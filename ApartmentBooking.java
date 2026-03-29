import java.util.Scanner;
// Parent class
public class ApartmentBooking {
    String name;
    String ContactNum;
    int BarangayChoice;
    int apartmentType;
    int months;
    int numberOfPeople;
    boolean valid = false;
    int howManyRooms;
    int advanceMonths;
    boolean wantsAdvancePayment;

    Scanner input = new Scanner(System.in);

    public void fillUpForm() {

        System.out.println("=== Welcome to HarmonyHomes Apartment Renting Form ===");

        System.out.print("Enter Customer Full Name: ");
        name = input.nextLine();

        System.out.print("Enter Contact Number: ");
        ContactNum = input.nextLine();

        while (true) {
            System.out.println("\nChoose Barangay:");
            System.out.println("1. Airport Sincang Apartment");
            System.out.println("2. Taculing Apartment");
            System.out.println("3. Burgos Apartment");
            System.out.println("4. Mandalagan Apartment");
            System.out.print("Enter Choice (1-4): ");
            BarangayChoice = input.nextInt();

            if (BarangayChoice >= 1 && BarangayChoice <= 4)
                break;

            System.out.println("Invalid choice.");
        }

        while (true) {
            System.out.println("\nAvailable Apartment Types:");
            System.out.println("1. Studio No-Bedroom Apartment");
            System.out.println("2. Studio 1-Bedroom Apartment");
            System.out.println("3. Studio 2-Bedrooms Apartment");
            System.out.print("Enter Choice (1-3): ");
            apartmentType = input.nextInt();

            System.out.print("Enter Number of People Staying: ");
            numberOfPeople = input.nextInt();

            if ((apartmentType == 1 && numberOfPeople <= 2) ||
                (apartmentType == 2 && numberOfPeople <= 3) ||
                (apartmentType == 3 && numberOfPeople <= 5)) {
                valid = true;
            }
            if (valid) break;
            System.out.println("Too many people. Try again.");
        }
        System.out.print("How many rooms you want to rent?: ");
        howManyRooms = input.nextInt();

        System.out.print("Enter Number of Months to Stay: ");
        months = input.nextInt();

        input.nextLine();

        System.out.print("Do you want to pay advance months? (yes/no): ");
        String choiceAdvance = input.nextLine();

        if (choiceAdvance.equalsIgnoreCase("yes")) {
            wantsAdvancePayment = true;

        System.out.print("Enter number of months to advance: ");
        advanceMonths = input.nextInt();

        if (advanceMonths > months) {
            advanceMonths = months;
    }
        } else {
        wantsAdvancePayment = false;
        advanceMonths = 0;
    }
     }   
    public void CostumerInfodisplay() {
        System.out.println("\n=== CUSTOMER INFORMATION ===");
        System.out.println("Full Name: " + name);
        System.out.println("Contact Number: " + ContactNum);
    }
}