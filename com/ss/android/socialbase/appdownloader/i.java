package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.g.c;
import java.util.ArrayDeque;
import java.util.Queue;

public class i {
  private Queue<Integer> a = new ArrayDeque<Integer>();
  
  private boolean b = false;
  
  private long c;
  
  private long d;
  
  private Handler e = new Handler(Looper.getMainLooper());
  
  private Runnable f = new Runnable(this) {
      public void run() {
        i.a(this.a);
      }
    };
  
  private i() {
    com.ss.android.socialbase.downloader.a.a.a().a(new com.ss.android.socialbase.downloader.a.a.a(this) {
          public void b() {
            long l = com.ss.android.socialbase.downloader.k.a.b().a("install_on_resume_install_interval", 300000L);
            if (System.currentTimeMillis() - i.b(this.a) < l)
              return; 
            i.a(this.a, System.currentTimeMillis());
            i.a(this.a);
          }
          
          public void c() {}
        });
  }
  
  public static i a() {
    return a.a();
  }
  
  private int b(Context paramContext, int paramInt, boolean paramBoolean) {
    paramInt = c.b(paramContext, paramInt, paramBoolean);
    if (paramInt == 1)
      this.b = true; 
    this.c = System.currentTimeMillis();
    return paramInt;
  }
  
  private void b() {
    Integer integer = this.a.poll();
    this.e.removeCallbacks(this.f);
    if (integer != null) {
      Context context = b.B();
      if (Looper.myLooper() != Looper.getMainLooper()) {
        this.e.post(new Runnable(this, context, integer) {
              public void run() {
                i.a(this.c, this.a, this.b.intValue(), false);
              }
            });
      } else {
        b(context, integer.intValue(), false);
      } 
      this.e.postDelayed(this.f, 20000L);
      return;
    } 
    this.b = false;
  }
  
  private boolean c() {
    return (System.currentTimeMillis() - this.c < 1000L);
  }
  
  public int a(Context paramContext, int paramInt, boolean paramBoolean) {
    if (paramBoolean)
      return b(paramContext, paramInt, paramBoolean); 
    if (c()) {
      this.e.postDelayed(new Runnable(this, paramContext, paramInt, paramBoolean) {
            public void run() {
              this.d.a(this.a, this.b, this.c);
            }
          }1000L);
      return 1;
    } 
    if (com.ss.android.socialbase.downloader.a.a.a().c())
      return b(paramContext, paramInt, paramBoolean); 
    if (this.a.isEmpty() && !this.b)
      return b(paramContext, paramInt, paramBoolean); 
    int j = com.ss.android.socialbase.downloader.k.a.b().a("install_queue_size", 3);
    while (this.a.size() > j)
      this.a.poll(); 
    this.e.removeCallbacks(this.f);
    long l = com.ss.android.socialbase.downloader.k.a.a(paramInt).a("install_queue_timeout", 20000L);
    this.e.postDelayed(this.f, l);
    if (!this.a.contains(Integer.valueOf(paramInt)))
      this.a.offer(Integer.valueOf(paramInt)); 
    return 1;
  }
  
  void a(c paramc, String paramString) {
    if (paramc != null && !TextUtils.isEmpty(paramString))
      b(); 
  }
  
  static class a {
    private static final i a = new i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */