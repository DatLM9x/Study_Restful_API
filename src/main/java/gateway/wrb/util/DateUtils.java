package gateway.wrb.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    public static final long SECOUND = 1000L;
    public static final long MINUS = 60 * SECOUND;
    public static final long HOUR = 60 * MINUS;
    public static final long A_DAY = 24 * HOUR;
    public static final String DATE_FORMAT = "yyyyMMdd";
    public static final String DATE_TIME_FORMAT = "yyyyMMddHHmmss";

    public static long currentTime() {
        return System.currentTimeMillis();
    }

    public static Date getGMTTime() {
        Date d = new Date(currentTime());
        return d;
    }

    public static int getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static long getTimeCurrentDay(int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static long nextTimeCurrentDay(Date inputDate, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inputDate);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTimeInMillis();
    }

    public static LocalDate getCurrentDate() {
        LocalDate localDate = LocalDate.now();
        return localDate;
    }

    public static Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        return calendar.getTime();
    }

    public static Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 23, 59, 59);
        return calendar.getTime();
    }

    public static Long parseYyyyMMddHHmmSS(String yyyyMMddHHmmss) {
        DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
        try {
            Date date = df.parse(yyyyMMddHHmmss);
            return date.getTime();
        } catch (ParseException e) {
            //
        }
        return null;
    }

    public static String formatDateTime(Long time) {
        if (time == null) {
            return null;
        }
        Date date = new Date(time);
        DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
        return df.format(date);
    }

    public static String formatDate(Long time) {
        if (time == null) {
            return null;
        }

        Date date = new Date(time);
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        return df.format(date);
    }

    public static Long convertDate(String dateStr) {
        if (dateStr == null) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        Long result;
        try {
            result = df.parse(dateStr).getTime();
        } catch (Exception ex) {
            result = null;
        }

        return result;
    }

    public static Long convertDateTime(String dateStr) {
        if (dateStr == null) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
        Long result;
        try {
            result = df.parse(dateStr).getTime();
        } catch (Exception ex) {
            result = null;
        }

        return result;
    }

    public static String formatDateTimeWithTimezone(Long time, String timezone) {
        if (time == null) {
            return null;
        }
        Date date = new Date(time);
        DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
        df.setTimeZone(TimeZone.getTimeZone(timezone));
        return df.format(date);
    }

    public static String getDateFormat(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
}
