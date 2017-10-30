/*
 * 
 */
package com.cmcc.ms.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * TODO Comment of DataUtils.
 *
 * @author zengqun
 */
public class DateUtils {

    /**
     * get system time for millisecond.
     *
     * @return the system time
     */
    public static String getSystemTime() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }

    /** The Constant YMD. */
    public static final String YMD = "yyyyMMdd";

    /** The Constant YMD_SLASH. */
    public static final String YMD_SLASH = "yyyy/MM/dd";

    /** The Constant YMD_DASH. */
    public static final String YMD_DASH = "yyyy-MM-dd";

    /** The Constant YM_DASH. */
    public static final String YM_DASH = "yyyy-MM";

    /** The Constant YMD_DASH_WITH_TIME. */
    public static final String YMD_DASH_WITH_TIME = "yyyy-MM-dd H:m";

    /** The Constant YDM_SLASH. */
    public static final String YDM_SLASH = "yyyy/dd/MM";

    /** The Constant YDM_DASH. */
    public static final String YDM_DASH = "yyyy-dd-MM";

    /** The Constant HM. */
    public static final String HM = "HHmm";

    /** The Constant HM_COLON. */
    public static final String HM_COLON = "HH:mm";

    /**  年、月、日、 时分秒，日期格式转换. */
    public static String DATE_FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";

    /** The Constant DAY. */
    public static final long DAY = 24 * 60 * 60 * 1000L;

    /** The Constant DFS. */
    private static final Map<String, DateFormat> DFS = new HashMap<String, DateFormat>();

    /** The Constant log. */
    private static final Log log = LogFactory.getLog(DateUtils.class);

    /**
     *  
     * 获得指定日期的前一天 
     *  
     *
     * @param format the format
     * @param specifiedDay the specified day
     * @return the specified day before
     */
    public static String getSpecifiedDayBefore(String format, String specifiedDay) {//可以用new Date().toLocalString()传递参数  
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat(format).parse(specifiedDay);
            c.setTime(date);
            int day = c.get(Calendar.DATE);
            c.set(Calendar.DATE, day - 1);

            String dayBefore = new SimpleDateFormat(format).format(c.getTime());
            return dayBefore;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     *  
     * 获得指定日期的后一天 
     *  
     *
     * @param format the format
     * @param specifiedDay the specified day
     * @return the specified day after
     */
    public static String getSpecifiedDayAfter(String format, String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat(format).parse(specifiedDay);
            c.setTime(date);
            int day = c.get(Calendar.DATE);
            c.set(Calendar.DATE, day + 1);

            String dayAfter = new SimpleDateFormat(format).format(c.getTime());
            return dayAfter;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 将时间unix转换为int类型.
     *
     * @param timeString the time string
     * @param format the format
     * @return the int
     */
    public static int dateToInt(String timeString, String format) {

        int time = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date date = sdf.parse(timeString);
            String strTime = date.getTime() + "";
            if (strTime.length() >= 10) {
                if (Long.parseLong(strTime) <= Integer.MAX_VALUE) {
                    strTime = strTime.substring(0, 10);
                } else {
                    strTime = strTime.substring(0, 9);
                }
            } else {
                strTime = strTime.substring(0, 9);
            }
            time = Integer.parseInt(strTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 将时间unix转换为int类型.
     *
     * @param timeInt the time int
     * @param format the format
     * @return the string
     */
    public static String dateToStr(Integer timeInt, String format) {
        Date date = new Date();
        long time = 0;
        if ((timeInt * 1000L) > Integer.MAX_VALUE) {
            time = timeInt * 1000L;
        } else {
            time = timeInt * 100L;
        }
        date.setTime(time);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * Gets the format.
     *
     * @param pattern the pattern
     * @return the format
     */
    public static DateFormat getFormat(String pattern) {
        DateFormat format = DFS.get(pattern);
        if (format == null) {
            format = new SimpleDateFormat(pattern);
            DFS.put(pattern, format);
        }
        return format;
    }

    /**
     * Parses the.
     *
     * @param source the source
     * @param pattern the pattern
     * @return the date
     */
    public static Date parse(String source, String pattern) {
        if (source == null) {
            return null;
        }
        Date date;
        try {
            date = getFormat(pattern).parse(source);
        } catch (ParseException e) {
            if (log.isDebugEnabled()) {
                log.debug(source + " doesn't match " + pattern);
            }
            return null;
        }
        return date;
    }

    /**
     * Format.
     *
     * @param date the date
     * @param pattern the pattern
     * @return the string
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return getFormat(pattern).format(date);
    }

    /**
     * * @param year * * @param month * 月(1-12) * @param day * (1-31) * @return
     * 输入、月、否效期.
     *
     */
    public static boolean isValid(int year, int month, int day) {
        if (month > 0 && month < 13 && day > 0 && day < 32) {
            // month of calendar is 0-based
            int mon = month - 1;
            Calendar calendar = new GregorianCalendar(year, mon, day);
            if (calendar.get(Calendar.YEAR) == year && calendar.get(Calendar.MONTH) == mon
                    && calendar.get(Calendar.DAY_OF_MONTH) == day) {
                return true;
            }
        }
        return false;
    }

    /**
     * Convert.
     *
     * @param date the date
     * @return the calendar
     */
    private static Calendar convert(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }

    /**
     *  * 返指定数位移期.
     *
     * @param date the date
     * @param offset the offset
     * @return the date
     */
    public static Date yearOffset(Date date, int offset) {
        return offsetDate(date, Calendar.YEAR, offset);
    }

    /**
     *  * 返指定月数位移期.
     *
     * @param date the date
     * @param offset the offset
     * @return the date
     */
    public static Date monthOffset(Date date, int offset) {
        return offsetDate(date, Calendar.MONTH, offset);
    }

    /**
     *  * 返指定数位移期.
     *
     * @param date the date
     * @param offset the offset
     * @return the date
     */
    public static Date dayOffset(Date date, int offset) {
        return offsetDate(date, Calendar.DATE, offset);
    }

    /**
     * * 返指定期相应位移期 * * @param date * 参考期 * @param field * 位移单位见 {@link Calendar}
     * * @param offset * 位移数量数表示间负数表示前间 * @return 位移期.
     *
     */
    public static Date offsetDate(Date date, int field, int offset) {
        Calendar calendar = convert(date);
        calendar.add(field, offset);
        return calendar.getTime();
    }

    /**
     *  * 返月第期.
     *
     * @param date the date
     * @return the date
     */
    public static Date firstDay(Date date) {
        Calendar calendar = convert(date);
        calendar.set(Calendar.DATE, 1);
        return calendar.getTime();
    }

    /**
     *  * 返月期.
     *
     * @param date the date
     * @return the date
     */
    public static Date lastDay(Date date) {
        Calendar calendar = convert(date);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        return calendar.getTime();
    }

    /**
     * * 返两期间差异数 * * @param date1 * 参照期 * @param date2 * 比较期 * @return
     * 参照期与比较期间数差异数表示参照期比较期0表示两期同负数表示参照期比较期前.
     *
     */
    public static int dayDiff(Date date1, Date date2) {
        long diff = date1.getTime() - date2.getTime();
        return (int) (diff / DAY);
    }

    /**
     * Gets the month first day.
     *
     * @author houyuliang
     * @param yyyymmStr            格式为 yyyy-MM
     * @return yyyy-MM-dd
     * @Description 得到某月的第一天
     * @time 2015年8月4日 下午5:08:53
     */
    public static String getMonthFirstDay(String yyyymmStr) {
        Date yyyymm = DateUtils.parse(yyyymmStr, "yyyy-MM");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(yyyymm);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));

        return sdf.format(calendar.getTime());
    }

    /**
     * 得到某月的最后一天.
     *
     * @param yyyymmStr the yyyymm str
     * @return the month last day
     */
    /**
     * @Description 得到某月的最后一天
     * @param yyyymmStr
     *            格式为 yyyy-MM
     * @return yyyy-MM-dd
     * @author houyuliang
     * @time 2015年8月4日 下午5:07:59
     */
    public static String getMonthLastDay(String yyyymmStr) {
        Date yyyymm = DateUtils.parse(yyyymmStr, "yyyy-MM");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(yyyymm);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        return sdf.format(calendar.getTime());
    }

    /**
     * 得到月的第一天.
     *
     * @return the month first day
     */
    public static String getMonthFirstDay() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));

        return sdf.format(calendar.getTime());
    }

    /**
     * 得到月的最后一天.
     *
     * @return the month last day
     */
    public static String getMonthLastDay() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        return sdf.format(calendar.getTime());
    }

    /**
     * Gets the date str set.
     *
     * @param startDate the start date
     * @param endDate the end date
     * @return the date str set
     */
    public static String getDateStrSet(Date startDate, Date endDate) {
        StringBuilder sbuf = new StringBuilder();
        while (!(startDate.after(endDate))) {
            sbuf.append(format(startDate, "yyyyMMdd") + " ");
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            startDate = cal.getTime();
        }

        return sbuf.toString();

    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Calendar cla = Calendar.getInstance();
        cla.set(Calendar.YEAR, 2015);
        cla.set(Calendar.MONTH, 10);
        cla.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = cla.getTime();
        cla.set(Calendar.YEAR, 2016);
        cla.set(Calendar.MONTH, 0);
        cla.set(Calendar.DAY_OF_MONTH, 23);
        Date endDate = cla.getTime();
        getDateStrSet(startDate, endDate);
        String dateToStr = dateToStr(1459440000, YMD_DASH);
        int dateToInt = dateToInt("2016-04-01", YMD_DASH);
        System.out.println(dateToInt);
        System.out.println(dateToStr);
    }

}
