package com.example.NewsWebsite.controller;

import com.example.NewsWebsite.model.Category;
import com.example.NewsWebsite.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/category")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @PostMapping
  public ResponseEntity addCategory(@RequestBody Category category) {
	try {
	  Category category1 = categoryService.createCategory(category);
	  return new ResponseEntity<>(category1, HttpStatus.CREATED);
	}catch (Exception e) {
	  return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
  }

  @GetMapping
  public ResponseEntity getAllCategory() {
	try {
	  List<Category> categories = categoryService.findAllCategory();
	  return new ResponseEntity<>(categories, HttpStatus.OK);
	}catch (Exception e) {
	  return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
  }

  @PutMapping("/{id}")
  public ResponseEntity updateCategory(@PathVariable Long id, @RequestBody Category category) {
	try {
	  Category category1 = categoryService.updateCategory(id, category);
	  return new ResponseEntity<>(category1, HttpStatus.OK);
	}catch (Exception e) {
	  return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
  }

}
