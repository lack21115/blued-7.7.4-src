package com.chad.library.adapter.base;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class BaseViewHolder extends RecyclerView.ViewHolder {
  @Deprecated
  public View p;
  
  private final SparseArray<View> q = new SparseArray();
  
  private final HashSet<Integer> r = new HashSet<Integer>();
  
  private final LinkedHashSet<Integer> s = new LinkedHashSet<Integer>();
  
  private final LinkedHashSet<Integer> t = new LinkedHashSet<Integer>();
  
  private BaseQuickAdapter u;
  
  public BaseViewHolder(View paramView) {
    super(paramView);
    this.p = paramView;
  }
  
  private int A() {
    return (getLayoutPosition() >= this.u.o()) ? (getLayoutPosition() - this.u.o()) : 0;
  }
  
  public BaseViewHolder a(int paramInt, Drawable paramDrawable) {
    ((ImageView)d(paramInt)).setImageDrawable(paramDrawable);
    return this;
  }
  
  @Deprecated
  public BaseViewHolder a(int paramInt, View.OnClickListener paramOnClickListener) {
    d(paramInt).setOnClickListener(paramOnClickListener);
    return this;
  }
  
  public BaseViewHolder a(int paramInt, CharSequence paramCharSequence) {
    ((TextView)d(paramInt)).setText(paramCharSequence);
    return this;
  }
  
  protected BaseViewHolder a(BaseQuickAdapter paramBaseQuickAdapter) {
    this.u = paramBaseQuickAdapter;
    return this;
  }
  
  public BaseViewHolder b(int paramInt1, int paramInt2) {
    ((TextView)d(paramInt1)).setText(paramInt2);
    return this;
  }
  
  public BaseViewHolder b(int paramInt, boolean paramBoolean) {
    View view = (View)d(paramInt);
    if (paramBoolean) {
      paramInt = 0;
    } else {
      paramInt = 8;
    } 
    view.setVisibility(paramInt);
    return this;
  }
  
  public BaseViewHolder c(int paramInt) {
    this.s.add(Integer.valueOf(paramInt));
    View view = (View)d(paramInt);
    if (view != null) {
      if (!view.isClickable())
        view.setClickable(true); 
      view.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (BaseViewHolder.a(this.a).y() != null)
                BaseViewHolder.a(this.a).y().onItemChildClick(BaseViewHolder.a(this.a), param1View, BaseViewHolder.b(this.a)); 
            }
          });
    } 
    return this;
  }
  
  public BaseViewHolder c(int paramInt1, int paramInt2) {
    ((ImageView)d(paramInt1)).setImageResource(paramInt2);
    return this;
  }
  
  public BaseViewHolder c(int paramInt, boolean paramBoolean) {
    View view = (View)d(paramInt);
    if (paramBoolean) {
      paramInt = 0;
    } else {
      paramInt = 4;
    } 
    view.setVisibility(paramInt);
    return this;
  }
  
  public <T extends View> T d(int paramInt) {
    View view2 = (View)this.q.get(paramInt);
    View view1 = view2;
    if (view2 == null) {
      view1 = this.itemView.findViewById(paramInt);
      this.q.put(paramInt, view1);
    } 
    return (T)view1;
  }
  
  public BaseViewHolder d(int paramInt1, int paramInt2) {
    d(paramInt1).setBackgroundColor(paramInt2);
    return this;
  }
  
  public BaseViewHolder e(int paramInt1, int paramInt2) {
    d(paramInt1).setBackgroundResource(paramInt2);
    return this;
  }
  
  public BaseViewHolder f(int paramInt1, int paramInt2) {
    ((TextView)d(paramInt1)).setTextColor(paramInt2);
    return this;
  }
  
  public Set<Integer> w() {
    return this.r;
  }
  
  public HashSet<Integer> x() {
    return this.t;
  }
  
  public HashSet<Integer> y() {
    return this.s;
  }
  
  @Deprecated
  public View z() {
    return this.p;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\chad\library\adapter\base\BaseViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */