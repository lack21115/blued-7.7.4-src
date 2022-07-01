package com.soft.blued.ui.login_register.AreaCode;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.soft.blued.model.AreaCode;
import com.soft.blued.utils.StringUtils;
import java.util.List;

public class AreaCodeSelectorSearchAdapter extends BaseAdapter {
  private final LayoutInflater a;
  
  private List<AreaCode> b;
  
  private Context c;
  
  private String d;
  
  public AreaCodeSelectorSearchAdapter(Context paramContext, List<AreaCode> paramList) {
    this.b = paramList;
    this.c = paramContext;
    this.a = LayoutInflater.from(this.c);
  }
  
  public void a(List<AreaCode> paramList, String paramString) {
    this.d = paramString;
    this.b.clear();
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount() {
    return this.b.size();
  }
  
  public Object getItem(int paramInt) {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return ((AreaCode)this.b.get(paramInt)).getSort().hashCode();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder;
    int i = 0;
    if (paramView == null) {
      paramView = this.a.inflate(2131492928, paramViewGroup, false);
      viewHolder = new ViewHolder();
      viewHolder.a = (TextView)paramView.findViewById(2131300474);
      viewHolder.b = (TextView)paramView.findViewById(2131300465);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    AreaCode areaCode = this.b.get(paramInt);
    viewHolder.b.setText(areaCode.getCode());
    String str = areaCode.getName();
    if (!StringUtils.e(str) && !StringUtils.e(this.d)) {
      if (str.toLowerCase().contains(this.d.toLowerCase())) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        str = str.toLowerCase();
        this.d = this.d.toLowerCase();
        paramInt = i;
        while (paramInt < str.length()) {
          i = str.indexOf(this.d, paramInt);
          if (i >= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#f46200")), i, this.d.length() + i, 33);
            paramInt = Math.max(paramInt + 1, i);
          } 
        } 
        viewHolder.a.setText((CharSequence)spannableStringBuilder);
        return paramView;
      } 
      viewHolder.a.setText(str);
      return paramView;
    } 
    viewHolder.a.setText(str);
    return paramView;
  }
  
  static class ViewHolder {
    TextView a;
    
    TextView b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\AreaCode\AreaCodeSelectorSearchAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */