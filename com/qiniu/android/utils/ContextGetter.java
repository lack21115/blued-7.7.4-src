package com.qiniu.android.utils;

import android.app.Application;
import android.content.Context;

public final class ContextGetter {
  public static Context applicationContext() {
    try {
      return getApplicationUsingReflection().getApplicationContext();
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  private static Application getApplicationUsingReflection() throws Exception {
    return (Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\androi\\utils\ContextGetter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */