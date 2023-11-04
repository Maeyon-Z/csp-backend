package com.ruoyi.project.cspCommon.service;

import java.util.List;
import com.ruoyi.project.cspCommon.domain.Exercise;

/**
 * 题目Service接口
 * 
 * @author zmy
 * @date 2023-10-25
 */
public interface IExerciseService 
{
    /**
     * 查询题目
     * 
     * @param id 题目主键
     * @return 题目
     */
    public Exercise selectExerciseById(Long id);

    /**
     * 查询题目列表
     * 
     * @param exercise 题目
     * @return 题目集合
     */
    public List<Exercise> selectExerciseList(Exercise exercise);

    /**
     * 新增题目
     * 
     * @param exercise 题目
     * @return 结果
     */
    public Long insertExercise(Exercise exercise);

    /**
     * 修改题目
     * 
     * @param exercise 题目
     * @return 结果
     */
    public int updateExercise(Exercise exercise);

    /**
     * 批量删除题目
     * 
     * @param ids 需要删除的题目主键集合
     * @return 结果
     */
    public int deleteExerciseByIds(Long[] ids);

    /**
     * 删除题目信息
     * 
     * @param id 题目主键
     * @return 结果
     */
    public int deleteExerciseById(Long id);

    List<Exercise> selectExerciseByParentId(Long parentId);
}
