package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.Team;
import com.huaxing.common.entity.UserEntity;
import com.huaxing.common.repository.BaseRepository;
import com.huaxing.vo.TeamVo;

/**
 * Create Date: 2018年6月22日 下午1:59:56
 * 
 * @version: V3.0.1
 * @author: Xie Ning
 */
public interface TeamRepository extends BaseRepository<Team> {

	/**
	 * 判断是否存在相同的班组
	 * 
	 * @param team
	 * @return
	 */
	public int isExists(Team team);

	/**
	 * 通过班组的id获取该班组的所有成员
	 * 
	 * @param teamId
	 * @return
	 */
	public List<UserEntity> getMembersbyTeamId(String teamId);

	/**
	 * 获取班组列表
	 * 
	 * @param team
	 * @return
	 */
	public List<TeamVo> queryVoList(Team team);

	/**
	 * 保存值班班组成员到班组成员表
	 * 
	 * @param team
	 * @return
	 */
	public int saveTeamMembers(Team team);

	/***
	 * 
	 * @param team
	 * @return
	 */
	public List<UserEntity> getSelectableUser(Team team);

	/***
	 * 
	 * @param ids
	 * @return
	 */
	public int deleteMembers(String[] ids);

	/***
	 * 模糊查询班组编号
	 * 
	 * @param team
	 * @return
	 */
	public List<String> getLikeLyCodes(Team team);

	/***
	 * 通过班组的id获取所有班组成员的信息
	 * 
	 * @param teamId
	 */
	public List<UserEntity> getMembers(String teamId);

}
