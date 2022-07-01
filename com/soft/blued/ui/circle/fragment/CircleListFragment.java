package com.soft.blued.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.das.client.feed.FeedProtos;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.adapter.CircleListAdapter;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.circle.model.MyCircleExtra;
import com.soft.blued.ui.circle.presenter.CircleListPresenter;
import com.soft.blued.utils.Logger;
import java.io.Serializable;
import java.util.List;

public class CircleListFragment extends MvpFragment<CircleListPresenter> {
  @BindView(2131298136)
  RecyclerView circleListView;
  
  private Context d;
  
  private CircleConstants.CIRCLE_FROM_PAGE e = CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE;
  
  private boolean f = false;
  
  private boolean g = true;
  
  private CircleListAdapter h;
  
  private NoDataAndLoadFailView i;
  
  @BindView(2131299616)
  SmartRefreshLayout refreshLayout;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  public static void a(Context paramContext, CircleConstants.CIRCLE_FROM_PAGE paramCIRCLE_FROM_PAGE) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("circle_list_page", (Serializable)paramCIRCLE_FROM_PAGE);
    TerminalActivity.d(paramContext, CircleListFragment.class, bundle);
  }
  
  public String X_() {
    CircleConstants.CIRCLE_FROM_PAGE cIRCLE_FROM_PAGE = CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE;
    if (getArguments() != null)
      cIRCLE_FROM_PAGE = (CircleConstants.CIRCLE_FROM_PAGE)getArguments().getSerializable("circle_list_page"); 
    return (null.a[cIRCLE_FROM_PAGE.ordinal()] != 1) ? super.X_() : "A71";
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = (Context)getActivity();
    if (getArguments() != null)
      this.e = (CircleConstants.CIRCLE_FROM_PAGE)getArguments().getSerializable("circle_list_page"); 
    this.h = new CircleListAdapter(this.d, this.e, (IRequestHost)w_(), null);
    this.i = new NoDataAndLoadFailView(this.d);
    this.i.c();
    this.h.e((View)this.i);
    this.refreshLayout.b(false);
    this.refreshLayout.a(new -$$Lambda$CircleListFragment$-Xpey6Tl1X4tS2dH-Xrc23nrdk8(this));
    this.h.a(new -$$Lambda$CircleListFragment$QmmNktsSNNCikME7xqy0PQng-LE(this), this.circleListView);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.d);
    linearLayoutManager.setOrientation(1);
    this.circleListView.setAdapter((RecyclerView.Adapter)this.h);
    this.circleListView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.title.setLeftClickListener(new -$$Lambda$CircleListFragment$3UjPCxwUIjZXi6mi9M7cCg6VGKc(this));
    if (this.e == CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE) {
      this.title.setRightText(this.d.getResources().getString(2131757838));
      this.title.setRightTextColor(2131100842);
    } else {
      this.title.a();
    } 
    int i = null.a[this.e.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i == 4) {
            this.title.a();
            this.title.setCenterText(this.d.getResources().getString(2131757838));
          } 
        } else {
          this.title.a();
          this.title.setCenterText(this.d.getResources().getString(2131758174));
        } 
      } else {
        this.title.a();
        this.title.setCenterText(this.d.getResources().getString(2131757930));
      } 
    } else {
      this.title.setRightText(this.d.getResources().getString(2131757838));
      this.title.setRightTextColor(2131100842);
      this.title.setCenterText(this.d.getResources().getString(2131758172));
      this.i.setBtnStr(2131757930);
      this.i.setNoDataBtnListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              CircleListFragment.a(CircleListFragment.a(this.a), CircleConstants.CIRCLE_FROM_PAGE.EXPLORE_MORE);
            }
          });
    } 
    this.i.setNoDataImg(2131232633);
    this.i.setNoDataStr(2131758229);
    this.circleListView.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
            this.a.k();
          }
        });
  }
  
  public void a(String paramString, List paramList) {
    super.a(paramString, paramList);
    if (paramList == null)
      return; 
    byte b = -1;
    int i = paramString.hashCode();
    if (i != 300194660) {
      if (i == 391102192 && paramString.equals("CIRCLE_ADMIN_COUNT"))
        b = 1; 
    } else if (paramString.equals("CIRCLE_DATA_LIST")) {
      b = 0;
    } 
    if (b != 0) {
      if (b != 1)
        return; 
      MvpUtils.a(paramList, MyCircleExtra.class, new MvpUtils.DataHandler<MyCircleExtra>(this) {
            public void a() {
              this.a.title.setRightTextColor(2131100842);
              this.a.title.setRightClickListener(-$$Lambda$CircleListFragment$3$2R4Ja0pFrN_G4ZqJCslobkxBOAs.INSTANCE);
            }
            
            public void a(MyCircleExtra param1MyCircleExtra) {
              if (param1MyCircleExtra.my_admin > 0) {
                this.a.title.setRightTextColor(2131100838);
                this.a.title.setRightClickListener(new -$$Lambda$CircleListFragment$3$vpYpJ2-kfZ9SZ5q8yMeuXWqveng(this));
                return;
              } 
              this.a.title.setRightTextColor(2131100842);
              this.a.title.setRightClickListener(-$$Lambda$CircleListFragment$3$8zwN9AXjulbjDMRBbzFs95fLZsc.INSTANCE);
            }
          });
      return;
    } 
    this.h.c(paramList);
    if (paramList.size() != 0)
      k(); 
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
    this.refreshLayout.g();
    this.h.l();
    if (this.h.n().size() <= 0) {
      if (paramBoolean) {
        this.i.a();
        return;
      } 
      this.i.b();
      return;
    } 
    this.i.c();
  }
  
  public void aL_() {
    super.aL_();
    this.i = null;
  }
  
  public void b(String paramString) {
    super.b(paramString);
  }
  
  public void k() {
    if (!this.circleListView.canScrollVertically(1) && !this.f && !this.g) {
      Logger.a("postFooterShow", FeedProtos.Event.CIRCLE_MORE_BTN_SHOW.name());
      EventTrackFeed.a(FeedProtos.Event.CIRCLE_MORE_BTN_SHOW);
      this.f = true;
    } 
  }
  
  public int p() {
    return 2131493161;
  }
  
  public void u() {
    this.refreshLayout.i();
  }
  
  public void x() {
    super.x();
    this.g = true;
    this.h.c(true);
  }
  
  public void y() {
    super.y();
    this.g = false;
    this.h.c(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */