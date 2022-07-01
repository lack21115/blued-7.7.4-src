package com.blued.android.module.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BluedGridLayoutManager extends GridLayoutManager {
  public BluedGridLayoutManager(Context paramContext, int paramInt) {
    super(paramContext, paramInt);
  }
  
  public BluedGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    try {
      super.onLayoutChildren(paramRecycler, paramState);
      return;
    } catch (Exception exception) {
      Log.e("GridLayoutManager", "recyclerView onLayoutChildren crash");
      return;
    } 
  }
  
  public void scrollToPosition(int paramInt) {
    try {
      super.scrollToPosition(paramInt);
      return;
    } catch (Exception exception) {
      Log.e("GridLayoutManager", "recyclerView scrollToPosition crash");
      return;
    } 
  }
  
  public boolean supportsPredictiveItemAnimations() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\view\BluedGridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */