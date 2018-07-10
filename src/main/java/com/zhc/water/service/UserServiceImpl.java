package com.zhc.water.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhc.water.common.persistence.PageVo;
import com.zhc.water.dao.UserMapper;
import com.zhc.water.model.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;

    public PageInfo<User> selectUser(Integer page,Integer size,User user) {
        //开启分页查询，写在查询语句上方
        //只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页。
        PageHelper.startPage(page, size);
        List<User> userList = userMapper.selectUser(user);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;

    }
}
