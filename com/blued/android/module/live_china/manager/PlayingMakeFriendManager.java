package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;
import java.util.List;

public class PlayingMakeFriendManager {
  public static int a = 0;
  
  public static int b = 0;
  
  public static int c = 0;
  
  public static double d = 0.9D;
  
  public boolean e;
  
  public int f;
  
  public List<LiveFriendModel> g;
  
  public int h;
  
  private Context i;
  
  private PlayingOnliveFragment j;
  
  private int k;
  
  private boolean l;
  
  public PlayingMakeFriendManager(PlayingOnliveFragment paramPlayingOnliveFragment) {
    int i;
    this.e = false;
    this.f = 0;
    this.l = false;
    this.g = new ArrayList<LiveFriendModel>();
    this.j = paramPlayingOnliveFragment;
    this.i = paramPlayingOnliveFragment.getContext();
    this.k = AppInfo.l / 2;
    a = (int)(this.k * d);
    b = DensityUtils.a(this.i, 148.0F);
    if (StatusBarHelper.a()) {
      i = b - StatusBarHelper.a((Context)paramPlayingOnliveFragment.getActivity());
    } else {
      i = b;
    } 
    c = i;
  }
  
  public void a() {
    this.j.b_(5);
    this.j.aU.f();
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, a * 2);
    layoutParams1.setMargins(0, b, 0, 0);
    this.j.aG.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.j.bR.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    layoutParams1 = new FrameLayout.LayoutParams(this.k, a);
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.k, a);
    int i = this.k;
    layoutParams2.leftMargin = i;
    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, a);
    i = a;
    layoutParams3.topMargin = i;
    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(this.k, i);
    layoutParams4.leftMargin = this.k;
    layoutParams4.topMargin = a;
    this.j.bk.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
    this.j.bl.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.j.bm.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.j.bn.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    this.j.ac.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.j.ad.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.j.ae.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.j.bF.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.j.bG.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    this.j.bE.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
    this.j.bF.setVisibility(0);
    this.j.bG.setVisibility(0);
    this.j.bE.setVisibility(0);
    this.j.bR.setVisibility(0);
    this.j.br.setVisibility(0);
    this.j.bs.setVisibility(0);
    this.j.bt.setVisibility(0);
    this.j.bq.setVisibility(0);
    this.j.by.setVisibility(0);
    this.j.bz.setVisibility(0);
    this.j.bA.setVisibility(0);
    this.j.bC.setVisibility(8);
    this.j.bD.setVisibility(8);
    this.j.bB.setVisibility(8);
    d();
  }
  
  public void a(int paramInt) {
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(this.k, a);
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.k, a);
    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.k, a);
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt == 3) {
          paramInt = a;
          layoutParams3.topMargin = b + paramInt;
          int i = this.k;
          layoutParams3.leftMargin = i;
          layoutParams1.leftMargin = i;
          layoutParams2.topMargin = paramInt;
          this.j.by.setVisibility(8);
        } 
      } else {
        paramInt = a;
        layoutParams3.topMargin = b + paramInt;
        int i = this.k;
        layoutParams1.leftMargin = i;
        layoutParams2.topMargin = paramInt;
        layoutParams2.leftMargin = i;
        this.j.bA.setVisibility(8);
      } 
    } else {
      paramInt = this.k;
      layoutParams3.leftMargin = paramInt;
      layoutParams3.topMargin = b;
      int i = a;
      layoutParams1.topMargin = i;
      layoutParams2.topMargin = i;
      layoutParams2.leftMargin = paramInt;
      this.j.bz.setVisibility(8);
    } 
    this.j.Z.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    this.j.bm.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.j.bn.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.j.bl.setVisibility(0);
    this.j.bm.setVisibility(0);
    this.j.bn.setVisibility(0);
    this.j.Z.setVisibility(0);
  }
  
  public void a(LiveFriendModel paramLiveFriendModel) {
    this.j.b_(6);
    (LiveFloatManager.a()).b.setVisibility(8);
    LiveFloatManager.a().h();
    PlayingOnliveFragment playingOnliveFragment = this.j;
    playingOnliveFragment.aJ = true;
    playingOnliveFragment.aN.setRTCModel(this.j.aJ);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, a * 2);
    layoutParams.setMargins(0, b, 0, 0);
    this.j.aG.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    a(paramLiveFriendModel.index);
    this.h = paramLiveFriendModel.index;
    e();
    d();
    this.j.q.a(3);
    this.j.a(JoinLiveResult.SUCCESS, paramLiveFriendModel.conference_id, paramLiveFriendModel.conference_token, paramLiveFriendModel.stream, paramLiveFriendModel.target_stream, paramLiveFriendModel.index);
  }
  
  public void a(List<LiveFriendModel> paramList) {
    this.g = paramList;
    if (this.g != null)
      for (int i = 0; i < this.g.size(); i++) {
        LiveFriendModel liveFriendModel = this.g.get(i);
        if (i == 0)
          if (!TextUtils.isEmpty(liveFriendModel.uid)) {
            this.j.bI.setVisibility(0);
            this.j.bI.setText(liveFriendModel.name);
            this.j.bz.setVisibility(8);
          } else {
            this.j.bI.setVisibility(8);
            if (this.j.bz.getVisibility() == 8)
              this.j.bz.setVisibility(0); 
          }  
        if (i == 1)
          if (!TextUtils.isEmpty(liveFriendModel.uid)) {
            this.j.bJ.setVisibility(0);
            this.j.bJ.setText(liveFriendModel.name);
            this.j.bA.setVisibility(8);
          } else {
            this.j.bJ.setVisibility(8);
            if (this.j.bA.getVisibility() == 8)
              this.j.bA.setVisibility(0); 
          }  
        if (i == 2)
          if (!TextUtils.isEmpty(liveFriendModel.uid)) {
            this.j.bH.setVisibility(0);
            this.j.bH.setText(liveFriendModel.name);
            this.j.by.setVisibility(8);
          } else {
            this.j.bH.setVisibility(8);
            if (this.j.by.getVisibility() == 8)
              this.j.by.setVisibility(0); 
          }  
      }  
  }
  
  public void a(boolean paramBoolean, int paramInt) {
    if (paramBoolean) {
      if (!LiveRoomManager.a().l()) {
        LiveSetDataObserver.a().e(LiveRoomManager.a().e());
        return;
      } 
    } else if (this.g.size() > paramInt) {
      LiveFriendModel liveFriendModel = this.g.get(paramInt);
      if (!TextUtils.isEmpty(liveFriendModel.uid)) {
        if (TextUtils.equals(liveFriendModel.uid, LiveRoomInfo.a().f())) {
          this.j.bO.a(1);
          this.j.bO.e();
          return;
        } 
        LiveSetDataObserver.a().e(liveFriendModel.uid);
        return;
      } 
      LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("点击空白小窗，当前状态为：");
      stringBuilder.append(this.j.A());
      liveMsgSendManager.b(stringBuilder.toString());
      if (!this.j.aE())
        this.j.q.performClick(); 
    } 
  }
  
  public void b() {
    if (this.j.aE()) {
      if (this.j.F != null)
        this.j.F.h(); 
      this.j.ac();
    } 
    if (!this.j.bO.a())
      this.j.aT(); 
    this.j.b_(0);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.j.aG.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    LiveFloatManager.a().a(AppInfo.l, this.j.aZ());
    layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    this.j.H.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.j.ad();
    this.j.bk.setVisibility(8);
    this.j.bl.setVisibility(8);
    this.j.bm.setVisibility(8);
    this.j.bn.setVisibility(8);
    this.j.br.setVisibility(8);
    this.j.bs.setVisibility(8);
    this.j.bt.setVisibility(8);
    this.j.bq.setVisibility(8);
    this.j.by.setVisibility(8);
    this.j.bz.setVisibility(8);
    this.j.bA.setVisibility(8);
    this.j.bR.setVisibility(8);
    this.g.clear();
  }
  
  public void c() {
    if (!this.j.bO.a())
      this.j.aT(); 
    if (this.j.F != null)
      this.j.F.h(); 
    this.j.b_(5);
    this.j.ac();
    this.j.bk.setVisibility(8);
    this.j.bl.setVisibility(8);
    this.j.bm.setVisibility(8);
    this.j.bn.setVisibility(8);
    this.j.bw.setVisibility(8);
    this.j.bx.setVisibility(8);
    this.j.bu.setVisibility(8);
    this.j.q.a(1);
    this.j.bP.setState(0);
  }
  
  public void d() {
    LiveSetDataObserver.a().b();
  }
  
  public void e() {}
  
  public void f() {
    BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this, (IRequestHost)this.j.w_()) {
        public void onUIUpdate(BluedEntity param1BluedEntity) {
          PlayingMakeFriendManager.a(this.a).af();
        }
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.j.u);
    stringBuilder.append("");
    LiveRoomHttpUtils.b(bluedUIHttpResponse, stringBuilder.toString(), "");
  }
  
  public void g() {
    if (this.j.aE())
      f(); 
  }
  
  public void h() {
    int i = this.h;
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
          return; 
        this.j.bB.setVisibility(8);
        return;
      } 
      this.j.bD.setVisibility(8);
      return;
    } 
    this.j.bC.setVisibility(8);
  }
  
  public void i() {
    if (this.h != 1);
  }
  
  public void j() {
    Log.i("==mic", "make friend manager destroy");
    this.l = true;
    this.e = false;
  }
  
  public void k() {
    if (this.l) {
      Log.i("==mic", "startSpeaking hasDestroy");
      return;
    } 
    this.e = true;
    this.f++;
    if (this.j.F != null)
      this.j.F.b(this.e, this.f); 
  }
  
  public void l() {
    if (this.l) {
      Log.i("==mic", "stopSpeaking hasDestroy");
      return;
    } 
    if (!this.e)
      return; 
    Log.i("==mic", "stopSpeaking");
    this.e = false;
    this.f = 0;
    if (this.j.F != null)
      this.j.F.b(this.e, this.f); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\PlayingMakeFriendManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */