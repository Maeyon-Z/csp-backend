package com.ruoyi.project.csp.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.csp.mapper.ExerciseMapper;
import com.ruoyi.project.csp.domain.Exercise;
import com.ruoyi.project.csp.service.IExerciseService;

/**
 * 题目Service业务层处理
 * 
 * @author zmy
 * @date 2023-10-25
 */
@Service
public class ExerciseServiceImpl implements IExerciseService 
{
    @Autowired
    private ExerciseMapper exerciseMapper;

    /**
     * 查询题目
     * 
     * @param id 题目主键
     * @return 题目
     */
    @Override
    public Exercise selectExerciseById(Long id)
    {
        Exercise exercise = exerciseMapper.selectExerciseById(id);
        exercise.setScore(0);
        return exercise;
    }

    /**
     * 查询题目列表
     * 
     * @param exercise 题目
     * @return 题目
     */
    @Override
    public List<Exercise> selectExerciseList(Exercise exercise)
    {
        return exerciseMapper.selectExerciseList(exercise);
    }

    /**
     * 新增题目
     * 
     * @param exercise 题目
     * @return 结果
     */
    @Override
    public Long insertExercise(Exercise exercise)
    {
        exercise.setCreateTime(DateUtils.getNowDate());
        exercise.setCreateBy(SecurityUtils.getUsername());
        exerciseMapper.insertExercise(exercise);
        return exercise.getId();
    }

    /**
     * 修改题目
     * 
     * @param exercise 题目
     * @return 结果
     */
    @Override
    public int updateExercise(Exercise exercise)
    {
        exercise.setUpdateTime(DateUtils.getNowDate());
        exercise.setUpdateBy(SecurityUtils.getUsername());
        return exerciseMapper.updateExercise(exercise);
    }

    /**
     * 批量删除题目
     * 
     * @param ids 需要删除的题目主键
     * @return 结果
     */
    @Override
    public int deleteExerciseByIds(Long[] ids)
    {
        return exerciseMapper.deleteExerciseByIds(ids);
    }

    /**
     * 删除题目信息
     * 
     * @param id 题目主键
     * @return 结果
     */
    @Override
    public int deleteExerciseById(Long id)
    {
        return exerciseMapper.deleteExerciseById(id);
    }

    @Override
    public List<Exercise> selectExerciseByParentId(Long parentId) {
        List<Exercise> res = exerciseMapper.selectExerciseByParentId(parentId);
        for(Exercise exercise : res){
            exercise.setScore(0);
        }
        return res;
    }
}
