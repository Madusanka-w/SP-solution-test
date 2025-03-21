package com.example.NewsWebsite.repository;

import com.example.NewsWebsite.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

  List<News> findByCategories_Id(Long categories_id);

}
