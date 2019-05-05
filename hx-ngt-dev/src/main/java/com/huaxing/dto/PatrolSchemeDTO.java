package com.huaxing.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.PatrolScheme;
import com.huaxing.bean.PatrolSchemeContent;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;
import com.huaxing.util.NgtConvertUtil;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
@ApiModel(value = "巡检计划用于新增修改")
@Data
@EqualsAndHashCode(callSuper = false)
public class PatrolSchemeDTO extends TransferObject<PatrolScheme> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键", required = false)
	@NotEmpty(message = "ID不能为空", groups = { UpdateGroup.class })
	private String id;

	// 巡检类别(计划,夜间,故障,临时等)
	@ApiModelProperty(value = "巡检类别(0计划巡检,1故障巡检，2特巡，3夜间巡检，4检查巡检，5临时巡检，6定期巡检)", required = false)
	@Pattern(regexp = "^[0,1,2,3,4,5,6]{1}$", message = "巡检类别仅可传入(0计划巡检,1故障巡检，2特巡，3夜间巡检，4检查巡检，5临时巡检，6定期巡检)", groups = { AddGroup.class,
			UpdateGroup.class })
	private String type;
	// 周期
	@ApiModelProperty(value = "周期", required = true)
	@Positive(message = "周期不能小于0", groups = { AddGroup.class, UpdateGroup.class })
	private Integer period;
	// 计划开始执行的日期
	@ApiModelProperty(value = "计划开始执行的日期", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startDate;
	// 巡检人id
	@ApiModelProperty(value = "巡检人id", required = true)
	// @NotEmpty(message = "巡检人不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String handlerId;
	// 计划终止方式(0始终运行,1按次数,2按日期)
	@ApiModelProperty(value = "计划终止方式(0始终运行,1按次数,2按日期)", required = false)
	@Pattern(regexp = "^[0,1,2]{1}$", message = "计划终止方式仅可传入(0始终运行,1按次数,2按日期)", groups = { AddGroup.class, UpdateGroup.class })
	private String terminationCondition;
	// 计划终止的参数
	@ApiModelProperty(value = "计划终止的参数", required = false)
	// @NotEmpty(message = "计划终止的参数不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String terminationParameter;

	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;

	@Valid
	@ApiModelProperty(value = "巡检内容集合", required = false)
	@Size(min = 1, message = "巡检内容至少为1个", groups = { AddGroup.class, UpdateGroup.class })
	private List<PatrolSchemeContentDTO> contentList;

	@Override
	public PatrolScheme toObject(Class<PatrolScheme> clazz) {
		PatrolScheme scheme = super.toObject(clazz);
		if (null != this.contentList && this.contentList.size() > 0) {
			List<PatrolSchemeContent> contentList = new ArrayList<PatrolSchemeContent>();

			for (PatrolSchemeContentDTO contentDTO : this.contentList) {
				PatrolSchemeContent contentTemp = contentDTO.toObject(PatrolSchemeContent.class);
				NgtConvertUtil.convertEquipment(contentTemp, contentTemp.getEquipmentId(), "equipmentName");
				contentList.add(contentTemp);
			}

			scheme.setContentList(contentList);
		}
		return scheme;
	}
}
