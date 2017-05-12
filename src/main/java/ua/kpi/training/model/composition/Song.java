package ua.kpi.training.model.composition;

import ua.kpi.training.view.DefaultMessages;

/**
 * Created by Kirill on 02.05.2017.
 */
public class Song extends Composition {
    private String nameOfSong;
    private String artistName;
    private int yearOfWriting;
    private String[] lyrics;

    public Song(String nameOfSong, Style style, int duration, int size, String artistName, int yearOfWriting) {
        super(style, duration, size);
        this.nameOfSong = nameOfSong;
        this.artistName = artistName;
        this.yearOfWriting = yearOfWriting;
    }

    public String getNameOfSong() {
        return nameOfSong;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getYearOfWriting() {
        return yearOfWriting;
    }

    public String[] getLyrics() {
        return lyrics;
    }

    public void setLyrics(String[] lyrics) {
        this.lyrics = lyrics;
    }

    @Override
    public String atributeToSting() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName()).append(DefaultMessages.SPACE)
                .append(nameOfSong).append(DefaultMessages.SPACE)
                .append(getStyle()).append(DefaultMessages.SPACE)
                .append(getDuration()).append(DefaultMessages.SPACE)
                .append(getSize()).append(DefaultMessages.SPACE)
                .append(artistName).append(DefaultMessages.SPACE)
                .append(getYearOfWriting()).append(DefaultMessages.SPACE);
        return builder.toString();
    }

}
