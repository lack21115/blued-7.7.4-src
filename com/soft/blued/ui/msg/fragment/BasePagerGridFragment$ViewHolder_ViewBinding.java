package com.soft.blued.ui.msg.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class BasePagerGridFragment$ViewHolder_ViewBinding implements Unbinder {
  private BasePagerGridFragment.ViewHolder b;
  
  public BasePagerGridFragment$ViewHolder_ViewBinding(BasePagerGridFragment.ViewHolder paramViewHolder, View paramView) {
    this.b = paramViewHolder;
    paramViewHolder.recyclerView = (RecyclerView)Utils.a(paramView, 2131299601, "field 'recyclerView'", RecyclerView.class);
  }
  
  public void unbind() {
    BasePagerGridFragment.ViewHolder viewHolder = this.b;
    if (viewHolder != null) {
      this.b = null;
      viewHolder.recyclerView = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\fragment\BasePagerGridFragment$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */