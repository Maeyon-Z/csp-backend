package com.ruoyi.project.cspCommon.mapper;

import java.util.List;
import com.ruoyi.project.cspCommon.domain.TbExamUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 考试-用户映射（记录参加考试的用户）Mapper接口
 *
 * @author zzz
 * @date 2023-11-03
 */
@Mapper
public interface TbExamUserMapper
{
    /**
     * 查询考试-用户映射（记录参加考试的用户）
     *
     * @param id 考试-用户映射（记录参加考试的用户）主键
     * @return 考试-用户映射（记录参加考试的用户）
     */
    public TbExamUser selectTbExamUserById(Long id);

    /**
     * 查询考试-用户映射（记录参加考试的用户）列表
     *
     * @param tbExamUser 考试-用户映射（记录参加考试的用户）
     * @return 考试-用户映射（记录参加考试的用户）集合
     */
    public List<TbExamUser> selectTbExamUserList(TbExamUser tbExamUser);

    /**
     * 新增考试-用户映射（记录参加考试的用户）
     *
     * @param tbExamUser 考试-用户映射（记录参加考试的用户）
     * @return 结果
     */
    public int insertTbExamUser(TbExamUser tbExamUser);

    /**
     * 修改考试-用户映射（记录参加考试的用户）
     *
     * @param tbExamUser 考试-用户映射（记录参加考试的用户）
     * @return 结果
     */
    public int updateTbExamUser(TbExamUser tbExamUser);

    /**
     * 删除考试-用户映射（记录参加考试的用户）
     *
     * @param id 考试-用户映射（记录参加考试的用户）主键
     * @return 结果
     */
    public int deleteTbExamUserById(Long id);

    /**
     * 批量删除考试-用户映射（记录参加考试的用户）
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbExamUserByIds(Long[] ids);

    List<Long> getExamUsersByExamId(Long examId);

    int startExam(TbExamUser tbExamUser);
}
