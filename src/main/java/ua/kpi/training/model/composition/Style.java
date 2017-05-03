package ua.kpi.training.model.composition;

import ua.kpi.training.view.DefaultMessages;
import ua.kpi.training.view.View;


/**
 * Created by Kirill on 02.05.2017.
 */
public enum Style {
    KLASSIC(DefaultMessages.KLASSIC_DESCRIPTION),
    POP(DefaultMessages.POP_DESCRIPTION),
    ROK(DefaultMessages.ROK_DESCRIPTION),
    XIP_XOP(DefaultMessages.XIP_XOP_DESCRIPTION);

    private String description;

    Style(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
