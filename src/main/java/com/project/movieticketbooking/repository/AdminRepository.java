package com.project.movieticketbooking.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.movieticketbooking.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public List<Admin> findByadminEmail(String adminEmail);

}
