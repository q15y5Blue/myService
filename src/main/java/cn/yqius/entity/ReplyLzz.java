package cn.yqius.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="ReplyLzz")
public class ReplyLzz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "content", length = 6000)
    private String content;

    @Column(length = 60)
    private String author;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;

    @Column(name = "floor_num", length = 15)
    private Integer floorNumber;

    //articleId
    @Column(name="article_id",length = 128)
    private Long articleId;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="fn")
    private Reply reply;

    @ManyToOne()
    @JoinColumn(name="userId")
    private Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    public ReplyLzz() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReplyLzz)) return false;
        ReplyLzz replyLzz = (ReplyLzz) o;
        return Objects.equals(id, replyLzz.id) &&
                Objects.equals(content, replyLzz.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }
}
