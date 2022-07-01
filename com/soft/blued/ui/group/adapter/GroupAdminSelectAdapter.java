package com.soft.blued.ui.group.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.ui.group.model.BluedGroupAllMembers;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

public class GroupAdminSelectAdapter extends BaseAdapter {
  private LayoutInflater a;
  
  private Context b;
  
  private List<BluedGroupAllMembers> c;
  
  private LoadOptions d;
  
  private IRequestHost e;
  
  public GroupAdminSelectAdapter(Context paramContext, IRequestHost paramIRequestHost, List<BluedGroupAllMembers> paramList) {
    this.b = paramContext;
    this.e = paramIRequestHost;
    this.c = paramList;
    this.a = LayoutInflater.from(paramContext);
    this.d = new LoadOptions();
    LoadOptions loadOptions = this.d;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
  }
  
  public void a() {
    this.c.clear();
    notifyDataSetChanged();
  }
  
  public void a(List<BluedGroupAllMembers> paramList) {
    if (paramList != null && paramList.size() > 0) {
      this.c.addAll(paramList);
      notifyDataSetChanged();
    } 
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
    View view;
    ViewHolder viewHolder;
    BluedGroupAllMembers bluedGroupAllMembers = this.c.get(paramInt);
    if (paramView == null) {
      ViewHolder viewHolder1 = new ViewHolder();
      View view1 = this.a.inflate(2131493542, paramViewGroup, false);
      viewHolder1.a = (ImageView)view1.findViewById(2131297952);
      viewHolder1.b = (TextView)view1.findViewById(2131301475);
      viewHolder1.c = (TextView)view1.findViewById(2131300871);
      viewHolder1.d = (TextView)view1.findViewById(2131301469);
      viewHolder1.e = (TextView)view1.findViewById(2131300943);
      viewHolder1.f = (ImageView)view1.findViewById(2131299212);
      view1.setTag(viewHolder1);
      viewHolder = viewHolder1;
      view = view1;
    } else {
      viewHolder = (ViewHolder)view.getTag();
    } 
    ImageLoader.a(this.e, bluedGroupAllMembers.avatar).a(2131234356).c().a(viewHolder.a);
    UserRelationshipUtils.a(viewHolder.f, bluedGroupAllMembers.vbadge, 3);
    if (!StringUtils.e(bluedGroupAllMembers.name)) {
      viewHolder.b.setText(bluedGroupAllMembers.name);
    } else {
      viewHolder.b.setVisibility(4);
    } 
    if (!StringUtils.e(bluedGroupAllMembers.distance)) {
      viewHolder.d.setText(DistanceUtils.a(bluedGroupAllMembers.distance, BlueAppLocal.c(), false));
    } else {
      viewHolder.d.setVisibility(4);
    } 
    if (!StringUtils.e(bluedGroupAllMembers.last_active_time)) {
      viewHolder.e.setText(TimeAndDateUtils.f(this.b, TimeAndDateUtils.b(bluedGroupAllMembers.last_active_time)));
    } else {
      viewHolder.e.setText("");
    } 
    TextView textView = viewHolder.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bluedGroupAllMembers.age);
    stringBuilder.append(" / ");
    stringBuilder.append(bluedGroupAllMembers.height);
    stringBuilder.append(" / ");
    stringBuilder.append(bluedGroupAllMembers.weight);
    stringBuilder.append(" ");
    stringBuilder.append(this.b.getResources().getString(2131758698));
    stringBuilder.append(" ");
    stringBuilder.append(UserRelationshipUtils.c(this.b, bluedGroupAllMembers.role));
    textView.setText(stringBuilder.toString());
    return view;
  }
  
  class ViewHolder {
    ImageView a;
    
    TextView b;
    
    TextView c;
    
    TextView d;
    
    TextView e;
    
    ImageView f;
    
    private ViewHolder(GroupAdminSelectAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\adapter\GroupAdminSelectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */