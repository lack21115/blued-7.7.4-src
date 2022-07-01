package com.soft.blued.ui.user.fragment;

import android.content.Context;
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
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.PreloadFragment;
import com.soft.blued.ui.user.observer.FollowAndFansSelectedTabObserver;
import com.soft.blued.ui.user.observer.SecretlyFollowedObserver;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import java.util.ArrayList;

public class FollowedTabsFragment extends PreloadFragment implements FollowAndFansSelectedTabObserver.IFollowAndFansSelectedTabObserver, SecretlyFollowedObserver.ISecretlyFollowedObserver {
  public String o = "";
  
  private Context p;
  
  private View q;
  
  private LayoutInflater r;
  
  private ViewPager s;
  
  private NormalFollowedFragment t;
  
  private SecretlyFollowedFragment u;
  
  private MyAdapter v;
  
  private ArrayList<BaseFragment> w = new ArrayList<BaseFragment>();
  
  private TextView x;
  
  private TextView y;
  
  private void t() {
    this.x = (TextView)this.q.findViewById(2131301120);
    this.x.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            FollowedTabsFragment.a(this.a).setCurrentItem(0);
          }
        });
    this.y = (TextView)this.q.findViewById(2131301311);
    this.y.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            FollowedTabsFragment.a(this.a).setCurrentItem(1);
          }
        });
    this.s = (ViewPager)this.q.findViewById(2131299192);
    this.s.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            if (param1Int != 0) {
              if (param1Int != 1)
                return; 
              FollowedTabsFragment.c(this.a).setTextColor(BluedSkinUtils.a(FollowedTabsFragment.b(this.a), 2131100842));
              FollowedTabsFragment.d(this.a).setTextColor(BluedSkinUtils.a(FollowedTabsFragment.b(this.a), 2131100838));
              return;
            } 
            FollowedTabsFragment.c(this.a).setTextColor(BluedSkinUtils.a(FollowedTabsFragment.b(this.a), 2131100838));
            FollowedTabsFragment.d(this.a).setTextColor(BluedSkinUtils.a(FollowedTabsFragment.b(this.a), 2131100842));
          }
        });
    this.u = new SecretlyFollowedFragment();
    this.t = new NormalFollowedFragment();
    this.w.clear();
    this.w.add(this.u);
    this.w.add(this.t);
    Bundle bundle = new Bundle();
    bundle.putString("uid", this.o);
    this.u.setArguments(bundle);
    this.t.setArguments(bundle);
    this.v = new MyAdapter(this, getChildFragmentManager());
    this.s.setAdapter((PagerAdapter)this.v);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {
    String str = this.p.getResources().getString(2131756540);
    if ((UserInfo.a().i()).vip_grade == 2 || (BluedConfig.b().j()).is_secretly_followed == 1 || paramInt1 > 0) {
      TextView textView = this.y;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(" ");
      stringBuilder.append(paramInt1);
      stringBuilder.append("/");
      stringBuilder.append(paramInt2);
      textView.setText(stringBuilder.toString());
      return;
    } 
    this.y.setText(str);
  }
  
  public void a(View paramView) {
    this.p = (Context)getActivity();
    this.q = paramView;
    this.r = LayoutInflater.from(this.p);
    paramView = this.r.inflate(2131493130, null);
    ((ViewGroup)this.q).addView(paramView);
    this.o = getArguments().getString("uid");
    SecretlyFollowedObserver.a().a(this);
    FollowAndFansSelectedTabObserver.a().a(this);
    t();
  }
  
  public void b(int paramInt) {
    if (paramInt >= 0 && paramInt < this.s.getChildCount())
      this.s.setCurrentItem(paramInt); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy() {
    super.onDestroy();
    SecretlyFollowedObserver.a().b(this);
    FollowAndFansSelectedTabObserver.a().b(this);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(FollowedTabsFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return FollowedTabsFragment.e(this.a).size();
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)((param1Int != 0) ? ((param1Int != 1) ? null : FollowedTabsFragment.g(this.a)) : FollowedTabsFragment.f(this.a));
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return "";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\FollowedTabsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */