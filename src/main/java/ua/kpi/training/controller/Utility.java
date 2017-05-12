package ua.kpi.training.controller;

import ua.kpi.training.view.DefaultMessages;
import ua.kpi.training.view.View;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Kirill on 03.05.2017.
 */
public class Utility {
    private Scanner scanner;

    public Utility(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getInt(String regExp) {
        int number = 0;
        String input;
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            if (Pattern.matches(regExp, input)) {
                number = Integer.parseInt(input);
                break;
            } else {
                View.printMessage(DefaultMessages.ERROR);
            }
        }
        return number;
    }

    public String getString(String regExp) {
        String input = "";
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            if (Pattern.matches(regExp, input)) {
                break;
            } else {
                View.printMessage(DefaultMessages.ERROR);
            }
        }
        return input;
    }
}
