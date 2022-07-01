package com.blued.android.framework.view.stickylistheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

class ExpandableStickyListHeadersAdapter extends BaseAdapter implements StickyListHeadersAdapter {
  DualHashMap<View, Long> a = new DualHashMap<View, Long>();
  
  DistinctMultiHashMap<Integer, View> b = new DistinctMultiHashMap<Integer, View>();
  
  List<Long> c = new ArrayList<Long>();
  
  private final StickyListHeadersAdapter d;
  
  ExpandableStickyListHeadersAdapter(StickyListHeadersAdapter paramStickyListHeadersAdapter) {
    this.d = paramStickyListHeadersAdapter;
  }
  
  public long a(int paramInt) {
    return this.d.a(paramInt);
  }
  
  public boolean areAllItemsEnabled() {
    return this.d.areAllItemsEnabled();
  }
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup) {
    return this.d.b(paramInt, paramView, paramViewGroup);
  }
  
  public int getCount() {
    return this.d.getCount();
  }
  
  public Object getItem(int paramInt) {
    return this.d.getItem(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return this.d.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt) {
    return this.d.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    paramView = this.d.getView(paramInt, paramView, paramViewGroup);
    this.a.a(paramView, Long.valueOf(getItemId(paramInt)));
    this.b.a(Integer.valueOf((int)a(paramInt)), paramView);
    if (this.c.contains(Long.valueOf(a(paramInt)))) {
      paramView.setVisibility(8);
      return paramView;
    } 
    paramView.setVisibility(0);
    return paramView;
  }
  
  public int getViewTypeCount() {
    return this.d.getViewTypeCount();
  }
  
  public boolean hasStableIds() {
    return this.d.hasStableIds();
  }
  
  public boolean isEmpty() {
    return this.d.isEmpty();
  }
  
  public boolean isEnabled(int paramInt) {
    return this.d.isEnabled(paramInt);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {
    this.d.registerDataSetObserver(paramDataSetObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {
    this.d.unregisterDataSetObserver(paramDataSetObserver);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\stickylistheaders\ExpandableStickyListHeadersAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */