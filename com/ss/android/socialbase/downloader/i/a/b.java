package com.ss.android.socialbase.downloader.i.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.ss.android.socialbase.downloader.k.a;

public class b {
  static long a;
  
  static long b;
  
  private static final HandlerThread c = new HandlerThread("Downloader-preconnecter");
  
  private static final Handler d = new Handler(c.getLooper());
  
  static {
    d.post(new Runnable() {
          public void run() {
            Process.setThreadPriority(10);
          }
        });
  }
  
  public static void a() {
    a = a.b().a("preconnect_connection_outdate_time", 300000L);
    b = a.b().a("preconnect_head_info_outdate_time", 300000L);
    a.a().a(a.b().a("preconnect_max_cache_size", 3));
  }
  
  static {
    c.start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\i\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */