package com.ruoyi.project.csp.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.project.csp.params.GenerateBaseExercisesParams;
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
import com.ruoyi.project.csp.domain.TbPaper;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.csp.service.ITbPaperService;

/**
 * 试卷管理Controller
 * 
 * @author zzz
 * @date 2023-10-25
 */
@RestController
@RequestMapping("/dataControl/paper")
public class TbPaperController extends BaseController
{
    @Autowired
    private ITbPaperService tbPaperService;

    /**
     * 查询试卷管理列表
     */
    @PreAuthorize("@ss.hasPermi('dataControl:paper:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbPaper tbPaper)
    {
        startPage();
        List<TbPaper> list = tbPaperService.selectTbPaperList(tbPaper);
        return getDataTable(list);
    }

    /**
     * 获取试卷管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('dataControl:paper:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbPaperService.selectTbPaperById(id));
    }

    /**
     * 新增试卷管理
     */
    @PreAuthorize("@ss.hasPermi('dataControl:paper:add')")
    @Log(title = "试卷管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody TbPaper tbPaper)
    {
        return success(tbPaperService.insertTbPaper(tbPaper));
    }

    @PreAuthorize("@ss.hasPermi('dataControl:paper:add')")
    @PostMapping("/genExercise/{type}")
    public AjaxResult genExercise(@RequestBody GenerateBaseExercisesParams params, @PathVariable("type") Integer type)
    {
        return success(tbPaperService.genExercise(params, type));
    }

    @PreAuthorize("@ss.hasPermi('dataControl:paper:add')")
    @PostMapping("/getExerciseIds/{type}")
    public AjaxResult getExerciseIds(@PathVariable("type") Integer type)
    {
        return success(tbPaperService.getExerciseIds(type));
    }

    /**
     * 修改试卷管理
     */
    @PreAuthorize("@ss.hasPermi('dataControl:paper:edit')")
    @Log(title = "试卷管理", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody TbPaper tbPaper)
    {
        return toAjax(tbPaperService.updateTbPaper(tbPaper));
    }


    /**
     * 删除试卷管理
     */
    @PreAuthorize("@ss.hasPermi('dataControl:paper:remove')")
    @Log(title = "试卷管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/del/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbPaperService.deleteTbPaperByIds(ids));
    }

    /**
     * 导出试卷管理列表
     */
    @PreAuthorize("@ss.hasPermi('dataControl:paper:export')")
    @Log(title = "试卷管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbPaper tbPaper)
    {
        List<TbPaper> list = tbPaperService.selectTbPaperList(tbPaper);
        ExcelUtil<TbPaper> util = new ExcelUtil<TbPaper>(TbPaper.class);
        util.exportExcel(response, list, "试卷管理数据");
    }
}
