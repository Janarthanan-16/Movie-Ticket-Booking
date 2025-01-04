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
import com.project.movieticketbooking.dto.AdminDto;
import com.project.movieticketbooking.entity.Admin;
import com.project.movieticketbooking.service.AdminService;
import com.project.movieticketbooking.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping
	@Operation(summary = "Save Admin Details")
	public ResponseEntity<ResponseStructure<Admin>> saveOwner(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@GetMapping
	@Operation(summary = "Find Admin Detail's By AdminId")
	public ResponseEntity<ResponseStructure<AdminDto>> findBookigById(@RequestParam int id) {
		return adminService.findAdminById(id);
	}

	@GetMapping("findAllAdmin")
	@Operation(summary = "Find All Admin Details")
	public ResponseEntity<ResponseStructure<List<Admin>>> findAllOwner() {
		return adminService.findAllAdmin();
	}

	@PutMapping
	@Operation(summary = "Update Admin Details")
	public ResponseEntity<ResponseStructure<Admin>> updateOwner(@RequestBody Admin admin, @RequestParam int id) {
		return adminService.updateAdmin(admin, id);
	}

	@DeleteMapping
	@Operation(summary = "Delete Admin Details")
	public ResponseEntity<ResponseStructure<Admin>> deleteOwner(@RequestParam int id) {
		return adminService.deleteAdmin(id);
	}

	@GetMapping("findByEmail")
	@Operation(summary = "Find Admin Details By Email")
	public ResponseEntity<ResponseStructure<Admin>> adminLogin(@RequestParam String adminEmail) {
		return adminService.findByAdminEamil(adminEmail);
	}

	@GetMapping("adminLogin")
	@Operation(summary = "Try To Login With Your Email And Password")
	public ResponseEntity<ResponseStructure<Admin>> adminLogin(@RequestParam String adminEmail,
			@RequestParam String adminPassword) {
		return adminService.adminLogin(adminEmail, adminPassword);
	}
}
