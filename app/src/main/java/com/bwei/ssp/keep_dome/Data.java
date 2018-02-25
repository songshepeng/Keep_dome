package com.bwei.ssp.keep_dome;

/**
 * Created by 子非鱼 on 2018/2/25.
 */

public class Data {
    private int imgUrl;
    private String price;
    private String vip;
    private String clubName;
    private String distance;
    private String Position;

    public Data(int imgUrl, String price, String vip, String clubName, String distance, String position) {
        this.imgUrl = imgUrl;
        this.price = price;
        this.vip = vip;
        this.clubName = clubName;
        this.distance = distance;
        Position = position;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    @Override
    public String toString() {
        return "Data{" +
                "imgUrl='" + imgUrl + '\'' +
                ", price='" + price + '\'' +
                ", vip='" + vip + '\'' +
                ", clubName='" + clubName + '\'' +
                ", distance='" + distance + '\'' +
                ", Position='" + Position + '\'' +
                '}';
    }
}
