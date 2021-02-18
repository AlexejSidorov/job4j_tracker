package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        Output out = new StubOutput();
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        new CreateAction(out).execute(input, tracker);
        Item created = tracker.findAll().get(0);
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenAddEmptyNameItem() {
        Output out = new StubOutput();
        String[] answers = {""};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        new CreateAction(out).execute(input, tracker);
        Item created = tracker.findAll().get(0);
        Item expected = new Item("");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), /* id сохраненной заявки в объект tracker. */
                "replaced item"
        };
        new EditAction(out).execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("item");
        tracker.add(item);
        int idItem = item.getId();
        String[] answers = {String.valueOf(idItem)};
        new DeleteAction(out).execute(new StubInput(answers), tracker);
        Item nullItem = tracker.findById(idItem);
        assertNull(nullItem);
    }

    @Test
    public void whenCreateInitItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenEditInitItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String itemIdString = Integer.toString(item.getId());
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", itemIdString, replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteInitItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        String itemIdString = Integer.toString(item.getId());
        Input in = new StubInput(
                new String[]{"0", itemIdString, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAll() {
        Item firstItem = new Item("FirstItem");
        Item secondItem = new Item("SecondItem");
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(firstItem);
        tracker.add(secondItem);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Show All Items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "===Show All Items===" + System.lineSeparator()
                        + firstItem.toString() + System.lineSeparator()
                        + secondItem.toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Show All Items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Item item = new Item("FirstItem");
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(item);
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindById(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find By Id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "===Find By Id===" + System.lineSeparator()
                        + item.toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find By Id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Item item = new Item("FirstItem");
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(item);
        Input in = new StubInput(
                new String[]{"0", "FirstItem", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByName(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find By Name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "===Find By Name===" + System.lineSeparator()
                        + item.toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find By Name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"9", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong number. Try again.%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
}



