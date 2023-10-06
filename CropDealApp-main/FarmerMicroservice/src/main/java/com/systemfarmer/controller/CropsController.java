package com.systemfarmer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.systemfarmer.model.CropsDetails;
import com.systemfarmer.repo.CropsRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/apiFarmer")
public class CropsController {
	
	

	@Autowired
    CropsRepository repo;
	
	@GetMapping(value="/crop")
	public List<CropsDetails> getAllCropsDetails(){
		return repo.findAll();
	}
	
	@GetMapping(value="/crop/{id}")
	  public Optional<CropsDetails> getCropsDetails(@PathVariable String id) {
		return repo.findById(id);
	  }
	
	@GetMapping(value="/farmerCrop/{farmerId}")
	  public List<CropsDetails> getByFarmerId(@PathVariable String farmerId) {
		return repo.findByFarmerId(farmerId);
	  }
	


	  @PostMapping(value="/crop")
	  public void addCropsDetails(@RequestBody CropsDetails crops) {
		  repo.insert(crops);
	  }

	  @PutMapping(value="/crop/{id}")
	  public void updateCropsDetails(@PathVariable String id, @RequestBody CropsDetails crops) {
		  repo.save(crops);
	  }

	  @DeleteMapping(value="/crop/{id}")
	  public void deleteCropsDetails(@PathVariable String id) {
	    repo.deleteById(id);
	  }

}
