package com.amap.api.mapcore2d;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class t {
  public static double a(String paramString1, String paramString2) {
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date date = simpleDateFormat.parse(paramString1);
      long l = (simpleDateFormat.parse(paramString2).getTime() - date.getTime()) / 86400000L;
      return l;
    } catch (ParseException parseException) {
      parseException.printStackTrace();
      return -1.0D;
    } 
  }
  
  public static String a() {
    return a(Calendar.getInstance());
  }
  
  public static String a(Calendar paramCalendar) {
    return a(paramCalendar.getTime(), "yyyy-MM-dd");
  }
  
  public static String a(Date paramDate, String paramString) {
    return (new SimpleDateFormat(paramString)).format(paramDate);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */