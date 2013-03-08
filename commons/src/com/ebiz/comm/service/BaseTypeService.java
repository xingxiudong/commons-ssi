package com.ebiz.comm.service;

import java.util.List;

import com.ebiz.comm.domain.BaseType;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-29 19:22:51
 */
public interface BaseTypeService {

	Long createBaseType(BaseType entity);

	int modifyBaseType(BaseType entity);

	int removeBaseType(BaseType entity);

	BaseType getBaseType(BaseType entity);

	List<BaseType> getBaseTypeList(BaseType entity);

	Long getBaseTypeCount(BaseType entity);

	List<BaseType> getBaseTypePaginatedList(BaseType entity);

}