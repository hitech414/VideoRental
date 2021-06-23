import java.util.List;

public class ReportGenerator {
    private Customer customer;

    private static final int POINT_ONE_COUPON = 10;
    private static final int POINT_TWO_COUPON = 30;

    public ReportGenerator (Customer customer) {
        this.customer = customer;
    }

    public String getReport () {
        double totalCharge = 0;
        int totalPoint = 0;

        List<Rental> rentals = this.customer.getRentals();
        String result = "Customer Report for " + this.customer.getName() + "\n";

        for (Rental each : rentals) {
            int daysRented = each.getDaysRented();
            double eachCharge = each.getCharge();
            int eachPoint = each.getPoint();

            result += "\t" + each.getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + eachCharge
                    + "\tPoint: " + eachPoint + "\n";

            totalCharge += eachCharge;
            totalPoint += eachPoint;
        }
        result += "Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n";

        checkCoupon(totalPoint);
        return result;
    }

    private void checkCoupon(int totalPoint) {
        if ( totalPoint >= POINT_ONE_COUPON ) {
            System.out.println("Congrat! You earned one free coupon");
        }
        else if ( totalPoint >= POINT_TWO_COUPON ) {
            System.out.println("Congrat! You earned two free coupon");
        }
    }
}
