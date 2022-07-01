package com.chad.library.adapter.base.callback;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.R;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;

public class ItemDragAndSwipeCallback extends ItemTouchHelper.Callback {
  private BaseItemDraggableAdapter a;
  
  private float b = 0.1F;
  
  private float c = 0.7F;
  
  private int d = 15;
  
  private int e = 32;
  
  public ItemDragAndSwipeCallback(BaseItemDraggableAdapter paramBaseItemDraggableAdapter) {
    this.a = paramBaseItemDraggableAdapter;
  }
  
  private boolean a(RecyclerView.ViewHolder paramViewHolder) {
    int i = paramViewHolder.getItemViewType();
    return (i == 273 || i == 546 || i == 819 || i == 1365);
  }
  
  public void a(int paramInt) {
    this.d = paramInt;
  }
  
  public void b(int paramInt) {
    this.e = paramInt;
  }
  
  public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder) {
    super.clearView(paramRecyclerView, paramViewHolder);
    if (a(paramViewHolder))
      return; 
    if (paramViewHolder.itemView.getTag(R.id.BaseQuickAdapter_dragging_support) != null && ((Boolean)paramViewHolder.itemView.getTag(R.id.BaseQuickAdapter_dragging_support)).booleanValue()) {
      this.a.c(paramViewHolder);
      paramViewHolder.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, Boolean.valueOf(false));
    } 
    if (paramViewHolder.itemView.getTag(R.id.BaseQuickAdapter_swiping_support) != null && ((Boolean)paramViewHolder.itemView.getTag(R.id.BaseQuickAdapter_swiping_support)).booleanValue()) {
      this.a.e(paramViewHolder);
      paramViewHolder.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, Boolean.valueOf(false));
    } 
  }
  
  public float getMoveThreshold(RecyclerView.ViewHolder paramViewHolder) {
    return this.b;
  }
  
  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder) {
    return a(paramViewHolder) ? makeMovementFlags(0, 0) : makeMovementFlags(this.d, this.e);
  }
  
  public float getSwipeThreshold(RecyclerView.ViewHolder paramViewHolder) {
    return this.c;
  }
  
  public boolean isItemViewSwipeEnabled() {
    return this.a.b();
  }
  
  public boolean isLongPressDragEnabled() {
    return false;
  }
  
  public void onChildDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean) {
    super.onChildDrawOver(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, paramBoolean);
    if (paramInt == 1 && !a(paramViewHolder)) {
      View view = paramViewHolder.itemView;
      paramCanvas.save();
      if (paramFloat1 > 0.0F) {
        paramCanvas.clipRect(view.getLeft(), view.getTop(), view.getLeft() + paramFloat1, view.getBottom());
        paramCanvas.translate(view.getLeft(), view.getTop());
      } else {
        paramCanvas.clipRect(view.getRight() + paramFloat1, view.getTop(), view.getRight(), view.getBottom());
        paramCanvas.translate(view.getRight() + paramFloat1, view.getTop());
      } 
      this.a.a(paramCanvas, paramViewHolder, paramFloat1, paramFloat2, paramBoolean);
      paramCanvas.restore();
    } 
  }
  
  public boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2) {
    return (paramViewHolder1.getItemViewType() == paramViewHolder2.getItemViewType());
  }
  
  public void onMoved(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, int paramInt1, RecyclerView.ViewHolder paramViewHolder2, int paramInt2, int paramInt3, int paramInt4) {
    super.onMoved(paramRecyclerView, paramViewHolder1, paramInt1, paramViewHolder2, paramInt2, paramInt3, paramInt4);
    this.a.a(paramViewHolder1, paramViewHolder2);
  }
  
  public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    Boolean bool = Boolean.valueOf(true);
    if (paramInt == 2 && !a(paramViewHolder)) {
      this.a.b(paramViewHolder);
      paramViewHolder.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, bool);
    } else if (paramInt == 1 && !a(paramViewHolder)) {
      this.a.d(paramViewHolder);
      paramViewHolder.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, bool);
    } 
    super.onSelectedChanged(paramViewHolder, paramInt);
  }
  
  public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    if (!a(paramViewHolder))
      this.a.f(paramViewHolder); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\chad\library\adapter\base\callback\ItemDragAndSwipeCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */