package cn.yqius;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {
    @Autowired
    @Resource(name = "redisTemplate1")
    private RedisTemplate<Object,Object> redisTemplate1;

    @Autowired
    @Resource(name = "redisTemplate2")
    private RedisTemplate<Object,Object> redisTemplate2;

    @Test
    public void setValue(){
        redisTemplate1.boundValueOps("name").set("itcast");
    }

    @Test
    public void getValue(){
        Object qiuyu =redisTemplate1.getConnectionFactory();
        System.out.println("qiuyu:"+qiuyu);
        Object qiuyu2 =redisTemplate2.getConnectionFactory();
        System.out.println("qiuyu2"+qiuyu2);
        String str = (String) redisTemplate1.boundValueOps("name").get();
        System.out.println(str);
    }

    @Test
    public void deleteValue(){
        redisTemplate1.delete("name");
    }

}
