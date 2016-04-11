package Chapter01;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import static org.hamcrest.core.Is.*;

public class CustomerTest {

    private static final Movie BLANCANIEVES = new Movie("Las crónicas de Blancanieves", Movie.CHILDREN);
    private static final Movie KIKI = new Movie("KIKI, el amor se hace", Movie.NEW_RELEASE);
    private static final Movie KUNG_FU = new Movie("Kung Fu Panda 3", Movie.REGULAR);

    private final Customer customer = new Customer("fred");

    @Test
    public void basicChildrenRental() {
        customer.addRental(new Rental(BLANCANIEVES, 2));
        assertThat(customer.statement(), is(expectedMessageFor("Las crónicas de Blancanieves", 1.5, 1.5, 1)));
    }

    @Test
    public void shouldDiscountChildrensRentals() {
        customer.addRental(new Rental(BLANCANIEVES, 4));
        assertThat(customer.statement(), is(expectedMessageFor("Las crónicas de Blancanieves", 3.0, 3.0, 1)));
    }

    @Test
    public void basicNewReleaseRental() {
        customer.addRental(new Rental(KIKI, 1));
        assertThat(customer.statement(), is(expectedMessageFor("KIKI, el amor se hace", 3.0, 3.0, 1)));
    }

    @Test
    public void shouldNotDiscountNewReleaseRentalsButBonusFrequentRenterPoints() {
        customer.addRental(new Rental(KIKI, 4));
        assertThat(customer.statement(), is(expectedMessageFor("KIKI, el amor se hace", 12.0, 12.0, 2)));
    }

    @Test
    public void basicRegularRental() {
        customer.addRental(new Rental(KUNG_FU, 2));
        assertThat(customer.statement(), is(expectedMessageFor("Kung Fu Panda 3", 2.0, 2.0, 1)));
    }

    @Test
    public void shouldDiscountRegularRental() {
        customer.addRental(new Rental(KUNG_FU, 4));
        assertThat(customer.statement(), is(expectedMessageFor("Kung Fu Panda 3", 5.0, 5.0, 1)));
    }


    private static String expectedMessageFor(String rental, double price, double total, int renterPointsEarned) {
        return "Rental Record for fred\n\t" + rental + "\t" + price + "\nAmount owed is " + total + "\nYou earned " + renterPointsEarned + " frequent renter points";
    }

}
