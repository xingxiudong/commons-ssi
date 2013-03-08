package com.ebiz.comm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.comm.dao.SysModuleDao;
import com.ebiz.comm.domain.SysModule;
import com.ebiz.comm.service.SysModuleService;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-29 19:22:51
 */
@Service
public class SysModuleServiceImpl implements SysModuleService {

	@Resource
	private SysModuleDao sysModuleDao;

	public Long createSysModule(SysModule entity) {
		return this.sysModuleDao.insert(entity);
	}

	public int modifySysModule(SysModule entity) {
		return this.sysModuleDao.update(entity);
	}

	public int removeSysModule(SysModule entity) {
		return this.sysModuleDao.delete(entity);
	}

	public SysModule getSysModule(SysModule entity) {
		return this.sysModuleDao.select(entity);
	}

	public List<SysModule> getSysModuleList(SysModule entity) {
		return this.sysModuleDao.selectList(entity);
	}

	public Long getSysModuleCount(SysModule entity) {
		return this.sysModuleDao.count(entity);
	}

	public List<SysModule> getSysModulePaginatedList(SysModule entity) {
		return this.sysModuleDao.selectPaginatedList(entity);
	}

}
