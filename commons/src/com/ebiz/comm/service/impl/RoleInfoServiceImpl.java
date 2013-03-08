package com.ebiz.comm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.comm.dao.RoleInfoDao;
import com.ebiz.comm.domain.RoleInfo;
import com.ebiz.comm.service.RoleInfoService;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-29 19:22:51
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {

	@Resource
	private RoleInfoDao roleInfoDao;

	public Long createRoleInfo(RoleInfo entity) {
		return this.roleInfoDao.insert(entity);
	}

	public int modifyRoleInfo(RoleInfo entity) {
		return this.roleInfoDao.update(entity);
	}

	public int removeRoleInfo(RoleInfo entity) {
		return this.roleInfoDao.delete(entity);
	}

	public RoleInfo getRoleInfo(RoleInfo entity) {
		return this.roleInfoDao.select(entity);
	}

	public List<RoleInfo> getRoleInfoList(RoleInfo entity) {
		return this.roleInfoDao.selectList(entity);
	}

	public Long getRoleInfoCount(RoleInfo entity) {
		return this.roleInfoDao.count(entity);
	}

	public List<RoleInfo> getRoleInfoPaginatedList(RoleInfo entity) {
		return this.roleInfoDao.selectPaginatedList(entity);
	}

}
