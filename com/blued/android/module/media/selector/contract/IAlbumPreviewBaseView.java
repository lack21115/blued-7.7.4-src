package com.blued.android.module.media.selector.contract;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.player.media.model.VideoPlayConfig;

public interface IAlbumPreviewBaseView extends IBaseView {
  BaseFragment a();
  
  BaseFragment a(VideoPlayConfig paramVideoPlayConfig);
  
  void a(int paramInt);
  
  boolean a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  boolean a(AlbumSelectInfo paramAlbumSelectInfo);
  
  FragmentActivity getActivity();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\contract\IAlbumPreviewBaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */