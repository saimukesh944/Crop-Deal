package com.systemadmin.controller;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.systemadmin.model.FarmerDetails;
import com.systemadmin.repo.AdminRepository;
import com.systemadmin.model.CropDetails;
import com.systemadmin.model.DealersDetails;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/apiAdmin")
public class AdminController {

	@Autowired
	AdminRepository repo;

	@GetMapping("/farmer")
	public Optional<FarmerDetails> getAdminDetails(@PathVariable String id) {
		return repo.findById(id);
	}

	@PostMapping("/addfarmer")
	public ResponseEntity<FarmerDetails> addFarmerDetails(@RequestBody FarmerDetails crops) {
		repo.insert(crops);
		try {
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

//@RequestMapping(value="/putfarmer",method=RequestMethod.PUT)
// public void addAdminDetails(@RequestBody FarmerDetails farmers) {
// repo.insert(farmers);
// }

	@DeleteMapping("/farmer")
	public void deleteCropDetails(@PathVariable String userName) {
		repo.deleteById(userName);
	}



	@PostMapping("/addcrop")
	public void addCropDetails(@RequestBody CropDetails crops) {
		repo.insert(crops);
	}

	@PutMapping("/crop/{id}")
	public void updateCropsDetails(@PathVariable String id, @RequestBody CropDetails crops) {
		repo.save(crops);
	}


	@DeleteMapping("/crop/{id}")
	public ResponseEntity<String> deleteCropsDetails(@PathVariable String id) {
		repo.deleteById(id);
		try {
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/dealers/{DealerId}")
	public Optional<DealersDetails> getDealersDetails(@PathVariable String DealerId) {
		return repo.findByDealerId(DealerId);
	}

	@PostMapping("/adddealers")
	public void addDealersDetails(@RequestBody DealersDetails dealers) {
		repo.insert(dealers);
	}

	@PutMapping("/dealers/{DealerId}")
	public void updateDealersDetails(@PathVariable String DealerId, @RequestBody DealersDetails dealers) {
		repo.save(dealers);
	}

	@DeleteMapping("/dealers/{DealerId}")
	public void deleteDealersDetails(@PathVariable String DealerId) {
		repo.deleteById(DealerId);
	}
}