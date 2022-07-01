package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.packet.impl.a;
import com.alipay.sdk.protocol.a;
import com.alipay.sdk.protocol.b;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.e;
import com.alipay.sdk.widget.a;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AuthTask {
  static final Object a = e.class;
  
  private Activity b;
  
  private a c;
  
  public AuthTask(Activity paramActivity) {
    this.b = paramActivity;
    b.a().a((Context)this.b);
    this.c = new a(paramActivity, "去支付宝授权");
  }
  
  private e.a a() {
    return new a(this);
  }
  
  private String a(Activity paramActivity, String paramString, a parama) {
    // Byte code:
    //   0: aload_3
    //   1: aload_2
    //   2: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   5: astore #5
    //   7: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   10: invokevirtual i : ()Ljava/util/List;
    //   13: astore #4
    //   15: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   18: getfield a : Z
    //   21: ifeq -> 32
    //   24: aload #4
    //   26: astore_2
    //   27: aload #4
    //   29: ifnonnull -> 36
    //   32: getstatic com/alipay/sdk/app/i.a : Ljava/util/List;
    //   35: astore_2
    //   36: aload_3
    //   37: aload_0
    //   38: getfield b : Landroid/app/Activity;
    //   41: aload_2
    //   42: invokestatic b : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;Ljava/util/List;)Z
    //   45: ifeq -> 118
    //   48: new com/alipay/sdk/util/e
    //   51: dup
    //   52: aload_1
    //   53: aload_3
    //   54: aload_0
    //   55: invokespecial a : ()Lcom/alipay/sdk/util/e$a;
    //   58: invokespecial <init> : (Landroid/app/Activity;Lcom/alipay/sdk/sys/a;Lcom/alipay/sdk/util/e$a;)V
    //   61: aload #5
    //   63: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_2
    //   67: aload_2
    //   68: ldc 'failed'
    //   70: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   73: ifne -> 101
    //   76: aload_2
    //   77: ldc 'scheme_failed'
    //   79: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   82: ifeq -> 88
    //   85: goto -> 101
    //   88: aload_2
    //   89: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   92: ifeq -> 99
    //   95: invokestatic c : ()Ljava/lang/String;
    //   98: areturn
    //   99: aload_2
    //   100: areturn
    //   101: aload_3
    //   102: ldc 'biz'
    //   104: ldc 'LogBindCalledH5'
    //   106: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: aload_1
    //   111: aload #5
    //   113: aload_3
    //   114: invokespecial b : (Landroid/app/Activity;Ljava/lang/String;Lcom/alipay/sdk/sys/a;)Ljava/lang/String;
    //   117: areturn
    //   118: aload_3
    //   119: ldc 'biz'
    //   121: ldc 'LogCalledH5'
    //   123: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_0
    //   127: aload_1
    //   128: aload #5
    //   130: aload_3
    //   131: invokespecial b : (Landroid/app/Activity;Ljava/lang/String;Lcom/alipay/sdk/sys/a;)Ljava/lang/String;
    //   134: areturn
  }
  
  private String a(a parama, b paramb) {
    String[] arrayOfString = paramb.c();
    null = new Bundle();
    null.putString("url", arrayOfString[0]);
    Intent intent = new Intent((Context)this.b, H5AuthActivity.class);
    intent.putExtras(null);
    a.a.a(parama, intent);
    this.b.startActivity(intent);
    synchronized (a) {
      a.wait();
      String str = j.a();
      null = str;
      if (TextUtils.isEmpty(str))
        null = j.c(); 
      return (String)null;
    } 
  }
  
  private String b(Activity paramActivity, String paramString, a parama) {
    k k;
    b();
    try {
      List<b> list = b.a((new a()).a(parama, (Context)paramActivity, paramString).c().optJSONObject("form").optJSONObject("onload"));
      c();
      int i;
      for (i = 0; i < list.size(); i++) {
        if (((b)list.get(i)).b() == a.b)
          return a(parama, list.get(i)); 
      } 
      c();
    } catch (IOException iOException) {
      k k1 = k.b(k.d.a());
      a.a(parama, "net", iOException);
    } finally {
      paramActivity = null;
    } 
    Activity activity = paramActivity;
    if (paramActivity == null)
      k = k.b(k.b.a()); 
    return j.a(k.a(), k.b(), "");
  }
  
  private void b() {
    a a1 = this.c;
    if (a1 != null)
      a1.b(); 
  }
  
  private void c() {
    a a1 = this.c;
    if (a1 != null)
      a1.c(); 
  }
  
  public String auth(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: new com/alipay/sdk/sys/a
    //   6: dup
    //   7: aload_0
    //   8: getfield b : Landroid/app/Activity;
    //   11: aload_1
    //   12: ldc 'auth'
    //   14: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_1
    //   18: iload_2
    //   19: invokevirtual innerAuth : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Z)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	27	finally
  }
  
  public Map<String, String> authV2(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new com/alipay/sdk/sys/a
    //   5: dup
    //   6: aload_0
    //   7: getfield b : Landroid/app/Activity;
    //   10: aload_1
    //   11: ldc 'authV2'
    //   13: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   16: astore_3
    //   17: aload_3
    //   18: aload_0
    //   19: aload_3
    //   20: aload_1
    //   21: iload_2
    //   22: invokevirtual innerAuth : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Z)Ljava/lang/String;
    //   25: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;)Ljava/util/Map;
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	33	finally
  }
  
  public String innerAuth(a parama, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifeq -> 10
    //   6: aload_0
    //   7: invokespecial b : ()V
    //   10: invokestatic a : ()Lcom/alipay/sdk/sys/b;
    //   13: aload_0
    //   14: getfield b : Landroid/app/Activity;
    //   17: invokevirtual a : (Landroid/content/Context;)V
    //   20: invokestatic c : ()Ljava/lang/String;
    //   23: astore #6
    //   25: ldc ''
    //   27: invokestatic a : (Ljava/lang/String;)V
    //   30: aload_0
    //   31: aload_0
    //   32: getfield b : Landroid/app/Activity;
    //   35: aload_2
    //   36: aload_1
    //   37: invokespecial a : (Landroid/app/Activity;Ljava/lang/String;Lcom/alipay/sdk/sys/a;)Ljava/lang/String;
    //   40: astore #4
    //   42: new java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore #5
    //   51: aload #5
    //   53: ldc ''
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #5
    //   61: invokestatic elapsedRealtime : ()J
    //   64: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_1
    //   69: ldc 'biz'
    //   71: ldc_w 'PgReturn'
    //   74: aload #5
    //   76: invokevirtual toString : ()Ljava/lang/String;
    //   79: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   82: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   85: aload_1
    //   86: aload_0
    //   87: getfield b : Landroid/app/Activity;
    //   90: invokevirtual a : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;)V
    //   93: aload_0
    //   94: invokespecial c : ()V
    //   97: aload_0
    //   98: getfield b : Landroid/app/Activity;
    //   101: astore #7
    //   103: aload_1
    //   104: getfield p : Ljava/lang/String;
    //   107: astore #5
    //   109: aload #4
    //   111: astore #6
    //   113: aload #7
    //   115: astore #4
    //   117: aload #4
    //   119: aload_1
    //   120: aload_2
    //   121: aload #5
    //   123: invokestatic b : (Landroid/content/Context;Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   126: goto -> 211
    //   129: astore #4
    //   131: goto -> 216
    //   134: astore #4
    //   136: aload #4
    //   138: invokestatic a : (Ljava/lang/Throwable;)V
    //   141: new java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial <init> : ()V
    //   148: astore #4
    //   150: aload #4
    //   152: ldc ''
    //   154: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload #4
    //   160: invokestatic elapsedRealtime : ()J
    //   163: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_1
    //   168: ldc 'biz'
    //   170: ldc_w 'PgReturn'
    //   173: aload #4
    //   175: invokevirtual toString : ()Ljava/lang/String;
    //   178: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   181: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   184: aload_1
    //   185: aload_0
    //   186: getfield b : Landroid/app/Activity;
    //   189: invokevirtual a : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;)V
    //   192: aload_0
    //   193: invokespecial c : ()V
    //   196: aload_0
    //   197: getfield b : Landroid/app/Activity;
    //   200: astore #4
    //   202: aload_1
    //   203: getfield p : Ljava/lang/String;
    //   206: astore #5
    //   208: goto -> 117
    //   211: aload_0
    //   212: monitorexit
    //   213: aload #6
    //   215: areturn
    //   216: new java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial <init> : ()V
    //   223: astore #5
    //   225: aload #5
    //   227: ldc ''
    //   229: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload #5
    //   235: invokestatic elapsedRealtime : ()J
    //   238: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_1
    //   243: ldc 'biz'
    //   245: ldc_w 'PgReturn'
    //   248: aload #5
    //   250: invokevirtual toString : ()Ljava/lang/String;
    //   253: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   256: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   259: aload_1
    //   260: aload_0
    //   261: getfield b : Landroid/app/Activity;
    //   264: invokevirtual a : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;)V
    //   267: aload_0
    //   268: invokespecial c : ()V
    //   271: aload_0
    //   272: getfield b : Landroid/app/Activity;
    //   275: aload_1
    //   276: aload_2
    //   277: aload_1
    //   278: getfield p : Ljava/lang/String;
    //   281: invokestatic b : (Landroid/content/Context;Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload #4
    //   286: athrow
    //   287: astore_1
    //   288: aload_0
    //   289: monitorexit
    //   290: aload_1
    //   291: athrow
    // Exception table:
    //   from	to	target	type
    //   6	10	287	finally
    //   10	30	287	finally
    //   30	42	134	java/lang/Exception
    //   30	42	129	finally
    //   42	109	287	finally
    //   117	126	287	finally
    //   136	141	129	finally
    //   141	208	287	finally
    //   216	287	287	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\AuthTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */