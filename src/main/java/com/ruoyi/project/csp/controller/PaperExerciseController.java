package com.ruoyi.project.csp.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.csp.domain.TbPaperExercise;
import com.ruoyi.project.csp.params.ConfigExerciseParams;
import com.ruoyi.project.csp.params.GenerateExerciseParams;
import com.ruoyi.project.csp.service.PaperExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dataControl/paper")
public class PaperExerciseController extends BaseController {

    @Autowired
    private PaperExerciseService paperExerciseService;

    /**
     * 按照规则随机生成试卷题目
     */
    @PreAuthorize("@ss.hasPermi('dataControl:paper:edit')")
    @Log(title = "试卷管理", businessType = BusinessType.UPDATE)
    @PostMapping("/genExercise")
    public AjaxResult genExercise(@RequestBody GenerateExerciseParams params)
    {
        // todo 按照规则生成试卷题目
        return success(paperExerciseService.generateExercise(params));
    }

    /**
     * 手动配置试卷题目
     */
    @PreAuthorize("@ss.hasPermi('dataControl:paper:edit')")
    @Log(title = "试卷管理", businessType = BusinessType.UPDATE)
    @PostMapping("/configExercise")
    public AjaxResult configExercise(@RequestBody ConfigExerciseParams params)
    {
        return success(paperExerciseService.configExercise(params));
    }

    /**
     * 获取试卷的所有题目id以及分值
     */
    @PreAuthorize("@ss.hasPermi('dataControl:paper:query')")
    @GetMapping("/queryExercise/{id}")
    public AjaxResult queryExercise(@PathVariable Long id)
    {
        List<TbPaperExercise> list = paperExerciseService.queryExercise(id);
        return success(list);
    }

    /**
     * 新增试卷题目
     */
    @PreAuthorize("@ss.hasPermi('dataControl:paper:edit')")
    @Log(title = "试卷管理", businessType = BusinessType.UPDATE)
    @PostMapping("/addExercise")
    public AjaxResult add(@RequestBody TbPaperExercise tbPaperExercise)
    {
        return toAjax(paperExerciseService.insertTbPaperExercise(tbPaperExercise));
    }

    /**
     * 删除试卷题目
     */
    @PreAuthorize("@ss.hasPermi('dataControl:paper:edit')")
    @Log(title = "试卷管理", businessType = BusinessType.UPDATE)
    @DeleteMapping("/delExercise/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(paperExerciseService.deleteTbPaperExerciseByIds(ids));
    }

}
