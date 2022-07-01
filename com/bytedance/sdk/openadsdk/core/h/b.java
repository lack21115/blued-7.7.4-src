package com.bytedance.sdk.openadsdk.core.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.f;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.ag;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements Runnable {
  private static volatile b a;
  
  private final Context b = o.a();
  
  private final a c = new a(this, this.b);
  
  private AtomicBoolean d = new AtomicBoolean(false);
  
  private boolean e = false;
  
  private Comparator<JSONObject> f = new Comparator<JSONObject>(this) {
      public int a(JSONObject param1JSONObject1, JSONObject param1JSONObject2) {
        return param1JSONObject1.optString("package_name").compareTo(param1JSONObject2.optString("package_name"));
      }
    };
  
  private int a(PackageInfo paramPackageInfo) {
    ApplicationInfo applicationInfo = paramPackageInfo.applicationInfo;
    byte b1 = 1;
    int i = b1;
    if (applicationInfo != null) {
      i = b1;
      if ((paramPackageInfo.applicationInfo.flags & 0x1) != 1) {
        if (String.valueOf(paramPackageInfo.firstInstallTime).endsWith("000"))
          return 2; 
        i = 0x1 & paramPackageInfo.applicationInfo.flags;
      } 
    } 
    return i;
  }
  
  public static b a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/h/b.a : Lcom/bytedance/sdk/openadsdk/core/h/b;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/core/h/b
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/h/b.a : Lcom/bytedance/sdk/openadsdk/core/h/b;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/core/h/b
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/core/h/b.a : Lcom/bytedance/sdk/openadsdk/core/h/b;
    //   25: ldc com/bytedance/sdk/openadsdk/core/h/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/core/h/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/core/h/b.a : Lcom/bytedance/sdk/openadsdk/core/h/b;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private JSONObject a(List<JSONObject> paramList, List<String> paramList1, List<String> paramList2) {
    // Byte code:
    //   0: new org/json/JSONObject
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #9
    //   9: iconst_m1
    //   10: istore #5
    //   12: ldc ''
    //   14: astore #7
    //   16: aload_0
    //   17: getfield b : Landroid/content/Context;
    //   20: invokestatic d : (Landroid/content/Context;)Ljava/lang/String;
    //   23: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   26: ifne -> 41
    //   29: aload_0
    //   30: getfield b : Landroid/content/Context;
    //   33: invokestatic d : (Landroid/content/Context;)Ljava/lang/String;
    //   36: astore #7
    //   38: iconst_1
    //   39: istore #5
    //   41: iload #5
    //   43: istore #4
    //   45: aload #7
    //   47: astore #8
    //   49: iload #5
    //   51: ifge -> 79
    //   54: iload #5
    //   56: istore #4
    //   58: aload #7
    //   60: astore #8
    //   62: invokestatic a : ()Ljava/lang/String;
    //   65: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   68: ifne -> 79
    //   71: iconst_4
    //   72: istore #4
    //   74: invokestatic a : ()Ljava/lang/String;
    //   77: astore #8
    //   79: iload #4
    //   81: istore #5
    //   83: iload #4
    //   85: ifge -> 100
    //   88: iconst_3
    //   89: istore #5
    //   91: aload_0
    //   92: getfield b : Landroid/content/Context;
    //   95: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   98: astore #8
    //   100: new org/json/JSONArray
    //   103: dup
    //   104: invokespecial <init> : ()V
    //   107: astore #7
    //   109: aload_1
    //   110: invokeinterface iterator : ()Ljava/util/Iterator;
    //   115: astore #10
    //   117: aload #10
    //   119: invokeinterface hasNext : ()Z
    //   124: ifeq -> 151
    //   127: aload #7
    //   129: aload #10
    //   131: invokeinterface next : ()Ljava/lang/Object;
    //   136: checkcast org/json/JSONObject
    //   139: ldc 'package_name'
    //   141: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   144: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   147: pop
    //   148: goto -> 117
    //   151: aload #9
    //   153: ldc 'app_list'
    //   155: aload #7
    //   157: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   160: pop
    //   161: aload #9
    //   163: ldc 'app_info'
    //   165: new org/json/JSONArray
    //   168: dup
    //   169: aload_1
    //   170: invokespecial <init> : (Ljava/util/Collection;)V
    //   173: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   176: pop
    //   177: aload #9
    //   179: ldc 'timestamp'
    //   181: invokestatic currentTimeMillis : ()J
    //   184: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   187: pop
    //   188: aload #9
    //   190: ldc 'device_id'
    //   192: aload #8
    //   194: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   197: pop
    //   198: aload #9
    //   200: ldc 'did'
    //   202: aload_0
    //   203: getfield b : Landroid/content/Context;
    //   206: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   209: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   212: pop
    //   213: aload #9
    //   215: ldc 'os_version'
    //   217: getstatic android/os/Build$VERSION.RELEASE : Ljava/lang/String;
    //   220: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   223: pop
    //   224: aload #9
    //   226: ldc 'device_platform'
    //   228: ldc 'android'
    //   230: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   233: pop
    //   234: aload #9
    //   236: ldc 'device_model'
    //   238: getstatic android/os/Build.MODEL : Ljava/lang/String;
    //   241: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   244: pop
    //   245: aload #9
    //   247: ldc 'app_id'
    //   249: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/core/h;
    //   252: invokevirtual e : ()Ljava/lang/String;
    //   255: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   258: pop
    //   259: aload #9
    //   261: ldc 'app_list_type'
    //   263: iconst_1
    //   264: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   267: pop
    //   268: aload #9
    //   270: ldc 'sdk_version'
    //   272: ldc '2.9.5.6'
    //   274: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   277: pop
    //   278: aload #9
    //   280: ldc 'device_id_type'
    //   282: iload #5
    //   284: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   287: pop
    //   288: aload_2
    //   289: ifnull -> 419
    //   292: aload_2
    //   293: invokeinterface isEmpty : ()Z
    //   298: ifne -> 419
    //   301: new org/json/JSONArray
    //   304: dup
    //   305: invokespecial <init> : ()V
    //   308: astore_1
    //   309: new org/json/JSONArray
    //   312: dup
    //   313: invokespecial <init> : ()V
    //   316: astore #7
    //   318: aload_2
    //   319: invokeinterface iterator : ()Ljava/util/Iterator;
    //   324: astore_2
    //   325: aload_2
    //   326: invokeinterface hasNext : ()Z
    //   331: ifeq -> 400
    //   334: aload_2
    //   335: invokeinterface next : ()Ljava/lang/Object;
    //   340: checkcast java/lang/String
    //   343: astore #8
    //   345: aload #8
    //   347: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   350: istore #6
    //   352: iload #6
    //   354: ifne -> 325
    //   357: invokestatic a : ()Landroid/content/Context;
    //   360: aload #8
    //   362: invokestatic c : (Landroid/content/Context;Ljava/lang/String;)Z
    //   365: ifeq -> 378
    //   368: aload_1
    //   369: aload #8
    //   371: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   374: pop
    //   375: goto -> 325
    //   378: aload #7
    //   380: aload #8
    //   382: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   385: pop
    //   386: goto -> 325
    //   389: aload #7
    //   391: aload #8
    //   393: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   396: pop
    //   397: goto -> 325
    //   400: aload #9
    //   402: ldc 'have_applist'
    //   404: aload_1
    //   405: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   408: pop
    //   409: aload #9
    //   411: ldc 'no_applist'
    //   413: aload #7
    //   415: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   418: pop
    //   419: aload_3
    //   420: ifnull -> 572
    //   423: aload_3
    //   424: invokeinterface isEmpty : ()Z
    //   429: ifne -> 572
    //   432: new org/json/JSONArray
    //   435: dup
    //   436: invokespecial <init> : ()V
    //   439: astore_1
    //   440: new org/json/JSONArray
    //   443: dup
    //   444: invokespecial <init> : ()V
    //   447: astore_2
    //   448: aload_3
    //   449: invokeinterface iterator : ()Ljava/util/Iterator;
    //   454: astore_3
    //   455: aload_3
    //   456: invokeinterface hasNext : ()Z
    //   461: ifeq -> 554
    //   464: aload_3
    //   465: invokeinterface next : ()Ljava/lang/Object;
    //   470: checkcast java/lang/String
    //   473: astore #7
    //   475: aload #7
    //   477: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   480: istore #6
    //   482: iload #6
    //   484: ifne -> 455
    //   487: aload #7
    //   489: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   492: astore #8
    //   494: new android/content/Intent
    //   497: dup
    //   498: ldc 'android.intent.action.VIEW'
    //   500: invokespecial <init> : (Ljava/lang/String;)V
    //   503: astore #10
    //   505: aload #10
    //   507: aload #8
    //   509: invokevirtual setData : (Landroid/net/Uri;)Landroid/content/Intent;
    //   512: pop
    //   513: invokestatic a : ()Landroid/content/Context;
    //   516: aload #10
    //   518: invokestatic a : (Landroid/content/Context;Landroid/content/Intent;)Z
    //   521: ifeq -> 534
    //   524: aload_1
    //   525: aload #7
    //   527: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   530: pop
    //   531: goto -> 455
    //   534: aload_2
    //   535: aload #7
    //   537: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   540: pop
    //   541: goto -> 455
    //   544: aload_2
    //   545: aload #7
    //   547: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   550: pop
    //   551: goto -> 455
    //   554: aload #9
    //   556: ldc 'scheme_success_list'
    //   558: aload_1
    //   559: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   562: pop
    //   563: aload #9
    //   565: ldc 'scheme_fail_list'
    //   567: aload_2
    //   568: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   571: pop
    //   572: aload #9
    //   574: areturn
    //   575: astore_1
    //   576: aload #9
    //   578: areturn
    //   579: astore #10
    //   581: goto -> 389
    //   584: astore #8
    //   586: goto -> 544
    // Exception table:
    //   from	to	target	type
    //   16	38	575	java/lang/Exception
    //   62	71	575	java/lang/Exception
    //   74	79	575	java/lang/Exception
    //   91	100	575	java/lang/Exception
    //   100	117	575	java/lang/Exception
    //   117	148	575	java/lang/Exception
    //   151	288	575	java/lang/Exception
    //   292	325	575	java/lang/Exception
    //   325	352	575	java/lang/Exception
    //   357	375	579	finally
    //   378	386	579	finally
    //   389	397	575	java/lang/Exception
    //   400	419	575	java/lang/Exception
    //   423	455	575	java/lang/Exception
    //   455	482	575	java/lang/Exception
    //   487	531	584	finally
    //   534	541	584	finally
    //   544	551	575	java/lang/Exception
    //   554	572	575	java/lang/Exception
  }
  
  private void a(List<JSONObject> paramList, boolean paramBoolean) throws JSONException {
    int i;
    List<JSONObject> list;
    if (j.d(this.b) == null && j.c(this.b) == null && j.a(this.b) == null && x.a() == null) {
      this.d.set(false);
      t.b("ApplistHelper", "real upload error1");
      return;
    } 
    boolean bool = a(paramList);
    List<String> list1 = o.h().N();
    List<String> list2 = o.h().O();
    if (!bool && (list1 == null || list1.isEmpty()) && (list2 == null || list2.isEmpty())) {
      this.d.set(false);
      t.b("ApplistHelper", "real upload error2");
      return;
    } 
    if (bool) {
      list = paramList;
    } else {
      list = new ArrayList();
    } 
    JSONObject jSONObject = ah.a(a(list, list1, list2));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("param:");
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    } 
    stringBuilder.append(i);
    t.b("ApplistHelper", stringBuilder.toString());
    (new f(1, ah.q("/api/ad/union/sdk/upload/app_info/"), jSONObject, new n.a<JSONObject>(this, paramBoolean, paramList) {
          public void a(n<JSONObject> param1n) {
            t.b("ApplistHelper", "real upload response");
            if (param1n != null && param1n.a())
              if (param1n.a != null && "20000".equals(((JSONObject)param1n.a).optString("status"))) {
                if (this.a)
                  b.a(this.c).a(); 
                String str = com.bytedance.sdk.openadsdk.core.a.a((new JSONArray(this.b)).toString(), com.bytedance.sdk.openadsdk.core.b.a());
                b.a(this.c).a(str);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("APP List upload success ! ");
                stringBuilder.append(param1n.e);
                t.b("ApplistHelper", stringBuilder.toString());
              } else {
                t.b("ApplistHelper", "APP List upload failed !");
              }  
            b.b(this.c).set(false);
          }
          
          public void b(n<JSONObject> param1n) {
            if (param1n != null) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("upload failed: code=");
              stringBuilder.append(param1n.h);
              t.c("ApplistHelper", stringBuilder.toString(), (Throwable)param1n.c);
            } 
            b.b(this.c).set(false);
          }
        })).setResponseOnMain(false).setShouldCache(false).build(e.a(this.b).d());
  }
  
  private boolean a(List<JSONObject> paramList) {
    if (paramList == null || paramList.isEmpty()) {
      t.b("ApplistHelper", "is app change true1");
      return false;
    } 
    Collections.sort(paramList, this.f);
    String str = com.bytedance.sdk.openadsdk.core.a.b(this.c.b(), com.bytedance.sdk.openadsdk.core.b.a());
    if (TextUtils.isEmpty(str)) {
      t.b("ApplistHelper", "is app change true2");
      return true;
    } 
    try {
      JSONArray jSONArray = new JSONArray(str);
      int i = jSONArray.length();
      return true;
    } finally {
      paramList = null;
      t.c("ApplistHelper", "is app change error: ", (Throwable)paramList);
    } 
  }
  
  private List<JSONObject> b(Context paramContext) {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #5
    //   9: aload_1
    //   10: ifnull -> 473
    //   13: aload_0
    //   14: getfield e : Z
    //   17: ifne -> 23
    //   20: aload #5
    //   22: areturn
    //   23: new org/json/JSONObject
    //   26: dup
    //   27: ldc_w 'utS\Ijx.:}oJEviZ;q9Yx;wrpHEDSop\7hSMzh6Ww}yffH}{<I[VmvQLVf\G4pp8gdyJdndq7YtZ.lHJft<wemwVu[L|5Sg].Z]Zr3X}{:DwWYWiwl7|iYnxfxpE]ri<3f\.t;T2}6h7H;.4hE7{x7fKdq[4KsvWYqP4DKE3WQLEx<7HjkQqwUXR}QVW2Wjf'
    //   30: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   33: invokestatic a : ()Ljava/lang/String;
    //   36: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokespecial <init> : (Ljava/lang/String;)V
    //   42: astore_3
    //   43: aload_3
    //   44: ldc_w 'cn'
    //   47: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   50: aload_3
    //   51: ldc_w 'm1'
    //   54: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   57: iconst_0
    //   58: anewarray java/lang/Class
    //   61: invokestatic a : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   64: aload_1
    //   65: iconst_0
    //   66: anewarray java/lang/Object
    //   69: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   72: astore #6
    //   74: aload_3
    //   75: ldc_w 'pn'
    //   78: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   81: astore #7
    //   83: aload_3
    //   84: ldc_w 'm2'
    //   87: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   90: astore_1
    //   91: aload_3
    //   92: ldc_w 'f'
    //   95: invokevirtual optInt : (Ljava/lang/String;)I
    //   98: istore_2
    //   99: aload #7
    //   101: aload_1
    //   102: iconst_1
    //   103: anewarray java/lang/Class
    //   106: dup
    //   107: iconst_0
    //   108: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   111: aastore
    //   112: invokestatic a : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   115: aload #6
    //   117: iconst_1
    //   118: anewarray java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: iload_2
    //   124: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   127: aastore
    //   128: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   131: astore_1
    //   132: aload_1
    //   133: instanceof java/util/List
    //   136: ifeq -> 473
    //   139: aload_1
    //   140: checkcast java/util/List
    //   143: astore_1
    //   144: aload_1
    //   145: ifnull -> 473
    //   148: aload_1
    //   149: invokeinterface isEmpty : ()Z
    //   154: ifne -> 473
    //   157: aload_1
    //   158: invokeinterface iterator : ()Ljava/util/Iterator;
    //   163: astore #8
    //   165: aload #8
    //   167: invokeinterface hasNext : ()Z
    //   172: ifeq -> 473
    //   175: aload #8
    //   177: invokeinterface next : ()Ljava/lang/Object;
    //   182: astore_1
    //   183: aload_1
    //   184: instanceof android/content/pm/PackageInfo
    //   187: ifeq -> 165
    //   190: aload_1
    //   191: checkcast android/content/pm/PackageInfo
    //   194: astore #9
    //   196: aload #9
    //   198: getfield applicationInfo : Landroid/content/pm/ApplicationInfo;
    //   201: astore_1
    //   202: ldc_w 'unknown'
    //   205: astore #4
    //   207: aload_1
    //   208: ifnull -> 266
    //   211: aload #7
    //   213: ldc_w 'getApplicationLabel'
    //   216: iconst_1
    //   217: anewarray java/lang/Class
    //   220: dup
    //   221: iconst_0
    //   222: ldc android/content/pm/ApplicationInfo
    //   224: aastore
    //   225: invokestatic a : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   228: aload #6
    //   230: iconst_1
    //   231: anewarray java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload #9
    //   238: getfield applicationInfo : Landroid/content/pm/ApplicationInfo;
    //   241: aastore
    //   242: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   245: checkcast java/lang/CharSequence
    //   248: astore_1
    //   249: aload_1
    //   250: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   253: ifne -> 266
    //   256: aload_1
    //   257: invokeinterface toString : ()Ljava/lang/String;
    //   262: astore_1
    //   263: goto -> 270
    //   266: ldc_w 'unknown'
    //   269: astore_1
    //   270: aload #7
    //   272: ldc_w 'getApplicationInfo'
    //   275: iconst_2
    //   276: anewarray java/lang/Class
    //   279: dup
    //   280: iconst_0
    //   281: ldc java/lang/String
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   289: aastore
    //   290: invokestatic a : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   293: aload #6
    //   295: iconst_2
    //   296: anewarray java/lang/Object
    //   299: dup
    //   300: iconst_0
    //   301: aload #9
    //   303: getfield packageName : Ljava/lang/String;
    //   306: aastore
    //   307: dup
    //   308: iconst_1
    //   309: iconst_0
    //   310: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   313: aastore
    //   314: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   317: checkcast android/content/pm/ApplicationInfo
    //   320: astore #10
    //   322: aload #4
    //   324: astore_3
    //   325: aload #10
    //   327: ifnull -> 336
    //   330: aload #10
    //   332: getfield sourceDir : Ljava/lang/String;
    //   335: astore_3
    //   336: new org/json/JSONObject
    //   339: dup
    //   340: invokespecial <init> : ()V
    //   343: astore #4
    //   345: aload #4
    //   347: ldc 'package_name'
    //   349: aload #9
    //   351: getfield packageName : Ljava/lang/String;
    //   354: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   357: pop
    //   358: aload #4
    //   360: ldc_w 'first_install_time'
    //   363: aload #9
    //   365: getfield firstInstallTime : J
    //   368: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   371: pop
    //   372: aload #4
    //   374: ldc_w 'last_update_time'
    //   377: aload #9
    //   379: getfield lastUpdateTime : J
    //   382: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   385: pop
    //   386: aload #4
    //   388: ldc_w 'version_name'
    //   391: aload #9
    //   393: getfield versionName : Ljava/lang/String;
    //   396: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   399: pop
    //   400: aload #4
    //   402: ldc_w 'version_code'
    //   405: aload #9
    //   407: getfield versionCode : I
    //   410: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   413: pop
    //   414: aload #4
    //   416: ldc_w 'app_name'
    //   419: aload_1
    //   420: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   423: pop
    //   424: aload #4
    //   426: ldc_w 'app_type'
    //   429: aload_0
    //   430: aload #9
    //   432: invokespecial a : (Landroid/content/pm/PackageInfo;)I
    //   435: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   438: pop
    //   439: aload #4
    //   441: ldc_w 'apk_dir'
    //   444: aload_3
    //   445: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   448: pop
    //   449: aload #5
    //   451: aload #4
    //   453: invokeinterface add : (Ljava/lang/Object;)Z
    //   458: pop
    //   459: goto -> 165
    //   462: astore_1
    //   463: ldc_w 'ApplistHelper'
    //   466: ldc_w 'get install apps error: '
    //   469: aload_1
    //   470: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   473: aload #5
    //   475: areturn
    //   476: astore_1
    //   477: goto -> 266
    //   480: astore_3
    //   481: aload #4
    //   483: astore_3
    //   484: goto -> 336
    // Exception table:
    //   from	to	target	type
    //   23	144	462	finally
    //   148	165	462	finally
    //   165	202	462	finally
    //   211	263	476	finally
    //   270	322	480	finally
    //   330	336	480	finally
    //   336	459	462	finally
  }
  
  public List<String> a(Context paramContext) {
    ArrayList<String> arrayList = new ArrayList();
    try {
      JSONObject jSONObject = new JSONObject(com.bytedance.sdk.openadsdk.core.a.b(b.a("utS\\Ijx.:}oJEviZ;q9Yx;wrpHEDSop\\7hSMzh6Ww}yffH}{<I[VmvQLVf\\G4pp8gdyJdndq7YtZ.lHJft<wemwVu[L|5Sg].Z]Zr3X}{:DwWYWiwl7|iYnxfxpE]ri<3f\\.t;T2}6h7H;.4hE7{x7fKdq[4KsvWYqP4DKE3WQLEx<7HjkQqwUXR}QVW2Wjf"), com.bytedance.sdk.openadsdk.core.b.a()));
      Object object2 = ag.a(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(paramContext, new Object[0]);
      String str2 = jSONObject.optString("pn");
      String str1 = jSONObject.optString("m2");
      int i = jSONObject.optInt("f");
      Object object1 = ag.a(str2, str1, new Class[] { int.class }).invoke(object2, new Object[] { Integer.valueOf(i) });
      if (object1 instanceof List) {
        object1 = object1;
        if (object1 != null && !object1.isEmpty()) {
          Iterator iterator = object1.iterator();
          while (true)
            return arrayList; 
        } 
      } 
    } finally {
      paramContext = null;
    } 
  }
  
  public void b() {
    boolean bool;
    if (o.h().P() && h.c().d().alist()) {
      bool = true;
    } else {
      bool = false;
    } 
    this.e = bool;
    if (!i.d())
      return; 
    if (this.d.get())
      return; 
    this.d.set(true);
    try {
      return;
    } finally {
      Exception exception = null;
      t.a("ApplistHelper", "upload sdk applist error: ", exception);
      this.d.set(false);
    } 
  }
  
  public void run() {
    if (!w.a(this.b)) {
      this.d.set(false);
      return;
    } 
    try {
      return;
    } finally {
      Exception exception = null;
      this.d.set(false);
      t.c("ApplistHelper", "upload sdk runnable error: ", exception);
    } 
  }
  
  class a {
    private final SharedPreferences b;
    
    a(b this$0, Context param1Context) {
      this.b = param1Context.getSharedPreferences("tt_sp_app_list", 0);
    }
    
    private long a(long param1Long) {
      return (param1Long + TimeZone.getDefault().getOffset(param1Long)) / 86400000L;
    }
    
    private boolean a(long param1Long1, long param1Long2) {
      long l = param1Long2 - param1Long1;
      return (l < 86400000L && l > -86400000L && a(param1Long1) == a(param1Long2));
    }
    
    void a() {
      if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_list", "day_update_time", Long.valueOf(System.currentTimeMillis()));
        return;
      } 
      this.b.edit().putLong("day_update_time", System.currentTimeMillis()).apply();
    }
    
    void a(String param1String) {
      if (TextUtils.isEmpty(param1String))
        return; 
      if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_list", "old_app_list", param1String);
        return;
      } 
      this.b.edit().putString("old_app_list", param1String).apply();
    }
    
    String b() {
      return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sp_app_list", "old_app_list", "") : this.b.getString("old_app_list", "");
    }
    
    boolean c() {
      long l;
      if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
        l = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_list", "day_update_time", 0L);
      } else {
        l = this.b.getLong("day_update_time", 0L);
      } 
      return a(l, System.currentTimeMillis()) ^ true;
    }
  }
  
  static class b {
    static String a(String param1String) {
      byte[] arrayOfByte = param1String.getBytes();
      for (int i = 0; i < arrayOfByte.length; i++)
        arrayOfByte[i] = (byte)(arrayOfByte[i] - 3); 
      return new String(arrayOfByte);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */