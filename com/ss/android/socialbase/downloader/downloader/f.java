package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.b.h;
import com.ss.android.socialbase.downloader.d.q;
import com.ss.android.socialbase.downloader.d.w;
import com.ss.android.socialbase.downloader.d.z;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.d;
import java.util.List;

public class f {
  private static volatile f a;
  
  private f() {}
  
  f(g paramg) {
    b.a(paramg);
  }
  
  public static f a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/f.a : Lcom/ss/android/socialbase/downloader/downloader/f;
    //   3: ifnonnull -> 41
    //   6: ldc com/ss/android/socialbase/downloader/downloader/f
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/f.a : Lcom/ss/android/socialbase/downloader/downloader/f;
    //   12: ifnonnull -> 29
    //   15: aload_0
    //   16: invokestatic a : (Landroid/content/Context;)V
    //   19: new com/ss/android/socialbase/downloader/downloader/f
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: putstatic com/ss/android/socialbase/downloader/downloader/f.a : Lcom/ss/android/socialbase/downloader/downloader/f;
    //   29: ldc com/ss/android/socialbase/downloader/downloader/f
    //   31: monitorexit
    //   32: goto -> 41
    //   35: astore_0
    //   36: ldc com/ss/android/socialbase/downloader/downloader/f
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    //   41: getstatic com/ss/android/socialbase/downloader/downloader/f.a : Lcom/ss/android/socialbase/downloader/downloader/f;
    //   44: areturn
    // Exception table:
    //   from	to	target	type
    //   9	29	35	finally
    //   29	32	35	finally
    //   36	39	35	finally
  }
  
  public static void a(g paramg) {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/downloader/f
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull -> 11
    //   7: ldc com/ss/android/socialbase/downloader/downloader/f
    //   9: monitorexit
    //   10: return
    //   11: getstatic com/ss/android/socialbase/downloader/downloader/f.a : Lcom/ss/android/socialbase/downloader/downloader/f;
    //   14: ifnonnull -> 27
    //   17: aload_0
    //   18: invokevirtual t : ()Lcom/ss/android/socialbase/downloader/downloader/f;
    //   21: putstatic com/ss/android/socialbase/downloader/downloader/f.a : Lcom/ss/android/socialbase/downloader/downloader/f;
    //   24: goto -> 31
    //   27: aload_0
    //   28: invokestatic a : (Lcom/ss/android/socialbase/downloader/downloader/g;)V
    //   31: ldc com/ss/android/socialbase/downloader/downloader/f
    //   33: monitorexit
    //   34: return
    //   35: astore_0
    //   36: ldc com/ss/android/socialbase/downloader/downloader/f
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   11	24	35	finally
    //   27	31	35	finally
  }
  
  public static d b(Context paramContext) {
    a(paramContext);
    return new d();
  }
  
  public c a(String paramString1, String paramString2) {
    return c.a().b(paramString1, paramString2);
  }
  
  public List<c> a(String paramString) {
    return c.a().a(paramString);
  }
  
  public void a() {
    c.a().c();
  }
  
  public void a(int paramInt) {
    c.a().d(paramInt);
  }
  
  @Deprecated
  public void a(int paramInt, w paramw) {
    if (paramw == null)
      return; 
    c.a().b(paramInt, paramw, h.a, true);
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    c.a().c(paramInt, paramBoolean);
  }
  
  public void a(List<String> paramList) {
    c.a().a(paramList);
  }
  
  public boolean a(c paramc) {
    return c.a().a(paramc);
  }
  
  public List<c> b(String paramString) {
    return c.a().b(paramString);
  }
  
  public void b(int paramInt) {
    a(paramInt, true);
  }
  
  public List<c> c(String paramString) {
    return c.a().c(paramString);
  }
  
  public void c(int paramInt) {
    c.a().f(paramInt);
  }
  
  public List<c> d(String paramString) {
    return c.a().d(paramString);
  }
  
  public boolean d(int paramInt) {
    return c.a().e(paramInt);
  }
  
  public void e(int paramInt) {
    c.a().g(paramInt);
  }
  
  public int f(int paramInt) {
    return c.a().h(paramInt);
  }
  
  public boolean g(int paramInt) {
    // Byte code:
    //   0: ldc 4194304
    //   2: invokestatic a : (I)Z
    //   5: ifeq -> 27
    //   8: aload_0
    //   9: monitorenter
    //   10: invokestatic a : ()Lcom/ss/android/socialbase/downloader/downloader/c;
    //   13: iload_1
    //   14: invokevirtual i : (I)Z
    //   17: istore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_2
    //   21: ireturn
    //   22: astore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_3
    //   26: athrow
    //   27: invokestatic a : ()Lcom/ss/android/socialbase/downloader/downloader/c;
    //   30: iload_1
    //   31: invokevirtual i : (I)Z
    //   34: ireturn
    // Exception table:
    //   from	to	target	type
    //   10	20	22	finally
    //   23	25	22	finally
  }
  
  public c h(int paramInt) {
    return c.a().j(paramInt);
  }
  
  public z i(int paramInt) {
    return c.a().k(paramInt);
  }
  
  public void j(int paramInt) {
    c.a().d(paramInt, true);
  }
  
  @Deprecated
  public void k(int paramInt) {
    c.a().a(paramInt, null, h.a, true);
  }
  
  public q l(int paramInt) {
    return c.a().o(paramInt);
  }
  
  public boolean m(int paramInt) {
    return c.a().c(paramInt).b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\downloader\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */