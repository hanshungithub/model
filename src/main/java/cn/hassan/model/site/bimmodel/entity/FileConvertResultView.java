package cn.hassan.model.site.bimmodel.entity;

import cn.hassan.model.common.pojo.BaseObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/21 14:40
 * Description:
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FileConvertResultView extends BaseObject {
	public long ConvertID;
	public String FileID;
	public String FileKey;
	public String FileBucket;
	public long FileSize;
	public String FileMd5;
	public String FloorName;
	public Integer FloorId;
	public Integer OrderId;
	public String URI;
}
