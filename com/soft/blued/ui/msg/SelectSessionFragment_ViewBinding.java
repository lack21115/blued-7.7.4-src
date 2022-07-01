package com.soft.blued.ui.msg;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class SelectSessionFragment_ViewBinding implements Unbinder {
  private SelectSessionFragment b;
  
  public SelectSessionFragment_ViewBinding(SelectSessionFragment paramSelectSessionFragment, View paramView) {
    this.b = paramSelectSessionFragment;
    paramSelectSessionFragment.top_title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300300, "field 'top_title'", CommonTopTitleNoTrans.class);
    paramSelectSessionFragment.recyclerView = (RecyclerView)Utils.a(paramView, 2131299601, "field 'recyclerView'", RecyclerView.class);
    paramSelectSessionFragment.tv_all = (TextView)Utils.a(paramView, 2131300509, "field 'tv_all'", TextView.class);
  }
  
  public void unbind() {
    SelectSessionFragment selectSessionFragment = this.b;
    if (selectSessionFragment != null) {
      this.b = null;
      selectSessionFragment.top_title = null;
      selectSessionFragment.recyclerView = null;
      selectSessionFragment.tv_all = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\SelectSessionFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */