package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.f;
import com.bytedance.sdk.adnet.b.h;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.b.j;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.d;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.c.a;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.h;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.d.a;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.core.d.q;
import com.bytedance.sdk.openadsdk.core.h.b;
import com.bytedance.sdk.openadsdk.core.h.f;
import com.bytedance.sdk.openadsdk.core.h.i;
import com.bytedance.sdk.openadsdk.core.h.j;
import com.bytedance.sdk.openadsdk.downloadnew.a.d;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.d;
import com.bytedance.sdk.openadsdk.utils.i;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.p;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import com.bytedance.sdk.openadsdk.utils.x;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class q implements p<a> {
  private static boolean f = true;
  
  private final Context a;
  
  private final boolean b;
  
  private final String c;
  
  private long d;
  
  private int e;
  
  q(Context paramContext) {
    this.a = paramContext;
    this.b = g();
    this.c = j();
  }
  
  private int a(int paramInt) {
    return 10000;
  }
  
  private static String a(Context paramContext) {
    try {
      return (telephonyManager == null) ? "" : telephonyManager.getSimOperator();
    } finally {
      paramContext = null;
    } 
  }
  
  private JSONObject a(AdSlot paramAdSlot, int paramInt, l paraml) {
    // Byte code:
    //   0: new org/json/JSONObject
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #6
    //   9: aload #6
    //   11: ldc 'id'
    //   13: aload_1
    //   14: invokevirtual getCodeId : ()Ljava/lang/String;
    //   17: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   20: pop
    //   21: aload #6
    //   23: ldc 'adtype'
    //   25: iload_2
    //   26: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_3
    //   31: ifnull -> 49
    //   34: aload #6
    //   36: ldc 'render_method'
    //   38: aload_3
    //   39: getfield e : I
    //   42: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   45: pop
    //   46: goto -> 58
    //   49: aload #6
    //   51: ldc 'render_method'
    //   53: iconst_1
    //   54: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   57: pop
    //   58: aload #6
    //   60: ldc 'ptpl_ids'
    //   62: invokestatic h : ()Lcom/bytedance/sdk/openadsdk/core/h/l;
    //   65: aload_1
    //   66: invokevirtual getCodeId : ()Ljava/lang/String;
    //   69: invokevirtual h : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   72: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   75: pop
    //   76: aload #6
    //   78: ldc 'pos'
    //   80: iload_2
    //   81: invokestatic getPosition : (I)I
    //   84: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   87: pop
    //   88: aload_0
    //   89: aload #6
    //   91: ldc 'accepted_size'
    //   93: aload_1
    //   94: invokevirtual getImgAcceptedWidth : ()I
    //   97: aload_1
    //   98: invokevirtual getImgAcceptedHeight : ()I
    //   101: invokespecial a : (Lorg/json/JSONObject;Ljava/lang/String;II)V
    //   104: aload #6
    //   106: ldc 'is_support_dpl'
    //   108: aload_1
    //   109: invokevirtual isSupportDeepLink : ()Z
    //   112: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload_1
    //   117: invokevirtual getNativeAdType : ()I
    //   120: ifgt -> 134
    //   123: iload_2
    //   124: bipush #9
    //   126: if_icmpeq -> 134
    //   129: iload_2
    //   130: iconst_5
    //   131: if_icmpne -> 143
    //   134: aload #6
    //   136: ldc 'is_origin_ad'
    //   138: iconst_1
    //   139: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   142: pop
    //   143: aload_3
    //   144: ifnull -> 166
    //   147: aload_3
    //   148: getfield g : Lorg/json/JSONObject;
    //   151: ifnull -> 166
    //   154: aload #6
    //   156: ldc 'session_params'
    //   158: aload_3
    //   159: getfield g : Lorg/json/JSONObject;
    //   162: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   165: pop
    //   166: aload_1
    //   167: invokevirtual getAdCount : ()I
    //   170: istore #5
    //   172: iload #5
    //   174: istore #4
    //   176: iload #5
    //   178: iconst_1
    //   179: if_icmpge -> 226
    //   182: iconst_1
    //   183: istore #4
    //   185: goto -> 226
    //   188: iload #4
    //   190: istore_2
    //   191: aload_3
    //   192: ifnull -> 210
    //   195: iload #4
    //   197: istore_2
    //   198: aload_3
    //   199: getfield d : Lorg/json/JSONArray;
    //   202: ifnull -> 210
    //   205: aload_1
    //   206: invokevirtual getAdCount : ()I
    //   209: istore_2
    //   210: aload #6
    //   212: ldc 'ad_count'
    //   214: iload_2
    //   215: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   218: pop
    //   219: aload #6
    //   221: areturn
    //   222: astore_1
    //   223: aload #6
    //   225: areturn
    //   226: iload #4
    //   228: istore #5
    //   230: iload #4
    //   232: iconst_3
    //   233: if_icmple -> 239
    //   236: iconst_3
    //   237: istore #5
    //   239: iload_2
    //   240: bipush #7
    //   242: if_icmpeq -> 255
    //   245: iload #5
    //   247: istore #4
    //   249: iload_2
    //   250: bipush #8
    //   252: if_icmpne -> 188
    //   255: iconst_1
    //   256: istore #4
    //   258: goto -> 188
    // Exception table:
    //   from	to	target	type
    //   9	30	222	java/lang/Exception
    //   34	46	222	java/lang/Exception
    //   49	58	222	java/lang/Exception
    //   58	123	222	java/lang/Exception
    //   134	143	222	java/lang/Exception
    //   147	166	222	java/lang/Exception
    //   166	172	222	java/lang/Exception
    //   198	210	222	java/lang/Exception
    //   210	219	222	java/lang/Exception
  }
  
  private JSONObject a(AdSlot paramAdSlot, l paraml, int paramInt) {
    JSONObject jSONObject = new JSONObject();
    try {
      String str3;
      JSONObject jSONObject2 = new JSONObject();
      if (paraml == null || TextUtils.isEmpty(paraml.a)) {
        str3 = ah.b();
      } else {
        str3 = paraml.a;
      } 
      if (paramInt == 7) {
        if (paraml != null && paraml.b > 0)
          jSONObject2.put("req_type", paraml.b); 
      } else if (paramInt == 8 && paraml != null && paraml.c > 0) {
        jSONObject2.put("req_type", paraml.c);
      } 
      try {
        String str5 = o.h().h();
        String str6 = o.h().i();
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
          JSONObject jSONObject3 = new JSONObject();
          jSONObject3.put("version", str5);
          jSONObject3.put("param", str6);
          jSONObject2.put("abtest", jSONObject3);
        } 
      } finally {
        Exception exception;
      } 
      jSONObject2.put("request_id", str3);
      jSONObject2.put("ad_sdk_version", "2.9.5.6");
      jSONObject2.put("source_type", "app");
      jSONObject2.put("app", b());
      JSONObject jSONObject1 = i.d(this.a);
      if (jSONObject1 != null) {
        if (!o.h().F() && !d.b())
          jSONObject1.remove("free_space"); 
        if (paramAdSlot.getOrientation() > 0)
          jSONObject1.put("orientation", paramAdSlot.getOrientation()); 
      } 
      jSONObject2.put("device", jSONObject1);
      jSONObject2.put("user", d());
      jSONObject2.put("ua", r.a);
      jSONObject2.put("ip", e());
      JSONArray jSONArray = new JSONArray();
      jSONArray.put(a(paramAdSlot, paramInt, paraml));
      jSONObject2.put("adslots", jSONArray);
      a(jSONObject2, paraml);
      long l1 = System.currentTimeMillis() / 1000L;
      jSONObject2.put("ts", l1);
      String str4 = "";
      String str2 = str4;
      if (paramAdSlot.getCodeId() != null) {
        str2 = str4;
        if (str3 != null)
          str2 = String.valueOf(l1).concat(paramAdSlot.getCodeId()).concat(str3); 
      } 
      jSONObject2.put("req_sign", j.a(str2));
      String str1 = k();
      str2 = d(str1);
      str2 = a.a(jSONObject2.toString(), str2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(2);
      stringBuilder.append(str1);
      stringBuilder.append(str2);
      str1 = stringBuilder.toString();
      boolean bool = b(str2);
      if (bool) {
        jSONObject.put("message", str1);
        jSONObject.put("cypher", 2);
      } else {
        jSONObject.put("message", jSONObject2.toString());
        jSONObject.put("cypher", 0);
      } 
      jSONObject.put("ad_sdk_version", "2.9.5.6");
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  private JSONObject a(String paramString1, String paramString2) {
    JSONObject jSONObject = new JSONObject();
    try {
      paramString1 = a.a(paramString1, b.a());
      int i = (int)(System.currentTimeMillis() / 1000L);
      StringBuilder stringBuilder = new StringBuilder("id=");
      stringBuilder.append(paramString1);
      stringBuilder.append("&timestamp=");
      stringBuilder.append(i);
      stringBuilder.append("&ext=");
      stringBuilder.append(paramString2);
      String str = j.a(stringBuilder.toString()).toUpperCase();
      jSONObject.put("id", paramString1);
      jSONObject.put("timestamp", i);
      jSONObject.put("sign", str);
      jSONObject.put("ext", paramString2);
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  private void a(long paramLong, String paramString1, int paramInt1, a parama, int paramInt2, String paramString2) {
    // Byte code:
    //   0: invokestatic a : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: iload #4
    //   9: iconst_4
    //   10: if_icmpeq -> 20
    //   13: iload #4
    //   15: iconst_3
    //   16: if_icmpeq -> 20
    //   19: return
    //   20: aload #7
    //   22: astore #9
    //   24: aload #7
    //   26: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   29: ifeq -> 39
    //   32: iload #6
    //   34: invokestatic a : (I)Ljava/lang/String;
    //   37: astore #9
    //   39: new com/bytedance/sdk/openadsdk/f/a/c
    //   42: dup
    //   43: invokespecial <init> : ()V
    //   46: iload #4
    //   48: invokevirtual a : (I)Lcom/bytedance/sdk/openadsdk/f/a/d;
    //   51: checkcast com/bytedance/sdk/openadsdk/f/a/c
    //   54: iload #6
    //   56: invokevirtual b : (I)Lcom/bytedance/sdk/openadsdk/f/a/d;
    //   59: checkcast com/bytedance/sdk/openadsdk/f/a/c
    //   62: aload #9
    //   64: invokevirtual g : (Ljava/lang/String;)Lcom/bytedance/sdk/openadsdk/f/a/d;
    //   67: checkcast com/bytedance/sdk/openadsdk/f/a/c
    //   70: astore #13
    //   72: aconst_null
    //   73: astore #10
    //   75: ldc ''
    //   77: astore #12
    //   79: aload #5
    //   81: ifnull -> 184
    //   84: aload #5
    //   86: getfield h : Lcom/bytedance/sdk/openadsdk/core/d/a;
    //   89: ifnull -> 184
    //   92: aload #5
    //   94: getfield h : Lcom/bytedance/sdk/openadsdk/core/d/a;
    //   97: invokevirtual c : ()Ljava/util/List;
    //   100: ifnull -> 184
    //   103: aload #5
    //   105: getfield h : Lcom/bytedance/sdk/openadsdk/core/d/a;
    //   108: invokevirtual c : ()Ljava/util/List;
    //   111: invokeinterface size : ()I
    //   116: ifle -> 184
    //   119: aload #5
    //   121: getfield h : Lcom/bytedance/sdk/openadsdk/core/d/a;
    //   124: invokevirtual c : ()Ljava/util/List;
    //   127: iconst_0
    //   128: invokeinterface get : (I)Ljava/lang/Object;
    //   133: checkcast com/bytedance/sdk/openadsdk/core/d/k
    //   136: astore #10
    //   138: aload #10
    //   140: invokevirtual P : ()Ljava/lang/String;
    //   143: astore #9
    //   145: aload #9
    //   147: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   150: istore #8
    //   152: iload #8
    //   154: ifne -> 177
    //   157: new org/json/JSONObject
    //   160: dup
    //   161: aload #9
    //   163: invokespecial <init> : (Ljava/lang/String;)V
    //   166: ldc_w 'req_id'
    //   169: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   172: astore #7
    //   174: goto -> 192
    //   177: ldc ''
    //   179: astore #7
    //   181: goto -> 192
    //   184: ldc ''
    //   186: astore #9
    //   188: aload #9
    //   190: astore #7
    //   192: aload #7
    //   194: astore #11
    //   196: aload #7
    //   198: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   201: ifeq -> 235
    //   204: aload #7
    //   206: astore #11
    //   208: aload #5
    //   210: ifnull -> 235
    //   213: aload #7
    //   215: astore #11
    //   217: aload #5
    //   219: getfield h : Lcom/bytedance/sdk/openadsdk/core/d/a;
    //   222: ifnull -> 235
    //   225: aload #5
    //   227: getfield h : Lcom/bytedance/sdk/openadsdk/core/d/a;
    //   230: invokevirtual a : ()Ljava/lang/String;
    //   233: astore #11
    //   235: aload #13
    //   237: aload #11
    //   239: invokevirtual f : (Ljava/lang/String;)Lcom/bytedance/sdk/openadsdk/f/a/d;
    //   242: checkcast com/bytedance/sdk/openadsdk/f/a/c
    //   245: astore #11
    //   247: aload #12
    //   249: astore #7
    //   251: aload #10
    //   253: ifnull -> 263
    //   256: aload #10
    //   258: invokevirtual M : ()Ljava/lang/String;
    //   261: astore #7
    //   263: aload #11
    //   265: aload #7
    //   267: invokevirtual d : (Ljava/lang/String;)Lcom/bytedance/sdk/openadsdk/f/a/d;
    //   270: checkcast com/bytedance/sdk/openadsdk/f/a/c
    //   273: aload #9
    //   275: invokevirtual h : (Ljava/lang/String;)Lcom/bytedance/sdk/openadsdk/f/a/d;
    //   278: checkcast com/bytedance/sdk/openadsdk/f/a/c
    //   281: aload_3
    //   282: invokevirtual c : (Ljava/lang/String;)Lcom/bytedance/sdk/openadsdk/f/a/d;
    //   285: checkcast com/bytedance/sdk/openadsdk/f/a/c
    //   288: lload_1
    //   289: invokevirtual a : (J)Lcom/bytedance/sdk/openadsdk/f/a/c;
    //   292: astore_3
    //   293: aload #5
    //   295: ifnull -> 342
    //   298: aload #5
    //   300: getfield a : I
    //   303: i2l
    //   304: lstore_1
    //   305: goto -> 308
    //   308: aload_3
    //   309: lload_1
    //   310: invokevirtual b : (J)Lcom/bytedance/sdk/openadsdk/f/a/c;
    //   313: pop
    //   314: goto -> 328
    //   317: astore_3
    //   318: ldc_w 'NetApiImpl'
    //   321: ldc_w 'uploadAdTypeTimeOutEvent throws exception '
    //   324: aload_3
    //   325: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   328: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/f/a;
    //   331: aload #13
    //   333: invokevirtual e : (Lcom/bytedance/sdk/openadsdk/f/a/d;)V
    //   336: return
    //   337: astore #7
    //   339: goto -> 177
    //   342: lconst_0
    //   343: lstore_1
    //   344: goto -> 308
    // Exception table:
    //   from	to	target	type
    //   84	152	317	finally
    //   157	174	337	finally
    //   196	204	317	finally
    //   217	235	317	finally
    //   235	247	317	finally
    //   256	263	317	finally
    //   263	293	317	finally
    //   298	305	317	finally
    //   308	314	317	finally
  }
  
  private void a(a parama) {
    if (parama != null) {
      if (parama.b == null)
        return; 
      String str = parama.b.optString("log_extra", "");
      long l2 = ah.e(str);
      int j = ah.f(str);
      long l1 = l2;
      if (l2 == 0L)
        l1 = this.d; 
      this.d = l1;
      int i = j;
      if (j == 0)
        i = this.e; 
      this.e = i;
    } 
  }
  
  private void a(p.b paramb) {
    paramb.a(-1, g.a(-1));
  }
  
  private void a(p.c paramc) {
    paramc.a(-1, g.a(-1));
  }
  
  private void a(JSONObject paramJSONObject, l paraml) {
    if (paraml != null) {
      if (paraml.d == null)
        return; 
      try {
        paramJSONObject.put("source_temai_product_ids", paraml.d);
        return;
      } catch (Exception exception) {
        return;
      } 
    } 
  }
  
  private void a(JSONObject paramJSONObject, String paramString, int paramInt1, int paramInt2) {
    if (paramInt1 > 0 && paramInt2 > 0) {
      JSONObject jSONObject = new JSONObject();
      JSONArray jSONArray = new JSONArray();
      try {
        jSONObject.put("width", paramInt1);
        jSONObject.put("height", paramInt2);
        jSONArray.put(jSONObject);
        paramJSONObject.put(paramString, jSONArray);
        return;
      } catch (Exception exception) {
        return;
      } 
    } 
  }
  
  private void a(JSONObject paramJSONObject, String paramString1, String paramString2) throws JSONException {
    if (!TextUtils.isEmpty(paramString2))
      paramJSONObject.put(paramString1, paramString2); 
  }
  
  private boolean a(String paramString) {
    if (b.a())
      return true; 
    if (b.a(paramString)) {
      paramString = b.b();
      if (!TextUtils.isEmpty(paramString))
        d.a(this.a, paramString, System.currentTimeMillis()); 
      return true;
    } 
    return false;
  }
  
  private static String b(int paramInt) {
    String str = "mdpi";
    if (paramInt != 120) {
      if (paramInt != 160)
        return (paramInt != 240) ? ((paramInt != 320) ? ((paramInt != 480) ? ((paramInt != 640) ? "mdpi" : "xxxhdpi") : "xxhdpi") : "xhdpi") : "hdpi"; 
    } else {
      str = "ldpi";
    } 
    return str;
  }
  
  private JSONArray b(List<FilterWord> paramList) {
    if (paramList == null || paramList.isEmpty())
      return null; 
    JSONArray jSONArray = new JSONArray();
    Iterator<FilterWord> iterator = paramList.iterator();
    while (iterator.hasNext())
      jSONArray.put(((FilterWord)iterator.next()).getId()); 
    return jSONArray;
  }
  
  private JSONObject b() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("appid", h.c().e());
      jSONObject.put("name", h.c().f());
      c(jSONObject);
      d(jSONObject);
      jSONObject.put("is_paid_app", h.c().g());
      jSONObject.put("apk_sign", s.b(j.a(this.a)).a());
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  private JSONObject b(k paramk, List<FilterWord> paramList) {
    JSONObject jSONObject = new JSONObject();
    com.bytedance.sdk.openadsdk.utils.c c = d.a(this.a);
    try {
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("action", "dislike");
      jSONObject1.put("timestamp", System.currentTimeMillis());
      jSONObject1.put("ad_sdk_version", "2.9.5.6");
      if (c != null) {
        jSONObject1.put("latitude", c.a);
        jSONObject1.put("longitude", c.b);
      } 
      jSONObject1.put("extra", paramk.P());
      jSONObject1.put("filter_words", b(paramList));
      JSONArray jSONArray = new JSONArray();
      jSONArray.put(jSONObject1);
      jSONObject.put("actions", jSONArray);
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  private boolean b(String paramString) {
    return TextUtils.isEmpty(paramString) ^ true;
  }
  
  private boolean b(JSONObject paramJSONObject) {
    if (paramJSONObject != null)
      try {
        return paramJSONObject.optString("message").equalsIgnoreCase("success");
      } finally {} 
    return false;
  }
  
  private String c() {
    return i.a();
  }
  
  private Map<String, String> c(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("Content-Type", "application/json; charset=utf-8");
    if (b(paramString))
      hashMap.put("Content-Encoding", "union_sdk_encode"); 
    return (Map)hashMap;
  }
  
  private void c(JSONObject paramJSONObject) {
    try {
      paramJSONObject.put("package_name", ah.d());
      paramJSONObject.put("version_code", ah.e());
      paramJSONObject.put("version", ah.f());
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private String d(String paramString) {
    String str = a.a(paramString);
    if (paramString == null) {
      paramString = b.a();
      return paramString.concat(paramString).substring(8, 24);
    } 
    return str;
  }
  
  private JSONObject d() {
    JSONObject jSONObject = new JSONObject();
    try {
      a(jSONObject, "keywords", h.c().h());
      JSONArray jSONArray = p.a(this.a);
      if (jSONArray != null)
        jSONObject.put("app_list", jSONArray); 
      a(jSONObject, "data", h.c().i());
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  private void d(JSONObject paramJSONObject) {
    com.bytedance.sdk.openadsdk.utils.c c = d.a(this.a);
    if (c != null)
      try {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("latitude", c.a);
        jSONObject.put("longitude", c.b);
        paramJSONObject.put("geo", jSONObject);
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  private String e() {
    return i.a(true);
  }
  
  private JSONObject e(JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 6
    //   4: aload_1
    //   5: areturn
    //   6: getstatic com/bytedance/sdk/openadsdk/core/q.f : Z
    //   9: ifeq -> 135
    //   12: aload_1
    //   13: ldc_w 'cypher'
    //   16: iconst_m1
    //   17: invokevirtual optInt : (Ljava/lang/String;I)I
    //   20: istore_2
    //   21: aload_1
    //   22: ldc_w 'message'
    //   25: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   28: astore #6
    //   30: iload_2
    //   31: iconst_1
    //   32: if_icmpne -> 154
    //   35: aload #6
    //   37: invokestatic a : ()Ljava/lang/String;
    //   40: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   43: astore #4
    //   45: goto -> 48
    //   48: aload #4
    //   50: astore #5
    //   52: iload_2
    //   53: iconst_2
    //   54: if_icmpne -> 111
    //   57: aload #4
    //   59: astore #5
    //   61: aload #6
    //   63: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   66: ifne -> 111
    //   69: aload #4
    //   71: astore #5
    //   73: aload #6
    //   75: invokevirtual length : ()I
    //   78: bipush #17
    //   80: if_icmplt -> 111
    //   83: aload_0
    //   84: aload #6
    //   86: iconst_1
    //   87: bipush #17
    //   89: invokevirtual substring : (II)Ljava/lang/String;
    //   92: invokespecial d : (Ljava/lang/String;)Ljava/lang/String;
    //   95: astore #4
    //   97: aload #6
    //   99: bipush #17
    //   101: invokevirtual substring : (I)Ljava/lang/String;
    //   104: aload #4
    //   106: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   109: astore #5
    //   111: aload #5
    //   113: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   116: istore_3
    //   117: iload_3
    //   118: ifne -> 135
    //   121: new org/json/JSONObject
    //   124: dup
    //   125: aload #5
    //   127: invokespecial <init> : (Ljava/lang/String;)V
    //   130: astore #4
    //   132: goto -> 138
    //   135: aload_1
    //   136: astore #4
    //   138: getstatic com/bytedance/sdk/openadsdk/core/q.f : Z
    //   141: ifeq -> 147
    //   144: aload #4
    //   146: astore_1
    //   147: aload_1
    //   148: areturn
    //   149: astore #4
    //   151: goto -> 135
    //   154: aload #6
    //   156: astore #4
    //   158: goto -> 48
    // Exception table:
    //   from	to	target	type
    //   6	30	149	java/lang/Exception
    //   35	45	149	java/lang/Exception
    //   61	69	149	java/lang/Exception
    //   73	111	149	java/lang/Exception
    //   111	117	149	java/lang/Exception
    //   121	132	149	finally
  }
  
  private JSONObject f() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("ua", r.a);
      jSONObject.put("udid", j.d(this.a));
      jSONObject.put("openudid", j.c(this.a));
      jSONObject.put("oaid", x.a());
      jSONObject.put("ad_sdk_version", "2.9.5.6");
      jSONObject.put("sim_op", a(this.a));
      if (this.b) {
        boolean bool1 = true;
        jSONObject.put("root", bool1);
        jSONObject.put("timezone", i());
        jSONObject.put("access", w.f(this.a));
        jSONObject.put("os", "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        jSONObject.put("device_type", this.c);
        jSONObject.put("device_model", Build.MODEL);
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_manufacturer", Build.MANUFACTURER);
        jSONObject.put("language", Locale.getDefault().getLanguage());
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(ai.d(this.a));
        stringBuilder1.append("x");
        stringBuilder1.append(ai.c(this.a));
        jSONObject.put("resolution", stringBuilder1.toString());
        jSONObject.put("display_density", b(ai.f(this.a)));
        jSONObject.put("density_dpi", ai.f(this.a));
        jSONObject.put("mc", c());
        jSONObject.put("device_id", j.a(this.a));
        jSONObject.put("aid", "1371");
        jSONObject.put("rom", h());
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", j.i(this.a));
        jSONObject.put("ut", this.e);
        jSONObject.put("uid", this.d);
        return jSONObject;
      } 
    } catch (Exception exception) {
      return jSONObject;
    } 
    boolean bool = false;
    jSONObject.put("root", bool);
    jSONObject.put("timezone", i());
    jSONObject.put("access", w.f(this.a));
    jSONObject.put("os", "Android");
    jSONObject.put("os_version", Build.VERSION.RELEASE);
    jSONObject.put("os_api", Build.VERSION.SDK_INT);
    jSONObject.put("device_type", this.c);
    jSONObject.put("device_model", Build.MODEL);
    jSONObject.put("device_brand", Build.BRAND);
    jSONObject.put("device_manufacturer", Build.MANUFACTURER);
    jSONObject.put("language", Locale.getDefault().getLanguage());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(ai.d(this.a));
    stringBuilder.append("x");
    stringBuilder.append(ai.c(this.a));
    jSONObject.put("resolution", stringBuilder.toString());
    jSONObject.put("display_density", b(ai.f(this.a)));
    jSONObject.put("density_dpi", ai.f(this.a));
    jSONObject.put("mc", c());
    jSONObject.put("device_id", j.a(this.a));
    jSONObject.put("aid", "1371");
    jSONObject.put("rom", h());
    jSONObject.put("cpu_abi", Build.CPU_ABI);
    jSONObject.put("build_serial", j.i(this.a));
    jSONObject.put("ut", this.e);
    jSONObject.put("uid", this.d);
    return jSONObject;
  }
  
  private static boolean g() {
    boolean bool = false;
    try {
      if (!(new File("/system/bin/su")).exists()) {
        boolean bool1 = (new File("/system/xbin/su")).exists();
        return bool1 ? true : bool;
      } 
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private static String h() {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      if (ac.e()) {
        stringBuilder.append("MIUI-");
      } else if (ac.b()) {
        stringBuilder.append("FLYME-");
      } else {
        String str = ac.n();
        if (ac.a(str))
          stringBuilder.append("EMUI-"); 
        if (!TextUtils.isEmpty(str)) {
          stringBuilder.append(str);
          stringBuilder.append("-");
        } 
      } 
      stringBuilder.append(Build.VERSION.INCREMENTAL);
    } finally {
      Exception exception;
    } 
    return stringBuilder.toString();
  }
  
  private static int i() {
    int j = TimeZone.getDefault().getRawOffset() / 3600000;
    int i = j;
    if (j < -12)
      i = -12; 
    j = i;
    if (i > 12)
      j = 12; 
    return j;
  }
  
  private String j() {
    return i.b(this.a) ? "tv" : (i.a(this.a) ? "android_pad" : "android");
  }
  
  private String k() {
    String str2 = a.a();
    String str1 = str2;
    if (str2 == null)
      str1 = b.a(); 
    return str1;
  }
  
  public h a(List<a> paramList) {
    boolean bool1;
    boolean bool = j.a();
    String str2 = null;
    if (!bool)
      return null; 
    JSONObject jSONObject = new JSONObject();
    boolean bool2 = false;
    try {
      a(paramList.get(0));
      jSONObject.put("header", f());
      JSONArray jSONArray = new JSONArray();
      Iterator<a> iterator = paramList.iterator();
      while (iterator.hasNext())
        jSONArray.put(((a)iterator.next()).b); 
      jSONObject.put("event", jSONArray);
      jSONObject.put("_gen_time", System.currentTimeMillis());
    } catch (JSONException jSONException) {}
    String str3 = a.a(jSONObject.toString(), b.b());
    String str1 = str3;
    if (!b(str3))
      str1 = jSONObject.toString(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("adevent is :");
    stringBuilder.append(jSONObject.toString());
    t.b("adevent", stringBuilder.toString());
    Map<String, String> map = c(str1);
    i i = i.a();
    (new f(this, 1, ah.g(), str1, (n.a)i, map) {
        public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
          return this.c;
        }
      }).setRetryPolicy((d)e.b().a(10000)).setUserAgent(r.a).build(e.a(this.a).d());
    try {
      n n = i.b();
    } finally {
      str1 = null;
    } 
    if (str1 != null) {
      bool1 = (int)((n)str1).h;
    } else {
      bool1 = false;
    } 
    if (!bool && bool1 == 'È') {
      str1 = "server say not success";
      bool2 = true;
    } else if (str1 != null && ((n)str1).c != null) {
      str1 = ((n)str1).c.getMessage();
    } else {
      str1 = "error unknown";
    } 
    return new h(bool, bool1, str1, bool2);
  }
  
  public h a(JSONObject paramJSONObject) {
    if (!j.a())
      return null; 
    if (paramJSONObject != null) {
      boolean bool2;
      boolean bool3;
      String str2;
      if (paramJSONObject.length() <= 0)
        return null; 
      i i1 = i.a();
      paramJSONObject = ah.a(paramJSONObject);
      String str3 = ah.q("/api/ad/union/sdk/stats/batch/");
      boolean bool1 = true;
      (new f(1, str3, paramJSONObject, (n.a)i1)).setRetryPolicy((d)e.b().a(10000)).setUserAgent(r.a).build(e.a(this.a).d());
      String str1 = "error unknown";
      int j = 0;
      int i = 0;
      try {
        n n = i1.b();
      } finally {
        i1 = null;
        bool3 = false;
        bool2 = false;
      } 
      return new h(bool2, i, str2, bool3);
    } 
    return null;
  }
  
  public o a() {
    boolean bool = j.a();
    o o2 = null;
    if (!bool)
      return null; 
    i i = i.a();
    (new j(0, "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json", (n.a)i)).setRetryPolicy((d)e.b().a(10000)).setShouldCache(false).build(e.a(this.a).d());
    try {
      n n = i.b();
    } catch (Exception exception) {
      exception = null;
    } 
    o o1 = o2;
    if (exception != null) {
      o1 = o2;
      if (exception.a())
        o1 = o.d((String)((n)exception).a); 
    } 
    return o1;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Bitmap paramBitmap) {
    // Byte code:
    //   0: invokestatic a : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: aload #4
    //   9: ifnonnull -> 13
    //   12: return
    //   13: new org/json/JSONObject
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: astore #5
    //   22: new java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial <init> : ()V
    //   29: astore #6
    //   31: aload #6
    //   33: aload_2
    //   34: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload #6
    //   40: ldc_w ':'
    //   43: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload #6
    //   49: iload_1
    //   50: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload #6
    //   56: ldc_w ':'
    //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload #6
    //   65: aload_3
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload #6
    //   72: invokevirtual toString : ()Ljava/lang/String;
    //   75: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   78: astore #6
    //   80: aload #5
    //   82: ldc_w 'rit'
    //   85: iload_1
    //   86: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   89: pop
    //   90: aload #5
    //   92: ldc_w 'req_id'
    //   95: aload_2
    //   96: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   99: pop
    //   100: aload #5
    //   102: ldc_w 'ad_id'
    //   105: aload_3
    //   106: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   109: pop
    //   110: aload #5
    //   112: ldc_w 'sign'
    //   115: aload #6
    //   117: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   120: pop
    //   121: aload #5
    //   123: ldc_w 'image'
    //   126: aload #4
    //   128: invokestatic a : (Landroid/graphics/Bitmap;)Ljava/lang/String;
    //   131: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   134: pop
    //   135: new com/bytedance/sdk/adnet/b/f
    //   138: dup
    //   139: iconst_1
    //   140: ldc_w '/union/service/sdk/upload/v2/'
    //   143: invokestatic q : (Ljava/lang/String;)Ljava/lang/String;
    //   146: aload #5
    //   148: invokestatic a : (Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   151: aconst_null
    //   152: invokespecial <init> : (ILjava/lang/String;Lorg/json/JSONObject;Lcom/bytedance/sdk/adnet/core/n$a;)V
    //   155: invokestatic b : ()Lcom/bytedance/sdk/adnet/core/e;
    //   158: sipush #10000
    //   161: invokevirtual a : (I)Lcom/bytedance/sdk/adnet/core/e;
    //   164: invokevirtual setRetryPolicy : (Lcom/bytedance/sdk/adnet/face/d;)Lcom/bytedance/sdk/adnet/core/Request;
    //   167: iconst_0
    //   168: invokevirtual setShouldCache : (Z)Lcom/bytedance/sdk/adnet/core/Request;
    //   171: aload_0
    //   172: getfield a : Landroid/content/Context;
    //   175: invokestatic a : (Landroid/content/Context;)Lcom/bytedance/sdk/openadsdk/g/e;
    //   178: invokevirtual d : ()Lcom/bytedance/sdk/adnet/core/m;
    //   181: invokevirtual build : (Lcom/bytedance/sdk/adnet/core/m;)V
    //   184: aload #4
    //   186: invokevirtual isRecycled : ()Z
    //   189: ifne -> 197
    //   192: aload #4
    //   194: invokevirtual recycle : ()V
    //   197: return
    //   198: astore_2
    //   199: goto -> 135
    //   202: astore_2
    //   203: return
    // Exception table:
    //   from	to	target	type
    //   22	135	198	finally
    //   184	197	202	finally
  }
  
  public void a(AdSlot paramAdSlot, l paraml, int paramInt, p.b paramb) {
    if (!j.a()) {
      if (paramb != null)
        paramb.a(1000, "广告请求开关已关闭,请联系穿山甲管理员"); 
      return;
    } 
    i.a(null).c();
    f.a().b();
    b.a().b();
    if (paramb == null)
      return; 
    if (a(paramAdSlot.getCodeId())) {
      paramb.a(-8, g.a(-8));
      return;
    } 
    JSONObject jSONObject = a(paramAdSlot, paraml, paramInt);
    if (jSONObject == null) {
      paramb.a(-9, g.a(-9));
      return;
    } 
    (new f(this, 1, ah.q("/api/ad/union/sdk/get_ads/"), jSONObject, new n.a<JSONObject>(this, paramb, paramAdSlot, paramInt, paraml) {
          public void a(n<JSONObject> param1n) {
            boolean bool;
            long l1;
            try {
            
            } finally {
              Exception exception = null;
              l1 = 0L;
            } 
            long l2 = System.currentTimeMillis();
            JSONObject jSONObject = q.a(this.e, (JSONObject)param1n.a);
            if (jSONObject == null) {
              q.a(this.e, this.a);
              q.a(this.e, param1n.e, this.b.getCodeId(), this.c, null, -1, "mate parse_fail");
              return;
            } 
            try {
              q.a a1 = q.a.a(jSONObject, this.b);
              j.a(q.a(this.e), a1.i);
              if (a1.d != 20000)
                return; 
              if (a1.h == null)
                return; 
              a1.h.c(jSONObject.toString());
            } finally {
              Exception exception = null;
              t.c("NetApiImpl", "get ad error: ", exception);
              q.a(this.e, this.a);
            } 
          }
          
          public void b(n<JSONObject> param1n) {
            byte b1;
            VAdError vAdError = param1n.c;
            if (vAdError instanceof com.bytedance.sdk.adnet.err.e) {
              q.a(this.e, this.a);
              q.a(this.e, param1n.e, this.b.getCodeId(), this.c, null, -1, g.a(-1));
              return;
            } 
            String str = g.a(-2);
            if (vAdError != null && param1n != null) {
              b1 = (int)param1n.h;
              str = vAdError.getMessage();
            } else {
              b1 = -2;
            } 
            this.a.a(b1, str);
            if (vAdError instanceof com.bytedance.sdk.adnet.err.g)
              str = "SocketTimeout"; 
            q.a(this.e, param1n.e, this.b.getCodeId(), this.c, null, b1, str);
          }
        }jSONObject) {
        public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          hashMap.put("ss-sign", s.b(j.a(q.a(this.d))).d(this.c.toString()));
          return (Map)hashMap;
        }
      }).setRetryPolicy((d)e.b().a(a(paramInt)).b(0)).setUserAgent(r.a).setShouldCache(false).addExtra("extra_time_start", Long.valueOf(System.currentTimeMillis())).build(e.a(this.a).e());
  }
  
  public void a(k paramk, List<FilterWord> paramList) {
    if (!j.a())
      return; 
    JSONObject jSONObject = b(paramk, paramList);
    if (jSONObject == null)
      return; 
    (new h(1, ah.q("/api/ad/union/dislike_event/"), ah.a(jSONObject), null)).setRetryPolicy((d)e.b().a(10000)).build(e.a(this.a).d());
  }
  
  public void a(String paramString1, String paramString2, p.a parama) {
    if (!j.a()) {
      if (parama != null)
        parama.a(false, -1L, 0L); 
      return;
    } 
    if (paramString1 != null && paramString2 != null) {
      if (parama == null)
        return; 
      JSONObject jSONObject = a(paramString1, paramString2);
      (new f(1, ah.q("/api/ad/union/sdk/material/check/"), ah.a(jSONObject), new n.a<JSONObject>(this, parama) {
            public void a(n<JSONObject> param1n) {
              long l1;
              long l2;
              boolean bool;
              if (param1n.a != null) {
                q.b b = q.b.a((JSONObject)param1n.a);
                l1 = b.a;
                l2 = param1n.f;
                bool = b.b;
              } else {
                l1 = -1L;
                l2 = 0L;
                bool = false;
              } 
              this.a.a(bool, l1, l2);
            }
            
            public void b(n<JSONObject> param1n) {
              long l;
              if (param1n.h != 0L) {
                l = param1n.h;
              } else {
                l = -1L;
              } 
              this.a.a(false, l, param1n.f);
            }
          })).setRetryPolicy((d)e.b().a(800)).build(e.a(this.a).d());
    } 
  }
  
  public void a(JSONObject paramJSONObject, p.c paramc) {
    if (!j.a()) {
      if (paramc != null)
        paramc.a(1000, "广告请求开关已关闭,请联系穿山甲管理员"); 
      return;
    } 
    if (paramJSONObject != null) {
      if (paramc == null)
        return; 
      paramJSONObject = ah.a(paramJSONObject);
      (new f(1, ah.q("/api/ad/union/sdk/reward_video/reward/"), paramJSONObject, new n.a<JSONObject>(this, paramc) {
            public void a(n<JSONObject> param1n) {
              if (param1n != null && param1n.a != null) {
                String str1;
                int i = ((JSONObject)param1n.a).optInt("cypher", -1);
                String str2 = ((JSONObject)param1n.a).optString("message");
                JSONObject jSONObject2 = (JSONObject)param1n.a;
                param1n = null;
                if (i == 1) {
                  str1 = a.b(str2, b.a());
                } else if (i == 2) {
                  str1 = ah.k(str2);
                } 
                JSONObject jSONObject1 = jSONObject2;
                if (!TextUtils.isEmpty(str1))
                  try {
                    jSONObject1 = new JSONObject(str1);
                  } finally {
                    str1 = null;
                  }  
                q.c c1 = q.c.a(jSONObject1);
                if (c1.a != 20000) {
                  this.a.a(c1.a, g.a(c1.a));
                  return;
                } 
                if (c1.c == null) {
                  q.a(this.b, this.a);
                  return;
                } 
                this.a.a(c1);
                return;
              } 
              q.a(this.b, this.a);
            }
            
            public void b(n<JSONObject> param1n) {
              int i = -2;
              String str2 = g.a(-2);
              if (param1n != null)
                i = (int)param1n.h; 
              String str1 = str2;
              if (param1n != null) {
                str1 = str2;
                if (param1n.c != null)
                  str1 = param1n.c.getMessage(); 
              } 
              this.a.a(i, str1);
            }
          })).setRetryPolicy((d)e.b().a(10000)).build(e.a(this.a).d());
    } 
  }
  
  public boolean a(JSONObject paramJSONObject, int paramInt) {
    boolean bool = j.a();
    boolean bool1 = false;
    if (!bool)
      return false; 
    if (paramJSONObject != null) {
      if (paramJSONObject.length() <= 0)
        return true; 
      i i = i.a();
      (new f(1, "https://i.snssdk.com/inspect/aegis/client/page/", paramJSONObject, (n.a)i)).setRetryPolicy((d)e.b().a(10000).b(paramInt)).build(e.a(this.a).d());
      try {
        n n = i.b();
        bool = bool1;
        return bool;
      } finally {
        paramJSONObject = null;
      } 
    } 
    return true;
  }
  
  public static class a {
    final int a;
    
    final long b;
    
    final long c;
    
    final int d;
    
    final String e;
    
    final int f;
    
    final String g;
    
    public final a h;
    
    final String i;
    
    private a(String param1String1, int param1Int1, int param1Int2, String param1String2, int param1Int3, String param1String3, a param1a, long param1Long1, long param1Long2) {
      this.a = param1Int1;
      this.d = param1Int2;
      this.e = param1String2;
      this.g = param1String3;
      this.h = param1a;
      this.i = param1String1;
      this.f = param1Int3;
      this.b = param1Long1;
      this.c = param1Long2;
    }
    
    public static a a(JSONObject param1JSONObject) {
      return a(param1JSONObject, null);
    }
    
    public static a a(JSONObject param1JSONObject, AdSlot param1AdSlot) {
      String str1 = param1JSONObject.optString("did");
      int i = param1JSONObject.optInt("processing_time_ms");
      long l1 = param1JSONObject.optLong("s_receive_ts");
      long l2 = param1JSONObject.optLong("s_send_ts");
      int j = param1JSONObject.optInt("status_code");
      String str2 = param1JSONObject.optString("desc");
      String str3 = param1JSONObject.optString("request_id");
      int k = param1JSONObject.optInt("reason");
      a a1 = c.a(param1JSONObject, param1AdSlot);
      if (a1 != null)
        a1.a(param1JSONObject.optLong("request_after")); 
      return new a(str1, i, j, str2, k, str3, a1, l1, l2);
    }
  }
  
  public static class b {
    public final int a;
    
    public final boolean b;
    
    private b(int param1Int, boolean param1Boolean) {
      this.a = param1Int;
      this.b = param1Boolean;
    }
    
    public static b a(JSONObject param1JSONObject) {
      return (param1JSONObject == null) ? null : new b(param1JSONObject.optInt("error_code"), param1JSONObject.optBoolean("result"));
    }
  }
  
  public static class c {
    public final int a;
    
    public final boolean b;
    
    public final q c;
    
    private c(int param1Int, boolean param1Boolean, q param1q) {
      this.a = param1Int;
      this.b = param1Boolean;
      this.c = param1q;
    }
    
    public static c a(JSONObject param1JSONObject) {
      if (param1JSONObject == null)
        return null; 
      int i = param1JSONObject.optInt("code");
      boolean bool = param1JSONObject.optBoolean("verify");
      JSONObject jSONObject = param1JSONObject.optJSONObject("data");
      q q1 = new q();
      if (jSONObject != null)
        try {
          q1.a(jSONObject.optInt("reason"));
          q1.b(jSONObject.optInt("corp_type"));
          q1.c(jSONObject.optInt("reward_amount"));
          q1.a(jSONObject.optString("reward_name"));
        } finally {
          jSONObject = null;
        }  
      return new c(i, bool, q1);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */