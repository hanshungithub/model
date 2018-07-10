package cn.hassan.model.Interfaces.strategy;

import cn.hassan.model.Interfaces.constant.InfParamEnum;
import cn.hassan.model.Interfaces.constant.InterfaceConstant;
import cn.hassan.model.common.pojo.BaseObject;
import cn.hassan.model.common.query.QueryBase;
import cn.hassan.model.common.utils.JsonUtil;
import cn.hassan.model.common.utils.ParameterUtil;
import cn.hassan.model.common.utils.StringUtil;
import cn.hassan.model.exception.BOExceptionEnum;
import cn.hassan.model.exception.BoException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/6 21:51
 * Description: 策略类的接口
 */
public abstract class IStrategy {
	protected Log log = LogFactory.getLog(this.getClass()); 			//日志对象

	public abstract String dispose(Map<String,String[]> map);
	
	protected <P> P paramsConvert(Map<String, String[]> map, Class<P> target){
		try {
			return ParameterUtil.toObject(map, target);
		} catch (Exception e) {
			log.error(BOExceptionEnum.SYS_ERROR,e);
			e.printStackTrace();
		}
		return null;
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
		 
		//如果是文本，需要URL解码UTF-8，解决该问题:文本中含&等特殊符号
		String s = StringUtil.decode(sArray[0]);
		
		return s.trim();		
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T getMapValue(Map<String, String[]> map, String param, Class<T> toClazz){
		String[] sArray = map.get(param);
		if (null == sArray){
			return null;
		}
		Object value = sArray;
		if(!toClazz.isArray()){
			String val = sArray[0];
			if("null".equalsIgnoreCase(val.trim()))
				return null;
			value = val;
		}
		try {
			Object result = ParameterUtil.conver(value, toClazz);

			//如果是文本，需要URL解码UTF-8，解决该问题:文本中含&等特殊符号
			if(toClazz == String.class){
				result = StringUtil.decode((String)result);
			}

			return (T) result;
		} catch (Exception e) {
			log.error("手机端\""+param+"\"参数格式出错",e);
			throw new BoException(BOExceptionEnum.SYS_ERROR);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T getMapValue(Map<String, String[]> map, InfParamEnum en){
		return (T)getMapValue(map, en.paramValue(), en.clazz());
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T getMapArray(Map<String, String[]> map, InfParamEnum en){
		String[] sArray = map.get(en.paramValue());
		if (null == sArray){
			return null;
		}
		String arrStr = sArray[0];
		
		//需要URL解码,UTF-8，解决该问题:文本中含&等特殊符号
		arrStr = StringUtil.decode(arrStr);
		
		if("".equals(arrStr.trim()) || "null".equalsIgnoreCase(arrStr.trim()))
			return null;
		
		String[] vals = arrStr.split(",");
		try {
			Object result = ParameterUtil.conver(vals, en.clazz());
			return (T) result;
		} catch (Exception e) {
			log.error("手机端\""+en.paramValue()+"\"参数格式出错",e);
			throw new BoException(BOExceptionEnum.SYS_ERROR);
		}
	}

	
	/**
	 * 
	 * @Description 组装boolean类型
	 * @return  
	 *
	 */
	protected String buildOk(){
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("ret", InterfaceConstant.RET_OK);
		return JsonUtil.toJson(result);
	}
	 
	protected String buildOkMember(String member_id){
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("ret",InterfaceConstant.RET_OK);
			result.put("member_id",member_id);
			
			return JsonUtil.toJson(result);
	}

	protected String buildFAIL(){
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("ret",InterfaceConstant.RET_FAIL);
		return JsonUtil.toJson(result);
	}

	protected String buildUnwrappedMap(Map<String,Object> map){
		Map<String, Object> result = new HashMap<>();
		result.put("ret",InterfaceConstant.RET_OK);
		result.putAll(map);
		return JsonUtil.toJson(result);
	}
	
	protected String buildMapToJson(Map<String, Object> map){
		return buildMapToJson(map, false);
	}
	
	protected String buildMapToJson(Map<String, Object> map, boolean unpack){
		Map<String, Object> result = new HashMap<String, Object>();
		int cnt = (map == null ? 0 : 1);
		result.put("ret", cnt);
		if(null != map){
			if(unpack){
				Set<String> keys = map.keySet();
				for(String key: keys){
					Object obj = map.get(key);
					result.put(key, obj);
				}
			}else{
				result.put("object", map);
			}
		}
		return JsonUtil.toJson(result);
	}	
	
	protected <Pojo> String buildListToJson(List<Pojo> list){
		return buildListToJson(list, null);
	}
	
	protected <Pojo> String buildListToJson(List<Pojo> list, QueryBase query){
		Map<String, Object> result = new HashMap<String, Object>();
		int cnt = (list == null ? 0 : list.size());
		
		if (log.isDebugEnabled()){
			log.debug("Strategy: " + this.getClass() + " return list size " + cnt);
		}		
		
		result.put("ret", cnt);
		if(null != query)
			result.put("total", query.getTotalItem());
		if(cnt > 0 ){
			result.put("list", list);
		}
		return JsonUtil.toJson(result);
	}

	protected <Pojo> String buildListToJsonForFamily(List<Pojo> list, QueryBase query){
		Map<String, Object> result = new HashMap<String, Object>();
		int cnt = (list == null ? 0 : list.size());

		if (log.isDebugEnabled()){
			log.debug("Strategy: " + this.getClass() + " return list size " + cnt);
		}

		result.put("ret", cnt);
		if(null != query)
			result.put("total", query.getTotalItem());
		if(cnt > 0 ){
			result.put("list", list);
		}else{
			result.put("msg", "无数据");
		}
		return JsonUtil.toJson(result);
	}

	protected <Pojo> String buildListToJsonForFamily(List<Pojo> list){
		return buildListToJsonForFamily(list,null);
	}

	protected <Pojo> String buildListWithQueryToJson(List<Pojo> list, QueryBase query){
		Map<String, Object> result = new HashMap<String, Object>();
		int cnt = (list == null ? 0 : list.size());

		if (log.isDebugEnabled()){
			log.debug("Strategy: " + this.getClass() + " return list size " + cnt);
		}

		result.put("ret", cnt);
		if(null != query){
			result.put("total", query.getTotalItem());
			result.put("page",query.getCurrentPage());
			result.put("size",query.getPageSize());
			result.put("totalPage",query.getTotalPage());
		}

		if(cnt > 0 ){
			result.put("list", list);
		}else{
			result.put("msg", "无数据");
		}
		return JsonUtil.toJson(result);
	}
	

	
	protected <Pojo extends BaseObject> String buildObjectToJson(Pojo pojo){
		Map<String, Object> result = new HashMap<String, Object>();
		int cnt = (pojo == null ? 0 : 1);
		
		if (log.isDebugEnabled()){
			log.debug("Strategy: " + this.getClass() + " return object " + cnt);
		}		
		
		result.put("ret", cnt);
		if(null != pojo){
			result.put("object", pojo);
		}
		return JsonUtil.toJson(result);
	}

	protected <Pojo extends BaseObject> String buildObjectToJsonForFamily(Pojo pojo){
		Map<String, Object> result = new HashMap<String, Object>();
		int cnt = (pojo == null ? 0 : 1);

		if (log.isDebugEnabled()){
			log.debug("Strategy: " + this.getClass() + " return object " + cnt);
		}

		result.put("ret", cnt);
		if(null != pojo){
			result.put("object", pojo);
		}
		if (cnt == 0) {
			result.put("msg", "无数据");
		}
		return JsonUtil.toJson(result);
	}
	
	protected String buildOKToJson(String s){
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("ret", 1);
		if(null != s){
			result.put("object", s);
		}
		return JsonUtil.toJson(result);
	}	
}
