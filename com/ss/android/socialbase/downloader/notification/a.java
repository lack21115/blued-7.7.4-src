package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.g.c;

public abstract class a {
  private int a;
  
  private long b;
  
  private long c;
  
  private String d;
  
  private int e = 0;
  
  private long f;
  
  private int g;
  
  private boolean h;
  
  public a(int paramInt, String paramString) {
    this.a = paramInt;
    this.d = paramString;
  }
  
  public int a() {
    return this.a;
  }
  
  public void a(int paramInt, com.ss.android.socialbase.downloader.e.a parama, boolean paramBoolean1, boolean paramBoolean2) {
    if (!paramBoolean2 && this.e == paramInt)
      return; 
    this.e = paramInt;
    a(parama, paramBoolean1);
  }
  
  public void a(long paramLong) {
    this.b = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2) {
    this.b = paramLong1;
    this.c = paramLong2;
    this.e = 4;
    a((com.ss.android.socialbase.downloader.e.a)null, false);
  }
  
  public void a(Notification paramNotification) {
    if (this.a != 0) {
      if (paramNotification == null)
        return; 
      b.a().a(this.a, this.e, paramNotification);
    } 
  }
  
  protected abstract void a(com.ss.android.socialbase.downloader.e.a parama, boolean paramBoolean);
  
  public void a(c paramc) {
    if (paramc == null)
      return; 
    this.a = paramc.g();
    this.d = paramc.i();
  }
  
  protected void a(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public long b() {
    return this.b;
  }
  
  public void b(long paramLong) {
    this.c = paramLong;
  }
  
  public long c() {
    return this.c;
  }
  
  public String d() {
    return this.d;
  }
  
  public int e() {
    return this.e;
  }
  
  public long f() {
    if (this.f == 0L)
      this.f = System.currentTimeMillis(); 
    return this.f;
  }
  
  public void g() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield g : I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield g : I
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	15	finally
  }
  
  public int h() {
    return this.g;
  }
  
  public boolean i() {
    return this.h;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\notification\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */