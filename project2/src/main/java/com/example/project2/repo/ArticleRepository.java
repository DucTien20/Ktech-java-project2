package com.example.project2.repo;

import com.example.project2.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository
extends JpaRepository<Article, Long> {
List<Article> findByBoardId(Long boardId);
}
