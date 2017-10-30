/*
 * 
 */
package com.cmcc.ms.common.utils;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;


/**
 * 封装joda-time 工具包.
 *
 * @author zhouxiaofeng
 */
public class TimeParseUtils {

    /** The Constant FORMAT_DATE. */
    public final static String FORMAT_DATE = "yyyy-MM-dd";

    /** The Constant FORMAT_TIME. */
    public final static String FORMAT_TIME = "hh:mm";

    /** The Constant FORMAT_DATE_TIME. */
    public final static String FORMAT_DATE_TIME = "yyyy-MM-dd hh:mm";

    /** The Constant FORMAT_MONTH_DAY_TIME. */
    public final static String FORMAT_MONTH_DAY_TIME = "MM月dd日 hh:mm";

    /** The Constant FORMAT_FULL_DATE_TIME_WITH_SYMBOL. */
    public final static String FORMAT_FULL_DATE_TIME_WITH_SYMBOL = "yyyy-MM-dd HH:mm:ss";

    /** The Constant FORMAT_FULL_DATE_TIME_NO_SYMBOL. */
    public final static String FORMAT_FULL_DATE_TIME_NO_SYMBOL = "yyyyMMddHHmmss";

    /** The Constant FORMAT_FULL_DATE_TIME_WITH_MILLS_NO_SYMBOL. */
    public final static String FORMAT_FULL_DATE_TIME_WITH_MILLS_NO_SYMBOL = "yyyyMMddHHmmssSSS";

    /**
     * <pre>
     * 指定Pattern 格式化时间
     * 
     * date = parseToDate("2000-01-01",FORMAT_DATE_TIME)
     * </pre>.
     *
     * @param strTime            pattern对应的时间
     * @param pattern            strTime的格式
     * @return 格式化结果
     * @throws UnsupportedOperationException             if parsing is not supported
     * @throws IllegalArgumentException             if the text to parse is invalid
     * @see #FORMAT_DATE
     * @see #FORMAT_TIME
     * @see #FORMAT_DATE_TIME
     * @see #FORMAT_MONTH_DAY_TIME
     */
    public static Date parseToDate(String strTime, String pattern) {
        DateTime d = DateTimeFormat.forPattern(pattern).parseDateTime(strTime);
        return d.toDate();
    }

    /**
     * date类型转string.
     *
     * @param date the date
     * @param pattern the pattern
     * @return the string
     */
    public static String parseToString(Date date, String pattern) {
        DateTime time = new DateTime(date);
        return time.toString(pattern);
    }
}
