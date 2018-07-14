package cn.hassan.model.Interfaces.strategy.impl;

import cn.hassan.model.Interfaces.constant.InfParamEnum;
import cn.hassan.model.Interfaces.strategy.IStrategy;
import cn.hassan.model.site.bimmodel.query.BimfileQuery;
import cn.hassan.model.site.bimmodel.service.BimfileService;
import cn.hassan.model.site.bimmodel.vo.FileConvertResultWithSize;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BimfileService bimfileService;

	@Override
	public String dispose(Map<String, String[]> map) {
		return null;
	}

	public String modelInfo(Map<String, String[]> map) {
		String fileId = getMapValue(map, InfParamEnum.fileId);
        BimfileQuery query = new BimfileQuery();
        query.setFileId(fileId);
        FileConvertResultWithSize result = bimfileService.bimfileConvertWithSize(query);
        return buildObjectToJson(result);
	}
}
