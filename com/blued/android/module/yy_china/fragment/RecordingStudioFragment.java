package com.blued.android.module.yy_china.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYLockModel;
import com.blued.android.module.yy_china.model.YYMsgKickInfoExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.model.YYAudioConfig;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class RecordingStudioFragment extends BaseYYStudioFragment {
  private PopupWindow B;
  
  private LinearLayout C;
  
  private TextView D;
  
  private int E;
  
  private int F;
  
  private int G;
  
  private int H;
  
  private int I;
  
  private int J;
  
  private void Z() {
    PopupWindow popupWindow = this.B;
    if (popupWindow != null && popupWindow.isShowing())
      this.B.dismiss(); 
  }
  
  private void a(YYMsgKickInfoExtra paramYYMsgKickInfoExtra) {
    if (paramYYMsgKickInfoExtra != null) {
      if (TextUtils.isEmpty(paramYYMsgKickInfoExtra.message))
        return; 
      YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel != null)
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_OWNER_OUT_MIKE_TOAST_SHOW, yYRoomModel.room_id, yYRoomModel.uid); 
      a(new Runnable(this, paramYYMsgKickInfoExtra) {
            public void run() {
              View view = LayoutInflater.from(this.b.getContext()).inflate(R.layout.dialog_warning_layout, null);
              TextView textView = (TextView)view.findViewById(R.id.tv_warn_title);
              ((TextView)view.findViewById(R.id.tv_warn)).setText(this.a.message);
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
  
  private void a(YYSeatMemberModel paramYYSeatMemberModel, int paramInt) {
    boolean bool;
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    String str = yYRoomModel.room_id;
    if (paramYYSeatMemberModel.position_status == -1) {
      bool = false;
    } else {
      bool = true;
    } 
    YYRoomHttpUtils.a(str, bool, paramInt, new BluedUIHttpResponse<BluedEntityA<YYLockModel>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<YYLockModel> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              if (param1BluedEntityA.getSingleData() == null)
                return; 
              if (((YYLockModel)param1BluedEntityA.getSingleData()).position_status == 0) {
                ToastUtils.a("麦位已解封，其他用户可以点击麦位正常上麦", 0);
                return;
              } 
              ToastUtils.a("麦位已封禁，没有用户可以上此麦，再次点击麦位可以解开", 0);
            } 
          }
        }(IRequestHost)w_());
  }
  
  private void b(View paramView, YYSeatMemberModel paramYYSeatMemberModel, int paramInt) {
    if (this.C == null) {
      this.C = (LinearLayout)LayoutInflater.from(getContext()).inflate(R.layout.view_yy_menu_layout, null);
      this.D = (TextView)this.C.findViewById(R.id.tv_status);
    } 
    if (paramYYSeatMemberModel.position_status == 0) {
      this.D.setText(getResources().getString(R.string.yy_seat_status_disable));
    } else if (paramYYSeatMemberModel.position_status == -1) {
      this.D.setText(getResources().getString(R.string.yy_seat_status_enable));
    } 
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("loc_x = ");
    stringBuilder2.append(arrayOfInt[0]);
    stringBuilder2.append(" ; loc_y = ");
    stringBuilder2.append(arrayOfInt[1]);
    Logger.e("RecordingStudioFragment", new Object[] { stringBuilder2.toString() });
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if (this.E <= 0) {
      this.C.measure(0, 0);
      this.E = this.C.getMeasuredWidth();
      this.F = this.C.getMeasuredHeight();
      this.G = i / 2 - this.E / 2;
      this.H = j / 2;
    } 
    this.I = arrayOfInt[0] + this.G;
    this.J = arrayOfInt[1] + this.H;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("moveX = ");
    stringBuilder1.append(this.I);
    stringBuilder1.append(" ; moveY = ");
    stringBuilder1.append(this.J);
    Logger.e("RecordingStudioFragment", new Object[] { stringBuilder1.toString() });
    if (this.B == null) {
      this.B = new PopupWindow((View)this.C, this.E, this.F);
      this.B.setFocusable(true);
      this.B.setOutsideTouchable(true);
      this.B.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    } 
    this.B.showAtLocation(getActivity().getWindow().getDecorView(), 0, this.I, this.J);
    this.D.setOnClickListener(new View.OnClickListener(this, paramYYSeatMemberModel, paramInt) {
          public void onClick(View param1View) {
            RecordingStudioFragment.a(this.c, this.a, this.b);
            RecordingStudioFragment.a(this.c);
          }
        });
  }
  
  private void d(String paramString) {
    Logger.e("RecordingStudioFragment", new Object[] { "leaveRoom 1 ... " });
    if (TextUtils.isEmpty(paramString))
      return; 
    Z();
    I();
    Logger.e("RecordingStudioFragment", new Object[] { "leaveRoom 2 ... " });
    YYRoomHttpUtils.c(paramString, new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)w_(), paramString) {
          Dialog a = null;
          
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            Logger.e("RecordingStudioFragment", new Object[] { "leaveRoom 3 ... " });
            this.c.S();
            Logger.e("RecordingStudioFragment", new Object[] { "leaveRoom 4 ... " });
            this.c.r.a(this.c, this.b);
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
            this.a = DialogUtils.a(this.c.getContext());
            DialogUtils.a(this.a);
          }
        }(IRequestHost)w_());
  }
  
  public void J() {
    LiveEventBus.get("late_reject_msg", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1String);
            stringBuilder.append("暂时不方便上麦");
            ToastUtils.a(stringBuilder.toString(), 0);
          }
        });
    LiveEventBus.get("down_seat_msg", YYAudienceModel.class).observe((LifecycleOwner)this, new Observer<YYAudienceModel>(this) {
          public void a(YYAudienceModel param1YYAudienceModel) {
            if (param1YYAudienceModel != null) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(param1YYAudienceModel.getName());
              stringBuilder.append("已下麦");
              ToastUtils.a(stringBuilder.toString(), 0);
              YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
              if (yYRoomModel != null && TextUtils.equals(param1YYAudienceModel.getUid(), yYRoomModel.uid))
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_OWNER_OUT_MIKE_TOAST_SHOW, yYRoomModel.room_id, yYRoomModel.uid); 
            } 
          }
        });
    LiveEventBus.get("close_living_room", YYMsgKickInfoExtra.class).observe((LifecycleOwner)this, new Observer<YYMsgKickInfoExtra>(this) {
          public void a(YYMsgKickInfoExtra param1YYMsgKickInfoExtra) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel == null)
              return; 
            RecordingStudioFragment.a(this.a, param1YYMsgKickInfoExtra);
            RecordingStudioFragment.a(this.a, yYRoomModel.room_id);
          }
        });
    LiveEventBus.get("show_music", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            this.a.x();
          }
        });
  }
  
  public void K() {
    a(getResources().getString(R.string.yy_shutdown), true);
  }
  
  public void L() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYRoomInfoManager.d().c().a(getContext(), getFragmentManager(), yYRoomModel, null, "我在语音聊天室，邀请你加入");
  }
  
  public void M() {
    this.u.setVisibility(0);
    this.v.setVisibility(8);
  }
  
  protected void N() {
    this.f.c(false);
    this.o.a(false);
    this.f.b(true);
    LiveMusicModel liveMusicModel = YYRoomInfoManager.d().n();
    if (liveMusicModel != null)
      a(liveMusicModel); 
  }
  
  public int O() {
    return 1;
  }
  
  public void P() {
    LiveAlterDialog.a(getContext(), R.layout.dialog_end_layout, null, new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel == null)
              return; 
            RecordingStudioFragment.a(this.a, yYRoomModel.room_id);
          }
        }true, false);
  }
  
  public void Q() {
    v();
    U().a(-5);
  }
  
  public void R() {
    byte b;
    if (this.z) {
      AudioChannelManager.e().a(T());
      return;
    } 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
    if (yYUserInfo == null)
      return; 
    YYAudioConfig yYAudioConfig = new YYAudioConfig();
    yYAudioConfig.c = YYRoomInfoManager.d().e();
    yYAudioConfig.b = yYRoomModel.room_id;
    if (yYUserInfo.chat_anchor.equals("0")) {
      b = 21;
    } else {
      b = 20;
    } 
    yYAudioConfig.d = b;
    yYAudioConfig.a = yYRoomModel.user_sig;
    yYAudioConfig.e = 1;
    yYAudioConfig.f = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("主态 getUserInfo -- role  ");
    stringBuilder.append(yYAudioConfig.d);
    stringBuilder.append("  uid ");
    stringBuilder.append(yYAudioConfig.c);
    Logger.b("ulog", new Object[] { stringBuilder.toString() });
    AudioChannelManager.e().a(T());
    c(yYRoomModel.publish_url);
    AudioChannelManager.e().a(yYAudioConfig);
  }
  
  public void V() {
    this.p.setPlaying(true);
  }
  
  public boolean V_() {
    if (this.r.getVisibility() == 0) {
      getActivity().finish();
      return true;
    } 
    return super.V_();
  }
  
  public void W() {
    this.p.setVisibility(8);
    this.p.a();
  }
  
  public void X() {
    this.p.a();
  }
  
  public void Y() {
    this.p.setPlaying(false);
  }
  
  public void a(View paramView, YYSeatMemberModel paramYYSeatMemberModel, int paramInt) {
    if (paramView != null) {
      String str1;
      String str2;
      if (paramYYSeatMemberModel == null)
        return; 
      if (paramYYSeatMemberModel.position_status == 1) {
        str1 = paramYYSeatMemberModel.getUid();
        String str = paramYYSeatMemberModel.getName();
        str2 = paramYYSeatMemberModel.getAvatar();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O());
        stringBuilder.append("");
        a(str1, str, str2, stringBuilder.toString(), true);
        return;
      } 
      b((View)str1, (YYSeatMemberModel)str2, paramInt);
    } 
  }
  
  public void a(LiveMusicModel paramLiveMusicModel) {
    this.p.setVisibility(0);
    this.p.setData(paramLiveMusicModel);
  }
  
  public void b(String paramString) {
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
          }
        }300L);
    a(new Runnable(this) {
          public void run() {
            if (this.a.z)
              return; 
            YYImMsgManager.a().b();
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel != null && yYRoomModel.isCPChannel())
              YYImMsgManager.a().a(this.a.getResources().getString(R.string.yy_host_guide_content)); 
          }
        },  350L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\RecordingStudioFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */