package com.huaxing.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.util.StringUtil;
import com.huaxing.repository.NgtCodeRepository;
import com.huaxing.service.NgtCodeService;
import com.huaxing.util.NgtDefine.TableEnum;

@Service
public class NgtCodeServiceImpl implements NgtCodeService {

	@Autowired
	private NgtCodeRepository codeRepository;

	@Override
	public synchronized String genCode(TableEnum tableType, String companyId) {
		StringBuffer sb = new StringBuffer();
		do {
			sb.setLength(0);
			String time = getTime();
			String tableName = tableType.getTableName();
			String code = codeRepository.getLastCode(tableName, time, companyId);
			String strCode = "000001";
			if (StringUtil.isNotEmpty(code)) {
				String lastCode = code.substring(code.lastIndexOf("-") + 1);
				int num = Integer.parseInt(lastCode);
				num++;
				strCode = String.format("%06d", num);
			}
			sb.append("NGT").append("-").append(time).append("-").append(strCode);
		} while (sb.length()>0 && isExistsCode(tableType,sb.toString(),companyId));

		return sb.toString();
	}

	private String getTime() {
		StringBuffer sb = new StringBuffer();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		sb.append(year);
		if (month < 10) {
			sb.append("0");
		}
		sb.append(month);
		return sb.toString();
	}

	@Override
	public boolean isExistsCode(TableEnum tableType, String code, String companyId) {
		String tableName = tableType.getTableName();
		return codeRepository.isExists(tableName, code, companyId)>0;
	}

}
