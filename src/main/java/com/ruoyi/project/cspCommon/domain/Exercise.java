package com.ruoyi.project.cspCommon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Map;

/**
 * 题目对象 tb_exercises
 * 
 * @author zmy
 * @date 2023-10-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    private Integer errorCounts;
}
