package com.ebiz.comm.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.ebiz.comm.dao.UserInfoDao;
import com.ebiz.comm.domain.UserInfo;
import com.ebiz.ssi2.dao.mybitis.EntityMybatisDaoImpl;

@Repository
public class UserInfoDaoImpl extends EntityMybatisDaoImpl<UserInfo> implements UserInfoDao {

}
