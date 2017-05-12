package ua.kpi.training.controller;

import ua.kpi.training.model.LowDiskStorageException;
import ua.kpi.training.model.Model;
import ua.kpi.training.view.DefaultMessages;
import ua.kpi.training.view.View;

import java.io.IOException;
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
        Scanner scanner = new Scanner(System.in);
        getLocaleBundle(scanner);
        soundRecording(scanner);
        View.printList(model.getList(), DefaultMessages.ALL_COMPOSITION);
        View.printList(
                model.selectedSongDesiredDuration(
                        model.getList(),
                        swapDuration(scanner)),
                DefaultMessages.SORTED_BY_DURATION);
        View.printList(
                model.sortByStyle(
                        model.getList()),
                DefaultMessages.SORTED_BY_STYLS);

    }

    public int getNumberFromUser(Scanner scanner) {
        return new Utility(scanner).getInt(RegExp.NUMBER_OF_COMPOSITION);
    }

    private void getLocaleBundle(Scanner scanner) {
        View.printMessage(DefaultMessages.LANGUAGE_SELECTION_EN);
        View.printMessage(DefaultMessages.LANGUAGE_SELECTION_UKR);
        View.identifyBundle(new Utility(scanner).getString(RegExp.IDENTIFY_BUMDLE));
    }

    private void printCompositionFromFile() {
        try {
            View.printListOfCompositionFromFile();
        } catch (IOException ex) {
        }
        ;
    }

    private void soundRecording(Scanner scanner) {
        View.printMessage(DefaultMessages.WRITE_PERMISSION);
        while ((scanner.nextLine()).equalsIgnoreCase(View.getMessage(DefaultMessages.COMPLIANCE))) {
            View.printMessage(DefaultMessages.SELECTION_FROM_LIST);
            printCompositionFromFile();
            try {
                model.writeOnDisk(getNumberFromUser(scanner));
            }catch(LowDiskStorageException ex){
                View.printException(View.getMessage(ex.getMessage()));
            }
            View.printMessage(DefaultMessages.WRITE_PERMISSION);
        }
    }

    private int getMinDurationFromUser(Scanner scanner) {
        View.printMessage(DefaultMessages.MIN_DURATION);
        return new Utility(scanner).getInt(RegExp.DURATION);
    }

    private int getMaxDurationFromUser(Scanner scanner) {
        View.printMessage(DefaultMessages.MAX_DURATION);
        return new Utility(scanner).getInt(RegExp.DURATION);
    }

    private Integer[] swapDuration(Scanner scanner) {
        int minDuration = getMinDurationFromUser(scanner);
        int maxDuration = getMaxDurationFromUser(scanner);
        Integer[] duration = new Integer[2];
        duration[0] = minDuration;
        duration[1] = maxDuration;
        swap(duration);
        return duration;
    }

    private Integer[] swap(Integer[] duration) {
        if (duration[0] > duration[1]) {
            int temp = duration[0];
            duration[0] = duration[1];
            duration[1] = temp;
        }
        return duration;
    }
}
