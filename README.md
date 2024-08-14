# Ktech-java-project2

완성된 기능:
  ## 필수 과제

- 게시판 관련 기능
- 게시글 관련 기능
- 댓글 관련 기능
# 진행과정
-  Article, Comment, Board model 만든다
-  Repository interface 만든다
-  각 service class 만든다
-  service control 위한 @Controller class 만든후 각 객체 관계를 link 한다
  + Article to board
     @ManyToOne
     private Board board;
  + article to Comment
      @OneToMany(mappedBy = "article")
      private Set<Comment> comments;
  + Board to Article
       @OneToMany(mappedBy = "board")
      private List<Article> articles;

ArticleController 에서 GET로 create 화면 들어와에 POST methor로 정보를 업력한다

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
+ update and delete search by id of article
      @PostMapping("{id}/update")
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
  
   


