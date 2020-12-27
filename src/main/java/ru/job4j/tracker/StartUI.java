package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out){
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select:");
            if(select > actions.length || select < 0){
                out.println("Wrong number. Try again.");
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ValidateInput(out, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ShowAllAction(out),
                new EditAction(out),
                new DeleteAction(out),
                new FindById(out),
                new FindByName(out),
                new ExitAction()
        };
        new StartUI(out).init(input, tracker, actions);
    }
}
