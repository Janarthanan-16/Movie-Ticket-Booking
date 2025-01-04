package com.project.movieticketbooking.dao;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.movieticketbooking.dto.AdminDto;
import com.project.movieticketbooking.entity.Admin;

@Repository
public class AdminDao {

	@Autowired
	com.project.movieticketbooking.repository.AdminRepository AdminRepository;

	@Autowired
	ModelMapper modelMapper;

//	1.save
	public Admin saveAdmin(Admin Admin) {
		List<Admin> list = findAllAdmin();

		for (Admin admin : list) {
			if (admin.getAdminEmail().equals(Admin.getAdminEmail())) {
				return null;
			}
		}
		AdminRepository.save(Admin);
		return Admin;

	}

//	2.findById
	public AdminDto findAdminById(int id) {
		Optional<Admin> optionalAdmin = AdminRepository.findById(id);
		if (optionalAdmin.isPresent()) {
			return modelMapper.map(optionalAdmin.get(), AdminDto.class);
		}
		return null; // exception will be there if the id is not present
	}

//	3.Find All
	public List<Admin> findAllAdmin() {
		return AdminRepository.findAll();
	}

//	4.update
	public Admin updateAdmin(Admin Admin, int id) {
		AdminDto findAdmin = findAdminById(id);
		if (findAdmin != null) {
			Admin.setAdminId(id);
			return Admin;

		}
		return null; // exception will be there if the findAdmin object is null
	}

//	5.delete
	public Admin deleteAdmin(int id) {
		Optional<Admin> foundedAdmin = AdminRepository.findById(null);
		if (foundedAdmin != null) {
			AdminRepository.delete(foundedAdmin.get());
			return foundedAdmin.get();
		}
		return null; // exception will be there for object is not present
	}

//	6.find Admin by email
	public List<Admin> findByAdminEmail(String adminEmail) {
		List<Admin> admin = AdminRepository.findByadminEmail(adminEmail);

		return admin;
	}

//	7.admin login validation for email and password
	public Admin adminLogin(String adminEmail, String adminPassword) {
		List<Admin> foundedAdmin = findByAdminEmail(adminEmail);
		if (foundedAdmin.size() > 1) {
			return null;
		} else if (foundedAdmin.get(0).getAdminPassword().equals(adminPassword)) {
			return foundedAdmin.get(0);
		} else {
			return null;
		}

	}
}
