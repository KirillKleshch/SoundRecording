package ua.kpi.training.view;

import ua.kpi.training.model.composition.Composition;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Kirill on 02.05.2017.
 */
public class View {
    public static final String MESSAGES_BUNDLE_NAME = "messages";
    public static ResourceBundle bundle =  ResourceBundle.getBundle(
            MESSAGES_BUNDLE_NAME,
            new Locale("en"));

    public static void printMessage(String messages) {
        StringBuilder builder = new StringBuilder();
        builder.append(getMessage(messages));
        System.out.println(builder.toString());
    }

    public static void printList(List<Composition> listOfComposition,String message){
        if(!listOfComposition.isEmpty()) {
            printMessage(message);
            listOfComposition.stream().map(Composition::atributeToSting).forEach(System.out::println);
            printMessage(DefaultMessages.LONG_DEFIS);
        }
        else{
            printMessage(DefaultMessages.LIST_IS_EMPTY);
        }
    }
    public static String getMessage(String message) {
        return bundle.getString(message);
    }

    public static void printException(String message){
        System.err.println(message);
    }

    public static void printListOfCompositionFromFile() throws IOException {
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader("Composition.txt"));
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void identifyBundle(String mesaage) {
        if (mesaage.equalsIgnoreCase(DefaultMessages.Ukrainian)) {
            bundle = ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("ua"));
        }
    }
}
