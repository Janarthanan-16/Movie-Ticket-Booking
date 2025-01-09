package com.project.movieticketbooking.entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Theatre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreId;
	private String theatreName;
	@OneToOne(cascade = CascadeType.ALL)
	private Location location;
	@OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
	private List<Screen> screen;

}
