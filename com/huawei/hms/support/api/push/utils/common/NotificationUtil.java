package com.huawei.hms.support.api.push.utils.common;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.huawei.hms.aaid.utils.PushPreferences;
import java.lang.reflect.Method;

public class NotificationUtil {
  public static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
  
  public static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
  
  public static boolean areNotificationsEnabled(Context paramContext) {
    if ((new PushPreferences(paramContext, "push_notify_flag")).getBoolean("notify_msg_enable"))
      return false; 
    int i = Build.VERSION.SDK_INT;
    return (i >= 24) ? areNotificationsEnabledKitKat(paramContext) : ((i >= 19) ? areNotificationsEnabledKitKat(paramContext) : true);
  }
  
  public static boolean areNotificationsEnabledKitKat(Context paramContext) {
    AppOpsManager appOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
    ApplicationInfo applicationInfo = paramContext.getApplicationInfo();
    String str = paramContext.getApplicationContext().getPackageName();
    int i = applicationInfo.uid;
    try {
      Class<?> clazz = Class.forName(AppOpsManager.class.getName());
      Method method = clazz.getMethod("checkOpNoThrow", new Class[] { int.class, int.class, String.class });
      i = ((Integer)method.invoke(appOpsManager, new Object[] { Integer.valueOf(((Integer)clazz.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), str })).intValue();
      return (i == 0);
    } catch (ClassNotFoundException|NoSuchMethodException|NoSuchFieldException|java.lang.reflect.InvocationTargetException|IllegalAccessException|RuntimeException classNotFoundException) {
      return true;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\pus\\utils\common\NotificationUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */