package com.ebiz.comm.web.utils;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Xing, XiuDong
 * @version 2010-07-19 16:30
 */
public class Messages {

	private String bundle_name;

	private ResourceBundle resourceBundle = null;

	public Messages() {

	}

	public Messages(String bundleName) {
		this.bundle_name = bundleName;
		resourceBundle = ResourceBundle.getBundle(bundleName);
	}

	public void init() {
		resourceBundle = ResourceBundle.getBundle(bundle_name);
	}

	public String getString(String key) {
		try {
			return resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public String getString(String key, Object... params) {
		try {
			return MessageFormat.format(resourceBundle.getString(key), params);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public String getBundle_name() {
		return bundle_name;
	}

	public void setBundle_name(String bundle_name) {
		this.bundle_name = bundle_name;
	}

	public void destroy() {
		ResourceBundle.clearCache(Messages.class.getClassLoader());
	}

}
