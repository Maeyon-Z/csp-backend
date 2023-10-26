package com.ruoyi.project.csp.service.impl;

import com.ruoyi.project.csp.domain.TbPaperExercise;
import com.ruoyi.project.csp.mapper.PaperExerciseMapper;
import com.ruoyi.project.csp.params.ConfigExerciseParams;
import com.ruoyi.project.csp.params.GenerateExerciseParams;
import com.ruoyi.project.csp.service.PaperExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperExerciseServiceImpl implements PaperExerciseService {

    @Autowired
    private PaperExerciseMapper paperExerciseMapper;

    @Override
    public Integer generateExercise(GenerateExerciseParams params) {
        return null;
    }

    @Override
    public List<TbPaperExercise> queryExercise(Long id) {
        return paperExerciseMapper.selectTbPaperExerciseListById(id);
    }

    @Override
    public Integer configExercise(ConfigExerciseParams params) {
        int res = 0;
        for(int i = 0; i < params.getExercisesId().size(); i++){
            TbPaperExercise paperExercise = new TbPaperExercise();
            paperExercise.setPaperId(params.getPaperId());
            paperExercise.setExerciseId(params.getExercisesId().get(i));
            paperExercise.setScore(params.getScores().get(i));
            res += paperExerciseMapper.insertTbPaperExercise(paperExercise);
        }
        return res;
    }

    @Override
    public int insertTbPaperExercise(TbPaperExercise tbPaperExercise)
    {
        return paperExerciseMapper.insertTbPaperExercise(tbPaperExercise);
    }

    @Override
    public int deleteTbPaperExerciseByIds(Long[] ids)
    {
        return paperExerciseMapper.deleteTbPaperExerciseByIds(ids);
    }
}
