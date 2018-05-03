package net.blog.base.repository.service;

import net.blog.base.entity.Article;
import net.blog.base.entity.Comment;
import net.blog.base.repository.dao.ICommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by drsnkrt on 16.01.2018.
 */
@Service
public class CommentService {

    @Autowired
    private ICommentDao dao;

    public List<Comment> getAllComments(int id) {
        List<Comment> comments = new ArrayList<>();
        dao.findCommentByArticleArticleId(id).forEach(comments::add);
        return comments;
    }

    public void saveComment(Comment comment, Article article) {
        comment.setArticle(article);
        dao.save(comment);
    }

    public Comment getCommentById(int id) {
        return dao.findByCommentId(id);
    }

}
