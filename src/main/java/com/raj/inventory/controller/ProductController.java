package com.raj.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.inventory.entity.Product;
import com.raj.inventory.service.ProductServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	// CREATE PRODUCT
	@PostMapping
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
		return new ResponseEntity<>(
				productServiceImpl.createProduct(product),
				HttpStatus.CREATED
				);
	}
	
	// GET ALL PRODUCTS
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity<>(
				productServiceImpl.getAllProducts(),
				HttpStatus.OK
				);
	}
	
	// GET PRODUCT BY ID
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		return new ResponseEntity<>(
				productServiceImpl.getProductById(id),
				HttpStatus.OK
				);
	}
	
	// UPDATE PRODUCT
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@Valid @PathVariable Long id, @RequestBody Product product) {
		return new ResponseEntity<>(
				productServiceImpl.updateProduct(id, product),
				HttpStatus.OK
				);
		
	}
	
	// DELETE PRODUCT
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		 productServiceImpl.deleteProduct(id);
		 return new ResponseEntity<>("Product Deleted Successfully",
				 HttpStatus.OK
				 );
	}
}
