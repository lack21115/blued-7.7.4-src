package com.soft.blued.ui.circle.fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
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

public class CircleMyRespondFragment extends PreloadFragment implements View.OnClickListener {
  public Context o;
  
  public PullToRefreshRecyclerView p;
  
  public RecyclerView q;
  
  public MyCircleTalkAdapter r;
  
  BluedUIHttpResponse s = new BluedUIHttpResponse<BluedEntity<MyCircleTalkModel, BluedEntityBaseExtra>>(this, (IRequestHost)w_()) {
      boolean a = false;
      
      private void a(BluedEntity<MyCircleTalkModel, BluedEntityBaseExtra> param1BluedEntity, boolean param1Boolean) {
        if (param1BluedEntity != null && param1BluedEntity.data != null) {
          if (param1BluedEntity.hasMore()) {
            CircleMyRespondFragment.a(this.b, true);
          } else {
            CircleMyRespondFragment.a(this.b, false);
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("isHasData:");
          stringBuilder.append(CircleMyRespondFragment.a(this.b));
          Log.v("drb", stringBuilder.toString());
          if (CircleMyRespondFragment.b(this.b) == 1) {
            this.b.r.c(param1BluedEntity.data);
            return;
          } 
          this.b.r.a(param1BluedEntity.data);
          return;
        } 
        this.b.r.c(false);
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        if (CircleMyRespondFragment.b(this.b) != 1)
          CircleMyRespondFragment.c(this.b); 
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        if (this.b.r.getItemCount() == 1) {
          if (this.a) {
            CircleMyRespondFragment.d(this.b).b();
          } else {
            CircleMyRespondFragment.d(this.b).a();
          } 
        } else {
          CircleMyRespondFragment.d(this.b).c();
        } 
        this.a = false;
        this.b.p.j();
        this.b.r.l();
        if (CircleMyRespondFragment.a(this.b)) {
          this.b.r.c(true);
          return;
        } 
        this.b.r.c(false);
      }
      
      public void onUIStart() {
        super.onUIStart();
      }
      
      public void onUIUpdate(BluedEntity<MyCircleTalkModel, BluedEntityBaseExtra> param1BluedEntity) {
        a(param1BluedEntity, false);
      }
    };
  
  private NoDataAndLoadFailView t;
  
  private int u = 1;
  
  private boolean v = true;
  
  private void t() {
    this.t = new NoDataAndLoadFailView(this.o);
    this.t.c();
    this.t.setImageScale(0.7F);
    this.t.setNoDataImg(2131232633);
    this.t.setNoDataStr(2131758178);
    this.p = (PullToRefreshRecyclerView)this.e.findViewById(2131301764);
    this.p.setRefreshEnabled(true);
    this.q = (RecyclerView)this.p.getRefreshableView();
    this.r = new MyCircleTalkAdapter(this.o, (IRequestHost)w_());
    this.q.setAdapter((RecyclerView.Adapter)this.r);
    this.r.e((View)this.t);
    this.r.a((LoadMoreView)new BluedAdapterLoadMoreView());
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.o, 1);
    this.q.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.r.c(true);
    this.r.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            this.a.a(false);
          }
        });
    this.p.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            this.a.a(true);
          }
        });
    this.p.k();
  }
  
  public void a(View paramView) {
    this.o = (Context)getActivity();
    this.e = LayoutInflater.from(this.o).inflate(2131493345, (ViewGroup)paramView, true);
    t();
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.u = 1;
    } else {
      this.u++;
    } 
    if (!this.v) {
      int i = this.u;
      if (i != 1) {
        this.u = i - 1;
        return;
      } 
    } 
    CircleHttpUtils.a(this.s, this.u, "reply");
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    getActivity().finish();
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean && !this.f) {
      PullToRefreshRecyclerView pullToRefreshRecyclerView = this.p;
      if (pullToRefreshRecyclerView != null) {
        pullToRefreshRecyclerView.k();
        this.f = true;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleMyRespondFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */