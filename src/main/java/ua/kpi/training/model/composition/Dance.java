package ua.kpi.training.model.composition;

/**
 * Created by Kirill on 02.05.2017.
 */
public class Dance extends Composition {
    private String danceName;
    private int numberOfPeopleWhoDanceIt;

    Dance(String danceName, int numberOfPeopleWhoDanceIt, int duration, Style style, int size) {
        super(duration, style, size);
        this.danceName = danceName;
        this.numberOfPeopleWhoDanceIt = numberOfPeopleWhoDanceIt;
    }

    public String getDanceName() {
        return danceName;
    }

    public int getNumberOfPeopleWhoDanceIt() {
        return numberOfPeopleWhoDanceIt;
    }
}
