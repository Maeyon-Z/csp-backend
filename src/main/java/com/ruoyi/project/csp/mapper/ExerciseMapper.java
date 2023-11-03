package com.ruoyi.project.csp.mapper;

import java.util.List;
import com.ruoyi.project.csp.domain.Exercise;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目Mapper接口
 * 
 * @author zmy
 * @date 2023-10-25
 */
@Mapper
public interface ExerciseMapper 
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
    public int insertExercise(Exercise exercise);

    /**
     * 修改题目
     * 
     * @param exercise 题目
     * @return 结果
     */
    public int updateExercise(Exercise exercise);

    /**
     * 删除题目
     * 
     * @param id 题目主键
     * @return 结果
     */
    public int deleteExerciseById(Long id);

    /**
     * 批量删除题目
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExerciseByIds(Long[] ids);

    List<Exercise> selectExerciseByParentId(Long parentId);

    List<Exercise> genExercise(Integer count, Integer type);

    List<Integer> getExerciseIds(Integer type);

    Integer getQuesCount(Long parentId);

    List<Long> getQuesIds(Long id);

    List<Exercise> findPaperExerciseByType(Long paperId, Long type);
}
