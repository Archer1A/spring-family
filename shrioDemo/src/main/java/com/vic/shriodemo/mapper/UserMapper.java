package com.vic.shriodemo.mapper;

import com.vic.shriodemo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * UserMapper
 *
 * @author Vic
 * @date 2019/5/15
 */
@Mapper
public interface UserMapper {

    @Select("Select * from sys_user where user_name = #{userName}")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "fullName",column = "full_name")}
            )
    UserInfo findUserByUserName(String userName);
}
