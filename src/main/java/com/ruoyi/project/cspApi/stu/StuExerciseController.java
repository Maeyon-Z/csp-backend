package com.ruoyi.project.cspApi.stu;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.cspCommon.domain.Exercise;
import com.ruoyi.project.cspCommon.service.IExerciseService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 题目Controller
 *
 * @author zmy
 * @date 2023-10-25
 */
@RestController
@RequestMapping("/stu/exercise")
public class StuExerciseController extends BaseController
{
    @Autowired
    private IExerciseService exerciseService;


    /**
     * 获取题目详细信息
     */
    @PreAuthorize("@ss.hasPermi('stu:exam:list')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(exerciseService.selectExerciseById(id));
    }

    /**
     * 获取程序题下面的多道问题
     */
    @PreAuthorize("@ss.hasPermi('stu:exam:list')")
    @GetMapping(value = "/ques/{parentId}")
    public AjaxResult getQues(@PathVariable("parentId") Long parentId)
    {
        return success(exerciseService.selectExerciseByParentId(parentId));
    }
}
