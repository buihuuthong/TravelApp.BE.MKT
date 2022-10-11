package com.MyTravel.mytravel.payload.request;

import com.MyTravel.mytravel.model.TourType;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TourRequest {

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

    @DBRef
    private Set<String> types;

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

    public Set<String> getTypes() {
        return types;
    }

    public void setTypes(Set<String> types) {
        this.types = types;
    }
}
