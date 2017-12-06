import java.util.List;
import java.util.ArrayList;

public class Event {


    public Event(int id) {
        this.id = id;
    }
    private int id;
    private int distance;
    private List<Ticket> tickets = new ArrayList<Ticket>();

    public int getId() { return id; }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTickets(Ticket ticket) {
        tickets.add(ticket);
    }

    public void setDistance(int distance) { this.distance = distance; };

    public int getDistance() {return distance; };




}