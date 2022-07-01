package com.amap.api.mapcore2d;

import android.text.TextUtils;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;
import org.json.JSONObject;

public final class gg extends Inner_3dMap_location {
  boolean a = true;
  
  private String b = null;
  
  private String c = "";
  
  private int d;
  
  private String e = "";
  
  private String f = "new";
  
  private JSONObject g = null;
  
  private String h = "";
  
  private String i = "";
  
  private long j = 0L;
  
  private String k = null;
  
  public gg(String paramString) {
    super(paramString);
  }
  
  public final String a() {
    return this.b;
  }
  
  public final void a(String paramString) {
    this.b = paramString;
  }
  
  public final String b() {
    return this.c;
  }
  
  public final void b(String paramString) {
    this.c = paramString;
  }
  
  public final int c() {
    return this.d;
  }
  
  public final void c(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifne -> 57
    //   7: aload_0
    //   8: invokevirtual getProvider : ()Ljava/lang/String;
    //   11: ldc 'gps'
    //   13: invokevirtual equals : (Ljava/lang/Object;)Z
    //   16: ifeq -> 25
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield d : I
    //   24: return
    //   25: aload_1
    //   26: ldc '0'
    //   28: invokevirtual equals : (Ljava/lang/Object;)Z
    //   31: ifeq -> 40
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield d : I
    //   39: return
    //   40: aload_1
    //   41: ldc '1'
    //   43: invokevirtual equals : (Ljava/lang/Object;)Z
    //   46: ifeq -> 57
    //   49: iconst_1
    //   50: istore_2
    //   51: aload_0
    //   52: iload_2
    //   53: putfield d : I
    //   56: return
    //   57: iconst_m1
    //   58: istore_2
    //   59: goto -> 51
  }
  
  public final String d() {
    return this.e;
  }
  
  public final void d(String paramString) {
    this.e = paramString;
  }
  
  public final JSONObject e() {
    return this.g;
  }
  
  public final void e(String paramString) {
    this.desc = paramString;
  }
  
  public final void setFloor(String paramString) {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.replace("F", "");
      try {
        Integer.parseInt(str);
      } finally {
        paramString = null;
        gu.a((Throwable)paramString, "MapLocationModel", "setFloor");
      } 
    } 
    this.floor = str;
  }
  
  public final JSONObject toJson(int paramInt) {
    try {
      JSONObject jSONObject = super.toJson(paramInt);
      if (paramInt != 1) {
        if (paramInt != 2 && paramInt != 3)
          return jSONObject; 
      } else {
        jSONObject.put("retype", this.e);
        jSONObject.put("cens", this.i);
        jSONObject.put("poiid", this.buildingId);
        jSONObject.put("floor", this.floor);
        jSONObject.put("coord", this.d);
        jSONObject.put("mcell", this.h);
        jSONObject.put("desc", this.desc);
        jSONObject.put("address", getAddress());
        if (this.g != null && gy.a(jSONObject, "offpct"))
          jSONObject.put("offpct", this.g.getString("offpct")); 
      } 
      return jSONObject;
    } finally {
      Exception exception = null;
      gu.a(exception, "MapLocationModel", "toStr");
    } 
  }
  
  public final String toStr(int paramInt) {
    Exception exception;
    try {
      JSONObject jSONObject = super.toJson(paramInt);
      jSONObject.put("nb", this.k);
    } finally {
      exception = null;
      gu.a(exception, "MapLocationModel", "toStr part2");
    } 
    return (exception == null) ? null : exception.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */