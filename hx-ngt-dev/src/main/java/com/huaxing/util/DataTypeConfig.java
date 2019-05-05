package com.huaxing.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix="huaxing.datatype")
public class DataTypeConfig {
	//采集变压器低压侧或高压侧的数据
	private String value;
}
