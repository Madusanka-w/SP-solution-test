package com.example.NewsWebsite.service;

import com.example.NewsWebsite.dto.NewsDto;
import com.example.NewsWebsite.model.Category;
import com.example.NewsWebsite.model.Comment;
import com.example.NewsWebsite.model.News;
import com.example.NewsWebsite.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class NewsService {

  @Autowired
  private NewsRepository newsRepository;

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private CommentService commentService;

  public News createNews(NewsDto newsDto){
	News newsEntity = new News();

	List<Category> categories = new ArrayList<>(); // Initialize outside the loop
	if (newsDto.getCategoryIds() != null && !newsDto.getCategoryIds().isEmpty()) {
	  for (Long categoryId : newsDto.getCategoryIds()) {
		Category category = categoryService.findCategoryById(categoryId);
		if (category != null) {
		  categories.add(category);
		}
	  }
	}

	newsEntity.setTitle(newsDto.getTitle());
	newsEntity.setDescription(newsDto.getDescription());
	newsEntity.setCategories(categories);

	return newsRepository.save(newsEntity);
  }


  public News updateNews(Long id, NewsDto news){
	News updatedNews = newsRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("News not found"));

	List<Category> categories = null;
	if(!news.getCategoryIds().isEmpty()) {
	  for(int i=0;i<news.getCategoryIds().size();i++){
		categories = updatedNews.getCategories();
		Category category = categoryService.findCategoryById(news.getCategoryIds().get(i));
		if(!categories.contains(category)){
		  categories.add(category);
		}
	  }
	}

	updatedNews.setTitle(news.getTitle());
	updatedNews.setDescription(news.getDescription());
	updatedNews.setCategories(categories);

	return newsRepository.save(updatedNews);

  }

  public News getNewsById(Long id){
	News news = newsRepository.findById(id).orElseThrow(() ->
		new RuntimeException("News not found"));

	return news;
  }

  public List<News> getAllNews(){
	return newsRepository.findAll();
  }

  public News addComment(Long newsId, Comment comment) {
	News news = newsRepository.findById(newsId)
		.orElseThrow(() -> new RuntimeException("News not found"));

	List<Comment> comments = news.getComments();
	Comment commentEntity = commentService.createComment(comment);
	comments.add(commentEntity);
	news.setComments(comments);
	return newsRepository.save(news);

  }

  public List<News> findByCategoryId(Long categoryId){
	List<News> newsList = newsRepository.findByCategories_Id(categoryId);
	return newsList;
  }


}
