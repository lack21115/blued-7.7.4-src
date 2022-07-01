package com.soft.blued.ui.feed.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SearchView;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.adapter.SuperTopicAdapter;
import com.soft.blued.ui.feed.model.BluedTopic;
import com.soft.blued.ui.feed.model.BluedTopicExtra;

public class SuperTopicSearchFragment extends KeyBoardFragment {
  public SearchEditText e;
  
  private Context f;
  
  private LayoutInflater o;
  
  private KeyboardListenLinearLayout p;
  
  private PullToRefreshRecyclerView q;
  
  private RecyclerView r;
  
  private SuperTopicAdapter s;
  
  private NoDataAndLoadFailView t;
  
  private int u = 1;
  
  private int v = 20;
  
  private boolean w = true;
  
  private SearchView x;
  
  private BluedUIHttpResponse y = new BluedUIHttpResponse<BluedEntity<BluedTopic, BluedTopicExtra>>(this, (IRequestHost)w_()) {
      boolean a;
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        SuperTopicSearchFragment.g(this.b).j();
        if (this.a) {
          SuperTopicSearchFragment.b(this.b).b();
          if (SuperTopicSearchFragment.a(this.b).n().size() > 0) {
            SuperTopicSearchFragment.a(this.b).m();
            return;
          } 
          SuperTopicSearchFragment.a(this.b).c(false);
          return;
        } 
        if (SuperTopicSearchFragment.h(this.b)) {
          SuperTopicSearchFragment.a(this.b).l();
          return;
        } 
        SuperTopicSearchFragment.a(this.b).k();
      }
      
      public void onUIUpdate(BluedEntity<BluedTopic, BluedTopicExtra> param1BluedEntity) {
        if (param1BluedEntity != null) {
          BluedTopicExtra bluedTopicExtra = (BluedTopicExtra)param1BluedEntity.extra;
          if (bluedTopicExtra != null && bluedTopicExtra.topics_exist == 0)
            SuperTopicSearchFragment.b(this.b).a(); 
          if (param1BluedEntity.hasData()) {
            SuperTopicSearchFragment.a(this.b, param1BluedEntity.hasMore());
            if (SuperTopicSearchFragment.e(this.b) == 1 && bluedTopicExtra != null && !TextUtils.isEmpty(bluedTopicExtra.q)) {
              SuperTopicSearchFragment.a(this.b).a(bluedTopicExtra.q);
              SuperTopicSearchFragment.a(this.b).c(param1BluedEntity.data);
              return;
            } 
            SuperTopicSearchFragment.a(this.b).a(param1BluedEntity.data);
            return;
          } 
          if (SuperTopicSearchFragment.e(this.b) == 1)
            SuperTopicSearchFragment.a(this.b).c(param1BluedEntity.data); 
          if (SuperTopicSearchFragment.e(this.b) != 1) {
            SuperTopicSearchFragment.f(this.b);
            SuperTopicSearchFragment.a(this.b, false);
          } 
        } 
      }
    };
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, SuperTopicSearchFragment.class, new Bundle());
  }
  
  public static void a(EditText paramEditText) {
    paramEditText.setFilters(new InputFilter[] { new InputFilter() {
            public CharSequence filter(CharSequence param1CharSequence, int param1Int1, int param1Int2, Spanned param1Spanned, int param1Int3, int param1Int4) {
              return param1CharSequence.equals(" ") ? "" : null;
            }
          } });
  }
  
  private void a(boolean paramBoolean, String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      this.q.j();
      this.s.c(false);
      return;
    } 
    if (paramBoolean)
      this.u = 1; 
    if (this.u == 1)
      this.w = true; 
    if (!this.w) {
      int i = this.u;
      if (i != 1) {
        this.u = i - 1;
        AppMethods.d(2131756083);
        this.q.j();
        this.s.k();
        return;
      } 
    } 
    EventTrackFeed.e(FeedProtos.Event.SUPER_TOPIC_SEARCH_KEYWORD, paramString);
    FeedHttpUtils.a(this.y, this.u, this.v, paramString, (IRequestHost)w_());
  }
  
  private void t() {
    this.x = (SearchView)this.p.findViewById(2131299874);
    this.e = this.x.getEditView();
    a((EditText)this.e);
    this.x.setOnSearchInfoListener(new SearchView.OnSearchInfoListener(this) {
          public void a() {
            KeyboardUtils.a((Activity)this.a.getActivity());
            this.a.getActivity().finish();
          }
          
          public void a(String param1String) {
            SuperTopicSearchFragment.a(this.a).c(null);
            SuperTopicSearchFragment.b(this.a).c();
            if (!TextUtils.isEmpty(param1String)) {
              SuperTopicSearchFragment.a(this.a, 1);
              SuperTopicSearchFragment.a(this.a).c(true);
              SuperTopicSearchFragment.a(this.a, true, param1String);
            } 
          }
          
          public void b() {}
        });
    KeyboardUtils.a((Context)getActivity(), (View)this.e);
  }
  
  private void u() {
    this.q = (PullToRefreshRecyclerView)this.p.findViewById(2131298146);
    this.q.setRefreshEnabled(true);
    this.r = (RecyclerView)this.q.getRefreshableView();
    this.r.setClipToPadding(false);
    this.r.setScrollBarStyle(33554432);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f);
    this.r.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.s = new SuperTopicAdapter(this.f, (IRequestHost)w_());
    this.r.setAdapter((RecyclerView.Adapter)this.s);
    this.t = new NoDataAndLoadFailView(this.f);
    this.t.setNoDataImg(2131232637);
    this.t.setNoDataStr(2131758966);
    this.t.setFailBtnVisibility(0);
    this.t.setBtnStr(2131756136);
    this.t.setTopSpace(DensityUtils.a(this.f, 40.0F));
    this.t.setImageScale(0.7F);
    this.t.setNoDataBtnListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_SEARCH_CREATE_BTN_CLICK);
            CreateSuperTopicFragment.a(SuperTopicSearchFragment.c(this.a));
          }
        });
    this.t.c();
    this.s.e((View)this.t);
    this.s.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            if (param1BaseQuickAdapter.e(param1Int) != null && param1BaseQuickAdapter.e(param1Int) instanceof BluedTopic) {
              BluedTopic bluedTopic = (BluedTopic)param1BaseQuickAdapter.e(param1Int);
              SuperTopicDetailFragment.a(SuperTopicSearchFragment.c(this.a), bluedTopic.super_did);
            } 
          }
        });
    this.q.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            SuperTopicSearchFragment.a(this.a, 1);
            SuperTopicSearchFragment superTopicSearchFragment = this.a;
            SuperTopicSearchFragment.a(superTopicSearchFragment, true, superTopicSearchFragment.e.getText().toString());
          }
        });
    this.s.a((LoadMoreView)new BluedAdapterLoadMoreView());
    this.s.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            SuperTopicSearchFragment.d(this.a);
            SuperTopicSearchFragment superTopicSearchFragment = this.a;
            SuperTopicSearchFragment.a(superTopicSearchFragment, false, superTopicSearchFragment.e.getText().toString());
          }
        }this.r);
  }
  
  public void e_(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      this.x.a(false);
      return;
    } 
    SearchView searchView = this.x;
    if (searchView != null)
      searchView.a(true); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    getActivity().getWindow().setSoftInputMode(16);
    this.f = (Context)getActivity();
    KeyboardListenLinearLayout keyboardListenLinearLayout = this.p;
    if (keyboardListenLinearLayout == null) {
      this.p = (KeyboardListenLinearLayout)paramLayoutInflater.inflate(2131493156, paramViewGroup, false);
      a(this.p);
      this.o = LayoutInflater.from((Context)getActivity());
      t();
      u();
    } else if (keyboardListenLinearLayout.getParent() != null) {
      ((ViewGroup)this.p.getParent()).removeView((View)this.p);
    } 
    return (View)this.p;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\SuperTopicSearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */