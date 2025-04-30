import java.util.*;

public class ShelterManager {
    static Hashtable<String, Shelter> shelters = new Hashtable<String, Shelter>();

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Title
        System.out.println("Welcome to the Shelter Management System");
        System.out.println("-------------------------------------------------------");

        while (true) {
            System.out.println("\n1. Add Shelter\n2. Update Beds\n3. Search Shelter\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = keyboard.nextInt();
            keyboard.nextLine();
            switch (choice) {
                case 1:
                    addShelter(keyboard);
                    break;
                case 2:
                    updateBeds(keyboard);
                    break;
                case 3:
                    searchShelter(keyboard);
                    break;
                case 4:
                    System.out.println("Fare Thee Well");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }

    }

    static void addShelter(Scanner keyboard) {
        System.out.print("Enter Shelter Name: ");
        String name = keyboard.nextLine();

        System.out.print("Enter Shelter Location: ");
        String loc = keyboard.nextLine();

        System.out.print("Contact Info: ");
        String contact = keyboard.next();

        System.out.print("Capacity: ");
        int cap = keyboard.nextInt();
        keyboard.nextLine();

        System.out.print("Available Beds: ");
        int beds = keyboard.nextInt();
        keyboard.nextLine();

        shelters.put(name, new Shelter(name, loc, cap, beds, contact));
        System.out.println("Shelter added/updated.");
    }

    static void updateBeds(Scanner keyboard) {
        System.out.print("Enter Shelter Name: ");
        String name = keyboard.nextLine();

        System.out.print("New available beds: ");
        int beds = keyboard.nextInt();
        keyboard.nextLine();

        Shelter newS = shelters.get(name);
        if (newS != null) {
            newS.setBeds(beds);
            System.out.println("Beds updated.");
        } else {
            System.out.println("Shelter not found.");
        }
    }

    static void searchShelter(Scanner keyboard) {
        System.out.print("Enter Shelter Name: ");
        String name = keyboard.nextLine();

        Shelter newS = shelters.get(name);
        System.out.println(newS != null ? newS : "Shelter not found.");
    }
}