package com.xiazhengtao.microservice.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiazhengtao.microservice.domain.SpecialControl;
import com.xiazhengtao.microservice.mapper.SpecialControlListMapper;
import com.xiazhengtao.microservice.moudles.Response;
import com.xiazhengtao.microservice.service.SpecialControlListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xiazhengtao
 * @since 2020-12-03
 */
@Service
@DS("master")
@Slf4j
@Transactional
public class SpecialControlListServiceImpl extends ServiceImpl<SpecialControlListMapper, SpecialControl> implements SpecialControlListService {

    @Autowired
    SpecialControlListMapper specialControlListMapper;

    @Override
    public Response add(List<SpecialControl> specialControls) {
        Response<Object> response = new Response<>();
        if (CollectionUtils.isEmpty(specialControls)) {
            response.setCode(400);
            response.setMsg("请求参数不能为空！");
            response.setResult(false);
            return response;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        specialControls.stream().forEach( specialControl -> {
            specialControl.setCreateTime(LocalDateTime.now());
            specialControl.setVersionNo(System.currentTimeMillis());
            specialControl.setZDescribe(specialControl.getZDescribe());
            specialControl.setZStatus("0");
            if (this.save(specialControl)) {
                log.info("插入数据库成功,记录{}条数据{}",atomicInteger.getAndIncrement(), JSONUtil.toJsonStr(specialControl));
            }
        });
        if (atomicInteger.get()==specialControls.size()) {
            response.setResult(true);
        } else {
            response.setCode(500);
            response.setMsg("请求参数不能为空！");
            response.setResult(false);
        }
        return response;
    }
}
