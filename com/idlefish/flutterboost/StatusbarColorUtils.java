package com.idlefish.flutterboost;

import android.app.Activity;
import android.view.View;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StatusbarColorUtils {
  private static Method a;
  
  private static Method b;
  
  private static Field c;
  
  private static int d;
  
  static {
    try {
      a = Activity.class.getMethod("setStatusBarDarkIcon", new Class[] { int.class });
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
    } 
    try {
      b = Activity.class.getMethod("setStatusBarDarkIcon", new Class[] { boolean.class });
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
    } 
    try {
      c = WindowManager.LayoutParams.class.getField("statusBarColor");
    } catch (NoSuchFieldException noSuchFieldException) {
      noSuchFieldException.printStackTrace();
    } 
    try {
      d = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
      return;
    } catch (NoSuchFieldException noSuchFieldException) {
      noSuchFieldException.printStackTrace();
      return;
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\StatusbarColorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */