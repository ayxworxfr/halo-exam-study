package com.evildoer.exam.common.entity;

import com.evildoer.exam.common.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * <p>
 * 用户管理
 * </p>
 *
 * @author evildoer
 * @datetime: 2021-01-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 登陆帐户
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型(1普通用户2管理员3系统用户)
     */
    private String userType;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 姓名拼音
     */
    private String namePinyin;

    /**
     * 性别(0:未知;1:男;2:女)
     */
    private Integer sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 微信
     */
    private String weiXin;

    /**
     * 微博
     */
    private String weiBo;

    /**
     * QQ
     */
    private String qq;

    /**
     * 出生日期
     */
    private LocalDate birthDay;

    /**
     * 部门编号
     */
    private Long deptId;

    /**
     * 职位
     */
    private String position;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 工号
     */
    private String staffNo;

    private Boolean enable;

    private String remark;

    private Long createBy;

    private Long updateBy;


}
