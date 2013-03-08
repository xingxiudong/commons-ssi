package com.ebiz.comm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.comm.service.BaseTypeService;
import com.ebiz.comm.service.Facade;
import com.ebiz.comm.service.RoleInfoService;
import com.ebiz.comm.service.RoleUserService;
import com.ebiz.comm.service.SysModuleService;
import com.ebiz.comm.service.UserInfoService;
import com.ebiz.comm.service.ViewTreeItemService;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-29 19:22:51
 */
@Service("facade")
public class FacadeImpl implements Facade {

	@Resource
	BaseTypeService baseTypeService;
	
	@Resource
	RoleInfoService roleInfoService;
	
	@Resource
	RoleUserService roleUserService;
	
	@Resource
	SysModuleService sysModuleService;
	
	@Resource
	UserInfoService userInfoService;
	
	public BaseTypeService getBaseTypeService() {
		return baseTypeService;
	}
	
	public RoleInfoService getRoleInfoService() {
		return roleInfoService;
	}
	
	public RoleUserService getRoleUserService() {
		return roleUserService;
	}
	
	public SysModuleService getSysModuleService() {
		return sysModuleService;
	}
	
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	@Resource
	ViewTreeItemService viewTreeItemService;
	
	public ViewTreeItemService getViewTreeItemService() {
		return viewTreeItemService;
	}
}
