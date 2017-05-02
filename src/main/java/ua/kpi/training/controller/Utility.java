package ua.kpi.training.controller;

import ua.kpi.training.view.View;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Kirill on 03.05.2017.
 */
public class Utility {
    private Scanner scanner;
    private View view;

    public Utility(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    public int getInt(String regExp){
        int number = 0;
        String input;
        while(scanner.hasNextLine()) {
            input = scanner.nextLine();
            if (Pattern.matches(regExp, input)){
                number = Integer.parseInt(input);
                break;
            } else {
                //view.printError();
            }
        }
        return number;
    }
}
