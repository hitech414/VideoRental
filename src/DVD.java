public class DVD extends Video{
    public DVD(String title, PriceCode priceCode){
        super();
        this.setTitle(title);
        this.setPriceCode(priceCode);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 3 ;
    }

    @Override
    public int getDaysRentedLimit() {
        return 2;
    }
}