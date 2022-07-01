package com.loc;

import com.amap.api.location.AMapLocation;

public final class dr {
  ds a = null;
  
  long b = 0L;
  
  long c = 0L;
  
  int d = 0;
  
  long e = 0L;
  
  AMapLocation f = null;
  
  long g = 0L;
  
  private boolean h = true;
  
  private ds b(ds paramds) {
    if (ep.a(paramds)) {
      int i;
      if (this.h && ei.a(paramds.getTime())) {
        if (paramds.getLocationType() == 5 || paramds.getLocationType() == 6) {
          i = 4;
        } else {
          return paramds;
        } 
      } else {
        i = this.d;
      } 
      paramds.setLocationType(i);
    } 
    return paramds;
  }
  
  public final AMapLocation a(AMapLocation paramAMapLocation) {
    if (!ep.a(paramAMapLocation))
      return paramAMapLocation; 
    long l1 = ep.b();
    long l2 = this.g;
    this.g = ep.b();
    if (l1 - l2 > 5000L)
      return paramAMapLocation; 
    AMapLocation aMapLocation = this.f;
    if (aMapLocation == null) {
      this.f = paramAMapLocation;
      return paramAMapLocation;
    } 
    if (1 != aMapLocation.getLocationType() && !"gps".equalsIgnoreCase(this.f.getProvider())) {
      this.f = paramAMapLocation;
      return paramAMapLocation;
    } 
    if (this.f.getAltitude() == paramAMapLocation.getAltitude() && this.f.getLongitude() == paramAMapLocation.getLongitude()) {
      this.f = paramAMapLocation;
      return paramAMapLocation;
    } 
    l1 = Math.abs(paramAMapLocation.getTime() - this.f.getTime());
    if (30000L < l1) {
      this.f = paramAMapLocation;
      return paramAMapLocation;
    } 
    float f = (this.f.getSpeed() + paramAMapLocation.getSpeed()) * (float)l1 / 2000.0F;
    if (ep.a(paramAMapLocation, this.f) > f + (this.f.getAccuracy() + paramAMapLocation.getAccuracy()) * 2.0F + 3000.0F)
      return this.f; 
    this.f = paramAMapLocation;
    return paramAMapLocation;
  }
  
  public final ds a(ds paramds) {
    // Byte code:
    //   0: aload_1
    //   1: astore #14
    //   3: invokestatic b : ()J
    //   6: aload_0
    //   7: getfield e : J
    //   10: lsub
    //   11: ldc2_w 30000
    //   14: lcmp
    //   15: ifle -> 36
    //   18: aload_0
    //   19: aload #14
    //   21: putfield a : Lcom/loc/ds;
    //   24: aload_0
    //   25: invokestatic b : ()J
    //   28: putfield e : J
    //   31: aload_0
    //   32: getfield a : Lcom/loc/ds;
    //   35: areturn
    //   36: aload_0
    //   37: invokestatic b : ()J
    //   40: putfield e : J
    //   43: aload_0
    //   44: getfield a : Lcom/loc/ds;
    //   47: invokestatic a : (Lcom/loc/ds;)Z
    //   50: ifeq -> 103
    //   53: aload_1
    //   54: invokestatic a : (Lcom/loc/ds;)Z
    //   57: ifne -> 63
    //   60: goto -> 103
    //   63: aload_1
    //   64: invokevirtual getTime : ()J
    //   67: aload_0
    //   68: getfield a : Lcom/loc/ds;
    //   71: invokevirtual getTime : ()J
    //   74: lcmp
    //   75: ifne -> 91
    //   78: aload_1
    //   79: invokevirtual getAccuracy : ()F
    //   82: ldc 300.0
    //   84: fcmpg
    //   85: ifge -> 91
    //   88: aload #14
    //   90: areturn
    //   91: aload_1
    //   92: invokevirtual getProvider : ()Ljava/lang/String;
    //   95: ldc 'gps'
    //   97: invokevirtual equals : (Ljava/lang/Object;)Z
    //   100: ifeq -> 119
    //   103: aload_0
    //   104: invokestatic b : ()J
    //   107: putfield b : J
    //   110: aload_0
    //   111: aload #14
    //   113: putfield a : Lcom/loc/ds;
    //   116: goto -> 31
    //   119: aload_1
    //   120: invokevirtual c : ()I
    //   123: aload_0
    //   124: getfield a : Lcom/loc/ds;
    //   127: invokevirtual c : ()I
    //   130: if_icmpeq -> 136
    //   133: goto -> 103
    //   136: aload_1
    //   137: invokevirtual getBuildingId : ()Ljava/lang/String;
    //   140: aload_0
    //   141: getfield a : Lcom/loc/ds;
    //   144: invokevirtual getBuildingId : ()Ljava/lang/String;
    //   147: invokevirtual equals : (Ljava/lang/Object;)Z
    //   150: ifne -> 166
    //   153: aload_1
    //   154: invokevirtual getBuildingId : ()Ljava/lang/String;
    //   157: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   160: ifne -> 166
    //   163: goto -> 103
    //   166: aload_0
    //   167: aload_1
    //   168: invokevirtual getLocationType : ()I
    //   171: putfield d : I
    //   174: aload #14
    //   176: aload_0
    //   177: getfield a : Lcom/loc/ds;
    //   180: invokestatic a : (Lcom/amap/api/location/AMapLocation;Lcom/amap/api/location/AMapLocation;)F
    //   183: fstore_2
    //   184: aload_0
    //   185: getfield a : Lcom/loc/ds;
    //   188: invokevirtual getAccuracy : ()F
    //   191: fstore_3
    //   192: aload_1
    //   193: invokevirtual getAccuracy : ()F
    //   196: fstore #4
    //   198: fload #4
    //   200: fload_3
    //   201: fsub
    //   202: fstore #5
    //   204: invokestatic b : ()J
    //   207: lstore #10
    //   209: aload_0
    //   210: getfield b : J
    //   213: lstore #12
    //   215: iconst_0
    //   216: istore #8
    //   218: fload_3
    //   219: ldc 100.0
    //   221: fcmpg
    //   222: ifgt -> 239
    //   225: fload #4
    //   227: ldc 299.0
    //   229: fcmpl
    //   230: ifle -> 239
    //   233: iconst_1
    //   234: istore #6
    //   236: goto -> 242
    //   239: iconst_0
    //   240: istore #6
    //   242: fload_3
    //   243: ldc 299.0
    //   245: fcmpl
    //   246: istore #9
    //   248: iload #8
    //   250: istore #7
    //   252: iload #9
    //   254: ifle -> 272
    //   257: iload #8
    //   259: istore #7
    //   261: fload #4
    //   263: ldc 299.0
    //   265: fcmpl
    //   266: ifle -> 272
    //   269: iconst_1
    //   270: istore #7
    //   272: iload #6
    //   274: ifne -> 417
    //   277: iload #7
    //   279: ifeq -> 285
    //   282: goto -> 417
    //   285: fload #4
    //   287: ldc 100.0
    //   289: fcmpg
    //   290: ifge -> 318
    //   293: iload #9
    //   295: ifle -> 318
    //   298: aload_0
    //   299: lload #10
    //   301: putfield b : J
    //   304: aload_0
    //   305: aload #14
    //   307: putfield a : Lcom/loc/ds;
    //   310: aload_0
    //   311: lconst_0
    //   312: putfield c : J
    //   315: goto -> 31
    //   318: fload #4
    //   320: ldc 299.0
    //   322: fcmpg
    //   323: ifgt -> 331
    //   326: aload_0
    //   327: lconst_0
    //   328: putfield c : J
    //   331: fload_2
    //   332: ldc 10.0
    //   334: fcmpg
    //   335: ifge -> 394
    //   338: fload_2
    //   339: f2d
    //   340: ldc2_w 0.1
    //   343: dcmpl
    //   344: ifle -> 394
    //   347: fload #4
    //   349: ldc 5.0
    //   351: fcmpl
    //   352: ifle -> 394
    //   355: fload #5
    //   357: ldc -300.0
    //   359: fcmpl
    //   360: iflt -> 376
    //   363: aload_0
    //   364: aload_0
    //   365: getfield a : Lcom/loc/ds;
    //   368: invokespecial b : (Lcom/loc/ds;)Lcom/loc/ds;
    //   371: astore #14
    //   373: goto -> 110
    //   376: fload_3
    //   377: fload #4
    //   379: fdiv
    //   380: fconst_2
    //   381: fcmpl
    //   382: iflt -> 363
    //   385: aload_0
    //   386: lload #10
    //   388: putfield b : J
    //   391: goto -> 110
    //   394: fload #5
    //   396: ldc 300.0
    //   398: fcmpl
    //   399: iflt -> 103
    //   402: lload #10
    //   404: lload #12
    //   406: lsub
    //   407: ldc2_w 30000
    //   410: lcmp
    //   411: iflt -> 363
    //   414: goto -> 103
    //   417: aload_0
    //   418: getfield c : J
    //   421: lstore #12
    //   423: lload #12
    //   425: lconst_0
    //   426: lcmp
    //   427: ifne -> 439
    //   430: aload_0
    //   431: lload #10
    //   433: putfield c : J
    //   436: goto -> 363
    //   439: lload #10
    //   441: lload #12
    //   443: lsub
    //   444: ldc2_w 30000
    //   447: lcmp
    //   448: ifle -> 363
    //   451: goto -> 298
  }
  
  public final void a() {
    this.a = null;
    this.b = 0L;
    this.c = 0L;
    this.f = null;
    this.g = 0L;
  }
  
  public final void a(boolean paramBoolean) {
    this.h = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */