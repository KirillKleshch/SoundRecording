package ua.kpi.training.model;

import ua.kpi.training.controller.Controller;
import ua.kpi.training.model.composition.Composition;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kirill on 02.05.2017.
 */
public class Disk {
    private List<Composition> listOfComposition;

    private int maxSize;
    private static int minDuration;
    private static int maxDuration;

    Disk(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Composition> getListOfComposition() {
        return listOfComposition;
    }

    public void writeOnDisk(int number) {
        listOfComposition.add(new CreateComposition().createComposition(number));
    }

    public List<Composition> sortByStyle(List<Composition> listOfComposition) {
        Collections.sort(listOfComposition,
                (composition1, composition2) ->
                        composition1.getStyle()
                                .compareTo(composition2.getStyle()));
        return listOfComposition;
    }

    public List<Composition> selectedSongDesiredDuration(List<Composition> listOfComposition, int minDuration, int maxDuration) {
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        listOfComposition = listOfComposition.stream()
                .filter(Disk::moreMinDuration)
                .filter(Disk::lessMaxDuration)
                .sorted((composition1, composition2) ->
                        ((Integer) composition1.getDuration())
                                .compareTo((Integer) (composition2.getDuration())))
                .collect(Collectors.toList());
        return listOfComposition;
    }

    private static Boolean moreMinDuration(Composition composition) {
        return composition.getDuration() >= minDuration ? true : false;
    }

    private static Boolean lessMaxDuration(Composition composition) {
        return composition.getDuration() <= maxDuration ? true : false;
    }
}