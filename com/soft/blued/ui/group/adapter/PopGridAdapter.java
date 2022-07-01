package com.soft.blued.ui.group.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.soft.blued.ui.find.model.FilterInfo;
import java.util.List;

public class PopGridAdapter extends BaseAdapter {
  private Context a;
  
  private List<FilterInfo> b;
  
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
    ViewHolder viewHolder;
    if (paramView == null) {
      paramView = LayoutInflater.from(this.a).inflate(2131494089, paramViewGroup, false);
      viewHolder = new ViewHolder();
      viewHolder.a = (TextView)paramView.findViewById(2131300870);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    FilterInfo filterInfo = this.b.get(paramInt);
    viewHolder.a.setText(filterInfo.mName);
    return paramView;
  }
  
  final class ViewHolder {
    TextView a;
    
    private ViewHolder(PopGridAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\adapter\PopGridAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */