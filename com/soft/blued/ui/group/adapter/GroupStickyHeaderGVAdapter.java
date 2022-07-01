package com.soft.blued.ui.group.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.blued.android.framework.view.stickygridheaders.StickyGridHeadersSimpleAdapter;
import com.soft.blued.ui.group.model.BluedGroupTypeGridItem;
import java.util.List;

public class GroupStickyHeaderGVAdapter extends BaseAdapter implements StickyGridHeadersSimpleAdapter {
  private LayoutInflater a;
  
  private List<BluedGroupTypeGridItem> b;
  
  public GroupStickyHeaderGVAdapter(Context paramContext, List<BluedGroupTypeGridItem> paramList) {
    this.a = LayoutInflater.from(paramContext);
    this.b = paramList;
  }
  
  public long a(int paramInt) {
    return ((BluedGroupTypeGridItem)this.b.get(paramInt)).getType();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view;
    HeaderViewHolder headerViewHolder;
    if (paramView == null) {
      HeaderViewHolder headerViewHolder1 = new HeaderViewHolder(this);
      View view1 = this.a.inflate(2131493391, paramViewGroup, false);
      headerViewHolder1.a = (TextView)view1.findViewById(2131300472);
      view1.setTag(headerViewHolder1);
      headerViewHolder = headerViewHolder1;
      view = view1;
    } else {
      headerViewHolder = (HeaderViewHolder)view.getTag();
    } 
    headerViewHolder.a.setText(((BluedGroupTypeGridItem)this.b.get(paramInt)).getName());
    return view;
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
    View view;
    ViewHolder viewHolder;
    if (paramView == null) {
      ViewHolder viewHolder1 = new ViewHolder(this);
      View view1 = this.a.inflate(2131493392, paramViewGroup, false);
      viewHolder1.a = (TextView)view1.findViewById(2131300870);
      view1.setTag(viewHolder1);
      viewHolder = viewHolder1;
      view = view1;
    } else {
      viewHolder = (ViewHolder)view.getTag();
    } 
    viewHolder.a.setText(((BluedGroupTypeGridItem)this.b.get(paramInt)).getTags());
    return view;
  }
  
  class HeaderViewHolder {
    TextView a;
    
    HeaderViewHolder(GroupStickyHeaderGVAdapter this$0) {}
  }
  
  class ViewHolder {
    TextView a;
    
    ViewHolder(GroupStickyHeaderGVAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\adapter\GroupStickyHeaderGVAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */