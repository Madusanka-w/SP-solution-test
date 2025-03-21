package com.example.NewsWebsite.controller;

import com.example.NewsWebsite.dto.NewsDto;
import com.example.NewsWebsite.model.Comment;
import com.example.NewsWebsite.model.News;
import com.example.NewsWebsite.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/news")
public class NewsController {

  @Autowired
  private NewsService newsService;

  @PostMapping
  public ResponseEntity createNews(@RequestBody NewsDto newsDto) {
	try {
	  News news = newsService.createNews(newsDto);
	  return new ResponseEntity<>(news, HttpStatus.CREATED);
	}catch (Exception e){
	  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
  }

  @PutMapping("/{id}")
  public ResponseEntity updateNews(@PathVariable Long id, @RequestBody NewsDto newsDto) {
	try {
	  News news = newsService.updateNews(id, newsDto);
	  return new ResponseEntity<>(news, HttpStatus.CREATED);
	} catch (Exception e){
	  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
  }

  @GetMapping
  public ResponseEntity getAllNews() {
	try {
	  List<News> newsList = newsService.getAllNews();
	  return new ResponseEntity<>(newsList, HttpStatus.OK);
	}catch (Exception e){
	  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
  }

  @GetMapping("/{id}")
  public ResponseEntity getNews(@PathVariable Long id) {
	try {
	  News news = newsService.getNewsById(id);
	  return new ResponseEntity<>(news, HttpStatus.OK);
	}catch (Exception e){
	  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
  }

  @PatchMapping("/addComment/{id}")
  public ResponseEntity addComment(@PathVariable Long id, @RequestBody Comment comment) {
	try {
	  News news = newsService.addComment(id, comment);
	  return new ResponseEntity<>(news, HttpStatus.CREATED);
	}catch (Exception e){
	  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
  }

  @GetMapping("/categoryId/{id}")
  public ResponseEntity getNewsByCategoryId(@PathVariable Long id) {
	try {
	  List<News> news = newsService.findByCategoryId(id);
	  return new ResponseEntity<>(news, HttpStatus.OK);
	}catch (Exception e){
	  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
  }

}
