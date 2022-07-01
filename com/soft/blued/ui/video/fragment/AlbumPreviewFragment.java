package com.soft.blued.ui.video.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.media.selector.fragment.AlbumPreviewBaseFragment;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.soft.blued.ui.video.presenter.AlbumPreviewPresent;

public class AlbumPreviewFragment extends AlbumPreviewBaseFragment {
  private AlbumPreviewPresent g;
  
  private int h;
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, int paramInt2, int paramInt3) {
    Bundle bundle = b(paramInt2);
    bundle.putInt("from", paramInt1);
    TerminalActivity.a((Fragment)paramBaseFragment, AlbumPreviewFragment.class, bundle, paramInt3);
  }
  
  private void m() {
    if (getArguments() == null)
      return; 
    this.h = getArguments().getInt("from");
  }
  
  public boolean a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt2 == -1) {
      bool1 = bool2;
      if (paramInt1 == 1000) {
        bool1 = bool2;
        if (paramIntent != null) {
          bool1 = bool2;
          if (paramIntent.getBooleanExtra("close_page", false)) {
            getActivity().setResult(-1, paramIntent);
            getActivity().finish();
            bool1 = true;
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  public boolean a(AlbumSelectInfo paramAlbumSelectInfo) {
    if (paramAlbumSelectInfo != null) {
      AlbumPreviewPresent albumPreviewPresent = this.g;
      if (albumPreviewPresent != null) {
        albumPreviewPresent.a(a(), paramAlbumSelectInfo, this.h, 1000);
        return true;
      } 
    } 
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.g = new AlbumPreviewPresent();
    m();
    ShortVideoProxy.e().a(getClass().getSimpleName());
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroyView() {
    ShortVideoProxy.e().b(getClass().getSimpleName());
    super.onDestroyView();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\fragment\AlbumPreviewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */