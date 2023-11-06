package com.ruoyi.project.cspCommon.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmitExamParams {

    private Long userId;

    private Long examId;

    private Map<Integer, String> answer;
}
