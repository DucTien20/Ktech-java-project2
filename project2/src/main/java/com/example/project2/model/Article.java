package com.example.project2.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private String writer;
    @Setter
    private  String password;
  @Setter

  @ManyToOne
  private Board board;

  @OneToMany(mappedBy = "article")
    private Set<Comment> comments;

    public Article() {}

    public Article(String title, String content, String writer, String password, Board board){
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password = password;
        this.board=board;
    }

}
