package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.h.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.downloadnew.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.a.a.b;
import com.bytedance.sdk.openadsdk.downloadnew.a.a.c;
import com.bytedance.sdk.openadsdk.downloadnew.a.a.d;
import com.bytedance.sdk.openadsdk.downloadnew.a.a.e;
import com.bytedance.sdk.openadsdk.downloadnew.a.a.f;
import com.bytedance.sdk.openadsdk.downloadnew.a.a.g;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.t;
import com.ss.android.a.a.a;
import com.ss.android.a.a.a.a;
import com.ss.android.a.a.a.e;
import com.ss.android.a.a.a.f;
import com.ss.android.a.a.a.g;
import com.ss.android.a.a.a.h;
import com.ss.android.a.a.a.j;
import com.ss.android.a.a.b.a;
import com.ss.android.a.a.b.a.a;
import com.ss.android.a.a.b.b;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.c.a;
import com.ss.android.downloadlib.h;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.downloader.g;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.i.f;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d {
  public static volatile String a;
  
  private static final AtomicBoolean b = new AtomicBoolean(false);
  
  private static Context c;
  
  private static Map<Integer, a.a> d;
  
  private static boolean e = true;
  
  private static AtomicBoolean f = new AtomicBoolean(false);
  
  private static a g = new a() {
      public void a(c param1c, a param1a, b param1b) {
        t.b("LibHolder", "completeListener: onDownloadStart");
      }
      
      public void a(c param1c) {
        t.b("LibHolder", "completeListener: onCanceled");
      }
      
      public void a(c param1c, a param1a, String param1String) {
        t.b("LibHolder", "completeListener: onDownloadFailed");
      }
      
      public void a(c param1c, String param1String) {
        t.b("LibHolder", "completeListener: onDownloadFinished");
      }
      
      public void b(c param1c, String param1String) {
        t.b("LibHolder", "completeListener: onInstalled");
        try {
          if (o.h().M())
            return; 
        } finally {
          param1c = null;
        } 
      }
    };
  
  static {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static void a() {
    File file = null;
    try {
      String str1;
      boolean bool = e;
      File file1 = file;
      if (bool) {
        file1 = file;
        if (!b()) {
          file1 = new File(g().getCacheDir(), Environment.DIRECTORY_DOWNLOADS);
          file1.mkdirs();
          String str = file1.getPath();
          bool = TextUtils.isEmpty(str);
          str1 = str;
          if (!bool)
            try {
              Runtime runtime = Runtime.getRuntime();
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("chmod 777 ");
              stringBuilder1.append(str);
            } finally {
              str1 = null;
              t.b("LibHolder", "download dir error: ", (Throwable)str1);
            }  
        } 
      } 
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        String str = str1;
        if ("mounted".equals(Environment.getExternalStorageState())) {
          File file2 = g().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
          str = str1;
          if (file2 != null)
            str = file2.getPath(); 
        } 
        str2 = str;
        if (TextUtils.isEmpty(str)) {
          File file2 = new File(g().getFilesDir(), Environment.DIRECTORY_DOWNLOADS);
          file2.mkdirs();
          str2 = file2.getPath();
        } 
      } 
      if (!TextUtils.isEmpty(str2)) {
        a = str2;
        l.a();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("path: ");
      stringBuilder.append(String.valueOf(a));
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static void a(int paramInt) {
    Map<Integer, a.a> map = d;
    if (map != null)
      map.remove(Integer.valueOf(paramInt)); 
  }
  
  public static void a(int paramInt, a.a parama) {
    if (parama != null) {
      if (d == null)
        d = Collections.synchronizedMap(new WeakHashMap<Integer, a.a>()); 
      d.put(Integer.valueOf(paramInt), parama);
    } 
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull -> 10
    //   6: invokestatic a : ()Landroid/content/Context;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnonnull -> 15
    //   14: return
    //   15: aload_2
    //   16: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   19: putstatic com/bytedance/sdk/openadsdk/downloadnew/a/d.c : Landroid/content/Context;
    //   22: invokestatic a : ()V
    //   25: getstatic com/bytedance/sdk/openadsdk/downloadnew/a/d.b : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   28: invokevirtual get : ()Z
    //   31: ifne -> 70
    //   34: ldc com/bytedance/sdk/openadsdk/downloadnew/a/d
    //   36: monitorenter
    //   37: getstatic com/bytedance/sdk/openadsdk/downloadnew/a/d.b : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   40: invokevirtual get : ()Z
    //   43: ifne -> 60
    //   46: getstatic com/bytedance/sdk/openadsdk/downloadnew/a/d.c : Landroid/content/Context;
    //   49: invokestatic b : (Landroid/content/Context;)Z
    //   52: istore_1
    //   53: getstatic com/bytedance/sdk/openadsdk/downloadnew/a/d.b : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   56: iload_1
    //   57: invokevirtual set : (Z)V
    //   60: ldc com/bytedance/sdk/openadsdk/downloadnew/a/d
    //   62: monitorexit
    //   63: return
    //   64: astore_0
    //   65: ldc com/bytedance/sdk/openadsdk/downloadnew/a/d
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    //   70: return
    // Exception table:
    //   from	to	target	type
    //   37	60	64	finally
    //   60	63	64	finally
    //   65	68	64	finally
  }
  
  public static boolean a(Context paramContext, String paramString) {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString))
        return false; 
      List list = com.ss.android.socialbase.appdownloader.d.h().b(paramContext);
      if (!list.isEmpty())
        for (c c : list) {
          if (c != null && paramString.equals(c.j()))
            return true; 
        }  
    } 
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, k paramk, Object paramObject) {
    boolean bool4 = TextUtils.isEmpty(paramString1);
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (!bool4) {
      bool2 = bool3;
      if (!TextUtils.isEmpty(paramString2)) {
        if (paramk == null)
          return false; 
        Map<Integer, a.a> map = h();
        bool2 = bool3;
        if (map != null) {
          Iterator<Map.Entry> iterator = map.entrySet().iterator();
          while (true) {
            bool2 = bool1;
            if (iterator.hasNext()) {
              Map.Entry entry = iterator.next();
              int i = ((Integer)entry.getKey()).intValue();
              a.a a1 = (a.a)entry.getValue();
              if (a1 != null) {
                bool2 = a1.a(i, paramk, paramString1, paramString2, paramObject);
                if (!bool1 && !bool2)
                  bool1 = true; 
              } 
              continue;
            } 
            break;
          } 
        } 
      } 
    } 
    return bool2;
  }
  
  public static boolean b() {
    return (Build.VERSION.SDK_INT >= 23) ? com.bytedance.sdk.openadsdk.core.f.d.a().a(g(), "android.permission.WRITE_EXTERNAL_STORAGE") : true;
  }
  
  private static boolean b(Context paramContext) {
    if (paramContext == null)
      return false; 
    Context context = paramContext.getApplicationContext();
    String str2 = context.getPackageName();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = ""; 
    i();
    a a1 = h.a(context).a();
    if (a1 == null)
      return false; 
    a a2 = (new a.a()).b("143").a("open_news").c("2.9.5.6").d(String.valueOf(2956)).a();
    a1 = a1.a((g)new d(context)).a((e)new b(context)).a((j)new f(context)).a((f)new c(context)).a((h)e.a(context)).a((a)new a(context)).a(a2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append(".TTFileProvider");
    a1.a(stringBuilder.toString());
    com.ss.android.socialbase.appdownloader.d.h().a(true);
    c(context);
    h.a(context).d().a(1);
    if (!f.getAndSet(true))
      d().a(g); 
    return true;
  }
  
  public static void c() {
    l l = o.h();
    if (l != null) {
      boolean bool = l.F();
      if (e != bool) {
        e = bool;
        a();
      } 
    } 
    try {
      a a1 = d().a();
      return;
    } finally {
      l = null;
      t.c("LibHolder", "sync config error: ", (Throwable)l);
    } 
  }
  
  private static void c(Context paramContext) {
    l l = o.h();
    if (l == null)
      return; 
    int i = l.L();
    f.a((new g(paramContext)).a(e.a(paramContext).a()).a(i).a((f)new g(paramContext)));
  }
  
  public static h d() {
    if (!b.get())
      b(o.a()); 
    return h.a(g());
  }
  
  public static void e() {
    d().g();
    if (!TextUtils.isEmpty(a))
      k.c(new File(a)); 
  }
  
  private static Context g() {
    Context context2 = c;
    Context context1 = context2;
    if (context2 == null)
      context1 = o.a(); 
    return context1;
  }
  
  private static Map<Integer, a.a> h() {
    return d;
  }
  
  private static void i() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_5
    //   3: istore_0
    //   4: iconst_2
    //   5: istore_3
    //   6: invokestatic h : ()Lcom/bytedance/sdk/openadsdk/core/h/l;
    //   9: astore #8
    //   11: aload #8
    //   13: ifnull -> 51
    //   16: aload #8
    //   18: invokevirtual G : ()Z
    //   21: istore #5
    //   23: aload #8
    //   25: invokevirtual H : ()I
    //   28: istore_1
    //   29: iload_1
    //   30: istore_0
    //   31: aload #8
    //   33: invokevirtual I : ()I
    //   36: istore #4
    //   38: iload_1
    //   39: istore_0
    //   40: iload #4
    //   42: istore_1
    //   43: goto -> 56
    //   46: iload_3
    //   47: istore_1
    //   48: goto -> 56
    //   51: iconst_0
    //   52: istore #5
    //   54: iload_3
    //   55: istore_1
    //   56: iload #5
    //   58: ifne -> 66
    //   61: iload_2
    //   62: istore_1
    //   63: goto -> 66
    //   66: iload_0
    //   67: ldc_w 60000
    //   70: imul
    //   71: istore_0
    //   72: invokestatic h : ()Lcom/ss/android/socialbase/appdownloader/d;
    //   75: iload_1
    //   76: invokevirtual b : (I)V
    //   79: invokestatic h : ()Lcom/ss/android/socialbase/appdownloader/d;
    //   82: iload_1
    //   83: invokevirtual a : (I)V
    //   86: invokestatic h : ()Lcom/ss/android/socialbase/appdownloader/d;
    //   89: astore #8
    //   91: iload_0
    //   92: i2l
    //   93: lstore #6
    //   95: aload #8
    //   97: lload #6
    //   99: invokevirtual a : (J)V
    //   102: invokestatic h : ()Lcom/ss/android/socialbase/appdownloader/d;
    //   105: lload #6
    //   107: invokevirtual b : (J)V
    //   110: new java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial <init> : ()V
    //   117: astore #8
    //   119: aload #8
    //   121: ldc_w 'count='
    //   124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload #8
    //   130: iload_1
    //   131: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload #8
    //   137: ldc_w ', time='
    //   140: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload #8
    //   146: iload_0
    //   147: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: ldc 'LibHolder'
    //   153: aload #8
    //   155: invokevirtual toString : ()Ljava/lang/String;
    //   158: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   161: return
    //   162: astore #8
    //   164: goto -> 51
    //   167: astore #8
    //   169: goto -> 46
    // Exception table:
    //   from	to	target	type
    //   6	11	162	finally
    //   16	23	162	finally
    //   23	29	167	finally
    //   31	38	167	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\downloadnew\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */