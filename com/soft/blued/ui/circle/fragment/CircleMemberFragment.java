package com.soft.blued.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.PageTabLayout;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.ui.circle.presenter.CircleJoinMemberPresenter;
import com.soft.blued.ui.circle.presenter.CircleMemberPresenter;

public class CircleMemberFragment extends MvpFragment<CircleMemberPresenter> {
  private MyAdapter d;
  
  @BindView(2131297163)
  FrameLayout flTabTitle;
  
  @BindView(2131299938)
  ShapeTextView shapeTab;
  
  @BindView(2131300167)
  PageTabLayout tabLayout;
  
  @BindView(2131300300)
  CommonTopTitleNoTrans topTitle;
  
  @BindView(2131301616)
  CustomViewPager viewPager;
  
  public static void a(Context paramContext, MyCircleModel paramMyCircleModel) {
    if (paramMyCircleModel != null) {
      if (TextUtils.isEmpty(paramMyCircleModel.circle_id))
        return; 
      Bundle bundle = new Bundle();
      bundle.putInt("admin_level", paramMyCircleModel.admin_level);
      bundle.putString("circle_id", paramMyCircleModel.circle_id);
      TerminalActivity.d(paramContext, CircleMemberFragment.class, bundle);
    } 
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    if (((CircleMemberPresenter)s()).m().size() > 1) {
      this.topTitle.setCenterText(2131755885);
      this.flTabTitle.setVisibility(0);
    } else {
      this.topTitle.setCenterText(2131755904);
      this.flTabTitle.setVisibility(8);
    } 
    this.topTitle.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
    this.d = new MyAdapter(this, getChildFragmentManager());
    this.viewPager.setAdapter((PagerAdapter)this.d);
    this.tabLayout.setupWithViewPager((ViewPager)this.viewPager);
    this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {}
        });
  }
  
  public int p() {
    return 2131493096;
  }
  
  public class MyAdapter extends FragmentStatePagerAdapter {
    public MyAdapter(CircleMemberFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return ((CircleMemberPresenter)this.a.s()).m().size();
    }
    
    public Fragment getItem(int param1Int) {
      Bundle bundle = new Bundle();
      bundle.putString("circle_id", ((CircleMemberPresenter)this.a.s()).o());
      bundle.putInt("admin_level", ((CircleMemberPresenter)this.a.s()).p());
      if (param1Int == 0) {
        CircleJoinMemberFragment<CircleJoinMemberPresenter> circleJoinMemberFragment = new CircleJoinMemberFragment<CircleJoinMemberPresenter>();
        circleJoinMemberFragment.setArguments(bundle);
        return (Fragment)circleJoinMemberFragment;
      } 
      CircleMuteMemberFragment circleMuteMemberFragment = new CircleMuteMemberFragment();
      circleMuteMemberFragment.setArguments(bundle);
      return (Fragment)circleMuteMemberFragment;
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return ((CircleMemberPresenter)this.a.s()).m().get(param1Int);
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      return super.instantiateItem(param1ViewGroup, param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleMemberFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */