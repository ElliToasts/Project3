/* Programmed by Anthony Ellinos
   Assignment: Project 3
   Bicycle Class */

public class Bicycle extends Equipment implements Rentable {
    private int gearCount;
    public static final double BASE_RATE = 40.0;

    public Bicycle(String brand, int yearMade, int gearCount) {
        super(brand, yearMade);
        this.gearCount = gearCount;
    }

    @Override
    public double getDailyRate() {

        if (gearCount > 12) {
            return BASE_RATE * 1.1;
        }
        return BASE_RATE;
    }

    // gear count getter 
    public int getGearCount() {
        return gearCount;
    }

    // always returns false
    @Override
    public boolean requiresDeposit() {
        return false;
    }

    @Override
    public String toString() {
        // Uses parents toString and adds to it with its own methods
        return super.toString() + "\nType: Bicycle" + "\nGear Count: " + getGearCount()
                + "\nDaily Rate: $" + String.format("%.2f", getDailyRate()) + "\nRequires Deposit: "
                + requiresDeposit();
    }
}