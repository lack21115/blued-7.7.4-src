package com.blued.android.module.common.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.blued.android.core.ui.BaseFragment;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseViewPagerFragmentPagerAdapter extends FragmentStatePagerAdapter {
  FragmentManager a;
  
  protected List<BaseFragment> b = new ArrayList<BaseFragment>();
  
  protected List<String> c = new ArrayList<String>();
  
  private int d;
  
  private int e;
  
  public BaseViewPagerFragmentPagerAdapter(FragmentManager paramFragmentManager) {
    super(paramFragmentManager);
    this.a = paramFragmentManager;
  }
  
  private String a(int paramInt, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("android:switcher:");
    stringBuilder.append(paramInt);
    stringBuilder.append(":");
    stringBuilder.append(paramLong);
    return stringBuilder.toString();
  }
  
  public void a(int paramInt) {
    this.d = paramInt;
  }
  
  public void a(List<BaseFragment> paramList) {
    this.b = paramList;
  }
  
  protected abstract BaseFragment b(int paramInt);
  
  public void b(List<String> paramList) {
    this.c = paramList;
  }
  
  public int getCount() {
    int i = this.e;
    return (i > 0) ? i : this.b.size();
  }
  
  public Fragment getItem(int paramInt) {
    BaseFragment baseFragment2;
    BaseFragment baseFragment1;
    String str = a(this.d, paramInt);
    if (paramInt < this.b.size()) {
      if (this.b.get(paramInt) == null) {
        Fragment fragment4 = this.a.findFragmentByTag(str);
        Fragment fragment3 = fragment4;
        if (fragment4 == null)
          baseFragment2 = b(paramInt); 
        this.b.set(paramInt, baseFragment2);
        return (Fragment)baseFragment2;
      } 
      return (Fragment)this.b.get(paramInt);
    } 
    Fragment fragment2 = this.a.findFragmentByTag((String)baseFragment2);
    Fragment fragment1 = fragment2;
    if (fragment2 == null)
      baseFragment1 = b(paramInt); 
    this.b.add(baseFragment1);
    return (Fragment)baseFragment1;
  }
  
  public CharSequence getPageTitle(int paramInt) {
    return this.c.get(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\adapter\BaseViewPagerFragmentPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */