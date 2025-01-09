package com.project.movieticketbooking.entity;

import java.util.List;
import java.util.Map;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int screenId;
	private String screenName;
	@ElementCollection
	private Map<String, Boolean> map;
	@ManyToOne(cascade = CascadeType.ALL)
	private Theatre theatre;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Movieshow> show;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Seat> seat;

}
