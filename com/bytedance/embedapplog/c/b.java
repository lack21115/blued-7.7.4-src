package com.bytedance.embedapplog.c;

import android.content.Context;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.IAppParam;
import org.json.JSONObject;

public class b {
  private static final String[] a = new String[] { 
      "ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", "build_serial", "carrier", "install_id", "package", 
      "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", 
      "device_id", "openudid", "clientudid", "aid" };
  
  private static final String[] b = new String[] { 
      "ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", "build_serial", "carrier", "iid", "app_name", 
      "version_name", "device_type", "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", 
      "device_id", "openudid", "clientudid", "aid" };
  
  public static String a(Context paramContext, JSONObject paramJSONObject, String paramString, boolean paramBoolean, IAppParam paramIAppParam) {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 9
    //   7: aload_2
    //   8: areturn
    //   9: new java/util/HashMap
    //   12: dup
    //   13: getstatic com/bytedance/embedapplog/c/b.a : [Ljava/lang/String;
    //   16: arraylength
    //   17: bipush #10
    //   19: iadd
    //   20: invokespecial <init> : (I)V
    //   23: astore #7
    //   25: iconst_0
    //   26: istore #6
    //   28: getstatic com/bytedance/embedapplog/c/b.a : [Ljava/lang/String;
    //   31: astore #8
    //   33: iload #6
    //   35: aload #8
    //   37: arraylength
    //   38: if_icmpge -> 84
    //   41: aload_1
    //   42: aload #8
    //   44: iload #6
    //   46: aaload
    //   47: aconst_null
    //   48: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   51: astore #8
    //   53: aload #8
    //   55: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   58: ifne -> 75
    //   61: aload #7
    //   63: getstatic com/bytedance/embedapplog/c/b.b : [Ljava/lang/String;
    //   66: iload #6
    //   68: aaload
    //   69: aload #8
    //   71: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: iload #6
    //   77: iconst_1
    //   78: iadd
    //   79: istore #6
    //   81: goto -> 28
    //   84: aload #4
    //   86: ifnull -> 596
    //   89: aload #4
    //   91: aload_0
    //   92: invokeinterface getAppSSIDs : (Landroid/content/Context;)Ljava/util/HashMap;
    //   97: astore #4
    //   99: goto -> 102
    //   102: aload_0
    //   103: invokestatic b : (Landroid/content/Context;)Z
    //   106: ifeq -> 131
    //   109: aload #4
    //   111: ifnull -> 131
    //   114: aload #7
    //   116: aload #4
    //   118: invokevirtual putAll : (Ljava/util/Map;)V
    //   121: goto -> 131
    //   124: astore #4
    //   126: aload #4
    //   128: invokestatic a : (Ljava/lang/Throwable;)V
    //   131: invokestatic getExtraParams : ()Lcom/bytedance/embedapplog/IExtraParams;
    //   134: ifnonnull -> 143
    //   137: aconst_null
    //   138: astore #4
    //   140: goto -> 153
    //   143: invokestatic getExtraParams : ()Lcom/bytedance/embedapplog/IExtraParams;
    //   146: invokeinterface getExtraParams : ()Ljava/util/HashMap;
    //   151: astore #4
    //   153: aload #4
    //   155: ifnull -> 175
    //   158: aload #7
    //   160: aload #4
    //   162: invokevirtual putAll : (Ljava/util/Map;)V
    //   165: goto -> 175
    //   168: astore #4
    //   170: aload #4
    //   172: invokestatic a : (Ljava/lang/Throwable;)V
    //   175: getstatic com/bytedance/embedapplog/AppLog.sCustomNetParams : Ljava/util/concurrent/ConcurrentHashMap;
    //   178: invokevirtual size : ()I
    //   181: ifle -> 192
    //   184: aload #7
    //   186: getstatic com/bytedance/embedapplog/AppLog.sCustomNetParams : Ljava/util/concurrent/ConcurrentHashMap;
    //   189: invokevirtual putAll : (Ljava/util/Map;)V
    //   192: iload_3
    //   193: ifeq -> 206
    //   196: aload #7
    //   198: ldc 'ssmix'
    //   200: ldc 'a'
    //   202: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   205: pop
    //   206: aload_0
    //   207: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   210: astore_0
    //   211: aload_0
    //   212: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   215: ifne -> 227
    //   218: aload #7
    //   220: ldc 'ac'
    //   222: aload_0
    //   223: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   226: pop
    //   227: ldc 'tweaked_channel'
    //   229: ldc ''
    //   231: invokestatic getHeaderValue : (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   234: checkcast java/lang/String
    //   237: astore #4
    //   239: aload #4
    //   241: astore_0
    //   242: aload #4
    //   244: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   247: ifeq -> 261
    //   250: ldc 'channel'
    //   252: ldc ''
    //   254: invokestatic getHeaderValue : (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   257: checkcast java/lang/String
    //   260: astore_0
    //   261: aload_0
    //   262: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   265: ifne -> 277
    //   268: aload #7
    //   270: ldc 'channel'
    //   272: aload_0
    //   273: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   276: pop
    //   277: aload_1
    //   278: ldc 'os_version'
    //   280: aconst_null
    //   281: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   284: astore #4
    //   286: aload #4
    //   288: astore_0
    //   289: aload #4
    //   291: ifnull -> 316
    //   294: aload #4
    //   296: astore_0
    //   297: aload #4
    //   299: invokevirtual length : ()I
    //   302: bipush #10
    //   304: if_icmple -> 316
    //   307: aload #4
    //   309: iconst_0
    //   310: bipush #10
    //   312: invokevirtual substring : (II)Ljava/lang/String;
    //   315: astore_0
    //   316: aload #7
    //   318: ldc 'os_version'
    //   320: aload_0
    //   321: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   324: pop
    //   325: aload #7
    //   327: ldc '_rticket'
    //   329: invokestatic currentTimeMillis : ()J
    //   332: invokestatic valueOf : (J)Ljava/lang/String;
    //   335: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   338: pop
    //   339: aload #7
    //   341: ldc 'device_platform'
    //   343: ldc 'android'
    //   345: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   348: pop
    //   349: ldc 'version_code'
    //   351: iconst_m1
    //   352: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   355: invokestatic getHeaderValue : (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   358: checkcast java/lang/Integer
    //   361: invokevirtual intValue : ()I
    //   364: istore #6
    //   366: iload #6
    //   368: iconst_m1
    //   369: if_icmpeq -> 385
    //   372: aload #7
    //   374: ldc 'version_code'
    //   376: iload #6
    //   378: invokestatic valueOf : (I)Ljava/lang/String;
    //   381: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   384: pop
    //   385: ldc 'manifest_version_code'
    //   387: iconst_m1
    //   388: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   391: invokestatic getHeaderValue : (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   394: checkcast java/lang/Integer
    //   397: invokevirtual intValue : ()I
    //   400: istore #6
    //   402: iload #6
    //   404: iconst_m1
    //   405: if_icmpeq -> 421
    //   408: aload #7
    //   410: ldc 'manifest_version_code'
    //   412: iload #6
    //   414: invokestatic valueOf : (I)Ljava/lang/String;
    //   417: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   420: pop
    //   421: ldc 'update_version_code'
    //   423: iconst_m1
    //   424: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   427: invokestatic getHeaderValue : (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   430: checkcast java/lang/Integer
    //   433: invokevirtual intValue : ()I
    //   436: istore #6
    //   438: iload #6
    //   440: iconst_m1
    //   441: if_icmpeq -> 457
    //   444: aload #7
    //   446: ldc 'update_version_code'
    //   448: iload #6
    //   450: invokestatic valueOf : (I)Ljava/lang/String;
    //   453: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   456: pop
    //   457: aload_1
    //   458: ldc 'oaid'
    //   460: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   463: invokestatic a : (Lorg/json/JSONObject;)Ljava/lang/String;
    //   466: astore_0
    //   467: aload_0
    //   468: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   471: ifne -> 483
    //   474: aload #7
    //   476: ldc 'oaid'
    //   478: aload_0
    //   479: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   482: pop
    //   483: aload_1
    //   484: ldc 'cdid'
    //   486: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   489: astore_0
    //   490: aload_0
    //   491: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   494: ifne -> 506
    //   497: aload #7
    //   499: ldc 'cdid'
    //   501: aload_0
    //   502: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   505: pop
    //   506: aload_2
    //   507: astore_0
    //   508: aload_2
    //   509: ldc '/'
    //   511: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   514: ifne -> 543
    //   517: new java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial <init> : ()V
    //   524: astore_0
    //   525: aload_0
    //   526: aload_2
    //   527: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload_0
    //   532: ldc '/'
    //   534: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload_0
    //   539: invokevirtual toString : ()Ljava/lang/String;
    //   542: astore_0
    //   543: new java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial <init> : ()V
    //   550: astore_1
    //   551: aload_1
    //   552: aload_0
    //   553: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: bipush #63
    //   559: istore #5
    //   561: aload_0
    //   562: bipush #63
    //   564: invokevirtual indexOf : (I)I
    //   567: ifge -> 573
    //   570: goto -> 577
    //   573: bipush #38
    //   575: istore #5
    //   577: aload_1
    //   578: iload #5
    //   580: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload_1
    //   585: invokevirtual toString : ()Ljava/lang/String;
    //   588: aload #7
    //   590: ldc 'UTF-8'
    //   592: invokestatic a : (Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;)Ljava/lang/String;
    //   595: areturn
    //   596: aconst_null
    //   597: astore #4
    //   599: goto -> 102
    // Exception table:
    //   from	to	target	type
    //   89	99	124	java/lang/Exception
    //   102	109	124	java/lang/Exception
    //   114	121	124	java/lang/Exception
    //   131	137	168	java/lang/Exception
    //   143	153	168	java/lang/Exception
    //   158	165	168	java/lang/Exception
  }
  
  public static String[] a(Context paramContext, JSONObject paramJSONObject) {
    String str;
    String[] arrayOfString = new String[(a.a().getSendHeadersUris()).length];
    if (AppLog.getEncryptAndCompress()) {
      str = "/service/2/app_log/?tt_data=a";
    } else {
      str = "/service/2/app_log/?";
    } 
    for (int i = 0; i < (a.a().getSendHeadersUris()).length; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a.a().getSendHeadersUris()[i]);
      stringBuilder.append(str);
      arrayOfString[i] = a(paramContext, paramJSONObject, stringBuilder.toString(), true, AppLog.getIAppParam());
      arrayOfString[i] = a.a(arrayOfString[i], a.b);
    } 
    return arrayOfString;
  }
  
  public static String b(Context paramContext, JSONObject paramJSONObject) {
    String str;
    if (AppLog.getEncryptAndCompress()) {
      str = "/service/2/app_log/?tt_data=a";
    } else {
      str = "/service/2/app_log/?";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a.a().getSuccRateUri());
    stringBuilder.append(str);
    return a(paramContext, paramJSONObject, stringBuilder.toString(), true, AppLog.getIAppParam());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */