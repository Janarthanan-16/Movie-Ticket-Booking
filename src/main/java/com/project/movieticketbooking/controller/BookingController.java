package com.project.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.movieticketbooking.entity.Booking;
import com.project.movieticketbooking.service.BookingService;
import com.project.movieticketbooking.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("booking")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@PostMapping
	@Operation(summary = "Save Booking Details")
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@RequestBody Booking booking) {
		return bookingService.saveBooking(booking);
	}

	@GetMapping
	@Operation(summary = "Find Booking Details By Booking Id")
	public ResponseEntity<ResponseStructure<Booking>> findBookigById(@RequestParam int id) {
		return bookingService.findBookigById(id);
	}

	@GetMapping("findAllBooking")
	@Operation(summary = "Find All Booking Details")
	public ResponseEntity<ResponseStructure<List<Booking>>> findAllBooking() {
		return bookingService.findAllBooking();
	}

	@PutMapping
	@Operation(summary = "Update Booking Details")
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@RequestBody Booking booking,
			@RequestParam int id) {
		return bookingService.updateBooking(booking, id);
	}

	@DeleteMapping
	@Operation(summary = "Delete Booking Details")
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(@RequestParam int id) {
		return bookingService.deleteBooking(id);
	}

}
