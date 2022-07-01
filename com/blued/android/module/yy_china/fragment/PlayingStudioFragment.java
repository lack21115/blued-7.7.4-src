package com.blued.android.module.yy_china.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMsgKickInfoExtra;
import com.blued.android.module.yy_china.model.YYReportModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.model.YYAudioConfig;
import com.blued.android.module.yy_china.trtc_audio.permission.PermissionHelper;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYBroadcastView;
import com.blued.android.module.yy_china.view.YYLateAcceptView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class PlayingStudioFragment extends BaseYYStudioFragment {
  private boolean B = false;
  
  private void V() {
    if (YYRoomInfoManager.d().b() == null)
      return; 
    YYRoomHttpUtils.c((YYRoomInfoManager.d().b()).room_id, 0, new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            YYImModel yYImModel = new YYImModel();
            yYImModel.type = -2;
            yYImModel.contents = this.a.getResources().getString(R.string.yy_msg_apply_mic);
            YYImMsgManager.a().f(yYImModel);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (param1Int == 40380002) {
              ToastUtils.a("房间已关闭", 0);
              PlayingStudioFragment.a(this.a, true);
              this.a.P();
            } 
            return super.onUIFailure(param1Int, param1String);
          }
        }(IRequestHost)w_());
  }
  
  private void W() {
    if (getContext() == null)
      return; 
    LiveAlterDialog.a(getContext(), R.layout.dialog_invite_layout, new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel == null)
              return; 
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_REFUSE_CLICK, yYRoomModel.room_id, yYRoomModel.uid);
            YYRoomHttpUtils.e(yYRoomModel.room_id, 0, PlayingStudioFragment.d(this.a), (IRequestHost)this.a.w_());
          }
        }new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel == null)
              return; 
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_ACCEPT_CLICK, yYRoomModel.room_id, yYRoomModel.uid);
            YYRoomHttpUtils.e(yYRoomModel.room_id, 1, PlayingStudioFragment.d(this.a), (IRequestHost)this.a.w_());
          }
        }true, false);
  }
  
  private BluedUIHttpResponse X() {
    return new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)w_()) {
        protected void a(BluedEntityA<Object> param1BluedEntityA) {}
      };
  }
  
  private void a(YYMsgKickInfoExtra paramYYMsgKickInfoExtra) {
    if (paramYYMsgKickInfoExtra != null) {
      if (TextUtils.isEmpty(paramYYMsgKickInfoExtra.audience_message))
        return; 
      a(new Runnable(this, paramYYMsgKickInfoExtra) {
            public void run() {
              YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
              if (yYRoomModel != null)
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_USER_OUT_MIKE_TOAST_SHOW, yYRoomModel.room_id, yYRoomModel.uid); 
              View view = LayoutInflater.from(this.b.getContext()).inflate(R.layout.dialog_warning_layout, null);
              TextView textView = (TextView)view.findViewById(R.id.tv_warn_title);
              ((TextView)view.findViewById(R.id.tv_warn)).setText(this.a.audience_message);
              textView.setText(this.a.title);
              LiveAlterDialog.a(this.b.getContext(), view, null, new View.OnClickListener(this) {
                    public void onClick(View param2View) {
                      this.a.b.getActivity().finish();
                    }
                  },  false, true);
            }
          }300L);
    } 
  }
  
  private void d(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    I();
    YYRoomHttpUtils.d(paramString, new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)w_()) {
          Dialog a = null;
          
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            this.b.S();
            if (PlayingStudioFragment.a(this.b)) {
              YYRoomInfoManager.d().l();
              this.b.getActivity().finish();
              return;
            } 
            this.b.s.a(this.b);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            DialogUtils.b(this.a);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            DialogUtils.b(this.a);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a = DialogUtils.a(this.b.getContext());
            DialogUtils.a(this.a);
          }
        }(IRequestHost)w_());
  }
  
  public void J() {
    LiveEventBus.get("invite_seat_msg", YYAudienceModel.class).observe((LifecycleOwner)this, new Observer<YYAudienceModel>(this) {
          public void a(YYAudienceModel param1YYAudienceModel) {
            if (YYRoomInfoManager.d().c().a(this.a.getContext(), null))
              return; 
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel != null)
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_INVITE_POP_SHOW, yYRoomModel.room_id, yYRoomModel.uid); 
            PermissionHelper.a(new PermissionCallbacks(this) {
                  public void a(String[] param2ArrayOfString) {
                    AppMethods.a("麦克风已被禁用，请在设置中授权麦克风使用");
                  }
                  
                  public void aa_() {
                    PlayingStudioFragment.b(this.a.a);
                  }
                });
          }
        });
    LiveEventBus.get("close_living_room", YYMsgKickInfoExtra.class).observe((LifecycleOwner)this, new Observer<YYMsgKickInfoExtra>(this) {
          public void a(YYMsgKickInfoExtra param1YYMsgKickInfoExtra) {
            if (param1YYMsgKickInfoExtra == null) {
              ToastUtils.a("你被房主移出了房间", 0);
              YYRoomInfoManager.d().l();
              this.a.getActivity().finish();
              return;
            } 
            PlayingStudioFragment.a(this.a, false);
            this.a.P();
            PlayingStudioFragment.a(this.a, param1YYMsgKickInfoExtra);
          }
        });
    LiveEventBus.get("late_accept_msg", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            (new YYLateAcceptView(this.a.getContext())).a(this.a);
          }
        });
    LiveEventBus.get("send_apply_reject", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel != null)
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_MIKE_REFUSE_SHOW, yYRoomModel.room_id, yYRoomModel.uid); 
          }
        });
    LiveEventBus.get("down_seat_msg", YYAudienceModel.class).observe((LifecycleOwner)this, new Observer<YYAudienceModel>(this) {
          public void a(YYAudienceModel param1YYAudienceModel) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (param1YYAudienceModel != null && yYRoomModel != null && TextUtils.equals(param1YYAudienceModel.getUid(), YYRoomInfoManager.d().e()))
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_USER_OUT_MIKE_TOAST_SHOW, yYRoomModel.room_id, yYRoomModel.uid, param1YYAudienceModel.getUid()); 
          }
        });
    LiveEventBus.get("set_mute_status", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            if (TextUtils.equals("1", param1String)) {
              param1String = "你已被禁言，本场不可在公屏发言";
            } else {
              param1String = "你已被解除禁言，恢复公屏发言权限";
            } 
            ToastUtils.a(param1String, 0);
          }
        });
  }
  
  public void K() {
    this.B = true;
    a(getResources().getString(R.string.yy_leave_room), false);
  }
  
  public void L() {}
  
  public void M() {
    this.u.setVisibility(8);
    a(new Runnable(this) {
          public void run() {
            if (this.a.z)
              return; 
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel == null)
              return; 
            if (!TextUtils.equals(yYRoomModel.relationship, "1")) {
              if (TextUtils.equals(yYRoomModel.relationship, "3"))
                return; 
              YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
              if (yYUserInfo == null)
                return; 
              String str1 = yYUserInfo.getUid();
              String str2 = yYUserInfo.getName();
              String str3 = yYUserInfo.getAvatar();
              YYImMsgManager.a().b(str1, str2, str3);
            } 
          }
        }60000L);
    a(new Runnable(this) {
          public void run() {
            if (this.a.z)
              return; 
            YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
            if (yYUserInfo == null)
              return; 
            String str1 = yYUserInfo.getUid();
            String str2 = yYUserInfo.getName();
            String str3 = yYUserInfo.getAvatar();
            if (yYUserInfo.isSendGift)
              return; 
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel != null)
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_SEND_GIFT_SHOW, yYRoomModel.room_id, yYRoomModel.uid); 
            YYImMsgManager.a().c(str1, str2, str3);
          }
        }300000L);
  }
  
  protected void N() {
    this.p.setVisibility(8);
    this.t.setVisibility(8);
    this.f.a(false);
    YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
    if (yYUserInfo == null || !TextUtils.equals(yYUserInfo.is_mic, "1")) {
      this.o.a(true);
    } else {
      this.o.a(false);
    } 
    this.v.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel != null)
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_REPORT_ROOM_CLICK, yYRoomModel.room_id, yYRoomModel.uid); 
            YYReportModel yYReportModel = new YYReportModel();
            this.a.a(yYReportModel, 1);
          }
        });
  }
  
  public int O() {
    return ((YYRoomInfoManager.d()).a == null) ? 0 : StringUtils.a((YYRoomInfoManager.d()).a.chat_anchor, 0);
  }
  
  public void P() {
    LiveEventBus.get("dialog_cancel_event").post("");
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null) {
      YYRoomInfoManager.d().l();
      getActivity().finish();
      return;
    } 
    d(yYRoomModel.room_id);
  }
  
  public void Q() {
    YYBroadcastView yYBroadcastView = new YYBroadcastView(getContext());
    yYBroadcastView.a(R.drawable.shape_raduis_12_151515);
    yYBroadcastView.b(true);
    yYBroadcastView.a(false);
    yYBroadcastView.setEditable(false);
    yYBroadcastView.setContentMinHeight(DensityUtils.a(getContext(), 190.0F));
    yYBroadcastView.a(this);
    yYBroadcastView.getBroadcastContent();
    a((View)yYBroadcastView, AppInfo.l - DensityUtils.a(getContext(), 60.0F), -2, 17);
  }
  
  public void R() {
    byte b;
    if (this.z) {
      AudioChannelManager.e().a(T());
      return;
    } 
    if (YYRoomInfoManager.d().b() == null)
      return; 
    YYAudioConfig yYAudioConfig = new YYAudioConfig();
    yYAudioConfig.c = YYRoomInfoManager.d().e();
    yYAudioConfig.b = (YYRoomInfoManager.d().b()).room_id;
    if ((YYRoomInfoManager.d()).a.chat_anchor.equals("0")) {
      b = 21;
    } else {
      b = 20;
    } 
    yYAudioConfig.d = b;
    yYAudioConfig.a = (YYRoomInfoManager.d().b()).user_sig;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("客态 getUserInfo -- role  ");
    stringBuilder.append(yYAudioConfig.d);
    stringBuilder.append("  uid ");
    stringBuilder.append(yYAudioConfig.c);
    Logger.c("ulog", new Object[] { stringBuilder.toString() });
    AudioChannelManager.e().a(T());
    AudioChannelManager.e().a(yYAudioConfig);
  }
  
  public boolean V_() {
    if (this.s.getVisibility() == 0) {
      getActivity().finish();
      return true;
    } 
    return super.V_();
  }
  
  public void a(View paramView, YYSeatMemberModel paramYYSeatMemberModel, int paramInt) {
    if (paramView != null) {
      String str;
      if (paramYYSeatMemberModel == null)
        return; 
      if (paramYYSeatMemberModel.position_status == 1) {
        String str1 = paramYYSeatMemberModel.getUid();
        String str2 = paramYYSeatMemberModel.getName();
        str = paramYYSeatMemberModel.getAvatar();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O());
        stringBuilder.append("");
        a(str1, str2, str, stringBuilder.toString(), true);
        return;
      } 
      if (((YYSeatMemberModel)str).position_status == 0) {
        YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
        if (yYUserInfo != null && TextUtils.equals("1", yYUserInfo.is_mic)) {
          ToastUtils.a("你已在麦上", 0);
          return;
        } 
        YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
        if (yYRoomModel != null && !yYRoomModel.enableRequestMic()) {
          ToastUtils.a("相亲交友活动已开始，不可以上麦喽！", 0);
          return;
        } 
        if (YYRoomInfoManager.d().c().a(getContext(), null))
          return; 
        LiveAlterDialog.a(getContext(), R.layout.dialog_apply_mic_layout, null, new View.OnClickListener(this) {
              public void onClick(View param1View) {
                PlayingStudioFragment.c(this.a);
              }
            },  true, false);
      } 
    } 
  }
  
  public void b(String paramString) {
    this.B = true;
    d(paramString);
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    a(new Runnable(this) {
          public void run() {
            if (this.a.z)
              return; 
            String str1 = this.a.getResources().getString(R.string.yy_room_regulation_title);
            String str2 = this.a.getResources().getString(R.string.yy_room_regulation_content);
            YYImMsgManager.a().a(str1, str2);
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel != null && !TextUtils.isEmpty(yYRoomModel.room_desc)) {
              YYImModel yYImModel = new YYImModel();
              yYImModel.type = 26;
              yYImModel.contents = yYRoomModel.room_desc;
              YYImMsgManager.a().u(yYImModel);
            } 
            if (yYRoomModel != null && yYRoomModel.isCPChannel())
              YYImMsgManager.a().a(this.a.getResources().getString(R.string.yy_audience_guide_content)); 
          }
        }300L);
    a(new Runnable(this) {
          public void run() {
            if (this.a.z)
              return; 
            YYImMsgManager.a().d();
          }
        },  500L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\PlayingStudioFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */