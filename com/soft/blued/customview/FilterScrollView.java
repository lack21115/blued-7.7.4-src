package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.widget.NestedScrollView;

public class FilterScrollView extends NestedScrollView {
  private boolean a = true;
  
  public FilterScrollView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public FilterScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    return !this.a ? false : super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return !this.a ? false : super.onTouchEvent(paramMotionEvent);
  }
  
  public void setScrollEnable(boolean paramBoolean) {
    this.a = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\FilterScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */