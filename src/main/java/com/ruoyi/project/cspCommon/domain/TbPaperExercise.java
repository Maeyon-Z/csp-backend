package com.ruoyi.project.cspCommon.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 试卷-题目映射管理对象 tb_paper_exercise
 *
 * @author zzz
 * @date 2023-10-26
 */
public class TbPaperExercise extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 试卷id */
    @Excel(name = "试卷id")
    private Long paperId;

    /** 题目id */
    @Excel(name = "题目id")
    private Long exerciseId;

    /** 题目分数 */
    @Excel(name = "题目分数")
    private Long score;

    public static TbPaperExercise build(Long paperId, Long exerciseId, Long score){
        TbPaperExercise res = new TbPaperExercise();
        res.setExerciseId(exerciseId);
        res.setScore(score);
        res.setPaperId(paperId);
        return res;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPaperId(Long paperId)
    {
        this.paperId = paperId;
    }

    public Long getPaperId()
    {
        return paperId;
    }
    public void setExerciseId(Long exerciseId)
    {
        this.exerciseId = exerciseId;
    }

    public Long getExerciseId()
    {
        return exerciseId;
    }
    public void setScore(Long score)
    {
        this.score = score;
    }

    public Long getScore()
    {
        return score;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("paperId", getPaperId())
                .append("exerciseId", getExerciseId())
                .append("score", getScore())
                .toString();
    }
}

