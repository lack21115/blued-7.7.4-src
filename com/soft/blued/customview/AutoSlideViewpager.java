package com.soft.blued.customview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;

public class AutoSlideViewpager extends ViewPager {
  private boolean d = false;
  
  private PagerIndicator e;
  
  private int f = 0;
  
  private Handler g = new Handler(Looper.getMainLooper());
  
  private Runnable h = new Runnable(this) {
      public void run() {
        if (!AutoSlideViewpager.a(this.a).booleanValue())
          return; 
        if (this.a.getAdapter() != null) {
          int i = this.a.getAdapter().getCount();
          AutoSlideViewpager.b(this.a);
          if (AutoSlideViewpager.c(this.a) >= i)
            AutoSlideViewpager.a(this.a, 0); 
          AutoSlideViewpager autoSlideViewpager = this.a;
          autoSlideViewpager.setCurrentItem(AutoSlideViewpager.c(autoSlideViewpager));
        } 
      }
    };
  
  private Boolean i = Boolean.valueOf(true);
  
  private Context j;
  
  private BroadcastReceiver k = new BroadcastReceiver(this) {
      public void onReceive(Context param1Context, Intent param1Intent) {
        if (AutoSlideViewpager.a(this.a).booleanValue()) {
          if (param1Intent.getAction().equals("slide_pause_listener")) {
            AutoSlideViewpager.g(this.a).removeCallbacks(AutoSlideViewpager.f(this.a));
            return;
          } 
          if (param1Intent.getAction().equals("slide_start_listener"))
            AutoSlideViewpager.e(this.a); 
        } 
      }
    };
  
  public AutoSlideViewpager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    g();
    this.j = paramContext;
  }
  
  private void f() {
    this.g.removeCallbacks(this.h);
    this.g.postDelayed(this.h, 3000L);
  }
  
  private void g() {
    addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {
            if (param1Int == 0) {
              AutoSlidePagerAdapter autoSlidePagerAdapter = (AutoSlidePagerAdapter)this.a.getAdapter();
              if (autoSlidePagerAdapter != null) {
                if (autoSlidePagerAdapter.a() <= 1)
                  return; 
                int i = autoSlidePagerAdapter.a();
                param1Int = autoSlidePagerAdapter.getCount();
                if (AutoSlideViewpager.c(this.a) < i) {
                  param1Int = AutoSlideViewpager.c(this.a) + i;
                  this.a.setCurrentItem(param1Int, false);
                  AutoSlideViewpager.a(this.a, param1Int);
                  return;
                } 
                if (AutoSlideViewpager.c(this.a) >= i * 2) {
                  if (param1Int < i * 3) {
                    if (i == 0) {
                      param1Int = AutoSlideViewpager.c(this.a);
                    } else {
                      param1Int = AutoSlideViewpager.c(this.a) % i;
                    } 
                  } else {
                    if (i == 0) {
                      param1Int = AutoSlideViewpager.c(this.a);
                    } else {
                      param1Int = AutoSlideViewpager.c(this.a) % i;
                    } 
                    param1Int += i;
                  } 
                  this.a.setCurrentItem(param1Int, false);
                  AutoSlideViewpager.a(this.a, param1Int);
                } 
              } 
            } 
          }
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            if (AutoSlideViewpager.d(this.a) != null)
              AutoSlideViewpager.d(this.a).setCurrentPage(param1Int); 
            AutoSlideViewpager.a(this.a, param1Int);
            AutoSlidePagerAdapter autoSlidePagerAdapter = (AutoSlidePagerAdapter)this.a.getAdapter();
            if (autoSlidePagerAdapter != null && autoSlidePagerAdapter.getCount() > 1 && AutoSlideViewpager.a(this.a).booleanValue())
              AutoSlideViewpager.e(this.a); 
          }
        });
  }
  
  public void b() {
    AutoSlidePagerAdapter autoSlidePagerAdapter = (AutoSlidePagerAdapter)getAdapter();
    if (autoSlidePagerAdapter != null && autoSlidePagerAdapter.a() > 1) {
      this.d = true;
      this.f = autoSlidePagerAdapter.a();
      setCurrentItem(this.f, false);
      if (this.i.booleanValue()) {
        f();
        return;
      } 
    } else {
      this.d = false;
    } 
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("slide_pause_listener");
    intentFilter.addAction("slide_start_listener");
    try {
      this.j.registerReceiver(this.k, intentFilter);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    try {
      this.j.unregisterReceiver(this.k);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  protected void onWindowVisibilityChanged(int paramInt) {
    super.onWindowVisibilityChanged(paramInt);
    if (this.d)
      if (paramInt == 0) {
        if (this.i.booleanValue()) {
          f();
          return;
        } 
      } else {
        this.g.removeCallbacks(this.h);
      }  
  }
  
  public void setPagerIndicator(PagerIndicator paramPagerIndicator) {
    this.e = paramPagerIndicator;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\AutoSlideViewpager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */