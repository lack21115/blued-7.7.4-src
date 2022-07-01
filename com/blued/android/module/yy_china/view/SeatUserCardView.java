package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;

public class SeatUserCardView extends UserCardView {
  private TextView g;
  
  private ShapeTextView h;
  
  private ShapeTextView i;
  
  private ShapeTextView j;
  
  private ShapeTextView k;
  
  private TextView l;
  
  private View m;
  
  private LinearLayout n;
  
  private ShapeLinearLayout o;
  
  public SeatUserCardView(Context paramContext) {
    super(paramContext);
  }
  
  public SeatUserCardView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public SeatUserCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYRoomHttpUtils.b(yYRoomModel.room_id, this.f.getUid(), new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)this.d.w_(), yYRoomModel) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            if (this.b.d != null)
              this.b.d.H(); 
            if (this.a == null)
              return; 
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_OUT_MIKE, this.a.room_id, this.a.uid);
            if (!TextUtils.equals(this.a.uid, YYRoomInfoManager.d().e()))
              AudioChannelManager.e().a(21); 
          }
        }(IRequestHost)this.d.w_());
  }
  
  private void d() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYRoomHttpUtils.b(yYRoomModel.room_id, this.f.getUid(), 0, new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)this.d.w_()) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.f.getName());
            stringBuilder.append("已闭麦");
            ToastUtils.a(stringBuilder.toString(), 0);
            if (this.a.d != null)
              this.a.d.H(); 
          }
        }(IRequestHost)this.d.w_());
  }
  
  void a() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (TextUtils.equals(this.f.getUid(), YYRoomInfoManager.d().e())) {
      this.m.setVisibility(8);
      this.g.setVisibility(8);
      this.n.setVisibility(8);
      this.a.setVisibility(8);
      if (yYRoomModel != null && TextUtils.equals(this.f.getUid(), yYRoomModel.uid)) {
        this.o.setVisibility(8);
        return;
      } 
      this.o.setVisibility(0);
      this.l.setVisibility(0);
      return;
    } 
    if (TextUtils.equals(this.e, "1")) {
      this.l.setVisibility(0);
      this.m.setVisibility(0);
      this.g.setVisibility(0);
      this.n.setVisibility(0);
      this.j.setVisibility(0);
      this.k.setVisibility(0);
      return;
    } 
    if (TextUtils.equals(this.e, "2")) {
      this.l.setVisibility(8);
      this.m.setVisibility(8);
      this.g.setVisibility(0);
      this.n.setVisibility(0);
      this.k.setVisibility(8);
      if (yYRoomModel != null && TextUtils.equals(this.f.getUid(), yYRoomModel.uid)) {
        this.j.setVisibility(8);
        return;
      } 
      if (TextUtils.equals(this.f.chat_anchor, "2")) {
        this.j.setVisibility(8);
        return;
      } 
      this.j.setVisibility(0);
      return;
    } 
    this.l.setVisibility(8);
    this.j.setVisibility(8);
    this.k.setVisibility(8);
    this.m.setVisibility(8);
    this.g.setVisibility(0);
    this.n.setVisibility(0);
  }
  
  void a(LinearLayout paramLinearLayout) {
    paramLinearLayout.addView(LayoutInflater.from(getContext()).inflate(R.layout.view_seat_user_menu_layout, null));
    this.g = (TextView)findViewById(R.id.tv_send_gift);
    this.h = (ShapeTextView)findViewById(R.id.tv_at_him);
    this.i = (ShapeTextView)findViewById(R.id.tv_private_chat);
    this.j = (ShapeTextView)findViewById(R.id.tv_close_audio);
    this.k = (ShapeTextView)findViewById(R.id.tv_out);
    this.l = (TextView)findViewById(R.id.tv_down_seat);
    this.m = findViewById(R.id.tv_line);
    this.n = (LinearLayout)findViewById(R.id.ll_menu);
    this.o = (ShapeLinearLayout)findViewById(R.id.ll_up_gift);
    this.k.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.l.setOnClickListener(this);
  }
  
  public void onClick(View paramView) {
    ChatRoomProtos.Event event1;
    int i = paramView.getId();
    int j = R.id.tv_at_him;
    ChatRoomProtos.Event event2 = null;
    if (i == j) {
      event1 = ChatRoomProtos.Event.CHAT_ROOM_PROFILE_AT_CLICK;
      this.d.H();
      this.d.a(this.f.getUid(), this.f.getName());
    } else if (event1.getId() == R.id.tv_down_seat) {
      c();
      event1 = event2;
    } else if (event1.getId() == R.id.tv_private_chat) {
      event1 = ChatRoomProtos.Event.CHAT_ROOM_PROFILE_MSG_CLICK;
      YYRoomInfoManager.d().c().a(getContext(), this.f.getUid(), this.f.getName(), this.f.getAvatar());
      this.d.V_();
      this.d.getActivity().finish();
    } else if (event1.getId() == R.id.tv_close_audio) {
      event1 = ChatRoomProtos.Event.CHAT_ROOM_MUTE_CLICK;
      d();
      this.d.H();
    } else if (event1.getId() == R.id.tv_send_gift) {
      event1 = ChatRoomProtos.Event.CHAT_ROOM_PROFILE_GIFT_CLICK;
      this.d.H();
      this.d.a(true, "personal_profile", this.f.getUid());
    } else if (event1.getId() == R.id.tv_out) {
      event1 = ChatRoomProtos.Event.CHAT_ROOM_KICK_OUT_CLICK;
      b();
    } else {
      super.onClick((View)event1);
      event1 = event2;
    } 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null && this.f != null && event1 != null)
      EventTrackYY.a(event1, yYRoomModel.room_id, yYRoomModel.uid, this.f.getUid()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\SeatUserCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */