package com.google.android.material.datepicker;

import android.os.Build;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class DateStrings {
  static Pair<String, String> a(Long paramLong1, Long paramLong2) {
    return a(paramLong1, paramLong2, null);
  }
  
  static Pair<String, String> a(Long paramLong1, Long paramLong2, SimpleDateFormat paramSimpleDateFormat) {
    Date date1;
    Date date2;
    if (paramLong1 == null && paramLong2 == null)
      return Pair.create(null, null); 
    if (paramLong1 == null)
      return Pair.create(null, a(paramLong2.longValue(), paramSimpleDateFormat)); 
    if (paramLong2 == null)
      return Pair.create(a(paramLong1.longValue(), paramSimpleDateFormat), null); 
    Calendar calendar1 = UtcDates.b();
    Calendar calendar2 = UtcDates.c();
    calendar2.setTimeInMillis(paramLong1.longValue());
    Calendar calendar3 = UtcDates.c();
    calendar3.setTimeInMillis(paramLong2.longValue());
    if (paramSimpleDateFormat != null) {
      date1 = new Date(paramLong1.longValue());
      date2 = new Date(paramLong2.longValue());
      return Pair.create(paramSimpleDateFormat.format(date1), paramSimpleDateFormat.format(date2));
    } 
    return (calendar2.get(1) == calendar3.get(1)) ? ((calendar2.get(1) == calendar1.get(1)) ? Pair.create(b(date1.longValue(), Locale.getDefault()), b(date2.longValue(), Locale.getDefault())) : Pair.create(b(date1.longValue(), Locale.getDefault()), a(date2.longValue(), Locale.getDefault()))) : Pair.create(a(date1.longValue(), Locale.getDefault()), a(date2.longValue(), Locale.getDefault()));
  }
  
  static String a(long paramLong) {
    return a(paramLong, Locale.getDefault());
  }
  
  static String a(long paramLong, SimpleDateFormat paramSimpleDateFormat) {
    Calendar calendar1 = UtcDates.b();
    Calendar calendar2 = UtcDates.c();
    calendar2.setTimeInMillis(paramLong);
    return (paramSimpleDateFormat != null) ? paramSimpleDateFormat.format(new Date(paramLong)) : ((calendar1.get(1) == calendar2.get(1)) ? b(paramLong) : a(paramLong));
  }
  
  static String a(long paramLong, Locale paramLocale) {
    return (Build.VERSION.SDK_INT >= 24) ? UtcDates.a(paramLocale).format(new Date(paramLong)) : UtcDates.e(paramLocale).format(new Date(paramLong));
  }
  
  static String b(long paramLong) {
    return b(paramLong, Locale.getDefault());
  }
  
  static String b(long paramLong, Locale paramLocale) {
    return (Build.VERSION.SDK_INT >= 24) ? UtcDates.b(paramLocale).format(new Date(paramLong)) : UtcDates.f(paramLocale).format(new Date(paramLong));
  }
  
  static String c(long paramLong) {
    return c(paramLong, Locale.getDefault());
  }
  
  static String c(long paramLong, Locale paramLocale) {
    return (Build.VERSION.SDK_INT >= 24) ? UtcDates.c(paramLocale).format(new Date(paramLong)) : UtcDates.g(paramLocale).format(new Date(paramLong));
  }
  
  static String d(long paramLong) {
    return d(paramLong, Locale.getDefault());
  }
  
  static String d(long paramLong, Locale paramLocale) {
    return (Build.VERSION.SDK_INT >= 24) ? UtcDates.d(paramLocale).format(new Date(paramLong)) : UtcDates.g(paramLocale).format(new Date(paramLong));
  }
  
  static String e(long paramLong) {
    return a(paramLong, (SimpleDateFormat)null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\DateStrings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */