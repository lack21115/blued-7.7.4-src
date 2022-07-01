package com.blued.android.module.live_china.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.blued.android.chat.data.BadgeData;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveHornModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.msg.SendMsgListener;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.List;

public class PlayingOnliveSimpleModeFragment extends PlayingOnliveBaseModeFragment {
  public static PlayingOnliveSimpleModeFragment a(short paramShort, long paramLong) {
    return new PlayingOnliveSimpleModeFragment();
  }
  
  public void G() {
    super.G();
    this.m.setVisibility(0);
    this.f.setVisibility(0);
    this.w.c(0);
    this.s.setVisibility(0);
  }
  
  public void I() {
    if (PlayingOnliveFragment.co == 1 && !this.B)
      a(new Runnable(this) {
            public void run() {
              this.a.J();
            }
          }); 
  }
  
  public void L() {
    if (PlayingOnliveFragment.co == 1) {
      LiveMsgSendManager.a().e();
      LiveRoomHttpUtils.a(String.valueOf(this.y));
    } 
  }
  
  public void P() {
    super.P();
    if (PlayingOnliveFragment.co == 1 && !LiveRoomManager.a().l()) {
      LiveRoomInfo liveRoomInfo = LiveRoomInfo.a();
      Context context = this.d;
      String str = LiveRoomManager.a().e();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("liveanchor_");
      stringBuilder.append(this.y);
      liveRoomInfo.a(context, this, str, stringBuilder.toString(), (IRequestHost)w_());
    } 
  }
  
  public void a(EditText paramEditText) {
    super.a(paramEditText);
    if (PlayingOnliveFragment.co == 1)
      LiveMsgSendManager.a().a(paramEditText.getText().toString(), new SendMsgListener(this, paramEditText) {
            public void a() {
              this.a.setText("");
            }
            
            public void b() {}
          }); 
  }
  
  public void a(ChattingModel paramChattingModel) {
    if (PlayingOnliveFragment.co == 1)
      this.w.c(paramChattingModel); 
  }
  
  public void a(LiveGiftModel paramLiveGiftModel) {
    if (PlayingOnliveFragment.co == 1)
      this.w.d(paramLiveGiftModel); 
  }
  
  public void a(LiveHornModel paramLiveHornModel, boolean paramBoolean) {
    super.a(paramLiveHornModel, paramBoolean);
    if (PlayingOnliveFragment.co == 1 && this.s != null)
      this.s.a(paramLiveHornModel, paramBoolean); 
  }
  
  public void a(List<BadgeData> paramList) {}
  
  public void a(boolean paramBoolean) {
    super.a(paramBoolean);
    this.w.c(0);
    this.m.setVisibility(8);
    this.f.setVisibility(8);
    this.r.setVisibility(8);
    this.s.setVisibility(8);
  }
  
  public void b(ChattingModel paramChattingModel) {
    int i = PlayingOnliveFragment.co;
  }
  
  public void b(boolean paramBoolean) {
    if (PlayingOnliveFragment.co == 1)
      this.w.c(paramBoolean); 
  }
  
  public void e(String paramString) {
    super.e(paramString);
    if (PlayingOnliveFragment.co == 1)
      LiveMsgSendManager.a().a(paramString); 
  }
  
  public void f(String paramString) {
    super.f(paramString);
    if (TextUtils.isEmpty(paramString))
      return; 
    if (PlayingOnliveFragment.co == 1) {
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
            }
          },  500L);
    } 
  }
  
  protected boolean k() {
    return (PlayingOnliveFragment.co == 1);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.al = true;
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.w.a(8);
    this.q.setVisibility(4);
    if (this.w.l != null)
      this.w.l.setVisibility(8); 
    this.g.setVisibility(0);
    this.k.setVisibility(8);
    this.h.setMaxWidth(DensityUtils.a(this.d, 110.0F));
    this.r.setVisibility(8);
    this.w.c(false);
    this.C.setVisibility(8);
    this.aE.setVisibility(8);
    if (this.aQ != null)
      this.aQ.setIsSimpleModel(true); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\PlayingOnliveSimpleModeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */