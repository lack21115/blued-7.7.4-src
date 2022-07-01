package com.soft.blued.ui.search;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.ui.search.adapter.SearchAllAdapter;
import com.soft.blued.ui.search.model.SearchSessionModel;
import com.soft.blued.ui.search.presenter.SearchAllPresenter;
import java.util.List;

public class SearchMessageFragment extends MvpFragment<SearchAllPresenter> {
  private String d;
  
  private SearchAllAdapter e;
  
  @BindView(2131299071)
  LinearLayout llSearchEmpty;
  
  @BindView(2131300277)
  CommonTopTitleNoTrans titleView;
  
  @BindView(2131301569)
  RecyclerView userList;
  
  private void E() {
    this.userList.setHasFixedSize(true);
    this.userList.setNestedScrollingEnabled(false);
    this.userList.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
    this.e = new SearchAllAdapter((BaseFragment)this);
    this.userList.setAdapter((RecyclerView.Adapter)this.e);
    this.e.a((LoadMoreView)new BluedAdapterLoadMoreView());
    this.e.c(false);
  }
  
  public static void a(Context paramContext, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("word", paramString);
    TerminalActivity.d(paramContext, SearchMessageFragment.class, bundle);
  }
  
  private void n() {
    this.titleView.setCenterText(getResources().getString(2131755807));
    this.titleView.a();
    this.titleView.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = getArguments().getString("word");
    E();
    n();
  }
  
  public void a(List<SearchSessionModel> paramList) {
    this.llSearchEmpty.setVisibility(8);
    this.userList.setVisibility(0);
    this.e.b(paramList, this.d);
  }
  
  public void k() {
    l();
    this.llSearchEmpty.setVisibility(0);
    this.userList.setVisibility(8);
  }
  
  public void l() {
    this.e.l();
    ((SearchAllPresenter)s()).m();
  }
  
  public void m() {
    this.e.l();
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    ((SearchAllPresenter)s()).a(this.d, 0, -1, true);
  }
  
  public void onDestroy() {
    super.onDestroy();
    ((SearchAllPresenter)s()).m();
  }
  
  public int p() {
    return 2131493306;
  }
  
  public String q() {
    return "SearchMessageFragment";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\search\SearchMessageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */