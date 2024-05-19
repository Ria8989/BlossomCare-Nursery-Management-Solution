package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masai.Entity.CurrentAdminSession;
import com.masai.Entity.LoginDTO;
import com.masai.Exception.LoginException;
import com.masai.Service.LoginAdminService;
import com.masai.Service.LoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginAdminController {

	@Autowired
	private LoginAdminService loginAdminService;
	
	@PostMapping("/adminLogin")
	public ResponseEntity<CurrentAdminSession> logInCustomer(@RequestBody LoginDTO dto) throws LoginException {
		
		CurrentAdminSession result = loginAdminService.logIntoAccount(dto);
			
		return new ResponseEntity<CurrentAdminSession>(result,HttpStatus.OK );
	}
	
	@PostMapping("/adminLogout")
	public String logoutCustomer(@RequestParam(required = false) String token) throws LoginException {
		return loginAdminService.logOutFromAccount(token);	
	}
}
