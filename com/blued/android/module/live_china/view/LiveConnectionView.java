package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.utils.log.InstantLog;

public class LiveConnectionView extends FrameLayout implements ILiveConnectionStateListener {
  public RecordingOnliveFragment a;
  
  private Context b;
  
  private LayoutInflater c;
  
  private LivePKCenterView d;
  
  private LivePKFriendListView e;
  
  private LivePKInviteView f;
  
  private LivePKWholeView g;
  
  private PopLiveCenterWebView h;
  
  public LiveConnectionView(Context paramContext) {
    this(paramContext, null);
  }
  
  public LiveConnectionView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LiveConnectionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
  }
  
  private void m() {
    this.c = LayoutInflater.from(this.b);
    View view = this.c.inflate(R.layout.live_connection_view, (ViewGroup)this);
    this.d = (LivePKCenterView)view.findViewById(R.id.live_pk_center_view);
    this.e = (LivePKFriendListView)view.findViewById(R.id.live_pk_friend_list_view);
    this.f = (LivePKInviteView)view.findViewById(R.id.live_pk_invite_view);
    this.g = (LivePKWholeView)view.findViewById(R.id.live_pk_whole_view);
    this.h = (PopLiveCenterWebView)view.findViewById(R.id.live_pk_web_view);
    this.d.a(this);
    this.e.a(this);
    this.f.a(this);
    this.g.a(this);
    this.h.a(this);
  }
  
  public void a() {
    this.a.Q();
  }
  
  public void a(RecordingOnliveFragment paramRecordingOnliveFragment) {
    this.a = paramRecordingOnliveFragment;
    m();
  }
  
  public void a(LiveFriendModel paramLiveFriendModel) {
    this.g.a(paramLiveFriendModel);
  }
  
  public void a(LiveFriendModel paramLiveFriendModel, boolean paramBoolean, int paramInt) {
    this.f.a(paramLiveFriendModel, paramBoolean, paramInt);
  }
  
  public void a(String paramString) {
    this.h.a(paramString);
  }
  
  public void a(boolean paramBoolean) {
    LivePKInviteView livePKInviteView = this.f;
    if (livePKInviteView != null && livePKInviteView.b()) {
      this.f.d();
      return;
    } 
    LivePKCenterView livePKCenterView = this.d;
    if (livePKCenterView != null) {
      livePKCenterView.a(paramBoolean);
      InstantLog.a("live_interact_btn_click");
    } 
  }
  
  public void a(boolean paramBoolean, int paramInt) {
    this.e.a(paramBoolean, paramInt);
  }
  
  public void b() {
    this.a.R();
  }
  
  public void c() {
    this.g.a();
  }
  
  public void d() {
    this.f.c();
  }
  
  public void e() {
    this.g.i();
  }
  
  public void f() {
    this.g.j();
  }
  
  public boolean g() {
    LivePKCenterView livePKCenterView = this.d;
    boolean bool = false;
    null = bool;
    if (livePKCenterView != null) {
      null = bool;
      if (this.e != null) {
        null = bool;
        if (this.g != null) {
          if (this.h == null)
            return false; 
          if (!livePKCenterView.a() && !this.e.e() && !this.f.b() && !this.g.f()) {
            null = bool;
            return this.h.c() ? true : null;
          } 
        } else {
          return null;
        } 
      } else {
        return null;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  public void h() {
    LivePKCenterView livePKCenterView = this.d;
    if (livePKCenterView != null && livePKCenterView.a()) {
      PopLiveCenterWebView popLiveCenterWebView = this.h;
      if (popLiveCenterWebView != null && popLiveCenterWebView.c()) {
        this.h.d();
      } else {
        this.d.b();
      } 
    } 
    LivePKFriendListView livePKFriendListView = this.e;
    if (livePKFriendListView != null && livePKFriendListView.e())
      this.e.f(); 
    LivePKInviteView livePKInviteView = this.f;
    if (livePKInviteView != null && livePKInviteView.b())
      this.f.a(); 
    LivePKWholeView livePKWholeView = this.g;
    if (livePKWholeView != null && livePKWholeView.f())
      this.g.e(); 
  }
  
  public boolean i() {
    LivePKWholeView livePKWholeView = this.g;
    if (livePKWholeView != null && (livePKWholeView.a == 4 || this.g.a == 2 || this.g.a == 1))
      return true; 
    LivePKInviteView livePKInviteView = this.f;
    return (livePKInviteView != null) ? livePKInviteView.b() : false;
  }
  
  public void j() {
    this.f.g();
    this.g.d();
  }
  
  public void k() {
    RecordingOnliveFragment recordingOnliveFragment = this.a;
    if (recordingOnliveFragment != null && (recordingOnliveFragment.B() || this.a.aM()))
      this.a.bD.b(); 
    LivePKWholeView livePKWholeView2 = this.g;
    if (livePKWholeView2 != null && livePKWholeView2.a == 1)
      this.g.b(); 
    LivePKInviteView livePKInviteView = this.f;
    if (livePKInviteView != null && livePKInviteView.b())
      this.f.e(); 
    livePKInviteView = this.f;
    if (livePKInviteView != null)
      livePKInviteView.g(); 
    LivePKWholeView livePKWholeView1 = this.g;
    if (livePKWholeView1 != null)
      livePKWholeView1.d(); 
  }
  
  public void l() {
    this.e.j();
  }
  
  public void setPKCurrentModel(int paramInt) {
    this.g.setCurrentModel(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveConnectionView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */