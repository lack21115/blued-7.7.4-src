package com.blued.android.modules;

import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.base.base.IBaseInterface;
import com.blued.android.module.base.shortvideo.IMusicList;
import com.blued.android.module.base.shortvideo.MusicListProxy;
import com.soft.blued.ui.video.fragment.MyMusicCollectionFragment;

public class MusicListModule {
  protected static IMusicList a = new IMusicList() {
      public void a(BaseFragment param1BaseFragment, int param1Int) {
        MyMusicCollectionFragment.a((Fragment)param1BaseFragment, param1Int);
      }
      
      public void b(BaseFragment param1BaseFragment, int param1Int) {
        MyMusicCollectionFragment.a((Fragment)param1BaseFragment, param1Int);
      }
    };
  
  public static void a() {
    MusicListProxy.a().a((IBaseInterface)a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\modules\MusicListModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */