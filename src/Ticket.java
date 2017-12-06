import java.text.DecimalFormat;

public class Ticket {


    public Ticket(double price) {
        if (price <= 0) {
            System.out.println("Please enter a price over $0");
        } else {
            setPrice(price);
        }
    }
    private String price;
    private double preFormattedPrice;

    public String getPrice() {
        return price;
    }

    /**
     * Turns the double price into a formatted string with a $ at the front and two decimal points
     * @param price
     */
    public void setPrice(double price) {
        preFormattedPrice = price;
        DecimalFormat df = new DecimalFormat(".##");
        String formattedPrice = df.format(price);
        formattedPrice = "$" + formattedPrice;
        this.price = formattedPrice;
    }

    public double getPreFormattedPrice() {
        return preFormattedPrice;
    }

}