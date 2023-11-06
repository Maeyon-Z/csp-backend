package com.ruoyi.project.cspCommon.mapper;

import com.ruoyi.project.cspCommon.domain.TbExaminationInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 考试情况记录Mapper接口
 *
 * @author zzz
 * @date 2023-11-06
 */
@Mapper
public interface TbExaminationInfoMapper
{
    /**
     * 查询考试情况记录
     *
     * @param id 考试情况记录主键
     * @return 考试情况记录
     */
    public TbExaminationInfo selectTbExaminationInfoById(Long id);

    /**
     * 查询考试情况记录列表
     *
     * @param tbExaminationInfo 考试情况记录
     * @return 考试情况记录集合
     */
    public List<TbExaminationInfo> selectTbExaminationInfoList(TbExaminationInfo tbExaminationInfo);

    /**
     * 新增考试情况记录
     *
     * @param tbExaminationInfo 考试情况记录
     * @return 结果
     */
    public int insertTbExaminationInfo(TbExaminationInfo tbExaminationInfo);

    /**
     * 修改考试情况记录
     *
     * @param tbExaminationInfo 考试情况记录
     * @return 结果
     */
    public int updateTbExaminationInfo(TbExaminationInfo tbExaminationInfo);

    /**
     * 删除考试情况记录
     *
     * @param id 考试情况记录主键
     * @return 结果
     */
    public int deleteTbExaminationInfoById(Long id);

    /**
     * 批量删除考试情况记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbExaminationInfoByIds(Long[] ids);
}
