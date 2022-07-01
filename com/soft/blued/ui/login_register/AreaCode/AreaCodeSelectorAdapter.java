package com.soft.blued.ui.login_register.AreaCode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import com.soft.blued.model.AreaCode;
import java.util.List;

public class AreaCodeSelectorAdapter extends BaseAdapter implements AreaCodeIndexer {
  private final LayoutInflater a;
  
  private List<AreaCode> b;
  
  private Context c;
  
  private ArrayMap<String, Integer> d = new ArrayMap();
  
  public AreaCodeSelectorAdapter(Context paramContext, List<AreaCode> paramList) {
    this.b = paramList;
    this.c = paramContext;
    this.a = LayoutInflater.from(this.c);
    for (int i = 0; i < this.b.size(); i++) {
      String str = ((AreaCode)this.b.get(i)).getSort();
      if (str != null && !"".equals(str)) {
        str = str.toUpperCase();
        if (!this.d.containsKey(str))
          this.d.put(str, Integer.valueOf(i)); 
      } 
    } 
  }
  
  private void a(TextView paramTextView, String paramString) {
    paramTextView.setVisibility(0);
    paramTextView.setText(paramString);
  }
  
  public int a(String paramString) {
    return this.d.containsKey(paramString) ? ((Integer)this.d.get(paramString)).intValue() : -1;
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
    if (paramView == null) {
      paramView = this.a.inflate(2131492927, paramViewGroup, false);
      viewHolder = new ViewHolder();
      viewHolder.a = (TextView)paramView.findViewById(2131300474);
      viewHolder.b = (TextView)paramView.findViewById(2131300475);
      viewHolder.c = (TextView)paramView.findViewById(2131300465);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    AreaCode areaCode = this.b.get(paramInt);
    viewHolder.a.setText(areaCode.getName());
    viewHolder.c.setText(areaCode.getCode());
    String str = areaCode.getSort().toUpperCase();
    if (paramInt == 0) {
      a(viewHolder.b, str);
      return paramView;
    } 
    if (!str.equals(((AreaCode)this.b.get(paramInt - 1)).getSort().toUpperCase())) {
      a(viewHolder.b, str);
      return paramView;
    } 
    viewHolder.b.setVisibility(8);
    return paramView;
  }
  
  static class ViewHolder {
    TextView a;
    
    TextView b;
    
    TextView c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\AreaCode\AreaCodeSelectorAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */