package com.spe.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spe.Entity.Plant;
import com.spe.Exception.PlantException;
import com.spe.Service.PlantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PlantController {
	private static final Logger logger = LogManager.getLogger(PlantController.class);

	@Autowired
	private PlantService plantService;
	
	@PostMapping("/plants")
	public ResponseEntity<Plant> addNewPlant(@Valid @RequestBody Plant plant) throws PlantException{
		logger.info("Adding New Plant " + plant.getCommonName());
		Plant newPlant = plantService.addPlant(plant);
		
		return new ResponseEntity<Plant>(newPlant,HttpStatus.CREATED);
	}
	
	@PutMapping("/plants/{plantId}")
	public ResponseEntity<Plant> updatePlant(@Valid @PathVariable Integer plantId, @RequestBody Plant plant) throws PlantException{ 
		logger.info("Update plant " + plantId);
		Plant existingPlant = plantService.updatePlant(plantId, plant);
		
		return new ResponseEntity<Plant>(existingPlant,HttpStatus.OK);
	}
	
	@DeleteMapping("/plants/{id}")
	public ResponseEntity<Plant> deletePlant(@PathVariable("id") Integer plantId) throws PlantException{
		logger.info("Delete Plant " + plantId);
		Plant existingPlant = plantService.deletePlant(plantId);
		
		return new ResponseEntity<Plant>(existingPlant,HttpStatus.OK);
		
	}
	
	@GetMapping("/plants/{plantId}")
	public ResponseEntity<Plant> getPlantById(@PathVariable Integer plantId) throws PlantException{
		logger.info("Find Plant by ID " + plantId);
		Plant existingPlant = plantService.viewPlant(plantId);
		
		return new ResponseEntity<Plant>(existingPlant,HttpStatus.FOUND);
		
	}
	
	@GetMapping("/plants")
	public ResponseEntity<List<Plant>> findAllPlants() throws PlantException{
		logger.info("Get All Plants");
		List<Plant> plantList = plantService.viewAllPlants();
		
		return new ResponseEntity<List<Plant>>(plantList,HttpStatus.FOUND);
	}
	
	@GetMapping("/plantByCommonName/{commonName}")
	public ResponseEntity<List<Plant>> findSeedByCommonName(@PathVariable String commonName) throws PlantException{
		logger.info("Get Seeds by Common Name " + commonName);
		List<Plant> plantList = plantService.viewPlant(commonName);
		
		return new ResponseEntity<List<Plant>>(plantList,HttpStatus.FOUND);		
	}
	
	@GetMapping("/plantsByTypeOfPlant/{typeOfPlant}")
	public ResponseEntity<List<Plant>> findSeedByTypeOfPlant(@PathVariable String typeOfPlant) throws PlantException{
		logger.info("Get Seeds by Plant Type " + typeOfPlant);
		List<Plant> plantList = plantService.viewAllPlants(typeOfPlant);
		
		return new ResponseEntity<List<Plant>>(plantList,HttpStatus.FOUND);		
	}
	
	
	
	
}
