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


    @Autowired
    private ReplyRepository replyRepository;

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
        PageRequest page = PageRequest.of(pageNo,10,orderFloor);
        Page<Reply> replyPage =replyRepository.getByArticleExists(articleId, page);
        System.out.println(replyPage);
        return replyPage;
    }

    @GetMapping(path = "/getReplyChild")
    public @ResponseBody Iterable<Reply> getReplyChild(
            @RequestParam(defaultValue = "0") Integer pageNo){
        return null;
}
}
