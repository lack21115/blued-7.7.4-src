package com.blued.android.module.common.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import java.util.ArrayList;
import java.util.List;

public abstract class CommonAdapter<T> extends BaseAdapter {
  public Context a = AppInfo.d();
  
  protected final List<T> b = new ArrayList<T>();
  
  public MultiItemTypeSupport<T> c;
  
  private int d;
  
  public CommonAdapter(int paramInt) {
    this.d = paramInt;
  }
  
  public ViewHolder a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2) {
    MultiItemTypeSupport<T> multiItemTypeSupport = this.c;
    return (multiItemTypeSupport != null) ? a(this.a, paramView, paramViewGroup, multiItemTypeSupport.a(paramInt1, this.b.get(paramInt1)), paramInt1, paramInt2) : a(this.a, paramView, paramViewGroup, this.d, paramInt2, paramInt1);
  }
  
  ViewHolder a(Context paramContext, View paramView, ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3) {
    if (paramView == null)
      return new ViewHolder(paramContext, paramViewGroup, paramInt1, paramInt2, paramInt3); 
    ViewHolder viewHolder = (ViewHolder)paramView.getTag();
    if (viewHolder.a != paramInt1)
      return new ViewHolder(paramContext, paramViewGroup, paramInt1, paramInt2, paramInt3); 
    viewHolder.c = paramInt3;
    return viewHolder;
  }
  
  public abstract void a(ViewHolder paramViewHolder, T paramT, int paramInt);
  
  public void a(List<? extends T> paramList) {
    if (paramList == null)
      return; 
    this.b.clear();
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount() {
    return this.b.size();
  }
  
  public T getItem(int paramInt) {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt) {
    return (this.c != null) ? ((paramInt >= this.b.size()) ? 0 : this.c.b(paramInt, this.b.get(paramInt))) : ((paramInt >= this.b.size()) ? 0 : 1);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder = a(paramInt, paramView, paramViewGroup, getCount());
    a(viewHolder, getItem(paramInt), paramInt);
    return viewHolder.a();
  }
  
  public int getViewTypeCount() {
    MultiItemTypeSupport<T> multiItemTypeSupport = this.c;
    return (multiItemTypeSupport != null) ? multiItemTypeSupport.a() : 1;
  }
  
  public static class ViewHolder {
    public int a;
    
    public int b;
    
    public int c;
    
    private SparseArray<View> d = new SparseArray();
    
    private View e;
    
    private ViewHolder(Context param1Context, ViewGroup param1ViewGroup, int param1Int1, int param1Int2, int param1Int3) {
      this.e = LayoutInflater.from(param1Context).inflate(param1Int1, param1ViewGroup, false);
      this.a = param1Int1;
      this.e.setTag(this);
      this.b = param1Int2;
      this.c = param1Int3;
    }
    
    public View a() {
      return this.e;
    }
    
    public <T extends View> T a(int param1Int) {
      View view2 = (View)this.d.get(param1Int);
      View view1 = view2;
      if (view2 == null) {
        view1 = this.e.findViewById(param1Int);
        this.d.put(param1Int, view1);
      } 
      return (T)view1;
    }
    
    public ViewHolder a(int param1Int1, int param1Int2) {
      TextView textView = a(param1Int1);
      if (textView != null)
        textView.setTextColor(param1Int2); 
      return this;
    }
    
    public ViewHolder a(int param1Int, String param1String) {
      TextView textView = a(param1Int);
      if (textView != null)
        textView.setText(param1String); 
      return this;
    }
    
    public ViewHolder b(int param1Int1, int param1Int2) {
      View view = (View)a(param1Int1);
      if (view != null)
        view.setVisibility(param1Int2); 
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\adapter\CommonAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */