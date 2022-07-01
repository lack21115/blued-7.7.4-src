package com.soft.blued.ui.live.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.RecommendDataListener;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.observer.LiveListPositionObserver;
import com.blued.android.module.live_china.observer.LiveListRefreshObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.log.InstantLog;
import com.soft.blued.push.PushChecker;
import com.soft.blued.ui.discover.observer.LiveListSetSelectedTab;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.adapter.LiveFollowListItemAdapter;
import com.soft.blued.ui.live.adapter.LiveFollowRecommendAdapter;
import com.soft.blued.ui.live.adapter.LiveHorizontalRecommendAdapter;
import com.soft.blued.ui.live.contract.LiveListFollowContract;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.model.LiveListCommonModel;
import com.soft.blued.ui.live.model.LiveListRecommendModel;
import com.soft.blued.ui.live.model.LiveRecommendModel;
import com.soft.blued.ui.live.presenter.LiveListFollowPresenter;
import com.soft.blued.ui.live.utils.LiveListDataUtils;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.NetworkUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.List;

public class LiveListFollowFragment extends PreloadFragment implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, LiveListPositionObserver.ILiveListPositionObserver, HomeTabClick.TabClickListener, LiveListFollowContract.IView {
  private ListView A;
  
  private RecyclerView B;
  
  private RenrenPullToRefreshListView C;
  
  private TextView D;
  
  private TextView E;
  
  private TextView F;
  
  private View G;
  
  private View H;
  
  private View I;
  
  private View J;
  
  private ProgressBar K;
  
  private List<BluedLiveListData> L;
  
  private boolean M;
  
  private boolean N;
  
  private boolean O;
  
  private ViewGroup P;
  
  private TextView Q;
  
  private ViewGroup R;
  
  private View S;
  
  private TextView T;
  
  private View U;
  
  private PullToRefreshRecyclerView V;
  
  private RecyclerView W;
  
  private boolean X;
  
  public long o;
  
  private Context p;
  
  private LayoutInflater q;
  
  private LiveFollowListItemAdapter r;
  
  private LiveListFollowContract.IPresenter s;
  
  private LiveListCommonModel t;
  
  private LiveListRecommendModel u;
  
  private LiveFollowRecommendAdapter v;
  
  private LoadOptions w;
  
  private View x;
  
  private LinearLayout y;
  
  private NoDataAndLoadFailView z;
  
  private void u() {
    this.w = new LoadOptions();
    LoadOptions loadOptions = this.w;
    loadOptions.d = 2131231368;
    loadOptions.b = 2131231368;
    this.L = new ArrayList<BluedLiveListData>();
    this.r = new LiveFollowListItemAdapter((IRequestHost)w_(), this.p, this.L);
    this.t = new LiveListCommonModel();
    this.u = new LiveListRecommendModel();
    this.s = (LiveListFollowContract.IPresenter)new LiveListFollowPresenter((BaseFragment)this, this, this.t, this.u);
  }
  
  private void v() {
    this.q = (LayoutInflater)this.p.getSystemService("layout_inflater");
    this.C = (RenrenPullToRefreshListView)this.G.findViewById(2131299763);
    this.A = (ListView)this.C.getRefreshableView();
    this.y = (LinearLayout)this.G.findViewById(2131298988);
    this.z = (NoDataAndLoadFailView)this.G.findViewById(2131298984);
    this.I = this.q.inflate(2131493400, (ViewGroup)this.A, false);
    this.J = this.q.inflate(2131493068, (ViewGroup)this.A, false);
    this.A.addHeaderView(this.I);
    this.A.setAdapter((ListAdapter)this.r);
    this.H = this.I.findViewById(2131299042);
    this.x = this.H.findViewById(2131301688);
    this.x.setVisibility(8);
    this.H.setVisibility(8);
    this.B = (RecyclerView)this.I.findViewById(2131298572);
    this.I.findViewById(2131301626).setVisibility(8);
    this.D = (TextView)this.I.findViewById(2131300996);
    this.E = (TextView)this.J.findViewById(2131301109);
    this.F = (TextView)this.H.findViewById(2131301240);
    this.K = (ProgressBar)this.G.findViewById(2131299526);
    this.P = (ViewGroup)this.G.findViewById(2131298573);
    this.Q = (TextView)this.G.findViewById(2131298571);
    this.R = (ViewGroup)this.G.findViewById(2131298574);
    this.S = LayoutInflater.from(this.p).inflate(2131493998, null);
    this.T = (TextView)this.S.findViewById(2131300992);
    this.v = new LiveFollowRecommendAdapter((IRequestHost)w_(), this.p);
    this.v.e(this.S);
    this.V = (PullToRefreshRecyclerView)this.G.findViewById(2131299605);
    this.W = (RecyclerView)this.V.getRefreshableView();
    this.W.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(this.p, 3));
    this.W.setAdapter((RecyclerView.Adapter)this.v);
    w();
    this.v.a(new RecommendDataListener(this) {
          public void a() {
            (LiveListFollowFragment.a(this.a)).lastUid = LiveListFollowFragment.b(this.a).a();
            LiveListFollowFragment.c(this.a).a(false);
          }
        });
    this.r.a(new RecommendDataListener(this) {
          public void a() {
            (LiveListFollowFragment.a(this.a)).page = 1;
            (LiveListFollowFragment.a(this.a)).lastUid = "";
            LiveListFollowFragment.c(this.a).a(true);
          }
        });
    this.r.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            Logger.a("drb", new Object[] { "onLoadMoreRequested" });
            LiveListRecommendModel liveListRecommendModel = LiveListFollowFragment.a(this.a);
            liveListRecommendModel.page++;
            LiveListFollowFragment.c(this.a).a(true);
          }
        });
    this.Q.setOnClickListener(this);
    this.T.setOnClickListener(this);
    this.U = this.G.findViewById(2131299301);
    PushChecker.a().a(this.U, 1, MessageProtos.WarnTime.TOAST_LIVE);
  }
  
  private void w() {
    this.A.setOnItemLongClickListener(this);
    this.A.setOnItemClickListener(this);
    this.C.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            LiveListFollowFragment.d(this.a).setPage(1);
            LiveListFollowFragment.c(this.a).a(false);
            LiveListRefreshObserver.a().b();
          }
          
          public void b() {
            LiveListFollowFragment.d(this.a).setPage(LiveListFollowFragment.d(this.a).getPage() + 1);
            LiveListFollowFragment.c(this.a).b();
          }
        });
    this.V.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            (LiveListFollowFragment.a(this.a)).lastUid = LiveListFollowFragment.b(this.a).a();
            LiveListFollowFragment.c(this.a).a(false);
          }
        });
  }
  
  private void x() {
    if (this.L.size() < 5) {
      PushChecker.a().a(getContext(), 2, MessageProtos.WarnTime.LIVE_FIRST);
      return;
    } 
    this.C.setOnScrollListener(new AbsListView.OnScrollListener(this) {
          public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {
            if (param1Int == 1)
              PushChecker.a().a(this.a.getContext(), 2, MessageProtos.WarnTime.LIVE_FIRST); 
          }
        });
  }
  
  public void a() {
    if (this.t.getIfFooterShowing()) {
      this.t.setFooterShowing(false);
      this.E.setVisibility(8);
    } 
  }
  
  public void a(int paramInt, long paramLong) {
    if (paramInt == -1)
      return; 
    paramInt = LiveListDataUtils.a(paramLong, this.L);
    this.A.post(new Runnable(this, paramInt) {
          public void run() {
            LiveListFollowFragment.f(this.b).requestFocus();
            LiveListFollowFragment.f(this.b).setSelection(this.a + 1);
          }
        });
  }
  
  public void a(View paramView) {
    this.G = paramView;
    LayoutInflater.from(this.p).inflate(2131493174, (ViewGroup)this.e, true);
    u();
    v();
  }
  
  public void a(BluedLiveListData paramBluedLiveListData) {
    this.L.remove(paramBluedLiveListData);
    this.r.notifyDataSetChanged();
  }
  
  public void a(List<BluedLiveListData> paramList) {
    this.C.setVisibility(0);
    Logger.a("drb", new Object[] { "setVisibility VISIBLE" });
    if (NetworkUtils.b()) {
      this.C.setEmptyView((View)this.y);
      this.y.setVisibility(0);
      this.z.c();
    } else {
      this.C.setEmptyView((View)this.z);
      this.y.setVisibility(8);
      this.z.b();
    } 
    if (this.t.getPage() == 1)
      this.A.setAdapter((ListAdapter)this.r); 
    if (paramList != null) {
      LiveDataListManager.a().c(LiveRoomInfoChannel.a(paramList, "followed"));
      if (this.t.getPage() == 1)
        this.L.clear(); 
      this.L.addAll(paramList);
    } 
    this.r.notifyDataSetChanged();
    if (paramList != null && this.t.getPage() == 1)
      x(); 
  }
  
  public void a(boolean paramBoolean) {
    this.X = paramBoolean;
    if (paramBoolean) {
      this.P.setVisibility(0);
      return;
    } 
    this.P.setVisibility(8);
  }
  
  public void aM_() {
    if (this.t.getPage() == 1)
      this.t.setHasData(true); 
    if (!this.t.getHasData() && this.t.getPage() != 1) {
      LiveListCommonModel liveListCommonModel = this.t;
      liveListCommonModel.setPage(liveListCommonModel.getPage() - 1);
      AppMethods.a(this.p.getResources().getString(2131756083));
      this.C.j();
    } 
  }
  
  public void aN_() {
    if (this.u.page == 1)
      this.u.hasData = true; 
    if (!this.u.hasData && this.u.page != 1) {
      LiveListRecommendModel liveListRecommendModel = this.u;
      liveListRecommendModel.page--;
      AppMethods.a(this.p.getResources().getString(2131756083));
    } 
  }
  
  public void aO_() {
    this.C.o();
  }
  
  public void b() {
    this.C.p();
  }
  
  public void b(List<LiveRecommendModel> paramList) {
    if (this.v == null)
      return; 
    if (!NetworkUtils.b()) {
      Logger.a("drb", new Object[] { "!CommonMethod.isNet()" });
      if (!this.X || this.v.n() == null || this.v.n().size() <= 0) {
        this.C.setVisibility(0);
        t();
        e();
        this.P.setVisibility(8);
      } 
    } 
    if (paramList != null) {
      if (paramList.size() > 0) {
        this.P.setVisibility(0);
        this.R.setVisibility(0);
        this.v.a(paramList);
        this.y.setVisibility(8);
        this.z.c();
        e();
        this.C.setVisibility(8);
        return;
      } 
      this.v.e(this.S);
      this.S.setVisibility(0);
      this.v.c(null);
      this.R.setVisibility(8);
      e();
      this.C.setVisibility(8);
    } 
  }
  
  public void b(boolean paramBoolean) {
    LiveFollowListItemAdapter liveFollowListItemAdapter = this.r;
    if (liveFollowListItemAdapter != null) {
      liveFollowListItemAdapter.a(paramBoolean);
      LiveHorizontalRecommendAdapter liveHorizontalRecommendAdapter = this.r.b();
      if (liveHorizontalRecommendAdapter != null && liveHorizontalRecommendAdapter.n() != null && liveHorizontalRecommendAdapter.n().size() == 0)
        this.r.c(); 
    } 
  }
  
  public void c() {
    this.C.q();
  }
  
  public void c(String paramString) {
    if ("live".equals(paramString) && this.O) {
      if (this.X) {
        this.V.setRefreshing(true);
        return;
      } 
      this.C.setRefreshing(true);
    } 
  }
  
  public void c(List<LiveRecommendModel> paramList) {
    LiveFollowListItemAdapter liveFollowListItemAdapter = this.r;
    if (liveFollowListItemAdapter != null)
      liveFollowListItemAdapter.a(paramList); 
  }
  
  public void d() {
    this.V.j();
  }
  
  public void d(String paramString) {
    if ("live".equals(paramString) && this.O)
      c(paramString); 
  }
  
  public void e() {
    this.C.j();
  }
  
  public void h() {
    for (int i = 0; i < this.L.size(); i++) {
      if (((BluedLiveListData)this.L.get(i)).livetype != 0) {
        this.t.setTipShow(false);
        return;
      } 
      this.t.setTipShow(true);
    } 
  }
  
  public void i() {
    if (this.t.getHasFollowData()) {
      if (this.t.getIfTipShow()) {
        this.D.setVisibility(0);
      } else {
        this.D.setVisibility(8);
      } 
      if (this.t.getIfRecommendShow()) {
        this.H.setVisibility(0);
        return;
      } 
      this.H.setVisibility(8);
      return;
    } 
    if (this.t.getPage() == 1) {
      this.D.setVisibility(8);
      this.H.setVisibility(8);
    } 
  }
  
  public void k() {
    this.K.setVisibility(8);
  }
  
  public void l() {
    LiveFollowListItemAdapter liveFollowListItemAdapter = this.r;
    if (liveFollowListItemAdapter != null)
      liveFollowListItemAdapter.d(); 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131298571) {
      if (i != 2131300992)
        return; 
      LiveListSetSelectedTab.a().a(1);
      return;
    } 
    EventTrackLive.a(LiveProtos.Event.LIVE_FOLLOWED_GRID_RECOMMEND_REFRESH_CLICK);
    InstantLog.a("live_followed_grid_recommend_refresh_click");
    if (this.V.i())
      return; 
    this.V.setRefreshing(true);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.p = (Context)getActivity();
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy() {
    super.onDestroy();
    HomeTabClick.b("live", this);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    BluedLiveListData bluedLiveListData = (BluedLiveListData)paramAdapterView.getAdapter().getItem(paramInt);
    if (bluedLiveListData != null) {
      paramInt = bluedLiveListData.livetype;
      String str = bluedLiveListData.uid;
      if (bluedLiveListData.anchor != null) {
        String str1 = bluedLiveListData.anchor.avatar;
        str1 = bluedLiveListData.anchor.name;
        int i = bluedLiveListData.anchor.vbadge;
      } 
      TextUtils.isEmpty(bluedLiveListData.lid);
      if (paramInt == 0) {
        UserInfoFragmentNew.a(this.p, str, "");
        return;
      } 
      LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(bluedLiveListData.lid, 0L), bluedLiveListData.screen_pattern, "followed", bluedLiveListData.uid, bluedLiveListData.title, bluedLiveListData.pic_url, 0);
      liveRoomData.live_url = bluedLiveListData.live_play;
      LiveRoomInfoChannel.a(this.p, liveRoomData, -1, LiveRoomInfoChannel.a(this.r.a(), "followed"));
    } 
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    BluedLiveListData bluedLiveListData = (BluedLiveListData)paramAdapterView.getAdapter().getItem(paramInt);
    if (bluedLiveListData != null) {
      Context context = this.p;
      CommonAlertDialog.a(context, "", context.getString(2131757136), this.p.getResources().getString(2131756086), new DialogInterface.OnClickListener(this, bluedLiveListData) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              if (BluedPreferences.aL()) {
                AlertDialog alertDialog = (new AlertDialog.Builder(LiveListFollowFragment.e(this.b))).create();
                Window window = alertDialog.getWindow();
                alertDialog.show();
                window.setContentView(LayoutInflater.from(LiveListFollowFragment.e(this.b)).inflate(2131492980, null));
                window.clearFlags(131072);
                alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener(this) {
                      public boolean onKey(DialogInterface param2DialogInterface, int param2Int, KeyEvent param2KeyEvent) {
                        return (param2Int == 4);
                      }
                    });
                ((TextView)window.findViewById(2131296926)).setOnClickListener(new View.OnClickListener(this, (Dialog)alertDialog) {
                      public void onClick(View param2View) {
                        Dialog dialog = this.a;
                        if (dialog != null)
                          dialog.cancel(); 
                        BluedPreferences.aM();
                        LiveListFollowFragment.c(this.b.b).a(this.b.a);
                      }
                    });
                return;
              } 
              LiveListFollowFragment.c(this.b).a(this.a);
            }
          }this.p.getResources().getString(2131756057), null, null);
    } 
    return true;
  }
  
  public void onPause() {
    super.onPause();
    this.o = System.currentTimeMillis();
  }
  
  public void onResume() {
    super.onResume();
    if (this.o != 0L && this.O) {
      if (System.currentTimeMillis() - this.o > 300000L) {
        RenrenPullToRefreshListView renrenPullToRefreshListView = this.C;
        if (renrenPullToRefreshListView != null)
          renrenPullToRefreshListView.setRefreshing(true); 
      } 
      this.o = 0L;
    } 
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    if (this.M) {
      if (this.O) {
        this.N = true;
        this.V.k();
      } 
      this.M = false;
    } 
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.O = paramBoolean;
    if (!this.N && this.O && this.G != null) {
      this.N = true;
      this.V.setRefreshing(true);
    } 
    if (paramBoolean) {
      HomeTabClick.a("live", this);
      LiveListPositionObserver.a().a(this);
      LiveDataListManager.a().c(LiveRoomInfoChannel.a(this.L, "followed"));
      return;
    } 
    LiveListPositionObserver.a().b(this);
  }
  
  public void t() {
    a((List<BluedLiveListData>)null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveListFollowFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */