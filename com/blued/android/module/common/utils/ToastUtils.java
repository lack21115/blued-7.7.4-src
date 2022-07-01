package com.blued.android.module.common.utils;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;

public class ToastUtils {
  public static void a(int paramInt) {
    try {
      AppMethods.a(AppInfo.d().getResources().getString(paramInt), true);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void a(String paramString) {
    try {
      if (!TextUtils.isEmpty(paramString)) {
        AppMethods.a(paramString, true);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void b(int paramInt) {
    try {
      AppMethods.a(AppInfo.d().getResources().getString(paramInt), false);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void b(String paramString) {
    try {
      if (!TextUtils.isEmpty(paramString)) {
        AppMethods.a(paramString, false);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\commo\\utils\ToastUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */