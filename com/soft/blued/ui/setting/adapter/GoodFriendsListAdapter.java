package com.soft.blued.ui.setting.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.List;

public class GoodFriendsListAdapter extends BaseAdapter {
  private Context a;
  
  private LayoutInflater b;
  
  private List<BluedBlackList> c = new ArrayList<BluedBlackList>();
  
  private String d = GoodFriendsListAdapter.class.getSimpleName();
  
  private int e;
  
  private Dialog f;
  
  private IRequestHost g;
  
  private String h;
  
  private LoadOptions i;
  
  public GoodFriendsListAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    this.g = paramIRequestHost;
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.e = (paramContext.getResources().getDisplayMetrics()).widthPixels;
    this.f = DialogUtils.a(paramContext);
    this.i = new LoadOptions();
    LoadOptions loadOptions = this.i;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
    int i = this.e;
    loadOptions.a(i / 2, i / 2);
  }
  
  private String a(int paramInt) {
    return this.a.getResources().getString(paramInt);
  }
  
  private void a(BluedBlackList paramBluedBlackList) {
    CommonAlertDialog.a(this.a, a(2131756094), 20, null, null, null, paramBluedBlackList.note, a(2131758397), new CommonAlertDialog.TextOnClickListener(this, paramBluedBlackList) {
          public void a(String param1String) {
            if (!param1String.equals(this.a.note)) {
              MineHttpUtils.h(GoodFriendsListAdapter.a(this.b), new BluedUIHttpResponse(this, param1String) {
                    public void onUIFinish() {
                      super.onUIFinish();
                      DialogUtils.b(GoodFriendsListAdapter.b(this.b.b));
                    }
                    
                    public void onUIStart() {
                      super.onUIStart();
                      DialogUtils.a(GoodFriendsListAdapter.b(this.b.b));
                    }
                    
                    public void onUIUpdate(BluedEntity param2BluedEntity) {
                      DialogUtils.b(GoodFriendsListAdapter.b(this.b.b));
                      AppMethods.d(2131757917);
                      this.b.a.note = this.a;
                      this.b.a.name = this.a;
                      this.b.b.notifyDataSetChanged();
                    }
                  }UserInfo.a().i().getUid(), param1String, this.a.uid, GoodFriendsListAdapter.c(this.b));
              return;
            } 
            AppMethods.d(2131758397);
          }
        }null);
  }
  
  private void b(BluedBlackList paramBluedBlackList) {
    CommonAlertDialog.a(this.a, null, a(2131756109), a(2131756086), new DialogInterface.OnClickListener(this, paramBluedBlackList) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            UserHttpUtils.a(GoodFriendsListAdapter.a(this.b), new UserRelationshipUtils.IAddOrRemoveAttentionDone(this) {
                  public void a() {
                    DialogUtils.a(GoodFriendsListAdapter.b(this.a.b));
                  }
                  
                  public void a(String param2String) {}
                  
                  public void b() {
                    DialogUtils.b(GoodFriendsListAdapter.b(this.a.b));
                  }
                  
                  public void b(String param2String) {
                    UserInfo.a().i().setFriendsCount(-1);
                    DialogUtils.b(GoodFriendsListAdapter.b(this.a.b));
                    GoodFriendsListAdapter.d(this.a.b).remove(this.a.a);
                    this.a.b.notifyDataSetChanged();
                  }
                  
                  public void c() {
                    DialogUtils.b(GoodFriendsListAdapter.b(this.a.b));
                  }
                },  this.a.uid, "", GoodFriendsListAdapter.c(this.b));
          }
        }null, null, null);
  }
  
  public void a(List<BluedBlackList> paramList, String paramString) {
    this.h = paramString;
    this.c.clear();
    if (paramList != null && paramList.size() > 0)
      this.c.addAll(paramList); 
    notifyDataSetChanged();
  }
  
  public void b(List<BluedBlackList> paramList, String paramString) {
    this.h = paramString;
    if (paramList != null && paramList.size() > 0) {
      for (int i = 0; i < paramList.size(); i++) {
        ((BluedBlackList)paramList.get(i)).height = StringUtils.a(((BluedBlackList)paramList.get(i)).height, BlueAppLocal.c(), false);
        ((BluedBlackList)paramList.get(i)).weight = StringUtils.b(((BluedBlackList)paramList.get(i)).weight, BlueAppLocal.c(), false);
      } 
      this.c.addAll(paramList);
      notifyDataSetChanged();
    } 
  }
  
  public int getCount() {
    return this.c.size();
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
      View view = this.b.inflate(2131493529, paramViewGroup, false);
      viewHolder1.a = (ImageView)view.findViewById(2131297362);
      viewHolder1.b = (TextView)view.findViewById(2131299358);
      viewHolder1.c = (TextView)view.findViewById(2131296943);
      viewHolder1.d = (TextView)view.findViewById(2131299415);
      viewHolder1.e = (TextView)view.findViewById(2131296915);
      viewHolder1.f = (ImageView)view.findViewById(2131297575);
      viewHolder1.g = (ImageView)view.findViewById(2131297447);
      viewHolder1.h = view.findViewById(2131301133);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    BluedBlackList bluedBlackList = this.c.get(paramInt);
    UserRelationshipUtils.a(viewHolder1.f, bluedBlackList.vbadge, 3);
    viewHolder2.setOnClickListener(new View.OnClickListener(this, bluedBlackList, viewHolder1) {
          public void onClick(View param1View) {
            UserInfoFragmentNew.a(GoodFriendsListAdapter.a(this.c), (UserBasicModel)this.a, "my_friends", (View)this.b.a);
          }
        });
    ImageLoader.a(this.g, bluedBlackList.avatar).a(2131234356).c().a(viewHolder1.a);
    if (!TextUtils.isEmpty(bluedBlackList.location) && bluedBlackList.vbadge != 3) {
      viewHolder1.c.setText(bluedBlackList.location);
    } else {
      viewHolder1.c.setText("");
    } 
    if (!TextUtils.isEmpty(bluedBlackList.description)) {
      viewHolder1.e.setText(bluedBlackList.description);
    } else {
      viewHolder1.e.setText("");
    } 
    if (!TextUtils.isEmpty(bluedBlackList.note)) {
      viewHolder1.b.setText(bluedBlackList.note);
    } else if (!TextUtils.isEmpty(bluedBlackList.name)) {
      viewHolder1.b.setText(bluedBlackList.name);
    } else {
      viewHolder1.b.setText("");
    } 
    UserRelationshipUtils.a(this.a, viewHolder1.b, (UserBasicModel)bluedBlackList);
    if (bluedBlackList.online_state == 1) {
      viewHolder1.h.setVisibility(0);
    } else {
      viewHolder1.h.setVisibility(8);
    } 
    TypefaceUtils.a(this.a, viewHolder1.b, this.h, this.a.getResources().getColor(2131100365));
    UserRelationshipUtils.a(viewHolder1.g, (UserBasicModel)bluedBlackList);
    if (bluedBlackList.vbadge != 3) {
      viewHolder1.d.setVisibility(0);
      if (!TextUtils.isEmpty(bluedBlackList.last_operate)) {
        Long long_ = Long.valueOf(TimeAndDateUtils.b(bluedBlackList.last_operate));
        if (StringUtils.e(TimeAndDateUtils.f(AppInfo.d(), long_.longValue()))) {
          viewHolder1.d.setText(a(2131755514));
        } else {
          viewHolder1.d.setText(TimeAndDateUtils.f(AppInfo.d(), long_.longValue()));
        } 
      } else {
        viewHolder1.d.setText(a(2131755514));
      } 
    } else {
      viewHolder1.d.setVisibility(8);
    } 
    TypefaceUtils.a(this.a, viewHolder1.d, bluedBlackList.is_hide_last_operate, 1);
    viewHolder1.d.post(new -$$Lambda$GoodFriendsListAdapter$jdq_B4z1miylmbbzr2KIx3VCla8(this, viewHolder1));
    viewHolder2.setOnLongClickListener(new -$$Lambda$GoodFriendsListAdapter$jHVfX4Z7Z_ZlMqatTCgs3UgMqsQ(this, paramInt, viewHolder1, bluedBlackList));
    return (View)viewHolder2;
  }
  
  class ViewHolder {
    public ImageView a;
    
    public TextView b;
    
    public TextView c;
    
    public TextView d;
    
    public TextView e;
    
    public ImageView f;
    
    public ImageView g;
    
    public View h;
    
    private ViewHolder(GoodFriendsListAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\adapter\GoodFriendsListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */