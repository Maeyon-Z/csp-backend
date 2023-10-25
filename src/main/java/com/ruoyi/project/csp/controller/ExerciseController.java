package com.ruoyi.project.csp.controller;

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
import com.ruoyi.project.csp.domain.Exercise;
import com.ruoyi.project.csp.service.IExerciseService;
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
@RequestMapping("/dataControl/exercise")
public class ExerciseController extends BaseController
{
    @Autowired
    private IExerciseService exerciseService;

    /**
     * 查询题目列表
     */
    @PreAuthorize("@ss.hasPermi('dataControl:exercise:list')")
    @GetMapping("/list")
    public TableDataInfo list(Exercise exercise)
    {
        startPage();
        List<Exercise> list = exerciseService.selectExerciseList(exercise);
        return getDataTable(list);
    }

    /**
     * 导出题目列表
     */
    @PreAuthorize("@ss.hasPermi('dataControl:exercise:export')")
    @Log(title = "题目管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Exercise exercise)
    {
        List<Exercise> list = exerciseService.selectExerciseList(exercise);
        ExcelUtil<Exercise> util = new ExcelUtil<Exercise>(Exercise.class);
        util.exportExcel(response, list, "题目数据");
    }

    /**
     * 获取题目详细信息
     */
    @PreAuthorize("@ss.hasPermi('dataControl:exercise:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(exerciseService.selectExerciseById(id));
    }

    /**
     * 新增题目
     */
    @PreAuthorize("@ss.hasPermi('dataControl:exercise:add')")
    @Log(title = "题目管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Exercise exercise)
    {
        return toAjax(exerciseService.insertExercise(exercise));
    }

    /**
     * 修改题目
     */
    @PreAuthorize("@ss.hasPermi('dataControl:exercise:edit')")
    @Log(title = "题目管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Exercise exercise)
    {
        return toAjax(exerciseService.updateExercise(exercise));
    }

    /**
     * 删除题目
     */
    @PreAuthorize("@ss.hasPermi('dataControl:exercise:remove')")
    @Log(title = "题目管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(exerciseService.deleteExerciseByIds(ids));
    }
}
