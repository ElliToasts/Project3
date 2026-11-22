/* Programmed by Anthony Ellinos
   Assignment: Project 3
   Equipment Driver */

import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentDriver {
    // static scanner so every method can use the same one instead of making
    // separate instances
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        // holds every Bicycle, Kayak, and Tent, since they are all Equipment objects
        ArrayList<Equipment> equipmentList = new ArrayList<>();
        int choice = 0;

        // keep showing the menu until the user picks 5
        while (choice != 5) {
            displayMenu();
            choice = getMenuChoice();

            // each option uses a different private method
            if (choice == 1) {
                equipmentList.add(getBicycle());
            } else if (choice == 2) {
                equipmentList.add(getKayak());
            } else if (choice == 3) {
                equipmentList.add(getTent());
            } else if (choice == 4) {
                showEquipmentLog(equipmentList);
            }

        }
        scanner.close();
    }

    // prints the menu options
    private static void displayMenu() {
        System.out.println("Select a type of equipment to record:\n");
        System.out.println("1. Bicycle\n2. Kayak\n3. Tent"
                + "\n4. Display Equipment\n5. Exit");
    }

    // reads a menu choice and keeps asking until they give an int from 1 to 5
    private static int getMenuChoice() {
        int choice = 0;
        boolean validInput = false; // becomes true once we get a good choice

        while (!validInput) {
            // only read the number if its an integer
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 5) {
                    validInput = true;
                }
            }
            // throw away whats left over (enter)
            scanner.nextLine();

            if (!validInput) {
                System.out.println("Please enter a number between 1 and 5.");
            }
        }
        return choice;
    }

    // asks for a bicycle's brand, year, and gear count, then creates a new Bicycle
    private static Bicycle getBicycle() {
        System.out.println("------------------------------");
        String brand = getBrand();
        int year = getYear();

        int gears = 0;
        boolean validInput = false; // becomes true once we get a good gear count

        // keep asking until the user enters an integer between 1 and 24
        while (!validInput) {
            System.out.println("Enter the number of gears:");

            if (scanner.hasNextInt()) {
                gears = scanner.nextInt();
                if (gears >= 1 && gears <= 24) {
                    validInput = true;
                }
            }
            // throw away whats left over (enter)
            scanner.nextLine();

            if (!validInput) {
                System.out.println("Gear count must be between 1 and 24.");
            }
        }
        // returning the new bicycle object
        return new Bicycle(brand, year, gears);
    }

    // asks for a kayak's brand, year, and type, then creates a new Kayak
    private static Kayak getKayak() {
        System.out.println("------------------------------");
        String brand = getBrand();
        int year = getYear();

        System.out.println("Enter the kayak type (recreational, touring, tandem):");
        // trim spaces and store in lowercase so it displays like the sample
        String type = scanner.nextLine().trim().toLowerCase();

        // keep asking until the type is one of the three valid options
        // while the type doesn't equal one of the options, keep asking 
        // for the user to enter a type
        while (!type.equals("recreational") && !type.equals("touring") && !type.equals("tandem")) {
            System.out.println("Kayak type must be recreational, touring, or tandem.");
            System.out.println("Enter the kayak type (recreational, touring, tandem):");
            type = scanner.nextLine().trim().toLowerCase();
        }
        return new Kayak(brand, year, type);
    }

    // asks for a tent's brand, year, and capacity, then creates the Tent
    private static Tent getTent() {
        System.out.println("------------------------------");
        String brand = getBrand();
        int year = getYear();

        int capacity = 0;
        boolean validInput = false; // becomes true once we get a good capacity

        // keep asking until the user enters an integer between 1 and 12
        while (!validInput) {
            System.out.println("Enter the tent capacity (number of people):");

            if (scanner.hasNextInt()) {
                capacity = scanner.nextInt();
                if (capacity >= 1 && capacity <= 12) {
                    validInput = true;
                }
            }
            // throw away whats left over (enter)
            scanner.nextLine();

            if (!validInput) {
                System.out.println("Capacity must be between 1 and 12.");
            }
        }
        return new Tent(brand, year, capacity);
    }

    // asks for a brand until the user enters at least one non-space character
    private static String getBrand() {
        System.out.println("Enter the brand of the equipment:");

        String input = scanner.nextLine().trim();

        while (input.isEmpty()) {
            System.out.println("You must enter a brand for the equipment.");
            System.out.println("Enter the brand of the equipment:");
            input = scanner.nextLine().trim();
        }
        return input;
    }

    // asks for a year until the user enters a whole number between 1900 and 2026
    private static int getYear() {
        int year = 0;
        boolean validInput = false; // becomes true once we get a good year

        while (!validInput) {
            System.out.println("Enter the year it was made:");

            // only read the number if it's actually a whole number (no letters or decimals)
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year >= 1900 && year <= 2026) {
                    validInput = true;
                }
            }
            // throw away whats left over (enter)
            scanner.nextLine();

            if (!validInput) {
                System.out.println("Year must be between 1900 and 2026.");
            }
        }
        return year;
    }

    // prints every piece of equipment recorded so far
    private static void showEquipmentLog(ArrayList<Equipment> list) {
        System.out.println("--------------------");
        System.out.println("Show Equipment Log");
        System.out.println("--------------------");

        if (list.isEmpty()) {
            System.out.println("No equipment recorded.");
        } else {
            // print e for each equipment object e in list
            for (Equipment e : list) {
                System.out.println(e);
                System.out.println(); // space between each entry
            }
        }
        System.out.println("--------------------");
    }
}
