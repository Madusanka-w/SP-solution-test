package com.example.NewsWebsite.service;

import com.example.NewsWebsite.model.Comment;
import com.example.NewsWebsite.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

  @Autowired
  private CommentRepository commentRepository;

  public Comment createComment(Comment comment) {
	return commentRepository.save(comment);
  }

  public void deleteComment(Long id) {
	commentRepository.deleteById(id);
  }

}
