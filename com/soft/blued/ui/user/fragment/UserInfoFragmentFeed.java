package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.PageTabLayout;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.List;

public class UserInfoFragmentFeed extends BaseFragment implements View.OnClickListener {
  public Context d;
  
  public View e;
  
  public ShapeTextView f;
  
  public List<String> g;
  
  public CustomViewPager h;
  
  public MyAdapter i;
  
  public PageTabLayout j;
  
  private void a() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.setCenterText(getString(2131756501));
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.a();
  }
  
  private void a(int paramInt) {
    ((ImageView)this.j.a(paramInt).a().findViewById(2131299936)).setVisibility(0);
  }
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, UserInfoFragmentFeed.class, new Bundle());
  }
  
  private void b(int paramInt) {
    ((ImageView)this.j.a(paramInt).a().findViewById(2131299936)).setVisibility(8);
  }
  
  private void k() {
    this.g = new ArrayList<String>();
    for (String str : this.d.getResources().getStringArray(2130903111))
      this.g.add(str); 
  }
  
  private void l() {
    this.f = (ShapeTextView)this.e.findViewById(2131297034);
    ShapeHelper.b((ShapeHelper.ShapeView)this.f, 2131100881);
    this.h = (CustomViewPager)this.e.findViewById(2131301616);
    this.i = new MyAdapter(this, getChildFragmentManager());
    this.h.setAdapter((PagerAdapter)this.i);
    this.j = (PageTabLayout)this.e.findViewById(2131300168);
    this.j.setupWithViewPager((ViewPager)this.h);
    this.h.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            if (param1Int == 1) {
              UserInfoFragmentFeed.a(this.a, param1Int);
              BluedPreferences.cD();
            } 
          }
        });
    for (int i = 0; i < this.g.size(); i++) {
      View view = LayoutInflater.from(this.d).inflate(2131493659, null);
      ShapeTextView shapeTextView = (ShapeTextView)view.findViewById(2131299940);
      ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, 2131100838);
      shapeTextView.setText(this.g.get(i));
      this.j.a(i).a(view);
    } 
    if (BluedPreferences.cC())
      a(1); 
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
      this.e = paramLayoutInflater.inflate(2131493346, paramViewGroup, false);
      k();
      a();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public class MyAdapter extends FragmentStatePagerAdapter {
    public MyAdapter(UserInfoFragmentFeed this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return this.a.g.size();
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)((param1Int == 0) ? new UserInfoFragmentMyFeedTab() : new UserInfoFragmentMyZanTab());
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return this.a.g.get(param1Int);
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      return super.instantiateItem(param1ViewGroup, param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\UserInfoFragmentFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */