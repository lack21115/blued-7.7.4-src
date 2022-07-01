package com.blued.android.framework.view.stickygridheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

public class StickyGridHeadersListAdapterWrapper extends BaseAdapter implements StickyGridHeadersBaseAdapter {
  private DataSetObserver a = new DataSetObserver(this) {
      public void onChanged() {
        this.a.notifyDataSetChanged();
      }
      
      public void onInvalidated() {
        this.a.notifyDataSetInvalidated();
      }
    };
  
  private ListAdapter b;
  
  public StickyGridHeadersListAdapterWrapper(ListAdapter paramListAdapter) {
    this.b = paramListAdapter;
    if (paramListAdapter != null)
      paramListAdapter.registerDataSetObserver(this.a); 
  }
  
  public int a() {
    return 0;
  }
  
  public int a(int paramInt) {
    return 0;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup) {
    return null;
  }
  
  public int getCount() {
    ListAdapter listAdapter = this.b;
    return (listAdapter == null) ? 0 : listAdapter.getCount();
  }
  
  public Object getItem(int paramInt) {
    ListAdapter listAdapter = this.b;
    return (listAdapter == null) ? null : listAdapter.getItem(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return this.b.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt) {
    return this.b.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    return this.b.getView(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount() {
    return this.b.getViewTypeCount();
  }
  
  public boolean hasStableIds() {
    return this.b.hasStableIds();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\stickygridheaders\StickyGridHeadersListAdapterWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */