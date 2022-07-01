package com.loc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public final class ej {
  static String a = "http://apilocate.amap.com/mobile/binary";
  
  static String b = "http://dualstack.apilocate.amap.com/mobile/binary";
  
  static String c = "";
  
  static String d;
  
  public static String e;
  
  public static String f;
  
  public static int g;
  
  public static String h;
  
  public static String i;
  
  static String j;
  
  static HashMap<String, String> k;
  
  static boolean l;
  
  static boolean m;
  
  private static final String[] n = new String[] { "com.amap.api.location", "com.loc", "com.amap.api.fence" };
  
  private static t o;
  
  private static boolean p;
  
  private static boolean q;
  
  static {
    d = "11G;11K;13J;13S;15O;15U;17J;17Y";
    e = null;
    f = null;
    g = 30000;
    h = null;
    i = null;
    o = null;
    p = false;
    q = false;
    l = false;
    m = false;
  }
  
  public static Bundle a(AMapLocationClientOption paramAMapLocationClientOption) {
    Bundle bundle = new Bundle();
    AMapLocationClientOption aMapLocationClientOption = paramAMapLocationClientOption;
    if (paramAMapLocationClientOption == null)
      aMapLocationClientOption = new AMapLocationClientOption(); 
    try {
      return bundle;
    } finally {
      paramAMapLocationClientOption = null;
      a((Throwable)paramAMapLocationClientOption, "CoreUtil", "getOptionBundle");
    } 
  }
  
  public static AMapLocation a(AMapLocation paramAMapLocation1, AMapLocation paramAMapLocation2) {
    if (paramAMapLocation2 == null)
      return paramAMapLocation1; 
    try {
      paramAMapLocation1.setCountry(paramAMapLocation2.getCountry());
      paramAMapLocation1.setRoad(paramAMapLocation2.getRoad());
      paramAMapLocation1.setPoiName(paramAMapLocation2.getPoiName());
      paramAMapLocation1.setStreet(paramAMapLocation2.getStreet());
      paramAMapLocation1.setNumber(paramAMapLocation2.getStreetNum());
      String str1 = paramAMapLocation2.getCityCode();
      String str2 = paramAMapLocation2.getAdCode();
      paramAMapLocation1.setCityCode(str1);
      paramAMapLocation1.setAdCode(str2);
      paramAMapLocation1.setCity(paramAMapLocation2.getCity());
      paramAMapLocation1.setDistrict(paramAMapLocation2.getDistrict());
      paramAMapLocation1.setProvince(paramAMapLocation2.getProvince());
      paramAMapLocation1.setAoiName(paramAMapLocation2.getAoiName());
      paramAMapLocation1.setAddress(paramAMapLocation2.getAddress());
      paramAMapLocation1.setDescription(paramAMapLocation2.getDescription());
      Bundle bundle = paramAMapLocation1.getExtras();
      if (bundle != null) {
        paramAMapLocation1.getExtras().putString("citycode", paramAMapLocation2.getCityCode());
        paramAMapLocation1.getExtras().putString("desc", paramAMapLocation2.getExtras().getString("desc"));
        return paramAMapLocation1;
      } 
      bundle = new Bundle();
      bundle.putString("citycode", paramAMapLocation2.getCityCode());
      bundle.putString("desc", paramAMapLocation2.getExtras().getString("desc"));
      bundle.putString("adcode", paramAMapLocation2.getAdCode());
      return paramAMapLocation1;
    } finally {
      paramAMapLocation2 = null;
    } 
  }
  
  public static AMapLocationClientOption a(Bundle paramBundle) {
    AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
    if (paramBundle == null)
      return aMapLocationClientOption; 
    try {
      return (AMapLocationClientOption)paramBundle.getParcelable("opt");
    } finally {
      paramBundle = null;
      a((Throwable)paramBundle, "CoreUtil", "getOptionFromBundle");
    } 
  }
  
  public static String a() {
    return a;
  }
  
  public static void a(Context paramContext) {
    try {
      if (u.b(paramContext))
        return; 
      try {
        if (k == null)
          k = new HashMap<String, String>(16); 
        k.clear();
        k.put("fe643c382e5c3b3962141f1a2e815a78", "FB923EE67A8B4032DAA517DD8CD7A26FF7C25B0C3663F92A0B61251C4FFFA858DF169D61321C3E7919CB67DF8EFEC827");
        k.put("9a571aa113ad987d626c0457828962e6", "D2FF99A88BEB04683D89470D4FA72B1749DA456AB0D0F1A476477CE5A6874F53A9106423D905F9D808C0FCE8E7F1E04AC642F01FE41D0C7D933971F45CBA72B7");
      } finally {
        Exception exception = null;
      } 
      String str = dy.a(k.f(paramContext));
      return;
    } finally {
      paramContext = null;
      a((Throwable)paramContext, "CoreUtil", "checkUrl");
    } 
  }
  
  public static void a(AMapLocation paramAMapLocation, JSONObject paramJSONObject) {
    if (paramJSONObject != null && paramAMapLocation != null)
      try {
        Bundle bundle;
        double d1 = paramJSONObject.optDouble("lat", paramAMapLocation.getLatitude());
        double d2 = paramJSONObject.optDouble("lon", paramAMapLocation.getLongitude());
        paramAMapLocation.setProvider(paramJSONObject.optString("provider", paramAMapLocation.getProvider()));
        paramAMapLocation.setLatitude(d1);
        paramAMapLocation.setLongitude(d2);
        paramAMapLocation.setAltitude(paramJSONObject.optDouble("altitude", paramAMapLocation.getAltitude()));
        try {
          String str1 = paramJSONObject.optString("accuracy");
          if (!TextUtils.isEmpty(str1))
            paramAMapLocation.setAccuracy(Float.parseFloat(str1)); 
        } finally {
          Exception exception;
        } 
        try {
          String str1 = paramJSONObject.optString("speed");
          if (!TextUtils.isEmpty(str1))
            paramAMapLocation.setSpeed(Float.parseFloat(str1)); 
        } finally {
          Exception exception;
        } 
        try {
          String str1 = paramJSONObject.optString("bearing");
          if (!TextUtils.isEmpty(str1))
            paramAMapLocation.setBearing(Float.parseFloat(str1)); 
        } finally {
          Exception exception;
        } 
        paramAMapLocation.setAdCode(paramJSONObject.optString("adcode", paramAMapLocation.getAdCode()));
        paramAMapLocation.setCityCode(paramJSONObject.optString("citycode", paramAMapLocation.getCityCode()));
        paramAMapLocation.setAddress(paramJSONObject.optString("address", paramAMapLocation.getAddress()));
        String str = paramJSONObject.optString("desc", "");
        paramAMapLocation.setCountry(paramJSONObject.optString("country", paramAMapLocation.getCountry()));
        paramAMapLocation.setProvince(paramJSONObject.optString("province", paramAMapLocation.getProvince()));
        paramAMapLocation.setCity(paramJSONObject.optString("city", paramAMapLocation.getCity()));
        paramAMapLocation.setDistrict(paramJSONObject.optString("district", paramAMapLocation.getDistrict()));
        paramAMapLocation.setRoad(paramJSONObject.optString("road", paramAMapLocation.getRoad()));
        paramAMapLocation.setStreet(paramJSONObject.optString("street", paramAMapLocation.getStreet()));
        paramAMapLocation.setNumber(paramJSONObject.optString("number", paramAMapLocation.getStreetNum()));
        paramAMapLocation.setPoiName(paramJSONObject.optString("poiname", paramAMapLocation.getPoiName()));
        paramAMapLocation.setAoiName(paramJSONObject.optString("aoiname", paramAMapLocation.getAoiName()));
        paramAMapLocation.setErrorCode(paramJSONObject.optInt("errorCode", paramAMapLocation.getErrorCode()));
        paramAMapLocation.setErrorInfo(paramJSONObject.optString("errorInfo", paramAMapLocation.getErrorInfo()));
        paramAMapLocation.setLocationType(paramJSONObject.optInt("locationType", paramAMapLocation.getLocationType()));
        paramAMapLocation.setLocationDetail(paramJSONObject.optString("locationDetail", paramAMapLocation.getLocationDetail()));
        paramAMapLocation.setTime(paramJSONObject.optLong("time", paramAMapLocation.getTime()));
        boolean bool1 = paramJSONObject.optBoolean("isOffset", paramAMapLocation.isOffset());
        paramAMapLocation.setOffset(bool1);
        paramAMapLocation.setBuildingId(paramJSONObject.optString("poiid", paramAMapLocation.getBuildingId()));
        paramAMapLocation.setFloor(paramJSONObject.optString("floor", paramAMapLocation.getFloor()));
        paramAMapLocation.setDescription(paramJSONObject.optString("description", paramAMapLocation.getDescription()));
        boolean bool2 = paramJSONObject.has("coordType");
        if (bool2) {
          String str1 = paramJSONObject.optString("coordType", "GCJ02");
        } else {
          if (a(d1, d2) && bool1) {
            paramAMapLocation.setCoordType("GCJ02");
          } else {
            String str1 = "WGS84";
            paramAMapLocation.setCoordType(str1);
          } 
          bundle = new Bundle();
          bundle.putString("citycode", paramAMapLocation.getCityCode());
          bundle.putString("desc", str.toString());
          bundle.putString("adcode", paramAMapLocation.getAdCode());
          return;
        } 
      } finally {
        paramAMapLocation = null;
      }  
  }
  
  public static void a(Throwable paramThrowable, String paramString1, String paramString2) {
    if ("reportError".equals(paramString2))
      return; 
    if (paramThrowable instanceof j)
      return; 
    try {
      return;
    } finally {
      paramThrowable = null;
    } 
  }
  
  public static boolean a(double paramDouble1, double paramDouble2) {
    int i = (int)((paramDouble2 - 73.0D) / 0.5D);
    int j = (int)((paramDouble1 - 3.5D) / 0.5D);
    if (j >= 0 && j < 101 && i >= 0) {
      if (i >= 124)
        return false; 
      try {
        return (i == 49);
      } finally {
        Exception exception = null;
        a(exception, "CoreUtil", "isChina");
      } 
    } 
    return false;
  }
  
  private static boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6) {
    return (Math.abs((paramDouble3 - paramDouble1) * (paramDouble6 - paramDouble2) - (paramDouble5 - paramDouble1) * (paramDouble4 - paramDouble2)) < 1.0E-9D && (paramDouble1 - paramDouble3) * (paramDouble1 - paramDouble5) <= 0.0D && (paramDouble2 - paramDouble4) * (paramDouble2 - paramDouble6) <= 0.0D);
  }
  
  public static boolean a(DPoint paramDPoint, List<DPoint> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getLongitude : ()D
    //   4: dstore_2
    //   5: aload_0
    //   6: invokevirtual getLatitude : ()D
    //   9: dstore #4
    //   11: aload_0
    //   12: invokevirtual getLatitude : ()D
    //   15: dstore #6
    //   17: aload_1
    //   18: iconst_0
    //   19: invokeinterface get : (I)Ljava/lang/Object;
    //   24: checkcast com/amap/api/location/DPoint
    //   27: aload_1
    //   28: aload_1
    //   29: invokeinterface size : ()I
    //   34: iconst_1
    //   35: isub
    //   36: invokeinterface get : (I)Ljava/lang/Object;
    //   41: invokevirtual equals : (Ljava/lang/Object;)Z
    //   44: ifne -> 61
    //   47: aload_1
    //   48: aload_1
    //   49: iconst_0
    //   50: invokeinterface get : (I)Ljava/lang/Object;
    //   55: invokeinterface add : (Ljava/lang/Object;)Z
    //   60: pop
    //   61: iconst_0
    //   62: istore #24
    //   64: iconst_0
    //   65: istore #22
    //   67: iload #24
    //   69: aload_1
    //   70: invokeinterface size : ()I
    //   75: iconst_1
    //   76: isub
    //   77: if_icmpge -> 410
    //   80: aload_1
    //   81: iload #24
    //   83: invokeinterface get : (I)Ljava/lang/Object;
    //   88: checkcast com/amap/api/location/DPoint
    //   91: invokevirtual getLongitude : ()D
    //   94: dstore #10
    //   96: aload_1
    //   97: iload #24
    //   99: invokeinterface get : (I)Ljava/lang/Object;
    //   104: checkcast com/amap/api/location/DPoint
    //   107: invokevirtual getLatitude : ()D
    //   110: dstore #16
    //   112: iload #24
    //   114: iconst_1
    //   115: iadd
    //   116: istore #25
    //   118: aload_1
    //   119: iload #25
    //   121: invokeinterface get : (I)Ljava/lang/Object;
    //   126: checkcast com/amap/api/location/DPoint
    //   129: invokevirtual getLongitude : ()D
    //   132: dstore #12
    //   134: aload_1
    //   135: iload #25
    //   137: invokeinterface get : (I)Ljava/lang/Object;
    //   142: checkcast com/amap/api/location/DPoint
    //   145: invokevirtual getLatitude : ()D
    //   148: dstore #14
    //   150: dload_2
    //   151: dload #4
    //   153: dload #10
    //   155: dload #16
    //   157: dload #12
    //   159: dload #14
    //   161: invokestatic a : (DDDDDD)Z
    //   164: ifeq -> 169
    //   167: iconst_1
    //   168: ireturn
    //   169: dload #14
    //   171: dload #16
    //   173: dsub
    //   174: dstore #8
    //   176: iload #22
    //   178: istore #23
    //   180: dload #8
    //   182: invokestatic abs : (D)D
    //   185: ldc2_w 1.0E-9
    //   188: dcmpg
    //   189: iflt -> 399
    //   192: dload #10
    //   194: dload #16
    //   196: dload_2
    //   197: dload #4
    //   199: ldc2_w 180.0
    //   202: dload #6
    //   204: invokestatic a : (DDDDDD)Z
    //   207: ifeq -> 231
    //   210: iload #22
    //   212: istore #23
    //   214: dload #16
    //   216: dload #14
    //   218: dcmpl
    //   219: ifle -> 399
    //   222: iload #22
    //   224: iconst_1
    //   225: iadd
    //   226: istore #23
    //   228: goto -> 399
    //   231: dload #12
    //   233: dload #14
    //   235: dload_2
    //   236: dload #4
    //   238: ldc2_w 180.0
    //   241: dload #6
    //   243: invokestatic a : (DDDDDD)Z
    //   246: ifeq -> 264
    //   249: iload #22
    //   251: istore #23
    //   253: dload #14
    //   255: dload #16
    //   257: dcmpl
    //   258: ifle -> 399
    //   261: goto -> 222
    //   264: dload #12
    //   266: dload #10
    //   268: dsub
    //   269: dstore #12
    //   271: dload #6
    //   273: dload #4
    //   275: dsub
    //   276: dstore #18
    //   278: ldc2_w 180.0
    //   281: dload_2
    //   282: dsub
    //   283: dstore #20
    //   285: dload #12
    //   287: dload #18
    //   289: dmul
    //   290: dload #8
    //   292: dload #20
    //   294: dmul
    //   295: dsub
    //   296: dstore #14
    //   298: dload #14
    //   300: dconst_0
    //   301: dcmpl
    //   302: ifeq -> 384
    //   305: dload #16
    //   307: dload #4
    //   309: dsub
    //   310: dstore #16
    //   312: dload #10
    //   314: dload_2
    //   315: dsub
    //   316: dstore #10
    //   318: dload #20
    //   320: dload #16
    //   322: dmul
    //   323: dload #18
    //   325: dload #10
    //   327: dmul
    //   328: dsub
    //   329: dload #14
    //   331: ddiv
    //   332: dstore #18
    //   334: dload #16
    //   336: dload #12
    //   338: dmul
    //   339: dload #10
    //   341: dload #8
    //   343: dmul
    //   344: dsub
    //   345: dload #14
    //   347: ddiv
    //   348: dstore #8
    //   350: dload #18
    //   352: dconst_0
    //   353: dcmpl
    //   354: iflt -> 384
    //   357: dload #18
    //   359: dconst_1
    //   360: dcmpg
    //   361: ifgt -> 384
    //   364: dload #8
    //   366: dconst_0
    //   367: dcmpl
    //   368: iflt -> 384
    //   371: dload #8
    //   373: dconst_1
    //   374: dcmpg
    //   375: ifgt -> 384
    //   378: iconst_1
    //   379: istore #24
    //   381: goto -> 387
    //   384: iconst_0
    //   385: istore #24
    //   387: iload #22
    //   389: istore #23
    //   391: iload #24
    //   393: ifeq -> 399
    //   396: goto -> 222
    //   399: iload #25
    //   401: istore #24
    //   403: iload #23
    //   405: istore #22
    //   407: goto -> 67
    //   410: iconst_0
    //   411: istore #26
    //   413: iload #22
    //   415: iconst_2
    //   416: irem
    //   417: ifeq -> 423
    //   420: iconst_1
    //   421: istore #26
    //   423: iload #26
    //   425: ireturn
  }
  
  private static byte[] a(String paramString) {
    int i = 0;
    if (paramString == null || paramString.length() < 2)
      return new byte[0]; 
    paramString = paramString.toLowerCase(Locale.US);
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    while (i < j) {
      int k = i * 2;
      arrayOfByte[i] = (byte)(ep.h(paramString.substring(k, k + 2)) & 0xFF);
      i++;
    } 
    return arrayOfByte;
  }
  
  public static String b() {
    return b;
  }
  
  public static String b(Context paramContext) {
    return r.a(k.e(paramContext));
  }
  
  public static t c() {
    try {
      if (o == null)
        o = (new t.a("loc", "5.2.0", "AMAP_Location_SDK_Android 5.2.0")).a((String[])n.clone()).a("5.2.0").a(); 
    } finally {
      Exception exception = null;
    } 
  }
  
  public static void c(Context paramContext) {
    try {
      if (u.b(paramContext))
        return; 
      return;
    } finally {
      paramContext = null;
      a((Throwable)paramContext, "CoreUtil", "changeUrl");
    } 
  }
  
  public static String d() {
    return d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */