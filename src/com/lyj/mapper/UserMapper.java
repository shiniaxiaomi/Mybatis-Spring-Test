package com.lyj.mapper;

import com.lyj.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
  @Select("SELECT * FROM user WHERE id = #{id}")
  User getUser(int id);

  @Update("update user set name=#{name} where id = #{id}")
  Integer updateUser(@Param("name") String name,@Param("id") int id);
} 