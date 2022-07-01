package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.ui.find.observer.BlackListDataObserver;
import com.soft.blued.ui.setting.Contract.IBlackListContract;
import com.soft.blued.ui.setting.Presenter.BlackListPresenter;
import com.soft.blued.ui.setting.adapter.BlackAdapter;
import com.soft.blued.ui.setting.model.BluedBlackList;
import java.util.List;

public class BlacklistFragment extends BaseFragment implements View.OnClickListener, BlackListDataObserver.IBlackListDataObserver, IBlackListContract.IView {
  private Context d;
  
  private View e;
  
  private SmartRefreshLayout f;
  
  private RecyclerView g;
  
  private BlackAdapter h;
  
  private int i = 10;
  
  private LinearLayout j;
  
  private NoDataAndLoadFailView k;
  
  private IBlackListContract.IPresenter l;
  
  private CommonTopTitleNoTrans m;
  
  private void k() {
    this.m = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    this.m.setCenterText(this.d.getResources().getString(2131758153));
    this.m.setCenterClickListener(this);
    this.m.setLeftClickListener(this);
    this.m.a();
  }
  
  private void l() {
    this.k = (NoDataAndLoadFailView)this.e.findViewById(2131298986);
    this.j = (LinearLayout)this.e.findViewById(2131298878);
    this.j.setOnClickListener(this);
    this.l.d();
    this.f = (SmartRefreshLayout)this.e.findViewById(2131299616);
    this.g = (RecyclerView)this.e.findViewById(2131299605);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.d);
    this.g.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.h = new BlackAdapter(this.d, (IRequestHost)w_());
    this.g.setAdapter((RecyclerView.Adapter)this.h);
    this.f.a(new OnRefreshListener(this) {
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            BlacklistFragment.a(this.a).b();
          }
        });
    this.f.a(new OnLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            BlacklistFragment.a(this.a).c();
          }
        });
    this.f.i();
  }
  
  public void a() {
    this.f.b(true);
  }
  
  public void a(List<BluedBlackList> paramList) {
    this.h.b(paramList);
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.j.setVisibility(0);
      return;
    } 
    this.j.setVisibility(8);
  }
  
  public void b() {
    this.f.b(false);
  }
  
  public void b(List<BluedBlackList> paramList) {
    this.h.a(paramList);
  }
  
  public void ba_() {
    this.k.b();
  }
  
  public void c() {
    this.f.g();
    this.f.h();
  }
  
  public void d() {
    this.k.a();
  }
  
  public void e() {
    this.k.c();
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131298878)
        return; 
      PersonalVerifyFragment.a((Context)getActivity());
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    this.l = (IBlackListContract.IPresenter)new BlackListPresenter(this.d, (IRequestHost)w_(), this, this.i);
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493081, paramViewGroup, false);
      l();
      k();
      BlackListDataObserver.a().a(this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    BlackListDataObserver.a().b(this);
    super.onDestroy();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\BlacklistFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */