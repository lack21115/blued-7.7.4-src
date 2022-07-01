package com.soft.blued.ui.group;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.ClickUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.TabPageIndicatorWithDot;

public class GroupSearchListFragment extends BaseFragment implements View.OnClickListener {
  private String d = GroupSearchListFragment.class.getSimpleName();
  
  private Context e;
  
  private View f;
  
  private TabPageIndicatorWithDot g;
  
  private ViewPager h;
  
  private MyPagerAdapter i;
  
  private String j;
  
  private ViewPager.OnPageChangeListener k = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
      
      public void onPageSelected(int param1Int) {}
    };
  
  private void a() {
    Bundle bundle = getArguments();
    if (bundle != null)
      this.j = bundle.getString("keywords"); 
  }
  
  public static void a(Context paramContext, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("keywords", paramString);
    TerminalActivity.d(paramContext, GroupSearchListFragment.class, bundle);
  }
  
  private void k() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.f.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(this.j);
    commonTopTitleNoTrans.setLeftClickListener(this);
    ((TextView)commonTopTitleNoTrans.findViewById(2131296857)).setOnTouchListener((View.OnTouchListener)new ClickUtils());
  }
  
  private void l() {
    this.g = (TabPageIndicatorWithDot)this.f.findViewById(2131297592);
    this.g.setOnPageChangeListener(this.k);
    this.h = (ViewPager)this.f.findViewById(2131299439);
    this.i = new MyPagerAdapter(this, getChildFragmentManager());
    this.h.setOffscreenPageLimit(2);
    this.h.setAdapter((PagerAdapter)this.i);
    this.g.setViewPager(this.h);
    this.g.setVisibility(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (this.i.a != null)
      this.i.a.onActivityResult(paramInt1, paramInt2, paramIntent); 
    if (this.i.b != null)
      this.i.b.onActivityResult(paramInt1, paramInt2, paramIntent); 
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    View view = this.f;
    if (view == null) {
      this.f = paramLayoutInflater.inflate(2131493143, paramViewGroup, false);
      a();
      k();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.f.getParent()).removeView(this.f);
    } 
    return this.f;
  }
  
  public class MyPagerAdapter extends FragmentPagerAdapter {
    public GroupSearchResultFragment a;
    
    public GroupSearchResultFragment b;
    
    private final String[] d = new String[] { this.c.getResources().getString(2131756805), this.c.getResources().getString(2131756804) };
    
    public MyPagerAdapter(GroupSearchListFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public int getCount() {
      return this.d.length;
    }
    
    public Fragment getItem(int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1)
          return null; 
        if (this.b == null)
          this.b = GroupSearchResultFragment.a(param1Int, GroupSearchListFragment.a(this.c)); 
        return (Fragment)this.b;
      } 
      if (this.a == null)
        this.a = GroupSearchResultFragment.a(param1Int, GroupSearchListFragment.a(this.c)); 
      return (Fragment)this.a;
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return this.d[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupSearchListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */