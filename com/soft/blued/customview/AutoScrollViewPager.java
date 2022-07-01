package com.soft.blued.customview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class AutoScrollViewPager extends ViewPager {
  private long d = 1500L;
  
  private int e = 1;
  
  private boolean f = true;
  
  private boolean g = true;
  
  private int h = 0;
  
  private boolean i = true;
  
  private double j = 1.0D;
  
  private double k = 1.0D;
  
  private Handler l;
  
  private boolean m = false;
  
  private boolean n = false;
  
  private float o = 0.0F;
  
  private float p = 0.0F;
  
  private CustomDurationScroller q = null;
  
  public AutoScrollViewPager(Context paramContext) {
    super(paramContext);
    i();
  }
  
  public AutoScrollViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    i();
  }
  
  private void a(long paramLong) {
    this.l.removeMessages(0);
    this.l.sendEmptyMessageDelayed(0, paramLong);
  }
  
  private void i() {
    this.l = new MyHandler(this);
    j();
  }
  
  private void j() {
    try {
      Field field1 = ViewPager.class.getDeclaredField("m");
      field1.setAccessible(true);
      Field field2 = ViewPager.class.getDeclaredField("f");
      field2.setAccessible(true);
      this.q = new CustomDurationScroller(getContext(), (Interpolator)field2.get((Object)null));
      field1.set(this, this.q);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void c(int paramInt) {
    this.m = true;
    a(paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (this.g)
      if (i == 0 && this.m) {
        this.n = true;
        g();
      } else if ((paramMotionEvent.getAction() == 1 || paramMotionEvent.getAction() == 3) && this.n) {
        f();
      }  
    i = this.h;
    if (i == 2 || i == 1) {
      this.o = paramMotionEvent.getX();
      if (paramMotionEvent.getAction() == 0)
        this.p = this.o; 
      int j = getCurrentItem();
      PagerAdapter pagerAdapter = getAdapter();
      if (pagerAdapter == null) {
        i = 0;
      } else {
        i = pagerAdapter.getCount();
      } 
      if ((j == 0 && this.p <= this.o) || (j == i - 1 && this.p >= this.o)) {
        if (this.h == 2) {
          getParent().requestDisallowInterceptTouchEvent(false);
        } else {
          if (i > 1)
            setCurrentItem(i - j - 1, this.i); 
          getParent().requestDisallowInterceptTouchEvent(true);
        } 
        return super.dispatchTouchEvent(paramMotionEvent);
      } 
    } 
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void f() {
    this.m = true;
    a((long)(this.d + this.q.getDuration() / this.j * this.k));
  }
  
  public void g() {
    this.m = false;
    this.l.removeMessages(0);
  }
  
  public int getDirection() {
    return (this.e == 0) ? 0 : 1;
  }
  
  public long getInterval() {
    return this.d;
  }
  
  public int getSlideBorderMode() {
    return this.h;
  }
  
  public void h() {
    PagerAdapter pagerAdapter = getAdapter();
    int i = getCurrentItem();
    if (pagerAdapter != null) {
      int j = pagerAdapter.getCount();
      if (j <= 1)
        return; 
      if (this.e == 0) {
        i--;
      } else {
        i++;
      } 
      if (i < 0) {
        if (this.f) {
          setCurrentItem(j - 1, this.i);
          return;
        } 
      } else if (i == j) {
        if (this.f) {
          setCurrentItem(0, this.i);
          return;
        } 
      } else {
        setCurrentItem(i, true);
      } 
    } 
  }
  
  public void setAutoScrollDurationFactor(double paramDouble) {
    this.j = paramDouble;
  }
  
  public void setBorderAnimation(boolean paramBoolean) {
    this.i = paramBoolean;
  }
  
  public void setCycle(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public void setDirection(int paramInt) {
    this.e = paramInt;
  }
  
  public void setInterval(long paramLong) {
    this.d = paramLong;
  }
  
  public void setSlideBorderMode(int paramInt) {
    this.h = paramInt;
  }
  
  public void setStopScrollWhenTouch(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public void setSwipeScrollDurationFactor(double paramDouble) {
    this.k = paramDouble;
  }
  
  static class MyHandler extends Handler {
    private final WeakReference<AutoScrollViewPager> a;
    
    public MyHandler(AutoScrollViewPager param1AutoScrollViewPager) {
      this.a = new WeakReference<AutoScrollViewPager>(param1AutoScrollViewPager);
    }
    
    public void handleMessage(Message param1Message) {
      super.handleMessage(param1Message);
      if (param1Message.what != 0)
        return; 
      AutoScrollViewPager autoScrollViewPager = this.a.get();
      if (autoScrollViewPager != null) {
        AutoScrollViewPager.b(autoScrollViewPager).a(AutoScrollViewPager.a(autoScrollViewPager));
        autoScrollViewPager.h();
        AutoScrollViewPager.b(autoScrollViewPager).a(AutoScrollViewPager.c(autoScrollViewPager));
        AutoScrollViewPager.a(autoScrollViewPager, AutoScrollViewPager.d(autoScrollViewPager) + AutoScrollViewPager.b(autoScrollViewPager).getDuration());
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\AutoScrollViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */