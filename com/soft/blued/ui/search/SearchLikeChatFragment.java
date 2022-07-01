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
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.ui.search.adapter.SearchAllAdapter;
import com.soft.blued.ui.search.model.SearchSessionModel;
import com.soft.blued.ui.search.presenter.SearchLikeChatPresenter;
import java.util.List;

public class SearchLikeChatFragment extends MvpFragment<SearchLikeChatPresenter> {
  private SearchAllAdapter d;
  
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
    this.d = new SearchAllAdapter((BaseFragment)this);
    this.userList.setAdapter((RecyclerView.Adapter)this.d);
    this.d.a((LoadMoreView)new BluedAdapterLoadMoreView());
    this.d.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            ((SearchLikeChatPresenter)this.a.s()).n();
          }
        },  this.userList);
    this.d.c(false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong, short paramShort, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    Bundle bundle = new Bundle();
    bundle.putString("word", paramString1);
    bundle.putLong("passby_session_id", paramLong);
    bundle.putShort("passby_session_type", paramShort);
    bundle.putString("passby_nick_name", paramString2);
    bundle.putString("passby_avatar", paramString3);
    bundle.putInt("passby_vbadge", paramInt1);
    bundle.putInt("passby_vip_grade", paramInt2);
    bundle.putInt("passby_is_vip_annual", paramInt3);
    bundle.putInt("passby_is_hide_vip_look", paramInt5);
    bundle.putInt("passby_vip_exp_lvl", paramInt4);
    TerminalActivity.d(paramContext, SearchLikeChatFragment.class, bundle);
  }
  
  private void n() {
    this.titleView.setCenterText(String.format(getResources().getString(2131758660), new Object[] { ((SearchLikeChatPresenter)s()).p() }));
    this.titleView.a();
    this.titleView.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    n();
    E();
  }
  
  public void a(List<SearchSessionModel> paramList) {
    this.llSearchEmpty.setVisibility(8);
    this.userList.setVisibility(0);
    this.d.b(paramList, ((SearchLikeChatPresenter)s()).q());
  }
  
  public void k() {
    l();
    this.llSearchEmpty.setVisibility(0);
    this.userList.setVisibility(8);
  }
  
  public void l() {
    this.d.l();
    this.d.c(false);
  }
  
  public void m() {
    this.d.l();
    this.d.c(true);
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    ((SearchLikeChatPresenter)s()).m();
  }
  
  public void onDestroy() {
    super.onDestroy();
    ((SearchLikeChatPresenter)s()).o();
  }
  
  public int p() {
    return 2131493306;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\search\SearchLikeChatFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */