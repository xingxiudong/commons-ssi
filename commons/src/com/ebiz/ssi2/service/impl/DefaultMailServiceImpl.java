package com.ebiz.ssi2.service.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.ebiz.ssi2.service.MailService;
import com.ebiz.ssi2.service.TemplateService;

/**
 * @author Xing,XiuDong
 * @version 2010.07.07
 */
public class DefaultMailServiceImpl implements MailService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private JavaMailSender mailSender;

	@Resource
	private TemplateService templateService;

	private String from = "";

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setTemplateService(TemplateService templateService) {
		this.templateService = templateService;
	}

	public void send(SimpleMailMessage mailMessage) {
		mailSender.send(mailMessage);
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void send(SimpleMailMessage msg, String templateName, Map<String, Object> model) {
		String content = templateService.getContent(templateName, model);
		MimeMessage mimeMsg = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true, "UTF-8");
			helper.setTo(msg.getTo());
			helper.setSubject(msg.getSubject());
			helper.setFrom(getFrom());
			helper.setText(content, true);
			mailSender.send(mimeMsg);
		} catch (MessagingException ex) {
			logger.error(ex.getMessage(), ex);
		}
	}
}
