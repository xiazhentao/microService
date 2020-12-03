package com.xiazhengtao.microservice.moudles;

import lombok.Data;

/**
 * @author xiazhengtao
 * @packageName com.xiazhengtao.microservice.moudles
 * @date 2020-11-25 20:24
 */
@Data
public class Response<T> {
    private Integer code = 200;

    private Boolean result;

    private T data;

    private String msg;
}
