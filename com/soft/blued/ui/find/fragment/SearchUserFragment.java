package com.soft.blued.ui.find.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.find.adapter.SearchNewAdapter;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.search.presenter.SearchAllPresenter;
import java.util.List;

public class SearchUserFragment extends MvpFragment<SearchAllPresenter> {
  private int d = 1;
  
  private int e = 10;
  
  private boolean f = true;
  
  private String g;
  
  private SearchNewAdapter h;
  
  @BindView(2131299071)
  LinearLayout llSearchEmpty;
  
  @BindView(2131299616)
  SmartRefreshLayout refreshLayout;
  
  @BindView(2131300277)
  CommonTopTitleNoTrans titleView;
  
  @BindView(2131301569)
  RecyclerView userList;
  
  public static void a(Context paramContext, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("word", paramString);
    TerminalActivity.d(paramContext, SearchUserFragment.class, bundle);
  }
  
  private void l() {
    this.titleView.setCenterText(getResources().getString(2131757935));
    this.titleView.a();
    this.titleView.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
  }
  
  private void m() {
    this.userList.setHasFixedSize(true);
    this.userList.setNestedScrollingEnabled(false);
    this.userList.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
    this.h = new SearchNewAdapter(null, (Activity)getActivity(), (IRequestHost)w_(), "", this.userList);
    this.userList.setAdapter((RecyclerView.Adapter)this.h);
    this.refreshLayout.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            SearchAllPresenter searchAllPresenter = (SearchAllPresenter)this.a.s();
            String str = SearchUserFragment.a(this.a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(SearchUserFragment.b(this.a));
            stringBuilder.append("");
            searchAllPresenter.a(str, stringBuilder.toString());
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            SearchUserFragment.a(this.a, 1);
            SearchAllPresenter searchAllPresenter = (SearchAllPresenter)this.a.s();
            String str = SearchUserFragment.a(this.a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(SearchUserFragment.b(this.a));
            stringBuilder.append("");
            searchAllPresenter.a(str, stringBuilder.toString());
          }
        });
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.g = getArguments().getString("word");
    m();
    l();
  }
  
  public void a(String paramString, List paramList) {
    super.a(paramString, paramList);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    this.refreshLayout.h();
    this.refreshLayout.g();
    if (paramBoolean) {
      this.d++;
      this.refreshLayout.b(true);
      return;
    } 
    this.refreshLayout.b(false);
  }
  
  public void a(List<UserFindResult> paramList) {
    this.llSearchEmpty.setVisibility(8);
    this.userList.setVisibility(0);
    if (this.d == 1) {
      this.h.a(paramList, this.g);
      return;
    } 
    this.h.b(paramList, this.g);
  }
  
  public void b(String paramString) {
    super.b(paramString);
  }
  
  public void k() {
    if (this.h.n().size() == 0) {
      this.llSearchEmpty.setVisibility(0);
      this.userList.setVisibility(8);
    } 
  }
  
  public int p() {
    return 2131493306;
  }
  
  public String q() {
    return "SearchUserFragment";
  }
  
  public void u() {
    this.refreshLayout.i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\SearchUserFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */