package com.ruoyi.project.cspCommon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.List;

/**
 * 考试管理对象 tb_exam
 * 
 * @author zzz
 * @date 2023-11-03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbExam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 考试名称 */
    @Excel(name = "考试名称")
    private String examName;

    /** 试卷id */
    @Excel(name = "试卷id")
    private Long paperId;

    /** 试卷名称 */
    @Excel(name = "试卷名称")
    private String paperName;

    /** 持续时间 */
    @Excel(name = "持续时间")
    private Long duration;

    /** 是否删除 0:否 1:是 */
    @Excel(name = "是否删除 0:否 1:是")
    private Long isDelete;

    List<Long> users;

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
    public void setPaperId(Long paperId) 
    {
        this.paperId = paperId;
    }

    public Long getPaperId() 
    {
        return paperId;
    }
    public void setPaperName(String paperName) 
    {
        this.paperName = paperName;
    }

    public String getPaperName() 
    {
        return paperName;
    }
    public void setDuration(Long duration) 
    {
        this.duration = duration;
    }

    public Long getDuration() 
    {
        return duration;
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
            .append("paperId", getPaperId())
            .append("paperName", getPaperName())
            .append("duration", getDuration())
            .append("isDelete", getIsDelete())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
