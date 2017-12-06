import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EventTest {


    @Test
    public void testTicketNum() {
        Event event = new Event(1);
        List<Ticket> ticketList = event.getTickets();
        assertFalse(ticketList.size() < 0);
    }

    @Test
    public void testGetTickets() {
        Event event = new Event(1);
        Ticket ticket = new Ticket(5.00);
        Ticket ticket2 = new Ticket(2.54);
        event.addTickets(ticket);
        event.addTickets(ticket2);
        List<Ticket> testList = event.getTickets();
        assertTrue(testList.size() == 2);
    }

    @Test
    public void testAddTickets() {
        Event event = new Event(1);
        List <Ticket> tickets = event.getTickets();
        assertTrue(tickets.isEmpty());
        Ticket ticket = new Ticket(3.45);
        event.addTickets(ticket);
        assertFalse(tickets.isEmpty());
        assertTrue(tickets.size() == 1);
    }

    @Test
    public void testSetandGetDistance() {
        Event event = new Event(1);
        event.setDistance(5);
        assertTrue(event.getDistance() == 5);
    }

}