package cn.yqius.control;
import java.util.concurrent.atomic.AtomicLong;

import cn.yqius.entity.Reply;
import cn.yqius.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/article/reply")
public class ReplyControl {

    //final只会在程序启动的时候初始化一次，并且在程序运行的时候不会再改变
    private final ReplyRepository replyRepository;

    //推荐对构造函数进行注解
    @Autowired
    public ReplyControl(ReplyRepository replyRepository){
        this.replyRepository = replyRepository;
    }

    //get Page info
    @GetMapping(path="/getReply")
    public String getReply(@ModelAttribute("article") Long articleID, Model model){
        model.addAttribute("articleId", articleID);
        model.addAttribute("replyNumber", replyRepository.countByArticle(articleID));
        model.addAttribute("replyNumber",0);
        model.addAttribute("replyObj",replyRepository.getFirstReply(articleID));
        return "reply";
    }

    //req
    @GetMapping(path="/getReplys")
    public @ResponseBody Iterable<Reply> getReplies(
            @RequestParam(defaultValue = "-1") Long articleId,
            @RequestParam(defaultValue="0") Integer pageNo){
        //floorNumber
        Sort orderFloor = new Sort(Sort.Direction.ASC,"floorNumber");
        PageRequest page = PageRequest.of(pageNo,20,orderFloor);
        Page<Reply> replyPage =replyRepository.getByArticleExists(articleId, page);
        return replyPage;
    }

}
