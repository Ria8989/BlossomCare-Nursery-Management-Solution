package com.spe.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spe.Entity.Seed;
import com.spe.Exception.SeedException;
import com.spe.Service.SeedService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SeedController {
	private static final Logger logger = LogManager.getLogger(SeedController.class);
	@Autowired
	private SeedService seedService;
	
	@PostMapping("/seeds")
	public ResponseEntity<Seed> addNewSeed(@Valid @RequestBody Seed seed) throws SeedException{
		logger.info("Adding New Seed " + seed.getTypeOfSeeds());
		Seed seed2 = seedService.addSeed(seed);
		
		return new ResponseEntity<Seed>(seed2,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/seeds/{seedId}")
	public ResponseEntity<Seed> updateSeed(@PathVariable Integer seedId,@RequestBody Seed seed) throws SeedException{
		logger.info("Updating Seed " + seedId);
		Seed seed2 = seedService.updateSeed(seedId,seed);
		
		return new ResponseEntity<Seed>(seed2,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/seeds/{seedId}")
	public ResponseEntity<Seed> deleteSeed(@PathVariable Integer seedId) throws SeedException{
		logger.info("Deleting Seed " + seedId);
		Seed seed2 = seedService.deleteSeed(seedId);
		
		return new ResponseEntity<Seed>(seed2,HttpStatus.OK);
		
	}
	
	@GetMapping("/seedsById/{seedId}")
	public ResponseEntity<Seed> findSeedById(@PathVariable Integer seedId) throws SeedException{
		logger.info("Find seed by ID " + seedId);
		Seed seed2 = seedService.viewSeed(seedId);
		
		return new ResponseEntity<Seed>(seed2,HttpStatus.FOUND);		
	}
	
	@GetMapping("/seeds")
	public ResponseEntity<List<Seed>> findAllSeeds() throws SeedException{
		logger.info("Get All Seeds");
		List<Seed> seedList = seedService.viewAllSeeds();
		System.out.println("Get All Seed");
		return new ResponseEntity<List<Seed>>(seedList,HttpStatus.FOUND);
	}
	
	@GetMapping("/seedsByCommonName/{commonName}")
	public ResponseEntity<List<Seed>> findSeedByCommonName(@PathVariable String commonName) throws SeedException{
		logger.info("Get Seed by Common Name " + commonName);
		List<Seed> seedList = seedService.viewSeed(commonName);
		
		return new ResponseEntity<List<Seed>>(seedList,HttpStatus.FOUND);		
	}
	
	@GetMapping("/seedsByTypeOfSeeds/{typeOfSeeds}")
	public ResponseEntity<List<Seed>> findSeedByTypeOfSeeds(@PathVariable String typeOfSeeds) throws SeedException{
		logger.info("Get Seed by Type " + typeOfSeeds);
		List<Seed> seedList = seedService.viewAllSeeds(typeOfSeeds);
		
		return new ResponseEntity<List<Seed>>(seedList,HttpStatus.FOUND);		
	}
	
}
