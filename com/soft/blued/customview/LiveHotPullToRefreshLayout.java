package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.blued.android.module.live_china.observer.LiveTabNewObserver;
import com.google.android.material.appbar.AppBarLayout;
import com.soft.blued.utils.RefreshUtils;

public class LiveHotPullToRefreshLayout extends FrameLayout {
  public boolean a;
  
  public View b;
  
  public int c;
  
  public AppBarLayout d;
  
  public View e;
  
  public View f;
  
  Runnable g = new Runnable(this) {
      public void run() {
        if (Math.abs(this.a.d.getTop()) >= LiveHotPullToRefreshLayout.b(this.a)) {
          if (LiveHotPullToRefreshLayout.a(this.a).getChildCount() == 0) {
            (LiveHotPullToRefreshLayout.c(this.a).getLayoutParams()).height = this.a.e.getHeight();
            LiveHotPullToRefreshLayout.a(this.a).addView(LiveHotPullToRefreshLayout.d(this.a));
          } 
          if (LiveHotPullToRefreshLayout.a(this.a).getVisibility() == 8) {
            LiveHotPullToRefreshLayout.a(this.a).setVisibility(0);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
            translateAnimation.setDuration(300L);
            translateAnimation.setFillAfter(true);
            LiveHotPullToRefreshLayout.a(this.a).setAnimation((Animation)translateAnimation);
            translateAnimation.setAnimationListener(new Animation.AnimationListener(this) {
                  public void onAnimationEnd(Animation param2Animation) {
                    LiveHotPullToRefreshLayout.a(this.a.a).clearAnimation();
                  }
                  
                  public void onAnimationRepeat(Animation param2Animation) {}
                  
                  public void onAnimationStart(Animation param2Animation) {}
                });
            translateAnimation.start();
          } 
        } 
      }
    };
  
  private int h;
  
  private int i;
  
  private FrameLayout j;
  
  private FrameLayout k;
  
  public LiveHotPullToRefreshLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LiveHotPullToRefreshLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b() {
    this.b = LayoutInflater.from(getContext()).inflate(2131493851, (ViewGroup)this);
    this.e = this.b.findViewById(2131299091);
    this.f = this.b.findViewById(2131299114);
    this.j = (FrameLayout)this.b.findViewById(2131297171);
    this.k = (FrameLayout)this.b.findViewById(2131297105);
    this.d = (AppBarLayout)this.b.findViewById(2131296447);
    this.d.a(new AppBarLayout.OnOffsetChangedListener(this) {
          public void onOffsetChanged(AppBarLayout param1AppBarLayout, int param1Int) {
            if (param1Int >= 0) {
              this.a.a = true;
            } else {
              this.a.a = false;
            } 
            if (param1Int == 0)
              LiveTabNewObserver.a().c(); 
            int i = this.a.c;
            this.a.c = param1Int;
          }
        });
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
          public void onGlobalLayout() {
            LiveHotPullToRefreshLayout liveHotPullToRefreshLayout = this.a;
            LiveHotPullToRefreshLayout.a(liveHotPullToRefreshLayout, liveHotPullToRefreshLayout.f.getHeight());
            liveHotPullToRefreshLayout = this.a;
            LiveHotPullToRefreshLayout.b(liveHotPullToRefreshLayout, liveHotPullToRefreshLayout.d.getHeight());
          }
        });
  }
  
  private View getView() {
    if (this.e.getParent() instanceof ViewGroup)
      ((ViewGroup)this.e.getParent()).removeAllViews(); 
    return this.e;
  }
  
  public void a() {
    RefreshUtils.a(this.d);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\LiveHotPullToRefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */