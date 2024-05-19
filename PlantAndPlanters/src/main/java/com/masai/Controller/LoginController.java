package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masai.Entity.CurrentUserSession;
import com.masai.Entity.LoginDTO;
import com.masai.Exception.LoginException;
import com.masai.Service.LoginService;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> logInCustomer(@RequestBody LoginDTO dto) throws LoginException {
		
		CurrentUserSession session = loginService.logIntoAccount(dto);
			
		return new ResponseEntity<CurrentUserSession>(session,HttpStatus.OK );
	}
	
	@PostMapping("/logout")
	public String logoutCustomer(@RequestParam(required = false) String token) throws LoginException {
		return loginService.logOutFromAccount(token);	
	}
}
