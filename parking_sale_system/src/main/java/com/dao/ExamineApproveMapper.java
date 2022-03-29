package com.dao;
import java.util.List;
import com.bean.ExamineApprove;
import org.apache.ibatis.annotations.Param;

public interface ExamineApproveMapper {
    boolean insertExamineApprove(ExamineApprove examineApprove);
    List<ExamineApprove> selectExamineApprove(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize,@Param("state") int state);
    List<ExamineApprove> selectHisExamineApprove(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize,@Param("adminId") String adminId,@Param("state1") int state1,@Param("state2")int state2);
    boolean updateExamineApproveState(@Param("state") int state,@Param("eId") String eId,@Param("adminId") String adminId);
    ExamineApprove selectExamineApproveById(@Param("eId") String eId);
}
