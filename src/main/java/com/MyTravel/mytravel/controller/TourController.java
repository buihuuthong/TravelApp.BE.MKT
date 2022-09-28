package com.MyTravel.mytravel.controller;

import com.MyTravel.mytravel.exception.ApiException;
import com.MyTravel.mytravel.exception.ErrorCode;
import com.MyTravel.mytravel.model.Tour;
import com.MyTravel.mytravel.repository.TourRepository;
import com.MyTravel.mytravel.security.services.ImageService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TourController {

    @Autowired
    TourRepository tourRepository;

    @Autowired
    ImageService imageService;


    @GetMapping("/tours")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Tour>> getAllTour(@RequestParam(required = false) String tourName) {
        try {
            List<Tour> tours = new ArrayList<Tour>();

            if (tourName == null)
                tourRepository.findAll().forEach(tours::add);
            else
                tourRepository.findByTourName(tourName).forEach(tours::add);

            if (tours.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tours, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tours/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Tour> getTourById(@PathVariable("id") String id) {
        Optional<Tour> tourData = tourRepository.findById(id);

        if (!tourRepository.existsById(id))
            throw new ApiException(ErrorCode.TOUR_NOT_FOUND);

        if (tourData.isPresent()) {
            return new ResponseEntity<>(tourData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/tours")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour) {
        try {
            Tour _tour = tourRepository.save(new Tour(
                    tour.getTourName(),
                    tour.getBanner(),
                    tour.getIntroduce(),
                    tour.getTourPlan(),
                    tour.getTourTime(),
                    tour.getPhone(),
                    tour.getRating(),
                    tour.getBasePrice()));
            return new ResponseEntity<>(_tour, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tours/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Tour> updateTour(@PathVariable("id") String id, @RequestBody Tour tour) {
        Optional<Tour> tourData = tourRepository.findById(id);

        if (!tourRepository.existsById(id))
            throw new ApiException(ErrorCode.TOUR_NOT_FOUND);

        if (tourData.isPresent()) {
            Tour _tour = tourData.get();
            _tour.setTourName(tour.getTourName());
            _tour.setBanner(tour.getBanner());
            _tour.setIntroduce(tour.getIntroduce());
            _tour.setTourPlan(tour.getTourPlan());
            _tour.setTourTime(tour.getTourTime());
            _tour.setPhone(tour.getPhone());
            _tour.setRating(tour.getRating());
            _tour.setBasePrice(tour.getBasePrice());
            return new ResponseEntity<>(tourRepository.save(_tour), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tours/image")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @ApiResponses({
            @ApiResponse(code = 404, message = "TOUR_NOT_FOUND"),
            @ApiResponse(code = 500, message = "IMAGE_UPLOAD_FAILED")
    })
    public Tour updateTourImage(@RequestParam("id") String id, @RequestPart("image") MultipartFile image) {
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.TOUR_NOT_FOUND));
        try {
            if (tour.getBanner() != null) imageService.deleteImage(tour.getBanner());
            String imageFileName = imageService.uploadImage(image);
            tour.setBanner(imageFileName);
            return tourRepository.save(tour);
        } catch (IOException e) {
            throw new ApiException(ErrorCode.IMAGE_UPLOAD_FAILED);
        }
    }

    @DeleteMapping("/tours/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteTour(@PathVariable("id") String id) {
        if (!tourRepository.existsById(id))
            throw new ApiException(ErrorCode.TOUR_NOT_FOUND);

        try {
            tourRepository.deleteById(id);
            return ResponseEntity.ok("Tour has been deleted!");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
