package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.soft.blued.customview.NoScrollH5ViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.http.H5Url;
import com.soft.blued.ui.web.NoTitleWebViewShowFragment;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LiveRankWebViewFragment extends BaseFragment implements View.OnClickListener {
  public int d = 2;
  
  private Context e;
  
  private ViewGroup f;
  
  private View g;
  
  private ImageView h;
  
  private ImageView i;
  
  private TabPageIndicatorWithDot j;
  
  private NoScrollH5ViewPager k;
  
  private MyAdapter l;
  
  private int m;
  
  private String n = "";
  
  private String o = "";
  
  private ViewPager.OnPageChangeListener p = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
      
      public void onPageSelected(int param1Int) {
        LiveRankWebViewFragment.a(this.a, param1Int);
      }
    };
  
  private String a(int paramInt, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("android:switcher:");
    stringBuilder.append(paramInt);
    stringBuilder.append(":");
    stringBuilder.append(paramLong);
    return stringBuilder.toString();
  }
  
  public static void a(Context paramContext, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putInt("INT_FIRST_PAGE", paramInt);
    TerminalActivity.d(paramContext, LiveRankWebViewFragment.class, bundle);
  }
  
  private void l() {
    this.n = H5Url.a(2);
    this.o = H5Url.a(3);
  }
  
  private void m() {
    this.g = this.f.findViewById(2131300273);
    this.h = (ImageView)this.f.findViewById(2131296863);
    this.h.setImageDrawable(BluedSkinUtils.b(this.e, 2131232743));
    this.h.setVisibility(0);
    this.h.setOnClickListener(this);
    this.i = (ImageView)this.f.findViewById(2131296867);
    this.i.setImageResource(2131232753);
    this.i.setVisibility(0);
    this.i.setOnClickListener(this);
  }
  
  public ViewGroup a(LayoutInflater paramLayoutInflater) {
    return (ViewGroup)paramLayoutInflater.inflate(2131493205, null);
  }
  
  public void a() {
    this.k = (NoScrollH5ViewPager)this.f.findViewById(2131301697);
    this.l = new MyAdapter(this, getChildFragmentManager());
    this.k.setAdapter((PagerAdapter)this.l);
    this.k.setOffscreenPageLimit(2);
    this.j = (TabPageIndicatorWithDot)this.f.findViewById(2131301725);
    this.j.setViewPager((ViewPager)this.k);
    this.j.setOnPageChangeListener(this.p);
    this.m = getArguments().getInt("INT_FIRST_PAGE");
    this.k.setCurrentItem(this.m);
  }
  
  protected void k() {
    if (w_() != null && w_().isActive())
      getActivity().finish(); 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      String str = a(this.k.getId(), this.m);
      ((NoTitleWebViewShowFragment)getChildFragmentManager().findFragmentByTag(str)).m();
      return;
    } 
    k();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    getActivity().getWindow().setSoftInputMode(18);
    this.e = (Context)getActivity();
    paramViewGroup = this.f;
    if (paramViewGroup == null) {
      this.f = a(paramLayoutInflater);
      l();
      m();
      a();
    } else if (paramViewGroup.getParent() != null) {
      ((ViewGroup)this.f.getParent()).removeView((View)this.f);
    } 
    return (View)this.f;
  }
  
  public static interface FIRST_PAGE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FirstPageDef {}
  
  public class MyAdapter extends FragmentPagerAdapter {
    FragmentManager a;
    
    private String[] c = LiveRankWebViewFragment.a(this.b).getResources().getStringArray(2130903089);
    
    public MyAdapter(LiveRankWebViewFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
      this.a = param1FragmentManager;
    }
    
    public NoTitleWebViewShowFragment a(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? null : (new NoTitleWebViewShowFragment()).a(LiveRankWebViewFragment.c(this.b))) : (new NoTitleWebViewShowFragment()).a(LiveRankWebViewFragment.b(this.b));
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return this.b.d;
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return this.c[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveRankWebViewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */