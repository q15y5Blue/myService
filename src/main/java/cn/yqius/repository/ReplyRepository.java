package cn.yqius.repository;

import cn.yqius.entity.Article;
import cn.yqius.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends PagingAndSortingRepository<Reply,Long> {

//    @Query("select r from Reply r where r.article.id =?1")
    @Query("select count(*) as floors from Reply r where  r.article.id = ?1")
    Integer countByArticle(Long a);

    @Query("select r from Reply r where r.article.id = :articleId ")
    Page<Reply> findAllById(@Param("articleId") Long id , Pageable pageable);

    @Query("select r from Reply r where r.article.id = :articleId and r.floorNumber=1")
    Reply getFirstReply(@Param("articleId") Long id);

    //-1 是楼中楼 1是主楼
    @Query("select r from Reply r where r.article.id = :articleId and r.floorNumber not in ('-1','1')")
    Page<Reply> getAllByArticleExists(@Param("articleId") Long articleId, Pageable page);

    @Query("select r from Reply r where r.parentId = :replyId order by r.date ")
    Page<Reply> getThreeChildrenRs(@Param("replyId") Long replyId, Pageable pageable);

    @Query("select r from Reply r where r.parentId = :replyId and r.floorNumber =-1 order by r.date")
    Page<Reply> getChildOfReply(@Param("replyId") Long replyId,Pageable pageable);

}
