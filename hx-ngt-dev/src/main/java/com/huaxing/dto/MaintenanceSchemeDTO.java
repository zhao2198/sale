package com.huaxing.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.MaintenanceScheme;
import com.huaxing.bean.MaintenanceSchemeContent;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;
import com.huaxing.util.NgtConvertUtil;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-06 14:34:54
 */
@Data
@ApiModel(value = "定保计划用于添加")
public class MaintenanceSchemeDTO extends TransferObject<MaintenanceScheme> {
	private static final long serialVersionUID = 1L;

	// id
	@ApiModelProperty(value = "id", required = false)
	@NotEmpty(message = "ID不能为空", groups = { UpdateGroup.class })
	private String id;

	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;
	// 开始日期
	@ApiModelProperty(value = "开始日期", required = true)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startDate;
	// 周期
	@ApiModelProperty(value = "周期", required = true)
	@NotEmpty(message = "周期不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String period;
	// 希完工日
	@ApiModelProperty(value = "希完工日", required = true)
	@NotEmpty(message = "希完工日不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String hopeTime;
	// 受理人
	@ApiModelProperty(value = "受理人", required = true)
	private String handlerId;

	@Valid
	@ApiModelProperty(value = "设备检查点", required = true)
	@Size(min = 1, message = "检查设备至少为一个", groups = { AddGroup.class, UpdateGroup.class })
	private List<MaintenanceSchemeContentDTO> list;

	@Override
	public MaintenanceScheme toObject(Class<MaintenanceScheme> clazz) {
		MaintenanceScheme periodic = super.toObject(clazz);
		if (null != this.list && this.list.size() > 0) {
			List<MaintenanceSchemeContent> contentList = new ArrayList<MaintenanceSchemeContent>();

			for (MaintenanceSchemeContentDTO contentDTO : this.list) {
				MaintenanceSchemeContent contentTemp = contentDTO.toObject(MaintenanceSchemeContent.class);
				NgtConvertUtil.convertEquipment(contentTemp, contentTemp.getEquipmentId(), "equipmentName");
				contentList.add(contentTemp);
			}

			periodic.setContentList(contentList);
		}
		return periodic;
	}

}
