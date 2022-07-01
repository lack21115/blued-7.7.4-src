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
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.utils.UserRelationshipUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;

public class YYAnchorView extends LinearLayout implements View.OnClickListener, FollowStatusObserver {
  private ImageView a;
  
  private TextView b;
  
  private ShapeTextView c;
  
  private BaseYYStudioFragment d;
  
  public YYAnchorView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYAnchorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_anchor_layout, (ViewGroup)this, true);
    this.a = (ImageView)findViewById(R.id.iv_owner_pic);
    this.b = (TextView)findViewById(R.id.tv_owner_name);
    this.c = (ShapeTextView)findViewById(R.id.tv_follow);
    this.c.setOnClickListener(this);
    this.a.setOnClickListener(this);
  }
  
  public void a(String paramString1, String paramString2) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      if (!TextUtils.equals(paramString1, yYRoomModel.uid))
        return; 
      yYRoomModel.relationship = paramString2;
      if (TextUtils.equals(paramString2, "1") || TextUtils.equals(paramString2, "3")) {
        this.c.setVisibility(8);
        return;
      } 
      this.c.setVisibility(0);
      this.c.setText(UserRelationshipUtils.a(getContext(), paramString2));
      return;
    } 
  }
  
  public void a(boolean paramBoolean) {
    byte b;
    ShapeTextView shapeTextView = this.c;
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
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    if (paramView.getId() == R.id.tv_follow) {
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_FOLLOW_CLICK, yYRoomModel.room_id, yYRoomModel.uid);
      YYRoomInfoManager.d().b(this.d.getContext(), yYRoomModel.uid, "", (IRequestHost)this.d.w_());
      return;
    } 
    if (paramView.getId() == R.id.iv_owner_pic) {
      BaseYYStudioFragment baseYYStudioFragment = this.d;
      String str1 = yYRoomModel.uid;
      String str2 = yYRoomModel.name;
      String str3 = yYRoomModel.avatar;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYAnchorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */