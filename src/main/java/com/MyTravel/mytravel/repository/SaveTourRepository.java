package com.MyTravel.mytravel.repository;

import com.MyTravel.mytravel.model.SaveTour;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SaveTourRepository extends MongoRepository<SaveTour, String> {

    Optional<SaveTour> findById(String id);
    List<SaveTour> findByUserId(String id);
    Boolean existsByTourId(String id);
}
