package com.qq.e.comm.plugin.util;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class be {
  public static void a(View paramView) {
    if (paramView != null) {
      ViewParent viewParent = paramView.getParent();
      if (viewParent instanceof ViewGroup)
        ((ViewGroup)viewParent).removeView(paramView); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */