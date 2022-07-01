package com.blued.android.module.media.selector.adapter;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.blued.android.module.media.selector.contract.IAlbumPreviewBaseCallback;
import com.blued.android.module.media.selector.fragment.PhotoDetailFragment;
import com.blued.android.module.media.selector.present.AlbumPreviewBasePresenter;
import com.blued.android.module.player.media.model.MediaInfo;
import com.blued.android.module.player.media.model.VideoPlayConfig;

public class AlbumPreviewBaseAdapter extends FragmentStatePagerAdapter {
  private IAlbumPreviewBaseCallback a;
  
  public AlbumPreviewBaseAdapter(FragmentManager paramFragmentManager, IAlbumPreviewBaseCallback paramIAlbumPreviewBaseCallback) {
    super(paramFragmentManager);
    this.a = paramIAlbumPreviewBaseCallback;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
    super.destroyItem(paramViewGroup, paramInt, paramObject);
  }
  
  public int getCount() {
    return this.a.a();
  }
  
  public Fragment getItem(int paramInt) {
    MediaInfo mediaInfo = this.a.a(paramInt);
    if (mediaInfo != null) {
      String str1;
      if (!TextUtils.isEmpty(mediaInfo.imgUri)) {
        str1 = mediaInfo.imgUri;
      } else {
        str1 = mediaInfo.imagePath;
      } 
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
        str2 = mediaInfo.path; 
      if (mediaInfo.media_type == AlbumPreviewBasePresenter.g()) {
        VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
        videoPlayConfig.a = str2;
        videoPlayConfig.b = mediaInfo.path;
        videoPlayConfig.w = mediaInfo;
        videoPlayConfig.o = false;
        videoPlayConfig.p = false;
        videoPlayConfig.q = true;
        videoPlayConfig.r = false;
        videoPlayConfig.m = true;
        videoPlayConfig.j = true;
        videoPlayConfig.v = true;
        return (Fragment)this.a.a(videoPlayConfig);
      } 
      return (Fragment)PhotoDetailFragment.a(str2, null, false);
    } 
    return (Fragment)PhotoDetailFragment.a(null, null, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\adapter\AlbumPreviewBaseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */