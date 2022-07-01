package com.blued.android.module.live_china.adapter;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
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
import java.util.ArrayList;
import java.util.List;

public class LiveRankGuestListItemAdapter extends BaseAdapter {
  private LayoutInflater a;
  
  private Context b;
  
  private Fragment c;
  
  private List<BluedLiveRankListData> d;
  
  private LoadOptions e;
  
  private LoadOptions f;
  
  private LoadOptions g;
  
  private String h;
  
  private boolean i;
  
  private IRequestHost j;
  
  private Dialog k;
  
  private boolean l;
  
  public LiveRankGuestListItemAdapter(Fragment paramFragment, List<BluedLiveRankListData> paramList, boolean paramBoolean1, boolean paramBoolean2, IRequestHost paramIRequestHost) {
    this.c = paramFragment;
    this.b = paramFragment.getContext();
    this.d = paramList;
    this.a = LayoutInflater.from(this.b);
    this.e = new LoadOptions();
    this.e.d = R.drawable.live_bg;
    this.e.b = R.drawable.live_bg;
    this.e.a(750, 750);
    this.f = new LoadOptions();
    this.f.d = R.drawable.live_list_item_card_img;
    this.f.b = R.drawable.live_list_item_card_img;
    this.g = new LoadOptions();
    this.g.d = R.drawable.user_bg_round;
    this.g.b = R.drawable.user_bg_round;
    this.i = paramBoolean1;
    this.j = paramIRequestHost;
    this.l = paramBoolean2;
    this.k = DialogUtils.a(this.b);
  }
  
  public void a(String paramString) {
    this.h = paramString;
  }
  
  public void a(List<BluedLiveRankListData> paramList) {
    List<BluedLiveRankListData> list = this.d;
    if (list == null) {
      this.d = new ArrayList<BluedLiveRankListData>();
    } else {
      list.clear();
    } 
    b(paramList);
  }
  
  public void b(List<BluedLiveRankListData> paramList) {
    if (this.d == null)
      this.d = new ArrayList<BluedLiveRankListData>(); 
    this.d.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount() {
    return this.d.size();
  }
  
  public Object getItem(int paramInt) {
    return this.d.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    if (paramView == null) {
      viewHolder1 = new ViewHolder();
      View view = this.a.inflate(R.layout.item_live_rank_guest, paramViewGroup, false);
      viewHolder1.a = (ImageView)view.findViewById(R.id.live_end_user_pic);
      viewHolder1.b = (ImageView)view.findViewById(R.id.img_verify);
      viewHolder1.c = (TextView)view.findViewById(R.id.tv_live_rank);
      viewHolder1.d = (TextView)view.findViewById(R.id.live_user_name);
      viewHolder1.e = (TextView)view.findViewById(R.id.live_user_score);
      viewHolder1.f = (ImageView)view.findViewById(R.id.img_viewer);
      viewHolder1.g = (LinearLayout)view.findViewById(R.id.ll_live_rank_name);
      viewHolder1.h = (TextView)view.findViewById(R.id.tv_score_label);
      viewHolder1.i = (TextView)view.findViewById(R.id.tv_attention);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    BluedLiveRankListData bluedLiveRankListData = this.d.get(paramInt);
    if (bluedLiveRankListData != null) {
      if (bluedLiveRankListData.active == 1) {
        viewHolder1.f.setVisibility(0);
      } else {
        viewHolder1.f.setVisibility(8);
      } 
      if (paramInt == 0) {
        viewHolder1.c.setText("");
        viewHolder1.c.setBackground(this.b.getResources().getDrawable(R.drawable.live_rank_one));
      } else if (paramInt == 1) {
        viewHolder1.c.setText("");
        viewHolder1.c.setBackground(this.b.getResources().getDrawable(R.drawable.live_rank_two));
      } else if (paramInt == 2) {
        viewHolder1.c.setText("");
        viewHolder1.c.setBackground(this.b.getResources().getDrawable(R.drawable.live_rank_three));
      } else {
        if (paramInt < 9) {
          TextView textView = viewHolder1.c;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("0");
          stringBuilder.append(String.valueOf(paramInt + 1));
          textView.setText(stringBuilder.toString());
        } else {
          viewHolder1.c.setText(String.valueOf(paramInt + 1));
        } 
        viewHolder1.c.setBackground(null);
      } 
      ImageLoader.a(this.j, bluedLiveRankListData.avatar).a(R.drawable.user_bg_round).c().a(viewHolder1.a);
      if ("0".equals(Integer.valueOf(bluedLiveRankListData.vbadge))) {
        viewHolder1.b.setVisibility(8);
        viewHolder1.b.setImageDrawable(this.b.getResources().getDrawable(R.drawable.v_gray));
      } else {
        viewHolder1.b.setVisibility(0);
        LiveRoomInfo.a().a(viewHolder1.b, bluedLiveRankListData.vbadge);
        LiveRoomInfo.a().a(viewHolder1.b, bluedLiveRankListData.vbadge);
      } 
      viewHolder1.a.setOnClickListener(new View.OnClickListener(this, bluedLiveRankListData) {
            public void onClick(View param1View) {
              if (LiveRankGuestListItemAdapter.a(this.b) == null)
                return; 
              if (LiveRankGuestListItemAdapter.a(this.b) instanceof DialogFragment) {
                ((DialogFragment)LiveRankGuestListItemAdapter.a(this.b)).dismiss();
              } else if (LiveRankGuestListItemAdapter.a(this.b).getParentFragment() != null && LiveRankGuestListItemAdapter.a(this.b).getParentFragment() instanceof DialogFragment) {
                ((DialogFragment)LiveRankGuestListItemAdapter.a(this.b).getParentFragment()).dismiss();
              } 
              LiveSetDataObserver.a().e(this.a.uid);
            }
          });
      viewHolder1.g.setOnClickListener(new View.OnClickListener(this, bluedLiveRankListData) {
            public void onClick(View param1View) {
              if (LiveRankGuestListItemAdapter.a(this.b) == null)
                return; 
              if (LiveRankGuestListItemAdapter.a(this.b) instanceof DialogFragment) {
                ((DialogFragment)LiveRankGuestListItemAdapter.a(this.b)).dismiss();
              } else if (LiveRankGuestListItemAdapter.a(this.b).getParentFragment() != null && LiveRankGuestListItemAdapter.a(this.b).getParentFragment() instanceof DialogFragment) {
                ((DialogFragment)LiveRankGuestListItemAdapter.a(this.b).getParentFragment()).dismiss();
              } 
              LiveSetDataObserver.a().e(this.a.uid);
            }
          });
      viewHolder1.d.setText(bluedLiveRankListData.name);
      if (TextUtils.isEmpty(this.h)) {
        if (this.l) {
          viewHolder1.h.setText(this.b.getString(R.string.live_rank_consumption_short));
        } else {
          viewHolder1.h.setText(this.b.getString(R.string.live_rank_month_consumption_short));
        } 
        String str = String.valueOf(CommonStringUtils.d(String.valueOf(bluedLiveRankListData.beans)));
        viewHolder1.e.setText(str);
      } else {
        viewHolder1.h.setText(this.h);
        String str = String.valueOf(CommonStringUtils.d(String.valueOf(bluedLiveRankListData.score)));
        viewHolder1.e.setText(str);
      } 
      if (this.i) {
        viewHolder1.i.setVisibility(0);
        LiveRoomInfo.a().a(this.b, bluedLiveRankListData.relationship, viewHolder1.i, null, false);
        viewHolder1.i.setOnClickListener(new View.OnClickListener(this, bluedLiveRankListData, viewHolder1) {
              public void onClick(View param1View) {
                if (!LiveRoomInfo.a().b(this.a.relationship))
                  LiveRoomInfo.a().a(LiveRankGuestListItemAdapter.b(this.c), new LiveUserRelationshipUtils.IAddOrRemoveAttentionDone(this) {
                        public void R_() {
                          DialogUtils.a(LiveRankGuestListItemAdapter.c(this.a.c));
                        }
                        
                        public void a(String param2String) {
                          this.a.a.relationship = param2String;
                          LiveRoomInfo.a().a(LiveRankGuestListItemAdapter.b(this.a.c), param2String, this.a.b.i, null, false);
                        }
                        
                        public void b(String param2String) {
                          this.a.a.relationship = param2String;
                          LiveRoomInfo.a().a(LiveRankGuestListItemAdapter.b(this.a.c), param2String, this.a.b.i, null, false);
                        }
                        
                        public void d() {
                          DialogUtils.b(LiveRankGuestListItemAdapter.c(this.a.c));
                        }
                        
                        public void e() {
                          DialogUtils.b(LiveRankGuestListItemAdapter.c(this.a.c));
                        }
                      }this.a.uid, this.a.relationship, "", LiveRankGuestListItemAdapter.d(this.c), true); 
              }
            });
        return (View)viewHolder2;
      } 
      viewHolder1.i.setVisibility(8);
    } 
    return (View)viewHolder2;
  }
  
  class ViewHolder {
    ImageView a;
    
    ImageView b;
    
    TextView c;
    
    TextView d;
    
    TextView e;
    
    ImageView f;
    
    LinearLayout g;
    
    TextView h;
    
    TextView i;
    
    private ViewHolder(LiveRankGuestListItemAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\LiveRankGuestListItemAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */