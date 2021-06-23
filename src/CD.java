public class CD extends Video{
    public CD(String title, PriceCode priceCode){
        super();
        this.setTitle(title);
        this.setPriceCode(priceCode);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 2 ;
    }

    @Override
    public int getDaysRentedLimit() {
        return 3;
    }
}