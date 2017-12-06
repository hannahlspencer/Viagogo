import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

public static List<Event> events = new ArrayList<Event>();
    public static void main(String[] args) {
        EventFinder ef = new EventFinder();
        ef.generateWorld();
        Scanner sc = new Scanner(System.in);
        String xAxisPrompt = "Please enter your x axis: ";
        String yAxisPrompt = "Please enter your y axis: ";
        int x = 0;
        int y = 0;
       System.out.println("So you're looking for events near you! Please enter your coordinates to find the closest five.");
       try {
           x = ef.checkInitialCoordinates(xAxisPrompt);
           y = ef.checkInitialCoordinates(yAxisPrompt);
       } catch (IllegalArgumentException e) {
           System.out.println("Please enter a number between -10 and 10");
           x = ef.checkInitialCoordinates(xAxisPrompt);
           y = ef.checkInitialCoordinates(yAxisPrompt);
       }

       ef.findEvents(x, y);
    }
}
