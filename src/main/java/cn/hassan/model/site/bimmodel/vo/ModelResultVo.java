package cn.hassan.model.site.bimmodel.vo;

import cn.hassan.model.common.pojo.BaseObject;
import cn.hassan.model.site.bimmodel.entity.FileConvertResult;
import lombok.Data;

import java.util.List;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/16 13:30
 * Description:
 */
@Data
public class ModelResultVo extends BaseObject {

	private Integer convertStatus;

	private List<FileConvertResult> fileConvertResults;

	private List<FileConvertResult> fileConvertResultsSenior;
}
