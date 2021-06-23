public class VideoSystem {

    public Video createVideo(String title, int videoType, int priceCode) {

        if(videoType == VideoType.VHS.ordinal())
            return new VHS(title, PriceCode.values()[priceCode]);
        else if(videoType == VideoType.CD.ordinal())
            return new CD(title, PriceCode.values()[priceCode]);
        else if(videoType == VideoType.DVD.ordinal())
            return new DVD(title, PriceCode.values()[priceCode]);

        return null;
    }
}
