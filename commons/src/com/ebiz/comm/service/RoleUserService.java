package com.ebiz.comm.service;

import java.util.List;

import com.ebiz.comm.domain.RoleUser;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-29 19:22:51
 */
public interface RoleUserService {

	Long createRoleUser(RoleUser entity);

	int modifyRoleUser(RoleUser entity);

	int removeRoleUser(RoleUser entity);

	RoleUser getRoleUser(RoleUser entity);

	List<RoleUser> getRoleUserList(RoleUser entity);

	Long getRoleUserCount(RoleUser entity);

	List<RoleUser> getRoleUserPaginatedList(RoleUser entity);

}