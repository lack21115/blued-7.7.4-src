package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.b.a;
import com.ss.android.socialbase.downloader.b.h;
import com.ss.android.socialbase.downloader.b.i;
import com.ss.android.socialbase.downloader.d.ae;
import com.ss.android.socialbase.downloader.d.l;
import com.ss.android.socialbase.downloader.d.w;
import com.ss.android.socialbase.downloader.d.x;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.e.f;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.g.b;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.d;
import com.ss.android.socialbase.downloader.impls.a;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.k.a;
import com.ss.android.socialbase.downloader.m.c;
import com.ss.android.socialbase.downloader.m.f;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

public class e {
  private static final String a = e.class.getSimpleName();
  
  private c b;
  
  private final k c;
  
  private final Handler d;
  
  private d e;
  
  private SparseArray<w> f;
  
  private SparseArray<w> g;
  
  private SparseArray<w> h;
  
  private boolean i = false;
  
  private volatile long j = 0L;
  
  private final AtomicLong k = new AtomicLong();
  
  private boolean l = false;
  
  private int m;
  
  private long n;
  
  private l o;
  
  private x p;
  
  public e(d paramd, Handler paramHandler) {
    this.e = paramd;
    j();
    this.d = paramHandler;
    this.c = b.p();
  }
  
  private void a(int paramInt, a parama) {
    a(paramInt, parama, true);
  }
  
  private void a(int paramInt, a parama, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   4: invokevirtual q : ()I
    //   7: istore #5
    //   9: iload #5
    //   11: bipush #-3
    //   13: if_icmpne -> 22
    //   16: iload_1
    //   17: iconst_4
    //   18: if_icmpne -> 22
    //   21: return
    //   22: aload_0
    //   23: invokespecial j : ()V
    //   26: iload_1
    //   27: iconst_4
    //   28: if_icmpeq -> 60
    //   31: iload_1
    //   32: invokestatic e : (I)Z
    //   35: ifeq -> 60
    //   38: aload_0
    //   39: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   42: iconst_0
    //   43: invokevirtual e : (Z)V
    //   46: iload_1
    //   47: invokestatic d : (I)Z
    //   50: ifeq -> 60
    //   53: aload_0
    //   54: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   57: invokevirtual P : ()V
    //   60: aload_0
    //   61: getfield p : Lcom/ss/android/socialbase/downloader/d/x;
    //   64: astore #6
    //   66: aload #6
    //   68: ifnull -> 135
    //   71: aload #6
    //   73: instanceof com/ss/android/socialbase/downloader/d/c
    //   76: ifeq -> 135
    //   79: aload #6
    //   81: checkcast com/ss/android/socialbase/downloader/d/c
    //   84: invokevirtual a : ()[I
    //   87: astore #6
    //   89: aload #6
    //   91: ifnull -> 135
    //   94: aload #6
    //   96: arraylength
    //   97: ifle -> 135
    //   100: iconst_0
    //   101: istore #4
    //   103: iload #4
    //   105: aload #6
    //   107: arraylength
    //   108: if_icmpge -> 135
    //   111: iload_1
    //   112: aload #6
    //   114: iload #4
    //   116: iaload
    //   117: if_icmpne -> 126
    //   120: iconst_1
    //   121: istore #4
    //   123: goto -> 138
    //   126: iload #4
    //   128: iconst_1
    //   129: iadd
    //   130: istore #4
    //   132: goto -> 103
    //   135: iconst_0
    //   136: istore #4
    //   138: iload_1
    //   139: invokestatic c : (I)Z
    //   142: ifne -> 150
    //   145: iload #4
    //   147: ifeq -> 185
    //   150: aload_0
    //   151: getfield o : Lcom/ss/android/socialbase/downloader/d/l;
    //   154: ifnull -> 172
    //   157: aload_0
    //   158: getfield o : Lcom/ss/android/socialbase/downloader/d/l;
    //   161: aload_0
    //   162: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   165: aload_2
    //   166: iload_1
    //   167: invokeinterface a : (Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;I)V
    //   172: aload_0
    //   173: getfield p : Lcom/ss/android/socialbase/downloader/d/x;
    //   176: aload_0
    //   177: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   180: aload_2
    //   181: iload_1
    //   182: invokestatic a : (Lcom/ss/android/socialbase/downloader/d/x;Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;I)V
    //   185: iload_1
    //   186: bipush #6
    //   188: if_icmpne -> 202
    //   191: aload_0
    //   192: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   195: iconst_2
    //   196: invokevirtual b : (I)V
    //   199: goto -> 228
    //   202: iload_1
    //   203: bipush #-6
    //   205: if_icmpne -> 220
    //   208: aload_0
    //   209: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   212: bipush #-3
    //   214: invokevirtual b : (I)V
    //   217: goto -> 228
    //   220: aload_0
    //   221: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   224: iload_1
    //   225: invokevirtual b : (I)V
    //   228: iload #5
    //   230: bipush #-3
    //   232: if_icmpeq -> 241
    //   235: iload #5
    //   237: iconst_m1
    //   238: if_icmpne -> 310
    //   241: aload_0
    //   242: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   245: invokevirtual aq : ()Lcom/ss/android/socialbase/downloader/b/j;
    //   248: getstatic com/ss/android/socialbase/downloader/b/j.c : Lcom/ss/android/socialbase/downloader/b/j;
    //   251: if_acmpne -> 264
    //   254: aload_0
    //   255: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   258: getstatic com/ss/android/socialbase/downloader/b/j.d : Lcom/ss/android/socialbase/downloader/b/j;
    //   261: invokevirtual a : (Lcom/ss/android/socialbase/downloader/b/j;)V
    //   264: aload_0
    //   265: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   268: invokevirtual ar : ()Lcom/ss/android/socialbase/downloader/b/a;
    //   271: getstatic com/ss/android/socialbase/downloader/b/a.d : Lcom/ss/android/socialbase/downloader/b/a;
    //   274: if_acmpne -> 287
    //   277: aload_0
    //   278: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   281: getstatic com/ss/android/socialbase/downloader/b/a.e : Lcom/ss/android/socialbase/downloader/b/a;
    //   284: invokevirtual a : (Lcom/ss/android/socialbase/downloader/b/a;)V
    //   287: aload_0
    //   288: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   291: invokevirtual aa : ()Lcom/ss/android/socialbase/downloader/b/b;
    //   294: getstatic com/ss/android/socialbase/downloader/b/b.c : Lcom/ss/android/socialbase/downloader/b/b;
    //   297: if_acmpne -> 310
    //   300: aload_0
    //   301: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   304: getstatic com/ss/android/socialbase/downloader/b/b.d : Lcom/ss/android/socialbase/downloader/b/b;
    //   307: invokevirtual a : (Lcom/ss/android/socialbase/downloader/b/b;)V
    //   310: iload_1
    //   311: aload_0
    //   312: getfield g : Landroid/util/SparseArray;
    //   315: iconst_1
    //   316: aload_0
    //   317: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   320: aload_2
    //   321: invokestatic a : (ILandroid/util/SparseArray;ZLcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;)V
    //   324: iload_1
    //   325: bipush #-4
    //   327: if_icmpne -> 331
    //   330: return
    //   331: iload_3
    //   332: ifeq -> 413
    //   335: aload_0
    //   336: getfield f : Landroid/util/SparseArray;
    //   339: astore #6
    //   341: aload #6
    //   343: ifnull -> 354
    //   346: aload #6
    //   348: invokevirtual size : ()I
    //   351: ifgt -> 383
    //   354: aload_0
    //   355: getfield h : Landroid/util/SparseArray;
    //   358: astore #6
    //   360: aload #6
    //   362: ifnull -> 413
    //   365: aload #6
    //   367: invokevirtual size : ()I
    //   370: ifle -> 413
    //   373: aload_0
    //   374: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   377: invokevirtual af : ()Z
    //   380: ifeq -> 413
    //   383: aload_0
    //   384: getfield d : Landroid/os/Handler;
    //   387: astore #6
    //   389: aload #6
    //   391: ifnull -> 413
    //   394: aload #6
    //   396: iload_1
    //   397: aload_0
    //   398: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   401: invokevirtual g : ()I
    //   404: iconst_0
    //   405: aload_2
    //   406: invokevirtual obtainMessage : (IIILjava/lang/Object;)Landroid/os/Message;
    //   409: invokevirtual sendToTarget : ()V
    //   412: return
    //   413: invokestatic t : ()Lcom/ss/android/socialbase/downloader/impls/a;
    //   416: astore_2
    //   417: aload_2
    //   418: ifnull -> 433
    //   421: aload_2
    //   422: aload_0
    //   423: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   426: invokevirtual g : ()I
    //   429: iload_1
    //   430: invokevirtual a : (II)V
    //   433: return
    //   434: astore #6
    //   436: goto -> 172
    // Exception table:
    //   from	to	target	type
    //   150	172	434	finally
  }
  
  private boolean a(long paramLong, boolean paramBoolean) {
    paramLong = this.b.Z();
    long l1 = this.b.ab();
    boolean bool2 = false;
    if (paramLong == l1)
      try {
        this.c.a(this.b.g(), this.b.Z());
        return false;
      } catch (Exception exception) {
        exception.printStackTrace();
        return false;
      }  
    if (this.i) {
      this.i = false;
      this.b.b(4);
    } 
    boolean bool1 = bool2;
    if (this.b.aE()) {
      bool1 = bool2;
      if (paramBoolean)
        bool1 = true; 
    } 
    a(4, (a)null, bool1);
    return paramBoolean;
  }
  
  private void b(a parama) {
    if (parama != null && parama.getCause() != null && parama.getCause() instanceof android.database.sqlite.SQLiteFullException) {
      try {
        this.c.f(this.b.g());
      } catch (SQLiteException sQLiteException) {
        sQLiteException.printStackTrace();
      } 
    } else {
      try {
        this.c.b(this.b.g(), this.b.Z());
      } catch (SQLiteException sQLiteException) {
        try {
          this.c.f(this.b.g());
        } catch (SQLiteException sQLiteException1) {
          sQLiteException1.printStackTrace();
        } 
      } 
    } 
    parama = c(parama);
    this.b.a(parama);
    a(-1, parama);
    if (a.a(this.b.g()).a("retry_schedule", 0) > 0)
      r.a().a(this.b); 
  }
  
  private void b(a parama, boolean paramBoolean) {
    byte b;
    this.c.h(this.b.g());
    if (paramBoolean) {
      b = 7;
    } else {
      b = 5;
    } 
    a(b, parama);
  }
  
  private boolean b(long paramLong) {
    boolean bool = this.l;
    boolean bool1 = true;
    if (!bool) {
      this.l = true;
      return true;
    } 
    long l1 = this.j;
    bool = bool1;
    if (this.k.get() < this.n)
      if (paramLong - l1 >= this.m) {
        bool = bool1;
      } else {
        bool = false;
      }  
    if (bool) {
      this.j = paramLong;
      this.k.set(0L);
    } 
    return bool;
  }
  
  private a c(a parama) {
    if (a.a(this.b.g()).a("download_failed_check_net", 0) == 1 && f.h((Throwable)parama)) {
      Context context = b.B();
      if (context != null && !f.b(context)) {
        char c1;
        if (this.b.x()) {
          c1 = 'ϵ';
        } else {
          c1 = 'Й';
        } 
        return new a(c1, parama.b());
      } 
    } 
    return parama;
  }
  
  private void j() {
    d d1 = this.e;
    if (d1 != null) {
      this.b = d1.a();
      this.f = this.e.a(h.a);
      this.h = this.e.a(h.c);
      this.g = this.e.a(h.b);
      this.o = this.e.d();
      this.p = this.e.e();
    } 
  }
  
  private void k() {
    ExecutorService executorService = b.k();
    if (executorService != null)
      executorService.execute(new Runnable(this) {
            public void run() {
              e.b(this.a).i(e.a(this.a).g());
              e.a(this.a, 1, (a)null);
            }
          }); 
  }
  
  private void l() {
    try {
      a.b(a, "saveFileAsTargetName onSuccess");
      i i = this.b.aS();
      if (i != i.a) {
        String str = "";
        if (i == i.b) {
          str = "md5 invalid because of file not exist";
        } else if (i == i.c) {
          str = "md5 invalid because of file md5 is empty";
        } else if (i == i.d) {
          str = "md5 invalid because of file md5 is not equals to task md5";
        } 
        return;
      } 
      this.b.g(false);
      a(-3, (a)null);
      return;
    } finally {
      Exception exception = null;
      a(new a(1008, f.b(exception, "onCompleted")));
    } 
  }
  
  public void a() {
    if (this.b.as())
      return; 
    this.b.b(1);
    k();
  }
  
  public void a(long paramLong, String paramString1, String paramString2) {
    this.b.c(paramLong);
    this.b.b(paramString1);
    if (!TextUtils.isEmpty(paramString2) && TextUtils.isEmpty(this.b.h()))
      this.b.c(paramString2); 
    try {
      this.c.a(this.b.g(), paramLong, paramString1, paramString2);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    a(3, (a)null);
    this.n = this.b.d(paramLong);
    this.m = this.b.aG();
    this.i = true;
    r.a().e();
  }
  
  public void a(a parama) {
    this.b.f(false);
    b(parama);
  }
  
  public void a(a parama, boolean paramBoolean) {
    this.b.f(false);
    this.k.set(0L);
    b(parama, paramBoolean);
  }
  
  public void a(b paramb, a parama, boolean paramBoolean) {
    byte b1;
    this.b.f(false);
    this.k.set(0L);
    this.c.h(this.b.g());
    if (paramBoolean) {
      b1 = 10;
    } else {
      b1 = 9;
    } 
    a(b1, parama, true);
  }
  
  public void a(String paramString) throws a {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onCompleteForFileExist existTargetFileName is ");
    stringBuilder.append(paramString);
    stringBuilder.append(" but curName is ");
    stringBuilder.append(this.b.h());
    a.b(str, stringBuilder.toString());
    if (c.a(16384)) {
      a(-3, (a)null);
      this.c.a(this.b);
      f.a(this.b, paramString);
      return;
    } 
    this.c.a(this.b);
    f.a(this.b, paramString);
    a(-3, (a)null);
  }
  
  public boolean a(long paramLong) {
    this.k.addAndGet(paramLong);
    this.b.b(paramLong);
    paramLong = SystemClock.uptimeMillis();
    return a(paramLong, b(paramLong));
  }
  
  public void b() {
    if (this.b.as()) {
      this.b.at();
      return;
    } 
    this.c.g(this.b.g());
    if (this.b.aR())
      a(6, (a)null); 
    a(2, (a)null);
  }
  
  public void c() {
    a(-4, (a)null);
  }
  
  public void d() {
    this.b.b(-2);
    try {
      this.c.d(this.b.g(), this.b.Z());
    } catch (SQLiteException sQLiteException) {
      sQLiteException.printStackTrace();
    } 
    a(-2, (a)null);
  }
  
  public void e() {
    this.b.b(-7);
    try {
      this.c.j(this.b.g());
    } catch (SQLiteException sQLiteException) {
      sQLiteException.printStackTrace();
    } 
    a(-7, (a)null);
  }
  
  public void f() {
    this.b.f(false);
    if (!this.b.V() && this.b.Z() != this.b.ab()) {
      a.b(a, this.b.d());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("current bytes is not equals to total bytes, bytes changed with process : ");
      stringBuilder1.append(this.b.aa());
      a((a)new f(1027, stringBuilder1.toString()));
      return;
    } 
    if (this.b.Z() <= 0L) {
      a.b(a, this.b.d());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("curBytes is 0, bytes changed with process : ");
      stringBuilder1.append(this.b.aa());
      a((a)new f(1026, stringBuilder1.toString()));
      return;
    } 
    if (!this.b.V() && this.b.ab() <= 0L) {
      a.b(a, this.b.d());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("TotalBytes is 0, bytes changed with process : ");
      stringBuilder1.append(this.b.aa());
      a((a)new f(1044, stringBuilder1.toString()));
      return;
    } 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.b.h());
    stringBuilder.append(" onCompleted start save file as target name");
    a.b(str, stringBuilder.toString());
    x x1 = this.p;
    d d1 = this.e;
    if (d1 != null)
      x1 = d1.e(); 
    if (this.b.W()) {
      f.a(this.b, x1, new ae(this) {
            public void a() {
              e.c(this.a);
            }
            
            public void a(a param1a) {
              String str1;
              String str2 = e.i();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("saveFileAsTargetName onFailed : ");
              if (param1a != null) {
                str1 = param1a.b();
              } else {
                str1 = "";
              } 
              stringBuilder.append(str1);
              a.b(str2, stringBuilder.toString());
              this.a.a(param1a);
            }
          });
      return;
    } 
    f.a(this.b, new ae(this) {
          public void a() {
            e.c(this.a);
          }
          
          public void a(a param1a) {
            String str1;
            String str2 = e.i();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("saveFileAsTargetName onFailed : ");
            if (param1a != null) {
              str1 = param1a.b();
            } else {
              str1 = "";
            } 
            stringBuilder.append(str1);
            a.b(str2, stringBuilder.toString());
            this.a.a(param1a);
          }
        });
  }
  
  public void g() {
    a.b(a, "onCompleteForFileExist");
    a(-3, (a)null);
    this.c.c(this.b.g(), this.b.ab());
    this.c.d(this.b.g());
  }
  
  public void h() {
    this.b.b(8);
    this.b.a(a.b);
    a a = b.t();
    if (a != null)
      a.a(this.b.g(), 8); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\downloader\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */