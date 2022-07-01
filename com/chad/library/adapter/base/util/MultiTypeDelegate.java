package com.chad.library.adapter.base.util;

import android.util.SparseIntArray;
import java.util.List;

public abstract class MultiTypeDelegate<T> {
  private SparseIntArray a;
  
  public final int a(int paramInt) {
    return this.a.get(paramInt, -404);
  }
  
  protected abstract int a(T paramT);
  
  public final int a(List<T> paramList, int paramInt) {
    paramList = (List<T>)paramList.get(paramInt);
    return (paramList != null) ? a((T)paramList) : -255;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\chad\library\adapter\bas\\util\MultiTypeDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */