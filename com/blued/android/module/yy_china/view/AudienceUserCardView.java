package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.trtc_audio.permission.PermissionHelper;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;

public class AudienceUserCardView extends UserCardView {
  private ShapeTextView g;
  
  private ShapeTextView h;
  
  private ShapeTextView i;
  
  private ShapeTextView j;
  
  private ShapeTextView k;
  
  private LinearLayout l;
  
  public AudienceUserCardView(Context paramContext) {
    super(paramContext);
  }
  
  public AudienceUserCardView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public AudienceUserCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    if (!yYRoomModel.enableRequestMic()) {
      ToastUtils.a("相亲交友活动已开始，不可以上麦喽！", 0);
      return;
    } 
    EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_MIKE_CLICK, yYRoomModel.room_id, yYRoomModel.uid);
    YYRoomHttpUtils.c(yYRoomModel.room_id, 0, new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)this.d.w_()) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            YYImModel yYImModel = new YYImModel();
            yYImModel.type = -2;
            yYImModel.contents = this.a.getResources().getString(R.string.yy_msg_apply_mic);
            YYImMsgManager.a().f(yYImModel);
            this.a.d.H();
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            this.a.c.setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.c.setVisibility(0);
          }
        }(IRequestHost)this.d.w_());
  }
  
  private void d() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    if (!yYRoomModel.enableRequestMic()) {
      ToastUtils.a("相亲交友活动已开始，不可以邀请用户上麦喽！", 0);
      return;
    } 
    YYRoomHttpUtils.a(yYRoomModel.room_id, this.f.getUid(), 0, new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)this.d.w_()) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            ToastUtils.a("邀请上麦已发出，等待确认", 0);
            this.a.d.H();
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            this.a.c.setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.c.setVisibility(0);
          }
        }(IRequestHost)this.d.w_());
  }
  
  void a() {
    if (TextUtils.equals(this.f.getUid(), YYRoomInfoManager.d().e())) {
      this.h.setVisibility(0);
      this.g.setVisibility(8);
      this.l.setVisibility(8);
      this.a.setVisibility(8);
      return;
    } 
    if (TextUtils.equals(this.e, "1")) {
      this.h.setVisibility(8);
      this.g.setVisibility(0);
      this.l.setVisibility(0);
      this.k.setVisibility(0);
      this.a.setVisibility(0);
      return;
    } 
    if (TextUtils.equals(this.e, "2")) {
      this.h.setVisibility(8);
      this.g.setVisibility(8);
      this.l.setVisibility(0);
      this.k.setVisibility(8);
      this.a.setVisibility(0);
      return;
    } 
    this.h.setVisibility(8);
    this.k.setVisibility(8);
    this.g.setVisibility(8);
    this.l.setVisibility(0);
    this.a.setVisibility(0);
  }
  
  void a(LinearLayout paramLinearLayout) {
    paramLinearLayout.addView(LayoutInflater.from(getContext()).inflate(R.layout.view_audience_user_menu_layout, null));
    this.g = (ShapeTextView)findViewById(R.id.tv_invite_seat);
    this.h = (ShapeTextView)findViewById(R.id.tv_up_seat);
    this.i = (ShapeTextView)findViewById(R.id.tv_at_him);
    this.j = (ShapeTextView)findViewById(R.id.tv_private_chat);
    this.k = (ShapeTextView)findViewById(R.id.tv_out);
    this.l = (LinearLayout)findViewById(R.id.ll_menu);
    this.h.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
  }
  
  public void onClick(View paramView) {
    YYRoomModel yYRoomModel;
    if (paramView.getId() == R.id.tv_at_him) {
      this.d.H();
      this.d.a(this.f.getUid(), this.f.getName());
      return;
    } 
    if (paramView.getId() == R.id.tv_invite_seat) {
      d();
      return;
    } 
    if (paramView.getId() == R.id.tv_private_chat) {
      YYRoomInfoManager.d().c().a(getContext(), this.f.getUid(), this.f.getName(), this.f.getAvatar());
      this.d.V_();
      this.d.getActivity().finish();
      return;
    } 
    if (paramView.getId() == R.id.tv_up_seat) {
      if (YYRoomInfoManager.d().c().a(getContext(), null))
        return; 
      yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel != null)
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_MIKE_CLICK, yYRoomModel.room_id, yYRoomModel.uid); 
      PermissionHelper.a(new PermissionCallbacks(this, yYRoomModel) {
            public void a(String[] param1ArrayOfString) {
              AppMethods.a("麦克风已被禁用，请在设置中授权麦克风使用");
            }
            
            public void aa_() {
              LiveAlterDialog.a(this.b.getContext(), R.layout.dialog_apply_mic_layout, null, new View.OnClickListener(this) {
                    public void onClick(View param2View) {
                      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_MIKE_CONFIRM_CLICK, this.a.a.room_id, this.a.a.uid);
                      AudienceUserCardView.a(this.a.b);
                    }
                  }true, false);
            }
          });
      return;
    } 
    if (yYRoomModel.getId() == R.id.tv_out) {
      yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel != null && this.f != null)
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_KICK_OUT_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.f.getUid()); 
      b();
      return;
    } 
    super.onClick((View)yYRoomModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\AudienceUserCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */