package ua.kpi.training.model.composition;

import ua.kpi.training.view.DefaultMessages;

/**
 * Created by Kirill on 02.05.2017.
 */
abstract public class Composition {
    private int duration;
    private Style style;
    private int size;

    Composition(Style style, int duration, int size) {
        this.duration = duration;
        this.style = style;
        this.size = size;
    }

    public int getDuration() {
        return duration;
    }

    public Style getStyle() {
        return style;
    }

    public int getSize() {
        return size;
    }

    public String atributeToSting() {
        return null;
    }
}
