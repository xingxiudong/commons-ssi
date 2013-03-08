package com.ebiz.ssi2.service;

import java.util.Map;

import org.springframework.mail.SimpleMailMessage;

/**
 * @author Xing,XiuDong
 */
public interface MailService {

	public void send(SimpleMailMessage msg);

	public void send(SimpleMailMessage msg, String templateName, Map<String, Object> model);

}
