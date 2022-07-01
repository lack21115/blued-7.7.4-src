package com.loc;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a {
  private static boolean A = false;
  
  en a = null;
  
  Context b = null;
  
  PendingIntent c = null;
  
  String d = null;
  
  GeoFenceListener e = null;
  
  volatile int f = 1;
  
  ArrayList<GeoFence> g = new ArrayList<GeoFence>();
  
  c h = null;
  
  Object i = new Object();
  
  Object j = new Object();
  
  a k = null;
  
  b l = null;
  
  volatile boolean m = false;
  
  volatile boolean n = false;
  
  volatile boolean o = false;
  
  b p = null;
  
  c q = null;
  
  AMapLocationClient r = null;
  
  volatile AMapLocation s = null;
  
  long t = 0L;
  
  AMapLocationClientOption u = null;
  
  int v = 0;
  
  AMapLocationListener w = new AMapLocationListener(this) {
      public final void onLocationChanged(AMapLocation param1AMapLocation) {
        try {
          boolean bool;
          byte b;
          if (this.a.y)
            return; 
          if (!this.a.o)
            return; 
          this.a.s = param1AMapLocation;
          if (param1AMapLocation != null) {
            b = param1AMapLocation.getErrorCode();
            if (param1AMapLocation.getErrorCode() == 0) {
              this.a.t = ep.b();
              this.a.a(5, (Bundle)null, 0L);
              bool = true;
            } else {
              bool = param1AMapLocation.getErrorCode();
              String str = param1AMapLocation.getErrorInfo();
              StringBuilder stringBuilder = new StringBuilder("locationDetail:");
              stringBuilder.append(param1AMapLocation.getLocationDetail());
              a.a("定位失败", bool, str, new String[] { stringBuilder.toString() });
              bool = false;
            } 
          } else {
            bool = false;
            b = 8;
          } 
          if (bool) {
            this.a.v = 0;
            return;
          } 
          Bundle bundle = new Bundle();
          if (!this.a.m) {
            this.a.b(7);
            bundle.putLong("interval", 2000L);
            this.a.a(8, bundle, 2000L);
          } 
          a a1 = this.a;
          a1.v++;
          return;
        } finally {
          param1AMapLocation = null;
        } 
      }
    };
  
  final int x = 3;
  
  volatile boolean y = false;
  
  private Object z = new Object();
  
  public a(Context paramContext) {
    try {
      return;
    } finally {
      paramContext = null;
      ej.a((Throwable)paramContext, "GeoFenceManger", "<init>");
    } 
  }
  
  static float a(DPoint paramDPoint, List<DPoint> paramList) {
    float f1 = Float.MAX_VALUE;
    float f2 = f1;
    if (paramDPoint != null) {
      f2 = f1;
      if (paramList != null) {
        f2 = f1;
        if (!paramList.isEmpty()) {
          Iterator<DPoint> iterator = paramList.iterator();
          while (true) {
            f2 = f1;
            if (iterator.hasNext()) {
              f1 = Math.min(f1, ep.a(paramDPoint, iterator.next()));
              continue;
            } 
            break;
          } 
        } 
      } 
    } 
    return f2;
  }
  
  private int a(List<GeoFence> paramList) {
    try {
      return 0;
    } finally {
      paramList = null;
      ej.a((Throwable)paramList, "GeoFenceManager", "addGeoFenceList");
      a("添加围栏失败", 8, paramList.getMessage(), new String[0]);
    } 
  }
  
  private static Bundle a(GeoFence paramGeoFence, String paramString1, String paramString2, int paramInt1, int paramInt2) {
    Bundle bundle = new Bundle();
    String str = paramString1;
    if (paramString1 == null)
      str = ""; 
    bundle.putString("fenceid", str);
    bundle.putString("customId", paramString2);
    bundle.putInt("event", paramInt1);
    bundle.putInt("location_errorcode", paramInt2);
    bundle.putParcelable("fence", (Parcelable)paramGeoFence);
    return bundle;
  }
  
  static void a(String paramString1, int paramInt, String paramString2, String... paramVarArgs) {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("===========================================\n");
    StringBuilder stringBuilder2 = new StringBuilder("              ");
    stringBuilder2.append(paramString1);
    stringBuilder2.append("                ");
    stringBuffer.append(stringBuilder2.toString());
    stringBuffer.append("\n");
    stringBuffer.append("-------------------------------------------\n");
    StringBuilder stringBuilder1 = new StringBuilder("errorCode:");
    stringBuilder1.append(paramInt);
    stringBuffer.append(stringBuilder1.toString());
    stringBuffer.append("\n");
    stringBuilder1 = new StringBuilder("错误信息:");
    stringBuilder1.append(paramString2);
    stringBuffer.append(stringBuilder1.toString());
    stringBuffer.append("\n");
    if (paramVarArgs.length > 0) {
      int i = paramVarArgs.length;
      for (paramInt = 0; paramInt < i; paramInt++) {
        stringBuffer.append(paramVarArgs[paramInt]);
        stringBuffer.append("\n");
      } 
    } 
    stringBuffer.append("===========================================\n");
    Log.i("fenceErrLog", stringBuffer.toString());
  }
  
  private static boolean a(GeoFence paramGeoFence, int paramInt) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #4
    //   3: iconst_0
    //   4: istore_3
    //   5: iload_3
    //   6: istore_2
    //   7: iload_1
    //   8: iconst_1
    //   9: iand
    //   10: iconst_1
    //   11: if_icmpne -> 29
    //   14: iload_3
    //   15: istore_2
    //   16: aload_0
    //   17: invokevirtual getStatus : ()I
    //   20: iconst_1
    //   21: if_icmpne -> 29
    //   24: iconst_1
    //   25: istore_2
    //   26: goto -> 29
    //   29: iload_2
    //   30: istore_3
    //   31: iload_1
    //   32: iconst_2
    //   33: iand
    //   34: iconst_2
    //   35: if_icmpne -> 53
    //   38: iload_2
    //   39: istore_3
    //   40: iload_2
    //   41: istore #4
    //   43: aload_0
    //   44: invokevirtual getStatus : ()I
    //   47: iconst_2
    //   48: if_icmpne -> 53
    //   51: iconst_1
    //   52: istore_3
    //   53: iload_3
    //   54: istore #4
    //   56: iload_1
    //   57: iconst_4
    //   58: iand
    //   59: iconst_4
    //   60: if_icmpne -> 91
    //   63: iload_3
    //   64: istore #4
    //   66: aload_0
    //   67: invokevirtual getStatus : ()I
    //   70: istore_1
    //   71: iload_3
    //   72: istore #4
    //   74: iload_1
    //   75: iconst_3
    //   76: if_icmpne -> 91
    //   79: iconst_1
    //   80: ireturn
    //   81: aload_0
    //   82: ldc_w 'Utils'
    //   85: ldc_w 'remindStatus'
    //   88: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   91: iload #4
    //   93: ireturn
    //   94: astore_0
    //   95: goto -> 81
    // Exception table:
    //   from	to	target	type
    //   16	24	94	finally
    //   43	51	94	finally
    //   66	71	94	finally
  }
  
  private static boolean a(AMapLocation paramAMapLocation, GeoFence paramGeoFence) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic a : (Lcom/amap/api/location/AMapLocation;)Z
    //   4: ifeq -> 222
    //   7: aload_1
    //   8: ifnull -> 222
    //   11: aload_1
    //   12: invokevirtual getPointList : ()Ljava/util/List;
    //   15: ifnull -> 222
    //   18: aload_1
    //   19: invokevirtual getPointList : ()Ljava/util/List;
    //   22: invokeinterface isEmpty : ()Z
    //   27: ifne -> 222
    //   30: aload_1
    //   31: invokevirtual getType : ()I
    //   34: istore #4
    //   36: iload #4
    //   38: ifeq -> 152
    //   41: iload #4
    //   43: iconst_1
    //   44: if_icmpeq -> 62
    //   47: iload #4
    //   49: iconst_2
    //   50: if_icmpeq -> 152
    //   53: iload #4
    //   55: iconst_3
    //   56: if_icmpeq -> 62
    //   59: goto -> 222
    //   62: aload_1
    //   63: invokevirtual getPointList : ()Ljava/util/List;
    //   66: invokeinterface iterator : ()Ljava/util/Iterator;
    //   71: astore_1
    //   72: iconst_0
    //   73: istore #5
    //   75: aload_1
    //   76: invokeinterface hasNext : ()Z
    //   81: ifeq -> 145
    //   84: aload_1
    //   85: invokeinterface next : ()Ljava/lang/Object;
    //   90: checkcast java/util/List
    //   93: astore #7
    //   95: aload #7
    //   97: invokeinterface size : ()I
    //   102: iconst_3
    //   103: if_icmpge -> 112
    //   106: iconst_0
    //   107: istore #6
    //   109: goto -> 134
    //   112: new com/amap/api/location/DPoint
    //   115: dup
    //   116: aload_0
    //   117: invokevirtual getLatitude : ()D
    //   120: aload_0
    //   121: invokevirtual getLongitude : ()D
    //   124: invokespecial <init> : (DD)V
    //   127: aload #7
    //   129: invokestatic a : (Lcom/amap/api/location/DPoint;Ljava/util/List;)Z
    //   132: istore #6
    //   134: iload #6
    //   136: ifeq -> 75
    //   139: iconst_1
    //   140: istore #5
    //   142: goto -> 75
    //   145: iload #5
    //   147: ireturn
    //   148: astore_0
    //   149: goto -> 228
    //   152: aload_1
    //   153: invokevirtual getCenter : ()Lcom/amap/api/location/DPoint;
    //   156: astore #7
    //   158: aload_1
    //   159: invokevirtual getRadius : ()F
    //   162: fstore_2
    //   163: iconst_4
    //   164: newarray double
    //   166: dup
    //   167: iconst_0
    //   168: aload #7
    //   170: invokevirtual getLatitude : ()D
    //   173: dastore
    //   174: dup
    //   175: iconst_1
    //   176: aload #7
    //   178: invokevirtual getLongitude : ()D
    //   181: dastore
    //   182: dup
    //   183: iconst_2
    //   184: aload_0
    //   185: invokevirtual getLatitude : ()D
    //   188: dastore
    //   189: dup
    //   190: iconst_3
    //   191: aload_0
    //   192: invokevirtual getLongitude : ()D
    //   195: dastore
    //   196: invokestatic a : ([D)F
    //   199: fstore_3
    //   200: fload_3
    //   201: fload_2
    //   202: fcmpg
    //   203: ifgt -> 212
    //   206: iconst_1
    //   207: istore #4
    //   209: goto -> 215
    //   212: iconst_0
    //   213: istore #4
    //   215: iload #4
    //   217: ifeq -> 222
    //   220: iconst_1
    //   221: ireturn
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_0
    //   225: iconst_0
    //   226: istore #5
    //   228: aload_0
    //   229: ldc_w 'Utils'
    //   232: ldc_w 'isInGeoFence'
    //   235: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   238: iload #5
    //   240: ireturn
    // Exception table:
    //   from	to	target	type
    //   0	7	224	finally
    //   11	36	224	finally
    //   62	72	224	finally
    //   75	106	148	finally
    //   112	134	148	finally
    //   152	200	224	finally
  }
  
  static float b(DPoint paramDPoint, List<DPoint> paramList) {
    float f3 = Float.MIN_VALUE;
    float f1 = Float.MIN_VALUE;
    float f2 = f3;
    if (paramDPoint != null) {
      f2 = f3;
      if (paramList != null) {
        f2 = f3;
        if (!paramList.isEmpty()) {
          Iterator<DPoint> iterator = paramList.iterator();
          while (true) {
            f2 = f1;
            if (iterator.hasNext()) {
              f1 = Math.max(f1, ep.a(paramDPoint, iterator.next()));
              continue;
            } 
            break;
          } 
        } 
      } 
    } 
    return f2;
  }
  
  private static DPoint b(List<DPoint> paramList) {
    DPoint dPoint = new DPoint();
    if (paramList != null)
      try {
        double d1;
        Iterator<DPoint> iterator = paramList.iterator();
        double d2 = 0.0D;
        return new DPoint(ep.b(d2 / paramList.size()), ep.b(d1 / paramList.size()));
      } finally {
        paramList = null;
      }  
    return dPoint;
  }
  
  private void b(int paramInt, Bundle paramBundle) {
    // Byte code:
    //   0: new android/os/Bundle
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #12
    //   9: new java/util/ArrayList
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore #11
    //   18: aload_2
    //   19: ifnull -> 922
    //   22: aload_2
    //   23: invokevirtual isEmpty : ()Z
    //   26: ifne -> 922
    //   29: new java/util/ArrayList
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: astore #14
    //   38: aload_2
    //   39: ldc 'customId'
    //   41: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   44: astore #13
    //   46: aload_2
    //   47: ldc_w 'keyWords'
    //   50: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   53: astore #16
    //   55: aload_2
    //   56: ldc_w 'city'
    //   59: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   62: astore #17
    //   64: aload_2
    //   65: ldc_w 'poiType'
    //   68: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   71: astore #18
    //   73: aload_2
    //   74: ldc_w 'centerPoint'
    //   77: invokevirtual getParcelable : (Ljava/lang/String;)Landroid/os/Parcelable;
    //   80: checkcast com/amap/api/location/DPoint
    //   83: astore #19
    //   85: aload_2
    //   86: ldc_w 'searchSize'
    //   89: bipush #10
    //   91: invokevirtual getInt : (Ljava/lang/String;I)I
    //   94: istore #9
    //   96: aload_2
    //   97: ldc_w 'aroundRadius'
    //   100: ldc_w 3000.0
    //   103: invokevirtual getFloat : (Ljava/lang/String;F)F
    //   106: fstore #7
    //   108: aload #16
    //   110: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   113: istore #10
    //   115: iload #10
    //   117: ifeq -> 126
    //   120: iconst_0
    //   121: istore #8
    //   123: goto -> 262
    //   126: iload_1
    //   127: iconst_1
    //   128: if_icmpeq -> 251
    //   131: iload_1
    //   132: iconst_2
    //   133: if_icmpeq -> 139
    //   136: goto -> 1001
    //   139: aload #19
    //   141: ifnonnull -> 147
    //   144: goto -> 120
    //   147: aload #19
    //   149: invokevirtual getLatitude : ()D
    //   152: ldc2_w 90.0
    //   155: dcmpl
    //   156: ifgt -> 195
    //   159: aload #19
    //   161: invokevirtual getLatitude : ()D
    //   164: ldc2_w -90.0
    //   167: dcmpg
    //   168: iflt -> 195
    //   171: aload #19
    //   173: invokevirtual getLongitude : ()D
    //   176: ldc2_w 180.0
    //   179: dcmpl
    //   180: ifgt -> 195
    //   183: aload #19
    //   185: invokevirtual getLongitude : ()D
    //   188: ldc2_w -180.0
    //   191: dcmpg
    //   192: ifge -> 136
    //   195: new java/lang/StringBuilder
    //   198: dup
    //   199: ldc_w '经纬度错误，传入的纬度：'
    //   202: invokespecial <init> : (Ljava/lang/String;)V
    //   205: astore_2
    //   206: aload_2
    //   207: aload #19
    //   209: invokevirtual getLatitude : ()D
    //   212: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_2
    //   217: ldc_w '传入的经度:'
    //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_2
    //   225: aload #19
    //   227: invokevirtual getLongitude : ()D
    //   230: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: ldc '添加围栏失败'
    //   236: iconst_0
    //   237: aload_2
    //   238: invokevirtual toString : ()Ljava/lang/String;
    //   241: iconst_0
    //   242: anewarray java/lang/String
    //   245: invokestatic a : (Ljava/lang/String;ILjava/lang/String;[Ljava/lang/String;)V
    //   248: goto -> 120
    //   251: aload #18
    //   253: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   256: ifeq -> 1001
    //   259: goto -> 120
    //   262: iload #8
    //   264: ifeq -> 865
    //   267: new android/os/Bundle
    //   270: dup
    //   271: invokespecial <init> : ()V
    //   274: astore #15
    //   276: aload #15
    //   278: ldc 'customId'
    //   280: aload #13
    //   282: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload #15
    //   287: ldc_w 'pendingIntentAction'
    //   290: aload_0
    //   291: getfield d : Ljava/lang/String;
    //   294: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload #15
    //   299: ldc_w 'expiration'
    //   302: ldc2_w -1
    //   305: invokevirtual putLong : (Ljava/lang/String;J)V
    //   308: aload #15
    //   310: ldc_w 'activatesAction'
    //   313: aload_0
    //   314: getfield f : I
    //   317: invokevirtual putInt : (Ljava/lang/String;I)V
    //   320: iload_1
    //   321: iconst_1
    //   322: if_icmpeq -> 445
    //   325: iload_1
    //   326: iconst_2
    //   327: if_icmpeq -> 360
    //   330: iload_1
    //   331: iconst_3
    //   332: if_icmpeq -> 340
    //   335: aconst_null
    //   336: astore_2
    //   337: goto -> 482
    //   340: aload_0
    //   341: getfield p : Lcom/loc/b;
    //   344: aload_0
    //   345: getfield b : Landroid/content/Context;
    //   348: ldc_w 'http://restsdk.amap.com/v3/config/district?'
    //   351: aload #16
    //   353: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   356: astore_2
    //   357: goto -> 482
    //   360: aload #19
    //   362: invokevirtual getLatitude : ()D
    //   365: invokestatic b : (D)D
    //   368: dstore_3
    //   369: aload #19
    //   371: invokevirtual getLongitude : ()D
    //   374: invokestatic b : (D)D
    //   377: dstore #5
    //   379: fload #7
    //   381: invokestatic valueOf : (F)Ljava/lang/Float;
    //   384: invokevirtual intValue : ()I
    //   387: istore #8
    //   389: aload #15
    //   391: ldc_w 'fenceRadius'
    //   394: ldc_w 200.0
    //   397: invokevirtual putFloat : (Ljava/lang/String;F)V
    //   400: aload_0
    //   401: getfield p : Lcom/loc/b;
    //   404: aload_0
    //   405: getfield b : Landroid/content/Context;
    //   408: ldc_w 'http://restsdk.amap.com/v3/place/around?'
    //   411: aload #16
    //   413: aload #18
    //   415: iload #9
    //   417: invokestatic valueOf : (I)Ljava/lang/String;
    //   420: dload_3
    //   421: invokestatic valueOf : (D)Ljava/lang/String;
    //   424: dload #5
    //   426: invokestatic valueOf : (D)Ljava/lang/String;
    //   429: iload #8
    //   431: invokestatic valueOf : (I)Ljava/lang/String;
    //   434: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   437: astore_2
    //   438: goto -> 482
    //   441: astore_2
    //   442: goto -> 946
    //   445: aload #15
    //   447: ldc_w 'fenceRadius'
    //   450: ldc_w 1000.0
    //   453: invokevirtual putFloat : (Ljava/lang/String;F)V
    //   456: aload_0
    //   457: getfield p : Lcom/loc/b;
    //   460: aload_0
    //   461: getfield b : Landroid/content/Context;
    //   464: ldc_w 'http://restsdk.amap.com/v3/place/text?'
    //   467: aload #16
    //   469: aload #18
    //   471: aload #17
    //   473: iload #9
    //   475: invokestatic valueOf : (I)Ljava/lang/String;
    //   478: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   481: astore_2
    //   482: iconst_4
    //   483: istore #8
    //   485: aload_2
    //   486: ifnull -> 853
    //   489: iconst_1
    //   490: iload_1
    //   491: if_icmpne -> 1007
    //   494: aload_2
    //   495: aload #14
    //   497: aload #15
    //   499: invokestatic a : (Ljava/lang/String;Ljava/util/List;Landroid/os/Bundle;)I
    //   502: istore #8
    //   504: goto -> 507
    //   507: iconst_2
    //   508: iload_1
    //   509: if_icmpne -> 522
    //   512: aload_2
    //   513: aload #14
    //   515: aload #15
    //   517: invokestatic a : (Ljava/lang/String;Ljava/util/List;Landroid/os/Bundle;)I
    //   520: istore #8
    //   522: iconst_3
    //   523: iload_1
    //   524: if_icmpne -> 1013
    //   527: aload_0
    //   528: getfield q : Lcom/loc/c;
    //   531: aload_2
    //   532: aload #14
    //   534: aload #15
    //   536: invokevirtual b : (Ljava/lang/String;Ljava/util/List;Landroid/os/Bundle;)I
    //   539: istore #8
    //   541: goto -> 544
    //   544: iload #8
    //   546: sipush #10000
    //   549: if_icmpne -> 599
    //   552: aload #14
    //   554: invokeinterface isEmpty : ()Z
    //   559: ifeq -> 568
    //   562: bipush #16
    //   564: istore_1
    //   565: goto -> 867
    //   568: aload_0
    //   569: aload #14
    //   571: invokespecial a : (Ljava/util/List;)I
    //   574: istore_1
    //   575: iload_1
    //   576: ifne -> 593
    //   579: iload_1
    //   580: istore #8
    //   582: aload #11
    //   584: aload #14
    //   586: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   589: pop
    //   590: goto -> 867
    //   593: iload_1
    //   594: istore #8
    //   596: goto -> 853
    //   599: iload #8
    //   601: istore_1
    //   602: iload #8
    //   604: iconst_1
    //   605: if_icmpeq -> 800
    //   608: iload #8
    //   610: istore_1
    //   611: iload #8
    //   613: bipush #7
    //   615: if_icmpeq -> 800
    //   618: iload #8
    //   620: istore_1
    //   621: iload #8
    //   623: iconst_4
    //   624: if_icmpeq -> 800
    //   627: iload #8
    //   629: istore_1
    //   630: iload #8
    //   632: iconst_5
    //   633: if_icmpeq -> 800
    //   636: iload #8
    //   638: istore_1
    //   639: iload #8
    //   641: bipush #16
    //   643: if_icmpeq -> 800
    //   646: iload #8
    //   648: istore_1
    //   649: iload #8
    //   651: bipush #17
    //   653: if_icmpeq -> 800
    //   656: iload #8
    //   658: tableswitch default -> 744, 10000 -> 798, 10001 -> 792, 10002 -> 792, 10003 -> 787, 10004 -> 787, 10005 -> 787, 10006 -> 787, 10007 -> 792, 10008 -> 792, 10009 -> 792, 10010 -> 787, 10011 -> 787, 10012 -> 792, 10013 -> 792, 10014 -> 787, 10015 -> 787, 10016 -> 787, 10017 -> 787
    //   744: iload #8
    //   746: tableswitch default -> 776, 20000 -> 782, 20001 -> 782, 20002 -> 782, 20003 -> 776
    //   776: bipush #8
    //   778: istore_1
    //   779: goto -> 800
    //   782: iconst_1
    //   783: istore_1
    //   784: goto -> 800
    //   787: iconst_4
    //   788: istore_1
    //   789: goto -> 800
    //   792: bipush #7
    //   794: istore_1
    //   795: goto -> 800
    //   798: iconst_0
    //   799: istore_1
    //   800: iload_1
    //   801: ifeq -> 850
    //   804: new java/lang/StringBuilder
    //   807: dup
    //   808: ldc_w 'searchErrCode is '
    //   811: invokespecial <init> : (Ljava/lang/String;)V
    //   814: astore_2
    //   815: aload_2
    //   816: iload_1
    //   817: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   820: pop
    //   821: aload_2
    //   822: invokevirtual toString : ()Ljava/lang/String;
    //   825: astore_2
    //   826: iconst_0
    //   827: istore #8
    //   829: ldc '添加围栏失败'
    //   831: iload_1
    //   832: aload_2
    //   833: iconst_0
    //   834: anewarray java/lang/String
    //   837: invokestatic a : (Ljava/lang/String;ILjava/lang/String;[Ljava/lang/String;)V
    //   840: goto -> 850
    //   843: astore_2
    //   844: iload #8
    //   846: istore_1
    //   847: goto -> 903
    //   850: goto -> 867
    //   853: iload #8
    //   855: istore_1
    //   856: goto -> 867
    //   859: astore_2
    //   860: iconst_0
    //   861: istore_1
    //   862: goto -> 903
    //   865: iconst_1
    //   866: istore_1
    //   867: iload_1
    //   868: istore #8
    //   870: aload #12
    //   872: ldc 'customId'
    //   874: aload #13
    //   876: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   879: iload_1
    //   880: istore #8
    //   882: aload #12
    //   884: ldc_w 'resultList'
    //   887: aload #11
    //   889: invokevirtual putParcelableArrayList : (Ljava/lang/String;Ljava/util/ArrayList;)V
    //   892: ldc_w 'errorCode'
    //   895: astore_2
    //   896: goto -> 928
    //   899: astore_2
    //   900: iload #8
    //   902: istore_1
    //   903: ldc_w 'errorCode'
    //   906: astore #11
    //   908: goto -> 953
    //   911: astore_2
    //   912: iconst_0
    //   913: istore_1
    //   914: ldc_w 'errorCode'
    //   917: astore #11
    //   919: goto -> 953
    //   922: ldc_w 'errorCode'
    //   925: astore_2
    //   926: iconst_1
    //   927: istore_1
    //   928: aload #12
    //   930: aload_2
    //   931: iload_1
    //   932: invokevirtual putInt : (Ljava/lang/String;I)V
    //   935: aload_0
    //   936: sipush #1000
    //   939: aload #12
    //   941: invokevirtual a : (ILandroid/os/Bundle;)V
    //   944: return
    //   945: astore_2
    //   946: ldc_w 'errorCode'
    //   949: astore #11
    //   951: iconst_0
    //   952: istore_1
    //   953: aload_2
    //   954: ldc 'GeoFenceManager'
    //   956: ldc_w 'doAddGeoFenceNearby'
    //   959: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   962: aload #12
    //   964: aload #11
    //   966: bipush #8
    //   968: invokevirtual putInt : (Ljava/lang/String;I)V
    //   971: aload_0
    //   972: sipush #1000
    //   975: aload #12
    //   977: invokevirtual a : (ILandroid/os/Bundle;)V
    //   980: return
    //   981: astore_2
    //   982: aload #12
    //   984: aload #11
    //   986: iload_1
    //   987: invokevirtual putInt : (Ljava/lang/String;I)V
    //   990: aload_0
    //   991: sipush #1000
    //   994: aload #12
    //   996: invokevirtual a : (ILandroid/os/Bundle;)V
    //   999: aload_2
    //   1000: athrow
    //   1001: iconst_1
    //   1002: istore #8
    //   1004: goto -> 262
    //   1007: iconst_0
    //   1008: istore #8
    //   1010: goto -> 507
    //   1013: goto -> 544
    // Exception table:
    //   from	to	target	type
    //   9	18	945	finally
    //   22	115	911	finally
    //   147	195	945	finally
    //   195	248	945	finally
    //   251	259	911	finally
    //   267	297	911	finally
    //   297	320	859	finally
    //   340	357	441	finally
    //   360	438	441	finally
    //   445	482	859	finally
    //   494	504	441	finally
    //   512	522	441	finally
    //   527	541	441	finally
    //   552	562	441	finally
    //   568	575	441	finally
    //   582	590	899	finally
    //   804	826	859	finally
    //   829	840	843	finally
    //   870	879	899	finally
    //   882	892	899	finally
    //   953	962	981	finally
  }
  
  private static boolean b(AMapLocation paramAMapLocation, GeoFence paramGeoFence) {
    boolean bool = true;
    try {
      return false;
    } finally {
      paramAMapLocation = null;
    } 
    ej.a((Throwable)paramAMapLocation, "Utils", "isFenceStatusChanged");
    return bool;
  }
  
  private void k() {
    if (!this.o)
      this.o = true; 
    if (this.n)
      return; 
    try {
      c c1;
      if (Looper.myLooper() == null) {
        c1 = new c(this, this.b.getMainLooper());
      } else {
        c1 = new c(this);
      } 
    } finally {
      Exception exception = null;
    } 
    try {
      this.l = new b("fenceActionThread");
      this.l.setPriority(5);
      this.l.start();
      this.k = new a(this, this.l.getLooper());
    } finally {
      Exception exception = null;
    } 
    try {
      if (this.d != null && this.c == null)
        a(this.d); 
    } finally {
      Exception exception = null;
    } 
  }
  
  public final PendingIntent a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield z : Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: new android/content/Intent
    //   10: dup
    //   11: aload_1
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: astore_3
    //   16: aload_3
    //   17: aload_0
    //   18: getfield b : Landroid/content/Context;
    //   21: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   24: invokevirtual setPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   27: pop
    //   28: aload_0
    //   29: aload_0
    //   30: getfield b : Landroid/content/Context;
    //   33: iconst_0
    //   34: aload_3
    //   35: iconst_0
    //   36: invokestatic getBroadcast : (Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   39: putfield c : Landroid/app/PendingIntent;
    //   42: aload_0
    //   43: aload_1
    //   44: putfield d : Ljava/lang/String;
    //   47: aload_0
    //   48: getfield g : Ljava/util/ArrayList;
    //   51: ifnull -> 120
    //   54: aload_0
    //   55: getfield g : Ljava/util/ArrayList;
    //   58: invokevirtual isEmpty : ()Z
    //   61: ifne -> 120
    //   64: aload_0
    //   65: getfield g : Ljava/util/ArrayList;
    //   68: invokevirtual iterator : ()Ljava/util/Iterator;
    //   71: astore_1
    //   72: aload_1
    //   73: invokeinterface hasNext : ()Z
    //   78: ifeq -> 120
    //   81: aload_1
    //   82: invokeinterface next : ()Ljava/lang/Object;
    //   87: checkcast com/amap/api/fence/GeoFence
    //   90: astore_3
    //   91: aload_3
    //   92: aload_0
    //   93: getfield c : Landroid/app/PendingIntent;
    //   96: invokevirtual setPendingIntent : (Landroid/app/PendingIntent;)V
    //   99: aload_3
    //   100: aload_0
    //   101: getfield d : Ljava/lang/String;
    //   104: invokevirtual setPendingIntentAction : (Ljava/lang/String;)V
    //   107: goto -> 72
    //   110: astore_1
    //   111: aload_1
    //   112: ldc 'GeoFenceManager'
    //   114: ldc_w 'createPendingIntent'
    //   117: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_2
    //   121: monitorexit
    //   122: aload_0
    //   123: getfield c : Landroid/app/PendingIntent;
    //   126: areturn
    //   127: astore_1
    //   128: aload_2
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Exception table:
    //   from	to	target	type
    //   7	72	110	finally
    //   72	107	110	finally
    //   111	120	127	finally
    //   120	122	127	finally
    //   128	130	127	finally
  }
  
  final GeoFence a(Bundle paramBundle, boolean paramBoolean) {
    GeoFence geoFence = new GeoFence();
    ArrayList<DPoint> arrayList1 = new ArrayList();
    DPoint dPoint = new DPoint();
    if (paramBoolean) {
      geoFence.setType(1);
      arrayList1 = paramBundle.getParcelableArrayList("pointList");
      if (arrayList1 != null)
        dPoint = b(arrayList1); 
      geoFence.setMaxDis2Center(b(dPoint, arrayList1));
      geoFence.setMinDis2Center(a(dPoint, arrayList1));
    } else {
      geoFence.setType(0);
      dPoint = (DPoint)paramBundle.getParcelable("centerPoint");
      if (dPoint != null)
        arrayList1.add(dPoint); 
      float f1 = 1000.0F;
      float f2 = paramBundle.getFloat("fenceRadius", 1000.0F);
      if (f2 > 0.0F)
        f1 = f2; 
      geoFence.setRadius(f1);
      geoFence.setMinDis2Center(f1);
      geoFence.setMaxDis2Center(f1);
    } 
    geoFence.setActivatesAction(this.f);
    geoFence.setCustomId(paramBundle.getString("customId"));
    ArrayList<ArrayList<DPoint>> arrayList = new ArrayList();
    arrayList.add(arrayList1);
    geoFence.setPointList(arrayList);
    geoFence.setCenter(dPoint);
    geoFence.setPendingIntentAction(this.d);
    geoFence.setExpiration(-1L);
    geoFence.setPendingIntent(this.c);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(c.a());
    geoFence.setFenceId(stringBuilder.toString());
    en en1 = this.a;
    if (en1 != null)
      en1.a(this.b, 2); 
    return geoFence;
  }
  
  public final void a() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "GeoFenceManager", "removeGeoFence");
    } 
  }
  
  public final void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial k : ()V
    //   4: iload_1
    //   5: bipush #7
    //   7: if_icmpgt -> 55
    //   10: iload_1
    //   11: istore_2
    //   12: iload_1
    //   13: ifgt -> 19
    //   16: goto -> 55
    //   19: new android/os/Bundle
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: astore_3
    //   27: aload_3
    //   28: ldc_w 'activatesAction'
    //   31: iload_2
    //   32: invokevirtual putInt : (Ljava/lang/String;I)V
    //   35: aload_0
    //   36: bipush #9
    //   38: aload_3
    //   39: lconst_0
    //   40: invokevirtual a : (ILandroid/os/Bundle;J)V
    //   43: return
    //   44: astore_3
    //   45: aload_3
    //   46: ldc 'GeoFenceManager'
    //   48: ldc_w 'setActivateAction'
    //   51: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   54: return
    //   55: iconst_1
    //   56: istore_2
    //   57: goto -> 19
    // Exception table:
    //   from	to	target	type
    //   0	4	44	finally
    //   19	43	44	finally
  }
  
  final void a(int paramInt, Bundle paramBundle) {
    try {
    
    } finally {
      paramBundle = null;
      ej.a((Throwable)paramBundle, "GeoFenceManager", "sendResultHandlerMessage");
    } 
  }
  
  final void a(int paramInt, Bundle paramBundle, long paramLong) {
    try {
    
    } finally {
      paramBundle = null;
      ej.a((Throwable)paramBundle, "GeoFenceManager", "sendActionHandlerMessage");
    } 
  }
  
  final void a(Bundle paramBundle) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_1
    //   3: ifnull -> 15
    //   6: aload_1
    //   7: ldc_w 'activatesAction'
    //   10: iconst_1
    //   11: invokevirtual getInt : (Ljava/lang/String;I)I
    //   14: istore_2
    //   15: aload_0
    //   16: getfield f : I
    //   19: iload_2
    //   20: if_icmpeq -> 86
    //   23: aload_0
    //   24: getfield g : Ljava/util/ArrayList;
    //   27: ifnull -> 82
    //   30: aload_0
    //   31: getfield g : Ljava/util/ArrayList;
    //   34: invokevirtual isEmpty : ()Z
    //   37: ifne -> 82
    //   40: aload_0
    //   41: getfield g : Ljava/util/ArrayList;
    //   44: invokevirtual iterator : ()Ljava/util/Iterator;
    //   47: astore_1
    //   48: aload_1
    //   49: invokeinterface hasNext : ()Z
    //   54: ifeq -> 82
    //   57: aload_1
    //   58: invokeinterface next : ()Ljava/lang/Object;
    //   63: checkcast com/amap/api/fence/GeoFence
    //   66: astore_3
    //   67: aload_3
    //   68: iconst_0
    //   69: invokevirtual setStatus : (I)V
    //   72: aload_3
    //   73: ldc2_w -1
    //   76: invokevirtual setEnterTime : (J)V
    //   79: goto -> 48
    //   82: aload_0
    //   83: invokevirtual d : ()V
    //   86: aload_0
    //   87: iload_2
    //   88: putfield f : I
    //   91: return
    //   92: astore_1
    //   93: aload_1
    //   94: ldc 'GeoFenceManager'
    //   96: ldc_w 'doSetActivatesAction'
    //   99: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   102: return
    // Exception table:
    //   from	to	target	type
    //   6	15	92	finally
    //   15	48	92	finally
    //   48	79	92	finally
    //   82	86	92	finally
    //   86	91	92	finally
  }
  
  public final void a(GeoFenceListener paramGeoFenceListener) {
    try {
      return;
    } finally {
      paramGeoFenceListener = null;
    } 
  }
  
  final void a(AMapLocation paramAMapLocation) {
    try {
      return;
    } finally {
      paramAMapLocation = null;
      ej.a((Throwable)paramAMapLocation, "GeoFenceManager", "doCheckFence");
    } 
  }
  
  public final void a(DPoint paramDPoint, float paramFloat, String paramString) {
    try {
      k();
      Bundle bundle = new Bundle();
      bundle.putParcelable("centerPoint", (Parcelable)paramDPoint);
      bundle.putFloat("fenceRadius", paramFloat);
      return;
    } finally {
      paramDPoint = null;
      ej.a((Throwable)paramDPoint, "GeoFenceManager", "addRoundGeoFence");
    } 
  }
  
  public final void a(String paramString1, String paramString2) {
    try {
      k();
      Bundle bundle = new Bundle();
      bundle.putString("keyWords", paramString1);
      return;
    } finally {
      paramString1 = null;
      ej.a((Throwable)paramString1, "GeoFenceManager", "addDistricetGeoFence");
    } 
  }
  
  public final void a(String paramString1, String paramString2, DPoint paramDPoint, float paramFloat, int paramInt, String paramString3) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial k : ()V
    //   4: fload #4
    //   6: fconst_0
    //   7: fcmpg
    //   8: ifle -> 112
    //   11: fload #4
    //   13: fstore #7
    //   15: fload #4
    //   17: ldc_w 50000.0
    //   20: fcmpl
    //   21: ifle -> 117
    //   24: goto -> 112
    //   27: new android/os/Bundle
    //   30: dup
    //   31: invokespecial <init> : ()V
    //   34: astore #9
    //   36: aload #9
    //   38: ldc_w 'keyWords'
    //   41: aload_1
    //   42: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload #9
    //   47: ldc_w 'poiType'
    //   50: aload_2
    //   51: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload #9
    //   56: ldc_w 'centerPoint'
    //   59: aload_3
    //   60: invokevirtual putParcelable : (Ljava/lang/String;Landroid/os/Parcelable;)V
    //   63: aload #9
    //   65: ldc_w 'aroundRadius'
    //   68: fload #7
    //   70: invokevirtual putFloat : (Ljava/lang/String;F)V
    //   73: aload #9
    //   75: ldc_w 'searchSize'
    //   78: iload #5
    //   80: invokevirtual putInt : (Ljava/lang/String;I)V
    //   83: aload #9
    //   85: ldc 'customId'
    //   87: aload #6
    //   89: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_0
    //   93: iconst_3
    //   94: aload #9
    //   96: lconst_0
    //   97: invokevirtual a : (ILandroid/os/Bundle;J)V
    //   100: return
    //   101: astore_1
    //   102: aload_1
    //   103: ldc 'GeoFenceManager'
    //   105: ldc_w 'addNearbyGeoFence'
    //   108: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   111: return
    //   112: ldc_w 3000.0
    //   115: fstore #7
    //   117: iload #5
    //   119: istore #8
    //   121: iload #5
    //   123: ifgt -> 130
    //   126: bipush #10
    //   128: istore #8
    //   130: iload #8
    //   132: istore #5
    //   134: iload #8
    //   136: bipush #25
    //   138: if_icmple -> 27
    //   141: bipush #25
    //   143: istore #5
    //   145: goto -> 27
    // Exception table:
    //   from	to	target	type
    //   0	4	101	finally
    //   27	100	101	finally
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4) {
    int i;
    try {
      k();
    } finally {
      paramString1 = null;
      ej.a((Throwable)paramString1, "GeoFenceManager", "addKeywordGeoFence");
    } 
    paramInt = i;
    if (i > 25)
      paramInt = 25; 
    Bundle bundle = new Bundle();
    bundle.putString("keyWords", paramString1);
    bundle.putString("poiType", paramString2);
    bundle.putString("city", paramString3);
    bundle.putInt("searchSize", paramInt);
    bundle.putString("customId", paramString4);
    a(2, bundle, 0L);
  }
  
  public final void a(String paramString, boolean paramBoolean) {
    try {
      k();
      Bundle bundle = new Bundle();
      bundle.putString("fid", paramString);
      return;
    } finally {
      paramString = null;
      ej.a((Throwable)paramString, "GeoFenceManager", "setGeoFenceAble");
    } 
  }
  
  public final void a(List<DPoint> paramList, String paramString) {
    try {
      k();
      Bundle bundle = new Bundle();
      bundle.putParcelableArrayList("pointList", new ArrayList<DPoint>(paramList));
      return;
    } finally {
      paramList = null;
      ej.a((Throwable)paramList, "GeoFenceManager", "addPolygonGeoFence");
    } 
  }
  
  public final boolean a(GeoFence paramGeoFence) {
    try {
    
    } finally {
      paramGeoFence = null;
      ej.a((Throwable)paramGeoFence, "GeoFenceManager", "removeGeoFence(GeoFence)");
    } 
    return false;
  }
  
  final int b(GeoFence paramGeoFence) {
    try {
      return 17;
    } finally {
      paramGeoFence = null;
      ej.a((Throwable)paramGeoFence, "GeoFenceManager", "addGeoFence2List");
      a("添加围栏失败", 8, paramGeoFence.getMessage(), new String[0]);
    } 
  }
  
  public final List<GeoFence> b() {
    try {
      return (ArrayList)this.g.clone();
    } finally {
      Exception exception = null;
    } 
  }
  
  final void b(int paramInt) {
    try {
    
    } finally {
      Exception exception = null;
      ej.a(exception, "GeoFenceManager", "removeActionHandlerMessage");
    } 
  }
  
  final void b(Bundle paramBundle) {
    b(2, paramBundle);
  }
  
  final void c() {
    try {
      if (!this.n)
        return; 
      if (this.g != null) {
        this.g.clear();
        this.g = null;
      } 
      boolean bool = this.o;
      if (bool)
        return; 
      try {
      
      } finally {
        Exception exception = null;
      } 
      if (this.r != null) {
        this.r.stopLocation();
        this.r.onDestroy();
      } 
      this.r = null;
      if (this.l != null)
        if (Build.VERSION.SDK_INT >= 18) {
          this.l.quitSafely();
        } else {
          this.l.quit();
        }  
      this.l = null;
      this.p = null;
      synchronized (this.z) {
        if (this.c != null)
          this.c.cancel(); 
        this.c = null;
        try {
        
        } finally {
          null = null;
        } 
        if (this.a != null)
          this.a.b(this.b); 
      } 
    } finally {
      Exception exception;
    } 
    this.m = false;
    this.n = false;
  }
  
  final void c(int paramInt) {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "GeoFenceManager", "resultRemindLocationError");
    } 
  }
  
  final void c(Bundle paramBundle) {
    b(1, paramBundle);
  }
  
  final void c(GeoFence paramGeoFence) {
    try {
    
    } finally {
      paramGeoFence = null;
      ej.a((Throwable)paramGeoFence, "GeoFenceManager", "resultTriggerGeoFence");
    } 
  }
  
  final void d() {
    if (this.y)
      return; 
    if (this.k != null) {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.s != null) {
        bool1 = bool2;
        if (ep.a(this.s)) {
          bool1 = bool2;
          if (ep.b() - this.t < 10000L)
            bool1 = true; 
        } 
      } 
      if (bool1) {
        a(6, (Bundle)null, 0L);
        a(5, (Bundle)null, 0L);
        return;
      } 
      b(7);
      a(7, (Bundle)null, 0L);
    } 
  }
  
  final void d(Bundle paramBundle) {
    b(3, paramBundle);
  }
  
  final void e() {
    try {
      if (this.m)
        b(8); 
      if (this.r != null)
        this.r.stopLocation(); 
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  final void e(Bundle paramBundle) {
    if (paramBundle != null)
      try {
        if (paramBundle.isEmpty())
          return; 
        String str = paramBundle.getString("fid");
        if (TextUtils.isEmpty(str))
          return; 
        boolean bool = true;
        boolean bool1 = paramBundle.getBoolean("ab", true);
        if (this.g != null && !this.g.isEmpty())
          for (GeoFence geoFence : this.g) {
            if (geoFence.getFenceId().equals(str)) {
              geoFence.setAble(bool1);
              break;
            } 
          }  
        return;
      } finally {
        paramBundle = null;
      }  
  }
  
  final void f() {
    float f;
    try {
      if (this.y)
        return; 
      if (!ep.a(this.s))
        return; 
      AMapLocation aMapLocation = this.s;
    } finally {
      Exception exception = null;
      ej.a(exception, "GeoFenceManager", "doCheckLocationPolicy");
    } 
    if (f == Float.MAX_VALUE)
      return; 
    if (f < 1000.0F) {
      b(7);
      Bundle bundle = new Bundle();
      bundle.putLong("interval", 2000L);
      a(8, bundle, 500L);
      return;
    } 
    if (f < 5000.0F) {
      e();
      b(7);
      a(7, (Bundle)null, 10000L);
      return;
    } 
    e();
    b(7);
    a(7, (Bundle)null, (long)((f - 4000.0F) / 100.0F * 1000.0F));
  }
  
  final void f(Bundle paramBundle) {
    try {
      return;
    } finally {
      paramBundle = null;
    } 
  }
  
  public final void g() {
    try {
      k();
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "GeoFenceManager", "pauseGeoFence");
    } 
  }
  
  final void h() {
    try {
      b(7);
      b(8);
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "GeoFenceManager", "doPauseGeoFence");
    } 
  }
  
  public final void i() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "GeoFenceManager", "resumeGeoFence");
    } 
  }
  
  public final boolean j() {
    return this.y;
  }
  
  final class a extends Handler {
    public a(a this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    public final void handleMessage(Message param1Message) {
      int j;
      a a1;
      ArrayList<GeoFence> arrayList;
      try {
        int k = param1Message.what;
        boolean bool = true;
        j = 1;
      } finally {
        param1Message = null;
      } 
      String str = "";
      int i = j;
      Bundle bundle = new Bundle();
      bundle.putString("customId", str);
      bundle.putInt("errorCode", i);
      bundle.putParcelableArrayList("resultList", arrayList);
      a1.a(1000, bundle);
    }
  }
  
  static final class b extends HandlerThread {
    public b(String param1String) {
      super(param1String);
    }
    
    public final void run() {
      try {
        return;
      } finally {
        Exception exception = null;
      } 
    }
  }
  
  final class c extends Handler {
    public c(a this$0) {}
    
    public c(a this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    public final void handleMessage(Message param1Message) {
      try {
        Bundle bundle = param1Message.getData();
        int i = param1Message.what;
        switch (i) {
          default:
            return;
          case 1002:
            try {
              return;
            } finally {
              param1Message = null;
              param1Message.printStackTrace();
            } 
          case 1001:
            try {
              return;
            } finally {
              param1Message = null;
              param1Message.printStackTrace();
            } 
          case 1000:
            break;
        } 
        a a1 = this.a;
        return;
      } finally {
        param1Message = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */