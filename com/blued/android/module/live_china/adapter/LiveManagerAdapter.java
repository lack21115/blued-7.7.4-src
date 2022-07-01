package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveUserinfoModel;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;
import java.util.List;

public class LiveManagerAdapter extends BaseAdapter {
  public Context a;
  
  public List<LiveUserinfoModel> b;
  
  public LoadOptions c;
  
  public LayoutInflater d;
  
  public IRequestHost e;
  
  private String f;
  
  public LiveManagerAdapter(Context paramContext, String paramString, IRequestHost paramIRequestHost) {
    this.a = paramContext;
    this.d = LayoutInflater.from(this.a);
    this.b = new ArrayList<LiveUserinfoModel>();
    int i = (this.a.getResources().getDisplayMetrics()).widthPixels;
    this.c = new LoadOptions();
    this.c.d = R.drawable.user_bg_round;
    this.c.b = R.drawable.user_bg_round;
    LoadOptions loadOptions = this.c;
    i >>= 1;
    loadOptions.a(i, i);
    this.f = paramString;
    this.e = paramIRequestHost;
  }
  
  public LiveUserinfoModel a(int paramInt) {
    return this.b.get(paramInt);
  }
  
  public void a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<LiveUserinfoModel>>(this, paramString) {
            boolean a = false;
            
            protected void a(BluedEntityA<LiveUserinfoModel> param1BluedEntityA) {
              if (param1BluedEntityA != null && param1BluedEntityA.hasData())
                for (int i = 0; i < this.c.b.size(); i++) {
                  if (this.b.equalsIgnoreCase(((LiveUserinfoModel)this.c.b.get(i)).uid)) {
                    ((LiveUserinfoModel)this.c.b.get(i)).is_manager = 1;
                    ((LiveUserinfoModel)this.c.b.get(i)).last_is_manager = 1;
                    this.c.notifyDataSetChanged();
                    return;
                  } 
                }  
            }
            
            public boolean onUIFailure(int param1Int, String param1String) {
              this.a = true;
              return super.onUIFailure(param1Int, param1String);
            }
            
            public void onUIFinish() {
              super.onUIFinish();
              if (this.a) {
                for (int i = 0; i < this.c.b.size(); i++) {
                  if (this.b.equalsIgnoreCase(((LiveUserinfoModel)this.c.b.get(i)).uid)) {
                    ((LiveUserinfoModel)this.c.b.get(i)).is_manager = ((LiveUserinfoModel)this.c.b.get(i)).last_is_manager;
                    this.c.notifyDataSetChanged();
                    break;
                  } 
                } 
                this.a = false;
              } 
            }
          }this.e, this.f, paramString);
      return;
    } 
    for (int i = 0; i < this.b.size(); i++) {
      if (paramString.equalsIgnoreCase(((LiveUserinfoModel)this.b.get(i)).uid)) {
        ((LiveUserinfoModel)this.b.get(i)).is_manager = ((LiveUserinfoModel)this.b.get(i)).last_is_manager;
        notifyDataSetChanged();
        AppMethods.a(this.a.getResources().getString(R.string.common_net_error));
        return;
      } 
    } 
  }
  
  public void a(List<LiveUserinfoModel> paramList) {
    if (paramList != null) {
      for (int i = 0; i < paramList.size(); i++) {
        ((LiveUserinfoModel)paramList.get(i)).is_manager = 1;
        ((LiveUserinfoModel)paramList.get(i)).last_is_manager = 1;
      } 
      this.b.addAll(paramList);
    } 
    notifyDataSetChanged();
  }
  
  public void b(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<LiveUserinfoModel>>(this, paramString) {
            boolean a = false;
            
            protected void a(BluedEntityA<LiveUserinfoModel> param1BluedEntityA) {
              if (param1BluedEntityA != null && param1BluedEntityA.hasData())
                for (int i = 0; i < this.c.b.size(); i++) {
                  if (this.b.equalsIgnoreCase(((LiveUserinfoModel)this.c.b.get(i)).uid)) {
                    ((LiveUserinfoModel)this.c.b.get(i)).is_manager = 0;
                    ((LiveUserinfoModel)this.c.b.get(i)).last_is_manager = 0;
                    this.c.notifyDataSetChanged();
                    return;
                  } 
                }  
            }
            
            public boolean onUIFailure(int param1Int, String param1String) {
              this.a = true;
              return super.onUIFailure(param1Int, param1String);
            }
            
            public void onUIFinish() {
              super.onUIFinish();
              if (this.a) {
                for (int i = 0; i < this.c.b.size(); i++) {
                  if (this.b.equalsIgnoreCase(((LiveUserinfoModel)this.c.b.get(i)).uid)) {
                    ((LiveUserinfoModel)this.c.b.get(i)).is_manager = ((LiveUserinfoModel)this.c.b.get(i)).last_is_manager;
                    this.c.notifyDataSetChanged();
                    break;
                  } 
                } 
                this.a = false;
              } 
            }
          }this.e, this.f, paramString); 
  }
  
  public int getCount() {
    return this.b.size();
  }
  
  public long getItemId(int paramInt) {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    if (paramView == null) {
      viewHolder1 = new ViewHolder();
      View view = this.d.inflate(R.layout.item_live_manage_list, paramViewGroup, false);
      ViewHolder.a(viewHolder1, (ImageView)view.findViewById(R.id.img_header));
      ViewHolder.b(viewHolder1, (ImageView)view.findViewById(R.id.img_verify));
      ViewHolder.a(viewHolder1, (TextView)view.findViewById(R.id.tv_name));
      ViewHolder.b(viewHolder1, (TextView)view.findViewById(R.id.tv_info));
      ViewHolder.c(viewHolder1, (TextView)view.findViewById(R.id.tv_city));
      ViewHolder.d(viewHolder1, (TextView)view.findViewById(R.id.tv_operate));
      ViewHolder.c(viewHolder1, (ImageView)view.findViewById(R.id.img_vip_icon));
      ViewHolder.a(viewHolder1, (ProgressBar)view.findViewById(R.id.loading_view));
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    LiveRoomUserModel liveRoomUserModel = (LiveRoomUserModel)this.b.get(paramInt);
    LiveRoomInfo.a().a(ViewHolder.a(viewHolder1), liveRoomUserModel.vbadge);
    ImageLoader.a(null, AvatarUtils.a(0, liveRoomUserModel.avatar)).a(R.drawable.user_bg_round).c().a(ViewHolder.b(viewHolder1));
    LiveRoomInfo.a().a(ViewHolder.c(viewHolder1), liveRoomUserModel);
    if (!TextUtils.isEmpty(liveRoomUserModel.note)) {
      ViewHolder.d(viewHolder1).setText(liveRoomUserModel.note);
    } else if (!TextUtils.isEmpty(liveRoomUserModel.name)) {
      ViewHolder.d(viewHolder1).setText(liveRoomUserModel.name);
    } else {
      ViewHolder.d(viewHolder1).setText("");
    } 
    LiveRoomInfo.a().a(this.a, ViewHolder.d(viewHolder1), liveRoomUserModel, R.color.white);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(liveRoomUserModel.age);
    stringBuilder1.append("");
    String str1 = stringBuilder1.toString();
    String str2 = LiveRoomInfo.a().a(liveRoomUserModel.height, false);
    String str3 = LiveRoomInfo.a().b(liveRoomUserModel.weight, false);
    TextView textView = ViewHolder.e(viewHolder1);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append("/");
    stringBuilder2.append(str2);
    stringBuilder2.append("/");
    stringBuilder2.append(str3);
    stringBuilder2.append("-");
    stringBuilder2.append(LiveRoomInfo.a().c(this.a, liveRoomUserModel.role));
    textView.setText(stringBuilder2.toString());
    if (!TextUtils.isEmpty(liveRoomUserModel.city_settled)) {
      ViewHolder.f(viewHolder1).setText(LiveRoomInfo.a().a(liveRoomUserModel.city_settled));
    } else {
      ViewHolder.f(viewHolder1).setText("");
    } 
    LiveRoomInfo.a().a(this.a, ViewHolder.f(viewHolder1), liveRoomUserModel.is_hide_city_settled, 1);
    int i = liveRoomUserModel.is_manager;
    if (i != -1) {
      if (i != 0) {
        ViewHolder.g(viewHolder1).setVisibility(8);
        ViewHolder.h(viewHolder1).setVisibility(0);
        ViewHolder.h(viewHolder1).setText(this.a.getString(R.string.live_cancel_manage));
        ViewHolder.h(viewHolder1).setBackground(this.a.getResources().getDrawable(R.drawable.shape_user_card_cancel_manager));
        ViewHolder.h(viewHolder1).setOnClickListener(new View.OnClickListener(this, liveRoomUserModel, paramInt) {
              public void onClick(View param1View) {
                CommonAlertDialog.a(this.c.a, null, "", this.c.a.getString(R.string.sure_to_remove_manager), "", "", new DialogInterface.OnClickListener(this) {
                      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                        this.a.c.b(this.a.a.uid);
                        ((LiveUserinfoModel)this.a.c.b.get(this.a.b)).is_manager = -1;
                        this.a.c.notifyDataSetChanged();
                      }
                    },  null, null, true);
              }
            });
        return (View)viewHolder2;
      } 
      ViewHolder.g(viewHolder1).setVisibility(8);
      ViewHolder.h(viewHolder1).setVisibility(0);
      ViewHolder.h(viewHolder1).setText(this.a.getString(R.string.live_set_manager));
      ViewHolder.h(viewHolder1).setBackground(this.a.getResources().getDrawable(R.drawable.shape_user_card_set_manager));
      ViewHolder.h(viewHolder1).setOnClickListener(new View.OnClickListener(this, liveRoomUserModel, paramInt) {
            public void onClick(View param1View) {
              this.c.a(this.a.uid);
              ((LiveUserinfoModel)this.c.b.get(this.b)).is_manager = -1;
              this.c.notifyDataSetChanged();
            }
          });
      return (View)viewHolder2;
    } 
    ViewHolder.g(viewHolder1).setVisibility(0);
    ViewHolder.h(viewHolder1).setVisibility(8);
    return (View)viewHolder2;
  }
  
  class ViewHolder {
    private ImageView b;
    
    private ImageView c;
    
    private TextView d;
    
    private TextView e;
    
    private TextView f;
    
    private TextView g;
    
    private ImageView h;
    
    private ProgressBar i;
    
    private ViewHolder(LiveManagerAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\LiveManagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */