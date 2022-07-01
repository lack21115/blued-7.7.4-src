package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.OpenConfig;
import java.lang.reflect.Method;

public class a {
  private static Class<?> a;
  
  private static Class<?> b;
  
  private static Method c;
  
  private static Method d;
  
  private static Method e;
  
  private static Method f;
  
  private static boolean g = false;
  
  public static void a(Context paramContext, QQToken paramQQToken, String paramString, String... paramVarArgs) {
    if (!g)
      return; 
    b(paramContext, paramQQToken);
    try {
      d.invoke(b, new Object[] { paramContext, paramString, paramVarArgs });
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static boolean a(Context paramContext, QQToken paramQQToken) {
    return OpenConfig.getInstance(paramContext, paramQQToken.getAppId()).getBoolean("Common_ta_enable");
  }
  
  public static void b(Context paramContext, QQToken paramQQToken) {
    try {
      if (a(paramContext, paramQQToken)) {
        f.invoke(a, new Object[] { Boolean.valueOf(true) });
        return;
      } 
      f.invoke(a, new Object[] { Boolean.valueOf(false) });
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void c(Context paramContext, QQToken paramQQToken) {
    String str = paramQQToken.getAppId();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Aqc");
    stringBuilder.append(str);
    str = stringBuilder.toString();
    try {
      a = Class.forName("com.tencent.stat.StatConfig");
      b = Class.forName("com.tencent.stat.StatService");
      c = b.getMethod("reportQQ", new Class[] { Context.class, String.class });
      d = b.getMethod("trackCustomEvent", new Class[] { Context.class, String.class, String[].class });
      e = b.getMethod("commitEvents", new Class[] { Context.class, int.class });
      f = a.getMethod("setEnableStatService", new Class[] { boolean.class });
      b(paramContext, paramQQToken);
      a.getMethod("setAutoExceptionCaught", new Class[] { boolean.class }).invoke(a, new Object[] { Boolean.valueOf(false) });
      a.getMethod("setEnableSmartReporting", new Class[] { boolean.class }).invoke(a, new Object[] { Boolean.valueOf(true) });
      a.getMethod("setSendPeriodMinutes", new Class[] { int.class }).invoke(a, new Object[] { Integer.valueOf(1440) });
      Class<?> clazz = Class.forName("com.tencent.stat.StatReportStrategy");
      a.getMethod("setStatSendStrategy", new Class[] { clazz }).invoke(a, new Object[] { clazz.getField("PERIOD").get(null) });
      b.getMethod("startStatService", new Class[] { Context.class, String.class, String.class }).invoke(b, new Object[] { paramContext, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null) });
      g = true;
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void d(Context paramContext, QQToken paramQQToken) {
    if (!g)
      return; 
    b(paramContext, paramQQToken);
    if (paramQQToken.getOpenId() != null)
      try {
        c.invoke(b, new Object[] { paramContext, paramQQToken.getOpenId() });
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */