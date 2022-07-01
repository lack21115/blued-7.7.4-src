package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_interface.IScreenManager;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomUtils;

public class PlayingScreenManager implements IScreenManager {
  private PlayingOnliveFragment a;
  
  private Context b;
  
  private View c;
  
  public PlayingScreenManager(PlayingOnliveFragment paramPlayingOnliveFragment) {
    this.a = paramPlayingOnliveFragment;
    this.c = paramPlayingOnliveFragment.e;
    this.b = paramPlayingOnliveFragment.getContext();
    h();
  }
  
  private void m() {
    AppInfo.n().post(new Runnable(this) {
          public void run() {
            int[] arrayOfInt = new int[2];
            (PlayingScreenManager.a(this.a)).H.getLocationOnScreen(arrayOfInt);
            int i = arrayOfInt[0];
            int j = arrayOfInt[1];
            int k = (PlayingScreenManager.a(this.a)).H.getMeasuredWidth();
            int m = (PlayingScreenManager.a(this.a)).H.getMeasuredHeight();
            LiveSetDataObserver.a().a(i, j, k + i, m + j);
          }
        });
  }
  
  private void n() {
    int i = AppInfo.l;
    int j = (int)(i * PlayingMakeFriendManager.d);
    LiveFloatManager.a().a(i, j);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, j);
    layoutParams.topMargin = PlayingMakeFriendManager.b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("layoutParams.topMargin:");
    stringBuilder.append(layoutParams.topMargin);
    Log.v("pk", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("layoutParams.topMargin:");
    stringBuilder.append(PlayingMakeFriendManager.b);
    Log.v("pk", stringBuilder.toString());
    this.a.H.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  private void o() {
    int i = AppInfo.l;
    int j = i * 2 / 3;
    LiveFloatManager.a().a(i, j);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, j);
    layoutParams.topMargin = PlayingMakeLoverManager.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("layoutParams.topMargin:");
    stringBuilder.append(layoutParams.topMargin);
    Log.v("lover", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("layoutParams.topMargin:");
    stringBuilder.append(PlayingMakeLoverManager.d);
    Log.v("lover", stringBuilder.toString());
    this.a.H.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void a() {
    Logger.a("rrb", new Object[] { "PlayingScreenManager 切换横屏模式" });
    LiveFloatManager.a().c(true);
    i();
    this.a.f.setShakeWidth(DensityUtils.a(this.b, 50.0F));
    PlayingOnliveFragment playingOnliveFragment = this.a;
    playingOnliveFragment.cn = 1;
    playingOnliveFragment.aI.notifyDataSetChanged();
    this.a.L();
    LiveRoomUtils.a((IRequestHost)this.a.w_(), "1");
    m();
    LiveSetDataObserver.a().b(this.a.D);
    LiveSetDataObserver.a().u();
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            (PlayingScreenManager.a(this.a)).aN.a(false);
          }
        },  100L);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
    layoutParams.setMargins(0, 0, DensityUtils.a(this.b, 53.0F), DensityUtils.a(this.b, 10.0F));
    layoutParams.gravity = 85;
    this.a.bT.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.a.bQ.b();
  }
  
  public void b() {
    LiveFloatManager.a().c(false);
    j();
    this.a.f.setShakeWidth(DensityUtils.a(this.b, 65.0F));
    PlayingOnliveFragment playingOnliveFragment = this.a;
    playingOnliveFragment.cn = 2;
    playingOnliveFragment.aI.notifyDataSetChanged();
    this.a.L();
    LiveRoomUtils.a((IRequestHost)this.a.w_(), "1");
    LiveSetDataObserver.a().l();
    m();
    LiveSetDataObserver.a().b(this.a.D);
    LiveSetDataObserver.a().u();
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            (PlayingScreenManager.a(this.a)).aN.a(true);
          }
        },  500L);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.a.bT.getLayoutParams();
    layoutParams.setMargins(0, 0, DensityUtils.a(this.b, 5.0F), DensityUtils.a(this.b, 55.0F));
    layoutParams.gravity = 85;
    this.a.bT.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.a.bQ.b();
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {
    l();
  }
  
  public void f() {
    n();
  }
  
  public void g() {
    o();
  }
  
  public void h() {
    LiveFloatManager.a().c(false);
    k();
    this.a.f.setShakeWidth(DensityUtils.a(this.b, 65.0F));
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            (PlayingScreenManager.a(this.a)).aN.a(true);
          }
        },  500L);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.a.bT.getLayoutParams();
    layoutParams.setMargins(0, 0, DensityUtils.a(this.b, 5.0F), DensityUtils.a(this.b, 55.0F));
    layoutParams.gravity = 85;
    this.a.bT.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void i() {
    LiveFloatManager.a().a(AppInfo.m, AppInfo.l);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AppInfo.m, AppInfo.l);
    layoutParams.gravity = 17;
    this.a.H.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void j() {
    Logger.a("rrb", new Object[] { "竖屏模式播放器" });
    LiveFloatManager.a().a(AppInfo.l, AppInfo.l / 16 * 9);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
    layoutParams.topMargin = DensityUtils.a(this.b, 120.0F);
    this.a.H.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void k() {
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
    layoutParams.gravity = 17;
    if (LiveFloatManager.a().N() == null)
      LiveFloatManager.a().H(); 
    this.a.H.addView((View)LiveFloatManager.a().N(), (ViewGroup.LayoutParams)layoutParams);
    LiveFloatManager.a().a(AppInfo.l, this.a.aZ());
  }
  
  public void l() {
    int j = AppInfo.l / 2;
    LiveFloatManager liveFloatManager = LiveFloatManager.a();
    int i = AppInfo.l;
    j = j / 3 * 4;
    liveFloatManager.a(i, j);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AppInfo.l, j);
    layoutParams.topMargin = PlayingMakeFriendManager.b;
    this.a.H.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\PlayingScreenManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */