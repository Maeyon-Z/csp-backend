package com.ruoyi.project.csp.mapper;

import java.util.List;
import com.ruoyi.project.csp.domain.TbPaper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 试卷管理Mapper接口
 * 
 * @author zzz
 * @date 2023-10-25
 */
@Mapper
public interface TbPaperMapper 
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
    public int insertTbPaper(TbPaper tbPaper);

    /**
     * 修改试卷管理
     * 
     * @param tbPaper 试卷管理
     * @return 结果
     */
    public int updateTbPaper(TbPaper tbPaper);

    /**
     * 删除试卷管理
     * 
     * @param id 试卷管理主键
     * @return 结果
     */
    public int deleteTbPaperById(Long id);

    /**
     * 批量删除试卷管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbPaperByIds(Long[] ids);

}
