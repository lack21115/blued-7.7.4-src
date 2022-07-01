package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import java.util.ArrayList;
import java.util.List;

public class LivePKInviteAdapter extends BaseAdapter {
  public Context a;
  
  public List<LiveFriendModel> b;
  
  public LoadOptions c;
  
  public LayoutInflater d;
  
  public LiveInviteListener e;
  
  public int f;
  
  public LivePKInviteAdapter(Context paramContext, LiveInviteListener paramLiveInviteListener) {
    this.a = paramContext;
    this.e = paramLiveInviteListener;
    this.d = LayoutInflater.from(this.a);
    this.b = new ArrayList<LiveFriendModel>();
    int i = (this.a.getResources().getDisplayMetrics()).widthPixels;
    this.c = new LoadOptions();
    this.c.d = R.drawable.user_bg_round;
    this.c.b = R.drawable.user_bg_round;
    LoadOptions loadOptions = this.c;
    i >>= 1;
    loadOptions.a(i, i);
  }
  
  public void a(int paramInt) {
    this.f = paramInt;
  }
  
  public void a(List<LiveFriendModel> paramList) {
    this.b.clear();
    b(paramList);
    notifyDataSetChanged();
  }
  
  public void b(List<LiveFriendModel> paramList) {
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount() {
    return this.b.size();
  }
  
  public Object getItem(int paramInt) {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    if (paramView == null) {
      viewHolder1 = new ViewHolder();
      View view = this.d.inflate(R.layout.item_live_pk_friend_list, paramViewGroup, false);
      ViewHolder.a(viewHolder1, (ImageView)view.findViewById(R.id.img_header));
      ViewHolder.b(viewHolder1, (ImageView)view.findViewById(R.id.img_verify));
      ViewHolder.a(viewHolder1, (TextView)view.findViewById(R.id.tv_name));
      ViewHolder.c(viewHolder1, (ImageView)view.findViewById(R.id.img_vip_icon));
      ViewHolder.b(viewHolder1, (TextView)view.findViewById(R.id.invite_btn));
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    LiveFriendModel liveFriendModel = this.b.get(paramInt);
    LiveRoomInfo.a().a(ViewHolder.a(viewHolder1), liveFriendModel.vbadge);
    ImageLoader.a(null, AvatarUtils.a(0, liveFriendModel.avatar)).a(R.drawable.user_bg_round).c().a(ViewHolder.b(viewHolder1));
    LiveRoomUserModel liveRoomUserModel = new LiveRoomUserModel();
    liveRoomUserModel.vip_grade = liveFriendModel.vip_grade;
    liveRoomUserModel.is_vip_annual = liveFriendModel.is_vip_annual;
    liveRoomUserModel.is_hide_vip_look = liveFriendModel.is_hide_vip_look;
    LiveRoomInfo.a().a(ViewHolder.c(viewHolder1), liveRoomUserModel);
    if (!TextUtils.isEmpty(liveFriendModel.note)) {
      ViewHolder.d(viewHolder1).setText(liveFriendModel.note);
    } else if (!TextUtils.isEmpty(liveFriendModel.name)) {
      ViewHolder.d(viewHolder1).setText(liveFriendModel.name);
    } else {
      ViewHolder.d(viewHolder1).setText("");
    } 
    LiveRoomInfo.a().a(this.a, ViewHolder.d(viewHolder1), liveRoomUserModel, R.color.white);
    if (this.f == 0) {
      ViewHolder.e(viewHolder1).setText(R.string.live_pk_invite);
    } else {
      ViewHolder.e(viewHolder1).setText(R.string.live_connection_invite);
    } 
    ViewHolder.e(viewHolder1).setOnClickListener(new View.OnClickListener(this, liveFriendModel, paramInt) {
          public void onClick(View param1View) {
            if (this.c.e != null)
              this.c.e.a(this.a, this.b); 
          }
        });
    return (View)viewHolder2;
  }
  
  public static interface LiveInviteListener {
    void a(LiveFriendModel param1LiveFriendModel, int param1Int);
  }
  
  class ViewHolder {
    private ImageView b;
    
    private ImageView c;
    
    private TextView d;
    
    private ImageView e;
    
    private TextView f;
    
    private ViewHolder(LivePKInviteAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\LivePKInviteAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */