package ua.kpi.training.model.composition;

/**
 * Created by Kirill on 02.05.2017.
 */
public class Song extends Composition {
    private String nameOfSong;
    private String artistName;
    private int yearOfWriting;
    private String[] lyrics;

    Song(String nameOfSong,int duration, Style style, int size, String artistName, int yearOfWriting) {
        super(duration, style, size);
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

}
