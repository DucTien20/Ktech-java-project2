package com.example.project2;


import com.example.project2.model.Article;
import com.example.project2.repo.ArticleRepository;
import com.example.project2.repo.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository repository;
    private final BoardRepository boardRepo;
    public ArticleService(ArticleRepository repository,
                          BoardRepository boardRepo
    ){
        this.repository = repository;
        this.boardRepo = boardRepo;
    }
    //CREATE
    public Article create(
            Long boardId,
            String title,
            String content,
            String writer,
            String password
    ){
        Article article = new Article(
                title,
                content,
                writer,
                password, boardRepo.findById(boardId).orElseThrow()
        );
        return repository.save(article);
    }
    public List<Article> readAll (){
        return repository.findAll();
    }

    public Article readOne(Long id){
        return repository.findById(id).orElse(null);
    }

    //update
    public Article update(
            Long id,
            String title,
            String content,
            String writer

    ){
        Optional<Article> optionalTarget = repository.findById(id);
        if(optionalTarget.isEmpty()){
            return null;
        }
        Article target = optionalTarget.get();
        target.setTitle(title);
        target.setContent(content);
        target.setWriter(writer);
        return repository.save(target);
    }


    //delete
    public void delete (Long id, String password) {
        if(password.equals(repository.findById(id).get().getPassword())) {
            repository.deleteById(id);
        }
    }

    public void delete(Long id) {
    }
}
