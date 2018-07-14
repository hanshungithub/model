package cn.hassan.model.site.file.pojo;

import cn.hassan.model.common.pojo.BaseObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/15 8:08
 * Description:
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UploadFile extends BaseObject {

	private String name;
	private String fileKey;
	private String fileId;
}
