package com.cxy.bms.manage.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author chenxy
 * @date 2020/4/23 9:07
 * @desc this is description
 */
@Data
@Builder
@TableName("subject_budget_declare")
@NoArgsConstructor
@AllArgsConstructor
public class Declare {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long estimatedAmount;

    private Long nodeId;

    private Long parentNodeId;

    private Long subjectId;

    private Long parentSubjectId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String createEmployee;

    private String updateEmployee;

}
