package androidx.viewpager2.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public final class FragmentViewHolder extends RecyclerView.ViewHolder {
  private FragmentViewHolder(FrameLayout paramFrameLayout) {
    super((View)paramFrameLayout);
  }
  
  static FragmentViewHolder a(ViewGroup paramViewGroup) {
    FrameLayout frameLayout = new FrameLayout(paramViewGroup.getContext());
    frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    frameLayout.setId(ViewCompat.generateViewId());
    frameLayout.setSaveEnabled(false);
    return new FragmentViewHolder(frameLayout);
  }
  
  FrameLayout w() {
    return (FrameLayout)this.itemView;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\viewpager2\adapter\FragmentViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */