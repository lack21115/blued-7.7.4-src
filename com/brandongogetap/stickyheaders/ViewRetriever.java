package com.brandongogetap.stickyheaders;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

interface ViewRetriever {
  RecyclerView.ViewHolder a(int paramInt);
  
  public static final class RecyclerViewRetriever implements ViewRetriever {
    private final RecyclerView a;
    
    private RecyclerView.ViewHolder b;
    
    private int c;
    
    RecyclerViewRetriever(RecyclerView param1RecyclerView) {
      this.a = param1RecyclerView;
      this.c = -1;
    }
    
    public RecyclerView.ViewHolder a(int param1Int) {
      if (this.c != this.a.getAdapter().getItemViewType(param1Int)) {
        this.c = this.a.getAdapter().getItemViewType(param1Int);
        this.b = this.a.getAdapter().createViewHolder((ViewGroup)this.a.getParent(), this.c);
      } 
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\brandongogetap\stickyheaders\ViewRetriever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */