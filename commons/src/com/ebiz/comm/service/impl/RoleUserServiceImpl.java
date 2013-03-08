package com.ebiz.comm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.comm.dao.RoleUserDao;
import com.ebiz.comm.domain.RoleUser;
import com.ebiz.comm.service.RoleUserService;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-29 19:22:51
 */
@Service
public class RoleUserServiceImpl implements RoleUserService {

	@Resource
	private RoleUserDao roleUserDao;

	public Long createRoleUser(RoleUser entity) {
		return this.roleUserDao.insert(entity);
	}

	public int modifyRoleUser(RoleUser entity) {
		return this.roleUserDao.update(entity);
	}

	public int removeRoleUser(RoleUser entity) {
		return this.roleUserDao.delete(entity);
	}

	public RoleUser getRoleUser(RoleUser entity) {
		return this.roleUserDao.select(entity);
	}

	public List<RoleUser> getRoleUserList(RoleUser entity) {
		return this.roleUserDao.selectList(entity);
	}

	public Long getRoleUserCount(RoleUser entity) {
		return this.roleUserDao.count(entity);
	}

	public List<RoleUser> getRoleUserPaginatedList(RoleUser entity) {
		return this.roleUserDao.selectPaginatedList(entity);
	}

}
