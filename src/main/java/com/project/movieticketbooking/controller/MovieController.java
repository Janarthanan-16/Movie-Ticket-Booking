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

import com.project.movieticketbooking.entity.Movie;
import com.project.movieticketbooking.service.MovieService;
import com.project.movieticketbooking.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("movie")
public class MovieController {

	@Autowired
	MovieService movieService;

	@PostMapping
	@Operation(summary = "Save Movie Details")
	public ResponseEntity<ResponseStructure<Movie>> saveMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}

	@GetMapping
	@Operation(summary = "Find Movie By Id")
	public ResponseEntity<ResponseStructure<Movie>> findMovieById(@RequestParam int id) {
		return movieService.findMovieById(id);
	}

	@GetMapping("findAllMovie")
	@Operation(summary = "Find All Movie Details")
	public ResponseEntity<ResponseStructure<List<Movie>>> findAllMovie() {
		return movieService.findAllMovie();
	}

	@PutMapping
	@Operation(summary = "Update Movie Details")
	public ResponseEntity<ResponseStructure<Movie>> updateMovie(@RequestBody Movie Movie, @RequestParam int id) {
		return movieService.updateMovie(Movie, id);
	}

	@DeleteMapping
	@Operation(summary = "Delete Movie Details")
	public ResponseEntity<ResponseStructure<Movie>> deleteMovie(@RequestParam int id) {
		return movieService.deleteMovie(id);
	}
}
