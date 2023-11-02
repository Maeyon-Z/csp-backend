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
     * 新增试卷管理
     */
    public int insertTbPaperExercise(TbPaperExercise tbPaperExercise);


    /**
     * 删除试卷管理
     */
    public int deleteTbPaperExerciseById(Long id);

    /**
     * 批量删除试卷管理
     */
    public int deleteTbPaperExerciseByIds(Long[] ids);
}
