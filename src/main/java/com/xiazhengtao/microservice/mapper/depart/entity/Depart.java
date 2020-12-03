package com.xiazhengtao.microservice.mapper.depart.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-11-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Depart implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;


}
