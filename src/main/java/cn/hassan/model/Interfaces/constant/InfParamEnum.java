package cn.hassan.model.Interfaces.constant;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/6 21:51
 * Description: 接口参数输入枚举类
 */
public enum InfParamEnum {
	
	itype	  ("itype","接口类型", Integer.class),
	sign	  ("sign","请求签名",String.class),
	fileId	  ("fileId","文件id",String.class)
	;

	private InfParamEnum(String paramValue, String paramMsg, Class<?> clazz){
		this.paramValue = paramValue;
		this.paramMsg = paramMsg;
		this.clazz = clazz;
	}


	private String paramValue;		//参数值
	private String paramMsg; 		//参数含义
	private Class<?> clazz;			//参数类型
	
	public String paramMsg(){
		return paramMsg;
	}
	
	public String paramValue(){
		return paramValue;
	}
	
	public Class<?> clazz(){
		return clazz;
	}
	
}
