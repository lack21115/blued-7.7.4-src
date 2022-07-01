package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class p {
  public static int a(Context paramContext) {
    WindowManager windowManager = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics displayMetrics = new DisplayMetrics();
    if (windowManager != null)
      windowManager.getDefaultDisplay().getMetrics(displayMetrics); 
    return displayMetrics.widthPixels;
  }
  
  public static int b(Context paramContext) {
    WindowManager windowManager = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics displayMetrics = new DisplayMetrics();
    if (windowManager != null)
      windowManager.getDefaultDisplay().getMetrics(displayMetrics); 
    return displayMetrics.heightPixels;
  }
  
  public static int c(Context paramContext) {
    int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    return (i > 0) ? paramContext.getResources().getDimensionPixelSize(i) : 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */