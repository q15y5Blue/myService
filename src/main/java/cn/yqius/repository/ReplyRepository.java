package cn.yqius.repository;

import cn.yqius.entity.Article;
import cn.yqius.entity.Reply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface ReplyRepository extends PagingAndSortingRepository<Reply,Long> {

    @Query("select r from Reply r where r.article.id =?1")
    List<Reply> findRepliesByArticle(Long a);
}
