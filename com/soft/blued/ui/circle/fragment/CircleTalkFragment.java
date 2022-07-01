package com.soft.blued.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.PageTabLayout;
import java.util.ArrayList;
import java.util.List;

public class CircleTalkFragment extends BaseFragment implements View.OnClickListener {
  public Context d;
  
  public View e;
  
  public List<String> f;
  
  public CustomViewPager g;
  
  public MyAdapter h;
  
  public PageTabLayout i;
  
  private void a() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.setCenterText(getString(2131758179));
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.e();
  }
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, CircleTalkFragment.class, new Bundle());
  }
  
  private void k() {
    this.f = new ArrayList<String>();
    for (String str : this.d.getResources().getStringArray(2130903095))
      this.f.add(str); 
  }
  
  private void l() {
    this.g = (CustomViewPager)this.e.findViewById(2131301616);
    this.h = new MyAdapter(this, getChildFragmentManager());
    this.g.setAdapter((PagerAdapter)this.h);
    this.i = (PageTabLayout)this.e.findViewById(2131300168);
    this.i.setupWithViewPager((ViewPager)this.g);
    this.g.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {}
        });
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493241, paramViewGroup, false);
      k();
      a();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public class MyAdapter extends FragmentStatePagerAdapter {
    public MyAdapter(CircleTalkFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return this.a.f.size();
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)((param1Int == 0) ? new CircleMyPublishFragment() : new CircleMyRespondFragment());
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return this.a.f.get(param1Int);
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      return super.instantiateItem(param1ViewGroup, param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleTalkFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */