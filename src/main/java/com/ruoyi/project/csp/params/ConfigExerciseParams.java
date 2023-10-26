package com.ruoyi.project.csp.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigExerciseParams {

    private Long paperId;

    private List<Long> exercisesId;

    private List<Long> scores;

}
