package com.ebiz.ssi2.service;

import java.util.Map;

/**
 * @author Liu,AiZhou
 */
public interface TemplateService {

	String getContent(String templateName, Map<String, Object> model);

}
