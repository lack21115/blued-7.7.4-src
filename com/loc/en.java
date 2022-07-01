package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class en {
  static AMapLocation g;
  
  static boolean h;
  
  private static List<bb> i = new ArrayList<bb>();
  
  private static JSONArray j = null;
  
  public SparseArray<Long> a = new SparseArray();
  
  public int b = -1;
  
  public long c = 0L;
  
  String[] d = new String[] { "ol", "cl", "gl", "ha", "bs", "ds" };
  
  public int e = -1;
  
  public long f = -1L;
  
  static {
    g = null;
    h = false;
  }
  
  public static void a(long paramLong1, long paramLong2) {
    try {
      if (h)
        return; 
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append("gpsTime:");
      stringBuffer.append(ep.a(paramLong1, "yyyy-MM-dd HH:mm:ss.SSS"));
      stringBuffer.append(",");
      stringBuffer.append("sysTime:");
      stringBuffer.append(ep.a(paramLong2, "yyyy-MM-dd HH:mm:ss.SSS"));
      stringBuffer.append(",");
      paramLong2 = ei.u();
      String str = "0";
      int i = 0L cmp paramLong2;
      if (i != 0)
        str = ep.a(paramLong2, "yyyy-MM-dd HH:mm:ss.SSS"); 
      stringBuffer.append("serverTime:");
      stringBuffer.append(str);
      a("checkgpstime", stringBuffer.toString());
      if (i != 0 && Math.abs(paramLong1 - paramLong2) < 31536000000L) {
        stringBuffer.append(", correctError");
        a("checkgpstimeerror", stringBuffer.toString());
      } 
      stringBuffer.delete(0, stringBuffer.length());
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/loc/en
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 91
    //   7: invokestatic a : ()Z
    //   10: ifne -> 16
    //   13: goto -> 91
    //   16: getstatic com/loc/en.i : Ljava/util/List;
    //   19: ifnull -> 64
    //   22: getstatic com/loc/en.i : Ljava/util/List;
    //   25: invokeinterface size : ()I
    //   30: ifle -> 64
    //   33: new java/util/ArrayList
    //   36: dup
    //   37: invokespecial <init> : ()V
    //   40: astore_1
    //   41: aload_1
    //   42: getstatic com/loc/en.i : Ljava/util/List;
    //   45: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   50: pop
    //   51: aload_1
    //   52: aload_0
    //   53: invokestatic b : (Ljava/util/List;Landroid/content/Context;)V
    //   56: getstatic com/loc/en.i : Ljava/util/List;
    //   59: invokeinterface clear : ()V
    //   64: aload_0
    //   65: invokestatic f : (Landroid/content/Context;)V
    //   68: ldc com/loc/en
    //   70: monitorexit
    //   71: return
    //   72: astore_0
    //   73: aload_0
    //   74: ldc 'ReportUtil'
    //   76: ldc 'destroy'
    //   78: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   81: ldc com/loc/en
    //   83: monitorexit
    //   84: return
    //   85: astore_0
    //   86: ldc com/loc/en
    //   88: monitorexit
    //   89: aload_0
    //   90: athrow
    //   91: ldc com/loc/en
    //   93: monitorexit
    //   94: return
    // Exception table:
    //   from	to	target	type
    //   7	13	72	finally
    //   16	64	72	finally
    //   64	68	72	finally
    //   73	81	85	finally
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
    if (paramInt1 != -1) {
      if (paramInt2 == -1)
        return; 
      if (paramContext != null) {
        try {
          if (!ei.a())
            return; 
          JSONObject jSONObject = new JSONObject();
          jSONObject.put("param_int_first", paramInt1);
          jSONObject.put("param_int_second", paramInt2);
          jSONObject.put("param_long_first", paramLong1);
          jSONObject.put("param_long_second", paramLong2);
          return;
        } finally {
          paramContext = null;
        } 
      } else {
        return;
      } 
    } 
  }
  
  public static void a(Context paramContext, long paramLong, boolean paramBoolean) {
    if (paramContext != null)
      try {
        if (!ei.a())
          return; 
        int i = Long.valueOf(paramLong).intValue();
        String str = "domestic";
        if (!paramBoolean)
          str = "abroad"; 
        return;
      } finally {
        paramContext = null;
      }  
  }
  
  public static void a(Context paramContext, AMapLocation paramAMapLocation) {
    // Byte code:
    //   0: ldc com/loc/en
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic a : (Lcom/amap/api/location/AMapLocation;)Z
    //   7: istore #4
    //   9: iload #4
    //   11: ifne -> 18
    //   14: ldc com/loc/en
    //   16: monitorexit
    //   17: return
    //   18: aload_1
    //   19: invokevirtual getLocationType : ()I
    //   22: istore_2
    //   23: iconst_0
    //   24: istore_3
    //   25: iload_2
    //   26: iconst_1
    //   27: if_icmpeq -> 361
    //   30: iload_2
    //   31: iconst_2
    //   32: if_icmpeq -> 356
    //   35: iload_2
    //   36: iconst_4
    //   37: if_icmpeq -> 356
    //   40: iload_2
    //   41: bipush #8
    //   43: if_icmpeq -> 351
    //   46: iload_2
    //   47: bipush #9
    //   49: if_icmpeq -> 346
    //   52: iconst_0
    //   53: istore_2
    //   54: goto -> 57
    //   57: iload_3
    //   58: ifeq -> 322
    //   61: invokestatic c : ()I
    //   64: istore_3
    //   65: iload_3
    //   66: ifeq -> 91
    //   69: iload_2
    //   70: ifne -> 82
    //   73: iload_3
    //   74: iconst_2
    //   75: if_icmpne -> 91
    //   78: ldc com/loc/en
    //   80: monitorexit
    //   81: return
    //   82: iload_3
    //   83: iconst_1
    //   84: if_icmpne -> 91
    //   87: ldc com/loc/en
    //   89: monitorexit
    //   90: return
    //   91: getstatic com/loc/en.j : Lorg/json/JSONArray;
    //   94: ifnonnull -> 107
    //   97: new org/json/JSONArray
    //   100: dup
    //   101: invokespecial <init> : ()V
    //   104: putstatic com/loc/en.j : Lorg/json/JSONArray;
    //   107: new org/json/JSONObject
    //   110: dup
    //   111: invokespecial <init> : ()V
    //   114: astore #5
    //   116: aload #5
    //   118: ldc 'lon'
    //   120: aload_1
    //   121: invokevirtual getLongitude : ()D
    //   124: invokestatic b : (D)D
    //   127: invokevirtual put : (Ljava/lang/String;D)Lorg/json/JSONObject;
    //   130: pop
    //   131: aload #5
    //   133: ldc 'lat'
    //   135: aload_1
    //   136: invokevirtual getLatitude : ()D
    //   139: invokestatic b : (D)D
    //   142: invokevirtual put : (Ljava/lang/String;D)Lorg/json/JSONObject;
    //   145: pop
    //   146: aload #5
    //   148: ldc_w 'type'
    //   151: iload_2
    //   152: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   155: pop
    //   156: aload #5
    //   158: ldc_w 'timestamp'
    //   161: invokestatic a : ()J
    //   164: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   167: pop
    //   168: aload_1
    //   169: invokevirtual getCoordType : ()Ljava/lang/String;
    //   172: ldc_w 'WGS84'
    //   175: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   178: ifeq -> 194
    //   181: aload #5
    //   183: ldc_w 'coordType'
    //   186: iconst_1
    //   187: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   190: pop
    //   191: goto -> 204
    //   194: aload #5
    //   196: ldc_w 'coordType'
    //   199: iconst_2
    //   200: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   203: pop
    //   204: iload_2
    //   205: ifne -> 295
    //   208: new org/json/JSONObject
    //   211: dup
    //   212: invokespecial <init> : ()V
    //   215: astore #6
    //   217: aload #6
    //   219: ldc_w 'accuracy'
    //   222: aload_1
    //   223: invokevirtual getAccuracy : ()F
    //   226: f2d
    //   227: invokestatic c : (D)D
    //   230: invokevirtual put : (Ljava/lang/String;D)Lorg/json/JSONObject;
    //   233: pop
    //   234: aload #6
    //   236: ldc_w 'altitude'
    //   239: aload_1
    //   240: invokevirtual getAltitude : ()D
    //   243: invokestatic c : (D)D
    //   246: invokevirtual put : (Ljava/lang/String;D)Lorg/json/JSONObject;
    //   249: pop
    //   250: aload #6
    //   252: ldc_w 'bearing'
    //   255: aload_1
    //   256: invokevirtual getBearing : ()F
    //   259: f2d
    //   260: invokestatic c : (D)D
    //   263: invokevirtual put : (Ljava/lang/String;D)Lorg/json/JSONObject;
    //   266: pop
    //   267: aload #6
    //   269: ldc_w 'speed'
    //   272: aload_1
    //   273: invokevirtual getSpeed : ()F
    //   276: f2d
    //   277: invokestatic c : (D)D
    //   280: invokevirtual put : (Ljava/lang/String;D)Lorg/json/JSONObject;
    //   283: pop
    //   284: aload #5
    //   286: ldc_w 'extension'
    //   289: aload #6
    //   291: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   294: pop
    //   295: getstatic com/loc/en.j : Lorg/json/JSONArray;
    //   298: aload #5
    //   300: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   303: astore_1
    //   304: aload_1
    //   305: putstatic com/loc/en.j : Lorg/json/JSONArray;
    //   308: aload_1
    //   309: invokevirtual length : ()I
    //   312: invokestatic b : ()I
    //   315: if_icmplt -> 322
    //   318: aload_0
    //   319: invokestatic f : (Landroid/content/Context;)V
    //   322: ldc com/loc/en
    //   324: monitorexit
    //   325: return
    //   326: astore_0
    //   327: aload_0
    //   328: ldc 'ReportUtil'
    //   330: ldc_w 'recordOfflineLocLog'
    //   333: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   336: ldc com/loc/en
    //   338: monitorexit
    //   339: return
    //   340: astore_0
    //   341: ldc com/loc/en
    //   343: monitorexit
    //   344: aload_0
    //   345: athrow
    //   346: iconst_2
    //   347: istore_2
    //   348: goto -> 363
    //   351: iconst_3
    //   352: istore_2
    //   353: goto -> 363
    //   356: iconst_1
    //   357: istore_2
    //   358: goto -> 363
    //   361: iconst_0
    //   362: istore_2
    //   363: iconst_1
    //   364: istore_3
    //   365: goto -> 57
    // Exception table:
    //   from	to	target	type
    //   3	9	326	finally
    //   18	23	326	finally
    //   61	65	326	finally
    //   91	107	326	finally
    //   107	191	326	finally
    //   194	204	326	finally
    //   208	295	326	finally
    //   295	322	326	finally
    //   327	336	340	finally
  }
  
  public static void a(Context paramContext, AMapLocation paramAMapLocation, dm paramdm) {
    if (paramAMapLocation == null)
      return; 
    try {
    
    } finally {
      paramContext = null;
      ej.a((Throwable)paramContext, "ReportUtil", "reportBatting");
    } 
    if (i != 0)
      String str1 = "abroad"; 
    int i = paramAMapLocation.getErrorCode();
    String str = "net";
    if (i != 0) {
      i = paramAMapLocation.getErrorCode();
      String str1 = str;
      if (i != 4) {
        str1 = str;
        if (i != 5) {
          str1 = str;
          if (i != 6) {
            str1 = str;
            if (i != 11)
              str1 = "cache"; 
          } 
        } 
      } 
    } else {
      int k = paramAMapLocation.getLocationType();
      i = j;
      String str1 = str;
      if (k != 5) {
        i = j;
        str1 = str;
        if (k != 6) {
          str1 = "cache";
          i = j;
        } 
      } 
      j = paramAMapLocation.getErrorCode();
    } 
    i = 0;
    int j = paramAMapLocation.getErrorCode();
  }
  
  public static void a(Context paramContext, String paramString, JSONObject paramJSONObject) {
    // Byte code:
    //   0: ldc com/loc/en
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 122
    //   7: invokestatic a : ()Z
    //   10: ifne -> 16
    //   13: goto -> 122
    //   16: new com/loc/bb
    //   19: dup
    //   20: aload_0
    //   21: ldc_w 'loc'
    //   24: ldc_w '5.2.0'
    //   27: aload_1
    //   28: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   31: astore_1
    //   32: aload_2
    //   33: ifnull -> 44
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual toString : ()Ljava/lang/String;
    //   41: invokevirtual a : (Ljava/lang/String;)V
    //   44: getstatic com/loc/en.i : Ljava/util/List;
    //   47: aload_1
    //   48: invokeinterface add : (Ljava/lang/Object;)Z
    //   53: pop
    //   54: getstatic com/loc/en.i : Ljava/util/List;
    //   57: invokeinterface size : ()I
    //   62: bipush #30
    //   64: if_icmplt -> 98
    //   67: new java/util/ArrayList
    //   70: dup
    //   71: invokespecial <init> : ()V
    //   74: astore_1
    //   75: aload_1
    //   76: getstatic com/loc/en.i : Ljava/util/List;
    //   79: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   84: pop
    //   85: aload_1
    //   86: aload_0
    //   87: invokestatic b : (Ljava/util/List;Landroid/content/Context;)V
    //   90: getstatic com/loc/en.i : Ljava/util/List;
    //   93: invokeinterface clear : ()V
    //   98: ldc com/loc/en
    //   100: monitorexit
    //   101: return
    //   102: astore_0
    //   103: aload_0
    //   104: ldc 'ReportUtil'
    //   106: ldc_w 'applyStatistics'
    //   109: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   112: ldc com/loc/en
    //   114: monitorexit
    //   115: return
    //   116: astore_0
    //   117: ldc com/loc/en
    //   119: monitorexit
    //   120: aload_0
    //   121: athrow
    //   122: ldc com/loc/en
    //   124: monitorexit
    //   125: return
    // Exception table:
    //   from	to	target	type
    //   7	13	102	finally
    //   16	32	102	finally
    //   36	44	102	finally
    //   44	98	102	finally
    //   103	112	116	finally
  }
  
  public static void a(AMapLocation paramAMapLocation1, AMapLocation paramAMapLocation2) {
    try {
      if (g == null) {
        if (!ep.a(paramAMapLocation1))
          return; 
        g = paramAMapLocation1.clone();
      } 
      return;
    } finally {
      paramAMapLocation1 = null;
    } 
  }
  
  public static void a(String paramString, int paramInt) {
    String str;
    if (paramInt != 2011) {
      if (paramInt != 2031) {
        if (paramInt != 2041) {
          if (paramInt != 2081) {
            if (paramInt != 2091) {
              if (paramInt != 2111) {
                if (paramInt != 2121) {
                  if (paramInt != 2141) {
                    if (paramInt != 2021) {
                      if (paramInt != 2022) {
                        if (paramInt != 2061) {
                          if (paramInt != 2062) {
                            if (paramInt != 2151) {
                              if (paramInt != 2152) {
                                switch (paramInt) {
                                  default:
                                    switch (paramInt) {
                                      default:
                                        switch (paramInt) {
                                          default:
                                            str = "";
                                            break;
                                          case 2133:
                                            str = "NoCgiAndWifiOff";
                                            break;
                                          case 2132:
                                            str = "AirPlaneModeAndWifiOff";
                                            break;
                                          case 2131:
                                            break;
                                        } 
                                        str = "NoCgiOAndWifiInfo";
                                        break;
                                      case 2103:
                                        str = "NotConfigAPSService";
                                        break;
                                      case 2102:
                                        str = "AuthClientScodeFail";
                                        break;
                                      case 2101:
                                        break;
                                    } 
                                    str = "BindAPSServiceException";
                                    break;
                                  case 2054:
                                    str = "ParserDataException";
                                    break;
                                  case 2053:
                                    str = "DecryptResponseException";
                                    break;
                                  case 2052:
                                    str = "MaybeIntercepted";
                                    break;
                                  case 2051:
                                    str = "NeedLoginNetWork\t";
                                    break;
                                } 
                              } else {
                                str = "MaybeMockGPSLoc";
                              } 
                            } else {
                              str = "MaybeMockNetLoc";
                            } 
                          } else {
                            str = "ServerLocFail";
                          } 
                        } else {
                          str = "ServerRetypeError";
                        } 
                      } else {
                        str = "OnlyOneWifiButNotMain";
                      } 
                    } else {
                      str = "OnlyMainWifi";
                    } 
                  } else {
                    str = "NoEnoughStatellites";
                  } 
                } else {
                  str = "NotLocPermission";
                } 
              } else {
                str = "ErrorCgiInfo";
              } 
            } else {
              str = "InitException";
            } 
          } else {
            str = "LocalLocException";
          } 
        } else {
          str = "ResponseResultIsNull";
        } 
      } else {
        str = "CreateApsReqException";
      } 
    } else {
      str = "ContextIsNull";
    } 
    a(paramString, String.valueOf(paramInt), str);
  }
  
  public static void a(String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramString1 = null;
      ej.a((Throwable)paramString1, "ReportUtil", "reportLog");
    } 
  }
  
  public static void a(String paramString1, String paramString2, String paramString3) {
    try {
      return;
    } finally {
      paramString1 = null;
    } 
  }
  
  public static void a(String paramString, Throwable paramThrowable) {
    try {
      return;
    } finally {
      paramString = null;
    } 
  }
  
  private static void f(Context paramContext) {
    try {
      return;
    } finally {
      paramContext = null;
      ej.a((Throwable)paramContext, "ReportUtil", "writeOfflineLocLog");
    } 
  }
  
  public final void a(Context paramContext, int paramInt) {
    try {
      if (this.b == paramInt)
        return; 
      if (this.b != -1 && this.b != paramInt) {
        long l1 = ep.b();
        long l2 = this.c;
        long l3 = ((Long)this.a.get(this.b, Long.valueOf(0L))).longValue();
        this.a.append(this.b, Long.valueOf(l1 - l2 + l3));
      } 
      long l = eo.a(paramContext, "pref1", this.d[paramInt], 0L);
      return;
    } finally {
      paramContext = null;
      ej.a((Throwable)paramContext, "ReportUtil", "setLocationType");
    } 
  }
  
  public final void a(Context paramContext, AMapLocationClientOption paramAMapLocationClientOption) {
    try {
      int i = null.a[paramAMapLocationClientOption.getLocationMode().ordinal()];
      byte b = 3;
      if (i != 1) {
        if (i != 2) {
          if (i != 3)
            b = -1; 
        } else {
          b = 5;
        } 
      } else {
        b = 4;
      } 
      if (this.e == b)
        return; 
      if (this.e != -1 && this.e != b) {
        long l1 = ep.b();
        long l2 = this.f;
        long l3 = ((Long)this.a.get(this.e, Long.valueOf(0L))).longValue();
        this.a.append(this.e, Long.valueOf(l1 - l2 + l3));
      } 
      long l = eo.a(paramContext, "pref1", this.d[b], 0L);
      return;
    } finally {
      paramContext = null;
      ej.a((Throwable)paramContext, "ReportUtil", "setLocationMode");
    } 
  }
  
  public final void b(Context paramContext) {
    try {
      int i;
      long l1 = ep.b();
      long l2 = this.c;
      if (this.b != -1) {
        long l = ((Long)this.a.get(this.b, Long.valueOf(0L))).longValue();
        this.a.append(this.b, Long.valueOf(l1 - l2 + l));
      } 
      l1 = ep.b();
      l2 = this.f;
      if (this.e != -1) {
        long l = ((Long)this.a.get(this.e, Long.valueOf(0L))).longValue();
        this.a.append(this.e, Long.valueOf(l1 - l2 + l));
      } 
    } finally {
      paramContext = null;
      ej.a((Throwable)paramContext, "ReportUtil", "saveLocationTypeAndMode");
    } 
  }
  
  public final int c(Context paramContext) {
    try {
      long l1 = eo.a(paramContext, "pref1", this.d[2], 0L);
      long l3 = eo.a(paramContext, "pref1", this.d[0], 0L);
      long l2 = eo.a(paramContext, "pref1", this.d[1], 0L);
      if (l1 == 0L && l3 == 0L && l2 == 0L)
        return -1; 
      l3 -= l1;
      return (l1 > l3) ? ((l1 > l2) ? 2 : 1) : ((l3 > l2) ? 0 : 1);
    } finally {
      paramContext = null;
    } 
  }
  
  public final int d(Context paramContext) {
    try {
      long l1 = eo.a(paramContext, "pref1", this.d[3], 0L);
      long l2 = eo.a(paramContext, "pref1", this.d[4], 0L);
      return (l1 == 0L && l2 == 0L && l3 == 0L) ? -1 : ((l1 > l2) ? ((l1 > l3) ? 3 : 5) : ((l2 > l3) ? 4 : 5));
    } finally {
      paramContext = null;
    } 
  }
  
  public final void e(Context paramContext) {
    try {
      SharedPreferences.Editor editor = eo.a(paramContext, "pref1");
      for (int i = 0; i < this.d.length; i++)
        eo.a(editor, this.d[i], 0L); 
      return;
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\en.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */