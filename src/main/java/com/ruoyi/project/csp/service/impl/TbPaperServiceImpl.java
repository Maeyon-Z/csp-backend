package com.ruoyi.project.csp.service.impl;

import java.util.*;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.csp.domain.Exercise;
import com.ruoyi.project.csp.domain.TbPaperExercise;
import com.ruoyi.project.csp.mapper.ExerciseMapper;
import com.ruoyi.project.csp.mapper.PaperExerciseMapper;
import com.ruoyi.project.csp.params.GenerateExercisesParams;
import com.ruoyi.project.csp.params.PaperSaveExerciseParams;
import com.ruoyi.project.csp.params.PaperSaveParams;
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
    @Autowired
    private ExerciseMapper exerciseMapper;
    @Autowired
    private PaperExerciseMapper paperExerciseMapper;

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
    public Long insertTbPaper(TbPaper tbPaper)
    {
        tbPaper.setCreateTime(DateUtils.getNowDate());
        tbPaper.setCreateBy(SecurityUtils.getUsername());
        tbPaperMapper.insertTbPaper(tbPaper);
        return tbPaper.getId();
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

    @Override
    public List<Exercise> genExercise(GenerateExercisesParams params, Integer type) {
        List<Exercise> res = exerciseMapper.genExercise(params.getCount(), type);
        if(type == 0){
            for(Exercise exercise : res){
                exercise.setScore(params.getScore());
            }
        } else {
            for(Exercise exercise : res){
                List<Long> ids = exerciseMapper.getQuesIds(exercise.getId());
                if(ids == null) ids = new ArrayList<>();
                exercise.setScore(params.getScore() * ids.size());
                Map<Long, Integer> map = new HashMap<>();
                for(Long id : ids){
                    map.put(id, params.getScore());
                }
                exercise.setScoreList(map);
            }
        }

        return res;
    }

    @Override
    public List<Integer> getExerciseIds(Integer type) {
        return exerciseMapper.getExerciseIds(type);
    }

    /**
     * 保存试卷
     * @param params
     */
    @Override
    public void savePaper(PaperSaveParams params) {
        // 首先保存试卷
        TbPaper tbPaper = new TbPaper();
        tbPaper.setPaperName(params.getPaperName());
        tbPaper.setRemark(params.getRemark());
        Long paperId = insertTbPaper(tbPaper);
        // 接下来保存试卷的所有题目
        for(PaperSaveExerciseParams param : params.getBaseExerciseList()){
            TbPaperExercise data = TbPaperExercise.build(paperId, param.getId(), param.getScore().longValue());
            paperExerciseMapper.insertTbPaperExercise(data);
        }
        for(PaperSaveExerciseParams param : params.getReadProgramList()){
            paperExerciseMapper.insertTbPaperExercise(TbPaperExercise.build(paperId, param.getId(), param.getScore().longValue()));
            Set<Integer> idSet = param.getScoreList().keySet();
            for(Integer id : idSet){
                paperExerciseMapper.insertTbPaperExercise(TbPaperExercise.build(paperId, id.longValue(), param.getScoreList().get(id).longValue()));
            }
        }
        for(PaperSaveExerciseParams param : params.getCompletionProgramList()){
            paperExerciseMapper.insertTbPaperExercise(TbPaperExercise.build(paperId, param.getId(), param.getScore().longValue()));
            Set<Integer> idSet = param.getScoreList().keySet();
            for(Integer id : idSet){
                paperExerciseMapper.insertTbPaperExercise(TbPaperExercise.build(paperId, id.longValue(), param.getScoreList().get(id).longValue()));
            }
        }
    }

    @Override
    public List<Exercise> getPaperExercise(Long paperId, Long type) {
        if(type == 0L){
            return exerciseMapper.findPaperExerciseByType(paperId, type);
        }else{
            List<Exercise> res = exerciseMapper.findPaperExerciseByType(paperId, type);
            for(Exercise exercise : res){
                List<TbPaperExercise> paperExercises = paperExerciseMapper.findChildExerciseScore(paperId, exercise.getId());
                Map<Long, Integer> map = new HashMap<>();
                for(TbPaperExercise paperExercise : paperExercises){
                    map.put(paperExercise.getExerciseId(), paperExercise.getScore().intValue());
                }
                exercise.setScoreList(map);
            }
            return res;
        }

    }

}
