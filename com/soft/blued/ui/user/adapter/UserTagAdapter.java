package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class UserTagAdapter extends BaseAdapter {
  private LayoutInflater a;
  
  private List<UserTag> b;
  
  private Context c;
  
  public UserTagAdapter(Context paramContext, List<UserTag> paramList) {
    this.a = LayoutInflater.from(paramContext);
    List<UserTag> list = paramList;
    if (paramList == null)
      list = new ArrayList<UserTag>(); 
    this.b = list;
    this.c = paramContext;
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
    if (paramView == null) {
      viewHolder1 = new ViewHolder();
      View view = this.a.inflate(2131493670, paramViewGroup, false);
      viewHolder1.a = (LinearLayout)view.findViewById(2131298718);
      viewHolder1.b = (TextView)view.findViewById(2131301372);
      ViewGroup.LayoutParams layoutParams = viewHolder1.a.getLayoutParams();
      layoutParams.width = ((this.c.getResources().getDisplayMetrics()).widthPixels - DensityUtils.a(this.c, 90.0F)) / 4;
      viewHolder1.a.setLayoutParams(layoutParams);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    UserTag userTag = this.b.get(paramInt);
    if (userTag.checked == 1) {
      if (Build.VERSION.SDK_INT < 16) {
        viewHolder1.a.setBackgroundDrawable(BluedSkinUtils.b(this.c, 2131234362));
      } else {
        viewHolder1.a.setBackground(BluedSkinUtils.b(this.c, 2131234362));
      } 
      viewHolder1.b.setTextColor(BluedSkinUtils.a(this.c, 2131100728));
    } else {
      if (Build.VERSION.SDK_INT < 16) {
        viewHolder1.a.setBackgroundDrawable(BluedSkinUtils.b(this.c, 2131234361));
      } else {
        viewHolder1.a.setBackground(BluedSkinUtils.b(this.c, 2131234361));
      } 
      viewHolder1.b.setTextColor(BluedSkinUtils.a(this.c, 2131100838));
    } 
    if (StringUtils.e(userTag.name)) {
      viewHolder1.a.setVisibility(8);
    } else {
      viewHolder1.a.setVisibility(0);
      viewHolder1.b.setText(userTag.name);
    } 
    if (!userTag.chooseable) {
      viewHolder1.b.setTextColor(BluedSkinUtils.a(this.c, 2131100842));
      if (Build.VERSION.SDK_INT < 16) {
        viewHolder1.a.setBackgroundDrawable(BluedSkinUtils.b(this.c, 2131234361));
        return (View)viewHolder2;
      } 
      viewHolder1.a.setBackground(BluedSkinUtils.b(this.c, 2131234361));
      return (View)viewHolder2;
    } 
    viewHolder1.b.setTextColor(viewHolder1.b.getTextColors());
    if (Build.VERSION.SDK_INT < 16) {
      viewHolder1.a.setBackgroundDrawable(viewHolder1.a.getBackground());
      return (View)viewHolder2;
    } 
    viewHolder1.a.setBackground(viewHolder1.a.getBackground());
    return (View)viewHolder2;
  }
  
  class ViewHolder {
    public LinearLayout a;
    
    public TextView b;
    
    private ViewHolder(UserTagAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\UserTagAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */