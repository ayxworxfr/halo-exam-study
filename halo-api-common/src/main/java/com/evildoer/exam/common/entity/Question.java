package com.evildoer.exam.common.entity;

import com.evildoer.exam.common.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author evildoer
 * @datetime: 2021-01-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Question extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 题目类型 1-选择题 2-多选题 3-填空题 4-简答题
     */
    private Integer type;

    /**
     * 题目标题
     */
    private String title;

    /**
     * 题目描述
     */
    private String description;

    /**
     * 题目难度权重0~1
     */
    private Double weight;

    /**
     * 题目内容(扩展用)
     */
    private String content;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    /**
     * 题目标签(多个标签用&分隔)
     */
    private String label;

    /**
     * 题目热度
     */
    private Long heat;

    /**
     * 问题状态 1-公开(默认) 2私有
     */
    private Integer status;

    private Long createBy;

    private Long updateBy;


}
