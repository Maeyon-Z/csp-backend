package com.ruoyi.project.cspCommon.domain;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 考试情况记录对象 tb_examination_info
 *
 * @author zzz
 * @date 2023-11-06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbExaminationInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 考试id */
    @Excel(name = "考试id")
    private Long examId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 题目id */
    @Excel(name = "题目id")
    private Long exerciseId;

    /** 答案 */
    @Excel(name = "答案")
    private String answer;

    /** 是否正确 0：否 1：是 */
    @Excel(name = "是否正确 0：否 1：是")
    private Long isTrue;

    public static TbExaminationInfo build(Long examId, Long userId, Long exerciseId, String answer){
        TbExaminationInfo info = new TbExaminationInfo();
        info.setAnswer(answer);
        info.setExamId(examId);
        info.setUserId(userId);
        info.setExerciseId(exerciseId);
        info.setCreateTime(DateUtils.getNowDate());
        info.setCreateBy(SecurityUtils.getUsername());
        info.setUpdateTime(DateUtils.getNowDate());
        info.setUpdateBy(SecurityUtils.getUsername());
        return info;
    }
}
