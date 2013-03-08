package com.ebiz.comm.service;

import java.util.List;

import com.ebiz.comm.domain.UserInfo;

public interface UserInfoService {

	Long createUserInfo(UserInfo entity);

	int modifyUserInfo(UserInfo entity);

	int removeUserInfo(UserInfo entity);

	UserInfo getUserInfo(UserInfo entity);

	List<UserInfo> getUserInfoList(UserInfo entity);

	Long getUserInfoCount(UserInfo entity);

	List<UserInfo> getUserInfoPaginatedList(UserInfo entity);

}
