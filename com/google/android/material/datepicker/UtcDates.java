package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import com.google.android.material.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

class UtcDates {
  static AtomicReference<TimeSource> a = new AtomicReference<TimeSource>();
  
  private static int a(String paramString1, String paramString2, int paramInt1, int paramInt2) {
    while (paramInt2 >= 0 && paramInt2 < paramString1.length() && paramString2.indexOf(paramString1.charAt(paramInt2)) == -1) {
      int i = paramInt2;
      if (paramString1.charAt(paramInt2) == '\'')
        while (true) {
          paramInt2 += paramInt1;
          i = paramInt2;
          if (paramInt2 >= 0) {
            i = paramInt2;
            if (paramInt2 < paramString1.length()) {
              i = paramInt2;
              if (paramString1.charAt(paramInt2) != '\'')
                continue; 
            } 
          } 
          break;
        }  
      paramInt2 = i + paramInt1;
    } 
    return paramInt2;
  }
  
  static long a(long paramLong) {
    Calendar calendar = c();
    calendar.setTimeInMillis(paramLong);
    return b(calendar).getTimeInMillis();
  }
  
  private static DateFormat a(String paramString, Locale paramLocale) {
    DateFormat dateFormat = DateFormat.getInstanceForSkeleton(paramString, paramLocale);
    dateFormat.setTimeZone(g());
    return dateFormat;
  }
  
  static DateFormat a(Locale paramLocale) {
    return a("yMMMd", paramLocale);
  }
  
  static TimeSource a() {
    TimeSource timeSource2 = a.get();
    TimeSource timeSource1 = timeSource2;
    if (timeSource2 == null)
      timeSource1 = TimeSource.a(); 
    return timeSource1;
  }
  
  static String a(Resources paramResources, SimpleDateFormat paramSimpleDateFormat) {
    String str1 = paramSimpleDateFormat.toLocalizedPattern();
    String str2 = paramResources.getString(R.string.mtrl_picker_text_input_year_abbr);
    String str3 = paramResources.getString(R.string.mtrl_picker_text_input_month_abbr);
    return str1.replaceAll("d", paramResources.getString(R.string.mtrl_picker_text_input_day_abbr)).replaceAll("M", str3).replaceAll("y", str2);
  }
  
  private static String a(String paramString) {
    int i = a(paramString, "yY", 1, 0);
    if (i >= paramString.length())
      return paramString; 
    String str = "EMd";
    int j = a(paramString, "EMd", 1, i);
    if (j < paramString.length()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("EMd");
      stringBuilder.append(",");
      str = stringBuilder.toString();
    } 
    return paramString.replace(paramString.substring(a(paramString, str, -1, i) + 1, j), " ").trim();
  }
  
  private static DateFormat a(int paramInt, Locale paramLocale) {
    DateFormat dateFormat = DateFormat.getDateInstance(paramInt, paramLocale);
    dateFormat.setTimeZone(f());
    return dateFormat;
  }
  
  static Calendar a(Calendar paramCalendar) {
    Calendar calendar = Calendar.getInstance(f());
    if (paramCalendar == null) {
      calendar.clear();
      return calendar;
    } 
    calendar.setTimeInMillis(paramCalendar.getTimeInMillis());
    return calendar;
  }
  
  static DateFormat b(Locale paramLocale) {
    return a("MMMd", paramLocale);
  }
  
  private static SimpleDateFormat b(String paramString, Locale paramLocale) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(paramString, paramLocale);
    simpleDateFormat.setTimeZone(f());
    return simpleDateFormat;
  }
  
  static Calendar b() {
    Calendar calendar = a().b();
    calendar.set(11, 0);
    calendar.set(12, 0);
    calendar.set(13, 0);
    calendar.set(14, 0);
    calendar.setTimeZone(f());
    return calendar;
  }
  
  static Calendar b(Calendar paramCalendar) {
    paramCalendar = a(paramCalendar);
    Calendar calendar = c();
    calendar.set(paramCalendar.get(1), paramCalendar.get(2), paramCalendar.get(5));
    return calendar;
  }
  
  static DateFormat c(Locale paramLocale) {
    return a("MMMEd", paramLocale);
  }
  
  static Calendar c() {
    return a((Calendar)null);
  }
  
  static DateFormat d(Locale paramLocale) {
    return a("yMMMEd", paramLocale);
  }
  
  static SimpleDateFormat d() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat)DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
    simpleDateFormat.setTimeZone(f());
    simpleDateFormat.setLenient(false);
    return simpleDateFormat;
  }
  
  static DateFormat e(Locale paramLocale) {
    return a(2, paramLocale);
  }
  
  static SimpleDateFormat e() {
    return h(Locale.getDefault());
  }
  
  static DateFormat f(Locale paramLocale) {
    SimpleDateFormat simpleDateFormat = (SimpleDateFormat)e(paramLocale);
    simpleDateFormat.applyPattern(a(simpleDateFormat.toPattern()));
    return simpleDateFormat;
  }
  
  private static TimeZone f() {
    return TimeZone.getTimeZone("UTC");
  }
  
  private static TimeZone g() {
    return TimeZone.getTimeZone("UTC");
  }
  
  static DateFormat g(Locale paramLocale) {
    return a(0, paramLocale);
  }
  
  private static SimpleDateFormat h(Locale paramLocale) {
    return b("LLLL, yyyy", paramLocale);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\UtcDates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */