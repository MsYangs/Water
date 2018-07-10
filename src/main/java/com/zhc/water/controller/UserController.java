package com.zhc.water.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhc.water.common.persistence.Page;
import com.zhc.water.common.persistence.PageVo;
import com.zhc.water.model.User;
import com.zhc.water.service.UserService;
import com.zhc.water.common.utils.HttpEntity;
import com.zhc.water.common.utils.HttpStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("user")
@Api(tags = {"用户操作接口"}, description = "UserControler")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;
    /*@ApiOperation(value = "查询用户", notes = "根据用户编码查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "User", value = "用户", required = true,
                    dataType = "User", paramType = "query")
    })
    @PostMapping("getUserByUserCode")
    public HttpEntity getUserByUserCode(@RequestBody User user){
        try{
            if(user != null && !StringUtils.isEmpty(user.getUserCode())){
                List<User> userList = userService.selectUser(user);
                return new HttpEntity(HttpStatus.OK,true,"请求成功",userList);
            }
            return new HttpEntity(HttpStatus.OK,true,"找不到数据","");
        }catch (Exception e){
            return new HttpEntity(HttpStatus.OK,false,e.getMessage(),"");
        }
    }*/


    @ApiOperation(value = "查询用户", notes = "用户数据分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "getUser", value = "分页参数与用户条件", required = true,
                    dataType = "Page", paramType = "query")
    })
    @PostMapping("getUser")
    public HttpEntity getUser(@RequestBody PageVo<User> pageVo){
        LOG.debug("入参为:{}"+pageVo.getEntity());
        try{
            User user = pageVo.getEntity();
            PageInfo pageInfo = userService.selectUser( pageVo.getPageNo(),pageVo.getPageSize(),user);
            return new HttpEntity(HttpStatus.OK,true,"请求成功",pageInfo);
        }catch (Exception e){
            return new HttpEntity(HttpStatus.OK,false,e.getMessage(),"");
        }
    }
}
