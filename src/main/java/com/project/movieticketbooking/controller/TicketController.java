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

import com.project.movieticketbooking.entity.Ticket;
import com.project.movieticketbooking.service.TicketService;
import com.project.movieticketbooking.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("ticket")
public class TicketController {

	@Autowired
	TicketService ticketService;

	@PostMapping
	@Operation(summary = "Save Ticket Details")
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(@RequestBody Ticket Ticket) {
		return ticketService.saveTicket(Ticket);
	}

	@GetMapping
	@Operation(summary = "Find Ticket Details By Id")
	public ResponseEntity<ResponseStructure<Ticket>> findTicketById(@RequestParam int id) {
		return ticketService.findTicketById(id);
	}

	@GetMapping("findAllTicket")
	@Operation(summary = "Find All Ticket Details")
	public ResponseEntity<ResponseStructure<List<Ticket>>> findAllTicket() {
		return ticketService.findAllTicket();
	}

	@PutMapping
	@Operation(summary = "Update Ticket Details")
	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(@RequestBody Ticket Ticket, @RequestParam int id) {
		return ticketService.updateTicket(Ticket, id);
	}

	@DeleteMapping
	@Operation(summary = "Delete Ticket Details")
	public ResponseEntity<ResponseStructure<Ticket>> deleteTicket(@RequestParam int id) {
		return ticketService.deleteTicket(id);
	}
}
