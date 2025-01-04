package com.project.movieticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.movieticketbooking.dao.TicketDao;
import com.project.movieticketbooking.entity.Ticket;
import com.project.movieticketbooking.exception.ListOfTicketNotFoundException;
import com.project.movieticketbooking.exception.TicketNotFoundException;
import com.project.movieticketbooking.util.ResponseStructure;

@Service
public class TicketService {

	@Autowired
	TicketDao ticketDao;

//	1.save
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(Ticket Ticket) {
		ResponseStructure<Ticket> structure = new ResponseStructure<>();
		structure.setData(ticketDao.saveTicket(Ticket));
		structure.setMessage("Ticket saved successfull");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Ticket>>(structure, HttpStatus.CREATED);
	}

	// 2.findTicketById
	public ResponseEntity<ResponseStructure<Ticket>> findTicketById(int id) {
		Ticket foundedTicket = ticketDao.findTicketById(id);
		if (foundedTicket != null) {
			ResponseStructure<Ticket> structure = new ResponseStructure<>();
			structure.setData(foundedTicket);
			structure.setMessage("Ticket Founded successfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Ticket>>(structure, HttpStatus.FOUND);
		}
		throw new TicketNotFoundException("Ticket Not Found"); // exception will be there TicketNotFoundException
	}

	// 3.findAll
	public ResponseEntity<ResponseStructure<List<Ticket>>> findAllTicket() {
		List<Ticket> Ticket = ticketDao.findAllTicket();
		if (Ticket != null) {
			ResponseStructure<List<Ticket>> structure = new ResponseStructure<>();
			structure.setData(Ticket);
			structure.setMessage("Tickets Founded successfully");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Ticket>>>(structure, HttpStatus.FOUND);
		}
		throw new ListOfTicketNotFoundException("**No Ticket Found**"); // exception will be there if list of Ticket is
																		// empty
	}

//	4.update

	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(Ticket Ticket, int id) {
		Ticket updatedTicket = ticketDao.updateTicket(Ticket, id);
		if (updatedTicket != null) {
			ResponseStructure<Ticket> structure = new ResponseStructure<>();
			structure.setData(updatedTicket);
			structure.setMessage("Ticket Updated Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Ticket>>(structure, HttpStatus.OK);
		}
		throw new TicketNotFoundException("Ticket Not Found"); // exception will be there if object is not present

	}

//	5.delete
	public ResponseEntity<ResponseStructure<Ticket>> deleteTicket(int id) {
		ResponseEntity<ResponseStructure<Ticket>> foundedTicket = findTicketById(id);
		if (foundedTicket != null) {
			ResponseStructure<Ticket> structure = new ResponseStructure<>();
			structure.setData(ticketDao.deleteTicket(id));
			structure.setMessage("Ticket Deleted Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Ticket>>(structure, HttpStatus.OK);
		}
		throw new TicketNotFoundException("Ticket Not Found"); // exception will be there if object is not present
	}

}
