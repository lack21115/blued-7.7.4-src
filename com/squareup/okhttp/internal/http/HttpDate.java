package com.squareup.okhttp.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class HttpDate {
  private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS;
  
  private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
  
  private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
  
  private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT = new ThreadLocal<DateFormat>() {
      protected DateFormat initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(HttpDate.GMT);
        return simpleDateFormat;
      }
    };
  
  static {
    BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = new String[] { 
        "EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", 
        "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z" };
    BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length];
  }
  
  public static String format(Date paramDate) {
    return ((DateFormat)STANDARD_DATE_FORMAT.get()).format(paramDate);
  }
  
  public static Date parse(String paramString) {
    if (paramString.length() == 0)
      return null; 
    ParsePosition parsePosition = new ParsePosition(0);
    Date date = ((DateFormat)STANDARD_DATE_FORMAT.get()).parse(paramString, parsePosition);
    if (parsePosition.getIndex() == paramString.length())
      return date; 
    synchronized (BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS) {
      int j = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length;
      for (int i = 0;; i++) {
        if (i < j) {
          DateFormat dateFormat2 = BROWSER_COMPATIBLE_DATE_FORMATS[i];
          DateFormat dateFormat1 = dateFormat2;
          if (dateFormat2 == null) {
            dateFormat1 = new SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[i], Locale.US);
            dateFormat1.setTimeZone(GMT);
            BROWSER_COMPATIBLE_DATE_FORMATS[i] = dateFormat1;
          } 
          parsePosition.setIndex(0);
          Date date1 = dateFormat1.parse(paramString, parsePosition);
          if (parsePosition.getIndex() != 0)
            return date1; 
        } else {
          return null;
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\http\HttpDate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */