package com.ebiz.comm.service;

import java.util.List;

import com.ebiz.comm.domain.SysModule;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-29 19:22:51
 */
public interface SysModuleService {

	Long createSysModule(SysModule entity);

	int modifySysModule(SysModule entity);

	int removeSysModule(SysModule entity);

	SysModule getSysModule(SysModule entity);

	List<SysModule> getSysModuleList(SysModule entity);

	Long getSysModuleCount(SysModule entity);

	List<SysModule> getSysModulePaginatedList(SysModule entity);

}