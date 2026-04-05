// Summary
class ApartmentSummary extends ApartmentDetails {

    double serviceFee = 500;
    double WifiBill = 1200;
    String electricityBill = "Depends on the bill";
    String waterBill = "Depends on the bill";

    public ApartmentSummary() {
        super();
    }

    public void displaySummary() {

        if (getAvailableRooms() == 0) {
            System.out.println("\nSorry Apartment is FULL.");
            return;
        }

        bookRoom();

        System.out.println("\n===== RENTAL SUMMARY =====");
        System.out.println("Barangay: " + getBarangayName());
        System.out.println("Apartment Type: " + getApartmentTypeName());
        System.out.println("People Staying: " + numberOfPeople);
        System.out.println("Available Rooms: " + getAvailableRooms());
        System.out.println("==============================");
        System.out.println("Monthly Rent per Room: Php " + rate);
        System.out.println("Rooms that tenant will rent: " + howManyRooms);

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

        double totalRent = months * rate * howManyRooms;
        double advancePayment = advanceMonths * rate * howManyRooms;
        double mandatoryAdvance = advance * howManyRooms;
        double totalDeposit = deposit * howManyRooms;
        double totalServiceFee = serviceFee;

        double Paynow;
        double remainingBalance;

        if (wantsAdvancePayment && advanceMonths >= months) {
            Paynow = totalRent + totalDeposit + totalServiceFee;
            remainingBalance = 0;

        } else if (wantsAdvancePayment && advanceMonths > 0) {
            Paynow = advancePayment + totalDeposit + totalServiceFee;
            remainingBalance = totalRent - advancePayment;

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
        System.out.println("Balance in rooms only: Php " + remainingBalance);
        System.out.println("Entire balance Remaining php " + ( Paynow - totalRent));
        }
    }
}
