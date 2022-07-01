package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYRankFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.utils.UserRelationshipUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class YYStudioTitleView extends LinearLayout implements View.OnClickListener, FollowStatusObserver {
  private ImageView a;
  
  private ImageView b;
  
  private ImageView c;
  
  private ImageView d;
  
  private ShapeTextView e;
  
  private TextView f;
  
  private LinearLayout g;
  
  private YYRankFragment h;
  
  private BaseYYStudioFragment i;
  
  public YYStudioTitleView(Context paramContext) {
    super(paramContext);
    c();
  }
  
  public YYStudioTitleView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public YYStudioTitleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c() {
    LayoutInflater.from(getContext()).inflate(R.layout.layout_yy_studio_title, (ViewGroup)this, true);
    this.g = (LinearLayout)findViewById(R.id.title_root_layout);
    this.d = (ImageView)findViewById(R.id.iv_owner_pic);
    this.a = (ImageView)findViewById(R.id.iv_add);
    this.b = (ImageView)findViewById(R.id.iv_more);
    this.c = (ImageView)findViewById(R.id.iv_rank);
    this.f = (TextView)findViewById(R.id.tv_owner_name);
    this.e = (ShapeTextView)findViewById(R.id.tv_follow);
    ((LinearLayout.LayoutParams)this.g.getLayoutParams()).topMargin = StatusBarHelper.a(getContext()) + DensityUtils.a(getContext(), 12.0F);
    this.f.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.a.setVisibility(8);
  }
  
  private void d() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      if (TextUtils.equals(yYRoomModel.uid, YYRoomInfoManager.d().e()))
        return; 
      YYRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<YYUserInfo>>(this, (IRequestHost)this.i.w_(), yYRoomModel) {
            protected void a(BluedEntityA<YYUserInfo> param1BluedEntityA) {
              YYUserInfo yYUserInfo = param1BluedEntityA.data.get(0);
              this.a.relationship = yYUserInfo.relationship;
              YYStudioTitleView.b(this.b).setText(UserRelationshipUtils.a(this.b.getContext(), this.a.relationship));
              if (TextUtils.equals(this.a.relationship, "1") || TextUtils.equals(this.a.relationship, "3")) {
                this.b.c(false);
                return;
              } 
              this.b.c(true);
            }
          }yYRoomModel.room_id, yYRoomModel.uid, (IRequestHost)this.i.w_());
    } 
  }
  
  public void a() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    ImageLoader.a((IRequestHost)this.i.w_(), yYRoomModel.avatar).a(R.drawable.user_bg_round).a(this.d);
    if (TextUtils.equals(yYRoomModel.relationship, "1") || TextUtils.equals(yYRoomModel.relationship, "3")) {
      c(false);
    } else {
      c(true);
    } 
    this.e.setText(UserRelationshipUtils.a(getContext(), yYRoomModel.relationship));
    this.f.setText(yYRoomModel.room_name);
    this.f.post(new Runnable(this) {
          public void run() {
            YYStudioTitleView.a(this.a).measure(0, 0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)YYStudioTitleView.a(this.a).getLayoutParams();
            int i = YYStudioTitleView.a(this.a).getMeasuredWidth();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("width = ");
            stringBuilder.append(i);
            Logger.e("YYStudioTitleView", new Object[] { stringBuilder.toString() });
            int j = DensityUtils.a(this.a.getContext(), 100.0F);
            stringBuilder = new StringBuilder();
            stringBuilder.append("100dp = ");
            stringBuilder.append(j);
            Logger.e("YYStudioTitleView", new Object[] { stringBuilder.toString() });
            if (i > j) {
              layoutParams.width = j;
            } else {
              layoutParams.width = i;
            } 
            YYStudioTitleView.a(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            YYStudioTitleView.a(this.a).setEllipsize(TextUtils.TruncateAt.MARQUEE);
            YYStudioTitleView.a(this.a).setMarqueeRepeatLimit(-1);
            YYStudioTitleView.a(this.a).setSingleLine(true);
            YYStudioTitleView.a(this.a).setSelected(true);
            YYStudioTitleView.a(this.a).setFocusable(true);
            YYStudioTitleView.a(this.a).setFocusableInTouchMode(true);
          }
        });
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.i = paramBaseYYStudioFragment;
    LiveEventBus.get("notify_room_rename", String.class).observe((LifecycleOwner)paramBaseYYStudioFragment, new Observer<String>(this) {
          public void a(String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("rename ... ");
            stringBuilder.append(param1String);
            Logger.e("YYStudioTitleView", new Object[] { stringBuilder.toString() });
            this.a.a();
          }
        });
    a();
    d();
  }
  
  public void a(String paramString1, String paramString2) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      if (!TextUtils.equals(paramString1, yYRoomModel.uid))
        return; 
      yYRoomModel.relationship = paramString2;
      if (TextUtils.equals(paramString2, "1") || TextUtils.equals(paramString2, "3")) {
        this.e.setVisibility(8);
        return;
      } 
      this.e.setVisibility(0);
      this.e.setText(UserRelationshipUtils.a(getContext(), paramString2));
      return;
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.f.setEnabled(paramBoolean);
  }
  
  public void b() {
    YYRankFragment yYRankFragment = this.h;
    if (yYRankFragment != null)
      yYRankFragment.dismiss(); 
  }
  
  public void b(boolean paramBoolean) {
    byte b;
    ImageView imageView = this.a;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    imageView.setVisibility(b);
  }
  
  public void c(boolean paramBoolean) {
    byte b;
    ShapeTextView shapeTextView = this.e;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    shapeTextView.setVisibility(b);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    Logger.e("observer", new Object[] { "YYAnchorView onAttachedToWindow ... " });
    YYObserverManager.a().a(this);
  }
  
  public void onClick(View paramView) {
    YYRoomModel yYRoomModel;
    if (paramView.getId() == R.id.iv_add) {
      this.i.L();
      return;
    } 
    if (paramView.getId() == R.id.iv_more) {
      this.i.K();
      return;
    } 
    if (paramView.getId() == R.id.tv_owner_name) {
      yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel != null)
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_NAME_CHANGE_CLICK, yYRoomModel.room_id, yYRoomModel.uid); 
      this.i.u();
      return;
    } 
    if (yYRoomModel.getId() == R.id.iv_rank) {
      yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel != null)
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_LIST_CLICK, yYRoomModel.room_id, yYRoomModel.uid); 
      this.h = new YYRankFragment();
      this.h.show(this.i.getFragmentManager(), "RankListDialog");
      return;
    } 
    if (yYRoomModel.getId() == R.id.tv_follow) {
      yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel == null)
        return; 
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_FOLLOW_CLICK, yYRoomModel.room_id, yYRoomModel.uid);
      YYRoomInfoManager.d().b(this.i.getContext(), yYRoomModel.uid, "", (IRequestHost)this.i.w_());
      return;
    } 
    if (yYRoomModel.getId() == R.id.iv_owner_pic) {
      YYRoomModel yYRoomModel1 = YYRoomInfoManager.d().b();
      if (yYRoomModel1 == null)
        return; 
      BaseYYStudioFragment baseYYStudioFragment = this.i;
      String str1 = yYRoomModel1.uid;
      String str2 = yYRoomModel1.name;
      String str3 = yYRoomModel1.avatar;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((YYRoomInfoManager.d()).a.chat_anchor);
      stringBuilder.append("");
      baseYYStudioFragment.a(str1, str2, str3, stringBuilder.toString(), true);
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    Logger.e("observer", new Object[] { "YYAnchorView onDetachedFromWindow ... " });
    YYObserverManager.a().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYStudioTitleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */