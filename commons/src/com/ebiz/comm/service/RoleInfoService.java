package com.ebiz.comm.service;

import java.util.List;

import com.ebiz.comm.domain.RoleInfo;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-29 19:22:51
 */
public interface RoleInfoService {

	Long createRoleInfo(RoleInfo entity);

	int modifyRoleInfo(RoleInfo entity);

	int removeRoleInfo(RoleInfo entity);

	RoleInfo getRoleInfo(RoleInfo entity);

	List<RoleInfo> getRoleInfoList(RoleInfo entity);

	Long getRoleInfoCount(RoleInfo entity);

	List<RoleInfo> getRoleInfoPaginatedList(RoleInfo entity);

}