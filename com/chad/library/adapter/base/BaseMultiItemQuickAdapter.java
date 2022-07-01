package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

public abstract class BaseMultiItemQuickAdapter<T extends MultiItemEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
  private SparseIntArray a;
  
  public BaseMultiItemQuickAdapter(List<T> paramList) {
    super(paramList);
  }
  
  private int a(int paramInt) {
    return this.a.get(paramInt, -404);
  }
  
  protected K a(ViewGroup paramViewGroup, int paramInt) {
    return c(paramViewGroup, a(paramInt));
  }
  
  protected void b(int paramInt1, int paramInt2) {
    if (this.a == null)
      this.a = new SparseIntArray(); 
    this.a.put(paramInt1, paramInt2);
  }
  
  protected int c(int paramInt) {
    T t = this.n.get(paramInt);
    return (t instanceof MultiItemEntity) ? ((MultiItemEntity)t).getItemType() : -255;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\chad\library\adapter\base\BaseMultiItemQuickAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */