package org.chromium.base;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.os.Process;

public final class ContextUtils {
  public static Context sApplicationContext;
  
  private static String sProcessName;
  
  public static AssetManager getApplicationAssets() {
    Context context;
    for (context = sApplicationContext; context instanceof ContextWrapper; context = ((ContextWrapper)context).getBaseContext());
    return context.getAssets();
  }
  
  public static String getProcessName() {
    if (sProcessName != null)
      return sProcessName; 
    try {
      Class<?> clazz = Class.forName("android.app.ActivityThread");
      Object object = clazz.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
      String str = (String)clazz.getMethod("getProcessName", new Class[0]).invoke(object, new Object[0]);
      sProcessName = str;
      return str;
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public static void initApplicationContext(Context paramContext) {
    if (sApplicationContext == null || sApplicationContext == paramContext) {
      if (paramContext != null) {
        sApplicationContext = paramContext;
        return;
      } 
      throw new RuntimeException("Global application context cannot be set to null.");
    } 
    throw new RuntimeException("Attempting to set multiple global application contexts.");
  }
  
  public static boolean isIsolatedProcess() {
    try {
      return ((Boolean)Process.class.getMethod("isIsolated", new Class[0]).invoke(null, new Object[0])).booleanValue();
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\ContextUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */