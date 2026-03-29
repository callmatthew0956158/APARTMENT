public class ApartmentSummary extends ApartmentDetails {

    double serviceFee = 500;
    double WifiBill = 1200;
    String electricityBill = "Depends on the bill";
    String waterBill = "Depends on the bill";

    public void displaySummary() {

        if (getAvailableRooms() == 0) {
            System.out.println("\nSorry Apartment is FULL.");
            return;
        }
        // Book room
        bookRoom();
        System.out.println("\n===== RENTAL SUMMARY =====");
        System.out.println("Barangay: " + getBarangayName());
        System.out.println("Apartment Type: " + getApartmentTypeName());
        System.out.println("People Staying: " + numberOfPeople);
        System.out.println("Available Rooms: " + getAvailableRooms());
        System.out.println("==============================");
        System.out.println("Monthly Rent per Room: Php " + rate);
        System.out.println("Rooms that tenant will rent: " + howManyRooms);

        // Display months info
        if (wantsAdvancePayment && advanceMonths >= months) {
            System.out.println("Paid: " + months + " months (FULLY PAID)");
        } else {
            System.out.println("Months to Stay: " + months);
            if (wantsAdvancePayment && advanceMonths > 0) {
                System.out.println("Advance Months Paid: " + advanceMonths);
            }
        }

        System.out.println("\n--- Payment Breakdown ---");
        System.out.println("Base Rent (" + months + " months): Php " + (months * rate * howManyRooms));
        if (wantsAdvancePayment && advanceMonths > 0) {
            System.out.println("Advance Months Payment (" + advanceMonths + "): Php " + (advanceMonths * rate * howManyRooms));
        }
        System.out.println("1 Month Advance: Php " + (advance * howManyRooms));
        System.out.println("Deposit: Php " + (deposit * howManyRooms));
        System.out.println("Service Fee: Php " + serviceFee);
        System.out.println("--------------------------------");

        System.out.println("\n=== UTILITIES ===");
        System.out.println("Electricity Bill: " + electricityBill);
        System.out.println("Water Bill: " + waterBill);
        System.out.println("Fix WiFi Bill: Php " + WifiBill);
        System.out.println("==============================");

        //TOTAL CALCULATIONS
        double totalRent = months * rate * howManyRooms;          // Rent for all rooms
        double advancePayment = advanceMonths * rate * howManyRooms;  // Advance months payment
        double mandatoryAdvance = advance * howManyRooms;        // 1 month mandatory advance
        double totalDeposit = deposit * howManyRooms;            // Deposit for all rooms
        double totalServiceFee = serviceFee;                     // service fee
        double Paynow;
        double remainingBalance;

        // FULL advance payment
        if (wantsAdvancePayment && advanceMonths >= months) {
            Paynow = totalRent + totalDeposit + totalServiceFee;
            remainingBalance = 0;

        // PARTIAL advance payment
        } else if (wantsAdvancePayment && advanceMonths > 0) {
            Paynow = advancePayment + totalDeposit + totalServiceFee;
            remainingBalance = totalRent - advancePayment;

        // NO advance
        } else {
            Paynow = mandatoryAdvance + totalDeposit + totalServiceFee;
            remainingBalance = totalRent;
        }

        System.out.println("===Total===");
        System.out.println("Total Rent for all rooms: Php " + totalRent);
        System.out.println("Total Payment (Pay Now): Php " + Paynow);

        if (remainingBalance == 0) {
            System.out.println("Remaining Balance: FULLY PAID");
        } else {
            System.out.println("Remaining Balance: Php " + (remainingBalance - Paynow));
        }
    }
}