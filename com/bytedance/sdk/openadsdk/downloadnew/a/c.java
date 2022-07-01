package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.downloadnew.a.b.b;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class c implements a {
  private WeakReference<Context> a;
  
  private String b;
  
  private String c;
  
  private AtomicBoolean d = new AtomicBoolean(false);
  
  private com.ss.android.a.a.b.c e;
  
  public c(Context paramContext, String paramString1, String paramString2) {
    this.a = new WeakReference<Context>(paramContext);
    this.b = paramString1;
    this.c = paramString2;
    this.e = (com.ss.android.a.a.b.c)b.a(paramString1, paramString2).a();
    a();
  }
  
  private Context l() {
    WeakReference<Context> weakReference = this.a;
    return (weakReference == null || weakReference.get() == null) ? o.a() : this.a.get();
  }
  
  private void m() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual get : ()Z
    //   9: ifeq -> 34
    //   12: aload_0
    //   13: getfield d : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   16: iconst_0
    //   17: invokevirtual set : (Z)V
    //   20: invokestatic d : ()Lcom/ss/android/downloadlib/h;
    //   23: aload_0
    //   24: getfield b : Ljava/lang/String;
    //   27: aload_0
    //   28: invokevirtual hashCode : ()I
    //   31: invokevirtual a : (Ljava/lang/String;I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   2	34	37	finally
  }
  
  private void n() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual get : ()Z
    //   9: pop
    //   10: aload_0
    //   11: getfield d : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   14: iconst_1
    //   15: invokevirtual set : (Z)V
    //   18: invokestatic d : ()Lcom/ss/android/downloadlib/h;
    //   21: aload_0
    //   22: invokespecial l : ()Landroid/content/Context;
    //   25: aload_0
    //   26: invokevirtual hashCode : ()I
    //   29: aconst_null
    //   30: aload_0
    //   31: getfield e : Lcom/ss/android/a/a/b/c;
    //   34: invokevirtual a : (Landroid/content/Context;ILcom/ss/android/a/a/b/d;Lcom/ss/android/a/a/b/c;)V
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   2	37	40	finally
  }
  
  public void a() {
    n();
  }
  
  public void a(int paramInt, a.a parama) {}
  
  public void a(long paramLong) {
    d.d().a(this.b, true);
  }
  
  public void a(Activity paramActivity) {}
  
  public void a(View paramView) {}
  
  public void a(TTAppDownloadListener paramTTAppDownloadListener) {}
  
  public void a(TTAppDownloadListener paramTTAppDownloadListener, boolean paramBoolean) {}
  
  public boolean a(boolean paramBoolean) {
    return false;
  }
  
  public void b() {
    n();
  }
  
  public boolean b(boolean paramBoolean) {
    return false;
  }
  
  public void c() {}
  
  public void d() {
    m();
    WeakReference<Context> weakReference = this.a;
    if (weakReference != null) {
      weakReference.clear();
      this.a = null;
    } 
  }
  
  public boolean e() {
    return false;
  }
  
  public void f() {
    TTCustomController tTCustomController = h.c().d();
    if (tTCustomController != null && !tTCustomController.isCanUseWriteExternal())
      try {
        String str1 = d.a;
        String str2 = Environment.getDataDirectory().getAbsolutePath();
        if (str1 != null) {
          boolean bool = str1.startsWith(str2);
          if (!bool)
            return; 
        } 
      } finally {} 
    d.d().a(this.b, this.e.d(), 2);
  }
  
  public void g() {
    a(0L);
  }
  
  public void h() {}
  
  public boolean i() {
    return false;
  }
  
  public boolean j() {
    return false;
  }
  
  public boolean k() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\downloadnew\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */