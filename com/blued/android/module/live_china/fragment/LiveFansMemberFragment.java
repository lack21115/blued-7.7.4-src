package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveFansMemberAdapter;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.model.LiveFansMemberModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.presenter.LiveFansRecordMemberPresent;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import java.util.List;

public class LiveFansMemberFragment extends MvpFragment<LiveFansRecordMemberPresent> implements View.OnClickListener {
  TextView d;
  
  View e;
  
  View f;
  
  View g;
  
  SmartRefreshLayout h;
  
  RecyclerView i;
  
  View j;
  
  View n;
  
  View o;
  
  TextView p;
  
  View q;
  
  private LoadOptions r;
  
  private LiveFansMemberAdapter s;
  
  private long t;
  
  private boolean u = true;
  
  private void l() {
    if (getArguments() != null)
      this.t = getArguments().getLong("lid"); 
    this.r = new LoadOptions();
    this.r.d = R.drawable.user_bg_round;
    this.r.b = R.drawable.user_bg_round;
  }
  
  private void m() {
    this.d = (TextView)this.l.findViewById(R.id.tv_fans_title);
    this.e = this.l.findViewById(R.id.iv_fans_member);
    this.f = this.l.findViewById(R.id.iv_fans_member_back);
    this.g = this.l.findViewById(R.id.iv_fans_qa);
    this.h = (SmartRefreshLayout)this.l.findViewById(R.id.smart_members);
    this.i = (RecyclerView)this.l.findViewById(R.id.rv_members);
    this.j = this.l.findViewById(R.id.ll_nodata_blacklist);
    this.n = this.l.findViewById(R.id.tv_live_reload);
    this.o = this.l.findViewById(R.id.ll_nodata);
    this.p = (TextView)this.l.findViewById(R.id.tv_tip);
    this.q = this.l.findViewById(R.id.loading_view);
    this.e.setVisibility(8);
    this.f.setVisibility(0);
    ((LiveFansRecordMemberPresent)s()).a(2);
    this.h.c(false);
    this.h.a((OnMultiPurposeListener)new SimpleMultiPurposeListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((LiveFansRecordMemberPresent)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {}
        });
    this.n.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            ((LiveFansRecordMemberPresent)this.a.s()).e();
          }
        });
    this.s = new LiveFansMemberAdapter(getContext());
    this.s.a(new BaseQuickAdapter.OnItemChildClickListener(this) {
          public void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            if (this.a.getParentFragment() instanceof LiveFansGuestDialogFragment)
              ((LiveFansGuestDialogFragment)this.a.getParentFragment()).dismiss(); 
            LiveFansMemberModel liveFansMemberModel = LiveFansMemberFragment.a(this.a).a(param1Int);
            if (liveFansMemberModel != null) {
              LiveRoomUserModel liveRoomUserModel = new LiveRoomUserModel();
              liveRoomUserModel.uid = liveFansMemberModel.uid;
              liveRoomUserModel.avatar = liveFansMemberModel.avatar;
              LiveSetDataObserver.a().a(liveRoomUserModel);
            } 
          }
        });
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    this.i.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.i.setAdapter((RecyclerView.Adapter)this.s);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    ((LiveFansRecordMemberPresent)s()).e();
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    m();
    this.u = true;
  }
  
  public void a(LiveFansInfoModel paramLiveFansInfoModel) {
    TextView textView = this.d;
    if (textView != null)
      textView.setText(String.format(getString(R.string.live_fans_not_add_tip_1), new Object[] { paramLiveFansInfoModel.anchor_name, Integer.valueOf(paramLiveFansInfoModel.member_total) })); 
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    this.q.setVisibility(8);
    this.h.h();
    if (this.s.a() == 0) {
      Log.i("xmm", "setData 1");
      if (paramBoolean) {
        Log.i("xmm", "setData 2");
        this.p.setText(R.string.live_fans_guest_no_member);
        this.o.setVisibility(0);
        this.i.setVisibility(8);
        this.j.setVisibility(8);
        return;
      } 
      Log.i("xmm", "setData 3");
      this.o.setVisibility(8);
      this.i.setVisibility(8);
      this.j.setVisibility(0);
      return;
    } 
    Log.i("xmm", "setData 4");
    this.o.setVisibility(8);
    this.i.setVisibility(0);
    this.j.setVisibility(8);
  }
  
  public void a(List<LiveFansMemberModel> paramList) {
    Log.i("xmm", "setData");
    this.i.setVisibility(0);
    this.s.a(paramList);
  }
  
  public void aL_() {
    super.aL_();
    this.u = false;
  }
  
  public void b(String paramString) {
    super.b(paramString);
  }
  
  public LiveFansGuestDialogFragment k() {
    return (getParentFragment() instanceof LiveFansGuestDialogFragment) ? (LiveFansGuestDialogFragment)getParentFragment() : null;
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == R.id.iv_fans_member_back) {
      if (getParentFragment() instanceof LiveFansGuestDialogFragment) {
        LiveFansGuestDialogFragment liveFansGuestDialogFragment = (LiveFansGuestDialogFragment)getParentFragment();
        if (liveFansGuestDialogFragment != null) {
          liveFansGuestDialogFragment.a(0);
          return;
        } 
      } 
    } else if (i == R.id.iv_fans_qa && k() != null) {
      k().f();
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    l();
  }
  
  public int p() {
    return R.layout.live_fans_member_view;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (this.u && paramBoolean) {
      EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_FANS_LIST_PAGE_SHOW, String.valueOf(this.t), LiveRoomInfo.a().f());
      ((LiveFansRecordMemberPresent)s()).e();
    } 
  }
  
  public void x() {
    super.x();
    Log.i("xmm", "setData 5");
    this.h.b(true);
  }
  
  public void y() {
    super.y();
    Log.i("xmm", "setData 6");
    this.h.b(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveFansMemberFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */