package com.ethanhua.skeleton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import io.supercharge.shimmerlayout.ShimmerLayout;

public class SkeletonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private int a;
  
  private int b;
  
  private int c;
  
  private boolean d;
  
  private int e;
  
  private int f;
  
  public int getItemCount() {
    return this.a;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    if (this.d) {
      ShimmerLayout shimmerLayout = (ShimmerLayout)paramViewHolder.itemView;
      shimmerLayout.setShimmerAnimationDuration(this.e);
      shimmerLayout.setShimmerAngle(this.f);
      shimmerLayout.setShimmerColor(this.c);
      shimmerLayout.a();
    } 
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    LayoutInflater layoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    return this.d ? new ShimmerViewHolder(layoutInflater, paramViewGroup, this.b) : new RecyclerView.ViewHolder(this, layoutInflater.inflate(this.b, paramViewGroup, false)) {
      
      };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\ethanhua\skeleton\SkeletonAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */