public class ApartmentRooms extends ApartmentPricing {
    //Ocupied and Avail rooms
    int[] totalAvailableRooms = {20, 20, 20, 20};
    int[] occupiedRooms = {15, 10, 11, 8};

    public int getAvailableRooms() {
        int index = BarangayChoice - 1;
        return totalAvailableRooms[index] - occupiedRooms[index];
    }

    public void bookRoom() {
        int index = BarangayChoice - 1;

        if (occupiedRooms[index] < totalAvailableRooms[index]) {
            occupiedRooms[index]++;
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