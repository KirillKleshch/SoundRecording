package ua.kpi.training.model.composition;

import ua.kpi.training.view.DefaultMessages;

/**
 * Created by Kirill on 02.05.2017.
 */
public class Dance extends Composition {
    private String danceName;
    private int numberOfPeopleWhoDanceIt;

    public Dance(String danceName, Style style, int duration, int numberOfPeopleWhoDanceIt, int size) {
        super(style, duration, size);
        this.danceName = danceName;
        this.numberOfPeopleWhoDanceIt = numberOfPeopleWhoDanceIt;
    }

    public String getDanceName() {
        return danceName;
    }

    public int getNumberOfPeopleWhoDanceIt() {
        return numberOfPeopleWhoDanceIt;
    }

    @Override
    public String atributeToSting() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName()).append(DefaultMessages.SPACE)
                .append(danceName).append(DefaultMessages.SPACE)
                .append(getStyle()).append(DefaultMessages.SPACE)
                .append(getDuration()).append(DefaultMessages.SPACE)
                .append(getNumberOfPeopleWhoDanceIt()).append(DefaultMessages.SPACE)
                .append(getSize()).append(DefaultMessages.SPACE);
        return builder.toString();
    }
}
