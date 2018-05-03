package net.blog.base.controller;

import net.blog.base.entity.Article;
import net.blog.base.entity.Comment;
import net.blog.base.repository.service.ArticleService;
import net.blog.base.repository.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by drsnkrt on 16.01.2018.
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @GetMapping(value = "/allarticles")
    public Iterable<Article> getAll() {
        return service.getAll();
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody final Article article) {
        service.saveOrUpdate(article);
    }

    @RequestMapping("/search/article")
    public List<Article> findAllByArticle(@RequestParam(value = "a") String article) {
        return service.searchByArticle(article);
    }

    @RequestMapping("/search/title")
    public List<Article> findAllByTitle(@RequestParam(value = "t") String title) {
        return service.findAllByTitleLike(title);
    }

    @DeleteMapping(value = "/{id}")
    public void delById(@PathVariable("id") final int id) {
        service.delById(id);
    }

    @GetMapping(value = "/{id}")
    public Article getById(@PathVariable final int id) {
        return service.getById(id);
    }


    //comments
    @Autowired
    CommentService commentService;

    @GetMapping(value = "/{articleId}/comments")
    public List<Comment> getAllComments(@PathVariable int articleId) {
        return commentService.getAllComments(articleId);
    }

    @GetMapping(value = "/{articleId}/comments/{commentId}")
    public Comment getCommentById(@PathVariable int commentId) {
        return commentService.getCommentById(commentId);
    }

//    @PostMapping(value = "{articleId}/comments")
//    public void saveComment(@RequestBody Comment comment, @PathVariable int articleId) {
//        comment.setArticle(new Article(articleId, "", "", "", new Date(), 1));
//        commentService.saveComment(comment);
//    }

}