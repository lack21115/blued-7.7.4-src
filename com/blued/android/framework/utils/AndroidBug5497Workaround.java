package com.blued.android.framework.utils;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

public class AndroidBug5497Workaround {
  private View a;
  
  private int b;
  
  private FrameLayout.LayoutParams c;
  
  private int d;
  
  private boolean e;
  
  private int f;
  
  private void a() {
    int i = b();
    if (i != this.b) {
      int j = this.a.getRootView().getHeight();
      int k = j - i;
      if (k > j / 4) {
        if (Build.VERSION.SDK_INT >= 19) {
          this.c.height = j - k + this.f;
        } else {
          this.c.height = j - k;
        } 
      } else {
        this.c.height = this.d;
      } 
      this.a.requestLayout();
      this.b = i;
    } 
  }
  
  private int b() {
    Rect rect = new Rect();
    this.a.getWindowVisibleDisplayFrame(rect);
    return rect.bottom - rect.top;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\AndroidBug5497Workaround.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */