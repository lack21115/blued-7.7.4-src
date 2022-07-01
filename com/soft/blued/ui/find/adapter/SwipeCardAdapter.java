package com.soft.blued.ui.find.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.login.LoginAndRegisterProtos;
import com.soft.blued.customview.swipecard.SwipeFlingAdapterView;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SwipeCardAdapter extends BaseAdapter {
  public List<BluedRecommendUsers> a = new ArrayList<BluedRecommendUsers>();
  
  private Context b;
  
  private SwipeFlingAdapterView c;
  
  private View.OnClickListener d;
  
  private ActivityFragmentActive e;
  
  private Dialog f;
  
  private List<BluedRecommendUsers> g = new ArrayList<BluedRecommendUsers>();
  
  private int h = 0;
  
  private int i = 0;
  
  private boolean j = false;
  
  private SwipeCardListener k = null;
  
  private HashSet<String> l = new HashSet<String>();
  
  private int m;
  
  public SwipeCardAdapter(Context paramContext, SwipeFlingAdapterView paramSwipeFlingAdapterView, View.OnClickListener paramOnClickListener, ActivityFragmentActive paramActivityFragmentActive, Dialog paramDialog) {
    this.b = paramContext;
    this.c = paramSwipeFlingAdapterView;
    this.d = paramOnClickListener;
    this.e = paramActivityFragmentActive;
    this.f = paramDialog;
    this.i = paramSwipeFlingAdapterView.getVisibleCount();
  }
  
  public int a() {
    return this.h;
  }
  
  public void a(int paramInt) {
    if (paramInt > -1)
      this.g.size(); 
  }
  
  public void a(SwipeCardListener paramSwipeCardListener) {
    this.k = paramSwipeCardListener;
  }
  
  public void a(List<BluedRecommendUsers> paramList) {
    this.l.clear();
    this.a.clear();
    int i = 0;
    this.m = 0;
    if (paramList != null && paramList.size() > 0)
      while (i < paramList.size()) {
        BluedRecommendUsers bluedRecommendUsers = paramList.get(i);
        if (!this.l.contains(bluedRecommendUsers.uid)) {
          this.a.add(bluedRecommendUsers);
          this.l.add(bluedRecommendUsers.uid);
        } 
        i++;
      }  
    this.c.setTag(2131296875, Integer.valueOf(a()));
    this.c.setTag(2131300307, Integer.valueOf(this.a.size()));
    c(this.h);
  }
  
  public void a(boolean paramBoolean) {
    this.j = paramBoolean;
  }
  
  public void b() {
    this.h--;
    c(this.h);
  }
  
  public void b(int paramInt) {
    if (paramInt >= 0) {
      List<BluedRecommendUsers> list = this.a;
      if (list != null) {
        if (paramInt >= list.size())
          return; 
        InstantLog.c("target_from_guide", ((BluedRecommendUsers)this.a.get(paramInt)).uid);
      } 
    } 
  }
  
  public void b(List<BluedRecommendUsers> paramList) {
    if (paramList != null && paramList.size() > 0)
      for (int i = 0; i < paramList.size(); i++) {
        BluedRecommendUsers bluedRecommendUsers = paramList.get(i);
        if (!this.l.contains(bluedRecommendUsers.uid)) {
          this.a.add(bluedRecommendUsers);
          this.l.add(bluedRecommendUsers.uid);
        } else {
          this.m++;
        } 
      }  
    this.c.setTag(2131296875, Integer.valueOf(a()));
    this.c.setTag(2131300307, Integer.valueOf(this.a.size()));
    c(this.h);
  }
  
  public void c() {
    this.h++;
    Logger.b("swipecard", new Object[] { "pointerForward", Integer.valueOf(this.h) });
    c(this.h);
    if (this.k != null && this.a.size() - 1 == this.h && !this.j)
      this.k.a(); 
  }
  
  public void c(int paramInt) {
    this.h = paramInt;
    paramInt = this.h;
    if (paramInt >= 0) {
      if (paramInt >= this.a.size())
        return; 
      this.g.clear();
      this.g.add(this.a.get(this.h));
      paramInt = this.h;
      while (true) {
        int i = paramInt + 1;
        paramInt = this.h;
        if (i <= this.i / 2 + paramInt) {
          paramInt = i;
          if (i < this.a.size()) {
            this.g.add(this.a.get(i));
            paramInt = i;
          } 
          continue;
        } 
        paramInt--;
        while (true) {
          i = this.h;
          if (paramInt >= i - this.i / 2) {
            if (paramInt >= 0)
              this.g.add(this.a.get(paramInt)); 
            paramInt--;
            continue;
          } 
          SwipeFlingAdapterView swipeFlingAdapterView = this.c;
          if (swipeFlingAdapterView != null) {
            swipeFlingAdapterView.setTag(2131296875, Integer.valueOf(i));
            this.c.setTag(2131300307, Integer.valueOf(this.a.size()));
          } 
          notifyDataSetChanged();
          BluedRecommendUsers bluedRecommendUsers = this.a.get(this.h);
          this.c.post(new Runnable(this, bluedRecommendUsers) {
                public void run() {
                  if (SwipeCardAdapter.a(this.b).getVisibility() == 0 && !this.a.isSwipeVisibility) {
                    this.a.isSwipeVisibility = true;
                    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.RECOMMEND_PAGE_POP_UPS_SHOW, this.a.uid);
                  } 
                }
              });
          break;
        } 
        break;
      } 
    } 
  }
  
  public BluedRecommendUsers d(int paramInt) {
    List<BluedRecommendUsers> list = this.g;
    return (list == null || list.size() == 0) ? null : this.g.get(paramInt);
  }
  
  public int getCount() {
    return this.g.size();
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    if (paramView == null) {
      viewHolder1 = new ViewHolder();
      View view = LayoutInflater.from(this.b).inflate(2131493280, paramViewGroup, false);
      viewHolder1.a = (TextView)view.findViewById(2131296655);
      viewHolder1.e = (ImageView)view.findViewById(2131296656);
      viewHolder1.c = (TextView)view.findViewById(2131296654);
      viewHolder1.b = (TextView)view.findViewById(2131296650);
      viewHolder1.h = (ImageView)view.findViewById(2131299507);
      viewHolder1.d = (TextView)view.findViewById(2131296653);
      viewHolder1.f = (TextView)view.findViewById(2131296648);
      viewHolder1.g = (ImageView)view.findViewById(2131296788);
      viewHolder1.j = (ImageView)view.findViewById(2131296652);
      viewHolder1.k = (TextView)view.findViewById(2131296657);
      viewHolder1.i = (RelativeLayout)view.findViewById(2131296478);
      viewHolder1.l = (ImageView)view.findViewById(2131297575);
      viewHolder1.m = (ImageView)view.findViewById(2131297447);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    BluedRecommendUsers bluedRecommendUsers = this.g.get(paramInt);
    viewHolder1.g.setOnClickListener(this.d);
    ImageLoader.a((IRequestHost)this.e, AvatarUtils.a(0, bluedRecommendUsers.avatar)).c().a(2131234356).a(viewHolder1.h);
    viewHolder1.a.setText(bluedRecommendUsers.name);
    if ("0.5".equals(bluedRecommendUsers.role)) {
      viewHolder1.e.setImageResource(2131232794);
    } else if ("1".equals(bluedRecommendUsers.role)) {
      viewHolder1.e.setImageResource(2131232793);
    } else if ("0".equals(bluedRecommendUsers.role)) {
      viewHolder1.e.setImageResource(2131232792);
    } else {
      viewHolder1.e.setImageResource(2131232795);
    } 
    UserRelationshipUtils.a(bluedRecommendUsers.relationship, viewHolder1.k, viewHolder1.j);
    if (!StringUtils.e(bluedRecommendUsers.distance))
      viewHolder1.b.setText(DistanceUtils.a(bluedRecommendUsers.distance, BlueAppLocal.c(), true)); 
    if (!StringUtils.e(bluedRecommendUsers.last_operate)) {
      String str1 = TimeAndDateUtils.f(this.b, TimeAndDateUtils.b(bluedRecommendUsers.last_operate));
      viewHolder1.c.setText(str1);
    } 
    String str = String.format(this.b.getString(2131755737), new Object[] { bluedRecommendUsers.age, StringUtils.a(bluedRecommendUsers.height, BlueAppLocal.c(), true), StringUtils.b(bluedRecommendUsers.weight, BlueAppLocal.c(), true) });
    viewHolder1.d.setText(str);
    viewHolder1.f.setText(AreaUtils.a(bluedRecommendUsers.city_settled, BlueAppLocal.c()));
    UserRelationshipUtils.a(viewHolder1.l, bluedRecommendUsers.vbadge, 1);
    if (!StringUtils.e(bluedRecommendUsers.blued_pic)) {
      viewHolder1.m.setVisibility(0);
      ImageLoader.a((IRequestHost)this.e, bluedRecommendUsers.blued_pic).a(2131231113).a(viewHolder1.m);
    } else {
      viewHolder1.m.setVisibility(8);
    } 
    viewHolder1.i.setOnClickListener(new View.OnClickListener(this, bluedRecommendUsers) {
          public void onClick(View param1View) {
            if (!"0".equals(this.a.relationship) && !"2".equals(this.a.relationship))
              return; 
            InstantLog.a("attention_from_guide");
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.RECOMMEND_PAGE_POP_UPS_FOLLOW_CLICK, this.a.uid);
            if (!UserRelationshipUtils.a(this.a.relationship))
              try {
                ActivityFragmentActive activityFragmentActive = SwipeCardAdapter.b(this.b);
                UserRelationshipUtils.a(SwipeCardAdapter.c(this.b), new UserRelationshipUtils.IAddOrRemoveAttentionDone(this) {
                      public void a() {
                        DialogUtils.a(SwipeCardAdapter.e(this.a.b));
                      }
                      
                      public void a(String param2String) {
                        this.a.a.relationship = param2String;
                        ((BluedRecommendUsers)this.a.b.a.get(SwipeCardAdapter.d(this.a.b))).relationship = param2String;
                        (SwipeCardAdapter.a(this.a.b)).a = null;
                        this.a.b.notifyDataSetChanged();
                      }
                      
                      public void b() {
                        DialogUtils.b(SwipeCardAdapter.e(this.a.b));
                      }
                      
                      public void b(String param2String) {
                        this.a.a.relationship = param2String;
                        ((BluedRecommendUsers)this.a.b.a.get(SwipeCardAdapter.d(this.a.b))).relationship = param2String;
                        (SwipeCardAdapter.a(this.a.b)).a = null;
                        this.a.b.notifyDataSetChanged();
                      }
                      
                      public void c() {
                        DialogUtils.b(SwipeCardAdapter.e(this.a.b));
                      }
                    },  this.a.uid, this.a.relationship, "", (IRequestHost)activityFragmentActive, true);
                return;
              } catch (ClassCastException classCastException) {
                classCastException.printStackTrace();
              }  
          }
        });
    return (View)viewHolder2;
  }
  
  public boolean isEmpty() {
    return this.g.isEmpty();
  }
  
  public static interface SwipeCardListener {
    void a();
  }
  
  class ViewHolder {
    public TextView a = null;
    
    public TextView b = null;
    
    public TextView c = null;
    
    public TextView d = null;
    
    public ImageView e = null;
    
    public TextView f = null;
    
    public ImageView g = null;
    
    public ImageView h = null;
    
    public RelativeLayout i;
    
    public ImageView j = null;
    
    public TextView k = null;
    
    public ImageView l = null;
    
    public ImageView m = null;
    
    private ViewHolder(SwipeCardAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\SwipeCardAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */