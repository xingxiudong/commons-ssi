package com.ebiz.comm.web.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringHelper {

	private static final Logger logger = LoggerFactory.getLogger(StringHelper.class);

	/** Default placeholder prefix: "${" */
	public static final String DEFAULT_PLACEHOLDER_PREFIX = "{";

	/** Default placeholder suffix: "}" */
	public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

	/**
	 * 将集合中元素property属性的值用separator连接符连接起来
	 * 
	 * @param c
	 *            待处理的集合
	 * @param property
	 *            待连接的属性名称
	 * @param separator
	 *            连接字符串
	 * @author Xing,XiuDong
	 */
	public static String join(Collection<?> c, String property, Object separator) {
		ArrayList<String> stringBuffer = new ArrayList<String>();

		Iterator<?> iter = c.iterator();
		while (iter.hasNext()) {
			Object o = iter.next();
			try {
				stringBuffer.add(BeanUtils.getProperty(o, property));
			} catch (IllegalAccessException e) {
				logger.error(e.getMessage());
			} catch (InvocationTargetException e) {
				logger.error(e.getMessage());
			} catch (NoSuchMethodException e) {
				logger.error(e.getMessage());
			}
		}

		return (StringUtils.join(stringBuffer, separator == null ? "" : separator.toString()));
	}

	/**
	 * @param c
	 *            : must with properties : mod_id par_id, mod_name and mod_url
	 * @author Xing,XiuDong
	 * @date 2010-12-17
	 */

	public static String getMzTreeNodes(Collection<?> c) {
		return getMzTreeNodes(c, "mod_id", "mod_name", "mod_url", "par_id", "mod_name");
	}

	public static String getMzTreeNodes(Collection<?> c, String node_id_prop, String node_name_prop,
			String node_url_prop, String par_node_id_prop, String node_hint_name_prop) {
		StringBuffer sb = new StringBuffer();

		Iterator<?> iter = c.iterator();
		while (iter.hasNext()) {
			Object obj = iter.next();

			String mod_id = null;
			String par_id = null;
			String mod_name = null;
			String hint_name = null;
			String mod_url = null;

			try {
				mod_id = BeanUtils.getProperty(obj, node_id_prop);
				par_id = BeanUtils.getProperty(obj, par_node_id_prop);
				mod_name = BeanUtils.getProperty(obj, node_name_prop);
				hint_name = BeanUtils.getProperty(obj, node_hint_name_prop);
				mod_url = BeanUtils.getProperty(obj, node_url_prop);
			} catch (IllegalAccessException e) {
				logger.error("IllegalAccessException:{}", e.getMessage());
			} catch (InvocationTargetException e) {
				logger.error("InvocationTargetException:{}", e.getMessage());
			} catch (NoSuchMethodException e) {
				logger.error("NoSuchMethodException:{}", e.getMessage());
			}

			par_id = "0".equals(par_id) ? "-1" : par_id;

			String text = StringUtils.replace(mod_name, ":", "&#58;");
			if (StringUtils.isEmpty(text)) {
				continue;
			}

			sb.append("\ntree.nodes[\"").append(par_id).append("_").append(mod_id).append("\"]=\"");
			sb.append("text:").append(text).append(";");

			String hint = StringUtils.replace(hint_name, ":", "&#58;");
			if (null != hint && hint.length() > 0) {
				sb.append("hint:").append(hint).append(";");
			}

			String url = StringUtils.replace(mod_url, ":", "&#58;");
			if (url != null && url.length() > 0) {
				sb.append("url:").append(url).append(";");
			} else {
				sb.append("url:").append("Frames.do?method=main").append(";");
			}

			sb.append("data:").append(node_id_prop).append("=").append(mod_id).append(";");
			sb.append("\";");
		}

		return sb.toString();

	}

	/**
	 * @author Xing,XiuDong
	 * @version 2010-07-07
	 */
	public static String parseStringParams(String str, String begin, String end, String... params) {
		int i = 1;
		for (String s : params) {
			str = StringUtils.replace(str, begin + i++ + end, s);
		}
		return str;
	}

	public static String parseStringParams(String str, String... params) {
		return parseStringParams(str, DEFAULT_PLACEHOLDER_PREFIX, DEFAULT_PLACEHOLDER_SUFFIX, params);
	}

	/**
	 * Formats messages using parameters. For example, the call:
	 * 
	 * <pre>
	 * format(&quot;foo #0 #1&quot;, &quot;bob&quot;, &quot;joe&quot;);
	 * </pre>
	 * 
	 * will return:
	 * 
	 * <pre>
	 * foo bob joe
	 * </pre>
	 * 
	 * @param msg
	 *            The message
	 * @param args
	 *            A list of arguments. A maximum of 10 are supported.
	 * @return The formatted string
	 */
	public static String format(String msg, String... args) {
		if (msg != null && msg.length() > 0 && msg.indexOf('#') > -1) {
			StringBuilder sb = new StringBuilder();
			boolean isArg = false;
			for (int x = 0; x < msg.length(); x++) {
				char c = msg.charAt(x);
				if (isArg) {
					isArg = false;
					if (Character.isDigit(c)) {
						int val = Character.getNumericValue(c);
						if (val >= 0 && val < args.length) {
							sb.append(args[val]);
							continue;
						}
					}
					sb.append('#');
				}
				if (c == '#') {
					isArg = true;
					continue;
				}
				sb.append(c);
			}

			if (isArg) {
				sb.append('#');
			}
			return sb.toString();
		}
		return msg;

	}
}