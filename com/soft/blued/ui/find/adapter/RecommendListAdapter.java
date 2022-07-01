package com.soft.blued.ui.find.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.views.FollowStatusView;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.List;

public class RecommendListAdapter<T extends BluedRecommendUsers> extends BaseAdapter {
  protected List<T> a = new ArrayList<T>();
  
  private Context b;
  
  private LayoutInflater c;
  
  private int d;
  
  private Dialog e;
  
  private LoadOptions f;
  
  private int g = -1;
  
  private boolean h;
  
  private IRequestHost i;
  
  public RecommendListAdapter(Context paramContext, int paramInt, IRequestHost paramIRequestHost) {
    this.i = paramIRequestHost;
    this.b = paramContext;
    this.g = paramInt;
    this.c = LayoutInflater.from(paramContext);
    this.d = (paramContext.getResources().getDisplayMetrics()).widthPixels;
    this.e = DialogUtils.a(paramContext);
  }
  
  public RecommendListAdapter(Context paramContext, int paramInt, boolean paramBoolean, IRequestHost paramIRequestHost) {
    this.i = paramIRequestHost;
    this.b = paramContext;
    this.g = paramInt;
    this.h = paramBoolean;
    this.c = LayoutInflater.from(paramContext);
    this.d = (paramContext.getResources().getDisplayMetrics()).widthPixels;
    this.e = DialogUtils.a(paramContext);
    this.f = new LoadOptions();
    LoadOptions loadOptions = this.f;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
    paramInt = this.d;
    loadOptions.a(paramInt >> 1, paramInt >> 1);
  }
  
  private void a(T paramT) {
    UserHttpUtils.b(this.b, new UserRelationshipUtils.IAddOrRemoveAttentionDone(this, (BluedRecommendUsers)paramT) {
          public void a() {
            DialogUtils.a(RecommendListAdapter.d(this.b));
          }
          
          public void a(String param1String) {
            UserInfo.a().i().setAttentionCount(1);
            UserInfoDataObserver.a().b();
            this.a.relationship = param1String;
            LiveEventBus.get("feed_relation_ship").post(this.a);
            this.b.notifyDataSetChanged();
          }
          
          public void b() {
            DialogUtils.b(RecommendListAdapter.d(this.b));
          }
          
          public void b(String param1String) {}
          
          public void c() {
            DialogUtils.b(RecommendListAdapter.d(this.b));
          }
        }((BluedRecommendUsers)paramT).uid, "", this.i);
  }
  
  private void b(T paramT) {
    Context context = this.b;
    CommonAlertDialog.a(context, null, context.getResources().getString(2131755729), this.b.getResources().getString(2131756086), new DialogInterface.OnClickListener(this, (BluedRecommendUsers)paramT) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            UserHttpUtils.a(RecommendListAdapter.c(this.b), new UserRelationshipUtils.IAddOrRemoveAttentionDone(this) {
                  public void a() {
                    DialogUtils.a(RecommendListAdapter.d(this.a.b));
                  }
                  
                  public void a(String param2String) {}
                  
                  public void b() {
                    DialogUtils.b(RecommendListAdapter.d(this.a.b));
                  }
                  
                  public void b(String param2String) {
                    UserInfo.a().i().setAttentionCount(-1);
                    UserInfoDataObserver.a().b();
                    this.a.a.relationship = param2String;
                    LiveEventBus.get("feed_relation_ship").post(this.a.a);
                    if (RecommendListAdapter.a(this.a.b) != 1 && RecommendListAdapter.a(this.a.b) != 4)
                      this.a.b.a.remove(this.a.a); 
                    this.a.b.notifyDataSetChanged();
                  }
                  
                  public void c() {
                    DialogUtils.b(RecommendListAdapter.d(this.a.b));
                  }
                },  this.a.uid, "", RecommendListAdapter.e(this.b));
          }
        }null, null, null);
  }
  
  public void a(List<T> paramList) {
    this.a.clear();
    if (paramList != null && paramList.size() > 0) {
      for (int i = 0; i < paramList.size(); i++) {
        if (BlueAppLocal.d()) {
          ((BluedRecommendUsers)paramList.get(i)).height = StringUtils.a(((BluedRecommendUsers)paramList.get(i)).height, BlueAppLocal.c(), false);
          ((BluedRecommendUsers)paramList.get(i)).weight = StringUtils.b(((BluedRecommendUsers)paramList.get(i)).weight, BlueAppLocal.c(), false);
        } else {
          ((BluedRecommendUsers)paramList.get(i)).height = StringUtils.a(((BluedRecommendUsers)paramList.get(i)).height, BlueAppLocal.c(), true);
          ((BluedRecommendUsers)paramList.get(i)).weight = StringUtils.b(((BluedRecommendUsers)paramList.get(i)).weight, BlueAppLocal.c(), true);
        } 
      } 
      this.a.addAll(paramList);
    } 
    notifyDataSetChanged();
  }
  
  public void b(List<T> paramList) {
    if (paramList != null && paramList.size() > 0) {
      for (int i = 0; i < paramList.size(); i++) {
        if (BlueAppLocal.d()) {
          ((BluedRecommendUsers)paramList.get(i)).height = StringUtils.a(((BluedRecommendUsers)paramList.get(i)).height, BlueAppLocal.c(), false);
          ((BluedRecommendUsers)paramList.get(i)).weight = StringUtils.b(((BluedRecommendUsers)paramList.get(i)).weight, BlueAppLocal.c(), false);
        } else {
          ((BluedRecommendUsers)paramList.get(i)).height = StringUtils.a(((BluedRecommendUsers)paramList.get(i)).height, BlueAppLocal.c(), true);
          ((BluedRecommendUsers)paramList.get(i)).weight = StringUtils.b(((BluedRecommendUsers)paramList.get(i)).weight, BlueAppLocal.c(), true);
        } 
      } 
      this.a.addAll(paramList);
      notifyDataSetChanged();
    } 
  }
  
  public int getCount() {
    return this.a.size();
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
      viewHolder1 = new ViewHolder(this);
      View view = this.c.inflate(2131493284, paramViewGroup, false);
      viewHolder1.a = (ImageView)view.findViewById(2131297362);
      viewHolder1.g = (TextView)view.findViewById(2131299744);
      viewHolder1.c = (TextView)view.findViewById(2131299358);
      viewHolder1.b = (TextView)view.findViewById(2131299164);
      viewHolder1.d = (TextView)view.findViewById(2131296426);
      viewHolder1.e = (TextView)view.findViewById(2131297368);
      viewHolder1.f = (TextView)view.findViewById(2131301755);
      viewHolder1.h = (FollowStatusView)view.findViewById(2131297199);
      viewHolder1.i = (ImageView)view.findViewById(2131297575);
      viewHolder1.j = (ImageView)view.findViewById(2131297447);
      viewHolder1.k = view.findViewById(2131301133);
      viewHolder1.l = (LinearLayout)view.findViewById(2131299013);
      viewHolder1.m = (LinearLayout)view.findViewById(2131298778);
      viewHolder1.n = (ShapeTextView)view.findViewById(2131300911);
      viewHolder1.o = (ImageView)view.findViewById(2131296670);
      viewHolder1.p = view.findViewById(2131297627);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    BluedRecommendUsers bluedRecommendUsers = (BluedRecommendUsers)this.a.get(paramInt);
    if (this.g == 3)
      bluedRecommendUsers.relationship = "1"; 
    UserRelationshipUtils.a(viewHolder1.i, bluedRecommendUsers.vbadge, 3);
    ImageLoader.a(this.i, AvatarUtils.a(0, bluedRecommendUsers.avatar)).c().a(2131234356).a(viewHolder1.a);
    UserRelationshipUtils.a(viewHolder1.j, (UserBasicModel)bluedRecommendUsers);
    if (bluedRecommendUsers.is_official != 1)
      UserRelationshipUtils.a(this.b, viewHolder1.g, bluedRecommendUsers.role); 
    if (!TextUtils.isEmpty(bluedRecommendUsers.note)) {
      viewHolder1.c.setText(bluedRecommendUsers.note);
    } else if (!TextUtils.isEmpty(bluedRecommendUsers.name)) {
      viewHolder1.c.setText(bluedRecommendUsers.name);
    } else {
      viewHolder1.c.setText("");
    } 
    UserRelationshipUtils.a(this.b, viewHolder1.c, (UserBasicModel)bluedRecommendUsers);
    if (bluedRecommendUsers.online_state == 1) {
      viewHolder1.k.setVisibility(0);
    } else {
      viewHolder1.k.setVisibility(8);
    } 
    if (bluedRecommendUsers.vbadge == 3 || bluedRecommendUsers.vbadge == 5) {
      viewHolder1.l.setVisibility(8);
    } else {
      viewHolder1.l.setVisibility(0);
      if (!TextUtils.isEmpty(bluedRecommendUsers.age)) {
        TextView textView = viewHolder1.d;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bluedRecommendUsers.age);
        stringBuilder.append(this.b.getResources().getString(2131755267));
        textView.setText(stringBuilder.toString());
      } else {
        viewHolder1.d.setText("");
      } 
      if (!TextUtils.isEmpty(bluedRecommendUsers.height)) {
        viewHolder1.e.setText(bluedRecommendUsers.height);
      } else {
        viewHolder1.e.setText("");
      } 
      if (!TextUtils.isEmpty(bluedRecommendUsers.weight)) {
        viewHolder1.f.setText(bluedRecommendUsers.weight);
      } else {
        viewHolder1.f.setText("");
      } 
    } 
    if (bluedRecommendUsers.vbadge == 3) {
      viewHolder1.m.setVisibility(8);
    } else {
      viewHolder1.m.setVisibility(0);
    } 
    if (!TextUtils.isEmpty(bluedRecommendUsers.location) && bluedRecommendUsers.vbadge != 3) {
      viewHolder1.b.setText(bluedRecommendUsers.location);
    } else {
      viewHolder1.b.setText("");
    } 
    if (bluedRecommendUsers.uid != null && bluedRecommendUsers.uid.equals(UserInfo.a().i().getUid())) {
      viewHolder1.h.setVisibility(8);
    } else {
      viewHolder1.h.setVisibility(0);
    } 
    viewHolder1.h.setRelationShip(bluedRecommendUsers.relationship);
    viewHolder1.h.setOnClickListener(new View.OnClickListener(this, bluedRecommendUsers) {
          public void onClick(View param1View) {
            FeedProtos.FollowLocation followLocation;
            boolean bool;
            if (!TextUtils.isEmpty(this.a.relationship) && (this.a.relationship.equals("1") || this.a.relationship.equals("3"))) {
              RecommendListAdapter.a(this.b, this.a);
              bool = false;
            } else {
              RecommendListAdapter.b(this.b, this.a);
              bool = true;
            } 
            View view = null;
            if (RecommendListAdapter.a(this.b) == 1) {
              if (RecommendListAdapter.b(this.b)) {
                followLocation = FeedProtos.FollowLocation.FOLLOW_MINE;
              } else {
                followLocation = FeedProtos.FollowLocation.FOLLOW_PROFILE_FANS_LIST;
              } 
            } else {
              param1View = view;
              if (RecommendListAdapter.a(this.b) == 2) {
                param1View = view;
                if (!RecommendListAdapter.b(this.b))
                  followLocation = FeedProtos.FollowLocation.FOLLOW_PROFILE_FOLLOW_LIST; 
              } 
            } 
            EventTrackFeed.a(FeedProtos.Event.OTHER_FOLLOW_CLICK, this.a.uid, "", "", followLocation, bool, false);
          }
        });
    viewHolder2.setOnClickListener(new View.OnClickListener(this, bluedRecommendUsers, viewHolder1.a) {
          public void onClick(View param1View) {
            String str;
            MessageProtos.StrangerSource strangerSource;
            int i = RecommendListAdapter.a(this.c);
            if (i != 1) {
              if (i != 2) {
                if (i != 3) {
                  strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
                  str = "";
                } else {
                  strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
                  str = "my_secret_follow";
                } 
              } else {
                strangerSource = MessageProtos.StrangerSource.MINE_FOLLOW;
                str = "my_followed";
              } 
            } else {
              strangerSource = MessageProtos.StrangerSource.MINE_FAN;
              str = "my_fans";
            } 
            UserInfoFragmentNew.a(RecommendListAdapter.c(this.c), (UserBasicModel)this.a, str, (View)this.b, null, new MsgSourceEntity(strangerSource, ""));
          }
        });
    return (View)viewHolder2;
  }
  
  public static interface PAGE_NAME {}
  
  public class ViewHolder {
    public ImageView a;
    
    public TextView b;
    
    public TextView c;
    
    public TextView d;
    
    public TextView e;
    
    public TextView f;
    
    public TextView g;
    
    public FollowStatusView h;
    
    public ImageView i;
    
    public ImageView j;
    
    public View k;
    
    public LinearLayout l;
    
    public LinearLayout m;
    
    public ShapeTextView n;
    
    public ImageView o;
    
    public View p;
    
    protected ViewHolder(RecommendListAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\RecommendListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */