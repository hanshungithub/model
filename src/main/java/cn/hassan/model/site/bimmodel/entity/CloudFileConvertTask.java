package cn.hassan.model.site.bimmodel.entity;

import cn.hassan.model.common.pojo.BaseObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/21 15:35
 * Description: 文件转化任务表
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CloudFileConvertTask extends BaseObject {
	/**
	 *
	 * 用于序列化标示
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 *
	 *
	 */
	private Long taskId;
	/**
	 *
	 *
	 *
	 */
	private String fileID;
	/**
	 *
	 * 文件名称
	 *
	 */
	private String fileName;
	/**
	 *
	 * 文件后缀名
	 *
	 */
	private Integer fileTypeId;
	/**
	 *
	 *
	 *
	 */
	private String fileBucket;
	/**
	 *
	 *
	 *
	 */
	private String fileKey;
	/**
	 *
	 * 文件大小，byte
	 *
	 */
	private Long fileSize;
	/**
	 *
	 *
	 *
	 */
	private String fileMd5;
	/**
	 *
	 *
	 *
	 */
	private Date addTime;
	/**
	 *
	 *
	 *
	 */
	private String addUser;
	/**
	 *
	 *
	 *
	 */
	private String zipFileMd5;
	/**
	 *
	 *
	 *
	 */
	private Integer isZip;
	/**
	 *
	 * 文件扩展名，如.rvt,.dwg,.pbim
	 *
	 */
	private String fileExtension;
	/**
	 *
	 * 开始处理的时间
	 *
	 */
	private Date startHandleTime;
	/**
	 *
	 * 文件处理使用的总时间（秒）
	 *
	 */
	private Long totalTimeElapsed;
	/**
	 *
	 * 文件下载使用的时间（秒）
	 *
	 */
	private Long downloadTimeElapsed;
	/**
	 *
	 * 文件转换使用的时间（秒）
	 *
	 */
	private Long convertTimeElapsed;
	/**
	 *
	 * 文件上传使用的时间（秒）
	 *
	 */
	private Long uploadTimeElapsed;
	/**
	 *
	 * 0:所有需要的转换; 1:pbim简化; 2:pbim拆解json; 3:dwg炸开; 4:rvt合成pbim（三维）
	 *
	 */
	private Integer workType;
	/**
	 *
	 * 文件转化状态，默认0为未转换，1为正在转化 2为转换成功， 3为转换失败
	 *
	 */
	private Integer convertStatus;
	/**
	 *
	 * 文件转化失败描述
	 *
	 */
	private String convertResultDesc;
	/**
	 *
	 * 任务是否已经发起 0：未发起 1：已发起
	 *
	 */
	private Integer taskEnabled;
	/**
	 *
	 * 任务优先级，数值越大，优先级越高
	 *
	 */
	private Integer taskPriorityLevel;
}
