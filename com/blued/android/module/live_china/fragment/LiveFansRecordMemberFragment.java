package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveFansRecordMemberAdapter;
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

public class LiveFansRecordMemberFragment extends MvpFragment<LiveFansRecordMemberPresent> implements View.OnClickListener {
  SmartRefreshLayout d;
  
  RecyclerView e;
  
  View f;
  
  View g;
  
  View h;
  
  View i;
  
  TextView j;
  
  private String n = LiveFansRecordMemberFragment.class.getSimpleName();
  
  private LiveFansRecordMemberAdapter o;
  
  private Context p;
  
  private int q = 0;
  
  private long r;
  
  private void k() {
    this.p = getContext();
    if (getArguments() != null) {
      this.q = getArguments().getInt("index", 0);
      this.r = getArguments().getLong("lid");
    } 
  }
  
  private void l() {
    this.d = (SmartRefreshLayout)this.l.findViewById(R.id.smart_members);
    this.e = (RecyclerView)this.l.findViewById(R.id.rv_members);
    this.f = this.l.findViewById(R.id.ll_nodata_error);
    this.g = this.l.findViewById(R.id.tv_live_reload);
    this.h = this.l.findViewById(R.id.ll_nodata);
    this.i = this.l.findViewById(R.id.loading_view);
    this.j = (TextView)this.l.findViewById(R.id.tv_tip);
    int i = this.q;
    if (i == 0) {
      this.j.setText(R.string.live_fans_no_member_active);
    } else if (i == 1) {
      this.j.setText(R.string.live_fans_no_member);
    } 
    ((LiveFansRecordMemberPresent)s()).a(this.q);
    this.d.c(false);
    this.d.a((OnMultiPurposeListener)new SimpleMultiPurposeListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((LiveFansRecordMemberPresent)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {}
        });
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            ((LiveFansRecordMemberPresent)this.a.s()).e();
          }
        });
    this.o = new LiveFansRecordMemberAdapter(getContext());
    this.o.a(new BaseQuickAdapter.OnItemChildClickListener(this) {
          public void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            if (this.a.getParentFragment() instanceof LiveFansRecordDialogFragment)
              ((LiveFansRecordDialogFragment)this.a.getParentFragment()).dismiss(); 
            LiveFansMemberModel liveFansMemberModel = LiveFansRecordMemberFragment.a(this.a).a(param1Int);
            if (liveFansMemberModel != null) {
              if (LiveFansRecordMemberFragment.b(this.a) == 0) {
                EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_ACTIVE_LIST_USER_CLICK, String.valueOf(LiveFansRecordMemberFragment.c(this.a)), liveFansMemberModel.uid);
              } else if (LiveFansRecordMemberFragment.b(this.a) == 1) {
                EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_TODAY_LIST_USER_CLICK, String.valueOf(LiveFansRecordMemberFragment.c(this.a)), liveFansMemberModel.uid);
              } else if (LiveFansRecordMemberFragment.b(this.a) == 2) {
                EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_ALL_LIST_USER_CLICK, String.valueOf(LiveFansRecordMemberFragment.c(this.a)), liveFansMemberModel.uid);
              } 
              LiveRoomUserModel liveRoomUserModel = new LiveRoomUserModel();
              liveRoomUserModel.uid = liveFansMemberModel.uid;
              liveRoomUserModel.avatar = liveFansMemberModel.avatar;
              LiveSetDataObserver.a().a(liveRoomUserModel);
            } 
          }
        });
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    this.e.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.e.setAdapter((RecyclerView.Adapter)this.o);
    ((LiveFansRecordMemberPresent)s()).e();
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    l();
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    this.i.setVisibility(8);
    this.d.h();
    if (this.o.a() == 0) {
      Log.i("xmm", "setData 1");
      if (paramBoolean) {
        Log.i("xmm", "setData 2");
        this.h.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        return;
      } 
      Log.i("xmm", "setData 3");
      this.h.setVisibility(8);
      this.e.setVisibility(8);
      this.f.setVisibility(0);
      return;
    } 
    Log.i("xmm", "setData 4");
    this.h.setVisibility(8);
    this.e.setVisibility(0);
    this.f.setVisibility(8);
  }
  
  public void a(List<LiveFansMemberModel> paramList) {
    Log.i("xmm", "setData");
    this.o.a(paramList);
  }
  
  public void b(String paramString) {
    super.b(paramString);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.tv_live_reload)
      ((LiveFansRecordMemberPresent)s()).e(); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    k();
  }
  
  public void onPause() {
    super.onPause();
  }
  
  public void onResume() {
    super.onResume();
  }
  
  public int p() {
    return R.layout.live_fans_record_member_view;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
  }
  
  public void x() {
    super.x();
    Log.i("xmm", "setData 5");
    this.d.b(true);
  }
  
  public void y() {
    super.y();
    Log.i("xmm", "setData 6");
    this.d.b(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveFansRecordMemberFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */