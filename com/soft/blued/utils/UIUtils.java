package com.soft.blued.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class UIUtils {
  public static boolean a(Context paramContext) {
    boolean bool = false;
    try {
      TypedArray typedArray = paramContext.obtainStyledAttributes((int[])Class.forName("com.android.internal.R$styleable").getField("Window").get((Object)null));
      Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", new Class[] { TypedArray.class });
      method.setAccessible(true);
      boolean bool1 = ((Boolean)method.invoke((Object)null, new Object[] { typedArray })).booleanValue();
      try {
        method.setAccessible(false);
        return bool1;
      } catch (Exception null) {
        bool = bool1;
      } 
    } catch (Exception exception) {}
    exception.printStackTrace();
    return bool;
  }
  
  public static boolean a(Object paramObject) {
    try {
      Field field = Activity.class.getDeclaredField("mActivityInfo");
      field.setAccessible(true);
      ((ActivityInfo)field.get(paramObject)).screenOrientation = -1;
      field.setAccessible(false);
      return true;
    } catch (Exception exception) {
      exception.printStackTrace();
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\UIUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */