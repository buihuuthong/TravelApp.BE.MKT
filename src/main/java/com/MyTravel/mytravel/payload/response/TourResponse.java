package com.MyTravel.mytravel.payload.response;

import java.math.BigDecimal;

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

    public TourResponse(String id, String tourName, String banner, String listImage, String introduce, String rating, String tourPlan, String phone, String tourTime, BigDecimal basePrice) {
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
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getListImage() {
        return listImage;
    }

    public void setListImage(String listImage) {
        this.listImage = listImage;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTourPlan() {
        return tourPlan;
    }

    public void setTourPlan(String tourPlan) {
        this.tourPlan = tourPlan;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTourTime() {
        return tourTime;
    }

    public void setTourTime(String tourTime) {
        this.tourTime = tourTime;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }
}
