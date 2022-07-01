package com.soft.blued.ui.yy_room.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.yy_room.fragment.YYChatRoomsFragment;
import com.soft.blued.ui.yy_room.presenter.YYChatRoomsPresenter;
import java.util.ArrayList;
import java.util.LinkedList;

public class YYRoomAdapter extends BaseQuickAdapter<YYRoomModel, BaseViewHolder> {
  private int a;
  
  private int b;
  
  private YYChatRoomsFragment c;
  
  private LinkedList<Integer> d;
  
  private String e;
  
  private String f;
  
  public YYRoomAdapter(Context paramContext, YYChatRoomsFragment paramYYChatRoomsFragment, String paramString) {
    super(2131493706, new ArrayList());
    this.k = paramContext;
    this.c = paramYYChatRoomsFragment;
    this.e = paramString;
    this.a = (AppInfo.l - DensityUtils.a(paramContext, 30.0F)) / 2;
    this.b = (int)(this.a * 1.272D);
    b();
  }
  
  private void b() {
    this.d = new LinkedList<Integer>();
    this.d.add(Integer.valueOf(2131234106));
    this.d.add(Integer.valueOf(2131234100));
    this.d.add(Integer.valueOf(2131234101));
    this.d.add(Integer.valueOf(2131234102));
    this.d.add(Integer.valueOf(2131234103));
    this.d.add(Integer.valueOf(2131234104));
    this.d.add(Integer.valueOf(2131234105));
  }
  
  public void a() {
    int i = ((Integer)this.d.poll()).intValue();
    this.d.offer(Integer.valueOf(i));
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, YYRoomModel paramYYRoomModel) {
    View view = paramBaseViewHolder.d(2131299065);
    RelativeLayout relativeLayout = (RelativeLayout)paramBaseViewHolder.d(2131299724);
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297798);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131301294);
    ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(2131301295);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131301134);
    FrameLayout frameLayout = (FrameLayout)paramBaseViewHolder.d(2131296888);
    int i = paramBaseViewHolder.getAdapterPosition();
    relativeLayout.setBackgroundResource(((Integer)this.d.get(i % 7)).intValue());
    textView2.setText(paramYYRoomModel.room_name);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("#");
    stringBuilder.append(paramYYRoomModel.room_type);
    shapeTextView.setText(stringBuilder.toString());
    textView1.setText(String.format(this.k.getResources().getString(2131758301), new Object[] { paramYYRoomModel.room_member_count }));
    ImageLoader.a((IRequestHost)this.c.w_(), paramYYRoomModel.avatar).a(2131234356).a(imageView);
    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
    layoutParams.width = this.a;
    layoutParams.height = this.b;
    view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    ((RelativeLayout.LayoutParams)frameLayout.getLayoutParams()).topMargin = (int)(this.b * 0.418D);
    if (!paramYYRoomModel.isUpload) {
      paramYYRoomModel.isUpload = true;
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_DRAW, paramYYRoomModel.room_id, paramYYRoomModel.uid, this.f, paramYYRoomModel.room_type, this.e);
    } 
    relativeLayout.setOnClickListener(new View.OnClickListener(this, paramYYRoomModel) {
          public void onClick(View param1View) {
            if (ClickUtils.a(2131299724, 2000L))
              return; 
            if (LiveFloatManager.a().x()) {
              ToastUtils.a("你正在直播间内，需要退出后操作");
              return;
            } 
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_CLICK, this.a.room_id, this.a.uid, ((YYChatRoomsPresenter)YYRoomAdapter.a(this.b).s()).q(), this.a.room_type, YYRoomAdapter.b(this.b));
            YYRoomAdapter.a(this.b).a(this.a);
          }
        });
  }
  
  public void a(String paramString) {
    this.f = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\adapter\YYRoomAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */