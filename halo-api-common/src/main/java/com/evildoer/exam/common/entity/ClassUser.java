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
public class ClassUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 年级id
     */
    private Long gradeId;

    /**
     * 用户id(根据用户身份来判断是老师还是学生)
     */
    private String userId;

    private String classId;

    /**
     * 值为1时，表示该用户为班主任(默认班级创建者为班主任)
     */
    private Integer status;


}
