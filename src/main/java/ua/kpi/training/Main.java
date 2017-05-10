package ua.kpi.training;

import ua.kpi.training.controller.Controller;
import ua.kpi.training.model.Model;
import ua.kpi.training.view.View;

/**
 * Created by Kirill on 02.05.2017.
 */
public class Main {
    public static void main(String[] args) {

        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();
    }
}