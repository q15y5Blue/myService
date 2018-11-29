package cn.yqius.control;
import java.util.concurrent.atomic.AtomicLong;

//import cn.yqius.entity.Greeting;
import cn.yqius.entity.Article;
import cn.yqius.entity.Reply;
import cn.yqius.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/article/reply")
public class ReplyControl {

    @Autowired
    private ReplyRepository replyRepository;

    @GetMapping(path="/getReplies")
    public @ResponseBody
    Iterable<Reply> getArticlePageByArticle(
            @ModelAttribute("article") Long articleId){
        return replyRepository.findRepliesByArticle(articleId);
    }

}
