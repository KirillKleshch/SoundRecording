package ua.kpi.training.model.composition;

/**
 * Created by Kirill on 02.05.2017.
 */
abstract public class Composition {
    private int duration;
    private Style style;
    private int size;

    Composition(int duration, Style style, int size) {
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
}
