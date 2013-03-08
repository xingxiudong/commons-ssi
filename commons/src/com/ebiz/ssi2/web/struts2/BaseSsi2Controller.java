package com.ebiz.ssi2.web.struts2;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ebiz.ssi2.domain.support.Pager;
import com.opensymphony.xwork2.ActionSupport;

public class BaseSsi2Controller extends ActionSupport {
	protected static final Logger logger = LoggerFactory.getLogger(BaseSsi2Controller.class);
	private static final long serialVersionUID = 1L;

	public static final String input = "input";
	public static final String back = "back";
	public static final String cancel = "cancel";
	public static final String browse = "browse";
	public static final String index = "index";
	public static final String show = "show";
	public static final String edit = "edit";
	public static final String editNew = "editNew";
	public static final String deleteConfirm = "deleteConfirm";

	protected String id;

//	protected Pager pager = new Pager();

	public void setId(String id) {
		this.id = id;
	}

//	public Pager getPager() {
//		return pager;
//	}
//
//	public void setPager(Pager pager) {
//		this.pager = pager;
//	}

	/**
	 * Deserialize a string to object.
	 * 
	 * @param serialize
	 *            : to serialize string object.
	 * @return Deserialize object.
	 * 
	 * @author Xing,XiuDong
	 * @version 2012-08-03
	 */
	public void deserialize(final String serialize, Object dest) {
		String[] kvs = serialize.split("&");
		String MAP_KEY = "param";
		Map<String, String> map = new HashMap<String, String>();

		try {
			for (int i = 0; i < kvs.length; i++) {
				if (null == kvs[i]) {
					continue;
				}

				String[] kv = kvs[i].split("=");
				if (null == kv || kv.length < 2) {
					continue;
				}

				String key = kv[0];
				String value = kv[1];

				if (key.indexOf('.') > 0) {
					String[] mapkvs = key.split("\\.");
					if (null != mapkvs && mapkvs.length == 2) {
						String map_attr = mapkvs[0];
						String map_key = mapkvs[1];
						String map_value = value;

						if (MAP_KEY.equals(map_attr)) {
							map.put(map_key, map_value);
						}
					}
				} else {
					BeanUtils.setProperty(dest, key, value);
				}

				logger.debug("deserialize : {} = {}", key, value);
			}
			BeanUtils.setProperty(dest, MAP_KEY, map);

		} catch (IllegalAccessException e) {
			logger.error("Deserialize IllegalAccessException : {}", e.getMessage());
		} catch (InvocationTargetException e) {
			logger.error("Deserialize InvocationTargetException : {}", e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public void decodeParams(Object src,String enc) {
		try {
			Map<Object, Object> map = BeanUtils.describe(src);
			for (Object key : map.keySet()) {
				logger.info("#################################1 {} = {}", key, map.get(key));
				if (null != map.get(key)) {
					map.put(key, URLDecoder.decode(map.get(key).toString(), enc));
				}
				logger.info("#################################2 {} = {}", key, map.get(key));
			}
			BeanUtils.populate(src, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
