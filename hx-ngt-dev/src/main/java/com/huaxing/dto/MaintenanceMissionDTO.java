package com.huaxing.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.huaxing.bean.MaintenanceMission;
import com.huaxing.bean.MaintenanceMissionContent;
import com.huaxing.common.web.transfer.TransferObject;
import com.huaxing.vo.MaintenanceMissionContentVO;

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
@ApiModel(value = "")
public class MaintenanceMissionDTO extends TransferObject<MaintenanceMission> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;

	@Valid
	@ApiModelProperty(value = "内容列表", required = false)
	private List<MaintenanceMissionContentVO> contentList;

	// // 编号
	// @ApiModelProperty(value = "编号", required = false)
	// private String code;
	// // 受理人
	// @ApiModelProperty(value = "受理人", required = false)
	// private String handlerId;
	// // 希完工日
	// @ApiModelProperty(value = "希完工日", required = false)
	// private String hopeTime;
	//
	// // 公司
	// @ApiModelProperty(value = "公司", required = false)
	// private String companyId;
	// // 模板的id
	// @ApiModelProperty(value = "模板的id", required = false)
	// private String templateId;
	// // 状态0新创建1待修复2待验收3已验收已通过4验收未通过
	// @ApiModelProperty(value = "状态0新创建1待修复2待验收3已验收已通过4验收未通过", required = false)
	// private String state;
	// // 审批意见
	// @ApiModelProperty(value = "审批意见", required = false)
	// private String command;

	@Override
	public MaintenanceMission toObject(Class<MaintenanceMission> clazz) {
		MaintenanceMission mission = super.toObject(clazz);
		if (null != this.contentList && this.contentList.size() > 0) {
			List<MaintenanceMissionContent> contentList = new ArrayList<MaintenanceMissionContent>();

			for (MaintenanceMissionContentVO contentDTO : this.contentList) {
				MaintenanceMissionContent contentTemp = contentDTO.toObject(MaintenanceMissionContent.class);
				contentList.add(contentTemp);
			}

			mission.setContentList(contentList);
		}
		return mission;
	}

}
