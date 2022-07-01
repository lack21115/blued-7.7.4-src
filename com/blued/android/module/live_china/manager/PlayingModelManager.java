package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.live_interface.IScreenManager;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.view.LiveCueView;

public class PlayingModelManager implements IScreenManager {
  private PlayingOnliveBaseModeFragment a;
  
  private Context b;
  
  private View c;
  
  private View d;
  
  private View e;
  
  public PlayingModelManager(PlayingOnliveBaseModeFragment paramPlayingOnliveBaseModeFragment) {
    this.a = paramPlayingOnliveBaseModeFragment;
    this.b = paramPlayingOnliveBaseModeFragment.getContext();
    this.c = paramPlayingOnliveBaseModeFragment.e;
    h();
  }
  
  private void a(int paramInt) {
    this.a.ak = paramInt;
    LiveRefreshUIObserver.a().c(paramInt);
  }
  
  private void k() {
    if (!LiveRoomPreferences.A()) {
      LiveRoomPreferences.b(true);
      LiveCueView.a(this.b, "", 21, 0, 16, 10, 0, false, R.drawable.live_switch_clear_tips, 5000);
    } 
  }
  
  public void a() {
    if (this.a.ak != 3 && this.a.ak != 4) {
      j();
      this.a.m();
      this.a.w.a();
    } 
    this.a.a(LiveRoomManager.a().h());
    a(2);
    this.a.am.setVisibility(0);
    this.a.q.setVisibility(0);
    this.a.E.setVisibility(0);
    this.a.K();
    this.a.r.d();
    if (LiveRoomManager.a().h() != null)
      this.a.r.setMedalData((LiveRoomManager.a().h()).badges); 
    this.a.e(0);
    this.a.aa.setVisibility(0);
    this.a.an.setVisibility(0);
    this.a.ah.setVisibility(0);
    this.a.ag.setVisibility(0);
    this.a.T.setVisibility(0);
    this.a.ai.setVisibility(8);
    this.a.w.c(true);
    this.a.w.c(0);
    this.a.w.a(0);
    this.a.w.h();
    this.a.y();
    k();
    AppInfo.n().removeCallbacks((Runnable)this.a.as);
    AppInfo.n().postDelayed((Runnable)this.a.as, 5000L);
  }
  
  public void b() {
    Logger.a("rrb", new Object[] { " %%%%%%%%%%%switchVerticalScreen mCurrentModel = ", Integer.valueOf(this.a.ak) });
    if (this.a.ak == 1)
      return; 
    a(1);
    i();
    this.a.m();
    this.a.r.e();
    if (LiveRoomManager.a().h() != null)
      this.a.r.setMedalData((LiveRoomManager.a().h()).badges); 
    this.a.w.a();
    this.a.af.setVisibility(0);
    this.a.w.h();
    this.a.w.o();
    this.a.v();
    AppInfo.n().removeCallbacks((Runnable)this.a.as);
  }
  
  public void c() {
    if (this.a.ak == 3)
      return; 
    this.a.am.setVisibility(4);
    this.a.q.setVisibility(4);
    this.a.E.setVisibility(4);
    this.a.r.setVisibility(8);
    this.a.e(8);
    this.a.w.c(false);
    this.a.z();
    a(3);
  }
  
  public void d() {
    this.a.am.setVisibility(4);
    this.a.q.setVisibility(4);
    this.a.E.setVisibility(4);
    this.a.r.setVisibility(8);
    this.a.an.setVisibility(8);
    this.a.ah.setVisibility(8);
    this.a.ag.setVisibility(8);
    this.a.T.setVisibility(8);
    this.a.ai.setVisibility(0);
    this.a.w.c(8);
    this.a.w.a(8);
    this.a.z();
    a(4);
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {
    i();
    this.a.m();
    a(0);
  }
  
  public void i() {
    Logger.a("drb", new Object[] { "mRootView = ", this.c });
    this.a.ad = (FrameLayout)this.c.findViewById(R.id.switch_orientation_layout);
    if (this.d != null && this.a.ad.getChildCount() > 0 && this.a.ad.getChildAt(0) == this.d) {
      Log.i("drb", "initVerticalRootView return");
      return;
    } 
    this.a.ad.removeAllViews();
    if (this.d == null)
      this.d = LayoutInflater.from(this.b).inflate(R.layout.fragment_play_onlive_portrait, null); 
    this.a.ad.addView(this.d);
  }
  
  public void j() {
    this.a.ad = (FrameLayout)this.c.findViewById(R.id.switch_orientation_layout);
    if (this.e != null && this.a.ad.getChildCount() > 0 && this.a.ad.getChildAt(0) == this.e) {
      Log.i("drb", "initHorizontalRootView return");
      return;
    } 
    this.a.ad.removeAllViews();
    if (this.e == null)
      this.e = LayoutInflater.from(this.b).inflate(R.layout.fragment_play_onlive_land, null); 
    this.a.ad.addView(this.e);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\PlayingModelManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */