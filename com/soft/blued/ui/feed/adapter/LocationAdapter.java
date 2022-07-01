package com.soft.blued.ui.feed.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.soft.blued.ui.msg.model.PositionPOIModel;
import java.util.List;

public class LocationAdapter extends BaseAdapter {
  private Context a;
  
  private LayoutInflater b;
  
  private List<PositionPOIModel> c;
  
  private PositonItemClickListener d;
  
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
      View view = this.b.inflate(2131493590, null);
      viewHolder1.a = (LinearLayout)view.findViewById(2131298900);
      viewHolder1.b = (TextView)view.findViewById(2131301177);
      viewHolder1.c = (TextView)view.findViewById(2131301176);
      viewHolder1.d = (ImageView)view.findViewById(2131297455);
      viewHolder1.e = (TextView)view.findViewById(2131300719);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    PositionPOIModel positionPOIModel = this.c.get(paramInt);
    viewHolder1.b.setText(positionPOIModel.name);
    if (positionPOIModel.mark_visible) {
      viewHolder1.d.setVisibility(0);
    } else {
      viewHolder1.d.setVisibility(4);
    } 
    viewHolder1.a.setOnClickListener(new -$$Lambda$LocationAdapter$ZMEbOWUGGLXbxZeTfOhRN60asH0(this, positionPOIModel, paramInt));
    if (paramInt == 0) {
      viewHolder1.b.setTextColor(this.a.getResources().getColor(2131100618));
      viewHolder1.e.setVisibility(8);
    } else {
      viewHolder1.b.setTextColor(this.a.getResources().getColor(2131100604));
      viewHolder1.e.setVisibility(0);
    } 
    if (!TextUtils.isEmpty(positionPOIModel.address)) {
      viewHolder1.c.setText(positionPOIModel.address);
      viewHolder1.c.setVisibility(0);
      return (View)viewHolder2;
    } 
    viewHolder1.c.setText("");
    viewHolder1.c.setVisibility(8);
    return (View)viewHolder2;
  }
  
  public static interface PositonItemClickListener {
    void a(PositionPOIModel param1PositionPOIModel);
  }
  
  class ViewHolder {
    public LinearLayout a;
    
    public TextView b;
    
    public TextView c;
    
    public ImageView d;
    
    public TextView e;
    
    private ViewHolder(LocationAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\LocationAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */