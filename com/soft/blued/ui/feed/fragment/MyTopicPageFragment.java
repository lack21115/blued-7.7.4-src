package com.soft.blued.ui.feed.fragment;

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
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.PageTabLayout;
import com.soft.blued.ui.feed.adapter.MyTopicAdapter;
import java.util.ArrayList;
import java.util.List;

public class MyTopicPageFragment extends BaseFragment {
  public Context d;
  
  public View e;
  
  public ShapeTextView f;
  
  public PageTabLayout g;
  
  public ViewPager h;
  
  public List<String> i;
  
  private MyAdapter j;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, MyTopicPageFragment.class, null);
  }
  
  public void a() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300273);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(this.d.getResources().getString(2131758186));
    commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
  }
  
  public void k() {
    this.i = new ArrayList<String>();
    this.i.add(this.d.getResources().getString(2131756138));
    this.i.add(this.d.getResources().getString(2131757091));
    this.f = (ShapeTextView)this.e.findViewById(2131299939);
    ShapeHelper.b((ShapeHelper.ShapeView)this.f, 2131100881);
    this.g = (PageTabLayout)this.e.findViewById(2131300168);
    this.h = (ViewPager)this.e.findViewById(2131301616);
    this.g.setupWithViewPager(this.h);
    this.j = new MyAdapter(this, getChildFragmentManager());
    this.h.setAdapter((PagerAdapter)this.j);
    this.h.setOffscreenPageLimit(this.j.getCount());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493223, paramViewGroup, false);
      k();
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public class MyAdapter extends FragmentStatePagerAdapter {
    public MyAdapter(MyTopicPageFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return this.a.i.size();
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)((param1Int != 1) ? MyTopicSinglePageFragment.a(MyTopicAdapter.MY_TOPIC_PAGE.a) : MyTopicSinglePageFragment.a(MyTopicAdapter.MY_TOPIC_PAGE.b));
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return this.a.i.get(param1Int);
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      return super.instantiateItem(param1ViewGroup, param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\MyTopicPageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */