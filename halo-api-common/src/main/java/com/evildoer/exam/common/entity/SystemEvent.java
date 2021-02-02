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
public class SystemEvent extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String userName;

    private String userPhone;

    private String title;

    private String requestUri;

    private String parameters;

    private String method;

    private String clientHost;

    private String userAgent;

    private Integer status;

    private Boolean enable;

    private String remark;

    private Long createBy;

    private Long updateBy;


}
