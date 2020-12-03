package com.xiazhengtao.microservice.controller;

import com.xiazhengtao.microservice.domain.User;
import com.xiazhengtao.microservice.moudles.Response;
import com.xiazhengtao.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiazhengtao
 * @packageName com.xiazhengtao.microservice.controller
 * @date 2020-11-25 20:15
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Response insert(@RequestBody User user) {
        return userService.add(user);
    }

    @PostMapping("/saveBatch")
    public Response saveBatch(@RequestBody List<User> userList) {
        Response<Object> response = new Response<>();
        if (userService.saveBatch(userList,userList.size())) {
            response.setResult(true);
            response.setMsg("操作成功");
        } else {
            response.setCode(500);
            response.setResult(false);
            response.setMsg("操作失败");
        }
        return response;
    }

    @PutMapping("getAll")
    public Response selectAll() {
        return userService.getAll();
    }

    @PostMapping("getUserByAge")
    public Response getUserByAge(@RequestBody User user) {
        return userService.getUserByAge(user);
    }


}
