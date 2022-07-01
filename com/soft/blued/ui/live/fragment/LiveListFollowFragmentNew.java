package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.manager.RecommendDataListener;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.observer.LiveListPositionObserver;
import com.blued.android.module.live_china.observer.LiveListRefreshObserver;
import com.blued.das.live.LiveProtos;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackLive;
import com.soft.blued.push.PushChecker;
import com.soft.blued.ui.discover.observer.LiveListSetSelectedTab;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.adapter.LiveFollowItemAdapter;
import com.soft.blued.ui.live.adapter.LiveFollowRecommendAdapter;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.model.LiveRecommendModel;
import com.soft.blued.ui.live.presenter.LiveFollowPresenter;
import com.soft.blued.ui.live.utils.LiveListDataUtils;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.List;

public class LiveListFollowFragmentNew extends MvpFragment<LiveFollowPresenter> implements View.OnClickListener, LiveListPositionObserver.ILiveListPositionObserver, HomeTabClick.TabClickListener {
  public long d;
  
  private Context e;
  
  private LiveFollowItemAdapter f;
  
  private LiveFollowRecommendAdapter g;
  
  private boolean h;
  
  private boolean i;
  
  @BindView(2131297729)
  ImageView ivClose;
  
  @BindView(2131297804)
  ImageView ivIcon;
  
  private boolean j;
  
  @BindView(2131298571)
  TextView liveRecommendChange;
  
  @BindView(2131298573)
  LinearLayout liveRecommendLayout;
  
  @BindView(2131298574)
  LinearLayout liveRecommendTop;
  
  @BindView(2131298477)
  View live_no_follow_banner;
  
  @BindView(2131298984)
  NoDataAndLoadFailView llNoInternet;
  
  @BindView(2131299605)
  RecyclerView mRecyclerView;
  
  @BindView(2131299301)
  View msg_toast;
  
  @BindView(2131299614)
  SmartRefreshLayout refreshFollowList;
  
  @BindView(2131299617)
  SmartRefreshLayout refreshNewUserList;
  
  @BindView(2131299772)
  RecyclerView rvFollowList;
  
  @BindView(2131300890)
  TextView tvHint;
  
  private void E() {
    this.refreshFollowList.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((LiveFollowPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((LiveFollowPresenter)this.a.s()).e();
            LiveListRefreshObserver.a().b();
          }
        });
    this.refreshNewUserList.b(false);
    this.refreshNewUserList.a(new OnRefreshListener(this) {
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((LiveFollowPresenter)this.a.s()).e();
          }
        });
    this.f.b(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            ((LiveFollowPresenter)this.a.s()).m();
          }
        });
    this.f.a(new BaseQuickAdapter.OnItemLongClickListener(this) {
          public boolean a(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            ((LiveFollowPresenter)this.a.s()).a(LiveListFollowFragmentNew.a(this.a).n().get(param1Int));
            return true;
          }
        });
    this.f.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            LiveListFollowFragmentNew.a(this.a, param1Int);
          }
        });
    this.g.a(new RecommendDataListener(this) {
          public void a() {
            ((LiveFollowPresenter)this.a.s()).m();
          }
        });
  }
  
  private void F() {
    if (this.f.b().size() < 5) {
      PushChecker.a().a(getContext(), 2, MessageProtos.WarnTime.LIVE_FIRST);
      return;
    } 
    this.rvFollowList.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
          public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
            super.onScrollStateChanged(param1RecyclerView, param1Int);
            if (param1Int == 1)
              PushChecker.a().a(this.a.getContext(), 2, MessageProtos.WarnTime.LIVE_FIRST); 
          }
          
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
          }
        });
  }
  
  private void a(int paramInt) {
    BluedLiveListData bluedLiveListData = this.f.n().get(paramInt);
    if (bluedLiveListData != null) {
      String str1;
      String str2;
      if (bluedLiveListData.anchor != null) {
        str1 = bluedLiveListData.anchor.name;
        str2 = bluedLiveListData.anchor.avatar;
      } else {
        str1 = "";
        str2 = str1;
      } 
      paramInt = bluedLiveListData.livetype;
      String str3 = bluedLiveListData.uid;
      if (paramInt == 0) {
        UserInfoFragmentNew.a(this.e, str3, "");
        return;
      } 
      EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_CLICK, "follow_list", bluedLiveListData.lid, bluedLiveListData.uid);
      LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(bluedLiveListData.lid, 0L), bluedLiveListData.screen_pattern, "followed", bluedLiveListData.uid, str1, str2, 0);
      liveRoomData.live_url = bluedLiveListData.live_play;
      LiveRoomInfoChannel.a(this.e, liveRoomData, -1, LiveRoomInfoChannel.a(this.f.a(), "followed"));
    } 
  }
  
  private void m() {
    this.f = new LiveFollowItemAdapter((BaseFragment)this);
  }
  
  private void n() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.e);
    linearLayoutManager.setOrientation(1);
    this.rvFollowList.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.rvFollowList.setAdapter((RecyclerView.Adapter)this.f);
    this.g = new LiveFollowRecommendAdapter((IRequestHost)w_(), this.e);
    this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(this.e, 3));
    this.mRecyclerView.setAdapter((RecyclerView.Adapter)this.g);
    E();
    this.liveRecommendChange.setOnClickListener(this);
    PushChecker.a().a(this.msg_toast, 1, MessageProtos.WarnTime.TOAST_LIVE);
  }
  
  public boolean A() {
    return true;
  }
  
  public void a(int paramInt, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyLiveListPosition position = ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" ; sessionId = ");
    stringBuilder.append(paramLong);
    Logger.e("LiveListFollowFragmentNew", new Object[] { stringBuilder.toString() });
    if (this.rvFollowList == null)
      return; 
    if (paramInt == -1)
      return; 
    paramInt = LiveListDataUtils.a(paramLong, this.f.a());
    this.rvFollowList.post(new Runnable(this, paramInt) {
          public void run() {
            this.b.rvFollowList.requestFocus();
            this.b.rvFollowList.scrollToPosition(this.a + 1);
          }
        });
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    m();
    n();
    ((LiveFollowPresenter)s()).e();
  }
  
  public void a(BluedLiveListData paramBluedLiveListData) {
    this.f.n().remove(paramBluedLiveListData);
    this.f.notifyDataSetChanged();
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
    if (b != 0) {
      if (b != 1)
        return; 
      this.refreshFollowList.h();
      return;
    } 
    this.refreshFollowList.g();
  }
  
  public void a(List<BluedLiveListData> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: getfield refreshNewUserList : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   4: bipush #8
    //   6: invokevirtual setVisibility : (I)V
    //   9: aload_0
    //   10: getfield refreshFollowList : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   13: iconst_0
    //   14: invokevirtual setVisibility : (I)V
    //   17: ldc_w 'LiveListFollowFragmentNew'
    //   20: iconst_1
    //   21: anewarray java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: ldc_w 'setVisibility VISIBLE'
    //   29: aastore
    //   30: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aload_1
    //   34: ifnull -> 128
    //   37: aload_1
    //   38: invokeinterface iterator : ()Ljava/util/Iterator;
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface hasNext : ()Z
    //   50: ifeq -> 82
    //   53: aload_3
    //   54: invokeinterface next : ()Ljava/lang/Object;
    //   59: checkcast com/soft/blued/ui/live/model/BluedLiveListData
    //   62: astore #4
    //   64: aload #4
    //   66: ifnull -> 44
    //   69: aload #4
    //   71: getfield livetype : I
    //   74: ifle -> 44
    //   77: iconst_1
    //   78: istore_2
    //   79: goto -> 84
    //   82: iconst_0
    //   83: istore_2
    //   84: iload_2
    //   85: ifeq -> 100
    //   88: aload_0
    //   89: getfield live_no_follow_banner : Landroid/view/View;
    //   92: bipush #8
    //   94: invokevirtual setVisibility : (I)V
    //   97: goto -> 108
    //   100: aload_0
    //   101: getfield live_no_follow_banner : Landroid/view/View;
    //   104: iconst_0
    //   105: invokevirtual setVisibility : (I)V
    //   108: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveDataListManager;
    //   111: aload_1
    //   112: ldc 'followed'
    //   114: invokestatic a : (Ljava/util/List;Ljava/lang/String;)Ljava/util/List;
    //   117: invokevirtual c : (Ljava/util/List;)V
    //   120: aload_0
    //   121: getfield f : Lcom/soft/blued/ui/live/adapter/LiveFollowItemAdapter;
    //   124: aload_1
    //   125: invokevirtual a : (Ljava/util/List;)V
    //   128: aload_1
    //   129: ifnull -> 150
    //   132: aload_0
    //   133: invokevirtual s : ()Lcom/blued/android/framework/ui/mvp/MvpPresenter;
    //   136: checkcast com/soft/blued/ui/live/presenter/LiveFollowPresenter
    //   139: getfield h : I
    //   142: iconst_1
    //   143: if_icmpne -> 150
    //   146: aload_0
    //   147: invokespecial F : ()V
    //   150: return
  }
  
  public void b(List<LiveRecommendModel> paramList) {
    if (this.g != null && paramList != null) {
      if (paramList.isEmpty())
        return; 
      this.refreshFollowList.setVisibility(8);
      this.refreshNewUserList.setVisibility(0);
      this.g.a(paramList);
      this.refreshNewUserList.g();
    } 
  }
  
  public void c(String paramString) {
    if (this.refreshNewUserList != null && this.refreshFollowList != null) {
      if (this.rvFollowList == null)
        return; 
      if ("live".equals(paramString) && this.j) {
        if (this.refreshNewUserList.getVisibility() == 0) {
          this.refreshNewUserList.i();
          return;
        } 
        this.rvFollowList.scrollToPosition(0);
        this.refreshFollowList.i();
      } 
    } 
  }
  
  public void c(List<LiveRecommendModel> paramList) {
    if (this.f != null && paramList != null) {
      if (paramList.isEmpty())
        return; 
      this.f.b(paramList);
    } 
  }
  
  public void d(String paramString) {
    if ("live".equals(paramString) && this.j)
      c(paramString); 
  }
  
  public void k() {
    this.f.a(true);
  }
  
  public void l() {
    this.f.a(false);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131298571) {
      if (i != 2131300992)
        return; 
      LiveListSetSelectedTab.a().a(1);
      return;
    } 
    InstantLog.a("live_followed_grid_recommend_refresh_click");
    this.refreshNewUserList.i();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy() {
    super.onDestroy();
    HomeTabClick.b("live", this);
  }
  
  public void onPause() {
    super.onPause();
    this.d = System.currentTimeMillis();
  }
  
  public void onResume() {
    super.onResume();
    if (this.d != 0L && this.j) {
      if (System.currentTimeMillis() - this.d > 300000L) {
        SmartRefreshLayout smartRefreshLayout = this.refreshFollowList;
        if (smartRefreshLayout != null)
          smartRefreshLayout.i(); 
      } 
      this.d = 0L;
    } 
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    if (this.h) {
      if (this.j) {
        this.i = true;
        this.refreshFollowList.i();
      } 
      this.h = false;
    } 
  }
  
  public int p() {
    return 2131493175;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.j = paramBoolean;
    if (!this.i && this.j)
      this.i = true; 
    if (paramBoolean) {
      HomeTabClick.a("live", this);
      LiveListPositionObserver.a().a(this);
      return;
    } 
    LiveListPositionObserver.a().b(this);
  }
  
  public void x() {
    super.x();
    this.refreshFollowList.b(true);
  }
  
  public void y() {
    super.y();
    this.refreshFollowList.b(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveListFollowFragmentNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */