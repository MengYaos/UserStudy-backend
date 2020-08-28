package com.firsts.survey.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Table(name = "result_info")
public class ResultInfoDto implements Serializable {
    @Id
    @Column(name = "id")
    /**
     * 结果id 自增
     */
    private Long id;

    /**
     * 第几阶段的标志位  1  2
     */
    @Column(name = "PHASE_FLAG")
    private Integer flag;

    /**
     * 效果图序列
     */
    @Column(name = "RENDERING_SEQUENCE")
    private String renderingSequence;

    /**
     * 内容完整性
     */
    @Column(name = "CONTENT_INTEGRITY")
    private String contentIntegrity;

    /**
     * 风格化程度
     */
    @Column(name = "STYLIZATION_LEVEL")
    private String stylizationLevel;

    /**
     * 整体质量
     */
    @Column(name = "OVERALL_QUALITY")
    private String overallQuality;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;
}
