package cn.hassan.model.site.bimmodel.service;


import cn.hassan.model.common.utils.StringUtil;
import cn.hassan.model.exception.BOExceptionEnum;
import cn.hassan.model.exception.BoException;
import cn.hassan.model.site.bimmodel.entity.*;
import cn.hassan.model.site.bimmodel.mapper.CloudProjectfileMapper;
import cn.hassan.model.site.bimmodel.mapper.FileConvertResultMapper;
import cn.hassan.model.site.bimmodel.mapper.FileConvertTaskMapper;
import cn.hassan.model.site.bimmodel.query.BimfileQuery;
import cn.hassan.model.site.bimmodel.vo.FileConvertResultWithSize;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BimfileService {

    @Autowired(required = false)
    private FileConvertResultMapper fileConvertResultMapper;

	@Value("${oss.cloud_endpoint}")
	private String endpoint;

	@Autowired(required = false)
	private FileConvertTaskMapper fileConvertTaskMapper;

	@Autowired(required = false)
	private CloudProjectfileMapper cloudProjectfileMapper;

    public FileConvertResultWithSize bimfileConvertWithSize(BimfileQuery query) {
        String ossEndpoint = endpoint;
		//返回客户端结果
		FileConvertResultWithSize resultWithSize = new FileConvertResultWithSize();
        //查看模型是否转化成功
		checkOptBimfileAuth(query);
		//查找文件转换的结果
        List<FileConvertResult> resultList = fileConvertResultMapper.findPBIMFileJsonListByFileId(query);
		List<FileConvertResultView> resultViews = new ArrayList<>();
		BigDecimal allSize = BigDecimal.ZERO;
		for (FileConvertResult result : resultList) {
			allSize = allSize.add(new BigDecimal(result.getFilesize()));
			FileConvertResultView resultView = new FileConvertResultView();
			resultView.setConvertID(result.getConvertid());
			resultView.setFileID(result.getFileid());
			resultView.setFileKey(result.getFilekey());
			resultView.setFileBucket(result.getFilebucket());
			resultView.setFileSize(result.getFilesize());
			resultView.setFileMd5(result.getFilemd5());
			resultView.setFloorName(result.getFloorName());
			resultView.setFloorId(result.getFloorId());
			resultView.setOrderId(result.getOrderId());
			try {
				resultView.setURI("http://" + result.getFilebucket() + "." + ossEndpoint.substring(ossEndpoint.lastIndexOf("/") + 1) + "/" + URLEncoder.encode(result.getFilekey(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				log.error(e.getMessage(), e);
			}
			resultViews.add(resultView);
		}
		resultWithSize.setJsons(resultViews.toArray(new FileConvertResultView[resultViews.size()]));
		resultWithSize.setSize(allSize.doubleValue());
		return resultWithSize;
    }

	private Bimfile getBimFile(BimfileQuery query) {
		CloudProjectfile cloudProjectfile = cloudProjectfileMapper.selectByPrimaryKey(query.getFileId());

		log.debug("CloudProjectfile查询，参数:{},结果:{}",query,cloudProjectfile);
		if (cloudProjectfile == null) {
			throw new BoException(BOExceptionEnum.SYS_ERROR);
		}else {
			return new Bimfile(cloudProjectfile);
		}
	}

	@NotNull
	private Bimfile checkOptBimfileAuth(BimfileQuery query) {
		Bimfile file = getBimFile(query);
		if (!file.isConvertStatus()) {
			StringBuilder errorMsg = new StringBuilder();
			if (file.isModel()) {
				errorMsg.append("模型");
			}else{
				errorMsg.append("图纸");
			}
			errorMsg.append(BOExceptionEnum.SYS_ERROR.errorMsg());
			String convertErrorMsg = file.getConvertResultDesc();
			if (StringUtil.isNotBlank(convertErrorMsg)) {
				errorMsg.append("(").append(convertErrorMsg).append(")");
			}
			//插队转化
			CloudFileConvertTask task = new CloudFileConvertTask();
			task.setFileID(file.getVersion_id());
			CloudFileConvertTask one = fileConvertTaskMapper.findOne(task);
			if (one != null) {
				one.setTaskPriorityLevel(one.getTaskPriorityLevel() + 1);
				fileConvertTaskMapper.updateFileConvertTask(one);
			}
			throw new BoException(BOExceptionEnum.SYS_ERROR.errorCode()
			);
		}
		return file;
	}
}
