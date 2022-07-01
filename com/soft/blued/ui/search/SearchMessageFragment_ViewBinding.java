package com.soft.blued.ui.search;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class SearchMessageFragment_ViewBinding implements Unbinder {
  private SearchMessageFragment b;
  
  public SearchMessageFragment_ViewBinding(SearchMessageFragment paramSearchMessageFragment, View paramView) {
    this.b = paramSearchMessageFragment;
    paramSearchMessageFragment.titleView = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300277, "field 'titleView'", CommonTopTitleNoTrans.class);
    paramSearchMessageFragment.userList = (RecyclerView)Utils.a(paramView, 2131301569, "field 'userList'", RecyclerView.class);
    paramSearchMessageFragment.llSearchEmpty = (LinearLayout)Utils.a(paramView, 2131299071, "field 'llSearchEmpty'", LinearLayout.class);
  }
  
  public void unbind() {
    SearchMessageFragment searchMessageFragment = this.b;
    if (searchMessageFragment != null) {
      this.b = null;
      searchMessageFragment.titleView = null;
      searchMessageFragment.userList = null;
      searchMessageFragment.llSearchEmpty = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\search\SearchMessageFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */