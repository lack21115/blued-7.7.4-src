package com.soft.blued.ui.notify.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.das.client.feed.FeedProtos;
import com.google.android.material.appbar.AppBarLayout;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.discover.fragment.ViewpointNoticeLikeListFragment;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg_group.fragment.GroupNoticeFragment;
import com.soft.blued.ui.notify.model.FeedNotice;
import com.soft.blued.ui.notify.model.ViewpointNoticeCount;
import com.soft.blued.ui.notify.presenter.SystemNoticePresenter;
import com.soft.blued.utils.RefreshUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SystemNoticeFragment extends MvpFragment<SystemNoticePresenter> implements BluedSkinSupportable, HomeTabClick.TabClickListener {
  @BindView(2131296447)
  AppBarLayout appbar;
  
  @BindView(2131296843)
  CoordinatorLayout coordinator;
  
  private SystemNoticeAdapter d;
  
  private NoDataAndLoadFailView e;
  
  private List<QBadgeContainer> f = new ArrayList<QBadgeContainer>();
  
  private boolean g = false;
  
  @BindView(2131297691)
  ImageView ivAttention;
  
  @BindView(2131297723)
  ImageView ivCircle;
  
  @BindView(2131297783)
  ImageView ivGroup;
  
  @BindView(2131297824)
  ImageView ivLike;
  
  @BindView(2131298711)
  LinearLayout llAttention;
  
  @BindView(2131298745)
  LinearLayout llCircle;
  
  @BindView(2131298830)
  LinearLayout llGroup;
  
  @BindView(2131298911)
  LinearLayout llLike;
  
  @BindView(2131298914)
  View llLine;
  
  @BindView(2131298947)
  LinearLayout llMenu;
  
  @BindView(2131299598)
  RecyclerView recycleView;
  
  @BindView(2131300012)
  SmartRefreshLayout srlList;
  
  @BindView(2131300534)
  QBadgeContainer tvAttentionCount;
  
  @BindView(2131300628)
  QBadgeContainer tvCircleCount;
  
  @BindView(2131300818)
  QBadgeContainer tvGroupCount;
  
  @BindView(2131300954)
  QBadgeContainer tvLikeCount;
  
  private void a(int paramInt) {
    QBadgeContainer qBadgeContainer = this.tvAttentionCount;
    if (qBadgeContainer == null)
      return; 
    qBadgeContainer.a(paramInt);
  }
  
  private void b(int paramInt) {
    QBadgeContainer qBadgeContainer = this.tvLikeCount;
    if (qBadgeContainer == null)
      return; 
    qBadgeContainer.a(paramInt);
  }
  
  private void b(ViewpointNoticeCount paramViewpointNoticeCount) {
    a(paramViewpointNoticeCount.followers);
    b(paramViewpointNoticeCount.liked);
    c(paramViewpointNoticeCount.groups);
    d(paramViewpointNoticeCount.circle);
  }
  
  private void b(boolean paramBoolean) {
    if (this.d.n().size() <= 0) {
      if (paramBoolean) {
        this.e.a();
        return;
      } 
      this.e.b();
    } 
  }
  
  private void c(int paramInt) {
    QBadgeContainer qBadgeContainer = this.tvGroupCount;
    if (qBadgeContainer == null)
      return; 
    qBadgeContainer.a(paramInt);
  }
  
  private void d(int paramInt) {
    QBadgeContainer qBadgeContainer = this.tvCircleCount;
    if (qBadgeContainer == null)
      return; 
    qBadgeContainer.a(paramInt);
  }
  
  public boolean A() {
    return true;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    LiveEventBus.get("notice_need_refresh", Void.class).observe((LifecycleOwner)this, new Observer<Void>(this) {
          public void a(Void param1Void) {
            if (this.a.getUserVisibleHint())
              ((SystemNoticePresenter)this.a.s()).e(); 
          }
        });
    this.f.clear();
    this.tvAttentionCount.a((View)this.llAttention);
    this.tvAttentionCount.d(8388661);
    this.tvAttentionCount.a(BluedSkinUtils.a(getContext(), 2131100728), 1.0F, true);
    this.tvAttentionCount.a("");
    this.f.add(this.tvAttentionCount);
    this.tvLikeCount.a((View)this.llLike);
    this.tvLikeCount.d(8388661);
    this.tvLikeCount.a(BluedSkinUtils.a(getContext(), 2131100728), 1.0F, true);
    this.tvLikeCount.a("");
    this.f.add(this.tvLikeCount);
    this.tvGroupCount.a((View)this.llGroup);
    this.tvGroupCount.d(8388661);
    this.tvGroupCount.a(BluedSkinUtils.a(getContext(), 2131100728), 1.0F, true);
    this.tvGroupCount.a("");
    this.f.add(this.tvGroupCount);
    this.tvCircleCount.a((View)this.llCircle);
    this.tvCircleCount.d(8388661);
    this.tvCircleCount.a(BluedSkinUtils.a(getContext(), 2131100728), 1.0F, true);
    this.tvCircleCount.a("");
    this.f.add(this.tvCircleCount);
    this.d = new SystemNoticeAdapter(getContext(), (IRequestHost)w_(), getFragmentManager(), true);
    this.d.a(new SystemNoticeAdapter.OnReadListener(this) {
          public void a() {
            ((SystemNoticePresenter)this.a.s()).h.c = SystemNoticeFragment.a(this.a).b();
            ((SystemNoticePresenter)this.a.s()).b(null);
          }
        });
    this.e = new NoDataAndLoadFailView(getContext());
    this.d.e((View)this.e);
    ((SystemNoticePresenter)s()).a(this.d);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    this.recycleView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.recycleView.setAdapter((RecyclerView.Adapter)this.d);
    this.srlList.a(new OnRefreshListener(this) {
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((SystemNoticePresenter)this.a.s()).e();
          }
        });
    this.srlList.a(new OnLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((SystemNoticePresenter)this.a.s()).f();
          }
        });
  }
  
  public void a(ViewpointNoticeCount paramViewpointNoticeCount) {
    if (paramViewpointNoticeCount != null) {
      b(paramViewpointNoticeCount);
      if (paramViewpointNoticeCount.isHttp) {
        paramViewpointNoticeCount.isHttp = false;
        ((SystemNoticePresenter)s()).b(paramViewpointNoticeCount);
      } 
    } 
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    if (paramString == null)
      return; 
    byte b = -1;
    int i = paramString.hashCode();
    if (i != -1290256561) {
      if (i == 623698297 && paramString.equals("_load_type_loadmore_"))
        b = 1; 
    } else if (paramString.equals("_load_type_refresh_")) {
      b = 0;
    } 
    if (b == 0 || b == 1) {
      this.srlList.g();
      this.srlList.h();
    } 
    b(paramBoolean);
  }
  
  protected void a(List<FeedNotice> paramList) {
    this.d.c(paramList);
    ((SystemNoticePresenter)s()).h.c = this.d.b();
    ((SystemNoticePresenter)s()).b(null);
  }
  
  public void aL_() {
    super.aL_();
    this.e = null;
  }
  
  public void c(String paramString) {
    if ("msg".equals(paramString) && this.srlList != null) {
      RecyclerView recyclerView = this.recycleView;
      if (recyclerView != null) {
        recyclerView.scrollToPosition(0);
        RefreshUtils.a(this.appbar);
        this.srlList.i();
      } 
    } 
  }
  
  public void d(String paramString) {
    c(paramString);
  }
  
  public void g() {
    List<QBadgeContainer> list = this.f;
    if (list != null) {
      if (list.isEmpty())
        return; 
      Iterator<QBadgeContainer> iterator = this.f.iterator();
      while (iterator.hasNext())
        ((QBadgeContainer)iterator.next()).a(BluedSkinUtils.a(getContext(), 2131100728), 1.0F, true); 
    } 
  }
  
  protected void k() {
    this.d.c((List)null);
    ((SystemNoticePresenter)s()).h.c = 0;
    ((SystemNoticePresenter)s()).b(null);
  }
  
  protected void l() {
    AppMethods.d(2131756206);
    this.d.c((List)null);
    this.e.a();
  }
  
  protected void m() {
    this.recycleView.scrollToPosition(0);
    this.srlList.i();
  }
  
  protected void n() {
    this.d.c();
  }
  
  public void onPause() {
    super.onPause();
    ((SystemNoticePresenter)s()).i = false;
  }
  
  public void onResume() {
    super.onResume();
    ((SystemNoticePresenter)s()).i = true;
  }
  
  @OnClick({2131300534, 2131300954, 2131300818, 2131300628})
  public void onViewClicked(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131300954:
        LiveEventBus.get("new_system_msg_read_count").post(Integer.valueOf(this.tvLikeCount.getBadgeNumber()));
        EventTrackFeed.b(FeedProtos.Event.MSG_NOTICE_LIKE_CLICK);
        this.tvLikeCount.a("");
        ViewpointNoticeLikeListFragment.a(getContext());
        ((SystemNoticePresenter)s()).p();
        return;
      case 2131300818:
        LiveEventBus.get("new_system_msg_read_count").post(Integer.valueOf(this.tvGroupCount.getBadgeNumber()));
        this.tvGroupCount.a("");
        TerminalActivity.d(getContext(), GroupNoticeFragment.class, null);
        ((SystemNoticePresenter)s()).q();
        return;
      case 2131300628:
        LiveEventBus.get("new_system_msg_read_count").post(Integer.valueOf(this.tvCircleCount.getBadgeNumber()));
        EventTrackFeed.b(FeedProtos.Event.MSG_NOTICE_CIRCLE_CLICK);
        this.tvCircleCount.a("");
        CircleNotifyListFragment.a(getContext());
        ((SystemNoticePresenter)s()).r();
        return;
      case 2131300534:
        break;
    } 
    LiveEventBus.get("new_system_msg_read_count").post(Integer.valueOf(this.tvAttentionCount.getBadgeNumber()));
    EventTrackFeed.b(FeedProtos.Event.MSG_NOTICE_FOLLOW_CLICK);
    this.tvAttentionCount.a("");
    ChatHelperV4.a().a(getContext(), 5L, 10L);
    ChatManager.getInstance().ignoredNoReadNum((short)1, 5L);
    ((SystemNoticePresenter)s()).o();
  }
  
  public int p() {
    return 2131493328;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (getActivity() != null) {
      if (!(getActivity() instanceof HomeActivity))
        return; 
      if (paramBoolean && ((HomeActivity)getActivity()).i() == 0 && this.srlList != null) {
        if (this.g)
          ((SystemNoticePresenter)s()).e(); 
        this.g = true;
      } 
      ((SystemNoticePresenter)s()).j = paramBoolean;
    } 
  }
  
  public void u() {
    this.srlList.i();
  }
  
  public void x() {
    super.x();
    this.srlList.b(true);
  }
  
  public void y() {
    super.y();
    this.srlList.b(false);
  }
  
  public boolean z() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\fragment\SystemNoticeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */