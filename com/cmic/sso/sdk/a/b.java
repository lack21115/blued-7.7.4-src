package com.cmic.sso.sdk.a;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.cmic.sso.sdk.utils.f;
import com.cmic.sso.sdk.utils.k;
import com.cmic.sso.sdk.utils.t;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class b {
  private static b a;
  
  private static long b;
  
  private b c = null;
  
  private SubscriptionInfo a(Object paramObject, String paramString, Object[] paramArrayOfObject) throws a {
    return (SubscriptionInfo)a(paramObject, paramString, paramArrayOfObject, null);
  }
  
  private SubscriptionInfo a(List<SubscriptionInfo> paramList, int paramInt) {
    SubscriptionInfo subscriptionInfo2 = paramList.get(0);
    Iterator<SubscriptionInfo> iterator = paramList.iterator();
    SubscriptionInfo subscriptionInfo1 = subscriptionInfo2;
    while (iterator.hasNext()) {
      subscriptionInfo2 = iterator.next();
      if (subscriptionInfo2.getSimSlotIndex() == paramInt)
        subscriptionInfo1 = subscriptionInfo2; 
    } 
    return subscriptionInfo1;
  }
  
  public static b a() {
    if (a == null)
      a = new b(); 
    return a;
  }
  
  private Object a(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass) throws a {
    try {
      Class<?> clazz = Class.forName(paramObject.getClass().getName());
      return (paramArrayOfObject != null && paramArrayOfClass != null) ? clazz.getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject) : clazz.getMethod(paramString, new Class[0]).invoke(paramObject, new Object[0]);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(" 反射出错");
      f.a("UMCTelephonyManagement", stringBuilder.toString());
      throw new a(paramString);
    } 
  }
  
  private String a(TelephonyManager paramTelephonyManager, String paramString, int paramInt) throws a {
    Class<int> clazz = int.class;
    Object object = a(paramTelephonyManager, paramString, new Object[] { Integer.valueOf(paramInt) }, new Class[] { clazz });
    return (object != null) ? object.toString() : null;
  }
  
  private String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("operatorChina = ");
    stringBuilder.append(paramString);
    f.b("UMCTelephonyManagement", stringBuilder.toString());
    return paramString.contains("中国移动") ? "46000" : (paramString.contains("中国联通") ? "46001" : (paramString.contains("中国电信") ? "46003" : ""));
  }
  
  private void a(List<SubscriptionInfo> paramList, TelephonyManager paramTelephonyManager) {
    SubscriptionInfo subscriptionInfo;
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    } 
    if (i == 1) {
      subscriptionInfo = paramList.get(0);
    } else if (i > 1) {
      subscriptionInfo = a((List<SubscriptionInfo>)subscriptionInfo, 0);
    } else {
      return;
    } 
    b.a(this.c, subscriptionInfo.getIccId());
    this.c.c(subscriptionInfo.getSimSlotIndex());
    this.c.e(subscriptionInfo.getSubscriptionId());
    b b1 = this.c;
    b.b(b1, b(b.g(b1)));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("readSim1Info1 iccid1 = ");
    stringBuilder.append(b.g(this.c));
    f.b("UMCTelephonyManagement", stringBuilder.toString());
    if (b.b(this.c) == -1 && b.a(this.c) == subscriptionInfo.getSubscriptionId()) {
      b.a(this.c, subscriptionInfo.getSimSlotIndex());
      stringBuilder = new StringBuilder();
      stringBuilder.append("readSim1Info1 dataSlotId = ");
      stringBuilder.append(b.b(this.c));
      f.b("UMCTelephonyManagement", stringBuilder.toString());
    } 
    if (!t.e())
      return; 
    try {
      this.c.a(a(paramTelephonyManager, "getDeviceId", subscriptionInfo.getSimSlotIndex()));
    } catch (a a) {
      try {
        this.c.a(a(paramTelephonyManager, "getDeviceIdGemini", subscriptionInfo.getSimSlotIndex()));
      } catch (a a1) {
        try {
          this.c.a(paramTelephonyManager.getDeviceId());
        } catch (Exception exception) {
          f.a("UMCTelephonyManagement", "readSim1Info imei1 failed");
        } 
      } 
    } 
    if (a.a() == 0) {
      i = subscriptionInfo.getSimSlotIndex();
    } else {
      i = subscriptionInfo.getSubscriptionId();
    } 
    try {
      this.c.c(a(paramTelephonyManager, "getSubscriberId", subscriptionInfo.getSubscriptionId()));
    } catch (a a) {
      try {
        this.c.c(a(paramTelephonyManager, "getSubscriberIdGemini", i));
      } catch (a a1) {
        try {
          this.c.c(paramTelephonyManager.getSubscriberId());
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      } 
    } 
    try {
      this.c.e(a(paramTelephonyManager, "getSimOperator", subscriptionInfo.getSubscriptionId()));
      return;
    } catch (a a) {
      try {
        this.c.e(a(paramTelephonyManager, "getSimOperatorGemini", i));
        return;
      } catch (a a1) {
        this.c.e(paramTelephonyManager.getSimOperator());
      } 
    } 
  }
  
  private String b(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: istore #4
    //   6: bipush #6
    //   8: istore_2
    //   9: iload #4
    //   11: ifeq -> 26
    //   14: aload_1
    //   15: invokevirtual length : ()I
    //   18: bipush #6
    //   20: if_icmpge -> 26
    //   23: ldc ''
    //   25: areturn
    //   26: aload_1
    //   27: iconst_0
    //   28: bipush #6
    //   30: invokevirtual substring : (II)Ljava/lang/String;
    //   33: astore_1
    //   34: new java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial <init> : ()V
    //   41: astore #5
    //   43: aload #5
    //   45: ldc 'operatorFlag = '
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload #5
    //   53: aload_1
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: ldc 'UMCTelephonyManagement'
    //   60: aload #5
    //   62: invokevirtual toString : ()Ljava/lang/String;
    //   65: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_1
    //   69: invokevirtual hashCode : ()I
    //   72: istore_3
    //   73: iload_3
    //   74: ldc 1657594888
    //   76: if_icmpeq -> 268
    //   79: iload_3
    //   80: ldc 1657594911
    //   82: if_icmpeq -> 252
    //   85: iload_3
    //   86: tableswitch default -> 120, 1657594879 -> 237, 1657594880 -> 222, 1657594881 -> 207, 1657594882 -> 191, 1657594883 -> 176
    //   120: iload_3
    //   121: tableswitch default -> 144, 1657594885 -> 161, 1657594886 -> 147
    //   144: goto -> 281
    //   147: aload_1
    //   148: ldc '898607'
    //   150: invokevirtual equals : (Ljava/lang/Object;)Z
    //   153: ifeq -> 281
    //   156: iconst_3
    //   157: istore_2
    //   158: goto -> 283
    //   161: aload_1
    //   162: ldc_w '898606'
    //   165: invokevirtual equals : (Ljava/lang/Object;)Z
    //   168: ifeq -> 281
    //   171: iconst_5
    //   172: istore_2
    //   173: goto -> 283
    //   176: aload_1
    //   177: ldc_w '898604'
    //   180: invokevirtual equals : (Ljava/lang/Object;)Z
    //   183: ifeq -> 281
    //   186: iconst_2
    //   187: istore_2
    //   188: goto -> 283
    //   191: aload_1
    //   192: ldc_w '898603'
    //   195: invokevirtual equals : (Ljava/lang/Object;)Z
    //   198: ifeq -> 281
    //   201: bipush #7
    //   203: istore_2
    //   204: goto -> 283
    //   207: aload_1
    //   208: ldc_w '898602'
    //   211: invokevirtual equals : (Ljava/lang/Object;)Z
    //   214: ifeq -> 281
    //   217: iconst_1
    //   218: istore_2
    //   219: goto -> 283
    //   222: aload_1
    //   223: ldc_w '898601'
    //   226: invokevirtual equals : (Ljava/lang/Object;)Z
    //   229: ifeq -> 281
    //   232: iconst_4
    //   233: istore_2
    //   234: goto -> 283
    //   237: aload_1
    //   238: ldc_w '898600'
    //   241: invokevirtual equals : (Ljava/lang/Object;)Z
    //   244: ifeq -> 281
    //   247: iconst_0
    //   248: istore_2
    //   249: goto -> 283
    //   252: aload_1
    //   253: ldc_w '898611'
    //   256: invokevirtual equals : (Ljava/lang/Object;)Z
    //   259: ifeq -> 281
    //   262: bipush #8
    //   264: istore_2
    //   265: goto -> 283
    //   268: aload_1
    //   269: ldc_w '898609'
    //   272: invokevirtual equals : (Ljava/lang/Object;)Z
    //   275: ifeq -> 281
    //   278: goto -> 283
    //   281: iconst_m1
    //   282: istore_2
    //   283: iload_2
    //   284: tableswitch default -> 336, 0 -> 345, 1 -> 345, 2 -> 345, 3 -> 345, 4 -> 342, 5 -> 342, 6 -> 342, 7 -> 339, 8 -> 339
    //   336: ldc ''
    //   338: areturn
    //   339: ldc '46003'
    //   341: areturn
    //   342: ldc '46001'
    //   344: areturn
    //   345: ldc '46000'
    //   347: areturn
  }
  
  private void b(Context paramContext) {
    // Byte code:
    //   0: ldc 'UMCTelephonyManagement'
    //   2: ldc_w 'readSimInfoDbStart'
    //   5: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   8: ldc_w 'content://telephony/siminfo'
    //   11: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   14: astore #5
    //   16: aload_1
    //   17: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   20: astore #6
    //   22: aconst_null
    //   23: astore_1
    //   24: aconst_null
    //   25: astore #4
    //   27: aload #6
    //   29: aload #5
    //   31: bipush #6
    //   33: anewarray java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w '_id'
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: ldc_w 'icc_id'
    //   47: aastore
    //   48: dup
    //   49: iconst_2
    //   50: ldc_w 'sim_id'
    //   53: aastore
    //   54: dup
    //   55: iconst_3
    //   56: ldc_w 'mcc'
    //   59: aastore
    //   60: dup
    //   61: iconst_4
    //   62: ldc_w 'mnc'
    //   65: aastore
    //   66: dup
    //   67: iconst_5
    //   68: ldc_w 'carrier_name'
    //   71: aastore
    //   72: ldc_w 'sim_id>=?'
    //   75: iconst_1
    //   76: anewarray java/lang/String
    //   79: dup
    //   80: iconst_0
    //   81: ldc_w '0'
    //   84: aastore
    //   85: aconst_null
    //   86: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   89: astore #5
    //   91: aload #5
    //   93: ifnull -> 1735
    //   96: aload #5
    //   98: astore #4
    //   100: aload #5
    //   102: astore_1
    //   103: aload #5
    //   105: invokeinterface moveToNext : ()Z
    //   110: ifeq -> 1735
    //   113: aload #5
    //   115: astore #4
    //   117: aload #5
    //   119: astore_1
    //   120: aload #5
    //   122: aload #5
    //   124: ldc_w 'icc_id'
    //   127: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   132: invokeinterface getString : (I)Ljava/lang/String;
    //   137: astore #10
    //   139: aload #5
    //   141: astore #4
    //   143: aload #5
    //   145: astore_1
    //   146: aload #5
    //   148: aload #5
    //   150: ldc_w 'sim_id'
    //   153: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   158: invokeinterface getInt : (I)I
    //   163: istore_2
    //   164: aload #5
    //   166: astore #4
    //   168: aload #5
    //   170: astore_1
    //   171: aload #5
    //   173: aload #5
    //   175: ldc_w '_id'
    //   178: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   183: invokeinterface getInt : (I)I
    //   188: istore_3
    //   189: aload #5
    //   191: astore #4
    //   193: aload #5
    //   195: astore_1
    //   196: aload #5
    //   198: aload #5
    //   200: ldc_w 'mcc'
    //   203: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   208: invokeinterface getString : (I)Ljava/lang/String;
    //   213: astore #9
    //   215: aload #5
    //   217: astore #4
    //   219: aload #5
    //   221: astore_1
    //   222: aload #5
    //   224: aload #5
    //   226: ldc_w 'mnc'
    //   229: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   234: invokeinterface getString : (I)Ljava/lang/String;
    //   239: astore #6
    //   241: aload #5
    //   243: astore #4
    //   245: aload #5
    //   247: astore_1
    //   248: aload #5
    //   250: aload #5
    //   252: ldc_w 'carrier_name'
    //   255: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   260: invokeinterface getString : (I)Ljava/lang/String;
    //   265: astore #8
    //   267: aload #5
    //   269: astore #4
    //   271: aload #5
    //   273: astore_1
    //   274: aload_0
    //   275: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   278: invokestatic b : (Lcom/cmic/sso/sdk/a/b$b;)I
    //   281: iconst_m1
    //   282: if_icmpne -> 400
    //   285: aload #5
    //   287: astore #4
    //   289: aload #5
    //   291: astore_1
    //   292: aload_0
    //   293: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   296: invokestatic a : (Lcom/cmic/sso/sdk/a/b$b;)I
    //   299: iconst_m1
    //   300: if_icmpeq -> 400
    //   303: aload #5
    //   305: astore #4
    //   307: aload #5
    //   309: astore_1
    //   310: aload_0
    //   311: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   314: invokestatic a : (Lcom/cmic/sso/sdk/a/b$b;)I
    //   317: iload_3
    //   318: if_icmpne -> 400
    //   321: aload #5
    //   323: astore #4
    //   325: aload #5
    //   327: astore_1
    //   328: aload_0
    //   329: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   332: iload_2
    //   333: invokestatic a : (Lcom/cmic/sso/sdk/a/b$b;I)I
    //   336: pop
    //   337: aload #5
    //   339: astore #4
    //   341: aload #5
    //   343: astore_1
    //   344: new java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial <init> : ()V
    //   351: astore #7
    //   353: aload #5
    //   355: astore #4
    //   357: aload #5
    //   359: astore_1
    //   360: aload #7
    //   362: ldc_w '通过读取sim db获取数据流量卡的卡槽值：'
    //   365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload #5
    //   371: astore #4
    //   373: aload #5
    //   375: astore_1
    //   376: aload #7
    //   378: iload_2
    //   379: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload #5
    //   385: astore #4
    //   387: aload #5
    //   389: astore_1
    //   390: ldc 'UMCTelephonyManagement'
    //   392: aload #7
    //   394: invokevirtual toString : ()Ljava/lang/String;
    //   397: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload #5
    //   402: astore #4
    //   404: aload #5
    //   406: astore_1
    //   407: aload_0
    //   408: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   411: invokestatic b : (Lcom/cmic/sso/sdk/a/b$b;)I
    //   414: iload_2
    //   415: if_icmpne -> 447
    //   418: aload #5
    //   420: astore #4
    //   422: aload #5
    //   424: astore_1
    //   425: invokestatic d : ()Z
    //   428: ifne -> 447
    //   431: aload #5
    //   433: astore #4
    //   435: aload #5
    //   437: astore_1
    //   438: aload_0
    //   439: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   442: iload_3
    //   443: invokestatic b : (Lcom/cmic/sso/sdk/a/b$b;I)I
    //   446: pop
    //   447: iload_2
    //   448: ifne -> 890
    //   451: aload #5
    //   453: astore #4
    //   455: aload #5
    //   457: astore_1
    //   458: aload_0
    //   459: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   462: aload #10
    //   464: invokestatic a : (Lcom/cmic/sso/sdk/a/b$b;Ljava/lang/String;)Ljava/lang/String;
    //   467: pop
    //   468: aload #5
    //   470: astore #4
    //   472: aload #5
    //   474: astore_1
    //   475: aload_0
    //   476: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   479: iload_3
    //   480: invokestatic c : (Lcom/cmic/sso/sdk/a/b$b;I)I
    //   483: pop
    //   484: aload #5
    //   486: astore #4
    //   488: aload #5
    //   490: astore_1
    //   491: aload_0
    //   492: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   495: invokestatic c : (Lcom/cmic/sso/sdk/a/b$b;)I
    //   498: iconst_m1
    //   499: if_icmpne -> 518
    //   502: aload #5
    //   504: astore #4
    //   506: aload #5
    //   508: astore_1
    //   509: aload_0
    //   510: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   513: iload_2
    //   514: invokestatic d : (Lcom/cmic/sso/sdk/a/b$b;I)I
    //   517: pop
    //   518: aload #5
    //   520: astore #4
    //   522: aload #5
    //   524: astore_1
    //   525: aload_0
    //   526: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   529: invokestatic d : (Lcom/cmic/sso/sdk/a/b$b;)Ljava/lang/String;
    //   532: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   535: ifeq -> 600
    //   538: aload #5
    //   540: astore #4
    //   542: aload #5
    //   544: astore_1
    //   545: aload #8
    //   547: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   550: ifne -> 600
    //   553: aload #5
    //   555: astore #4
    //   557: aload #5
    //   559: astore_1
    //   560: aload_0
    //   561: aload #8
    //   563: invokespecial a : (Ljava/lang/String;)Ljava/lang/String;
    //   566: astore #7
    //   568: aload #5
    //   570: astore #4
    //   572: aload #5
    //   574: astore_1
    //   575: aload #7
    //   577: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   580: ifne -> 600
    //   583: aload #5
    //   585: astore #4
    //   587: aload #5
    //   589: astore_1
    //   590: aload_0
    //   591: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   594: aload #7
    //   596: invokestatic b : (Lcom/cmic/sso/sdk/a/b$b;Ljava/lang/String;)Ljava/lang/String;
    //   599: pop
    //   600: aload #5
    //   602: astore #4
    //   604: aload #5
    //   606: astore_1
    //   607: aload_0
    //   608: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   611: invokestatic d : (Lcom/cmic/sso/sdk/a/b$b;)Ljava/lang/String;
    //   614: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   617: ifeq -> 667
    //   620: aload #5
    //   622: astore #4
    //   624: aload #5
    //   626: astore_1
    //   627: aload_0
    //   628: aload #10
    //   630: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   633: astore #7
    //   635: aload #5
    //   637: astore #4
    //   639: aload #5
    //   641: astore_1
    //   642: aload #7
    //   644: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   647: ifne -> 667
    //   650: aload #5
    //   652: astore #4
    //   654: aload #5
    //   656: astore_1
    //   657: aload_0
    //   658: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   661: aload #7
    //   663: invokestatic b : (Lcom/cmic/sso/sdk/a/b$b;Ljava/lang/String;)Ljava/lang/String;
    //   666: pop
    //   667: aload #6
    //   669: astore #7
    //   671: aload #5
    //   673: astore #4
    //   675: aload #5
    //   677: astore_1
    //   678: aload_0
    //   679: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   682: invokestatic d : (Lcom/cmic/sso/sdk/a/b$b;)Ljava/lang/String;
    //   685: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   688: ifeq -> 1335
    //   691: aload #6
    //   693: astore #7
    //   695: aload #5
    //   697: astore #4
    //   699: aload #5
    //   701: astore_1
    //   702: aload #9
    //   704: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   707: ifne -> 1335
    //   710: aload #6
    //   712: astore #7
    //   714: aload #5
    //   716: astore #4
    //   718: aload #5
    //   720: astore_1
    //   721: aload #6
    //   723: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   726: ifne -> 1335
    //   729: aload #6
    //   731: astore #7
    //   733: aload #5
    //   735: astore #4
    //   737: aload #5
    //   739: astore_1
    //   740: aload #6
    //   742: invokevirtual length : ()I
    //   745: iconst_1
    //   746: if_icmpne -> 810
    //   749: aload #5
    //   751: astore #4
    //   753: aload #5
    //   755: astore_1
    //   756: new java/lang/StringBuilder
    //   759: dup
    //   760: invokespecial <init> : ()V
    //   763: astore #7
    //   765: aload #5
    //   767: astore #4
    //   769: aload #5
    //   771: astore_1
    //   772: aload #7
    //   774: ldc_w '0'
    //   777: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: aload #5
    //   783: astore #4
    //   785: aload #5
    //   787: astore_1
    //   788: aload #7
    //   790: aload #6
    //   792: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload #5
    //   798: astore #4
    //   800: aload #5
    //   802: astore_1
    //   803: aload #7
    //   805: invokevirtual toString : ()Ljava/lang/String;
    //   808: astore #7
    //   810: aload #5
    //   812: astore #4
    //   814: aload #5
    //   816: astore_1
    //   817: aload_0
    //   818: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   821: astore #6
    //   823: aload #5
    //   825: astore #4
    //   827: aload #5
    //   829: astore_1
    //   830: new java/lang/StringBuilder
    //   833: dup
    //   834: invokespecial <init> : ()V
    //   837: astore #11
    //   839: aload #5
    //   841: astore #4
    //   843: aload #5
    //   845: astore_1
    //   846: aload #11
    //   848: aload #9
    //   850: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: pop
    //   854: aload #5
    //   856: astore #4
    //   858: aload #5
    //   860: astore_1
    //   861: aload #11
    //   863: aload #7
    //   865: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: pop
    //   869: aload #5
    //   871: astore #4
    //   873: aload #5
    //   875: astore_1
    //   876: aload #6
    //   878: aload #11
    //   880: invokevirtual toString : ()Ljava/lang/String;
    //   883: invokestatic b : (Lcom/cmic/sso/sdk/a/b$b;Ljava/lang/String;)Ljava/lang/String;
    //   886: pop
    //   887: goto -> 1335
    //   890: aload #6
    //   892: astore #7
    //   894: iload_2
    //   895: iconst_1
    //   896: if_icmpne -> 1335
    //   899: aload #5
    //   901: astore #4
    //   903: aload #5
    //   905: astore_1
    //   906: aload_0
    //   907: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   910: aload #10
    //   912: invokestatic c : (Lcom/cmic/sso/sdk/a/b$b;Ljava/lang/String;)Ljava/lang/String;
    //   915: pop
    //   916: aload #5
    //   918: astore #4
    //   920: aload #5
    //   922: astore_1
    //   923: aload_0
    //   924: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   927: iload_3
    //   928: invokestatic e : (Lcom/cmic/sso/sdk/a/b$b;I)I
    //   931: pop
    //   932: aload #5
    //   934: astore #4
    //   936: aload #5
    //   938: astore_1
    //   939: aload_0
    //   940: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   943: invokestatic e : (Lcom/cmic/sso/sdk/a/b$b;)I
    //   946: iconst_m1
    //   947: if_icmpne -> 966
    //   950: aload #5
    //   952: astore #4
    //   954: aload #5
    //   956: astore_1
    //   957: aload_0
    //   958: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   961: iload_2
    //   962: invokestatic f : (Lcom/cmic/sso/sdk/a/b$b;I)I
    //   965: pop
    //   966: aload #5
    //   968: astore #4
    //   970: aload #5
    //   972: astore_1
    //   973: aload_0
    //   974: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   977: invokestatic f : (Lcom/cmic/sso/sdk/a/b$b;)Ljava/lang/String;
    //   980: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   983: ifeq -> 1048
    //   986: aload #5
    //   988: astore #4
    //   990: aload #5
    //   992: astore_1
    //   993: aload #8
    //   995: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   998: ifne -> 1048
    //   1001: aload #5
    //   1003: astore #4
    //   1005: aload #5
    //   1007: astore_1
    //   1008: aload_0
    //   1009: aload #8
    //   1011: invokespecial a : (Ljava/lang/String;)Ljava/lang/String;
    //   1014: astore #7
    //   1016: aload #5
    //   1018: astore #4
    //   1020: aload #5
    //   1022: astore_1
    //   1023: aload #7
    //   1025: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1028: ifne -> 1048
    //   1031: aload #5
    //   1033: astore #4
    //   1035: aload #5
    //   1037: astore_1
    //   1038: aload_0
    //   1039: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   1042: aload #7
    //   1044: invokestatic d : (Lcom/cmic/sso/sdk/a/b$b;Ljava/lang/String;)Ljava/lang/String;
    //   1047: pop
    //   1048: aload #5
    //   1050: astore #4
    //   1052: aload #5
    //   1054: astore_1
    //   1055: aload_0
    //   1056: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   1059: invokestatic f : (Lcom/cmic/sso/sdk/a/b$b;)Ljava/lang/String;
    //   1062: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1065: ifeq -> 1115
    //   1068: aload #5
    //   1070: astore #4
    //   1072: aload #5
    //   1074: astore_1
    //   1075: aload_0
    //   1076: aload #10
    //   1078: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   1081: astore #7
    //   1083: aload #5
    //   1085: astore #4
    //   1087: aload #5
    //   1089: astore_1
    //   1090: aload #7
    //   1092: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1095: ifne -> 1115
    //   1098: aload #5
    //   1100: astore #4
    //   1102: aload #5
    //   1104: astore_1
    //   1105: aload_0
    //   1106: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   1109: aload #7
    //   1111: invokestatic d : (Lcom/cmic/sso/sdk/a/b$b;Ljava/lang/String;)Ljava/lang/String;
    //   1114: pop
    //   1115: aload #6
    //   1117: astore #7
    //   1119: aload #5
    //   1121: astore #4
    //   1123: aload #5
    //   1125: astore_1
    //   1126: aload_0
    //   1127: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   1130: invokestatic f : (Lcom/cmic/sso/sdk/a/b$b;)Ljava/lang/String;
    //   1133: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1136: ifeq -> 1335
    //   1139: aload #6
    //   1141: astore #7
    //   1143: aload #5
    //   1145: astore #4
    //   1147: aload #5
    //   1149: astore_1
    //   1150: aload #9
    //   1152: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1155: ifne -> 1335
    //   1158: aload #6
    //   1160: astore #7
    //   1162: aload #5
    //   1164: astore #4
    //   1166: aload #5
    //   1168: astore_1
    //   1169: aload #6
    //   1171: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1174: ifne -> 1335
    //   1177: aload #6
    //   1179: astore #7
    //   1181: aload #5
    //   1183: astore #4
    //   1185: aload #5
    //   1187: astore_1
    //   1188: aload #6
    //   1190: invokevirtual length : ()I
    //   1193: iconst_1
    //   1194: if_icmpne -> 1258
    //   1197: aload #5
    //   1199: astore #4
    //   1201: aload #5
    //   1203: astore_1
    //   1204: new java/lang/StringBuilder
    //   1207: dup
    //   1208: invokespecial <init> : ()V
    //   1211: astore #7
    //   1213: aload #5
    //   1215: astore #4
    //   1217: aload #5
    //   1219: astore_1
    //   1220: aload #7
    //   1222: ldc_w '0'
    //   1225: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1228: pop
    //   1229: aload #5
    //   1231: astore #4
    //   1233: aload #5
    //   1235: astore_1
    //   1236: aload #7
    //   1238: aload #6
    //   1240: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: pop
    //   1244: aload #5
    //   1246: astore #4
    //   1248: aload #5
    //   1250: astore_1
    //   1251: aload #7
    //   1253: invokevirtual toString : ()Ljava/lang/String;
    //   1256: astore #7
    //   1258: aload #5
    //   1260: astore #4
    //   1262: aload #5
    //   1264: astore_1
    //   1265: aload_0
    //   1266: getfield c : Lcom/cmic/sso/sdk/a/b$b;
    //   1269: astore #6
    //   1271: aload #5
    //   1273: astore #4
    //   1275: aload #5
    //   1277: astore_1
    //   1278: new java/lang/StringBuilder
    //   1281: dup
    //   1282: invokespecial <init> : ()V
    //   1285: astore #11
    //   1287: aload #5
    //   1289: astore #4
    //   1291: aload #5
    //   1293: astore_1
    //   1294: aload #11
    //   1296: aload #9
    //   1298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1301: pop
    //   1302: aload #5
    //   1304: astore #4
    //   1306: aload #5
    //   1308: astore_1
    //   1309: aload #11
    //   1311: aload #7
    //   1313: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: pop
    //   1317: aload #5
    //   1319: astore #4
    //   1321: aload #5
    //   1323: astore_1
    //   1324: aload #6
    //   1326: aload #11
    //   1328: invokevirtual toString : ()Ljava/lang/String;
    //   1331: invokestatic d : (Lcom/cmic/sso/sdk/a/b$b;Ljava/lang/String;)Ljava/lang/String;
    //   1334: pop
    //   1335: aload #5
    //   1337: astore #4
    //   1339: aload #5
    //   1341: astore_1
    //   1342: new java/lang/StringBuilder
    //   1345: dup
    //   1346: invokespecial <init> : ()V
    //   1349: astore #6
    //   1351: aload #5
    //   1353: astore #4
    //   1355: aload #5
    //   1357: astore_1
    //   1358: aload #6
    //   1360: ldc_w 'icc_id-->'
    //   1363: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1366: pop
    //   1367: aload #5
    //   1369: astore #4
    //   1371: aload #5
    //   1373: astore_1
    //   1374: aload #6
    //   1376: aload #10
    //   1378: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: pop
    //   1382: aload #5
    //   1384: astore #4
    //   1386: aload #5
    //   1388: astore_1
    //   1389: ldc 'UMCTelephonyManagement'
    //   1391: aload #6
    //   1393: invokevirtual toString : ()Ljava/lang/String;
    //   1396: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1399: aload #5
    //   1401: astore #4
    //   1403: aload #5
    //   1405: astore_1
    //   1406: new java/lang/StringBuilder
    //   1409: dup
    //   1410: invokespecial <init> : ()V
    //   1413: astore #6
    //   1415: aload #5
    //   1417: astore #4
    //   1419: aload #5
    //   1421: astore_1
    //   1422: aload #6
    //   1424: ldc_w 'sim_id-->'
    //   1427: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: pop
    //   1431: aload #5
    //   1433: astore #4
    //   1435: aload #5
    //   1437: astore_1
    //   1438: aload #6
    //   1440: iload_2
    //   1441: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1444: pop
    //   1445: aload #5
    //   1447: astore #4
    //   1449: aload #5
    //   1451: astore_1
    //   1452: ldc 'UMCTelephonyManagement'
    //   1454: aload #6
    //   1456: invokevirtual toString : ()Ljava/lang/String;
    //   1459: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1462: aload #5
    //   1464: astore #4
    //   1466: aload #5
    //   1468: astore_1
    //   1469: new java/lang/StringBuilder
    //   1472: dup
    //   1473: invokespecial <init> : ()V
    //   1476: astore #6
    //   1478: aload #5
    //   1480: astore #4
    //   1482: aload #5
    //   1484: astore_1
    //   1485: aload #6
    //   1487: ldc_w 'subId或者说是_id->'
    //   1490: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1493: pop
    //   1494: aload #5
    //   1496: astore #4
    //   1498: aload #5
    //   1500: astore_1
    //   1501: aload #6
    //   1503: iload_3
    //   1504: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1507: pop
    //   1508: aload #5
    //   1510: astore #4
    //   1512: aload #5
    //   1514: astore_1
    //   1515: ldc 'UMCTelephonyManagement'
    //   1517: aload #6
    //   1519: invokevirtual toString : ()Ljava/lang/String;
    //   1522: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1525: aload #5
    //   1527: astore #4
    //   1529: aload #5
    //   1531: astore_1
    //   1532: new java/lang/StringBuilder
    //   1535: dup
    //   1536: invokespecial <init> : ()V
    //   1539: astore #6
    //   1541: aload #5
    //   1543: astore #4
    //   1545: aload #5
    //   1547: astore_1
    //   1548: aload #6
    //   1550: ldc_w 'mcc_string--->'
    //   1553: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: pop
    //   1557: aload #5
    //   1559: astore #4
    //   1561: aload #5
    //   1563: astore_1
    //   1564: aload #6
    //   1566: aload #7
    //   1568: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1571: pop
    //   1572: aload #5
    //   1574: astore #4
    //   1576: aload #5
    //   1578: astore_1
    //   1579: ldc 'UMCTelephonyManagement'
    //   1581: aload #6
    //   1583: invokevirtual toString : ()Ljava/lang/String;
    //   1586: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1589: aload #5
    //   1591: astore #4
    //   1593: aload #5
    //   1595: astore_1
    //   1596: new java/lang/StringBuilder
    //   1599: dup
    //   1600: invokespecial <init> : ()V
    //   1603: astore #6
    //   1605: aload #5
    //   1607: astore #4
    //   1609: aload #5
    //   1611: astore_1
    //   1612: aload #6
    //   1614: ldc_w 'mnc_string--->'
    //   1617: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: pop
    //   1621: aload #5
    //   1623: astore #4
    //   1625: aload #5
    //   1627: astore_1
    //   1628: aload #6
    //   1630: aload #9
    //   1632: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1635: pop
    //   1636: aload #5
    //   1638: astore #4
    //   1640: aload #5
    //   1642: astore_1
    //   1643: ldc 'UMCTelephonyManagement'
    //   1645: aload #6
    //   1647: invokevirtual toString : ()Ljava/lang/String;
    //   1650: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1653: aload #5
    //   1655: astore #4
    //   1657: aload #5
    //   1659: astore_1
    //   1660: new java/lang/StringBuilder
    //   1663: dup
    //   1664: invokespecial <init> : ()V
    //   1667: astore #6
    //   1669: aload #5
    //   1671: astore #4
    //   1673: aload #5
    //   1675: astore_1
    //   1676: aload #6
    //   1678: ldc_w 'carrier_name----->'
    //   1681: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1684: pop
    //   1685: aload #5
    //   1687: astore #4
    //   1689: aload #5
    //   1691: astore_1
    //   1692: aload #6
    //   1694: aload #8
    //   1696: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1699: pop
    //   1700: aload #5
    //   1702: astore #4
    //   1704: aload #5
    //   1706: astore_1
    //   1707: ldc 'UMCTelephonyManagement'
    //   1709: aload #6
    //   1711: invokevirtual toString : ()Ljava/lang/String;
    //   1714: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1717: aload #5
    //   1719: astore #4
    //   1721: aload #5
    //   1723: astore_1
    //   1724: ldc 'UMCTelephonyManagement'
    //   1726: ldc_w '---------------------------------'
    //   1729: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1732: goto -> 96
    //   1735: aload #5
    //   1737: ifnull -> 1771
    //   1740: aload #5
    //   1742: astore_1
    //   1743: goto -> 1765
    //   1746: astore_1
    //   1747: goto -> 1780
    //   1750: aload_1
    //   1751: astore #4
    //   1753: ldc 'UMCTelephonyManagement'
    //   1755: ldc_w 'readSimInfoDb error'
    //   1758: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1761: aload_1
    //   1762: ifnull -> 1771
    //   1765: aload_1
    //   1766: invokeinterface close : ()V
    //   1771: ldc 'UMCTelephonyManagement'
    //   1773: ldc_w 'readSimInfoDbEnd'
    //   1776: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1779: return
    //   1780: aload #4
    //   1782: ifnull -> 1792
    //   1785: aload #4
    //   1787: invokeinterface close : ()V
    //   1792: aload_1
    //   1793: athrow
    //   1794: astore #4
    //   1796: goto -> 1750
    // Exception table:
    //   from	to	target	type
    //   27	91	1794	java/lang/Exception
    //   27	91	1746	finally
    //   103	113	1794	java/lang/Exception
    //   103	113	1746	finally
    //   120	139	1794	java/lang/Exception
    //   120	139	1746	finally
    //   146	164	1794	java/lang/Exception
    //   146	164	1746	finally
    //   171	189	1794	java/lang/Exception
    //   171	189	1746	finally
    //   196	215	1794	java/lang/Exception
    //   196	215	1746	finally
    //   222	241	1794	java/lang/Exception
    //   222	241	1746	finally
    //   248	267	1794	java/lang/Exception
    //   248	267	1746	finally
    //   274	285	1794	java/lang/Exception
    //   274	285	1746	finally
    //   292	303	1794	java/lang/Exception
    //   292	303	1746	finally
    //   310	321	1794	java/lang/Exception
    //   310	321	1746	finally
    //   328	337	1794	java/lang/Exception
    //   328	337	1746	finally
    //   344	353	1794	java/lang/Exception
    //   344	353	1746	finally
    //   360	369	1794	java/lang/Exception
    //   360	369	1746	finally
    //   376	383	1794	java/lang/Exception
    //   376	383	1746	finally
    //   390	400	1794	java/lang/Exception
    //   390	400	1746	finally
    //   407	418	1794	java/lang/Exception
    //   407	418	1746	finally
    //   425	431	1794	java/lang/Exception
    //   425	431	1746	finally
    //   438	447	1794	java/lang/Exception
    //   438	447	1746	finally
    //   458	468	1794	java/lang/Exception
    //   458	468	1746	finally
    //   475	484	1794	java/lang/Exception
    //   475	484	1746	finally
    //   491	502	1794	java/lang/Exception
    //   491	502	1746	finally
    //   509	518	1794	java/lang/Exception
    //   509	518	1746	finally
    //   525	538	1794	java/lang/Exception
    //   525	538	1746	finally
    //   545	553	1794	java/lang/Exception
    //   545	553	1746	finally
    //   560	568	1794	java/lang/Exception
    //   560	568	1746	finally
    //   575	583	1794	java/lang/Exception
    //   575	583	1746	finally
    //   590	600	1794	java/lang/Exception
    //   590	600	1746	finally
    //   607	620	1794	java/lang/Exception
    //   607	620	1746	finally
    //   627	635	1794	java/lang/Exception
    //   627	635	1746	finally
    //   642	650	1794	java/lang/Exception
    //   642	650	1746	finally
    //   657	667	1794	java/lang/Exception
    //   657	667	1746	finally
    //   678	691	1794	java/lang/Exception
    //   678	691	1746	finally
    //   702	710	1794	java/lang/Exception
    //   702	710	1746	finally
    //   721	729	1794	java/lang/Exception
    //   721	729	1746	finally
    //   740	749	1794	java/lang/Exception
    //   740	749	1746	finally
    //   756	765	1794	java/lang/Exception
    //   756	765	1746	finally
    //   772	781	1794	java/lang/Exception
    //   772	781	1746	finally
    //   788	796	1794	java/lang/Exception
    //   788	796	1746	finally
    //   803	810	1794	java/lang/Exception
    //   803	810	1746	finally
    //   817	823	1794	java/lang/Exception
    //   817	823	1746	finally
    //   830	839	1794	java/lang/Exception
    //   830	839	1746	finally
    //   846	854	1794	java/lang/Exception
    //   846	854	1746	finally
    //   861	869	1794	java/lang/Exception
    //   861	869	1746	finally
    //   876	887	1794	java/lang/Exception
    //   876	887	1746	finally
    //   906	916	1794	java/lang/Exception
    //   906	916	1746	finally
    //   923	932	1794	java/lang/Exception
    //   923	932	1746	finally
    //   939	950	1794	java/lang/Exception
    //   939	950	1746	finally
    //   957	966	1794	java/lang/Exception
    //   957	966	1746	finally
    //   973	986	1794	java/lang/Exception
    //   973	986	1746	finally
    //   993	1001	1794	java/lang/Exception
    //   993	1001	1746	finally
    //   1008	1016	1794	java/lang/Exception
    //   1008	1016	1746	finally
    //   1023	1031	1794	java/lang/Exception
    //   1023	1031	1746	finally
    //   1038	1048	1794	java/lang/Exception
    //   1038	1048	1746	finally
    //   1055	1068	1794	java/lang/Exception
    //   1055	1068	1746	finally
    //   1075	1083	1794	java/lang/Exception
    //   1075	1083	1746	finally
    //   1090	1098	1794	java/lang/Exception
    //   1090	1098	1746	finally
    //   1105	1115	1794	java/lang/Exception
    //   1105	1115	1746	finally
    //   1126	1139	1794	java/lang/Exception
    //   1126	1139	1746	finally
    //   1150	1158	1794	java/lang/Exception
    //   1150	1158	1746	finally
    //   1169	1177	1794	java/lang/Exception
    //   1169	1177	1746	finally
    //   1188	1197	1794	java/lang/Exception
    //   1188	1197	1746	finally
    //   1204	1213	1794	java/lang/Exception
    //   1204	1213	1746	finally
    //   1220	1229	1794	java/lang/Exception
    //   1220	1229	1746	finally
    //   1236	1244	1794	java/lang/Exception
    //   1236	1244	1746	finally
    //   1251	1258	1794	java/lang/Exception
    //   1251	1258	1746	finally
    //   1265	1271	1794	java/lang/Exception
    //   1265	1271	1746	finally
    //   1278	1287	1794	java/lang/Exception
    //   1278	1287	1746	finally
    //   1294	1302	1794	java/lang/Exception
    //   1294	1302	1746	finally
    //   1309	1317	1794	java/lang/Exception
    //   1309	1317	1746	finally
    //   1324	1335	1794	java/lang/Exception
    //   1324	1335	1746	finally
    //   1342	1351	1794	java/lang/Exception
    //   1342	1351	1746	finally
    //   1358	1367	1794	java/lang/Exception
    //   1358	1367	1746	finally
    //   1374	1382	1794	java/lang/Exception
    //   1374	1382	1746	finally
    //   1389	1399	1794	java/lang/Exception
    //   1389	1399	1746	finally
    //   1406	1415	1794	java/lang/Exception
    //   1406	1415	1746	finally
    //   1422	1431	1794	java/lang/Exception
    //   1422	1431	1746	finally
    //   1438	1445	1794	java/lang/Exception
    //   1438	1445	1746	finally
    //   1452	1462	1794	java/lang/Exception
    //   1452	1462	1746	finally
    //   1469	1478	1794	java/lang/Exception
    //   1469	1478	1746	finally
    //   1485	1494	1794	java/lang/Exception
    //   1485	1494	1746	finally
    //   1501	1508	1794	java/lang/Exception
    //   1501	1508	1746	finally
    //   1515	1525	1794	java/lang/Exception
    //   1515	1525	1746	finally
    //   1532	1541	1794	java/lang/Exception
    //   1532	1541	1746	finally
    //   1548	1557	1794	java/lang/Exception
    //   1548	1557	1746	finally
    //   1564	1572	1794	java/lang/Exception
    //   1564	1572	1746	finally
    //   1579	1589	1794	java/lang/Exception
    //   1579	1589	1746	finally
    //   1596	1605	1794	java/lang/Exception
    //   1596	1605	1746	finally
    //   1612	1621	1794	java/lang/Exception
    //   1612	1621	1746	finally
    //   1628	1636	1794	java/lang/Exception
    //   1628	1636	1746	finally
    //   1643	1653	1794	java/lang/Exception
    //   1643	1653	1746	finally
    //   1660	1669	1794	java/lang/Exception
    //   1660	1669	1746	finally
    //   1676	1685	1794	java/lang/Exception
    //   1676	1685	1746	finally
    //   1692	1700	1794	java/lang/Exception
    //   1692	1700	1746	finally
    //   1707	1717	1794	java/lang/Exception
    //   1707	1717	1746	finally
    //   1724	1732	1794	java/lang/Exception
    //   1724	1732	1746	finally
    //   1753	1761	1746	finally
  }
  
  private void b(Context paramContext, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 22) {
      SubscriptionManager subscriptionManager = SubscriptionManager.from(paramContext.getApplicationContext());
      if (subscriptionManager != null) {
        if (paramBoolean)
          try {
            SubscriptionInfo subscriptionInfo = a(subscriptionManager, "getDefaultDataSubscriptionInfo", (Object[])null);
            if (subscriptionInfo != null) {
              b.a(this.c, subscriptionInfo.getSimSlotIndex());
              b.b(this.c, subscriptionInfo.getSubscriptionId());
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("getDefaultDataSubscriptionInfo适配成功: dataSlotId即sim_id = ");
              stringBuilder.append(b.b(this.c));
              f.b("UMCTelephonyManagement", stringBuilder.toString());
              stringBuilder = new StringBuilder();
              stringBuilder.append("getDefaultDataSubscriptionInfo适配成功: dataSubId = ");
              stringBuilder.append(b.a(this.c));
              f.b("UMCTelephonyManagement", stringBuilder.toString());
              return;
            } 
          } catch (Exception exception) {
            f.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubscriptionInfo 反射出错");
          }  
        try {
          if (b.b(this.c) == -1 && Build.VERSION.SDK_INT >= 24) {
            b.b(this.c, SubscriptionManager.getDefaultDataSubscriptionId());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("android 7.0及以上手机getDefaultDataSubscriptionId适配成功: dataSubId = ");
            stringBuilder.append(b.a(this.c));
            f.b("UMCTelephonyManagement", stringBuilder.toString());
            return;
          } 
        } catch (Exception exception) {
          f.a("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配失败");
        } 
        try {
          Method method = subscriptionManager.getClass().getMethod("getDefaultDataSubId", new Class[0]);
          if (method != null) {
            b.b(this.c, ((Integer)method.invoke(subscriptionManager, new Object[0])).intValue());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("android 7.0以下手机getDefaultDataSubId适配成功: dataSubId = ");
            stringBuilder.append(b.a(this.c));
            f.b("UMCTelephonyManagement", stringBuilder.toString());
            return;
          } 
        } catch (Exception exception) {
          f.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubId 反射出错");
        } 
        try {
          Method method = subscriptionManager.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]);
          if (method != null) {
            b.b(this.c, ((Integer)method.invoke(subscriptionManager, new Object[0])).intValue());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("反射getDefaultDataSubscriptionId适配成功: dataSubId = ");
            stringBuilder.append(b.a(this.c));
            f.b("UMCTelephonyManagement", stringBuilder.toString());
            return;
          } 
          return;
        } catch (Exception exception) {
          f.a("UMCTelephonyManagement", "getDefaultDataSubscriptionId-->getDefaultDataSubscriptionId 反射出错");
        } 
        return;
      } 
    } else {
      b.a(this.c, -1);
    } 
  }
  
  private void b(List<SubscriptionInfo> paramList, TelephonyManager paramTelephonyManager) {
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    } 
    byte b1 = 1;
    if (i > 1) {
      SubscriptionInfo subscriptionInfo = a(paramList, 1);
      this.c.d(subscriptionInfo.getSimSlotIndex());
      this.c.f(subscriptionInfo.getSubscriptionId());
      b.c(this.c, subscriptionInfo.getIccId());
      b b2 = this.c;
      b.d(b2, b(b.h(b2)));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("readSim1Info2 iccid2 = ");
      stringBuilder.append(b.h(this.c));
      f.b("UMCTelephonyManagement", stringBuilder.toString());
      if (b.b(this.c) == -1 && b.a(this.c) == subscriptionInfo.getSubscriptionId()) {
        b.a(this.c, subscriptionInfo.getSimSlotIndex());
        stringBuilder = new StringBuilder();
        stringBuilder.append("readSim1Info2 dataSlotId = ");
        stringBuilder.append(b.b(this.c));
        f.b("UMCTelephonyManagement", stringBuilder.toString());
      } 
      if (!t.e())
        return; 
      try {
        this.c.b(a(paramTelephonyManager, "getDeviceId", 1));
      } catch (a a) {
        try {
          this.c.b(a(paramTelephonyManager, "getDeviceIdGemini", 1));
        } catch (Exception exception) {
          f.a("UMCTelephonyManagement", "readSim1Info imei2 failed");
        } 
      } 
      if (a.a() == 0) {
        i = b1;
      } else {
        i = subscriptionInfo.getSubscriptionId();
      } 
      try {
        this.c.d(a(paramTelephonyManager, "getSubscriberId", subscriptionInfo.getSubscriptionId()));
      } catch (a a) {
        try {
          this.c.d(a(paramTelephonyManager, "getSubscriberIdGemini", i));
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      } 
      try {
        this.c.f(a(paramTelephonyManager, "getSimOperator", subscriptionInfo.getSubscriptionId()));
        return;
      } catch (a a) {
        try {
          this.c.f(a(paramTelephonyManager, "getSimOperatorGemini", i));
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      } 
    } 
  }
  
  private boolean b(TelephonyManager paramTelephonyManager, String paramString, int paramInt) throws a {
    Class<int> clazz = int.class;
    Object object = a(paramTelephonyManager, paramString, new Object[] { Integer.valueOf(paramInt) }, new Class[] { clazz });
    return (object != null && Integer.parseInt(object.toString()) == 5);
  }
  
  private void c(Context paramContext) {
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
    if (telephonyManager == null)
      return; 
    List<SubscriptionInfo> list = e(paramContext);
    if (list != null && list.size() > 0) {
      a(list, telephonyManager);
      b(list, telephonyManager);
    } 
  }
  
  private void d(Context paramContext) {
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
    this.c.c(0);
    this.c.d(1);
    this.c.b(-1);
    try {
      String str = a(telephonyManager, "getSubscriberId", 0);
      this.c.c(str);
      str = a(telephonyManager, "getSubscriberId", 1);
      this.c.d(str);
    } catch (a a) {
      try {
        String str = a(telephonyManager, "getSubscriberIdGemini", 0);
        this.c.c(str);
        str = a(telephonyManager, "getSubscriberIdGemini", 1);
        this.c.d(str);
      } catch (a a1) {
        try {
          String str = telephonyManager.getSubscriberId();
          this.c.c(str);
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      } 
    } 
    try {
      boolean bool = b(telephonyManager, "getSimState", 0);
      this.c.a(bool);
      bool = b(telephonyManager, "getSimState", 1);
      this.c.b(bool);
    } catch (a a) {
      try {
        boolean bool = b(telephonyManager, "getSimStateGemini", 0);
        this.c.a(bool);
        bool = b(telephonyManager, "getSimStateGemini", 1);
        this.c.b(bool);
      } catch (a a1) {
        boolean bool;
        if (telephonyManager.getSimState() == 5) {
          bool = true;
        } else {
          bool = false;
        } 
        this.c.a(bool);
      } 
    } 
    try {
      String str = a(telephonyManager, "getSimOperator", 0);
      this.c.e(str);
      str = a(telephonyManager, "getSimOperator", 1);
      this.c.f(str);
    } catch (a a) {
      try {
        String str = a(telephonyManager, "getSimOperatorGemini", 0);
        this.c.e(str);
        str = a(telephonyManager, "getSimOperatorGemini", 1);
        this.c.f(str);
      } catch (a a1) {
        String str = telephonyManager.getSimOperator();
        this.c.e(str);
      } 
    } 
    if (TextUtils.isEmpty(this.c.b()) && !TextUtils.isEmpty(this.c.c())) {
      b b1 = this.c;
      b1.a(b1.a());
      this.c.b("");
      b1 = this.c;
      b1.c(b1.c());
      this.c.d("");
      b1 = this.c;
      b1.c(b1.h());
      this.c.d(-1);
      b1 = this.c;
      b1.a(b1.e());
      this.c.b(false);
      b1 = this.c;
      b1.e(b1.d());
      this.c.f("");
      b1 = this.c;
      b1.b(b1.g());
      return;
    } 
    if (!TextUtils.isEmpty(this.c.b()) && TextUtils.isEmpty(this.c.c())) {
      this.c.b("");
      this.c.b(false);
      this.c.d(-1);
      b b1 = this.c;
      b1.b(b1.g());
      return;
    } 
    if (TextUtils.isEmpty(this.c.b()) && TextUtils.isEmpty(this.c.c())) {
      this.c.a("");
      this.c.b("");
      this.c.c(-1);
      this.c.d(-1);
      this.c.a(false);
      this.c.b(false);
      this.c.b(-1);
    } 
  }
  
  private List<SubscriptionInfo> e(Context paramContext) {
    SubscriptionManager subscriptionManager = SubscriptionManager.from(paramContext.getApplicationContext());
    return (subscriptionManager != null) ? subscriptionManager.getActiveSubscriptionInfoList() : null;
  }
  
  private int f(Context paramContext) {
    if (k.a(paramContext, "android.permission.READ_PHONE_STATE")) {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
      if (telephonyManager == null)
        return -1; 
      if (t.e())
        try {
          Method method = telephonyManager.getClass().getMethod("getDataNetworkType", new Class[] { int.class });
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("data dataNetworkType defaultDataSubId = ");
          stringBuilder2.append(b.a(this.c));
          f.b("UMCTelephonyManagement", stringBuilder2.toString());
          int j = ((Integer)method.invoke(telephonyManager, new Object[] { Integer.valueOf(b.a(this.c)) })).intValue();
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("data dataNetworkType ---------");
          stringBuilder1.append(j);
          f.b("UMCTelephonyManagement", stringBuilder1.toString());
          int i = j;
          if (j == 0) {
            i = j;
            if (Build.VERSION.SDK_INT >= 24) {
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("data dataNetworkType ---->=N ");
              stringBuilder1.append(j);
              f.b("UMCTelephonyManagement", stringBuilder1.toString());
              i = telephonyManager.getDataNetworkType();
            } 
          } 
          return i;
        } catch (Exception exception) {
          f.a("UMCTelephonyManagement", "data dataNetworkType ----反射出错-----");
          exception.printStackTrace();
          return -1;
        }  
      return exception.getDataNetworkType();
    } 
    return -1;
  }
  
  public String a(Context paramContext) {
    switch (f(paramContext)) {
      default:
        return "0";
      case 20:
        return "4";
      case 13:
      case 18:
      case 19:
        return "3";
      case 3:
      case 5:
      case 6:
      case 8:
      case 9:
      case 10:
      case 12:
      case 14:
      case 15:
      case 17:
        return "2";
      case 1:
      case 2:
      case 4:
      case 7:
      case 11:
      case 16:
        break;
    } 
    return "1";
  }
  
  public void a(Context paramContext, boolean paramBoolean) {
    if (System.currentTimeMillis() - b < 5000L)
      return; 
    this.c = new b();
    if (!t.b(paramContext))
      return; 
    b(paramContext, paramBoolean);
    if (t.d() && t.e()) {
      f.b("UMCTelephonyManagement", "华为手机兼容性处理");
      if (b.a(this.c) == 0 || b.a(this.c) == 1) {
        b b1 = this.c;
        b.a(b1, b.a(b1));
      } 
    } 
    if (paramBoolean)
      try {
        if (Build.VERSION.SDK_INT >= 22) {
          c(paramContext);
        } else {
          d(paramContext);
        } 
      } catch (Exception exception) {
        f.a("UMCTelephonyManagement", "read sim info error");
      }  
    if (Build.VERSION.SDK_INT >= 21)
      b(paramContext); 
    b = System.currentTimeMillis();
  }
  
  public b b() {
    b b2 = this.c;
    b b1 = b2;
    if (b2 == null)
      b1 = new b(); 
    return b1;
  }
  
  public static class a extends Exception {
    public a(String param1String) {
      super(param1String);
    }
  }
  
  public static class b {
    private String a = "";
    
    private String b = "";
    
    private String c = "";
    
    private String d = "";
    
    private String e = "";
    
    private String f = "";
    
    private boolean g = false;
    
    private boolean h = false;
    
    private int i = -1;
    
    private int j = -1;
    
    private int k = -1;
    
    private int l = -1;
    
    private String m = "";
    
    private String n = "";
    
    private int o = -1;
    
    private int p = -1;
    
    private int q = -1;
    
    public String a() {
      return this.d;
    }
    
    public String a(int param1Int) {
      return (this.i == param1Int) ? this.a : ((this.j == param1Int) ? this.b : "");
    }
    
    protected void a(String param1String) {
      if (param1String != null)
        this.c = param1String; 
    }
    
    protected void a(boolean param1Boolean) {
      this.g = param1Boolean;
    }
    
    public String b() {
      return this.e;
    }
    
    protected void b(int param1Int) {
      this.o = param1Int;
    }
    
    protected void b(String param1String) {
      if (param1String != null)
        this.d = param1String; 
    }
    
    protected void b(boolean param1Boolean) {
      this.h = param1Boolean;
    }
    
    public String c() {
      return this.f;
    }
    
    protected void c(int param1Int) {
      this.i = param1Int;
    }
    
    protected void c(String param1String) {
      if (param1String != null)
        this.e = param1String; 
    }
    
    public String d() {
      return this.n;
    }
    
    protected void d(int param1Int) {
      this.j = param1Int;
    }
    
    protected void d(String param1String) {
      if (param1String != null)
        this.f = param1String; 
    }
    
    protected void e(int param1Int) {
      this.k = param1Int;
    }
    
    protected void e(String param1String) {
      if (param1String != null)
        this.m = param1String; 
    }
    
    public boolean e() {
      return this.h;
    }
    
    public int f() {
      return this.o;
    }
    
    protected void f(int param1Int) {
      this.l = param1Int;
    }
    
    protected void f(String param1String) {
      this.n = param1String;
    }
    
    public int g() {
      return this.i;
    }
    
    public String g(int param1Int) {
      return (this.i == param1Int) ? this.e : ((this.j == param1Int) ? this.f : "");
    }
    
    public int h() {
      return this.j;
    }
    
    public String h(int param1Int) {
      return (this.i == param1Int) ? this.c : ((this.j == param1Int) ? this.d : "");
    }
    
    public int i() {
      return ((!TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(this.e)) || (!TextUtils.isEmpty(this.m) && !TextUtils.isEmpty(this.n))) ? 2 : ((!TextUtils.isEmpty(this.e) || !TextUtils.isEmpty(this.f) || !TextUtils.isEmpty(this.m) || !TextUtils.isEmpty(this.n)) ? 1 : 0);
    }
    
    public String i(int param1Int) {
      return (this.i == param1Int) ? this.m : ((this.j == param1Int) ? this.n : "");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */