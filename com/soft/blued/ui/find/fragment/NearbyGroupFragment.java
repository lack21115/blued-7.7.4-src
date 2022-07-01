package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SearchView;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.find.adapter.RecommendedGroupAdapter;
import com.soft.blued.ui.group.GroupSearchFragment;
import com.soft.blued.ui.group.adapter.GroupListsAdapter;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedGroupExtra;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.home.HomeTabClick;
import java.util.ArrayList;
import java.util.List;

public class NearbyGroupFragment extends PreloadFragment implements HomeTabClick.TabClickListener {
  private List<BluedGroupLists> A;
  
  private int B = 1;
  
  private int C = 20;
  
  private boolean D = true;
  
  private boolean E = false;
  
  private View F;
  
  private View o;
  
  private View p;
  
  private Context q;
  
  private NoDataAndLoadFailView r;
  
  private SearchView s;
  
  private View t;
  
  private RenrenPullToRefreshListView u;
  
  private RecyclerView v;
  
  private TextView w;
  
  private ListView x;
  
  private GroupListsAdapter y;
  
  private RecommendedGroupAdapter z;
  
  private void t() {
    this.u = (RenrenPullToRefreshListView)this.o.findViewById(2131298144);
    this.u.setRefreshEnabled(true);
    this.x = (ListView)this.u.getRefreshableView();
    this.x.setClipToPadding(false);
    this.x.setScrollBarStyle(33554432);
    this.x.setHeaderDividersEnabled(false);
    this.x.setDividerHeight(0);
    this.y = new GroupListsAdapter(this.q);
    this.x.setAdapter((ListAdapter)this.y);
    this.x.addHeaderView(this.p);
    this.u.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            NearbyGroupFragment.a(this.a, 1);
            NearbyGroupFragment.a(this.a);
          }
          
          public void b() {
            NearbyGroupFragment.b(this.a);
            NearbyGroupFragment.a(this.a);
          }
        });
    this.x.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            if (param1Int > 1) {
              if (param1Int > NearbyGroupFragment.c(this.a).getCount() + 1)
                return; 
              BluedGroupLists bluedGroupLists = (BluedGroupLists)NearbyGroupFragment.c(this.a).getItem(param1Int - 2);
              GroupInfoFragment.a(NearbyGroupFragment.d(this.a), bluedGroupLists.groups_gid, "nearby");
            } 
          }
        });
    a(new Runnable(this) {
          public void run() {
            NearbyGroupFragment.e(this.a).k();
          }
        },  200L);
  }
  
  private void u() {
    if (this.B == 1 || this.D) {
      Context context = this.q;
      BluedUIHttpResponse<BluedEntity<BluedGroupLists, BluedGroupExtra>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<BluedGroupLists, BluedGroupExtra>>(this) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            NearbyGroupFragment.b(this.a, true);
            NearbyGroupFragment.k(this.a);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            if (NearbyGroupFragment.c(this.a).getCount() == 0) {
              if (NearbyGroupFragment.l(this.a)) {
                NearbyGroupFragment.m(this.a).b();
              } else {
                NearbyGroupFragment.m(this.a).a();
              } 
              NearbyGroupFragment.g(this.a).setVisibility(8);
              NearbyGroupFragment.h(this.a).setVisibility(8);
              NearbyGroupFragment.i(this.a).setVisibility(8);
              NearbyGroupFragment.e(this.a).p();
            } else {
              NearbyGroupFragment.m(this.a).c();
              if (NearbyGroupFragment.n(this.a)) {
                NearbyGroupFragment.e(this.a).o();
              } else {
                NearbyGroupFragment.e(this.a).p();
              } 
            } 
            NearbyGroupFragment.e(this.a).q();
            NearbyGroupFragment.e(this.a).j();
            NearbyGroupFragment.b(this.a, false);
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
          
          public void onUIUpdate(BluedEntity<BluedGroupLists, BluedGroupExtra> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0)
              if (NearbyGroupFragment.f(this.a) == 1) {
                NearbyGroupFragment.c(this.a).a(param1BluedEntity.data);
              } else {
                NearbyGroupFragment.c(this.a).b(param1BluedEntity.data);
              }  
            if (param1BluedEntity != null) {
              NearbyGroupFragment.a(this.a, param1BluedEntity.hasMore());
            } else {
              NearbyGroupFragment.a(this.a, false);
            } 
            if (NearbyGroupFragment.f(this.a) == 1) {
              if (param1BluedEntity != null && param1BluedEntity.extra != null && ((BluedGroupExtra)param1BluedEntity.extra).recommend_groups != null && ((BluedGroupExtra)param1BluedEntity.extra).recommend_groups.size() >= 2) {
                NearbyGroupFragment.g(this.a).setVisibility(0);
                NearbyGroupFragment.h(this.a).setVisibility(0);
                NearbyGroupFragment.i(this.a).setVisibility(0);
                NearbyGroupFragment.j(this.a).a(((BluedGroupExtra)param1BluedEntity.extra).recommend_groups);
                return;
              } 
              NearbyGroupFragment.g(this.a).setVisibility(8);
              NearbyGroupFragment.h(this.a).setVisibility(8);
              NearbyGroupFragment.i(this.a).setVisibility(8);
              NearbyGroupFragment.j(this.a).a(null);
            } 
          }
        };
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.B);
      stringBuilder1.append("");
      String str = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.C);
      stringBuilder2.append("");
      GroupHttpUtils.e(context, bluedUIHttpResponse, str, stringBuilder2.toString(), (IRequestHost)w_());
    } 
  }
  
  private void v() {
    this.r = (NoDataAndLoadFailView)this.p.findViewById(2131299395);
    this.r.setNoDataImg(2131232644);
    this.r.a();
    this.s = (SearchView)this.p.findViewById(2131297300);
    this.s.setMaskLayerOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            TerminalActivity.d(NearbyGroupFragment.d(this.a), GroupSearchFragment.class, null);
          }
        });
    this.t = this.p.findViewById(2131298840);
    this.t.setOnClickListener(null);
    this.F = this.p.findViewById(2131298123);
    this.w = (TextView)this.p.findViewById(2131301097);
    this.w.setVisibility(8);
    this.w.setOnClickListener(null);
    this.A = new ArrayList<BluedGroupLists>();
    this.v = (RecyclerView)this.p.findViewById(2131299788);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.q);
    linearLayoutManager.setOrientation(0);
    this.z = new RecommendedGroupAdapter(this.q, (IRequestHost)w_(), this.A);
    this.v.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.v.setAdapter((RecyclerView.Adapter)this.z);
  }
  
  public void a(View paramView) {
    this.q = (Context)getActivity();
    LayoutInflater layoutInflater = LayoutInflater.from(this.q);
    this.o = layoutInflater.inflate(2131493249, (ViewGroup)paramView, true);
    this.p = layoutInflater.inflate(2131493398, null, false);
    t();
    v();
  }
  
  public void c(String paramString) {
    if ("find".equals(paramString)) {
      RenrenPullToRefreshListView renrenPullToRefreshListView = this.u;
      if (renrenPullToRefreshListView != null)
        renrenPullToRefreshListView.k(); 
    } 
  }
  
  public void d(String paramString) {
    c(paramString);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy() {
    HomeTabClick.b("find", this);
    super.onDestroy();
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
      HomeTabClick.a("find", this); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyGroupFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */