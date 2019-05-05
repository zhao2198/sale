package com.huaxing.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.huaxing.bean.PatrolMission;
import com.huaxing.bean.PatrolMissionContent;
import com.huaxing.bean.PatrolSchemeContent;
import com.huaxing.common.web.transfer.TransferObject;
import com.huaxing.util.NgtConvertUtil;
import com.huaxing.vo.PatrolMissionContentVO;

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
@ApiModel(value = "")
@Data
@EqualsAndHashCode(callSuper = false)
public class PatrolMissionDTO extends TransferObject<PatrolMission> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键", required = true)
	@NotBlank(message="任务ID不能为空")
	private String id;

	@Valid
	@ApiModelProperty(value = "巡检记录集合", required = true)
	@Size(min=1,message="巡检记录不能为空")
	private List<PatrolMissionContentDTO> contentList;

	@Override
	public PatrolMission toObject(Class<PatrolMission> clazz) {
		PatrolMission mission = super.toObject(clazz);
		if(contentList != null && contentList.size()!=0) {
			List<PatrolMissionContent> missionContentList = new ArrayList<>();
			for (PatrolMissionContentDTO patrolMissionContentDTO : contentList) {
				PatrolMissionContent contentTemp = patrolMissionContentDTO.toObject(PatrolMissionContent.class);
				missionContentList.add(contentTemp);
			}
			mission.setContentList(missionContentList);
		}
		return mission;
	}


	
	
}
