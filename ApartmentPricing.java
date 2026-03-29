public class ApartmentPricing extends ApartmentBooking {

    double rate;
    double Monthspay;
    double advance; // 1 month mandatory advance
    double deposit;

    public void setPricesApart() {
        if (apartmentType == 1) 
            rate = 5000;
        else if (apartmentType == 2) 
            rate = 6500;
        else if (apartmentType == 3) 
            rate = 8500;

      
       // Base rent already includes full stay
        Monthspay = months * rate;

    // Optional advance months only count if less than months
    if (wantsAdvancePayment && advanceMonths < months) {
        Monthspay += advanceMonths * rate;
    }

    // Mandatory advance
    if(wantsAdvancePayment && advanceMonths >= months) {
        advance = 0; 
    }else {
        advance = rate; 
    }

    // Deposit and service fee stay
    deposit = rate;
    }
}