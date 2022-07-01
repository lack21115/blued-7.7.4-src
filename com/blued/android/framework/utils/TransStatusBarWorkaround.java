package com.blued.android.framework.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

public class TransStatusBarWorkaround {
  private View a;
  
  private int b;
  
  private ViewGroup.LayoutParams c;
  
  private void a() {
    int i = b();
    if (i != this.b) {
      this.c.height = i;
      this.a.requestLayout();
      this.b = i;
    } 
  }
  
  private int b() {
    Rect rect = new Rect();
    this.a.getWindowVisibleDisplayFrame(rect);
    return rect.bottom;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\TransStatusBarWorkaround.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */