package cn.yqius.control;

import cn.yqius.entity.Reply;
import cn.yqius.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Entity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * select r.*  from reply r   where r.content is not null and r.content != '' and
 * r.content regexp "[0-9]+明镜高悬"
 * order by r.date desc
 * limit 500
 */

@Controller
@RequestMapping(path = "/faq")
public class FAQController {


    private final ReplyRepository replyRepository;

    @Autowired
    public FAQController(ReplyRepository replyRepository){
        this.replyRepository = replyRepository;
    }

    @GetMapping(path="/getAnswers")
    public @ResponseBody
    List<Reply> getAnswers(@RequestParam(defaultValue="error") String quest){
        //中文参数 遇到中文乱码问题已解决
        Sort orderTime = new Sort(Sort.Direction.DESC,"date");
        PageRequest page = PageRequest.of(0,10, orderTime);
        return replyRepository.findRepliesByContentContaining(quest,page);
    }
}
