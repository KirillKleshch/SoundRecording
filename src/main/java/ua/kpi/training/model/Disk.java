package ua.kpi.training.model;

import ua.kpi.training.model.composition.Composition;

import java.util.ArrayList;
import java.util.List;

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
        listOfComposition = new ArrayList<>();
    }

    static Boolean moreMinDuration(Composition composition) {
        return composition.getDuration() >= minDuration ? true : false;
    }

    static Boolean lessMaxDuration(Composition composition) {
        return composition.getDuration() <= maxDuration ? true : false;
    }

    public void setMinDuration(int minDuration) {
        this.minDuration = minDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getMinDuration() {
        return minDuration;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public List<Composition> getListOfComposition() {
        return listOfComposition;
    }
}