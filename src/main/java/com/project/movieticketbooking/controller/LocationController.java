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

import com.project.movieticketbooking.entity.Location;
import com.project.movieticketbooking.service.LocationService;
import com.project.movieticketbooking.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("location")
public class LocationController {

	@Autowired
	LocationService locationService;

	@PostMapping
	@Operation(summary = "Save Location Details")
	public ResponseEntity<ResponseStructure<Location>> saveLocation(@RequestBody Location location) {
		return locationService.saveLocation(location);
	}

	@GetMapping
	@Operation(summary = "Find Location Details By Location Id")
	public ResponseEntity<ResponseStructure<Location>> findLocationById(@RequestParam int id) {
		return locationService.findLocationById(id);
	}

	@GetMapping("findAllLocation")
	@Operation(summary = "Find All Location")
	public ResponseEntity<ResponseStructure<List<Location>>> findAllLocation() {
		return locationService.findAllLocation();
	}

	@PutMapping
	@Operation(summary = "Update Location Details")
	public ResponseEntity<ResponseStructure<Location>> updateLocation(@RequestBody Location Location,
			@RequestParam int id) {
		return locationService.updateLocation(Location, id);
	}

	@DeleteMapping
	@Operation(summary = "Delete Location Details")
	public ResponseEntity<ResponseStructure<Location>> deleteLocation(@RequestParam int id) {
		return locationService.deleteLocation(id);
	}

}
