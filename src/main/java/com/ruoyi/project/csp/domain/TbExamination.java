package com.ruoyi.project.csp.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 试卷管理对象 tb_examination_paper
 * 
 * @author zzz
 * @date 2023-10-25
 */
public class TbExamination extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 试卷名称 */
    @Excel(name = "试卷名称")
    private String examName;

    /** 用户id列表,记录指定参加考试的用户 */
    private String userIds;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 持续时间，以分钟为单位 */
    @Excel(name = "持续时间，以分钟为单位")
    private Long duration;

    /** 是否结束 0:否 1:是 */
    @Excel(name = "是否结束 0:否 1:是")
    private Long isEnd;

    /** 是否删除 0:否 1:是 */
    private Long isDelete;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setExamName(String examName) 
    {
        this.examName = examName;
    }

    public String getExamName() 
    {
        return examName;
    }
    public void setUserIds(String userIds) 
    {
        this.userIds = userIds;
    }

    public String getUserIds() 
    {
        return userIds;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setDuration(Long duration) 
    {
        this.duration = duration;
    }

    public Long getDuration() 
    {
        return duration;
    }
    public void setIsEnd(Long isEnd) 
    {
        this.isEnd = isEnd;
    }

    public Long getIsEnd() 
    {
        return isEnd;
    }
    public void setIsDelete(Long isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() 
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("examName", getExamName())
            .append("userIds", getUserIds())
            .append("startTime", getStartTime())
            .append("duration", getDuration())
            .append("isEnd", getIsEnd())
            .append("isDelete", getIsDelete())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
