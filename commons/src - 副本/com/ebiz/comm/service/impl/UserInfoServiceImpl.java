package com.ebiz.comm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.comm.dao.UserInfoDao;
import com.ebiz.comm.domain.UserInfo;
import com.ebiz.comm.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	UserInfoDao userInfoDao;
	
	public Long createUserInfo(UserInfo entity) {
		return this.userInfoDao.insert(entity);
	}

	public int modifyUserInfo(UserInfo entity) {
		return this.userInfoDao.update(entity);
	}

	public int removeUserInfo(UserInfo entity) {
		return this.userInfoDao.delete(entity);
	}

	public UserInfo getUserInfo(UserInfo entity) {
		return this.userInfoDao.select(entity);
	}

	public List<UserInfo> getUserInfoList(UserInfo entity) {
		return this.userInfoDao.selectList(entity);
	}

	public Long getUserInfoCount(UserInfo entity) {
		return this.userInfoDao.count(entity);
	}

	public List<UserInfo> getUserInfoPaginatedList(UserInfo entity) {
		return this.userInfoDao.selectPaginatedList(entity);
	}

}
