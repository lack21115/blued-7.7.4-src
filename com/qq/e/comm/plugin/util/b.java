package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.StringUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  private static volatile Boolean a;
  
  public static Pair<JSONArray, Pair<Integer, Integer>> a(JSONObject paramJSONObject, String paramString) {
    int i = paramJSONObject.optInt("ret");
    Integer integer = Integer.valueOf(501);
    if (i != 0)
      return new Pair(null, new Pair(integer, Integer.valueOf(2001))); 
    paramJSONObject = paramJSONObject.optJSONObject("data");
    if (paramJSONObject == null)
      return new Pair(null, new Pair(integer, Integer.valueOf(2002))); 
    paramJSONObject = paramJSONObject.optJSONObject(paramString);
    if (paramJSONObject == null)
      return new Pair(null, new Pair(integer, Integer.valueOf(2003))); 
    i = paramJSONObject.optInt("ret");
    if (i != 0)
      return new Pair(null, new Pair(Integer.valueOf(i), Integer.valueOf(2004))); 
    JSONArray jSONArray = paramJSONObject.optJSONArray("list");
    return (jSONArray == null || jSONArray.length() <= 0) ? new Pair(null, new Pair(integer, Integer.valueOf(2005))) : new Pair(jSONArray, new Pair(Integer.valueOf(2000), Integer.valueOf(2000)));
  }
  
  public static String a() {
    return "com.jingdong.app.mall";
  }
  
  public static String a(Context paramContext) {
    return (paramContext != null && GDTADManager.getInstance().getSM().getInteger("cookieForLastAds", 0) == 1) ? av.b("last_ads", "") : null;
  }
  
  public static List<JSONObject> a(JSONArray paramJSONArray, m paramm, String paramString) {
    return a(paramJSONArray, paramm, paramString, null);
  }
  
  public static List<JSONObject> a(JSONArray paramJSONArray, m paramm, String paramString, boolean[] paramArrayOfboolean) {
    // Byte code:
    //   0: aload_2
    //   1: astore #9
    //   3: new java/util/ArrayList
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: astore #12
    //   12: new org/json/JSONArray
    //   15: dup
    //   16: invokespecial <init> : ()V
    //   19: astore #13
    //   21: aload_0
    //   22: ifnull -> 832
    //   25: aload_3
    //   26: ifnull -> 46
    //   29: aload_0
    //   30: invokevirtual length : ()I
    //   33: aload_3
    //   34: arraylength
    //   35: if_icmpeq -> 46
    //   38: ldc 'ad.len != filter.len!!'
    //   40: invokestatic e : (Ljava/lang/String;)V
    //   43: aload #12
    //   45: areturn
    //   46: new java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial <init> : ()V
    //   53: astore #10
    //   55: aload #10
    //   57: ldc 'filterInstalledApp before size:'
    //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload #10
    //   65: aload_0
    //   66: invokevirtual length : ()I
    //   69: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #10
    //   75: invokevirtual toString : ()Ljava/lang/String;
    //   78: invokestatic d : (Ljava/lang/String;)V
    //   81: new com/qq/e/comm/plugin/ad/AdFilterReporter
    //   84: dup
    //   85: invokespecial <init> : ()V
    //   88: astore #14
    //   90: iconst_0
    //   91: istore #4
    //   93: iload #4
    //   95: aload_0
    //   96: invokevirtual length : ()I
    //   99: if_icmpge -> 757
    //   102: aload_0
    //   103: iload #4
    //   105: invokevirtual optJSONObject : (I)Lorg/json/JSONObject;
    //   108: astore #15
    //   110: aload #15
    //   112: invokestatic a : (Lorg/json/JSONObject;)Z
    //   115: istore #6
    //   117: aload #15
    //   119: invokestatic b : (Lorg/json/JSONObject;)Z
    //   122: istore #7
    //   124: aload #15
    //   126: invokestatic a : (Lorg/json/JSONObject;)Z
    //   129: istore #8
    //   131: iload #6
    //   133: ifne -> 171
    //   136: iload #7
    //   138: ifne -> 171
    //   141: iload #8
    //   143: ifeq -> 149
    //   146: goto -> 171
    //   149: aload #12
    //   151: aload #15
    //   153: invokeinterface add : (Ljava/lang/Object;)Z
    //   158: pop
    //   159: aload_3
    //   160: ifnull -> 168
    //   163: aload_3
    //   164: iload #4
    //   166: iconst_0
    //   167: bastore
    //   168: goto -> 748
    //   171: iload #6
    //   173: ifeq -> 203
    //   176: aload #15
    //   178: invokestatic d : (Lorg/json/JSONObject;)Lcom/qq/e/comm/plugin/ad/j;
    //   181: astore #11
    //   183: aload #11
    //   185: invokevirtual d : ()Ljava/lang/String;
    //   188: astore #10
    //   190: aload #11
    //   192: invokevirtual h : ()I
    //   195: invokestatic a : (I)Z
    //   198: istore #6
    //   200: goto -> 296
    //   203: aconst_null
    //   204: astore #10
    //   206: aconst_null
    //   207: astore #11
    //   209: iload #7
    //   211: ifeq -> 221
    //   214: ldc 'com.jingdong.app.mall'
    //   216: astore #10
    //   218: goto -> 283
    //   221: iload #8
    //   223: ifeq -> 283
    //   226: aload #15
    //   228: ldc 'ext'
    //   230: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   233: astore #10
    //   235: aload #10
    //   237: ifnull -> 249
    //   240: aload #10
    //   242: ldc 'pkg_name'
    //   244: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   247: astore #11
    //   249: aload #11
    //   251: astore #10
    //   253: aload #11
    //   255: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   258: ifeq -> 283
    //   261: aload #12
    //   263: aload #15
    //   265: invokeinterface add : (Ljava/lang/Object;)Z
    //   270: pop
    //   271: aload_3
    //   272: ifnull -> 168
    //   275: aload_3
    //   276: iload #4
    //   278: iconst_0
    //   279: bastore
    //   280: goto -> 168
    //   283: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   286: invokevirtual getAppContext : ()Landroid/content/Context;
    //   289: aload #10
    //   291: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   294: istore #6
    //   296: aload #15
    //   298: ldc 'reltarget'
    //   300: invokevirtual optInt : (Ljava/lang/String;)I
    //   303: istore #5
    //   305: new org/json/JSONObject
    //   308: dup
    //   309: invokespecial <init> : ()V
    //   312: astore #11
    //   314: aload #11
    //   316: ldc 'muidtype'
    //   318: ldc 'imei'
    //   320: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   323: pop
    //   324: getstatic com/qq/e/comm/plugin/h/b.a : Lcom/qq/e/comm/plugin/h/b;
    //   327: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   330: invokevirtual getAppContext : ()Landroid/content/Context;
    //   333: invokevirtual a : (Landroid/content/Context;)Ljava/lang/String;
    //   336: astore #16
    //   338: aload #11
    //   340: ldc 'muid'
    //   342: aload #16
    //   344: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   347: pop
    //   348: aload #11
    //   350: ldc 'package_name'
    //   352: aload #10
    //   354: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   357: pop
    //   358: new java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial <init> : ()V
    //   365: astore #10
    //   367: aload #10
    //   369: invokestatic currentTimeMillis : ()J
    //   372: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload #10
    //   378: ldc ''
    //   380: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload #11
    //   386: ldc 'timestamp'
    //   388: aload #10
    //   390: invokevirtual toString : ()Ljava/lang/String;
    //   393: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   396: pop
    //   397: iload #6
    //   399: ifeq -> 434
    //   402: iload #5
    //   404: iconst_1
    //   405: if_icmpne -> 434
    //   408: aload #11
    //   410: ldc 'install_status'
    //   412: ldc '1'
    //   414: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   417: pop
    //   418: aload #14
    //   420: aload #15
    //   422: ldc 'fl'
    //   424: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   427: iconst_2
    //   428: invokevirtual a : (Ljava/lang/String;I)V
    //   431: goto -> 481
    //   434: iload #6
    //   436: ifne -> 471
    //   439: iload #5
    //   441: iconst_2
    //   442: if_icmpne -> 471
    //   445: aload #11
    //   447: ldc 'install_status'
    //   449: ldc '0'
    //   451: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   454: pop
    //   455: aload #14
    //   457: aload #15
    //   459: ldc 'fl'
    //   461: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   464: iconst_1
    //   465: invokevirtual a : (Ljava/lang/String;I)V
    //   468: goto -> 481
    //   471: aload #12
    //   473: aload #15
    //   475: invokeinterface add : (Ljava/lang/Object;)Z
    //   480: pop
    //   481: aload #11
    //   483: ldc 'install_status'
    //   485: invokevirtual has : (Ljava/lang/String;)Z
    //   488: istore #6
    //   490: aload_3
    //   491: ifnull -> 500
    //   494: aload_3
    //   495: iload #4
    //   497: iload #6
    //   499: bastore
    //   500: iload #6
    //   502: ifeq -> 695
    //   505: aload #16
    //   507: ifnull -> 937
    //   510: sipush #1006
    //   513: aload #11
    //   515: aload_1
    //   516: aload_2
    //   517: invokestatic a : (ILorg/json/JSONObject;Lcom/qq/e/comm/plugin/ad/m;Ljava/lang/String;)V
    //   520: goto -> 523
    //   523: aload_2
    //   524: astore #10
    //   526: new com/qq/e/comm/plugin/y/d
    //   529: dup
    //   530: new org/json/JSONObject
    //   533: dup
    //   534: aload #11
    //   536: iconst_3
    //   537: anewarray java/lang/String
    //   540: dup
    //   541: iconst_0
    //   542: ldc 'package_name'
    //   544: aastore
    //   545: dup
    //   546: iconst_1
    //   547: ldc 'timestamp'
    //   549: aastore
    //   550: dup
    //   551: iconst_2
    //   552: ldc 'install_status'
    //   554: aastore
    //   555: invokespecial <init> : (Lorg/json/JSONObject;[Ljava/lang/String;)V
    //   558: invokespecial <init> : (Lorg/json/JSONObject;)V
    //   561: astore #11
    //   563: aload #11
    //   565: ldc 'threadid'
    //   567: aload #10
    //   569: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)Lcom/qq/e/comm/plugin/y/d;
    //   572: pop
    //   573: aload #11
    //   575: ldc 'plc'
    //   577: aload_1
    //   578: invokestatic a : (Lcom/qq/e/comm/plugin/ad/m;)Lorg/json/JSONObject;
    //   581: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)Lcom/qq/e/comm/plugin/y/d;
    //   584: pop
    //   585: aload #13
    //   587: aload #11
    //   589: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   592: pop
    //   593: new com/qq/e/comm/plugin/y/c
    //   596: dup
    //   597: invokespecial <init> : ()V
    //   600: astore #16
    //   602: aload #16
    //   604: aload_1
    //   605: invokevirtual a : ()Ljava/lang/String;
    //   608: invokevirtual a : (Ljava/lang/String;)Lcom/qq/e/comm/plugin/y/c;
    //   611: pop
    //   612: aload #16
    //   614: aload #15
    //   616: ldc_w 'cl'
    //   619: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   622: invokevirtual b : (Ljava/lang/String;)Lcom/qq/e/comm/plugin/y/c;
    //   625: pop
    //   626: aload #16
    //   628: aload #15
    //   630: ldc_w 'traceid'
    //   633: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   636: invokevirtual c : (Ljava/lang/String;)Lcom/qq/e/comm/plugin/y/c;
    //   639: pop
    //   640: ldc_w 100202
    //   643: iload #5
    //   645: aload #16
    //   647: aload #11
    //   649: invokestatic a : (IILcom/qq/e/comm/plugin/y/c;Lcom/qq/e/comm/plugin/y/d;)V
    //   652: aload #10
    //   654: astore #9
    //   656: aload_1
    //   657: invokevirtual b : ()Lcom/qq/e/comm/plugin/ad/e;
    //   660: ifnull -> 748
    //   663: ldc_w 100212
    //   666: aload_1
    //   667: invokevirtual b : ()Lcom/qq/e/comm/plugin/ad/e;
    //   670: invokevirtual b : ()I
    //   673: aload #16
    //   675: aload #11
    //   677: invokestatic a : (IILcom/qq/e/comm/plugin/y/c;Lcom/qq/e/comm/plugin/y/d;)V
    //   680: aload #10
    //   682: astore #9
    //   684: goto -> 748
    //   687: aload_2
    //   688: astore #9
    //   690: astore #10
    //   692: goto -> 711
    //   695: aload_2
    //   696: astore #9
    //   698: goto -> 748
    //   701: astore #10
    //   703: aload_2
    //   704: astore #9
    //   706: goto -> 711
    //   709: astore #10
    //   711: new java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial <init> : ()V
    //   718: astore #11
    //   720: aload #11
    //   722: ldc_w 'get exception. '
    //   725: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload #11
    //   731: aload #10
    //   733: invokevirtual getMessage : ()Ljava/lang/String;
    //   736: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: pop
    //   740: aload #11
    //   742: invokevirtual toString : ()Ljava/lang/String;
    //   745: invokestatic d : (Ljava/lang/String;)V
    //   748: iload #4
    //   750: iconst_1
    //   751: iadd
    //   752: istore #4
    //   754: goto -> 93
    //   757: aload #12
    //   759: invokeinterface size : ()I
    //   764: istore #5
    //   766: aload_1
    //   767: invokevirtual b : ()Lcom/qq/e/comm/plugin/ad/e;
    //   770: getstatic com/qq/e/comm/plugin/ad/e.d : Lcom/qq/e/comm/plugin/ad/e;
    //   773: if_acmpne -> 824
    //   776: iconst_1
    //   777: istore #4
    //   779: iload #5
    //   781: iconst_1
    //   782: if_icmple -> 824
    //   785: iload #4
    //   787: iload #5
    //   789: if_icmpge -> 824
    //   792: aload #14
    //   794: aload #12
    //   796: iload #4
    //   798: invokeinterface get : (I)Ljava/lang/Object;
    //   803: checkcast org/json/JSONObject
    //   806: ldc 'fl'
    //   808: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   811: iconst_3
    //   812: invokevirtual a : (Ljava/lang/String;I)V
    //   815: iload #4
    //   817: iconst_1
    //   818: iadd
    //   819: istore #4
    //   821: goto -> 785
    //   824: aload #14
    //   826: invokevirtual a : ()V
    //   829: goto -> 832
    //   832: aload_0
    //   833: ifnull -> 899
    //   836: aload_0
    //   837: invokevirtual length : ()I
    //   840: ifle -> 899
    //   843: aload #12
    //   845: invokeinterface size : ()I
    //   850: ifne -> 899
    //   853: new com/qq/e/comm/plugin/y/d
    //   856: dup
    //   857: invokespecial <init> : ()V
    //   860: astore_0
    //   861: aload_0
    //   862: ldc_w 'filters'
    //   865: aload #13
    //   867: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)Lcom/qq/e/comm/plugin/y/d;
    //   870: pop
    //   871: ldc_w 100222
    //   874: aload_1
    //   875: invokevirtual b : ()Lcom/qq/e/comm/plugin/ad/e;
    //   878: invokevirtual b : ()I
    //   881: new com/qq/e/comm/plugin/y/c
    //   884: dup
    //   885: invokespecial <init> : ()V
    //   888: aload_1
    //   889: invokevirtual a : ()Ljava/lang/String;
    //   892: invokevirtual a : (Ljava/lang/String;)Lcom/qq/e/comm/plugin/y/c;
    //   895: aload_0
    //   896: invokestatic a : (IILcom/qq/e/comm/plugin/y/c;Lcom/qq/e/comm/plugin/y/d;)V
    //   899: new java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial <init> : ()V
    //   906: astore_0
    //   907: aload_0
    //   908: ldc_w 'filterInstalledApp after size:'
    //   911: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: pop
    //   915: aload_0
    //   916: aload #12
    //   918: invokeinterface size : ()I
    //   923: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   926: pop
    //   927: aload_0
    //   928: invokevirtual toString : ()Ljava/lang/String;
    //   931: invokestatic d : (Ljava/lang/String;)V
    //   934: aload #12
    //   936: areturn
    //   937: goto -> 523
    // Exception table:
    //   from	to	target	type
    //   314	367	709	java/lang/Exception
    //   367	397	701	java/lang/Exception
    //   408	431	701	java/lang/Exception
    //   445	468	701	java/lang/Exception
    //   471	481	701	java/lang/Exception
    //   481	490	701	java/lang/Exception
    //   510	520	687	java/lang/Exception
    //   526	652	687	java/lang/Exception
    //   656	680	687	java/lang/Exception
  }
  
  public static void a(JSONObject paramJSONObject, Context paramContext) throws JSONException {
    if (paramJSONObject != null && !TextUtils.isEmpty(paramJSONObject.optString("last_ads")) && paramContext != null && GDTADManager.getInstance().getSM().getInteger("cookieForLastAds", 0) == 1)
      av.a("last_ads", paramJSONObject.optString("last_ads")); 
  }
  
  public static boolean a(int paramInt) {
    return (paramInt == 12 || paramInt == 1000 || paramInt == 48 || paramInt == 38 || paramInt == 25);
  }
  
  public static boolean a(Context paramContext, a parama) {
    if (parama.v()) {
      String str = parama.z().d();
      if (com.qq.e.comm.plugin.a.d.b.a().a(paramContext, str) == 1)
        return true; 
    } 
    return false;
  }
  
  public static boolean a(a parama) {
    return (parama != null && parama.a_() == 25);
  }
  
  public static boolean a(JSONObject paramJSONObject) {
    return (paramJSONObject != null && paramJSONObject.optInt("producttype") == 1000);
  }
  
  public static void b(Context paramContext) {
    if (paramContext != null) {
      int i = (paramContext.getApplicationInfo()).targetSdkVersion;
      if (Build.VERSION.SDK_INT >= 30 && i >= 30 && !c(paramContext)) {
        ak.a("miss android.permission.QUERY_ALL_PACKAGES", new Object[0]);
        u.a(1130005, 0, null);
      } 
    } 
  }
  
  private static boolean b(int paramInt) {
    return (paramInt == 46);
  }
  
  public static boolean b(a parama) {
    return (parama == null) ? false : b(parama.a_());
  }
  
  public static boolean b(JSONObject paramJSONObject) {
    return (paramJSONObject != null && paramJSONObject.optInt("producttype") == 25);
  }
  
  private static boolean c(int paramInt) {
    return (paramInt == 3);
  }
  
  public static boolean c(Context paramContext) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: ifnonnull -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: getstatic com/qq/e/comm/plugin/util/b.a : Ljava/lang/Boolean;
    //   11: ifnonnull -> 103
    //   14: ldc com/qq/e/comm/plugin/util/b
    //   16: monitorenter
    //   17: getstatic com/qq/e/comm/plugin/util/b.a : Ljava/lang/Boolean;
    //   20: ifnonnull -> 91
    //   23: iconst_0
    //   24: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   27: putstatic com/qq/e/comm/plugin/util/b.a : Ljava/lang/Boolean;
    //   30: aload_0
    //   31: invokevirtual getPackageName : ()Ljava/lang/String;
    //   34: astore_3
    //   35: aload_0
    //   36: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   39: aload_3
    //   40: sipush #4096
    //   43: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   46: getfield requestedPermissions : [Ljava/lang/String;
    //   49: astore_0
    //   50: aload_0
    //   51: ifnull -> 91
    //   54: aload_0
    //   55: arraylength
    //   56: istore_2
    //   57: iload_1
    //   58: iload_2
    //   59: if_icmpge -> 91
    //   62: ldc_w 'android.permission.QUERY_ALL_PACKAGES'
    //   65: aload_0
    //   66: iload_1
    //   67: aaload
    //   68: invokevirtual equals : (Ljava/lang/Object;)Z
    //   71: ifeq -> 84
    //   74: iconst_1
    //   75: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   78: putstatic com/qq/e/comm/plugin/util/b.a : Ljava/lang/Boolean;
    //   81: goto -> 91
    //   84: iload_1
    //   85: iconst_1
    //   86: iadd
    //   87: istore_1
    //   88: goto -> 57
    //   91: ldc com/qq/e/comm/plugin/util/b
    //   93: monitorexit
    //   94: goto -> 103
    //   97: astore_0
    //   98: ldc com/qq/e/comm/plugin/util/b
    //   100: monitorexit
    //   101: aload_0
    //   102: athrow
    //   103: getstatic com/qq/e/comm/plugin/util/b.a : Ljava/lang/Boolean;
    //   106: invokevirtual booleanValue : ()Z
    //   109: ireturn
    //   110: astore_0
    //   111: goto -> 91
    // Exception table:
    //   from	to	target	type
    //   17	35	97	finally
    //   35	50	110	android/content/pm/PackageManager$NameNotFoundException
    //   35	50	97	finally
    //   54	57	110	android/content/pm/PackageManager$NameNotFoundException
    //   54	57	97	finally
    //   62	81	110	android/content/pm/PackageManager$NameNotFoundException
    //   62	81	97	finally
    //   91	94	97	finally
    //   98	101	97	finally
  }
  
  public static boolean c(a parama) {
    return (parama == null) ? false : c(parama.ae());
  }
  
  public static boolean c(JSONObject paramJSONObject) {
    return (paramJSONObject == null) ? false : b(paramJSONObject.optInt("producttype"));
  }
  
  public static String d(JSONObject paramJSONObject) {
    return (paramJSONObject == null) ? null : paramJSONObject.optString("cl");
  }
  
  public static boolean d(a parama) {
    return (parama == null) ? false : g(parama.E());
  }
  
  public static String e(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      String str = paramJSONObject.optString("customized_invoke_url");
      if (!StringUtil.isEmpty(str))
        return str; 
    } 
    return null;
  }
  
  public static boolean f(JSONObject paramJSONObject) {
    return (paramJSONObject == null) ? false : c(paramJSONObject.optInt("mini_program_type"));
  }
  
  public static boolean g(JSONObject paramJSONObject) {
    return (c(paramJSONObject) || f(paramJSONObject));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */