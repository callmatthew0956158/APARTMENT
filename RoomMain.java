// Main class
public class RoomMain {
    public static void main(String[] args) {

        ApartmentSummary booking = new ApartmentSummary();

        booking.displayAllBarangayRooms();
        booking.fillUpForm();
        booking.setPricesApart();
        booking.CostumerInfodisplay();
        booking.displaySummary();
    }
}