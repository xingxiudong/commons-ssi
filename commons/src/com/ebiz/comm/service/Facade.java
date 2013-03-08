package com.ebiz.comm.service;

import com.ebiz.ssi2.service.BaseFacade;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-29 19:22:51
 */
public interface Facade extends BaseFacade {

	BaseTypeService getBaseTypeService();
	
	RoleInfoService getRoleInfoService();
	
	RoleUserService getRoleUserService();
	
	SysModuleService getSysModuleService();
	
	UserInfoService getUserInfoService();

	ViewTreeItemService getViewTreeItemService();
	
}