package com.huaxing.vo;
import java.util.List;

import com.huaxing.bean.ElectricPricePower;
import com.huaxing.common.web.transfer.TransferObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel(value="电度电价信息")
@Data
public class ElectricPricePowerVo extends TransferObject<ElectricPricePower> {
	//电度电价类型 0 单一 1 自定义
	@ApiModelProperty(value="电度电价类型（0单一1自定义）",required=true)
	private String type;
	//电价
	@ApiModelProperty(value="电度电价(单一时返回)",required=false)
	private String value;
	@ApiModelProperty(value="电度电价阶梯启用标志（0不启用1启用）",required=true)
	//阶梯标志 0 不启用 1 启用
	private String isladder;
	//mine
	@ApiModelProperty(value="电度电价分时（尖时段；自定义时返回）",required=false)
	private List<String> sharpTimeArr;//尖时段
	@ApiModelProperty(value="电度电价分时（峰时段；自定义时返回）",required=false)
	private List<String> peakTimeArr;//峰时段
	@ApiModelProperty(value="电度电价分时（平时段；自定义时返回）",required=false)
	private List<String> flatTimeArr;//平时段
	@ApiModelProperty(value="电度电价分时（谷时段；自定义时返回）",required=false)
	private List<String> valleyTimeArr;//谷时段
	@ApiModelProperty(value="尖电价；自定义时返回",required=false)
	private String sharpPrice;//尖电价
	@ApiModelProperty(value="峰电价；自定义时返回",required=false)
	private String peakPrice;//峰电价
	@ApiModelProperty(value="平电价；自定义时返回",required=false)
	private String flatPrice;//平电价
	@ApiModelProperty(value="谷电价；自定义时返回",required=false)
	private String valleyPrice;//谷电价
}
