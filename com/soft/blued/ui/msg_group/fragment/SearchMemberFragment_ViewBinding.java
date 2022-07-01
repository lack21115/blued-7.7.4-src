package com.soft.blued.ui.msg_group.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SearchView;

public class SearchMemberFragment_ViewBinding implements Unbinder {
  private SearchMemberFragment b;
  
  public SearchMemberFragment_ViewBinding(SearchMemberFragment paramSearchMemberFragment, View paramView) {
    this.b = paramSearchMemberFragment;
    paramSearchMemberFragment.refresh_layout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refresh_layout'", SmartRefreshLayout.class);
    paramSearchMemberFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramSearchMemberFragment.search_view = (SearchView)Utils.a(paramView, 2131299874, "field 'search_view'", SearchView.class);
    paramSearchMemberFragment.search_list = (RecyclerView)Utils.a(paramView, 2131299869, "field 'search_list'", RecyclerView.class);
    paramSearchMemberFragment.user_list = (RecyclerView)Utils.a(paramView, 2131301578, "field 'user_list'", RecyclerView.class);
    paramSearchMemberFragment.noDataView = (NoDataAndLoadFailView)Utils.a(paramView, 2131299385, "field 'noDataView'", NoDataAndLoadFailView.class);
  }
  
  public void unbind() {
    SearchMemberFragment searchMemberFragment = this.b;
    if (searchMemberFragment != null) {
      this.b = null;
      searchMemberFragment.refresh_layout = null;
      searchMemberFragment.title = null;
      searchMemberFragment.search_view = null;
      searchMemberFragment.search_list = null;
      searchMemberFragment.user_list = null;
      searchMemberFragment.noDataView = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\SearchMemberFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */