/* Programmed by Anthony Ellinos
   Assignment: Project 3
   Equipment Class */

public abstract class Equipment {
    private String brand;
    private int yearMade;

    // gets called in each subclass thru super(brand, yearMade)
    public Equipment(String brand, int yearMade) {
        this.brand = brand;
        this.yearMade = yearMade;
    }

    public String getBrand() {
        return brand;
    }

    public int getYearMade() {
        return yearMade;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + "\nYear Made: " + yearMade;
    }

    // forces subclasses to implement this method
    public abstract double getDailyRate();
}
