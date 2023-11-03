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
import com.ruoyi.project.csp.domain.TbExam;
import com.ruoyi.project.csp.service.ITbExamService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 考试管理Controller
 * 
 * @author zzz
 * @date 2023-11-03
 */
@RestController
@RequestMapping("/dataControl/exam")
public class TbExamController extends BaseController
{
    @Autowired
    private ITbExamService tbExamService;

    /**
     * 查询考试管理列表
     */
    @PreAuthorize("@ss.hasPermi('dataControl:exam:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbExam tbExam)
    {
        startPage();
        List<TbExam> list = tbExamService.selectTbExamList(tbExam);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('dataControl:exam:list')")
    @GetMapping("/getAllUser")
    public AjaxResult getAllUser()
    {
        return success(tbExamService.getAllUser());
    }

    /**
     * 导出考试管理列表
     */
    @PreAuthorize("@ss.hasPermi('dataControl:exam:export')")
    @Log(title = "考试管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbExam tbExam)
    {
        List<TbExam> list = tbExamService.selectTbExamList(tbExam);
        ExcelUtil<TbExam> util = new ExcelUtil<TbExam>(TbExam.class);
        util.exportExcel(response, list, "考试管理数据");
    }

    /**
     * 获取考试管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('dataControl:exam:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbExamService.selectTbExamById(id));
    }

    /**
     * 新增考试管理
     */
    @PreAuthorize("@ss.hasPermi('dataControl:exam:add')")
    @Log(title = "考试管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbExam tbExam)
    {
        return toAjax(tbExamService.insertTbExam(tbExam));
    }

    /**
     * 修改考试管理
     */
    @PreAuthorize("@ss.hasPermi('dataControl:exam:edit')")
    @Log(title = "考试管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbExam tbExam)
    {
        return toAjax(tbExamService.updateTbExam(tbExam));
    }

    /**
     * 删除考试管理
     */
    @PreAuthorize("@ss.hasPermi('dataControl:exam:remove')")
    @Log(title = "考试管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbExamService.deleteTbExamByIds(ids));
    }
}
