package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_interface.IScreenManager;
import com.blued.android.module.live_china.observer.BeansRefreshObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomUtils;

public class RecordingScreenManager implements IScreenManager {
  private RecordingOnliveFragment a;
  
  private Context b;
  
  private View c;
  
  private View d;
  
  private View e;
  
  public RecordingScreenManager(RecordingOnliveFragment paramRecordingOnliveFragment) {
    this.a = paramRecordingOnliveFragment;
    this.b = paramRecordingOnliveFragment.getContext();
    this.c = paramRecordingOnliveFragment.e;
    this.a.V();
    if (this.a.be) {
      b();
      if (LiveRoomManager.a().B())
        this.a.getActivity().setRequestedOrientation(0); 
    } else {
      h();
    } 
    this.a.ac();
  }
  
  public void a() {
    if (this.a.bn == 2)
      return; 
    Logger.a("drb", new Object[] { "切换横屏" });
    LiveFloatManager.a().c(true);
    j();
    this.a.W();
    this.a.aZ();
    this.a.cG.a();
    k();
    if (LiveRoomManager.a().B()) {
      this.a.bp.setVisibility(0);
      this.a.bo.setVisibility(8);
      this.a.ar.setVisibility(8);
      RecordingOnliveFragment recordingOnliveFragment1 = this.a;
      recordingOnliveFragment1.a(recordingOnliveFragment1.V);
      this.a.J_();
    } else {
      this.a.bp.setVisibility(8);
      this.a.bo.setVisibility(8);
      this.a.ar.setVisibility(0);
    } 
    this.a.cG.g();
    this.a.ak.d();
    LiveRoomUtils.a((IRequestHost)this.a.w_(), "1");
    BeansRefreshObserver.a().a(this.a.ag, this.a.ah);
    RecordingOnliveFragment recordingOnliveFragment = this.a;
    recordingOnliveFragment.bn = 2;
    recordingOnliveFragment.M_();
    this.a.K();
    this.a.bd.b();
  }
  
  public void b() {
    if (this.a.bn == 1)
      return; 
    Logger.a("drb", new Object[] { "切换竖屏" });
    LiveFloatManager.a().c(false);
    i();
    this.a.W();
    this.a.aZ();
    this.a.cG.a();
    l();
    this.a.ar.setVisibility(8);
    this.a.bp.setVisibility(8);
    this.a.bo.setVisibility(0);
    if (LiveRoomManager.a().B()) {
      RecordingOnliveFragment recordingOnliveFragment1 = this.a;
      recordingOnliveFragment1.a(recordingOnliveFragment1.V);
      this.a.J_();
    } 
    this.a.ak.e();
    this.a.cG.g();
    LiveRoomUtils.a((IRequestHost)this.a.w_(), "1");
    BeansRefreshObserver.a().a(this.a.ag, this.a.ah);
    RecordingOnliveFragment recordingOnliveFragment = this.a;
    recordingOnliveFragment.bn = 1;
    recordingOnliveFragment.X();
    this.a.M_();
    this.a.K();
    this.a.bd.b();
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {
    i();
    this.a.W();
    this.a.aZ();
    this.a.ar.setVisibility(0);
    this.a.bp.setVisibility(8);
    this.a.bo.setVisibility(8);
    this.a.bn = 0;
  }
  
  public void i() {
    Logger.a("drb", new Object[] { "mRootView = ", this.c });
    this.a.bl.removeAllViews();
    if (this.d == null)
      this.d = LayoutInflater.from(this.b).inflate(R.layout.fragment_record_onlive_portrait, null); 
    this.a.bl.addView(this.d);
  }
  
  public void j() {
    this.a.bl.removeAllViews();
    if (this.e == null)
      this.e = LayoutInflater.from(this.b).inflate(R.layout.fragment_record_onlive_land, null); 
    this.a.bl.addView(this.e);
  }
  
  public void k() {
    this.a.a(AppInfo.m, AppInfo.l);
    if (this.a.S != null)
      this.a.S.d(); 
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AppInfo.m, AppInfo.l);
    layoutParams.gravity = 17;
    this.a.C.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void l() {
    AppInfo.n().post(new Runnable(this) {
          public void run() {
            if (!LiveFloatManager.a().B()) {
              Logger.a("ddrb", new Object[] { "--- setVerticalPlayer" });
              if ((RecordingScreenManager.a(this.a)).S != null)
                (RecordingScreenManager.a(this.a)).S.d(); 
              RecordingScreenManager.a(this.a).a(AppInfo.l, AppInfo.l / 16 * 9);
              FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AppInfo.l, AppInfo.l / 16 * 9);
              layoutParams.topMargin = DensityUtils.a(RecordingScreenManager.b(this.a), 120.0F);
              layoutParams.gravity = 49;
              (RecordingScreenManager.a(this.a)).C.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
              (RecordingScreenManager.a(this.a)).C.setBackgroundResource(R.color.black);
            } 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\RecordingScreenManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */