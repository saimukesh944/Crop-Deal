package com.systemorders.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.systemorders.model.Cart;
import com.systemorders.repository.CartRepository;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/apiCart")
@EnableEurekaClient
public class CartController {
  @Autowired
  CartRepository repo;


  @GetMapping(value="/getCart")
  public List<Cart> getAllCart() {
	  return repo.findAll();
  }
  
  @GetMapping(value="/dealerCart/{dealerId}")
  public List<Cart> getByFarmerId(@PathVariable String dealerId) {
	return repo.findByDealerId(dealerId);
  }

  @PostMapping(value="/addToCart")
  public void addOrders(@RequestBody Cart cart) {
	  repo.insert(cart);
  }

  @DeleteMapping(value="/deleteCart")
  public void deleteorders() {
    repo.deleteAll();
  }
  
  @DeleteMapping(value="/deleteCart/{id}")
  public void deleteCropsDetails(@PathVariable String id) {
    repo.deleteById(id);
  }
  @PutMapping(value="/updateCart/{id}")
  public void UpdateCropsDetails(@PathVariable String id) {
	 Cart cart=repo.findById(id).get();
	  if(cart!=null)
		  cart.setPaymentStatus(true);
   repo.save(cart);
  }

  

}
