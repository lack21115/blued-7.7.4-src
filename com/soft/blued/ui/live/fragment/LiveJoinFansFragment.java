package com.soft.blued.ui.live.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.model.LiveFansQuitModel;
import com.blued.android.module.live_china.model.LiveFansRecommendModel;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.H5Url;
import com.soft.blued.log.trackUtils.EventTrackLive;
import com.soft.blued.ui.live.adapter.LiveFansRecommendAdapater;
import com.soft.blued.ui.live.adapter.LiveJoinFansAdapater;
import com.soft.blued.ui.live.model.LiveJoinFansModel;
import com.soft.blued.ui.live.presenter.LiveJoinFansPresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.List;

public class LiveJoinFansFragment extends MvpFragment<LiveJoinFansPresenter> implements View.OnClickListener {
  public Dialog d;
  
  LiveJoinFansAdapater e = null;
  
  LiveFansRecommendAdapater f = null;
  
  @BindView(2131297133)
  View fl_main;
  
  private Context g;
  
  @BindView(2131298983)
  View ll_no_fans;
  
  @BindView(2131299597)
  RecyclerView recycle_recommend;
  
  @BindView(2131299598)
  RecyclerView recycle_view;
  
  @BindView(2131299618)
  SmartRefreshLayout refresh_view;
  
  @BindView(2131300300)
  CommonTopTitleNoTrans top_title;
  
  @BindView(2131300751)
  TextView tv_fans_qa;
  
  @BindView(2131301108)
  TextView tv_no_data;
  
  @BindView(2131301225)
  View tv_re_title;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, LiveJoinFansFragment.class, null);
  }
  
  private void m() {
    this.d = DialogUtils.a((Context)getActivity());
    this.top_title.a();
    this.top_title.setCenterText(getText(2131757306));
    this.top_title.setLeftClickListener(this);
    this.top_title.e();
    this.e = new LiveJoinFansAdapater((IRequestHost)w_(), getContext());
    this.e.a(new LiveJoinFansAdapater.EventCallBack(this) {
          public void a() {
            this.a.l();
          }
          
          public void a(String param1String, int param1Int) {
            DialogUtils.a(this.a.d);
            ((LiveJoinFansPresenter)this.a.s()).d(param1String);
          }
        });
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    this.recycle_view.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.recycle_view.setAdapter((RecyclerView.Adapter)this.e);
    this.refresh_view.a((OnMultiPurposeListener)new SimpleMultiPurposeListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((LiveJoinFansPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {}
        });
    this.refresh_view.b(false);
    this.refresh_view.c(false);
    linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(0);
    this.recycle_recommend.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.f = new LiveFansRecommendAdapater((IRequestHost)w_(), this.g);
    this.f.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            Log.i("LiveJoinFansFragment", "onLoadMoreRequested");
            ((LiveJoinFansPresenter)this.a.s()).a(false);
          }
        }this.recycle_recommend);
    this.recycle_recommend.setAdapter((RecyclerView.Adapter)this.f);
    this.tv_fans_qa.setOnClickListener(this);
    ((LiveJoinFansPresenter)s()).e();
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    m();
  }
  
  public void a(LiveFansQuitModel paramLiveFansQuitModel) {
    if (paramLiveFansQuitModel == null)
      return; 
    this.e.a(paramLiveFansQuitModel.localUid);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    if (paramString == "LIVE_JOIN_FANS_QUIT") {
      DialogUtils.b(this.d);
      return;
    } 
    if (paramString == "LIVE_JOIN_FANS") {
      this.refresh_view.g();
      this.refresh_view.h();
      this.refresh_view.b(((LiveJoinFansPresenter)s()).i);
      if (paramBoolean) {
        this.tv_no_data.setText(getText(2131757338));
        return;
      } 
      this.tv_no_data.setText(getText(2131757538));
    } 
  }
  
  public void a(List<LiveJoinFansModel> paramList) {
    if (paramList == null)
      return; 
    this.e.a(paramList);
    l();
  }
  
  public void b(List<LiveFansRecommendModel> paramList) {
    if (paramList == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("pageRecommend:");
    stringBuilder.append(((LiveJoinFansPresenter)s()).l);
    Log.i("LiveJoinFansFragment", stringBuilder.toString());
    this.tv_re_title.setVisibility(0);
    if (((LiveJoinFansPresenter)s()).l == 1) {
      this.f.a(paramList);
    } else {
      this.f.b(paramList);
    } 
    this.f.c(((LiveJoinFansPresenter)s()).j);
  }
  
  public void k() {
    l();
  }
  
  public void l() {
    if (this.e.a() > 1) {
      this.fl_main.setVisibility(0);
      this.recycle_view.setVisibility(0);
      this.ll_no_fans.setVisibility(8);
      EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_SHOW, true);
      return;
    } 
    this.fl_main.setVisibility(0);
    this.recycle_view.setVisibility(8);
    this.ll_no_fans.setVisibility(0);
    ((LiveJoinFansPresenter)s()).a(true);
    EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_SHOW, false);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131300751)
        return; 
      WebViewShowInfoFragment.show(this.g, H5Url.a(47), 0);
      return;
    } 
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.g = getContext();
  }
  
  public int p() {
    return 2131493188;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveJoinFansFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */