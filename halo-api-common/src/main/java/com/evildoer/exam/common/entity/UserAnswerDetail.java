package com.evildoer.exam.common.entity;

import com.evildoer.exam.common.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author evildoer
 * @since 2021-01-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserAnswerDetail extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 考试用户表id
     */
    private String examUserId;

    /**
     * 报考用户id
     */
    private Long userId;

    /**
     * 考试id
     */
    private String examId;

    private String userAnswer;

    /**
     * 得分
     */
    private String markScore;

    /**
     * 问题id
     */
    private String questionId;

    /**
     * 问题正确答案(如果是多选题包含分值分配方式)
     */
    private String answer;

    /**
     * 问题解析
     */
    private String analysis;

    /**
     * 出题人设置的题目分值
     */
    private Double score;

    /**
     * 答题时间点
     */
    private LocalDateTime answerTime;


}
