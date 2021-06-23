public enum PriceCode {
    REGULAR(1), NEW_RELEASE(2);

    private int priceNumber;

    PriceCode(int pricenumber){
        this.priceNumber = pricenumber;
    }

    public int getPriceCodeNumber(){
        return this.priceNumber;
    }
}
