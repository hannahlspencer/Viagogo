import java.util.*;

public class EventFinder {

    private List<MapCoordinates> map = new LinkedList<>(); //tree? hashmap?
    private List<Event> eventsInWorld = new ArrayList<Event>();
    //eventCount generates unique ID, starting at 1 as 0 signifies dummy event
    private int eventCount = 1;

    /**
     * Ensures the parameters being given are correct
     * @param  message
     * @return int coordinate being checked back to Main
     */

    public int checkInitialCoordinates(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        int coord = sc.nextInt();

        if (coord > 10 || coord < -10) {
            throw new IllegalArgumentException("Please enter a number between -10 and 10");
        }
        return coord;
    }

    /**
     * finds events with the checked coordinates
     * @param x
     * @param y
     * @return list of the five closest events to the coordinates
     */
    public List<Event> findEvents(int x, int y) {
        List<MapCoordinates> checkedCoords = new ArrayList<>();
        List<Event> closestEvents = new ArrayList<Event>();
        Map<Event, Integer> events = new HashMap<Event, Integer>();
        int distance = 0;
        Event event = new Event(0);
        x +=10;
        y += 10;
        for (MapCoordinates coords : map) {
            try {
                event = coords.getEvent();
                int xToCheck = coords.getXAxis();
                int yToCheck = coords.getYAxis();
                //normalise coords
                xToCheck += 10;
                yToCheck += 10;

                //calculation checks Manhattan distance
                distance = (Math.max(x, xToCheck) - Math.min(x, xToCheck)) + (Math.max(y, yToCheck) - Math.min(y, yToCheck));
                event.setDistance(distance);

                //making sure blank events are ignored
                if (event.getDistance() != 0 && event.getId() != 0) {
                    eventsInWorld.add(event);
                }
                //sorts events so closest are first
                eventsInWorld.sort(Comparator.comparing(Event::getDistance));
              } catch (NullPointerException e) {
                  System.out.println("No event has been found.");
              }
        }
        //skims the first five events from the sorted list
        for (int i = 0; i < 5; i++) {
            closestEvents.add(eventsInWorld.get(i));
        }
        print(closestEvents);
        return closestEvents;
    }

    /**
     * Prints the closest events, their price, and their distance to the console
     * @param events
     */

    public void print(List<Event> events) {
        for(Event event : events) {
            int eventId = event.getId();
            String lowestPrice = findLowestPrice(event.getTickets());
            int num = event.getDistance();
            System.out.println("Event " + eventId + " - " + lowestPrice + ", Distance " + num);
        }
    }

    /**
     * @param tickets
     * @return the minimum price for the tickets available for each event
     */
    public String findLowestPrice(List<Ticket> tickets) {
        double lowestPrice = Double.MAX_VALUE;
        String formattedLowestPrice = "";
        for (Ticket tick : tickets) {
            if (tick.getPreFormattedPrice() < lowestPrice) {
                lowestPrice = tick.getPreFormattedPrice();
                formattedLowestPrice = tick.getPrice();
            }
        }
        return formattedLowestPrice;
    }

    /**
     * Generates coordinate seed data for program
     */
    public void generateWorld() {
        for(int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                int xAxis = i - 10;
                int yAxis = j - 10;
                MapCoordinates coord = new MapCoordinates(xAxis, yAxis);
                map.add(coord);
                Random rand = new Random();
                int eventAdderChoice = rand.nextInt();
                if (eventAdderChoice % 14 == 0) {
                    generateEvents(coord);
                }

            }

        }

    }

    /**
     * Generates seed event data based on coordinates
     * @param coord
     */

    public void generateEvents(MapCoordinates coord) {
        Event event = new Event(eventCount);
        coord.setEvent(event);
        eventCount++;
        int ticketNum = (int) (Math.random() * 100);
        generateTickets(event, ticketNum);
    }

    /**
     * Generates ticket data based on events
     * @param event
     * @param ticketNum
     */

    public void generateTickets(Event event, int ticketNum) {
        Random rand = new Random();

        //adding random tickets
        for(int i = 0; i < ticketNum; i++) {
            Ticket ticket = new Ticket(rand.nextDouble()*100);
            event.addTickets(ticket);
        }


    }

    //getters for testing purposes
    public List<MapCoordinates> getMap() {
        return map;
    }
    public List<Event> getEventsInWorld() { return eventsInWorld; }

}