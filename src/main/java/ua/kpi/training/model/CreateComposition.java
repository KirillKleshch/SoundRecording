package ua.kpi.training.model;

import ua.kpi.training.controller.RegExp;
import ua.kpi.training.model.composition.*;
import ua.kpi.training.view.DefaultMessages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Kirill on 03.05.2017.
 */
public class CreateComposition {
    public Composition createComposition(int number) {
        String[] atribute = null;
        try {
            atribute = createAtributeOfComposition(number);
        } catch (IOException ioEx) {
            System.err.print(ioEx.getMessage());
        }
        return selectionParticularComposition(atribute);
    }

    private String[] deleteDot(String[] atribute) {
        atribute[0] = atribute[0].replace(DefaultMessages.DOT, DefaultMessages.EMPTY_STRING);
        return atribute;
    }

    private String[] createAtributeOfComposition(int number) throws IOException {
        BufferedReader reader = null;
        String line;
        String[] atribute = null;
        try {
            reader = new BufferedReader(new FileReader(DefaultMessages.FILE_NAME));
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
        while ((line = reader.readLine()) != null) {
            atribute = deleteDot(line.split(DefaultMessages.SPACE));
            if (Integer.parseInt(atribute[0]) == number) {
                break;
            }
        }
        return atribute;
    }

    private Composition selectionParticularComposition(String[] atribute) {
        Composition composition = null;
        if (atribute[1].equals(KindMusicalComposition.SONG.getDescription())) {
            composition = new Song(
                    atribute[2], defineStyle(atribute[3]),
                    Integer.parseInt(atribute[4]),
                    Integer.parseInt(atribute[5]),
                    atribute[6], Integer.parseInt(atribute[7]));
        } else if (atribute[1].equals(KindMusicalComposition.DANCE.getDescription())) {
            composition = new Dance(
                    atribute[2], defineStyle(atribute[3]),
                    Integer.parseInt(atribute[4]),
                    Integer.parseInt(atribute[5]),
                    Integer.parseInt(atribute[6]));
        } else if (atribute[1].equals(KindMusicalComposition.CONCERT.getDescription())) {
            composition = new Concert(
                    atribute[2], atribute[3],
                    Concert.createDate(createDateFromAtribute(atribute[4])),
                    defineStyle(atribute[5]),
                    Integer.parseInt(atribute[6]),
                    Integer.parseInt(atribute[7]));
        } else if (atribute[1].equals(KindMusicalComposition.SYMPHONY.getDescription())) {
            composition = new Symphony(
                    atribute[2], atribute[3],
                    defineStyle(atribute[4]),
                    Integer.parseInt(atribute[5]),
                    Integer.parseInt(atribute[6]));
        }
        return composition;
    }

    private Style defineStyle(String styleName) {
        Style style = null;
        if (styleName.equals(Style.KLASSIC.getDescription())) {
            style = Style.KLASSIC;
        } else if (styleName.equals(Style.POP.getDescription())) {
            style = Style.POP;
        } else if (styleName.equals(Style.ROK.getDescription())) {
            style = Style.ROK;
        } else if (styleName.equals(Style.XIP_XOP.getDescription())) {
            style = Style.XIP_XOP;
        }

        return style;
    }

    private Integer[] createDateFromAtribute(String atribute) {
        String[] stringDate = atribute.split(RegExp.BREAK_DATE_BY_DOT);
        Integer[] date = new Integer[stringDate.length];
        for (int i = 0; i < stringDate.length; i++) {
            date[i] = Integer.parseInt(stringDate[i]);
        }
        return date;
    }
}
