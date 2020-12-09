package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    @Override
    public String askStr(String question) {
        if(!question.isEmpty()){
            System.out.println(question);
        }
        return new Scanner(System.in).nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }
}
