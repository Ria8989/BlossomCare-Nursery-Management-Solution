package com.spe.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spe.Entity.CurrentAdminSession;
import com.spe.Entity.LoginDTO;
import com.spe.Exception.LoginException;
import com.spe.Service.LoginAdminService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginAdminController {
	private static final Logger logger = LogManager.getLogger(LoginAdminController.class);
	@Autowired
	private LoginAdminService loginAdminService;
	
	@PostMapping("/adminLogin")
	public ResponseEntity<CurrentAdminSession> logInCustomer(@RequestBody LoginDTO dto) throws LoginException {
		logger.info("Admin Login");
		CurrentAdminSession result = loginAdminService.logIntoAccount(dto);
			
		return new ResponseEntity<CurrentAdminSession>(result,HttpStatus.OK );
	}
	
	@PostMapping("/adminLogout")
	public String logoutCustomer(@RequestParam(required = false) String token) throws LoginException {
		logger.info("Admin Logout");
		return loginAdminService.logOutFromAccount(token);
	}
}
