package com.MyTravel.mytravel.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;


@Getter
@Setter
@Document(collection = "tours")
public class Tour {

    @Id
    private String id;

    @NotBlank
    private String tourName;

    @NotBlank
    private String banner;

    @NotBlank
    private String introduce;

    @NotBlank
    private String rating;

    @NotBlank
    private String tourPlan;

    private String phone;

    @NotBlank
    private String tourTime;

    @NotBlank
    private BigDecimal basePrice;

    public Tour() {
    }

    public Tour(String tourName, String banner, String introduce, String rating, String tourPlan, String phone, String tourTime, BigDecimal basePrice) {
        this.tourName = tourName;
        this.banner = banner;
        this.introduce = introduce;
        this.tourPlan = tourPlan;
        this.tourTime = tourTime;
        this.phone = phone;
        this.rating = rating;
        this.basePrice = basePrice;
    }

    public String getId() {
        return id;
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
