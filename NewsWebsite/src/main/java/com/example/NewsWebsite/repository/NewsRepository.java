package com.example.NewsWebsite.repository;

import com.example.NewsWebsite.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {

}
