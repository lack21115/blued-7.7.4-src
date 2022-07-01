package com.ss.android.downloadlib.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.downloadlib.g;
import com.ss.android.socialbase.downloader.downloader.f;
import java.io.File;

public class c {
  private static volatile c a;
  
  private Handler b = null;
  
  public static c a() {
    // Byte code:
    //   0: getstatic com/ss/android/downloadlib/a/c.a : Lcom/ss/android/downloadlib/a/c;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/downloadlib/a/c
    //   8: monitorenter
    //   9: getstatic com/ss/android/downloadlib/a/c.a : Lcom/ss/android/downloadlib/a/c;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/downloadlib/a/c
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/downloadlib/a/c.a : Lcom/ss/android/downloadlib/a/c;
    //   25: ldc com/ss/android/downloadlib/a/c
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/downloadlib/a/c
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/downloadlib/a/c.a : Lcom/ss/android/downloadlib/a/c;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(Context paramContext, com.ss.android.socialbase.downloader.g.c paramc) {
    if (!b())
      return; 
    if (paramc == null)
      return; 
    try {
      File file = new File(paramc.k(), paramc.h());
      if (file.isFile() && file.exists())
        file.delete(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    if (this.b == null)
      this.b = new Handler(Looper.getMainLooper()); 
    String str = paramc.j();
    f.a(paramContext).j(paramc.g());
    this.b.post(new Runnable(this, str) {
          public void run() {
            j.d().a(3, j.a(), null, "下载失败，请重试！", null, 0);
            f f = g.a().a(this.a);
            if (f != null)
              f.f(); 
          }
        });
  }
  
  public boolean b() {
    return (j.i().optInt("forbid_invalidte_download_file_install", 0) == 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */