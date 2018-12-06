package cn.yqius.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="ReplyLzz")
public class ReplyLzz {

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

    @ManyToOne
    private Reply reply;

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
