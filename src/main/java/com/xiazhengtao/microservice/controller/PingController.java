package com.xiazhengtao.microservice.controller;

import com.xiazhengtao.microservice.moudles.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiazhengtao
 * @packageName com.xiazhengtao.microservice.controller
 * @date 2020-11-25 20:40
 */
@RestController
public class PingController {

    @RequestMapping(method = RequestMethod.GET)
    public Response ping(){
        Response<Object> response = new Response<>();
        response.setData(System.currentTimeMillis());
        return response;
    }
}
