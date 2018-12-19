package net.seehope.college.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @BelongsProject: co-college
 * @BelongsPackage: net.seehope.college.util.date
 * @Author: lxgy
 * @CreateTime: 2018-12-14 00:37
 * @Description: 时间日期工具类.
 */
public class DateTimeUtil {
    /*一天换算成毫秒*/
    public static final long DAY_IN_MILLISECOND = 60 * 60 * 24 * 1000;
    /*一月*/
    public static final int JANUARY = 0;
    /*二月*/
    public static final int FEBRUARY = 1;
    /*三月*/
    public static final int MARCH = 2;
    /*四月*/
    public static final int APRIL = 3;
    /*五月*/
    public static final int MAY = 4;
    /*六月*/
    public static final int JUNE = 5;
    /*七月*/
    public static final int JULY = 6;
    /*八月*/
    public static final int AUGUST = 7;
    /*九月*/
    public static final int SEPTEMBER = 8;
    /*十月*/
    public static final int OCTOBER = 9;
    /*十一月*/
    public static final int NOVEMBER = 10;
    /*十二月*/
    public static final int DECEMBER = 11;
    /*星期天*/
    public static final int SUNDAY = 0;
    /*星期一*/
    public static final int MONDAY = 1;
    /*星期二*/
    public static final int TUESDAY = 2;
    /*星期三*/
    public static final int WEDNESDAY = 3;
    /*星期四*/
    public static final int THURSDAY = 4;
    /*星期五*/
    public static final int FRIDAY = 5;
    /*星期六*/
    public static final int SATURDAY = 6;
    /*分钟*/
    public static final String TIMEUNIT_MINUTE = "M";
    /*小时*/
    public static final String TIMEUNIT_HOUR = "H";
    /*天*/
    public static final String TIMEUNIT_DAY = "D";
    /*日*/
    public static final String PERIODUNIT_DAY = "day";
    /*周*/
    public static final String PERIODUNIT_WEEK = "week";
    /*月*/
    public static final String PERIODUNIT_MONTH = "month";
    /*年*/
    public static final String PERIODUNIT_YEAR = "year";

    /**
     * 获取当前日期是星期几 <br />
     * 格式：例如：星期一<br />
     * =====================<br />
     *
     * @param date
     * @return
     * @Author: lxgy
     */
    public static String getWeekOfDate(Date date) {
        String[] weekDays = {"星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * 获取当前日期<br />
     * 时间格式为：yyyy-MM-dd<br />
     * ========================<br />
     *
     * @return
     * @Author:lxgy
     */
    public static String getCurrentDate() {
        return formatDate(new Date());
    }

    /**
     * 获取当前日期.<br />
     * 格式为：yyyy-MM-dd HH:mm:ss<br />
     * ==================<br />
     *
     * @return
     * @Author:lxgy
     */
    public static String getCurrentDateTime() {
        return formatDateTime(new Date());
    }

    /**
     * 格式化日期方法.<br />
     * 格式为：yyyy-MM-dd <br />
     * ======================== <br />
     *
     * @param date
     * @return
     * @Author lxgy
     */
    public static String formatDate(Date date) {
        String currentDate = "";
        if (date != null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            currentDate = df.format(date);
        }
        return currentDate;
    }

    /**
     * 格式化日期方法<br />
     * 格式为：yyyy-MM-dd HH:mm:ss<br />
     * =========================<br />
     *
     * @param date
     * @return
     * @Author:lxgy
     */
    public static String formatDateTime(Date date) {
        String currenDate = "";
        if (date != null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            currenDate = df.format(date);
        }
        return currenDate;
    }

    /**
     * 获取当前时间的hour的值<br />
     * =================<br />
     *
     * @param date
     * @return
     * @Author：lxgy
     */
    public static int getHour(Date date) {
        int hour = 0;
        if (date != null) {
            hour = date.getHours();
        }
        return hour;
    }

    /**
     * 获取当前时间的minutes<br/>
     * ====================<br/>
     *
     * @param date
     * @return
     */
    public static int getMinute(Date date) {
        int minutes = 0;
        if (date != null) {
            minutes = date.getMinutes();
        }
        return minutes;
    }

    /**
     * 根绝时间格式的字符串以及对应的格式转换为字符串<br />
     * 比如：2018-12-12 yyyy-MM-dd<br/>
     * ======================================<br/>
     *
     * @param dateTime
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date getDate(String dateTime, String format) throws ParseException {
        if (dateTime == null || dateTime.length() == 0) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(format);
        return df.parse(dateTime);
    }
}
