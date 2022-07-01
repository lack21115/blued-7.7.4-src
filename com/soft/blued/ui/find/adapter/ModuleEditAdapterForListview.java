package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.soft.blued.ui.find.model.NearbyModule;
import java.util.ArrayList;
import java.util.List;

public class ModuleEditAdapterForListview extends BaseAdapter {
  public View.OnClickListener a;
  
  private List<NearbyModule> b;
  
  private Context c;
  
  private LayoutInflater d;
  
  public ModuleEditAdapterForListview(Context paramContext, View.OnClickListener paramOnClickListener) {
    this.c = paramContext;
    this.d = LayoutInflater.from(this.c);
    this.a = paramOnClickListener;
  }
  
  public List<NearbyModule> a() {
    return this.b;
  }
  
  public void a(List<NearbyModule> paramList) {
    List<NearbyModule> list = this.b;
    if (list != null) {
      list.clear();
    } else {
      this.b = new ArrayList<NearbyModule>();
    } 
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount() {
    List<NearbyModule> list = this.b;
    return (list != null) ? list.size() : 0;
  }
  
  public Object getItem(int paramInt) {
    return null;
  }
  
  public long getItemId(int paramInt) {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    if (paramView == null) {
      viewHolder1 = new ViewHolder(this);
      View view = this.d.inflate(2131493614, paramViewGroup, false);
      viewHolder1.a = (TextView)view.findViewById(2131301409);
      viewHolder1.b = (ImageView)view.findViewById(2131297535);
      viewHolder1.c = (LinearLayout)view.findViewById(2131298900);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    NearbyModule nearbyModule = this.b.get(paramInt);
    viewHolder1.a.setText(nearbyModule.title);
    if (nearbyModule.is_fixed == 1) {
      viewHolder1.a.setTextColor(this.c.getResources().getColor(2131100543));
      viewHolder1.b.setVisibility(8);
      return (View)viewHolder2;
    } 
    viewHolder1.a.setTextColor(this.c.getResources().getColor(2131100539));
    viewHolder1.b.setVisibility(0);
    viewHolder1.b.setOnClickListener(new View.OnClickListener(this, nearbyModule, paramInt) {
          public void onClick(View param1View) {
            NearbyModule nearbyModule = this.a;
            int i = ((NearbyModule)ModuleEditAdapterForListview.a(this.c).get(this.b)).is_show;
            boolean bool = true;
            if (i == 1)
              bool = false; 
            nearbyModule.is_show = bool;
            this.c.notifyDataSetChanged();
            this.c.a.onClick(param1View);
          }
        });
    if (((NearbyModule)this.b.get(paramInt)).is_show == 1) {
      viewHolder1.b.setImageResource(2131234234);
      return (View)viewHolder2;
    } 
    viewHolder1.b.setImageResource(2131234233);
    return (View)viewHolder2;
  }
  
  public class ViewHolder {
    public TextView a;
    
    public ImageView b;
    
    public LinearLayout c;
    
    public ViewHolder(ModuleEditAdapterForListview this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\ModuleEditAdapterForListview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */