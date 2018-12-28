package cn.yqius.repository;

import cn.yqius.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

// 🐑🐑🐑🐑🐑🐑🐑 🐑🐑🐑🐑🐑🐑🐑 🐑🐑🐑🐑🐑🐑🐑 🐑🐑🐑🐑🐑🐑🐑 🐑🐑🐑🐑🐑🐑🐑 🐑🐑🐑🐑🐑🐑🐑
public interface ReplyRepository extends JpaRepository<Reply,Long> {

    @Query("select count(*) as floors from Reply r where  r.article.id = ?1")
    Integer countByArticle(Long a);

    @Query("select r from Reply r where r.article.id = :articleId and r.floorNumber=1 ")
    Reply getFirstReply(@Param("articleId") Long id);

    //-1是楼中楼 1是主楼 查询非主楼、非楼中楼的回复 ,
    @Query("select r from Reply r where r.article.id = :articleId and r.floorNumber not in ('-1','1') ")
    Page<Reply> getByArticleExists(@Param("articleId") Long articleId, Pageable page);

}
