package com.meizu.flyme.openidsdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

public class OpenIdHelper {
  public static String a(Context paramContext) {
    b b = b.a();
    return b.a(paramContext.getApplicationContext(), b.c);
  }
  
  public static final boolean a() {
    try {
      Class<?> clazz = Class.forName("android.app.ActivityThread");
      Method method = clazz.getMethod("currentApplication", new Class[0]);
      method.setAccessible(true);
      Context context = (Context)method.invoke((Object)null, new Object[0]);
      if (context == null)
        return false; 
    } catch (Exception exception) {
      Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + exception.toString());
      exception = null;
      if (exception == null)
        return false; 
    } 
    return b.a().a((Context)exception, false);
  }
  
  public static String b(Context paramContext) {
    b b = b.a();
    return b.a(paramContext.getApplicationContext(), b.b);
  }
  
  public static String c(Context paramContext) {
    b b = b.a();
    return b.a(paramContext.getApplicationContext(), b.a);
  }
  
  public static String d(Context paramContext) {
    b b = b.a();
    return b.a(paramContext.getApplicationContext(), b.d);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\meizu\flyme\openidsdk\OpenIdHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */