package com.blued.android.module.live.base.utils;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.module.live.base.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class LiveTimeAndDateUtils {
  public static long a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return 0L; 
    try {
      long l = Long.parseLong(paramString);
      return l * 1000L;
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0L;
    } 
  }
  
  public static String a(long paramLong) {
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
    if (paramLong > 1827590400000L)
      return paramContext.getString(R.string.never_expires); 
    StringBuffer stringBuffer = new StringBuffer();
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    calendar.setTimeInMillis(paramLong);
    stringBuffer.append(paramContext.getString(R.string.valid_to));
    if (BlueAppLocal.d()) {
      stringBuffer.append((new SimpleDateFormat("yyyy/MM/dd", BlueAppLocal.c())).format(calendar.getTime()));
    } else {
      stringBuffer.append((new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)).format(calendar.getTime()));
    } 
    return stringBuffer.toString();
  }
  
  public static String b(long paramLong) {
    StringBuffer stringBuffer = new StringBuffer();
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    calendar.setTimeInMillis(paramLong);
    if (BlueAppLocal.d()) {
      stringBuffer.append((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", BlueAppLocal.c())).format(calendar.getTime()));
    } else {
      stringBuffer.append((new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)).format(calendar.getTime()));
    } 
    return stringBuffer.toString();
  }
  
  public static String b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    try {
      return (new SimpleDateFormat("HH:mm:ss", BlueAppLocal.c())).format(Long.valueOf(Long.parseLong(paramString) * 1000L));
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\bas\\utils\LiveTimeAndDateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */