package com.ebiz.comm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.comm.dao.BaseTypeDao;
import com.ebiz.comm.domain.BaseType;
import com.ebiz.comm.service.BaseTypeService;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-29 19:22:51
 */
@Service
public class BaseTypeServiceImpl implements BaseTypeService {

	@Resource
	private BaseTypeDao baseTypeDao;

	public Long createBaseType(BaseType entity) {
		return this.baseTypeDao.insert(entity);
	}

	public int modifyBaseType(BaseType entity) {
		return this.baseTypeDao.update(entity);
	}

	public int removeBaseType(BaseType entity) {
		return this.baseTypeDao.delete(entity);
	}

	public BaseType getBaseType(BaseType entity) {
		return this.baseTypeDao.select(entity);
	}

	public List<BaseType> getBaseTypeList(BaseType entity) {
		return this.baseTypeDao.selectList(entity);
	}

	public Long getBaseTypeCount(BaseType entity) {
		return this.baseTypeDao.count(entity);
	}

	public List<BaseType> getBaseTypePaginatedList(BaseType entity) {
		return this.baseTypeDao.selectPaginatedList(entity);
	}

}
