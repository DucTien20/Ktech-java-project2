package com.example.project2.repo;

import com.example.project2.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository
 extends JpaRepository<Comment, Long> {
}
