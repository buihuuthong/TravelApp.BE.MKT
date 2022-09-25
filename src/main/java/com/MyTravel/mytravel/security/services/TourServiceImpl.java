//package com.MyTravel.mytravel.security.services;
//
//import com.MyTravel.mytravel.dto.TourCreateDto;
//import com.MyTravel.mytravel.repository.TourRepository;
//import lombok.RequiredArgsConstructor;
//
//@org.springframework.stereotype.Service
//@RequiredArgsConstructor
//public class TourServiceImpl {
//    private final TourRepository tourRepository;
//
//    public Tour createTour(TourCreateDto dto) {
//
//        var tour = new Tour();
//        tour.setTourName(dto.getTourName());
//        tour.setBanner(dto.getBanner());
//        tour.setTourPlan(dto.getTourPlan());
//        tour.setIntroduce(dto.getIntroduce());
//        tour.setTourTime(dto.getTourTime());
//        tour.setBasePrice(dto.getBasePrice());
//        tour.setPhone(dto.getPhone());
//        tour.setRating(dto.getRating());
//        tour.setListImage(dto.getListImage());
//        return tourRepository.save(tour);
//    }
//}
