package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;

public class HackyViewPager extends ViewPager {
  public HackyViewPager(Context paramContext) {
    super(paramContext);
    f();
  }
  
  public HackyViewPager(Context paramContext, AttributeSet paramAttributeSet) {
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
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public void setAlpha(int paramInt) {
    getBackground().setAlpha(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\HackyViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */