import java.util.Date;

public class Rental {
	private Video video ;
	private int status ; // 0 for Rented, 1 for Returned
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		status = 0 ;
		rentDate = new Date() ;
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
		if ( status == 1 ) {
			this.status = 1;
			returnDate = new Date() ;
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
		if (getDaysRented() <= 2) return 0;
		return video.getDaysRentedLimit();
	}

	public int getDaysRented() {
		long diff;
		if (getStatus() == 1) { // returned Video
			diff = returnDate.getTime() - rentDate.getTime();
		} else { // not yet returned
			diff = new Date().getTime() - rentDate.getTime();
		}
		return (int) (diff / (1000 * 60 * 60 * 24)) + 1;
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
