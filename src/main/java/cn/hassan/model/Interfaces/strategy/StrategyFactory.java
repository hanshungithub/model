package cn.hassan.model.Interfaces.strategy;

import cn.hassan.model.exception.BOExceptionEnum;
import cn.hassan.model.exception.BoException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;


public class StrategyFactory {
	protected Log log = LogFactory.getLog(this.getClass()); 			//日志对象
	
	private Map<Integer,IStrategy> strategyMap ;

	public IStrategy create(Integer itype){
		if(itype == null)
			throw new BoException(BOExceptionEnum.SYS_ERROR);
		IStrategy strategy = null;
		try {
			strategy = strategyMap.get(itype);
		} catch (Exception e) {
			log.error("itype error:" + itype, e);
			throw new BoException(BOExceptionEnum.SYS_ERROR);
		}
		if(null == strategy){
			log.error("itype error:" + itype);
			throw new BoException(BOExceptionEnum.SYS_ERROR);
		}
		return strategy;
	}

	public Map<Integer, IStrategy> getStrategyMap() {
		return strategyMap;
	}

	public void setStrategyMap(Map<Integer, IStrategy> strategyMap) {
		this.strategyMap = strategyMap;
	}

	
	
}
