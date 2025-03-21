package com.example.NewsWebsite.repository;

import com.example.NewsWebsite.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {


}
