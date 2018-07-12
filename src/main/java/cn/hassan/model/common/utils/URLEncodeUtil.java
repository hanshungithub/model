package cn.hassan.model.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/12 13:29
 * Description:
 */
public class URLEncodeUtil {
	public static final String encode(String s) {
		if (s == null) {
			return null;
		}
		try {
			return URLEncoder.encode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
}
