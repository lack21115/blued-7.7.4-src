package com.soft.blued.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.R;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.adapter.CircleNewListAdapter;
import com.soft.blued.ui.circle.adapter.CircleTypeListAdapter;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.circle.model.CircleTypeListModel;
import com.soft.blued.ui.circle.model.CircleTypeModel;
import com.soft.blued.ui.circle.vm.CircleTypeListViewModel;
import com.soft.blued.utils.ViewUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, d1 = {"\000V\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\004\n\002\030\002\n\002\b\002\n\002\020 \n\002\030\002\n\000\n\002\020\002\n\002\b\006\n\002\020\013\n\002\b\004\n\002\030\002\n\002\b\005\030\000 '2\b\022\004\022\0020\0020\001:\001'B\005¢\006\002\020\003J\020\020\026\032\0020\0272\006\020\030\032\0020\025H\002J\b\020\031\032\0020\027H\024J\b\020\032\032\0020\027H\024J\b\020\033\032\0020\027H\024J\020\020\034\032\0020\0272\006\020\035\032\0020\036H\024J\b\020\037\032\0020\027H\024J\020\020 \032\0020\0272\006\020\030\032\0020\025H\002J\020\020!\032\0020\0272\006\020\"\032\0020#H\002J\026\020$\032\0020\0272\f\020%\032\b\022\004\022\0020\0250\024H\002J\020\020&\032\0020\0272\006\020\035\032\0020\036H\002R\016\020\004\032\0020\005X\016¢\006\002\n\000R\016\020\006\032\0020\007X.¢\006\002\n\000R\016\020\b\032\0020\005X\016¢\006\002\n\000R\016\020\t\032\0020\nX.¢\006\002\n\000R\016\020\013\032\0020\fX\016¢\006\002\n\000R\024\020\r\032\0020\fXD¢\006\b\n\000\032\004\b\016\020\017R\016\020\020\032\0020\021X.¢\006\002\n\000R\016\020\022\032\0020\fX\016¢\006\002\n\000R\024\020\023\032\b\022\004\022\0020\0250\024X\016¢\006\002\n\000¨\006("}, d2 = {"Lcom/soft/blued/ui/circle/fragment/CircleTypeListFragment;", "Lcom/blued/android/module/common/base/mvvm/MVVMBaseFragment;", "Lcom/soft/blued/ui/circle/vm/CircleTypeListViewModel;", "()V", "circleFromPage", "Lcom/soft/blued/ui/circle/model/CircleConstants$CIRCLE_FROM_PAGE;", "circleListAdapter", "Lcom/soft/blued/ui/circle/adapter/CircleNewListAdapter;", "circleListPage", "circleTypeListAdapter", "Lcom/soft/blued/ui/circle/adapter/CircleTypeListAdapter;", "clickPosition", "", "layoutId", "getLayoutId", "()I", "noDataView", "Lcom/soft/blued/customview/NoDataAndLoadFailView;", "nowPosition", "typeList", "", "Lcom/soft/blued/ui/circle/model/CircleTypeModel$DataBean;", "getPositionAndOffset", "", "model", "hasMore", "init", "liveDataObserver", "loadFinish", "success", "", "noMore", "scrollToPosition", "setCircleListData", "circleListModel", "Lcom/soft/blued/ui/circle/model/CircleTypeListModel;", "setCircleTypeListData", "circleTypeList", "typeListLoadFinish", "Companion", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class CircleTypeListFragment extends MVVMBaseFragment<CircleTypeListViewModel> {
  public static final Companion e = new Companion(null);
  
  private NoDataAndLoadFailView f;
  
  private CircleConstants.CIRCLE_FROM_PAGE g = CircleConstants.CIRCLE_FROM_PAGE.EXPLORE_MORE;
  
  private CircleConstants.CIRCLE_FROM_PAGE h = CircleConstants.CIRCLE_FROM_PAGE.HOME_RECOMMEND_CIRCLE;
  
  private CircleNewListAdapter i;
  
  private CircleTypeListAdapter j;
  
  private List<? extends CircleTypeModel.DataBean> k = new ArrayList<CircleTypeModel.DataBean>();
  
  private int l;
  
  private int m;
  
  private final int n = 2131493102;
  
  private HashMap o;
  
  private final void a(CircleTypeListModel paramCircleTypeListModel) {
    CircleNewListAdapter circleNewListAdapter = this.i;
    if (circleNewListAdapter == null)
      Intrinsics.b("circleListAdapter"); 
    circleNewListAdapter.c(paramCircleTypeListModel.getCircleList());
    if (((CircleTypeListViewModel)k()).g()) {
      b(this.k.get(this.m));
      ((CircleTypeListViewModel)k()).c(false);
    } 
    CircleConstants.CIRCLE_FROM_PAGE cIRCLE_FROM_PAGE = this.h;
    int i = CircleTypeListFragment$WhenMappings.a[cIRCLE_FROM_PAGE.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
          return; 
        EventTrackFeed.a(FeedProtos.Event.CIRCLE_MORE_LIST_SHOW, FeedProtos.SourcePage.CIRCLE_HOME_RECOMMEND, ((CircleTypeListViewModel)k()).f());
        return;
      } 
      EventTrackFeed.a(FeedProtos.Event.CIRCLE_MORE_LIST_SHOW, FeedProtos.SourcePage.MINE_CIRCLE, ((CircleTypeListViewModel)k()).f());
      return;
    } 
    EventTrackFeed.a(FeedProtos.Event.CIRCLE_MORE_LIST_SHOW, FeedProtos.SourcePage.FEED_PLAZA_RECOMMEND_MORE, ((CircleTypeListViewModel)k()).f());
  }
  
  private final void a(CircleTypeModel.DataBean paramDataBean) {
    int[] arrayOfInt = ViewUtils.a((RecyclerView)a(R.id.circleListRecycler));
    paramDataBean.lastPosition = arrayOfInt[0];
    paramDataBean.lastOffset = arrayOfInt[1];
  }
  
  private final void a(List<? extends CircleTypeModel.DataBean> paramList) {
    if (paramList.isEmpty()) {
      ((NoDataAndLoadFailView)a(R.id.classNoDataView)).a();
      return;
    } 
    CircleTypeListAdapter circleTypeListAdapter = this.j;
    if (circleTypeListAdapter == null)
      Intrinsics.b("circleTypeListAdapter"); 
    circleTypeListAdapter.c(paramList);
    this.k = paramList;
    ((CircleTypeListViewModel)k()).a(String.valueOf(((CircleTypeModel.DataBean)paramList.get(0)).id));
    CircleTypeListViewModel circleTypeListViewModel = (CircleTypeListViewModel)k();
    ActivityFragmentActive activityFragmentActive = w_();
    Intrinsics.a(activityFragmentActive, "fragmentActive");
    circleTypeListViewModel.a((IRequestHost)activityFragmentActive);
  }
  
  private final void b(CircleTypeModel.DataBean paramDataBean) {
    ViewUtils.a((RecyclerView)a(R.id.circleListRecycler), paramDataBean.lastPosition, paramDataBean.lastOffset);
  }
  
  private final void b(boolean paramBoolean) {
    if (!paramBoolean) {
      ((NoDataAndLoadFailView)a(R.id.classNoDataView)).b();
      return;
    } 
    ((NoDataAndLoadFailView)a(R.id.classNoDataView)).c();
  }
  
  public int a() {
    return this.n;
  }
  
  public View a(int paramInt) {
    if (this.o == null)
      this.o = new HashMap<Object, Object>(); 
    View view2 = (View)this.o.get(Integer.valueOf(paramInt));
    View view1 = view2;
    if (view2 == null) {
      view1 = getView();
      if (view1 == null)
        return null; 
      view1 = view1.findViewById(paramInt);
      this.o.put(Integer.valueOf(paramInt), view1);
    } 
    return view1;
  }
  
  public void a(boolean paramBoolean) {
    ((SmartRefreshLayout)a(R.id.refreshLayout)).g();
    CircleNewListAdapter circleNewListAdapter = this.i;
    if (circleNewListAdapter == null)
      Intrinsics.b("circleListAdapter"); 
    circleNewListAdapter.l();
    if (paramBoolean) {
      NoDataAndLoadFailView noDataAndLoadFailView1 = this.f;
      if (noDataAndLoadFailView1 == null)
        Intrinsics.b("noDataView"); 
      noDataAndLoadFailView1.a();
      return;
    } 
    NoDataAndLoadFailView noDataAndLoadFailView = this.f;
    if (noDataAndLoadFailView == null)
      Intrinsics.b("noDataView"); 
    noDataAndLoadFailView.b();
  }
  
  public void p() {
    LiveData liveData = (LiveData)((CircleTypeListViewModel)k()).c();
    CircleTypeListFragment circleTypeListFragment = this;
    LifecycleExtKt.a((LifecycleOwner)this, liveData, new CircleTypeListFragment$liveDataObserver$1(circleTypeListFragment));
    LifecycleExtKt.a((LifecycleOwner)this, (LiveData)((CircleTypeListViewModel)k()).d(), new CircleTypeListFragment$liveDataObserver$2(circleTypeListFragment));
    LifecycleExtKt.a((LifecycleOwner)this, (LiveData)((CircleTypeListViewModel)k()).e(), new CircleTypeListFragment$liveDataObserver$3(circleTypeListFragment));
  }
  
  public void q() {
    if (getArguments() != null) {
      Bundle bundle2 = getArguments();
      if (bundle2 == null)
        Intrinsics.a(); 
      CircleConstants.CIRCLE_FROM_PAGE cIRCLE_FROM_PAGE2 = (CircleConstants.CIRCLE_FROM_PAGE)bundle2.getSerializable("circle_list_page");
      if (cIRCLE_FROM_PAGE2 == null)
        Intrinsics.a(); 
      this.g = cIRCLE_FROM_PAGE2;
      Bundle bundle1 = getArguments();
      if (bundle1 == null)
        Intrinsics.a(); 
      CircleConstants.CIRCLE_FROM_PAGE cIRCLE_FROM_PAGE1 = (CircleConstants.CIRCLE_FROM_PAGE)bundle1.getSerializable("circle_new_list_from_page");
      if (cIRCLE_FROM_PAGE1 == null)
        Intrinsics.a(); 
      this.h = cIRCLE_FROM_PAGE1;
    } 
    ((CommonTopTitleNoTrans)a(R.id.title)).a();
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)a(R.id.title);
    Context context3 = getContext();
    if (context3 == null)
      Intrinsics.a(); 
    Intrinsics.a(context3, "context!!");
    commonTopTitleNoTrans.setCenterText(context3.getResources().getString(2131757930));
    ((CommonTopTitleNoTrans)a(R.id.title)).setLeftClickListener(new CircleTypeListFragment$init$1(this));
    Context context2 = getContext();
    if (context2 == null)
      Intrinsics.a(); 
    Intrinsics.a(context2, "context!!");
    ActivityFragmentActive activityFragmentActive3 = w_();
    Intrinsics.a(activityFragmentActive3, "fragmentActive");
    this.i = new CircleNewListAdapter(context2, (IRequestHost)activityFragmentActive3, this.g);
    this.f = new NoDataAndLoadFailView(getContext());
    NoDataAndLoadFailView noDataAndLoadFailView1 = this.f;
    if (noDataAndLoadFailView1 == null)
      Intrinsics.b("noDataView"); 
    noDataAndLoadFailView1.setNoDataImg(2131232633);
    noDataAndLoadFailView1 = this.f;
    if (noDataAndLoadFailView1 == null)
      Intrinsics.b("noDataView"); 
    noDataAndLoadFailView1.setNoDataStr(2131758250);
    noDataAndLoadFailView1 = this.f;
    if (noDataAndLoadFailView1 == null)
      Intrinsics.b("noDataView"); 
    noDataAndLoadFailView1.setBtnStr(2131758628);
    noDataAndLoadFailView1 = this.f;
    if (noDataAndLoadFailView1 == null)
      Intrinsics.b("noDataView"); 
    noDataAndLoadFailView1.setFailBtnListener(new CircleTypeListFragment$init$2(this));
    noDataAndLoadFailView1 = this.f;
    if (noDataAndLoadFailView1 == null)
      Intrinsics.b("noDataView"); 
    noDataAndLoadFailView1.c();
    CircleNewListAdapter circleNewListAdapter1 = this.i;
    if (circleNewListAdapter1 == null)
      Intrinsics.b("circleListAdapter"); 
    NoDataAndLoadFailView noDataAndLoadFailView2 = this.f;
    if (noDataAndLoadFailView2 == null)
      Intrinsics.b("noDataView"); 
    circleNewListAdapter1.e((View)noDataAndLoadFailView2);
    ((SmartRefreshLayout)a(R.id.refreshLayout)).b(false);
    ((SmartRefreshLayout)a(R.id.refreshLayout)).a(new CircleTypeListFragment$init$3(this));
    circleNewListAdapter1 = this.i;
    if (circleNewListAdapter1 == null)
      Intrinsics.b("circleListAdapter"); 
    circleNewListAdapter1.a(new CircleTypeListFragment$init$4(this), (RecyclerView)a(R.id.circleListRecycler));
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    RecyclerView recyclerView2 = (RecyclerView)a(R.id.circleListRecycler);
    Intrinsics.a(recyclerView2, "circleListRecycler");
    CircleNewListAdapter circleNewListAdapter2 = this.i;
    if (circleNewListAdapter2 == null)
      Intrinsics.b("circleListAdapter"); 
    recyclerView2.setAdapter((RecyclerView.Adapter)circleNewListAdapter2);
    recyclerView2 = (RecyclerView)a(R.id.circleListRecycler);
    Intrinsics.a(recyclerView2, "circleListRecycler");
    recyclerView2.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    Context context1 = getContext();
    if (context1 == null)
      Intrinsics.a(); 
    Intrinsics.a(context1, "context!!");
    ActivityFragmentActive activityFragmentActive2 = w_();
    Intrinsics.a(activityFragmentActive2, "fragmentActive");
    this.j = new CircleTypeListAdapter(context1, (IRequestHost)activityFragmentActive2);
    ((NoDataAndLoadFailView)a(R.id.classNoDataView)).setNoDataImg(2131232633);
    ((NoDataAndLoadFailView)a(R.id.classNoDataView)).setNoDataStr(2131758250);
    ((NoDataAndLoadFailView)a(R.id.classNoDataView)).setBtnStr(2131758628);
    ((NoDataAndLoadFailView)a(R.id.classNoDataView)).setFailBtnListener(new CircleTypeListFragment$init$5(this));
    ((NoDataAndLoadFailView)a(R.id.classNoDataView)).c();
    RecyclerView recyclerView1 = (RecyclerView)a(R.id.typeListRecycler);
    Intrinsics.a(recyclerView1, "typeListRecycler");
    CircleTypeListAdapter circleTypeListAdapter2 = this.j;
    if (circleTypeListAdapter2 == null)
      Intrinsics.b("circleTypeListAdapter"); 
    recyclerView1.setAdapter((RecyclerView.Adapter)circleTypeListAdapter2);
    recyclerView1 = (RecyclerView)a(R.id.typeListRecycler);
    Intrinsics.a(recyclerView1, "typeListRecycler");
    recyclerView1.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
    CircleTypeListViewModel circleTypeListViewModel = (CircleTypeListViewModel)k();
    ActivityFragmentActive activityFragmentActive1 = w_();
    Intrinsics.a(activityFragmentActive1, "fragmentActive");
    circleTypeListViewModel.a((IRequestHost)activityFragmentActive1);
    CircleTypeListAdapter circleTypeListAdapter1 = this.j;
    if (circleTypeListAdapter1 == null)
      Intrinsics.b("circleTypeListAdapter"); 
    circleTypeListAdapter1.a(new CircleTypeListFragment$init$6(this));
  }
  
  public void s() {
    CircleNewListAdapter circleNewListAdapter = this.i;
    if (circleNewListAdapter == null)
      Intrinsics.b("circleListAdapter"); 
    circleNewListAdapter.c(true);
  }
  
  public void t() {
    CircleNewListAdapter circleNewListAdapter = this.i;
    if (circleNewListAdapter == null)
      Intrinsics.b("circleListAdapter"); 
    circleNewListAdapter.c(false);
  }
  
  public void u() {
    HashMap hashMap = this.o;
    if (hashMap != null)
      hashMap.clear(); 
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000 \n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\036\020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\b¨\006\n"}, d2 = {"Lcom/soft/blued/ui/circle/fragment/CircleTypeListFragment$Companion;", "", "()V", "show", "", "context", "Landroid/content/Context;", "circleListPage", "Lcom/soft/blued/ui/circle/model/CircleConstants$CIRCLE_FROM_PAGE;", "circleFromPage", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class Companion {
    private Companion() {}
    
    public final void a(Context param1Context, CircleConstants.CIRCLE_FROM_PAGE param1CIRCLE_FROM_PAGE1, CircleConstants.CIRCLE_FROM_PAGE param1CIRCLE_FROM_PAGE2) {
      Intrinsics.b(param1Context, "context");
      Intrinsics.b(param1CIRCLE_FROM_PAGE1, "circleListPage");
      Intrinsics.b(param1CIRCLE_FROM_PAGE2, "circleFromPage");
      Bundle bundle = new Bundle();
      bundle.putSerializable("circle_list_page", (Serializable)param1CIRCLE_FROM_PAGE1);
      bundle.putSerializable("circle_new_list_from_page", (Serializable)param1CIRCLE_FROM_PAGE2);
      TerminalActivity.d(param1Context, CircleTypeListFragment.class, bundle);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class CircleTypeListFragment$init$1 implements View.OnClickListener {
    CircleTypeListFragment$init$1(CircleTypeListFragment param1CircleTypeListFragment) {}
    
    public final void onClick(View param1View) {
      FragmentActivity fragmentActivity = this.a.getActivity();
      if (fragmentActivity == null)
        Intrinsics.a(); 
      fragmentActivity.finish();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class CircleTypeListFragment$init$2 implements View.OnClickListener {
    CircleTypeListFragment$init$2(CircleTypeListFragment param1CircleTypeListFragment) {}
    
    public final void onClick(View param1View) {
      CircleTypeListFragment.a(this.a).j();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "onRefresh"}, k = 3, mv = {1, 1, 16})
  static final class CircleTypeListFragment$init$3 implements OnRefreshListener {
    CircleTypeListFragment$init$3(CircleTypeListFragment param1CircleTypeListFragment) {}
    
    public final void onRefresh(RefreshLayout param1RefreshLayout) {
      Intrinsics.b(param1RefreshLayout, "it");
      CircleTypeListViewModel circleTypeListViewModel = CircleTypeListFragment.a(this.a);
      ActivityFragmentActive activityFragmentActive = this.a.w_();
      Intrinsics.a(activityFragmentActive, "fragmentActive");
      circleTypeListViewModel.a((IRequestHost)activityFragmentActive);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "onLoadMoreRequested"}, k = 3, mv = {1, 1, 16})
  static final class CircleTypeListFragment$init$4 implements BaseQuickAdapter.RequestLoadMoreListener {
    CircleTypeListFragment$init$4(CircleTypeListFragment param1CircleTypeListFragment) {}
    
    public final void onLoadMoreRequested() {
      CircleTypeListViewModel circleTypeListViewModel = CircleTypeListFragment.a(this.a);
      ActivityFragmentActive activityFragmentActive = this.a.w_();
      Intrinsics.a(activityFragmentActive, "fragmentActive");
      circleTypeListViewModel.b((IRequestHost)activityFragmentActive);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class CircleTypeListFragment$init$5 implements View.OnClickListener {
    CircleTypeListFragment$init$5(CircleTypeListFragment param1CircleTypeListFragment) {}
    
    public final void onClick(View param1View) {
      CircleTypeListFragment.a(this.a).j();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000$\n\000\n\002\020\002\n\000\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\000\020\000\032\0020\00128\020\002\0324\022\f\022\n \005*\004\030\0010\0040\004\022\f\022\n \005*\004\030\0010\0060\006 \005*\017\022\002\b\003\022\002\b\003\030\0010\003¨\006\0010\003¨\006\0012\016\020\007\032\n \005*\004\030\0010\b0\b2\006\020\t\032\0020\nH\n¢\006\002\b\013"}, d2 = {"<anonymous>", "", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "kotlin.jvm.PlatformType", "Lcom/chad/library/adapter/base/BaseViewHolder;", "view", "Landroid/view/View;", "position", "", "onItemClick"}, k = 3, mv = {1, 1, 16})
  static final class CircleTypeListFragment$init$6 implements BaseQuickAdapter.OnItemClickListener {
    CircleTypeListFragment$init$6(CircleTypeListFragment param1CircleTypeListFragment) {}
    
    public final void onItemClick(BaseQuickAdapter<Object, BaseViewHolder> param1BaseQuickAdapter, View param1View, int param1Int) {
      Integer integer;
      byte b1;
      if (CircleTypeListFragment.b(this.a).b(param1Int) == null)
        return; 
      CircleTypeListFragment.b(this.a).a(param1Int);
      CircleTypeListFragment.a(this.a, param1Int);
      CircleTypeListFragment.b(this.a).notifyDataSetChanged();
      CircleTypeListFragment circleTypeListFragment = this.a;
      CircleTypeListFragment.a(circleTypeListFragment, CircleTypeListFragment.c(circleTypeListFragment).get(CircleTypeListFragment.d(this.a)));
      CircleTypeListFragment.b(this.a, param1Int);
      CircleTypeListViewModel circleTypeListViewModel = CircleTypeListFragment.a(this.a);
      CircleTypeModel.DataBean dataBean1 = CircleTypeListFragment.b(this.a).b(param1Int);
      param1View = null;
      if (dataBean1 != null) {
        integer = Integer.valueOf(dataBean1.id);
      } else {
        dataBean1 = null;
      } 
      circleTypeListViewModel.a(String.valueOf(dataBean1));
      circleTypeListViewModel = CircleTypeListFragment.a(this.a);
      dataBean1 = CircleTypeListFragment.b(this.a).b(param1Int);
      if (dataBean1 != null) {
        integer = Integer.valueOf(dataBean1.id);
      } else {
        dataBean1 = null;
      } 
      byte b2 = -1;
      if (dataBean1 != null) {
        b1 = dataBean1.intValue();
      } else {
        b1 = -1;
      } 
      circleTypeListViewModel.a(b1);
      this.a.t();
      if (CircleTypeListFragment.a(this.a).h()) {
        CircleTypeListFragment.a(this.a).c(true);
        CircleTypeListFragment.a(this.a).i();
      } else {
        CircleTypeListFragment.e(this.a).c();
        CircleTypeListFragment.f(this.a).c(null);
        ((SmartRefreshLayout)this.a.a(R.id.refreshLayout)).i();
      } 
      CircleNewListAdapter circleNewListAdapter = CircleTypeListFragment.f(this.a);
      CircleTypeModel.DataBean dataBean2 = CircleTypeListFragment.b(this.a).b(param1Int);
      View view = param1View;
      if (dataBean2 != null)
        integer = Integer.valueOf(dataBean2.id); 
      param1Int = b2;
      if (integer != null)
        param1Int = integer.intValue(); 
      circleNewListAdapter.a(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleTypeListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */