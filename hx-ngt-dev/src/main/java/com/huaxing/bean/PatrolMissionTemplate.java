package com.huaxing.bean;

import java.util.Date;
import java.util.List;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PatrolMissionTemplate extends PatrolScheme {
	private String patrolSchemeId;
}
