package net.blog.base.entity;

import net.blog.base.enums.Status;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by drsnkrt on 15.01.2018.
 */
@Entity
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private int commentId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "image_uri")
    private String imageUri;

    @Column(name = "record_status_id")
    private int recordStatusId;

    @ManyToOne
    private Article article;

    public Comment(int commentId, String comment, String imageUri, int recordStatusId, int articleID) {
        super();
        this.commentId = commentId;
        this.comment = comment;
        this.imageUri = imageUri;
        this.recordStatusId = recordStatusId;
        this.article = new Article(articleID, "", "", "", new Date(), Status.Pasif);
    }


    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Comment() {
    }


    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public int getRecordStatusId() {
        return recordStatusId;
    }

    public void setRecordStatusId(int recordStatusId) {
        this.recordStatusId = recordStatusId;
    }

}

