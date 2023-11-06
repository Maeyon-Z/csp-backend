package com.ruoyi.project.cspCommon.service.impl;

import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.cspCommon.domain.*;
import com.ruoyi.project.cspCommon.mapper.*;
import com.ruoyi.project.cspCommon.params.SubmitExamParams;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    @Autowired
    private ExerciseMapper exerciseMapper;
    @Autowired
    private PaperExerciseMapper paperExerciseMapper;
    @Autowired
    private TbExaminationInfoMapper tbExaminationInfoMapper;

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

    @Override
    public List<StuExam> selectStuExamList(TbExam tbExam) {
        Long stuId = SecurityUtils.getUserId();
        List<StuExam> res = tbExamMapper.selectStuExamList(tbExam.getExamName(), stuId);

        for(StuExam exam : res){
            exam.setUsers(tbExamUserMapper.getExamUsersByExamId(exam.getExamId()));
        }

        return res;
    }

    @Override
    public int startExam(StuExam stuExam) {
        Date startTime = DateUtils.getNowDate();
        Date endTime = new Date(startTime.getTime() + stuExam.getDuration() * 60 * 1000);
        TbExamUser tbExamUser = TbExamUser.build(stuExam.getExamId(), SecurityUtils.getUserId(), 1L, startTime, endTime);
        return tbExamUserMapper.startExam(tbExamUser);
    }

    @Override
    public StuExam getStuExamById(Long id) {
        return tbExamMapper.getStuExamById(id);
    }

    @Override
    public int submitExam(SubmitExamParams params) {
        // 提交试卷
        // 1、对于每道题目，判断是否正确，同时计算总分数、插入考试记录表
        Long userId = params.getUserId();
        Long examId = params.getExamId();
        Integer score = 0;
        for(Integer exerciseId : params.getAnswer().keySet()){
            TbExaminationInfo info = TbExaminationInfo.build(examId, userId, exerciseId.longValue(), params.getAnswer().get(exerciseId));
            if(params.getAnswer().get(exerciseId).equals(exerciseMapper.selectExerciseById(exerciseId.longValue()).getCorrectAnswer())){
                score += paperExerciseMapper.getPaperExerciseScore(exerciseId, examId);
                info.setIsTrue(1L);
            }else{
                info.setIsTrue(0L);
            }
            tbExaminationInfoMapper.insertTbExaminationInfo(info);
        }
        // 2、更新用户-考试关系表
        tbExamUserMapper.endExam(userId, examId, score);
        return score;
    }

}
