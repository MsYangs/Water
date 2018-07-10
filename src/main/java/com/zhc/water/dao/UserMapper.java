package com.zhc.water.dao;

import com.zhc.water.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> selectUser(User user);
}
