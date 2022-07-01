package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class ProhibitedSlidingViewPager extends ViewPager {
  private static final String d = ProhibitedSlidingViewPager.class.getSimpleName();
  
  private float e;
  
  private SwipeDirection f = SwipeDirection.a;
  
  private int g;
  
  private ILastPageScrollToRightListener h;
  
  public ProhibitedSlidingViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            ProhibitedSlidingViewPager.a(this.a, param1Int);
          }
        });
  }
  
  private boolean a(MotionEvent paramMotionEvent) {
    if (this.f == SwipeDirection.a)
      return true; 
    if (this.f == SwipeDirection.d)
      return false; 
    if (paramMotionEvent.getAction() == 0) {
      this.e = paramMotionEvent.getX();
      return true;
    } 
    if (paramMotionEvent.getAction() == 2)
      try {
        float f = paramMotionEvent.getX() - this.e;
        if (f > 0.0F) {
          if (this.f == SwipeDirection.c)
            return false; 
        } else if (f < 0.0F) {
          if (this.f == SwipeDirection.b)
            return false; 
          if (this.g == getAdapter().getCount() - 1 && this.h != null)
            return this.h.a(); 
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    if (a(paramMotionEvent))
      try {
        return super.onInterceptTouchEvent(paramMotionEvent);
      } catch (Exception exception) {
        return false;
      }  
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return a(paramMotionEvent) ? super.onTouchEvent(paramMotionEvent) : false;
  }
  
  public void setAllowedSwipeDirection(SwipeDirection paramSwipeDirection) {
    this.f = paramSwipeDirection;
  }
  
  public void setLastPageToRightListener(ILastPageScrollToRightListener paramILastPageScrollToRightListener) {
    this.h = paramILastPageScrollToRightListener;
  }
  
  public static interface ILastPageScrollToRightListener {
    boolean a();
  }
  
  public enum SwipeDirection {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\ProhibitedSlidingViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */