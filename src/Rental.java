import java.util.Date;

public class Rental {
    private Video video;
    private int status; // 0 for Rented, 1 for Returned
    private Date rentDate;
    private Date returnDate;
    private final int SEC_ONE_DAY = 60 * 60 * 24;

    public Rental(Video video) {
        this.video = video;
        status = 0;
        rentDate = new Date();
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public int getStatus() {
        return status;
    }

    public void returnVideo() {
        if (status == 0) {
            this.status = 1;
            returnDate = new Date();
        }
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getDaysRentedLimit() {
        int limit = 0;
        int daysRented = getDaysRented();

        if (daysRented <= 2) return limit;

        // Switch -
        // Feature Envy
        switch (video.getVideoType()) {
            case VHS:
                limit = 5;
                break;
            case CD:
                limit = 3;
                break;
            case DVD:
                limit = 2;
                break;
        }
        return limit;
    }

    public int getDaysRented() {

        // Duplication
        long diff = 0;
        if (getStatus() == 1) { // returned Video
            diff = getReturnDate().getTime() - getRentDate().getTime();
        } else { // not yet returned
            diff = new Date().getTime() - getRentDate().getTime();
        }
        return (int) (diff / (1000 * SEC_ONE_DAY)) + 1;
    }

    public int getPoint() {
        int eachPoint = 1;

        if ((this.getVideo().getPriceCode() == PriceCode.NEW_RELEASE))
            eachPoint++;

        if (getDaysRented() > getDaysRentedLimit())
            eachPoint -= Math.min(eachPoint, getVideo().getLateReturnPointPenalty());

        return eachPoint;
    }

    public double getCharge() {
        int daysRented = this.getDaysRented();

        // Switch -> Factory
        ChargeVideoCalculator calculateCharge;
        switch (this.getVideo().getPriceCode()) {
            case REGULAR:
                calculateCharge = new ChargeRegularCalculator();
                break;
            case NEW_RELEASE:
                calculateCharge = new ChargeNewReleaseCalculator();
                break;
            default:
                calculateCharge = new ChargeDefaultCalculator();
                break;
        }

        return calculateCharge.getCharge(daysRented);
    }
}
