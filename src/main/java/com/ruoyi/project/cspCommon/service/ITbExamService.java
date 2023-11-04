package com.ruoyi.project.cspCommon.service;

import java.util.List;
import com.ruoyi.project.cspCommon.domain.TbExam;
import com.ruoyi.project.system.domain.SysUser;

/**
 * 考试管理Service接口
 * 
 * @author zzz
 * @date 2023-11-03
 */
public interface ITbExamService 
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
     * 批量删除考试管理
     * 
     * @param ids 需要删除的考试管理主键集合
     * @return 结果
     */
    public int deleteTbExamByIds(Long[] ids);

    /**
     * 删除考试管理信息
     * 
     * @param id 考试管理主键
     * @return 结果
     */
    public int deleteTbExamById(Long id);

    List<SysUser> getAllUser();
}
