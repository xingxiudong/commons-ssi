package com.ebiz.comm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.comm.service.Facade;
import com.ebiz.comm.service.UserInfoService;

@Service("facade")
public class FacadeImpl implements Facade {

	@Resource
	UserInfoService userInfoService;

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

}
