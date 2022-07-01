package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.R;

public class LiveMusicDialogFragment extends LiveBaseDialogFragment {
  private IDialogEvent d;
  
  private long e;
  
  private int f;
  
  public void f() {
    if (getArguments() != null) {
      this.e = getArguments().getLong("lid");
      this.f = getArguments().getInt("from");
    } 
  }
  
  public int g() {
    return AppInfo.l;
  }
  
  public int h() {
    return AppInfo.m;
  }
  
  public int i() {
    return R.style.main_menu_animstyle;
  }
  
  public FragmentPagerAdapter j() {
    return new FragmentPagerAdapter(this, getChildFragmentManager()) {
        public int getCount() {
          return 1;
        }
        
        public Fragment getItem(int param1Int) {
          LiveMusicFragment liveMusicFragment = new LiveMusicFragment();
          Bundle bundle = new Bundle();
          bundle.putLong("lid", LiveMusicDialogFragment.a(this.a));
          liveMusicFragment.setArguments(bundle);
          return (Fragment)liveMusicFragment;
        }
      };
  }
  
  public void l() {
    IDialogEvent iDialogEvent = this.d;
    if (iDialogEvent != null)
      iDialogEvent.a(); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy() {
    super.onDestroy();
    l();
  }
  
  public static interface IDialogEvent {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveMusicDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */