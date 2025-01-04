package com.project.movieticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.movieticketbooking.dao.BookingDao;
import com.project.movieticketbooking.entity.Booking;
import com.project.movieticketbooking.exception.BookingDeleteNotFound;
import com.project.movieticketbooking.exception.BookingNotFoundException;
import com.project.movieticketbooking.exception.BookingUpdateCannotDone;
import com.project.movieticketbooking.exception.ListOfBookingNotFoundException;
import com.project.movieticketbooking.util.ResponseStructure;

@Service
public class BookingService {

	@Autowired
	BookingDao bookingDao;

//	1.save
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking) {
		ResponseStructure<Booking> structure = new ResponseStructure<>();
		structure.setData(bookingDao.saveBooking(booking));
		structure.setMessage("Booked Successfull");
		structure.setStatusCode(HttpStatus.CREATED.value());

		return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.CREATED);
	}

//	2.findById
	public ResponseEntity<ResponseStructure<Booking>> findBookigById(int id) {
		Booking booking = bookingDao.findBookingById(id);
		if (booking != null) {
			ResponseStructure<Booking> structure = new ResponseStructure<>();
			structure.setData(booking);
			structure.setMessage("Booking Founded");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.FOUND);
		}
		throw new BookingNotFoundException("***For The Given Id Booking Details Not Found or Booking Id is Invalid***");
	}

//	3.Find All

	public ResponseEntity<ResponseStructure<List<Booking>>> findAllBooking() {
		List<Booking> allFoundedBooking = bookingDao.findAllBooking();
		if (allFoundedBooking != null) {
			ResponseStructure<List<Booking>> structure = new ResponseStructure<>();
			structure.setData(allFoundedBooking);
			structure.setMessage("All Booking Founded Successfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Booking>>>(structure, HttpStatus.NOT_FOUND);
		}
		throw new ListOfBookingNotFoundException("***No Booking Details Found it Should Be Empty***"); // exception will be
																									// there if list
		// of Booking object is null
	}

//	4.update

	public ResponseEntity<ResponseStructure<Booking>> updateBooking(Booking booking, int id) {
		Booking updatedBooking = bookingDao.updateBooking(booking, id);
		if (updatedBooking != null) {
			ResponseStructure<Booking> structure = new ResponseStructure<>();
			structure.setData(updatedBooking);
			structure.setMessage("Booking Updated Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.OK);
		}
		throw new BookingUpdateCannotDone("***For The Given Id Data Not Present or else Booking Details Not Retrieved***"); // exception
																														// will
																														// be
																														// there
																														// if
																														// object
																														// is
																														// not
																														// present

	}

//	5.delete
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(int id) {
		ResponseEntity<ResponseStructure<Booking>> foundedBooking = findBookigById(id);
		if (foundedBooking != null) {
			ResponseStructure<Booking> structure = new ResponseStructure<>();
			structure.setData(bookingDao.deleteBooking(id));
			structure.setMessage("Booking Deleted Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.OK);
		}
		throw new BookingDeleteNotFound("For The Given Id Booking Details Not Found"); // exception will be there if
																						// object is not present
	}

}
