package com.MyTravel.mytravel.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@Document(collection = "saveTour")
public class SaveTour {

    @Id
    private String id;

    private User user;

    private Tour tour;

    public SaveTour() {
    }

    public SaveTour(String id, User user, Tour tour) {
        this.id = id;
        this.user = user;
        this.tour = tour;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
