package com.soft.blued.utils;

import android.view.View;

public class FindViewUtils {
  public static <T extends View> T a(View paramView, int paramInt) {
    return (T)paramView.findViewById(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\FindViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */