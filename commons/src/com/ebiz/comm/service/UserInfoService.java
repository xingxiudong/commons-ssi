package com.ebiz.comm.service;

import java.util.List;

import com.ebiz.comm.domain.UserInfo;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-29 19:22:51
 */
public interface UserInfoService {

	Long createUserInfo(UserInfo entity);

	int modifyUserInfo(UserInfo entity);

	int removeUserInfo(UserInfo entity);

	UserInfo getUserInfo(UserInfo entity);

	List<UserInfo> getUserInfoList(UserInfo entity);

	Long getUserInfoCount(UserInfo entity);

	List<UserInfo> getUserInfoPaginatedList(UserInfo entity);

}