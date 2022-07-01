package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.ui.setting.fragment.FriendslistFragment;
import com.soft.blued.ui.user.observer.FollowAndFansSelectedTabObserver;
import com.soft.blued.user.UserInfo;
import java.util.ArrayList;

public class FollowedAndFansFragment extends BaseFragment implements FollowAndFansSelectedTabObserver.IFollowAndFansSelectedTabObserver {
  private Context d;
  
  private View e;
  
  private View f;
  
  private ImageView g;
  
  private ImageView h;
  
  private ViewPager i;
  
  private BaseFragment j;
  
  private FansFragment k;
  
  private FriendslistFragment l;
  
  private MyAdapter m;
  
  private ArrayList<BaseFragment> n = new ArrayList<BaseFragment>();
  
  private String o = "";
  
  private void a() {
    if (getArguments() != null) {
      if ("fans".equals(getArguments().getString("followed_or_fan")))
        this.i.setCurrentItem(1); 
      if ("followed".equals(getArguments().getString("followed_or_fan")))
        this.i.setCurrentItem(0); 
    } 
  }
  
  public static void a(Context paramContext, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("uid", paramString);
    TerminalActivity.d(paramContext, FollowedAndFansFragment.class, bundle);
  }
  
  private void k() {
    this.f = this.e.findViewById(2131300273);
    this.f.setVisibility(0);
    this.g = (ImageView)this.f.findViewById(2131296863);
    this.h = (ImageView)this.f.findViewById(2131296867);
    this.g.setVisibility(0);
    this.g.setImageDrawable(BluedSkinUtils.b(this.d, 2131232743));
    this.h.setVisibility(4);
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
  }
  
  private void l() {
    this.i = (ViewPager)this.e.findViewById(2131299192);
    this.k = new FansFragment();
    if (m()) {
      this.j = (BaseFragment)new FollowedTabsFragment();
    } else {
      this.j = (BaseFragment)new NormalFollowedFragment();
    } 
    this.l = new FriendslistFragment();
    this.n.clear();
    this.n.add(this.k);
    this.n.add(this.j);
    if (m())
      this.n.add(this.l); 
    Bundle bundle = new Bundle();
    bundle.putString("uid", this.o);
    this.k.setArguments(bundle);
    this.j.setArguments(bundle);
    this.l.setArguments(bundle);
    this.m = new MyAdapter(this, getChildFragmentManager());
    this.i.setAdapter((PagerAdapter)this.m);
    ((TabPageIndicatorWithDot)this.e.findViewById(2131301725)).setViewPager(this.i);
  }
  
  private boolean m() {
    return TextUtils.isEmpty(this.o) ? false : (this.o.equals(UserInfo.a().i().getUid()));
  }
  
  public void a(int paramInt) {
    if (paramInt < this.i.getAdapter().getCount())
      this.i.setCurrentItem(paramInt); 
  }
  
  public void b(int paramInt) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493129, paramViewGroup, false);
      this.o = getArguments().getString("uid");
      k();
      l();
      a();
      FollowAndFansSelectedTabObserver.a().a(this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    FollowAndFansSelectedTabObserver.a().b(this);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(FollowedAndFansFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return FollowedAndFansFragment.c(this.a).size();
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)((param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : FollowedAndFansFragment.f(this.a)) : FollowedAndFansFragment.e(this.a)) : FollowedAndFansFragment.d(this.a));
    }
    
    public CharSequence getPageTitle(int param1Int) {
      if (FollowedAndFansFragment.a(this.a)) {
        (new String[3])[0] = FollowedAndFansFragment.b(this.a).getResources().getString(2131755359);
        (new String[3])[1] = FollowedAndFansFragment.b(this.a).getResources().getString(2131756380);
        (new String[3])[2] = FollowedAndFansFragment.b(this.a).getResources().getString(2131756565);
        return (new String[3])[param1Int];
      } 
      String[] arrayOfString = new String[2];
      arrayOfString[0] = FollowedAndFansFragment.b(this.a).getResources().getString(2131755359);
      arrayOfString[1] = FollowedAndFansFragment.b(this.a).getResources().getString(2131756380);
      return (param1Int < arrayOfString.length) ? arrayOfString[param1Int] : arrayOfString[arrayOfString.length - 1];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\FollowedAndFansFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */