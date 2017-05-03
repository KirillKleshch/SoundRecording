package ua.kpi.training.model;

import ua.kpi.training.view.DefaultMessages;

/**
 * Created by Kirill on 03.05.2017.
 */
public enum KindMusicalComposition {
    SONG(DefaultMessages.SONG_DESCRIPTION),
    DANCE(DefaultMessages.DANCE_DESCRIPTION),
    CONCERT(DefaultMessages.CONCERT_DESCRIPTION),
    SYMPHONY(DefaultMessages.SYMPHONY_DESCRIPTION);

    private String description;

    KindMusicalComposition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
