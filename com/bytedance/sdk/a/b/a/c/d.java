package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.a.c;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class d {
  private static final ThreadLocal<DateFormat> a = new ThreadLocal<DateFormat>() {
      protected DateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(c.g);
        return simpleDateFormat;
      }
    };
  
  private static final String[] b = new String[] { 
      "EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", 
      "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z" };
  
  private static final DateFormat[] c = new DateFormat[b.length];
  
  public static String a(Date paramDate) {
    return ((DateFormat)a.get()).format(paramDate);
  }
  
  public static Date a(String paramString) {
    if (paramString.length() == 0)
      return null; 
    ParsePosition parsePosition = new ParsePosition(0);
    Date date = ((DateFormat)a.get()).parse(paramString, parsePosition);
    if (parsePosition.getIndex() == paramString.length())
      return date; 
    synchronized (b) {
      int j = b.length;
      for (int i = 0;; i++) {
        if (i < j) {
          DateFormat dateFormat2 = c[i];
          DateFormat dateFormat1 = dateFormat2;
          if (dateFormat2 == null) {
            dateFormat1 = new SimpleDateFormat(b[i], Locale.US);
            dateFormat1.setTimeZone(c.g);
            c[i] = dateFormat1;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */