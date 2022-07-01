package com.soft.blued.ui.search;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class SearchLikeChatFragment_ViewBinding implements Unbinder {
  private SearchLikeChatFragment b;
  
  public SearchLikeChatFragment_ViewBinding(SearchLikeChatFragment paramSearchLikeChatFragment, View paramView) {
    this.b = paramSearchLikeChatFragment;
    paramSearchLikeChatFragment.titleView = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300277, "field 'titleView'", CommonTopTitleNoTrans.class);
    paramSearchLikeChatFragment.userList = (RecyclerView)Utils.a(paramView, 2131301569, "field 'userList'", RecyclerView.class);
    paramSearchLikeChatFragment.llSearchEmpty = (LinearLayout)Utils.a(paramView, 2131299071, "field 'llSearchEmpty'", LinearLayout.class);
  }
  
  public void unbind() {
    SearchLikeChatFragment searchLikeChatFragment = this.b;
    if (searchLikeChatFragment != null) {
      this.b = null;
      searchLikeChatFragment.titleView = null;
      searchLikeChatFragment.userList = null;
      searchLikeChatFragment.llSearchEmpty = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\search\SearchLikeChatFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */