package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import com.soft.blued.ui.login_register.AreaCode.AreaCodeIndexer;
import com.soft.blued.ui.user.model.Country;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CountryAdapter extends BaseAdapter implements AreaCodeIndexer {
  private final LayoutInflater a;
  
  private List<Country> b = new ArrayList<Country>();
  
  private List<Country> c = new ArrayList<Country>();
  
  private List<Country> d = new ArrayList<Country>();
  
  private Context e;
  
  private Map<String, Integer> f = (Map<String, Integer>)new ArrayMap();
  
  public CountryAdapter(Context paramContext, List<Country> paramList) {
    this.b = paramList;
    this.c.addAll(paramList);
    this.d.addAll(paramList);
    this.e = paramContext;
    this.a = LayoutInflater.from(this.e);
    for (int i = 0; i < this.b.size(); i++) {
      String str = ((Country)this.b.get(i)).group_by;
      if (str != null && !"".equals(str)) {
        str = str.toUpperCase();
        if (!this.f.containsKey(str))
          this.f.put(str, Integer.valueOf(i)); 
      } 
    } 
  }
  
  private void a(TextView paramTextView, String paramString) {
    paramTextView.setVisibility(0);
    paramTextView.setText(paramString);
  }
  
  public int a(String paramString) {
    return this.f.containsKey(paramString) ? ((Integer)this.f.get(paramString)).intValue() : -1;
  }
  
  public void a(Country paramCountry) {
    if (paramCountry != null) {
      List<Country> list = this.c;
      if (list != null && list.size() > 0) {
        this.c.add(0, paramCountry);
        this.b.add(0, paramCountry);
      } 
    } 
  }
  
  public void b(String paramString) {
    List<Country> list = this.c;
    if (list != null && list.size() > 0) {
      this.d.clear();
      for (int i = 0; i < this.c.size(); i++) {
        if (((Country)this.c.get(i)).nation.contains(paramString) || ((Country)this.c.get(i)).abbr.contains(paramString) || ((Country)this.c.get(i)).group_by.equals(this.e.getResources().getString(2131758408)))
          this.d.add(this.c.get(i)); 
      } 
      this.b.clear();
      if (!StringUtils.e(paramString)) {
        this.b.addAll(this.d);
        return;
      } 
      this.b.addAll(this.c);
    } 
  }
  
  public int getCount() {
    return this.b.size();
  }
  
  public Object getItem(int paramInt) {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return ((Country)this.b.get(paramInt)).abbr.hashCode();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder;
    if (paramView == null) {
      paramView = this.a.inflate(2131493334, paramViewGroup, false);
      viewHolder = new ViewHolder();
      viewHolder.a = (TextView)paramView.findViewById(2131301088);
      viewHolder.b = (TextView)paramView.findViewById(2131300811);
      viewHolder.c = paramView.findViewById(2131301278);
      viewHolder.d = (TextView)paramView.findViewById(2131300694);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    Country country = this.b.get(paramInt);
    viewHolder.a.setText(country.nation);
    String str1 = country.group_by;
    String str2 = str1.toUpperCase();
    if (paramInt == 0) {
      if (!StringUtils.e(str1)) {
        a(viewHolder.b, str2);
        viewHolder.d.setVisibility(8);
        viewHolder.b.setVisibility(0);
      } else {
        viewHolder.d.setVisibility(8);
        viewHolder.b.setVisibility(8);
      } 
    } else if (!str2.equals(((Country)this.b.get(paramInt - 1)).group_by.toUpperCase())) {
      a(viewHolder.b, str2);
      viewHolder.d.setVisibility(8);
    } else {
      viewHolder.b.setVisibility(8);
      viewHolder.d.setVisibility(0);
    } 
    if ("1".equals(country.has_child)) {
      viewHolder.c.setVisibility(0);
      return paramView;
    } 
    viewHolder.c.setVisibility(8);
    return paramView;
  }
  
  static class ViewHolder {
    TextView a;
    
    TextView b;
    
    View c;
    
    TextView d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\CountryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */