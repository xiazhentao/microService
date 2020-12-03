package com.xiazhengtao.microservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiazhengtao.microservice.domain.SpecialControl;
import com.xiazhengtao.microservice.moudles.Response;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-12-03
 */
public interface SpecialControlListService extends IService<SpecialControl> {

    Response add(List<SpecialControl> specialControls);

}
