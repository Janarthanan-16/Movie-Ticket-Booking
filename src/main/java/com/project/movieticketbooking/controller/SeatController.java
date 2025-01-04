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

import com.project.movieticketbooking.entity.Seat;
import com.project.movieticketbooking.service.SeatService;
import com.project.movieticketbooking.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("seat")
public class SeatController {

	@Autowired
	SeatService seatService;

	@PostMapping
	@Operation(summary = "Save Seat Details")
	public ResponseEntity<ResponseStructure<Seat>> saveSeat(@RequestBody Seat Seat) {
		return seatService.saveSeat(Seat);
	}

	@GetMapping
	@Operation(summary = "Find Seat Details By Seat Id ")
	public ResponseEntity<ResponseStructure<Seat>> findSeatById(@RequestParam int id) {
		return seatService.findSeatById(id);
	}

	@GetMapping("findAllSeat")
	@Operation(summary = "Find All Seat Details")
	public ResponseEntity<ResponseStructure<List<Seat>>> findAllSeat() {
		return seatService.findAllSeat();
	}

	@PutMapping
	@Operation(summary = "Update Seat Details")
	public ResponseEntity<ResponseStructure<Seat>> updateSeat(@RequestBody Seat Seat, @RequestParam int id) {
		return seatService.updateSeat(Seat, id);
	}

	@DeleteMapping
	@Operation(summary = "")
	public ResponseEntity<ResponseStructure<Seat>> deleteSeat(@RequestParam int id) {
		return seatService.deleteSeat(id);
	}
}
