public enum VideoType {
    VHS(1), CD(2), DVD(3);

    private int typeNumber;

    VideoType(int typeNumber){
        this.typeNumber = typeNumber;
    }

    public int getVideoTypeNumber(){
        return this.typeNumber;
    }
}


