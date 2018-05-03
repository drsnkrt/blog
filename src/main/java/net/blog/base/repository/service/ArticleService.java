package net.blog.base.repository.service;

import net.blog.base.entity.Article;
import net.blog.base.repository.dao.IArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by drsnkrt on 16.01.2018.
 */
@Service
public class ArticleService {

    @Autowired
    private IArticleDao dao;

    public Iterable<Article> getAll() {
        return dao.findAll();
    }

    public List<Article> findAll() {

        return (List<Article>) dao.findAll();
    }

    public Iterable<Article> getAllDesc() {
        return dao.findAllByOrderByRecordDateAsc();
    }

    public void delById(int articleId) {
        dao.deleteByArticleId(articleId);
    }

    public Article getById(int articleId) {
        return dao.findByArticleId(articleId);
    }

    //special methods
    public List<Article> findAllByTitleLike(String title) {
        return dao.findAllByTitleContainingIgnoreCase(title);
    }

    public List<Article> searchByArticle(String article) {
        return dao.findAllByArticleContainingIgnoreCase(article);
    }

    public void saveOrUpdate(Article article) {
        dao.save(article);
    }

}
