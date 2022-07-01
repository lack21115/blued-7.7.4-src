package com.blued.android.core.utils.swipeback;

import android.app.Activity;
import android.os.Build;
import java.lang.reflect.Method;

public class SwipeBackUtils {
  public static void a(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 21) {
      c(paramActivity);
      return;
    } 
    b(paramActivity);
  }
  
  public static void b(Activity paramActivity) {
    try {
      int i;
      Class[] arrayOfClass = Activity.class.getDeclaredClasses();
      int j = arrayOfClass.length;
      Class clazz = null;
    } finally {
      paramActivity = null;
    } 
  }
  
  private static void c(Activity paramActivity) {
    try {
      int i;
      Method method = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
      method.setAccessible(true);
      Object object = method.invoke(paramActivity, new Object[0]);
      Class[] arrayOfClass = Activity.class.getDeclaredClasses();
      int j = arrayOfClass.length;
      method = null;
    } finally {
      paramActivity = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\swipeback\SwipeBackUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */