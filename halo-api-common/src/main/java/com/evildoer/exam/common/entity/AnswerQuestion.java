package com.evildoer.exam.common.entity;

import com.evildoer.exam.common.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author evildoer
 * @since 2021-01-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AnswerQuestion extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String answer;

    /**
     * 得分
     */
    private String markScore;

    /**
     * 问题id
     */
    private String questionId;

    /**
     * 答题时间点
     */
    private LocalDateTime answerTime;

    /**
     * 考试用户表id
     */
    private String examUserId;


}
