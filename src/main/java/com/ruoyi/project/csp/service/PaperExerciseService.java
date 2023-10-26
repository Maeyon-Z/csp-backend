package com.ruoyi.project.csp.service;

import com.ruoyi.project.csp.domain.TbPaperExercise;
import com.ruoyi.project.csp.params.ConfigExerciseParams;
import com.ruoyi.project.csp.params.GenerateExerciseParams;

import java.util.List;

public interface PaperExerciseService {
    Integer generateExercise(GenerateExerciseParams params);

    List<TbPaperExercise> queryExercise(Long id);

    Integer configExercise(ConfigExerciseParams params);


    int insertTbPaperExercise(TbPaperExercise tbPaperExercise);

    int deleteTbPaperExerciseByIds(Long[] ids);


}
