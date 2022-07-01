package com.soft.blued.utils;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

public class RecyclerViewAnimUtil {
  public static void a(RecyclerView paramRecyclerView) {
    if (paramRecyclerView == null)
      return; 
    paramRecyclerView.getItemAnimator().setAddDuration(0L);
    paramRecyclerView.getItemAnimator().setChangeDuration(0L);
    paramRecyclerView.getItemAnimator().setMoveDuration(0L);
    paramRecyclerView.getItemAnimator().setRemoveDuration(0L);
    ((SimpleItemAnimator)paramRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\RecyclerViewAnimUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */