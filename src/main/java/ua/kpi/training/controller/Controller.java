package ua.kpi.training.controller;

import ua.kpi.training.model.Model;
import ua.kpi.training.view.View;

import java.util.Scanner;

/**
 * Created by Kirill on 03.05.2017.
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {

    }

    public int getNumberFromUser(){
        Scanner scanner = new Scanner(System.in);
        return  new Utility(scanner,view).getInt(RegExp.NUMBER_OF_COMPOSITION);
    }
}
