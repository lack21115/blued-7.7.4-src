package com.ethanhua.skeleton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public class ShimmerViewHolder extends RecyclerView.ViewHolder {
  public ShimmerViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, int paramInt) {
    super(paramLayoutInflater.inflate(R.layout.layout_shimmer, paramViewGroup, false));
    paramViewGroup = (ViewGroup)this.itemView;
    View view = paramLayoutInflater.inflate(paramInt, paramViewGroup, false);
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    if (layoutParams != null)
      paramViewGroup.setLayoutParams(layoutParams); 
    paramViewGroup.addView(view);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\ethanhua\skeleton\ShimmerViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */