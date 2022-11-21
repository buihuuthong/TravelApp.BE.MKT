package com.MyTravel.mytravel.payload.request;

import com.MyTravel.mytravel.model.Tour;
import com.MyTravel.mytravel.model.User;

public class SaveTourRequest {
    private User user;

    private Tour tour;

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
