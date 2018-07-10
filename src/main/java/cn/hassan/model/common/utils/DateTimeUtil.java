package cn.hassan.model.common.utils;

import org.jetbrains.annotations.Nullable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/6 21:51
 * Description: 日期时间工具类，进行各种日期时间格式的转化以及格式化
 */
public class DateTimeUtil {

	// /
	// 定义时间日期显示格式
	// /
	private final static String DATE_FORMAT = "yyyy-MM-dd";

	private final static String DATE_FORMAT_CN = "yyyy年MM月dd日";

	private final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private final static String TIME_FORMAT_CN = "yyyy年MM月dd日 HH:mm:ss";

	private final static String MONTH_FORMAT = "yyyy-MM";

	private final static String DAY_FORMAT = "yyyyMMdd";
	
	private final static String LONG_FORMAT = "yyyyMMddHHmmss";
	
	private final static String EA_DATE_FORMAT = "yyyy-MM-dd HH:mm";//20150921 审批导出用日期

	private final static String C_SHARP_FORMAT = "yyyy/MM/dd HH:mm:ss";

	// private final static String TIME_FORMAT_MILLI = "yyyy-MM-dd
	// HH:mm:ss.SSS";

	/**
	 * 取得当前系统时间，返回java.util.Date类型
	 * 
	 * @see java.util.Date
	 * @return java.util.Date 返回服务器当前系统时间
	 */
	public static java.util.Date getCurrDateTime() {
		return new java.util.Date();
	}

	/**
	 * 取得当前系统日期，返回java.util.Date类型
	 * @return
	 */
	public static java.util.Date getCurrDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 取得当前系统时间戳
	 *
	 * @see java.sql.Timestamp
	 * @return java.sql.Timestamp 系统时间戳
	 */
	public static java.sql.Timestamp getCurrTimestamp() {
		return new java.sql.Timestamp(System.currentTimeMillis());
	}

	/**
	 * 得到格式化后的日期，格式为yyyy-MM-dd，如2006-02-15
	 *
	 * @param currDate
	 *            要格式化的日期
	 * @see #getFormatDate(java.util.Date, String)
	 * @return String 返回格式化后的日期，默认格式为为yyyy-MM-dd，如2006-02-15
	 */
	public static String getFormatDate(java.util.Date currDate) {
		return getFormatDate(currDate, DATE_FORMAT);
	}

	/**
	 * @date 20150921
	 * 得到格式化后的日期，格式为yyyy-MM-dd HH:mm，如2015-08-16 16:00
	 *
	 * @param currDate
	 *            要格式化的日期
	 * @see #getFormatDate(java.util.Date, String)
	 * @return String 返回格式化后的日期，默认格式为为yyyy-MM-dd HH:mm，如2015-08-16 16:00
	 */
	public static String getEAFormatDate(java.util.Date currDate) {
		return getFormatDate(currDate, EA_DATE_FORMAT);
	}

	/**
	 * 得到格式化后的日期，格式为yyyy-MM-dd，如2006-02-15
	 *
	 * @param currDate
	 *            要格式化的日期
	 * @see #getFormatDate(java.util.Date)
	 * @return Date 返回格式化后的日期，默认格式为为yyyy-MM-dd，如2006-02-15
	 * @throws ParseException
	 */
	public static Date getFormatDateToDate(java.util.Date currDate) throws ParseException {
		return getFormatDate(getFormatDate(currDate));
	}

	/**
	 * 得到格式化后的日期，格式为yyyy年MM月dd日，如2006年02月15日
	 *
	 * @param currDate
	 *            要格式化的日期
	 * @see #getFormatDate(java.util.Date, String)
	 * @return String 返回格式化后的日期，默认格式为yyyy年MM月dd日，如2006年02月15日
	 */
	public static String getFormatDate_CN(java.util.Date currDate) {
		return getFormatDate(currDate, DATE_FORMAT_CN);
	}

	/**
	 * 得到格式化后的日期，格式为yyyy年MM月dd日，如2006年02月15日
	 *
	 * @param currDate
	 *            要格式化的日期
	 * @see #getFormatDate_CN(String)
	 * @return Date 返回格式化后的日期，默认格式为yyyy年MM月dd日，如2006年02月15日
	 * @throws ParseException
	 */
	public static Date getFormatDateToDate_CN(java.util.Date currDate) throws ParseException {
		return getFormatDate_CN(getFormatDate_CN(currDate));
	}

	/**
	 * 得到格式化后的日期，格式为yyyy-MM-dd，如2006-02-15
	 *
	 * @param currDate
	 *            要格式化的日期
	 * @see #getFormatDate(String, String)
	 * @return Date 返回格式化后的日期，默认格式为yyyy-MM-dd，如2006-02-15
	 * @throws ParseException
	 */
	public static Date getFormatDate(String currDate) throws ParseException {
		return getFormatDate(currDate, DATE_FORMAT);
	}

	/**
	 * 得到格式化后的日期，格式为yyyy年MM月dd日，如2006年02月15日
	 *
	 * @param currDate
	 *            要格式化的日期
	 * @see #getFormatDate(String, String)
	 * @return 返回格式化后的日期，默认格式为yyyy年MM月dd日，如2006年02月15日
	 * @throws ParseException
	 */
	public static Date getFormatDate_CN(String currDate) throws ParseException {
		return getFormatDate(currDate, DATE_FORMAT_CN);
	}

	/**
	 * 根据格式得到格式化后的日期
	 *
	 * @param currDate
	 *            要格式化的日期
	 * @param format
	 *            日期格式，如yyyy-MM-dd
	 * @see java.text.SimpleDateFormat#format(java.util.Date)
	 * @return String 返回格式化后的日期，格式由参数<code>format</code>
	 *         定义，如yyyy-MM-dd，如2006-02-15
	 */
	public static String getFormatDate(java.util.Date currDate, String format) {
		SimpleDateFormat dtFormatdB = null;
		try {
			dtFormatdB = new SimpleDateFormat(format);
			return dtFormatdB.format(currDate);
		} catch (Exception e) {
			dtFormatdB = new SimpleDateFormat(DATE_FORMAT);

			return dtFormatdB.format(currDate);
		}
	}

	/**
	 * 得到格式化后的时间，格式为yyyy-MM-dd HH:mm:ss，如2006-02-15 15:23:45
	 *
	 * @param currDate
	 *            要格式化的时间
	 * @see #getFormatDateTime(java.util.Date, String)
	 * @return String 返回格式化后的时间，默认格式为yyyy-MM-dd HH:mm:ss，如2006-02-15 15:23:45
	 */
	public static String getFormatDateTime(java.util.Date currDate) {
		return getFormatDateTime(currDate, TIME_FORMAT);
	}

	/**
	 * 得到格式化后的时间，格式为yyyy-MM-dd HH:mm:ss，如2006-02-15 15:23:45
	 *
	 * @param currDate
	 *            要格式环的时间
	 * @see #getFormatDateTime(String)
	 * @return Date 返回格式化后的时间，默认格式为yyyy-MM-dd HH:mm:ss，如2006-02-15 15:23:45
	 * @throws ParseException
	 */
	public static Date getFormatDateTimeToTime(java.util.Date currDate) throws ParseException {
		return getFormatDateTime(getFormatDateTime(currDate));
	}

	/**
	 * 得到格式化后的时间，格式为yyyy-MM-dd HH:mm:ss，如2006-02-15 15:23:45
	 *
	 * @param currDate
	 *            要格式化的时间
	 * @see #getFormatDateTime(String, String)
	 * @return Date 返回格式化后的时间，默认格式为yyyy-MM-dd HH:mm:ss，如2006-02-15 15:23:45
	 * @throws ParseException
	 */
	public static Date getFormatDateTime(String currDate) throws ParseException {
		return getFormatDateTime(currDate, TIME_FORMAT);
	}

	/**
	 * 得到格式化后的时间，格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日 15:23:45
	 *
	 * @param currDate
	 *            要格式化的时间
	 * @see #getFormatDateTime(java.util.Date, String)
	 * @return String 返回格式化后的时间，默认格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日 15:23:45
	 */
	public static String getFormatDateTime_CN(java.util.Date currDate) {
		return getFormatDateTime(currDate, TIME_FORMAT_CN);
	}

	/**
	 * 得到格式化后的时间，格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日 15:23:45
	 *
	 * @param currDate
	 *            要格式化的时间
	 * @see #getFormatDateTime_CN(String)
	 * @return Date 返回格式化后的时间，默认格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日 15:23:45
	 * @throws ParseException
	 */
	public static Date getFormatDateTimeToTime_CN(java.util.Date currDate) throws ParseException {
		return getFormatDateTime_CN(getFormatDateTime_CN(currDate));
	}

	/**
	 * 得到格式化后的时间，格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日 15:23:45
	 *
	 * @param currDate
	 *            要格式化的时间
	 * @see #getFormatDateTime(String, String)
	 * @return Date 返回格式化后的时间，默认格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日 15:23:45
	 * @throws ParseException
	 */
	public static Date getFormatDateTime_CN(String currDate) throws ParseException {
		return getFormatDateTime(currDate, TIME_FORMAT_CN);
	}

	/**
	 * 根据格式得到格式化后的时间
	 *
	 * @param currDate
	 *            要格式化的时间
	 * @param format
	 *            时间格式，如yyyy-MM-dd HH:mm:ss
	 * @see java.text.SimpleDateFormat#format(java.util.Date)
	 * @return String 返回格式化后的时间，格式由参数<code>format</code>定义，如yyyy-MM-dd HH:mm:ss
	 */
	public static String getFormatDateTime(java.util.Date currDate,
										   String format) {
		SimpleDateFormat dtFormatdB = null;
		try {
			dtFormatdB = new SimpleDateFormat(format);
			return dtFormatdB.format(currDate);
		} catch (Exception e) {
			dtFormatdB = new SimpleDateFormat(TIME_FORMAT);

			return dtFormatdB.format(currDate);
		}
	}

	/**
	 * 根据格式得到格式化后的日期
	 *
	 * @param currDate
	 *            要格式化的日期
	 * @param format
	 *            日期格式，如yyyy-MM-dd
	 * @see java.text.SimpleDateFormat#parse(java.lang.String)
	 * @return Date 返回格式化后的日期，格式由参数<code>format</code>定义，如yyyy-MM-dd，如2006-02-15
	 * @throws ParseException
	 */
	public static Date getFormatDate(String currDate, String format) throws ParseException {
		SimpleDateFormat dtFormatdB = null;
		try {
			dtFormatdB = new SimpleDateFormat(format);
			return dtFormatdB.parse(currDate);
		} catch (Exception e) {
			dtFormatdB = new SimpleDateFormat(DATE_FORMAT);

			return dtFormatdB.parse(currDate);
		}
	}

	/**
	 * 根据格式得到格式化后的时间
	 *
	 * @param currDate
	 *            要格式化的时间
	 * @param format
	 *            时间格式，如yyyy-MM-dd HH:mm:ss
	 * @see java.text.SimpleDateFormat#parse(java.lang.String)
	 * @return Date 返回格式化后的时间，格式由参数<code>format</code>定义，如yyyy-MM-dd HH:mm:ss
	 * @throws ParseException
	 */
	public static Date getFormatDateTime(String currDate, String format) throws ParseException {
		SimpleDateFormat dtFormatdB = null;
		try {
			dtFormatdB = new SimpleDateFormat(format);
			return dtFormatdB.parse(currDate);
		} catch (Exception e) {
			dtFormatdB = new SimpleDateFormat(TIME_FORMAT);

			return dtFormatdB.parse(currDate);

		}
	}

	@Nullable
	public static String getCSharpFormat(Date date){
		if (date == null) {
			return null;
		}
		return getFormatDateTime(date, C_SHARP_FORMAT);
	}

	public static Date getCSharpFormat(String date) throws ParseException {
		if (StringUtil.isEmpty(date)) {
			return null;
		}
		return getFormatDateTime(date, C_SHARP_FORMAT);
	}

	/**
	 * 得到本日的上月时间 如果当日为2007-9-1,那么获得2007-8-1
	 *
	 *
	 */
	public static String getDateBeforeMonth() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		return getFormatDate(cal.getTime(), DATE_FORMAT);
	}

	/**
	 * 得到本日的几个月时间 如果当日为2007-9-1, i为1 那么获得2007-8-1
	 *											i为2 那么获得2007-7-1
	 *返回Date类型
	 */
	public static Date getDateMonth(Integer i) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -(i));
		return cal.getTime();
	}

	/**
	 *
	 *
	 */
	public static String getDateBeforeDay() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return getFormatDate(cal.getTime(), DATE_FORMAT);
	}

	/**
	 * 得到格式化后的当前系统日期，格式为yyyy-MM-dd，如2006-02-15
	 *
	 * @see #getFormatDate(java.util.Date)
	 * @return String 返回格式化后的当前服务器系统日期，格式为yyyy-MM-dd，如2006-02-15
	 */
	public static String getCurrDateStr() {
		return getFormatDate(getCurrDateTime());
	}

	/**
	 * 得到格式化后的当前系统时间，格式为yyyy-MM-dd HH:mm:ss，如2006-02-15 15:23:45
	 *
	 * @see #getFormatDateTime(java.util.Date)
	 * @return String 返回格式化后的当前服务器系统时间，格式为yyyy-MM-dd HH:mm:ss，如2006-02-15
	 *         15:23:45
	 */
	public static String getCurrDateTimeStr() {
		return getFormatDateTime(getCurrDateTime());
	}

	/**
	 * 得到格式化后的当前系统日期，格式为yyyy年MM月dd日，如2006年02月15日
	 *
	 * @see #getFormatDate(java.util.Date, String)
	 * @return String 返回当前服务器系统日期，格式为yyyy年MM月dd日，如2006年02月15日
	 */
	public static String getCurrDateStr_CN() {
		return getFormatDate(getCurrDateTime(), DATE_FORMAT_CN);
	}

	/**
	 * 得到格式化后的当前系统时间，格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日 15:23:45
	 *
	 * @see #getFormatDateTime(java.util.Date, String)
	 * @return String 返回格式化后的当前服务器系统时间，格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日
	 *         15:23:45
	 */
	public static String getCurrDateTimeStr_CN() {
		return getFormatDateTime(getCurrDateTime(), TIME_FORMAT_CN);
	}

	/**
	 * 得到系统当前日期的前或者后几天
	 *
	 * @param iDate
	 *            如果要获得前几天日期，该参数为负数； 如果要获得后几天日期，该参数为正数
	 * @see java.util.Calendar#add(int, int)
	 * @return Date 返回系统当前日期的前或者后几天
	 */
	public static Date getDateBeforeOrAfter(int iDate) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, iDate);
		return cal.getTime();
	}

	/**
	 * 得到日期的前或者后几天
	 *
	 * @param iDate
	 *            如果要获得前几天日期，该参数为负数； 如果要获得后几天日期，该参数为正数
	 * @see java.util.Calendar#add(int, int)
	 * @return Date 返回参数<code>curDate</code>定义日期的前或者后几天
	 */
	public static Date getDateBeforeOrAfter(Date curDate, int iDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(curDate);
		cal.add(Calendar.DAY_OF_MONTH, iDate);
		return cal.getTime();
	}

	/**
	 * 得到格式化后的月份，格式为yyyy-MM，如2006-02
	 *
	 * @param currDate
	 *            要格式化的日期
	 * @see #getFormatDate(java.util.Date, String)
	 * @return String 返回格式化后的月份，格式为yyyy-MM，如2006-02
	 */
	public static String getFormatMonth(java.util.Date currDate) {
		return getFormatDate(currDate, MONTH_FORMAT);
	}

	/**
	 * 得到格式化后的日，格式为yyyyMMdd，如20060210
	 *
	 * @param currDate
	 *            要格式化的日期
	 * @see #getFormatDate(java.util.Date, String)
	 * @return String 返回格式化后的日，格式为yyyyMMdd，如20060210
	 */
	public static String getFormatDay(java.util.Date currDate) {
		return getFormatDate(currDate, DAY_FORMAT);
	}

	/**
	 * 得到当月第一天，格式为yyyy-MM-dd，如2006-02-01
	 *
	 * @see java.util.Calendar#getMinimum(int)
	 * @see #getFormatDate(java.util.Date, String)
	 * @return String 返回当月第一天，
	 */
	public static Date getFirstDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		return cal.getTime();
	}

	/**
	 * 得到格式化后的当月第一天，格式为yyyy-MM-dd，如2006-02-01
	 *
	 * @see java.util.Calendar#getMinimum(int)
	 * @see #getFormatDate(java.util.Date, String)
	 * @return String 返回格式化后的当月第一天，格式为yyyy-MM-dd，如2006-02-01
	 */
	public static String getFormatFirstDayOfMonth() {
		return getFormatDate(getFirstDayOfMonth(), DATE_FORMAT);
	}

	/**
	 * 下月第一天，格式为yyyy-MM-dd，如2006-02-01
	 *
	 * @see java.util.Calendar#getMinimum(int)
	 * @see #getFormatDate(java.util.Date, String)
	 * @return String 下月第一天，
	 */
	public static Date getFirstDayOfNextMonth() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, +1);
		int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		return  cal.getTime();
	}

	/**
	 * 得到格式化后的下月第一天，格式为yyyy-MM-dd，如2006-02-01
	 *
	 * @see java.util.Calendar#getMinimum(int)
	 * @see #getFormatDate(java.util.Date, String)
	 * @return String 返回格式化后的下月第一天，格式为yyyy-MM-dd，如2006-02-01
	 */
	public static String getFormartFirstDayOfNextMonth() {
		return getFormatDate(getFirstDayOfNextMonth(), DATE_FORMAT);
	}

	/**
	 * 得到指定日期格式化后当月第一天，格式为yyyy-MM-dd，如2006-02-01
	 *
	 * @param currDate
	 *            要格式化的日期
	 * @see java.util.Calendar#getMinimum(int)
	 * @see #getFormatDate(java.util.Date, String)
	 * @return String 返回格式化后的当月第一天，格式为yyyy-MM-dd，如2006-02-01
	 */
	public static String getFormatFirstDayOfMonth(Date currDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(currDate);
		int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		return getFormatDate(cal.getTime(), DATE_FORMAT);
	}

	/**
	 * 得到指定日期格式化后当月最后一天，格式为yyyy-MM-dd，如2006-02-01
	 *
	 * @param currDate
	 *            要格式化的日期
	 * @see java.util.Calendar#getMinimum(int)
	 * @see #getFormatDate(java.util.Date, String)
	 * @return String 返回格式化后的当月第一天，格式为yyyy-MM-dd，如2006-02-01
	 */
	public static String getFormatLastDayOfMonth(Date currDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(currDate);
		int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		return getFormatDate(cal.getTime(), DATE_FORMAT);
	}

	/**
	 * 得到指定日期当月第一天
	 *
	 * @param currDate
	 *            要格式化的日期
	 * @see java.util.Calendar#getMinimum(int)
	 * @see #getFormatDate(java.util.Date, String)
	 * @return String 返回格式化后的当月第一天，格式为yyyy-MM-dd，如2006-02-01
	 */
	public static Date getFirstDayOfMonth(Date currDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(currDate);
		int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		return cal.getTime();
	}

	/**
	 * 得到指定日期当月最后一天
	 *
	 * @param currDate
	 *            要格式化的日期
	 * @see java.util.Calendar#getMinimum(int)
	 * @see #getFormatDate(java.util.Date, String)
	 * @return String 返回格式化后的当月第一天，格式为yyyy-MM-dd，如2006-02-01
	 */
	public static Date getLastDayOfMonth(Date currDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(currDate);
		int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		return cal.getTime();
	}

	/**
	 * 得到日期的前或者后几小时
	 *
	 * @param iHour
	 *            如果要获得前几小时日期，该参数为负数； 如果要获得后几小时日期，该参数为正数
	 * @see java.util.Calendar#add(int, int)
	 * @return Date 返回参数<code>curDate</code>定义日期的前或者后几小时
	 */
	public static Date getDateBeforeOrAfterHours(Date curDate, int iHour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(curDate);
		cal.add(Calendar.HOUR_OF_DAY, iHour);
		return cal.getTime();
	}
	
	/**
	 * 得到日期的前或者后几分钟
	 * @param curDate
	 * @param minutes
	 * @return
	 */
	public static Date getDateBeforeOrAfterMinute(Date curDate, int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(curDate);
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}

	/**
	 * 判断日期是否在当前周内
	 * 
	 * @param curDate
	 * @param compareDate
	 * @return
	 * @throws ParseException
	 */
	public static boolean isSameWeek(Date curDate, Date compareDate) throws ParseException {
		if (curDate == null || compareDate == null) {
			return false;
		}

		Calendar calSun = Calendar.getInstance();
		calSun.setTime(getFormatDateToDate(curDate));
		calSun.set(Calendar.DAY_OF_WEEK, 1);

		Calendar calNext = Calendar.getInstance();
		calNext.setTime(calSun.getTime());
		calNext.add(Calendar.DATE, 7);

		Calendar calComp = Calendar.getInstance();
		calComp.setTime(compareDate);
		if (calComp.after(calSun) && calComp.before(calNext)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 时间查询时,结束时间的 23:59:59
	 */
	public static String addDateEndfix(String datestring) {
		if ((datestring == null) || datestring.equals("")) {
			return null;
		}
		return datestring + " 23:59:59";
	}

	
	/**
	 * 返回格式化的日期
	 * 
	 * @param datePre
	 *            格式"yyyy-MM-dd HH:mm:ss";
	 * @return
	 * @throws ParseException
	 */
	public static Date formatEndTime(String datePre) throws ParseException {
		if (datePre == null)
			return null;
		String dateStr = addDateEndfix(datePre);
		return getFormatDateTime(dateStr);
	}

	// date1加上compday天数以后的日期与当前时间比较，如果大于当前时间返回true，否则false
	public static Boolean compareDay(Date date1, int compday) {
		if (date1 == null)
			return false;
		Date dateComp = getDateBeforeOrAfter(date1, compday);
		Date nowdate = new Date();
		if (dateComp.after(nowdate))
			return true;
		else
			return false;
	}

	/**
	 * 进行时段格式转换，对于输入的48位的01串，将进行如下操作： <li>1.先将输入中每个0变成两个0，每个1变成2个1，形成一个96位的二进制串。
	 * </li> <li>2.将上述的96位的二进制串分成3组，每组32位。</li> <li>3.将每个32位的二进制串转换成一个8位的16进制串。</li>
	 * <li>4.将3个8位的16进制串合并成一个串，中间以","分割。</li>
	 * 
	 * @param timespan
	 *            一个48位的二进制串，如：
	 *            "011111111011111111111111111111111111111111111110"
	 * @return 一个16进制串，每位间以","分割。如："3fffcfff,ffffffff,fffffffc"
	 */
	public static String convertBinaryTime2Hex(String timespan) {
		if (timespan == null || timespan.equals("")) {
			return "";
		}

		String ret = "";
		String tmp = "";
		for (int i = 0; i < timespan.length(); i++) {
			tmp += timespan.charAt(i);
			tmp += timespan.charAt(i);
			// tmp += i;
			if ((i + 1) % 16 == 0) {
				if (!ret.equals("")) {
					ret += ",";
				}
				Long t = Long.parseLong(tmp, 2);
				String hexStr = Long.toHexString(t);
				if (hexStr.length() < 8) {
					int length = hexStr.length();
					for (int n = 0; n < 8 - length; n++) {
						hexStr = "0" + hexStr;
					}
				}

				ret += hexStr;
				tmp = "";
			}
		}

		return ret;
	}

	/**
	 * 进行时段格式转换，将输入的26位的2进制串转换成48位的二进制串。
	 * 
	 * @param timespan
	 *            一个16进制串，每位间以","分割。如："3fffcfff,ffffffff,fffffffc"
	 * @return 一个48位的二进制串，如："011111111011111111111111111111111111111111111110"
	 */
	public static String convertHexTime2Binary(String timespan) {
		if (timespan == null || timespan.equals("")) {
			return "";
		}

		String tmp = "";
		String ret = "";
		String[] strArr = timespan.split(",");
		for (int i = 0; i < strArr.length; i++) {
			String binStr = Long.toBinaryString(Long.parseLong(strArr[i], 16));
			if (binStr.length() < 32) {
				int length = binStr.length();
				for (int n = 0; n < 32 - length; n++) {
					binStr = "0" + binStr;
				}
			}
			tmp += binStr;
		}

		for (int i = 0; i < 48; i++) {
			ret += tmp.charAt(i * 2);
		}

		return ret;
	}

	/**
	 * 进行时段格式转换，将输入的32位的10进制串转换成48位的二进制串。
	 * 
	 * @param timespan
	 *            一个16进制串，每位间以","分割。如："1234567890,1234567890,1234567890c"
	 * @return 一个48位的二进制串，如："011111111011111111111111111111111111111111111110"
	 */
	public static String convertDecTime2Binary(String timespan) {
		if (timespan == null || timespan.equals("")) {
			return "";
		}

		String tmp = "";
		String ret = "";
		String[] strArr = timespan.split(",");
		for (int i = 0; i < strArr.length; i++) {
			String binStr = Long.toBinaryString(Long.parseLong(strArr[i], 10));
			if (binStr.length() < 32) {
				int length = binStr.length();
				for (int n = 0; n < 32 - length; n++) {
					binStr = "0" + binStr;
				}
			}
			tmp += binStr;
		}

		for (int i = 0; i < 48; i++) {
			ret += tmp.charAt(i * 2);
		}

		return ret;
	}

	/**
	 * 进行时段格式转换，对于输入的48位的01串，将进行如下操作： <li>1.先将输入中每个0变成两个0，每个1变成2个1，形成一个96位的二进制串。
	 * </li> <li>2.将上述的96位的二进制串分成3组，每组32位。</li> <li>3.将每个32位的二进制串转换成一个10位的10进制串。
	 * </li> <li>4.将3个8位的16进制串合并成一个串，中间以","分割。</li>
	 * 
	 * @param timespan
	 *            一个48位的二进制串，如：
	 *            "011111111011111111111111111111111111111111111110"
	 * @return 一个16进制串，每位间以","分割。如："1234567890,1234567890,1234567890"
	 */
	public static String convertBinaryTime2Dec(String timespan) {
		if (timespan == null || timespan.equals("")) {
			return "";
		}

		String ret = "";
		String tmp = "";
		for (int i = 0; i < timespan.length(); i++) {
			tmp += timespan.charAt(i);
			tmp += timespan.charAt(i);
			// tmp += i;
			if ((i + 1) % 16 == 0) {
				if (!ret.equals("")) {
					ret += ",";
				}
				Long t = Long.parseLong(tmp, 2);
				String decStr = Long.toString(t);
				if (decStr.length() < 10) {
					int length = decStr.length();
					for (int n = 0; n < 10 - length; n++) {
						decStr = "0" + decStr;
					}
				}

				ret += decStr;
				tmp = "";
			}
		}

		return ret;
	}

	/**
	 * 第二个参数减去第一个参数，差多少天
	 * 
	 * @return two与one的差值（天） author:金龙
	 */
	public static int compareDay(Date one, Date two) {
		long num1 = one.getTime();
		long num2 = two.getTime();
		return (int) ((num2 - num1) / (24 * 3600 * 1000));
	}

	/**
	 * 
	 * @Description 第二个参数减去第一个参数，差多少天
	 * @param one 日期格式，如yyyy-MM-dd
	 * @param two 日期格式，如yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 *
	 */
	public static int compareDay(String one, String two) throws ParseException {
		Date oneDate = getFormatDate(one);
		Date twoDate = getFormatDate(two);
		return compareDay(oneDate,twoDate);
	}
	
	/**
	 * 
	 * @Description 第二个参数减去第一个参数，第2个日期是否小于第一个日期
	 * @param one 日期格式，如yyyy-MM-dd
	 * @param two 日期格式，如yyyy-MM-dd
	 * @return  
	 *
	 */
	public static boolean compareDate_lt(String one, String two){
		try {
			if (compareDay(one,two)<0){
				return true;
			}
		} catch (ParseException e) {
			return false;
		}
		return false;
	}
	

	/**
	 * 第二个参数减去第一个参数，差多少小时
	 * 
	 * @return two与one的差值（小时） author:金龙
	 */
	public static int compareHour(Date one, Date two) {
		long num1 = one.getTime();
		long num2 = two.getTime();
		return (int) ((num2 - num1) / (3600 * 1000));
	}

	/**
	 * 第二个参数减去第一个参数，差多少分钟
	 * 
	 * @return two与one的差值（分钟） author:金龙
	 */
	public static int compareMinuter(Date one, Date two) {
		long num1 = one.getTime();
		long num2 = two.getTime();
		return (int) ((num2 - num1) / (60 * 1000));
	}
	
	/**
	 * 
	 * 第二个参数减去第一个参数，差多少秒
	 * @Description
	 * @param one
	 * @param two
	 * @return  
	 *
	 */
	public static int compareSeconds(Date one, Date two){
		long num1 = one.getTime();
		long num2 = two.getTime();
		return (int) ((num2 - num1) / (1000));		
	}
	
	/**
	 * 
	 * @Description 格式化为日期，传入格式为yyyyMMddHHmmss
	 * @param sDate
	 * @return  
	 * @throws ParseException
	 *
	 */
    public static Date parseDateLongFormat(String sDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(LONG_FORMAT);
        Date d = null;

        if ((sDate != null) && (sDate.length() == LONG_FORMAT.length())) {
        	d = dateFormat.parse(sDate);
        }

        return d;
    }	
    
    public static Date parseDateFormat(String sDate, String format) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date d = null;

        if ((sDate != null) && (sDate.length() == format.length())) {
        	d = dateFormat.parse(sDate);
        }

        return d;
    }	
    
    /**
     * 
     * @Description 日期格式化为yyyyMMddHHmmss
     * @param date
     * @return  
     *
     */
    public static String getLongDateString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(LONG_FORMAT);

        return getDateString(date, dateFormat);
    }    
    
    /**
     * 判断表示时间的字符是否为符合yyyyMMddHHmmss格式
     * 
     * @param strDate
     * @return
     */
    public static boolean isValidLongDateFormat(String strDate) {
        if (strDate.length() != LONG_FORMAT.length()) {
            return false;
        }

        try {
            Long.parseLong(strDate); //---- 避免日期中输入非数字 ----
        } catch (Exception NumberFormatException) {
            return false;
        }

        DateFormat df = getNewDateFormat(LONG_FORMAT);

        try {
            df.parse(strDate);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    /**
     * 判断表示时间的字符是否为符合yyyyMMddHHmmss格式
     * 
     * @param strDate
     * @param delimiter
     * @return
     */
    public static boolean isValidLongDateFormat(String strDate, String delimiter) {
        String temp = strDate.replaceAll(delimiter, "");

        return isValidLongDateFormat(temp);
    }    
    
    public static String getDateString(Date date, DateFormat dateFormat) {
        if (date == null || dateFormat == null) {
            return null;
        }

        return dateFormat.format(date);
    }    
    
    public static DateFormat getNewDateFormat(String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);

        df.setLenient(false);
        return df;
    }    
    // 获得当天0点时间
 	public static Date getTimesmorning() {
 		Calendar cal = Calendar.getInstance();
 		cal.set(Calendar.HOUR_OF_DAY, 0);
 		cal.set(Calendar.SECOND, 0);
 		cal.set(Calendar.MINUTE, 0);
 		cal.set(Calendar.MILLISECOND, 0);
 		return cal.getTime();
 	}

 	// 获得当天24点时间
 	public static Date getTimesnight() {
 		Calendar cal = Calendar.getInstance();
 		cal.set(Calendar.HOUR_OF_DAY, 24);
 		cal.set(Calendar.SECOND, 0);
 		cal.set(Calendar.MINUTE, 0);
 		cal.set(Calendar.MILLISECOND, 0);
 		return  cal.getTime();
 	}
 	
    // 获取昨天0点时间
 	public static Date getYesterdayTime(){
 	   Calendar cal = Calendar.getInstance();
       cal.add(Calendar.DATE,-1);
       cal.set(Calendar.HOUR_OF_DAY, 0);
       cal.set(Calendar.SECOND, 0);
	   cal.set(Calendar.MINUTE, 0);
	   cal.set(Calendar.MILLISECOND, 0);
       return cal.getTime();
 	}
 	
 	// 获得本周一0点时间
 	public static Date getTimesWeekmorning() {
 		Calendar cal = Calendar.getInstance();
 		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
 		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
 		return  cal.getTime();
 	}

 	// 获得本周日24点时间
 	public  static Date getTimesWeeknight() {
 		Calendar cal = Calendar.getInstance();
 		cal.setTime(getTimesWeekmorning());
 		cal.add(Calendar.DAY_OF_WEEK, 7);
 		return cal.getTime();
 	}

 	// 获得本月第一天0点时间
 	public static Date getTimesMonthmorning() {
 		Calendar cal = Calendar.getInstance();
 		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
 		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
 		return  cal.getTime();
 	}
	// 获得指定月第一天0点时间
	public static Date getTimesMonthmorning(Date month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(month);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return  cal.getTime();
	}

 	// 获得本月最后一天24点时间
 	public static Date getTimesMonthnight() {
 		Calendar cal = Calendar.getInstance();
 		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
 		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
 		cal.set(Calendar.HOUR_OF_DAY, 24);
 		return cal.getTime();
 	}

	// 获得指定月最后一天24点时间
	public static Date getTimesMonthnight(Date month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(month);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 24);
		return cal.getTime();
	}

	// 获得本年第一天0点时间
	public static Date getTimesYearmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), Calendar.JANUARY, 1, 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return  cal.getTime();
	}
	
	// 获得本年最后一天24点时间
	public static Date getTimesYearnight() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), Calendar.DECEMBER, 0, 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}
	// 获得上一年第一天0点时间
	public static Date getLastTimesYearmorning() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -1);
		cal.set(cal.get(Calendar.YEAR), Calendar.JANUARY, 1, 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return  cal.getTime();
	}
	
	// 获得上一年最后一天24点时间
	public static Date getLastTimesYearnight() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -1);
		cal.set(cal.get(Calendar.YEAR), Calendar.DECEMBER, 0, 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}
	
	// 获得前年第一天0点时间
	public static Date getLastBeforeTimesYearmorning() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -2);
		cal.set(cal.get(Calendar.YEAR), Calendar.JANUARY, 1, 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return  cal.getTime();
	}
	
	// 获得前年最后一天24点时间
	public static Date getLastBeforeTimesYearnight() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -2);
		cal.set(cal.get(Calendar.YEAR), Calendar.DECEMBER, 0, 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}
 	
	public static void main(String[] args) {
		/** ***********Test of convertTimeSpan***************** */
		
//		
//		System.out
//				.println(getLongDateString(new Date()));
//		System.out
//				.println(convertDecTime2Binary("0000000000,1073741823,4290772992"));
		
		
//		try {
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(DateTimeUtil.getFormatDate("2011-2-5"));
//			int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
//			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//			cal.set(Calendar.DAY_OF_MONTH, firstDay);
//			System.out.println(getFormatDate(cal.getTime(), DATE_FORMAT));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Calendar c = Calendar.getInstance();
		c.setTime(	new Date());
		c.add(Calendar.DAY_OF_YEAR,-30);
		System.out.println(c.getTime());
	}
	
	/** 
	 * 获取指定日期是星期几
	 * 参数为null时表示获取当前日期是星期几
	 * @param date
	 * @return
	 */
	public static String getWeekOfDate(Date date) {
	    String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
	    Calendar calendar = Calendar.getInstance();
	    if(date != null){        
	         calendar.setTime(date);      
	    }        
	    int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
	    if (w < 0){        
	        w = 0;      
	    }      
	    return weekOfDays[w];    
	}


	/**
	 * 根据 相差日期 得到 是否 包括节假日 的日期
	 * @param source 目标时间 默认为当前时间
	 * @param days 相差日期 正数为后几天 负数为前几天
	 * @param withoutWeekend 是否忽略节假日
	 * @return 新的日期
	 */
	public static Date getDatePredicate(Date source, Float days, boolean withoutWeekend) {
		int isPositive = 1;
		if (days < 0) {
			isPositive = -1;
		}

		Integer daysAbs = Math.abs(days.intValue());
		Calendar calendar = Calendar.getInstance();
		if (source == null) {
			source = new Date();
		}
		calendar.setTime(source);

		while(daysAbs>0){
			calendar.add(Calendar.DAY_OF_MONTH,isPositive);
			int week = calendar.get(Calendar.DAY_OF_WEEK);
			if(withoutWeekend){
				if (week != 1 && week != 7) {
					daysAbs --;
				}
			}else{
				daysAbs --;
			}

		}
		return calendar.getTime();
	}

	/**
	 * 判断两个日期是否是同一天 只判断日期 不判断时间
	 * @param source 日期-
	 * @param target 日期二
	 * @return 是否为同一天
	 */
	public static boolean isSameDay(Date source, Date target) {
		Calendar sourceCal = Calendar.getInstance();
		sourceCal.setTime(source);

		Calendar targetCal = Calendar.getInstance();
		targetCal.setTime(target);

		if(sourceCal.get(Calendar.YEAR) != targetCal.get(Calendar.YEAR)){
			return false;
		}

		if (sourceCal.get(Calendar.DAY_OF_YEAR) != targetCal.get(Calendar.DAY_OF_YEAR)) {
			return false;
		}

		return true;
	}

	public static int compare(Date a, Date b){
		Calendar aC = Calendar.getInstance();
		aC.setTime(a);
		aC.set(Calendar.HOUR_OF_DAY,0);
		aC.set(Calendar.MINUTE,0);
		aC.set(Calendar.SECOND,0);
		aC.set(Calendar.MILLISECOND,0);

		Calendar bC = Calendar.getInstance();
		bC.setTime(b);
		bC.set(Calendar.HOUR_OF_DAY,0);
		bC.set(Calendar.MINUTE,0);
		bC.set(Calendar.SECOND,0);
		bC.set(Calendar.MILLISECOND,0);

		return aC.getTime().compareTo(bC.getTime());

	}
	/**
	 * a日期增加c天与b比较(精确到天)
	 * @Author xxw
	 * @param a b c
	 * @return <0 小于 =0 等于 >0 大于
	 */
	public static int compareDate(Date a, Date b, Integer c){
		Calendar aC = Calendar.getInstance();
		aC.setTime(a);
		aC.set(Calendar.DAY_OF_YEAR,c);

		Calendar bC = Calendar.getInstance();
		bC.setTime(b);
		bC.set(Calendar.DAY_OF_YEAR,0);

		return aC.getTime().compareTo(bC.getTime());

	}

	/**
	 * 得到指定日期的最晚时间 23:59:59
	 * @Author jin
	 * @param date 指定日期时间
	 * @return 指定日期的最晚时间
	 */
	public static Date dayLastTime(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.set(Calendar.HOUR_OF_DAY,23);
		calendar.set(Calendar.MINUTE,59);
		calendar.set(Calendar.SECOND,59);
		calendar.set(Calendar.MILLISECOND,999);

		return calendar.getTime();
	}

	public static Date dayFirstTime(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);

		return calendar.getTime();
	}

	/**
	 * 得到今天最晚时间 23:59:59
	 * @Author jin
	 * @return 今天日期的最晚时间
	 */
	public static Date dayLastTime() {
		return dayLastTime(null);
	}


	/**
	 * 获取今天的几天后时间
	 * **/

	public static Date fewDaysLater(Date date, Integer day){
		if (day == null) {
			return date;
		}
		Long time = date.getTime() + (day * 24 * 3600*1000);
		return dayLastTime(new Date(time));
	}

	/*字符串转时间戳  C_SHARP_FORMAT*/
	public static String timeStamp2Date(String time){
		if(time==null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(C_SHARP_FORMAT);
		return sdf.format(new Date(Long.valueOf(time)));
	}
	/**
	 * 转换时间戳(yyyy/MM/dd HH:mm:ss)
	 */
	public static String getTimeStamp(String time) throws ParseException {
		if(time == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(C_SHARP_FORMAT);
		return String.valueOf(sdf.parse(time).getTime());
	}
}
