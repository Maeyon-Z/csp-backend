package com.ruoyi.project.cspCommon.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaperSaveExerciseParams {

    private Long id;
    private Integer score;

    // 记录程序题的子题分数
    private Map<Integer, Integer> scoreList;
}
