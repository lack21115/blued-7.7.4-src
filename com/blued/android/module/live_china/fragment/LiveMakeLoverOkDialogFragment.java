package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import java.io.Serializable;

public class LiveMakeLoverOkDialogFragment extends LiveBaseDialogFragment {
  private IDialogEvent d;
  
  private long e;
  
  private int f;
  
  private LiveMakeLoverFansModel g;
  
  private LiveMakeLoverFansModel h;
  
  private String i;
  
  private boolean j;
  
  public void a(IDialogEvent paramIDialogEvent) {
    this.d = paramIDialogEvent;
  }
  
  public void f() {
    if (getArguments() != null) {
      this.e = getArguments().getLong("lid");
      this.f = getArguments().getInt("from");
      this.g = (LiveMakeLoverFansModel)getArguments().getSerializable("chosen");
      this.h = (LiveMakeLoverFansModel)getArguments().getSerializable("chooser");
      this.i = getArguments().getString("apngLocalUrl");
      this.j = getArguments().getBoolean("confirm");
    } 
  }
  
  public int g() {
    return AppInfo.l;
  }
  
  public int h() {
    return AppInfo.m;
  }
  
  public int i() {
    return 0;
  }
  
  public FragmentPagerAdapter j() {
    return new FragmentPagerAdapter(this, getChildFragmentManager()) {
        public int getCount() {
          return 1;
        }
        
        public Fragment getItem(int param1Int) {
          if (LiveMakeLoverOkDialogFragment.a(this.a)) {
            LiveMakeLoverOkFragment liveMakeLoverOkFragment = new LiveMakeLoverOkFragment();
            Bundle bundle1 = new Bundle();
            bundle1.putLong("lid", LiveMakeLoverOkDialogFragment.b(this.a));
            bundle1.putSerializable("chosen", (Serializable)LiveMakeLoverOkDialogFragment.c(this.a));
            bundle1.putSerializable("chooser", (Serializable)LiveMakeLoverOkDialogFragment.d(this.a));
            liveMakeLoverOkFragment.setArguments(bundle1);
            return (Fragment)liveMakeLoverOkFragment;
          } 
          LiveMakeLoverMatchFragment liveMakeLoverMatchFragment = new LiveMakeLoverMatchFragment();
          Bundle bundle = new Bundle();
          bundle.putLong("lid", LiveMakeLoverOkDialogFragment.b(this.a));
          bundle.putInt("from", LiveMakeLoverOkDialogFragment.e(this.a));
          bundle.putSerializable("chosen", (Serializable)LiveMakeLoverOkDialogFragment.c(this.a));
          bundle.putSerializable("chooser", (Serializable)LiveMakeLoverOkDialogFragment.d(this.a));
          bundle.putString("apngLocalUrl", LiveMakeLoverOkDialogFragment.f(this.a));
          liveMakeLoverMatchFragment.setArguments(bundle);
          return (Fragment)liveMakeLoverMatchFragment;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveMakeLoverOkDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */