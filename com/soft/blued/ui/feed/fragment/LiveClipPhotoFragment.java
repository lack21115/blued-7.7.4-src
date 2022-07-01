package com.soft.blued.ui.feed.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.soft.blued.utils.Logger;

public class LiveClipPhotoFragment extends LiveBaseDialogFragment<LiveMakeLoverFansModel> {
  private String d;
  
  private String e;
  
  private int f;
  
  public void a(LiveMakeLoverFansModel paramLiveMakeLoverFansModel) {
    super.a(paramLiveMakeLoverFansModel);
    Logger.e("LiveClipPhotoFragment", new Object[] { "onDismiss result = " });
    if (getParentFragment() != null && getParentFragment() instanceof LiveBaseDialogFragment) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onDismiss parentFragment = ");
      stringBuilder.append(getParentFragment().getClass().getSimpleName());
      Logger.e("LiveClipPhotoFragment", new Object[] { stringBuilder.toString() });
      ((LiveBaseDialogFragment)getParentFragment()).a(paramLiveMakeLoverFansModel);
    } 
    dismiss();
  }
  
  public void f() {
    if (getArguments() != null) {
      this.e = getArguments().getString("select_http_url");
      this.d = getArguments().getString("photo_path");
      this.f = getArguments().getInt("select_photo");
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
          ClipPhotoFragment clipPhotoFragment = new ClipPhotoFragment();
          Bundle bundle = new Bundle();
          bundle.putString("select_http_url", LiveClipPhotoFragment.a(this.a));
          bundle.putString("photo_path", LiveClipPhotoFragment.b(this.a));
          bundle.putInt("select_photo", LiveClipPhotoFragment.c(this.a));
          clipPhotoFragment.setArguments(bundle);
          return (Fragment)clipPhotoFragment;
        }
      };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\LiveClipPhotoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */