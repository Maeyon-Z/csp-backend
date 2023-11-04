package com.ruoyi.project.cspApi.dataControl;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.ruoyi.project.cspCommon.params.GenerateExercisesParams;
import com.ruoyi.project.cspCommon.params.PaperSaveParams;
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
import com.ruoyi.project.cspCommon.domain.TbPaper;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.cspCommon.service.ITbPaperService;

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

    @PreAuthorize("@ss.hasPermi('dataControl:paper:list')")
    @GetMapping("/getPaperListForExam")
    public AjaxResult getPaperListForExam()
    {
        return success(tbPaperService.getPaperListForExam());
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
     * 获取试卷题目
     */
    @PreAuthorize("@ss.hasPermi('dataControl:paper:query')")
    @GetMapping(value = "/getPaperExercise/{paperId}/{type}")
    public AjaxResult getPaperExercise(@PathVariable("paperId") Long paperId, @PathVariable("type") Long type)
    {
        return success(tbPaperService.getPaperExercise(paperId, type));
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

    /**
     * 保存配置好的试卷
     */
    @PreAuthorize("@ss.hasPermi('dataControl:paper:add')")
    @Log(title = "试卷管理", businessType = BusinessType.INSERT)
    @PostMapping("/save")
    public AjaxResult save(@RequestBody PaperSaveParams params)
    {
        tbPaperService.savePaper(params);
        return AjaxResult.success();
    }

    /**
     * 随机生成指定数量的指定题型的题目
     */
    @PreAuthorize("@ss.hasPermi('dataControl:paper:add')")
    @PostMapping("/genExercise/{type}")
    public AjaxResult genExercise(@RequestBody GenerateExercisesParams params, @PathVariable("type") Integer type)
    {
        return success(tbPaperService.genExercise(params, type));
    }

    /**
     * 获取某一题型的全部题目id
     */
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
