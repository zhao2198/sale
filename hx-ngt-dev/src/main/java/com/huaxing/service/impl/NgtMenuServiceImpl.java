package com.huaxing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxing.bean.Permissions;
import com.huaxing.bean.TreeNode;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.common.utils.RestResult;
import com.huaxing.repository.NgtMenuRepository;
import com.huaxing.repository.SysRoleRepository;
import com.huaxing.service.NgtMenuService;

/**
 * 角色表
 * 
 * @author zhao wei
 * @date 2018-06-27 09:46:45
 */
@Service
public class NgtMenuServiceImpl extends BaseServiceImpl<Permissions> implements NgtMenuService {

	@Autowired
	private NgtMenuRepository menuRepository;

	@Autowired
	private SysRoleRepository roleRepository;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = menuRepository;

	}

	@Override
	public List<Permissions> getPermissionsByUserId(String userId, String roleId) {
		List<Permissions> list = menuRepository.getPermissionsByUserId(userId);

		// List<String> roleList = roleRepository.getPowerListByRoleId(roleId);
		//
		// for (int i = 0; i < roleList.size(); i++) {
		// for (int j = 0; j < list.size(); j++) {
		// Permissions permiss = list.get(j);
		// if (roleList.get(i).toString().equals(permiss.getId())) {
		// permiss.setChecked(true);
		// }
		// }
		// }
		return list;
	}

	@Override
	@Transactional
	public RestResult<String> createRoleMenus(String roleId, List<String> menuIds) {
		menuRepository.deletRoleMenuId(roleId);
		int count = menuRepository.saveRoleMenus(roleId, menuIds);
		return this.result(count);
	}

	@Override
	public List<TreeNode> getCurrentMenuTreeByRoleId(String userId, String roleId) {
		List<Permissions> list = menuRepository.getPermissionsByUserId(userId);

		List<String> roleList = roleRepository.getPowerListByRoleId(roleId);

		List<TreeNode> treeList = new ArrayList<TreeNode>();

		List<TreeNode> nodeList = new ArrayList<TreeNode>();

		if (null != list && list.size() > 0) {

			for (Permissions permiss : list) {
				TreeNode node = new TreeNode();
				node.setId(permiss.getId());
				node.setPid(permiss.getParentId());
				node.setName(permiss.getName());
				node.setText(node.getName());

				for (String id : roleList) {
					if (permiss.getId().equals(id)) {
						node.setChecked(true);
					}
				}

				treeList.add(node);
			}

			// 先找到所有的一级菜单
			for (int i = 0; i < treeList.size(); i++) {
				TreeNode node = treeList.get(i);
				if (node.getPid().equals("0")) {
					nodeList.add(node);
				}

			}
			// 为一级菜单设置子菜单，getChild是递归调用的
			for (TreeNode t : nodeList) {
				t.setChildren(getChild(t.getId(), treeList));
			}
		}

		return nodeList;
	}

	private List<TreeNode> getChild(String id, List<TreeNode> list) {
		// 子菜单
		List<TreeNode> childList = new ArrayList<TreeNode>();
		for (TreeNode o : list) {
			// 遍历所有节点，将父菜单id与传过来的id比较
			if (StringUtils.isNotBlank(o.getPid()) && !o.getPid().equals("0") && o.getPid().equals(id)) {
				if (o.getPid().equals(id)) {
					childList.add(o);
				}
			}
		}
		// 把子菜单的子菜单再循环一遍
		for (TreeNode o : childList) {// 没有url子菜单还有子菜单
			if (!o.getPid().equals("0")) {
				// 递归
				o.setChildren(getChild(o.getId(), list));
			}
		}
		// 递归退出条件
		if (childList.size() == 0) {
			return null;
		}
		return childList;
	}

}
