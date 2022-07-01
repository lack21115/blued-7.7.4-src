package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.List;

public class PlayingMakeLoverManager extends MakeLoverBaseManager {
  public static int b = 0;
  
  public static int c = 0;
  
  public static int d = 0;
  
  public static int e = 0;
  
  public static double f = 1.0D;
  
  public boolean g;
  
  public int h;
  
  public String i;
  
  Object j;
  
  public int k;
  
  private Context l;
  
  private PlayingOnliveFragment m;
  
  private boolean n;
  
  private int o;
  
  public PlayingMakeLoverManager(PlayingOnliveFragment paramPlayingOnliveFragment) {
    int i;
    this.g = false;
    this.h = 0;
    this.i = "";
    this.n = false;
    this.j = new Object();
    this.m = paramPlayingOnliveFragment;
    this.l = paramPlayingOnliveFragment.getContext();
    this.o = DensityUtils.a(this.l, 1.0F);
    b = AppInfo.l / 3;
    c = (int)(b * f);
    d = DensityUtils.a(this.l, '');
    if (StatusBarHelper.a()) {
      i = d - StatusBarHelper.a((Context)paramPlayingOnliveFragment.getActivity());
    } else {
      i = d;
    } 
    e = i;
    this.i = AvatarUtils.a(0, LiveRoomInfo.a().e());
  }
  
  public void a(LiveMakeLoverFansModel paramLiveMakeLoverFansModel) {
    if (this.m.aG())
      return; 
    Log.i("==makelover==", "joinMakeLover");
    this.m.b_(9);
    this.m.bL.setVisibility(8);
    LiveSetDataObserver.a().a(paramLiveMakeLoverFansModel);
    (LiveFloatManager.a()).b.setVisibility(8);
    LiveFloatManager.a().h();
    PlayingOnliveFragment playingOnliveFragment = this.m;
    playingOnliveFragment.aJ = true;
    playingOnliveFragment.aN.setRTCModel(this.m.aJ);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, c * 2);
    layoutParams.setMargins(0, d, 0, 0);
    this.m.aG.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    b(paramLiveMakeLoverFansModel.index);
    this.k = paramLiveMakeLoverFansModel.index;
    i();
    this.m.a(JoinLiveResult.SUCCESS, paramLiveMakeLoverFansModel.conference_id, "", paramLiveMakeLoverFansModel.stream, "", paramLiveMakeLoverFansModel.index);
  }
  
  public void a(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("updatePhotoPushUrl:");
    stringBuilder.append(paramString1);
    stringBuilder.append(" netUrl:");
    stringBuilder.append(paramString2);
    stringBuilder.append("  photo:");
    stringBuilder.append(paramString3);
    Log.i("==makelover==", stringBuilder.toString());
    a(paramString1, paramString2);
    if (this.m.F != null)
      this.m.F.c(paramString3); 
  }
  
  public void a(boolean paramBoolean) {
    LiveRoomHttpUtils.a(String.valueOf(this.m.u), new BluedUIHttpResponse(this, (IRequestHost)this.m.w_(), paramBoolean) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            if (this.a) {
              LiveFloatManager.a().b(false);
              LiveFloatManager.a().n();
              PlayingMakeLoverManager.a(this.b).aa();
              return;
            } 
            PlayingMakeLoverManager.a(this.b).ah();
          }
        });
  }
  
  public void a(boolean paramBoolean, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onMakeLoverWindowClick isHost:");
    stringBuilder.append(paramBoolean);
    stringBuilder.append(" index:");
    stringBuilder.append(paramInt);
    Log.i("==makelover==", stringBuilder.toString());
    if (paramBoolean) {
      EventTrackLive.b(LiveProtos.Event.USER_MIKE_USER_PHOTO_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e(), LiveRoomManager.a().e());
      if (!LiveRoomManager.a().l()) {
        LiveSetDataObserver.a().e(LiveRoomManager.a().e());
        return;
      } 
    } else if (this.a.size() > paramInt) {
      LiveMakeLoverFansModel liveMakeLoverFansModel = this.a.get(paramInt);
      if (liveMakeLoverFansModel != null && !liveMakeLoverFansModel.isEmpty()) {
        EventTrackLive.b(LiveProtos.Event.USER_MIKE_USER_PHOTO_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e(), liveMakeLoverFansModel.uid);
        this.m.bK.a(paramInt);
        LiveSetDataObserver.a().e(liveMakeLoverFansModel.uid);
        return;
      } 
      LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("点击空白小窗，当前状态为：");
      stringBuilder1.append(this.m.A());
      liveMsgSendManager.b(stringBuilder1.toString());
      if (!this.m.aG())
        this.m.bL.performClick(); 
    } 
  }
  
  public void b(int paramInt) {
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(b, c);
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b, c);
    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(b, c);
    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(b, c);
    FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(b, c);
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          if (paramInt != 4) {
            if (paramInt == 5) {
              int i = d;
              paramInt = c;
              layoutParams5.topMargin = i + paramInt;
              i = b;
              layoutParams5.leftMargin = i * 2;
              layoutParams1.leftMargin = i;
              layoutParams2.leftMargin = i * 2;
              layoutParams3.topMargin = paramInt;
              layoutParams4.leftMargin = i;
              layoutParams4.topMargin = paramInt;
              this.m.bK.k.setVisibility(8);
            } 
          } else {
            int i = d;
            paramInt = c;
            layoutParams5.topMargin = i + paramInt;
            i = b;
            layoutParams5.leftMargin = i;
            layoutParams1.leftMargin = i;
            layoutParams2.leftMargin = i * 2;
            layoutParams3.topMargin = paramInt;
            layoutParams4.leftMargin = i * 2;
            layoutParams4.topMargin = paramInt;
            this.m.bK.j.setVisibility(8);
          } 
        } else {
          int i = d;
          paramInt = c;
          layoutParams5.topMargin = i + paramInt;
          i = b;
          layoutParams1.leftMargin = i;
          layoutParams2.leftMargin = i * 2;
          layoutParams3.leftMargin = i;
          layoutParams3.topMargin = paramInt;
          layoutParams4.leftMargin = i * 2;
          layoutParams4.topMargin = paramInt;
          this.m.bK.i.setVisibility(8);
        } 
      } else {
        layoutParams5.topMargin = d;
        paramInt = b;
        layoutParams5.leftMargin = paramInt * 2;
        layoutParams1.leftMargin = paramInt;
        int i = c;
        layoutParams2.topMargin = i;
        layoutParams3.leftMargin = paramInt;
        layoutParams3.topMargin = i;
        layoutParams4.leftMargin = paramInt * 2;
        layoutParams4.topMargin = i;
        this.m.bK.h.setVisibility(8);
      } 
    } else {
      paramInt = b;
      layoutParams5.leftMargin = paramInt;
      layoutParams5.topMargin = d;
      layoutParams1.leftMargin = paramInt * 2;
      int i = c;
      layoutParams2.topMargin = i;
      layoutParams3.leftMargin = paramInt;
      layoutParams3.topMargin = i;
      layoutParams4.leftMargin = paramInt * 2;
      layoutParams4.topMargin = i;
      this.m.bK.g.setVisibility(8);
    } 
    this.m.Z.setLayoutParams((ViewGroup.LayoutParams)layoutParams5);
    this.m.bm.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.m.bn.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.m.bo.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    this.m.bp.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
    this.m.bl.setVisibility(0);
    this.m.bm.setVisibility(0);
    this.m.bn.setVisibility(0);
    this.m.bo.setVisibility(0);
    this.m.bp.setVisibility(0);
    this.m.Z.setVisibility(0);
  }
  
  public void b(List<LiveMakeLoverFansModel> paramList) {
    if (paramList == null)
      return; 
    a(paramList);
    h();
  }
  
  public void d(String paramString) {
    b(paramString);
    h();
  }
  
  public void f() {
    if (this.m.aF())
      return; 
    Log.i("==makelover==", "startMakeLover");
    this.m.b_(8);
    LiveMakeLoverManager.a(1);
    this.m.bL.setVisibility(0);
    LiveSetDataObserver.a().e();
    this.m.aU.g();
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, c * 2);
    layoutParams1.setMargins(0, d, 0, 0);
    this.m.aG.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    layoutParams1 = new FrameLayout.LayoutParams(-1, -1);
    layoutParams1.setMargins(0, d, 0, 0);
    this.m.bK.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    layoutParams1 = new FrameLayout.LayoutParams(b, c);
    this.m.bl.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.m.ac.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.m.ad.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.m.ae.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.m.af.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.m.ag.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.m.ab.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    layoutParams1 = new FrameLayout.LayoutParams(b, c);
    int i = b;
    layoutParams1.leftMargin = i - this.o;
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, c);
    i = b;
    layoutParams2.leftMargin = i * 2 - this.o;
    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, c);
    i = c;
    layoutParams3.topMargin = i;
    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(b, i);
    i = c;
    layoutParams4.topMargin = i - this.o;
    int j = b;
    layoutParams4.leftMargin = j;
    FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(j, i);
    layoutParams5.leftMargin = b * 2 - this.o;
    layoutParams5.topMargin = c;
    this.m.bK.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.m.bK.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.m.bK.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    this.m.bK.e.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
    this.m.bK.f.setLayoutParams((ViewGroup.LayoutParams)layoutParams5);
    this.m.bK.a.setVisibility(0);
    this.m.bK.g.setVisibility(0);
    this.m.bK.h.setVisibility(0);
    this.m.bK.i.setVisibility(0);
    this.m.bK.j.setVisibility(0);
    this.m.bK.k.setVisibility(0);
    this.m.bK.l.setVisibility(8);
    this.m.bK.m.setVisibility(8);
    this.m.bK.n.setVisibility(8);
    this.m.bK.o.setVisibility(8);
    this.m.bK.p.setVisibility(8);
    this.m.bK.v.setVisibility(8);
    this.m.bK.w.setVisibility(8);
    this.m.bK.x.setVisibility(8);
    this.m.bK.y.setVisibility(8);
    this.m.bK.z.setVisibility(8);
    this.m.bK.F.setVisibility(8);
    this.m.bK.G.setVisibility(8);
    this.m.bK.H.setVisibility(8);
    this.m.bK.I.setVisibility(8);
    this.m.bK.J.setVisibility(8);
    ImageFileLoader.a(null).a(this.i).a();
    if ((LiveRoomManager.a().h()).matchmaking != null && (LiveRoomManager.a().h()).matchmaking.fans != null)
      b((LiveRoomManager.a().h()).matchmaking.fans); 
  }
  
  public void g() {
    if (!this.m.aG())
      return; 
    Log.i("==makelover==", "exitMakeLover");
    this.m.b_(8);
    this.m.bL.setVisibility(0);
    if (this.m.F != null)
      this.m.F.h(); 
    LiveSetDataObserver.a().f();
    this.m.ac();
    this.m.bl.setVisibility(8);
    this.m.bm.setVisibility(8);
    this.m.bn.setVisibility(8);
    this.m.bo.setVisibility(8);
    this.m.bp.setVisibility(8);
    LiveMakeLoverManager.a(1);
  }
  
  public void h() {
    if (this.a != null)
      for (int i = 0; i < this.a.size(); i++) {
        LiveMakeLoverFansModel liveMakeLoverFansModel = this.a.get(i);
        if (i == 0)
          if (!liveMakeLoverFansModel.isEmpty()) {
            this.m.bK.g.setVisibility(8);
          } else if (this.m.bK.g.getVisibility() == 8) {
            this.m.bK.g.setVisibility(0);
          }  
        if (i == 1)
          if (!liveMakeLoverFansModel.isEmpty()) {
            this.m.bK.h.setVisibility(8);
          } else if (this.m.bK.h.getVisibility() == 8) {
            this.m.bK.h.setVisibility(0);
          }  
        if (i == 2)
          if (!liveMakeLoverFansModel.isEmpty()) {
            this.m.bK.i.setVisibility(8);
          } else if (this.m.bK.i.getVisibility() == 8) {
            this.m.bK.i.setVisibility(0);
          }  
        if (i == 3)
          if (!liveMakeLoverFansModel.isEmpty()) {
            this.m.bK.j.setVisibility(8);
          } else if (this.m.bK.j.getVisibility() == 8) {
            this.m.bK.j.setVisibility(0);
          }  
        if (i == 4)
          if (!liveMakeLoverFansModel.isEmpty()) {
            this.m.bK.k.setVisibility(8);
          } else if (this.m.bK.k.getVisibility() == 8) {
            this.m.bK.k.setVisibility(0);
          }  
      }  
    this.m.bK.a();
  }
  
  public void i() {}
  
  public void j() {
    if (LiveMakeLoverManager.b())
      LiveRoomHttpUtils.u(null, String.valueOf(this.m.u)); 
    if (this.m.aG())
      a(false); 
  }
  
  public void k() {
    Log.i("==makelover==", "make lover manager destroy");
    this.n = true;
    this.g = false;
  }
  
  public void l() {
    if (this.n) {
      Log.i("==record==", "startSpeaking hasDestroy");
      return;
    } 
    this.g = true;
    this.h++;
    if (this.m.F != null)
      this.m.F.a(this.g, this.h); 
  }
  
  public void m() {
    if (this.n)
      return; 
    if (!this.g)
      return; 
    Log.i("==record", "stopSpeaking");
    this.g = false;
    this.h = 0;
    if (this.m.F != null)
      this.m.F.a(this.g, this.h); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\PlayingMakeLoverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */