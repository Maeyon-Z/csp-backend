package com.ruoyi.project.cspCommon.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.cspCommon.domain.TbExamUser;
import com.ruoyi.project.cspCommon.mapper.TbExamUserMapper;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.cspCommon.mapper.TbExamMapper;
import com.ruoyi.project.cspCommon.domain.TbExam;
import com.ruoyi.project.cspCommon.service.ITbExamService;

/**
 * 考试管理Service业务层处理
 * 
 * @author zzz
 * @date 2023-11-03
 */
@Service
public class TbExamServiceImpl implements ITbExamService 
{
    @Autowired
    private TbExamMapper tbExamMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private TbExamUserMapper tbExamUserMapper;

    /**
     * 查询考试管理
     * 
     * @param id 考试管理主键
     * @return 考试管理
     */
    @Override
    public TbExam selectTbExamById(Long id)
    {
        return tbExamMapper.selectTbExamById(id);
    }

    /**
     * 查询考试管理列表
     * 
     * @param tbExam 考试管理
     * @return 考试管理
     */
    @Override
    public List<TbExam> selectTbExamList(TbExam tbExam)
    {
        List<TbExam> res = tbExamMapper.selectTbExamList(tbExam);

        for(TbExam exam : res){
            exam.setUsers(tbExamUserMapper.getExamUsersByExamId(exam.getId()));
        }

        return res;
    }

    /**
     * 新增考试管理
     * 
     * @param tbExam 考试管理
     * @return 结果
     */
    @Override
    public int insertTbExam(TbExam tbExam)
    {
        tbExam.setCreateTime(DateUtils.getNowDate());
        tbExam.setCreateBy(SecurityUtils.getUsername());
        tbExam.setIsDelete(0L);
        tbExamMapper.insertTbExam(tbExam);
        List<Long> users = tbExam.getUsers();
        for (Long userId : users){
            tbExamUserMapper.insertTbExamUser(TbExamUser.buildForInsert(tbExam.getId(), userId));
        }
        return tbExam.getId().intValue();
    }

    /**
     * 修改考试管理
     * @param tbExam 考试管理
     * @return 结果
     */
    @Override
    public int updateTbExam(TbExam tbExam)
    {
        tbExam.setUpdateTime(DateUtils.getNowDate());
        tbExam.setUpdateBy(SecurityUtils.getUsername());
        tbExam.setIsDelete(0L);
        tbExamMapper.updateTbExam(tbExam);
        return tbExam.getId().intValue();
    }

    /**
     * 批量删除考试管理
     * 
     * @param ids 需要删除的考试管理主键
     * @return 结果
     */
    @Override
    public int deleteTbExamByIds(Long[] ids)
    {
        return tbExamMapper.deleteTbExamByIds(ids);
    }

    /**
     * 删除考试管理信息
     * 
     * @param id 考试管理主键
     * @return 结果
     */
    @Override
    public int deleteTbExamById(Long id)
    {
        return tbExamMapper.deleteTbExamById(id);
    }

    @Override
    public List<SysUser> getAllUser() {
        return sysUserMapper.getAllUser();
    }
}
