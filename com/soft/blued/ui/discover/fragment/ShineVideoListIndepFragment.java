package com.soft.blued.ui.discover.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class ShineVideoListIndepFragment extends BaseFragment {
  public Context d;
  
  public View e;
  
  public ViewPager f;
  
  public MyAdapter g;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, ShineVideoListIndepFragment.class, null);
  }
  
  public void a() {
    this.f = (ViewPager)this.e.findViewById(2131301697);
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.setCenterText(2131758419);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.g = new MyAdapter(this, getChildFragmentManager());
    this.f.setAdapter((PagerAdapter)this.g);
    this.g.notifyDataSetChanged();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493319, paramViewGroup, false);
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(ShineVideoListIndepFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return 1;
    }
    
    public Fragment getItem(int param1Int) {
      ShineVideoListFragment shineVideoListFragment = new ShineVideoListFragment();
      Bundle bundle = new Bundle();
      bundle.putInt(ShineVideoListFragment.d, 1);
      shineVideoListFragment.setArguments(bundle);
      return (Fragment)shineVideoListFragment;
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return this.a.d.getResources().getString(2131758419);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\ShineVideoListIndepFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */