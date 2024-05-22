package com.spe.Controller;

import com.spe.PlantAndPlantersApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spe.Entity.Admin;
import com.spe.Exception.AdminException;
import com.spe.Service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AdminController {
	private static final Logger logger = LogManager.getLogger(AdminController.class);
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admins")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) throws AdminException {

		logger.info("AdminController strated");
		
		Admin savedAdmin= adminService.addAdmin(admin);
		
		System.out.println(savedAdmin);
		
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.CREATED);
	}
}
