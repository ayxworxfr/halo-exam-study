package com.evildoer.exam.common.entity;

import com.evildoer.exam.common.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author evildoer
 * @since 2021-01-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ExamDetail extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 报考用户id
     */
    private Long userId;

    /**
     * 考试id
     */
    private String examId;

    /**
     * 班级内部测试(大型考试可以设为空)
     */
    private Long classId;

    /**
     * 课程id
     */
    private Long subjectId;

    /**
     * 考试名称
     */
    private String examName;

    private Long markScore;

    private Long score;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;


}
