package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.das.vip.VipProtos;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.find.observer.VisitRecordSelectedTabObserver;

public class VisitHistoryFragment extends BaseFragment implements VisitRecordSelectedTabObserver.IVisitRecordSelectedTabObserver {
  private Context d;
  
  private View e;
  
  private ViewPager f;
  
  private MyVisitorFragment g;
  
  private MyVisitedFragment h;
  
  private BaseFragment[] i;
  
  private int j;
  
  private ViewPager.OnPageChangeListener k = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
      
      public void onPageSelected(int param1Int) {
        VisitHistoryFragment.a(this.a, param1Int);
      }
    };
  
  private void a() {
    this.f = (ViewPager)this.e.findViewById(2131299192);
    MyAdapter myAdapter = new MyAdapter(this, getChildFragmentManager());
    this.f.setAdapter((PagerAdapter)myAdapter);
    TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot)this.e.findViewById(2131301725);
    tabPageIndicatorWithDot.setViewPager(this.f);
    tabPageIndicatorWithDot.setOnPageChangeListener(this.k);
  }
  
  private void k() {
    ImageView imageView = (ImageView)this.e.findViewById(2131296863);
    imageView.setImageDrawable(BluedSkinUtils.b(this.d, 2131232743));
    imageView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackVIP.a(VipProtos.Event.VOCATIVE_BACK_BTN_CLICK);
            this.a.getActivity().finish();
          }
        });
    this.e.findViewById(2131296867).setVisibility(8);
    this.e.findViewById(2131296871).setVisibility(8);
  }
  
  private void l() {
    this.g = new MyVisitorFragment();
    this.h = new MyVisitedFragment();
    this.i = new BaseFragment[2];
    BaseFragment[] arrayOfBaseFragment = this.i;
    arrayOfBaseFragment[0] = (BaseFragment)this.g;
    arrayOfBaseFragment[1] = (BaseFragment)this.h;
  }
  
  public void a(int paramInt) {
    if (paramInt < this.f.getAdapter().getCount())
      this.f.setCurrentItem(paramInt); 
  }
  
  protected void finalize() throws Throwable {
    super.finalize();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493363, paramViewGroup, false);
      k();
      a();
      l();
      VisitRecordSelectedTabObserver.a().a(this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    VisitRecordSelectedTabObserver.a().b(this);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    private String[] b = new String[] { VisitHistoryFragment.a(this.a).getResources().getString(2131756042), VisitHistoryFragment.a(this.a).getResources().getString(2131757817) };
    
    public MyAdapter(VisitHistoryFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return 2;
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)((param1Int != 0) ? ((param1Int != 1) ? null : VisitHistoryFragment.c(this.a)) : VisitHistoryFragment.b(this.a));
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return this.b[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\VisitHistoryFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */