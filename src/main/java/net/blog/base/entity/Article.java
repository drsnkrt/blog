package net.blog.base.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by drsnkrt on 15.01.2018.
 */
@Entity
@Table(name = "t_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "article_id")
    private int articleId;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "article")
    private String article;

    @Column(name = "image_uri")
    private String imageUri;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "record_date")
    private Date recordDate;

    @Column(name = "record_status_id")
    private int recordStatusId;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "article_id", referencedColumnName = "article_id")
//    private List<Comment> comments;

    public Article(int articleId, String title, String article, String imageUri, Date recordDate, int recordStatusId) {
        super();
        this.articleId = articleId;
        this.title = title;
        this.article = article;
        this.imageUri = imageUri;
        this.recordDate = recordDate;
        this.recordStatusId = recordStatusId;
    }

    public Article() {
    }

//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Comment> comments) {
//        this.comments = comments;
//    }

    public int getRecordStatusId() {
        return recordStatusId;
    }

    public void setRecordStatusId(int recordStatusId) {
        this.recordStatusId = recordStatusId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {


        this.recordDate = recordDate;
    }

}
