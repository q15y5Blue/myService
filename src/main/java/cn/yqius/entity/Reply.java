package cn.yqius.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

//@NamedEntityGraph注解的name是类中的属性名称 非自定义名称
@Entity
@Table(name="reply")
@NamedEntityGraph(name="graph.repliesAll",
        attributeNodes={@NamedAttributeNode("user"), @NamedAttributeNode("article"),@NamedAttributeNode(value="lzlReply",subgraph = "lzlSub")},
        subgraphs = {@NamedSubgraph(name="lzlSub",attributeNodes = {@NamedAttributeNode("user") })})
public class Reply implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id =0L;

    @Column(name = "content",length = 6000)
    private String content = "";

    @Column(length = 60)
    private String author = "";

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;

    @Column(name = "floor_num", length = 15)
    private Integer floorNumber = 0;

    @Column(name="fn",length = 128)
    private Long parentId = 0L;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="article_id")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="authorId")
    private Users user;

    @OneToMany(mappedBy = "reply", orphanRemoval=true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<ReplyLzz> lzlReply ;

    public Set<ReplyLzz> getLzlReply() {
        return lzlReply;
    }

    public void setLzlReply(Set<ReplyLzz> lzlReply) {
        this.lzlReply = lzlReply;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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
