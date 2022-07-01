package com.blued.android.module.live_china.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFullModeFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveSimpleModeFragment;

public class LiveModePagerAdapter extends FragmentStatePagerAdapter {
  PlayingOnliveFragment a;
  
  FragmentManager b;
  
  public LiveModePagerAdapter(FragmentManager paramFragmentManager, PlayingOnliveFragment paramPlayingOnliveFragment) {
    super(paramFragmentManager);
    this.a = paramPlayingOnliveFragment;
    this.b = paramFragmentManager;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
    super.destroyItem(paramViewGroup, paramInt, paramObject);
  }
  
  public int getCount() {
    return this.a.cn;
  }
  
  public Fragment getItem(int paramInt) {
    return (Fragment)((paramInt != 0) ? ((paramInt != 1) ? null : PlayingOnliveSimpleModeFragment.a(this.a.t, this.a.u)) : PlayingOnliveFullModeFragment.a(this.a.t, this.a.u));
  }
  
  public int getItemPosition(Object paramObject) {
    return -2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\LiveModePagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */