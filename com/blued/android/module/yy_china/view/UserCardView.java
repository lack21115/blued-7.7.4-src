package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.utils.UserRelationshipUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;

public abstract class UserCardView extends RelativeLayout implements View.OnClickListener, FollowStatusObserver {
  protected ShapeTextView a;
  
  protected ShapeTextView b;
  
  protected FrameLayout c;
  
  protected BaseYYStudioFragment d;
  
  protected String e;
  
  protected YYUserInfo f;
  
  private TextView g;
  
  private TextView h;
  
  private TextView i;
  
  private ImageView j;
  
  private ImageView k;
  
  private LinearLayout l;
  
  public UserCardView(Context paramContext) {
    super(paramContext);
    c();
  }
  
  public UserCardView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public UserCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void a(String paramString) {
    this.a.setText(UserRelationshipUtils.a(getContext(), paramString));
    if (TextUtils.equals(paramString, "1") || TextUtils.equals(paramString, "3") || TextUtils.equals(this.f.getUid(), YYRoomInfoManager.d().e()) || TextUtils.equals(paramString, "8") || TextUtils.equals(paramString, "4")) {
      this.a.setVisibility(8);
      return;
    } 
    this.a.setVisibility(0);
  }
  
  private void a(boolean paramBoolean) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null && this.f != null)
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_USER_PROFILE_FOLLOW_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.f.getUid(), paramBoolean); 
  }
  
  private void c() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_user_card_layout, (ViewGroup)this, true);
    this.g = (TextView)findViewById(R.id.tv_name);
    this.h = (TextView)findViewById(R.id.tv_user_info);
    this.i = (TextView)findViewById(R.id.tv_address);
    this.j = (ImageView)findViewById(R.id.iv_header_view);
    this.a = (ShapeTextView)findViewById(R.id.tv_follow);
    this.c = (FrameLayout)findViewById(R.id.fl_loading_view);
    this.k = (ImageView)findViewById(R.id.iv_more);
    this.l = (LinearLayout)findViewById(R.id.info_view);
    this.b = (ShapeTextView)findViewById(R.id.tv_role_text);
    a(this.l);
    this.a.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.j.setOnClickListener(this);
  }
  
  private void d() {
    LiveAlterDialog.a(getContext(), R.layout.dialog_follow_layout, null, new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel != null && this.a.f != null && TextUtils.equals(yYRoomModel.uid, this.a.f.getUid()))
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_UNFOLLOW, yYRoomModel.room_id, yYRoomModel.uid, this.a.f.getUid()); 
            YYRoomInfoManager.d().a(this.a.getContext(), this.a.f.getUid(), "", (IRequestHost)this.a.d.w_());
          }
        }false, true);
  }
  
  private void e() {
    if (TextUtils.equals(this.f.getUid(), YYRoomInfoManager.d().e())) {
      this.k.setVisibility(8);
    } else {
      this.k.setVisibility(0);
    } 
    this.g.setText(this.f.getName());
    this.i.setText(this.f.location);
    a(this.f.relationship);
    if (!TextUtils.isEmpty(this.f.height) && !TextUtils.isEmpty(this.f.height))
      this.h.setText(String.format(getResources().getString(R.string.yy_years_height_weight), new Object[] { this.f.age, this.f.height, this.f.weight, UserRelationshipUtils.a(getContext(), null, this.f.role) })); 
    ImageLoader.a((IRequestHost)this.d.w_(), this.f.getAvatar()).a(R.drawable.user_bg_round).a(this.j);
  }
  
  private void getUserInfo() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<YYUserInfo>>(this, (IRequestHost)this.d.w_()) {
          protected void a(BluedEntityA<YYUserInfo> param1BluedEntityA) {
            this.a.f = param1BluedEntityA.data.get(0);
            YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
            if (yYUserInfo != null && TextUtils.equals(this.a.f.getUid(), yYUserInfo.getUid()))
              (YYRoomInfoManager.d()).a = this.a.f; 
            if (TextUtils.equals(this.a.f.chat_anchor, "1")) {
              ShapeHelper.b((ShapeHelper.ShapeView)this.a.b, R.color.syc_3883FD);
              this.a.b.setText(this.a.getContext().getResources().getString(R.string.yy_role_host));
              this.a.b.setVisibility(0);
            } else if (TextUtils.equals(this.a.f.chat_anchor, "2")) {
              ShapeHelper.b((ShapeHelper.ShapeView)this.a.b, R.color.syc_8F38FD);
              this.a.b.setText(this.a.getContext().getResources().getString(R.string.yy_role_manager));
              this.a.b.setVisibility(0);
            } else {
              this.a.b.setVisibility(8);
            } 
            this.a.a();
            UserCardView.b(this.a);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            this.a.c.setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.c.setVisibility(0);
          }
        }yYRoomModel.room_id, this.f.getUid(), (IRequestHost)this.d.w_());
  }
  
  abstract void a();
  
  abstract void a(LinearLayout paramLinearLayout);
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment, String paramString1, String paramString2, String paramString3, String paramString4) {
    this.d = paramBaseYYStudioFragment;
    this.e = paramString4;
    if (this.f == null) {
      this.f = new YYUserInfo();
      this.f.setAvatar(paramString3);
      this.f.setName(paramString2);
      this.f.setUid(paramString1);
    } 
    a();
    e();
    paramBaseYYStudioFragment.a(new Runnable(this) {
          public void run() {
            UserCardView.a(this.a);
          }
        },  300L);
  }
  
  public void a(String paramString1, String paramString2) {
    this.f.relationship = paramString2;
    a(paramString2);
  }
  
  protected void b() {
    LiveAlterDialog.a(getContext(), R.layout.dialog_kick_out_layout, null, new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel == null)
              return; 
            YYRoomHttpUtils.b(new BluedUIHttpResponse(this, (IRequestHost)this.a.d.w_()) {
                  public void onUIUpdate(BluedEntity param2BluedEntity) {
                    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
                    if (yYRoomModel != null && this.a.a.f != null)
                      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_KICK_OUT_CONFIRM_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.a.a.f.getUid()); 
                    if (this.a.a.d != null)
                      this.a.a.d.H(); 
                  }
                }yYRoomModel.room_id, this.a.f.getUid(), (IRequestHost)this.a.d.w_());
          }
        }false, true);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    YYObserverManager.a().a(this);
  }
  
  public void onClick(View paramView) {
    if (ClickUtils.a(R.id.iv_header_view))
      return; 
    if (paramView.getId() == R.id.tv_follow) {
      if (TextUtils.equals("2", this.f.relationship) || TextUtils.equals("0", this.f.relationship)) {
        a(true);
        YYRoomInfoManager.d().b(getContext(), this.f.getUid(), "", (IRequestHost)this.d.w_());
        return;
      } 
      a(false);
      d();
      return;
    } 
    if (paramView.getId() == R.id.iv_more) {
      this.d.a(this.f);
      return;
    } 
    if (paramView.getId() == R.id.iv_header_view) {
      YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel != null && this.f != null)
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_GO_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.f.getUid()); 
      YYRoomInfoManager.d().c().a(getContext(), this.f.getUid(), this.f.getName(), this.f.getAvatar(), this.f.vbadge, 2);
      this.d.V_();
      this.d.getActivity().finish();
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    YYObserverManager.a().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\UserCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */