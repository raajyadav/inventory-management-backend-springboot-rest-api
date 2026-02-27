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

import com.raj.inventory.entity.Category;
import com.raj.inventory.repository.CategoryRepository;
import com.raj.inventory.service.CategoryServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

    CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
	
	// CREATE CATEGORY
	@PostMapping
	public ResponseEntity<Category> createCatogory(@Valid @RequestBody Category category) {
		 return new ResponseEntity<>(
				 categoryServiceImpl.createCategory(category),
				 HttpStatus.CREATED
				 );
	}
	
	// GET ALL CATEGORIES
	@GetMapping
	public ResponseEntity<List<Category>> getAllCatogory(){
		return new ResponseEntity<>(
				categoryServiceImpl.getAllCategories(),
				HttpStatus.OK
				);
	}
	
	// GET CATEGORY BY ID
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
		return new ResponseEntity<> (
				categoryServiceImpl.getCategoryById(id),
				HttpStatus.OK
				);
	}
	
	// UPDATE CATEGORY
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@Valid @PathVariable Long id,@RequestBody Category category) {
		return new ResponseEntity<>(categoryServiceImpl.updateCategory(id, category),
				HttpStatus.OK
				);
	}
	
	// DELETE CATEGORY
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
		categoryServiceImpl.deleteCategory(id);
		return new ResponseEntity<>("Category Deleted Successfully",HttpStatus.OK);
	}
}
