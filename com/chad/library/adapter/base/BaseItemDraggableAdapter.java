package com.chad.library.adapter.base;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.R;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import java.util.Collections;
import java.util.List;

public abstract class BaseItemDraggableAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
  protected int a = 0;
  
  protected ItemTouchHelper b;
  
  protected boolean c = false;
  
  protected boolean d = false;
  
  protected OnItemDragListener e;
  
  protected OnItemSwipeListener f;
  
  protected boolean g = true;
  
  protected View.OnTouchListener h;
  
  protected View.OnLongClickListener i;
  
  public BaseItemDraggableAdapter(int paramInt, List<T> paramList) {
    super(paramInt, paramList);
  }
  
  private boolean b(int paramInt) {
    return (paramInt >= 0 && paramInt < this.n.size());
  }
  
  public int a(RecyclerView.ViewHolder paramViewHolder) {
    return paramViewHolder.getAdapterPosition() - o();
  }
  
  public void a() {
    this.d = false;
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  public void a(Canvas paramCanvas, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    OnItemSwipeListener onItemSwipeListener = this.f;
    if (onItemSwipeListener != null && this.d)
      onItemSwipeListener.a(paramCanvas, paramViewHolder, paramFloat1, paramFloat2, paramBoolean); 
  }
  
  public void a(ItemTouchHelper paramItemTouchHelper) {
    a(paramItemTouchHelper, 0, true);
  }
  
  public void a(ItemTouchHelper paramItemTouchHelper, int paramInt, boolean paramBoolean) {
    this.c = true;
    this.b = paramItemTouchHelper;
    a(paramInt);
    a(paramBoolean);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2) {
    int i = a(paramViewHolder1);
    int j = a(paramViewHolder2);
    if (b(i) && b(j)) {
      if (i < j) {
        int k;
        for (k = i; k < j; k = m) {
          List<T> list = this.n;
          int m = k + 1;
          Collections.swap(list, k, m);
        } 
      } else {
        int k;
        for (k = i; k > j; k--)
          Collections.swap(this.n, k, k - 1); 
      } 
      notifyItemMoved(paramViewHolder1.getAdapterPosition(), paramViewHolder2.getAdapterPosition());
    } 
    OnItemDragListener onItemDragListener = this.e;
    if (onItemDragListener != null && this.c)
      onItemDragListener.a(paramViewHolder1, i, paramViewHolder2, j); 
  }
  
  public void a(K paramK, int paramInt) {
    super.a(paramK, paramInt);
    paramInt = paramK.getItemViewType();
    if (this.b != null && this.c && paramInt != 546 && paramInt != 273 && paramInt != 1365 && paramInt != 819) {
      paramInt = this.a;
      if (paramInt != 0) {
        View view = (View)paramK.d(paramInt);
        if (view != null) {
          view.setTag(R.id.BaseQuickAdapter_viewholder_support, paramK);
          if (this.g) {
            view.setOnLongClickListener(this.i);
            return;
          } 
          view.setOnTouchListener(this.h);
          return;
        } 
      } else {
        ((BaseViewHolder)paramK).itemView.setTag(R.id.BaseQuickAdapter_viewholder_support, paramK);
        ((BaseViewHolder)paramK).itemView.setOnLongClickListener(this.i);
      } 
    } 
  }
  
  public void a(OnItemDragListener paramOnItemDragListener) {
    this.e = paramOnItemDragListener;
  }
  
  public void a(boolean paramBoolean) {
    this.g = paramBoolean;
    if (this.g) {
      this.h = null;
      this.i = new View.OnLongClickListener(this) {
          public boolean onLongClick(View param1View) {
            if (this.a.b != null && this.a.c)
              this.a.b.startDrag((RecyclerView.ViewHolder)param1View.getTag(R.id.BaseQuickAdapter_viewholder_support)); 
            return true;
          }
        };
      return;
    } 
    this.h = new View.OnTouchListener(this) {
        public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
          if (MotionEventCompat.getActionMasked(param1MotionEvent) == 0 && !this.a.g) {
            if (this.a.b != null && this.a.c)
              this.a.b.startDrag((RecyclerView.ViewHolder)param1View.getTag(R.id.BaseQuickAdapter_viewholder_support)); 
            return true;
          } 
          return false;
        }
      };
    this.i = null;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {
    OnItemDragListener onItemDragListener = this.e;
    if (onItemDragListener != null && this.c)
      onItemDragListener.a(paramViewHolder, a(paramViewHolder)); 
  }
  
  public boolean b() {
    return this.d;
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder) {
    OnItemDragListener onItemDragListener = this.e;
    if (onItemDragListener != null && this.c)
      onItemDragListener.b(paramViewHolder, a(paramViewHolder)); 
  }
  
  public void d(RecyclerView.ViewHolder paramViewHolder) {
    OnItemSwipeListener onItemSwipeListener = this.f;
    if (onItemSwipeListener != null && this.d)
      onItemSwipeListener.a(paramViewHolder, a(paramViewHolder)); 
  }
  
  public void e(RecyclerView.ViewHolder paramViewHolder) {
    OnItemSwipeListener onItemSwipeListener = this.f;
    if (onItemSwipeListener != null && this.d)
      onItemSwipeListener.b(paramViewHolder, a(paramViewHolder)); 
  }
  
  public void f(RecyclerView.ViewHolder paramViewHolder) {
    OnItemSwipeListener onItemSwipeListener = this.f;
    if (onItemSwipeListener != null && this.d)
      onItemSwipeListener.c(paramViewHolder, a(paramViewHolder)); 
    int i = a(paramViewHolder);
    if (b(i)) {
      this.n.remove(i);
      notifyItemRemoved(paramViewHolder.getAdapterPosition());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\chad\library\adapter\base\BaseItemDraggableAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */