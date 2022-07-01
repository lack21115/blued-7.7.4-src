package com.soft.blued.ui.circle.fragment;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.R;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.ui.circle.adapter.CircleListAdapter;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.ui.circle.vm.CircleMyManagementViewModel;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\000@\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\002\b\004\n\002\020\013\n\002\b\003\n\002\020 \n\002\030\002\n\002\b\002\030\000 \0302\b\022\004\022\0020\0020\001:\001\030B\005¢\006\002\020\003J\b\020\f\032\0020\rH\024J\b\020\016\032\0020\rH\024J\b\020\017\032\0020\rH\024J\020\020\020\032\0020\r2\006\020\021\032\0020\022H\024J\b\020\023\032\0020\rH\024J\026\020\024\032\0020\r2\f\020\025\032\b\022\004\022\0020\0270\026H\002R\016\020\004\032\0020\005X.¢\006\002\n\000R\024\020\006\032\0020\007XD¢\006\b\n\000\032\004\b\b\020\tR\016\020\n\032\0020\013X.¢\006\002\n\000¨\006\031"}, d2 = {"Lcom/soft/blued/ui/circle/fragment/CircleMyManagementFragment;", "Lcom/blued/android/module/common/base/mvvm/MVVMBaseFragment;", "Lcom/soft/blued/ui/circle/vm/CircleMyManagementViewModel;", "()V", "circleListAdapter", "Lcom/soft/blued/ui/circle/adapter/CircleListAdapter;", "layoutId", "", "getLayoutId", "()I", "noDataView", "Lcom/soft/blued/customview/NoDataAndLoadFailView;", "hasMore", "", "init", "liveDataObserver", "loadFinish", "success", "", "noMore", "setDataList", "dataList", "", "Lcom/soft/blued/ui/circle/model/MyCircleModel;", "Companion", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class CircleMyManagementFragment extends MVVMBaseFragment<CircleMyManagementViewModel> {
  public static final Companion e = new Companion(null);
  
  private final int f = 2131493098;
  
  private CircleListAdapter g;
  
  private NoDataAndLoadFailView h;
  
  private HashMap i;
  
  private final void a(List<? extends MyCircleModel> paramList) {
    if (((CircleMyManagementViewModel)k()).d() == 1) {
      CircleListAdapter circleListAdapter1 = this.g;
      if (circleListAdapter1 == null)
        Intrinsics.b("circleListAdapter"); 
      circleListAdapter1.c(paramList);
      return;
    } 
    CircleListAdapter circleListAdapter = this.g;
    if (circleListAdapter == null)
      Intrinsics.b("circleListAdapter"); 
    circleListAdapter.a(paramList);
  }
  
  public int a() {
    return this.f;
  }
  
  public View a(int paramInt) {
    if (this.i == null)
      this.i = new HashMap<Object, Object>(); 
    View view2 = (View)this.i.get(Integer.valueOf(paramInt));
    View view1 = view2;
    if (view2 == null) {
      view1 = getView();
      if (view1 == null)
        return null; 
      view1 = view1.findViewById(paramInt);
      this.i.put(Integer.valueOf(paramInt), view1);
    } 
    return view1;
  }
  
  public void a(boolean paramBoolean) {
    ((SmartRefreshLayout)a(R.id.refreshLayout)).g();
    CircleListAdapter circleListAdapter = this.g;
    if (circleListAdapter == null)
      Intrinsics.b("circleListAdapter"); 
    circleListAdapter.l();
    if (paramBoolean) {
      NoDataAndLoadFailView noDataAndLoadFailView1 = this.h;
      if (noDataAndLoadFailView1 == null)
        Intrinsics.b("noDataView"); 
      noDataAndLoadFailView1.a();
      return;
    } 
    NoDataAndLoadFailView noDataAndLoadFailView = this.h;
    if (noDataAndLoadFailView == null)
      Intrinsics.b("noDataView"); 
    noDataAndLoadFailView.b();
  }
  
  public void p() {
    LifecycleExtKt.a((LifecycleOwner)this, (LiveData)((CircleMyManagementViewModel)k()).c(), new CircleMyManagementFragment$liveDataObserver$1(this));
  }
  
  public void q() {
    ((CommonTopTitleNoTrans)a(R.id.title)).a();
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)a(R.id.title);
    Context context = getContext();
    if (context == null)
      Intrinsics.a(); 
    Intrinsics.a(context, "context!!");
    commonTopTitleNoTrans.setCenterText(context.getResources().getString(2131757838));
    ((CommonTopTitleNoTrans)a(R.id.title)).setLeftClickListener(new CircleMyManagementFragment$init$1(this));
    this.g = new CircleListAdapter(getContext(), CircleConstants.CIRCLE_FROM_PAGE.MANAGED_CIRCLE, (IRequestHost)w_(), null);
    this.h = new NoDataAndLoadFailView(getContext());
    NoDataAndLoadFailView noDataAndLoadFailView1 = this.h;
    if (noDataAndLoadFailView1 == null)
      Intrinsics.b("noDataView"); 
    noDataAndLoadFailView1.setNoDataImg(2131232633);
    noDataAndLoadFailView1 = this.h;
    if (noDataAndLoadFailView1 == null)
      Intrinsics.b("noDataView"); 
    noDataAndLoadFailView1.setNoDataStr(2131758229);
    noDataAndLoadFailView1 = this.h;
    if (noDataAndLoadFailView1 == null)
      Intrinsics.b("noDataView"); 
    noDataAndLoadFailView1.c();
    CircleListAdapter circleListAdapter1 = this.g;
    if (circleListAdapter1 == null)
      Intrinsics.b("circleListAdapter"); 
    NoDataAndLoadFailView noDataAndLoadFailView2 = this.h;
    if (noDataAndLoadFailView2 == null)
      Intrinsics.b("noDataView"); 
    circleListAdapter1.e((View)noDataAndLoadFailView2);
    ((SmartRefreshLayout)a(R.id.refreshLayout)).b(false);
    ((SmartRefreshLayout)a(R.id.refreshLayout)).a(new CircleMyManagementFragment$init$2(this));
    circleListAdapter1 = this.g;
    if (circleListAdapter1 == null)
      Intrinsics.b("circleListAdapter"); 
    circleListAdapter1.a(new CircleMyManagementFragment$init$3(this), (RecyclerView)a(R.id.recycleView));
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    RecyclerView recyclerView = (RecyclerView)a(R.id.recycleView);
    Intrinsics.a(recyclerView, "recycleView");
    CircleListAdapter circleListAdapter2 = this.g;
    if (circleListAdapter2 == null)
      Intrinsics.b("circleListAdapter"); 
    recyclerView.setAdapter((RecyclerView.Adapter)circleListAdapter2);
    recyclerView = (RecyclerView)a(R.id.recycleView);
    Intrinsics.a(recyclerView, "recycleView");
    recyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    ((CircleMyManagementViewModel)k()).e();
  }
  
  public void s() {
    CircleListAdapter circleListAdapter = this.g;
    if (circleListAdapter == null)
      Intrinsics.b("circleListAdapter"); 
    circleListAdapter.c(true);
  }
  
  public void t() {
    CircleListAdapter circleListAdapter = this.g;
    if (circleListAdapter == null)
      Intrinsics.b("circleListAdapter"); 
    circleListAdapter.c(false);
  }
  
  public void u() {
    HashMap hashMap = this.i;
    if (hashMap != null)
      hashMap.clear(); 
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\006¨\006\007"}, d2 = {"Lcom/soft/blued/ui/circle/fragment/CircleMyManagementFragment$Companion;", "", "()V", "show", "", "context", "Landroid/content/Context;", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class Companion {
    private Companion() {}
    
    public final void a(Context param1Context) {
      Intrinsics.b(param1Context, "context");
      TerminalActivity.d(param1Context, CircleMyManagementFragment.class, null);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class CircleMyManagementFragment$init$1 implements View.OnClickListener {
    CircleMyManagementFragment$init$1(CircleMyManagementFragment param1CircleMyManagementFragment) {}
    
    public final void onClick(View param1View) {
      FragmentActivity fragmentActivity = this.a.getActivity();
      if (fragmentActivity == null)
        Intrinsics.a(); 
      fragmentActivity.finish();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "onRefresh"}, k = 3, mv = {1, 1, 16})
  static final class CircleMyManagementFragment$init$2 implements OnRefreshListener {
    CircleMyManagementFragment$init$2(CircleMyManagementFragment param1CircleMyManagementFragment) {}
    
    public final void onRefresh(RefreshLayout param1RefreshLayout) {
      Intrinsics.b(param1RefreshLayout, "it");
      CircleMyManagementFragment.a(this.a).e();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "onLoadMoreRequested"}, k = 3, mv = {1, 1, 16})
  static final class CircleMyManagementFragment$init$3 implements BaseQuickAdapter.RequestLoadMoreListener {
    CircleMyManagementFragment$init$3(CircleMyManagementFragment param1CircleMyManagementFragment) {}
    
    public final void onLoadMoreRequested() {
      CircleMyManagementFragment.a(this.a).f();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleMyManagementFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */