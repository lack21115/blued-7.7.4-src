package com.bytedance.sdk.adnet.a;

import android.content.Context;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.c.a;
import com.bytedance.sdk.adnet.c.f;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.d.d;
import com.bytedance.sdk.adnet.d.f;
import com.bytedance.sdk.adnet.d.g;
import com.bytedance.sdk.adnet.d.i;
import com.bytedance.sdk.adnet.d.j;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a implements a, j.a {
  private static a b;
  
  final j a = new j(Looper.getMainLooper(), this);
  
  private final boolean c;
  
  private volatile boolean d = false;
  
  private boolean e = true;
  
  private boolean f = false;
  
  private long g = 0L;
  
  private long h = 0L;
  
  private AtomicBoolean i = new AtomicBoolean(false);
  
  private final Context j;
  
  private volatile boolean k = false;
  
  private a(Context paramContext, boolean paramBoolean) {
    this.j = paramContext;
    this.c = paramBoolean;
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/adnet/a/a
    //   2: monitorenter
    //   3: getstatic com/bytedance/sdk/adnet/a/a.b : Lcom/bytedance/sdk/adnet/a/a;
    //   6: ifnonnull -> 35
    //   9: aload_0
    //   10: invokestatic b : (Landroid/content/Context;)Z
    //   13: istore_1
    //   14: new com/bytedance/sdk/adnet/a/a
    //   17: dup
    //   18: aload_0
    //   19: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   22: iload_1
    //   23: invokespecial <init> : (Landroid/content/Context;Z)V
    //   26: putstatic com/bytedance/sdk/adnet/a/a.b : Lcom/bytedance/sdk/adnet/a/a;
    //   29: getstatic com/bytedance/sdk/adnet/a/a.b : Lcom/bytedance/sdk/adnet/a/a;
    //   32: invokestatic a : (Lcom/bytedance/sdk/adnet/c/a;)V
    //   35: getstatic com/bytedance/sdk/adnet/a/a.b : Lcom/bytedance/sdk/adnet/a/a;
    //   38: astore_0
    //   39: ldc com/bytedance/sdk/adnet/a/a
    //   41: monitorexit
    //   42: aload_0
    //   43: areturn
    //   44: astore_0
    //   45: ldc com/bytedance/sdk/adnet/a/a
    //   47: monitorexit
    //   48: aload_0
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   3	35	44	finally
    //   35	42	44	finally
    //   45	48	44	finally
  }
  
  private void a(int paramInt) {
    String[] arrayOfString = d();
    if (arrayOfString == null || arrayOfString.length <= paramInt) {
      b(102);
      return;
    } 
    String str = arrayOfString[paramInt];
    if (TextUtils.isEmpty(str)) {
      b(102);
      return;
    } 
    try {
      return;
    } finally {
      str = null;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("try app config exception: ");
      stringBuilder.append(str);
      d.b("AppConfig", stringBuilder.toString());
    } 
  }
  
  private boolean a(Object paramObject) throws Exception {
    // Byte code:
    //   0: aload_1
    //   1: instanceof java/lang/String
    //   4: ifeq -> 48
    //   7: aload_1
    //   8: checkcast java/lang/String
    //   11: astore_1
    //   12: aload_1
    //   13: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   16: ifeq -> 21
    //   19: iconst_0
    //   20: ireturn
    //   21: new org/json/JSONObject
    //   24: dup
    //   25: aload_1
    //   26: invokespecial <init> : (Ljava/lang/String;)V
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: ldc 'success'
    //   34: aload_2
    //   35: ldc 'message'
    //   37: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual equals : (Ljava/lang/Object;)Z
    //   43: ifne -> 65
    //   46: iconst_0
    //   47: ireturn
    //   48: aload_1
    //   49: instanceof org/json/JSONObject
    //   52: ifeq -> 63
    //   55: aload_1
    //   56: checkcast org/json/JSONObject
    //   59: astore_1
    //   60: goto -> 65
    //   63: aconst_null
    //   64: astore_1
    //   65: aload_1
    //   66: ifnonnull -> 71
    //   69: iconst_0
    //   70: ireturn
    //   71: aload_1
    //   72: ldc 'data'
    //   74: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   77: astore_1
    //   78: aload_0
    //   79: monitorenter
    //   80: aload_0
    //   81: getfield j : Landroid/content/Context;
    //   84: ldc 'ss_app_config'
    //   86: iconst_0
    //   87: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   90: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   95: astore_2
    //   96: aload_2
    //   97: ldc 'last_refresh_time'
    //   99: invokestatic currentTimeMillis : ()J
    //   102: invokeinterface putLong : (Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   107: pop
    //   108: aload_2
    //   109: invokeinterface apply : ()V
    //   114: aload_0
    //   115: monitorexit
    //   116: invokestatic a : ()Lcom/bytedance/sdk/adnet/c/f;
    //   119: invokevirtual e : ()Lcom/bytedance/sdk/adnet/c/e;
    //   122: ifnull -> 135
    //   125: invokestatic a : ()Lcom/bytedance/sdk/adnet/c/f;
    //   128: invokevirtual e : ()Lcom/bytedance/sdk/adnet/c/e;
    //   131: aload_1
    //   132: invokevirtual a : (Lorg/json/JSONObject;)V
    //   135: iconst_1
    //   136: ireturn
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Exception table:
    //   from	to	target	type
    //   80	116	137	finally
    //   138	140	137	finally
  }
  
  private String b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("https://");
    stringBuilder.append(paramString);
    stringBuilder.append("/get_domains/v4/");
    Address address = com.bytedance.sdk.adnet.a.a().a(this.j);
    i i = new i(stringBuilder.toString());
    if (address != null && address.hasLatitude() && address.hasLongitude()) {
      i.a("latitude", address.getLatitude());
      i.a("longitude", address.getLongitude());
      String str = address.getLocality();
      if (!TextUtils.isEmpty(str))
        i.a("city", Uri.encode(str)); 
    } 
    if (this.d)
      i.a("force", 1); 
    try {
      String str;
      if (Build.VERSION.SDK_INT < 21) {
        str = Build.CPU_ABI;
      } else {
        str = Build.SUPPORTED_ABIS[0];
      } 
    } finally {
      address = null;
    } 
    i.a("aid", com.bytedance.sdk.adnet.a.a().a());
    i.a("device_platform", com.bytedance.sdk.adnet.a.a().c());
    i.a("channel", com.bytedance.sdk.adnet.a.a().b());
    i.a("version_code", com.bytedance.sdk.adnet.a.a().d());
    i.a("device_id", com.bytedance.sdk.adnet.a.a().e());
    return i.toString();
  }
  
  private void b(int paramInt) {
    j j1 = this.a;
    if (j1 != null)
      j1.sendEmptyMessage(paramInt); 
  }
  
  public static void b(Context paramContext) {
    a a1 = b;
    if (a1 != null) {
      if (g.b(paramContext)) {
        a1.a(true);
        return;
      } 
      a1.a();
    } 
  }
  
  private void d(boolean paramBoolean) {
    long l1;
    if (this.f)
      return; 
    if (this.e) {
      this.e = false;
      this.g = 0L;
      this.h = 0L;
    } 
    if (paramBoolean) {
      l1 = 10800000L;
    } else {
      l1 = 43200000L;
    } 
    long l2 = System.currentTimeMillis();
    if (l2 - this.g > l1 && l2 - this.h > 120000L) {
      paramBoolean = f.a(this.j);
      if (!this.k || paramBoolean)
        b(paramBoolean); 
    } 
  }
  
  private boolean e() {
    String[] arrayOfString = d();
    if (arrayOfString != null) {
      if (arrayOfString.length == 0)
        return false; 
      a(0);
    } 
    return false;
  }
  
  public String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return paramString; 
    if (Looper.myLooper() == Looper.getMainLooper())
      try {
        return f.a().a(paramString);
      } finally {
        Exception exception = null;
      }  
    try {
      return f.a().a(paramString);
    } finally {
      Exception exception = null;
    } 
  }
  
  public void a() {
    a(false);
  }
  
  public void a(Message paramMessage) {
    int i = paramMessage.what;
    if (i != 101) {
      if (i != 102)
        return; 
      this.f = false;
      if (this.e)
        a(); 
      d.b("TNCManager", "doRefresh, error");
      this.i.set(false);
      return;
    } 
    this.f = false;
    this.g = System.currentTimeMillis();
    d.b("TNCManager", "doRefresh, succ");
    if (this.e)
      a(); 
    this.i.set(false);
  }
  
  public void a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Z
    //   6: ifeq -> 17
    //   9: aload_0
    //   10: iload_1
    //   11: invokespecial d : (Z)V
    //   14: goto -> 42
    //   17: aload_0
    //   18: getfield g : J
    //   21: lstore_2
    //   22: lload_2
    //   23: lconst_0
    //   24: lcmp
    //   25: ifgt -> 42
    //   28: new com/bytedance/sdk/adnet/a/a$1
    //   31: dup
    //   32: aload_0
    //   33: ldc_w 'LoadDomainConfig4Other-Thread'
    //   36: invokespecial <init> : (Lcom/bytedance/sdk/adnet/a/a;Ljava/lang/String;)V
    //   39: invokevirtual start : ()V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore #4
    //   47: aload_0
    //   48: monitorexit
    //   49: aload #4
    //   51: athrow
    //   52: astore #4
    //   54: goto -> 42
    // Exception table:
    //   from	to	target	type
    //   2	14	45	finally
    //   17	22	45	finally
    //   28	42	52	finally
  }
  
  void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic currentTimeMillis : ()J
    //   5: aload_0
    //   6: getfield g : J
    //   9: lsub
    //   10: ldc2_w 3600000
    //   13: lcmp
    //   14: ifle -> 42
    //   17: aload_0
    //   18: invokestatic currentTimeMillis : ()J
    //   21: putfield g : J
    //   24: invokestatic a : ()Lcom/bytedance/sdk/adnet/c/f;
    //   27: invokevirtual e : ()Lcom/bytedance/sdk/adnet/c/e;
    //   30: ifnull -> 42
    //   33: invokestatic a : ()Lcom/bytedance/sdk/adnet/c/f;
    //   36: invokevirtual e : ()Lcom/bytedance/sdk/adnet/c/e;
    //   39: invokevirtual b : ()V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: goto -> 42
    // Exception table:
    //   from	to	target	type
    //   2	24	45	finally
    //   24	42	50	java/lang/Exception
    //   24	42	45	finally
  }
  
  public boolean b(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("doRefresh: updating state");
    stringBuilder.append(this.i.get());
    d.b("TNCManager", stringBuilder.toString());
    if (!this.i.compareAndSet(false, true)) {
      d.b("TNCManager", "doRefresh, already running");
      return false;
    } 
    if (paramBoolean)
      this.h = System.currentTimeMillis(); 
    (new Thread(this, "AppConfigThread", paramBoolean) {
        public void run() {
          this.b.c(this.a);
        }
      }).start();
    return true;
  }
  
  public void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield k : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield k : Z
    //   19: aload_0
    //   20: getfield j : Landroid/content/Context;
    //   23: ldc 'ss_app_config'
    //   25: iconst_0
    //   26: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   29: ldc 'last_refresh_time'
    //   31: lconst_0
    //   32: invokeinterface getLong : (Ljava/lang/String;J)J
    //   37: lstore #4
    //   39: invokestatic currentTimeMillis : ()J
    //   42: lstore #6
    //   44: lload #4
    //   46: lstore_2
    //   47: lload #4
    //   49: lload #6
    //   51: lcmp
    //   52: ifle -> 58
    //   55: lload #6
    //   57: lstore_2
    //   58: aload_0
    //   59: lload_2
    //   60: putfield g : J
    //   63: invokestatic a : ()Lcom/bytedance/sdk/adnet/c/f;
    //   66: invokevirtual e : ()Lcom/bytedance/sdk/adnet/c/e;
    //   69: ifnull -> 81
    //   72: invokestatic a : ()Lcom/bytedance/sdk/adnet/c/f;
    //   75: invokevirtual e : ()Lcom/bytedance/sdk/adnet/c/e;
    //   78: invokevirtual a : ()V
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: astore #8
    //   86: aload_0
    //   87: monitorexit
    //   88: aload #8
    //   90: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	84	finally
    //   14	44	84	finally
    //   58	81	84	finally
  }
  
  void c(boolean paramBoolean) {
    d.b("TNCManager", "doRefresh, actual request");
    c();
    this.f = true;
    if (!paramBoolean) {
      this.a.sendEmptyMessage(102);
      return;
    } 
    try {
      e();
      return;
    } catch (Exception exception) {
      this.i.set(false);
      return;
    } 
  }
  
  public String[] d() {
    String[] arrayOfString = com.bytedance.sdk.adnet.a.a().f();
    if (arrayOfString != null) {
      String[] arrayOfString1 = arrayOfString;
      return (arrayOfString.length <= 0) ? new String[0] : arrayOfString1;
    } 
    return new String[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */