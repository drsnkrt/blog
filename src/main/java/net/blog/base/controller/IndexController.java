package net.blog.base.controller;

import net.blog.base.entity.Comment;
import net.blog.base.repository.service.ArticleService;
import net.blog.base.repository.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    private ArticleService service;

    @Autowired
    CommentService commentService;

    @GetMapping("/")
    public String showIndexPage(Model model) {
        model.addAttribute("articles", service.getAll());
        model.addAttribute("articlesdesc", service.getAllDesc());
        return "index";
    }

    @GetMapping("/search")
    public String listUsers(Model model, @RequestParam(defaultValue = "") String title) {
        model.addAttribute("articles", service.findAllByTitleLike(title));
        return "search";
    }

    @GetMapping("/fragments/latest")
    public String binder(Model model) {
        model.addAttribute("articlesdesc", service.getAllDesc());
        return "fragments/latest";
    }


    @GetMapping("/{id}")
    public String showDetailPage(@PathVariable Integer id, Model model) {
        model.addAttribute("article", service.getById(id));
//        model.addAttribute("comments", commentService.getAllComments(id));
        return "detail";
    }

    @PostMapping("/addcomment")
    public String addTask(@RequestParam(value = "articleId") String articleId, @RequestParam(value = "cmt") String cmt, @RequestParam(value = "imageUri") String imageUri, @RequestParam(value = "recordStatusId") String recordStatusId) {

        Comment comment= new Comment();
        comment.setRecordStatusId(Integer.parseInt(recordStatusId));
        comment.setImageUri(imageUri);
        comment.setComment(cmt);
        commentService.saveComment(comment, service.getById(Integer.parseInt(articleId)));
        return "redirect:/";
    }


    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }

    @GetMapping("/contact")
    public String showContactPage() {
        return "contact";
    }

    @GetMapping("/gallery")
    public String showGalleryPage() {

        return "gallery";
    }

}
