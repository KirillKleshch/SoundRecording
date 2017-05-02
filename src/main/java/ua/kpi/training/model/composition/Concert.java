package ua.kpi.training.model.composition;

import java.util.Date;

/**
 * Created by Kirill on 02.05.2017.
 */
public class Concert extends Composition {
    private Date dateConcert;
    private String musicBandName;

    Concert(int duration, Style style, int size, Date dateConcert, String musicBandName) {
        super(duration, style, size);
        this.dateConcert = dateConcert;
        this.musicBandName = musicBandName;
    }

    public Date getDateConcert() {
        return dateConcert;
    }

    public String getMusicBandName() {
        return musicBandName;
    }


}
