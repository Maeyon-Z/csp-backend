package com.ruoyi.project.cspCommon.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaperSaveParams {

    private String paperName;
    private String remark;
    private List<PaperSaveExerciseParams> baseExerciseList;
    private List<PaperSaveExerciseParams> readProgramList;
    private List<PaperSaveExerciseParams> completionProgramList;

}
