package com.qq.e.comm.plugin.ad;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.ads.cfg.SDKSrcConfig;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.a;
import com.qq.e.comm.plugin.e.a;
import com.qq.e.comm.plugin.f.a;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.util.aa;
import com.qq.e.comm.plugin.util.ad;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.b;
import com.qq.e.comm.plugin.util.bd;
import com.qq.e.comm.plugin.util.bg;
import com.qq.e.comm.plugin.util.bj;
import com.qq.e.comm.plugin.util.h;
import com.qq.e.comm.plugin.util.m;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.x;
import com.qq.e.comm.plugin.util.z;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.zip.CRC32;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.gdtadv;

public class c {
  private static volatile String a;
  
  private static final Random b = new Random(System.currentTimeMillis());
  
  private static int a(b paramb) {
    int i = paramb.i();
    null = e.x.b();
    boolean bool = false;
    if (i == null)
      return 0; 
    if (GDTADManager.getInstance().getSM().getInteger("rewardEndCardLandingPageLandscape", 0) == 1) {
      i = 1;
    } else {
      i = 0;
    } 
    null = bool;
    if (GDTADManager.getInstance().getSM().getInteger("rewardEndCardLandingPage", 1) == 1) {
      if (i == 0) {
        null = bool;
        return "p".equals(GDTADManager.getInstance().getDeviceStatus().getScreenOrientation()) ? 1 : null;
      } 
    } else {
      return null;
    } 
    return 1;
  }
  
  public static d a(e parame, int paramInt) {
    int i = null.a[parame.ordinal()];
    return (i != 1) ? ((i != 2) ? ((i != 3) ? ((i != 4) ? ((i != 5) ? null : d.j) : ((paramInt >= 320) ? d.i : d.h)) : d.g) : ((paramInt >= 320) ? d.f : d.e)) : ((paramInt < 160) ? d.a : ((paramInt >= 160 && paramInt < 240) ? d.b : ((paramInt >= 240 && paramInt < 320) ? d.c : d.d)));
  }
  
  private static String a(JSONObject paramJSONObject, b paramb) {
    String str2 = paramJSONObject.optString("sdkver");
    String str3 = paramJSONObject.optString("c_os");
    String str4 = paramJSONObject.optString("muidtype");
    String str5 = paramJSONObject.optString("muid");
    String str6 = paramJSONObject.optString("c_pkgname");
    int i = paramJSONObject.optInt("postype");
    String str1 = paramb.c();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str2);
    stringBuilder2.append(str3);
    stringBuilder2.append(str4);
    stringBuilder2.append(str5);
    stringBuilder2.append(str6);
    stringBuilder2.append(i);
    stringBuilder2.append(str1);
    str1 = stringBuilder2.toString();
    CRC32 cRC32 = new CRC32();
    cRC32.update(str1.getBytes(a.a));
    str1 = Long.toHexString(cRC32.getValue());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("0001");
    stringBuilder1.append(str1);
    return stringBuilder1.toString();
  }
  
  public static Map<String, String> a(e parame, GDTADManager paramGDTADManager, b paramb) throws JSONException {
    parame.b("adposcount", String.valueOf(paramb.d()));
    parame.b("count", String.valueOf(paramb.e()));
    parame.b("posid", paramb.c());
    if (paramb.i() == e.j.b()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramb.n());
      stringBuilder.append("");
      parame.b("page_number", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramb.o());
      stringBuilder.append("");
      parame.b("is_manual_operation", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramb.p());
      stringBuilder.append("");
      parame.b("channel", stringBuilder.toString());
    } 
    if (paramb.i() == e.d.b())
      parame.b("spsa", "1"); 
    if (paramb.i() == e.j.b())
      parame.b("support_content_ad", "1"); 
    int i = paramb.g();
    int j = paramb.h();
    if (i > 0 && j > 0) {
      parame.b("posw", String.valueOf(paramb.g()));
      parame.b("posh", String.valueOf(paramb.h()));
    } 
    if (paramb.i() == e.i.b()) {
      parame.b("template_count", String.valueOf(1));
      parame.b("actual_width", String.valueOf(paramb.a()));
      parame.b("actual_height", String.valueOf(paramb.b()));
    } 
    if (paramb.f() > 0)
      parame.b("datatype", String.valueOf(paramb.f())); 
    if (paramb.l() > 0)
      parame.b("reqtype", String.valueOf(paramb.l())); 
    if (paramb.u() > 0)
      parame.b("flow_source", String.valueOf(paramb.u())); 
    if (paramb.x() != null && paramb.x().getValue() > 0)
      parame.b("login_type", String.valueOf(paramb.x().getValue())); 
    if (!TextUtils.isEmpty(paramb.y()))
      parame.b("login_appid", paramb.y()); 
    if (!TextUtils.isEmpty(paramb.v()))
      parame.b("login_openid", paramb.v()); 
    if (!TextUtils.isEmpty(paramb.w()))
      parame.b("uin", paramb.w()); 
    if (paramGDTADManager.getSM().getInteger("flow_control", 0) == 1)
      parame.b("fc", "1"); 
    if (paramGDTADManager.getSM().getInteger("support_https", 0) == 1)
      parame.b("support_https", "1"); 
    parame.b("ext", a(paramGDTADManager, parame, paramb).toString());
    JSONObject jSONObject = b(paramGDTADManager, parame, paramb);
    if (jSONObject != null)
      parame.b("outerext", jSONObject.toString()); 
    parame.b("r", String.valueOf(Math.random()));
    if (!TextUtils.isEmpty(b.a(GDTADManager.getInstance().getAppContext())))
      parame.b("last_ads", b.a(GDTADManager.getInstance().getAppContext())); 
    if (a.a != null && !TextUtils.isEmpty(a.a.a()))
      parame.b("uin", a.a.a()); 
    jSONObject = a();
    if (!m.a(jSONObject)) {
      String str2 = jSONObject.toString();
      String str1 = com.qq.e.comm.plugin.util.c.a(str2);
      parame.b("encext", str1);
      parame.b("encver", com.qq.e.comm.plugin.util.c.a);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("原文：");
      stringBuilder2.append(str2);
      GDTLogger.d(stringBuilder2.toString());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("密文：");
      stringBuilder1.append(str1);
      GDTLogger.d(stringBuilder1.toString());
    } 
    return parame.e();
  }
  
  private static JSONArray a(JSONArray paramJSONArray1, JSONArray paramJSONArray2) {
    if (paramJSONArray1 != null) {
      HashSet<Object> hashSet;
      int i = paramJSONArray1.length();
      if (i == 0)
        return paramJSONArray2; 
      JSONArray jSONArray = paramJSONArray1;
      if (paramJSONArray2 != null) {
        int j = paramJSONArray2.length();
        jSONArray = paramJSONArray1;
        if (j != 0) {
          int m;
          hashSet = new HashSet();
          byte b = 0;
          int k = 0;
          while (true) {
            m = b;
            if (k < i) {
              hashSet.add(paramJSONArray1.opt(k));
              k++;
              continue;
            } 
            break;
          } 
          while (m < j) {
            hashSet.add(paramJSONArray2.opt(m));
            m++;
          } 
          return new JSONArray(hashSet);
        } 
      } 
      return (JSONArray)hashSet;
    } 
    return paramJSONArray2;
  }
  
  private static JSONObject a() {
    JSONArray jSONArray = b();
    if (m.a(jSONArray))
      return null; 
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.putOpt("blist", jSONArray);
    } catch (JSONException jSONException) {}
    return jSONObject;
  }
  
  private static JSONObject a(GDTADManager paramGDTADManager) {
    String str1;
    JSONObject jSONObject = new JSONObject();
    String str7 = i.a;
    String str6 = i.b;
    String str5 = i.c;
    String str4 = i.d;
    String str3 = i.e;
    if (Build.VERSION.SDK_INT >= 9) {
      str1 = i.f;
    } else {
      str1 = null;
    } 
    String str2 = str7;
    try {
      if (StringUtil.isEmpty(str7))
        str2 = null; 
      jSONObject.put("br", str2);
      str2 = str6;
      if (StringUtil.isEmpty(str6))
        str2 = null; 
      jSONObject.put("de", str2);
      str2 = str5;
      if (StringUtil.isEmpty(str5))
        str2 = null; 
      jSONObject.put("fp", str2);
      str2 = str4;
      if (StringUtil.isEmpty(str4))
        str2 = null; 
      jSONObject.put("hw", str2);
      str2 = str3;
      if (StringUtil.isEmpty(str3))
        str2 = null; 
      jSONObject.put("pr", str2);
      str2 = str1;
      if (StringUtil.isEmpty(str1))
        str2 = null; 
      jSONObject.put("sr", str2);
      jSONObject.put("is_d", i.a(paramGDTADManager.getAppContext()));
      return jSONObject;
    } catch (JSONException jSONException) {
      return jSONObject;
    } 
  }
  
  private static JSONObject a(GDTADManager paramGDTADManager, e parame, b paramb) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("req", c(paramGDTADManager, parame, paramb));
    return a(jSONObject, paramb.H());
  }
  
  private static JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2) throws JSONException {
    if (paramJSONObject2 != null && paramJSONObject2.length() > 0) {
      Iterator<String> iterator = paramJSONObject2.keys();
      while (iterator.hasNext()) {
        String str = iterator.next();
        if (!paramJSONObject1.has(str)) {
          paramJSONObject1.put(str, paramJSONObject2.get(str));
          continue;
        } 
        Object object1 = paramJSONObject1.get(str);
        Object object2 = paramJSONObject2.get(str);
        if (object1 instanceof JSONObject && object2 instanceof JSONObject)
          a((JSONObject)object1, (JSONObject)object2); 
      } 
    } 
    return paramJSONObject1;
  }
  
  private static void a(GDTADManager paramGDTADManager, JSONObject paramJSONObject, b paramb) throws JSONException {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/h/b.a : Lcom/qq/e/comm/plugin/h/b;
    //   3: invokevirtual a : ()Lcom/qq/e/comm/plugin/h/a;
    //   6: aload_0
    //   7: invokevirtual getAppContext : ()Landroid/content/Context;
    //   10: invokeinterface a : (Landroid/content/Context;)Ljava/lang/String;
    //   15: astore #8
    //   17: ldc_w 'imei = %s'
    //   20: iconst_1
    //   21: anewarray java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload #8
    //   28: aastore
    //   29: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: aload_1
    //   33: getstatic com/qq/e/comm/plugin/h/b.a : Lcom/qq/e/comm/plugin/h/b;
    //   36: invokevirtual b : ()Ljava/lang/String;
    //   39: aload #8
    //   41: invokevirtual putOpt : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   44: pop
    //   45: aload_1
    //   46: getstatic com/qq/e/comm/plugin/h/b.c : Lcom/qq/e/comm/plugin/h/b;
    //   49: invokevirtual b : ()Ljava/lang/String;
    //   52: getstatic com/qq/e/comm/plugin/h/b.c : Lcom/qq/e/comm/plugin/h/b;
    //   55: aload_0
    //   56: invokevirtual getAppContext : ()Landroid/content/Context;
    //   59: invokevirtual a : (Landroid/content/Context;)Ljava/lang/String;
    //   62: invokevirtual putOpt : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   65: pop
    //   66: aload_1
    //   67: getstatic com/qq/e/comm/plugin/h/b.d : Lcom/qq/e/comm/plugin/h/b;
    //   70: invokevirtual b : ()Ljava/lang/String;
    //   73: getstatic com/qq/e/comm/plugin/h/b.d : Lcom/qq/e/comm/plugin/h/b;
    //   76: aload_0
    //   77: invokevirtual getAppContext : ()Landroid/content/Context;
    //   80: invokevirtual a : (Landroid/content/Context;)Ljava/lang/String;
    //   83: invokevirtual putOpt : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   86: pop
    //   87: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   90: invokevirtual getSM : ()Lcom/qq/e/comm/managers/setting/SM;
    //   93: astore #5
    //   95: aload #8
    //   97: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   100: ifeq -> 179
    //   103: aload #5
    //   105: ifnull -> 179
    //   108: new java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial <init> : ()V
    //   115: astore #4
    //   117: aload #4
    //   119: ldc_w 'support_ad_upload_qadid_'
    //   122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload #4
    //   128: aload_2
    //   129: invokevirtual i : ()I
    //   132: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: iconst_1
    //   137: aload #5
    //   139: aload #4
    //   141: invokevirtual toString : ()Ljava/lang/String;
    //   144: iconst_0
    //   145: invokevirtual getInteger : (Ljava/lang/String;I)I
    //   148: if_icmpne -> 179
    //   151: iconst_1
    //   152: aload #5
    //   154: ldc_w 'should_collect_qadid'
    //   157: iconst_0
    //   158: invokevirtual getInteger : (Ljava/lang/String;I)I
    //   161: if_icmpne -> 179
    //   164: aload_1
    //   165: ldc_w 'm8'
    //   168: aload_0
    //   169: invokevirtual getAppContext : ()Landroid/content/Context;
    //   172: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   175: invokevirtual putOpt : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload #5
    //   181: ifnull -> 405
    //   184: aload #5
    //   186: ldc_w 'ex_exp_info'
    //   189: aload_2
    //   190: invokevirtual c : ()Ljava/lang/String;
    //   193: invokevirtual getStringForPlacement : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   196: astore_2
    //   197: aload_2
    //   198: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   201: istore_3
    //   202: aconst_null
    //   203: astore #7
    //   205: iload_3
    //   206: ifne -> 255
    //   209: new org/json/JSONObject
    //   212: dup
    //   213: aload_2
    //   214: invokespecial <init> : (Ljava/lang/String;)V
    //   217: astore_2
    //   218: aload_2
    //   219: ldc_w 'exp_id'
    //   222: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   225: astore #4
    //   227: goto -> 261
    //   230: astore #4
    //   232: goto -> 239
    //   235: astore #4
    //   237: aconst_null
    //   238: astore_2
    //   239: aload #4
    //   241: invokevirtual getMessage : ()Ljava/lang/String;
    //   244: aload #4
    //   246: invokestatic w : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   249: aconst_null
    //   250: astore #4
    //   252: goto -> 261
    //   255: aconst_null
    //   256: astore #4
    //   258: aload #4
    //   260: astore_2
    //   261: aload #5
    //   263: ldc_w 'ex_exp_info'
    //   266: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   269: astore #5
    //   271: aload #5
    //   273: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   276: ifne -> 330
    //   279: new org/json/JSONObject
    //   282: dup
    //   283: aload #5
    //   285: invokespecial <init> : (Ljava/lang/String;)V
    //   288: astore #5
    //   290: aload #5
    //   292: ldc_w 'exp_id'
    //   295: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   298: astore #6
    //   300: goto -> 337
    //   303: astore #6
    //   305: goto -> 313
    //   308: astore #6
    //   310: aconst_null
    //   311: astore #5
    //   313: aload #6
    //   315: invokevirtual getMessage : ()Ljava/lang/String;
    //   318: aload #6
    //   320: invokestatic w : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   323: aload #7
    //   325: astore #6
    //   327: goto -> 337
    //   330: aconst_null
    //   331: astore #5
    //   333: aload #7
    //   335: astore #6
    //   337: aload_2
    //   338: ifnull -> 535
    //   341: aload #5
    //   343: ifnull -> 535
    //   346: aload #6
    //   348: aload #4
    //   350: invokestatic a : (Lorg/json/JSONArray;Lorg/json/JSONArray;)Lorg/json/JSONArray;
    //   353: astore_2
    //   354: aload_2
    //   355: ifnull -> 368
    //   358: aload #5
    //   360: ldc_w 'exp_id'
    //   363: aload_2
    //   364: invokevirtual putOpt : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   367: pop
    //   368: aload_1
    //   369: ldc_w 'ex_exp_info'
    //   372: aload #5
    //   374: invokevirtual putOpt : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   377: pop
    //   378: goto -> 405
    //   381: aload_2
    //   382: ifnull -> 405
    //   385: aload_1
    //   386: ldc_w 'ex_exp_info'
    //   389: aload_2
    //   390: invokevirtual putOpt : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   393: pop
    //   394: goto -> 405
    //   397: aload_2
    //   398: invokevirtual getMessage : ()Ljava/lang/String;
    //   401: aload_2
    //   402: invokestatic w : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   405: aload #8
    //   407: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   410: ifne -> 448
    //   413: aload_1
    //   414: ldc 'muidtype'
    //   416: iconst_1
    //   417: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   420: pop
    //   421: aload_1
    //   422: ldc 'muid'
    //   424: aload #8
    //   426: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   429: pop
    //   430: ldc_w 'gdt_tag_p'
    //   433: ldc_w 'request muid(imei) = %s'
    //   436: iconst_1
    //   437: anewarray java/lang/Object
    //   440: dup
    //   441: iconst_0
    //   442: aload #8
    //   444: aastore
    //   445: invokestatic b : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   448: iconst_1
    //   449: aload_1
    //   450: ldc_w '/display'
    //   453: invokestatic a : (ZLorg/json/JSONObject;Ljava/lang/String;)V
    //   456: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   459: invokevirtual getSM : ()Lcom/qq/e/comm/managers/setting/SM;
    //   462: ldc_w 'plainIdsOn'
    //   465: iconst_1
    //   466: invokevirtual getInteger : (Ljava/lang/String;I)I
    //   469: iconst_1
    //   470: if_icmpne -> 484
    //   473: aload_1
    //   474: ldc_w 'm9'
    //   477: invokestatic c : ()Ljava/lang/String;
    //   480: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   483: pop
    //   484: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   487: invokevirtual getSM : ()Lcom/qq/e/comm/managers/setting/SM;
    //   490: ldc_w 'adson'
    //   493: iconst_1
    //   494: invokevirtual getInteger : (Ljava/lang/String;I)I
    //   497: iconst_1
    //   498: if_icmpne -> 530
    //   501: getstatic com/qq/e/comm/plugin/h/b.e : Lcom/qq/e/comm/plugin/h/b;
    //   504: invokevirtual a : ()Lcom/qq/e/comm/plugin/h/a;
    //   507: checkcast com/qq/e/comm/plugin/h/a/c
    //   510: aload_0
    //   511: invokevirtual getAppContext : ()Landroid/content/Context;
    //   514: invokevirtual d : (Landroid/content/Context;)Lorg/json/JSONObject;
    //   517: astore_0
    //   518: aload_1
    //   519: getstatic com/qq/e/comm/plugin/h/b.e : Lcom/qq/e/comm/plugin/h/b;
    //   522: invokevirtual b : ()Ljava/lang/String;
    //   525: aload_0
    //   526: invokevirtual putOpt : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   529: pop
    //   530: return
    //   531: astore_2
    //   532: goto -> 397
    //   535: aload #5
    //   537: ifnull -> 381
    //   540: goto -> 368
    // Exception table:
    //   from	to	target	type
    //   209	218	235	org/json/JSONException
    //   218	227	230	org/json/JSONException
    //   279	290	308	org/json/JSONException
    //   290	300	303	org/json/JSONException
    //   346	354	531	org/json/JSONException
    //   358	368	531	org/json/JSONException
    //   368	378	531	org/json/JSONException
    //   385	394	531	org/json/JSONException
  }
  
  private static void a(b paramb, JSONObject paramJSONObject) throws JSONException {
    int i = paramb.z();
    int j = paramb.A();
    if (j > 0 && j < i) {
      GDTLogger.e("参数设置错误 , minVideoDuration不能大于maxVideoDuration");
      return;
    } 
    if (i > 0)
      paramJSONObject.put("min_duration", i); 
    if (j > 0)
      paramJSONObject.put("max_duration", j); 
  }
  
  private static boolean a(int paramInt) {
    String str = GDTADManager.getInstance().getSM().getString("fixedDurationSupportPosTypes");
    return !TextUtils.isEmpty(str) ? Arrays.<String>asList(str.split(",")).contains(Integer.toString(paramInt)) : ((e.f.b() == paramInt || e.i.b() == paramInt || e.n.b() == paramInt || e.l.b() == paramInt || e.w.b() == paramInt));
  }
  
  private static JSONArray b() {
    int i = GDTADManager.getInstance().getSM().getInteger("bssidCount", 1);
    if (i > 0) {
      List list = bj.a(GDTADManager.getInstance().getAppContext(), i);
      if (!m.a(list) && list.size() != 0) {
        JSONArray jSONArray1;
        JSONArray jSONArray2 = new JSONArray();
        Iterator<String> iterator = list.iterator();
        while (true) {
          jSONArray1 = jSONArray2;
          if (iterator.hasNext()) {
            jSONArray2.put(iterator.next());
            continue;
          } 
          break;
        } 
        return jSONArray1;
      } 
    } 
    return null;
  }
  
  private static JSONObject b(GDTADManager paramGDTADManager, e parame, b paramb) throws JSONException {
    if (paramb.q() == null || paramb.q().size() == 0)
      return null; 
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("category", new JSONArray(paramb.q()));
    return jSONObject;
  }
  
  private static void b(JSONObject paramJSONObject, b paramb) throws JSONException {
    if (paramb.i() == e.a.b()) {
      paramJSONObject.put("placement_type", 1);
      paramJSONObject.put("render_type", 1);
    } 
    if (paramb.i() == e.b.b()) {
      paramJSONObject.put("placement_type", 2);
      paramJSONObject.put("render_type", 1);
    } 
    if (paramb.i() == e.c.b()) {
      paramJSONObject.put("placement_type", 3);
      paramJSONObject.put("render_type", 1);
    } 
    if (paramb.i() == e.d.b()) {
      paramJSONObject.put("placement_type", 4);
      paramJSONObject.put("render_type", 1);
    } 
    if (paramb.i() == e.f.b()) {
      paramJSONObject.put("placement_type", 9);
      paramJSONObject.put("render_type", 1);
    } 
    if (paramb.i() == e.g.b()) {
      paramJSONObject.put("placement_type", 9);
      paramJSONObject.put("render_type", 1);
    } 
    if (paramb.i() == e.i.b()) {
      paramJSONObject.put("placement_type", 9);
      paramJSONObject.put("render_type", 3);
    } 
    if (paramb.i() == e.w.b()) {
      paramJSONObject.put("placement_type", 9);
      paramJSONObject.put("render_type", 3);
    } 
    if (paramb.i() == e.x.b()) {
      paramJSONObject.put("placement_type", 10);
      paramJSONObject.put("render_type", 3);
    } 
    if (paramb.i() == e.k.b()) {
      paramJSONObject.put("placement_type", 10);
      paramJSONObject.put("render_type", 1);
    } 
    if (paramb.i() == e.l.b()) {
      paramJSONObject.put("placement_type", 9);
      paramJSONObject.put("render_type", 1);
      paramJSONObject.put("support_container", true);
    } 
    if (paramb.i() == e.m.b()) {
      paramJSONObject.put("placement_type", 1);
      paramJSONObject.put("render_type", 3);
    } 
    if (paramb.i() == e.n.b()) {
      paramJSONObject.put("placement_type", 2);
      paramJSONObject.put("render_type", 3);
    } 
  }
  
  private static boolean b(int paramInt) {
    return (b.nextDouble() < paramInt * 0.001D);
  }
  
  private static String c() {
    return (String)gdtadv.getobjresult(174, 1, new Object[0]);
  }
  
  private static JSONObject c(GDTADManager paramGDTADManager, e parame, b paramb) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    String str = paramGDTADManager.getDeviceStatus().getScreenOrientation();
    if (str == null || str.equals("p")) {
      i = 0;
    } else {
      i = 90;
    } 
    a(paramGDTADManager, jSONObject, paramb);
    b(jSONObject, paramb);
    jSONObject.put("conn", paramGDTADManager.getDeviceStatus().getNetworkType().getConnValue());
    str = ad.a();
    if (!StringUtil.isEmpty(str))
      jSONObject.put("cell_native", str); 
    jSONObject.put("carrier", paramGDTADManager.getDeviceStatus().getCarrier().getValue());
    try {
      double d1 = x.a(paramGDTADManager.getAppContext()).a();
      double d2 = x.a(paramGDTADManager.getAppContext()).b();
      jSONObject.put("loc_src", x.a(paramGDTADManager.getAppContext()).c());
      if (!m.a(d1) && !m.a(d2)) {
        jSONObject.put("lat", (long)(d1 * 1000000.0D));
        jSONObject.put("lng", (long)(1000000.0D * d2));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[latitude, longitude]=");
        stringBuilder.append(d1);
        stringBuilder.append(",");
        stringBuilder.append(d2);
        GDTLogger.d(stringBuilder.toString());
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Get location encountered exception: ");
      stringBuilder.append(exception.getMessage());
      GDTLogger.d(stringBuilder.toString());
    } 
    jSONObject.put("support_features", a(paramb));
    if (paramb.i() == e.k.b() || paramb.i() == e.x.b()) {
      SM sM = GDTADManager.getInstance().getSM();
      if (paramb.i() == e.k.b())
        jSONObject.put("support_reward_page", sM.getIntegerForPlacement("supportRewardPage", paramb.c(), 0)); 
      jSONObject.put("support_app_landing_page", sM.getInteger("rewardVideoSupportLandingPage", 0));
      int j = sM.getIntegerForPlacement("rewardVideoServerMaxDuration", paramb.c(), 31);
      if (j > 0)
        jSONObject.put("max_duration", j); 
    } else {
      if (paramb.i() == e.v.b()) {
        jSONObject.put("support_app_landing_page", GDTADManager.getInstance().getSM().getInteger("interstitialFullScreenSupportLandingPage", 0));
        paramb.h(e.n.b());
      } else {
        jSONObject.put("support_app_landing_page", 1);
      } 
      a(paramb, jSONObject);
    } 
    if (a(paramb.i()))
      jSONObject.putOpt("fixed_duration", GDTADManager.getInstance().getSM().getString("fixedDurations")); 
    jSONObject.put("c_os", "android");
    jSONObject.put("c_osver", Build.VERSION.RELEASE);
    jSONObject.put("c_pkgname", paramGDTADManager.getAppStatus().getAPPName());
    jSONObject.put("c_device", (paramGDTADManager.getDeviceStatus()).model);
    jSONObject.put("c_devicetype", am.a(paramGDTADManager.getAppContext()));
    jSONObject.put("c_mf", Build.MANUFACTURER);
    jSONObject.put("c_ori", i);
    Object object = o.a();
    if (((Integer)((Pair)object).first).intValue() > ((Integer)((Pair)object).second).intValue()) {
      jSONObject.put("c_w", ((Pair)object).second);
      object = ((Pair)object).first;
    } else {
      jSONObject.put("c_w", ((Pair)object).first);
      object = ((Pair)object).second;
    } 
    jSONObject.put("c_h", object);
    object = new StringBuilder();
    object.append(SDKStatus.getSDKVersion());
    object.append(".");
    object.append(GDTADManager.getInstance().getPM().getPluginVersion());
    jSONObject.put("sdkver", object.toString());
    jSONObject.put("jsver", paramb.k());
    jSONObject.put("tmpallpt", true);
    jSONObject.put("postype", paramb.i());
    jSONObject.put("deep_link_version", 1);
    jSONObject.put("c_sdfree", o.o());
    jSONObject.put("c_market", aa.a());
    jSONObject.put("c_hl", Locale.getDefault().getLanguage());
    if (paramb.i() == e.e.b())
      jSONObject.put("feedreq", 1); 
    if (paramb.i() == e.b.b() || paramb.i() == e.n.b())
      jSONObject.put("inline_full_screen", 1); 
    if (paramb.i() == e.i.b())
      jSONObject.put("native_jsver", "1.1.0"); 
    try {
      object = SDKSrcConfig.getSdkSrc();
      if (!StringUtil.isEmpty((String)object))
        jSONObject.put("sdk_src", object); 
    } finally {
      object = null;
    } 
    jSONObject.put("scs", a(jSONObject, paramb));
    if (b(GDTADManager.getInstance().getSM().getInteger("antiSpamTestRate", 1000)))
      jSONObject.put("ast", a(paramGDTADManager)); 
    if (paramb.i() == e.i.b() && bd.a())
      jSONObject.put("support_video", true); 
    if ((paramb.i() == e.w.b() || paramb.i() == e.x.b()) && bd.b())
      jSONObject.put("support_video", true); 
    if (paramb.i() == e.n.b() && bd.c())
      jSONObject.put("support_video", true); 
    if (paramb.i() == e.d.b()) {
      if (GDTADManager.getInstance().getSM().getIntegerForPlacement("skssv", paramb.c(), 0) == 1) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i != 0)
        jSONObject.put("support_video", true); 
    } 
    jSONObject.put("from_js", paramb.r());
    jSONObject.put("url", paramb.s());
    jSONObject.putOpt("xflow_pos_id", paramb.t());
    jSONObject.put("sdk_st", paramb.j().a());
    jSONObject.put("sdk_pt", 1);
    if (paramb.i() == e.d.b()) {
      jSONObject.put("hwmodel", Build.DEVICE);
      jSONObject.put("hwmachine", Build.MODEL);
      jSONObject.put("brands", Build.BRAND);
      jSONObject.put("mnc", o.f(GDTADManager.getInstance().getAppContext()));
      jSONObject.put("prld", paramb.B());
      jSONObject.put("rtld", paramb.C());
      jSONObject.put("wl", paramb.D());
      jSONObject.put("playround", paramb.F());
      jSONObject.put("block_effect", paramb.E());
      jSONObject.put("oneshot", paramb.G());
      jSONObject.put("warm_boot", false);
    } 
    jSONObject.put("wx_api_ver", bg.a());
    jSONObject.put("opensdk_ver", bg.b());
    object = h.a();
    if (!TextUtils.isEmpty((CharSequence)object))
      jSONObject.put("qq_ver", object); 
    int i = (paramGDTADManager.getAppContext().getApplicationInfo()).targetSdkVersion;
    jSONObject.put("target_ver", i);
    if (Build.VERSION.SDK_INT >= 30 && i >= 30)
      jSONObject.put("query_all_packages", b.c(paramGDTADManager.getAppContext())); 
    jSONObject.put("support_c2s", 2);
    if (SDKStatus.getSDKVersionCode() >= 30)
      jSONObject.put("support_component", String.format("%d,%d,%d", new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) })); 
    Integer integer = a.a().c();
    if (integer != null)
      jSONObject.put("m_ch", integer.intValue()); 
    if (z.a())
      jSONObject.put("support_app_store", 1); 
    if (paramb.i() == e.w.b() || paramb.i() == e.x.b()) {
      jSONObject.put("support_tpl", 1);
      jSONObject.put("tpl_ids", paramb.I());
    } 
    return jSONObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ad\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */