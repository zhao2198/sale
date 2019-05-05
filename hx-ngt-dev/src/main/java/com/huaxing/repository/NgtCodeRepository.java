package com.huaxing.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NgtCodeRepository {

	@Select(value = "select code from ${tableName} where code is not null and code like concat('%', #{time}, '%') and  company_id=#{companyId} order by create_date desc limit 0,1")
	String getLastCode(@Param("tableName") String tableName, @Param("time") String time, @Param("companyId") String companyId);

	@Select(value = "select count(*) from ${tableName} where code = #{code} and  company_id=#{companyId}")
	int isExists(@Param("tableName") String tableName, @Param("code") String code, @Param("companyId") String companyId);

}
