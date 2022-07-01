package com.blued.android.module.shortvideo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;

public class StvHackyViewPager extends ViewPager {
  public StvHackyViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    f();
  }
  
  public void f() {
    setPageMargin(DensityUtils.a(AppInfo.d(), 20.0F));
    setBackgroundColor(-16777216);
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    try {
      return super.onInterceptTouchEvent(paramMotionEvent);
    } catch (IllegalArgumentException|ArrayIndexOutOfBoundsException illegalArgumentException) {
      return false;
    } 
  }
  
  public void setAlpha(int paramInt) {
    getBackground().setAlpha(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\widget\StvHackyViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */