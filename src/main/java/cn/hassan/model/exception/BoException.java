package cn.hassan.model.exception;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/6 21:51
 * Description:
 */
public class BoException extends BaseRuntimeException {

	/**
	 *
	 * BOExceptionEnum构造业务层异常
	 *
	 * @param en
	 */
	public BoException(BOExceptionEnum en) {
		super(en.errorCode(), en.errorMsg());
	}


	public BoException(String errorMsg) {
		super("", errorMsg);
	}

	/**
	 * 抛出BOException异常
	 *
	 * @Description
	 * @param en
	 *            异常枚举
	 *
	 */
	public static void throwz(BOExceptionEnum en) {
		throw new BoException(en);
	}
}
