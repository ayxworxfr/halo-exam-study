package com.evildoer.exam.common.entity;

import com.evildoer.exam.common.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @author evildoer
 * @since 2021-01-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 所属部门编号
     */
    private Long deptId;

    /**
     * 角色类型(1:业务角色;2:管理角色 ;3:系统内置角色)
     */
    private Integer roleType;

    private Boolean enable;

    /**
     * 备注
     */
    private String remark;

    private Long createBy;

    private Long updateBy;


}
