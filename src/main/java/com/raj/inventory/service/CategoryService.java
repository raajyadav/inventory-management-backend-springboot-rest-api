package com.raj.inventory.service;

import java.util.List;

import com.raj.inventory.entity.Category;

public interface CategoryService {

	public Category createCategory(Category category);
	
	public List<Category> getAllCategories();
	
	public Category getCategoryById(Long id);
	
	public Category updateCategory(Long id, Category category);
	
	public void deleteCategory(Long id);
}
