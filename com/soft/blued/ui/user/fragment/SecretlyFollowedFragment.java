package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.find.adapter.RecommendListAdapter;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.ui.user.model.SecretlyFollowedExtra;
import com.soft.blued.ui.user.observer.SecretlyFollowedObserver;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;

public class SecretlyFollowedFragment extends BaseFragment implements View.OnClickListener, VIPBuyResultObserver.IVIPBuyResultObserver {
  BluedUIHttpResponse d = new BluedUIHttpResponse<BluedEntity<BluedRecommendUsers, SecretlyFollowedExtra>>(this) {
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        super.onFailure(param1Throwable, param1Int, param1String);
        SecretlyFollowedFragment.c(this.a, true);
        if (SecretlyFollowedFragment.c(this.a) != 1)
          SecretlyFollowedFragment.e(this.a); 
      }
      
      public void onUIFinish() {
        SecretlyFollowedFragment.b(this.a).j();
        SecretlyFollowedFragment.b(this.a).q();
        if (SecretlyFollowedFragment.g(this.a)) {
          if (SecretlyFollowedFragment.d(this.a).getCount() == 0) {
            SecretlyFollowedFragment.h(this.a).b();
          } else {
            SecretlyFollowedFragment.h(this.a).c();
          } 
        } else if (SecretlyFollowedFragment.d(this.a).getCount() == 0) {
          SecretlyFollowedFragment.h(this.a).a();
        } else {
          SecretlyFollowedFragment.h(this.a).c();
        } 
        SecretlyFollowedFragment.d(this.a).notifyDataSetChanged();
        SecretlyFollowedFragment.c(this.a, false);
        if (SecretlyFollowedFragment.d(this.a).getCount() == 0) {
          if ((BluedConfig.b().j()).is_secretly_followed == 1 || (UserInfo.a().i()).vip_grade == 2) {
            SecretlyFollowedFragment.i(this.a).setVisibility(8);
            SecretlyFollowedFragment.j(this.a).setVisibility(8);
            return;
          } 
          SecretlyFollowedFragment.i(this.a).setVisibility(0);
          SecretlyFollowedFragment.j(this.a).setVisibility(8);
          return;
        } 
        SecretlyFollowedFragment.i(this.a).setVisibility(8);
        if ((BluedConfig.b().j()).is_secretly_followed == 1 || (UserInfo.a().i()).vip_grade == 2) {
          SecretlyFollowedFragment.j(this.a).setVisibility(8);
          return;
        } 
        SecretlyFollowedFragment.j(this.a).setVisibility(0);
      }
      
      public void onUIUpdate(BluedEntity<BluedRecommendUsers, SecretlyFollowedExtra> param1BluedEntity) {
        if (param1BluedEntity != null) {
          if (param1BluedEntity.data != null && param1BluedEntity.hasData()) {
            if (param1BluedEntity.hasMore()) {
              SecretlyFollowedFragment.b(this.a, true);
              SecretlyFollowedFragment.b(this.a).o();
            } else {
              SecretlyFollowedFragment.b(this.a, false);
              SecretlyFollowedFragment.b(this.a).p();
            } 
            if (SecretlyFollowedFragment.c(this.a) == 1) {
              SecretlyFollowedFragment.d(this.a).a(param1BluedEntity.data);
            } else {
              SecretlyFollowedFragment.d(this.a).b(param1BluedEntity.data);
            } 
          } else {
            if (SecretlyFollowedFragment.c(this.a) == 1)
              SecretlyFollowedFragment.d(this.a).a(param1BluedEntity.data); 
            if (SecretlyFollowedFragment.c(this.a) > 1) {
              SecretlyFollowedFragment.e(this.a);
              SecretlyFollowedFragment.b(this.a, false);
              SecretlyFollowedFragment.b(this.a).p();
              AppMethods.a(SecretlyFollowedFragment.f(this.a).getResources().getString(2131756083));
            } 
          } 
          if (param1BluedEntity.extra != null)
            SecretlyFollowedObserver.a().a(((SecretlyFollowedExtra)param1BluedEntity.extra).secretly_count, ((SecretlyFollowedExtra)param1BluedEntity.extra).secretly_followed_limit); 
        } 
      }
    };
  
  private Context e;
  
  private View f;
  
  private NoDataAndLoadFailView g;
  
  private RenrenPullToRefreshListView h;
  
  private ListView i;
  
  private LayoutInflater j;
  
  private RecommendListAdapter k;
  
  private int l;
  
  private int m = 20;
  
  private boolean n = true;
  
  private boolean o = false;
  
  private String p;
  
  private TextView q;
  
  private TextView r;
  
  private LinearLayout s;
  
  private ConstraintLayout t;
  
  private void a() {
    if (getArguments() != null)
      this.p = getArguments().getString("uid"); 
    this.j = LayoutInflater.from(this.e);
    this.q = (TextView)this.f.findViewById(2131300599);
    this.q.setOnClickListener(this);
    this.r = (TextView)this.f.findViewById(2131300600);
    this.r.setOnClickListener(this);
    this.s = (LinearLayout)this.f.findViewById(2131298738);
    this.t = (ConstraintLayout)this.f.findViewById(2131298737);
    this.h = (RenrenPullToRefreshListView)this.f.findViewById(2131298144);
    this.h.setRefreshEnabled(true);
    this.i = (ListView)this.h.getRefreshableView();
    this.i.setClipToPadding(false);
    this.i.setScrollBarStyle(33554432);
    this.i.setHeaderDividersEnabled(false);
    this.i.setDividerHeight(0);
    this.i.setEmptyView((View)this.g);
    this.h.k();
    this.k = new RecommendListAdapter(this.e, 3, k(), (IRequestHost)w_());
    this.i.setAdapter((ListAdapter)this.k);
    this.h.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            SecretlyFollowedFragment.a(this.a, 1);
            SecretlyFollowedFragment.a(this.a, false);
          }
          
          public void b() {
            SecretlyFollowedFragment.a(this.a);
            SecretlyFollowedFragment.a(this.a, false);
          }
        });
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.l = 1; 
    if (this.l == 1)
      this.n = true; 
    if (!this.n) {
      int i = this.l;
      if (i != 1) {
        this.l = i - 1;
        AppMethods.a(this.e.getResources().getString(2131756083));
        this.h.j();
        this.h.q();
        return;
      } 
    } 
    Context context = this.e;
    BluedUIHttpResponse bluedUIHttpResponse = this.d;
    String str1 = this.p;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.l);
    stringBuilder1.append("");
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.m);
    stringBuilder2.append("");
    MineHttpUtils.f(context, bluedUIHttpResponse, str1, str2, stringBuilder2.toString(), (IRequestHost)w_());
  }
  
  private boolean k() {
    return TextUtils.isEmpty(this.p) ? false : (this.p.equals(UserInfo.a().i().getUid()));
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    if (paramBoolean)
      a(true); 
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131300599:
      case 2131300600:
        break;
    } 
    InstantLog.a("secretly_follow_buy_btn_click");
    PayUtils.a(this.e, 22, "follow_secret_list");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    this.j = paramLayoutInflater;
    View view = this.f;
    if (view == null) {
      this.f = this.j.inflate(2131493308, paramViewGroup, false);
      this.g = new NoDataAndLoadFailView(this.e);
      this.g.setNoDataImg(2131232643);
      this.g.setNoDataStr(2131758254);
      this.g.c();
      a();
      VIPBuyResultObserver.a().a(this, getLifecycle());
    } else if (view.getParent() != null) {
      ((ViewGroup)this.f.getParent()).removeView(this.f);
    } 
    return this.f;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\SecretlyFollowedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */