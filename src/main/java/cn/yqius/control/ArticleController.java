package cn.yqius.control;

import cn.yqius.entity.Article;
import cn.yqius.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping(path="/getPages")
    public @ResponseBody Iterable<Article> getArticlePage(){
        return articleRepository.findAll();
    }
}
