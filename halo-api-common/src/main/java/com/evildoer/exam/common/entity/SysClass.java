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
 * @datetime: 2021-01-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysClass extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 班级名称
     */
    private String name;

    private Long gradeId;


}
