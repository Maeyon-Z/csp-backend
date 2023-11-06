package com.ruoyi.project.cspCommon.params;

import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneratePracticeParams extends BaseEntity {

    private Integer count;

    private Integer type;
}
