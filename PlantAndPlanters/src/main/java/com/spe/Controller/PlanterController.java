package com.spe.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spe.Entity.Planter;
import com.spe.Exception.PlanterException;
import com.spe.Service.PlanterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PlanterController {
	private static final Logger logger = LogManager.getLogger(PlanterController.class);

	@Autowired
	private PlanterService planterService;
	
	@PostMapping("/planters")
	public ResponseEntity<Planter> addNewPlanter(@Valid @RequestBody Planter planter) throws PlanterException{
		logger.info("Adding New Planter");
		Planter savedPlanter = planterService.addPlanter(planter);
		
		return new ResponseEntity<Planter>(savedPlanter,HttpStatus.CREATED);
	}
	
	@PutMapping("/planters/{planterId}")
	public ResponseEntity<Planter> updatePlanter(@PathVariable Integer planterId, @Valid @RequestBody Planter planter) throws PlanterException{
		logger.info("Updating Planter");
		System.out.println(planter);
		
		Planter updatedPlanter = planterService.updatePlanter(planterId, planter);
		
		return new ResponseEntity<Planter>(updatedPlanter,HttpStatus.OK);
	}
	
	@DeleteMapping("/planters/{planterId}")
	public ResponseEntity<Planter> deletePlanter(@PathVariable Integer planterId) throws PlanterException{
		logger.info("Deleting Planter");
		Planter deletedPlanter = planterService.deletePlanter(planterId);
		
		return new ResponseEntity<Planter>(deletedPlanter, HttpStatus.OK);
	}
	
	@GetMapping("/planters/{planterId}")
	public ResponseEntity<Planter> getPlanterById(@PathVariable Integer planterId) throws PlanterException{
		logger.info("Get Planter by ID");
		Planter planter = planterService.viewPlanterById(planterId);
		
		return new ResponseEntity<Planter>(planter, HttpStatus.FOUND);
	}
	
	@GetMapping("/planters")
	public ResponseEntity<List<Planter>> getAllPlanters() throws PlanterException{
		logger.info("Get All Planters");
		List<Planter> planterList = planterService.viewAllPlanters();
		
		return new ResponseEntity<List<Planter>>(planterList, HttpStatus.FOUND);
	}
	
	@GetMapping("/planters/{startCost}/{endCost}")
	public ResponseEntity<List<Planter>> getAllPlanterByCost(@PathVariable Double startCost, @PathVariable Double endCost) throws PlanterException{
		logger.info("Get Planter by Cost");
		List<Planter> planterList = planterService.viewPlantersByCost(startCost, endCost);
		
		return new ResponseEntity<List<Planter>>(planterList, HttpStatus.FOUND);
	}
	
	@GetMapping("/plantersByShape/{planterShape}")
	public ResponseEntity<List<Planter>> getPlanterById(@PathVariable String planterShape) throws PlanterException{
		logger.info("Get Planter by Shape");
		List<Planter> planterList = planterService.viewPlantersByShape(planterShape);
		
		return new ResponseEntity<List<Planter>>(planterList, HttpStatus.FOUND);
	}
}
