
import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static junit.framework.TestCase.assertTrue;


public class EventFinderTest {

    @Test
    public void testReturnFiveEvents() {
        EventFinder ef = new EventFinder();
        ef.generateWorld();
        List<Event> events = ef.findEvents(5, 5);
        assertTrue(events.size() == 5);
    }

    @Test
    public void testCheapestPrice() {
        EventFinder ef = new EventFinder();
        List<String> price = new ArrayList<>();
        ef.generateWorld();
        List<Event> events = ef.getEventsInWorld();
        for (Event event : events) {
            List<Ticket> tickets = event.getTickets();
            for (Ticket ticket: tickets) {
              price.add(ticket.getPrice());
            }
            int minIndex = price.indexOf(Collections.min(price));
            assertTrue(price.get(minIndex).equals(ef.findLowestPrice(tickets)));
        }
    }
}