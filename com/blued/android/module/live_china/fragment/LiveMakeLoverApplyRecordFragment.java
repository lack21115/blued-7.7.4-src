package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.presenter.LiveMakeLoverApplyRecordPresent;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;

public class LiveMakeLoverApplyRecordFragment extends MvpFragment<LiveMakeLoverApplyRecordPresent> implements View.OnClickListener {
  TextView d;
  
  ViewPager e;
  
  View f;
  
  TextView g;
  
  View h;
  
  View i;
  
  TextView j;
  
  View n;
  
  private int o = 2;
  
  private MyAdapter p;
  
  private long q;
  
  private String r;
  
  private int s = -1;
  
  private int t = -1;
  
  private ViewPager.OnPageChangeListener u = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
      
      public void onPageSelected(int param1Int) {
        this.a.a(param1Int);
      }
    };
  
  private void l() {
    if (getArguments() != null) {
      this.r = getArguments().getString("uid");
      this.q = getArguments().getLong("lid");
    } 
  }
  
  private void m() {
    this.d = (TextView)this.l.findViewById(R.id.tv_title);
    this.e = (ViewPager)this.l.findViewById(R.id.view_pager);
    this.f = this.l.findViewById(R.id.ll_selected);
    this.g = (TextView)this.l.findViewById(R.id.tv_selected_title);
    this.h = this.l.findViewById(R.id.ll_selected_line);
    this.i = this.l.findViewById(R.id.ll_select);
    this.j = (TextView)this.l.findViewById(R.id.tv_selected_title);
    this.n = this.l.findViewById(R.id.ll_select_line);
    this.p = new MyAdapter(this, getChildFragmentManager());
    this.e.setAdapter((PagerAdapter)this.p);
    this.e.setOnPageChangeListener(this.u);
    this.f.setOnClickListener(this);
    this.i.setOnClickListener(this);
    a(0);
  }
  
  private void n() {
    int i = this.s;
    if (i >= 0) {
      int j = this.t;
      if (j >= 0) {
        if (i > 0) {
          a(0);
          return;
        } 
        if (j > 0)
          a(1); 
      } 
    } 
  }
  
  public void a(int paramInt) {
    this.e.setCurrentItem(paramInt);
    if (paramInt == 0) {
      this.g.setTextColor(getResources().getColor(R.color.syc_dark_h));
      this.j.setTextColor(getResources().getColor(R.color.syc_dark_j));
      this.h.setVisibility(0);
      this.n.setVisibility(4);
      return;
    } 
    if (paramInt == 1) {
      this.g.setTextColor(getResources().getColor(R.color.syc_dark_j));
      this.j.setTextColor(getResources().getColor(R.color.syc_dark_h));
      this.h.setVisibility(4);
      this.n.setVisibility(0);
    } 
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    m();
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
  }
  
  public void aL_() {
    super.aL_();
  }
  
  public void b(int paramInt) {
    this.s = paramInt;
    n();
  }
  
  public void b(String paramString) {
    super.b(paramString);
  }
  
  public void c(int paramInt) {
    this.t = paramInt;
    n();
  }
  
  public LiveMakeLoverDialogFragment k() {
    return (getParentFragment() instanceof LiveMakeLoverDialogFragment) ? (LiveMakeLoverDialogFragment)getParentFragment() : null;
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == R.id.ll_selected) {
      EventTrackLive.a(LiveProtos.Event.ANCHOR_MIKE_MANAGE_BE_PICKED_CLICK, String.valueOf(this.q));
      a(0);
      return;
    } 
    if (i == R.id.ll_select) {
      EventTrackLive.a(LiveProtos.Event.ANCHOR_MIKE_MANAGE_TO_PICK_CLICK, String.valueOf(this.q));
      a(1);
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    l();
  }
  
  public int p() {
    return R.layout.fragment_live_make_lover_record_apply;
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
    
    public MyAdapter(LiveMakeLoverApplyRecordFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
      this.a = param1FragmentManager;
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return LiveMakeLoverApplyRecordFragment.a(this.b);
    }
    
    public Fragment getItem(int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1)
          return null; 
        Bundle bundle1 = new Bundle();
        LiveMakeLoverApplyMemberFragment liveMakeLoverApplyMemberFragment1 = new LiveMakeLoverApplyMemberFragment();
        bundle1.putString("uid", LiveMakeLoverApplyRecordFragment.b(this.b));
        bundle1.putLong("lid", LiveMakeLoverApplyRecordFragment.c(this.b));
        bundle1.putString("type", "3");
        liveMakeLoverApplyMemberFragment1.setArguments(bundle1);
        return (Fragment)liveMakeLoverApplyMemberFragment1;
      } 
      Bundle bundle = new Bundle();
      LiveMakeLoverApplyMemberFragment liveMakeLoverApplyMemberFragment = new LiveMakeLoverApplyMemberFragment();
      bundle.putString("uid", LiveMakeLoverApplyRecordFragment.b(this.b));
      bundle.putLong("lid", LiveMakeLoverApplyRecordFragment.c(this.b));
      bundle.putString("type", "2");
      liveMakeLoverApplyMemberFragment.setArguments(bundle);
      return (Fragment)liveMakeLoverApplyMemberFragment;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveMakeLoverApplyRecordFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */