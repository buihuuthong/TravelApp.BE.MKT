package com.MyTravel.mytravel.payload.response;

import java.math.BigDecimal;
import java.util.List;

public class TourResponse {

    private String id;

    private String tourName;

    private String banner;

    private String listImage;

    private String introduce;

    private String rating;

    private String tourPlan;

    private String phone;

    private String tourTime;

    private BigDecimal basePrice;

    private List<String> tourTypes;

    public TourResponse(String id, String tourName, String banner, String listImage, String introduce, String rating, String tourPlan, String phone, String tourTime, BigDecimal basePrice, List<String> tourTypes) {
        this.id = id;
        this.tourName = tourName;
        this.banner = banner;
        this.listImage = listImage;
        this.introduce = introduce;
        this.rating = rating;
        this.tourPlan = tourPlan;
        this.phone = phone;
        this.tourTime = tourTime;
        this.basePrice = basePrice;
        this.tourTypes = tourTypes;
    }
}
