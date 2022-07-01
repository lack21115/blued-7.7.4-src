package com.soft.blued.ui.group.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.group.GroupMemberInviteFragment;
import com.soft.blued.ui.group.model.BluedUserInviteList;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

public class GroupUserInviteAdapter extends BaseAdapter {
  private Context a;
  
  private List<BluedUserInviteList> b;
  
  private LayoutInflater c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private int g;
  
  private String h;
  
  private LoadOptions i;
  
  private IRequestHost j;
  
  public GroupUserInviteAdapter(Context paramContext, IRequestHost paramIRequestHost, List<BluedUserInviteList> paramList) {
    this.a = paramContext;
    this.j = paramIRequestHost;
    this.b = paramList;
    this.c = LayoutInflater.from(paramContext);
    this.i = new LoadOptions();
    LoadOptions loadOptions = this.i;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
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
    BluedUserInviteList bluedUserInviteList = this.b.get(paramInt);
    if (paramView == null) {
      viewHolder1 = new ViewHolder(this);
      View view = this.c.inflate(2131493541, paramViewGroup, false);
      viewHolder1.a = (ImageView)view.findViewById(2131297952);
      viewHolder1.b = (TextView)view.findViewById(2131301475);
      viewHolder1.c = (TextView)view.findViewById(2131301469);
      viewHolder1.d = (TextView)view.findViewById(2131301136);
      viewHolder1.e = (TextView)view.findViewById(2131301474);
      viewHolder1.f = (TextView)view.findViewById(2131300871);
      viewHolder1.g = (CheckBox)view.findViewById(2131296669);
      viewHolder1.h = (ImageView)view.findViewById(2131297958);
      viewHolder1.i = (ImageView)view.findViewById(2131297581);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    ImageLoader.a(this.j, bluedUserInviteList.avatar).a(2131234356).c().a(viewHolder1.a);
    UserRelationshipUtils.a(viewHolder1.i, (UserBasicModel)bluedUserInviteList);
    if (!StringUtils.e(bluedUserInviteList.note)) {
      viewHolder1.b.setText(bluedUserInviteList.note);
    } else if (!StringUtils.e(bluedUserInviteList.name)) {
      viewHolder1.b.setText(bluedUserInviteList.name);
    } else {
      viewHolder1.b.setVisibility(4);
    } 
    UserRelationshipUtils.a(this.a, viewHolder1.b, (UserBasicModel)bluedUserInviteList);
    if (!StringUtils.e(bluedUserInviteList.distance)) {
      viewHolder1.c.setText(DistanceUtils.a(bluedUserInviteList.distance, BlueAppLocal.c(), false));
    } else {
      viewHolder1.c.setVisibility(4);
    } 
    DistanceUtils.a(this.a, viewHolder1.c, (UserBasicModel)bluedUserInviteList, 1);
    if (!StringUtils.e(bluedUserInviteList.last_operate)) {
      viewHolder1.d.setText(TimeAndDateUtils.f(this.a, TimeAndDateUtils.b(bluedUserInviteList.last_operate)));
    } else {
      viewHolder1.d.setText("");
    } 
    TypefaceUtils.a(this.a, viewHolder1.d, bluedUserInviteList.is_hide_last_operate, 1);
    if (!StringUtils.e(bluedUserInviteList.city_settled)) {
      viewHolder1.e.setText(AreaUtils.a(bluedUserInviteList.city_settled, BlueAppLocal.c()));
    } else {
      viewHolder1.e.setVisibility(4);
    } 
    TypefaceUtils.b(this.a, viewHolder1.e, bluedUserInviteList.is_hide_city_settled, 1);
    TextView textView = viewHolder1.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bluedUserInviteList.age);
    stringBuilder.append(" / ");
    stringBuilder.append(bluedUserInviteList.height);
    stringBuilder.append(" / ");
    stringBuilder.append(bluedUserInviteList.weight);
    stringBuilder.append(" ");
    stringBuilder.append(this.a.getResources().getString(2131758698));
    stringBuilder.append(" ");
    stringBuilder.append(UserRelationshipUtils.c(this.a, bluedUserInviteList.role));
    textView.setText(stringBuilder.toString());
    if (this.b.size() > 0) {
      int i;
      for (i = 0; i < this.b.size(); i++) {
        bluedUserInviteList.isCheckedFlag = false;
        bluedUserInviteList.isEnabledFlag = true;
      } 
    } 
    if (GroupMemberInviteFragment.d.size() > 0) {
      int i;
      for (i = 0; i < GroupMemberInviteFragment.d.size(); i++) {
        if (((String)GroupMemberInviteFragment.d.get(i)).equals(bluedUserInviteList.uid) && 2 == ((Short)GroupMemberInviteFragment.h.get(i)).shortValue()) {
          bluedUserInviteList.isCheckedFlag = true;
          bluedUserInviteList.isEnabledFlag = true;
        } 
      } 
    } 
    if (GroupMemberInviteFragment.j.size() > 0) {
      int i;
      for (i = 0; i < GroupMemberInviteFragment.j.size(); i++) {
        if (!StringUtils.e(bluedUserInviteList.uid) && !StringUtils.e(GroupMemberInviteFragment.j.get(i)) && bluedUserInviteList.uid.equals(GroupMemberInviteFragment.j.get(i))) {
          bluedUserInviteList.isCheckedFlag = true;
          bluedUserInviteList.isEnabledFlag = false;
        } 
      } 
    } 
    viewHolder1.g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this, paramInt, viewHolder1, bluedUserInviteList) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            if (param1Boolean) {
              GroupUserInviteAdapter groupUserInviteAdapter = this.d;
              GroupUserInviteAdapter.a(groupUserInviteAdapter, ((BluedUserInviteList)GroupUserInviteAdapter.a(groupUserInviteAdapter).get(this.a)).uid);
              groupUserInviteAdapter = this.d;
              GroupUserInviteAdapter.b(groupUserInviteAdapter, ((BluedUserInviteList)GroupUserInviteAdapter.a(groupUserInviteAdapter).get(this.a)).name);
              groupUserInviteAdapter = this.d;
              GroupUserInviteAdapter.c(groupUserInviteAdapter, ((BluedUserInviteList)GroupUserInviteAdapter.a(groupUserInviteAdapter).get(this.a)).avatar);
              groupUserInviteAdapter = this.d;
              GroupUserInviteAdapter.a(groupUserInviteAdapter, ((BluedUserInviteList)GroupUserInviteAdapter.a(groupUserInviteAdapter).get(this.a)).vbadge);
              this.b.g.setOnClickListener(new View.OnClickListener(this) {
                    public void onClick(View param2View) {
                      if (GroupMemberInviteFragment.d.size() >= 8) {
                        this.a.b.g.setChecked(false);
                        AppMethods.d(2131758312);
                        return;
                      } 
                      if (!StringUtils.e(GroupUserInviteAdapter.b(this.a.d))) {
                        GroupMemberInviteFragment.d.add(GroupUserInviteAdapter.b(this.a.d));
                        GroupMemberInviteFragment.e.add(GroupUserInviteAdapter.c(this.a.d));
                        GroupMemberInviteFragment.f.add(GroupUserInviteAdapter.d(this.a.d));
                        GroupMemberInviteFragment.g.add(Integer.valueOf(GroupUserInviteAdapter.e(this.a.d)));
                        GroupMemberInviteFragment.h.add(Short.valueOf((short)2));
                      } 
                      this.a.c.isCheckedFlag = true;
                    }
                  });
              return;
            } 
            this.b.g.setOnClickListener(new View.OnClickListener(this) {
                  public void onClick(View param2View) {
                    GroupUserInviteAdapter.d(this.a.d, ((BluedUserInviteList)GroupUserInviteAdapter.a(this.a.d).get(this.a.a)).uid);
                    if (GroupMemberInviteFragment.d != null)
                      for (int i = 0; i < GroupMemberInviteFragment.d.size(); i++) {
                        if (((String)GroupMemberInviteFragment.d.get(i)).equals(GroupUserInviteAdapter.f(this.a.d))) {
                          GroupMemberInviteFragment.e.remove(GroupMemberInviteFragment.e.get(i));
                          GroupMemberInviteFragment.f.remove(GroupMemberInviteFragment.f.get(i));
                          GroupMemberInviteFragment.d.remove(GroupMemberInviteFragment.d.get(i));
                          GroupMemberInviteFragment.g.remove(GroupMemberInviteFragment.g.get(i));
                          GroupMemberInviteFragment.h.remove(GroupMemberInviteFragment.h.get(i));
                        } 
                      }  
                    this.a.c.isCheckedFlag = false;
                  }
                });
          }
        });
    viewHolder1.g.setChecked(bluedUserInviteList.isCheckedFlag);
    viewHolder1.g.setEnabled(bluedUserInviteList.isEnabledFlag);
    viewHolder2.setOnClickListener(new View.OnClickListener(this, bluedUserInviteList, viewHolder1) {
          public void onClick(View param1View) {
            UserInfoFragmentNew.a(GroupUserInviteAdapter.g(this.c), (UserBasicModel)this.a, "", (View)this.b.a);
          }
        });
    UserRelationshipUtils.a(viewHolder1.h, bluedUserInviteList.vbadge, 3);
    return (View)viewHolder2;
  }
  
  public class ViewHolder {
    public ImageView a;
    
    public TextView b;
    
    public TextView c;
    
    public TextView d;
    
    public TextView e;
    
    public TextView f;
    
    public CheckBox g;
    
    public ImageView h;
    
    public ImageView i;
    
    public ViewHolder(GroupUserInviteAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\adapter\GroupUserInviteAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */