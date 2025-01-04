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
import com.project.movieticketbooking.entity.Movieshow;
import com.project.movieticketbooking.service.ShowService;
import com.project.movieticketbooking.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("show")
public class ShowController {

	@Autowired
	ShowService showService;

	@PostMapping
	@Operation(summary = "Save Show Details")
	public ResponseEntity<ResponseStructure<Movieshow>> saveShow(@RequestBody Movieshow Show) {
		return showService.saveShow(Show);
	}

	@GetMapping
	@Operation(summary = "Find Show Details")
	public ResponseEntity<ResponseStructure<Movieshow>> findBookigById(@RequestParam int id) {
		return showService.findShowById(id);
	}

	@GetMapping("findAllShow")
	@Operation(summary = "Find All Show Details")
	public ResponseEntity<ResponseStructure<List<Movieshow>>> findAllShow() {
		return showService.findAllShow();
	}

	@PutMapping
	@Operation(summary = "Update Show Details")
	public ResponseEntity<ResponseStructure<Movieshow>> updateShow(@RequestBody Movieshow movieShow,
			@RequestParam int id) {
		return showService.updateShow(movieShow, id);
	}

	@DeleteMapping
	@Operation(summary = "Delete Show Details")
	public ResponseEntity<ResponseStructure<Movieshow>> deleteShow(@RequestParam int id) {
		return showService.deleteShow(id);
	}
}
