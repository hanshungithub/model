package cn.hassan.model.Interfaces.context;

import cn.hassan.model.Interfaces.constant.InfParamEnum;
import cn.hassan.model.Interfaces.strategy.IStrategy;
import cn.hassan.model.Interfaces.strategy.StrategyFactory;
import cn.hassan.model.common.utils.Md5Util;
import cn.hassan.model.common.utils.ParameterUtil;
import cn.hassan.model.common.utils.StringUtil;
import cn.hassan.model.common.utils.ZipUtils;
import cn.hassan.model.exception.BOExceptionEnum;
import cn.hassan.model.exception.BoException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 接口上下文
 *
 */
public class InterfaceContext {
	protected Log log = LogFactory.getLog(this.getClass()); 			//日志对象

	private StrategyFactory strategyFactory;
	private String isTest;												//是否测试  true:测试，服务端开发调试接口室，不压缩,不校验签名

	public IStrategy getStrategyInterface(Integer itype){
		return strategyFactory.create(itype);
	}

	/**
	 *
	 * @param map
	 * @return
	 */
	public String dispose(Map<String,String[]> map){




		//指定接口编码，调用策略工厂生成具体策略实体处理业务
		Integer itype =new Integer(map.get("itype")[0]);
		IStrategy strategy = strategyFactory.create(itype);
		return strategy.dispose(map);
	}


	/**
	 *
	 * @Description 负责URL压缩字段的解压，并组装成map对象,并做安全校验
	 * @param sParam
	 * @return
	 *
	 */
	public Map<String,String[]> doInterfaceParam(String sParam){

		//解压
 		String s = ZipUtils.gunzip(sParam);
// 		String s = sParam;

		//组装Map
		Map<String,String[]> map = ParameterUtil.toMapArray(s);

		//获取原始接口参数
		String sInfParam = StringUtil.substringBefore(s,"&sign=");

		//打印接口日志
		if (log.isDebugEnabled()){
			log.info("接口参数:"+s);
		}

		//安全性校验
		safeValid(map,sInfParam);

		return map;
	}

	/**
	 * 请求安全性校验
	 * @param map
	 */
	protected void safeValid(Map<String,String[]> map, String sInfParam){
		if (null == map){
			throw new BoException(BOExceptionEnum.SYS_ERROR);
		}

		//接口类型
		String sItype = getMapValue(map, InfParamEnum.itype.paramValue());
		validParam(sItype);

		Integer itype =new Integer(sItype);


		//客户端签名
		String sClientSign = getMapValue(map,InfParamEnum.sign.paramValue());
		validParam(sClientSign);

		String sServSign;

		//获取签名参数,排除客户端sign
		map.remove(InfParamEnum.sign.paramValue());

		// itype >= 300，为登录后的接口，需要验证mid
		if (itype <300){

			//登录、注册等接口,获取签名
			sServSign = Md5Util.encrypt(sInfParam +"BIM","UTF-8");
		}else{
			//登录后接口
			String mid = null;
			if(map.get("mid")!=null){
				mid = map.get("mid")[0];
			}

			//获取图片信息，不判断是否离职，加入企业界面需要用到
			if (itype != 10000 && itype != 356){
				if (StringUtil.isBlank(mid)){
					log.error("用户ID为空,接口itype:"+itype);
					throw new BoException(BOExceptionEnum.SYS_ERROR);
				}


				String version = getMapValue(map,InfParamEnum.itype.paramValue());
				map.put(InfParamEnum.itype.paramValue(), new String[]{version});

			}
		}



	}

	/**
	 *
	 * @Description  参数为空报错
	 * @param param
	 *
	 */
	private void validParam(String param){
		if (null == param){
			throw new BoException(BOExceptionEnum.SYS_ERROR);
		}
	}

	/**
	 *
	 * @Description 从map中获取某个参数值
	 * @param map
	 * @param param
	 * @return
	 *
	 */
	protected String getMapValue(Map<String, String[]> map, String param){

		String[] sArray = map.get(param);
		if (null == sArray){
			return null;
		}

		return sArray[0];
	}

	public StrategyFactory getStrategyFactory() {
		return strategyFactory;
	}

	public void setStrategyFactory(StrategyFactory strategyFactory) {
		this.strategyFactory = strategyFactory;
	}

	public String getIsTest() {
		return isTest;
	}

	public void setIsTest(String isTest) {
		this.isTest = isTest;
	}


}
