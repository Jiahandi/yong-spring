package com.xian.yong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xian.yong.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface UserMapper extends BaseMapper<User> {

//    @Select("select * from user")
//    List<User> findAll();
//
//    @Insert("insert into user(username,password,tel,email,avatar) Values (#{username}, #{password}," +
//            "#{tel}, #{email}), #{avatar};")
//    int insert(User user);
//
//
//    int update(User user);
//
//    @Delete("delete from user where id = #{id}")
//    Integer deleteById(@Param("id") Integer id);
//
//    @Select("select * from user where username like #{username} limit #{pageNum}, #{pageSize}")
//    List<User> selectPage(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize,@Param("username") String username);
//
//    @Select("select count(*) from user where username like #{username}")
//    Integer selectTotal(@Param("username") String username);
}
