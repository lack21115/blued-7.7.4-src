package com.baidu.mobads.utils;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import com.baidu.mobads.interfaces.utils.IXAdViewUtils;

public class ab implements IXAdViewUtils {
  private boolean a(View paramView) {
    return (paramView.getWidth() > 15 && paramView.getHeight() > 15);
  }
  
  public int getViewState(View paramView) {
    return !isScreenOn(paramView.getContext()) ? 4 : (!isAdViewShown(paramView) ? 1 : (!a(paramView) ? 6 : (!isVisible(paramView, 50) ? 3 : 0)));
  }
  
  public int getVisiblePercent(View paramView, Context paramContext) {
    if (paramView != null)
      try {
        if (paramView.isShown()) {
          DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
          int i = displayMetrics.heightPixels;
          int j = displayMetrics.widthPixels;
          Rect rect = new Rect();
          paramView.getGlobalVisibleRect(rect);
          if (rect.top <= i && rect.left <= j) {
            double d = (rect.width() * rect.height());
            i = paramView.getWidth();
            j = paramView.getHeight();
            return (int)(d * 100.0D / (i * j));
          } 
        } 
        return 0;
      } catch (Exception exception) {
        return 0;
      }  
    return 0;
  }
  
  public boolean isAdViewOutsideScreen(View paramView) {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect rect = XAdSDKFoundationFacade.getInstance().getCommonUtils().getWindowRect(paramView.getContext());
    boolean bool = false;
    int i = arrayOfInt[0] + paramView.getWidth() / 2;
    int j = arrayOfInt[1] + paramView.getHeight() / 2;
    if (i <= 0 || i >= rect.width() || j <= 0 || j >= rect.height())
      bool = true; 
    return bool;
  }
  
  public boolean isAdViewShown(View paramView) {
    return (paramView != null && paramView.isShown());
  }
  
  public boolean isAdViewTooSmall(View paramView) {
    return (paramView != null && (paramView.getWidth() < 10 || paramView.getHeight() < 10));
  }
  
  public boolean isScreenOn(Context paramContext) {
    try {
      return ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
      return true;
    } 
  }
  
  public boolean isVisible(View paramView, int paramInt) {
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
        if (l3 <= 0L)
          return false; 
        bool1 = bool2;
        if (l1 * l2 * 100L >= paramInt * l3)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */