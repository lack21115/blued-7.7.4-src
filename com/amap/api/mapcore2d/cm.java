package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Log;
import com.amap.api.maps2d.MapsInitializer;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class cm {
  public static double[] a = new double[] { 
      7453.642D, 3742.9905D, 1873.333D, 936.89026D, 468.472D, 234.239D, 117.12D, 58.56D, 29.28D, 14.64D, 
      7.32D, 3.66D, 1.829D, 0.915D, 0.4575D, 0.228D, 0.1144D };
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6) {
    return (paramDouble3 - paramDouble1) * (paramDouble6 - paramDouble2) - (paramDouble5 - paramDouble1) * (paramDouble4 - paramDouble2);
  }
  
  public static double a(LatLng paramLatLng1, LatLng paramLatLng2) {
    double d4 = paramLatLng1.longitude;
    double d3 = paramLatLng1.latitude;
    double d2 = paramLatLng2.longitude;
    double d1 = paramLatLng2.latitude;
    double d5 = d4 * 0.01745329251994329D;
    double d6 = d3 * 0.01745329251994329D;
    d3 = d2 * 0.01745329251994329D;
    d4 = d1 * 0.01745329251994329D;
    d1 = Math.sin(d5);
    d2 = Math.sin(d6);
    d5 = Math.cos(d5);
    d6 = Math.cos(d6);
    double d7 = Math.sin(d3);
    double d8 = Math.sin(d4);
    d3 = Math.cos(d3);
    d4 = Math.cos(d4);
    double[] arrayOfDouble1 = new double[3];
    double[] arrayOfDouble2 = new double[3];
    arrayOfDouble1[0] = d5 * d6;
    arrayOfDouble1[1] = d6 * d1;
    arrayOfDouble1[2] = d2;
    arrayOfDouble2[0] = d3 * d4;
    arrayOfDouble2[1] = d4 * d7;
    arrayOfDouble2[2] = d8;
    return Math.asin(Math.sqrt((arrayOfDouble1[0] - arrayOfDouble2[0]) * (arrayOfDouble1[0] - arrayOfDouble2[0]) + (arrayOfDouble1[1] - arrayOfDouble2[1]) * (arrayOfDouble1[1] - arrayOfDouble2[1]) + (arrayOfDouble1[2] - arrayOfDouble2[2]) * (arrayOfDouble1[2] - arrayOfDouble2[2])) / 2.0D) * 1.27420015798544E7D;
  }
  
  public static float a(float paramFloat) {
    if (paramFloat < 0.0F)
      return 0.0F; 
    float f = paramFloat;
    if (paramFloat > 45.0F)
      f = 45.0F; 
    return f;
  }
  
  public static int a(Object[] paramArrayOfObject) {
    return Arrays.hashCode(paramArrayOfObject);
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat) {
    if (paramBitmap == null)
      return null; 
    try {
      return Bitmap.createScaledBitmap(paramBitmap, (int)(paramBitmap.getWidth() * paramFloat), (int)(paramBitmap.getHeight() * paramFloat), true);
    } finally {
      paramBitmap = null;
      a((Throwable)paramBitmap, "Util", "zoomBitmap");
    } 
  }
  
  public static Bitmap a(String paramString) {
    try {
      if (ar.a != null) {
        inputStream = ar.a.getAssets().open(paramString);
        return bitmap1;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("/assets/");
      stringBuilder.append((String)inputStream);
      InputStream inputStream = BitmapDescriptorFactory.class.getResourceAsStream(stringBuilder.toString());
      return bitmap;
    } finally {
      paramString = null;
      a((Throwable)paramString, "Util", "fromAsset");
    } 
  }
  
  public static da a() {
    try {
      return (q.p == null) ? (new da.a("2dmap", "6.0.0", "AMAP_SDK_Android_2DMap_6.0.0")).a(new String[] { "com.amap.api.maps2d", "com.amap.api.mapcore2d" }).a("6.0.0").a() : q.p;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static w a(LatLng paramLatLng) {
    return (paramLatLng == null) ? null : new w((int)(paramLatLng.latitude * 1000000.0D), (int)(paramLatLng.longitude * 1000000.0D));
  }
  
  public static String a(int paramInt) {
    if (paramInt < 1000) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt);
      stringBuilder1.append("m");
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt / 1000);
    stringBuilder.append("km");
    return stringBuilder.toString();
  }
  
  public static String a(String paramString, Object paramObject) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("=");
    stringBuilder.append(String.valueOf(paramObject));
    return stringBuilder.toString();
  }
  
  public static String a(String... paramVarArgs) {
    StringBuilder stringBuilder = new StringBuilder();
    int k = paramVarArgs.length;
    int i = 0;
    int j = 0;
    while (i < k) {
      stringBuilder.append(paramVarArgs[i]);
      if (j != paramVarArgs.length - 1)
        stringBuilder.append(","); 
      j++;
      i++;
    } 
    return stringBuilder.toString();
  }
  
  public static void a(Throwable paramThrowable, String paramString1, String paramString2) {
    try {
      do do = do.e();
      return;
    } finally {
      paramThrowable = null;
    } 
  }
  
  public static boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8) {
    paramDouble3 -= paramDouble1;
    paramDouble8 -= paramDouble6;
    paramDouble4 -= paramDouble2;
    double d = paramDouble7 - paramDouble5;
    paramDouble7 = paramDouble3 * paramDouble8 - paramDouble4 * d;
    if (paramDouble7 != 0.0D) {
      paramDouble2 -= paramDouble6;
      paramDouble1 -= paramDouble5;
      paramDouble5 = (d * paramDouble2 - paramDouble8 * paramDouble1) / paramDouble7;
      paramDouble1 = (paramDouble2 * paramDouble3 - paramDouble1 * paramDouble4) / paramDouble7;
      if (paramDouble5 >= 0.0D && paramDouble5 <= 1.0D && paramDouble1 >= 0.0D && paramDouble1 <= 1.0D)
        return true; 
    } 
    return false;
  }
  
  public static boolean a(int paramInt1, int paramInt2) {
    if (paramInt1 > 0 && paramInt2 > 0)
      return true; 
    Log.w("2dmap", "the map must have a size");
    return false;
  }
  
  public static boolean a(Context paramContext) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/amap/api/mapcore2d/cm}} */
    if (paramContext == null) {
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/amap/api/mapcore2d/cm}} */
      return false;
    } 
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager == null) {
        /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/amap/api/mapcore2d/cm}} */
        return false;
      } 
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo == null) {
        /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/amap/api/mapcore2d/cm}} */
        return false;
      } 
      NetworkInfo.State state = networkInfo.getState();
      if (state != null && state != NetworkInfo.State.DISCONNECTED) {
        NetworkInfo.State state1 = NetworkInfo.State.DISCONNECTING;
        if (state == state1) {
          /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/amap/api/mapcore2d/cm}} */
          return false;
        } 
      } else {
        /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/amap/api/mapcore2d/cm}} */
        return false;
      } 
    } finally {}
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/amap/api/mapcore2d/cm}} */
    return true;
  }
  
  public static boolean a(LatLng paramLatLng, List<LatLng> paramList) {
    // Byte code:
    //   0: aload_1
    //   1: astore #19
    //   3: aload_0
    //   4: getfield longitude : D
    //   7: dstore #6
    //   9: aload_0
    //   10: getfield latitude : D
    //   13: dstore_2
    //   14: aload_0
    //   15: getfield latitude : D
    //   18: dstore #4
    //   20: aload_1
    //   21: invokeinterface size : ()I
    //   26: iconst_3
    //   27: if_icmpge -> 32
    //   30: iconst_0
    //   31: ireturn
    //   32: aload #19
    //   34: iconst_0
    //   35: invokeinterface get : (I)Ljava/lang/Object;
    //   40: checkcast com/amap/api/maps2d/model/LatLng
    //   43: aload #19
    //   45: aload_1
    //   46: invokeinterface size : ()I
    //   51: iconst_1
    //   52: isub
    //   53: invokeinterface get : (I)Ljava/lang/Object;
    //   58: invokevirtual equals : (Ljava/lang/Object;)Z
    //   61: ifne -> 80
    //   64: aload #19
    //   66: aload #19
    //   68: iconst_0
    //   69: invokeinterface get : (I)Ljava/lang/Object;
    //   74: invokeinterface add : (Ljava/lang/Object;)Z
    //   79: pop
    //   80: iconst_0
    //   81: istore #18
    //   83: iconst_0
    //   84: istore #16
    //   86: aload_1
    //   87: astore_0
    //   88: iload #18
    //   90: aload_1
    //   91: invokeinterface size : ()I
    //   96: iconst_1
    //   97: isub
    //   98: if_icmpge -> 323
    //   101: aload_0
    //   102: iload #18
    //   104: invokeinterface get : (I)Ljava/lang/Object;
    //   109: checkcast com/amap/api/maps2d/model/LatLng
    //   112: getfield longitude : D
    //   115: dstore #8
    //   117: aload_0
    //   118: iload #18
    //   120: invokeinterface get : (I)Ljava/lang/Object;
    //   125: checkcast com/amap/api/maps2d/model/LatLng
    //   128: getfield latitude : D
    //   131: dstore #10
    //   133: iload #18
    //   135: iconst_1
    //   136: iadd
    //   137: istore #18
    //   139: aload_0
    //   140: iload #18
    //   142: invokeinterface get : (I)Ljava/lang/Object;
    //   147: checkcast com/amap/api/maps2d/model/LatLng
    //   150: getfield longitude : D
    //   153: dstore #12
    //   155: aload_0
    //   156: iload #18
    //   158: invokeinterface get : (I)Ljava/lang/Object;
    //   163: checkcast com/amap/api/maps2d/model/LatLng
    //   166: getfield latitude : D
    //   169: dstore #14
    //   171: dload #6
    //   173: dload_2
    //   174: dload #8
    //   176: dload #10
    //   178: dload #12
    //   180: dload #14
    //   182: invokestatic b : (DDDDDD)Z
    //   185: ifeq -> 190
    //   188: iconst_1
    //   189: ireturn
    //   190: dload #14
    //   192: dload #10
    //   194: dsub
    //   195: invokestatic abs : (D)D
    //   198: ldc2_w 1.0E-9
    //   201: dcmpg
    //   202: ifge -> 212
    //   205: iload #16
    //   207: istore #17
    //   209: goto -> 248
    //   212: dload #8
    //   214: dload #10
    //   216: dload #6
    //   218: dload_2
    //   219: ldc2_w 180.0
    //   222: dload #4
    //   224: invokestatic b : (DDDDDD)Z
    //   227: ifeq -> 251
    //   230: iload #16
    //   232: istore #17
    //   234: dload #10
    //   236: dload #14
    //   238: dcmpl
    //   239: ifle -> 248
    //   242: iload #16
    //   244: iconst_1
    //   245: iadd
    //   246: istore #17
    //   248: goto -> 316
    //   251: dload #12
    //   253: dload #14
    //   255: dload #6
    //   257: dload_2
    //   258: ldc2_w 180.0
    //   261: dload #4
    //   263: invokestatic b : (DDDDDD)Z
    //   266: ifeq -> 284
    //   269: iload #16
    //   271: istore #17
    //   273: dload #14
    //   275: dload #10
    //   277: dcmpl
    //   278: ifle -> 248
    //   281: goto -> 242
    //   284: iload #16
    //   286: istore #17
    //   288: dload #8
    //   290: dload #10
    //   292: dload #12
    //   294: dload #14
    //   296: dload #6
    //   298: dload_2
    //   299: ldc2_w 180.0
    //   302: dload #4
    //   304: invokestatic a : (DDDDDDDD)Z
    //   307: ifeq -> 316
    //   310: iload #16
    //   312: iconst_1
    //   313: iadd
    //   314: istore #17
    //   316: iload #17
    //   318: istore #16
    //   320: goto -> 86
    //   323: iload #16
    //   325: iconst_2
    //   326: irem
    //   327: ifeq -> 332
    //   330: iconst_1
    //   331: ireturn
    //   332: iconst_0
    //   333: ireturn
  }
  
  public static boolean a(File paramFile) throws IOException, Exception {
    if (paramFile != null) {
      if (!paramFile.exists())
        return false; 
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
        for (int i = 0; i < arrayOfFile.length; i++) {
          if (arrayOfFile[i].isFile()) {
            if (!arrayOfFile[i].delete())
              return false; 
          } else {
            if (!a(arrayOfFile[i]))
              return false; 
            arrayOfFile[i].delete();
          } 
        }  
      return true;
    } 
    return false;
  }
  
  public static float b(float paramFloat) {
    if (paramFloat > q.c) {
      int i = q.c;
      return i;
    } 
    if (paramFloat < q.d) {
      int i = q.d;
      return i;
    } 
    return paramFloat;
  }
  
  public static String b(Context paramContext) {
    if (!Environment.getExternalStorageState().equals("mounted"))
      return paramContext.getFilesDir().getPath(); 
    if (MapsInitializer.sdcardDir == null || MapsInitializer.sdcardDir.equals("")) {
      File file1 = new File(Environment.getExternalStorageDirectory(), "AMap");
      if (!file1.exists())
        file1.mkdir(); 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(file1.toString());
      stringBuilder1.append("/");
      return stringBuilder1.toString();
    } 
    File file = new File(MapsInitializer.sdcardDir);
    if (!file.exists())
      file.mkdirs(); 
    file = new File(file, "Amap");
    if (!file.exists())
      file.mkdir(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(file.toString());
    stringBuilder.append("/");
    return stringBuilder.toString();
  }
  
  public static boolean b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6) {
    return (Math.abs(a(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6)) < 1.0E-9D && (paramDouble1 - paramDouble3) * (paramDouble1 - paramDouble5) <= 0.0D && (paramDouble2 - paramDouble4) * (paramDouble2 - paramDouble6) <= 0.0D);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */