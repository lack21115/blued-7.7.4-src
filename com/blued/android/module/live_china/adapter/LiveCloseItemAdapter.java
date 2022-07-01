package com.blued.android.module.live_china.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.BluedLiveRankListData;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import java.util.List;

public class LiveCloseItemAdapter extends BaseAdapter {
  private LayoutInflater a;
  
  private Context b;
  
  private List<BluedLiveRankListData> c;
  
  private LoadOptions d;
  
  private boolean e;
  
  private IRequestHost f;
  
  private Dialog g;
  
  public LiveCloseItemAdapter(Context paramContext, List<BluedLiveRankListData> paramList, boolean paramBoolean, IRequestHost paramIRequestHost) {
    this.b = paramContext;
    this.c = paramList;
    this.a = LayoutInflater.from(paramContext);
    this.d = new LoadOptions();
    this.d.d = R.drawable.user_bg_round;
    this.d.b = R.drawable.user_bg_round;
    this.e = paramBoolean;
    this.f = paramIRequestHost;
    this.g = DialogUtils.a(paramContext);
  }
  
  public int getCount() {
    return this.c.size();
  }
  
  public Object getItem(int paramInt) {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    if (paramView == null) {
      viewHolder1 = new ViewHolder();
      View view = this.a.inflate(R.layout.item_live_close_guest, paramViewGroup, false);
      viewHolder1.b = (ImageView)view.findViewById(R.id.live_end_user_pic);
      viewHolder1.a = (ImageView)view.findViewById(R.id.live_end_header_bg);
      viewHolder1.e = (TextView)view.findViewById(R.id.live_user_name);
      viewHolder1.f = (TextView)view.findViewById(R.id.live_user_score);
      viewHolder1.h = (LinearLayout)view.findViewById(R.id.ll_live_rank_name);
      viewHolder1.i = (ImageView)view.findViewById(R.id.img_score_icon);
      viewHolder1.k = (TextView)view.findViewById(R.id.tv_attention);
      viewHolder1.j = (ImageView)view.findViewById(R.id.img_attention);
      viewHolder1.g = (ImageView)view.findViewById(R.id.img_viewer);
      viewHolder1.c = (ImageView)view.findViewById(R.id.img_verify);
      viewHolder1.d = (TextView)view.findViewById(R.id.tv_live_rank);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    BluedLiveRankListData bluedLiveRankListData = this.c.get(paramInt);
    if (bluedLiveRankListData != null) {
      if (bluedLiveRankListData.active == 1) {
        viewHolder1.g.setVisibility(0);
      } else {
        viewHolder1.g.setVisibility(8);
      } 
      viewHolder1.a.setVisibility(0);
      viewHolder1.d.setVisibility(8);
      if (paramInt == 0) {
        viewHolder1.a.setBackgroundResource(R.drawable.live_close_host_rank_header1);
      } else if (paramInt == 1) {
        viewHolder1.a.setBackgroundResource(R.drawable.live_close_host_rank_header2);
      } else if (paramInt == 2) {
        viewHolder1.a.setBackgroundResource(R.drawable.live_close_host_rank_header3);
      } else {
        viewHolder1.a.setVisibility(4);
        viewHolder1.d.setVisibility(0);
        if (paramInt < 9) {
          TextView textView = viewHolder1.d;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("0");
          stringBuilder.append(String.valueOf(paramInt + 1));
          textView.setText(stringBuilder.toString());
        } else {
          viewHolder1.d.setText(String.valueOf(paramInt + 1));
        } 
      } 
      ImageLoader.a(this.f, bluedLiveRankListData.avatar).a(R.drawable.user_bg_round).c().a(viewHolder1.b);
      if ("0".equals(Integer.valueOf(bluedLiveRankListData.vbadge))) {
        viewHolder1.c.setVisibility(8);
        viewHolder1.c.setImageDrawable(this.b.getResources().getDrawable(R.drawable.v_gray));
      } else {
        viewHolder1.c.setVisibility(0);
        LiveRoomInfo.a().a(viewHolder1.c, bluedLiveRankListData.vbadge);
      } 
      viewHolder1.b.setOnClickListener(new View.OnClickListener(this, bluedLiveRankListData) {
            public void onClick(View param1View) {
              List<DialogFragment> list = ((FragmentActivity)LiveCloseItemAdapter.a(this.b)).getSupportFragmentManager().getFragments();
              if (list != null && list.size() >= 2 && list.get(1) instanceof DialogFragment && list.get(1) != null)
                ((DialogFragment)list.get(1)).dismiss(); 
              LiveSetDataObserver.a().e(this.a.uid);
            }
          });
      viewHolder1.h.setOnClickListener(new View.OnClickListener(this, bluedLiveRankListData) {
            public void onClick(View param1View) {
              List<DialogFragment> list = ((FragmentActivity)LiveCloseItemAdapter.a(this.b)).getSupportFragmentManager().getFragments();
              if (list != null && list.size() >= 2 && list.get(1) instanceof DialogFragment && list.get(1) != null)
                ((DialogFragment)list.get(1)).dismiss(); 
              LiveSetDataObserver.a().e(this.a.uid);
            }
          });
      viewHolder1.e.setText(bluedLiveRankListData.name);
      viewHolder1.i.setVisibility(0);
      String str = String.valueOf(CommonStringUtils.d(String.valueOf(bluedLiveRankListData.beans)));
      viewHolder1.f.setText(str);
      if (this.e) {
        viewHolder1.k.setVisibility(0);
        LiveUserRelationshipUtils.b(this.b, bluedLiveRankListData.relationship, viewHolder1.k, viewHolder1.j);
        viewHolder1.k.setOnClickListener(new View.OnClickListener(this, bluedLiveRankListData, viewHolder1) {
              public void onClick(View param1View) {
                if (!LiveRoomInfo.a().b(this.a.relationship))
                  LiveRoomInfo.a().a(LiveCloseItemAdapter.a(this.c), new LiveUserRelationshipUtils.IAddOrRemoveAttentionDone(this) {
                        public void R_() {
                          DialogUtils.a(LiveCloseItemAdapter.b(this.a.c));
                        }
                        
                        public void a(String param2String) {
                          this.a.a.relationship = param2String;
                          LiveRoomInfo.a().a(LiveCloseItemAdapter.a(this.a.c), param2String, this.a.b.k, null, false);
                        }
                        
                        public void b(String param2String) {
                          this.a.a.relationship = param2String;
                          LiveRoomInfo.a().a(LiveCloseItemAdapter.a(this.a.c), param2String, this.a.b.k, null, false);
                        }
                        
                        public void d() {
                          DialogUtils.b(LiveCloseItemAdapter.b(this.a.c));
                        }
                        
                        public void e() {
                          DialogUtils.b(LiveCloseItemAdapter.b(this.a.c));
                        }
                      }this.a.uid, this.a.relationship, "", LiveCloseItemAdapter.c(this.c), true); 
              }
            });
        return (View)viewHolder2;
      } 
      viewHolder1.k.setVisibility(8);
    } 
    return (View)viewHolder2;
  }
  
  class ViewHolder {
    public ImageView a;
    
    ImageView b;
    
    ImageView c;
    
    TextView d;
    
    TextView e;
    
    TextView f;
    
    ImageView g;
    
    LinearLayout h;
    
    ImageView i;
    
    ImageView j;
    
    TextView k;
    
    private ViewHolder(LiveCloseItemAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\LiveCloseItemAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */