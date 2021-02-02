package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectUser(){
        User user=userMapper.selectById(101);
        System.out.println(user);
        user=userMapper.selectByName("liubei");
        System.out.println(user);
        user=userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);


    }

    @Test
    public void testInsertUser(){
        User user=new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("123@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());
        int rows=userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void  updateUser(){
        int rows=userMapper.updateStatus(150,1);
        System.out.println(rows);
        rows=userMapper.updateHeader(150,"http://www.nowcoder.com/102.png");
        System.out.println(rows);
        rows=userMapper.updatePassword(150,"333333");
        System.out.println(rows);
    }

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void TestSelectPosts(){
        List<DiscussPost> list=discussPostMapper.selectDiscussPost(149,0,10);
        for(DiscussPost post:list){
            System.out.println(post);
        }

        int rows=discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }

    private static final Logger logger= LoggerFactory.getLogger(MapperTests.class);

    @Test
    public void testLogger(){
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }


}
