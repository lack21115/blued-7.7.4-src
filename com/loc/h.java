package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import org.json.JSONObject;

public final class h {
  Object a = new Object();
  
  AMapLocationClientOption b = null;
  
  a c = null;
  
  private Context d;
  
  private AMapLocationClient e = null;
  
  private WebView f = null;
  
  private String g = "AMap.Geolocation.cbk";
  
  private volatile boolean h = false;
  
  public h(Context paramContext, WebView paramWebView) {
    this.d = paramContext.getApplicationContext();
    this.f = paramWebView;
    this.c = new a(this);
  }
  
  private static String b(AMapLocation paramAMapLocation) {
    JSONObject jSONObject = new JSONObject();
    String str = "errorInfo";
    if (paramAMapLocation == null) {
      try {
        jSONObject.put("errorCode", -1);
        String str2 = "unknownError";
        String str1 = str;
        jSONObject.put(str1, str2);
      } finally {}
    } else if (paramAMapLocation.getErrorCode() == 0) {
      jSONObject.put("errorCode", 0);
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("x", paramAMapLocation.getLongitude());
      jSONObject1.put("y", paramAMapLocation.getLatitude());
      jSONObject1.put("precision", paramAMapLocation.getAccuracy());
      jSONObject1.put("type", paramAMapLocation.getLocationType());
      jSONObject1.put("country", paramAMapLocation.getCountry());
      jSONObject1.put("province", paramAMapLocation.getProvince());
      jSONObject1.put("city", paramAMapLocation.getCity());
      jSONObject1.put("cityCode", paramAMapLocation.getCityCode());
      jSONObject1.put("district", paramAMapLocation.getDistrict());
      jSONObject1.put("adCode", paramAMapLocation.getAdCode());
      jSONObject1.put("street", paramAMapLocation.getStreet());
      jSONObject1.put("streetNum", paramAMapLocation.getStreetNum());
      jSONObject1.put("floor", paramAMapLocation.getFloor());
      jSONObject1.put("address", paramAMapLocation.getAddress());
      jSONObject.put("result", jSONObject1);
    } else {
      jSONObject.put("errorCode", paramAMapLocation.getErrorCode());
      jSONObject.put("errorInfo", paramAMapLocation.getErrorInfo());
      String str2 = "locationDetail";
      str = paramAMapLocation.getLocationDetail();
      String str1 = str2;
      str2 = str;
      jSONObject.put(str1, str2);
    } 
    return jSONObject.toString();
  }
  
  public final void a() {
    if (this.f != null) {
      if (this.d == null)
        return; 
      if (Build.VERSION.SDK_INT < 17)
        return; 
      if (this.h)
        return; 
      try {
        this.f.getSettings().setJavaScriptEnabled(true);
        this.f.addJavascriptInterface(this, "AMapAndroidLoc");
        if (!TextUtils.isEmpty(this.f.getUrl()))
          this.f.reload(); 
        if (this.e == null) {
          this.e = new AMapLocationClient(this.d);
          this.e.setLocationListener(this.c);
        } 
        return;
      } finally {
        Exception exception = null;
      } 
    } 
  }
  
  public final void b() {
    synchronized (this.a) {
      this.h = false;
      if (this.e != null) {
        this.e.unRegisterLocationListener(this.c);
        this.e.stopLocation();
        this.e.onDestroy();
        this.e = null;
      } 
      this.b = null;
      return;
    } 
  }
  
  @JavascriptInterface
  public final void getLocation(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Ljava/lang/Object;
    //   4: astore #12
    //   6: aload #12
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield h : Z
    //   13: ifne -> 20
    //   16: aload #12
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield b : Lcom/amap/api/location/AMapLocationClientOption;
    //   24: ifnonnull -> 38
    //   27: aload_0
    //   28: new com/amap/api/location/AMapLocationClientOption
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: putfield b : Lcom/amap/api/location/AMapLocationClientOption;
    //   38: iconst_5
    //   39: istore #4
    //   41: ldc2_w 30000
    //   44: lstore #8
    //   46: iconst_1
    //   47: istore #10
    //   49: lload #8
    //   51: lstore #6
    //   53: new org/json/JSONObject
    //   56: dup
    //   57: aload_1
    //   58: invokespecial <init> : (Ljava/lang/String;)V
    //   61: astore_1
    //   62: lload #8
    //   64: lstore #6
    //   66: aload_1
    //   67: ldc_w 'to'
    //   70: ldc2_w 30000
    //   73: invokevirtual optLong : (Ljava/lang/String;J)J
    //   76: lstore #8
    //   78: lload #8
    //   80: lstore #6
    //   82: aload_1
    //   83: ldc_w 'useGPS'
    //   86: iconst_1
    //   87: invokevirtual optInt : (Ljava/lang/String;I)I
    //   90: istore_2
    //   91: iload_2
    //   92: iconst_1
    //   93: if_icmpne -> 101
    //   96: iconst_1
    //   97: istore_2
    //   98: goto -> 103
    //   101: iconst_0
    //   102: istore_2
    //   103: aload_1
    //   104: ldc_w 'watch'
    //   107: iconst_0
    //   108: invokevirtual optInt : (Ljava/lang/String;I)I
    //   111: istore_3
    //   112: iload_3
    //   113: iconst_1
    //   114: if_icmpne -> 122
    //   117: iconst_1
    //   118: istore_3
    //   119: goto -> 124
    //   122: iconst_0
    //   123: istore_3
    //   124: aload_1
    //   125: ldc_w 'interval'
    //   128: iconst_5
    //   129: invokevirtual optInt : (Ljava/lang/String;I)I
    //   132: istore #5
    //   134: iload #5
    //   136: istore #4
    //   138: aload_1
    //   139: ldc_w 'callback'
    //   142: aconst_null
    //   143: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   146: astore_1
    //   147: iload #5
    //   149: istore #4
    //   151: aload_1
    //   152: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   155: ifne -> 178
    //   158: iload #5
    //   160: istore #4
    //   162: aload_0
    //   163: aload_1
    //   164: putfield g : Ljava/lang/String;
    //   167: iload #5
    //   169: istore #4
    //   171: lload #8
    //   173: lstore #6
    //   175: goto -> 188
    //   178: ldc 'AMap.Geolocation.cbk'
    //   180: astore_1
    //   181: goto -> 158
    //   184: iconst_0
    //   185: istore_2
    //   186: iconst_0
    //   187: istore_3
    //   188: aload_0
    //   189: getfield b : Lcom/amap/api/location/AMapLocationClientOption;
    //   192: lload #6
    //   194: invokevirtual setHttpTimeOut : (J)Lcom/amap/api/location/AMapLocationClientOption;
    //   197: pop
    //   198: iload_2
    //   199: ifeq -> 222
    //   202: aload_0
    //   203: getfield b : Lcom/amap/api/location/AMapLocationClientOption;
    //   206: astore #11
    //   208: getstatic com/amap/api/location/AMapLocationClientOption$AMapLocationMode.Hight_Accuracy : Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;
    //   211: astore_1
    //   212: aload #11
    //   214: aload_1
    //   215: invokevirtual setLocationMode : (Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;)Lcom/amap/api/location/AMapLocationClientOption;
    //   218: pop
    //   219: goto -> 235
    //   222: aload_0
    //   223: getfield b : Lcom/amap/api/location/AMapLocationClientOption;
    //   226: astore #11
    //   228: getstatic com/amap/api/location/AMapLocationClientOption$AMapLocationMode.Battery_Saving : Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;
    //   231: astore_1
    //   232: goto -> 212
    //   235: aload_0
    //   236: getfield b : Lcom/amap/api/location/AMapLocationClientOption;
    //   239: astore_1
    //   240: iload_3
    //   241: ifne -> 339
    //   244: goto -> 247
    //   247: aload_1
    //   248: iload #10
    //   250: invokevirtual setOnceLocation : (Z)Lcom/amap/api/location/AMapLocationClientOption;
    //   253: pop
    //   254: iload_3
    //   255: ifeq -> 273
    //   258: aload_0
    //   259: getfield b : Lcom/amap/api/location/AMapLocationClientOption;
    //   262: iload #4
    //   264: sipush #1000
    //   267: imul
    //   268: i2l
    //   269: invokevirtual setInterval : (J)Lcom/amap/api/location/AMapLocationClientOption;
    //   272: pop
    //   273: aload_0
    //   274: getfield e : Lcom/amap/api/location/AMapLocationClient;
    //   277: ifnull -> 305
    //   280: aload_0
    //   281: getfield e : Lcom/amap/api/location/AMapLocationClient;
    //   284: aload_0
    //   285: getfield b : Lcom/amap/api/location/AMapLocationClientOption;
    //   288: invokevirtual setLocationOption : (Lcom/amap/api/location/AMapLocationClientOption;)V
    //   291: aload_0
    //   292: getfield e : Lcom/amap/api/location/AMapLocationClient;
    //   295: invokevirtual stopLocation : ()V
    //   298: aload_0
    //   299: getfield e : Lcom/amap/api/location/AMapLocationClient;
    //   302: invokevirtual startLocation : ()V
    //   305: aload #12
    //   307: monitorexit
    //   308: return
    //   309: astore_1
    //   310: aload #12
    //   312: monitorexit
    //   313: aload_1
    //   314: athrow
    //   315: astore_1
    //   316: goto -> 184
    //   319: astore_1
    //   320: lload #8
    //   322: lstore #6
    //   324: goto -> 186
    //   327: astore_1
    //   328: lload #8
    //   330: lstore #6
    //   332: goto -> 188
    //   335: astore_1
    //   336: goto -> 273
    //   339: iconst_0
    //   340: istore #10
    //   342: goto -> 247
    // Exception table:
    //   from	to	target	type
    //   9	19	309	finally
    //   20	38	309	finally
    //   53	62	315	finally
    //   66	78	315	finally
    //   82	91	315	finally
    //   103	112	319	finally
    //   124	134	327	finally
    //   138	147	327	finally
    //   151	158	327	finally
    //   162	167	327	finally
    //   188	198	335	finally
    //   202	212	335	finally
    //   212	219	335	finally
    //   222	232	335	finally
    //   235	240	335	finally
    //   247	254	335	finally
    //   258	273	335	finally
    //   273	305	309	finally
    //   305	308	309	finally
    //   310	313	309	finally
  }
  
  @JavascriptInterface
  public final void stopLocation() {
    if (!this.h)
      return; 
    AMapLocationClient aMapLocationClient = this.e;
    if (aMapLocationClient != null)
      aMapLocationClient.stopLocation(); 
  }
  
  final class a implements AMapLocationListener {
    a(h this$0) {}
    
    public final void onLocationChanged(AMapLocation param1AMapLocation) {
      if (h.c(this.a))
        h.a(this.a, h.a(param1AMapLocation)); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */