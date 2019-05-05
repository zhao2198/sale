package com.huaxing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.util.StringUtil;
import com.huaxing.bean.NgtUser;
import com.huaxing.common.exception.ResponseStatus;
import com.huaxing.common.paging.Paging;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.secutiry.EncryUtil;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.common.utils.Constants;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.modules.util.PropertiesUtil;
import com.huaxing.repository.NgtRoleRepository;
import com.huaxing.repository.NgtUserRepository;
import com.huaxing.service.NgtUserService;
import com.huaxing.util.ConvertUtil;
import com.huaxing.util.NgtStatus;
import com.huaxing.vo.NgtUserVO;

@Service
public class NgtUserServiceImpl extends BaseServiceImpl<NgtUser> implements NgtUserService {
	@Autowired
	private NgtUserRepository userRepository;

	@Autowired
	private NgtRoleRepository releRepository;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = userRepository;
	}

	@Override
	public RestResult<String> deleteBatch(String[] ids) {
		if (null != ids) {
			for (int i = 0; i < ids.length; i++) {
				String userId = ids[i];
				this.delete(userId);

			}
			return this.result(ids.length);
		}
		return RestResultUtil.getResult(ResponseStatus.MISS_REQUIRED_PARAMETE);

	}

	@Override
	@Transactional
	public RestResult<String> createUser(NgtUser user) {
		if (userRepository.isExists(user) > 0) {
			return RestResultUtil.getResult(NgtStatus.NGTUSER_NAME_EXISTS);
		}
		user.setUUID();
		user.setPassword(EncryUtil.entryptPassword(Constants.DEFAULT_PASSWORD));
		int count = userRepository.save(user);

		return this.result(count);
	}

	@Override
	@Transactional
	public RestResult<String> modifyUser(NgtUser user) {
		if (userRepository.isExists(user) > 0) {
			return RestResultUtil.getResult(NgtStatus.NGTUSER_NAME_EXISTS);
		}
		int count = userRepository.update(user);
		return this.result(count);
	}

	@Override
	public PagingList<NgtUserVO> queryList(NgtUser user, PagingAttribute pageAttr) {
		// 使用分页插件
		Page page = pageAttr.toPage();

		// 查询MODEL
		List<NgtUser> list = userRepository.queryList(user);

		// // 将MODEL转换为VO
		//
		// List<NgtUserVO> distList = this.toListVO(list, NgtUserVO.class);
		//
		// // 替换公司
		// ConvertUtil.convertListOffice(distList, "officeId", "officeName");
		//
		// // 构建分页对象
		// Paging paging = new Paging(page.getTotal(), pageAttr);

		return buildUserList(list, page, pageAttr);
	}

	@Override
	public NgtUserVO getNgtUserById(String id) {
		NgtUser user = userRepository.get(id);
		NgtUserVO userVO = new NgtUserVO();
		this.toVO(user, userVO);
		ConvertUtil.convertOffice(userVO, user.getOfficeId(), "officeName");
		String photo = userVO.getPhoto();
		if(StringUtil.isNotEmpty(photo)) {
			userVO.setPhotoUrl(PropertiesUtil.getUploadDomain() + photo);
		}
		return userVO;
	}

	@Override
	public RestResult<String> modifyPassword(String userId) {
		NgtUser user = new NgtUser();
		user.setId(userId);
		user.setPassword(EncryUtil.entryptPassword(Constants.DEFAULT_PASSWORD));
		int count = userRepository.updatePassword(user);
		return this.result(count);
	}

	@Override
	public PagingList<NgtUserVO> queryListByRoleId(NgtUser user, String roleId, PagingAttribute pageAttr) {
		// 使用分页插件
		Page page = pageAttr.toPage();

		// 查询MODEL
		List<NgtUser> list = userRepository.queryListByRoleId(user, roleId);

		return buildUserList(list, page, pageAttr);
	}

	private PagingList<NgtUserVO> buildUserList(List<NgtUser> list, Page page, PagingAttribute pageAttr) {
		if (null != list && list.size() > 0) {
			List<NgtUserVO> distList = this.toListVO(list, NgtUserVO.class);

			// 替换公司
			ConvertUtil.convertListOffice(distList, "officeId", "officeName");

			// 构建分页对象
			Paging paging = new Paging(page.getTotal(), pageAttr);

			return new PagingList<NgtUserVO>(distList, paging);
		}
		return null;
	}

	/*
	 * Create Date 2018年6月29日 下午2:08:25
	 * 
	 * @author zhao wei
	 * 
	 * @see com.huaxing.service.NgtUserService#delete(java.lang.String)
	 */
	@Override
	@Transactional
	public RestResult<String> delete(String userId) {
		int count = userRepository.delete(userId);
		releRepository.deleteUserRole(userId);
		return this.result(count);
	}

}
