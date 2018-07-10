package com.zhc.water.service;
import com.github.pagehelper.PageInfo;
import com.zhc.water.common.persistence.PageVo;
import com.zhc.water.model.User;

import java.util.List;

public interface UserService {
    PageInfo<User> selectUser(Integer page,Integer size,User user);
}
