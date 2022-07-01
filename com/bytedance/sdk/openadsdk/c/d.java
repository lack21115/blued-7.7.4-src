package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.d.e;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.dislike.a;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.i;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
  public static void a(Context paramContext, long paramLong, k paramk) {
    if (paramContext != null) {
      if (paramk == null)
        return; 
      JSONObject jSONObject = new JSONObject();
      try {
        JSONObject jSONObject1 = new JSONObject();
        jSONObject1.put("skip_duration", paramLong);
        jSONObject.put("ad_extra_data", jSONObject1.toString());
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      c(paramContext, paramk, "splash_ad", "skip", jSONObject);
    } 
  }
  
  public static void a(Context paramContext, k paramk) {
    c(paramContext, paramk, "install_warn", "install_again");
  }
  
  public static void a(Context paramContext, k paramk, String paramString) {
    c(paramContext, paramk, paramString, "click_close");
  }
  
  public static void a(Context paramContext, k paramk, String paramString1, String paramString2) {
    c(paramContext, paramk, paramString1, paramString2);
  }
  
  public static void a(Context paramContext, k paramk, String paramString1, String paramString2, int paramInt) {
    if (paramk != null) {
      if (paramContext == null)
        return; 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("color_percent", Integer.valueOf(paramInt));
      if (paramk.z() != null)
        hashMap.put("playable_url", paramk.z().h()); 
      hashMap.put("memory_total", Integer.valueOf(ah.h()));
      hashMap.put("memory_use", Integer.valueOf(ah.j() - ah.i()));
      hashMap.put("request_id", ah.h(paramk.P()));
      hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
      r(paramContext, paramk, paramString1, paramString2, (Map)hashMap);
    } 
  }
  
  public static void a(Context paramContext, k paramk, String paramString1, String paramString2, int paramInt, String paramString3, Map<String, Object> paramMap) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("fail_status", paramInt);
      jSONObject.put("fail_msg", paramString3);
      if (paramMap != null) {
        JSONObject jSONObject1 = new JSONObject();
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue()); 
        jSONObject.put("ad_extra_data", jSONObject1.toString());
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    c(paramContext, paramk, paramString1, paramString2, jSONObject);
  }
  
  public static void a(Context paramContext, k paramk, String paramString1, String paramString2, int paramInt, Map<String, Object> paramMap) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("ext_value", paramInt);
      JSONObject jSONObject1 = new JSONObject();
      if (paramMap != null)
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue());  
      jSONObject.put("ad_extra_data", jSONObject1.toString());
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    c(paramContext, paramk, paramString1, paramString2, jSONObject);
  }
  
  public static void a(Context paramContext, k paramk, String paramString1, String paramString2, long paramLong, int paramInt, Map<String, Object> paramMap) {
    JSONObject jSONObject1 = new JSONObject();
    JSONObject jSONObject2 = new JSONObject();
    try {
      jSONObject1.put("duration", paramLong);
      jSONObject1.put("percent", paramInt);
      if (paramMap != null)
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject2.put((String)entry.getKey(), entry.getValue());  
      jSONObject1.put("ad_extra_data", jSONObject2.toString());
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    c(paramContext, paramk, paramString1, paramString2, jSONObject1);
  }
  
  public static void a(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    JSONObject jSONObject = new JSONObject();
    if (paramMap != null && paramMap.size() > 0) {
      try {
        JSONObject jSONObject1 = new JSONObject();
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue()); 
        jSONObject.put("ad_extra_data", jSONObject1.toString());
      } catch (Exception exception) {}
      c(paramContext, paramk, paramString1, paramString2, jSONObject);
      return;
    } 
    c(paramContext, paramk, paramString1, paramString2);
  }
  
  public static void a(Context paramContext, k paramk, String paramString1, String paramString2, JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("ad_extra_data", paramJSONObject.toString());
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      c(paramContext, paramk, paramString1, paramString2, jSONObject);
      return;
    } 
    c(paramContext, paramk, paramString1, paramString2);
  }
  
  public static void a(Context paramContext, k paramk, String paramString, Map<String, Object> paramMap) {
    Context context;
    if (paramContext == null) {
      context = o.a();
    } else {
      context = paramContext;
    } 
    JSONObject jSONObject = new JSONObject();
    try {
      boolean bool;
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("device", i.d(context).toString());
      if (paramk.V()) {
        bool = true;
      } else {
        bool = false;
      } 
      jSONObject1.put("is_cache", bool);
      if (paramMap != null)
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue());  
      jSONObject.put("ad_extra_data", jSONObject1.toString());
      jSONObject.putOpt("log_extra", paramk.P());
      float f = Double.valueOf((System.currentTimeMillis() / 1000L) - ah.g(paramk.P())).floatValue();
      if (f <= 0.0F)
        f = 0.0F; 
      jSONObject.putOpt("show_time", Float.valueOf(f));
    } catch (JSONException jSONException) {}
    a a = a.a(context, paramString, "show", paramk.M(), jSONObject);
    o.c().a(a);
    String str = j.a(o.a());
    if (!TextUtils.isEmpty(str)) {
      List list = paramk.H();
      o.g().a(str, list, true);
    } 
    if (t.c()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("show ");
      stringBuilder.append(paramk.M());
      t.c("AdEvent", stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(j.a(paramContext)))
      s.b(j.a(paramContext)).c("AdShow"); 
  }
  
  public static void a(Context paramContext, String paramString, long paramLong) {
    c.a(paramContext, paramString, paramLong);
  }
  
  public static void a(Context paramContext, String paramString1, k paramk, e parame, String paramString2, boolean paramBoolean, Map<String, Object> paramMap) {
    // Byte code:
    //   0: aload_0
    //   1: astore #8
    //   3: aload_0
    //   4: ifnonnull -> 12
    //   7: invokestatic a : ()Landroid/content/Context;
    //   10: astore #8
    //   12: new org/json/JSONObject
    //   15: dup
    //   16: invokespecial <init> : ()V
    //   19: astore_0
    //   20: aload_3
    //   21: ifnull -> 131
    //   24: aload_3
    //   25: invokevirtual a : ()Lorg/json/JSONObject;
    //   28: astore_3
    //   29: aload_3
    //   30: ldc 'device'
    //   32: aload #8
    //   34: invokestatic d : (Landroid/content/Context;)Lorg/json/JSONObject;
    //   37: invokevirtual toString : ()Ljava/lang/String;
    //   40: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload_3
    //   45: ldc_w 'is_valid'
    //   48: iload #5
    //   50: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   53: pop
    //   54: aload #6
    //   56: ifnull -> 120
    //   59: aload #6
    //   61: invokeinterface entrySet : ()Ljava/util/Set;
    //   66: invokeinterface iterator : ()Ljava/util/Iterator;
    //   71: astore #6
    //   73: aload #6
    //   75: invokeinterface hasNext : ()Z
    //   80: ifeq -> 120
    //   83: aload #6
    //   85: invokeinterface next : ()Ljava/lang/Object;
    //   90: checkcast java/util/Map$Entry
    //   93: astore #9
    //   95: aload_3
    //   96: aload #9
    //   98: invokeinterface getKey : ()Ljava/lang/Object;
    //   103: checkcast java/lang/String
    //   106: aload #9
    //   108: invokeinterface getValue : ()Ljava/lang/Object;
    //   113: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   116: pop
    //   117: goto -> 73
    //   120: aload_0
    //   121: ldc 'ad_extra_data'
    //   123: aload_3
    //   124: invokevirtual toString : ()Ljava/lang/String;
    //   127: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   130: pop
    //   131: aload_0
    //   132: ldc 'log_extra'
    //   134: aload_2
    //   135: invokevirtual P : ()Ljava/lang/String;
    //   138: invokevirtual putOpt : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   141: pop
    //   142: invokestatic currentTimeMillis : ()J
    //   145: ldc2_w 1000
    //   148: ldiv
    //   149: l2d
    //   150: aload_2
    //   151: invokevirtual P : ()Ljava/lang/String;
    //   154: invokestatic g : (Ljava/lang/String;)D
    //   157: dsub
    //   158: invokestatic valueOf : (D)Ljava/lang/Double;
    //   161: invokevirtual floatValue : ()F
    //   164: fstore #7
    //   166: fload #7
    //   168: fconst_0
    //   169: fcmpl
    //   170: ifle -> 304
    //   173: goto -> 176
    //   176: aload_0
    //   177: ldc 'show_time'
    //   179: fload #7
    //   181: invokestatic valueOf : (F)Ljava/lang/Float;
    //   184: invokevirtual putOpt : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   187: pop
    //   188: goto -> 191
    //   191: aload #8
    //   193: aload #4
    //   195: aload_1
    //   196: aload_2
    //   197: invokevirtual M : ()Ljava/lang/String;
    //   200: aload_0
    //   201: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/bytedance/sdk/openadsdk/c/a;
    //   204: astore_0
    //   205: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/c/b;
    //   208: aload_0
    //   209: invokevirtual a : (Lcom/bytedance/sdk/openadsdk/c/i;)V
    //   212: invokestatic a : ()Landroid/content/Context;
    //   215: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   218: astore_0
    //   219: aload_0
    //   220: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   223: ifne -> 252
    //   226: ldc_w 'click'
    //   229: aload_1
    //   230: invokevirtual equals : (Ljava/lang/Object;)Z
    //   233: ifeq -> 252
    //   236: aload_2
    //   237: invokevirtual I : ()Ljava/util/List;
    //   240: astore_3
    //   241: invokestatic g : ()Lcom/bytedance/sdk/openadsdk/j/a;
    //   244: aload_0
    //   245: aload_3
    //   246: iconst_1
    //   247: invokeinterface a : (Ljava/lang/String;Ljava/util/List;Z)V
    //   252: invokestatic c : ()Z
    //   255: ifeq -> 299
    //   258: new java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial <init> : ()V
    //   265: astore_0
    //   266: aload_0
    //   267: aload_1
    //   268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload_0
    //   273: ldc_w ' '
    //   276: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload_0
    //   281: aload_2
    //   282: invokevirtual M : ()Ljava/lang/String;
    //   285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: ldc_w 'AdEvent'
    //   292: aload_0
    //   293: invokevirtual toString : ()Ljava/lang/String;
    //   296: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   299: return
    //   300: astore_3
    //   301: goto -> 191
    //   304: fconst_0
    //   305: fstore #7
    //   307: goto -> 176
    // Exception table:
    //   from	to	target	type
    //   24	54	300	org/json/JSONException
    //   59	73	300	org/json/JSONException
    //   73	117	300	org/json/JSONException
    //   120	131	300	org/json/JSONException
    //   131	166	300	org/json/JSONException
    //   176	188	300	org/json/JSONException
  }
  
  public static void a(k paramk) {}
  
  public static void a(k paramk, String paramString1, String paramString2, long paramLong) {
    JSONObject jSONObject = new JSONObject();
    try {
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("device", i.d(o.a()).toString());
      if (paramString2.equals("download_creative_duration")) {
        jSONObject1.put("download_creative_duration", paramLong);
      } else if (paramString2.equals("load_ad_duration")) {
        jSONObject1.put("load_ad_duration", paramLong);
      } 
      jSONObject.put("ad_extra_data", jSONObject1.toString());
      jSONObject.putOpt("log_extra", paramk.P());
    } catch (JSONException jSONException) {}
    a a = a.a(o.a(), paramString1, paramString2, paramk.M(), jSONObject);
    o.c().a(a);
  }
  
  public static void a(k paramk, String paramString, Map<String, Object> paramMap) {
    Context context = o.a();
    JSONObject jSONObject = new JSONObject();
    if (paramMap != null && paramMap.size() > 0) {
      try {
        JSONObject jSONObject1 = new JSONObject();
        jSONObject1.put("device", i.d(context).toString());
        Object object = paramMap.remove("total_time");
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue()); 
        boolean bool = object instanceof Long;
        if (bool) {
          jSONObject.put("duration", object);
        } else {
          jSONObject.put("duration", 0);
        } 
        jSONObject.put("ad_extra_data", jSONObject1.toString());
      } catch (Exception exception) {}
      c(context, paramk, paramString, "load_ad_duration", jSONObject);
      return;
    } 
    c(context, paramk, paramString, "load_ad_duration");
  }
  
  public static void a(k paramk, List<FilterWord> paramList) {
    a.a().a(paramk, paramList);
    if (t.c()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("tt_dislike_icon ");
      stringBuilder.append(paramk.M());
      t.c("AdEvent", stringBuilder.toString());
    } 
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      JSONObject jSONObject = new JSONObject();
      try {
        String str = paramJSONObject.optString("ad_extra_data", null);
        if (str != null)
          jSONObject = new JSONObject(str); 
        jSONObject.put("device", i.d(o.a()).toString());
        paramJSONObject.put("ad_extra_data", jSONObject.toString());
        paramJSONObject.put("tag", paramString2);
        if ("click".equals(paramString3)) {
          String str1 = paramJSONObject.optString("log_extra");
          float f = Double.valueOf((System.currentTimeMillis() / 1000L) - ah.g(str1)).floatValue();
          if (f <= 0.0F)
            f = 0.0F; 
          paramJSONObject.putOpt("show_time", Float.valueOf(f));
        } 
      } catch (JSONException jSONException) {}
    } 
    a a = a.a(paramString1, paramString2, paramString3, paramLong1, paramLong2, paramJSONObject);
    o.c().a(a);
    if (t.c())
      t.c("AdEvent", "sendJsAdEvent"); 
  }
  
  public static void b(Context paramContext, k paramk, String paramString1, String paramString2) {
    c(paramContext, paramk, paramString1, paramString2);
  }
  
  public static void b(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    JSONObject jSONObject = new JSONObject();
    if (paramMap != null && paramMap.size() > 0) {
      try {
        JSONObject jSONObject1 = new JSONObject();
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue()); 
        jSONObject.put("ad_extra_data", jSONObject1.toString());
      } catch (Exception exception) {}
      c(paramContext, paramk, paramString1, paramString2, jSONObject);
      return;
    } 
    c(paramContext, paramk, paramString1, paramString2);
  }
  
  public static void b(Context paramContext, k paramk, String paramString1, String paramString2, JSONObject paramJSONObject) {
    JSONObject jSONObject = paramJSONObject;
    if (paramJSONObject == null)
      jSONObject = new JSONObject(); 
    c(paramContext, paramk, paramString1, paramString2, jSONObject);
  }
  
  public static void b(Context paramContext, k paramk, String paramString, Map<String, Object> paramMap) {
    Context context = paramContext;
    if (paramContext == null)
      context = o.a(); 
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.putOpt("log_extra", paramk.P());
    } catch (Exception exception) {}
    a a = a.a(context, paramString, "render_h5_detect", paramk.M(), jSONObject);
    o.c().a(a);
  }
  
  private static void c(Context paramContext, k paramk, String paramString1, String paramString2) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.putOpt("log_extra", paramk.P());
    } catch (JSONException jSONException) {}
    a a = a.a(paramContext, paramString1, paramString2, paramk.M(), jSONObject);
    o.c().a(a);
    if (t.c()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("tag: ");
      stringBuilder.append(paramString1);
      stringBuilder.append("label: ");
      stringBuilder.append(paramString2);
      stringBuilder.append(" ");
      stringBuilder.append(paramk.M());
      t.c("AdEvent", stringBuilder.toString());
    } 
  }
  
  public static void c(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    JSONObject jSONObject = new JSONObject();
    if (paramMap != null && paramMap.size() > 0) {
      try {
        JSONObject jSONObject1 = new JSONObject();
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue()); 
        jSONObject.put("ad_extra_data", jSONObject1.toString());
      } catch (Exception exception) {}
      c(paramContext, paramk, paramString1, paramString2, jSONObject);
      return;
    } 
    c(paramContext, paramk, paramString1, paramString2);
  }
  
  private static void c(Context paramContext, k paramk, String paramString1, String paramString2, JSONObject paramJSONObject) {
    if (paramk == null)
      return; 
    if (paramJSONObject != null)
      try {
        paramJSONObject.putOpt("log_extra", paramk.P());
      } catch (JSONException jSONException) {} 
    a a = a.a(paramContext, paramString1, paramString2, paramk.M(), paramJSONObject);
    o.c().a(a);
    if (t.c()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("tag: ");
      stringBuilder.append(paramString1);
      stringBuilder.append("label: ");
      stringBuilder.append(paramString2);
      stringBuilder.append(" ");
      stringBuilder.append(paramk.M());
      t.c("AdEvent", stringBuilder.toString());
    } 
  }
  
  public static void c(Context paramContext, k paramk, String paramString, Map<String, Object> paramMap) {
    JSONObject jSONObject = new JSONObject();
    if (paramMap != null && paramMap.size() > 0) {
      try {
        JSONObject jSONObject1 = new JSONObject();
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue()); 
        jSONObject.put("ad_extra_data", jSONObject1.toString());
      } catch (Exception exception) {}
      c(paramContext, paramk, "install_warn", paramString, jSONObject);
      return;
    } 
    c(paramContext, paramk, "install_warn", paramString);
  }
  
  public static void d(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    if (paramMap != null && paramMap.size() > 0) {
      JSONObject jSONObject = new JSONObject();
      try {
        JSONObject jSONObject1 = new JSONObject();
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue()); 
        jSONObject.put("ad_extra_data", jSONObject1.toString());
      } catch (Exception exception) {}
      c(paramContext, paramk, paramString1, paramString2, jSONObject);
      return;
    } 
    c(paramContext, paramk, paramString1, paramString2);
  }
  
  public static void e(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    if (paramMap != null && paramMap.size() > 0) {
      JSONObject jSONObject = new JSONObject();
      try {
        JSONObject jSONObject1 = new JSONObject();
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue()); 
        jSONObject.put("ad_extra_data", jSONObject1.toString());
      } catch (Exception exception) {}
      c(paramContext, paramk, paramString1, paramString2, jSONObject);
      return;
    } 
    c(paramContext, paramk, paramString1, paramString2);
  }
  
  public static void f(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    if (paramMap != null && paramMap.size() > 0) {
      JSONObject jSONObject = new JSONObject();
      try {
        JSONObject jSONObject1 = new JSONObject();
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue()); 
        jSONObject.put("ad_extra_data", jSONObject1.toString());
      } catch (Exception exception) {}
      c(paramContext, paramk, paramString1, paramString2, jSONObject);
      return;
    } 
    c(paramContext, paramk, paramString1, paramString2);
  }
  
  public static void g(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    if (paramMap != null && paramMap.size() > 0) {
      JSONObject jSONObject = new JSONObject();
      try {
        JSONObject jSONObject1 = new JSONObject();
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue()); 
        jSONObject.put("ad_extra_data", jSONObject1.toString());
      } catch (Exception exception) {}
      c(paramContext, paramk, paramString1, paramString2, jSONObject);
      return;
    } 
    c(paramContext, paramk, paramString1, paramString2);
  }
  
  public static void h(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    if (paramMap != null && paramMap.size() > 0) {
      JSONObject jSONObject = new JSONObject();
      try {
        JSONObject jSONObject1 = new JSONObject();
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue()); 
        jSONObject.put("ad_extra_data", jSONObject1.toString());
      } catch (Exception exception) {}
      c(paramContext, paramk, paramString1, paramString2, jSONObject);
      return;
    } 
    c(paramContext, paramk, paramString1, paramString2);
  }
  
  public static void i(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    JSONObject jSONObject = new JSONObject();
    try {
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("refer", "auto_control");
      if (paramMap != null && paramMap.size() > 0)
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue());  
      jSONObject.put("ad_extra_data", jSONObject1.toString());
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    c(paramContext, paramk, paramString1, paramString2, jSONObject);
  }
  
  public static void j(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    JSONObject jSONObject2 = new JSONObject();
    JSONObject jSONObject1 = new JSONObject();
    if (paramMap != null) {
      try {
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject2.put((String)entry.getKey(), entry.getValue()); 
      } finally {
        paramMap = null;
      } 
      c(paramContext, paramk, paramString1, paramString2, jSONObject1);
      return;
    } 
    jSONObject1.put("ad_extra_data", jSONObject2.toString());
  }
  
  public static void k(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    JSONObject jSONObject2 = new JSONObject();
    JSONObject jSONObject1 = new JSONObject();
    if (paramMap != null) {
      try {
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject2.put((String)entry.getKey(), entry.getValue()); 
      } finally {
        paramMap = null;
      } 
      c(paramContext, paramk, paramString1, paramString2, jSONObject1);
      return;
    } 
    jSONObject1.put("ad_extra_data", jSONObject2.toString());
  }
  
  public static void l(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    m(paramContext, paramk, paramString1, paramString2, paramMap);
  }
  
  public static void m(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    JSONObject jSONObject2 = new JSONObject();
    JSONObject jSONObject1 = new JSONObject();
    if (paramMap != null) {
      try {
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject2.put((String)entry.getKey(), entry.getValue()); 
      } finally {
        paramMap = null;
      } 
      c(paramContext, paramk, paramString1, paramString2, jSONObject1);
      return;
    } 
    jSONObject1.put("ad_extra_data", jSONObject2.toString());
  }
  
  public static void n(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    JSONObject jSONObject1 = new JSONObject();
    JSONObject jSONObject2 = new JSONObject();
    if (paramMap != null) {
      try {
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject2.put((String)entry.getKey(), entry.getValue()); 
        jSONObject1.put("ad_extra_data", jSONObject2.toString());
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      c(paramContext, paramk, paramString1, paramString2, jSONObject1);
      return;
    } 
    jSONObject1.put("ad_extra_data", jSONObject2.toString());
  }
  
  public static void o(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    JSONObject jSONObject1 = new JSONObject();
    JSONObject jSONObject2 = new JSONObject();
    if (paramMap != null) {
      try {
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject2.put((String)entry.getKey(), entry.getValue()); 
        jSONObject1.put("ad_extra_data", jSONObject2.toString());
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      c(paramContext, paramk, paramString1, paramString2, jSONObject1);
      return;
    } 
    jSONObject1.put("ad_extra_data", jSONObject2.toString());
  }
  
  public static void p(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    JSONObject jSONObject = new JSONObject();
    try {
      JSONObject jSONObject1 = new JSONObject();
      if (paramMap != null)
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue());  
      jSONObject.put("ad_extra_data", jSONObject1.toString());
    } catch (Exception exception) {}
    c(paramContext, paramk, paramString1, paramString2, jSONObject);
  }
  
  public static void q(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    JSONObject jSONObject = new JSONObject();
    try {
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("refer", paramString2);
      if (paramMap != null)
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue());  
      jSONObject.put("ad_extra_data", jSONObject1.toString());
    } finally {}
    c(paramContext, paramk, paramString1, "click_open", jSONObject);
  }
  
  public static void r(Context paramContext, k paramk, String paramString1, String paramString2, Map<String, Object> paramMap) {
    JSONObject jSONObject = new JSONObject();
    try {
      JSONObject jSONObject1 = new JSONObject();
      if (paramMap != null)
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          jSONObject1.put((String)entry.getKey(), entry.getValue());  
      jSONObject.put("ad_extra_data", jSONObject1.toString());
    } catch (Exception exception) {}
    c(paramContext, paramk, paramString1, paramString2, jSONObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */