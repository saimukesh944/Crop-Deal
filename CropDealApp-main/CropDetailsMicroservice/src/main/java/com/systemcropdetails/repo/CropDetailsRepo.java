package com.systemcropdetails.repo;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.systemcropdetails.model.CropDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface CropDetailsRepo extends MongoRepository<CropDetails , String> {
	
	List<CropDetails> findByFarmerId(String farmerId);


	CropDetails insert(CropDetails crops);
}