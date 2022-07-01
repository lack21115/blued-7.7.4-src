package com.bytedance.sdk.adnet.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.d.d;
import org.json.JSONObject;

public class e {
  private static final Object d = new Object();
  
  private Context a;
  
  private d b;
  
  private boolean c = true;
  
  public e(Context paramContext, boolean paramBoolean) {
    this.a = paramContext;
    this.c = paramBoolean;
    this.b = new d();
  }
  
  private d b(JSONObject paramJSONObject) {
    // Byte code:
    //   0: new com/bytedance/sdk/adnet/c/d
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #5
    //   9: aload_1
    //   10: ldc 'local_enable'
    //   12: invokevirtual has : (Ljava/lang/String;)Z
    //   15: istore_3
    //   16: iconst_1
    //   17: istore #4
    //   19: iload_3
    //   20: ifeq -> 43
    //   23: aload_1
    //   24: ldc 'local_enable'
    //   26: invokevirtual getInt : (Ljava/lang/String;)I
    //   29: ifne -> 443
    //   32: iconst_0
    //   33: istore_3
    //   34: goto -> 37
    //   37: aload #5
    //   39: iload_3
    //   40: putfield a : Z
    //   43: aload_1
    //   44: ldc 'probe_enable'
    //   46: invokevirtual has : (Ljava/lang/String;)Z
    //   49: ifeq -> 72
    //   52: iload #4
    //   54: istore_3
    //   55: aload_1
    //   56: ldc 'probe_enable'
    //   58: invokevirtual getInt : (Ljava/lang/String;)I
    //   61: ifne -> 66
    //   64: iconst_0
    //   65: istore_3
    //   66: aload #5
    //   68: iload_3
    //   69: putfield b : Z
    //   72: aload_1
    //   73: ldc 'local_host_filter'
    //   75: invokevirtual has : (Ljava/lang/String;)Z
    //   78: ifeq -> 161
    //   81: aload_1
    //   82: ldc 'local_host_filter'
    //   84: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   87: astore #6
    //   89: new java/util/HashMap
    //   92: dup
    //   93: invokespecial <init> : ()V
    //   96: astore #7
    //   98: aload #6
    //   100: invokevirtual length : ()I
    //   103: ifle -> 151
    //   106: iconst_0
    //   107: istore_2
    //   108: iload_2
    //   109: aload #6
    //   111: invokevirtual length : ()I
    //   114: if_icmpge -> 151
    //   117: aload #6
    //   119: iload_2
    //   120: invokevirtual getString : (I)Ljava/lang/String;
    //   123: astore #8
    //   125: aload #8
    //   127: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   130: ifeq -> 136
    //   133: goto -> 448
    //   136: aload #7
    //   138: aload #8
    //   140: iconst_0
    //   141: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   144: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   147: pop
    //   148: goto -> 448
    //   151: aload #5
    //   153: aload #7
    //   155: putfield c : Ljava/util/Map;
    //   158: goto -> 167
    //   161: aload #5
    //   163: aconst_null
    //   164: putfield c : Ljava/util/Map;
    //   167: aload_1
    //   168: ldc 'host_replace_map'
    //   170: invokevirtual has : (Ljava/lang/String;)Z
    //   173: ifeq -> 283
    //   176: aload_1
    //   177: ldc 'host_replace_map'
    //   179: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   182: astore #6
    //   184: new java/util/HashMap
    //   187: dup
    //   188: invokespecial <init> : ()V
    //   191: astore #7
    //   193: aload #6
    //   195: invokevirtual length : ()I
    //   198: ifle -> 273
    //   201: aload #6
    //   203: invokevirtual keys : ()Ljava/util/Iterator;
    //   206: astore #8
    //   208: aload #8
    //   210: invokeinterface hasNext : ()Z
    //   215: ifeq -> 273
    //   218: aload #8
    //   220: invokeinterface next : ()Ljava/lang/Object;
    //   225: checkcast java/lang/String
    //   228: astore #9
    //   230: aload #6
    //   232: aload #9
    //   234: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   237: astore #10
    //   239: aload #9
    //   241: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   244: ifne -> 208
    //   247: aload #10
    //   249: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   252: ifeq -> 258
    //   255: goto -> 208
    //   258: aload #7
    //   260: aload #9
    //   262: aload #10
    //   264: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   269: pop
    //   270: goto -> 208
    //   273: aload #5
    //   275: aload #7
    //   277: putfield d : Ljava/util/Map;
    //   280: goto -> 289
    //   283: aload #5
    //   285: aconst_null
    //   286: putfield d : Ljava/util/Map;
    //   289: aload #5
    //   291: aload_1
    //   292: ldc 'req_to_cnt'
    //   294: aload #5
    //   296: getfield e : I
    //   299: invokevirtual optInt : (Ljava/lang/String;I)I
    //   302: putfield e : I
    //   305: aload #5
    //   307: aload_1
    //   308: ldc 'req_to_api_cnt'
    //   310: aload #5
    //   312: getfield f : I
    //   315: invokevirtual optInt : (Ljava/lang/String;I)I
    //   318: putfield f : I
    //   321: aload #5
    //   323: aload_1
    //   324: ldc 'req_to_ip_cnt'
    //   326: aload #5
    //   328: getfield g : I
    //   331: invokevirtual optInt : (Ljava/lang/String;I)I
    //   334: putfield g : I
    //   337: aload #5
    //   339: aload_1
    //   340: ldc 'req_err_cnt'
    //   342: aload #5
    //   344: getfield h : I
    //   347: invokevirtual optInt : (Ljava/lang/String;I)I
    //   350: putfield h : I
    //   353: aload #5
    //   355: aload_1
    //   356: ldc 'req_err_api_cnt'
    //   358: aload #5
    //   360: getfield i : I
    //   363: invokevirtual optInt : (Ljava/lang/String;I)I
    //   366: putfield i : I
    //   369: aload #5
    //   371: aload_1
    //   372: ldc 'req_err_ip_cnt'
    //   374: aload #5
    //   376: getfield j : I
    //   379: invokevirtual optInt : (Ljava/lang/String;I)I
    //   382: putfield j : I
    //   385: aload #5
    //   387: aload_1
    //   388: ldc 'update_interval'
    //   390: aload #5
    //   392: getfield k : I
    //   395: invokevirtual optInt : (Ljava/lang/String;I)I
    //   398: putfield k : I
    //   401: aload #5
    //   403: aload_1
    //   404: ldc 'update_random_range'
    //   406: aload #5
    //   408: getfield l : I
    //   411: invokevirtual optInt : (Ljava/lang/String;I)I
    //   414: putfield l : I
    //   417: aload #5
    //   419: aload_1
    //   420: ldc 'http_code_black'
    //   422: aload #5
    //   424: getfield m : Ljava/lang/String;
    //   427: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   430: putfield m : Ljava/lang/String;
    //   433: aload #5
    //   435: areturn
    //   436: astore_1
    //   437: aload_1
    //   438: invokevirtual printStackTrace : ()V
    //   441: aconst_null
    //   442: areturn
    //   443: iconst_1
    //   444: istore_3
    //   445: goto -> 37
    //   448: iload_2
    //   449: iconst_1
    //   450: iadd
    //   451: istore_2
    //   452: goto -> 108
    // Exception table:
    //   from	to	target	type
    //   0	16	436	finally
    //   23	32	436	finally
    //   37	43	436	finally
    //   43	52	436	finally
    //   55	64	436	finally
    //   66	72	436	finally
    //   72	106	436	finally
    //   108	133	436	finally
    //   136	148	436	finally
    //   151	158	436	finally
    //   161	167	436	finally
    //   167	208	436	finally
    //   208	255	436	finally
    //   258	270	436	finally
    //   273	280	436	finally
    //   283	289	436	finally
    //   289	433	436	finally
  }
  
  public void a() {
    if (!this.c)
      return; 
    String str = this.a.getSharedPreferences("ttnet_tnc_config", 0).getString("tnc_config_str", null);
    if (TextUtils.isEmpty(str)) {
      d.b("TNCConfigHandler", "loadLocalConfig: no existed");
      return;
    } 
    try {
      d d1 = b(new JSONObject(str));
      return;
    } finally {
      str = null;
      str.printStackTrace();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("loadLocalConfig: except: ");
      stringBuilder.append(str.getMessage());
      d.b("TNCConfigHandler", stringBuilder.toString());
    } 
  }
  
  public void a(JSONObject paramJSONObject) {
    if (!this.c) {
      d.b("TNCConfigHandler", "handleConfigChanged: no mainProc");
      return;
    } 
    f.a().b();
  }
  
  public void b() {
    try {
      String str = com.bytedance.sdk.adnet.d.e.a(this.a, 1);
      if (TextUtils.isEmpty(str))
        return; 
      d d1 = b(new JSONObject(str));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("loadLocalConfigForOtherProcess, config: ");
    } finally {
      Exception exception = null;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("loadLocalConfigForOtherProcess, except: ");
      stringBuilder.append(exception.getMessage());
    } 
  }
  
  public d c() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */