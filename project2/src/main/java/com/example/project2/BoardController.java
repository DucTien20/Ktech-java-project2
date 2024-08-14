package com.example.project2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("boards")
public class BoardController {
    private final BoardService service;
    private final ArticleService articleService;
    public BoardController(BoardService service, ArticleService articleService){
        this.service = service;
        this.articleService = articleService;
    }
    @GetMapping
    public String readAll(Model model) {
        model.addAttribute("boardList", service.readAll());
        model.addAttribute("articles", articleService.readAll());
        return "boards/home.html";
    }

    @GetMapping("{id}")
    public String readOne(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("boards", service.readBoard(id));
        return "boards/read.html";
    }
}
