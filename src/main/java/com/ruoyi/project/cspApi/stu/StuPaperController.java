package com.ruoyi.project.cspApi.stu;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.cspCommon.service.ITbPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 试卷管理Controller
 * 
 * @author zzz
 * @date 2023-10-25
 */
@RestController
@RequestMapping("/stu/paper")
public class StuPaperController extends BaseController
{
    @Autowired
    private ITbPaperService tbPaperService;


    @PreAuthorize("@ss.hasPermi('stu:exam:list')")
    @GetMapping("/getPaperListForExam")
    public AjaxResult getPaperListForExam()
    {
        return success(tbPaperService.getPaperListForExam());
    }


    @PreAuthorize("@ss.hasPermi('stu:exam:list')")
    @GetMapping(value = "/{id}")
    public AjaxResult getPaperInfo(@PathVariable("id") Long id)
    {
        return success(tbPaperService.selectTbPaperById(id));
    }

    /**
     * 获取试卷题目
     */
    @PreAuthorize("@ss.hasPermi('stu:exam:list')")
    @GetMapping(value = "/getPaperExercise/{paperId}/{type}")
    public AjaxResult getPaperExercise(@PathVariable("paperId") Long paperId, @PathVariable("type") Long type)
    {
        return success(tbPaperService.getPaperExercise(paperId, type));
    }
}
