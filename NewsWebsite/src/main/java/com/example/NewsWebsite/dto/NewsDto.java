package com.example.NewsWebsite.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class NewsDto {

  private Long id;

  private String title;

  private String description;

  private List<Long> categoryIds = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Long> getCategoryIds() {
    return categoryIds;
  }

  public void setCategoryIds(List<Long> categoryIds) {
    this.categoryIds = categoryIds;
  }
}
