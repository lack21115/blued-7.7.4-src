package com.amap.api.mapcore2d;

import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import java.util.LinkedList;

final class aq implements View.OnKeyListener {
  private float a = 0.0F;
  
  private float b = 0.0F;
  
  private az c;
  
  private boolean d;
  
  private b e;
  
  private a f;
  
  aq(az paramaz) {
    this.c = paramaz;
    this.d = false;
    this.e = new b();
    this.f = new a();
  }
  
  private boolean a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
    return a(paramInt1, paramInt2, paramBoolean1, paramBoolean2, 1, 0);
  }
  
  private boolean a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, int paramInt4) {
    az az1 = this.c;
    boolean bool2 = false;
    boolean bool1 = false;
    if (az1 != null) {
      if (az1.c == null)
        return false; 
      this.c.c.g().r();
      az.c c = this.c.c;
      if (paramBoolean1) {
        f = c.e() + paramInt3;
      } else {
        f = c.e() - paramInt3;
      } 
      float f = this.c.c.g().a(f);
      if (f != this.c.c.e()) {
        a(paramInt1, paramInt2, f, paramBoolean1, paramBoolean2, paramInt4);
        bool1 = true;
      } 
      bool2 = bool1;
      try {
        if (this.c.g.c().isScaleControlsEnabled()) {
          this.c.g.s();
          return bool1;
        } 
      } catch (RemoteException remoteException) {
        cm.a((Throwable)remoteException, "MapController", "zoomWithAnimation");
        bool2 = bool1;
      } 
    } 
    return bool2;
  }
  
  private boolean b(w paramw) {
    if (paramw != null) {
      az az1 = this.c;
      if (az1 != null) {
        if (az1.c == null)
          return false; 
        w w1 = this.c.c.f();
        return (w1 == null) ? false : (!(paramw.b() == w1.b() && paramw.a() == w1.a()));
      } 
    } 
    return false;
  }
  
  private void c(w paramw) {
    az az1 = this.c;
    if (az1 != null && az1.g != null)
      this.c.g.r(); 
    az1 = this.c;
    if (az1 != null && az1.c != null)
      this.c.c.a(paramw); 
  }
  
  private float e(float paramFloat) {
    az az1 = this.c;
    float f = paramFloat;
    if (az1 != null) {
      if (az1.c == null)
        return paramFloat; 
      b b1 = this.c.c.g();
      b1.r();
      paramFloat = b1.a(paramFloat);
      this.c.c.a(paramFloat);
      f = paramFloat;
      try {
        if (this.c.g.c().isScaleControlsEnabled()) {
          this.c.g.s();
          return paramFloat;
        } 
      } catch (RemoteException remoteException) {
        cm.a((Throwable)remoteException, "MapController", "setZoom");
        f = paramFloat;
      } 
    } 
    return f;
  }
  
  private boolean f(float paramFloat) {
    az az1 = this.c;
    return (az1 != null) ? ((az1.c == null) ? false : (!(paramFloat == this.c.c.e()))) : false;
  }
  
  public float a() {
    return this.a;
  }
  
  public float a(float paramFloat, int paramInt) {
    float f = paramFloat;
    if (paramFloat >= q.c)
      f = q.c; 
    paramFloat = f;
    if (f <= q.d)
      paramFloat = q.d; 
    if (!f(paramFloat))
      return paramFloat; 
    b(paramFloat, paramInt);
    return paramFloat;
  }
  
  public Pair<Float, Boolean> a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: fload_1
    //   1: fconst_0
    //   2: fcmpg
    //   3: ifle -> 349
    //   6: fload_2
    //   7: fconst_0
    //   8: fcmpg
    //   9: ifgt -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: aload_0
    //   15: getfield c : Lcom/amap/api/mapcore2d/az;
    //   18: astore #16
    //   20: aload #16
    //   22: ifnull -> 349
    //   25: aload #16
    //   27: getfield c : Lcom/amap/api/mapcore2d/az$c;
    //   30: ifnull -> 349
    //   33: aload_0
    //   34: getfield c : Lcom/amap/api/mapcore2d/az;
    //   37: getfield b : Lcom/amap/api/mapcore2d/az$d;
    //   40: ifnonnull -> 45
    //   43: aconst_null
    //   44: areturn
    //   45: aload_0
    //   46: getfield c : Lcom/amap/api/mapcore2d/az;
    //   49: getfield c : Lcom/amap/api/mapcore2d/az$c;
    //   52: invokevirtual e : ()F
    //   55: pop
    //   56: aload_0
    //   57: getfield c : Lcom/amap/api/mapcore2d/az;
    //   60: getfield b : Lcom/amap/api/mapcore2d/az$d;
    //   63: iload_3
    //   64: iload #4
    //   66: iload #5
    //   68: invokevirtual b : (III)I
    //   71: istore #5
    //   73: aload_0
    //   74: getfield c : Lcom/amap/api/mapcore2d/az;
    //   77: getfield b : Lcom/amap/api/mapcore2d/az$d;
    //   80: iload_3
    //   81: iload #4
    //   83: iload #6
    //   85: invokevirtual a : (III)I
    //   88: istore_3
    //   89: iload #5
    //   91: ifne -> 110
    //   94: iload_3
    //   95: ifne -> 110
    //   98: aload_0
    //   99: fload_1
    //   100: putfield a : F
    //   103: aload_0
    //   104: fload_2
    //   105: putfield b : F
    //   108: aconst_null
    //   109: areturn
    //   110: iload_3
    //   111: i2f
    //   112: fload_1
    //   113: fdiv
    //   114: f2d
    //   115: dstore #7
    //   117: iload #5
    //   119: i2f
    //   120: fload_2
    //   121: fdiv
    //   122: f2d
    //   123: dstore #9
    //   125: dload #7
    //   127: dload #9
    //   129: invokestatic min : (DD)D
    //   132: dstore #11
    //   134: aload_0
    //   135: getfield c : Lcom/amap/api/mapcore2d/az;
    //   138: getfield h : Lcom/amap/api/mapcore2d/av;
    //   141: getfield k : D
    //   144: dload #11
    //   146: ddiv
    //   147: dstore #13
    //   149: aload_0
    //   150: getfield c : Lcom/amap/api/mapcore2d/az;
    //   153: getfield h : Lcom/amap/api/mapcore2d/av;
    //   156: getfield d : D
    //   159: dstore #7
    //   161: iconst_0
    //   162: istore #15
    //   164: iconst_0
    //   165: istore_3
    //   166: dload #7
    //   168: ldc2_w 2.0
    //   171: ddiv
    //   172: dstore #7
    //   174: dload #7
    //   176: dload #13
    //   178: dcmpl
    //   179: ifle -> 189
    //   182: iload_3
    //   183: iconst_1
    //   184: iadd
    //   185: istore_3
    //   186: goto -> 166
    //   189: aload_0
    //   190: getfield c : Lcom/amap/api/mapcore2d/az;
    //   193: getfield h : Lcom/amap/api/mapcore2d/av;
    //   196: getfield d : D
    //   199: iconst_1
    //   200: iload_3
    //   201: ishl
    //   202: i2d
    //   203: ddiv
    //   204: dload #13
    //   206: ddiv
    //   207: invokestatic log : (D)D
    //   210: ldc2_w 2.0
    //   213: invokestatic log : (D)D
    //   216: ddiv
    //   217: dstore #7
    //   219: aload_0
    //   220: iload_3
    //   221: i2d
    //   222: dload #7
    //   224: dadd
    //   225: d2f
    //   226: invokevirtual d : (F)F
    //   229: fstore_1
    //   230: fload_1
    //   231: f2i
    //   232: i2f
    //   233: fstore_2
    //   234: fload_1
    //   235: fload_2
    //   236: fsub
    //   237: f2d
    //   238: dstore #7
    //   240: dload #7
    //   242: dconst_1
    //   243: dconst_1
    //   244: getstatic com/amap/api/mapcore2d/az.a : D
    //   247: dsub
    //   248: ldc2_w 0.4
    //   251: dmul
    //   252: dsub
    //   253: dcmpl
    //   254: ifle -> 265
    //   257: getstatic com/amap/api/mapcore2d/az.a : D
    //   260: dstore #7
    //   262: goto -> 351
    //   265: dload #7
    //   267: getstatic com/amap/api/mapcore2d/az.a : D
    //   270: dcmpl
    //   271: ifle -> 282
    //   274: getstatic com/amap/api/mapcore2d/az.a : D
    //   277: dstore #7
    //   279: goto -> 360
    //   282: dload #7
    //   284: getstatic com/amap/api/mapcore2d/az.a : D
    //   287: dsub
    //   288: invokestatic abs : (D)D
    //   291: ldc2_w 9.999999747378752E-5
    //   294: dcmpg
    //   295: ifgt -> 306
    //   298: getstatic com/amap/api/mapcore2d/az.a : D
    //   301: dstore #7
    //   303: goto -> 360
    //   306: dload #11
    //   308: dload #9
    //   310: dcmpl
    //   311: ifne -> 317
    //   314: iconst_1
    //   315: istore #15
    //   317: new android/util/Pair
    //   320: dup
    //   321: fload_1
    //   322: invokestatic valueOf : (F)Ljava/lang/Float;
    //   325: iload #15
    //   327: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   330: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   333: astore #16
    //   335: aload #16
    //   337: areturn
    //   338: astore #16
    //   340: aload #16
    //   342: ldc 'MapController'
    //   344: ldc 'zoomToSpan'
    //   346: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   349: aconst_null
    //   350: areturn
    //   351: dload #7
    //   353: d2f
    //   354: fload_2
    //   355: fadd
    //   356: fstore_1
    //   357: goto -> 306
    //   360: dload #7
    //   362: ldc2_w 9.999999747378752E-5
    //   365: dsub
    //   366: dstore #7
    //   368: goto -> 351
    // Exception table:
    //   from	to	target	type
    //   45	89	338	java/lang/Exception
    //   98	108	338	java/lang/Exception
    //   110	161	338	java/lang/Exception
    //   166	174	338	java/lang/Exception
    //   189	230	338	java/lang/Exception
    //   240	262	338	java/lang/Exception
    //   265	279	338	java/lang/Exception
    //   282	303	338	java/lang/Exception
    //   317	335	338	java/lang/Exception
  }
  
  public void a(float paramFloat) {
    this.a = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    a(paramFloat1, paramFloat2, 0, 0, 0);
  }
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3) {
    // Byte code:
    //   0: fconst_0
    //   1: fstore #11
    //   3: fload_1
    //   4: fconst_0
    //   5: fcmpg
    //   6: ifle -> 387
    //   9: fload_2
    //   10: fconst_0
    //   11: fcmpg
    //   12: ifgt -> 16
    //   15: return
    //   16: aload_0
    //   17: getfield c : Lcom/amap/api/mapcore2d/az;
    //   20: astore #14
    //   22: aload #14
    //   24: ifnull -> 387
    //   27: aload #14
    //   29: getfield c : Lcom/amap/api/mapcore2d/az$c;
    //   32: ifnull -> 387
    //   35: aload_0
    //   36: getfield c : Lcom/amap/api/mapcore2d/az;
    //   39: getfield b : Lcom/amap/api/mapcore2d/az$d;
    //   42: ifnonnull -> 46
    //   45: return
    //   46: fload #11
    //   48: fstore #10
    //   50: aload_0
    //   51: getfield c : Lcom/amap/api/mapcore2d/az;
    //   54: getfield c : Lcom/amap/api/mapcore2d/az$c;
    //   57: invokevirtual e : ()F
    //   60: fstore #12
    //   62: fload #11
    //   64: fstore #10
    //   66: aload_0
    //   67: getfield c : Lcom/amap/api/mapcore2d/az;
    //   70: getfield b : Lcom/amap/api/mapcore2d/az$d;
    //   73: iload_3
    //   74: iload #4
    //   76: iload #5
    //   78: invokevirtual b : (III)I
    //   81: istore #13
    //   83: fload #11
    //   85: fstore #10
    //   87: aload_0
    //   88: getfield c : Lcom/amap/api/mapcore2d/az;
    //   91: getfield b : Lcom/amap/api/mapcore2d/az$d;
    //   94: iload_3
    //   95: iload #4
    //   97: iload #5
    //   99: invokevirtual a : (III)I
    //   102: istore_3
    //   103: iload #13
    //   105: ifne -> 131
    //   108: iload_3
    //   109: ifne -> 131
    //   112: fload #11
    //   114: fstore #10
    //   116: aload_0
    //   117: fload_1
    //   118: putfield a : F
    //   121: fload #11
    //   123: fstore #10
    //   125: aload_0
    //   126: fload_2
    //   127: putfield b : F
    //   130: return
    //   131: iload_3
    //   132: i2f
    //   133: fload_1
    //   134: fdiv
    //   135: f2d
    //   136: dstore #6
    //   138: iload #13
    //   140: i2f
    //   141: fload_2
    //   142: fdiv
    //   143: f2d
    //   144: dstore #8
    //   146: dload #6
    //   148: dload #8
    //   150: invokestatic min : (DD)D
    //   153: dstore #6
    //   155: aload_0
    //   156: getfield c : Lcom/amap/api/mapcore2d/az;
    //   159: getfield h : Lcom/amap/api/mapcore2d/av;
    //   162: getfield k : D
    //   165: dload #6
    //   167: ddiv
    //   168: dstore #8
    //   170: iconst_0
    //   171: istore_3
    //   172: aload_0
    //   173: getfield c : Lcom/amap/api/mapcore2d/az;
    //   176: getfield h : Lcom/amap/api/mapcore2d/av;
    //   179: getfield d : D
    //   182: dstore #6
    //   184: dload #6
    //   186: ldc2_w 2.0
    //   189: ddiv
    //   190: dstore #6
    //   192: dload #6
    //   194: dload #8
    //   196: dcmpl
    //   197: ifle -> 207
    //   200: iload_3
    //   201: iconst_1
    //   202: iadd
    //   203: istore_3
    //   204: goto -> 184
    //   207: aload_0
    //   208: getfield c : Lcom/amap/api/mapcore2d/az;
    //   211: getfield h : Lcom/amap/api/mapcore2d/av;
    //   214: getfield d : D
    //   217: iconst_1
    //   218: iload_3
    //   219: ishl
    //   220: i2d
    //   221: ddiv
    //   222: dload #8
    //   224: ddiv
    //   225: invokestatic log : (D)D
    //   228: dstore #6
    //   230: ldc2_w 2.0
    //   233: invokestatic log : (D)D
    //   236: dstore #8
    //   238: dload #6
    //   240: dload #8
    //   242: ddiv
    //   243: dstore #6
    //   245: iload_3
    //   246: i2d
    //   247: dload #6
    //   249: dadd
    //   250: d2f
    //   251: fstore_1
    //   252: fload_1
    //   253: fstore #10
    //   255: aload_0
    //   256: fload_1
    //   257: invokevirtual d : (F)F
    //   260: fstore_2
    //   261: fload_2
    //   262: f2i
    //   263: i2f
    //   264: fstore #11
    //   266: fload_2
    //   267: fload #11
    //   269: fsub
    //   270: f2d
    //   271: dstore #6
    //   273: fload_2
    //   274: fstore #10
    //   276: dload #6
    //   278: dconst_1
    //   279: dconst_1
    //   280: getstatic com/amap/api/mapcore2d/az.a : D
    //   283: dsub
    //   284: ldc2_w 0.4
    //   287: dmul
    //   288: dsub
    //   289: dcmpl
    //   290: ifle -> 304
    //   293: fload_2
    //   294: fstore #10
    //   296: getstatic com/amap/api/mapcore2d/az.a : D
    //   299: dstore #6
    //   301: goto -> 388
    //   304: fload_2
    //   305: fstore #10
    //   307: dload #6
    //   309: getstatic com/amap/api/mapcore2d/az.a : D
    //   312: dcmpl
    //   313: ifle -> 327
    //   316: fload_2
    //   317: fstore #10
    //   319: getstatic com/amap/api/mapcore2d/az.a : D
    //   322: dstore #6
    //   324: goto -> 398
    //   327: fload_2
    //   328: fstore #10
    //   330: fload_2
    //   331: fstore_1
    //   332: dload #6
    //   334: getstatic com/amap/api/mapcore2d/az.a : D
    //   337: dsub
    //   338: invokestatic abs : (D)D
    //   341: ldc2_w 9.999999747378752E-5
    //   344: dcmpg
    //   345: ifgt -> 381
    //   348: fload_2
    //   349: fstore #10
    //   351: getstatic com/amap/api/mapcore2d/az.a : D
    //   354: dstore #6
    //   356: goto -> 398
    //   359: astore #14
    //   361: fload #12
    //   363: fstore_1
    //   364: goto -> 372
    //   367: astore #14
    //   369: fload #10
    //   371: fstore_1
    //   372: aload #14
    //   374: ldc 'MapController'
    //   376: ldc 'zoomToSpan'
    //   378: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   381: aload_0
    //   382: fload_1
    //   383: invokevirtual c : (F)F
    //   386: pop
    //   387: return
    //   388: fload #11
    //   390: dload #6
    //   392: d2f
    //   393: fadd
    //   394: fstore_1
    //   395: goto -> 381
    //   398: dload #6
    //   400: ldc2_w 9.999999747378752E-5
    //   403: dsub
    //   404: dstore #6
    //   406: goto -> 388
    // Exception table:
    //   from	to	target	type
    //   50	62	367	java/lang/Exception
    //   66	83	367	java/lang/Exception
    //   87	103	367	java/lang/Exception
    //   116	121	367	java/lang/Exception
    //   125	130	367	java/lang/Exception
    //   146	170	359	java/lang/Exception
    //   172	184	359	java/lang/Exception
    //   184	192	359	java/lang/Exception
    //   207	238	359	java/lang/Exception
    //   255	261	367	java/lang/Exception
    //   276	293	367	java/lang/Exception
    //   296	301	367	java/lang/Exception
    //   307	316	367	java/lang/Exception
    //   319	324	367	java/lang/Exception
    //   332	348	367	java/lang/Exception
    //   351	356	367	java/lang/Exception
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean1, boolean paramBoolean2, int paramInt3) {
    this.e.a(paramInt1, paramInt2, paramFloat, paramBoolean1, paramBoolean2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    if (this.d) {
      this.d = false;
      return;
    } 
    if (paramInt1 == 0 && paramInt2 == 0)
      return; 
    if (this.c == null)
      return; 
    try {
      return;
    } finally {
      Exception exception = null;
      cm.a(exception, "MapController", "scrollBy");
    } 
  }
  
  public void a(w paramw) {
    if (b(paramw))
      c(paramw); 
  }
  
  public void a(w paramw, float paramFloat) {
    if (!b(paramw) && !f(paramFloat))
      return; 
    c(paramw);
    e(paramFloat);
  }
  
  public void a(w paramw, int paramInt) {
    this.f.a(paramw, null, null, paramInt);
  }
  
  public void a(boolean paramBoolean) {
    this.c.c.g().r();
    if (paramBoolean) {
      f = this.c.c.e() + true;
    } else {
      f = this.c.c.e() - true;
    } 
    float f = this.c.c.g().a(f);
    if (f != this.c.c.e())
      c(f); 
  }
  
  public boolean a(float paramFloat, int paramInt1, int paramInt2, int paramInt3) {
    return a(paramInt1, paramInt2, paramFloat, paramInt3);
  }
  
  public boolean a(int paramInt) {
    return a(1, paramInt);
  }
  
  boolean a(int paramInt1, int paramInt2) {
    az az1 = this.c;
    return (az1 == null || az1.c == null) ? false : a(this.c.c.c() / 2, this.c.c.d() / 2, true, false, paramInt1, paramInt2);
  }
  
  public boolean a(int paramInt1, int paramInt2, float paramFloat, int paramInt3) {
    az az1 = this.c;
    boolean bool2 = false;
    boolean bool1 = false;
    if (az1 != null) {
      if (az1.c == null)
        return false; 
      this.c.c.g().r();
      float f = this.c.c.e();
      if (paramFloat != f) {
        this.e.a(paramInt1, paramInt2, paramFloat, f, paramInt3);
        bool1 = true;
      } 
      bool2 = bool1;
      try {
        if (this.c.g.c().isScaleControlsEnabled()) {
          this.c.g.s();
          return bool1;
        } 
      } catch (RemoteException remoteException) {
        cm.a((Throwable)remoteException, "MapController", "zoomToAnimation");
        bool2 = bool1;
      } 
    } 
    return bool2;
  }
  
  public float b() {
    return this.b;
  }
  
  public void b(float paramFloat) {
    this.b = paramFloat;
  }
  
  public void b(boolean paramBoolean) {
    this.e.a();
    this.f.b();
  }
  
  public boolean b(float paramFloat, int paramInt) {
    return a(this.c.c.c() / 2, this.c.c.d() / 2, paramFloat, paramInt);
  }
  
  public boolean b(int paramInt) {
    return b(1, paramInt);
  }
  
  boolean b(int paramInt1, int paramInt2) {
    az az1 = this.c;
    return (az1 == null || az1.c == null) ? false : a(this.c.c.c() / 2, this.c.c.d() / 2, false, false, paramInt1, paramInt2);
  }
  
  public float c(float paramFloat) {
    if (!f(paramFloat))
      return paramFloat; 
    e(paramFloat);
    return paramFloat;
  }
  
  public boolean c() {
    return a(0);
  }
  
  public boolean c(int paramInt1, int paramInt2) {
    return a(paramInt1, paramInt2, true, true);
  }
  
  public float d(float paramFloat) {
    az az1 = this.c;
    float f = paramFloat;
    if (az1 != null) {
      if (az1.c == null)
        return paramFloat; 
      float f1 = paramFloat;
      if (paramFloat < this.c.c.b())
        f1 = this.c.c.b(); 
      f = f1;
      if (f1 > this.c.c.a())
        f = this.c.c.a(); 
    } 
    return f;
  }
  
  public void d(int paramInt1, int paramInt2) {
    if (this.d) {
      this.d = false;
      return;
    } 
    if (paramInt1 == 0 && paramInt2 == 0)
      return; 
    if (this.c == null)
      return; 
    try {
      return;
    } finally {
      Exception exception = null;
      cm.a(exception, "MapController", "scrollBy");
    } 
  }
  
  public boolean d() {
    return b(0);
  }
  
  public void e() {
    this.d = true;
  }
  
  public boolean f() {
    return this.f.a();
  }
  
  public void g() {
    this.f.b();
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() != 0)
      return false; 
    switch (paramInt) {
      default:
        return false;
      case 22:
        d(10, 0);
        return true;
      case 21:
        d(-10, 0);
        return true;
      case 20:
        d(0, 10);
        return true;
      case 19:
        break;
    } 
    d(0, -10);
    return true;
  }
  
  class a implements bz {
    private by b = null;
    
    private Message c = null;
    
    private Runnable d = null;
    
    private a(aq this$0) {}
    
    private by a(w param1w, int param1Int) {
      if (param1Int < 500)
        param1Int = 500; 
      try {
        return new by(param1Int, 10, (aq.a(this.a)).h.l, param1w, param1Int, this);
      } finally {
        param1w = null;
        cm.a((Throwable)param1w, "MapController", "makeTransTool");
      } 
    }
    
    private void d() {
      this.b = null;
      this.c = null;
      this.d = null;
    }
    
    public void a(w param1w) {
      if (param1w != null) {
        if (aq.a(this.a) == null)
          return; 
        if (param1w.d() == Long.MIN_VALUE || param1w.c() == Long.MIN_VALUE) {
          param1w = (aq.a(this.a)).h.b(param1w);
          this.a.a(param1w);
          return;
        } 
        this.a.a(param1w);
        return;
      } 
    }
    
    public void a(w param1w, Message param1Message, Runnable param1Runnable, int param1Int) {
      if (aq.a(this.a) != null) {
        (aq.a(this.a)).d.a = true;
        (aq.a(this.a)).h.m = param1w.g();
      } 
      this.b = a(param1w, param1Int);
      this.c = param1Message;
      this.d = param1Runnable;
      by by1 = this.b;
      if (by1 != null)
        by1.d(); 
    }
    
    public boolean a() {
      by by1 = this.b;
      return (by1 != null) ? by1.f() : false;
    }
    
    public void b() {
      by by1 = this.b;
      if (by1 != null)
        by1.e(); 
    }
    
    public void c() {
      Message message = this.c;
      if (message != null)
        message.getTarget().sendMessage(this.c); 
      Runnable runnable = this.d;
      if (runnable != null)
        runnable.run(); 
      d();
      if (aq.a(this.a) != null && (aq.a(this.a)).d != null)
        (aq.a(this.a)).d.a = false; 
    }
  }
  
  class b implements Animation.AnimationListener {
    private LinkedList<Animation> b = new LinkedList<Animation>();
    
    private cf c = null;
    
    private b(aq this$0) {}
    
    private void a(float param1Float, int param1Int1, int param1Int2, boolean param1Boolean, int param1Int3) {
      try {
        if (this.c == null && aq.a(this.a) != null && (aq.a(this.a)).c != null) {
          this.c = new cf((aq.a(this.a)).c.g(), this, param1Int3);
        } else {
          cf cf1 = this.c;
          int i = param1Int3;
          if (param1Int3 <= 160)
            i = 160; 
          cf1.a(i);
        } 
      } finally {
        Exception exception = null;
      } 
    }
    
    private void b(float param1Float, int param1Int1, int param1Int2, boolean param1Boolean, int param1Int3) {
      try {
        if (this.c == null) {
          this.c = new cf((aq.a(this.a)).c.g(), this, param1Int3);
        } else {
          cf cf1 = this.c;
          int i = param1Int3;
          if (param1Int3 <= 160)
            i = 160; 
          cf1.a(i);
        } 
        this.c.c = param1Float;
        this.c.d = param1Boolean;
        return;
      } finally {
        Exception exception = null;
        cm.a(exception, "MapController", "doZoomIn");
      } 
    }
    
    public void a() {
      this.b.clear();
    }
    
    public void a(int param1Int1, int param1Int2, float param1Float1, float param1Float2, int param1Int3) {
      try {
        if (this.c == null) {
          this.c = new cf((aq.a(this.a)).c.g(), this, param1Int3);
        } else {
          cf cf1 = this.c;
          int i = param1Int3;
          if (param1Int3 <= 160)
            i = 160; 
          cf1.a(i);
        } 
        this.c.c = param1Float1;
        return;
      } finally {
        Exception exception = null;
        cm.a(exception, "MapController", "zoomTo");
      } 
    }
    
    public void a(int param1Int1, int param1Int2, float param1Float, boolean param1Boolean1, boolean param1Boolean2, int param1Int3) {
      if (!param1Boolean1) {
        a(param1Float, param1Int1, param1Int2, param1Boolean2, param1Int3);
        return;
      } 
      b(param1Float, param1Int1, param1Int2, param1Boolean2, param1Int3);
    }
    
    public void onAnimationEnd(Animation param1Animation) {
      if (aq.a(this.a) == null)
        return; 
      if (this.b.size() == 0) {
        (aq.a(this.a)).e.b();
        return;
      } 
      (aq.a(this.a)).c.g().startAnimation(this.b.remove());
    }
    
    public void onAnimationRepeat(Animation param1Animation) {}
    
    public void onAnimationStart(Animation param1Animation) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */