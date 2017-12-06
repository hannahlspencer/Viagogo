import org.junit.*;

import static junit.framework.TestCase.assertTrue;

public class MapCoordinatesTest {
    @Test
    public void testDummyEvent() {
        MapCoordinates map = new MapCoordinates(5,5);
        assertTrue(map.getEvent().getId() == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSettingXAxis() throws Exception {
        MapCoordinates map = new MapCoordinates(-20, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSettingYAxis() throws Exception {
        MapCoordinates map = new MapCoordinates(5, 15);
    }

    @Test
    public void testSetandGetEvent() {
        MapCoordinates map = new MapCoordinates(-5, 5);
        Event event = new Event(5);
        map.setEvent(event);
        assertTrue(map.getEvent().getId() == 5);
    }
}
