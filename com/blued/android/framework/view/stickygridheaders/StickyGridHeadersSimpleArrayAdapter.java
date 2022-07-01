package com.blued.android.framework.view.stickygridheaders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class StickyGridHeadersSimpleArrayAdapter<T> extends BaseAdapter implements StickyGridHeadersSimpleAdapter {
  protected static final String a = StickyGridHeadersSimpleArrayAdapter.class.getSimpleName();
  
  private int b;
  
  private LayoutInflater c;
  
  private int d;
  
  private List<T> e;
  
  public long a(int paramInt) {
    CharSequence charSequence;
    T t = getItem(paramInt);
    if (t instanceof CharSequence) {
      charSequence = (CharSequence)t;
    } else {
      charSequence = charSequence.toString();
    } 
    return charSequence.subSequence(0, 1).charAt(0);
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup) {
    HeaderViewHolder headerViewHolder;
    CharSequence charSequence;
    if (paramView == null) {
      paramView = this.c.inflate(this.b, paramViewGroup, false);
      headerViewHolder = new HeaderViewHolder(this);
      headerViewHolder.a = (TextView)paramView.findViewById(16908308);
      paramView.setTag(headerViewHolder);
    } else {
      headerViewHolder = (HeaderViewHolder)paramView.getTag();
    } 
    T t = getItem(paramInt);
    if (t instanceof CharSequence) {
      charSequence = (CharSequence)t;
    } else {
      charSequence = charSequence.toString();
    } 
    headerViewHolder.a.setText(charSequence.subSequence(0, 1));
    return paramView;
  }
  
  public boolean areAllItemsEnabled() {
    return false;
  }
  
  public int getCount() {
    return this.e.size();
  }
  
  public T getItem(int paramInt) {
    return this.e.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder;
    if (paramView == null) {
      paramView = this.c.inflate(this.d, paramViewGroup, false);
      viewHolder = new ViewHolder(this);
      viewHolder.a = (TextView)paramView.findViewById(16908308);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    T t = getItem(paramInt);
    if (t instanceof CharSequence) {
      viewHolder.a.setText((CharSequence)t);
      return paramView;
    } 
    viewHolder.a.setText(t.toString());
    return paramView;
  }
  
  public class HeaderViewHolder {
    public TextView a;
    
    protected HeaderViewHolder(StickyGridHeadersSimpleArrayAdapter this$0) {}
  }
  
  public class ViewHolder {
    public TextView a;
    
    protected ViewHolder(StickyGridHeadersSimpleArrayAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\stickygridheaders\StickyGridHeadersSimpleArrayAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */