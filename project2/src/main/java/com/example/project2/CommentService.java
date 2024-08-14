package com.example.project2;

import com.example.project2.model.Article;
import com.example.project2.model.Comment;
import com.example.project2.repo.ArticleRepository;
import com.example.project2.repo.CommentRepository;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final ArticleRepository articleRepo;
    private final CommentRepository commentRepo;
    public CommentService(
            ArticleRepository articleRepo,
            CommentRepository commentRepo
    ){
        this.articleRepo = articleRepo;
        this.commentRepo = commentRepo;
    }
    public Comment create(
            Long articleId,
            String content,
            String writer
    ){
        Article article = articleRepo.findById(articleId).orElseThrow();

        Comment comment = new Comment(
                content,
                writer,
                article
        );
        return commentRepo.save(comment);
    }

    @ManyToOne
    public Article article;



    public Comment readOne (
            Long articleId,
            Long commentId
    ){
        Comment comment = commentRepo.findById(commentId).orElseThrow();
        if(!comment.getArticle().getId().equals(articleId))
            throw new RuntimeException();

        return  comment;
    }
}
