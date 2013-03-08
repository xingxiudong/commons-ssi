package com.ebiz.ssi2.dao;

import java.util.List;

/**
 * @author XingXiuDong
 * @date 2012-07-19
 */
public abstract interface EntityDao<T> {

	public abstract Long count(T entity);

	public abstract int delete(T entity);

	public abstract Long insert(T entity);

	public abstract T select(T entity);

	public abstract List<T> selectList(T entity);

	public abstract List<T> selectPaginatedList(T entity);

	public abstract int update(T entity);

}
