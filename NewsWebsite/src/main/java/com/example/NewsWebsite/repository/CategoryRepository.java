package com.example.NewsWebsite.repository;

import com.example.NewsWebsite.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
