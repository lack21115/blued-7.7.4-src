package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.image.ImageLoader;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.find.model.JoyEntryModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class GameHallAdapter extends BaseAdapter {
  public List<JoyEntryModel> a;
  
  public Context b;
  
  public int c;
  
  public LayoutInflater d;
  
  public int getCount() {
    if (this.a == null)
      this.a = new ArrayList<JoyEntryModel>(); 
    return this.a.size();
  }
  
  public Object getItem(int paramInt) {
    if (this.a == null)
      this.a = new ArrayList<JoyEntryModel>(); 
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder;
    if (paramView == null) {
      viewHolder = new ViewHolder(this);
      paramView = this.d.inflate(2131493531, null);
      viewHolder.a = (ImageView)paramView.findViewById(2131297463);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)viewHolder.a.getLayoutParams();
      layoutParams.height = this.c;
      viewHolder.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    JoyEntryModel joyEntryModel = this.a.get(paramInt);
    ImageLoader.a(null, joyEntryModel.icon).a(viewHolder.a);
    viewHolder.a.setOnClickListener(new View.OnClickListener(this, joyEntryModel) {
          public void onClick(View param1View) {
            if (!StringUtils.e(this.a.url)) {
              InstantLog.a("game_hall_item_click", this.a.url);
              WebViewShowInfoFragment.show(this.b.b, this.a.url, -1);
            } 
          }
        });
    return paramView;
  }
  
  public class ViewHolder {
    public ImageView a;
    
    public ViewHolder(GameHallAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\GameHallAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */