package net.blog.base.repository.dao;

import net.blog.base.entity.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by drsnkrt on 16.01.2018.
 */
public interface ICommentDao extends CrudRepository<Comment, Integer> {

    List<Comment> findCommentByArticleArticleId(int articleId);

    Comment findByCommentId(int id);

}

