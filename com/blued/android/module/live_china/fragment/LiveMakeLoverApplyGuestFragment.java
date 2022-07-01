package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveMakeLoverManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.presenter.LiveMakeLoverApplyGuestPresent;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;

public class LiveMakeLoverApplyGuestFragment extends MvpFragment<LiveMakeLoverApplyGuestPresent> implements View.OnClickListener {
  View d;
  
  TextView e;
  
  View f;
  
  View g;
  
  View h;
  
  View i;
  
  ViewPager j;
  
  View n;
  
  View o;
  
  View p;
  
  TextView q;
  
  private Dialog r;
  
  private int s = 1;
  
  private MyAdapter t;
  
  private long u;
  
  private String v;
  
  private CountDownTimer w;
  
  private boolean x;
  
  private boolean y = false;
  
  private void I() {
    if (getArguments() != null) {
      this.v = getArguments().getString("uid");
      this.u = getArguments().getLong("lid");
    } 
  }
  
  private void J() {
    this.d = this.l.findViewById(R.id.empty_view);
    this.e = (TextView)this.l.findViewById(R.id.tv_title);
    this.f = this.l.findViewById(R.id.ll_apply);
    this.g = this.l.findViewById(R.id.tv_apply_selected);
    this.h = this.l.findViewById(R.id.tv_apply_select);
    this.i = this.l.findViewById(R.id.tv_apply_cancel);
    this.j = (ViewPager)this.l.findViewById(R.id.view_pager);
    this.n = this.l.findViewById(R.id.fl_time);
    this.o = this.l.findViewById(R.id.tv_time_cancel);
    this.p = this.l.findViewById(R.id.tv_time_start);
    this.q = (TextView)this.l.findViewById(R.id.tv_time);
    this.r = DialogUtils.a(getContext());
    this.t = new MyAdapter(this, getChildFragmentManager());
    if (LiveMakeLoverManager.a() == 1 || LiveMakeLoverManager.a() == 2) {
      this.j.setAdapter((PagerAdapter)this.t);
      this.j.setCurrentItem(0);
    } 
    K();
  }
  
  private void K() {
    if (LiveMakeLoverManager.a() == 1) {
      this.x = false;
      this.f.setVisibility(0);
      this.n.setVisibility(8);
      this.g.setVisibility(0);
      this.h.setVisibility(0);
      this.i.setVisibility(8);
      this.e.setText(R.string.live_make_friend_apply);
      this.g.setOnClickListener(this);
      this.h.setOnClickListener(this);
      this.d.setOnClickListener(this);
      return;
    } 
    if (LiveMakeLoverManager.a() == 2) {
      this.x = false;
      this.f.setVisibility(0);
      this.n.setVisibility(8);
      this.g.setVisibility(8);
      this.h.setVisibility(8);
      this.i.setVisibility(0);
      this.e.setText(R.string.live_make_lover_apply_wait);
      this.i.setOnClickListener(this);
      this.d.setOnClickListener(this);
      return;
    } 
    if (LiveMakeLoverManager.a() == 3) {
      this.x = false;
      this.y = true;
      LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = H();
      if (liveMakeLoverDialogFragment != null && liveMakeLoverDialogFragment.getDialog() != null) {
        liveMakeLoverDialogFragment.getDialog().setCancelable(false);
        liveMakeLoverDialogFragment.getDialog().setCanceledOnTouchOutside(false);
      } 
      this.d.setOnClickListener(null);
      this.f.setVisibility(8);
      this.n.setVisibility(0);
      this.o.setOnClickListener(this);
      this.p.setOnClickListener(this);
      this.e.setText(R.string.live_make_lover_apply_pass);
      k();
    } 
  }
  
  public void E() {
    if (this.x)
      return; 
    this.x = true;
    l();
    ((LiveMakeLoverApplyGuestPresent)s()).f(String.valueOf(this.u));
  }
  
  public void F() {
    l();
    LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = H();
    if (liveMakeLoverDialogFragment != null)
      liveMakeLoverDialogFragment.dismiss(); 
  }
  
  public LiveMakeLoverApplyMemberFragment G() {
    return (getChildFragmentManager() != null && getChildFragmentManager().getFragments() != null && getChildFragmentManager().getFragments().size() > 0 && getChildFragmentManager().getFragments().get(0) instanceof LiveMakeLoverApplyMemberFragment) ? getChildFragmentManager().getFragments().get(0) : null;
  }
  
  public LiveMakeLoverDialogFragment H() {
    return (getParentFragment() instanceof LiveMakeLoverDialogFragment) ? (LiveMakeLoverDialogFragment)getParentFragment() : null;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    J();
  }
  
  public void a(String paramString, boolean paramBoolean) {
    LiveMakeLoverApplyMemberFragment liveMakeLoverApplyMemberFragment;
    super.a(paramString, paramBoolean);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("dismissDataLoading:");
    stringBuilder.append(paramString);
    Log.i("==makelover", stringBuilder.toString());
    DialogUtils.b(this.r);
    if (paramString == "LIVE_MAKE_LOVER_APPLY") {
      if (paramBoolean) {
        LiveMakeLoverManager.a(2);
        K();
        liveMakeLoverApplyMemberFragment = G();
        if (liveMakeLoverApplyMemberFragment != null) {
          liveMakeLoverApplyMemberFragment.k();
          return;
        } 
      } 
    } else {
      if (liveMakeLoverApplyMemberFragment == "LIVE_MAKE_LOVER_CANCEL") {
        if (paramBoolean)
          LiveMakeLoverManager.a(1); 
        F();
        return;
      } 
      if (liveMakeLoverApplyMemberFragment == "LIVE_MAKE_LOVER_START") {
        this.y = false;
        LiveMakeLoverManager.a(1);
        F();
        return;
      } 
      if (liveMakeLoverApplyMemberFragment == "LIVE_MAKE_LOVER_REFUSE") {
        this.y = false;
        LiveMakeLoverManager.a(1);
        F();
      } 
    } 
  }
  
  public void aL_() {
    super.aL_();
  }
  
  public void b(String paramString) {
    super.b(paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("showDataLoading:");
    stringBuilder.append(paramString);
    Log.i("==makelover", stringBuilder.toString());
    DialogUtils.a(this.r);
  }
  
  public void b(boolean paramBoolean) {
    if (LiveMakeLoverManager.a() == 3)
      return; 
    if (paramBoolean) {
      if (LiveMakeLoverManager.a() == 1) {
        LiveMakeLoverManager.a(2);
        Log.i("==makelover==", "reset apply LOVER_WAIT_MODEL ");
        K();
        return;
      } 
    } else if (LiveMakeLoverManager.a() == 2) {
      LiveMakeLoverManager.a(1);
      Log.i("==makelover==", "reset apply LOVER_APPLY_MODEL ");
      K();
    } 
  }
  
  public void k() {
    l();
    this.w = (new CountDownTimer(this, 5000L, 500L) {
        public void onFinish() {
          this.a.m();
        }
        
        public void onTick(long param1Long) {
          param1Long /= 1000L;
          TextView textView = this.a.q;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(param1Long + 1L);
          stringBuilder.append("S");
          textView.setText(stringBuilder.toString());
        }
      }).start();
  }
  
  public void l() {
    CountDownTimer countDownTimer = this.w;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
  }
  
  public void m() {
    if (this.x)
      return; 
    this.x = true;
    l();
    ((LiveMakeLoverApplyGuestPresent)s()).d(String.valueOf(this.u));
  }
  
  public void n() {
    if (this.x)
      return; 
    this.x = true;
    l();
    ((LiveMakeLoverApplyGuestPresent)s()).e(String.valueOf(this.u));
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == R.id.tv_apply_selected) {
      EventTrackLive.a(LiveProtos.Event.USER_CONNECT_APPLY_BE_PICKED_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e());
      ((LiveMakeLoverApplyGuestPresent)s()).a(String.valueOf(this.u), "0");
      return;
    } 
    if (i == R.id.tv_apply_select) {
      EventTrackLive.a(LiveProtos.Event.USER_CONNECT_APPLY_TO_PICK_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e());
      ((LiveMakeLoverApplyGuestPresent)s()).a(String.valueOf(this.u), "1");
      return;
    } 
    if (i == R.id.tv_apply_cancel) {
      n();
      return;
    } 
    if (i == R.id.empty_view) {
      F();
      return;
    } 
    if (i == R.id.tv_time_cancel) {
      EventTrackLive.a(LiveProtos.Event.USER_CANCEL_MIKE_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e());
      E();
      return;
    } 
    if (i == R.id.tv_time_start) {
      EventTrackLive.a(LiveProtos.Event.USER_START_MIKE_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e());
      m();
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    I();
  }
  
  public void onDestroy() {
    super.onDestroy();
    l();
  }
  
  public void onStop() {
    super.onStop();
    if (this.y) {
      LiveMakeLoverManager.a(1);
      E();
    } 
  }
  
  public int p() {
    return R.layout.fragment_live_make_lover_guest_apply;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
  }
  
  public void x() {
    super.x();
  }
  
  public void y() {
    super.y();
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    FragmentManager a;
    
    public MyAdapter(LiveMakeLoverApplyGuestFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
      this.a = param1FragmentManager;
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return LiveMakeLoverApplyGuestFragment.a(this.b);
    }
    
    public Fragment getItem(int param1Int) {
      if (param1Int != 0)
        return null; 
      Bundle bundle = new Bundle();
      LiveMakeLoverApplyMemberFragment liveMakeLoverApplyMemberFragment = new LiveMakeLoverApplyMemberFragment();
      bundle.putString("uid", LiveMakeLoverApplyGuestFragment.b(this.b));
      bundle.putLong("lid", LiveMakeLoverApplyGuestFragment.c(this.b));
      bundle.putString("type", "1");
      liveMakeLoverApplyMemberFragment.setArguments(bundle);
      return (Fragment)liveMakeLoverApplyMemberFragment;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveMakeLoverApplyGuestFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */