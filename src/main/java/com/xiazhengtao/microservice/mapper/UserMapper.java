package com.xiazhengtao.microservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiazhengtao.microservice.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiazhengtao
 * @packageName com.xiazhengtao.microservice.mapper
 * @date 2020-11-25 20:21
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> getUserByAddr(@Param("age") int age);

}
