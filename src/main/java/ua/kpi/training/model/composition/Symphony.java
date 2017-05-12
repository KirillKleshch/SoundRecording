package ua.kpi.training.model.composition;

import ua.kpi.training.view.DefaultMessages;

/**
 * Created by Kirill on 02.05.2017.
 */
public class Symphony extends Composition {
    private String symphonyName;
    private String orchestraName;

    public Symphony(String symphonyName, String orchestraName, Style style, int duration, int size) {
        super(style, duration, size);
        this.orchestraName = orchestraName;
        this.symphonyName = symphonyName;
    }

    public String getSymphonyName() {
        return symphonyName;
    }

    public String getOrchestraName() {
        return orchestraName;
    }

    @Override
    public String atributeToSting() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName()).append(DefaultMessages.SPACE)
                .append(getSymphonyName()).append(DefaultMessages.SPACE)
                .append(getOrchestraName()).append(DefaultMessages.SPACE)
                .append(getStyle()).append(DefaultMessages.SPACE)
                .append(getDuration()).append(DefaultMessages.SPACE)
                .append(getSize()).append(DefaultMessages.SPACE);
        return builder.toString();
    }
}
