package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;
import java.util.Map;

public abstract class BaseListAdapter<E> extends BaseAdapter {
  public List<E> a;
  
  public Context b;
  
  public LayoutInflater c;
  
  public Map<Integer, onInternalClickListener> d;
  
  public BaseListAdapter(Context paramContext, List<E> paramList) {
    this.b = paramContext;
    this.a = paramList;
    this.c = LayoutInflater.from(paramContext);
  }
  
  private void a(View paramView, Integer paramInteger, Object paramObject) {
    Map<Integer, onInternalClickListener> map = this.d;
    if (map != null && paramView != null)
      for (Integer integer : map.keySet()) {
        View view = paramView.findViewById(integer.intValue());
        onInternalClickListener onInternalClickListener = this.d.get(integer);
        if (view != null && onInternalClickListener != null)
          view.setOnClickListener(new View.OnClickListener(this, onInternalClickListener, paramView, paramInteger, paramObject) {
                public void onClick(View param1View) {
                  this.a.a(this.b, param1View, this.c, this.d);
                }
              }); 
      }  
  }
  
  public abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public List<E> a() {
    return this.a;
  }
  
  public void a(E paramE) {
    this.a.add(paramE);
    notifyDataSetChanged();
  }
  
  public int getCount() {
    return this.a.size();
  }
  
  public Object getItem(int paramInt) {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    paramView = a(paramInt, paramView, paramViewGroup);
    a(paramView, Integer.valueOf(paramInt), this.a.get(paramInt));
    return paramView;
  }
  
  public static interface onInternalClickListener {
    void a(View param1View1, View param1View2, Integer param1Integer, Object param1Object);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\BaseListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */