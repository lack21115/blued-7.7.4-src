package com.blued.android.module.yy_china.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.OnItemClickRoomMemberListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.UserRelationshipUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

public class RoomMemberAdapter extends BaseQuickAdapter<YYAudienceModel, BaseViewHolder> {
  private BaseYYStudioFragment a;
  
  private int b;
  
  private OnItemClickRoomMemberListener c;
  
  public RoomMemberAdapter(BaseYYStudioFragment paramBaseYYStudioFragment, int paramInt) {
    super(R.layout.item_yy_room_member_layout, new ArrayList());
    this.k = paramBaseYYStudioFragment.getContext();
    this.b = paramInt;
    this.a = paramBaseYYStudioFragment;
  }
  
  public int a(String paramString) {
    for (int i = 0; i < n().size(); i++) {
      if (TextUtils.equals(paramString, ((YYAudienceModel)n().get(i)).getUid()))
        return i; 
    } 
    return -1;
  }
  
  public void a(OnItemClickRoomMemberListener paramOnItemClickRoomMemberListener) {
    this.c = paramOnItemClickRoomMemberListener;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, YYAudienceModel paramYYAudienceModel) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_member_view);
    TextView textView1 = (TextView)paramBaseViewHolder.d(R.id.tv_member_name);
    TextView textView2 = (TextView)paramBaseViewHolder.d(R.id.tv_member_style);
    ShapeTextView shapeTextView1 = (ShapeTextView)paramBaseViewHolder.d(R.id.tv_follow);
    ShapeTextView shapeTextView2 = (ShapeTextView)paramBaseViewHolder.d(R.id.tv_invite);
    ShapeTextView shapeTextView3 = (ShapeTextView)paramBaseViewHolder.d(R.id.tv_role_text);
    ImageLoader.a((IRequestHost)this.a.w_(), paramYYAudienceModel.getAvatar()).a(R.drawable.user_bg_round).a(imageView);
    textView1.setText(paramYYAudienceModel.getName());
    if (TextUtils.equals(paramYYAudienceModel.getUid(), YYRoomInfoManager.d().e())) {
      textView2.setText(this.k.getResources().getString(R.string.yy_msg_self));
    } else {
      textView2.setText(String.format(this.k.getResources().getString(R.string.yy_years_height_weight), new Object[] { paramYYAudienceModel.age, paramYYAudienceModel.height, paramYYAudienceModel.weight, UserRelationshipUtils.a(this.k, null, paramYYAudienceModel.role) }));
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b);
    stringBuilder.append("");
    if (TextUtils.equals(stringBuilder.toString(), "1")) {
      shapeTextView1.setVisibility(8);
      shapeTextView2.setVisibility(0);
      if (TextUtils.equals(paramYYAudienceModel.is_mic, "1")) {
        shapeTextView2.setEnabled(false);
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView2, R.color.syc_dark_28282b, R.color.syc_dark_28282b);
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView1, R.color.syc_8d8d8e);
        shapeTextView2.setText(this.k.getResources().getString(R.string.yy_has_seat));
      } else {
        shapeTextView2.setEnabled(true);
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView2, R.color.syc_00E0AB, R.color.syc_3883FD);
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView1, R.color.syc_dark_b);
        shapeTextView2.setText(this.k.getResources().getString(R.string.yy_invite_seat));
      } 
    } else {
      shapeTextView1.setVisibility(0);
      shapeTextView2.setVisibility(8);
      if (TextUtils.equals(paramYYAudienceModel.relationship, "1") || TextUtils.equals(paramYYAudienceModel.relationship, "3")) {
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView1, R.color.syc_dark_28282b, R.color.syc_dark_28282b);
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView1, R.color.syc_8d8d8e);
      } else {
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView1, R.color.syc_dark_b);
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView1, R.color.syc_00E0AB, R.color.syc_3883FD);
      } 
      shapeTextView1.setText(UserRelationshipUtils.a(this.k, paramYYAudienceModel.relationship));
    } 
    if (TextUtils.equals(paramYYAudienceModel.getUid(), YYRoomInfoManager.d().e()) || TextUtils.equals(paramYYAudienceModel.relationship, "8") || TextUtils.equals(paramYYAudienceModel.relationship, "4"))
      shapeTextView1.setVisibility(8); 
    if (TextUtils.equals(paramYYAudienceModel.chat_anchor, "1")) {
      shapeTextView3.setVisibility(0);
      shapeTextView3.setText(this.k.getResources().getString(R.string.yy_role_host));
      ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView3, R.color.syc_3883FD);
    } else if (TextUtils.equals(paramYYAudienceModel.chat_anchor, "2")) {
      shapeTextView3.setVisibility(0);
      shapeTextView3.setText(this.k.getResources().getString(R.string.yy_role_manager));
      ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView3, R.color.syc_8F38FD);
    } else {
      shapeTextView3.setVisibility(4);
    } 
    shapeTextView1.setOnClickListener(new View.OnClickListener(this, paramYYAudienceModel, paramBaseViewHolder) {
          public void onClick(View param1View) {
            if (RoomMemberAdapter.a(this.c) != null)
              RoomMemberAdapter.a(this.c).a(this.a, this.b.getAdapterPosition()); 
          }
        });
    shapeTextView2.setOnClickListener(new View.OnClickListener(this, paramYYAudienceModel, paramBaseViewHolder) {
          public void onClick(View param1View) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel != null)
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_INVITE_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.a.getUid()); 
            if (RoomMemberAdapter.a(this.c) != null)
              RoomMemberAdapter.a(this.c).b(this.a, this.b.getAdapterPosition()); 
          }
        });
    imageView.setOnClickListener(new View.OnClickListener(this, paramYYAudienceModel) {
          public void onClick(View param1View) {
            boolean bool;
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel != null) {
              bool = yYRoomModel.isExistById(this.a.getUid());
            } else {
              bool = false;
            } 
            RoomMemberAdapter.b(this.b).a(this.a.getUid(), this.a.getName(), this.a.getAvatar(), (YYRoomInfoManager.d()).a.chat_anchor, bool);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\adapter\RoomMemberAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */