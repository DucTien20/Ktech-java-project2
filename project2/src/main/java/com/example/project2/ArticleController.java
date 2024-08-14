package com.example.project2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("articles")
public class ArticleController {
    private final ArticleService service;
    private final BoardService boardService;
    public ArticleController(
            ArticleService service, BoardService boardService
            ){
        this.service = service;
        this.boardService = boardService;
    }


    @GetMapping("create")
    public String createView(
            Model model
    ){
        model.addAttribute("boardList", boardService.readAll());
        return "articles/create.html";
    }
    @PostMapping("create")
    public String create(
            @RequestParam("board-id")
            Long boardId,
            @RequestParam("title")
            String title,
            @RequestParam("content")
            String content,
            @RequestParam("writer")
            String writer,
            @RequestParam("password")
            String password

    ){
        Long id = service.create(boardId, title, content, writer, password).getId();
        return String.format("redirect:/articles/%d", id);
    }





    @GetMapping
    public String readAll(Model model){
        model.addAttribute("articles",service.readAll());
        return "articles/home.html";
    }
    @GetMapping("{id}")
    public String readOne(
            @PathVariable("id")
            Long id,
            Model model
    ){
        model.addAttribute("article", service.readOne(id));
        return "articles/read.html";
    }

    @GetMapping("{id}/update")
    public String updateView(
            @PathVariable("id")
            Long id,
            Model model
    ){
        model.addAttribute("article", service.readOne(id));
        return "articles/update.html";
    }
    @PostMapping("{id}/update")
    public String update(
            @PathVariable("id")
            Long id,
            @RequestParam("title")
            String title,
            @RequestParam("content")
            String content,
            @RequestParam("writer")
            String writer
    ){
        service.update(id, title, content, writer);
        return String.format("redirect:/articles/%d", id);
    }
    @PostMapping("{id}/delete")
    public String delete(
            @PathVariable("id")
            Long id,
            @RequestParam("password")
            String password
    ){
        service.delete(id, password);
        return "redirect:/articles";
    }
}
