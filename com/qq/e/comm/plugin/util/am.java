package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.qq.e.comm.util.GDTLogger;

public class am {
  public static float a(Context paramContext, float paramFloat) {
    return TypedValue.applyDimension(1, paramFloat, paramContext.getApplicationContext().getResources().getDisplayMetrics());
  }
  
  public static int a(Context paramContext) {
    try {
      int i = (paramContext.getApplicationContext().getResources().getConfiguration()).screenLayout;
      return ((i & 0xF) >= 3) ? 2 : 1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Get device type encounter exception: ");
      stringBuilder.append(exception.getMessage());
      GDTLogger.d(stringBuilder.toString());
      return 0;
    } 
  }
  
  public static int a(Context paramContext, int paramInt) {
    Resources resources = paramContext.getApplicationContext().getResources();
    return (int)TypedValue.applyDimension(1, paramInt, resources.getDisplayMetrics());
  }
  
  public static float b(Context paramContext, float paramFloat) {
    return paramFloat / (paramContext.getApplicationContext().getResources().getDisplayMetrics()).density + 0.5F;
  }
  
  public static int b(Context paramContext) {
    return (paramContext.getApplicationContext().getResources().getDisplayMetrics()).widthPixels;
  }
  
  public static int b(Context paramContext, int paramInt) {
    float f = (paramContext.getApplicationContext().getResources().getDisplayMetrics()).density;
    return (int)(paramInt / f + 0.5F);
  }
  
  public static int c(Context paramContext) {
    return (paramContext.getApplicationContext().getResources().getDisplayMetrics()).heightPixels;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */