package ua.kpi.training.model.composition;

/**
 * Created by Kirill on 02.05.2017.
 */
public class Symphony extends Composition {
    private String symphonyName;
    private String orchestraName;

    Symphony(String symphonyName, String orchestraName, int duration, Style style, int size) {
        super(duration, style, size);
        this.orchestraName = orchestraName;
        this.symphonyName = symphonyName;
    }

    public String getSymphonyName() {
        return symphonyName;
    }
    public String getOrchestraName() {
        return orchestraName;           
}   }
