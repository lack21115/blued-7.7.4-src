package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveMakeLoverApplyMemberAdapter;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverApplyMemberModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.presenter.LiveMakeLoverApplyMemberPresent;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import java.util.Iterator;
import java.util.List;

public class LiveMakeLoverApplyMemberFragment extends MvpFragment<LiveMakeLoverApplyMemberPresent> implements View.OnClickListener {
  View d;
  
  SmartRefreshLayout e;
  
  RecyclerView f;
  
  View g;
  
  private LiveMakeLoverApplyMemberAdapter h;
  
  private long i;
  
  private String j;
  
  private String n;
  
  private void E() {
    this.d = this.l.findViewById(R.id.ll_nodata);
    this.e = (SmartRefreshLayout)this.l.findViewById(R.id.smart_members);
    this.f = (RecyclerView)this.l.findViewById(R.id.rv_members);
    this.g = this.l.findViewById(R.id.loading_view);
    this.e.c(false);
    this.e.a((OnMultiPurposeListener)new SimpleMultiPurposeListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((LiveMakeLoverApplyMemberPresent)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {}
        });
    this.h = new LiveMakeLoverApplyMemberAdapter(getContext(), TextUtils.equals(this.j, "1"));
    this.h.a(new BaseQuickAdapter.OnItemChildClickListener(this) {
          public void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            LiveRoomUserModel liveRoomUserModel;
            LiveMakeLoverApplyMemberModel liveMakeLoverApplyMemberModel = LiveMakeLoverApplyMemberFragment.a(this.a).a(param1Int);
            if (liveMakeLoverApplyMemberModel == null)
              return; 
            if (param1View.getId() == R.id.ll_items_view) {
              if (this.a.m() != null && this.a.m().H() != null) {
                this.a.m().H().dismiss();
              } else if (this.a.l() != null && this.a.l().k() != null) {
                this.a.l().k().dismiss();
              } 
              liveRoomUserModel = new LiveRoomUserModel();
              liveRoomUserModel.uid = liveMakeLoverApplyMemberModel.uid;
              liveRoomUserModel.avatar = liveMakeLoverApplyMemberModel.avatar;
              LiveSetDataObserver.a().a(liveRoomUserModel);
              return;
            } 
            if (liveRoomUserModel.getId() == R.id.tv_done) {
              EventTrackLive.a(LiveProtos.Event.ANCHOR_MIKE_MANAGE_CONFIRM_CLICK, String.valueOf(LiveMakeLoverApplyMemberFragment.b(this.a)), liveMakeLoverApplyMemberModel.uid);
              ((LiveMakeLoverApplyMemberPresent)this.a.s()).a(liveMakeLoverApplyMemberModel);
              return;
            } 
            if (liveRoomUserModel.getId() == R.id.tv_ignore) {
              EventTrackLive.a(LiveProtos.Event.ANCHOR_MIKE_MANAGE_IGNORE_CLICK, String.valueOf(LiveMakeLoverApplyMemberFragment.b(this.a)), liveMakeLoverApplyMemberModel.uid);
              ((LiveMakeLoverApplyMemberPresent)this.a.s()).b(liveMakeLoverApplyMemberModel);
            } 
          }
        });
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    this.f.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.f.setAdapter((RecyclerView.Adapter)this.h);
  }
  
  private void n() {
    if (getArguments() != null) {
      this.i = getArguments().getLong("lid");
      this.j = getArguments().getString("type");
      this.n = getArguments().getString("uid");
    } 
    ((LiveMakeLoverApplyMemberPresent)s()).a(String.valueOf(this.i), this.j);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    E();
  }
  
  public void a(String paramString, List paramList) {
    super.a(paramString, paramList);
    if (paramString == "LIVE_MAKE_LOVER_APPLY_LIST") {
      this.h.a(paramList);
      if (TextUtils.equals(this.j, "1") && this.h.n() != null) {
        boolean bool1;
        boolean bool2 = false;
        Iterator iterator = this.h.n().iterator();
        while (true) {
          bool1 = bool2;
          if (iterator.hasNext()) {
            if (TextUtils.equals(((LiveMakeLoverApplyMemberModel)iterator.next()).uid, LiveRoomInfo.a().f())) {
              bool1 = true;
              break;
            } 
            continue;
          } 
          break;
        } 
        LiveMakeLoverApplyGuestFragment liveMakeLoverApplyGuestFragment = m();
        if (liveMakeLoverApplyGuestFragment != null)
          liveMakeLoverApplyGuestFragment.b(bool1); 
      } 
    } 
  }
  
  public void a(String paramString, boolean paramBoolean) {
    LiveMakeLoverApplyRecordFragment liveMakeLoverApplyRecordFragment;
    super.a(paramString, paramBoolean);
    this.g.setVisibility(8);
    if (paramString == "LIVE_MAKE_LOVER_APPLY_LIST") {
      if (TextUtils.equals(this.j, "2")) {
        liveMakeLoverApplyRecordFragment = l();
        if (liveMakeLoverApplyRecordFragment != null)
          liveMakeLoverApplyRecordFragment.b(this.h.a()); 
      } else if (TextUtils.equals(this.j, "3")) {
        liveMakeLoverApplyRecordFragment = l();
        if (liveMakeLoverApplyRecordFragment != null)
          liveMakeLoverApplyRecordFragment.c(this.h.a()); 
      } 
      this.e.h();
      if (this.h.a() == 0) {
        this.d.setVisibility(0);
        this.f.setVisibility(8);
        return;
      } 
      this.d.setVisibility(8);
      this.f.setVisibility(0);
      return;
    } 
    if (liveMakeLoverApplyRecordFragment == "LIVE_MAKE_LOVER_AGREE") {
      if (!paramBoolean && ((LiveMakeLoverApplyMemberPresent)s()).h != 403002 && ((LiveMakeLoverApplyMemberPresent)s()).h != 403003)
        int i = ((LiveMakeLoverApplyMemberPresent)s()).h; 
      k();
      return;
    } 
    if (liveMakeLoverApplyRecordFragment == "LIVE_MAKE_LOVER_IGNORE") {
      int i = ((LiveMakeLoverApplyMemberPresent)s()).h;
      k();
    } 
  }
  
  public void aL_() {
    super.aL_();
  }
  
  public void b(String paramString) {
    super.b(paramString);
    this.g.setVisibility(0);
  }
  
  public void k() {
    ((LiveMakeLoverApplyMemberPresent)s()).e();
  }
  
  public LiveMakeLoverApplyRecordFragment l() {
    return (getParentFragment() instanceof LiveMakeLoverApplyRecordFragment) ? (LiveMakeLoverApplyRecordFragment)getParentFragment() : null;
  }
  
  public LiveMakeLoverApplyGuestFragment m() {
    return (getParentFragment() instanceof LiveMakeLoverApplyGuestFragment) ? (LiveMakeLoverApplyGuestFragment)getParentFragment() : null;
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    n();
  }
  
  public int p() {
    return R.layout.fragment_live_make_lover_apply_member;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
  }
  
  public void x() {
    super.x();
    this.e.b(true);
  }
  
  public void y() {
    super.y();
    this.e.b(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveMakeLoverApplyMemberFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */