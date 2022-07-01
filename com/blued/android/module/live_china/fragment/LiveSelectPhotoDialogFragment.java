package com.blued.android.module.live_china.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.same.Logger;

public class LiveSelectPhotoDialogFragment extends LiveBaseDialogFragment<LiveMakeLoverFansModel> {
  public void a(LiveMakeLoverFansModel paramLiveMakeLoverFansModel) {
    super.a(paramLiveMakeLoverFansModel);
    Logger.d("LiveSelectPhotoDialogFragment", new Object[] { "clip sucess image path" });
    b(paramLiveMakeLoverFansModel);
    dismiss();
  }
  
  public void f() {}
  
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
          return (Fragment)new LiveShowPhotosFragment();
        }
      };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveSelectPhotoDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */