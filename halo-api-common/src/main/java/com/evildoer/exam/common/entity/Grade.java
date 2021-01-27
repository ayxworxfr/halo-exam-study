package com.evildoer.exam.common.entity;

import com.evildoer.exam.common.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author evildoer
 * @since 2021-01-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Grade extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 年级名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;


}
