package com.MyTravel.mytravel.controller;

import com.MyTravel.mytravel.exception.ApiException;
import com.MyTravel.mytravel.exception.ErrorCode;
import com.MyTravel.mytravel.model.BookTour;
import com.MyTravel.mytravel.model.SaveTour;
import com.MyTravel.mytravel.model.Tour;
import com.MyTravel.mytravel.model.User;
import com.MyTravel.mytravel.payload.request.BookTourRequest;
import com.MyTravel.mytravel.payload.request.SaveTourRequest;
import com.MyTravel.mytravel.repository.SaveTourRepository;
import com.MyTravel.mytravel.repository.TourRepository;
import com.MyTravel.mytravel.repository.UserRepository;
import com.MyTravel.mytravel.security.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class SaveTourController {

    @Autowired
    SaveTourRepository saveTourRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TourRepository tourRepository;

    @Autowired
    AuthService authService;


    @GetMapping("/saveTour/my")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<SaveTour>> getMySaveTour(@RequestParam("id") String id) {
            List<SaveTour> saveTours = new ArrayList<SaveTour>();

            if(userRepository.findById(id) == null)
                throw new ApiException(ErrorCode.USER_NOT_FOUND);

            saveTours.addAll(saveTourRepository.findByUserId(id));

            if (saveTours.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(saveTours, HttpStatus.OK);
    }

    @PostMapping("/saveTour")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<SaveTour> createSaveTour(
            @RequestParam("userId") String userId,
            @RequestParam("tourId") String tourId) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));

            Tour tour = tourRepository.findById(tourId)
                    .orElseThrow(() -> new ApiException(ErrorCode.TOUR_NOT_FOUND));

            if(saveTourRepository.existsByTourId(tourId))
                throw new ApiException(ErrorCode.TOUR_ALREADY_SAVE);

        try {
            var saveTour = new SaveTour();
            saveTour.setUser(user);
            saveTour.setTour(tour);

            SaveTour createSave = saveTourRepository.save(saveTour);

            return new ResponseEntity<>(createSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/saveTour/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteSaveTour(@PathVariable("id") String id) {
        if (!saveTourRepository.existsById(id))
            throw new ApiException(ErrorCode.TOUR_NOT_FOUND);

        try {
            saveTourRepository.deleteById(id);
            return ResponseEntity.ok("Tour has been unsave !");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
