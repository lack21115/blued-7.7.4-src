package com.soft.blued.ui.find.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import com.soft.blued.utils.BluedPreferences;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeGuideFragment extends BaseFragment {
  private View d;
  
  private ViewPager e;
  
  private TextView f;
  
  private void a() {
    this.e = (ViewPager)this.d.findViewById(2131301672);
    this.f = (TextView)this.d.findViewById(2131300805);
    this.e.setAdapter((PagerAdapter)new GlidePagerAdapter(this, getChildFragmentManager()));
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (HomeGuideFragment.a(this.a).getCurrentItem() < 0) {
              HomeGuideFragment.a(this.a).setCurrentItem(HomeGuideFragment.a(this.a).getCurrentItem() + 1);
              return;
            } 
            if (HomeGuideFragment.a(this.a).getCurrentItem() == 0) {
              BluedPreferences.cg();
              this.a.getActivity().finish();
              ActivityChangeAnimationUtils.c((Activity)this.a.getActivity());
            } 
          }
        });
    this.f.setText(getResources().getString(2131756810));
    this.e.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            if (param1Int == 0) {
              HomeGuideFragment.b(this.a).setText(this.a.getResources().getString(2131756810));
              return;
            } 
            HomeGuideFragment.b(this.a).setText(this.a.getResources().getString(2131756811));
          }
        });
  }
  
  public boolean j() {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    try {
      this.d = paramLayoutInflater.inflate(2131492995, null);
      a();
    } catch (Exception exception) {
      this.d = (View)new RelativeLayout(getContext());
      getActivity().finish();
    } 
    return this.d;
  }
  
  class GlidePagerAdapter extends FragmentPagerAdapter {
    private int[] b;
    
    private int[] c;
    
    private int[] d;
    
    private List<HomeGuideFragment.GuideBean> e;
    
    public GlidePagerAdapter(HomeGuideFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
      int i = 0;
      this.b = new int[] { 2131232350 };
      this.c = new int[] { 2131756812 };
      this.d = new int[] { 2131756806 };
      this.e = new ArrayList<HomeGuideFragment.GuideBean>();
      while (i < this.b.length) {
        HomeGuideFragment.GuideBean guideBean = new HomeGuideFragment.GuideBean();
        guideBean.a = this.b[i];
        guideBean.b = this.c[i];
        guideBean.c = this.d[i];
        this.e.add(guideBean);
        i++;
      } 
    }
    
    public int getCount() {
      return 1;
    }
    
    public Fragment getItem(int param1Int) {
      GuideItemFragment guideItemFragment = new GuideItemFragment();
      Bundle bundle = new Bundle();
      bundle.putSerializable("data", this.e.get(param1Int));
      guideItemFragment.setArguments(bundle);
      return (Fragment)guideItemFragment;
    }
  }
  
  public static class GuideBean implements Serializable {
    public int a;
    
    public int b;
    
    public int c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\HomeGuideFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */