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
import com.project.movieticketbooking.dto.UserDto;
import com.project.movieticketbooking.entity.User;
import com.project.movieticketbooking.service.UserService;
import com.project.movieticketbooking.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	@Operation(summary = "Save User Details")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User User) {
		return userService.saveUser(User);
	}

	@GetMapping
	@Operation(summary = "Find User Details")
	public ResponseEntity<ResponseStructure<UserDto>> findUserById(@RequestParam int id) {
		return userService.findUserById(id);
	}

	@GetMapping("findAllUser")
	@Operation(summary = "Find All User Details")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUser() {
		return userService.findAllUser();
	}

	@PutMapping
	@Operation(summary = "Update User Details")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User User, @RequestParam int id) {
		return userService.updateUser(User, id);
	}

	@DeleteMapping
	@Operation(summary = "Delete User Details")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int id) {
		return userService.deleteUser(id);
	}

	@GetMapping("findByEmail")
	public ResponseEntity<ResponseStructure<User>> findByEmail(@RequestParam String userEmail) {
		return userService.findByEmailUser(userEmail);
	}

	@GetMapping("userLogin")
	public ResponseEntity<ResponseStructure<User>> userLogin(String userEmail, String userPassword) {
		return userService.userLogin(userEmail, userPassword);
	}
}
