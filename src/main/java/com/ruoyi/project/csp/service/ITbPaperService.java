package com.ruoyi.project.csp.service;

import java.util.List;

import com.ruoyi.project.csp.domain.Exercise;
import com.ruoyi.project.csp.domain.TbPaper;
import com.ruoyi.project.csp.params.GenerateExercisesParams;
import com.ruoyi.project.csp.params.PaperSaveParams;

/**
 * 试卷管理Service接口
 * 
 * @author zzz
 * @date 2023-10-25
 */
public interface ITbPaperService 
{
    /**
     * 查询试卷管理
     * 
     * @param id 试卷管理主键
     * @return 试卷管理
     */
    public TbPaper selectTbPaperById(Long id);

    /**
     * 查询试卷管理列表
     * 
     * @param tbPaper 试卷管理
     * @return 试卷管理集合
     */
    public List<TbPaper> selectTbPaperList(TbPaper tbPaper);

    /**
     * 新增试卷管理
     * 
     * @param tbPaper 试卷管理
     * @return 结果
     */
    public Long insertTbPaper(TbPaper tbPaper);

    /**
     * 修改试卷管理
     * 
     * @param tbPaper 试卷管理
     * @return 结果
     */
    public int updateTbPaper(TbPaper tbPaper);

    /**
     * 批量删除试卷管理
     * 
     * @param ids 需要删除的试卷管理主键集合
     * @return 结果
     */
    public int deleteTbPaperByIds(Long[] ids);

    /**
     * 删除试卷管理信息
     * 
     * @param id 试卷管理主键
     * @return 结果
     */
    public int deleteTbPaperById(Long id);

    List<Exercise> genExercise(GenerateExercisesParams params, Integer type);

    List<Integer> getExerciseIds(Integer type);

    void savePaper(PaperSaveParams params);

    List<Exercise> getPaperExercise(Long paperId, Long type);
}
