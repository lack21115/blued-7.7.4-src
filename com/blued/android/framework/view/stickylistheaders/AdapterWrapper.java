package com.blued.android.framework.view.stickylistheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.LinkedList;
import java.util.List;

class AdapterWrapper extends BaseAdapter implements StickyListHeadersAdapter {
  final StickyListHeadersAdapter a;
  
  private final List<View> b = new LinkedList<View>();
  
  private final Context c;
  
  private Drawable d;
  
  private int e;
  
  private OnHeaderClickListener f;
  
  private DataSetObserver g = new DataSetObserver(this) {
      public void onChanged() {
        AdapterWrapper.c(this.a);
      }
      
      public void onInvalidated() {
        AdapterWrapper.a(this.a).clear();
        AdapterWrapper.b(this.a);
      }
    };
  
  AdapterWrapper(Context paramContext, StickyListHeadersAdapter paramStickyListHeadersAdapter) {
    this.c = paramContext;
    this.a = paramStickyListHeadersAdapter;
    paramStickyListHeadersAdapter.registerDataSetObserver(this.g);
  }
  
  private View a() {
    return (this.b.size() > 0) ? this.b.remove(0) : null;
  }
  
  private View a(WrapperView paramWrapperView, int paramInt) {
    View view2;
    if (paramWrapperView.d == null) {
      view2 = a();
    } else {
      view2 = paramWrapperView.d;
    } 
    View view1 = this.a.b(paramInt, view2, paramWrapperView);
    if (view1 != null) {
      view1.setClickable(true);
      view1.setOnClickListener(new View.OnClickListener(this, paramInt) {
            public void onClick(View param1View) {
              if (AdapterWrapper.d(this.b) != null) {
                long l = this.b.a.a(this.a);
                AdapterWrapper.d(this.b).a(param1View, this.a, l);
              } 
            }
          });
      return view1;
    } 
    throw new NullPointerException("Header view must not be null.");
  }
  
  private void a(WrapperView paramWrapperView) {
    View view = paramWrapperView.d;
    if (view != null) {
      view.setVisibility(0);
      this.b.add(view);
    } 
  }
  
  private boolean b(int paramInt) {
    return (paramInt != 0 && this.a.a(paramInt) == this.a.a(paramInt - 1));
  }
  
  public long a(int paramInt) {
    return this.a.a(paramInt);
  }
  
  public WrapperView a(int paramInt, View paramView, ViewGroup paramViewGroup) {
    WrapperView wrapperView;
    if (paramView == null) {
      wrapperView = new WrapperView(this.c);
    } else {
      wrapperView = wrapperView;
    } 
    View view2 = this.a.getView(paramInt, wrapperView.a, paramViewGroup);
    View view1 = null;
    if (b(paramInt)) {
      a(wrapperView);
    } else {
      view1 = a(wrapperView, paramInt);
    } 
    boolean bool = view2 instanceof android.widget.Checkable;
    if (bool && !(wrapperView instanceof CheckableWrapperView)) {
      paramViewGroup = new CheckableWrapperView(this.c);
    } else {
      paramViewGroup = wrapperView;
      if (!bool) {
        paramViewGroup = wrapperView;
        if (wrapperView instanceof CheckableWrapperView)
          paramViewGroup = new WrapperView(this.c); 
      } 
    } 
    paramViewGroup.a(view2, view1, this.d, this.e);
    return (WrapperView)paramViewGroup;
  }
  
  void a(Drawable paramDrawable, int paramInt) {
    this.d = paramDrawable;
    this.e = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(OnHeaderClickListener paramOnHeaderClickListener) {
    this.f = paramOnHeaderClickListener;
  }
  
  public boolean areAllItemsEnabled() {
    return this.a.areAllItemsEnabled();
  }
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup) {
    return this.a.b(paramInt, paramView, paramViewGroup);
  }
  
  public boolean equals(Object paramObject) {
    return this.a.equals(paramObject);
  }
  
  public int getCount() {
    return this.a.getCount();
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    return ((BaseAdapter)this.a).getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public Object getItem(int paramInt) {
    return this.a.getItem(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return this.a.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt) {
    return this.a.getItemViewType(paramInt);
  }
  
  public int getViewTypeCount() {
    return this.a.getViewTypeCount();
  }
  
  public boolean hasStableIds() {
    return this.a.hasStableIds();
  }
  
  public int hashCode() {
    return this.a.hashCode();
  }
  
  public boolean isEmpty() {
    return this.a.isEmpty();
  }
  
  public boolean isEnabled(int paramInt) {
    return this.a.isEnabled(paramInt);
  }
  
  public void notifyDataSetChanged() {
    ((BaseAdapter)this.a).notifyDataSetChanged();
  }
  
  public void notifyDataSetInvalidated() {
    ((BaseAdapter)this.a).notifyDataSetInvalidated();
  }
  
  public String toString() {
    return this.a.toString();
  }
  
  static interface OnHeaderClickListener {
    void a(View param1View, int param1Int, long param1Long);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\stickylistheaders\AdapterWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */