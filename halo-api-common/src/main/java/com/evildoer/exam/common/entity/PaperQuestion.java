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
public class PaperQuestion extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 试卷id
     */
    private String paperId;

    /**
     * 题目编号
     */
    private Integer number;

    /**
     * 问题id
     */
    private String questionId;

    /**
     * 出卷人设置的题目分值
     */
    private Double score;


}
