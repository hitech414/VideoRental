public class ChargeNewReleaseCalculator extends ChargeVideoCalculator{
    @Override
    double getCharge(int daysRented) {
        double charge = daysRented * 3;
        return charge;
    }
}
