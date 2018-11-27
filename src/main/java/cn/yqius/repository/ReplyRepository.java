package cn.yqius.repository;

import cn.yqius.entity.Article;
import cn.yqius.entity.Reply;
import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "getReply", path = "getReply")
public interface ReplyRepository extends PagingAndSortingRepository<Reply,Long> {
    List<Reply> findRepliesByArticle(Article a);
}
