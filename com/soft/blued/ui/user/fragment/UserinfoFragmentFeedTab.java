package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedParse;
import com.soft.blued.ui.feed.observer.IFeedDataObserver;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.observer.FeedRefreshObserver;
import com.soft.blued.ui.user.observer.UserinfoFeedScrollObserver;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import java.io.Serializable;
import java.util.ArrayList;

public class UserinfoFragmentFeedTab extends BaseFragment implements FeedRefreshObserver.IFeedRefreshObserver {
  public Context d;
  
  public View e;
  
  public PullToRefreshRecyclerView f;
  
  public RecyclerView g;
  
  public FeedListAdapterForRecyclerView h;
  
  private View i;
  
  private NoDataAndLoadFailView j;
  
  private int k = 1;
  
  private int l = 20;
  
  private boolean m = true;
  
  private UserBasicModel n;
  
  private View o;
  
  private BluedUIHttpResponse p = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(this, (IRequestHost)w_()) {
      private void a(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA, boolean param1Boolean) {
        if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
          if (UserinfoFragmentFeedTab.b(this.a) == 1) {
            this.a.h.c(param1BluedEntityA.data);
          } else {
            this.a.h.a(param1BluedEntityA.data);
          } 
          this.a.h.notifyDataSetChanged();
        } 
        if (param1BluedEntityA != null && param1BluedEntityA.hasMore()) {
          UserinfoFragmentFeedTab.a(this.a, true);
          return;
        } 
        UserinfoFragmentFeedTab.a(this.a, false);
      }
      
      protected BluedEntityA<BluedIngSelfFeed> a(String param1String) {
        BluedEntityA<BluedIngSelfFeed> bluedEntityA = (BluedEntityA)super.parseData(param1String);
        if (this.a.d != null && bluedEntityA != null) {
          if (!bluedEntityA.hasData())
            return bluedEntityA; 
          for (BluedIngSelfFeed bluedIngSelfFeed : bluedEntityA.data)
            bluedIngSelfFeed.feedParse = new FeedParse(this.a.d, bluedIngSelfFeed, 1); 
        } 
        return bluedEntityA;
      }
      
      protected void a(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA) {
        a(param1BluedEntityA, true);
      }
      
      public void b(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA) {
        a(param1BluedEntityA, false);
      }
      
      public void onUIFinish(boolean param1Boolean) {
        if (UserinfoFragmentFeedTab.a(this.a) != null)
          UserinfoFragmentFeedTab.a(this.a).setVisibility(8); 
        if (this.a.h.n().size() <= 0) {
          if (param1Boolean) {
            UserinfoFragmentFeedTab.c(this.a).a();
          } else {
            UserinfoFragmentFeedTab.c(this.a).b();
            if (UserinfoFragmentFeedTab.b(this.a) != 1)
              UserinfoFragmentFeedTab.d(this.a); 
          } 
        } else {
          UserinfoFragmentFeedTab.c(this.a).c();
        } 
        boolean bool = UserinfoFragmentFeedTab.e(this.a);
        param1Boolean = false;
        if (bool) {
          this.a.h.l();
        } else {
          this.a.h.c(false);
          if (this.a.h.p() == 0) {
            this.a.h.c(UserinfoFragmentFeedTab.f(this.a));
            ((TextView)UserinfoFragmentFeedTab.f(this.a).findViewById(2131300944)).setText(2131759178);
          } 
        } 
        if (UserinfoFragmentFeedTab.b(this.a) == 1) {
          UserInfoFragmentNew userInfoFragmentNew = (UserInfoFragmentNew)this.a.getParentFragment();
          if (this.a.h.n().size() > 0)
            param1Boolean = true; 
          userInfoFragmentNew.e(param1Boolean);
        } 
      }
      
      public void onUIStart() {
        super.onUIStart();
        if (this.a.h.getItemCount() == 0 && UserinfoFragmentFeedTab.a(this.a) != null)
          UserinfoFragmentFeedTab.a(this.a).setVisibility(0); 
      }
    };
  
  public static UserinfoFragmentFeedTab a(UserBasicModel paramUserBasicModel) {
    UserinfoFragmentFeedTab userinfoFragmentFeedTab = new UserinfoFragmentFeedTab();
    Bundle bundle = new Bundle();
    bundle.putSerializable("user", (Serializable)paramUserBasicModel);
    userinfoFragmentFeedTab.setArguments(bundle);
    return userinfoFragmentFeedTab;
  }
  
  public void a() {
    this.o = this.e.findViewById(2131299159);
    this.j = new NoDataAndLoadFailView(this.d);
    this.j.c();
    this.j.setImageScale(0.7F);
    this.j.setTopSpace(DensityUtils.a(this.d, 58.0F));
    this.i = LayoutInflater.from(this.d).inflate(2131494212, null);
    this.f = (PullToRefreshRecyclerView)this.e.findViewById(2131301764);
    this.f.setRefreshEnabled(false);
    this.g = (RecyclerView)this.f.getRefreshableView();
    this.h = new FeedListAdapterForRecyclerView(new ArrayList(), this.d, (IRequestHost)w_(), this.g, 1);
    this.g.setAdapter((RecyclerView.Adapter)this.h);
    this.h.e((View)this.j);
    this.h.a((LoadMoreView)new BluedAdapterLoadMoreView());
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.d, 1);
    this.g.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.g.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
          public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
            super.onScrollStateChanged(param1RecyclerView, param1Int);
            this.a.h.p.onScrollStateChanged(param1RecyclerView, param1Int);
          }
          
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
            this.a.h.p.onScrolled(param1RecyclerView, param1Int1, param1Int2);
            UserinfoFeedScrollObserver.a().a(param1RecyclerView, param1Int1, param1Int2);
          }
        });
    this.h.c(true);
    this.h.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            this.a.a(false);
          }
        },  this.g);
    a(true);
  }
  
  public void a(Object paramObject, int paramInt) {
    if (paramInt == 2) {
      NoDataAndLoadFailView noDataAndLoadFailView = this.j;
      if (noDataAndLoadFailView != null)
        noDataAndLoadFailView.c(); 
      if (paramObject instanceof BluedIngSelfFeed) {
        paramObject = paramObject;
        if (this.h != null && !CircleMethods.isCircle((BluedIngSelfFeed)paramObject))
          a(true); 
      } 
    } 
  }
  
  public void a(boolean paramBoolean) {
    UserBasicModel userBasicModel = this.n;
    if (userBasicModel != null) {
      if (StringUtils.e(userBasicModel.uid))
        return; 
      if (paramBoolean) {
        this.k = 1;
      } else {
        this.k++;
      } 
      if (!this.m) {
        int i = this.k;
        if (i != 1) {
          this.k = i - 1;
          return;
        } 
      } 
      Context context = this.d;
      BluedUIHttpResponse bluedUIHttpResponse = this.p;
      String str1 = this.n.uid;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.k);
      stringBuilder1.append("");
      String str2 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.l);
      stringBuilder2.append("");
      MineHttpUtils.b(context, bluedUIHttpResponse, str1, str2, stringBuilder2.toString(), (IRequestHost)w_());
    } 
  }
  
  public void b(UserBasicModel paramUserBasicModel) {
    if (paramUserBasicModel == null)
      return; 
    this.n = paramUserBasicModel;
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.h;
    if (feedListAdapterForRecyclerView != null) {
      feedListAdapterForRecyclerView.v();
      this.h.c(true);
    } 
    a(true);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493345, paramViewGroup, false);
      this.n = (UserBasicModel)getArguments().getSerializable("user");
      if (this.n == null) {
        this.n = new UserBasicModel();
        this.n.uid = (UserInfo.a().i()).uid;
      } 
      a();
      FeedMethods.a((LifecycleOwner)getActivity(), (IFeedDataObserver)this.h);
      FeedRefreshObserver.a().a(this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    FeedRefreshObserver.a().b(this);
  }
  
  public void onPause() {
    super.onPause();
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.h;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.c(); 
  }
  
  public void onResume() {
    super.onResume();
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.h;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.b(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\UserinfoFragmentFeedTab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */