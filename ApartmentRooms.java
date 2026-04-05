// Rooms
class ApartmentRooms extends ApartmentPricing {

    protected int[] totalAvailableRooms = {20, 20, 20, 20};
    protected int[] occupiedRooms = {15, 10, 11, 8};

    public ApartmentRooms() {
        super();
    }

    public int getAvailableRooms() {
        int index = BarangayChoice - 1;
        return totalAvailableRooms[index] - occupiedRooms[index];
    }

    public void bookRoom() {
    int index = BarangayChoice - 1;
    int availableRooms = totalAvailableRooms[index] - occupiedRooms[index];

    // requested rooms exceed available
    if (howManyRooms > availableRooms) {
        System.out.println("\nERROR: Not enough available rooms!");
        System.out.println("Available rooms: " + availableRooms);
        System.out.println("You requested: " + howManyRooms);
        System.out.println("Please try again.\n");
        return;
    }

    // valid, book rooms
    for (int i = 0; i < howManyRooms; i++) {
        if (occupiedRooms[index] < totalAvailableRooms[index]) {
            occupiedRooms[index]++;
        }
    }
}

    public void displayAllBarangayRooms() {
        System.out.println("\n=== AVAILABLE ROOMS PER BARANGAY ===");

        System.out.println("Airport Sincang Apartment: " + (totalAvailableRooms[0] - occupiedRooms[0]));
        System.out.println("Taculing Apartment: " + (totalAvailableRooms[1] - occupiedRooms[1]));
        System.out.println("Burgos Apartment: " + (totalAvailableRooms[2] - occupiedRooms[2]));
        System.out.println("Mandalagan Apartment: " + (totalAvailableRooms[3] - occupiedRooms[3]));
    }
}
