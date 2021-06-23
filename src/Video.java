import java.util.Date;

public abstract class Video {
	private String title ;

	private PriceCode priceCode;
	private VideoType videoType;
	private Date registeredDate ;
	private boolean rented ;
	
	public Video() {
		this.registeredDate = new Date() ;
	}

	public PriceCode getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(PriceCode priceCode) {
		this.priceCode = priceCode;
	}

	public int getPriceCodeNumber() { return this.priceCode.getPriceCodeNumber(); }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public VideoType getVideoType() {
		return videoType;
	}

	public void setVideoType(VideoType videoType) {
		this.videoType = videoType;
	}

	public int getVideoTypeNumber() { return this.videoType.getVideoTypeNumber(); }

	public abstract int getDaysRentedLimit();
	public abstract int getLateReturnPointPenalty();

}
