package com.soft.blued.ui.tag_show;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.ui.feed.fragment.SuperTopicDetailFragment;

public class UserTagCombineFragment extends BaseFragment {
  public static String d = "TAG";
  
  public static String e = "TAGID";
  
  public static String f = "tab";
  
  public String g;
  
  public String h;
  
  public int i = 0;
  
  private Context j;
  
  private View k;
  
  private CommonTopTitleNoTrans l;
  
  private ViewPager m;
  
  private TagUserFragment n;
  
  private TagGroupFragment o;
  
  private SuperTopicDetailFragment p;
  
  private TabPageIndicatorWithDot q;
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putString(e, paramString1);
    bundle.putString(d, paramString2);
    bundle.putInt(f, paramInt);
    TerminalActivity.d(paramContext, UserTagCombineFragment.class, bundle);
  }
  
  private void k() {
    Bundle bundle = new Bundle();
    bundle.putString(TagUserFragment.e, this.h);
    bundle.putString(TagUserFragment.d, this.g);
    this.n = new TagUserFragment();
    this.n.setArguments(bundle);
    bundle = new Bundle();
    bundle.putString(TagGroupFragment.j, this.g);
    this.o = new TagGroupFragment();
    this.o.setArguments(bundle);
    bundle = new Bundle();
    bundle.putString("topic", this.g);
    bundle.putBoolean("if_hide_title", true);
    this.p = new SuperTopicDetailFragment();
    this.p.setArguments(bundle);
  }
  
  private void l() {
    this.m = (ViewPager)this.k.findViewById(2131299192);
    MyAdapter myAdapter = new MyAdapter(this, getChildFragmentManager());
    this.m.setAdapter((PagerAdapter)myAdapter);
    this.m.setOffscreenPageLimit(2);
    this.q = (TabPageIndicatorWithDot)this.k.findViewById(2131297592);
    this.q.setViewPager(this.m);
    this.m.setCurrentItem(this.i);
  }
  
  private void m() {
    this.l = (CommonTopTitleNoTrans)this.k.findViewById(2131300300);
    this.l.a();
    this.l.setCenterText("");
    this.l.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    Bundle bundle = getArguments();
    if (bundle == null)
      return; 
    this.g = bundle.getString(d);
    this.h = bundle.getString(e);
    this.i = bundle.getInt(f);
    int i = this.i;
    if (i < 0 || i >= 2)
      this.i = 0; 
    if (!TextUtils.isEmpty(this.g))
      this.l.setCenterText(this.g); 
  }
  
  public String[] a() {
    return new String[] { this.j.getResources().getString(2131758195) };
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.j = (Context)getActivity();
    View view = this.k;
    if (view == null) {
      this.k = paramLayoutInflater.inflate(2131493329, paramViewGroup, false);
      m();
      k();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.k.getParent()).removeView(this.k);
    } 
    return this.k;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    private String[] b = this.a.a();
    
    public MyAdapter(UserTagCombineFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return this.b.length;
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)((param1Int != 0) ? null : UserTagCombineFragment.a(this.a));
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return this.b[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\tag_show\UserTagCombineFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */