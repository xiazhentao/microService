package com.xiazhengtao.microservice.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("zz_special_control_list")
public class SpecialControl implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type=IdType.AUTO)
    private Integer id;

    /**
     * 配置名称
     */
    private String configName;

    /**
     * 识别代码：用于服务端识别该配置的标识
     */
    private String recognitionCode;

    /**
     * 所属网点代码
     */
    private String orgCode;

    /**
     * 所属网点名称
     */
    private String orgName;

    /**
     * 描述
     */
    private String zDescribe;

    /**
     * 版本号
     */
    private Long versionNo;

    private LocalDateTime createTime;

    private LocalDateTime deleteTime;

    /**
     * 0：未删除  1：已删除
     */
    private String zStatus;

    private String blank1;

    private String blank2;

    private String blank3;

    private String blank4;

    private String blank5;

    private String blank6;

    private String blank7;

    private String blank8;

    private String blank9;


}
