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
public class Exam extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 考试名称
     */
    private String name;

    /**
     * 班级内部测试(大型考试可以设为空)
     */
    private Long classId;

    /**
     * 课程id
     */
    private Long subjectId;

    /**
     * 试卷id
     */
    private String paperId;

    /**
     * 是否发布@1是，0否
     */
    private Integer publish;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 1-模考 2-正考
     */
    private Integer type;

    private String remark;

    private String avatar;

    /**
     * 试卷标签(多个标签用&分隔)
     */
    private String label;


}
