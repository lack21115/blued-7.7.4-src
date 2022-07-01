package com.soft.blued.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.ui.circle.adapter.MyCircleTalkAdapter;
import com.soft.blued.ui.circle.model.MyCircleTalkModel;

public class CircleMyPublishFragment extends BaseFragment implements View.OnClickListener {
  public Context d;
  
  public View e;
  
  public PullToRefreshRecyclerView f;
  
  public RecyclerView g;
  
  public MyCircleTalkAdapter h;
  
  BluedUIHttpResponse i = new BluedUIHttpResponse<BluedEntity<MyCircleTalkModel, BluedEntityBaseExtra>>(this, (IRequestHost)w_()) {
      boolean a = false;
      
      private void a(BluedEntity<MyCircleTalkModel, BluedEntityBaseExtra> param1BluedEntity, boolean param1Boolean) {
        if (param1BluedEntity != null && param1BluedEntity.data != null) {
          if (param1BluedEntity.hasMore()) {
            CircleMyPublishFragment.a(this.b, true);
          } else {
            CircleMyPublishFragment.a(this.b, false);
          } 
          if (CircleMyPublishFragment.a(this.b) == 1) {
            this.b.h.c(param1BluedEntity.data);
            return;
          } 
          this.b.h.a(param1BluedEntity.data);
        } 
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        if (CircleMyPublishFragment.a(this.b) != 1)
          CircleMyPublishFragment.b(this.b); 
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        if (this.b.h.getItemCount() == 1) {
          if (this.a) {
            CircleMyPublishFragment.c(this.b).b();
          } else {
            CircleMyPublishFragment.c(this.b).a();
          } 
        } else {
          CircleMyPublishFragment.c(this.b).c();
        } 
        this.a = false;
        this.b.f.j();
        this.b.h.l();
        if (CircleMyPublishFragment.d(this.b)) {
          this.b.h.c(true);
          return;
        } 
        this.b.h.c(false);
      }
      
      public void onUIStart() {
        super.onUIStart();
      }
      
      public void onUIUpdate(BluedEntity<MyCircleTalkModel, BluedEntityBaseExtra> param1BluedEntity) {
        a(param1BluedEntity, false);
      }
    };
  
  private NoDataAndLoadFailView j;
  
  private int k = 1;
  
  private boolean l = true;
  
  private void a() {}
  
  private void k() {
    this.j = new NoDataAndLoadFailView(this.d);
    this.j.c();
    this.j.setImageScale(0.7F);
    this.j.setNoDataImg(2131232633);
    this.j.setNoDataStr(2131758176);
    this.f = (PullToRefreshRecyclerView)this.e.findViewById(2131301764);
    this.f.setRefreshEnabled(true);
    this.g = (RecyclerView)this.f.getRefreshableView();
    this.h = new MyCircleTalkAdapter(this.d, (IRequestHost)w_());
    this.g.setAdapter((RecyclerView.Adapter)this.h);
    this.h.e((View)this.j);
    this.h.a((LoadMoreView)new BluedAdapterLoadMoreView());
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.d, 1);
    this.g.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.h.c(true);
    Log.v("drb", "setEnableLoadMore(true)");
    this.h.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            this.a.a(false);
          }
        });
    this.f.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            this.a.a(true);
          }
        });
    this.f.k();
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.k = 1;
    } else {
      this.k++;
    } 
    if (!this.l) {
      int i = this.k;
      if (i != 1) {
        this.k = i - 1;
        return;
      } 
    } 
    CircleHttpUtils.a(this.i, this.k, "mine");
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493345, paramViewGroup, false);
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleMyPublishFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */