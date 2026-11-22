/* Programmed by Anthony Ellinos
   Assignment: Project 3
   Tent Class */

public class Tent extends Equipment implements Rentable {
    private int capacity;
    public static final double BASE_RATE = 32.0;

    public Tent(String brand, int yearMade, int capacity) {
        super(brand, yearMade);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public double getDailyRate() {
        // 125% for tents that hold 6 or more people
        if (capacity >= 6) {
            return BASE_RATE * 1.25;
        }
        return BASE_RATE;
    }

    // always true
    @Override
    public boolean requiresDeposit() {
        return true;
    }

    @Override
    public String toString() {
        // Uses parents toString and adds to it with its own methods
        return super.toString() + "\nType: Tent" + "\nCapacity: " + getCapacity() + "\nDaily Rate: $"
                + String.format("%.2f", getDailyRate()) + "\nRequires Deposit: " + requiresDeposit();
    }
}
