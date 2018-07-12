package cn.hassan.model.Interfaces.web;

import cn.hassan.model.Interfaces.context.InterfaceContext;
import cn.hassan.model.common.utils.URLEncodeUtil;
import cn.hassan.model.common.utils.ZipUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/10 14:45
 * Description: 接口总入口 - 给手机端调用
 */
@RestController
public class InterfaceController {

	@Autowired
	private InterfaceContext context;

	/**
	 * 接口入口
	 */
	@RequestMapping("/gateWay")
	public String gateWay(String s) {
		StringBuilder str=new  StringBuilder();
		str.append("itype="+1000+"&");
		str.append("sign=").append(s);
		String string= ZipUtils.gzip(str.toString());
		String encode = URLEncodeUtil.encode(string);
		Map<String, String[]> map = context.doInterfaceParam(encode);
		String dispose = context.dispose(map);
		return dispose;
	}
}
