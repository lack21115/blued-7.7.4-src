package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ai;
import java.lang.reflect.Method;

public class y {
  private static boolean a(Context paramContext) throws Throwable {
    Object object;
    PowerManager powerManager = (PowerManager)paramContext.getSystemService("power");
    if (powerManager != null) {
      Method method = powerManager.getClass().getMethod("isScreenOn", new Class[0]);
    } else {
      paramContext = null;
    } 
    if (paramContext != null) {
      object = paramContext.invoke(powerManager, new Object[0]);
    } else {
      object = Boolean.valueOf(false);
    } 
    return ((Boolean)object).booleanValue();
  }
  
  private static boolean a(View paramView) {
    return (paramView != null && paramView.isShown());
  }
  
  private static boolean a(View paramView, int paramInt) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramView != null) {
      bool1 = bool2;
      if (paramView.getVisibility() == 0) {
        if (paramView.getParent() == null)
          return false; 
        Rect rect = new Rect();
        if (!paramView.getGlobalVisibleRect(rect))
          return false; 
        long l1 = rect.height();
        long l2 = rect.width();
        long l3 = paramView.getHeight() * paramView.getWidth();
        bool1 = bool2;
        if (l3 > 0L) {
          bool1 = bool2;
          if (l1 * l2 * 100L >= paramInt * l3)
            bool1 = true; 
        } 
      } 
    } 
    return bool1;
  }
  
  public static boolean a(View paramView, int paramInt1, int paramInt2) {
    boolean bool = false;
    try {
      paramInt1 = b(paramView, paramInt1, paramInt2);
      return bool;
    } finally {
      paramView = null;
    } 
  }
  
  private static int b(View paramView, int paramInt1, int paramInt2) throws Throwable {
    return !a(paramView.getContext()) ? 4 : (!a(paramView) ? 1 : (!b(paramView, paramInt2) ? 6 : (!a(paramView, paramInt1) ? 3 : 0)));
  }
  
  private static boolean b(View paramView, int paramInt) {
    int i = c(paramView, paramInt);
    paramInt = d(paramView, paramInt);
    return (paramView.getWidth() >= i && paramView.getHeight() >= paramInt);
  }
  
  private static int c(View paramView, int paramInt) {
    return (paramInt == 3) ? (int)(ai.c(paramView.getContext().getApplicationContext()) * 0.7D) : 20;
  }
  
  private static int d(View paramView, int paramInt) {
    return (paramInt == 3) ? (ai.d(paramView.getContext().getApplicationContext()) / 2) : 20;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */