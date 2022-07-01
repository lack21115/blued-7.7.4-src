package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.downloadnew.a.b.b;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.c;
import com.bytedance.sdk.openadsdk.multipro.aidl.b.e;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.b.d;
import com.ss.android.a.a.c.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class b implements a, ak.a {
  protected IListenerManager a;
  
  private WeakReference<Context> b;
  
  private final com.bytedance.sdk.openadsdk.core.d.b c;
  
  private final k d;
  
  private String e;
  
  private int f = -1;
  
  private com.ss.android.a.a.b.a g;
  
  private com.ss.android.a.a.b.b h;
  
  private c i;
  
  private final AtomicInteger j = new AtomicInteger(1);
  
  private final AtomicBoolean k = new AtomicBoolean(false);
  
  private boolean l = false;
  
  private boolean m;
  
  private final AtomicLong n = new AtomicLong();
  
  private final AtomicBoolean o = new AtomicBoolean(false);
  
  private WeakReference<View> p;
  
  private boolean q = false;
  
  private HashSet<Integer> r;
  
  private c s;
  
  private final ak t = new ak(Looper.getMainLooper(), this);
  
  private boolean u = true;
  
  private String v;
  
  private final d w = new d(this) {
      public void a() {
        b.a(this.a).set(1);
        b.a("onIdle");
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
          b.a(this.a, "onIdle", 0L, 0L, null, null);
          return;
        } 
        if (b.b(this.a) != null)
          b.b(this.a).onIdle(); 
      }
      
      public void a(c param1c, com.ss.android.a.a.b.a param1a) {
        b.a(this.a).set(2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onDownloadStart: ");
        stringBuilder.append(param1c.d());
        b.a(stringBuilder.toString());
        this.a.a(param1c.d());
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
          b.a(this.a, "onIdle", 0L, 0L, null, null);
          return;
        } 
        if (b.b(this.a) != null)
          b.b(this.a).onIdle(); 
      }
      
      public void a(e param1e) {
        b.a(this.a).set(5);
        this.a.a(param1e.a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onDownloadFailed: ");
        stringBuilder.append(param1e.c);
        stringBuilder.append(", ");
        stringBuilder.append(param1e.d);
        b.a(stringBuilder.toString());
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
          b.a(this.a, "onDownloadFailed", param1e.c, param1e.d, param1e.e, b.d(this.a).c());
          return;
        } 
        if (b.b(this.a) != null)
          b.b(this.a).onDownloadFailed(param1e.c, param1e.d, param1e.e, b.d(this.a).c()); 
      }
      
      public void a(e param1e, int param1Int) {
        b.a(this.a).set(3);
        b.c(this.a).set(false);
        this.a.a(param1e.a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onDownloadActive: ");
        stringBuilder.append(param1e.c);
        stringBuilder.append(", ");
        stringBuilder.append(param1e.d);
        b.a(stringBuilder.toString());
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
          b.a(this.a, "onDownloadActive", param1e.c, param1e.d, param1e.e, b.d(this.a).c());
          return;
        } 
        if (b.b(this.a) != null)
          b.b(this.a).onDownloadActive(param1e.c, param1e.d, param1e.e, b.d(this.a).c()); 
      }
      
      public void b(e param1e) {
        b.a(this.a).set(7);
        b.c(this.a).set(true);
        this.a.a(param1e.a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onInstalled: ");
        stringBuilder.append(param1e.c);
        stringBuilder.append(", ");
        stringBuilder.append(param1e.d);
        b.a(stringBuilder.toString());
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
          b.a(this.a, "onInstalled", param1e.c, param1e.d, param1e.e, b.d(this.a).c());
          return;
        } 
        if (b.b(this.a) != null)
          b.b(this.a).onInstalled(param1e.e, b.d(this.a).c()); 
      }
      
      public void b(e param1e, int param1Int) {
        b.a(this.a).set(4);
        b.c(this.a).set(false);
        this.a.a(param1e.a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onDownloadPaused: ");
        stringBuilder.append(param1e.c);
        stringBuilder.append(", ");
        stringBuilder.append(param1e.d);
        b.a(stringBuilder.toString());
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
          b.a(this.a, "onDownloadPaused", param1e.c, param1e.d, param1e.e, b.d(this.a).c());
          return;
        } 
        if (b.b(this.a) != null)
          b.b(this.a).onDownloadPaused(param1e.c, param1e.d, param1e.e, b.d(this.a).c()); 
      }
      
      public void c(e param1e) {
        b.a(this.a).set(6);
        this.a.a(param1e.a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onDownloadFinished: ");
        stringBuilder.append(param1e.c);
        stringBuilder.append(", ");
        stringBuilder.append(param1e.d);
        b.a(stringBuilder.toString());
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
          b.a(this.a, "onDownloadFinished", param1e.c, param1e.d, param1e.e, b.d(this.a).c());
          return;
        } 
        if (b.b(this.a) != null)
          b.b(this.a).onDownloadFinished(param1e.c, param1e.e, b.d(this.a).c()); 
      }
    };
  
  private a x = new a(this);
  
  private List<ITTAppDownloadListener> y = new ArrayList<ITTAppDownloadListener>();
  
  public b(Context paramContext, k paramk, String paramString) {
    this.b = new WeakReference<Context>(paramContext);
    this.d = paramk;
    this.c = paramk.N();
    this.e = paramString;
    this.f = ah.c(paramk.P());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.d.hashCode());
    stringBuilder.append(this.d.ae().toString());
    this.v = j.a(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("====tag===");
    stringBuilder.append(paramString);
    b(stringBuilder.toString());
    if (this.c == null) {
      t.e("DMLibManager", "download create error: not a App type Ad!");
      return;
    } 
    if (o.a() == null)
      o.a(paramContext); 
    this.s = new c();
    this.i = (c)b.a(this.e, this.d, null).a();
    this.g = (com.ss.android.a.a.b.a)b.a(this.d).a();
    this.h = (com.ss.android.a.a.b.b)b.a(this.d, this.e).a();
    a();
  }
  
  private void a(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3) {
    a a1 = this.x;
    if (a1 == null) {
      this.x = new a(this, paramString1, paramLong1, paramLong2, paramString2, paramString3);
    } else {
      a1.a(paramString1);
      this.x.a(paramLong1);
      this.x.b(paramLong2);
      this.x.b(paramString2);
      this.x.c(paramString3);
    } 
    com.bytedance.sdk.openadsdk.i.a.a().a(this.x, 5);
  }
  
  private void a(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return; 
      com.bytedance.sdk.openadsdk.core.d.b b1 = this.c;
      if (b1 == null)
        return; 
      g.a(b1.b(), paramString1, paramString2, new g.a(this) {
            public void a() {
              b.e(this.a);
            }
            
            public void b() {}
            
            public void c() {}
          });
    } 
  }
  
  private boolean a(int paramInt) {
    int j;
    int i = o.h().f();
    boolean bool = false;
    if (i != -1) {
      j = bool;
      if (i != 0)
        if (i != 2) {
          if (i != 3) {
            j = bool;
            if (!h.c().b(paramInt)) {
              i = 104857600;
              com.bytedance.sdk.openadsdk.core.d.b b1 = this.c;
              paramInt = i;
              if (b1 != null) {
                paramInt = i;
                if (b1.g() > 0)
                  paramInt = this.c.g(); 
              } 
              j = bool;
              if (paramInt > o.h().g())
                return true; 
            } 
          } else {
            return true;
          } 
        } else {
          j = bool;
          if (paramInt != 4)
            return true; 
        }  
    } else {
      j = h.c().b(paramInt) ^ true;
    } 
    return j;
  }
  
  public static boolean a(Context paramContext, String paramString1, k paramk, String paramString2) {
    if (paramContext == null)
      return false; 
    try {
      if (o.h().d())
        ah.a(paramk, paramString2); 
      Uri uri = Uri.parse(paramString1);
      Intent intent = new Intent("android.intent.action.VIEW");
      intent.setData(uri);
      intent.addFlags(268435456);
      intent.putExtra("open_url", paramString1);
      return true;
    } finally {
      paramContext = null;
    } 
  }
  
  private boolean a(String paramString1, String paramString2, k paramk) {
    return d.a(paramString1, paramString2, paramk, Integer.valueOf(1));
  }
  
  private void b(TTAppDownloadListener paramTTAppDownloadListener) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(hashCode());
    stringBuilder.append("registerMultiProcessListener, mMetaMd5:");
    stringBuilder.append(this.v);
    t.e("DMLibManager", stringBuilder.toString());
    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
      if (paramTTAppDownloadListener == null)
        return; 
      (new Thread(new Runnable(this, paramTTAppDownloadListener) {
            public void run() {
              com.bytedance.sdk.openadsdk.multipro.aidl.a a = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(o.a());
              e e = new e(this.a);
              IListenerManager iListenerManager = com.bytedance.sdk.openadsdk.multipro.aidl.a.b.asInterface(a.a(3));
              if (iListenerManager != null)
                try {
                  iListenerManager.registerTTAppDownloadListener(b.f(this.b), (ITTAppDownloadListener)e);
                  b.g(this.b).add(e);
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("registerMultiProcessListener, mTTAppDownloadListenerList size:");
                  stringBuilder.append(b.g(this.b).size());
                  t.e("DMLibManager", stringBuilder.toString());
                  return;
                } catch (RemoteException remoteException) {
                  remoteException.printStackTrace();
                }  
            }
          })).start();
    } 
  }
  
  private static void b(String paramString) {
    t.b("DMLibManager", paramString);
  }
  
  private void d(boolean paramBoolean) {
    if (paramBoolean) {
      d.a(s(), this.d, this.e, "quickapp_success");
      return;
    } 
    d.a(s(), this.d, this.e, "quickapp_fail");
  }
  
  private void n() {}
  
  private void o() {
    b("tryReleaseResource==");
    WeakReference<Context> weakReference = this.b;
    if (weakReference == null) {
      b("tryReleaseResource==  mContext is null");
      return;
    } 
    if (weakReference.get() instanceof Activity) {
      Activity activity = (Activity)this.b.get();
    } else {
      weakReference = null;
    } 
    if (weakReference == null) {
      b("tryReleaseResource==  activity is null");
      return;
    } 
    if (h.c().a((Activity)weakReference)) {
      b("tryReleaseResource==  isActivityAlive is true");
      return;
    } 
    w();
  }
  
  private void p() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_1
    //   10: aload_1
    //   11: ldc_w 'unbindDownload=='
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_1
    //   19: aload_0
    //   20: getfield o : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: invokevirtual get : ()Z
    //   26: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_1
    //   31: invokevirtual toString : ()Ljava/lang/String;
    //   34: invokestatic b : (Ljava/lang/String;)V
    //   37: aload_0
    //   38: getfield c : Lcom/bytedance/sdk/openadsdk/core/d/b;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnonnull -> 49
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: getfield o : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   53: invokevirtual get : ()Z
    //   56: ifeq -> 86
    //   59: aload_0
    //   60: getfield o : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   63: iconst_0
    //   64: invokevirtual set : (Z)V
    //   67: invokestatic d : ()Lcom/ss/android/downloadlib/h;
    //   70: aload_0
    //   71: getfield i : Lcom/ss/android/a/a/b/c;
    //   74: invokeinterface a : ()Ljava/lang/String;
    //   79: aload_0
    //   80: invokevirtual hashCode : ()I
    //   83: invokevirtual a : (Ljava/lang/String;I)V
    //   86: aload_0
    //   87: invokespecial o : ()V
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Exception table:
    //   from	to	target	type
    //   2	42	93	finally
    //   49	86	93	finally
    //   86	90	93	finally
  }
  
  private void q() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_1
    //   10: aload_1
    //   11: ldc_w 'bindDownload=='
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_1
    //   19: aload_0
    //   20: getfield o : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: invokevirtual get : ()Z
    //   26: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_1
    //   31: invokevirtual toString : ()Ljava/lang/String;
    //   34: invokestatic b : (Ljava/lang/String;)V
    //   37: aload_0
    //   38: getfield c : Lcom/bytedance/sdk/openadsdk/core/d/b;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnonnull -> 49
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: getfield o : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   53: invokevirtual get : ()Z
    //   56: pop
    //   57: aload_0
    //   58: getfield o : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   61: iconst_1
    //   62: invokevirtual set : (Z)V
    //   65: invokestatic d : ()Lcom/ss/android/downloadlib/h;
    //   68: aload_0
    //   69: invokespecial s : ()Landroid/content/Context;
    //   72: aload_0
    //   73: invokevirtual hashCode : ()I
    //   76: aload_0
    //   77: getfield w : Lcom/ss/android/a/a/b/d;
    //   80: aload_0
    //   81: getfield i : Lcom/ss/android/a/a/b/c;
    //   84: invokevirtual a : (Landroid/content/Context;ILcom/ss/android/a/a/b/d;Lcom/ss/android/a/a/b/c;)V
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Exception table:
    //   from	to	target	type
    //   2	42	90	finally
    //   49	87	90	finally
  }
  
  private boolean r() {
    if (this.c != null) {
      if (!i())
        return false; 
      boolean bool = a(s(), this.c.a(), this.d, this.e);
      if (bool) {
        Message message = Message.obtain();
        message.what = 9;
        this.t.sendMessageDelayed(message, 3000L);
        return bool;
      } 
      d(false);
      return bool;
    } 
    return false;
  }
  
  private Context s() {
    WeakReference<Context> weakReference = this.b;
    return (weakReference == null || weakReference.get() == null) ? o.a() : this.b.get();
  }
  
  private void t() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial s : ()Landroid/content/Context;
    //   4: ldc_w 'tt_confirm_download'
    //   7: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   10: astore #5
    //   12: aload_0
    //   13: getfield c : Lcom/bytedance/sdk/openadsdk/core/d/b;
    //   16: astore #6
    //   18: iconst_0
    //   19: istore_3
    //   20: aload #5
    //   22: astore #4
    //   24: aload #6
    //   26: ifnull -> 73
    //   29: aload #5
    //   31: astore #4
    //   33: aload #6
    //   35: invokevirtual c : ()Ljava/lang/String;
    //   38: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   41: ifne -> 73
    //   44: aload_0
    //   45: invokespecial s : ()Landroid/content/Context;
    //   48: ldc_w 'tt_confirm_download_have_app_name'
    //   51: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   54: iconst_1
    //   55: anewarray java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield c : Lcom/bytedance/sdk/openadsdk/core/d/b;
    //   64: invokevirtual c : ()Ljava/lang/String;
    //   67: aastore
    //   68: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   71: astore #4
    //   73: aload_0
    //   74: invokespecial s : ()Landroid/content/Context;
    //   77: ldc_w 'tt_tip'
    //   80: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   83: astore #7
    //   85: iload_3
    //   86: istore_2
    //   87: aload_0
    //   88: invokespecial s : ()Landroid/content/Context;
    //   91: ifnull -> 152
    //   94: iload_3
    //   95: istore_2
    //   96: aload_0
    //   97: invokespecial s : ()Landroid/content/Context;
    //   100: instanceof android/app/Activity
    //   103: ifeq -> 152
    //   106: aload_0
    //   107: invokespecial s : ()Landroid/content/Context;
    //   110: checkcast android/app/Activity
    //   113: astore #5
    //   115: getstatic android/os/Build$VERSION.SDK_INT : I
    //   118: bipush #17
    //   120: if_icmplt -> 146
    //   123: aload #5
    //   125: invokevirtual isDestroyed : ()Z
    //   128: ifne -> 141
    //   131: iload_3
    //   132: istore_2
    //   133: aload #5
    //   135: invokevirtual isFinishing : ()Z
    //   138: ifeq -> 152
    //   141: iconst_1
    //   142: istore_2
    //   143: goto -> 152
    //   146: aload #5
    //   148: invokevirtual isFinishing : ()Z
    //   151: istore_2
    //   152: aload_0
    //   153: invokespecial s : ()Landroid/content/Context;
    //   156: ifnull -> 304
    //   159: aload_0
    //   160: invokespecial s : ()Landroid/content/Context;
    //   163: instanceof android/app/Activity
    //   166: ifeq -> 304
    //   169: iload_2
    //   170: ifeq -> 176
    //   173: goto -> 304
    //   176: getstatic android/os/Build$VERSION.SDK_INT : I
    //   179: bipush #21
    //   181: if_icmplt -> 198
    //   184: aload_0
    //   185: invokespecial s : ()Landroid/content/Context;
    //   188: astore #5
    //   190: ldc_w 'Theme.Dialog.TTDownload'
    //   193: astore #6
    //   195: goto -> 209
    //   198: aload_0
    //   199: invokespecial s : ()Landroid/content/Context;
    //   202: astore #5
    //   204: ldc_w 'Theme.Dialog.TTDownloadOld'
    //   207: astore #6
    //   209: aload #5
    //   211: aload #6
    //   213: invokestatic g : (Landroid/content/Context;Ljava/lang/String;)I
    //   216: istore_1
    //   217: new android/app/AlertDialog$Builder
    //   220: dup
    //   221: aload_0
    //   222: invokespecial s : ()Landroid/content/Context;
    //   225: iload_1
    //   226: invokespecial <init> : (Landroid/content/Context;I)V
    //   229: astore #5
    //   231: aload #5
    //   233: aload #7
    //   235: invokevirtual setTitle : (Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;
    //   238: aload #4
    //   240: invokevirtual setMessage : (Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;
    //   243: aload_0
    //   244: invokespecial s : ()Landroid/content/Context;
    //   247: ldc_w 'tt_label_ok'
    //   250: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   253: new com/bytedance/sdk/openadsdk/downloadnew/a/b$4
    //   256: dup
    //   257: aload_0
    //   258: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/downloadnew/a/b;)V
    //   261: invokevirtual setPositiveButton : (Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;
    //   264: aload_0
    //   265: invokespecial s : ()Landroid/content/Context;
    //   268: ldc_w 'tt_label_cancel'
    //   271: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   274: new com/bytedance/sdk/openadsdk/downloadnew/a/b$3
    //   277: dup
    //   278: aload_0
    //   279: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/downloadnew/a/b;)V
    //   282: invokevirtual setNegativeButton : (Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;
    //   285: new com/bytedance/sdk/openadsdk/downloadnew/a/b$2
    //   288: dup
    //   289: aload_0
    //   290: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/downloadnew/a/b;)V
    //   293: invokevirtual setOnCancelListener : (Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;
    //   296: pop
    //   297: aload #5
    //   299: invokevirtual show : ()Landroid/app/AlertDialog;
    //   302: pop
    //   303: return
    //   304: aload_0
    //   305: aload #7
    //   307: aload #4
    //   309: invokespecial a : (Ljava/lang/String;Ljava/lang/String;)V
    //   312: return
  }
  
  private void u() {
    v();
    this.k.set(true);
    if (o.h().d())
      ah.a(this.d, this.e); 
  }
  
  private void v() {
    f();
  }
  
  private void w() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(hashCode());
    stringBuilder.append("unregisterMultiProcessListener, mMetaMd5:");
    stringBuilder.append(this.v);
    t.e("DMLibManager", stringBuilder.toString());
    if (!com.bytedance.sdk.openadsdk.multipro.b.b())
      return; 
    (new Thread(new Runnable(this) {
          public void run() {
            IListenerManager iListenerManager = com.bytedance.sdk.openadsdk.multipro.aidl.a.b.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(o.a()).a(3));
            try {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("unregisterMultiProcessListener, mTTAppDownloadListenerList size:");
              stringBuilder.append(b.g(this.a).size());
              t.e("DMLibManager", stringBuilder.toString());
              if (iListenerManager != null && b.g(this.a).size() > 0) {
                for (ITTAppDownloadListener iTTAppDownloadListener : b.g(this.a))
                  iListenerManager.unregisterTTAppDownloadListener(b.f(this.a), iTTAppDownloadListener); 
                b.g(this.a).clear();
                return;
              } 
            } catch (RemoteException remoteException) {
              remoteException.printStackTrace();
            } 
          }
        })).start();
  }
  
  private void x() {
    com.bytedance.sdk.openadsdk.core.d.b b1 = this.c;
    if (b1 != null && b1.b() != null)
      j(); 
  }
  
  public void a() {
    q();
    n();
  }
  
  public void a(int paramInt, a.a parama) {
    if (this.r == null)
      this.r = new HashSet<Integer>(); 
    this.r.add(Integer.valueOf(paramInt));
    d.a(paramInt, parama);
  }
  
  public void a(long paramLong) {
    this.n.set(paramLong);
  }
  
  public void a(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setActivity==activity:");
    stringBuilder.append(paramActivity.getLocalClassName());
    t.e("DMLibManager", stringBuilder.toString());
    if (paramActivity == null)
      return; 
    this.b = new WeakReference(paramActivity);
    q();
  }
  
  public void a(Message paramMessage) {
    if (paramMessage.what != 9)
      return; 
    if (h.c() != null && !h.c().a()) {
      d(false);
      boolean bool = this.u;
      if (bool) {
        if (b(bool))
          return; 
        x();
      } 
      return;
    } 
    d(true);
  }
  
  public void a(View paramView) {
    if (paramView != null)
      this.p = new WeakReference<View>(paramView); 
  }
  
  public void a(TTAppDownloadListener paramTTAppDownloadListener) {
    a(paramTTAppDownloadListener, true);
  }
  
  public void a(TTAppDownloadListener paramTTAppDownloadListener, boolean paramBoolean) {
    if (paramTTAppDownloadListener == null)
      return; 
    c c1 = this.s;
    if (c1 != null)
      c1.a(paramTTAppDownloadListener); 
    if (paramBoolean)
      b(paramTTAppDownloadListener); 
    p();
    q();
  }
  
  public boolean a(Context paramContext, String paramString) {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString))
        return false; 
      try {
        boolean bool = ah.c(paramContext, paramString);
        return false;
      } finally {
        paramContext = null;
      } 
    } 
    return false;
  }
  
  public boolean a(boolean paramBoolean) {
    this.u = paramBoolean;
    return r();
  }
  
  public void b() {
    if (o.a() == null)
      o.a(s()); 
    this.m = true;
    q();
  }
  
  public void b(long paramLong) {
    if (this.c == null)
      return; 
    this.o.set(false);
    d.d().a(this.i.a(), true);
    q();
  }
  
  public boolean b(boolean paramBoolean) {
    return false;
  }
  
  public void c() {
    this.m = false;
  }
  
  public void c(boolean paramBoolean) {
    this.q = paramBoolean;
  }
  
  public void d() {
    c c1 = this.s;
    if (c1 != null)
      c1.a(); 
    p();
    HashSet<Integer> hashSet = this.r;
    if (hashSet != null) {
      Iterator<Integer> iterator = hashSet.iterator();
      while (iterator.hasNext()) {
        d.a(((Integer)iterator.next()).intValue());
        iterator.remove();
      } 
    } 
    WeakReference<Context> weakReference = this.b;
    if (weakReference != null) {
      weakReference.clear();
      this.b = null;
    } 
  }
  
  public boolean e() {
    return this.k.get();
  }
  
  public void f() {
    if (s() != null) {
      if (this.c == null)
        return; 
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
      if (!this.d.s() && d.a(s(), this.c.b())) {
        b("changeDownloadStatus, not support pause/continue function");
        try {
          Toast.makeText(s(), "应用正在下载...", 0).show();
          return;
        } catch (Exception exception) {
          return;
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("changeDownloadStatus, the current status is1: ");
      stringBuilder.append(this.j);
      b(stringBuilder.toString());
      d.d().a(this.c.b(), this.i.d(), 2, this.h, this.g);
      stringBuilder = new StringBuilder();
      stringBuilder.append("changeDownloadStatus, the current status is2: ");
      stringBuilder.append(this.j);
      b(stringBuilder.toString());
    } 
  }
  
  public void g() {
    b(0L);
  }
  
  public void h() {
    if (s() != null) {
      if (this.c == null)
        return; 
      if (m()) {
        this.k.set(true);
        return;
      } 
      if (k())
        return; 
      if (r()) {
        this.k.set(true);
        return;
      } 
      if (b(this.u)) {
        this.k.set(true);
        return;
      } 
      x();
    } 
  }
  
  public boolean i() {
    k k1 = this.d;
    return (k1 != null && k1.y() != null && this.c != null && this.d.y().b() == 3 && this.c.a() != null);
  }
  
  public boolean j() {
    if (this.j.get() == 1) {
      int i = w.c(s());
      if (i == 0) {
        Toast.makeText(s(), ab.b(s(), "tt_no_network"), 0).show();
        return true;
      } 
      if (a(i)) {
        t();
        return true;
      } 
      u();
      return true;
    } 
    f();
    if (this.j.get() == 3 || this.j.get() == 4) {
      this.k.set(false);
      return false;
    } 
    if (this.j.get() == 6)
      this.k.set(true); 
    return false;
  }
  
  public boolean k() {
    com.bytedance.sdk.openadsdk.core.d.b b1 = this.c;
    boolean bool2 = false;
    if (b1 == null)
      return false; 
    String str = b1.d();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str)) {
      bool1 = bool2;
      if (a(s(), str)) {
        AtomicBoolean atomicBoolean = this.k;
        bool2 = true;
        atomicBoolean.set(true);
        bool1 = bool2;
        if (!a(this.e, "click_open", this.d)) {
          String str1 = ah.f(this.d);
          d.q(s(), this.d, this.e, str1, null);
          bool1 = bool2;
        } 
      } 
    } 
    return bool1;
  }
  
  protected IListenerManager l() {
    if (this.a == null)
      this.a = com.bytedance.sdk.openadsdk.multipro.aidl.a.b.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(o.a()).a(3)); 
    return this.a;
  }
  
  public boolean m() {
    if (this.d.O() != null) {
      String str = this.d.O().a();
      if (!TextUtils.isEmpty(str)) {
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (ah.a(s(), intent)) {
          if (!(s() instanceof Activity))
            intent.addFlags(268435456); 
          try {
            if (o.h().d())
              ah.a(this.d, this.e); 
            s().startActivity(intent);
            return true;
          } finally {
            uri = null;
            if (this.d.E() != null)
              z.a(s(), this.d.E(), this.d, ah.a(this.e), this.e, true); 
          } 
        } 
      } 
      if (this.j.get() != 4 && this.j.get() != 3 && (!this.l || this.k.get())) {
        this.l = true;
        if (!a(this.e, "open_fallback_url", this.d))
          d.p(s(), this.d, this.e, "open_fallback_url", null); 
      } 
    } 
    return false;
  }
  
  class a implements Runnable {
    String a;
    
    long b;
    
    long c;
    
    String d;
    
    String e;
    
    public a(b this$0) {}
    
    public a(b this$0, String param1String1, long param1Long1, long param1Long2, String param1String2, String param1String3) {
      this.a = param1String1;
      this.b = param1Long1;
      this.c = param1Long2;
      this.d = param1String2;
      this.e = param1String3;
    }
    
    public void a(long param1Long) {
      this.b = param1Long;
    }
    
    public void a(String param1String) {
      this.a = param1String;
    }
    
    public void b(long param1Long) {
      this.c = param1Long;
    }
    
    public void b(String param1String) {
      this.d = param1String;
    }
    
    public void c(String param1String) {
      this.e = param1String;
    }
    
    public void run() {
      try {
        return;
      } finally {
        Exception exception = null;
        t.c("DMLibManager", "executeRewardVideoCallback execute throw Exception : ", exception);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\downloadnew\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */