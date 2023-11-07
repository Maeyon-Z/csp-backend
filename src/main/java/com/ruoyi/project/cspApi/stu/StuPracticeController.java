package com.ruoyi.project.cspApi.stu;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.cspCommon.params.GeneratePracticeParams;
import com.ruoyi.project.cspCommon.service.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.ruoyi.framework.web.domain.AjaxResult.success;

@RestController
@RequestMapping("/stu/practice")
public class StuPracticeController {

    @Autowired
    private IExerciseService exerciseService;


    @PreAuthorize("@ss.hasPermi('stu:practice:list')")
    @PostMapping(value = "/genExercise")
    public AjaxResult genExercise(@RequestBody GeneratePracticeParams params)
    {
        return success(exerciseService.genPractice(params));
    }

    @PreAuthorize("@ss.hasPermi('stu:practice:list')")
    @PostMapping(value = "/submit")
    public AjaxResult submit(@RequestBody GeneratePracticeParams params)
    {
        // todo 练习题提交，用于记录错题
        return null;
    }

}
