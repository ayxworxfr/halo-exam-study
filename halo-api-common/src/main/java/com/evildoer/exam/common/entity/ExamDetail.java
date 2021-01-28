package com.evildoer.exam.common.entity;

import com.evildoer.exam.common.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

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
public class ExamDetail extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 考试id
     */
    private String examId;

    private Long peoples;

    private Long score;

    private BigDecimal markScore;


}
