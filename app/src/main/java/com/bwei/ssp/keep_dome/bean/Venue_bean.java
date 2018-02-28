package com.bwei.ssp.keep_dome.bean;

/**
 * Created by lenovo on 2018/2/27.
 */

public class Venue_bean {
    String shop_name;
    String shop_address;

    public Venue_bean(String shop_name, String shop_address) {
        this.shop_name = shop_name;
        this.shop_address = shop_address;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    @Override
    public String toString() {
        return "Venue_bean{" +
                "shop_name='" + shop_name + '\'' +
                ", shop_address='" + shop_address + '\'' +
                '}';
    }
}
