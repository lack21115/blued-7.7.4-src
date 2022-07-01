package com.soft.blued.utils;

import android.content.Context;
import com.blued.android.core.BlueAppLocal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class TimeAndDateUtils {
  public static final ThreadLocal<SimpleDateFormat> a = new ThreadLocal<SimpleDateFormat>() {
      protected SimpleDateFormat a() {
        return new SimpleDateFormat("yyyy-MM-dd", BlueAppLocal.c());
      }
    };
  
  public static final ThreadLocal<SimpleDateFormat> b = new ThreadLocal<SimpleDateFormat>() {
      protected SimpleDateFormat a() {
        return new SimpleDateFormat("yyyy", BlueAppLocal.c());
      }
    };
  
  public static final ThreadLocal<SimpleDateFormat> c = new ThreadLocal<SimpleDateFormat>() {
      protected SimpleDateFormat a() {
        return new SimpleDateFormat("HH:mm:ss", BlueAppLocal.c());
      }
    };
  
  public static final ThreadLocal<SimpleDateFormat> d = new ThreadLocal<SimpleDateFormat>() {
      protected SimpleDateFormat a() {
        return new SimpleDateFormat("MM-dd HH:mm", BlueAppLocal.c());
      }
    };
  
  public static final ThreadLocal<SimpleDateFormat> e = new ThreadLocal<SimpleDateFormat>() {
      protected SimpleDateFormat a() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm", BlueAppLocal.c());
      }
    };
  
  public static final ThreadLocal<SimpleDateFormat> f = new ThreadLocal<SimpleDateFormat>() {
      protected SimpleDateFormat a() {
        return new SimpleDateFormat("HH:mm", BlueAppLocal.c());
      }
    };
  
  public static final ThreadLocal<SimpleDateFormat> g = new ThreadLocal<SimpleDateFormat>() {
      protected SimpleDateFormat a() {
        return new SimpleDateFormat("MM-dd", BlueAppLocal.c());
      }
    };
  
  public static final ThreadLocal<SimpleDateFormat> h = new ThreadLocal<SimpleDateFormat>() {
      protected SimpleDateFormat a() {
        return new SimpleDateFormat("MM-dd HH:mm", BlueAppLocal.c());
      }
    };
  
  public static int a(long paramLong1, long paramLong2) {
    Calendar calendar1 = Calendar.getInstance();
    Calendar calendar2 = Calendar.getInstance();
    calendar1.setTimeInMillis(paramLong1);
    calendar2.setTimeInMillis(paramLong2);
    int k = calendar1.get(6);
    int j = calendar2.get(6);
    int m = calendar1.get(1);
    int i = calendar2.get(1);
    if (m > i) {
      int i1 = j;
      j = k;
      k = i1;
    } else {
      int i1 = m;
      m = i;
      i = i1;
    } 
    if (i == m)
      return Math.abs(j - k); 
    boolean bool = false;
    int n = i;
    i = bool;
    while (n < m) {
      if ((n % 4 == 0 && n % 100 != 0) || n % 400 == 0) {
        i += 366;
      } else {
        i += 365;
      } 
      n++;
    } 
    return i + j - k;
  }
  
  public static int a(Date paramDate) {
    int i;
    if (paramDate == null)
      return 0; 
    try {
      Calendar calendar = Calendar.getInstance();
      if (!calendar.before(paramDate)) {
        int j = calendar.get(1);
        int k = calendar.get(2) + 1;
        int m = calendar.get(5);
        calendar.setTime(paramDate);
        i = calendar.get(1);
        int n = calendar.get(2) + 1;
        int i1 = calendar.get(5);
        i = j - i;
        j = i;
        if (k <= n) {
          if (k == n) {
            j = i;
            return (m < i1) ? (i - 1) : j;
          } 
        } else {
          return j;
        } 
      } else {
        throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0;
    } 
    return i - 1;
  }
  
  public static String a() {
    Date date = new Date();
    GregorianCalendar gregorianCalendar = new GregorianCalendar();
    gregorianCalendar.setTime(date);
    date = gregorianCalendar.getTime();
    return (new SimpleDateFormat("yyyy.MM.dd", BlueAppLocal.c())).format(date);
  }
  
  public static String a(long paramLong) {
    StringBuffer stringBuffer = new StringBuffer();
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    calendar.setTimeInMillis(paramLong);
    if (BlueAppLocal.d()) {
      stringBuffer.append((new SimpleDateFormat("yyyy-MM-dd HH:mm", BlueAppLocal.c())).format(calendar.getTime()));
    } else {
      stringBuffer.append((new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.ENGLISH)).format(calendar.getTime()));
    } 
    return stringBuffer.toString();
  }
  
  public static String a(long paramLong, boolean paramBoolean) {
    StringBuilder stringBuilder;
    long l = paramLong / 3600L;
    if (l > 9L) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(l);
      stringBuilder.append("");
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append("0");
      stringBuilder.append(l);
    } 
    String str1 = stringBuilder.toString();
    paramLong %= 3600L;
    l = paramLong / 60L;
    if (l > 9L) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(l);
      stringBuilder.append("");
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append("0");
      stringBuilder.append(l);
    } 
    String str2 = stringBuilder.toString();
    paramLong %= 60L;
    if (paramLong > 9L) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramLong);
      stringBuilder.append("");
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append("0");
      stringBuilder.append(paramLong);
    } 
    String str3 = stringBuilder.toString();
    if (paramBoolean) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(":");
    } else {
      stringBuilder = new StringBuilder();
    } 
    stringBuilder.append(str2);
    stringBuilder.append(":");
    stringBuilder.append(str3);
    return stringBuilder.toString();
  }
  
  public static String a(Context paramContext, long paramLong) {
    StringBuffer stringBuffer = new StringBuffer();
    long l2 = System.currentTimeMillis();
    long l3 = l2 - paramLong;
    long l1 = l3 / 86400000L;
    long l4 = l3 / 3600000L - 24L * l1;
    if (l3 <= 60000L) {
      stringBuffer.append(paramContext.getResources().getString(2131758289));
    } else {
      String str;
      if (l3 < 3600000L) {
        if (l3 < 120000L) {
          str = paramContext.getResources().getString(2131755426);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l3 / 60L / 1000L);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } else {
          str = str.getResources().getString(2131755424);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l3 / 60L / 1000L);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } 
      } else if (l3 < 86400000L) {
        if (l3 < 7200000L) {
          str = str.getResources().getString(2131755422);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l4);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } else {
          str = str.getResources().getString(2131755420);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l4);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } 
      } else {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(l2);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        l2 = calendar.getTimeInMillis();
        calendar.set(6, 1);
        calendar.setTimeInMillis(paramLong);
        if (paramLong > l2 - 86400000L) {
          stringBuffer.append(str.getResources().getString(2131759368));
        } else {
          StringBuilder stringBuilder;
          if (l1 < 8L) {
            str = str.getResources().getString(2131755416);
            stringBuilder = new StringBuilder();
            stringBuilder.append(l1);
            stringBuilder.append("");
            stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
          } else if (BlueAppLocal.d()) {
            if (f(paramLong)) {
              stringBuffer.append((new SimpleDateFormat("MM-dd HH:mm", BlueAppLocal.c())).format(stringBuilder.getTime()));
            } else {
              stringBuffer.append((new SimpleDateFormat("yyyy-MM-dd HH:mm", BlueAppLocal.c())).format(stringBuilder.getTime()));
            } 
          } else if (f(paramLong)) {
            stringBuffer.append((new SimpleDateFormat("MMM dd HH:mm", Locale.ENGLISH)).format(stringBuilder.getTime()));
          } else {
            stringBuffer.append((new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.ENGLISH)).format(stringBuilder.getTime()));
          } 
        } 
      } 
    } 
    return stringBuffer.toString();
  }
  
  public static String a(String paramString) {
    if (StringUtils.e(paramString))
      return ""; 
    try {
      SimpleDateFormat simpleDateFormat;
      if (BlueAppLocal.d()) {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", BlueAppLocal.c());
      } else {
        simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
      } 
      return simpleDateFormat.format(Long.valueOf(Long.parseLong(paramString) * 1000L));
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static String a(String paramString1, String paramString2) {
    if (paramString1 == null || paramString1.isEmpty() || paramString1.equals("null"))
      return ""; 
    if (paramString2 != null) {
      String str1 = paramString2;
      if (paramString2.isEmpty()) {
        str1 = "yyyy-MM-dd HH:mm";
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str1);
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString1);
        stringBuilder1.append("000");
        return simpleDateFormat2.format(new Date(Long.parseLong(stringBuilder1.toString())));
      } 
      SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat((String)stringBuilder1);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString1);
      stringBuilder1.append("000");
      return simpleDateFormat1.format(new Date(Long.parseLong(stringBuilder1.toString())));
    } 
    String str = "yyyy-MM-dd HH:mm";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append("000");
    return simpleDateFormat.format(new Date(Long.parseLong(stringBuilder.toString())));
  }
  
  public static long b(String paramString) {
    if (StringUtils.e(paramString))
      return 0L; 
    try {
      long l = Long.parseLong(paramString);
      return l * 1000L;
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0L;
    } 
  }
  
  public static String b(long paramLong) {
    StringBuffer stringBuffer = new StringBuffer();
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    calendar.setTimeInMillis(paramLong);
    if (BlueAppLocal.d()) {
      stringBuffer.append((new SimpleDateFormat("yyyy-MM-dd", BlueAppLocal.c())).format(calendar.getTime()));
    } else {
      stringBuffer.append((new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)).format(calendar.getTime()));
    } 
    return stringBuffer.toString();
  }
  
  public static String b(Context paramContext, long paramLong) {
    StringBuffer stringBuffer = new StringBuffer();
    paramLong = System.currentTimeMillis() - paramLong;
    long l = paramLong / 86400000L;
    l = paramLong / 3600000L - l * 24L;
    if (paramLong <= 60000L) {
      stringBuffer.append(paramContext.getResources().getString(2131758289));
    } else {
      String str;
      if (paramLong < 3600000L) {
        if (paramLong < 120000L) {
          str = paramContext.getResources().getString(2131755426);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramLong / 60L / 1000L);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } else {
          str = str.getResources().getString(2131755424);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramLong / 60L / 1000L);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } 
      } else if (paramLong < 86400000L) {
        if (paramLong < 7200000L) {
          str = str.getResources().getString(2131755422);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } else {
          str = str.getResources().getString(2131755420);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } 
      } else {
        stringBuffer.append("");
      } 
    } 
    return stringBuffer.toString();
  }
  
  public static String b(String paramString1, String paramString2) {
    try {
      long l = (new SimpleDateFormat(paramString2)).parse(paramString1).getTime() / 1000L;
      return String.valueOf(l);
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public static String c(long paramLong) {
    StringBuffer stringBuffer = new StringBuffer();
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    calendar.setTimeInMillis(paramLong);
    if (BlueAppLocal.d()) {
      stringBuffer.append((new SimpleDateFormat("yyyy年MM月dd日", BlueAppLocal.c())).format(calendar.getTime()));
    } else {
      stringBuffer.append((new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)).format(calendar.getTime()));
    } 
    return stringBuffer.toString();
  }
  
  public static String c(Context paramContext, long paramLong) {
    StringBuffer stringBuffer = new StringBuffer();
    String str = b(paramContext, paramLong);
    if (!StringUtils.e(str)) {
      stringBuffer.append(str);
    } else {
      Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
      calendar.set(11, 0);
      calendar.set(12, 0);
      calendar.set(13, 0);
      calendar.set(6, 1);
      calendar.setTimeInMillis(paramLong);
      if (BlueAppLocal.d()) {
        if (f(paramLong)) {
          stringBuffer.append((new SimpleDateFormat("MM-dd", BlueAppLocal.c())).format(calendar.getTime()));
        } else {
          stringBuffer.append((new SimpleDateFormat("yyyy-MM-dd", BlueAppLocal.c())).format(calendar.getTime()));
        } 
      } else if (f(paramLong)) {
        stringBuffer.append((new SimpleDateFormat("MMM dd", Locale.ENGLISH)).format(calendar.getTime()));
      } else {
        stringBuffer.append((new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)).format(calendar.getTime()));
      } 
    } 
    return stringBuffer.toString();
  }
  
  public static String c(String paramString) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月");
    try {
      long l = simpleDateFormat.parse(paramString).getTime();
      return String.valueOf(l);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static Date c(String paramString1, String paramString2) {
    try {
      return (new SimpleDateFormat(paramString2)).parse(paramString1);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static String d(long paramLong) {
    StringBuffer stringBuffer = new StringBuffer();
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    calendar.setTimeInMillis(paramLong);
    if (BlueAppLocal.d()) {
      if (f(paramLong)) {
        stringBuffer.append((new SimpleDateFormat("MM-dd", BlueAppLocal.c())).format(calendar.getTime()));
      } else {
        stringBuffer.append((new SimpleDateFormat("yyyy-MM-dd", BlueAppLocal.c())).format(calendar.getTime()));
      } 
    } else if (f(paramLong)) {
      stringBuffer.append((new SimpleDateFormat("MMM dd", Locale.ENGLISH)).format(calendar.getTime()));
    } else {
      stringBuffer.append((new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)).format(calendar.getTime()));
    } 
    return stringBuffer.toString();
  }
  
  public static String d(Context paramContext, long paramLong) {
    StringBuffer stringBuffer = new StringBuffer();
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    calendar.set(11, 0);
    calendar.set(12, 0);
    calendar.set(13, 0);
    calendar.set(6, 1);
    calendar.setTimeInMillis(paramLong);
    if (BlueAppLocal.d()) {
      stringBuffer.append((new SimpleDateFormat("MM-dd HH:mm", BlueAppLocal.c())).format(calendar.getTime()));
    } else {
      stringBuffer.append((new SimpleDateFormat("MMM dd HH:mm", Locale.ENGLISH)).format(calendar.getTime()));
    } 
    return stringBuffer.toString();
  }
  
  public static String d(String paramString) {
    SimpleDateFormat simpleDateFormat;
    if (BlueAppLocal.d()) {
      simpleDateFormat = new SimpleDateFormat("yyyy年MM月", BlueAppLocal.c());
    } else {
      simpleDateFormat = new SimpleDateFormat("MMM. yyyy", Locale.ENGLISH);
    } 
    return simpleDateFormat.format(new Date(Long.valueOf(paramString).longValue()));
  }
  
  public static String e(Context paramContext, long paramLong) {
    StringBuffer stringBuffer = new StringBuffer();
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    calendar.set(11, 0);
    calendar.set(12, 0);
    calendar.set(13, 0);
    calendar.set(6, 1);
    calendar.setTimeInMillis(paramLong);
    if (BlueAppLocal.d()) {
      if (f(paramLong)) {
        stringBuffer.append((new SimpleDateFormat("MM-dd HH:mm", BlueAppLocal.c())).format(calendar.getTime()));
      } else {
        stringBuffer.append((new SimpleDateFormat("yyyy-MM-dd HH:mm", BlueAppLocal.c())).format(calendar.getTime()));
      } 
    } else if (f(paramLong)) {
      stringBuffer.append((new SimpleDateFormat("MMM dd HH:mm", Locale.ENGLISH)).format(calendar.getTime()));
    } else {
      stringBuffer.append((new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.ENGLISH)).format(calendar.getTime()));
    } 
    return stringBuffer.toString();
  }
  
  public static boolean e(long paramLong) {
    Date date1 = new Date(paramLong);
    Date date2 = new Date();
    return ((SimpleDateFormat)a.get()).format(date2).equals(((SimpleDateFormat)a.get()).format(date1));
  }
  
  public static String f(Context paramContext, long paramLong) {
    StringBuffer stringBuffer = new StringBuffer();
    paramLong = Math.abs(System.currentTimeMillis() - paramLong);
    long l1 = paramLong / 86400000L;
    long l2 = paramLong / 3600000L;
    long l4 = 24L * l1;
    l2 -= l4;
    long l3 = paramLong / 60000L;
    l4 *= 60L;
    long l5 = l2 * 60L;
    l3 = paramLong / 1000L - l4 * 60L - l5 * 60L - (l3 - l4 - l5) * 60L;
    if (paramContext != null) {
      String str;
      if (paramLong < 60000L) {
        if (paramLong < 2000L) {
          str = paramContext.getResources().getString(2131755432);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l3);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } else {
          str = str.getResources().getString(2131755430);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l3);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } 
      } else if (paramLong < 3600000L) {
        if (paramLong < 120000L) {
          str = str.getResources().getString(2131755426);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramLong / 60L / 1000L);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } else {
          str = str.getResources().getString(2131755424);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramLong / 60L / 1000L);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } 
      } else if (paramLong < 86400000L) {
        if (paramLong < 7200000L) {
          str = str.getResources().getString(2131755422);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l2);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } else {
          str = str.getResources().getString(2131755420);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l2);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } 
      } else if (l1 == 1L) {
        str = str.getResources().getString(2131755418);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l1);
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } else if (l1 <= 30L) {
        str = str.getResources().getString(2131755416);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l1);
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } else {
        stringBuffer.append(String.format(str.getResources().getString(2131755416), new Object[] { "30" }));
      } 
      return stringBuffer.toString();
    } 
    return "";
  }
  
  public static boolean f(long paramLong) {
    Date date1 = new Date(paramLong);
    Date date2 = new Date();
    return ((SimpleDateFormat)b.get()).format(date2).equals(((SimpleDateFormat)b.get()).format(date1));
  }
  
  public static String g(Context paramContext, long paramLong) {
    String str;
    StringBuffer stringBuffer = new StringBuffer();
    long l2 = System.currentTimeMillis() - paramLong;
    long l1 = l2 / 86400000L;
    paramLong = l2 / 3600000L;
    long l4 = 24L * l1;
    long l3 = paramLong - l4;
    paramLong = l2 / 60000L;
    l4 *= 60L;
    long l5 = l3 * 60L;
    paramLong = l2 / 1000L - l4 * 60L - l5 * 60L - (paramLong - l4 - l5) * 60L;
    if (l2 < 60000L) {
      l1 = 0L;
      if (paramLong < 0L)
        paramLong = l1; 
      if (l2 < 2000L) {
        str = paramContext.getResources().getString(2131755432);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramLong);
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } else {
        str = str.getResources().getString(2131755430);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramLong);
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } 
    } else if (l2 < 3600000L) {
      if (l2 < 120000L) {
        str = str.getResources().getString(2131755426);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l2 / 60L / 1000L);
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } else {
        str = str.getResources().getString(2131755424);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l2 / 60L / 1000L);
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } 
    } else if (l2 < 86400000L) {
      if (l2 < 7200000L) {
        str = str.getResources().getString(2131755422);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l3);
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } else {
        str = str.getResources().getString(2131755420);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l3);
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } 
    } else if (l1 == 1L) {
      str = str.getResources().getString(2131755418);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l1);
      stringBuilder.append("");
      stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
    } else if (l1 >= 30L) {
      int i = (int)Math.floor(((float)l1 / 30.0F));
      if (i == 1) {
        str = str.getResources().getString(2131755429);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } else if (i < 12) {
        str = str.getResources().getString(2131755428);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } else if (i == 12) {
        str = str.getResources().getString(2131755434);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Math.ceil(i / 12.0D));
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } else {
        str = str.getResources().getString(2131755435);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Math.ceil(i / 12.0D));
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } 
    } else {
      str = str.getResources().getString(2131755416);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l1);
      stringBuilder.append("");
      stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
    } 
    return stringBuffer.toString();
  }
  
  public static boolean g(long paramLong) {
    Date date1 = new Date(paramLong);
    Date date2 = new Date();
    GregorianCalendar gregorianCalendar = new GregorianCalendar();
    gregorianCalendar.setTime(date2);
    gregorianCalendar.add(5, -1);
    date2 = gregorianCalendar.getTime();
    return ((SimpleDateFormat)a.get()).format(date1).equals(((SimpleDateFormat)a.get()).format(date2));
  }
  
  public static String h(Context paramContext, long paramLong) {
    String str;
    StringBuffer stringBuffer = new StringBuffer();
    long l2 = System.currentTimeMillis() - paramLong;
    long l1 = l2 / 86400000L;
    paramLong = l2 / 3600000L;
    l1 *= 24L;
    long l3 = paramLong - l1;
    long l5 = l2 / 60000L;
    paramLong = l1 * 60L;
    long l4 = l3 * 60L;
    l5 = l5 - paramLong - l4;
    paramLong = l2 / 1000L - paramLong * 60L - l4 * 60L - l5 * 60L;
    if (l2 < 60000L) {
      l1 = 0L;
      if (paramLong < 0L)
        paramLong = l1; 
      if (l2 < 2000L) {
        str = paramContext.getResources().getString(2131758669);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramLong);
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } else {
        str = str.getResources().getString(2131758670);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramLong);
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } 
    } else if (l2 < 3600000L) {
      if (l2 < 120000L) {
        str = str.getResources().getString(2131757904);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l2 / 60L / 1000L);
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } else {
        str = str.getResources().getString(2131757905);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l2 / 60L / 1000L);
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } 
    } else {
      String str1;
      if (l5 < 2L) {
        str1 = str.getResources().getString(2131757904);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(l5);
        stringBuilder1.append("");
        str1 = String.format(str1, new Object[] { stringBuilder1.toString() });
      } else {
        str1 = str.getResources().getString(2131757905);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(l5);
        stringBuilder1.append("");
        str1 = String.format(str1, new Object[] { stringBuilder1.toString() });
      } 
      paramLong = l1 + l3;
      if (paramLong < 2L) {
        str = str.getResources().getString(2131757032);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(l3);
        stringBuilder1.append("");
        str = String.format(str, new Object[] { stringBuilder1.toString() });
      } else {
        str = str.getResources().getString(2131757033);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramLong);
        stringBuilder1.append("");
        str = String.format(str, new Object[] { stringBuilder1.toString() });
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(str1);
      stringBuffer.append(stringBuilder.toString());
    } 
    return stringBuffer.toString();
  }
  
  public static String i(Context paramContext, long paramLong) {
    StringBuffer stringBuffer = new StringBuffer();
    long l1 = Math.abs(System.currentTimeMillis() - paramLong);
    long l2 = l1 / 86400000L;
    long l3 = l1 / 3600000L - 24L * l2;
    long l4 = l1 / 60000L;
    l4 = l1 / 1000L;
    if (paramContext != null) {
      String str;
      if (l1 < 3600000L) {
        if (l1 < 60000L) {
          stringBuffer.append(paramContext.getResources().getString(2131758289));
        } else if (l1 < 120000L) {
          str = paramContext.getResources().getString(2131755426);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l1 / 60L / 1000L + 1L);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } else {
          str = str.getResources().getString(2131755424);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l1 / 60L / 1000L);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } 
      } else if (l1 < 86400000L) {
        if (l1 < 7200000L) {
          str = str.getResources().getString(2131755422);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l3);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } else {
          str = str.getResources().getString(2131755420);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l3);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
        } 
      } else if (l2 == 1L) {
        str = str.getResources().getString(2131755418);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l2);
        stringBuilder.append("");
        stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
      } else {
        if (l2 <= 7L) {
          str = str.getResources().getString(2131755416);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l2);
          stringBuilder.append("");
          stringBuffer.append(String.format(str, new Object[] { stringBuilder.toString() }));
          return stringBuffer.toString();
        } 
        return d(paramLong);
      } 
      return stringBuffer.toString();
    } 
    return "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\TimeAndDateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */