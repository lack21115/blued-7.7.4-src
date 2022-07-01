package com.ss.android.downloadlib;

import android.content.Context;
import com.ss.android.a.a.a;
import com.ss.android.a.a.b.a;
import com.ss.android.a.a.b.a.a;
import com.ss.android.a.a.b.b;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.b.d;
import com.ss.android.downloadad.a.a;
import com.ss.android.downloadad.a.b;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.c.a;
import com.ss.android.downloadlib.c.b;
import com.ss.android.downloadlib.c.c;
import com.ss.android.socialbase.appdownloader.c.c;
import com.ss.android.socialbase.appdownloader.c.d;
import com.ss.android.socialbase.appdownloader.c.g;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.downloader.f;

public class h {
  private static volatile h a;
  
  private a b = new e();
  
  private f c = g.a();
  
  private a d;
  
  private b e;
  
  private long f = System.currentTimeMillis();
  
  private h(Context paramContext) {
    b(paramContext);
  }
  
  public static h a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/ss/android/downloadlib/h.a : Lcom/ss/android/downloadlib/h;
    //   3: ifnonnull -> 38
    //   6: ldc com/ss/android/downloadlib/h
    //   8: monitorenter
    //   9: getstatic com/ss/android/downloadlib/h.a : Lcom/ss/android/downloadlib/h;
    //   12: ifnonnull -> 26
    //   15: new com/ss/android/downloadlib/h
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/ss/android/downloadlib/h.a : Lcom/ss/android/downloadlib/h;
    //   26: ldc com/ss/android/downloadlib/h
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/ss/android/downloadlib/h
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/ss/android/downloadlib/h.a : Lcom/ss/android/downloadlib/h;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void b(Context paramContext) {
    j.a(paramContext);
    f.a(j.a());
    c.a().b();
    d.h().a(j.a(), "misc_config", (c)new c(), (d)new b(paramContext), new c());
    d.h().a((g)new a());
  }
  
  private f h() {
    return this.c;
  }
  
  public a a() {
    return this.b;
  }
  
  public void a(Context paramContext, int paramInt, d paramd, c paramc) {
    h().a(paramContext, paramInt, paramd, paramc);
  }
  
  public void a(a parama) {
    h().a(parama);
  }
  
  public void a(String paramString, int paramInt) {
    h().a(paramString, paramInt);
  }
  
  public void a(String paramString, long paramLong, int paramInt) {
    h().a(paramString, paramLong, paramInt);
  }
  
  public void a(String paramString, long paramLong, int paramInt, b paramb, a parama) {
    h().a(paramString, paramLong, paramInt, paramb, parama);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    h().a(paramString, paramBoolean);
  }
  
  public long b() {
    return this.f;
  }
  
  public void c() {
    this.f = System.currentTimeMillis();
  }
  
  public a d() {
    if (this.d == null)
      this.d = a.a(); 
    return this.d;
  }
  
  public b e() {
    if (this.e == null)
      this.e = b.a(); 
    return this.e;
  }
  
  public String f() {
    return j.m();
  }
  
  public void g() {
    d.a().c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */