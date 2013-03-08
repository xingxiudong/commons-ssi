package com.ebiz.ssi2.dao.mybitis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ebiz.ssi2.dao.EntityDao;

/**
 * @author XingXiuDong
 * @date 2012-07-19
 */
public class EntityMybatisDaoImpl<T> extends SqlSessionDaoSupport implements EntityDao<T> {
	protected static final Logger logger = LoggerFactory.getLogger(EntityMybatisDaoImpl.class);

	public static final String SQLID_INSERT = "insert";
	public static final String SQLID_UPDATE = "update";
	public static final String SQLID_DELETE = "delete";
	public static final String SQLID_SELECT = "select";
	public static final String SQLID_SELECT_LIST = "selectList";
	public static final String SQLID_SELECT_PAGINATED_LIST = "selectPaginatedList";
	public static final String SQLID_COUNT = "count";

	public static final String SUFFIX_DAOIMPL = "SqlMapImpl";

	private String dbDialect = "MYSQL";

	public String getDbDialect() {
		return dbDialect;
	}

	public void setDbDialect(String dbDialect) {
		if (dbDialect == null || (!dbDialect.equals("MYSQL") && !dbDialect.equals("ORACLE"))) {
			logger.error("DbDialect settings ：Only 'MYSQL' and 'ORACLE' is supportted.");
		}
		this.dbDialect = dbDialect;
	}

	public Long count(T entity) {
		return (Long) super.getSqlSession().selectOne(getStatement(SQLID_COUNT), entity);
	}

	public int delete(T entity) {
		return (int) super.getSqlSession().delete(getStatement(SQLID_DELETE), entity);
	}

	public Long insert(T entity) {
		return (long) super.getSqlSession().insert(getStatement(SQLID_INSERT), entity);
	}

	@SuppressWarnings("unchecked")
	public T select(T entity) {
		return (T) super.getSqlSession().selectOne(getStatement(SQLID_SELECT), entity);
	}

	public List<T> selectList(T entity) {
		return super.getSqlSession().selectList(getStatement(SQLID_SELECT_LIST), entity);
	}

	public List<T> selectPaginatedList(T entity) {
		return super.getSqlSession().selectList(getStatement(SQLID_SELECT_PAGINATED_LIST), entity);
	}

	public int update(T entity) {
		return (int) super.getSqlSession().update(getStatement(SQLID_UPDATE), entity);
	}

	public String getStatement(String SqlId) {
		String name = this.getClass().getName();
		name = name.replace(SUFFIX_DAOIMPL, "").replace(".mybatis", "");
		
		StringBuffer sb = new StringBuffer();
		sb.append(name).append(".").append(SqlId);
		String statement = sb.toString();
		logger.info("Mybatis excute : {}", statement);
		
		return statement;
	}
}
