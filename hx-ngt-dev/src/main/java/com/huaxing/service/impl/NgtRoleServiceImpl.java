package com.huaxing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.huaxing.bean.NgtRole;
import com.huaxing.common.paging.Paging;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.repository.NgtMenuRepository;
import com.huaxing.repository.NgtRoleRepository;
import com.huaxing.service.NgtRoleService;
import com.huaxing.util.ConvertUtil;
import com.huaxing.util.NgtStatus;
import com.huaxing.vo.NgtRoleVO;

@Service
public class NgtRoleServiceImpl extends BaseServiceImpl<NgtRole> implements NgtRoleService {
	@Autowired
	private NgtRoleRepository roleRepository;

	@Autowired
	private NgtMenuRepository menuRepository;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = roleRepository;
	}

	/*
	 * Create Date 2018年6月29日 上午11:06:27
	 * 
	 * @author zhao wei
	 * 
	 * @see com.huaxing.service.NgtRoleService#deleteBatch(java.lang.String[])
	 */
	@Override
	public RestResult<String> deleteBatch(String[] ids) {
		if (null != ids) {
			for (String roleId : ids) {
				if (roleRepository.isExistUser(roleId) > 0) {
					return RestResultUtil.getResult(NgtStatus.NGTROLE_EXISTS_USER);
				}
			}

			for (String roleId : ids) {
				roleRepository.delete(roleId);
				menuRepository.deletRoleMenuId(roleId);
			}
		}
		return this.result(1);
	}

	/*
	 * Create Date 2018年6月29日 上午11:06:23
	 * 
	 * @author zhao wei
	 * 
	 * @see com.huaxing.service.NgtRoleService#createRole(com.huaxing.bean.NgtRole)
	 */
	@Override
	public RestResult<String> createRole(NgtRole role) {
		if (roleRepository.isExists(role) > 0) {
			return RestResultUtil.getResult(NgtStatus.NGTROLE_NAME_EXISTS);
		}
		role.setUUID();
		int count = roleRepository.save(role);
		return this.result(count);
	}

	/*
	 * Create Date 2018年6月29日 上午11:06:20
	 * 
	 * @author zhao wei
	 * 
	 * @see com.huaxing.service.NgtRoleService#modifyRole(com.huaxing.bean.NgtRole)
	 */
	@Override
	public RestResult<String> modifyRole(NgtRole role) {
		if (roleRepository.isExists(role) > 0) {
			return RestResultUtil.getResult(NgtStatus.NGTROLE_NAME_EXISTS);
		}
		int count = roleRepository.update(role);
		return this.result(count);
	}

	/*
	 * Create Date 2018年6月29日 上午11:06:17
	 * 
	 * @author zhao wei
	 * 
	 * @see com.huaxing.service.NgtRoleService#queryList(com.huaxing.bean.NgtRole, com.huaxing.common.paging.PagingAttribute)
	 */
	@Override
	public PagingList<NgtRoleVO> queryList(NgtRole role, PagingAttribute pageAttr) {
		// 使用分页插件
		Page page = pageAttr.toPage();

		// 查询MODEL
		List<NgtRole> list = roleRepository.queryList(role);

		// 将MODEL转换为VO

		List<NgtRoleVO> distList = this.toListVO(list, NgtRoleVO.class);

		// 替换组织
		ConvertUtil.convertListOffice(distList, "officeIdNotuse", "officeName");

		// 构建分页对象
		Paging paging = new Paging(page.getTotal(), pageAttr);

		return new PagingList<NgtRoleVO>(distList, paging);
	}

	/*
	 * Create Date 2018年6月29日 上午11:06:13
	 * 
	 * @author zhao wei
	 * 
	 * @see com.huaxing.service.NgtRoleService#getNgtRoleById(java.lang.String)
	 */
	@Override
	public NgtRoleVO getNgtRoleById(String id) {
		NgtRole user = roleRepository.get(id);
		NgtRoleVO roleVO = new NgtRoleVO();
		this.toVO(user, roleVO);
		return roleVO;
	}

	/*
	 * Create Date 2018年6月29日 上午11:06:07
	 * 
	 * @author zhao wei
	 * 
	 * @see com.huaxing.service.NgtRoleService#saveRoleUser(java.lang.String, java.util.List)
	 */
	@Override
	public RestResult<String> saveRoleUser(String roleId, List<String> userIds) {
		int count = roleRepository.saveRoleUser(roleId, userIds);
		return this.result(count);
	}

	@Override
	@Transactional
	public RestResult<String> delete(String id) {
		if (roleRepository.isExistUser(id) > 0) {
			return RestResultUtil.getResult(NgtStatus.NGTROLE_EXISTS_USER);
		}

		int count = roleRepository.delete(id);
		menuRepository.deletRoleMenuId(id);
		return this.result(count);
	}

	@Override
	public List<NgtRoleVO> queryList(NgtRole role, String userId) {
		// 查询MODEL
		List<NgtRole> list = roleRepository.queryList(role);
		List<NgtRoleVO> distList = this.toListVO(list, NgtRoleVO.class);
		if(null != distList && distList.size() > 0) {
			List<NgtRole> userRoleList = roleRepository.queryListByUserId(userId);
			for(NgtRoleVO beanItemVO : distList) {
				
				for(NgtRole beanItem : userRoleList) {
					if(beanItemVO.getId().equals(beanItem.getId())) {
						beanItemVO.setChecked(true);
					}
				}
			}
		}
		return distList;
	}

	@Override
	@Transactional
	public RestResult<String> saveUserRole(String userId, List<String> roleIds) {
		roleRepository.deleteUserRole(userId);
		int count = roleRepository.saveUserRole(userId, roleIds);
		return this.result(count);
	}

}
