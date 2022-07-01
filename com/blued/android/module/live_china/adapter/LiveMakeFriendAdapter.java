package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import java.util.ArrayList;
import java.util.List;

public class LiveMakeFriendAdapter extends BaseAdapter {
  public Context a;
  
  public List<LiveFriendModel> b;
  
  public LoadOptions c;
  
  public LayoutInflater d;
  
  public LiveJoinListener e;
  
  public int f;
  
  public ListView g;
  
  public LiveMakeFriendAdapter(Context paramContext, LiveJoinListener paramLiveJoinListener, int paramInt, ListView paramListView) {
    this.a = paramContext;
    this.e = paramLiveJoinListener;
    this.d = LayoutInflater.from(this.a);
    this.f = paramInt;
    this.g = paramListView;
    this.b = new ArrayList<LiveFriendModel>();
    this.c = new LoadOptions();
    this.c.d = R.drawable.user_bg_round;
    this.c.b = R.drawable.user_bg_round;
  }
  
  public void a(LiveFriendModel paramLiveFriendModel) {
    List<LiveFriendModel> list = this.b;
    if (list != null && list.size() > 0) {
      this.b.remove(paramLiveFriendModel);
      notifyDataSetChanged();
    } 
  }
  
  public void a(List<LiveFriendModel> paramList) {
    this.b.clear();
    b(paramList);
  }
  
  public void b(List<LiveFriendModel> paramList) {
    int j;
    this.b.addAll(paramList);
    byte b = 0;
    int i = 0;
    while (true) {
      j = b;
      if (i < paramList.size()) {
        LiveFriendModel liveFriendModel = paramList.get(i);
        if (TextUtils.equals(LiveRoomInfo.a().f(), liveFriendModel.uid)) {
          liveFriendModel.isMyself = 1;
          j = i;
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    notifyDataSetChanged();
    if (j != 0)
      AppInfo.n().post(new Runnable(this, j) {
            public void run() {
              this.b.g.smoothScrollToPositionFromTop(this.a, DensityUtils.a(this.b.a, 120.0F));
            }
          }); 
  }
  
  public int getCount() {
    return this.b.size();
  }
  
  public Object getItem(int paramInt) {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    if (paramView == null) {
      viewHolder1 = new ViewHolder();
      View view = this.d.inflate(R.layout.item_live_make_friend_list, paramViewGroup, false);
      ViewHolder.a(viewHolder1, (ImageView)view.findViewById(R.id.img_header));
      ViewHolder.b(viewHolder1, (ImageView)view.findViewById(R.id.img_verify));
      ViewHolder.a(viewHolder1, (TextView)view.findViewById(R.id.tv_name));
      ViewHolder.c(viewHolder1, (ImageView)view.findViewById(R.id.img_vip_icon));
      ViewHolder.b(viewHolder1, (TextView)view.findViewById(R.id.tv_join));
      ViewHolder.c(viewHolder1, (TextView)view.findViewById(R.id.tv_ignore));
      ViewHolder.d(viewHolder1, (TextView)view.findViewById(R.id.tv_number));
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
    LiveRoomInfo.a().a(this.a, ViewHolder.d(viewHolder1), liveRoomUserModel, R.color.syc_dark_h);
    ViewHolder.b(viewHolder1).setOnClickListener(new View.OnClickListener(this, liveFriendModel, paramInt) {
          public void onClick(View param1View) {
            if (this.c.e != null)
              this.c.e.a(this.a, this.b); 
          }
        });
    ViewHolder.d(viewHolder1).setOnClickListener(new View.OnClickListener(this, liveFriendModel, paramInt) {
          public void onClick(View param1View) {
            if (this.c.e != null)
              this.c.e.a(this.a, this.b); 
          }
        });
    ViewHolder.e(viewHolder1).setOnClickListener(new View.OnClickListener(this, viewHolder1, liveFriendModel, paramInt) {
          public void onClick(View param1View) {
            if (this.d.e != null) {
              LiveMakeFriendAdapter.ViewHolder.e(this.a).setEnabled(false);
              this.d.e.a(this.b, this.c, LiveMakeFriendAdapter.ViewHolder.e(this.a));
            } 
          }
        });
    ViewHolder.f(viewHolder1).setOnClickListener(new View.OnClickListener(this, viewHolder1, liveFriendModel, paramInt) {
          public void onClick(View param1View) {
            if (this.d.e != null) {
              LiveMakeFriendAdapter.ViewHolder.f(this.a).setEnabled(false);
              this.d.e.b(this.b, this.c, LiveMakeFriendAdapter.ViewHolder.f(this.a));
            } 
          }
        });
    TextView textView = ViewHolder.g(viewHolder1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt + 1);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    if (this.f == 0) {
      ViewHolder.e(viewHolder1).setVisibility(0);
      ViewHolder.f(viewHolder1).setVisibility(0);
    } else {
      ViewHolder.e(viewHolder1).setVisibility(8);
      ViewHolder.f(viewHolder1).setVisibility(8);
    } 
    if (liveFriendModel.isMyself == 1) {
      viewHolder2.setBackgroundColor(Color.parseColor("#33996afb"));
      return (View)viewHolder2;
    } 
    viewHolder2.setBackgroundResource(R.color.transparent);
    return (View)viewHolder2;
  }
  
  public static interface LiveJoinListener {
    void a(LiveFriendModel param1LiveFriendModel, int param1Int);
    
    void a(LiveFriendModel param1LiveFriendModel, int param1Int, TextView param1TextView);
    
    void b(LiveFriendModel param1LiveFriendModel, int param1Int, TextView param1TextView);
  }
  
  class ViewHolder {
    private ImageView b;
    
    private ImageView c;
    
    private TextView d;
    
    private ImageView e;
    
    private TextView f;
    
    private TextView g;
    
    private TextView h;
    
    private ViewHolder(LiveMakeFriendAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\LiveMakeFriendAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */