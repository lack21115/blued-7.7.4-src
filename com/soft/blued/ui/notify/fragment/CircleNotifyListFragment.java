package com.soft.blued.ui.notify.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
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
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.ui.notify.adapter.CircleNotifyAdapter;
import com.soft.blued.ui.notify.model.CircleNotify;
import com.soft.blued.ui.notify.presenter.CircleNotifyListPresenter;
import java.util.List;

public class CircleNotifyListFragment extends MvpFragment<CircleNotifyListPresenter> {
  private CircleNotifyAdapter d;
  
  private NoDataAndLoadFailView e;
  
  @BindView(2131299605)
  RecyclerView recyclerView;
  
  @BindView(2131299616)
  SmartRefreshLayout refreshLayout;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, CircleNotifyListFragment.class, null);
  }
  
  private void b(boolean paramBoolean) {
    this.refreshLayout.g();
    if (paramBoolean) {
      this.d.l();
    } else {
      this.d.m();
    } 
    if (this.d.n().size() <= 0) {
      if (paramBoolean) {
        this.e.a();
        return;
      } 
      this.e.b();
    } 
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
    this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
    this.d = new CircleNotifyAdapter(getContext(), (IRequestHost)w_());
    this.recyclerView.setAdapter((RecyclerView.Adapter)this.d);
    this.e = new NoDataAndLoadFailView(getContext());
    this.e.setNoDataImg(2131232640);
    this.e.setNoDataStr(2131758231);
    this.d.e((View)this.e);
    this.refreshLayout.b(true);
    this.refreshLayout.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((CircleNotifyListPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((CircleNotifyListPresenter)this.a.s()).e();
          }
        });
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    if (paramString == null)
      return; 
    byte b = -1;
    int i = paramString.hashCode();
    if (i != -1290256561) {
      if (i == 623698297 && paramString.equals("_load_type_loadmore_"))
        b = 1; 
    } else if (paramString.equals("_load_type_refresh_")) {
      b = 0;
    } 
    if (b != 0 && b != 1)
      return; 
    b(paramBoolean);
  }
  
  protected void a(List<CircleNotify> paramList) {
    this.d.c(paramList);
  }
  
  public void aL_() {
    super.aL_();
    this.e = null;
  }
  
  public int p() {
    return 2131493099;
  }
  
  public void u() {
    this.refreshLayout.i();
  }
  
  public void x() {
    super.x();
    this.refreshLayout.b(true);
  }
  
  public void y() {
    super.y();
    this.refreshLayout.b(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\fragment\CircleNotifyListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */