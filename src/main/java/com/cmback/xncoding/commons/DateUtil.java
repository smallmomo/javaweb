package com.cmback.xncoding.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/11/5.
 */
public class DateUtil {

    public static int DATE_TIME_FMT = 1;

    public static int TIME_STAMP_FMT = 2;

    public static int DATE_FMT = 3;

    public static int YEAR_MONTH_FMT = 4;

    public static long MILLS_IN_1Hour = 1000*60*60;

    private static SimpleDateFormat dateTimeFmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    private static SimpleDateFormat timeStampFmt = new SimpleDateFormat("yyyyMMddhhmmssSSS");

    private static SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");

    private static SimpleDateFormat yearMonthFmt = new SimpleDateFormat("yyyyMM");


    public static String getDateString(Date date, int type) {

        String str = null;

        if (DATE_TIME_FMT == type) {

            str = dateTimeFmt.format(date);

        } else if (TIME_STAMP_FMT == type) {

            str = timeStampFmt.format(date);

        } else if (DATE_FMT == type) {

            str = dateFmt.format(date);

        } else if (YEAR_MONTH_FMT == type) {

            str = yearMonthFmt.format(date);

        } else {
            throw new IllegalArgumentException("No format type match, type = " + type);
        }

        return str;
    }

    public static Date parseDateStr (String dateStr, int type) throws ParseException {
        Date date = null;

        if (DATE_TIME_FMT == type) {

            date = dateTimeFmt.parse(dateStr);

        } else if (TIME_STAMP_FMT == type) {

            date = timeStampFmt.parse(dateStr);

        } else if (DATE_FMT == type) {

            date = dateFmt.parse(dateStr);

        } else if (YEAR_MONTH_FMT == type) {

            date = yearMonthFmt.parse(dateStr);

        } else {
            throw new IllegalArgumentException("No format type match, type = " + type);
        }

        return date;
    }
}