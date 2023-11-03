package com.ruoyi.project.csp.mapper;

import java.util.List;
import com.ruoyi.project.csp.domain.TbExam;
import org.apache.ibatis.annotations.Mapper;

/**
 * 考试管理Mapper接口
 * 
 * @author zzz
 * @date 2023-11-03
 */
@Mapper
public interface TbExamMapper 
{
    /**
     * 查询考试管理
     * 
     * @param id 考试管理主键
     * @return 考试管理
     */
    public TbExam selectTbExamById(Long id);

    /**
     * 查询考试管理列表
     * 
     * @param tbExam 考试管理
     * @return 考试管理集合
     */
    public List<TbExam> selectTbExamList(TbExam tbExam);

    /**
     * 新增考试管理
     * 
     * @param tbExam 考试管理
     * @return 结果
     */
    public int insertTbExam(TbExam tbExam);

    /**
     * 修改考试管理
     * 
     * @param tbExam 考试管理
     * @return 结果
     */
    public int updateTbExam(TbExam tbExam);

    /**
     * 删除考试管理
     * 
     * @param id 考试管理主键
     * @return 结果
     */
    public int deleteTbExamById(Long id);

    /**
     * 批量删除考试管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbExamByIds(Long[] ids);
}
