package com.amap.api.location;

import android.content.Context;
import com.loc.ej;
import com.loc.ep;

public class CoordinateConverter {
  private static int b = 0;
  
  private static int c = 1;
  
  private static int d = 2;
  
  private static int e = 4;
  
  private static int f = 8;
  
  private static int g = 16;
  
  private static int h = 32;
  
  private static int i = 64;
  
  DPoint a = null;
  
  private Context j;
  
  private CoordType k = null;
  
  private DPoint l = null;
  
  public CoordinateConverter(Context paramContext) {
    this.j = paramContext;
  }
  
  public static float calculateLineDistance(DPoint paramDPoint1, DPoint paramDPoint2) {
    try {
      return ep.a(paramDPoint1, paramDPoint2);
    } finally {
      paramDPoint1 = null;
    } 
  }
  
  public static boolean isAMapDataAvailable(double paramDouble1, double paramDouble2) {
    return ej.a(paramDouble1, paramDouble2);
  }
  
  public DPoint convert() throws Exception {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield k : Lcom/amap/api/location/CoordinateConverter$CoordType;
    //   6: ifnull -> 552
    //   9: aload_0
    //   10: getfield l : Lcom/amap/api/location/DPoint;
    //   13: ifnull -> 542
    //   16: aload_0
    //   17: getfield l : Lcom/amap/api/location/DPoint;
    //   20: invokevirtual getLongitude : ()D
    //   23: ldc2_w 180.0
    //   26: dcmpl
    //   27: ifgt -> 532
    //   30: aload_0
    //   31: getfield l : Lcom/amap/api/location/DPoint;
    //   34: invokevirtual getLongitude : ()D
    //   37: ldc2_w -180.0
    //   40: dcmpg
    //   41: iflt -> 532
    //   44: aload_0
    //   45: getfield l : Lcom/amap/api/location/DPoint;
    //   48: invokevirtual getLatitude : ()D
    //   51: ldc2_w 90.0
    //   54: dcmpl
    //   55: ifgt -> 522
    //   58: aload_0
    //   59: getfield l : Lcom/amap/api/location/DPoint;
    //   62: invokevirtual getLatitude : ()D
    //   65: ldc2_w -90.0
    //   68: dcmpg
    //   69: iflt -> 522
    //   72: iconst_0
    //   73: istore_2
    //   74: iconst_0
    //   75: istore_3
    //   76: iconst_0
    //   77: istore #4
    //   79: iconst_0
    //   80: istore #5
    //   82: iconst_0
    //   83: istore #6
    //   85: iconst_0
    //   86: istore_1
    //   87: aconst_null
    //   88: astore #8
    //   90: aconst_null
    //   91: astore #9
    //   93: aconst_null
    //   94: astore #10
    //   96: aconst_null
    //   97: astore #11
    //   99: aconst_null
    //   100: astore #12
    //   102: aconst_null
    //   103: astore #7
    //   105: getstatic com/amap/api/location/CoordinateConverter$1.a : [I
    //   108: aload_0
    //   109: getfield k : Lcom/amap/api/location/CoordinateConverter$CoordType;
    //   112: invokevirtual ordinal : ()I
    //   115: iaload
    //   116: tableswitch default -> 569, 1 -> 421, 2 -> 374, 3 -> 332, 4 -> 290, 5 -> 249, 6 -> 208, 7 -> 160
    //   160: getstatic com/amap/api/location/CoordinateConverter.b : I
    //   163: getstatic com/amap/api/location/CoordinateConverter.i : I
    //   166: iand
    //   167: ifne -> 186
    //   170: ldc 'gps'
    //   172: astore #7
    //   174: getstatic com/amap/api/location/CoordinateConverter.b : I
    //   177: getstatic com/amap/api/location/CoordinateConverter.i : I
    //   180: ior
    //   181: putstatic com/amap/api/location/CoordinateConverter.b : I
    //   184: iconst_1
    //   185: istore_1
    //   186: aload_0
    //   187: getfield j : Landroid/content/Context;
    //   190: aload_0
    //   191: getfield l : Lcom/amap/api/location/DPoint;
    //   194: invokestatic a : (Landroid/content/Context;Lcom/amap/api/location/DPoint;)Lcom/amap/api/location/DPoint;
    //   197: astore #8
    //   199: aload_0
    //   200: aload #8
    //   202: putfield a : Lcom/amap/api/location/DPoint;
    //   205: goto -> 469
    //   208: iload_2
    //   209: istore_1
    //   210: aload #8
    //   212: astore #7
    //   214: getstatic com/amap/api/location/CoordinateConverter.b : I
    //   217: getstatic com/amap/api/location/CoordinateConverter.h : I
    //   220: iand
    //   221: ifne -> 240
    //   224: ldc 'google'
    //   226: astore #7
    //   228: getstatic com/amap/api/location/CoordinateConverter.b : I
    //   231: getstatic com/amap/api/location/CoordinateConverter.h : I
    //   234: ior
    //   235: putstatic com/amap/api/location/CoordinateConverter.b : I
    //   238: iconst_1
    //   239: istore_1
    //   240: aload_0
    //   241: getfield l : Lcom/amap/api/location/DPoint;
    //   244: astore #8
    //   246: goto -> 199
    //   249: iload_3
    //   250: istore_1
    //   251: aload #9
    //   253: astore #7
    //   255: getstatic com/amap/api/location/CoordinateConverter.b : I
    //   258: getstatic com/amap/api/location/CoordinateConverter.g : I
    //   261: iand
    //   262: ifne -> 281
    //   265: ldc 'aliyun'
    //   267: astore #7
    //   269: getstatic com/amap/api/location/CoordinateConverter.b : I
    //   272: getstatic com/amap/api/location/CoordinateConverter.g : I
    //   275: ior
    //   276: putstatic com/amap/api/location/CoordinateConverter.b : I
    //   279: iconst_1
    //   280: istore_1
    //   281: aload_0
    //   282: getfield l : Lcom/amap/api/location/DPoint;
    //   285: astore #8
    //   287: goto -> 199
    //   290: iload #4
    //   292: istore_1
    //   293: aload #10
    //   295: astore #7
    //   297: getstatic com/amap/api/location/CoordinateConverter.b : I
    //   300: getstatic com/amap/api/location/CoordinateConverter.f : I
    //   303: iand
    //   304: ifne -> 323
    //   307: ldc 'sosomap'
    //   309: astore #7
    //   311: getstatic com/amap/api/location/CoordinateConverter.b : I
    //   314: getstatic com/amap/api/location/CoordinateConverter.f : I
    //   317: ior
    //   318: putstatic com/amap/api/location/CoordinateConverter.b : I
    //   321: iconst_1
    //   322: istore_1
    //   323: aload_0
    //   324: getfield l : Lcom/amap/api/location/DPoint;
    //   327: astore #8
    //   329: goto -> 199
    //   332: iload #5
    //   334: istore_1
    //   335: aload #11
    //   337: astore #7
    //   339: getstatic com/amap/api/location/CoordinateConverter.b : I
    //   342: getstatic com/amap/api/location/CoordinateConverter.e : I
    //   345: iand
    //   346: ifne -> 365
    //   349: ldc 'mapabc'
    //   351: astore #7
    //   353: getstatic com/amap/api/location/CoordinateConverter.b : I
    //   356: getstatic com/amap/api/location/CoordinateConverter.e : I
    //   359: ior
    //   360: putstatic com/amap/api/location/CoordinateConverter.b : I
    //   363: iconst_1
    //   364: istore_1
    //   365: aload_0
    //   366: getfield l : Lcom/amap/api/location/DPoint;
    //   369: astore #8
    //   371: goto -> 199
    //   374: aload_0
    //   375: aload_0
    //   376: getfield j : Landroid/content/Context;
    //   379: aload_0
    //   380: getfield l : Lcom/amap/api/location/DPoint;
    //   383: invokestatic b : (Landroid/content/Context;Lcom/amap/api/location/DPoint;)Lcom/amap/api/location/DPoint;
    //   386: putfield a : Lcom/amap/api/location/DPoint;
    //   389: iload #6
    //   391: istore_1
    //   392: aload #12
    //   394: astore #7
    //   396: getstatic com/amap/api/location/CoordinateConverter.b : I
    //   399: getstatic com/amap/api/location/CoordinateConverter.d : I
    //   402: iand
    //   403: ifne -> 469
    //   406: ldc 'mapbar'
    //   408: astore #7
    //   410: getstatic com/amap/api/location/CoordinateConverter.b : I
    //   413: istore_1
    //   414: getstatic com/amap/api/location/CoordinateConverter.d : I
    //   417: istore_2
    //   418: goto -> 461
    //   421: aload_0
    //   422: aload_0
    //   423: getfield l : Lcom/amap/api/location/DPoint;
    //   426: invokestatic a : (Lcom/amap/api/location/DPoint;)Lcom/amap/api/location/DPoint;
    //   429: putfield a : Lcom/amap/api/location/DPoint;
    //   432: iload #6
    //   434: istore_1
    //   435: aload #12
    //   437: astore #7
    //   439: getstatic com/amap/api/location/CoordinateConverter.b : I
    //   442: getstatic com/amap/api/location/CoordinateConverter.c : I
    //   445: iand
    //   446: ifne -> 469
    //   449: ldc 'baidu'
    //   451: astore #7
    //   453: getstatic com/amap/api/location/CoordinateConverter.b : I
    //   456: istore_1
    //   457: getstatic com/amap/api/location/CoordinateConverter.c : I
    //   460: istore_2
    //   461: iload_1
    //   462: iload_2
    //   463: ior
    //   464: putstatic com/amap/api/location/CoordinateConverter.b : I
    //   467: iconst_1
    //   468: istore_1
    //   469: iload_1
    //   470: ifeq -> 511
    //   473: new org/json/JSONObject
    //   476: dup
    //   477: invokespecial <init> : ()V
    //   480: astore #8
    //   482: aload #7
    //   484: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   487: ifne -> 500
    //   490: aload #8
    //   492: ldc 'amap_loc_coordinate'
    //   494: aload #7
    //   496: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   499: pop
    //   500: aload_0
    //   501: getfield j : Landroid/content/Context;
    //   504: ldc 'O021'
    //   506: aload #8
    //   508: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   511: aload_0
    //   512: getfield a : Lcom/amap/api/location/DPoint;
    //   515: astore #7
    //   517: aload_0
    //   518: monitorexit
    //   519: aload #7
    //   521: areturn
    //   522: new java/lang/IllegalArgumentException
    //   525: dup
    //   526: ldc '请传入合理纬度'
    //   528: invokespecial <init> : (Ljava/lang/String;)V
    //   531: athrow
    //   532: new java/lang/IllegalArgumentException
    //   535: dup
    //   536: ldc '请传入合理经度'
    //   538: invokespecial <init> : (Ljava/lang/String;)V
    //   541: athrow
    //   542: new java/lang/IllegalArgumentException
    //   545: dup
    //   546: ldc '转换坐标源不能为空'
    //   548: invokespecial <init> : (Ljava/lang/String;)V
    //   551: athrow
    //   552: new java/lang/IllegalArgumentException
    //   555: dup
    //   556: ldc '转换坐标类型不能为空'
    //   558: invokespecial <init> : (Ljava/lang/String;)V
    //   561: athrow
    //   562: astore #7
    //   564: aload_0
    //   565: monitorexit
    //   566: aload #7
    //   568: athrow
    //   569: iload #6
    //   571: istore_1
    //   572: aload #12
    //   574: astore #7
    //   576: goto -> 469
    // Exception table:
    //   from	to	target	type
    //   2	72	562	finally
    //   105	160	562	finally
    //   160	170	562	finally
    //   174	184	562	finally
    //   186	199	562	finally
    //   199	205	562	finally
    //   214	224	562	finally
    //   228	238	562	finally
    //   240	246	562	finally
    //   255	265	562	finally
    //   269	279	562	finally
    //   281	287	562	finally
    //   297	307	562	finally
    //   311	321	562	finally
    //   323	329	562	finally
    //   339	349	562	finally
    //   353	363	562	finally
    //   365	371	562	finally
    //   374	389	562	finally
    //   396	406	562	finally
    //   410	418	562	finally
    //   421	432	562	finally
    //   439	449	562	finally
    //   453	461	562	finally
    //   461	467	562	finally
    //   473	500	562	finally
    //   500	511	562	finally
    //   511	517	562	finally
    //   522	532	562	finally
    //   532	542	562	finally
    //   542	552	562	finally
    //   552	562	562	finally
  }
  
  public CoordinateConverter coord(DPoint paramDPoint) throws Exception {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 79
    //   6: aload_1
    //   7: invokevirtual getLongitude : ()D
    //   10: ldc2_w 180.0
    //   13: dcmpl
    //   14: ifgt -> 69
    //   17: aload_1
    //   18: invokevirtual getLongitude : ()D
    //   21: ldc2_w -180.0
    //   24: dcmpg
    //   25: iflt -> 69
    //   28: aload_1
    //   29: invokevirtual getLatitude : ()D
    //   32: ldc2_w 90.0
    //   35: dcmpl
    //   36: ifgt -> 59
    //   39: aload_1
    //   40: invokevirtual getLatitude : ()D
    //   43: ldc2_w -90.0
    //   46: dcmpg
    //   47: iflt -> 59
    //   50: aload_0
    //   51: aload_1
    //   52: putfield l : Lcom/amap/api/location/DPoint;
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_0
    //   58: areturn
    //   59: new java/lang/IllegalArgumentException
    //   62: dup
    //   63: ldc '请传入合理纬度'
    //   65: invokespecial <init> : (Ljava/lang/String;)V
    //   68: athrow
    //   69: new java/lang/IllegalArgumentException
    //   72: dup
    //   73: ldc '请传入合理经度'
    //   75: invokespecial <init> : (Ljava/lang/String;)V
    //   78: athrow
    //   79: new java/lang/IllegalArgumentException
    //   82: dup
    //   83: ldc '传入经纬度对象为空'
    //   85: invokespecial <init> : (Ljava/lang/String;)V
    //   88: athrow
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: goto -> 89
    // Exception table:
    //   from	to	target	type
    //   6	55	93	finally
    //   59	69	93	finally
    //   69	79	93	finally
    //   79	89	93	finally
  }
  
  public CoordinateConverter from(CoordType paramCoordType) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield k : Lcom/amap/api/location/CoordinateConverter$CoordType;
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_0
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public enum CoordType {
    ALIYUN, BAIDU, GOOGLE, GPS, MAPABC, MAPBAR, SOSOMAP;
    
    static {
      ALIYUN = new CoordType("ALIYUN", 4);
      GOOGLE = new CoordType("GOOGLE", 5);
      GPS = new CoordType("GPS", 6);
      a = new CoordType[] { BAIDU, MAPBAR, MAPABC, SOSOMAP, ALIYUN, GOOGLE, GPS };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\location\CoordinateConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */