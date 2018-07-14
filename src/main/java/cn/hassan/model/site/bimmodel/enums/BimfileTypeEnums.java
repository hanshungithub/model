package cn.hassan.model.site.bimmodel.enums;

import org.jetbrains.annotations.Nullable;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/21 13:59
 * Description: BIM FILE 类型 1-模型 2-文件
 */
public enum BimfileTypeEnums {
	MODEL       ((byte)1, "模型",102),
	DOCUMENT    ((byte)2, "文件",101),
	DRAWING     ((byte)3, "图纸",104),
	;
	/**
	 * 状态值
	 */
	private byte value;
	/**
	 * 状态的描述
	 */
	private String description;

	/**
	 * 云平台对应类型
	 */
	private int cloudNodeType;

	BimfileTypeEnums(byte value, String description,int cloudNodeType) {
		this.value = value;
		this.description = description;
		this.cloudNodeType = cloudNodeType;
	}

	public byte value() {
		return value;
	}
	public String description() {
		return description;
	}

	public int getCloudNodeType() {
		return cloudNodeType;
	}

	// 把整数映射到枚举值
	@Nullable
	public static BimfileTypeEnums valueOf(byte value) {
		for(BimfileTypeEnums statusEnum : BimfileTypeEnums.values()) {
			if(statusEnum.value() == value) {
				return statusEnum;
			}
		}
		return null;
	}
}
