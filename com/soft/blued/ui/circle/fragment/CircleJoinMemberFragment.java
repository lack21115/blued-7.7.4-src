package com.soft.blued.ui.circle.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.brandongogetap.stickyheaders.StickyLayoutManager;
import com.brandongogetap.stickyheaders.exposed.StickyHeaderHandler;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.adapter.CircleMemberAdapter;
import com.soft.blued.ui.circle.presenter.CircleJoinMemberPresenter;
import com.soft.blued.ui.discover.model.CircleBaseMember;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.pop.BottomMenuPop;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.util.ArrayList;
import java.util.List;

public class CircleJoinMemberFragment<T extends CircleJoinMemberPresenter> extends MvpFragment<CircleJoinMemberPresenter> {
  protected CircleMemberAdapter d;
  
  protected NoDataAndLoadFailView e;
  
  @BindView(2131299605)
  RecyclerView recyclerView;
  
  @BindView(2131299616)
  SmartRefreshLayout refreshLayout;
  
  private void b(boolean paramBoolean) {
    this.refreshLayout.g();
    this.refreshLayout.h();
    if (this.d.n().size() <= 0) {
      if (paramBoolean) {
        this.e.a();
        return;
      } 
      this.e.b();
    } 
  }
  
  public boolean A() {
    return true;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = new CircleMemberAdapter((IRequestHost)w_(), ((CircleJoinMemberPresenter)s()).n());
    this.e = new NoDataAndLoadFailView(getContext());
    ((CircleJoinMemberPresenter)s()).a(this.d);
    this.d.e((View)this.e);
    this.refreshLayout.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((CircleJoinMemberPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((CircleJoinMemberPresenter)this.a.s()).e();
          }
        });
    StickyLayoutManager stickyLayoutManager = new StickyLayoutManager(getContext(), (StickyHeaderHandler)this.d);
    this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)stickyLayoutManager);
    this.recyclerView.setAdapter((RecyclerView.Adapter)this.d);
    this.d.a(new BaseQuickAdapter.OnItemChildClickListener(this) {
          public void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            CircleBaseMember.Member member = (CircleBaseMember.Member)this.a.d.e(param1Int);
            int i = param1View.getId();
            if (i != 2131296768) {
              if (i != 2131297863)
                return; 
              this.a.a(member, param1Int);
              if (member.isManager()) {
                EventTrackFeed.a(FeedProtos.Event.CIRCLE_USER_LIST_MANAGE_CLICK, ((CircleJoinMemberPresenter)this.a.s()).m(), member.uid, FeedProtos.UserType.VICE_CAPTAIN);
                return;
              } 
              EventTrackFeed.a(FeedProtos.Event.CIRCLE_USER_LIST_MANAGE_CLICK, ((CircleJoinMemberPresenter)this.a.s()).m(), member.uid, FeedProtos.UserType.COMMON_USER);
              return;
            } 
            if (member.is_locked == 1) {
              AppMethods.a(this.a.getString(2131755898));
              return;
            } 
            UserInfoFragmentNew.a(this.a.getContext(), member.uid, "CIRCLE_MEMBERS", new MsgSourceEntity(MessageProtos.StrangerSource.CIRCLE_USERS));
          }
        });
  }
  
  protected void a(CircleBaseMember.Member paramMember, int paramInt) {
    int i;
    String str = paramMember.uid;
    ArrayList<BottomMenuPop.MenuItemInfo> arrayList = new ArrayList();
    BasePopupView basePopupView = CommonShowBottomWindow.a(getContext(), arrayList);
    BottomMenuPop.MenuItemInfo menuItemInfo1 = new BottomMenuPop.MenuItemInfo();
    Resources resources1 = getResources();
    if (paramMember.isManager()) {
      i = 2131755902;
    } else {
      i = 2131755889;
    } 
    menuItemInfo1.a = resources1.getString(i);
    BottomMenuPop.MenuItemInfo menuItemInfo2 = new BottomMenuPop.MenuItemInfo();
    menuItemInfo2.a = getResources().getString(2131755903);
    BottomMenuPop.MenuItemInfo menuItemInfo3 = new BottomMenuPop.MenuItemInfo();
    Resources resources2 = getResources();
    if (paramMember.is_mute == 1) {
      i = 2131755901;
    } else {
      i = 2131755900;
    } 
    menuItemInfo3.a = resources2.getString(i);
    menuItemInfo3.b = 2131100837;
    menuItemInfo1.c = new -$$Lambda$CircleJoinMemberFragment$UhCL7214lkYfd9NNQ-qBLyD9PFA(this, paramMember, str, basePopupView, paramInt);
    menuItemInfo2.c = new -$$Lambda$CircleJoinMemberFragment$6n9f07JXSJ_WEhl824u_4Ave9iI(this, str, basePopupView, paramMember, paramInt);
    menuItemInfo3.c = new -$$Lambda$CircleJoinMemberFragment$S9Wq7U6t6__sS9RdUJn0zyBGho4(this, paramMember, str, basePopupView, paramInt);
    if (((CircleJoinMemberPresenter)s()).n() == 1) {
      arrayList.add(menuItemInfo1);
      arrayList.add(menuItemInfo2);
      arrayList.add(menuItemInfo3);
    } 
    if (((CircleJoinMemberPresenter)s()).n() == 2) {
      arrayList.add(menuItemInfo2);
      arrayList.add(menuItemInfo3);
    } 
    basePopupView.h();
  }
  
  public void a(String paramString, List paramList) {
    byte b;
    super.a(paramString, paramList);
    if (paramString.hashCode() == -1515158321 && paramString.equals("data_member")) {
      b = 0;
    } else {
      b = -1;
    } 
    if (b != 0)
      return; 
    MvpUtils.a(paramList, CircleBaseMember.Member.class, new MvpUtils.DataListHandler<CircleBaseMember.Member>(this) {
          public void a() {}
          
          public void a(List<CircleBaseMember.Member> param1List) {
            this.a.d.c(param1List);
          }
        });
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
    if (b != 0 && b != 1)
      return; 
    b(paramBoolean);
  }
  
  public void aL_() {
    super.aL_();
    this.e = null;
  }
  
  public void b(String paramString) {
    super.b(paramString);
  }
  
  public int p() {
    return 2131493097;
  }
  
  public void u() {
    this.refreshLayout.i();
  }
  
  public void x() {
    super.x();
    this.refreshLayout.b(true);
  }
  
  public void y() {
    super.y();
    this.refreshLayout.b(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleJoinMemberFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */