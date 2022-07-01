package com.blued.android.module.base.shortvideo;

import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.base.base.BaseProxy;

public class MusicListProxy extends BaseProxy<IMusicList> implements IMusicList {
  private static MusicListProxy b;
  
  public static MusicListProxy a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/base/shortvideo/MusicListProxy.b : Lcom/blued/android/module/base/shortvideo/MusicListProxy;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/base/shortvideo/MusicListProxy
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/base/shortvideo/MusicListProxy.b : Lcom/blued/android/module/base/shortvideo/MusicListProxy;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/base/shortvideo/MusicListProxy
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/base/shortvideo/MusicListProxy.b : Lcom/blued/android/module/base/shortvideo/MusicListProxy;
    //   25: ldc com/blued/android/module/base/shortvideo/MusicListProxy
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/base/shortvideo/MusicListProxy
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/base/shortvideo/MusicListProxy.b : Lcom/blued/android/module/base/shortvideo/MusicListProxy;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(BaseFragment paramBaseFragment, int paramInt) {
    if (this.a != null)
      ((IMusicList)this.a).a(paramBaseFragment, paramInt); 
  }
  
  public void b(BaseFragment paramBaseFragment, int paramInt) {
    if (this.a != null)
      ((IMusicList)this.a).b(paramBaseFragment, paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\base\shortvideo\MusicListProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */