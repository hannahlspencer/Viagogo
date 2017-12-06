public class MapCoordinates {

    public MapCoordinates(int x, int y) {
        setXAxis(x);
        setYAxis(y);
    }
    private int x;
    private int y;
    //dummy event to prevent exceptions when searching
    private Event event = new Event(0);


    /**
     * Ensures the x axis is within bounds of the world
     * @param x
     */
    public void setXAxis(int x) {
        if (x > 10 || x < -10) {
            throw new IllegalArgumentException("Please enter coordinates between 10 and -10");
        } else {
            this.x = x;
        }
    }

    /**
     * Ensures y axis is within bounds of the world
     * @param y
     */
    public void setYAxis(int y) {
        if (y > 10 || y < -10) {
            throw new IllegalArgumentException("Please enter coordinates between 10 and -10");
        } else {
            this.y = y;
        }
    }

    public int getXAxis() {
        return x;
    }
    public int getYAxis() {
        return y;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    public Event getEvent() {
      return event;
    }
}