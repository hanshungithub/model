package cn.hassan.model.exception;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/6 21:51
 * Description: 运行时异常的基类
 */
public class BaseRuntimeException extends RuntimeException {

	/**
	 * @Description
	 * @author
	 * @create at Oct 18, 2011 3:11:24 PM
	 * 
	 */
	private static final long serialVersionUID = 9051275901375243959L;
	/**
	 * 错误码
	 */
	private String errorCode;

	@Deprecated
	public BaseRuntimeException() {
		super();
	}

	/**
	 * 
	 * 构造函数
	 * 
	 * @param errorCode
	 *            错误码
	 * @param errorMsg
	 *            错误信息
	 * 
	 */
	public BaseRuntimeException(String errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
	}

	/**
	 * 取错误码
	 * 
	 * @Description
	 * @return
	 * 
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * 取错误信息
	 * 
	 * @Description
	 * @return
	 * 
	 */
	public String getErrorMsg() {
		return getMessage();
	}
}
