package com.facebook.stetho.common.android;

import android.view.View;
import android.view.ViewGroup;

public final class ViewGroupUtil {
  public static int findChildIndex(ViewGroup paramViewGroup, View paramView) {
    int j = paramViewGroup.getChildCount();
    for (int i = 0; i < j; i++) {
      if (paramViewGroup.getChildAt(i) == paramView)
        return i; 
    } 
    return -1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\android\ViewGroupUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */