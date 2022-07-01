package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;

class cd extends View {
  private Bitmap a;
  
  private Bitmap b;
  
  private Bitmap c;
  
  private Bitmap d;
  
  private Paint e;
  
  private boolean f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private boolean p;
  
  private float q;
  
  private float r;
  
  private boolean s;
  
  public cd(Context paramContext, y paramy) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial <init> : (Landroid/content/Context;)V
    //   5: aload_0
    //   6: new android/graphics/Paint
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: putfield e : Landroid/graphics/Paint;
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield f : Z
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield g : I
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield h : I
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield i : I
    //   36: aload_0
    //   37: bipush #10
    //   39: putfield j : I
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield k : I
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield l : I
    //   52: aload_0
    //   53: bipush #10
    //   55: putfield m : I
    //   58: aload_0
    //   59: bipush #8
    //   61: putfield n : I
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield o : I
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield p : Z
    //   74: aload_0
    //   75: fconst_0
    //   76: putfield q : F
    //   79: aload_0
    //   80: fconst_0
    //   81: putfield r : F
    //   84: aload_0
    //   85: iconst_1
    //   86: putfield s : Z
    //   89: aload_1
    //   90: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   93: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   96: astore #4
    //   98: aconst_null
    //   99: astore_1
    //   100: aconst_null
    //   101: astore_3
    //   102: aload #4
    //   104: ldc 'ap2d.data'
    //   106: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   109: astore_2
    //   110: aload_3
    //   111: astore_1
    //   112: aload_0
    //   113: aload_2
    //   114: invokestatic decodeStream : (Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   117: putfield c : Landroid/graphics/Bitmap;
    //   120: aload_3
    //   121: astore_1
    //   122: aload_0
    //   123: aload_0
    //   124: getfield c : Landroid/graphics/Bitmap;
    //   127: getstatic com/amap/api/mapcore2d/q.a : F
    //   130: invokestatic a : (Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   133: putfield a : Landroid/graphics/Bitmap;
    //   136: aload_3
    //   137: astore_1
    //   138: aload_2
    //   139: invokevirtual close : ()V
    //   142: aload_3
    //   143: astore_1
    //   144: aload #4
    //   146: ldc 'ap12d.data'
    //   148: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   151: astore_3
    //   152: aload_3
    //   153: astore_1
    //   154: aload_0
    //   155: aload_3
    //   156: invokestatic decodeStream : (Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   159: putfield d : Landroid/graphics/Bitmap;
    //   162: aload_3
    //   163: astore_1
    //   164: aload_0
    //   165: aload_0
    //   166: getfield d : Landroid/graphics/Bitmap;
    //   169: getstatic com/amap/api/mapcore2d/q.a : F
    //   172: invokestatic a : (Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   175: putfield b : Landroid/graphics/Bitmap;
    //   178: aload_3
    //   179: astore_1
    //   180: aload_3
    //   181: invokevirtual close : ()V
    //   184: aload_3
    //   185: astore_1
    //   186: aload_0
    //   187: aload_0
    //   188: getfield b : Landroid/graphics/Bitmap;
    //   191: invokevirtual getWidth : ()I
    //   194: putfield h : I
    //   197: aload_3
    //   198: astore_1
    //   199: aload_0
    //   200: aload_0
    //   201: getfield b : Landroid/graphics/Bitmap;
    //   204: invokevirtual getHeight : ()I
    //   207: putfield g : I
    //   210: aload_3
    //   211: astore_1
    //   212: aload_0
    //   213: getfield e : Landroid/graphics/Paint;
    //   216: iconst_1
    //   217: invokevirtual setAntiAlias : (Z)V
    //   220: aload_3
    //   221: astore_1
    //   222: aload_0
    //   223: getfield e : Landroid/graphics/Paint;
    //   226: ldc -16777216
    //   228: invokevirtual setColor : (I)V
    //   231: aload_3
    //   232: astore_1
    //   233: aload_0
    //   234: getfield e : Landroid/graphics/Paint;
    //   237: getstatic android/graphics/Paint$Style.STROKE : Landroid/graphics/Paint$Style;
    //   240: invokevirtual setStyle : (Landroid/graphics/Paint$Style;)V
    //   243: aload_2
    //   244: ifnull -> 259
    //   247: aload_2
    //   248: invokevirtual close : ()V
    //   251: goto -> 259
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual printStackTrace : ()V
    //   259: aload_3
    //   260: ifnull -> 317
    //   263: aload_3
    //   264: invokevirtual close : ()V
    //   267: return
    //   268: astore_3
    //   269: goto -> 275
    //   272: astore_3
    //   273: aconst_null
    //   274: astore_2
    //   275: aload_3
    //   276: ldc 'WaterMarkerView'
    //   278: ldc 'create'
    //   280: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload_3
    //   284: invokevirtual printStackTrace : ()V
    //   287: aload_2
    //   288: ifnull -> 303
    //   291: aload_2
    //   292: invokevirtual close : ()V
    //   295: goto -> 303
    //   298: astore_2
    //   299: aload_2
    //   300: invokevirtual printStackTrace : ()V
    //   303: aload_1
    //   304: ifnull -> 317
    //   307: aload_1
    //   308: invokevirtual close : ()V
    //   311: return
    //   312: astore_1
    //   313: aload_1
    //   314: invokevirtual printStackTrace : ()V
    //   317: return
    //   318: astore_3
    //   319: aload_2
    //   320: ifnull -> 335
    //   323: aload_2
    //   324: invokevirtual close : ()V
    //   327: goto -> 335
    //   330: astore_2
    //   331: aload_2
    //   332: invokevirtual printStackTrace : ()V
    //   335: aload_1
    //   336: ifnull -> 351
    //   339: aload_1
    //   340: invokevirtual close : ()V
    //   343: goto -> 351
    //   346: astore_1
    //   347: aload_1
    //   348: invokevirtual printStackTrace : ()V
    //   351: aload_3
    //   352: athrow
    // Exception table:
    //   from	to	target	type
    //   102	110	272	finally
    //   112	120	268	finally
    //   122	136	268	finally
    //   138	142	268	finally
    //   144	152	268	finally
    //   154	162	268	finally
    //   164	178	268	finally
    //   180	184	268	finally
    //   186	197	268	finally
    //   199	210	268	finally
    //   212	220	268	finally
    //   222	231	268	finally
    //   233	243	268	finally
    //   247	251	254	finally
    //   263	267	312	finally
    //   275	287	318	finally
    //   291	295	298	finally
    //   307	311	312	finally
    //   323	327	330	finally
    //   339	343	346	finally
  }
  
  private void f() {
    int i = this.l;
    if (i != 0) {
      if (i != 1 && i == 2)
        g(); 
    } else {
      h();
    } 
    this.j = this.m;
    this.k = getHeight() - this.n - this.g;
    if (this.j < 0)
      this.j = 0; 
    if (this.k < 0)
      this.k = 0; 
  }
  
  private void g() {
    if (this.s) {
      this.m = (int)(getWidth() * this.q);
    } else {
      this.m = (int)(getWidth() * this.q - this.h);
    } 
    this.n = (int)(getHeight() * this.r);
  }
  
  private void h() {
    int i = this.i;
    if (i == 1) {
      this.m = (getWidth() - this.h) / 2;
    } else if (i == 2) {
      this.m = getWidth() - this.h - 10;
    } else {
      this.m = 10;
    } 
    this.n = 8;
  }
  
  public int a() {
    return this.i;
  }
  
  public void a(int paramInt) {
    this.l = 0;
    this.i = paramInt;
    e();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int j = this.h / 2;
    int k = this.g / 2;
    int i = paramInt3 - j;
    paramInt3 = paramInt1;
    if (paramInt1 > i)
      paramInt3 = i; 
    i = paramInt3;
    if (paramInt3 < j)
      i = j; 
    paramInt1 = paramInt2;
    if (paramInt2 < k)
      paramInt1 = k; 
    paramInt3 = paramInt4 - k;
    paramInt2 = paramInt1;
    if (paramInt1 > paramInt3)
      paramInt2 = paramInt3; 
    c(i - j);
    b(paramInt4 - paramInt2 - k);
  }
  
  public void a(boolean paramBoolean) {
    try {
      return;
    } finally {
      Exception exception = null;
      do.c(exception, "WaterMarkerView", "changeBitmap");
      exception.printStackTrace();
    } 
  }
  
  public void b() {
    try {
      if (this.a != null)
        this.a.recycle(); 
      if (this.b != null)
        this.b.recycle(); 
      this.a = null;
      this.b = null;
      return;
    } finally {
      Exception exception = null;
      do.c(exception, "WaterMarkerView", "destory");
      exception.printStackTrace();
    } 
  }
  
  public void b(int paramInt) {
    this.l = 1;
    this.n = paramInt;
    e();
  }
  
  public Bitmap c() {
    return this.f ? this.b : this.a;
  }
  
  public void c(int paramInt) {
    this.l = 1;
    this.m = paramInt;
    e();
  }
  
  public Point d() {
    return new Point(this.j, this.k - 2);
  }
  
  public void e() {
    if (getWidth() != 0) {
      if (getHeight() == 0)
        return; 
      f();
      postInvalidate();
    } 
  }
  
  public void onDraw(Canvas paramCanvas) {
    try {
      return;
    } finally {
      paramCanvas = null;
      do.c((Throwable)paramCanvas, "WaterMarkerView", "onDraw");
      paramCanvas.printStackTrace();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */