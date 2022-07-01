package com.soft.blued.ui.tag_show;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.model.BluedMyExtra;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.adapter.PeopleListQuickAdapter;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import java.util.ArrayList;

public class TagUserFragment extends BaseFragment {
  public static String d = "TAG_STR";
  
  public static String e = "TAG_ID";
  
  BluedUIHttpResponse f = new BluedUIHttpResponse<BluedEntity<UserFindResult, BluedMyExtra>>(this, (IRequestHost)w_()) {
      public void onUIFinish() {
        super.onUIFinish();
        TagUserFragment.i(this.a).j();
        if (TagUserFragment.e(this.a)) {
          TagUserFragment.f(this.a).l();
          return;
        } 
        TagUserFragment.c(this.a).l();
      }
      
      public void onUIUpdate(BluedEntity<UserFindResult, BluedMyExtra> param1BluedEntity) {
        if (param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
          if (param1BluedEntity.extra != null && param1BluedEntity.hasMore()) {
            TagUserFragment.a(this.a, true);
            if (TagUserFragment.e(this.a)) {
              TagUserFragment.f(this.a).c(true);
            } else {
              TagUserFragment.c(this.a).c(true);
            } 
          } else {
            if (TagUserFragment.e(this.a)) {
              TagUserFragment.f(this.a).c(false);
            } else {
              TagUserFragment.c(this.a).c(false);
            } 
            TagUserFragment.a(this.a, false);
          } 
          if (TagUserFragment.g(this.a) == 1) {
            if (TagUserFragment.e(this.a)) {
              TagUserFragment.f(this.a).c(param1BluedEntity.data);
            } else {
              TagUserFragment.c(this.a).c(param1BluedEntity.data);
            } 
          } else if (TagUserFragment.e(this.a)) {
            TagUserFragment.f(this.a).a(param1BluedEntity.data);
          } else {
            TagUserFragment.c(this.a).a(param1BluedEntity.data);
          } 
          if (param1BluedEntity.extra != null) {
            TagUserFragment.a(this.a, ((BluedMyExtra)param1BluedEntity.extra).getNext_min_dist());
            TagUserFragment.b(this.a, ((BluedMyExtra)param1BluedEntity.extra).getNext_skip_uid());
            return;
          } 
        } else {
          if (TagUserFragment.g(this.a) != 1)
            TagUserFragment.h(this.a); 
          if (BluedPreferences.G()) {
            AppMethods.a(TagUserFragment.d(this.a).getResources().getString(2131755446));
          } else {
            AppMethods.a(TagUserFragment.d(this.a).getResources().getString(2131756083));
          } 
          if (TagUserFragment.e(this.a)) {
            TagUserFragment.f(this.a).c(false);
            return;
          } 
          TagUserFragment.c(this.a).c(false);
        } 
      }
      
      public BluedEntity<UserFindResult, BluedMyExtra> parseData(String param1String) {
        BluedEntity<UserFindResult, BluedMyExtra> bluedEntity = super.parseData(param1String);
        if (bluedEntity != null)
          for (int i = 0; i < bluedEntity.data.size(); i++) {
            ((UserFindResult)bluedEntity.data.get(i)).distance = DistanceUtils.a(((UserFindResult)bluedEntity.data.get(i)).distance, BlueAppLocal.c(), false);
            ((UserFindResult)bluedEntity.data.get(i)).last_operate = TimeAndDateUtils.a(TagUserFragment.d(this.a), TimeAndDateUtils.b(((UserFindResult)bluedEntity.data.get(i)).last_operate));
          }  
        return bluedEntity;
      }
    };
  
  private Context g;
  
  private View h;
  
  private PullToRefreshRecyclerView i;
  
  private RecyclerView j;
  
  private int k;
  
  private boolean l;
  
  private boolean m;
  
  private String n;
  
  private String o;
  
  private int p = 1;
  
  private int q = 60;
  
  private boolean r = true;
  
  private PeopleGridQuickAdapter s;
  
  private PeopleListQuickAdapter t;
  
  private String u;
  
  private String v;
  
  private void l() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.u = bundle.getString(e);
      this.v = bundle.getString(d);
    } 
    int i = BluedPreferences.aD();
    if (i != 1) {
      if (i != 2)
        return; 
      this.m = true;
      return;
    } 
    this.m = false;
  }
  
  private void m() {
    this.k = PeopleGridQuickAdapter.a(this.g);
    this.i = (PullToRefreshRecyclerView)this.h.findViewById(2131298144);
    PullToRefreshRecyclerView pullToRefreshRecyclerView = this.i;
    boolean bool = true;
    pullToRefreshRecyclerView.setRefreshEnabled(true);
    this.j = (RecyclerView)this.i.getRefreshableView();
    this.j.setClipToPadding(false);
    this.j.setScrollBarStyle(33554432);
    if (BluedPreferences.I() != 1)
      bool = false; 
    this.l = bool;
    this.i.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            this.a.a(true);
          }
        });
    if (this.l) {
      a();
    } else {
      k();
    } 
    this.i.k();
  }
  
  public void a() {
    this.t = new PeopleListQuickAdapter(new ArrayList(), (Activity)getActivity(), (IRequestHost)w_(), "tag_user", this.j);
    this.t.a(this.v);
    this.t.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            TagUserFragment.a(this.a);
            this.a.a(false);
          }
        },  this.j);
    this.j.setAdapter((RecyclerView.Adapter)this.t);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.g, 1);
    this.j.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean)
      this.p = 1; 
    if (this.p == 1)
      this.r = true; 
    if (!this.r) {
      AppMethods.a(this.g.getResources().getString(2131756083));
      this.i.j();
      return;
    } 
    int i = this.q;
    int j = this.p;
    FilterEntity filterEntity = new FilterEntity();
    filterEntity.tagsid = this.u;
    filterEntity.sort_by = "index";
    filterEntity.longitude = BluedPreferences.s();
    filterEntity.latitude = BluedPreferences.t();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.q);
    stringBuilder.append("");
    filterEntity.limit = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(i * (j - 1));
    stringBuilder.append("");
    filterEntity.start = stringBuilder.toString();
    filterEntity.source = "tag";
    filterEntity.column = PeopleGridQuickAdapter.a(this.g);
    if (this.p == 1) {
      NearbyHttpUtils.b((Context)getActivity(), this.f, filterEntity, "", (IRequestHost)w_());
      return;
    } 
    filterEntity.next_min_dist = this.n;
    filterEntity.next_skip_uid = this.o;
    NearbyHttpUtils.b((Context)getActivity(), this.f, filterEntity, "", (IRequestHost)w_());
  }
  
  public void k() {
    this.s = new PeopleGridQuickAdapter(new ArrayList(), (Activity)getActivity(), (IRequestHost)w_(), "tag_user", this.j);
    this.s.a(this.v);
    this.s.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            TagUserFragment.a(this.a);
            this.a.a(false);
          }
        },  this.j);
    this.j.setAdapter((RecyclerView.Adapter)this.s);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.g, this.k);
    this.j.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) {
          public int getSpanSize(int param1Int) {
            int i = TagUserFragment.b(this.c);
            if (TagUserFragment.c(this.c).e(param1Int) != null) {
              param1Int = TagUserFragment.c(this.c).getItemViewType(param1Int);
              if (param1Int != 10)
                return (param1Int != 11) ? TagUserFragment.b(this.c) : TagUserFragment.b(this.c); 
              i = 1;
            } 
            return i;
          }
        });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.g = (Context)getActivity();
    View view = this.h;
    if (view == null) {
      this.h = paramLayoutInflater.inflate(2131493331, paramViewGroup, false);
      l();
      m();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.h.getParent()).removeView(this.h);
    } 
    return this.h;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\tag_show\TagUserFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */