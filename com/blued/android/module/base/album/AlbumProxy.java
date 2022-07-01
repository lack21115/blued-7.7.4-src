package com.blued.android.module.base.album;

import com.blued.android.module.base.base.BaseProxy;

public class AlbumProxy extends BaseProxy<IAlbum> implements IAlbum {
  private static AlbumProxy b;
  
  public static AlbumProxy a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/base/album/AlbumProxy.b : Lcom/blued/android/module/base/album/AlbumProxy;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/base/album/AlbumProxy
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/base/album/AlbumProxy.b : Lcom/blued/android/module/base/album/AlbumProxy;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/base/album/AlbumProxy
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/base/album/AlbumProxy.b : Lcom/blued/android/module/base/album/AlbumProxy;
    //   25: ldc com/blued/android/module/base/album/AlbumProxy
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/base/album/AlbumProxy
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/base/album/AlbumProxy.b : Lcom/blued/android/module/base/album/AlbumProxy;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3) {
    if (this.a != null)
      ((IAlbum)this.a).a(paramObject, paramInt1, paramInt2, paramInt3); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\base\album\AlbumProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */