package com.ebiz.comm.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch.qos.logback.classic.Logger;

import com.ebiz.comm.domain.UserInfo;

public class FacadeTest {

	public Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	static Facade facade;

	@BeforeClass
	public static void setUp() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		facade = (Facade) context.getBean("facade");
	}

	@Test
	public void testGetUserInfoService() {
		for (int i = 11; i < 100; i++) {
			logger.info("*** i = {}", i);
			UserInfo entity = new UserInfo();
			entity.setUser_id(Integer.valueOf(i));
			entity.setUser_name("许晴" + i);
			entity.setPass_word("8888" + i);
			Long id = facade.getUserInfoService().createUserInfo(entity);
			logger.info("*** id : {}", id);
		}

	}
}
