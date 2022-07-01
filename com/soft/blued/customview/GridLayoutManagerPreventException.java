package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GridLayoutManagerPreventException extends GridLayoutManager {
  public GridLayoutManagerPreventException(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    try {
      super.onLayoutChildren(paramRecycler, paramState);
      return;
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      indexOutOfBoundsException.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\GridLayoutManagerPreventException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */