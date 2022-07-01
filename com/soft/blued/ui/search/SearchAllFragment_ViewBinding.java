package com.soft.blued.ui.search;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SearchView;

public class SearchAllFragment_ViewBinding implements Unbinder {
  private SearchAllFragment b;
  
  public SearchAllFragment_ViewBinding(SearchAllFragment paramSearchAllFragment, View paramView) {
    this.b = paramSearchAllFragment;
    paramSearchAllFragment.msgSearchView = (SearchView)Utils.a(paramView, 2131299293, "field 'msgSearchView'", SearchView.class);
    paramSearchAllFragment.tvSearchPerson = (TextView)Utils.a(paramView, 2131301305, "field 'tvSearchPerson'", TextView.class);
    paramSearchAllFragment.tvNoResults = (TextView)Utils.a(paramView, 2131301114, "field 'tvNoResults'", TextView.class);
    paramSearchAllFragment.tvMorePerson = (TextView)Utils.a(paramView, 2131301054, "field 'tvMorePerson'", TextView.class);
    paramSearchAllFragment.tvSearchMsg = (TextView)Utils.a(paramView, 2131301304, "field 'tvSearchMsg'", TextView.class);
    paramSearchAllFragment.tvMoreMsg = (TextView)Utils.a(paramView, 2131301053, "field 'tvMoreMsg'", TextView.class);
    paramSearchAllFragment.listPerson = (RecyclerView)Utils.a(paramView, 2131298142, "field 'listPerson'", RecyclerView.class);
    paramSearchAllFragment.listMessage = (RecyclerView)Utils.a(paramView, 2131298141, "field 'listMessage'", RecyclerView.class);
    paramSearchAllFragment.noDataView = (NoDataAndLoadFailView)Utils.a(paramView, 2131299389, "field 'noDataView'", NoDataAndLoadFailView.class);
    paramSearchAllFragment.personLoading = (FrameLayout)Utils.a(paramView, 2131299459, "field 'personLoading'", FrameLayout.class);
    paramSearchAllFragment.llUserView = (RelativeLayout)Utils.a(paramView, 2131299125, "field 'llUserView'", RelativeLayout.class);
    paramSearchAllFragment.llLine = Utils.a(paramView, 2131298914, "field 'llLine'");
    paramSearchAllFragment.llMsgView = (RelativeLayout)Utils.a(paramView, 2131298963, "field 'llMsgView'", RelativeLayout.class);
    paramSearchAllFragment.llContentView = (NestedScrollView)Utils.a(paramView, 2131298761, "field 'llContentView'", NestedScrollView.class);
  }
  
  public void unbind() {
    SearchAllFragment searchAllFragment = this.b;
    if (searchAllFragment != null) {
      this.b = null;
      searchAllFragment.msgSearchView = null;
      searchAllFragment.tvSearchPerson = null;
      searchAllFragment.tvNoResults = null;
      searchAllFragment.tvMorePerson = null;
      searchAllFragment.tvSearchMsg = null;
      searchAllFragment.tvMoreMsg = null;
      searchAllFragment.listPerson = null;
      searchAllFragment.listMessage = null;
      searchAllFragment.noDataView = null;
      searchAllFragment.personLoading = null;
      searchAllFragment.llUserView = null;
      searchAllFragment.llLine = null;
      searchAllFragment.llMsgView = null;
      searchAllFragment.llContentView = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\search\SearchAllFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */