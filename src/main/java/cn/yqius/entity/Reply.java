package cn.yqius.entity;

import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="reply")
public class Reply implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "content",length = 6000)
    private String content;

    @Column(length = 60)
    private String author;

    @Column
    private Date date;

    @Column(name = "floor_num", length = 15)
    private Integer floorNumber;

    @Column(name="fn",length = 128)
    private Long parentId;

    @ManyToOne()
    @JoinColumn(name="article_id")
    private Article article;

    @OneToMany(mappedBy = "reply", fetch = FetchType.LAZY)
    private Set<ReplyLzz> lzlReply =new HashSet<ReplyLzz>();



//    @Transient
//    private Page<Reply> children;

    public Reply() {
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reply)) return false;
        Reply reply = (Reply) o;
        return Objects.equals(id, reply.id) &&
                Objects.equals(article, reply.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, article);
    }
}
