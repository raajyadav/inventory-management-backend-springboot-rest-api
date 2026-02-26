package com.raj.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.inventory.entity.Category;
import com.raj.inventory.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private  CategoryRepository categoryRepository;

	@Override
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
    public Category getCategoryById(Long id) {
        Optional<Category> findById = categoryRepository.findById(id);
        if(findById.isPresent()) {
        	return findById.get();
        }
        return null;
    }

	@Override
	public Category updateCategory(Long id, Category category) {
		Category existing = getCategoryById(id);
		existing.setName(category.getName());
		existing.setDescription(category.getDescription());
		return categoryRepository.save(existing);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		
	}

}
