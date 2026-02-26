package com.raj.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	// CREATE PRODUCT
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productServiceImpl.createProduct(product);
	}
	
	// GET ALL PRODUCTS
	@GetMapping
	public List<Product> getAllProducts(){
		return productServiceImpl.getAllProducts();
	}
	
	// GET PRODUCT BY ID
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productServiceImpl.getProductById(id);
	}
	
	// UPDATE PRODUCT
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		return productServiceImpl.updateProduct(id, product);
	}
	
	// DELETE PRODUCT
	@DeleteMapping("/{delete}")
	public String deleteProduct(@PathVariable Long id) {
		 productServiceImpl.deleteProduct(id);
		 return "Product Deleted Successfully";
	}
}
