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
import com.blued.android.framework.view.stickylistheaders.StickyListHeadersAdapter;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

public class MyGroupListsAdapter extends BaseAdapter implements StickyListHeadersAdapter {
  private List<BluedGroupLists> a;
  
  private LayoutInflater b;
  
  private LoadOptions c;
  
  private boolean d;
  
  private IRequestHost e;
  
  public MyGroupListsAdapter(Context paramContext, IRequestHost paramIRequestHost, List<BluedGroupLists> paramList, boolean paramBoolean) {
    this.a = paramList;
    this.e = paramIRequestHost;
    this.d = paramBoolean;
    this.b = LayoutInflater.from(paramContext);
    this.c = new LoadOptions();
    LoadOptions loadOptions = this.c;
    loadOptions.d = 2131232322;
    loadOptions.b = 2131232322;
  }
  
  public long a(int paramInt) {
    return ((BluedGroupLists)this.a.get(paramInt)).type;
  }
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view;
    HeaderViewHolder headerViewHolder;
    if (paramView == null) {
      HeaderViewHolder headerViewHolder1 = new HeaderViewHolder();
      View view1 = this.b.inflate(2131493244, paramViewGroup, false);
      headerViewHolder1.a = (TextView)view1.findViewById(2131300472);
      view1.setTag(headerViewHolder1);
      headerViewHolder = headerViewHolder1;
      view = view1;
    } else {
      headerViewHolder = (HeaderViewHolder)view.getTag();
    } 
    if (this.d) {
      headerViewHolder.a.setVisibility(0);
      headerViewHolder.a.setText(((BluedGroupLists)this.a.get(paramInt)).header_name);
      return view;
    } 
    headerViewHolder.a.setVisibility(8);
    return view;
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    BluedGroupLists bluedGroupLists = this.a.get(paramInt);
    if (paramView == null) {
      viewHolder1 = new ViewHolder();
      View view = this.b.inflate(2131493539, paramViewGroup, false);
      viewHolder1.a = (ImageView)view.findViewById(2131297790);
      viewHolder1.b = (TextView)view.findViewById(2131300852);
      viewHolder1.c = (TextView)view.findViewById(2131300812);
      viewHolder1.d = (TextView)view.findViewById(2131300842);
      viewHolder1.e = (TextView)view.findViewById(2131300824);
      viewHolder1.f = (ImageView)view.findViewById(2131297958);
      viewHolder1.g = (TextView)view.findViewById(2131300844);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    if (bluedGroupLists.groups_is_locked == 1) {
      viewHolder1.g.setVisibility(0);
    } else {
      viewHolder1.g.setVisibility(8);
    } 
    ImageLoader.a(this.e, bluedGroupLists.groups_avatar).a(2131234356).c().a(viewHolder1.a);
    if (!StringUtils.e(bluedGroupLists.groups_name)) {
      viewHolder1.b.setText(bluedGroupLists.groups_name);
    } else {
      viewHolder1.b.setVisibility(4);
    } 
    if (BlueAppLocal.d()) {
      if (!StringUtils.e(bluedGroupLists.groups_members_count)) {
        TextView textView = viewHolder1.c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringUtils.a(bluedGroupLists.groups_members_count));
        stringBuilder.append("人");
        textView.setText(stringBuilder.toString());
      } else {
        viewHolder1.c.setVisibility(4);
      } 
    } else if (!StringUtils.e(bluedGroupLists.groups_members_count)) {
      viewHolder1.c.setText(StringUtils.a(bluedGroupLists.groups_members_count));
    } else {
      viewHolder1.c.setVisibility(4);
    } 
    if (!StringUtils.e(bluedGroupLists.groups_city)) {
      viewHolder1.d.setText(bluedGroupLists.groups_description);
    } else {
      viewHolder1.d.setVisibility(4);
    } 
    if (!StringUtils.e(bluedGroupLists.groups_distance)) {
      viewHolder1.e.setText(DistanceUtils.a(bluedGroupLists.groups_distance, BlueAppLocal.c(), false));
    } else {
      viewHolder1.e.setVisibility(4);
    } 
    UserRelationshipUtils.a(viewHolder1.f, bluedGroupLists.vbadge, 3);
    return (View)viewHolder2;
  }
  
  class HeaderViewHolder {
    public TextView a;
    
    private HeaderViewHolder(MyGroupListsAdapter this$0) {}
  }
  
  class ViewHolder {
    public ImageView a;
    
    public TextView b;
    
    public TextView c;
    
    public TextView d;
    
    public TextView e;
    
    public ImageView f;
    
    public TextView g;
    
    private ViewHolder(MyGroupListsAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\adapter\MyGroupListsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */