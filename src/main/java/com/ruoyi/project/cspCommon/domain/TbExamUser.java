package com.ruoyi.project.cspCommon.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 考试-用户映射（记录参加考试的用户）对象 tb_exam_user
 *
 * @author zzz
 * @date 2023-11-03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbExamUser extends BaseEntity
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

    /** 状态（0：尚未开始 1：正在进行 2：已结束） */
    @Excel(name = "状态", readConverterExp = "0=：尚未开始,1=：正在进行,2=：已结束")
    private Long status;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    private Integer score;


    public static TbExamUser buildForInsert(Long examId, Long userId){
        TbExamUser tbExamUser = new TbExamUser();
        tbExamUser.setExamId(examId);
        tbExamUser.setUserId(userId);
        tbExamUser.setStatus(0L);
        return tbExamUser;
    }

    public static TbExamUser build(Long examId, Long userId, Long status, Date startTime, Date endTime){
        TbExamUser tbExamUser = new TbExamUser();
        tbExamUser.setExamId(examId);
        tbExamUser.setUserId(userId);
        tbExamUser.setStatus(status);
        tbExamUser.setStartTime(startTime);
        tbExamUser.setEndTime(endTime);
        return tbExamUser;
    }

}
