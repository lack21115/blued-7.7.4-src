package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.packet.impl.f;
import com.alipay.sdk.protocol.b;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.H5PayResultModel;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.e;
import com.alipay.sdk.util.n;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class PayTask {
  static final Object a = e.class;
  
  private static long h = 0L;
  
  private static final long i = 3000L;
  
  private static long j = -1L;
  
  private Activity b;
  
  private com.alipay.sdk.widget.a c;
  
  private String d = "wappaygw.alipay.com/service/rest.htm";
  
  private String e = "mclient.alipay.com/service/rest.htm";
  
  private String f = "mclient.alipay.com/home/exterfaceAssign.htm";
  
  private Map<String, a> g = new HashMap<String, a>();
  
  public PayTask(Activity paramActivity) {
    this.b = paramActivity;
    b.a().a((Context)this.b);
    this.c = new com.alipay.sdk.widget.a(paramActivity, "去支付宝付款");
  }
  
  private e.a a() {
    return new h(this);
  }
  
  private String a(com.alipay.sdk.sys.a parama, b paramb) {
    String[] arrayOfString = paramb.c();
    Intent intent = new Intent((Context)this.b, H5PayActivity.class);
    Bundle bundle = new Bundle();
    bundle.putString("url", arrayOfString[0]);
    if (arrayOfString.length == 2)
      bundle.putString("cookie", arrayOfString[1]); 
    intent.putExtras(bundle);
    com.alipay.sdk.sys.a.a.a(parama, intent);
    this.b.startActivity(intent);
    Object object = a;
    /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    try {
      a.wait();
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
      String str = j.a();
      object = str;
      if (TextUtils.isEmpty(str))
        object = j.c(); 
      return (String)object;
    } catch (InterruptedException interruptedException) {
      c.a(interruptedException);
      String str = j.c();
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
      return str;
    } finally {}
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    throw arrayOfString;
  }
  
  private String a(com.alipay.sdk.sys.a parama, b paramb, String paramString) {
    Object object = paramb.c();
    Intent intent = new Intent((Context)this.b, H5PayActivity.class);
    try {
      JSONObject jSONObject = n.c(new String(com.alipay.sdk.encrypt.a.a(object[2])));
      intent.putExtra("url", object[0]);
      intent.putExtra("title", object[1]);
      intent.putExtra("version", "v2");
      intent.putExtra("method", jSONObject.optString("method", "POST"));
      j.a(false);
      j.a((String)null);
      com.alipay.sdk.sys.a.a.a(parama, intent);
      this.b.startActivity(intent);
      object = a;
      /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
      try {
        Object object1;
        a.wait();
        boolean bool = j.b();
        String str2 = j.a();
        j.a(false);
        j.a((String)null);
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
        String str1 = "";
        object = str1;
        return (String)object1;
      } catch (InterruptedException interruptedException) {
        return str;
      } finally {}
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
      throw parama;
    } finally {
      paramString = null;
      c.a((Throwable)paramString);
      a.a(parama, "biz", "H5PayDataAnalysisError", (Throwable)paramString, Arrays.toString((Object[])object));
    } 
  }
  
  private String a(com.alipay.sdk.sys.a parama, String paramString) {
    String str1;
    k k1;
    k k3;
    showLoading();
    String str2 = null;
    try {
      int i;
      JSONObject jSONObject = (new f()).a(parama, this.b.getApplicationContext(), paramString).c();
      String str = jSONObject.optString("end_code", null);
      List<b> list = b.a(jSONObject.optJSONObject("form").optJSONObject("onload"));
      byte b = 0;
    } catch (IOException iOException) {
      k3 = k.b(k.d.a());
      a.a((com.alipay.sdk.sys.a)str1, "net", iOException);
      dismissLoading();
      a.a((Context)this.b, (com.alipay.sdk.sys.a)str1, paramString, ((com.alipay.sdk.sys.a)str1).p);
    } finally {
      Exception exception = null;
    } 
    k k2 = k1;
    if (k1 == null)
      k2 = k.b(k.b.a()); 
    return j.a(k2.a(), k2.b(), "");
  }
  
  private static String a(com.alipay.sdk.sys.a parama, String paramString1, List<com.alipay.sdk.data.a.a> paramList, String paramString2, Activity paramActivity) {
    Object object;
    n.a a1 = n.a(parama, (Context)paramActivity, paramList);
    if (a1 != null && !a1.a(parama) && !a1.a()) {
      String str1;
      if (!TextUtils.equals(a1.a.packageName, "hk.alipay.wallet"))
        return paramString2; 
      c.a("mspl", "PayTask not_login");
      String str2 = String.valueOf(paramString1.hashCode());
      object = new Object();
      PayResultActivity.b.put(str2, object);
      object = new Intent((Context)paramActivity, PayResultActivity.class);
      object.putExtra("orderSuffix", paramString1);
      object.putExtra("externalPkgName", paramActivity.getPackageName());
      object.putExtra("phonecashier.pay.hash", str2);
      com.alipay.sdk.sys.a.a.a(parama, (Intent)object);
      paramActivity.startActivity((Intent)object);
      synchronized (PayResultActivity.b.get(str2)) {
        c.a("mspl", "PayTask wait");
        PayResultActivity.b.get(str2).wait();
        str1 = PayResultActivity.a.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PayTask ret: ");
        stringBuilder.append(str1);
        c.a("mspl", stringBuilder.toString());
        return str1;
      } 
    } 
    return (String)object;
  }
  
  private String a(com.alipay.sdk.sys.a parama, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic b : ()Z
    //   5: ifeq -> 27
    //   8: aload_1
    //   9: ldc 'biz'
    //   11: ldc_w 'RepPay'
    //   14: ldc ''
    //   16: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   19: invokestatic d : ()Ljava/lang/String;
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: iload_3
    //   28: ifeq -> 35
    //   31: aload_0
    //   32: invokevirtual showLoading : ()V
    //   35: aload_2
    //   36: ldc_w 'payment_inst='
    //   39: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   42: ifeq -> 119
    //   45: aload_2
    //   46: aload_2
    //   47: ldc_w 'payment_inst='
    //   50: invokevirtual indexOf : (Ljava/lang/String;)I
    //   53: bipush #13
    //   55: iadd
    //   56: invokevirtual substring : (I)Ljava/lang/String;
    //   59: astore #6
    //   61: aload #6
    //   63: bipush #38
    //   65: invokevirtual indexOf : (I)I
    //   68: istore #4
    //   70: aload #6
    //   72: astore #5
    //   74: iload #4
    //   76: ifle -> 89
    //   79: aload #6
    //   81: iconst_0
    //   82: iload #4
    //   84: invokevirtual substring : (II)Ljava/lang/String;
    //   87: astore #5
    //   89: aload #5
    //   91: ldc_w '"'
    //   94: ldc ''
    //   96: invokevirtual replaceAll : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   99: invokestatic getDefault : ()Ljava/util/Locale;
    //   102: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   105: ldc_w 'alipay'
    //   108: ldc ''
    //   110: invokevirtual replaceAll : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   113: invokestatic a : (Ljava/lang/String;)V
    //   116: goto -> 124
    //   119: ldc ''
    //   121: invokestatic a : (Ljava/lang/String;)V
    //   124: aload_2
    //   125: ldc_w 'service=alipay.acquire.mr.ord.createandpay'
    //   128: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   131: ifeq -> 138
    //   134: iconst_1
    //   135: putstatic com/alipay/sdk/cons/a.u : Z
    //   138: aload_2
    //   139: astore #5
    //   141: getstatic com/alipay/sdk/cons/a.u : Z
    //   144: ifeq -> 205
    //   147: aload_2
    //   148: ldc_w 'https://wappaygw.alipay.com/home/exterfaceAssign.htm?'
    //   151: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   154: ifeq -> 176
    //   157: aload_2
    //   158: aload_2
    //   159: ldc_w 'https://wappaygw.alipay.com/home/exterfaceAssign.htm?'
    //   162: invokevirtual indexOf : (Ljava/lang/String;)I
    //   165: bipush #53
    //   167: iadd
    //   168: invokevirtual substring : (I)Ljava/lang/String;
    //   171: astore #5
    //   173: goto -> 205
    //   176: aload_2
    //   177: astore #5
    //   179: aload_2
    //   180: ldc_w 'https://mclient.alipay.com/home/exterfaceAssign.htm?'
    //   183: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   186: ifeq -> 205
    //   189: aload_2
    //   190: aload_2
    //   191: ldc_w 'https://mclient.alipay.com/home/exterfaceAssign.htm?'
    //   194: invokevirtual indexOf : (Ljava/lang/String;)I
    //   197: bipush #52
    //   199: iadd
    //   200: invokevirtual substring : (I)Ljava/lang/String;
    //   203: astore #5
    //   205: new java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial <init> : ()V
    //   212: astore_2
    //   213: aload_2
    //   214: ldc_w 'pay prepared: '
    //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_2
    //   222: aload #5
    //   224: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: ldc_w 'mspl'
    //   231: aload_2
    //   232: invokevirtual toString : ()Ljava/lang/String;
    //   235: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload_0
    //   239: aload #5
    //   241: aload_1
    //   242: invokespecial a : (Ljava/lang/String;Lcom/alipay/sdk/sys/a;)Ljava/lang/String;
    //   245: astore_2
    //   246: new java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial <init> : ()V
    //   253: astore #6
    //   255: aload #6
    //   257: ldc_w 'pay raw result: '
    //   260: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload #6
    //   266: aload_2
    //   267: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: ldc_w 'mspl'
    //   274: aload #6
    //   276: invokevirtual toString : ()Ljava/lang/String;
    //   279: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   282: aload_1
    //   283: aload_0
    //   284: getfield b : Landroid/app/Activity;
    //   287: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   290: aload_2
    //   291: invokestatic a : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;Ljava/lang/String;)V
    //   294: new java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial <init> : ()V
    //   301: astore #6
    //   303: aload #6
    //   305: ldc ''
    //   307: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload #6
    //   313: invokestatic elapsedRealtime : ()J
    //   316: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_1
    //   321: ldc 'biz'
    //   323: ldc_w 'PgReturn'
    //   326: aload #6
    //   328: invokevirtual toString : ()Ljava/lang/String;
    //   331: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   334: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   337: aload_1
    //   338: aload_0
    //   339: getfield b : Landroid/app/Activity;
    //   342: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   345: invokevirtual a : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;)V
    //   348: aload_0
    //   349: invokevirtual dismissLoading : ()V
    //   352: aload_0
    //   353: getfield b : Landroid/app/Activity;
    //   356: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   359: aload_1
    //   360: aload #5
    //   362: aload_1
    //   363: getfield p : Ljava/lang/String;
    //   366: invokestatic b : (Landroid/content/Context;Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload_2
    //   370: astore_1
    //   371: goto -> 462
    //   374: astore #6
    //   376: invokestatic c : ()Ljava/lang/String;
    //   379: astore_2
    //   380: aload #6
    //   382: invokestatic a : (Ljava/lang/Throwable;)V
    //   385: new java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial <init> : ()V
    //   392: astore #6
    //   394: aload #6
    //   396: ldc ''
    //   398: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload #6
    //   404: invokestatic elapsedRealtime : ()J
    //   407: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload_1
    //   412: ldc 'biz'
    //   414: ldc_w 'PgReturn'
    //   417: aload #6
    //   419: invokevirtual toString : ()Ljava/lang/String;
    //   422: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   425: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   428: aload_1
    //   429: aload_0
    //   430: getfield b : Landroid/app/Activity;
    //   433: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   436: invokevirtual a : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;)V
    //   439: aload_0
    //   440: invokevirtual dismissLoading : ()V
    //   443: aload_0
    //   444: getfield b : Landroid/app/Activity;
    //   447: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   450: aload_1
    //   451: aload #5
    //   453: aload_1
    //   454: getfield p : Ljava/lang/String;
    //   457: invokestatic b : (Landroid/content/Context;Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   460: aload_2
    //   461: astore_1
    //   462: new java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial <init> : ()V
    //   469: astore_2
    //   470: aload_2
    //   471: ldc_w 'pay returning: '
    //   474: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: aload_2
    //   479: aload_1
    //   480: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: ldc_w 'mspl'
    //   487: aload_2
    //   488: invokevirtual toString : ()Ljava/lang/String;
    //   491: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   494: aload_0
    //   495: monitorexit
    //   496: aload_1
    //   497: areturn
    //   498: astore_2
    //   499: new java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial <init> : ()V
    //   506: astore #6
    //   508: aload #6
    //   510: ldc ''
    //   512: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload #6
    //   518: invokestatic elapsedRealtime : ()J
    //   521: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload_1
    //   526: ldc 'biz'
    //   528: ldc_w 'PgReturn'
    //   531: aload #6
    //   533: invokevirtual toString : ()Ljava/lang/String;
    //   536: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   539: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   542: aload_1
    //   543: aload_0
    //   544: getfield b : Landroid/app/Activity;
    //   547: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   550: invokevirtual a : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;)V
    //   553: aload_0
    //   554: invokevirtual dismissLoading : ()V
    //   557: aload_0
    //   558: getfield b : Landroid/app/Activity;
    //   561: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   564: aload_1
    //   565: aload #5
    //   567: aload_1
    //   568: getfield p : Ljava/lang/String;
    //   571: invokestatic b : (Landroid/content/Context;Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   574: aload_2
    //   575: athrow
    //   576: astore_1
    //   577: aload_0
    //   578: monitorexit
    //   579: aload_1
    //   580: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	576	finally
    //   31	35	576	finally
    //   35	70	576	finally
    //   79	89	576	finally
    //   89	116	576	finally
    //   119	124	576	finally
    //   124	138	576	finally
    //   141	173	576	finally
    //   179	205	576	finally
    //   205	294	374	finally
    //   294	369	576	finally
    //   376	385	498	finally
    //   385	460	576	finally
    //   462	494	576	finally
    //   499	576	576	finally
  }
  
  private String a(String paramString, com.alipay.sdk.sys.a parama) {
    // Byte code:
    //   0: aload_2
    //   1: aload_1
    //   2: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   5: astore #4
    //   7: aload #4
    //   9: ldc_w 'paymethod="expressGateway"'
    //   12: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   15: ifeq -> 26
    //   18: aload_0
    //   19: aload_2
    //   20: aload #4
    //   22: invokespecial a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;)Ljava/lang/String;
    //   25: areturn
    //   26: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   29: invokevirtual i : ()Ljava/util/List;
    //   32: astore_3
    //   33: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   36: getfield a : Z
    //   39: ifeq -> 48
    //   42: aload_3
    //   43: astore_1
    //   44: aload_3
    //   45: ifnonnull -> 52
    //   48: getstatic com/alipay/sdk/app/i.a : Ljava/util/List;
    //   51: astore_1
    //   52: aload_2
    //   53: aload_0
    //   54: getfield b : Landroid/app/Activity;
    //   57: aload_1
    //   58: invokestatic b : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;Ljava/util/List;)Z
    //   61: ifeq -> 258
    //   64: new com/alipay/sdk/util/e
    //   67: dup
    //   68: aload_0
    //   69: getfield b : Landroid/app/Activity;
    //   72: aload_2
    //   73: aload_0
    //   74: invokespecial a : ()Lcom/alipay/sdk/util/e$a;
    //   77: invokespecial <init> : (Landroid/app/Activity;Lcom/alipay/sdk/sys/a;Lcom/alipay/sdk/util/e$a;)V
    //   80: astore_3
    //   81: new java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial <init> : ()V
    //   88: astore #5
    //   90: aload #5
    //   92: ldc_w 'pay inner started: '
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload #5
    //   101: aload #4
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: ldc_w 'mspl'
    //   110: aload #5
    //   112: invokevirtual toString : ()Ljava/lang/String;
    //   115: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_3
    //   119: aload #4
    //   121: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   124: astore #5
    //   126: new java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial <init> : ()V
    //   133: astore #6
    //   135: aload #6
    //   137: ldc_w 'pay inner raw result: '
    //   140: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload #6
    //   146: aload #5
    //   148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: ldc_w 'mspl'
    //   155: aload #6
    //   157: invokevirtual toString : ()Ljava/lang/String;
    //   160: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_3
    //   164: invokevirtual a : ()V
    //   167: aload #5
    //   169: ldc_w 'failed'
    //   172: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   175: ifne -> 241
    //   178: aload #5
    //   180: ldc_w 'scheme_failed'
    //   183: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   186: ifeq -> 192
    //   189: goto -> 241
    //   192: aload #5
    //   194: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   197: ifeq -> 204
    //   200: invokestatic c : ()Ljava/lang/String;
    //   203: areturn
    //   204: aload #5
    //   206: ldc_w '{"isLogin":"false"}'
    //   209: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   212: ifeq -> 238
    //   215: aload_2
    //   216: ldc 'biz'
    //   218: ldc_w 'LogHkLoginByIntent'
    //   221: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload_2
    //   225: aload #4
    //   227: aload_1
    //   228: aload #5
    //   230: aload_0
    //   231: getfield b : Landroid/app/Activity;
    //   234: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Landroid/app/Activity;)Ljava/lang/String;
    //   237: areturn
    //   238: aload #5
    //   240: areturn
    //   241: aload_2
    //   242: ldc 'biz'
    //   244: ldc_w 'LogBindCalledH5'
    //   247: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload_0
    //   251: aload_2
    //   252: aload #4
    //   254: invokespecial a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;)Ljava/lang/String;
    //   257: areturn
    //   258: aload_2
    //   259: ldc 'biz'
    //   261: ldc_w 'LogCalledH5'
    //   264: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload_0
    //   268: aload_2
    //   269: aload #4
    //   271: invokespecial a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;)Ljava/lang/String;
    //   274: areturn
  }
  
  private String a(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("={");
    paramString2 = stringBuilder.toString();
    return paramString1.substring(paramString1.indexOf(paramString2) + paramString2.length(), paramString1.lastIndexOf("}"));
  }
  
  private String a(String paramString, Map<String, String> paramMap) throws UnsupportedEncodingException {
    String str1;
    boolean bool = "9000".equals(paramMap.get("resultStatus"));
    String str2 = paramMap.get("result");
    a a1 = this.g.remove(paramString);
    if (a1 != null) {
      paramString = a1.b();
    } else {
      paramString = "";
    } 
    if (a1 != null) {
      str1 = a1.d();
    } else {
      str1 = "";
    } 
    a(new String[] { paramString, str1 });
    if (paramMap.containsKey("callBackUrl"))
      return paramMap.get("callBackUrl"); 
    if (str2.length() > 15) {
      paramString = a(new String[] { n.a("&callBackUrl=\"", "\"", str2), n.a("&call_back_url=\"", "\"", str2), n.a("&return_url=\"", "\"", str2), URLDecoder.decode(n.a("&return_url=", "&", str2), "utf-8"), URLDecoder.decode(n.a("&callBackUrl=", "&", str2), "utf-8"), n.a("call_back_url=\"", "\"", str2) });
      if (!TextUtils.isEmpty(paramString))
        return paramString; 
    } 
    if (a1 != null) {
      if (bool) {
        paramString = a1.a();
      } else {
        paramString = a1.c();
      } 
      if (!TextUtils.isEmpty(paramString))
        return paramString; 
    } 
    return (a1 != null) ? com.alipay.sdk.data.a.j().e() : "";
  }
  
  private static final String a(String... paramVarArgs) {
    if (paramVarArgs == null)
      return ""; 
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      String str = paramVarArgs[i];
      if (!TextUtils.isEmpty(str))
        return str; 
    } 
    return "";
  }
  
  private void a(com.alipay.sdk.sys.a parama, JSONObject paramJSONObject) {
    try {
      String str2 = paramJSONObject.optString("tid");
      String str1 = paramJSONObject.optString("client_key");
      if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str1))
        return; 
    } finally {
      paramJSONObject = null;
    } 
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString, StringBuilder paramStringBuilder, Map<String, String> paramMap, String... paramVarArgs) {
    // Byte code:
    //   0: aload #6
    //   2: arraylength
    //   3: istore #8
    //   5: iconst_0
    //   6: istore #7
    //   8: iload #7
    //   10: iload #8
    //   12: if_icmpge -> 66
    //   15: aload #6
    //   17: iload #7
    //   19: aaload
    //   20: astore #9
    //   22: aload #5
    //   24: aload #9
    //   26: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast java/lang/CharSequence
    //   34: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   37: ifeq -> 49
    //   40: iload #7
    //   42: iconst_1
    //   43: iadd
    //   44: istore #7
    //   46: goto -> 8
    //   49: aload #5
    //   51: aload #9
    //   53: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   58: checkcast java/lang/String
    //   61: astore #5
    //   63: goto -> 70
    //   66: ldc ''
    //   68: astore #5
    //   70: aload #5
    //   72: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   75: ifeq -> 84
    //   78: iload_2
    //   79: ifeq -> 166
    //   82: iconst_0
    //   83: ireturn
    //   84: iload_1
    //   85: ifeq -> 133
    //   88: aload #4
    //   90: ldc_w '&'
    //   93: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload #4
    //   99: aload_3
    //   100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload #4
    //   106: ldc_w '="'
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload #4
    //   115: aload #5
    //   117: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload #4
    //   123: ldc_w '"'
    //   126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: goto -> 166
    //   133: aload #4
    //   135: aload_3
    //   136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload #4
    //   142: ldc_w '="'
    //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload #4
    //   151: aload #5
    //   153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload #4
    //   159: ldc_w '"'
    //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: iconst_1
    //   167: ireturn
  }
  
  private static boolean b() {
    long l = SystemClock.elapsedRealtime();
    if (l - j >= 3000L) {
      j = l;
      return false;
    } 
    return true;
  }
  
  public static boolean fetchSdkConfig(Context paramContext) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/alipay/sdk/app/PayTask}} */
    try {
      b.a().a(paramContext);
      long l1 = SystemClock.elapsedRealtime() / 1000L;
      long l2 = h;
      int i = com.alipay.sdk.data.a.j().f();
      if (l1 - l2 < i) {
        /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alipay/sdk/app/PayTask}} */
        return false;
      } 
      h = l1;
      com.alipay.sdk.data.a.j().a(com.alipay.sdk.sys.a.a(), paramContext.getApplicationContext());
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alipay/sdk/app/PayTask}} */
      return true;
    } catch (Exception exception) {
      c.a(exception);
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alipay/sdk/app/PayTask}} */
      return false;
    } finally {}
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alipay/sdk/app/PayTask}} */
    throw paramContext;
  }
  
  public void dismissLoading() {
    com.alipay.sdk.widget.a a1 = this.c;
    if (a1 != null) {
      a1.c();
      this.c = null;
    } 
  }
  
  public String fetchOrderInfoFromH5PayUrl(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: ifne -> 1740
    //   9: aload_1
    //   10: invokevirtual trim : ()Ljava/lang/String;
    //   13: astore_2
    //   14: new java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore_3
    //   22: aload_3
    //   23: ldc_w 'https://'
    //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_3
    //   31: aload_0
    //   32: getfield d : Ljava/lang/String;
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_2
    //   40: aload_3
    //   41: invokevirtual toString : ()Ljava/lang/String;
    //   44: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   47: ifne -> 86
    //   50: new java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial <init> : ()V
    //   57: astore_3
    //   58: aload_3
    //   59: ldc_w 'http://'
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_3
    //   67: aload_0
    //   68: getfield d : Ljava/lang/String;
    //   71: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_2
    //   76: aload_3
    //   77: invokevirtual toString : ()Ljava/lang/String;
    //   80: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   83: ifeq -> 243
    //   86: new java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial <init> : ()V
    //   93: astore_3
    //   94: aload_3
    //   95: ldc_w '(http|https)://'
    //   98: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_3
    //   103: aload_0
    //   104: getfield d : Ljava/lang/String;
    //   107: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_3
    //   112: ldc_w '\?'
    //   115: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_2
    //   120: aload_3
    //   121: invokevirtual toString : ()Ljava/lang/String;
    //   124: ldc ''
    //   126: invokevirtual replaceFirst : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   129: invokevirtual trim : ()Ljava/lang/String;
    //   132: astore_3
    //   133: aload_3
    //   134: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   137: ifne -> 243
    //   140: ldc_w '<request_token>'
    //   143: ldc_w '</request_token>'
    //   146: aload_3
    //   147: invokestatic b : (Ljava/lang/String;)Ljava/util/Map;
    //   150: ldc_w 'req_data'
    //   153: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   158: checkcast java/lang/String
    //   161: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   164: astore_1
    //   165: new com/alipay/sdk/sys/a
    //   168: dup
    //   169: aload_0
    //   170: getfield b : Landroid/app/Activity;
    //   173: ldc ''
    //   175: ldc ''
    //   177: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   180: astore_2
    //   181: new java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial <init> : ()V
    //   188: astore_3
    //   189: aload_3
    //   190: ldc_w '_input_charset="utf-8"&ordertoken="'
    //   193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_3
    //   198: aload_1
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_3
    //   204: ldc_w '"&pay_channel_id="alipay_sdk"&bizcontext="'
    //   207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_3
    //   212: aload_2
    //   213: ldc_w 'sc'
    //   216: ldc_w 'h5tonative'
    //   219: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   222: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_3
    //   227: ldc_w '"'
    //   230: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_3
    //   235: invokevirtual toString : ()Ljava/lang/String;
    //   238: astore_1
    //   239: aload_0
    //   240: monitorexit
    //   241: aload_1
    //   242: areturn
    //   243: new java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial <init> : ()V
    //   250: astore_3
    //   251: aload_3
    //   252: ldc_w 'https://'
    //   255: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload_3
    //   260: aload_0
    //   261: getfield e : Ljava/lang/String;
    //   264: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload_2
    //   269: aload_3
    //   270: invokevirtual toString : ()Ljava/lang/String;
    //   273: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   276: ifne -> 315
    //   279: new java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial <init> : ()V
    //   286: astore_3
    //   287: aload_3
    //   288: ldc_w 'http://'
    //   291: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload_3
    //   296: aload_0
    //   297: getfield e : Ljava/lang/String;
    //   300: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_2
    //   305: aload_3
    //   306: invokevirtual toString : ()Ljava/lang/String;
    //   309: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   312: ifeq -> 472
    //   315: new java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial <init> : ()V
    //   322: astore_3
    //   323: aload_3
    //   324: ldc_w '(http|https)://'
    //   327: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_3
    //   332: aload_0
    //   333: getfield e : Ljava/lang/String;
    //   336: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload_3
    //   341: ldc_w '\?'
    //   344: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload_2
    //   349: aload_3
    //   350: invokevirtual toString : ()Ljava/lang/String;
    //   353: ldc ''
    //   355: invokevirtual replaceFirst : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   358: invokevirtual trim : ()Ljava/lang/String;
    //   361: astore_3
    //   362: aload_3
    //   363: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   366: ifne -> 472
    //   369: ldc_w '<request_token>'
    //   372: ldc_w '</request_token>'
    //   375: aload_3
    //   376: invokestatic b : (Ljava/lang/String;)Ljava/util/Map;
    //   379: ldc_w 'req_data'
    //   382: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   387: checkcast java/lang/String
    //   390: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   393: astore_1
    //   394: new com/alipay/sdk/sys/a
    //   397: dup
    //   398: aload_0
    //   399: getfield b : Landroid/app/Activity;
    //   402: ldc ''
    //   404: ldc ''
    //   406: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   409: astore_2
    //   410: new java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial <init> : ()V
    //   417: astore_3
    //   418: aload_3
    //   419: ldc_w '_input_charset="utf-8"&ordertoken="'
    //   422: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload_3
    //   427: aload_1
    //   428: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload_3
    //   433: ldc_w '"&pay_channel_id="alipay_sdk"&bizcontext="'
    //   436: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload_3
    //   441: aload_2
    //   442: ldc_w 'sc'
    //   445: ldc_w 'h5tonative'
    //   448: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   451: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload_3
    //   456: ldc_w '"'
    //   459: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload_3
    //   464: invokevirtual toString : ()Ljava/lang/String;
    //   467: astore_1
    //   468: aload_0
    //   469: monitorexit
    //   470: aload_1
    //   471: areturn
    //   472: new java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial <init> : ()V
    //   479: astore_3
    //   480: aload_3
    //   481: ldc_w 'https://'
    //   484: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload_3
    //   489: aload_0
    //   490: getfield f : Ljava/lang/String;
    //   493: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload_2
    //   498: aload_3
    //   499: invokevirtual toString : ()Ljava/lang/String;
    //   502: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   505: ifne -> 544
    //   508: new java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial <init> : ()V
    //   515: astore_3
    //   516: aload_3
    //   517: ldc_w 'http://'
    //   520: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload_3
    //   525: aload_0
    //   526: getfield f : Ljava/lang/String;
    //   529: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload_2
    //   534: aload_3
    //   535: invokevirtual toString : ()Ljava/lang/String;
    //   538: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   541: ifeq -> 700
    //   544: aload_2
    //   545: ldc_w 'alipay.wap.create.direct.pay.by.user'
    //   548: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   551: ifne -> 564
    //   554: aload_2
    //   555: ldc_w 'create_forex_trade_wap'
    //   558: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   561: ifeq -> 700
    //   564: new java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial <init> : ()V
    //   571: astore_3
    //   572: aload_3
    //   573: ldc_w '(http|https)://'
    //   576: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload_3
    //   581: aload_0
    //   582: getfield f : Ljava/lang/String;
    //   585: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload_3
    //   590: ldc_w '\?'
    //   593: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload_2
    //   598: aload_3
    //   599: invokevirtual toString : ()Ljava/lang/String;
    //   602: ldc ''
    //   604: invokevirtual replaceFirst : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   607: invokevirtual trim : ()Ljava/lang/String;
    //   610: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   613: ifne -> 700
    //   616: new com/alipay/sdk/sys/a
    //   619: dup
    //   620: aload_0
    //   621: getfield b : Landroid/app/Activity;
    //   624: ldc ''
    //   626: ldc ''
    //   628: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   631: astore_3
    //   632: new org/json/JSONObject
    //   635: dup
    //   636: invokespecial <init> : ()V
    //   639: astore_2
    //   640: aload_2
    //   641: ldc 'url'
    //   643: aload_1
    //   644: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   647: pop
    //   648: aload_2
    //   649: ldc_w 'bizcontext'
    //   652: aload_3
    //   653: ldc_w 'sc'
    //   656: ldc_w 'h5tonative'
    //   659: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   662: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   665: pop
    //   666: new java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial <init> : ()V
    //   673: astore_1
    //   674: aload_1
    //   675: ldc_w 'new_external_info=='
    //   678: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: aload_1
    //   683: aload_2
    //   684: invokevirtual toString : ()Ljava/lang/String;
    //   687: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: aload_1
    //   692: invokevirtual toString : ()Ljava/lang/String;
    //   695: astore_1
    //   696: aload_0
    //   697: monitorexit
    //   698: aload_1
    //   699: areturn
    //   700: ldc_w '^(http|https)://(maliprod\.alipay\.com/w/trade_pay\.do.?|mali\.alipay\.com/w/trade_pay\.do.?|mclient\.alipay\.com/w/trade_pay\.do.?)'
    //   703: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   706: aload_1
    //   707: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   710: invokevirtual find : ()Z
    //   713: ifeq -> 1198
    //   716: ldc_w '?'
    //   719: ldc ''
    //   721: aload_1
    //   722: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   725: astore_1
    //   726: aload_1
    //   727: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   730: ifne -> 1198
    //   733: aload_1
    //   734: invokestatic b : (Ljava/lang/String;)Ljava/util/Map;
    //   737: astore #4
    //   739: new java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial <init> : ()V
    //   746: astore_3
    //   747: aload_0
    //   748: iconst_0
    //   749: iconst_1
    //   750: ldc_w 'trade_no'
    //   753: aload_3
    //   754: aload #4
    //   756: iconst_2
    //   757: anewarray java/lang/String
    //   760: dup
    //   761: iconst_0
    //   762: ldc_w 'trade_no'
    //   765: aastore
    //   766: dup
    //   767: iconst_1
    //   768: ldc_w 'alipay_trade_no'
    //   771: aastore
    //   772: invokespecial a : (ZZLjava/lang/String;Ljava/lang/StringBuilder;Ljava/util/Map;[Ljava/lang/String;)Z
    //   775: ifeq -> 1198
    //   778: aload_0
    //   779: iconst_1
    //   780: iconst_0
    //   781: ldc_w 'pay_phase_id'
    //   784: aload_3
    //   785: aload #4
    //   787: iconst_3
    //   788: anewarray java/lang/String
    //   791: dup
    //   792: iconst_0
    //   793: ldc_w 'payPhaseId'
    //   796: aastore
    //   797: dup
    //   798: iconst_1
    //   799: ldc_w 'pay_phase_id'
    //   802: aastore
    //   803: dup
    //   804: iconst_2
    //   805: ldc_w 'out_relation_id'
    //   808: aastore
    //   809: invokespecial a : (ZZLjava/lang/String;Ljava/lang/StringBuilder;Ljava/util/Map;[Ljava/lang/String;)Z
    //   812: pop
    //   813: aload_3
    //   814: ldc_w '&biz_sub_type="TRADE"'
    //   817: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: pop
    //   821: aload_3
    //   822: ldc_w '&biz_type="trade"'
    //   825: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: pop
    //   829: aload #4
    //   831: ldc_w 'app_name'
    //   834: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   839: checkcast java/lang/String
    //   842: astore_2
    //   843: aload_2
    //   844: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   847: ifeq -> 876
    //   850: aload #4
    //   852: ldc_w 'cid'
    //   855: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   860: checkcast java/lang/CharSequence
    //   863: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   866: ifne -> 876
    //   869: ldc_w 'ali1688'
    //   872: astore_1
    //   873: goto -> 928
    //   876: aload_2
    //   877: astore_1
    //   878: aload_2
    //   879: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   882: ifeq -> 928
    //   885: aload #4
    //   887: ldc_w 'sid'
    //   890: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   895: checkcast java/lang/CharSequence
    //   898: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   901: ifeq -> 1750
    //   904: aload_2
    //   905: astore_1
    //   906: aload #4
    //   908: ldc_w 's_id'
    //   911: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   916: checkcast java/lang/CharSequence
    //   919: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   922: ifne -> 928
    //   925: goto -> 1750
    //   928: new java/lang/StringBuilder
    //   931: dup
    //   932: invokespecial <init> : ()V
    //   935: astore_2
    //   936: aload_2
    //   937: ldc_w '&app_name="'
    //   940: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: pop
    //   944: aload_2
    //   945: aload_1
    //   946: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: aload_2
    //   951: ldc_w '"'
    //   954: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: pop
    //   958: aload_3
    //   959: aload_2
    //   960: invokevirtual toString : ()Ljava/lang/String;
    //   963: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: aload_0
    //   968: iconst_1
    //   969: iconst_1
    //   970: ldc_w 'extern_token'
    //   973: aload_3
    //   974: aload #4
    //   976: iconst_4
    //   977: anewarray java/lang/String
    //   980: dup
    //   981: iconst_0
    //   982: ldc_w 'extern_token'
    //   985: aastore
    //   986: dup
    //   987: iconst_1
    //   988: ldc_w 'cid'
    //   991: aastore
    //   992: dup
    //   993: iconst_2
    //   994: ldc_w 'sid'
    //   997: aastore
    //   998: dup
    //   999: iconst_3
    //   1000: ldc_w 's_id'
    //   1003: aastore
    //   1004: invokespecial a : (ZZLjava/lang/String;Ljava/lang/StringBuilder;Ljava/util/Map;[Ljava/lang/String;)Z
    //   1007: ifne -> 1015
    //   1010: aload_0
    //   1011: monitorexit
    //   1012: ldc ''
    //   1014: areturn
    //   1015: aload_0
    //   1016: iconst_1
    //   1017: iconst_0
    //   1018: ldc_w 'appenv'
    //   1021: aload_3
    //   1022: aload #4
    //   1024: iconst_1
    //   1025: anewarray java/lang/String
    //   1028: dup
    //   1029: iconst_0
    //   1030: ldc_w 'appenv'
    //   1033: aastore
    //   1034: invokespecial a : (ZZLjava/lang/String;Ljava/lang/StringBuilder;Ljava/util/Map;[Ljava/lang/String;)Z
    //   1037: pop
    //   1038: aload_3
    //   1039: ldc_w '&pay_channel_id="alipay_sdk"'
    //   1042: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: pop
    //   1046: new com/alipay/sdk/app/PayTask$a
    //   1049: dup
    //   1050: aload_0
    //   1051: aconst_null
    //   1052: invokespecial <init> : (Lcom/alipay/sdk/app/PayTask;Lcom/alipay/sdk/app/g;)V
    //   1055: astore_1
    //   1056: aload_1
    //   1057: aload #4
    //   1059: ldc_w 'return_url'
    //   1062: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1067: checkcast java/lang/String
    //   1070: invokevirtual a : (Ljava/lang/String;)V
    //   1073: aload_1
    //   1074: aload #4
    //   1076: ldc_w 'show_url'
    //   1079: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1084: checkcast java/lang/String
    //   1087: invokevirtual c : (Ljava/lang/String;)V
    //   1090: aload_1
    //   1091: aload #4
    //   1093: ldc_w 'pay_order_id'
    //   1096: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1101: checkcast java/lang/String
    //   1104: invokevirtual b : (Ljava/lang/String;)V
    //   1107: new com/alipay/sdk/sys/a
    //   1110: dup
    //   1111: aload_0
    //   1112: getfield b : Landroid/app/Activity;
    //   1115: ldc ''
    //   1117: ldc ''
    //   1119: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1122: astore_2
    //   1123: new java/lang/StringBuilder
    //   1126: dup
    //   1127: invokespecial <init> : ()V
    //   1130: astore #4
    //   1132: aload #4
    //   1134: aload_3
    //   1135: invokevirtual toString : ()Ljava/lang/String;
    //   1138: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: pop
    //   1142: aload #4
    //   1144: ldc_w '&bizcontext="'
    //   1147: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: pop
    //   1151: aload #4
    //   1153: aload_2
    //   1154: ldc_w 'sc'
    //   1157: ldc_w 'h5tonative'
    //   1160: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1163: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: pop
    //   1167: aload #4
    //   1169: ldc_w '"'
    //   1172: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: pop
    //   1176: aload #4
    //   1178: invokevirtual toString : ()Ljava/lang/String;
    //   1181: astore_2
    //   1182: aload_0
    //   1183: getfield g : Ljava/util/Map;
    //   1186: aload_2
    //   1187: aload_1
    //   1188: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1193: pop
    //   1194: aload_0
    //   1195: monitorexit
    //   1196: aload_2
    //   1197: areturn
    //   1198: aload_2
    //   1199: ldc_w 'mclient.alipay.com/cashier/mobilepay.htm'
    //   1202: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1205: ifne -> 1663
    //   1208: invokestatic isSandBox : ()Z
    //   1211: ifeq -> 1227
    //   1214: aload_2
    //   1215: ldc_w 'mobileclientgw.alipaydev.com/cashier/mobilepay.htm'
    //   1218: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1221: ifeq -> 1227
    //   1224: goto -> 1663
    //   1227: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   1230: invokevirtual d : ()Z
    //   1233: ifeq -> 1740
    //   1236: ldc_w '^https?://(maliprod\.alipay\.com|mali\.alipay\.com)/batch_payment\.do\?'
    //   1239: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   1242: aload_2
    //   1243: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   1246: invokevirtual find : ()Z
    //   1249: ifeq -> 1740
    //   1252: aload_2
    //   1253: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   1256: astore #9
    //   1258: aload #9
    //   1260: ldc_w 'return_url'
    //   1263: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1266: astore #4
    //   1268: aload #9
    //   1270: ldc_w 'show_url'
    //   1273: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1276: astore #5
    //   1278: aload #9
    //   1280: ldc_w 'pay_order_id'
    //   1283: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1286: astore #6
    //   1288: iconst_2
    //   1289: anewarray java/lang/String
    //   1292: dup
    //   1293: iconst_0
    //   1294: aload #9
    //   1296: ldc_w 'trade_nos'
    //   1299: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1302: aastore
    //   1303: dup
    //   1304: iconst_1
    //   1305: aload #9
    //   1307: ldc_w 'alipay_trade_no'
    //   1310: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1313: aastore
    //   1314: invokestatic a : ([Ljava/lang/String;)Ljava/lang/String;
    //   1317: astore #7
    //   1319: iconst_3
    //   1320: anewarray java/lang/String
    //   1323: dup
    //   1324: iconst_0
    //   1325: aload #9
    //   1327: ldc_w 'payPhaseId'
    //   1330: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1333: aastore
    //   1334: dup
    //   1335: iconst_1
    //   1336: aload #9
    //   1338: ldc_w 'pay_phase_id'
    //   1341: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1344: aastore
    //   1345: dup
    //   1346: iconst_2
    //   1347: aload #9
    //   1349: ldc_w 'out_relation_id'
    //   1352: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1355: aastore
    //   1356: invokestatic a : ([Ljava/lang/String;)Ljava/lang/String;
    //   1359: astore #8
    //   1361: aload #9
    //   1363: ldc_w 'app_name'
    //   1366: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1369: astore #10
    //   1371: aload #9
    //   1373: ldc_w 'cid'
    //   1376: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1379: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1382: ifne -> 1757
    //   1385: ldc_w 'ali1688'
    //   1388: astore_1
    //   1389: goto -> 1392
    //   1392: aload #9
    //   1394: ldc_w 'sid'
    //   1397: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1400: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1403: ifne -> 1763
    //   1406: ldc_w 'tb'
    //   1409: astore_2
    //   1410: goto -> 1413
    //   1413: aload #9
    //   1415: ldc_w 's_id'
    //   1418: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1421: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1424: ifne -> 1769
    //   1427: ldc_w 'tb'
    //   1430: astore_3
    //   1431: goto -> 1434
    //   1434: iconst_4
    //   1435: anewarray java/lang/String
    //   1438: dup
    //   1439: iconst_0
    //   1440: aload #10
    //   1442: aastore
    //   1443: dup
    //   1444: iconst_1
    //   1445: aload_1
    //   1446: aastore
    //   1447: dup
    //   1448: iconst_2
    //   1449: aload_2
    //   1450: aastore
    //   1451: dup
    //   1452: iconst_3
    //   1453: aload_3
    //   1454: aastore
    //   1455: invokestatic a : ([Ljava/lang/String;)Ljava/lang/String;
    //   1458: astore_1
    //   1459: iconst_4
    //   1460: anewarray java/lang/String
    //   1463: dup
    //   1464: iconst_0
    //   1465: aload #9
    //   1467: ldc_w 'extern_token'
    //   1470: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1473: aastore
    //   1474: dup
    //   1475: iconst_1
    //   1476: aload #9
    //   1478: ldc_w 'cid'
    //   1481: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1484: aastore
    //   1485: dup
    //   1486: iconst_2
    //   1487: aload #9
    //   1489: ldc_w 'sid'
    //   1492: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1495: aastore
    //   1496: dup
    //   1497: iconst_3
    //   1498: aload #9
    //   1500: ldc_w 's_id'
    //   1503: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1506: aastore
    //   1507: invokestatic a : ([Ljava/lang/String;)Ljava/lang/String;
    //   1510: astore_2
    //   1511: iconst_1
    //   1512: anewarray java/lang/String
    //   1515: dup
    //   1516: iconst_0
    //   1517: aload #9
    //   1519: ldc_w 'appenv'
    //   1522: invokevirtual getQueryParameter : (Ljava/lang/String;)Ljava/lang/String;
    //   1525: aastore
    //   1526: invokestatic a : ([Ljava/lang/String;)Ljava/lang/String;
    //   1529: astore_3
    //   1530: aload #7
    //   1532: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1535: ifne -> 1740
    //   1538: aload_1
    //   1539: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1542: ifne -> 1740
    //   1545: aload_2
    //   1546: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1549: ifne -> 1740
    //   1552: ldc_w 'trade_no="%s"&pay_phase_id="%s"&biz_type="trade"&biz_sub_type="TRADE"&app_name="%s"&extern_token="%s"&appenv="%s"&pay_channel_id="alipay_sdk"&bizcontext="%s"'
    //   1555: bipush #6
    //   1557: anewarray java/lang/Object
    //   1560: dup
    //   1561: iconst_0
    //   1562: aload #7
    //   1564: aastore
    //   1565: dup
    //   1566: iconst_1
    //   1567: aload #8
    //   1569: aastore
    //   1570: dup
    //   1571: iconst_2
    //   1572: aload_1
    //   1573: aastore
    //   1574: dup
    //   1575: iconst_3
    //   1576: aload_2
    //   1577: aastore
    //   1578: dup
    //   1579: iconst_4
    //   1580: aload_3
    //   1581: aastore
    //   1582: dup
    //   1583: iconst_5
    //   1584: new com/alipay/sdk/sys/a
    //   1587: dup
    //   1588: aload_0
    //   1589: getfield b : Landroid/app/Activity;
    //   1592: ldc ''
    //   1594: ldc ''
    //   1596: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1599: ldc_w 'sc'
    //   1602: ldc_w 'h5tonative'
    //   1605: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1608: aastore
    //   1609: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1612: astore_1
    //   1613: new com/alipay/sdk/app/PayTask$a
    //   1616: dup
    //   1617: aload_0
    //   1618: aconst_null
    //   1619: invokespecial <init> : (Lcom/alipay/sdk/app/PayTask;Lcom/alipay/sdk/app/g;)V
    //   1622: astore_2
    //   1623: aload_2
    //   1624: aload #4
    //   1626: invokevirtual a : (Ljava/lang/String;)V
    //   1629: aload_2
    //   1630: aload #5
    //   1632: invokevirtual c : (Ljava/lang/String;)V
    //   1635: aload_2
    //   1636: aload #6
    //   1638: invokevirtual b : (Ljava/lang/String;)V
    //   1641: aload_2
    //   1642: aload #7
    //   1644: invokevirtual d : (Ljava/lang/String;)V
    //   1647: aload_0
    //   1648: getfield g : Ljava/util/Map;
    //   1651: aload_1
    //   1652: aload_2
    //   1653: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1658: pop
    //   1659: aload_0
    //   1660: monitorexit
    //   1661: aload_1
    //   1662: areturn
    //   1663: new com/alipay/sdk/sys/a
    //   1666: dup
    //   1667: aload_0
    //   1668: getfield b : Landroid/app/Activity;
    //   1671: ldc ''
    //   1673: ldc ''
    //   1675: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1678: ldc_w 'sc'
    //   1681: ldc_w 'h5tonative'
    //   1684: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1687: astore_1
    //   1688: new org/json/JSONObject
    //   1691: dup
    //   1692: invokespecial <init> : ()V
    //   1695: astore_3
    //   1696: aload_3
    //   1697: ldc 'url'
    //   1699: aload_2
    //   1700: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1703: pop
    //   1704: aload_3
    //   1705: ldc_w 'bizcontext'
    //   1708: aload_1
    //   1709: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1712: pop
    //   1713: ldc_w 'new_external_info==%s'
    //   1716: iconst_1
    //   1717: anewarray java/lang/Object
    //   1720: dup
    //   1721: iconst_0
    //   1722: aload_3
    //   1723: invokevirtual toString : ()Ljava/lang/String;
    //   1726: aastore
    //   1727: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1730: astore_1
    //   1731: aload_0
    //   1732: monitorexit
    //   1733: aload_1
    //   1734: areturn
    //   1735: astore_1
    //   1736: aload_1
    //   1737: invokestatic a : (Ljava/lang/Throwable;)V
    //   1740: aload_0
    //   1741: monitorexit
    //   1742: ldc ''
    //   1744: areturn
    //   1745: astore_1
    //   1746: aload_0
    //   1747: monitorexit
    //   1748: aload_1
    //   1749: athrow
    //   1750: ldc_w 'tb'
    //   1753: astore_1
    //   1754: goto -> 928
    //   1757: ldc ''
    //   1759: astore_1
    //   1760: goto -> 1392
    //   1763: ldc ''
    //   1765: astore_2
    //   1766: goto -> 1413
    //   1769: ldc ''
    //   1771: astore_3
    //   1772: goto -> 1434
    // Exception table:
    //   from	to	target	type
    //   2	86	1735	finally
    //   86	239	1735	finally
    //   243	315	1735	finally
    //   315	468	1735	finally
    //   472	544	1735	finally
    //   544	564	1735	finally
    //   564	696	1735	finally
    //   700	869	1735	finally
    //   878	904	1735	finally
    //   906	925	1735	finally
    //   928	1010	1735	finally
    //   1015	1194	1735	finally
    //   1198	1224	1735	finally
    //   1227	1385	1735	finally
    //   1392	1406	1735	finally
    //   1413	1427	1735	finally
    //   1434	1659	1735	finally
    //   1663	1731	1735	finally
    //   1736	1740	1745	finally
  }
  
  public String fetchTradeToken() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new com/alipay/sdk/sys/a
    //   5: dup
    //   6: aload_0
    //   7: getfield b : Landroid/app/Activity;
    //   10: ldc ''
    //   12: ldc_w 'fetchTradeToken'
    //   15: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield b : Landroid/app/Activity;
    //   22: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   25: invokestatic a : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;)Ljava/lang/String;
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
  
  public String getVersion() {
    return "15.7.4";
  }
  
  public H5PayResultModel h5Pay(com.alipay.sdk.sys.a parama, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new com/alipay/sdk/util/H5PayResultModel
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore #7
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: iload_3
    //   15: invokespecial a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Z)Ljava/lang/String;
    //   18: ldc_w ';'
    //   21: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   24: astore #8
    //   26: new java/util/HashMap
    //   29: dup
    //   30: invokespecial <init> : ()V
    //   33: astore #9
    //   35: aload #8
    //   37: arraylength
    //   38: istore #5
    //   40: iconst_0
    //   41: istore #4
    //   43: iload #4
    //   45: iload #5
    //   47: if_icmpge -> 103
    //   50: aload #8
    //   52: iload #4
    //   54: aaload
    //   55: astore #10
    //   57: aload #10
    //   59: ldc_w '={'
    //   62: invokevirtual indexOf : (Ljava/lang/String;)I
    //   65: istore #6
    //   67: iload #6
    //   69: iflt -> 196
    //   72: aload #10
    //   74: iconst_0
    //   75: iload #6
    //   77: invokevirtual substring : (II)Ljava/lang/String;
    //   80: astore #11
    //   82: aload #9
    //   84: aload #11
    //   86: aload_0
    //   87: aload #10
    //   89: aload #11
    //   91: invokespecial a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   94: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   99: pop
    //   100: goto -> 196
    //   103: aload #9
    //   105: ldc_w 'resultStatus'
    //   108: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   113: ifeq -> 134
    //   116: aload #7
    //   118: aload #9
    //   120: ldc_w 'resultStatus'
    //   123: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   128: checkcast java/lang/String
    //   131: invokevirtual setResultCode : (Ljava/lang/String;)V
    //   134: aload #7
    //   136: aload_0
    //   137: aload_2
    //   138: aload #9
    //   140: invokespecial a : (Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   143: invokevirtual setReturnUrl : (Ljava/lang/String;)V
    //   146: aload #7
    //   148: invokevirtual getReturnUrl : ()Ljava/lang/String;
    //   151: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   154: ifeq -> 186
    //   157: aload_1
    //   158: ldc 'biz'
    //   160: ldc_w 'H5CbUrlEmpty'
    //   163: ldc ''
    //   165: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   168: goto -> 186
    //   171: astore_2
    //   172: aload_1
    //   173: ldc 'biz'
    //   175: ldc_w 'H5CbEx'
    //   178: aload_2
    //   179: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   182: aload_2
    //   183: invokestatic a : (Ljava/lang/Throwable;)V
    //   186: aload_0
    //   187: monitorexit
    //   188: aload #7
    //   190: areturn
    //   191: astore_1
    //   192: aload_0
    //   193: monitorexit
    //   194: aload_1
    //   195: athrow
    //   196: iload #4
    //   198: iconst_1
    //   199: iadd
    //   200: istore #4
    //   202: goto -> 43
    // Exception table:
    //   from	to	target	type
    //   2	11	191	finally
    //   11	40	171	finally
    //   57	67	171	finally
    //   72	100	171	finally
    //   103	134	171	finally
    //   134	168	171	finally
    //   172	186	191	finally
  }
  
  public String pay(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: new com/alipay/sdk/sys/a
    //   6: dup
    //   7: aload_0
    //   8: getfield b : Landroid/app/Activity;
    //   11: aload_1
    //   12: ldc_w 'pay'
    //   15: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   18: aload_1
    //   19: iload_2
    //   20: invokespecial a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Z)Ljava/lang/String;
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	28	finally
  }
  
  public boolean payInterceptorWithUrl(String paramString, boolean paramBoolean, H5PayCallback paramH5PayCallback) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual fetchOrderInfoFromH5PayUrl : (Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   12: ifne -> 72
    //   15: new java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: astore #4
    //   24: aload #4
    //   26: ldc_w 'intercepted: '
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload #4
    //   35: aload_1
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: ldc_w 'mspl'
    //   43: aload #4
    //   45: invokevirtual toString : ()Ljava/lang/String;
    //   48: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   51: new java/lang/Thread
    //   54: dup
    //   55: new com/alipay/sdk/app/g
    //   58: dup
    //   59: aload_0
    //   60: aload_1
    //   61: iload_2
    //   62: aload_3
    //   63: invokespecial <init> : (Lcom/alipay/sdk/app/PayTask;Ljava/lang/String;ZLcom/alipay/sdk/app/H5PayCallback;)V
    //   66: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   69: invokevirtual start : ()V
    //   72: aload_1
    //   73: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   76: istore_2
    //   77: aload_0
    //   78: monitorexit
    //   79: iload_2
    //   80: iconst_1
    //   81: ixor
    //   82: ireturn
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Exception table:
    //   from	to	target	type
    //   2	72	83	finally
    //   72	77	83	finally
  }
  
  public Map<String, String> payV2(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new com/alipay/sdk/sys/a
    //   5: dup
    //   6: aload_0
    //   7: getfield b : Landroid/app/Activity;
    //   10: aload_1
    //   11: ldc_w 'payV2'
    //   14: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: aload_3
    //   21: aload_1
    //   22: iload_2
    //   23: invokespecial a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Z)Ljava/lang/String;
    //   26: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;)Ljava/util/Map;
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: areturn
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	34	finally
  }
  
  public void showLoading() {
    com.alipay.sdk.widget.a a1 = this.c;
    if (a1 != null)
      a1.b(); 
  }
  
  class a {
    private String b = "";
    
    private String c = "";
    
    private String d = "";
    
    private String e = "";
    
    private a(PayTask this$0) {}
    
    public String a() {
      return this.b;
    }
    
    public void a(String param1String) {
      this.b = param1String;
    }
    
    public String b() {
      return this.d;
    }
    
    public void b(String param1String) {
      this.d = param1String;
    }
    
    public String c() {
      return this.c;
    }
    
    public void c(String param1String) {
      this.c = param1String;
    }
    
    public String d() {
      return this.e;
    }
    
    public void d(String param1String) {
      this.e = param1String;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\PayTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */