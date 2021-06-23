public enum PriceCode {
    REGULAR(1), NEW_RELEASE(2);

    private int priceNumber;

    PriceCode(int pricenumber){
        this.priceNumber = pricenumber;
    }

    public int getPriceCodeNumber(){
        return this.priceNumber;
    }

    public static PriceCode fromInt(int id) {
        for (PriceCode code : values()) {
            if (code.getPriceCodeNumber() == id) {
                return code;
            }
        }
        return null;
    }
}
