package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.user.model.VIPBuyOption;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class VIPBuyAdapter extends BaseAdapter {
  public onGoodClick a;
  
  private LayoutInflater b;
  
  private List<VIPBuyOption> c;
  
  private Context d;
  
  private LoadOptions e;
  
  private int f;
  
  public VIPBuyAdapter(Context paramContext, int paramInt) {
    this.b = LayoutInflater.from(paramContext);
    this.c = new ArrayList<VIPBuyOption>();
    this.d = paramContext;
    this.e = new LoadOptions();
    LoadOptions loadOptions = this.e;
    loadOptions.d = 2131231369;
    loadOptions.b = 2131231369;
    this.f = paramInt;
  }
  
  public VIPBuyOption a() {
    VIPBuyOption vIPBuyOption = null;
    for (int i = 0; i < this.c.size(); i++) {
      if (((VIPBuyOption)this.c.get(i)).choosen)
        vIPBuyOption = this.c.get(i); 
    } 
    return vIPBuyOption;
  }
  
  public void a(int paramInt) {
    if (paramInt < this.c.size()) {
      for (int i = 0; i < this.c.size(); i++)
        ((VIPBuyOption)this.c.get(i)).choosen = false; 
      ((VIPBuyOption)this.c.get(paramInt)).choosen = true;
      onGoodClick onGoodClick1 = this.a;
      if (onGoodClick1 != null)
        onGoodClick1.onclick(this.c.get(paramInt)); 
    } 
  }
  
  public void a(onGoodClick paramonGoodClick) {
    this.a = paramonGoodClick;
  }
  
  public void a(List<VIPBuyOption> paramList) {
    if (paramList != null) {
      for (int i = 0; i < paramList.size(); i++)
        ((VIPBuyOption)paramList.get(i)).vip_grade = this.f; 
      this.c.clear();
      this.c.addAll(paramList);
      notifyDataSetChanged();
    } 
  }
  
  public int getCount() {
    return this.c.size();
  }
  
  public Object getItem(int paramInt) {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    if (paramView == null) {
      viewHolder1 = new ViewHolder();
      View view = this.b.inflate(2131493686, paramViewGroup, false);
      ViewHolder.a(viewHolder1, (TextView)view.findViewById(2131301047));
      ViewHolder.b(viewHolder1, (TextView)view.findViewById(2131300704));
      ViewHolder.c(viewHolder1, (TextView)view.findViewById(2131300487));
      ViewHolder.a(viewHolder1, (ConstraintLayout)view.findViewById(2131299712));
      ViewHolder.d(viewHolder1, (TextView)view.findViewById(2131301370));
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    VIPBuyOption vIPBuyOption = this.c.get(paramInt);
    if (vIPBuyOption != null) {
      String str;
      DecimalFormat decimalFormat = new DecimalFormat("#.##");
      TextView textView = ViewHolder.a(viewHolder1);
      StringBuilder stringBuilder = new StringBuilder();
      if (BlueAppLocal.a().equalsIgnoreCase("en")) {
        str = "￥";
      } else {
        str = "";
      } 
      stringBuilder.append(str);
      stringBuilder.append(decimalFormat.format(vIPBuyOption.money / vIPBuyOption.month));
      textView.setText(stringBuilder.toString());
      viewHolder2.setOnClickListener(new -$$Lambda$VIPBuyAdapter$5nYFgIXWoEE_8Qwaa2j885_iB0E(this, paramInt, vIPBuyOption));
      if (vIPBuyOption.item != null) {
        ViewHolder.b(viewHolder1).setText(vIPBuyOption.item.name);
        ViewHolder.c(viewHolder1).setText(vIPBuyOption.item.description);
        if (TextUtils.isEmpty(vIPBuyOption.item.tag)) {
          ViewHolder.d(viewHolder1).setVisibility(8);
        } else {
          ViewHolder.d(viewHolder1).setVisibility(0);
          ViewHolder.d(viewHolder1).setText(vIPBuyOption.item.tag);
        } 
      } 
      if (vIPBuyOption.choosen) {
        if (this.f == 2) {
          ViewHolder.e(viewHolder1).setBackground(this.d.getResources().getDrawable(2131233739));
          return (View)viewHolder2;
        } 
        ViewHolder.e(viewHolder1).setBackground(this.d.getResources().getDrawable(2131233745));
        return (View)viewHolder2;
      } 
      ViewHolder.e(viewHolder1).setBackground(BluedSkinUtils.b(this.d, 2131233751));
    } 
    return (View)viewHolder2;
  }
  
  class ViewHolder {
    private TextView b;
    
    private TextView c;
    
    private TextView d;
    
    private ConstraintLayout e;
    
    private TextView f;
    
    private ViewHolder(VIPBuyAdapter this$0) {}
  }
  
  public static interface onGoodClick {
    void onclick(VIPBuyOption param1VIPBuyOption);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\VIPBuyAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */