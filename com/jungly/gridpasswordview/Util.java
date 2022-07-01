package com.jungly.gridpasswordview;

import android.content.Context;
import android.util.DisplayMetrics;

public class Util {
  public static int a(Context paramContext, float paramFloat) {
    return (int)(paramFloat / (paramContext.getResources().getDisplayMetrics()).scaledDensity + 0.5F);
  }
  
  public static int a(Context paramContext, int paramInt) {
    DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
    return (int)((paramInt * displayMetrics.density) + 0.5D);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jungly\gridpasswordview\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */