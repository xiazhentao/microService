package com.xiazhengtao.microservice.controller;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.xiazhengtao.microservice.domain.SpecialControl;
import com.xiazhengtao.microservice.moudles.Response;
import com.xiazhengtao.microservice.service.SpecialControlListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-12-03
 */
@RestController
@RequestMapping("/specialControl")
public class SpecialControlListController {

    @Autowired
    private SpecialControlListService specialControlListService;

    @GetMapping("readExcelSaveBatch/{fileName}")
    public Response addBatch(@PathVariable("fileName") String fileName) {
        ExcelReader reader = ExcelUtil.getReader("/Users/xiazhengtao/文件/testExcel.xls");
        List<SpecialControl> specialControls = reader.readAll(SpecialControl.class);
        return this.specialControlListService.add(specialControls);
    }
}
