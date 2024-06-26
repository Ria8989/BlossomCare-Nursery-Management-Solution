package com.spe.Controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spe.Entity.Customer;
import com.spe.Exception.CustomerException;
import com.spe.Service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CustomerController {
	private static final Logger logger = LogManager.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) throws CustomerException {

		Customer savedCustomer= customerService.addCustomer(customer);
		logger.info("Creating customer " + savedCustomer.getCustomerName());
		
		return new ResponseEntity<Customer>(savedCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/customers")
	public  ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer,@RequestParam(required = false) String key ) throws CustomerException {
		
		
		Customer updatedCustomer= customerService.updateCustomer(customer, key);
		logger.info("Updating Customer "  + updatedCustomer.getCustomerName());
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/customers/{customerId}/{token}/{adminId}")
	public  ResponseEntity<Customer> deleteCustomerById(@PathVariable Integer customerId,@PathVariable String token,@PathVariable Integer adminId ) throws CustomerException {
		
		
		Customer deletedCustomer= customerService.deleteCustomer(customerId, token,adminId);
		logger.info("Deleting Customer "  + deletedCustomer.getCustomerName());
		return new ResponseEntity<Customer>(deletedCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/customers/{customerId}/{token}/{adminId}")
	public  ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerId,@PathVariable String token,@PathVariable Integer adminId ) throws CustomerException {
		
		
		Customer customer= customerService.viewCustomer(customerId, token,adminId);
		logger.info("Find Customer By ID "  + customerId);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/customers/{token}/{adminId}")
	public  ResponseEntity<List<Customer>> getAllCustomer(@PathVariable String token,@PathVariable Integer adminId ) throws CustomerException {
		
		
		List<Customer> customerList = customerService.viewAllCustomer(token,adminId);
		logger.info("Get All Customers");
		return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
	}

}
