package com.example.demo.controller;


import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // ⭐ Book Ticket API
    @PostMapping
    public Booking bookTicket(@RequestBody Booking booking) {
        return bookingService.bookTicket(booking);
    }

    // ⭐ Get All Bookings API
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
}