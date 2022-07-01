package com.blued.android.module.live_china.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.chat.data.BadgeData;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveHornModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.RankingExtra;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.msg.SendMsgListener;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.view.MedalView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;

public class PlayingOnliveFullModeFragment extends PlayingOnliveBaseModeFragment {
  public static PlayingOnliveFullModeFragment a(short paramShort, long paramLong) {
    return new PlayingOnliveFullModeFragment();
  }
  
  private void af() {
    LiveEventBus.get("live_ranking_msg", RankingExtra.class).observe((LifecycleOwner)this, new Observer<RankingExtra>(this) {
          public void a(RankingExtra param1RankingExtra) {
            if (LiveRoomManager.a().h() == null)
              return; 
            (LiveRoomManager.a().h()).rankingExtra = param1RankingExtra;
            if (this.a.aQ == null)
              return; 
            this.a.aQ.setValue(param1RankingExtra);
          }
        });
    LiveEventBus.get(LiveEventBusUtil.b, ChattingModel.class).observe((LifecycleOwner)this, new -$$Lambda$PlayingOnliveFullModeFragment$L3DHXmk2_6eJr8yzhvT3uXt6NM0(this));
    LiveEventBus.get(LiveEventBusUtil.g, Boolean.class).observe((LifecycleOwner)this, new -$$Lambda$PlayingOnliveFullModeFragment$p19QVAWIuqVZ_mKLpHo0Iu1Xpcs(this));
  }
  
  private void e(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("firstChargeSuccessAnim:");
    stringBuilder.append(paramBoolean);
    LogUtils.c(stringBuilder.toString());
    if (paramBoolean) {
      this.T.setVisibility(4);
      return;
    } 
    this.T.setVisibility(0);
  }
  
  public void G() {
    super.G();
    this.w.l();
    this.q.c();
    this.m.setVisibility(0);
    this.f.setVisibility(0);
    this.w.c(0);
    this.s.setVisibility(0);
    this.aE.setVisibility(0);
  }
  
  public void I() {
    if (PlayingOnliveFragment.co == 0 && !this.B)
      a(new Runnable(this) {
            public void run() {
              this.a.J();
            }
          }); 
  }
  
  public void K() {
    LiveRoomData liveRoomData = LiveRoomManager.a().h();
    byte b = 8;
    if (liveRoomData != null && (LiveRoomManager.a().h()).badges != null) {
      MedalView medalView = this.r;
      if ((LiveRoomManager.a().h()).badges.size() > 0)
        b = 0; 
      medalView.setVisibility(b);
      return;
    } 
    this.r.setVisibility(8);
  }
  
  public void L() {
    if (PlayingOnliveFragment.co == 0) {
      LiveMsgSendManager.a().e();
      LiveRoomHttpUtils.a(String.valueOf(this.y));
    } 
  }
  
  public void P() {
    super.P();
    if (PlayingOnliveFragment.co == 0 && !LiveRoomManager.a().l()) {
      LiveRoomInfo liveRoomInfo = LiveRoomInfo.a();
      Context context = this.d;
      String str = LiveRoomManager.a().e();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("liveanchor_");
      stringBuilder.append(this.y);
      liveRoomInfo.a(context, this, str, stringBuilder.toString(), (IRequestHost)w_());
    } 
  }
  
  public void a(int paramInt) {
    if (paramInt < 30)
      return; 
    if (paramInt >= 90) {
      this.aI.setImageResource(R.drawable.live_anchor_head_bg_90);
    } else if (paramInt >= 60) {
      this.aI.setImageResource(R.drawable.live_anchor_head_bg_60);
    } else if (paramInt >= 30) {
      this.aI.setImageResource(R.drawable.live_anchor_head_bg_30);
    } 
    this.aI.setVisibility(0);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.aH.getLayoutParams();
    layoutParams.leftMargin = DensityUtils.a(this.d, 6.0F);
    this.aH.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = (FrameLayout.LayoutParams)this.s.getLayoutParams();
    layoutParams.topMargin = DensityUtils.a(this.d, 54.0F);
    this.s.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void a(EditText paramEditText) {
    super.a(paramEditText);
    LiveMsgSendManager.a().a(paramEditText.getText().toString(), new SendMsgListener(this, paramEditText) {
          public void a() {
            this.a.setText("");
          }
          
          public void b() {}
        });
  }
  
  public void a(ChattingModel paramChattingModel) {
    if (PlayingOnliveFragment.co == 0)
      this.w.c(paramChattingModel); 
  }
  
  public void a(LiveGiftModel paramLiveGiftModel) {
    if (PlayingOnliveFragment.co == 0)
      this.w.d(paramLiveGiftModel); 
  }
  
  public void a(LiveHornModel paramLiveHornModel, boolean paramBoolean) {
    super.a(paramLiveHornModel, paramBoolean);
    if (PlayingOnliveFragment.co == 0 && this.s != null)
      this.s.a(paramLiveHornModel, paramBoolean); 
  }
  
  public void a(LiveRoomUserModel paramLiveRoomUserModel) {
    if (this.w != null)
      this.w.a(paramLiveRoomUserModel); 
  }
  
  public void a(String paramString, int paramInt) {
    if (this.w != null)
      this.w.a(paramString, paramInt); 
  }
  
  public void a(String paramString1, String paramString2) {
    if (this.aE == null)
      return; 
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
      this.aE.setVisibility(0);
      ImageLoader.a((IRequestHost)w_(), paramString1).a(this.aF);
      this.aE.setOnClickListener(new View.OnClickListener(this, paramString2) {
            public void onClick(View param1View) {
              LiveBottomWebDialogFragment.a((Context)this.b.getActivity(), this.b.getFragmentManager(), this.a);
            }
          });
      return;
    } 
    this.aE.setVisibility(8);
  }
  
  public void a(List<BadgeData> paramList) {
    if (ac()) {
      this.r.setVisibility(8);
      return;
    } 
    if (paramList != null) {
      if (paramList.size() > 0) {
        this.r.setVisibility(0);
      } else {
        this.r.setVisibility(8);
      } 
    } else {
      this.r.setVisibility(8);
    } 
    this.r.setMedalData(paramList);
  }
  
  public void a(boolean paramBoolean) {
    super.a(paramBoolean);
    this.w.k();
    this.q.b();
    this.w.c(8);
    this.m.setVisibility(8);
    this.f.setVisibility(8);
    this.r.setVisibility(8);
    this.s.setVisibility(8);
    this.aE.setVisibility(8);
  }
  
  public void a_(String paramString) {
    if (this.w != null)
      this.w.b(paramString); 
  }
  
  public void b(int paramInt) {
    this.w.a(paramInt);
  }
  
  public void b(ChattingModel paramChattingModel) {
    if (PlayingOnliveFragment.co == 0)
      this.w.d(paramChattingModel); 
  }
  
  public void e(String paramString) {
    super.e(paramString);
    if (PlayingOnliveFragment.co == 0)
      LiveMsgSendManager.a().a(paramString); 
  }
  
  public void f(String paramString) {
    super.f(paramString);
    Logger.a("rrb", new Object[] { "setReplyClick name = ", paramString });
    if (TextUtils.isEmpty(paramString))
      return; 
    if (PlayingOnliveFragment.co == 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.V.getText().toString());
      stringBuilder.append("@");
      stringBuilder.append(paramString);
      stringBuilder.append(" ");
      paramString = stringBuilder.toString();
      int i = paramString.length();
      this.V.setText(paramString);
      this.V.setSelection(i);
      a(new Runnable(this) {
            public void run() {
              if (this.a.V != null) {
                this.a.V.setFocusableInTouchMode(true);
                this.a.V.requestFocus();
              } 
              KeyboardUtils.c((Activity)this.a.getActivity());
              Logger.a("rrb", new Object[] { "setReplyClick end" });
            }
          }500L);
    } 
  }
  
  protected boolean k() {
    return (PlayingOnliveFragment.co == 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.al = false;
    af();
    View view = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    Z();
    aa();
    LiveEventBus.get("live_msg_daily_task_complete", Integer.class).observe((LifecycleOwner)this, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            if (this.a.w != null)
              this.a.w.b(param1Integer.intValue()); 
          }
        });
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    ab();
  }
  
  public void x() {
    if (this.w != null)
      this.w.e(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\PlayingOnliveFullModeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */