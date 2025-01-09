package com.project.movieticketbooking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.movieticketbooking.dao.TheatreDao;
import com.project.movieticketbooking.entity.Screen;
import com.project.movieticketbooking.entity.Theatre;
import com.project.movieticketbooking.exception.ListOfTheatreNotFoundException;
import com.project.movieticketbooking.exception.TheatreNotFoundException;
import com.project.movieticketbooking.util.ResponseStructure;

@Service
public class TheatreService {

	@Autowired
	TheatreDao theatreDao;

//	1.save
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(Theatre Theatre) {
		
		System.out.println(Theatre);
		
		ResponseStructure<Theatre> structure = new ResponseStructure<>();
		for (Screen screen : Theatre.getScreen()) {
			screen.setTheatre(Theatre);
		}

		structure.setData(theatreDao.saveTheatre(Theatre));
		structure.setMessage("Theatre saved successfull");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Theatre>>(structure, HttpStatus.CREATED);
	}

// 2.findTheatreById
	public ResponseEntity<ResponseStructure<Theatre>> findTheatreById(int id) {
		Theatre foundedTheatre = theatreDao.findTheatreById(id);
		if (foundedTheatre != null) {
			ResponseStructure<Theatre> structure = new ResponseStructure<>();
			structure.setData(foundedTheatre);
			structure.setMessage("Theatre Founded successfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Theatre>>(structure, HttpStatus.FOUND);
		}
		throw new TheatreNotFoundException("Theatre Not Found For A Given Id"); // exception will be there
																				// TheatreNotFoundException
	}

// 3.findAll
	public ResponseEntity<ResponseStructure<List<Theatre>>> findAllTheatre() {
		List<Theatre> Theatre = theatreDao.findAllTheatre();
		if (Theatre != null) {
			ResponseStructure<List<Theatre>> structure = new ResponseStructure<>();
			structure.setData(Theatre);
			structure.setMessage("Theatres Founded successfully");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Theatre>>>(structure, HttpStatus.FOUND);
		}
		throw new ListOfTheatreNotFoundException("Theatre's Not Found"); // exception will be there if list of Theatre
																			// is empty
	}

//	4.update

	public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(Theatre Theatre, int id) {
		Theatre updatedTheatre = theatreDao.updateTheatre(Theatre, id);
		if (updatedTheatre != null) {
			ResponseStructure<Theatre> structure = new ResponseStructure<>();
			structure.setData(updatedTheatre);
			structure.setMessage("Theatre Updated Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Theatre>>(structure, HttpStatus.OK);
		}
		throw new TheatreNotFoundException("Theatre Not Found For A Given Id"); // exception will be there if object is
																				// not present

	}

//	5.delete
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(int id) {
		ResponseEntity<ResponseStructure<Theatre>> foundedTheatre = findTheatreById(id);
		if (foundedTheatre != null) {
			ResponseStructure<Theatre> structure = new ResponseStructure<>();
			structure.setData(theatreDao.deleteTheatre(id));
			structure.setMessage("Theatre Deleted Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Theatre>>(structure, HttpStatus.OK);
		}
		throw new TheatreNotFoundException("Theatre Not Found For A Given Id"); // exception will be there if object is
																				// not present
	}

}
