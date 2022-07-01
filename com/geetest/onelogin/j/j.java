package com.geetest.onelogin.j;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.geetest.onelogin.a.b;
import com.geetest.onelogin.a.c;
import com.geetest.onelogin.a.d;
import com.geetest.onelogin.a.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class j {
  public static c a(Context paramContext) {
    JSONObject jSONObject = AuthnHelper.getInstance(paramContext).getNetworkType(paramContext);
    try {
      return new c(jSONObject.getString("operatorType"), jSONObject.getString("networkType"));
    } catch (Exception exception) {
      exception.printStackTrace();
      return new c();
    } 
  }
  
  public static boolean a(d paramd, Context paramContext) {
    long l1 = paramd.getDataSimBean().b();
    long l2 = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isSimInfoChanged updateTime=");
    stringBuilder.append(l1);
    stringBuilder.append(", now=");
    stringBuilder.append(l2);
    stringBuilder.append(", delta=");
    long l3 = l2 - l1;
    stringBuilder.append(l3);
    c.a(stringBuilder.toString());
    boolean bool = false;
    if (l2 > l1 && l3 < 8000L) {
      paramd.getDataSimBean().a(l2);
    } else {
      b b = d(paramContext);
      stringBuilder = new StringBuilder();
      stringBuilder.append("isSimInfoChanged newBean=");
      stringBuilder.append(b);
      c.a(stringBuilder.toString());
      if (paramd.getDataSimBean().equals(b)) {
        paramd.getDataSimBean().a(l2);
      } else {
        bool = true;
      } 
    } 
    paramd.setSimChanged(bool);
    return bool;
  }
  
  public static boolean a(String paramString) {
    return Pattern.compile("^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(14[5-9])|(19[8,9])|)\\d{8}$").matcher(paramString).matches();
  }
  
  public static String b(Context paramContext) {
    byte b;
    JSONObject jSONObject = AuthnHelper.getInstance(paramContext).getNetworkType(paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("operatorType: ");
    stringBuilder.append(jSONObject.toString());
    h.b(stringBuilder.toString());
    try {
      String str = jSONObject.getString("operatorType");
      b = -1;
      switch (str.hashCode()) {
        case 51:
          if (str.equals("3"))
            b = 2; 
          break;
        case 50:
          if (str.equals("2"))
            b = 1; 
          break;
        case 49:
          if (str.equals("1"))
            b = 0; 
          break;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return "unknown";
    } 
    return (b != 0) ? ((b != 1) ? ((b == 2) ? "CT" : "unknown") : "CU") : "CM";
  }
  
  public static String c(Context paramContext) {
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    return (telephonyManager != null) ? telephonyManager.getSimOperator() : "";
  }
  
  public static b d(Context paramContext) {
    // Byte code:
    //   0: invokestatic a : ()Lcom/geetest/onelogin/j/p;
    //   3: ldc 'getSimInfo'
    //   5: invokevirtual a : (Ljava/lang/String;)V
    //   8: new com/geetest/onelogin/a/b
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: astore #5
    //   17: aload_0
    //   18: invokestatic a : (Landroid/content/Context;)Lcom/geetest/onelogin/a/c;
    //   21: astore #6
    //   23: aload #6
    //   25: invokevirtual toString : ()Ljava/lang/String;
    //   28: invokestatic b : (Ljava/lang/String;)V
    //   31: aload #5
    //   33: aload #6
    //   35: invokevirtual b : ()Ljava/lang/String;
    //   38: invokevirtual a : (Ljava/lang/String;)V
    //   41: aload_0
    //   42: ldc 'phone'
    //   44: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   47: checkcast android/telephony/TelephonyManager
    //   50: astore #6
    //   52: iconst_0
    //   53: istore_1
    //   54: aload #6
    //   56: ifnull -> 464
    //   59: getstatic android/os/Build$VERSION.SDK_INT : I
    //   62: bipush #23
    //   64: if_icmplt -> 82
    //   67: aload #5
    //   69: aload #6
    //   71: invokevirtual getPhoneCount : ()I
    //   74: invokevirtual c : (I)V
    //   77: iconst_0
    //   78: istore_1
    //   79: goto -> 90
    //   82: aload #5
    //   84: iconst_1
    //   85: invokevirtual c : (I)V
    //   88: iconst_1
    //   89: istore_1
    //   90: aload_0
    //   91: invokestatic f : (Landroid/content/Context;)Ljava/lang/Integer;
    //   94: invokevirtual intValue : ()I
    //   97: istore #4
    //   99: aload #5
    //   101: iload #4
    //   103: invokevirtual b : (I)V
    //   106: aload #5
    //   108: aload #6
    //   110: invokevirtual getSimOperator : ()Ljava/lang/String;
    //   113: invokevirtual c : (Ljava/lang/String;)V
    //   116: iload_1
    //   117: istore_2
    //   118: iload_1
    //   119: istore_3
    //   120: ldc android/telephony/TelephonyManager
    //   122: ldc 'getSimState'
    //   124: iconst_1
    //   125: anewarray java/lang/Class
    //   128: dup
    //   129: iconst_0
    //   130: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   133: aastore
    //   134: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   137: astore #7
    //   139: iload_1
    //   140: istore_2
    //   141: iload_1
    //   142: istore_3
    //   143: new java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial <init> : ()V
    //   150: astore #8
    //   152: iload_1
    //   153: istore_2
    //   154: iload_1
    //   155: istore_3
    //   156: aload #8
    //   158: aload #7
    //   160: aload #6
    //   162: iconst_1
    //   163: anewarray java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: iload #4
    //   170: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   173: aastore
    //   174: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   177: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: iload_1
    //   182: istore_2
    //   183: iload_1
    //   184: istore_3
    //   185: aload #8
    //   187: ldc ''
    //   189: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: iload_1
    //   194: istore_2
    //   195: iload_1
    //   196: istore_3
    //   197: aload #5
    //   199: aload #8
    //   201: invokevirtual toString : ()Ljava/lang/String;
    //   204: invokevirtual b : (Ljava/lang/String;)V
    //   207: iload_1
    //   208: iconst_2
    //   209: ior
    //   210: istore_1
    //   211: iload_1
    //   212: istore_2
    //   213: iload_1
    //   214: istore_3
    //   215: getstatic android/os/Build$VERSION.SDK_INT : I
    //   218: bipush #28
    //   220: if_icmple -> 249
    //   223: iload_1
    //   224: istore_2
    //   225: iload_1
    //   226: istore_3
    //   227: getstatic android/os/Build$VERSION.SDK_INT : I
    //   230: bipush #28
    //   232: if_icmple -> 527
    //   235: iload_1
    //   236: istore_2
    //   237: iload_1
    //   238: istore_3
    //   239: aload_0
    //   240: invokestatic a : (Landroid/content/Context;)Z
    //   243: ifeq -> 527
    //   246: goto -> 249
    //   249: iload_1
    //   250: istore_2
    //   251: iload_1
    //   252: istore_3
    //   253: aload_0
    //   254: invokestatic e : (Landroid/content/Context;)Ljava/util/List;
    //   257: invokeinterface iterator : ()Ljava/util/Iterator;
    //   262: astore #7
    //   264: iload_1
    //   265: istore_2
    //   266: iload_1
    //   267: istore_3
    //   268: aload #7
    //   270: invokeinterface hasNext : ()Z
    //   275: ifeq -> 336
    //   278: iload_1
    //   279: istore_2
    //   280: iload_1
    //   281: istore_3
    //   282: aload #7
    //   284: invokeinterface next : ()Ljava/lang/Object;
    //   289: checkcast com/geetest/onelogin/a/g
    //   292: astore #8
    //   294: iload_1
    //   295: istore_2
    //   296: iload_1
    //   297: istore_3
    //   298: aload #8
    //   300: invokevirtual b : ()I
    //   303: iload #4
    //   305: if_icmpne -> 264
    //   308: iload_1
    //   309: istore_2
    //   310: iload_1
    //   311: istore_3
    //   312: aload #5
    //   314: aload #8
    //   316: invokevirtual a : ()I
    //   319: invokevirtual a : (I)V
    //   322: iload_1
    //   323: istore_2
    //   324: iload_1
    //   325: istore_3
    //   326: aload #5
    //   328: aload #8
    //   330: invokevirtual c : ()Ljava/lang/String;
    //   333: invokevirtual d : (Ljava/lang/String;)V
    //   336: iload_1
    //   337: iconst_4
    //   338: ior
    //   339: istore_1
    //   340: goto -> 464
    //   343: astore_0
    //   344: iload_2
    //   345: istore_1
    //   346: aload_0
    //   347: invokevirtual printStackTrace : ()V
    //   350: new java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial <init> : ()V
    //   357: astore #6
    //   359: aload #6
    //   361: ldc_w 'getSimState error: '
    //   364: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload #6
    //   370: aload_0
    //   371: invokevirtual toString : ()Ljava/lang/String;
    //   374: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload #6
    //   380: invokevirtual toString : ()Ljava/lang/String;
    //   383: invokestatic c : (Ljava/lang/String;)V
    //   386: goto -> 464
    //   389: astore #7
    //   391: aload #7
    //   393: invokevirtual printStackTrace : ()V
    //   396: new java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial <init> : ()V
    //   403: astore #7
    //   405: aload #7
    //   407: aload #6
    //   409: invokevirtual getSimState : ()I
    //   412: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload #7
    //   418: ldc ''
    //   420: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload #5
    //   426: aload #7
    //   428: invokevirtual toString : ()Ljava/lang/String;
    //   431: invokevirtual b : (Ljava/lang/String;)V
    //   434: iload_3
    //   435: bipush #8
    //   437: ior
    //   438: istore_1
    //   439: aload_0
    //   440: invokestatic b : (Landroid/content/Context;)Z
    //   443: ifeq -> 464
    //   446: aload #5
    //   448: aload #6
    //   450: invokevirtual getSimSerialNumber : ()Ljava/lang/String;
    //   453: invokevirtual d : (Ljava/lang/String;)V
    //   456: iload_1
    //   457: bipush #16
    //   459: ior
    //   460: istore_1
    //   461: goto -> 340
    //   464: aload #5
    //   466: invokestatic currentTimeMillis : ()J
    //   469: invokevirtual a : (J)V
    //   472: invokestatic a : ()Lcom/geetest/onelogin/j/p;
    //   475: ldc 'getSimInfo'
    //   477: invokevirtual b : (Ljava/lang/String;)V
    //   480: new java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial <init> : ()V
    //   487: astore_0
    //   488: aload_0
    //   489: ldc_w 'getSimInfo bean: '
    //   492: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload_0
    //   497: aload #5
    //   499: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload_0
    //   504: ldc_w ', index: '
    //   507: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload_0
    //   512: iload_1
    //   513: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload_0
    //   518: invokevirtual toString : ()Ljava/lang/String;
    //   521: invokestatic a : (Ljava/lang/String;)V
    //   524: aload #5
    //   526: areturn
    //   527: goto -> 464
    // Exception table:
    //   from	to	target	type
    //   120	139	389	java/lang/Exception
    //   120	139	343	finally
    //   143	152	389	java/lang/Exception
    //   143	152	343	finally
    //   156	181	389	java/lang/Exception
    //   156	181	343	finally
    //   185	193	389	java/lang/Exception
    //   185	193	343	finally
    //   197	207	389	java/lang/Exception
    //   197	207	343	finally
    //   215	223	389	java/lang/Exception
    //   215	223	343	finally
    //   227	235	389	java/lang/Exception
    //   227	235	343	finally
    //   239	246	389	java/lang/Exception
    //   239	246	343	finally
    //   253	264	389	java/lang/Exception
    //   253	264	343	finally
    //   268	278	389	java/lang/Exception
    //   268	278	343	finally
    //   282	294	389	java/lang/Exception
    //   282	294	343	finally
    //   298	308	389	java/lang/Exception
    //   298	308	343	finally
    //   312	322	389	java/lang/Exception
    //   312	322	343	finally
    //   326	336	389	java/lang/Exception
    //   326	336	343	finally
  }
  
  public static List<g> e(Context paramContext) {
    Uri uri = Uri.parse("content://telephony/siminfo");
    Cursor cursor = paramContext.getContentResolver().query(uri, new String[] { 
          "_id", "icc_id", "sim_id", "display_name", "carrier_name", "name_source", "color", "number", "display_number_format", "data_roaming", 
          "mcc", "mnc" }, "sim_id>=0", null, "sim_id");
    ArrayList<g> arrayList = new ArrayList();
    if (cursor != null) {
      while (cursor.moveToNext()) {
        g g = new g(Integer.valueOf(cursor.getString(cursor.getColumnIndex("_id"))).intValue(), Integer.valueOf(cursor.getString(cursor.getColumnIndex("sim_id"))).intValue(), cursor.getString(cursor.getColumnIndex("icc_id")), cursor.getString(cursor.getColumnIndex("carrier_name")), cursor.getString(cursor.getColumnIndex("display_name")), cursor.getString(cursor.getColumnIndex("number")), cursor.getString(cursor.getColumnIndex("mcc")), cursor.getString(cursor.getColumnIndex("mnc")));
        arrayList.add(g);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("querySimInfo info=");
        stringBuilder.append(g);
        c.a(stringBuilder.toString());
      } 
      cursor.close();
    } 
    return arrayList;
  }
  
  public static Integer f(Context paramContext) {
    StringBuilder stringBuilder;
    Integer integer1 = Integer.valueOf(-1);
    Integer integer2 = integer1;
    try {
      if (Build.VERSION.SDK_INT >= 22) {
        SubscriptionManager subscriptionManager = SubscriptionManager.from(paramContext.getApplicationContext());
        Method method = subscriptionManager.getClass().getMethod("getDefaultDataSubId", new Class[0]);
        integer2 = integer1;
        if (method != null) {
          int i = ((Integer)method.invoke(subscriptionManager, new Object[0])).intValue();
          return Integer.valueOf(i);
        } 
      } 
    } catch (NoSuchMethodException noSuchMethodException) {
      integer2 = integer1;
      try {
        if (Build.VERSION.SDK_INT >= 22) {
          SubscriptionManager subscriptionManager = SubscriptionManager.from(paramContext.getApplicationContext());
          Method method = subscriptionManager.getClass().getMethod("getDefaultDataSubscrptionId", new Class[0]);
          integer2 = integer1;
          if (method != null) {
            int i = ((Integer)method.invoke(subscriptionManager, new Object[0])).intValue();
            return Integer.valueOf(i);
          } 
        } 
        return integer2;
      } catch (NoSuchMethodException noSuchMethodException1) {
        integer2 = integer1;
        Integer integer3 = integer1;
        Integer integer4 = integer1;
        Integer integer5 = integer1;
        try {
          if (Build.VERSION.SDK_INT >= 22) {
            integer3 = integer1;
            integer4 = integer1;
            integer5 = integer1;
            SubscriptionManager subscriptionManager = SubscriptionManager.from(paramContext.getApplicationContext());
            integer3 = integer1;
            integer4 = integer1;
            integer5 = integer1;
            Method method = subscriptionManager.getClass().getMethod("getDefaultDataPhoneId", new Class[0]);
            integer2 = integer1;
            if (method != null) {
              integer3 = integer1;
              integer4 = integer1;
              integer5 = integer1;
              Integer integer = Integer.valueOf(((Integer)method.invoke(subscriptionManager, new Object[0])).intValue());
              integer3 = integer;
              integer4 = integer;
              integer5 = integer;
              stringBuilder = new StringBuilder();
              integer3 = integer;
              integer4 = integer;
              integer5 = integer;
              stringBuilder.append(((Integer)method.invoke(subscriptionManager, new Object[0])).intValue());
              integer3 = integer;
              integer4 = integer;
              integer5 = integer;
              stringBuilder.append("");
              integer3 = integer;
              integer4 = integer;
              integer5 = integer;
              Log.v("", stringBuilder.toString());
              return integer;
            } 
          } 
          return integer2;
        } catch (NoSuchMethodException noSuchMethodException2) {
          noSuchMethodException.printStackTrace();
          return integer3;
        } catch (IllegalAccessException illegalAccessException) {
          noSuchMethodException.printStackTrace();
          return integer4;
        } catch (InvocationTargetException invocationTargetException) {}
        noSuchMethodException.printStackTrace();
        return integer5;
      } catch (IllegalAccessException illegalAccessException) {
        noSuchMethodException.printStackTrace();
        return (Integer)stringBuilder;
      } catch (InvocationTargetException invocationTargetException) {
        noSuchMethodException.printStackTrace();
        return (Integer)stringBuilder;
      } 
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
      return (Integer)stringBuilder;
    } catch (InvocationTargetException invocationTargetException) {
      invocationTargetException.printStackTrace();
      return (Integer)stringBuilder;
    } 
    return integer2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\j\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */