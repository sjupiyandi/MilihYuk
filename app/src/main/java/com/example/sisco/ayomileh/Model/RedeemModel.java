package com.example.sisco.ayomileh.Model;

import java.util.ArrayList;

/**
 * Created by Princhaa on /22Oct/17.
 */

public class RedeemModel {
    private String id;
    private String name;
    private String price;
    private String code;
    private String coin;
    private String image;

    public RedeemModel(String id, String name, String price, String code, String coin, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.code = code;
        this.coin = coin;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static ArrayList<RedeemModel> createRedeem(){
        ArrayList<RedeemModel> redeemModels = new ArrayList<>();

        redeemModels.add(new RedeemModel("1", "Nasi Goreng Jawa", "24.000", "CGQ23T", "100", "nasgor"));
        redeemModels.add(new RedeemModel("2", "Spiderman Home Coming", "60.000", "CIN24H", "400", "movie"));
        redeemModels.add(new RedeemModel("3", "Spiderman Home Alone", "60.000", "CIN24G", "300", "movie"));
        return redeemModels;
    }
}
