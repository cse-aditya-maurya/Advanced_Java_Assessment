package com.example.demo.service;

import com.example.demo.feign.MovieFeignClient;
import com.example.demo.model.Booking;
import com.example.demo.model.Movie;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private MovieFeignClient movieFeignClient;

    private List<Booking> bookingList = new ArrayList<>();
    @CircuitBreaker(name = "movieService", fallbackMethod = "movieFallback")
    public Booking bookTicket(Booking booking) {

        
    	Movie movie = movieFeignClient.getMovie(booking.getMovieId());

       
        double totalAmount = movie.getPrice() * booking.getTickets();
        booking.setTotalAmount(totalAmount);

     
        bookingList.add(booking);

        return booking;
    }

    public List<Booking> getAllBookings() {
        return bookingList;
    }
    
    public Booking movieFallback(Booking booking, Exception ex) {

        booking.setTotalAmount(0);
        System.out.println("Movie service down — fallback executed");

        return booking;
    }


}