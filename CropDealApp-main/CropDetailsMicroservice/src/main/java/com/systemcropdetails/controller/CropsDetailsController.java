package com.systemcropdetails.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.systemcropdetails.model.CropDetails;
import com.systemcropdetails.repo.CropDetailsRepo;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/apiCrop")
public class CropsDetailsController {



	@Autowired
	CropDetailsRepo repo;

	@GetMapping("/crop")
	public List<CropDetails> getAllCropsDetails(){
		return repo.findAll();
	}

	@GetMapping("/crop/{id}")
	public List<CropDetails> getCropsDetails(@PathVariable String id) {
		return repo.findByFarmerId(id);
	}

	@GetMapping("/farmerCrop/{farmerId}")
	public List<CropDetails> getByFarmerId(@PathVariable String farmerId) {
		return repo.findByFarmerId(farmerId);
	}


	@PostMapping("/addcrop")
	public List<CropDetails> addCropDetails(@RequestBody CropDetails crops) {
		return (List<CropDetails>) repo.insert(crops);

	}

	@PutMapping("/crop/{id}")
	public List<CropDetails> updateCropsDetails(@PathVariable String id, @RequestBody CropDetails crops) {
		return (List<CropDetails>) repo.save(crops);
	}

	@DeleteMapping("/crop/{id}")
	public void deleteCropsDetails(@PathVariable String id) {
		repo.deleteById(id);
	}
}