package com.ruoyi.project.csp.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
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


    public static TbExamUser buildForInsert(Long examId, Long userId){
        TbExamUser tbExamUser = new TbExamUser();
        tbExamUser.setExamId(examId);
        tbExamUser.setUserId(userId);
        tbExamUser.setStatus(0L);
        return tbExamUser;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setExamId(Long examId)
    {
        this.examId = examId;
    }

    public Long getExamId()
    {
        return examId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("examId", getExamId())
                .append("userId", getUserId())
                .append("status", getStatus())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .toString();
    }
}
