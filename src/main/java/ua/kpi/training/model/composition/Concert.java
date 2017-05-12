package ua.kpi.training.model.composition;

import ua.kpi.training.view.DefaultMessages;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Kirill on 02.05.2017.
 */
public class Concert extends Composition {
    private GregorianCalendar dateConcert;
    private String city;
    private String musicBandName;

    public Concert(String musicBandName, String city, GregorianCalendar dateConcert, Style style, int duration, int size) {
        super(style, duration, size);
        this.dateConcert = dateConcert;
        this.city = city;
        this.musicBandName = musicBandName;
    }

    public GregorianCalendar getDateConcert() {
        return dateConcert;
    }

    public String getMusicBandName() {
        return musicBandName;
    }

    public static GregorianCalendar createDate(Integer[] data) {
        return new GregorianCalendar(data[2], data[1], data[0]);
    }

    @Override
    public String atributeToSting() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName()).append(DefaultMessages.SPACE)
                .append(getMusicBandName()).append(DefaultMessages.SPACE)
                .append(city).append(DefaultMessages.SPACE)
                .append(dateConcert.get(Calendar.DAY_OF_MONTH)).append(DefaultMessages.DOT)
                .append(dateConcert.get(Calendar.MONTH)).append(DefaultMessages.DOT)
                .append(dateConcert.get(Calendar.YEAR)).append(DefaultMessages.SPACE)
                .append(getStyle()).append(DefaultMessages.SPACE)
                .append(getDuration()).append(DefaultMessages.SPACE)
                .append(getSize()).append(DefaultMessages.SPACE);
        return builder.toString();
    }

}
