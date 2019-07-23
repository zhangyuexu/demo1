package com.zyx.mapper;

import com.zyx.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 访问数据库接口
 */
public interface UserMapper {

    //使用#{}，不使用${}，因为$是字符串拼接的，很容易造成sql注入；而#是经过mybatis预编译的，相当于?占位符
    @Insert("INSERT INTO USER(name,phone,create_time,age)VALUES(#{name},#{phone},#{createTime},#{age})")
    //保存对象，获取数据库自增id;keyProperty代表程序中的id，keyColumn代表数据库的字段
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")//插入数据库，生成自增主键后，它会映射到User对象里去，即keyProperty
    int insert(User user);


    @Select("select * from user")
    @Results({
            //当数据库字段名与实体类对应的属性名不一致时，可以使用@Results映射来将其对应起来。column为数据库字段名，porperty为实体类属性名，jdbcType为数据库字段数据类型，id为是否为主键。
            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "name",property = "name")
    })
    List<User> getAll();


    @Select("select * from user where id = #{id}")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    User findById(Long id);


    @Update("update user set name = #{name} where id = #{id}")
    int update(User user);


    @Delete("delete from user where id = #{userId}")
    int delete(Long userId);

}
