package cn.bdqn.dao;

import cn.bdqn.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
   // @Select("select * from User")
    List<User> list();

    //@Insert("insert into User(username,password) values(#{username},#{password})")
    void add(@Param("username") String username, @Param("password") String password);

   // @Update("update User set username=#{username} where id=#{id}")
    void update(@Param("username") String username, @Param("id") Integer id);

   // @Delete("delete from User where id=#{id}")
    void delete(@Param("id") Integer id);

    public List<User>findlimit(@Param("currPageNo")Integer currPageNo,@Param("pageSize")Integer pageSize);
    public Integer findTotal();
}
