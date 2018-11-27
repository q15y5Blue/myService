package cn.yqius.repository;

import cn.yqius.entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "article", path = "getArticles") //PagingAndSortingRepository
public interface ArticleRepository extends PagingAndSortingRepository<Article,Long> {

}
