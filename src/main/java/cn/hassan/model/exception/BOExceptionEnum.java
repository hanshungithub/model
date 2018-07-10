package cn.hassan.model.exception;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/6 21:51
 * Description: BoException的错误码和错误信息枚举
 */
public enum BOExceptionEnum {
	
	//--------------------------------------------------  基础 -----------------------------------------------------//
	SYS_ERROR						("-10",  "系统异常，请稍候再试")
    ;


	/**
	 * 错误码
	 */
	private String errorCode;
	
	/**
	 * 错误信息
	 */
	private String errorMsg;
	
	BOExceptionEnum(String errorCode, String errorMsg){
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public String errorCode(){
		return errorCode;
	}
	
	public String errorMsg(){
		return errorMsg;
	}
}
