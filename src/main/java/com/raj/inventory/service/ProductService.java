package com.raj.inventory.service;

import java.util.List;

import com.raj.inventory.entity.Product;

public interface ProductService {

	public Product createProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(Long id);
	
	public Product updateProduct(Long id, Product product);
	
	public void deleteProduct(Long id);
}
