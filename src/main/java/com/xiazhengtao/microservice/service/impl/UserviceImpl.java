package com.xiazhengtao.microservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiazhengtao.microservice.domain.User;
import com.xiazhengtao.microservice.mapper.UserMapper;
import com.xiazhengtao.microservice.moudles.Response;
import com.xiazhengtao.microservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author xiazhengtao
 * @packageName com.xiazhengtao.microservice.service.impl
 * @date 2020-11-25 20:20
 */
@Service
@Slf4j
//@DS("master")
public class UserviceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Response add(User user) {
        final Response<Object> response = new Response<>();
        final int insert =  this.baseMapper.insert(user);
        Predicate<Integer> pre = integer -> integer.equals(1);
        if (pre.test(insert)) {
            response.setMsg("操作成功");
            response.setResult(true);
        } else {
            response.setCode(300);
            response.setMsg("操作失败");
            response.setResult(false);
        }
        return response;
    }

    @Override
    public Response getAll() {
        final Response<List<User>> response = new Response<>();
        final List<User> users =  this.baseMapper.selectList(null);
        response.setData(users);
        return response;
    }

    @Override
    public Response getUserByAge(User user) {
        Response<List<User>> response = new Response<>();
        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper();
        userQueryWrapper.eq(User::getAge, 23)
                .eq(User::getAddress,"清河县");
        final List<User> users =  this.baseMapper.selectList(userQueryWrapper);
        if (CollectionUtils.isEmpty(users)) {
            response.setCode(300);
            response.setResult(false);
            response.setMsg("查询无结果");
        } else {
            response.setData(users);
        }
        return response;
    }

}
