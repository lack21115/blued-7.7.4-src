package com.soft.blued.customview.adapttextview;

import android.content.Context;
import com.blued.android.framework.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;

public class FontAdjustTextHelper {
  private static String[] a = new String[] { "A", "标准", "", "", "A" };
  
  private static int[] b = new int[] { 13, 14, 16, 18, 24 };
  
  public static int a() {
    return a(BluedPreferences.cv());
  }
  
  public static int a(int paramInt) {
    int[] arrayOfInt = b;
    return (arrayOfInt != null && arrayOfInt.length > paramInt) ? arrayOfInt[paramInt] : 14;
  }
  
  public static int a(Context paramContext, float paramFloat) {
    return (int)(paramFloat * (paramContext.getResources().getDisplayMetrics()).density + 0.5F);
  }
  
  public static int b() {
    return BluedPreferences.cv();
  }
  
  public static void b(int paramInt) {
    BluedPreferences.u(paramInt);
  }
  
  public static String[] c() {
    a[1] = AppUtils.a(2131758718);
    return a;
  }
  
  public static int[] d() {
    return b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\adapttextview\FontAdjustTextHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */