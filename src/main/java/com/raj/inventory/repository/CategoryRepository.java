package com.raj.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raj.inventory.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
