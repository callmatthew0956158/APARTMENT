// Details
class ApartmentDetails extends ApartmentRooms {

    public ApartmentDetails() {
        super();
    }

    public String getBarangayName() {
        if (BarangayChoice == 1)
            return "Airport Sincang Apartment";
        else if (BarangayChoice == 2)
            return "Taculing Apartment";
        else if (BarangayChoice == 3)
            return "Burgos Apartment";
        else if (BarangayChoice == 4)
            return "Mandalagan Apartment";
        else
            return "Choose again";
    }

    public String getApartmentTypeName() {
        if (apartmentType == 1)
            return "Studio No-Bedroom Apartment";
        else if (apartmentType == 2)
            return "Studio 1-Bedroom Apartment";
        else if (apartmentType == 3)
            return "Studio 2-Bedrooms Apartment";
        else
            return "Choose again";
    }
}
