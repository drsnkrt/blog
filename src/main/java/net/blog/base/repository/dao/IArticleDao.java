package net.blog.base.repository.dao;

import net.blog.base.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by drsnkrt on 16.01.2018.
 */
public interface IArticleDao extends JpaRepository<Article, Integer> {

    void deleteByArticleId(int articleId);

    List<Article> findAllByTitleContainingIgnoreCase(String title);

    List<Article> findAllByArticleContainingIgnoreCase(String article);

    Article findByArticleId(int articleId);

    List<Article> findAllByOrderByRecordDateAsc();

}
