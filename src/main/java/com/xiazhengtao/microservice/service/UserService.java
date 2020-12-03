package com.xiazhengtao.microservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiazhengtao.microservice.domain.User;
import com.xiazhengtao.microservice.moudles.Response;

/**
 * @author xiazhengtao
 * @packageName com.xiazhengtao.microservice.service
 * @date 2020-11-25 20:19
 */
public interface UserService  extends IService<User> {

    Response add(User user);

    Response getAll();

    Response getUserByAge(User user);
}
