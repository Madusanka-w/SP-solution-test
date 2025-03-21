package com.example.NewsWebsite.service;

import com.example.NewsWebsite.model.Category;
import com.example.NewsWebsite.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public Category createCategory(Category category) {
	return categoryRepository.save(category);
  }

  public Category updateCategory(Long id, Category category) {
	Category updatedCategory = categoryRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Category not found"));

	updatedCategory.setName(category.getName());
	return categoryRepository.save(updatedCategory);
  }

  public Category findCategoryById(Long id) {
	Category category = categoryRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Category not found"));
	return category;
  }

  public List<Category> findAllCategory() {
	List<Category> categoryList = categoryRepository.findAll();
	return categoryList;
  }
}
