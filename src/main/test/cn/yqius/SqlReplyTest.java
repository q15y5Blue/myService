package cn.yqius;

import cn.yqius.entity.Reply;
import cn.yqius.repository.ReplyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)//数据库配置
public class SqlReplyTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReplyRepository replyRepository;

//    @Test
//    public void testfindContentExists() {
//        Reply reply = new Reply();
//        entityManager.persist(reply);
//        Sort orderTime = new Sort(Sort.Direction.DESC,"date");
//        PageRequest page = PageRequest.of(0,10, orderTime);
//        List<Reply> replies = replyRepository.findRepliesByContentContaining("三生树",page);
//        System.out.println(replies);
//        for(Reply s:replies){
//            System.out.println(s.getContent());
//        }
//    }

    @Test
    public void testfindAllReplis(){
        Reply reply = new Reply();
        entityManager.persist(reply);
        Sort orderFloor = new Sort(Sort.Direction.ASC,"floorNumber");
        PageRequest page = PageRequest.of(0,20,orderFloor);
        Page<Reply> replyPage =replyRepository.getByArticleExists(5539801878L, page);
        replyPage.getContent().forEach(
            item-> System.out.println(item.getContent()+"\n"+item.getUser().getUsername())
        );
    }

}
