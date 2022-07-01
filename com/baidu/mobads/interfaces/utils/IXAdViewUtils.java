package com.baidu.mobads.interfaces.utils;

import android.content.Context;
import android.view.View;

public interface IXAdViewUtils {
  public static final int SHOW_STATE_LOWER_THAN_MIN_SHOWPERCENT = 3;
  
  public static final int SHOW_STATE_NOT_ENOUGH_BIG = 6;
  
  public static final int SHOW_STATE_NOT_VISIBLE = 1;
  
  public static final int SHOW_STATE_SCREEN_OFF = 4;
  
  public static final int SHOW_STATE_SHOW = 0;
  
  int getViewState(View paramView);
  
  int getVisiblePercent(View paramView, Context paramContext);
  
  boolean isAdViewOutsideScreen(View paramView);
  
  boolean isAdViewShown(View paramView);
  
  boolean isAdViewTooSmall(View paramView);
  
  boolean isScreenOn(Context paramContext);
  
  boolean isVisible(View paramView, int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interface\\utils\IXAdViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */