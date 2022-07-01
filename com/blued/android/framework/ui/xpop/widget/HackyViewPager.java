package com.blued.android.framework.ui.xpop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class HackyViewPager extends ViewPager {
  public HackyViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    try {
      return super.onInterceptTouchEvent(paramMotionEvent);
    } catch (IllegalArgumentException illegalArgumentException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\widget\HackyViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */