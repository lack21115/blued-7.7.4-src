package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveRewardListModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.view.PopRewardListView;
import java.util.ArrayList;
import java.util.List;

public class RewardListAdapter extends BaseAdapter {
  private Context a;
  
  private LayoutInflater b;
  
  private LoadOptions c;
  
  private BaseFragment d;
  
  private PopRewardListView e;
  
  private List<LiveRewardListModel> f = new ArrayList<LiveRewardListModel>();
  
  private long g;
  
  public RewardListAdapter(BaseFragment paramBaseFragment, PopRewardListView paramPopRewardListView) {
    this.a = paramBaseFragment.getContext();
    this.d = paramBaseFragment;
    this.e = paramPopRewardListView;
    this.b = LayoutInflater.from(this.a);
    this.c = new LoadOptions();
    this.c.b = R.drawable.user_bg_round;
    this.c.d = R.drawable.user_bg_round;
  }
  
  public void a(long paramLong) {
    this.g = paramLong;
  }
  
  public void a(List<LiveRewardListModel> paramList) {
    this.f.clear();
    for (LiveRewardListModel liveRewardListModel : paramList) {
      if (liveRewardListModel.uid == this.g) {
        liveRewardListModel.is_best = true;
        break;
      } 
    } 
    this.f.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void b(List<LiveRewardListModel> paramList) {
    for (LiveRewardListModel liveRewardListModel : paramList) {
      if (liveRewardListModel.uid == this.g) {
        liveRewardListModel.is_best = true;
        break;
      } 
    } 
    this.f.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount() {
    return this.f.size();
  }
  
  public Object getItem(int paramInt) {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    if (paramView == null) {
      viewHolder1 = new ViewHolder();
      View view = this.b.inflate(R.layout.live_reward_list_item, paramViewGroup, false);
      ViewHolder.a(viewHolder1, (ImageView)view.findViewById(R.id.header_view));
      ViewHolder.b(viewHolder1, (ImageView)view.findViewById(R.id.img_verify));
      ViewHolder.a(viewHolder1, (TextView)view.findViewById(R.id.reward_name));
      ViewHolder.b(viewHolder1, (TextView)view.findViewById(R.id.reward_time));
      ViewHolder.c(viewHolder1, (TextView)view.findViewById(R.id.reward_beans));
      ViewHolder.c(viewHolder1, (ImageView)view.findViewById(R.id.iv_beans));
      ViewHolder.a(viewHolder1, (LinearLayout)view.findViewById(R.id.beast_layout));
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    LiveRewardListModel liveRewardListModel = this.f.get(paramInt);
    ImageLoader.a(null, liveRewardListModel.avatar).a(R.drawable.user_bg_round).c().a(ViewHolder.a(viewHolder1));
    LiveRoomInfo.a().a(ViewHolder.b(viewHolder1), liveRewardListModel.vbadge);
    if (!TextUtils.isEmpty(liveRewardListModel.name)) {
      ViewHolder.c(viewHolder1).setText(liveRewardListModel.name);
    } else {
      ViewHolder.c(viewHolder1).setText("");
    } 
    ViewHolder.d(viewHolder1).setText(LiveTimeAndDateUtils.b(String.valueOf(liveRewardListModel.time)));
    if (liveRewardListModel.is_prize == 1) {
      ViewHolder.e(viewHolder1).setText("1");
      ViewHolder.f(viewHolder1).setImageResource(R.drawable.live_reward_list_header_gift_icon);
    } else {
      ViewHolder.e(viewHolder1).setText(CommonStringUtils.d(Double.toString(liveRewardListModel.beans)));
      ViewHolder.f(viewHolder1).setImageResource(R.drawable.live_reward_list_header_bean_icon);
    } 
    if (liveRewardListModel.is_best) {
      ViewHolder.g(viewHolder1).setVisibility(0);
    } else {
      ViewHolder.g(viewHolder1).setVisibility(4);
    } 
    ViewHolder.a(viewHolder1).setOnClickListener(new View.OnClickListener(this, liveRewardListModel) {
          public void onClick(View param1View) {
            if (RewardListAdapter.a(this.b) instanceof RecordingOnliveFragment) {
              ((RecordingOnliveFragment)RewardListAdapter.a(this.b)).cG.b(this.a.name);
              return;
            } 
            if (RewardListAdapter.a(this.b) instanceof com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment)
              LiveSetDataObserver.a().d(this.a.name); 
          }
        });
    return (View)viewHolder2;
  }
  
  class ViewHolder {
    private ImageView b;
    
    private ImageView c;
    
    private TextView d;
    
    private TextView e;
    
    private TextView f;
    
    private ImageView g;
    
    private LinearLayout h;
    
    private ViewHolder(RewardListAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\RewardListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */