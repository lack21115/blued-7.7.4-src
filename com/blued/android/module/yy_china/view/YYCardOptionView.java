package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYReportModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;

public class YYCardOptionView extends LinearLayout implements View.OnClickListener {
  private TextView a;
  
  private TextView b;
  
  private TextView c;
  
  private TextView d;
  
  private BaseYYStudioFragment e;
  
  private YYUserInfo f;
  
  private YYUserInfo g;
  
  public YYCardOptionView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYCardOptionView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYCardOptionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_card_option_layout, (ViewGroup)this, true);
    this.c = (TextView)findViewById(R.id.tv_cancel);
    this.b = (TextView)findViewById(R.id.tv_report);
    this.a = (TextView)findViewById(R.id.tv_manager);
    this.d = (TextView)findViewById(R.id.tv_mute);
    this.g = (YYRoomInfoManager.d()).a;
    YYUserInfo yYUserInfo = this.g;
    if (yYUserInfo == null)
      return; 
    if (TextUtils.equals(yYUserInfo.chat_anchor, "1")) {
      this.a.setVisibility(0);
    } else {
      this.a.setVisibility(8);
    } 
    if (TextUtils.equals(this.g.chat_anchor, "1") || TextUtils.equals(this.g.chat_anchor, "2")) {
      this.d.setVisibility(0);
    } else {
      this.d.setVisibility(8);
    } 
    this.c.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  private void b() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYUserInfo yYUserInfo = this.f;
    if (yYUserInfo == null)
      return; 
    int i = TextUtils.equals(yYUserInfo.chat_anchor, "2") ^ true;
    if (i == 1)
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_SET_MANAGER_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.f.getUid()); 
    YYRoomHttpUtils.d(yYRoomModel.room_id, this.f.getUid(), i, new BluedUIHttpResponse(this, (IRequestHost)this.e.w_(), i, yYRoomModel) {
          public boolean onUIFailure(int param1Int, String param1String) {
            if (param1Int == 40380012)
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_MANAGER_MAX_SHOW, this.b.room_id, this.b.uid, YYCardOptionView.b(this.c).getUid()); 
            ToastUtils.a(param1String, 0);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            if (this.a == 1)
              ToastUtils.a("设置成功", 0); 
            if (YYCardOptionView.a(this.c) != null)
              YYCardOptionView.a(this.c).H(); 
          }
        }(IRequestHost)this.e.w_());
  }
  
  private void setMute(String paramString) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYUserInfo yYUserInfo = this.f;
    if (yYUserInfo == null)
      return; 
    if (TextUtils.equals(yYUserInfo.mute, "1")) {
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_FORBID_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.f.getUid());
    } else {
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_REMOVE_FORBID_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.f.getUid());
    } 
    YYRoomHttpUtils.b(yYRoomModel.room_id, this.f.getUid(), paramString, new BluedUIHttpResponse(this, (IRequestHost)this.e.w_(), paramString) {
          public boolean onUIFailure(int param1Int, String param1String) {
            ToastUtils.a(param1String, 0);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (YYCardOptionView.a(this.b) != null)
              YYCardOptionView.a(this.b).H(); 
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            String str;
            if (TextUtils.equals("1", this.a)) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(YYCardOptionView.b(this.b).getName());
              stringBuilder.append(" 已被禁言，本场不可在公屏发言。");
              str = stringBuilder.toString();
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(YYCardOptionView.b(this.b).getName());
              stringBuilder.append(" 已被解除禁言，恢复公屏发言权限。");
              str = stringBuilder.toString();
            } 
            ToastUtils.a(str, 0);
          }
        }(IRequestHost)this.e.w_());
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment, YYUserInfo paramYYUserInfo) {
    this.e = paramBaseYYStudioFragment;
    this.f = paramYYUserInfo;
    YYUserInfo yYUserInfo = this.f;
    if (yYUserInfo == null)
      return; 
    if (!TextUtils.equals(yYUserInfo.chat_anchor, "2")) {
      this.a.setText(getResources().getString(R.string.yy_do_manager));
    } else {
      this.a.setText(getResources().getString(R.string.yy_undo_manager));
    } 
    if (TextUtils.equals(this.f.mute, "1")) {
      this.d.setText("解除禁言");
    } else {
      this.d.setText("禁言");
    } 
    if (TextUtils.equals(this.g.chat_anchor, "1")) {
      this.d.setVisibility(0);
      return;
    } 
    if (!TextUtils.equals(this.g.chat_anchor, "1") && !TextUtils.equals(this.g.chat_anchor, "2")) {
      this.d.setVisibility(8);
      return;
    } 
    if (TextUtils.equals(this.f.chat_anchor, "1") || TextUtils.equals(this.f.chat_anchor, "2")) {
      this.d.setVisibility(8);
      return;
    } 
    this.d.setVisibility(0);
  }
  
  public void onClick(View paramView) {
    YYReportModel yYReportModel;
    if (this.e == null)
      return; 
    if (paramView.getId() == R.id.tv_cancel) {
      this.e.H();
      return;
    } 
    if (paramView.getId() == R.id.tv_report) {
      YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel != null)
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_REPORT_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.f.getUid()); 
      yYReportModel = new YYReportModel();
      yYReportModel.uid = this.f.getUid();
      this.e.a(yYReportModel, 0);
      return;
    } 
    if (yYReportModel.getId() == R.id.tv_manager) {
      b();
      return;
    } 
    if (yYReportModel.getId() == R.id.tv_mute) {
      YYUserInfo yYUserInfo = this.f;
      if (yYUserInfo == null)
        return; 
      if (TextUtils.equals(yYUserInfo.mute, "1")) {
        setMute("0");
        return;
      } 
      setMute("1");
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.e = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYCardOptionView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */