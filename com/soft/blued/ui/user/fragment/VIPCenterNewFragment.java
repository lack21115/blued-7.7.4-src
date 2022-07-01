package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
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
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.List;

public class VIPCenterNewFragment extends BaseFragment implements VIPBuyResultObserver.IVIPBuyResultObserver {
  public int d;
  
  public String e;
  
  public boolean f = false;
  
  private View g;
  
  private List<String> h;
  
  private Context i;
  
  private MyAdapter j;
  
  private CustomViewPager k;
  
  private ImageView l;
  
  private ImageView m;
  
  private TabPageIndicatorWithDot n;
  
  private TabPageIndicatorWithDot o;
  
  private View p;
  
  private View q;
  
  private float r = 0.0F;
  
  private float s = 0.0F;
  
  public static void a(Context paramContext, int paramInt, String paramString) {
    BluedConfig.b().d();
    if ((UserInfo.a().i()).vip_grade == 0) {
      Bundle bundle = new Bundle();
      bundle.putInt("KEY_TAB_INDEX", paramInt);
      bundle.putString("KEY_VIP_DETAIL", paramString);
      TerminalActivity.a(bundle);
      TerminalActivity.d(paramContext, VIPCenterNewFragment.class, bundle);
      return;
    } 
    VIPCenterTabPageFragment.a(paramContext, (UserInfo.a().i()).vip_grade, paramString);
  }
  
  public void a() {
    BluedConfig.b().d();
    getActivity().finish();
  }
  
  void a(float paramFloat, int paramInt) {
    if (paramInt == 2) {
      this.r = paramFloat;
    } else {
      this.s = paramFloat;
    } 
    if (this.k.getCurrentItem() == 0) {
      this.q.setAlpha(this.r);
      return;
    } 
    this.q.setAlpha(this.s);
  }
  
  public void a(int paramInt) {
    if (paramInt == 0) {
      this.l.setImageResource(2131232744);
      this.q.setAlpha(this.r);
      if (this.q.getAlpha() < 0.5F) {
        StatusBarHelper.a((Activity)getActivity(), false);
      } else {
        StatusBarHelper.a((Activity)getActivity(), true);
      } 
      this.n.setTextColor(2131100792);
      this.n.setTabTextColorUnfocused(2131100770);
      this.n.setIndicatorColor(2131100792);
      return;
    } 
    this.l.setImageResource(2131232743);
    this.q.setAlpha(this.s);
    StatusBarHelper.a((Activity)getActivity(), true);
    this.n.setTextColor(2131100806);
    this.n.setTabTextColorUnfocused(2131100769);
    this.n.setIndicatorColor(2131100806);
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    if (paramBoolean) {
      VIPCenterTabPageFragment.a(this.i, (UserInfo.a().i()).vip_grade, this.e);
      getActivity().finish();
    } 
  }
  
  public void a(Rect paramRect) {
    CustomViewPager customViewPager = this.k;
    if (customViewPager != null)
      customViewPager.setIgnoreRect(paramRect); 
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 || paramInt == 3)
      a(); 
    return super.a(paramInt, paramKeyEvent);
  }
  
  public void b(int paramInt) {
    int i = this.d;
    if (i != 0) {
      if (i == 1)
        return; 
      if (paramInt == 0 || paramInt == 1)
        this.k.setCurrentItem(paramInt); 
    } 
  }
  
  protected void k() {
    this.k = (CustomViewPager)this.g.findViewById(2131301616);
    this.h = new ArrayList<String>();
    this.h.add(this.i.getResources().getString(2131758972));
    this.h.add(this.i.getResources().getString(2131759236));
    this.j = new MyAdapter(this, getChildFragmentManager());
    this.k.setAdapter((PagerAdapter)this.j);
    this.l = (ImageView)this.g.findViewById(2131296863);
    this.m = (ImageView)this.g.findViewById(2131296864);
    this.l.setOnClickListener(new -$$Lambda$VIPCenterNewFragment$R7gJYKNFE2wFo98BI1UqzrcUhvM(this));
    this.m.setOnClickListener(new -$$Lambda$VIPCenterNewFragment$6b91iiBdzOcfcXA6TS7d-bo453M(this));
    this.n = (TabPageIndicatorWithDot)this.g.findViewById(2131301725);
    this.o = (TabPageIndicatorWithDot)this.g.findViewById(2131301726);
    this.p = this.g.findViewById(2131297165);
    this.q = this.g.findViewById(2131297166);
    this.o.setTextColor(2131100838);
    this.o.setTabTextColorUnfocused(2131100689);
    this.o.setIndicatorColor(2131100838);
    a(0);
    this.n.setViewPager((ViewPager)this.k);
    this.o.setViewPager((ViewPager)this.k);
    this.q.setAlpha(0.0F);
    this.p.setPadding(0, StatusBarHelper.a(this.i), 0, 0);
    this.q.setPadding(0, StatusBarHelper.a(this.i), 0, 0);
    int i = this.d;
    if (i == 0 || i == 1) {
      this.k.setCurrentItem(this.d);
    } else {
      this.k.setCurrentItem(0);
    } 
    this.n.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            Logger.a("center_page_selected", Integer.valueOf(param1Int));
            Rect rect = ((VIPCenterTabPageFragment)VIPCenterNewFragment.b(this.a).instantiateItem((ViewGroup)VIPCenterNewFragment.a(this.a), param1Int)).m();
            this.a.a(rect);
          }
        });
  }
  
  public int l() {
    return (this.k.getCurrentItem() == 0) ? 2 : 1;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.i = (Context)getActivity();
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493359, paramViewGroup, false);
      this.d = getArguments().getInt("KEY_TAB_INDEX", -1);
      this.e = getArguments().getString("KEY_VIP_DETAIL", "");
      k();
      StatusBarHelper.a((Activity)getActivity(), false);
      VIPBuyResultObserver.a().a(this, getLifecycle());
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    return this.g;
  }
  
  public class MyAdapter extends FragmentStatePagerAdapter {
    public MyAdapter(VIPCenterNewFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return VIPCenterNewFragment.c(this.a).size();
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)((param1Int != 0) ? VIPCenterTabPageFragment.a(1, this.a.e) : VIPCenterTabPageFragment.a(2, this.a.e));
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return VIPCenterNewFragment.c(this.a).get(param1Int);
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      return super.instantiateItem(param1ViewGroup, param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\VIPCenterNewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */