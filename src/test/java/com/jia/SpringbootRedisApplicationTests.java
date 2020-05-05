package com.jia;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jia.pojo.User;
import com.jia.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
class SpringbootRedisApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
        // 操作字符串 类似String类型
        redisTemplate.opsForValue().set("myjcx","贾垂讯666");
        System.out.println(redisTemplate.opsForValue().get("myjcx"));
    }

    @Test
    public void test() throws JsonProcessingException {
        User user = new User("贾垂讯",18);
        // String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    public void test02() {
        redisUtil.set("name","阿讯");
        redisUtil.set("age","21");
        System.out.println(redisUtil.get("name"));
    }

}
