package com.loc;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import org.json.JSONObject;

public final class ds extends AMapLocation {
  protected String d = "";
  
  boolean e = true;
  
  String f = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
  
  private String g = null;
  
  private String h = "";
  
  private int i;
  
  private String j = "";
  
  private String k = "new";
  
  private JSONObject l = null;
  
  private String m = "";
  
  private String n = "";
  
  private String o = null;
  
  public ds(String paramString) {
    super(paramString);
  }
  
  public final String a() {
    return this.g;
  }
  
  public final void a(String paramString) {
    this.g = paramString;
  }
  
  public final void a(JSONObject paramJSONObject) {
    this.l = paramJSONObject;
  }
  
  public final void a(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public final String b() {
    return this.h;
  }
  
  public final void b(String paramString) {
    this.h = paramString;
  }
  
  public final void b(JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic a : (Lcom/amap/api/location/AMapLocation;Lorg/json/JSONObject;)V
    //   5: aload_0
    //   6: aload_1
    //   7: ldc 'type'
    //   9: aload_0
    //   10: getfield k : Ljava/lang/String;
    //   13: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   16: putfield k : Ljava/lang/String;
    //   19: aload_0
    //   20: aload_1
    //   21: ldc 'retype'
    //   23: aload_0
    //   24: getfield j : Ljava/lang/String;
    //   27: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: putfield j : Ljava/lang/String;
    //   33: aload_1
    //   34: ldc 'cens'
    //   36: aload_0
    //   37: getfield n : Ljava/lang/String;
    //   40: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   43: astore #4
    //   45: aload #4
    //   47: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   50: ifne -> 139
    //   53: aload #4
    //   55: ldc '\*'
    //   57: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   60: astore #5
    //   62: aload #5
    //   64: arraylength
    //   65: istore_3
    //   66: iconst_0
    //   67: istore_2
    //   68: iload_2
    //   69: iload_3
    //   70: if_icmpge -> 133
    //   73: aload #5
    //   75: iload_2
    //   76: aaload
    //   77: astore #6
    //   79: aload #6
    //   81: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   84: ifne -> 299
    //   87: aload #6
    //   89: ldc ','
    //   91: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   94: astore #5
    //   96: aload_0
    //   97: aload #5
    //   99: iconst_0
    //   100: aaload
    //   101: invokestatic e : (Ljava/lang/String;)D
    //   104: invokevirtual setLongitude : (D)V
    //   107: aload_0
    //   108: aload #5
    //   110: iconst_1
    //   111: aaload
    //   112: invokestatic e : (Ljava/lang/String;)D
    //   115: invokevirtual setLatitude : (D)V
    //   118: aload_0
    //   119: aload #5
    //   121: iconst_2
    //   122: aaload
    //   123: invokestatic g : (Ljava/lang/String;)I
    //   126: i2f
    //   127: invokevirtual setAccuracy : (F)V
    //   130: goto -> 133
    //   133: aload_0
    //   134: aload #4
    //   136: putfield n : Ljava/lang/String;
    //   139: aload_0
    //   140: aload_1
    //   141: ldc 'desc'
    //   143: aload_0
    //   144: getfield d : Ljava/lang/String;
    //   147: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   150: putfield d : Ljava/lang/String;
    //   153: aload_0
    //   154: aload_1
    //   155: ldc 'coord'
    //   157: aload_0
    //   158: getfield i : I
    //   161: invokestatic valueOf : (I)Ljava/lang/String;
    //   164: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   167: invokevirtual c : (Ljava/lang/String;)V
    //   170: aload_0
    //   171: aload_1
    //   172: ldc 'mcell'
    //   174: aload_0
    //   175: getfield m : Ljava/lang/String;
    //   178: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   181: putfield m : Ljava/lang/String;
    //   184: aload_0
    //   185: aload_1
    //   186: ldc 'isReversegeo'
    //   188: aload_0
    //   189: getfield e : Z
    //   192: invokevirtual optBoolean : (Ljava/lang/String;Z)Z
    //   195: putfield e : Z
    //   198: aload_0
    //   199: aload_1
    //   200: ldc 'geoLanguage'
    //   202: aload_0
    //   203: getfield f : Ljava/lang/String;
    //   206: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   209: putfield f : Ljava/lang/String;
    //   212: aload_1
    //   213: ldc 'poiid'
    //   215: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   218: ifeq -> 231
    //   221: aload_0
    //   222: aload_1
    //   223: ldc 'poiid'
    //   225: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   228: invokevirtual setBuildingId : (Ljava/lang/String;)V
    //   231: aload_1
    //   232: ldc 'pid'
    //   234: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   237: ifeq -> 250
    //   240: aload_0
    //   241: aload_1
    //   242: ldc 'pid'
    //   244: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   247: invokevirtual setBuildingId : (Ljava/lang/String;)V
    //   250: aload_1
    //   251: ldc 'floor'
    //   253: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   256: ifeq -> 269
    //   259: aload_0
    //   260: aload_1
    //   261: ldc 'floor'
    //   263: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   266: invokevirtual setFloor : (Ljava/lang/String;)V
    //   269: aload_1
    //   270: ldc 'flr'
    //   272: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   275: ifeq -> 288
    //   278: aload_0
    //   279: aload_1
    //   280: ldc 'flr'
    //   282: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   285: invokevirtual setFloor : (Ljava/lang/String;)V
    //   288: return
    //   289: astore_1
    //   290: aload_1
    //   291: ldc 'AmapLoc'
    //   293: ldc 'AmapLoc'
    //   295: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   298: return
    //   299: iload_2
    //   300: iconst_1
    //   301: iadd
    //   302: istore_2
    //   303: goto -> 68
    // Exception table:
    //   from	to	target	type
    //   0	66	289	finally
    //   79	130	289	finally
    //   133	139	289	finally
    //   139	231	289	finally
    //   231	250	289	finally
    //   250	269	289	finally
    //   269	288	289	finally
  }
  
  public final int c() {
    return this.i;
  }
  
  public final void c(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifne -> 35
    //   7: aload_1
    //   8: ldc '0'
    //   10: invokevirtual equals : (Ljava/lang/Object;)Z
    //   13: ifeq -> 21
    //   16: iconst_0
    //   17: istore_2
    //   18: goto -> 37
    //   21: aload_1
    //   22: ldc '1'
    //   24: invokevirtual equals : (Ljava/lang/Object;)Z
    //   27: ifeq -> 35
    //   30: iconst_1
    //   31: istore_2
    //   32: goto -> 37
    //   35: iconst_m1
    //   36: istore_2
    //   37: aload_0
    //   38: iload_2
    //   39: putfield i : I
    //   42: aload_0
    //   43: getfield i : I
    //   46: ifne -> 58
    //   49: ldc 'WGS84'
    //   51: astore_1
    //   52: aload_0
    //   53: aload_1
    //   54: invokespecial setCoordType : (Ljava/lang/String;)V
    //   57: return
    //   58: ldc 'GCJ02'
    //   60: astore_1
    //   61: goto -> 52
  }
  
  public final String d() {
    return this.j;
  }
  
  public final void d(String paramString) {
    this.j = paramString;
  }
  
  public final String e() {
    return this.k;
  }
  
  public final void e(String paramString) {
    this.k = paramString;
  }
  
  public final JSONObject f() {
    return this.l;
  }
  
  public final void f(String paramString) {
    this.f = paramString;
  }
  
  public final String g() {
    return this.m;
  }
  
  public final void g(String paramString) {
    this.d = paramString;
  }
  
  public final ds h() {
    String str = this.m;
    if (TextUtils.isEmpty(str))
      return null; 
    String[] arrayOfString = str.split(",");
    if (arrayOfString.length != 3)
      return null; 
    ds ds1 = new ds("");
    ds1.setProvider(getProvider());
    ds1.setLongitude(ep.e(arrayOfString[0]));
    ds1.setLatitude(ep.e(arrayOfString[1]));
    ds1.setAccuracy(ep.f(arrayOfString[2]));
    ds1.setCityCode(getCityCode());
    ds1.setAdCode(getAdCode());
    ds1.setCountry(getCountry());
    ds1.setProvince(getProvince());
    ds1.setCity(getCity());
    ds1.setTime(getTime());
    ds1.k = this.k;
    ds1.c(String.valueOf(this.i));
    return !ep.a(ds1) ? null : ds1;
  }
  
  public final void h(String paramString) {
    this.o = paramString;
  }
  
  public final boolean i() {
    return this.e;
  }
  
  public final String j() {
    return this.f;
  }
  
  public final String k() {
    return this.o;
  }
  
  public final JSONObject toJson(int paramInt) {
    try {
      JSONObject jSONObject = super.toJson(paramInt);
      if (paramInt != 1) {
        if (paramInt != 2 && paramInt != 3)
          return jSONObject; 
      } else {
        jSONObject.put("retype", this.j);
        jSONObject.put("cens", this.n);
        jSONObject.put("coord", this.i);
        jSONObject.put("mcell", this.m);
        jSONObject.put("desc", this.d);
        jSONObject.put("address", getAddress());
        if (this.l != null && ep.a(jSONObject, "offpct"))
          jSONObject.put("offpct", this.l.getString("offpct")); 
      } 
      jSONObject.put("type", this.k);
      return jSONObject;
    } finally {
      Exception exception = null;
      ej.a(exception, "AmapLoc", "toStr");
    } 
  }
  
  public final String toStr() {
    return toStr(1);
  }
  
  public final String toStr(int paramInt) {
    Exception exception;
    try {
      JSONObject jSONObject = toJson(paramInt);
      jSONObject.put("nb", this.o);
    } finally {
      exception = null;
      ej.a(exception, "AMapLocation", "toStr part2");
    } 
    return (exception == null) ? null : exception.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */