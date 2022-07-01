package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;

public class KeyboardLockdLayout extends FrameLayout {
  int a;
  
  int b;
  
  private Context c;
  
  public KeyboardLockdLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    a();
  }
  
  private void a() {}
  
  private boolean b() {
    Rect rect = new Rect();
    View view = getRootView();
    getWindowVisibleDisplayFrame(rect);
    DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
    return ((view.getBottom() - rect.bottom) > displayMetrics.density * 100.0F);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (b()) {
      super.onMeasure(this.a, this.b);
    } else {
      super.onMeasure(paramInt1, paramInt2);
    } 
    this.a = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\KeyboardLockdLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */