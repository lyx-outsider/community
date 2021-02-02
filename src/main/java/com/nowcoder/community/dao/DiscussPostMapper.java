package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPost(int userId,int offset,int limit);
    //如果需要动态的拼一个条件，并且这个方法有且只有一个参数，则这个参数之前必须取别名
    //如果只有一个参数，并且在<if>里使用，则必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);//@Param("userId")用于给参数取别名



}
