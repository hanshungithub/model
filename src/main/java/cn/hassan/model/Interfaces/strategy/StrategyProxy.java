package cn.hassan.model.Interfaces.strategy;

import cn.hassan.model.exception.BOExceptionEnum;
import cn.hassan.model.exception.BoException;
import cn.hassan.model.exception.ValidationException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;


public class StrategyProxy extends IStrategy{
	
	private IStrategy  targetEnty;
	
	private String targetMethod;

	@Override
	public String dispose(Map<String, String[]> map) throws BoException {
		Method method;
		try {
			method = targetEnty.getClass().getMethod(targetMethod, Map.class);
			return (String) method.invoke(targetEnty, map);
			
		} catch (NoSuchMethodException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			log.error(e.getMessage());
			throw new BoException(BOExceptionEnum.SYS_ERROR);
		} catch (InvocationTargetException e) {
			
			if (e.getTargetException()  instanceof  BoException ){
				throw (BoException)e.getTargetException() ;
			} 
			else if(e.getTargetException() instanceof ValidationException){
				throw (ValidationException)e.getTargetException() ;
			}
			else{
				log.error(BOExceptionEnum.SYS_ERROR,e);
				log.error(map);
				String[] itypes = map.get("itype");
				if(itypes!=null&&itypes.length>0){
					log.error(itypes[0]);
				}
				throw new BoException(BOExceptionEnum.SYS_ERROR);
			}
		}
	}

	public IStrategy getTargetEnty() {
		return targetEnty;
	}

	public void setTargetEnty(IStrategy targetEnty) {
		this.targetEnty = targetEnty;
	}

	public String getTargetMethod() {
		return targetMethod;
	}

	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}
	

}
