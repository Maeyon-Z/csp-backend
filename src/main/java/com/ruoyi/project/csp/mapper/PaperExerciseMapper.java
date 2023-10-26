package com.ruoyi.project.csp.mapper;

import java.util.List;
import com.ruoyi.project.csp.domain.TbPaperExercise;
import org.apache.ibatis.annotations.Mapper;

/**
 * 试卷管理Mapper接口
 *
 * @author zzz
 * @date 2023-10-26
 */
@Mapper
public interface PaperExerciseMapper
{

    /**
     * 查询试卷的题目列表
     * @return 试卷管理集合
     */
    public List<TbPaperExercise> selectTbPaperExerciseListById(Long paperId);






    /**
     * 查询试卷管理
     *
     * @param id 试卷管理主键
     * @return 试卷管理
     */
    public TbPaperExercise selectTbPaperExerciseById(Long id);


    /**
     * 新增试卷管理
     *
     * @param tbPaperExercise 试卷管理
     * @return 结果
     */
    public int insertTbPaperExercise(TbPaperExercise tbPaperExercise);

    /**
     * 修改试卷管理
     *
     * @param tbPaperExercise 试卷管理
     * @return 结果
     */
    public int updateTbPaperExercise(TbPaperExercise tbPaperExercise);

    /**
     * 删除试卷管理
     *
     * @param id 试卷管理主键
     * @return 结果
     */
    public int deleteTbPaperExerciseById(Long id);

    /**
     * 批量删除试卷管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbPaperExerciseByIds(Long[] ids);
}
