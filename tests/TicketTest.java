import org.junit.*;
import static org.junit.Assert.*;
import java.util.Random;

public class TicketTest {

    String price = "";
    double preFormattedPrice = 0;
    @Before
    public void initialise() {
        Random rand = new Random();
        preFormattedPrice = rand.nextDouble()*100;
        Ticket ticket = new Ticket(preFormattedPrice);
        price = ticket.getPrice();
    }

    @Test
    public void checkPriceTwoDecimals() {
        char dec = price.charAt(price.length() - 3);
        assertTrue(dec == '.');
    }

    @Test
    public void checkDollarSign() {
        char dollar = price.charAt(0);
        assertTrue(dollar == '$');
    }

    @Test
    public void checkPricePositive() {
        assertTrue(preFormattedPrice > 0);
    }

}