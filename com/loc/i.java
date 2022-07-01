package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;

public final class i {
  static ea b;
  
  static ae e;
  
  static long g;
  
  String a = null;
  
  ea c = null;
  
  ea d = null;
  
  long f = 0L;
  
  boolean h = false;
  
  private Context i;
  
  public i(Context paramContext) {
    this.i = paramContext.getApplicationContext();
  }
  
  private void e() {
    if (b == null || ep.b() - g > 180000L) {
      ea ea1 = f();
      g = ep.b();
      if (ea1 != null && ep.a(ea1.a()))
        b = ea1; 
    } 
  }
  
  private ea f() {
    // Byte code:
    //   0: aload_0
    //   1: getfield i : Landroid/content/Context;
    //   4: astore_1
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore #5
    //   10: aload_1
    //   11: ifnonnull -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: invokevirtual a : ()V
    //   20: getstatic com/loc/i.e : Lcom/loc/ae;
    //   23: ifnonnull -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: getstatic com/loc/i.e : Lcom/loc/ae;
    //   31: ldc '_id=1'
    //   33: ldc com/loc/ea
    //   35: invokevirtual a : (Ljava/lang/String;Ljava/lang/Class;)Ljava/util/List;
    //   38: astore_1
    //   39: aload_1
    //   40: invokeinterface size : ()I
    //   45: ifle -> 305
    //   48: aload_1
    //   49: iconst_0
    //   50: invokeinterface get : (I)Ljava/lang/Object;
    //   55: checkcast com/loc/ea
    //   58: astore_3
    //   59: aload_3
    //   60: astore_2
    //   61: aload_3
    //   62: invokevirtual c : ()Ljava/lang/String;
    //   65: invokestatic b : (Ljava/lang/String;)[B
    //   68: astore_1
    //   69: aload_1
    //   70: ifnull -> 300
    //   73: aload_3
    //   74: astore_2
    //   75: aload_1
    //   76: arraylength
    //   77: ifle -> 300
    //   80: aload_3
    //   81: astore_2
    //   82: aload_1
    //   83: aload_0
    //   84: getfield a : Ljava/lang/String;
    //   87: invokestatic b : ([BLjava/lang/String;)[B
    //   90: astore_1
    //   91: aload_1
    //   92: ifnull -> 300
    //   95: aload_3
    //   96: astore_2
    //   97: aload_1
    //   98: arraylength
    //   99: ifle -> 300
    //   102: aload_3
    //   103: astore_2
    //   104: new java/lang/String
    //   107: dup
    //   108: aload_1
    //   109: ldc 'UTF-8'
    //   111: invokespecial <init> : ([BLjava/lang/String;)V
    //   114: astore_1
    //   115: goto -> 118
    //   118: aload_3
    //   119: astore_2
    //   120: aload_3
    //   121: invokevirtual b : ()Ljava/lang/String;
    //   124: invokestatic b : (Ljava/lang/String;)[B
    //   127: astore #6
    //   129: aload #5
    //   131: astore #4
    //   133: aload #6
    //   135: ifnull -> 199
    //   138: aload #5
    //   140: astore #4
    //   142: aload_3
    //   143: astore_2
    //   144: aload #6
    //   146: arraylength
    //   147: ifle -> 199
    //   150: aload_3
    //   151: astore_2
    //   152: aload #6
    //   154: aload_0
    //   155: getfield a : Ljava/lang/String;
    //   158: invokestatic b : ([BLjava/lang/String;)[B
    //   161: astore #6
    //   163: aload #5
    //   165: astore #4
    //   167: aload #6
    //   169: ifnull -> 199
    //   172: aload #5
    //   174: astore #4
    //   176: aload_3
    //   177: astore_2
    //   178: aload #6
    //   180: arraylength
    //   181: ifle -> 199
    //   184: aload_3
    //   185: astore_2
    //   186: new java/lang/String
    //   189: dup
    //   190: aload #6
    //   192: ldc 'UTF-8'
    //   194: invokespecial <init> : ([BLjava/lang/String;)V
    //   197: astore #4
    //   199: aload_3
    //   200: astore_2
    //   201: aload_3
    //   202: aload #4
    //   204: invokevirtual a : (Ljava/lang/String;)V
    //   207: aload_1
    //   208: astore_2
    //   209: aload_3
    //   210: astore_1
    //   211: aload_2
    //   212: astore_3
    //   213: goto -> 216
    //   216: aload_1
    //   217: astore_2
    //   218: aload_1
    //   219: astore #4
    //   221: aload_3
    //   222: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   225: ifne -> 297
    //   228: aload_1
    //   229: astore_2
    //   230: new com/amap/api/location/AMapLocation
    //   233: dup
    //   234: ldc ''
    //   236: invokespecial <init> : (Ljava/lang/String;)V
    //   239: astore #5
    //   241: aload_1
    //   242: astore_2
    //   243: aload #5
    //   245: new org/json/JSONObject
    //   248: dup
    //   249: aload_3
    //   250: invokespecial <init> : (Ljava/lang/String;)V
    //   253: invokestatic a : (Lcom/amap/api/location/AMapLocation;Lorg/json/JSONObject;)V
    //   256: aload_1
    //   257: astore_2
    //   258: aload_1
    //   259: astore #4
    //   261: aload #5
    //   263: invokestatic b : (Lcom/amap/api/location/AMapLocation;)Z
    //   266: ifeq -> 297
    //   269: aload_1
    //   270: astore_2
    //   271: aload_1
    //   272: aload #5
    //   274: invokevirtual a : (Lcom/amap/api/location/AMapLocation;)V
    //   277: aload_1
    //   278: areturn
    //   279: astore_1
    //   280: goto -> 286
    //   283: astore_1
    //   284: aconst_null
    //   285: astore_2
    //   286: aload_1
    //   287: ldc 'LastLocationManager'
    //   289: ldc 'readLastFix'
    //   291: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload_2
    //   295: astore #4
    //   297: aload #4
    //   299: areturn
    //   300: aconst_null
    //   301: astore_1
    //   302: goto -> 118
    //   305: aconst_null
    //   306: astore_1
    //   307: goto -> 216
    // Exception table:
    //   from	to	target	type
    //   20	26	283	finally
    //   28	59	283	finally
    //   61	69	279	finally
    //   75	80	279	finally
    //   82	91	279	finally
    //   97	102	279	finally
    //   104	115	279	finally
    //   120	129	279	finally
    //   144	150	279	finally
    //   152	163	279	finally
    //   178	184	279	finally
    //   186	199	279	finally
    //   201	207	279	finally
    //   221	228	279	finally
    //   230	241	279	finally
    //   243	256	279	finally
    //   261	269	279	finally
    //   271	277	279	finally
  }
  
  public final AMapLocation a(AMapLocation paramAMapLocation, String paramString, long paramLong) {
    if (paramAMapLocation == null)
      return paramAMapLocation; 
    AMapLocation aMapLocation = paramAMapLocation;
    if (paramAMapLocation.getErrorCode() != 0) {
      aMapLocation = paramAMapLocation;
      if (paramAMapLocation.getLocationType() != 1) {
        if (paramAMapLocation.getErrorCode() == 7)
          return paramAMapLocation; 
        try {
          e();
          if (b != null) {
            boolean bool;
            if (b.a() == null)
              return paramAMapLocation; 
            boolean bool1 = false;
            if (TextUtils.isEmpty(paramString)) {
              long l = ep.b() - b.d();
              bool = bool1;
              if (l >= 0L) {
                bool = bool1;
                if (l <= paramLong)
                  bool = true; 
              } 
              paramAMapLocation.setTrustedLevel(3);
            } else {
              bool = ep.a(b.b(), paramString);
              paramAMapLocation.setTrustedLevel(2);
            } 
            aMapLocation = paramAMapLocation;
            if (bool) {
              aMapLocation = b.a();
              try {
                aMapLocation.setLocationType(9);
                aMapLocation.setFixLastLocation(true);
                return aMapLocation;
              } finally {
                paramString = null;
              } 
            } else {
              return aMapLocation;
            } 
          } else {
            return paramAMapLocation;
          } 
        } finally {}
        ej.a((Throwable)paramString, "LastLocationManager", "fixLastLocation");
        aMapLocation = paramAMapLocation;
      } 
    } 
    return aMapLocation;
  }
  
  public final void a() {
    if (this.h)
      return; 
    try {
      if (this.a == null)
        this.a = dy.a("MD5", n.x(this.i)); 
    } finally {
      Exception exception = null;
    } 
    this.h = true;
  }
  
  public final boolean a(AMapLocation paramAMapLocation, String paramString) {
    if (this.i != null) {
      if (paramAMapLocation == null)
        return false; 
      if (ep.a(paramAMapLocation) && paramAMapLocation.getLocationType() != 2 && !paramAMapLocation.isMock()) {
        if (paramAMapLocation.isFixLastLocation())
          return false; 
        ea ea1 = new ea();
        ea1.a(paramAMapLocation);
        if (paramAMapLocation.getLocationType() == 1) {
          ea1.a((String)null);
        } else {
          ea1.a(paramString);
        } 
        try {
          b = ea1;
          g = ep.b();
          this.c = ea1;
          if (this.d != null && ep.a(this.d.a(), ea1.a()) <= 500.0F)
            return false; 
          long l1 = ep.b();
          long l2 = this.f;
        } finally {
          paramAMapLocation = null;
        } 
      } 
    } 
    return false;
  }
  
  public final AMapLocation b() {
    e();
    ea ea1 = b;
    return (ea1 == null) ? null : (!ep.a(ea1.a()) ? null : b.a());
  }
  
  public final void c() {
    try {
      d();
      this.f = 0L;
      this.h = false;
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "LastLocationManager", "destroy");
    } 
  }
  
  public final void d() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "LastLocationManager", "saveLastFix");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */