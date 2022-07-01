package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.ui.feed.adapter.MyTopicAdapter;
import com.soft.blued.ui.feed.model.BluedTopic;
import com.soft.blued.ui.feed.model.BluedTopicExtra;
import java.io.Serializable;

public class MyTopicSinglePageFragment extends PreloadFragment {
  private Context o;
  
  private View p;
  
  private PullToRefreshRecyclerView q;
  
  private RecyclerView r;
  
  private MyTopicAdapter s;
  
  private NoDataAndLoadFailView t;
  
  private int u = 1;
  
  private int v = 20;
  
  private boolean w = true;
  
  private MyTopicAdapter.MY_TOPIC_PAGE x = MyTopicAdapter.MY_TOPIC_PAGE.a;
  
  private BluedUIHttpResponse y = new BluedUIHttpResponse<BluedEntity<BluedTopic, BluedTopicExtra>>(this, (IRequestHost)w_()) {
      boolean a;
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        MyTopicSinglePageFragment.e(this.b).j();
        MyTopicSinglePageFragment.c(this.b).l();
        if (this.a) {
          MyTopicSinglePageFragment.f(this.b).b();
          if (MyTopicSinglePageFragment.c(this.b).n().size() > 0) {
            MyTopicSinglePageFragment.c(this.b).m();
            return;
          } 
        } else {
          if (MyTopicSinglePageFragment.c(this.b).n().size() == 0) {
            MyTopicSinglePageFragment.f(this.b).a();
          } else {
            MyTopicSinglePageFragment.f(this.b).c();
          } 
          if (MyTopicSinglePageFragment.g(this.b)) {
            MyTopicSinglePageFragment.c(this.b).c(true);
            return;
          } 
          MyTopicSinglePageFragment.c(this.b).k();
          MyTopicSinglePageFragment.c(this.b).c(false);
        } 
      }
      
      public void onUIUpdate(BluedEntity<BluedTopic, BluedTopicExtra> param1BluedEntity) {
        if (param1BluedEntity != null) {
          if (param1BluedEntity.hasData()) {
            if (param1BluedEntity.hasMore()) {
              MyTopicSinglePageFragment.b(this.b, true);
            } else {
              MyTopicSinglePageFragment.b(this.b, false);
            } 
            if (MyTopicSinglePageFragment.b(this.b) == 1) {
              MyTopicSinglePageFragment.c(this.b).c(param1BluedEntity.data);
              return;
            } 
            MyTopicSinglePageFragment.c(this.b).a(param1BluedEntity.data);
            return;
          } 
          if (MyTopicSinglePageFragment.b(this.b) == 1)
            MyTopicSinglePageFragment.c(this.b).c(param1BluedEntity.data); 
          if (MyTopicSinglePageFragment.b(this.b) != 1) {
            MyTopicSinglePageFragment.d(this.b);
            MyTopicSinglePageFragment.b(this.b, false);
          } 
        } 
      }
    };
  
  public static MyTopicSinglePageFragment a(MyTopicAdapter.MY_TOPIC_PAGE paramMY_TOPIC_PAGE) {
    MyTopicSinglePageFragment myTopicSinglePageFragment = new MyTopicSinglePageFragment();
    Bundle bundle = new Bundle();
    bundle.putSerializable("PAGE_KEY", (Serializable)paramMY_TOPIC_PAGE);
    myTopicSinglePageFragment.setArguments(bundle);
    return myTopicSinglePageFragment;
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.u = 1; 
    FeedHttpUtils.a(this.y, this.x, this.u, this.v, (IRequestHost)w_());
  }
  
  private void t() {
    this.q = (PullToRefreshRecyclerView)this.p.findViewById(2131298146);
    this.q.setBackgroundColor(BluedSkinUtils.a(this.o, 2131100728));
    this.q.setRefreshEnabled(true);
    this.r = (RecyclerView)this.q.getRefreshableView();
    this.r.setClipToPadding(false);
    this.r.setScrollBarStyle(33554432);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.o);
    this.r.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.s = new MyTopicAdapter(this.o, this.x, (IRequestHost)w_());
    this.r.setAdapter((RecyclerView.Adapter)this.s);
    this.t = new NoDataAndLoadFailView(this.o);
    this.t.setNoDataImg(2131232637);
    this.t.setNoDataStr(2131758966);
    this.t.setTopSpace(DensityUtils.a(this.o, 40.0F));
    this.t.setImageScale(0.7F);
    this.t.c();
    this.s.e((View)this.t);
    this.q.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            MyTopicSinglePageFragment.a(this.a, 1);
            MyTopicSinglePageFragment.a(this.a, true);
          }
        });
    this.s.a((LoadMoreView)new BluedAdapterLoadMoreView());
    this.s.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            MyTopicSinglePageFragment.a(this.a);
            MyTopicSinglePageFragment.a(this.a, false);
          }
        }this.r);
    this.q.k();
  }
  
  public String X_() {
    return (this.x == MyTopicAdapter.MY_TOPIC_PAGE.b) ? "A48" : "A47";
  }
  
  public void a(View paramView) {
    this.o = (Context)getActivity();
    this.p = LayoutInflater.from(this.o).inflate(2131493224, (ViewGroup)paramView, true);
    ((KeyboardListenLinearLayout)this.p.findViewById(2131297984)).setBackgroundColor(BluedSkinUtils.a(getContext(), 2131100728));
    t();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.x = (MyTopicAdapter.MY_TOPIC_PAGE)getArguments().getSerializable("PAGE_KEY");
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\MyTopicSinglePageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */