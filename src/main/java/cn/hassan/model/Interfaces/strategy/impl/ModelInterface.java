package cn.hassan.model.Interfaces.strategy.impl;

import cn.hassan.model.Interfaces.constant.InfParamEnum;
import cn.hassan.model.Interfaces.strategy.IStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/12 13:40
 * Description:
 */
@Component(value = "modelInterface")
public class ModelInterface extends IStrategy {
	@Override
	public String dispose(Map<String, String[]> map) {
		return null;
	}

	public String modelInfo(Map<String, String[]> map) {
		String mapValue = getMapValue(map, InfParamEnum.sign);
		return "hello" + mapValue;
	}
}
