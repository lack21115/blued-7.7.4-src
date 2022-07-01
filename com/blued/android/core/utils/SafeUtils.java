package com.blued.android.core.utils;

import com.blued.android.core.AppInfo;

public class SafeUtils {
  public static int a(String paramString) {
    try {
      return Integer.parseInt(paramString);
    } catch (Exception exception) {
      if (!AppInfo.m())
        return -1; 
      throw exception;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\SafeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */