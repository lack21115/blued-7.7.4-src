package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.view.View;
import yaq.gdtadv;

public class bf {
  private static boolean a(Context paramContext) {
    return gdtadv.getZresult(346, 1, new Object[] { paramContext });
  }
  
  public static boolean a(Context paramContext, View paramView, int paramInt) {
    return gdtadv.getZresult(347, 1, new Object[] { paramContext, paramView, Integer.valueOf(paramInt) });
  }
  
  public static boolean a(Context paramContext, View paramView, int paramInt, boolean paramBoolean) {
    return gdtadv.getZresult(348, 1, new Object[] { paramContext, paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
  }
  
  public static boolean a(View paramView) {
    return gdtadv.getZresult(349, 1, new Object[] { paramView });
  }
  
  private static boolean a(View paramView, int paramInt) {
    return gdtadv.getZresult(350, 1, new Object[] { paramView, Integer.valueOf(paramInt) });
  }
  
  public static float b(View paramView) {
    return gdtadv.getFresult(351, 1, new Object[] { paramView });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */