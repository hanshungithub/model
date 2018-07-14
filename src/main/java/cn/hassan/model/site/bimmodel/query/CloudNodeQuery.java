package cn.hassan.model.site.bimmodel.query;

import cn.hassan.model.common.query.QueryBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/21 10:22
 * Description: 目录树节点表分页查询Query
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CloudNodeQuery extends QueryBase {
	/*获取指定版本的节点集合*/
	private Long targetRevisionID;

	/*模糊查询值*/
	private String searchValue;
	/*搜索开始时间*/
	private Date searchBeginDate;
	/*搜索结束时间*/
	private Date searchEndDate;
	/*按时间轴方式查询*/
	private Integer searchTimeLine;



	private String projectId;

	private String parentID;


	/*查询此节点路径下的所有子节点*/
	private String topNodeIDPath;

	/*返回指定类型s的节点*/
	private String nodeTypes;



	private Integer nodeType;
	/*项目名称*/
	private String projectName;



	/*工程名称*/
	private String subProjectName;



	/*结果返回Appid*/
	private Boolean returnAppID;
	/*排序*/
	private Integer orderBy;
	/*文件类型s*/
	private String fileTypeIds;
	/*指定要查询的节点集合*/
	private String nodeIDs;
	/*文件ID*/
	private String fileID;
	/*文件名称*/
	private String fileName;

	private Integer fileTypeId;

	private String fileBucket;

	private String fileKey;

	private Long fileSize;

	private String fileMd5;

	private String fileExtension;

	private String zipFileMd5;

	private Integer isZip;

	private String filePath;

	private Integer nodeRevisionId;

	private String revisionNodeName;

	/*节点所属工程的软件ID*/
	private Integer appID;

	/*查询接口指定节点所属工程的软件ID*/
	private String appIDs;
	/*节点所属工程的软件名称*/
	private String appName;

	/*节点标记删除*/
	private Integer isDel;

	private String revisionUser;

	private Date revisionTime;

	private Integer convertStatus;

	private String convertResultDesc;

	/*模型显示类型，空或者0为全部，1为只显示上传的模型,2为只显示工程模型*/
	private Integer modelShowType;
	/*预占用操作Id*/
	private String operateId;
	/*指定只显示有转化完成的*/
	private Integer searchConverted;

	public Integer getIscoadmin() {
		return iscoadmin;
	}

	/*当前登录用户ID*/
	private String curUserID;


	/*是否企业管理员*/
	private Integer iscoadmin;
	/*是否5D列表页*/
	private Integer is5DtopNode;


	private  String nodeId;

	private String topNodeId;//根节点
}
