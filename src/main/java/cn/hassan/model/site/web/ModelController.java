package cn.hassan.model.site.web;

import cn.hassan.model.common.enums.SourceEnum;
import cn.hassan.model.exception.BOExceptionEnum;
import cn.hassan.model.exception.BoException;
import cn.hassan.model.site.bimmodel.query.BimfileQuery;
import cn.hassan.model.site.bimmodel.service.BimfileService;
import cn.hassan.model.site.bimmodel.vo.FileConvertResultWithSize;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value="/front/bimfile", tags="bim模型相关请求处理")
@RestController
public class ModelController {

    @Autowired
    private BimfileService bimfileService;

    /**
     * @param query versionId
     * @return 模型详细信息
     */
	@ApiOperation(value="模型详细信息")
	@ApiImplicitParam(name = "fileId", value = "文件Id(上传后返回的fileId)", required = true)
	@PostMapping("/front/bimfile/modelConstructInfoCors.htm")
    public JSONObject modelConstructInfoCors(BimfileQuery query) {
		query.setFileId("a90600e7-1f49-2c91-8083-01312615b77a");
        JSONObject jsonObject = new JSONObject();
        if(StringUtils.isEmpty(query.getFileId())){
			throw new BoException(BOExceptionEnum.SYS_ERROR);
        }
        query.setSource((int)SourceEnum.WEB.value());
		FileConvertResultWithSize result = bimfileService.bimfileConvertWithSize(query);
        jsonObject.put("result",result);
        return jsonObject;

    }
}
