package cn.hassan.model.site.bimmodel.vo;

import cn.hassan.model.common.pojo.BaseObject;
import cn.hassan.model.site.bimmodel.entity.FileConvertResultView;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/21 14:44
 * Description:
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FileConvertResultWithSize extends BaseObject {

	private FileConvertResultView[] jsons;

	private Double size;
}
