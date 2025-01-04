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

import com.project.movieticketbooking.entity.Theatre;
import com.project.movieticketbooking.service.TheatreService;
import com.project.movieticketbooking.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("theatre")
public class TheatreController {
	@Autowired
	TheatreService theatreService;

	@PostMapping
	@Operation(summary = "Save Theatre Detailss")
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(@RequestBody Theatre Theatre) {
		return theatreService.saveTheatre(Theatre);
	}

	@GetMapping
	@Operation(summary = "Find Theatre Details By Id")
	public ResponseEntity<ResponseStructure<Theatre>> findTheatreById(@RequestParam int id) {
		return theatreService.findTheatreById(id);
	}

	@GetMapping("findAllTheatre")
	@Operation(summary = "Find All Theatre Details")
	public ResponseEntity<ResponseStructure<List<Theatre>>> findAllTheatre() {
		return theatreService.findAllTheatre();
	}

	@PutMapping
	@Operation(summary = "Update Theatre Details")
	public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(@RequestBody Theatre Theatre,
			@RequestParam int id) {
		return theatreService.updateTheatre(Theatre, id);
	}

	@DeleteMapping
	@Operation(summary = "Delete Theatre Details")
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(@RequestParam int id) {
		return theatreService.deleteTheatre(id);
	}
}
