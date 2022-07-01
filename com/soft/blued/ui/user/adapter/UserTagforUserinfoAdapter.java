package com.soft.blued.ui.user.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.utils.StringUtils;
import java.util.List;

public class UserTagforUserinfoAdapter extends BaseAdapter {
  private LayoutInflater a;
  
  private List<UserTag> b;
  
  public UserTag a(int paramInt) {
    return this.b.get(paramInt);
  }
  
  public int getCount() {
    return this.b.size();
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    if (paramView == null) {
      viewHolder1 = new ViewHolder();
      View view = this.a.inflate(2131493671, paramViewGroup, false);
      viewHolder1.a = (LinearLayout)view.findViewById(2131298718);
      viewHolder1.b = (TextView)view.findViewById(2131301372);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    UserTag userTag = this.b.get(paramInt);
    if (StringUtils.e(userTag.name)) {
      viewHolder1.a.setVisibility(8);
      return (View)viewHolder2;
    } 
    viewHolder1.a.setVisibility(0);
    viewHolder1.b.setText(userTag.name);
    return (View)viewHolder2;
  }
  
  class ViewHolder {
    public LinearLayout a;
    
    public TextView b;
    
    private ViewHolder(UserTagforUserinfoAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\UserTagforUserinfoAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */