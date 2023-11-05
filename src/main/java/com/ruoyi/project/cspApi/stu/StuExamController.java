package com.ruoyi.project.cspApi.stu;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.cspCommon.domain.StuExam;
import com.ruoyi.project.cspCommon.domain.TbExam;
import com.ruoyi.project.cspCommon.service.ITbExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 考试管理Controller
 * 
 * @author zzz
 * @date 2023-11-03
 */
@RestController
@RequestMapping("/stu/exam")
public class StuExamController extends BaseController
{
    @Autowired
    private ITbExamService tbExamService;

    /**
     * 查询考试列表
     */
    @PreAuthorize("@ss.hasPermi('stu:exam:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbExam tbExam)
    {
        startPage();
        List<StuExam> list = tbExamService.selectStuExamList(tbExam);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('stu:exam:list')")
    @GetMapping("/getAllUser")
    public AjaxResult getAllUser()
    {
        return success(tbExamService.getAllUser());
    }

    @PreAuthorize("@ss.hasPermi('stu:exam:list')")
    @GetMapping("/startExam/{userId}/{examId}")
    public AjaxResult startExam(@PathVariable("userId") Long userId, @PathVariable("examId") Long examId)
    {
        // todo 修改开始考试的实现为更新记录 而不是单独的写sql
        return toAjax(tbExamService.startExam(userId, examId));
    }

  }
