package com.ruoyi.project.csp.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.List;
import java.util.Map;

/**
 * 题目对象 tb_exercises
 * 
 * @author zmy
 * @date 2023-10-25
 */
@Data
public class Exercise extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 题目描述 */
    @Excel(name = "题目描述")
    private String exerciseTitle;

    @Excel(name = "题目程序")
    private String exerciseProgram;

    private Long parentId;

    /** 选项A */
    @Excel(name = "选项A")
    private String choiceA;

    /** 选项B */
    @Excel(name = "选项B")
    private String choiceB;

    /** 选项C */
    @Excel(name = "选项C")
    private String choiceC;

    /** 选项D */
    @Excel(name = "选项D")
    private String choiceD;

    /** 正确答案，对于选择题只能取A、B、C、D这四个值其中之一，对于判断题只能是 正确/错误 二者之一 */
    @Excel(name = "正确答案，对于选择题只能取A、B、C、D这四个值其中之一，对于判断题只能是 正确/错误 二者之一")
    private String correctAnswer;

    /** 答案解析 */
    @Excel(name = "答案解析")
    private String analysis;

    /** 题目类型 0:选择题 1:判断题 */
    @Excel(name = "题目类型 0:选择题 1:判断题")
    private Long exerciseType;

    /** 类型 0:基础题 1:阅读程序 2:补全程序 */
    @Excel(name = "类型 0:基础题 1:阅读程序 2:补全程序")
    private Long quesType;

    /** 是否删除 0:否 1:是 */
    @Excel(name = "是否删除 0:否 1:是")
    private Long isDelete;

    private Integer score;

    private Map<Long, Integer> scoreList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public Long getParentId()
    {
        return this.parentId;
    }


    public String getExerciseProgram(){
        return this.exerciseProgram;
    }

    public void setExerciseProgram(String exerciseProgram){
        this.exerciseProgram = exerciseProgram;
    }
    public void setExerciseTitle(String exerciseTitle) 
    {
        this.exerciseTitle = exerciseTitle;
    }

    public String getExerciseTitle() 
    {
        return exerciseTitle;
    }
    public void setChoiceA(String choiceA) 
    {
        this.choiceA = choiceA;
    }

    public String getChoiceA() 
    {
        return choiceA;
    }
    public void setChoiceB(String choiceB) 
    {
        this.choiceB = choiceB;
    }

    public String getChoiceB() 
    {
        return choiceB;
    }
    public void setChoiceC(String choiceC) 
    {
        this.choiceC = choiceC;
    }

    public String getChoiceC() 
    {
        return choiceC;
    }
    public void setChoiceD(String choiceD) 
    {
        this.choiceD = choiceD;
    }

    public String getChoiceD() 
    {
        return choiceD;
    }
    public void setCorrectAnswer(String correctAnswer) 
    {
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() 
    {
        return correctAnswer;
    }
    public void setAnalysis(String analysis) 
    {
        this.analysis = analysis;
    }

    public String getAnalysis() 
    {
        return analysis;
    }
    public void setExerciseType(Long exerciseType) 
    {
        this.exerciseType = exerciseType;
    }

    public Long getExerciseType() 
    {
        return exerciseType;
    }
    public void setQuesType(Long quesType) 
    {
        this.quesType = quesType;
    }

    public Long getQuesType() 
    {
        return quesType;
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
            .append("exerciseTitle", getExerciseTitle())
                .append("exerciseProgram", getExerciseProgram())
            .append("choiceA", getChoiceA())
            .append("choiceB", getChoiceB())
            .append("choiceC", getChoiceC())
            .append("choiceD", getChoiceD())
            .append("correctAnswer", getCorrectAnswer())
            .append("analysis", getAnalysis())
            .append("exerciseType", getExerciseType())
            .append("quesType", getQuesType())
            .append("isDelete", getIsDelete())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
