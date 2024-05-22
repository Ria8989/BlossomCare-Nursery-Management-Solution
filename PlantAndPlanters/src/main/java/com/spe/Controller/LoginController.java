package com.spe.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spe.Entity.CurrentUserSession;
import com.spe.Entity.LoginDTO;
import com.spe.Exception.LoginException;
import com.spe.Service.LoginService;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginController {
	private static final Logger logger = LogManager.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> logInCustomer(@RequestBody LoginDTO dto) throws LoginException {
		logger.info("Customer Login");
		CurrentUserSession session = loginService.logIntoAccount(dto);
			
		return new ResponseEntity<CurrentUserSession>(session,HttpStatus.OK );
	}
	
	@PostMapping("/logout")
	public String logoutCustomer(@RequestParam(required = false) String token) throws LoginException {
		logger.info("Customer Logout");
		return loginService.logOutFromAccount(token);
	}
}
