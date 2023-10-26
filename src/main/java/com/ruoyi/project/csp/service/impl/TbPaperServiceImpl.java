package com.ruoyi.project.csp.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.csp.mapper.TbPaperMapper;
import com.ruoyi.project.csp.domain.TbPaper;
import com.ruoyi.project.csp.service.ITbPaperService;

/**
 * 试卷管理Service业务层处理
 * 
 * @author zzz
 * @date 2023-10-25
 */
@Service
public class TbPaperServiceImpl implements ITbPaperService 
{
    @Autowired
    private TbPaperMapper tbPaperMapper;

    /**
     * 查询试卷管理
     * 
     * @param id 试卷管理主键
     * @return 试卷管理
     */
    @Override
    public TbPaper selectTbPaperById(Long id)
    {
        return tbPaperMapper.selectTbPaperById(id);
    }

    /**
     * 查询试卷管理列表
     * 
     * @param tbPaper 试卷管理
     * @return 试卷管理
     */
    @Override
    public List<TbPaper> selectTbPaperList(TbPaper tbPaper)
    {
        return tbPaperMapper.selectTbPaperList(tbPaper);
    }

    /**
     * 新增试卷管理
     * 
     * @param tbPaper 试卷管理
     * @return 结果
     */
    @Override
    public int insertTbPaper(TbPaper tbPaper)
    {
        tbPaper.setCreateTime(DateUtils.getNowDate());
        tbPaper.setCreateBy(SecurityUtils.getUsername());
        return tbPaperMapper.insertTbPaper(tbPaper);
    }

    /**
     * 修改试卷管理
     * 
     * @param tbPaper 试卷管理
     * @return 结果
     */
    @Override
    public int updateTbPaper(TbPaper tbPaper)
    {
        tbPaper.setUpdateTime(DateUtils.getNowDate());
        tbPaper.setUpdateBy(SecurityUtils.getUsername());
        return tbPaperMapper.updateTbPaper(tbPaper);
    }

    /**
     * 批量删除试卷管理
     * 
     * @param ids 需要删除的试卷管理主键
     * @return 结果
     */
    @Override
    public int deleteTbPaperByIds(Long[] ids)
    {
        return tbPaperMapper.deleteTbPaperByIds(ids);
    }

    /**
     * 删除试卷管理信息
     * 
     * @param id 试卷管理主键
     * @return 结果
     */
    @Override
    public int deleteTbPaperById(Long id)
    {
        return tbPaperMapper.deleteTbPaperById(id);
    }
}
