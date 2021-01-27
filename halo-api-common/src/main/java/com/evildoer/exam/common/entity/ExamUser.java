package com.evildoer.exam.common.entity;

import com.evildoer.exam.common.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

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
public class ExamUser extends BaseEntity {

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
     * 报考时间
     */
    private LocalDateTime signTime;

    /**
     * 提交答卷时间
     */
    private LocalDateTime finishTime;


}
