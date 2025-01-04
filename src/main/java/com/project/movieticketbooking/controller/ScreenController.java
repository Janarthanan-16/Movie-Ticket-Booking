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

import com.project.movieticketbooking.dto.ScreenDto;
import com.project.movieticketbooking.entity.Screen;
import com.project.movieticketbooking.service.ScreenService;
import com.project.movieticketbooking.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("screen")
public class ScreenController {

	@Autowired
	ScreenService screenService;

	@PostMapping
	@Operation(summary = "Save Screen Details")
	public ResponseEntity<ResponseStructure<Screen>> saveScreen(@RequestBody ScreenDto Screen) {
		return screenService.saveScreen(Screen);
	}

	@GetMapping
	@Operation(summary = "Find Screen Details")
	public ResponseEntity<ResponseStructure<Screen>> findScreenById(@RequestParam int id) {
		return screenService.findScreenById(id);
	}

	@GetMapping("findAllScreen")
	@Operation(summary = "Find All Screen Details")
	public ResponseEntity<ResponseStructure<List<Screen>>> findAllScreen() {
		return screenService.findAllScreen();
	}

	@PutMapping
	@Operation(summary = "Update Screen Details")
	public ResponseEntity<ResponseStructure<Screen>> updateScreen(@RequestBody Screen Screen, @RequestParam int id) {
		return screenService.updateScreen(Screen, id);
	}

	@DeleteMapping
	@Operation(summary = "Delete Screen Details")
	public ResponseEntity<ResponseStructure<Screen>> deleteScreen(@RequestParam int id) {
		return screenService.deleteScreen(id);
	}
}
