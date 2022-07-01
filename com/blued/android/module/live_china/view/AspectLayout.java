package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class AspectLayout extends RelativeLayout {
  private int a;
  
  private int b;
  
  public AspectLayout(Context paramContext) {
    super(paramContext);
  }
  
  public AspectLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public AspectLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public AspectLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    Rect rect = new Rect();
    getWindowVisibleDisplayFrame(rect);
    int i = getRootView().getHeight();
    if (i - rect.bottom - rect.top > i / 4) {
      super.onMeasure(this.a, this.b);
      return;
    } 
    this.a = paramInt1;
    this.b = paramInt2;
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\AspectLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */