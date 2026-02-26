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

import com.raj.inventory.entity.Category;
import com.raj.inventory.service.CategoryServiceImpl;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	// CREATE CATEGORY
	@PostMapping
	public Category createCatogory(@RequestBody Category category) {
		return categoryServiceImpl.createCategory(category);
	}
	
	// GET ALL CATEGORIES
	@GetMapping
	public List<Category> getAllCatogory(){
		return categoryServiceImpl.getAllCategories();
	}
	
	// GET CATEGORY BY ID
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable Long id) {
		return categoryServiceImpl.getCategoryById(id);
	}
	
	// UPDATE CATEGORY
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Long id,@RequestBody Category category) {
		return categoryServiceImpl.updateCategory(id, category);
	}
	
	// DELETE CATEGORY
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable Long id) {
		categoryServiceImpl.deleteCategory(id);
		return "Category Deleted Successfully";
	}
}
