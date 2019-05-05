package com.huaxing.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.modules.util.FileCopyUtil;
import com.huaxing.modules.util.PropertiesUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 文件上传接口 Create Date: 2018年7月4日 上午10:46:12
 * 
 * @version: V3.0.1
 * @author: zhao wei
 */
@Api(tags = { "能管在线：文件上传接口" })
@RestController
@RequestMapping("/api/file")
public class FileUploadController {

	/**
	 * 信息
	 */
	@ApiOperation(value = "通用上传文件", notes = "")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public RestResult<Object> upload(@RequestParam(value = "file", required = true) MultipartFile file) {
		if (null != file) {
			String path = FileCopyUtil.copy(file);
			String fullPath = PropertiesUtil.getUploadDomain() + path;
			Map<String, String> map = new HashMap<String, String>();
			map.put("path", path);
			map.put("url", fullPath);
			return RestResultUtil.ok(map);
		}
		return RestResultUtil.failed();
	}

}
