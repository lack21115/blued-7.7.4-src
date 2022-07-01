package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.blued.android.core.AppInfo;
import java.util.ArrayList;

public class LivePictureFragment extends LiveBaseDialogFragment {
  private ArrayList<String> d;
  
  public void f() {
    if (getArguments() != null)
      this.d = getArguments().getStringArrayList("picture_url_list"); 
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
          LivePhotoDetailFragment livePhotoDetailFragment = new LivePhotoDetailFragment();
          Bundle bundle = new Bundle();
          bundle.putStringArrayList("picture_url_list", LivePictureFragment.a(this.a));
          livePhotoDetailFragment.setArguments(bundle);
          return (Fragment)livePhotoDetailFragment;
        }
      };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LivePictureFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */