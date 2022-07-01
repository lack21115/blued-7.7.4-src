package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.ui.user.model.VIPPrivilegeModel;
import java.util.List;

public class VIPPrivilegeAdapter extends BaseAdapter {
  private LayoutInflater a;
  
  private Context b;
  
  private IRequestHost c;
  
  private List<VIPPrivilegeModel> d;
  
  public VIPPrivilegeAdapter(Context paramContext, IRequestHost paramIRequestHost, List<VIPPrivilegeModel> paramList, GridView paramGridView) {
    this.b = paramContext;
    this.c = paramIRequestHost;
    this.a = LayoutInflater.from(paramContext);
    this.d = paramList;
    paramGridView.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            if ((VIPPrivilegeModel)VIPPrivilegeAdapter.a(this.a).get(param1Int) == null);
          }
        });
  }
  
  public int getCount() {
    return this.d.size();
  }
  
  public Object getItem(int paramInt) {
    return this.d.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view;
    ViewHolder viewHolder;
    if (paramView == null) {
      ViewHolder viewHolder1 = new ViewHolder(this);
      View view1 = this.a.inflate(2131493688, paramViewGroup, false);
      viewHolder1.a = (ImageView)view1.findViewById(2131301709);
      viewHolder1.b = (TextView)view1.findViewById(2131301708);
      view1.setTag(viewHolder1);
      viewHolder = viewHolder1;
      view = view1;
    } else {
      viewHolder = (ViewHolder)view.getTag();
    } 
    VIPPrivilegeModel vIPPrivilegeModel = this.d.get(paramInt);
    if (vIPPrivilegeModel != null) {
      ImageLoader.a(this.c, vIPPrivilegeModel.icon).a(2131234356).c().a(viewHolder.a);
      viewHolder.b.setText(vIPPrivilegeModel.name);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("model.name:");
      stringBuilder.append(vIPPrivilegeModel.name);
      stringBuilder.append(" -- position");
      Log.v("drb", stringBuilder.toString());
    } 
    return view;
  }
  
  class ViewHolder {
    public ImageView a;
    
    public TextView b;
    
    ViewHolder(VIPPrivilegeAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\VIPPrivilegeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */