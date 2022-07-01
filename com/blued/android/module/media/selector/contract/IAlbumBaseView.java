package com.blued.android.module.media.selector.contract;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.player.media.model.MediaInfo;

public interface IAlbumBaseView extends IBaseView {
  int S_();
  
  long T_();
  
  long U_();
  
  void a(boolean paramBoolean);
  
  void a(boolean paramBoolean, String paramString);
  
  boolean a(int paramInt, MediaInfo paramMediaInfo);
  
  boolean a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  boolean a(AlbumSelectInfo paramAlbumSelectInfo);
  
  BaseFragment b();
  
  void c();
  
  void d();
  
  void e();
  
  FragmentActivity getActivity();
  
  int i();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\contract\IAlbumBaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */