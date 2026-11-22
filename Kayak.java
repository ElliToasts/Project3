/* Programmed by Anthony Ellinos
   Assignment: Project 3
   Kayak Class */

public class Kayak extends Equipment implements Rentable {

    private String kayakType;
    public static final double BASE_RATE = 60.0;

    public Kayak(String brand, int yearMade, String kayakType) {
        super(brand, yearMade);
        this.kayakType = kayakType;
    }

    public String getKayakType() {
        return kayakType;
    }

    @Override
    public double getDailyRate() {
        // returns 85% for rec, 100% for touring, and 115% for tandem
        // IgnoreCase allows the user to type in any version
        // as long as the word is spelled correctly
        if (kayakType.equalsIgnoreCase("recreational")) {
            return BASE_RATE * 0.85;
        } else if (kayakType.equalsIgnoreCase("touring")) {
            return BASE_RATE;
        } else if (kayakType.equalsIgnoreCase("tandem")) {
            return BASE_RATE * 1.15;
        }
        return BASE_RATE; // never reached but needed
    }

    // always true
    @Override
    public boolean requiresDeposit() {
        return true;
    }

    @Override
    public String toString() {
        // Uses parents toString and adds to it with its own methods
        return super.toString() + "\nType: Kayak" + "\nKayak Type: " + getKayakType()
                + "\nDaily Rate: $" + String.format("%.2f", getDailyRate()) + "\nRequires Deposit: "
                + requiresDeposit();
    }
}
