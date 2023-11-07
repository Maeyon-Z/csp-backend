package com.ruoyi.project.cspApi.stu;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.cspCommon.domain.Exercise;
import com.ruoyi.project.cspCommon.service.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ruoyi.common.utils.PageUtils.startPage;

@RestController
@RequestMapping("/stu/error")
public class StuErrorController extends BaseController {

    @Autowired
    private IExerciseService exerciseService;

    /**
     * 查询题目列表
     */
    @PreAuthorize("@ss.hasPermi('stu:error:list')")
    @GetMapping("/list")
    public TableDataInfo list(Exercise exercise)
    {
        startPage();
        List<Exercise> list = exerciseService.getErrorList(exercise);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('stu:error:list')")
    @GetMapping("/del/{id}")
    public AjaxResult del(@PathVariable("id") Long id)
    {
        return toAjax(exerciseService.delError(id));
    }
}
