package cn.hassan.model.site.bimmodel.entity;


import cn.hassan.model.common.pojo.BaseObject;
import cn.hassan.model.site.bimmodel.enums.BimfileTypeEnums;

import java.util.Objects;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/21 13:56
 * Description:
 */
public class Bimfile extends BaseObject {

	private String version_id;

	private Integer fileTypeId;

	private boolean convertStatus;

	private String convertResultDesc;

	private String fileExtension;

	private Integer status;

	public Bimfile(CloudProjectfile file) {
		this.version_id = file.getFileid();
		this.fileTypeId = file.getFiletypeid();
		this.fileExtension = file.getFileextension();
		this.convertResultDesc = file.getConvertresultdesc();
		this.convertStatus = file.getConvertstatus() != 3;
		this.status = file.getConvertstatus();
	}

	public boolean isDwg() {
		return Objects.equals(2, fileTypeId);
	}

	public String getVersion_id() {
		return version_id;
	}

	public void setVersion_id(String version_id) {
		this.version_id = version_id;
	}


	public boolean isModel() {
		return Objects.equals(101, fileTypeId);
	}

	public boolean isDocument() {
		return  !isModel();
	}

	public Byte getBimfileType() {
		if (isModel()) {
			return BimfileTypeEnums.MODEL.value();
		} else if (isDwg()) {
			return BimfileTypeEnums.DRAWING.value();
		}else{
			return BimfileTypeEnums.DOCUMENT.value();
		}
	}

	public boolean isConvertStatus() {
		return convertStatus;
	}

	public void setConvertStatus(boolean convertStatus) {
		this.convertStatus = convertStatus;
	}

	public String getConvertResultDesc() {
		return convertResultDesc;
	}

	public void setConvertResultDesc(String convertResultDesc) {
		this.convertResultDesc = convertResultDesc;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public Integer getFileTypeId() {
		return fileTypeId;
	}

	public void setFileTypeId(Integer fileTypeId) {
		this.fileTypeId = fileTypeId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
