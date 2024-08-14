package com.example.project2.repo;

import com.example.project2.model.Article;
import com.example.project2.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends
        JpaRepository<Board, Long> {

}
