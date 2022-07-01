package com.cmic.sso.sdk.utils;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class v {
  public static String a() {
    Date date = new Date(System.currentTimeMillis());
    return (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(date);
  }
  
  public static String a(long paramLong) {
    Date date = new Date(paramLong);
    return (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(date);
  }
  
  private static String a(String paramString, Date paramDate) {
    return (paramDate == null || TextUtils.isEmpty(paramString)) ? null : (new SimpleDateFormat(paramString)).format(paramDate);
  }
  
  private static String a(Date paramDate) {
    return a("yyyyMMdd", paramDate);
  }
  
  public static String b() {
    return a(new Date());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */