package cn.hassan.model.exception;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/6 21:51
 * Description: 校验不通过抛出的异常
 */
public class ValidationException extends BaseRuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1298243450502948658L;

	/**
	 * 
	 * 构造函数
	 * 
	 * @param errorCode
	 *            错误码
	 * @param errorMsg
	 *            错误信息
	 */
	public ValidationException(String errorCode, String errorMsg) {
		super(errorCode, errorMsg);
	}

	/**
	 * 抛ValidationException异常
	 * 
	 * @Description
	 * @param errorCode
	 * @param errorMessage
	 * 
	 */
	public static void throwz(String errorCode, String errorMessage) {
		throw new ValidationException(errorCode, errorMessage);
	}
}
