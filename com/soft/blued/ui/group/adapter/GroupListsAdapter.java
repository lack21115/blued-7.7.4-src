package com.soft.blued.ui.group.adapter;

import android.content.Context;
import android.graphics.Color;
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
import com.blued.android.framework.view.pulltorefresh.PinnedSectionListView;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

public class GroupListsAdapter extends BaseAdapter implements PinnedSectionListView.PinnedSectionListAdapter {
  private List<BluedGroupLists> a = new ArrayList<BluedGroupLists>();
  
  private LayoutInflater b;
  
  private IRequestHost c;
  
  public GroupListsAdapter(Context paramContext) {
    this.b = LayoutInflater.from(paramContext);
  }
  
  public GroupListsAdapter(Context paramContext, IRequestHost paramIRequestHost, List<BluedGroupLists> paramList) {
    this.c = paramIRequestHost;
    this.b = LayoutInflater.from(paramContext);
  }
  
  public void a(ViewHolder paramViewHolder, BluedGroupLists paramBluedGroupLists) {
    LoadOptions loadOptions = new LoadOptions();
    loadOptions.d = 2131232322;
    loadOptions.b = 2131232322;
    paramViewHolder.a.setVisibility(8);
    paramViewHolder.c.setVisibility(0);
    if (paramBluedGroupLists.is_title == 2) {
      paramViewHolder.c.setBackgroundColor(Color.parseColor("#f7f7f7"));
    } else {
      paramViewHolder.c.setBackgroundColor(Color.parseColor("#ffffff"));
    } 
    ImageLoader.a(this.c, paramBluedGroupLists.groups_avatar).a(2131234356).c().a(paramViewHolder.d);
    if (!StringUtils.e(paramBluedGroupLists.groups_name)) {
      paramViewHolder.e.setVisibility(0);
      paramViewHolder.e.setText(paramBluedGroupLists.groups_name);
    } else {
      paramViewHolder.e.setVisibility(4);
    } 
    if (BlueAppLocal.d()) {
      if (!StringUtils.e(paramBluedGroupLists.groups_members_count)) {
        paramViewHolder.f.setVisibility(0);
        TextView textView = paramViewHolder.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringUtils.a(paramBluedGroupLists.groups_members_count));
        stringBuilder.append("人");
        textView.setText(stringBuilder.toString());
      } else {
        paramViewHolder.f.setVisibility(4);
      } 
    } else if (!StringUtils.e(paramBluedGroupLists.groups_members_count)) {
      paramViewHolder.f.setVisibility(0);
      paramViewHolder.f.setText(StringUtils.a(paramBluedGroupLists.groups_members_count));
    } else {
      paramViewHolder.f.setVisibility(4);
    } 
    if (!StringUtils.e(paramBluedGroupLists.groups_description)) {
      paramViewHolder.h.setVisibility(0);
      paramViewHolder.h.setText(paramBluedGroupLists.groups_description);
    } else {
      paramViewHolder.h.setVisibility(4);
    } 
    if (!StringUtils.e(paramBluedGroupLists.groups_distance)) {
      paramViewHolder.g.setVisibility(0);
      paramViewHolder.g.setText(DistanceUtils.b(paramBluedGroupLists.groups_distance, BlueAppLocal.c(), false));
    } else {
      paramViewHolder.g.setVisibility(4);
    } 
    UserRelationshipUtils.a(paramViewHolder.i, paramBluedGroupLists.vbadge, 3);
  }
  
  public void a(List<BluedGroupLists> paramList) {
    if (paramList != null) {
      List<BluedGroupLists> list = this.a;
      if (list == null) {
        this.a = new ArrayList<BluedGroupLists>();
        return;
      } 
      list.clear();
      b(paramList);
    } 
  }
  
  public boolean a(int paramInt) {
    return (paramInt == 1);
  }
  
  public void b(List<BluedGroupLists> paramList) {
    if (this.a == null)
      this.a = new ArrayList<BluedGroupLists>(); 
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount() {
    return this.a.size();
  }
  
  public Object getItem(int paramInt) {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt) {
    return ((BluedGroupLists)getItem(paramInt)).is_title;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder;
    BluedGroupLists bluedGroupLists = this.a.get(paramInt);
    if (paramView == null) {
      viewHolder = new ViewHolder(this);
      paramView = this.b.inflate(2131493539, null);
      viewHolder.a = (LinearLayout)paramView.findViewById(2131298841);
      viewHolder.b = (TextView)paramView.findViewById(2131300840);
      viewHolder.c = (LinearLayout)paramView.findViewById(2131298834);
      viewHolder.d = (ImageView)paramView.findViewById(2131297790);
      viewHolder.e = (TextView)paramView.findViewById(2131300852);
      viewHolder.f = (TextView)paramView.findViewById(2131300812);
      viewHolder.h = (TextView)paramView.findViewById(2131300842);
      viewHolder.g = (TextView)paramView.findViewById(2131300824);
      viewHolder.i = (ImageView)paramView.findViewById(2131297958);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    a(viewHolder, bluedGroupLists);
    return paramView;
  }
  
  public class ViewHolder {
    public LinearLayout a;
    
    public TextView b;
    
    public LinearLayout c;
    
    public ImageView d;
    
    public TextView e;
    
    public TextView f;
    
    public TextView g;
    
    public TextView h;
    
    public ImageView i;
    
    public ViewHolder(GroupListsAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\adapter\GroupListsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */