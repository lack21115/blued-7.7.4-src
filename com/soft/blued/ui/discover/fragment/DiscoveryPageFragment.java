package com.soft.blued.ui.discover.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.customview.bluedad.BluedADConstraintLayout;
import com.soft.blued.ui.discover.model.DiscoveryPageTabModel;
import com.soft.blued.ui.discover.presenter.DiscoveryPagePresenter;

public class DiscoveryPageFragment extends MvpFragment<DiscoveryPagePresenter> {
  @BindView(2131296537)
  BluedADConstraintLayout bluedAdLayout;
  
  @BindView(2131296863)
  ImageView cttLeft;
  
  @BindView(2131296867)
  ImageView cttRight;
  
  @BindView(2131296869)
  FrameLayout cttRightMenu;
  
  @BindView(2131296871)
  TextView cttRightText;
  
  private MyAdapter d;
  
  @BindView(2131297060)
  QBadgeContainer findBadgeContainer;
  
  @BindView(2131297530)
  ImageView imgNearbyAd;
  
  @BindView(2131297532)
  ShapeTextView imgNewRemindVisitor;
  
  @BindView(2131297551)
  ShapeTextView imgRightNewDot;
  
  @BindView(2131300273)
  View title;
  
  @BindView(2131301672)
  CustomViewPager viewPager;
  
  @BindView(2131301725)
  TabPageIndicatorWithDot vpIndicator;
  
  private void k() {
    if (StatusBarHelper.a())
      this.findBadgeContainer.setPadding(0, StatusBarHelper.a((Context)getActivity()), 0, 0); 
    this.cttLeft.setVisibility(4);
    this.title.setVisibility(0);
    this.cttRightMenu.setVisibility(8);
  }
  
  private void l() {
    if (this.d == null)
      this.d = new MyAdapter(this, getChildFragmentManager()); 
    this.viewPager.setAdapter((PagerAdapter)this.d);
    this.vpIndicator.setViewPager((ViewPager)this.viewPager);
    ViewGroup.LayoutParams layoutParams = this.vpIndicator.getLayoutParams();
    int i = DensityUtils.a(getContext(), 50.0F);
    ((ViewGroup.MarginLayoutParams)layoutParams).setMargins(i, 0, i, 0);
    this.vpIndicator.setLayoutParams(layoutParams);
    if (!BlueAppLocal.d())
      this.vpIndicator.setTabPaddingLeftRight(DensityUtils.a(getContext(), 5.0F)); 
    this.vpIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            this.a.vpIndicator.c(param1Int);
          }
        });
    a(2);
  }
  
  public void a(int paramInt) {
    paramInt = ((DiscoveryPagePresenter)s()).a(paramInt);
    if (paramInt >= 0 && paramInt < this.viewPager.getAdapter().getCount())
      this.viewPager.setCurrentItem(paramInt); 
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    k();
    l();
  }
  
  protected void a(Integer paramInteger) {
    if (paramInteger.intValue() >= 0 && paramInteger.intValue() < this.vpIndicator.e)
      this.vpIndicator.a(paramInteger.intValue()); 
  }
  
  protected void b(Integer paramInteger) {
    if (paramInteger.intValue() >= 0 && paramInteger.intValue() < this.vpIndicator.e)
      this.vpIndicator.c(paramInteger.intValue()); 
  }
  
  protected void c(Integer paramInteger) {
    if (paramInteger.intValue() >= 0 && this.d.getCount() > paramInteger.intValue())
      this.viewPager.setCurrentItem(paramInteger.intValue(), true); 
  }
  
  public int p() {
    return 2131493117;
  }
  
  public boolean z() {
    return true;
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(DiscoveryPageFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return ((DiscoveryPagePresenter)this.a.s()).m().size();
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)((DiscoveryPageTabModel)((DiscoveryPagePresenter)this.a.s()).m().get(param1Int)).getFragment();
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return ((DiscoveryPageTabModel)((DiscoveryPagePresenter)this.a.s()).m().get(param1Int)).title;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\DiscoveryPageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */