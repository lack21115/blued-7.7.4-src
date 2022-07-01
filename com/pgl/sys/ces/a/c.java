package com.pgl.sys.ces.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.pgl.a.b.d;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;

public class c {
  public static String a() {
    Exception exception;
    try {
      String str = TimeZone.getDefault().getDisplayName(false, 0);
    } finally {
      exception = null;
    } 
  }
  
  public static String a(Context paramContext) {
    String str;
    try {
      str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    } finally {
      paramContext = null;
    } 
  }
  
  public static String b(Context paramContext) {
    try {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
    } finally {
      paramContext = null;
    } 
  }
  
  public static String c(Context paramContext) {
    try {
      Locale locale = (paramContext.getResources().getConfiguration()).locale;
      String str1 = locale.getLanguage();
      String str2 = locale.getCountry();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append("_");
      stringBuilder.append(str2);
      str1 = stringBuilder.toString();
    } finally {
      paramContext = null;
    } 
  }
  
  public static String d(Context paramContext) {
    StringBuilder stringBuilder;
    double d;
    try {
      Class<?> clazz = Class.forName("com.android.internal.os.PowerProfile");
      paramContext = clazz.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
      Method method = clazz.getDeclaredMethod("getAveragePower", new Class[] { String.class });
      method.setAccessible(true);
      d = ((Double)method.invoke(paramContext, new Object[] { "battery.capacity" })).doubleValue();
    } finally {
      paramContext = null;
    } 
    stringBuilder.append("capacity : ");
    stringBuilder.append(d);
    d.b(stringBuilder.toString());
    return Integer.toString((int)d);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\ces\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */