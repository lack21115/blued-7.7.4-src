package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.sys.b;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class OpenAuthTask {
  public static final int Duplex = 5000;
  
  public static final int NOT_INSTALLED = 4001;
  
  public static final int OK = 9000;
  
  public static final int SYS_ERR = 4000;
  
  private static final Map<String, Callback> a = new ConcurrentHashMap<String, Callback>();
  
  private static long b = -1L;
  
  private static final int c = 122;
  
  private volatile boolean d = false;
  
  private final Activity e;
  
  private Callback f;
  
  private final Handler g = new Handler(Looper.getMainLooper());
  
  public OpenAuthTask(Activity paramActivity) {
    this.e = paramActivity;
    b.a().a((Context)paramActivity);
  }
  
  private String a(long paramLong, String paramString1, BizType paramBizType, String paramString2) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("startTime", String.valueOf(paramLong));
    jSONObject.put("session", paramString1);
    jSONObject.put("package", this.e.getPackageName());
    if (paramBizType != null)
      jSONObject.put("appId", paramBizType.appId); 
    jSONObject.put("sdkVersion", "h.a.3.7.4");
    jSONObject.put("mqpURL", paramString2);
    return Base64.encodeToString(jSONObject.toString().getBytes(Charset.forName("UTF-8")), 2);
  }
  
  private String a(BizType paramBizType, Map<String, String> paramMap) {
    if (paramBizType != null) {
      Uri.Builder builder = (new Uri.Builder()).scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", paramBizType.appId);
      if (e.a[paramBizType.ordinal()] == 1)
        builder.appendQueryParameter("appClearTop", "false").appendQueryParameter("startMultApp", "YES"); 
      for (Map.Entry<String, String> entry : paramMap.entrySet())
        builder.appendQueryParameter((String)entry.getKey(), (String)entry.getValue()); 
      return builder.build().toString();
    } 
    throw new RuntimeException("missing bizType");
  }
  
  static void a(String paramString1, int paramInt, String paramString2, Bundle paramBundle) {
    Callback callback = a.remove(paramString1);
    if (callback != null)
      try {
        return;
      } finally {
        callback = null;
      }  
  }
  
  private boolean a(com.alipay.sdk.sys.a parama, String paramString, BizType paramBizType, Map<String, String> paramMap, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield d : Z
    //   4: ifeq -> 32
    //   7: aload_0
    //   8: getfield g : Landroid/os/Handler;
    //   11: new com/alipay/sdk/app/OpenAuthTask$a
    //   14: dup
    //   15: aload_0
    //   16: sipush #4000
    //   19: ldc '该 OpenAuthTask 已在执行'
    //   21: aconst_null
    //   22: aconst_null
    //   23: invokespecial <init> : (Lcom/alipay/sdk/app/OpenAuthTask;ILjava/lang/String;Landroid/os/Bundle;Lcom/alipay/sdk/app/e;)V
    //   26: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   29: pop
    //   30: iconst_1
    //   31: ireturn
    //   32: aload_0
    //   33: iconst_1
    //   34: putfield d : Z
    //   37: invokestatic elapsedRealtime : ()J
    //   40: lstore #6
    //   42: lload #6
    //   44: getstatic com/alipay/sdk/app/OpenAuthTask.b : J
    //   47: lsub
    //   48: ldc2_w 3000
    //   51: lcmp
    //   52: ifgt -> 81
    //   55: aload_0
    //   56: getfield g : Landroid/os/Handler;
    //   59: new com/alipay/sdk/app/OpenAuthTask$a
    //   62: dup
    //   63: aload_0
    //   64: sipush #5000
    //   67: ldc_w '3s 内重复支付'
    //   70: aconst_null
    //   71: aconst_null
    //   72: invokespecial <init> : (Lcom/alipay/sdk/app/OpenAuthTask;ILjava/lang/String;Landroid/os/Bundle;Lcom/alipay/sdk/app/e;)V
    //   75: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   78: pop
    //   79: iconst_1
    //   80: ireturn
    //   81: lload #6
    //   83: putstatic com/alipay/sdk/app/OpenAuthTask.b : J
    //   86: bipush #32
    //   88: invokestatic a : (I)Ljava/lang/String;
    //   91: astore #9
    //   93: new java/util/HashMap
    //   96: dup
    //   97: aload #4
    //   99: invokespecial <init> : (Ljava/util/Map;)V
    //   102: astore #10
    //   104: aload #10
    //   106: ldc_w 'mqpPkgName'
    //   109: aload_0
    //   110: getfield e : Landroid/app/Activity;
    //   113: invokevirtual getPackageName : ()Ljava/lang/String;
    //   116: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: aload #10
    //   124: ldc_w 'mqpScene'
    //   127: ldc_w 'sdk'
    //   130: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: pop
    //   136: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   139: invokevirtual i : ()Ljava/util/List;
    //   142: astore #8
    //   144: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   147: getfield a : Z
    //   150: ifeq -> 162
    //   153: aload #8
    //   155: astore #4
    //   157: aload #8
    //   159: ifnonnull -> 167
    //   162: getstatic com/alipay/sdk/app/i.a : Ljava/util/List;
    //   165: astore #4
    //   167: aload_1
    //   168: aload_0
    //   169: getfield e : Landroid/app/Activity;
    //   172: aload #4
    //   174: invokestatic a : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;Ljava/util/List;)Lcom/alipay/sdk/util/n$a;
    //   177: astore #4
    //   179: aload #4
    //   181: ifnull -> 539
    //   184: aload #4
    //   186: aload_1
    //   187: invokevirtual a : (Lcom/alipay/sdk/sys/a;)Z
    //   190: ifne -> 539
    //   193: aload #4
    //   195: invokevirtual a : ()Z
    //   198: ifne -> 539
    //   201: aload #4
    //   203: getfield a : Landroid/content/pm/PackageInfo;
    //   206: ifnull -> 539
    //   209: aload #4
    //   211: getfield a : Landroid/content/pm/PackageInfo;
    //   214: getfield versionCode : I
    //   217: bipush #122
    //   219: if_icmpge -> 225
    //   222: goto -> 539
    //   225: aload_1
    //   226: invokestatic a : (Lcom/alipay/sdk/sys/a;)Ljava/util/HashMap;
    //   229: astore_2
    //   230: aload_2
    //   231: ldc_w 'ts_scheme'
    //   234: invokestatic elapsedRealtime : ()J
    //   237: invokestatic valueOf : (J)Ljava/lang/String;
    //   240: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   245: pop
    //   246: aload #10
    //   248: ldc_w 'mqpLoc'
    //   251: new org/json/JSONObject
    //   254: dup
    //   255: aload_2
    //   256: invokespecial <init> : (Ljava/util/Map;)V
    //   259: invokevirtual toString : ()Ljava/lang/String;
    //   262: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   267: pop
    //   268: goto -> 283
    //   271: astore_2
    //   272: aload_1
    //   273: ldc_w 'biz'
    //   276: ldc_w 'OpenAuthLocEx'
    //   279: aload_2
    //   280: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   283: aload_0
    //   284: aload_3
    //   285: aload #10
    //   287: invokespecial a : (Lcom/alipay/sdk/app/OpenAuthTask$BizType;Ljava/util/Map;)Ljava/lang/String;
    //   290: astore #8
    //   292: getstatic com/alipay/sdk/app/OpenAuthTask.a : Ljava/util/Map;
    //   295: aload #9
    //   297: aload_0
    //   298: getfield f : Lcom/alipay/sdk/app/OpenAuthTask$Callback;
    //   301: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   306: pop
    //   307: aconst_null
    //   308: astore_2
    //   309: aload_0
    //   310: lload #6
    //   312: aload #9
    //   314: aload_3
    //   315: aload #8
    //   317: invokespecial a : (JLjava/lang/String;Lcom/alipay/sdk/app/OpenAuthTask$BizType;Ljava/lang/String;)Ljava/lang/String;
    //   320: astore_3
    //   321: aload_3
    //   322: astore_2
    //   323: goto -> 341
    //   326: astore_3
    //   327: aload_1
    //   328: ldc_w 'biz'
    //   331: ldc_w 'JSONEx'
    //   334: aload_3
    //   335: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   338: goto -> 323
    //   341: aload_2
    //   342: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   345: ifeq -> 374
    //   348: aload_0
    //   349: getfield g : Landroid/os/Handler;
    //   352: new com/alipay/sdk/app/OpenAuthTask$a
    //   355: dup
    //   356: aload_0
    //   357: sipush #4000
    //   360: ldc_w '参数错误'
    //   363: aconst_null
    //   364: aconst_null
    //   365: invokespecial <init> : (Lcom/alipay/sdk/app/OpenAuthTask;ILjava/lang/String;Landroid/os/Bundle;Lcom/alipay/sdk/app/e;)V
    //   368: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   371: pop
    //   372: iconst_1
    //   373: ireturn
    //   374: new android/content/Intent
    //   377: dup
    //   378: ldc_w 'android.intent.action.VIEW'
    //   381: new android/net/Uri$Builder
    //   384: dup
    //   385: invokespecial <init> : ()V
    //   388: ldc 'alipays'
    //   390: invokevirtual scheme : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   393: ldc 'platformapi'
    //   395: invokevirtual authority : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   398: ldc 'startapp'
    //   400: invokevirtual path : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   403: ldc 'appId'
    //   405: ldc_w '20001129'
    //   408: invokevirtual appendQueryParameter : (Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   411: ldc_w 'payload'
    //   414: aload_2
    //   415: invokevirtual appendQueryParameter : (Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   418: invokevirtual build : ()Landroid/net/Uri;
    //   421: invokespecial <init> : (Ljava/lang/String;Landroid/net/Uri;)V
    //   424: astore_2
    //   425: aload_2
    //   426: ldc_w 268435456
    //   429: invokevirtual addFlags : (I)Landroid/content/Intent;
    //   432: pop
    //   433: aload_2
    //   434: aload #4
    //   436: getfield a : Landroid/content/pm/PackageInfo;
    //   439: getfield packageName : Ljava/lang/String;
    //   442: invokevirtual setPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   445: pop
    //   446: new java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial <init> : ()V
    //   453: astore_3
    //   454: aload_3
    //   455: ldc_w ''
    //   458: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload_3
    //   463: lload #6
    //   465: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload_1
    //   470: ldc_w 'biz'
    //   473: ldc_w 'PgOpenStarting'
    //   476: aload_3
    //   477: invokevirtual toString : ()Ljava/lang/String;
    //   480: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   483: aload_1
    //   484: aload #9
    //   486: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;)V
    //   489: aload_0
    //   490: getfield e : Landroid/app/Activity;
    //   493: aload_2
    //   494: invokevirtual startActivity : (Landroid/content/Intent;)V
    //   497: iconst_0
    //   498: ireturn
    //   499: astore_2
    //   500: aload_1
    //   501: ldc_w 'biz'
    //   504: ldc_w 'StartWalletEx'
    //   507: aload_2
    //   508: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   511: iconst_0
    //   512: ireturn
    //   513: aload_0
    //   514: getfield g : Landroid/os/Handler;
    //   517: new com/alipay/sdk/app/OpenAuthTask$a
    //   520: dup
    //   521: aload_0
    //   522: sipush #4000
    //   525: ldc_w '业务参数错误'
    //   528: aconst_null
    //   529: aconst_null
    //   530: invokespecial <init> : (Lcom/alipay/sdk/app/OpenAuthTask;ILjava/lang/String;Landroid/os/Bundle;Lcom/alipay/sdk/app/e;)V
    //   533: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   536: pop
    //   537: iconst_1
    //   538: ireturn
    //   539: iload #5
    //   541: ifeq -> 649
    //   544: aload #10
    //   546: ldc_w 'mqpScheme'
    //   549: aload_2
    //   550: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   553: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   558: pop
    //   559: aload #10
    //   561: ldc_w 'mqpNotifyName'
    //   564: aload #9
    //   566: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   571: pop
    //   572: aload #10
    //   574: ldc_w 'mqpScene'
    //   577: ldc_w 'landing'
    //   580: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   585: pop
    //   586: aload_0
    //   587: aload_3
    //   588: aload #10
    //   590: invokespecial a : (Lcom/alipay/sdk/app/OpenAuthTask$BizType;Ljava/util/Map;)Ljava/lang/String;
    //   593: astore_2
    //   594: new android/content/Intent
    //   597: dup
    //   598: aload_0
    //   599: getfield e : Landroid/app/Activity;
    //   602: ldc_w com/alipay/sdk/app/H5OpenAuthActivity
    //   605: invokespecial <init> : (Landroid/content/Context;Ljava/lang/Class;)V
    //   608: astore_3
    //   609: aload_3
    //   610: ldc_w 'url'
    //   613: ldc_w 'https://render.alipay.com/p/s/i?scheme=%s'
    //   616: iconst_1
    //   617: anewarray java/lang/Object
    //   620: dup
    //   621: iconst_0
    //   622: aload_2
    //   623: invokestatic encode : (Ljava/lang/String;)Ljava/lang/String;
    //   626: aastore
    //   627: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   630: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   633: pop
    //   634: aload_1
    //   635: aload_3
    //   636: invokestatic a : (Lcom/alipay/sdk/sys/a;Landroid/content/Intent;)V
    //   639: aload_0
    //   640: getfield e : Landroid/app/Activity;
    //   643: aload_3
    //   644: invokevirtual startActivity : (Landroid/content/Intent;)V
    //   647: iconst_0
    //   648: ireturn
    //   649: aload_0
    //   650: getfield g : Landroid/os/Handler;
    //   653: new com/alipay/sdk/app/OpenAuthTask$a
    //   656: dup
    //   657: aload_0
    //   658: sipush #4001
    //   661: ldc_w '支付宝未安装或签名错误'
    //   664: aconst_null
    //   665: aconst_null
    //   666: invokespecial <init> : (Lcom/alipay/sdk/app/OpenAuthTask;ILjava/lang/String;Landroid/os/Bundle;Lcom/alipay/sdk/app/e;)V
    //   669: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   672: pop
    //   673: iconst_1
    //   674: ireturn
    //   675: astore_1
    //   676: goto -> 513
    // Exception table:
    //   from	to	target	type
    //   225	268	271	finally
    //   272	283	675	finally
    //   283	292	675	finally
    //   309	321	326	org/json/JSONException
    //   446	497	499	finally
  }
  
  public void execute(String paramString, BizType paramBizType, Map<String, String> paramMap, Callback paramCallback, boolean paramBoolean) {
    Activity activity = this.e;
    String str = String.valueOf(paramMap);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("oa-");
    stringBuilder.append(paramBizType);
    com.alipay.sdk.sys.a a = new com.alipay.sdk.sys.a((Context)activity, str, stringBuilder.toString());
    try {
      this.f = paramCallback;
      paramBoolean = a(a, paramString, paramBizType, paramMap, paramBoolean);
      if (paramBoolean)
        a.b((Context)this.e, a, "", a.p); 
      return;
    } finally {}
  }
  
  public enum BizType {
    AccountAuth,
    Deduct,
    Invoice("20000920");
    
    private String appId;
    
    static {
      $VALUES = new BizType[] { Invoice, AccountAuth, Deduct };
    }
    
    BizType(String param1String1) {
      this.appId = param1String1;
    }
  }
  
  public static interface Callback {
    void onResult(int param1Int, String param1String, Bundle param1Bundle);
  }
  
  final class a implements Runnable {
    final int a;
    
    final String b;
    
    final Bundle c;
    
    private a(OpenAuthTask this$0, int param1Int, String param1String, Bundle param1Bundle) {
      this.a = param1Int;
      this.b = param1String;
      this.c = param1Bundle;
    }
    
    public void run() {
      if (OpenAuthTask.a(this.d) != null)
        OpenAuthTask.a(this.d).onResult(this.a, this.b, this.c); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\OpenAuthTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */