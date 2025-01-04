package com.project.movieticketbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.movieticketbooking.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	// 1.Booking Handling Exception
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleBookingNotFoundException(
			BookingNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Booking Details Not Found For A Given Id");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// 2.User Handling Exception

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleUserNotFoundException(UserNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("User Details Not Found For A Given Id");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleListOfAllUserNotFoundException(
			ListOfAllUserNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("User Details Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

//	3.Location Exception Handling
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleLocationNotFoundException(
			LocationNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Location Details Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleListOfLocationNotFoundException(
			ListOfLocationNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Location's Details Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

//	4.Movie Exception Handling
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleMovieNotFoundException(MovieNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Movie Details Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

//	5.Admin Exception Handling
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleAdminNotFoundException(AdminNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Admin Details Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleListOfAdminNotFoundException(
			ListOfAdminNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Admin's Details Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleAdminEmailDuplicateException(
			AdminEmailDuplicateException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Admin Details Not Found Because Email Duplicated");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

//	6.Screen Exception Handling
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleScreenNotFoundException(ScreenNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Screen Details Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleListOfScreenNotFoundException(
			ListOfScreenNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Screen's Details Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

//	7.Seat Exception handling
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleSeatNotFoundException(SeatNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Seat Details Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleListOfSeatNotFoundException(
			ListOfSeatNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Seat's Details Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

//	8.Ticket Exception handling
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleListOfTicketNotFoundException(
			ListOfTicketNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Ticket's Details Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}
