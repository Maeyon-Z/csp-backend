package com.ruoyi.project.cspCommon.mapper;

import java.util.List;
import com.ruoyi.project.cspCommon.domain.TbErrorExercise;
import org.apache.ibatis.annotations.Mapper;

/**
 * 错题记录Mapper接口
 *
 * @author zzz
 * @date 2023-11-07
 */
@Mapper
public interface TbErrorExerciseMapper
{
    /**
     * 查询错题记录
     *
     * @param id 错题记录主键
     * @return 错题记录
     */
    public TbErrorExercise selectTbErrorExerciseById(Long id);

    /**
     * 查询错题记录列表
     *
     * @param tbErrorExercise 错题记录
     * @return 错题记录集合
     */
    public List<TbErrorExercise> selectTbErrorExerciseList(TbErrorExercise tbErrorExercise);

    /**
     * 新增错题记录
     *
     * @param tbErrorExercise 错题记录
     * @return 结果
     */
    public int insertTbErrorExercise(TbErrorExercise tbErrorExercise);

    /**
     * 修改错题记录
     *
     * @param tbErrorExercise 错题记录
     * @return 结果
     */
    public int updateTbErrorExercise(TbErrorExercise tbErrorExercise);

    /**
     * 删除错题记录
     *
     * @param id 错题记录主键
     * @return 结果
     */
    public int deleteTbErrorExerciseById(Long id);

    /**
     * 批量删除错题记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbErrorExerciseByIds(Long[] ids);

    TbErrorExercise selectTbErrorExercise(Long exerciseId, Long userId);

}
