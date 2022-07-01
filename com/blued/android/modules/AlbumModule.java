package com.blued.android.modules;

import com.blued.android.module.base.album.AlbumProxy;
import com.blued.android.module.base.album.IAlbum;
import com.blued.android.module.base.base.IBaseInterface;
import com.soft.blued.ui.video.fragment.AlbumSelectFragment;

public class AlbumModule {
  protected static IAlbum a = new IAlbum() {
      public void a(Object param1Object, int param1Int1, int param1Int2, int param1Int3) {
        a(param1Object, param1Int1, 9, param1Int2, param1Int3);
      }
      
      public void a(Object param1Object, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
        AlbumSelectFragment.a(param1Object, param1Int1, 3, param1Int2, param1Int3, param1Int4);
      }
    };
  
  public static void a() {
    AlbumProxy.a().a((IBaseInterface)a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\modules\AlbumModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */