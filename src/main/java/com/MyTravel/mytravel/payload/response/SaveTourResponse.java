package com.MyTravel.mytravel.payload.response;

import com.MyTravel.mytravel.model.Tour;
import com.MyTravel.mytravel.model.User;

public class SaveTourResponse {

    private String id;

    private User user;

    private Tour tour;

    public SaveTourResponse(String id, User user, Tour tour) {
        this.id = id;
        this.user = user;
        this.tour = tour;
    }
}
