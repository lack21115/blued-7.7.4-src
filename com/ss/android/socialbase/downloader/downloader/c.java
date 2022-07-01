package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.b.h;
import com.ss.android.socialbase.downloader.d.aa;
import com.ss.android.socialbase.downloader.d.ac;
import com.ss.android.socialbase.downloader.d.q;
import com.ss.android.socialbase.downloader.d.w;
import com.ss.android.socialbase.downloader.d.x;
import com.ss.android.socialbase.downloader.d.z;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.g.d;
import com.ss.android.socialbase.downloader.h.a;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.l;
import com.ss.android.socialbase.downloader.m.f;
import java.util.ArrayList;
import java.util.List;

public class c {
  private static volatile c a;
  
  private volatile SparseArray<Boolean> b = new SparseArray();
  
  private Handler c = new Handler(Looper.getMainLooper());
  
  private volatile List<aa> d = new ArrayList<aa>();
  
  public static c a() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/c.a : Lcom/ss/android/socialbase/downloader/downloader/c;
    //   3: ifnonnull -> 31
    //   6: ldc com/ss/android/socialbase/downloader/downloader/c
    //   8: monitorenter
    //   9: new com/ss/android/socialbase/downloader/downloader/c
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/ss/android/socialbase/downloader/downloader/c.a : Lcom/ss/android/socialbase/downloader/downloader/c;
    //   19: ldc com/ss/android/socialbase/downloader/downloader/c
    //   21: monitorexit
    //   22: goto -> 31
    //   25: astore_0
    //   26: ldc com/ss/android/socialbase/downloader/downloader/c
    //   28: monitorexit
    //   29: aload_0
    //   30: athrow
    //   31: getstatic com/ss/android/socialbase/downloader/downloader/c.a : Lcom/ss/android/socialbase/downloader/downloader/c;
    //   34: areturn
    // Exception table:
    //   from	to	target	type
    //   9	22	25	finally
    //   26	29	25	finally
  }
  
  private List<com.ss.android.socialbase.downloader.g.c> a(List<com.ss.android.socialbase.downloader.g.c> paramList1, List<com.ss.android.socialbase.downloader.g.c> paramList2, SparseArray<com.ss.android.socialbase.downloader.g.c> paramSparseArray) {
    ArrayList<com.ss.android.socialbase.downloader.g.c> arrayList = new ArrayList();
    if (paramList1 != null)
      for (com.ss.android.socialbase.downloader.g.c c1 : paramList1) {
        if (c1 != null && paramSparseArray.get(c1.g()) == null)
          paramSparseArray.put(c1.g(), c1); 
      }  
    if (paramList2 != null)
      for (com.ss.android.socialbase.downloader.g.c c1 : paramList2) {
        if (c1 != null && paramSparseArray.get(c1.g()) == null)
          paramSparseArray.put(c1.g(), c1); 
      }  
    int i;
    for (i = 0; i < paramSparseArray.size(); i++)
      arrayList.add((com.ss.android.socialbase.downloader.g.c)paramSparseArray.get(paramSparseArray.keyAt(i))); 
    return arrayList;
  }
  
  private n b(d paramd) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:322)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int a(int paramInt) {
    return (!f.c() && l.a(true).g()) ? l.a(true).m(paramInt) : b(paramInt);
  }
  
  public int a(String paramString1, String paramString2) {
    return b.a(paramString1, paramString2);
  }
  
  public List<com.ss.android.socialbase.downloader.g.c> a(String paramString) {
    List<com.ss.android.socialbase.downloader.g.c> list2 = l.a(false).a(paramString);
    List<com.ss.android.socialbase.downloader.g.c> list1 = l.a(true).a(paramString);
    if (list2 == null && list1 == null)
      return null; 
    if (list2 != null && list1 != null) {
      list2 = new ArrayList<com.ss.android.socialbase.downloader.g.c>(list2);
      list2.addAll(list1);
      return list2;
    } 
    if (list2 != null)
      list1 = list2; 
    return list1;
  }
  
  public void a(int paramInt, w paramw, h paramh, boolean paramBoolean) {
    int i;
    n n = c(paramInt);
    if (n == null)
      return; 
    if (paramw == null) {
      i = 0;
    } else {
      i = paramw.hashCode();
    } 
    n.b(paramInt, i, paramw, paramh, paramBoolean);
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    b(paramInt, paramBoolean);
    if (!f.c() && l.a(true).g())
      l.a(true).c(paramInt, paramBoolean); 
    if (!b.b() && !f.c() && !f.a())
      try {
        Intent intent = new Intent(b.B(), DownloadHandleService.class);
        intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
        intent.putExtra("extra_download_id", paramInt);
        return;
      } finally {
        Exception exception = null;
      }  
  }
  
  public void a(d paramd) {
    x x;
    n n = b(paramd);
    if (n == null) {
      if (paramd != null) {
        boolean bool;
        x = paramd.e();
        com.ss.android.socialbase.downloader.g.c c1 = paramd.a();
        a a = new a(1003, "tryDownload but getDownloadHandler failed");
        if (paramd.a() != null) {
          bool = paramd.a().q();
        } else {
          bool = false;
        } 
        a.a(x, c1, a, bool);
      } 
      return;
    } 
    if (paramd.b()) {
      this.c.postDelayed(new Runnable(this, (n)x, paramd) {
            public void run() {
              this.a.a(this.b);
            }
          }500L);
      return;
    } 
    x.a(paramd);
  }
  
  public void a(List<String> paramList) {
    n n = l.a(false);
    if (n != null)
      n.a(paramList); 
    n = l.a(true);
    if (n != null)
      n.a(paramList); 
  }
  
  public boolean a(com.ss.android.socialbase.downloader.g.c paramc) {
    if (paramc == null)
      return false; 
    n n = c(paramc.g());
    return (n == null) ? false : n.a(paramc);
  }
  
  public int b(int paramInt) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public com.ss.android.socialbase.downloader.g.c b(String paramString1, String paramString2) {
    int i = a(paramString1, paramString2);
    n n = c(i);
    return (n == null) ? null : n.h(i);
  }
  
  public List<com.ss.android.socialbase.downloader.g.c> b(String paramString) {
    SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray = new SparseArray();
    n n1 = l.a(false);
    List<com.ss.android.socialbase.downloader.g.c> list = null;
    if (n1 != null) {
      List<com.ss.android.socialbase.downloader.g.c> list1 = n1.c(paramString);
    } else {
      n1 = null;
    } 
    n n2 = l.a(true);
    if (n2 != null)
      list = n2.c(paramString); 
    return a((List<com.ss.android.socialbase.downloader.g.c>)n1, list, sparseArray);
  }
  
  public void b() {
    synchronized (this.d) {
      for (aa aa : this.d) {
        if (aa != null)
          aa.a(); 
      } 
      return;
    } 
  }
  
  public void b(int paramInt, w paramw, h paramh, boolean paramBoolean) {
    n n = c(paramInt);
    if (n == null)
      return; 
    n.a(paramInt, paramw.hashCode(), paramw, paramh, paramBoolean);
  }
  
  public void b(int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Landroid/util/SparseArray;
    //   6: astore #4
    //   8: iload_2
    //   9: ifeq -> 19
    //   12: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   15: astore_3
    //   16: goto -> 23
    //   19: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   22: astore_3
    //   23: aload #4
    //   25: iload_1
    //   26: aload_3
    //   27: invokevirtual put : (ILjava/lang/Object;)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore_3
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_3
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	33	finally
    //   12	16	33	finally
    //   19	23	33	finally
    //   23	30	33	finally
  }
  
  public n c(int paramInt) {
    paramInt = a(paramInt);
    boolean bool = true;
    if (paramInt != 1 || f.c())
      bool = false; 
    return l.a(bool);
  }
  
  public List<com.ss.android.socialbase.downloader.g.c> c(String paramString) {
    SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray = new SparseArray();
    n n1 = l.a(false);
    List<com.ss.android.socialbase.downloader.g.c> list = null;
    if (n1 != null) {
      List<com.ss.android.socialbase.downloader.g.c> list1 = n1.d(paramString);
    } else {
      n1 = null;
    } 
    n n2 = l.a(true);
    if (n2 != null)
      list = n2.d(paramString); 
    return a((List<com.ss.android.socialbase.downloader.g.c>)n1, list, sparseArray);
  }
  
  public void c() {
    n n = l.a(false);
    if (n != null)
      n.a(); 
    n = l.a(true);
    if (n != null)
      n.a(); 
  }
  
  public void c(int paramInt, boolean paramBoolean) {
    if (f.a()) {
      if (com.ss.android.socialbase.downloader.m.c.a(8388608)) {
        n n = l.a(true);
        if (n != null)
          n.a(paramInt, paramBoolean); 
        n = l.a(false);
        if (n != null) {
          n.a(paramInt, paramBoolean);
          return;
        } 
      } else {
        n n = l.a(false);
        if (n != null)
          n.a(paramInt, paramBoolean); 
        n = l.a(true);
        if (n != null) {
          n.a(paramInt, paramBoolean);
          return;
        } 
      } 
    } else {
      n n = c(paramInt);
      if (n != null)
        n.a(paramInt, paramBoolean); 
      l.a(true).a(2, paramInt);
    } 
  }
  
  public List<com.ss.android.socialbase.downloader.g.c> d(String paramString) {
    SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray = new SparseArray();
    n n1 = l.a(false);
    List<com.ss.android.socialbase.downloader.g.c> list = null;
    if (n1 != null) {
      List<com.ss.android.socialbase.downloader.g.c> list1 = n1.e(paramString);
    } else {
      n1 = null;
    } 
    n n2 = l.a(true);
    if (n2 != null)
      list = n2.e(paramString); 
    return a((List<com.ss.android.socialbase.downloader.g.c>)n1, list, sparseArray);
  }
  
  public void d(int paramInt) {
    n n = c(paramInt);
    if (n == null)
      return; 
    n.a(paramInt);
  }
  
  public void d(int paramInt, boolean paramBoolean) {
    n n = c(paramInt);
    if (n == null)
      return; 
    n.b(paramInt, paramBoolean);
  }
  
  public boolean e(int paramInt) {
    n n = c(paramInt);
    return (n == null) ? false : n.b(paramInt);
  }
  
  public void f(int paramInt) {
    n n = c(paramInt);
    if (n == null)
      return; 
    n.c(paramInt);
  }
  
  public void g(int paramInt) {
    n n = c(paramInt);
    if (n == null)
      return; 
    n.d(paramInt);
  }
  
  public int h(int paramInt) {
    n n = c(paramInt);
    return (n == null) ? 0 : n.f(paramInt);
  }
  
  public boolean i(int paramInt) {
    n n = c(paramInt);
    return (n == null) ? false : n.g(paramInt);
  }
  
  public com.ss.android.socialbase.downloader.g.c j(int paramInt) {
    n n = c(paramInt);
    return (n == null) ? null : n.h(paramInt);
  }
  
  public z k(int paramInt) {
    n n = c(paramInt);
    return (n == null) ? null : n.q(paramInt);
  }
  
  public ac l(int paramInt) {
    n n = c(paramInt);
    return (n == null) ? null : n.r(paramInt);
  }
  
  public boolean m(int paramInt) {
    n n = c(paramInt);
    return (n == null) ? false : n.l(paramInt);
  }
  
  public void n(int paramInt) {
    if (paramInt == 0)
      return; 
    b(paramInt, Boolean.TRUE.booleanValue());
    n n = l.a(true);
    if (n == null)
      return; 
    n.d();
  }
  
  public q o(int paramInt) {
    n n = c(paramInt);
    return (n == null) ? null : n.s(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\downloader\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */