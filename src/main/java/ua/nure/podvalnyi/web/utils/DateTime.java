package ua.nure.podvalnyi.web.utils;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class DateTime {

    public static Date getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        return date;
    }

    public static Time getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Time time = new Time(System.currentTimeMillis());
        System.out.println(formatter.format(time));
        return time;
    }

    public static Date dateOfMajority(){
        LocalDate localDate = getDate().toLocalDate();
        localDate = localDate.minusYears(18).minusDays(1);
        return Date.valueOf(localDate);
    }
}
