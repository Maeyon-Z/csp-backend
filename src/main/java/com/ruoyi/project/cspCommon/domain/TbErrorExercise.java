package com.ruoyi.project.cspCommon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 错题记录对象 tb_error_exercise
 *
 * @author zzz
 * @date 2023-11-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbErrorExercise extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 题目id */
    @Excel(name = "题目id")
    private Long exerciseId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 错误次数 */
    @Excel(name = "错误次数")
    private Long errorCounts;

    /** 是否删除 0:否 1:是 */
    @Excel(name = "是否删除 0:否 1:是")
    private Long isDelete;


    public static TbErrorExercise build(Long exerciseId, Long userId, Integer counts, String createBy, Date createTime) {
        TbErrorExercise info = new TbErrorExercise();
        info.setExerciseId(exerciseId);
        info.setUserId(userId);
        info.setErrorCounts(counts.longValue());
        info.setCreateBy(createBy);
        info.setCreateTime(createTime);
        return info;
    }
}
