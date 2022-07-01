package com.scwang.smartrefresh.layout.util;

import android.content.res.Resources;

public class DensityUtil {
  public float a = (Resources.getSystem().getDisplayMetrics()).density;
  
  public static float a(int paramInt) {
    return paramInt / (Resources.getSystem().getDisplayMetrics()).density;
  }
  
  public static int a(float paramFloat) {
    return (int)(paramFloat * (Resources.getSystem().getDisplayMetrics()).density + 0.5F);
  }
  
  public int b(float paramFloat) {
    return (int)(paramFloat * this.a + 0.5F);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layou\\util\DensityUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */