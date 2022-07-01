package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class SearchUserFragment_ViewBinding implements Unbinder {
  private SearchUserFragment b;
  
  public SearchUserFragment_ViewBinding(SearchUserFragment paramSearchUserFragment, View paramView) {
    this.b = paramSearchUserFragment;
    paramSearchUserFragment.titleView = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300277, "field 'titleView'", CommonTopTitleNoTrans.class);
    paramSearchUserFragment.userList = (RecyclerView)Utils.a(paramView, 2131301569, "field 'userList'", RecyclerView.class);
    paramSearchUserFragment.llSearchEmpty = (LinearLayout)Utils.a(paramView, 2131299071, "field 'llSearchEmpty'", LinearLayout.class);
    paramSearchUserFragment.refreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refreshLayout'", SmartRefreshLayout.class);
  }
  
  public void unbind() {
    SearchUserFragment searchUserFragment = this.b;
    if (searchUserFragment != null) {
      this.b = null;
      searchUserFragment.titleView = null;
      searchUserFragment.userList = null;
      searchUserFragment.llSearchEmpty = null;
      searchUserFragment.refreshLayout = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\SearchUserFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */