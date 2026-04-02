// Pricing
class ApartmentPricing extends ApartmentBooking {

    protected double rate;
    protected double Monthspay;
    protected double advance;
    protected double deposit;

    public ApartmentPricing() {
        super();
    }

    public void setPricesApart() {
        if (apartmentType == 1) 
            rate = 5000;
        else if (apartmentType == 2) 
            rate = 6500;
        else if (apartmentType == 3) 
            rate = 8500;

        Monthspay = months * rate;

        if (wantsAdvancePayment && advanceMonths < months) {
            Monthspay += advanceMonths * rate;
        }

        if (wantsAdvancePayment && advanceMonths >= months) {
            advance = 0;
        } else {
            advance = rate;
        }

        deposit = rate;
    }
}
