package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class NoScrollH5ViewPager extends ViewPager {
  private boolean d = false;
  
  public NoScrollH5ViewPager(Context paramContext) {
    super(paramContext);
  }
  
  public NoScrollH5ViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    return this.d ? super.onInterceptTouchEvent(paramMotionEvent) : false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return this.d ? super.onTouchEvent(paramMotionEvent) : true;
  }
  
  public void setScroll(boolean paramBoolean) {
    this.d = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\NoScrollH5ViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */